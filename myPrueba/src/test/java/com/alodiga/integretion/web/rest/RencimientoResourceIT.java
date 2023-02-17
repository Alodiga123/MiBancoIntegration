package com.alodiga.integretion.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import com.alodiga.integretion.IntegrationTest;
import com.alodiga.integretion.domain.Rencimiento;
import com.alodiga.integretion.repository.EntityManager;
import com.alodiga.integretion.repository.RencimientoRepository;
import com.alodiga.integretion.service.dto.RencimientoDTO;
import com.alodiga.integretion.service.mapper.RencimientoMapper;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Integration tests for the {@link RencimientoResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class RencimientoResourceIT {

    private static final Integer DEFAULT_CEDULA_BENEFICIARIO = 1;
    private static final Integer UPDATED_CEDULA_BENEFICIARIO = 2;

    private static final String DEFAULT_TELEFONO_EMISOR = "AAAAAAAAAA";
    private static final String UPDATED_TELEFONO_EMISOR = "BBBBBBBBBB";

    private static final String DEFAULT_FECHA_HORA = "AAAAAAAAAA";
    private static final String UPDATED_FECHA_HORA = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/rencimientos";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private RencimientoRepository rencimientoRepository;

    @Autowired
    private RencimientoMapper rencimientoMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private Rencimiento rencimiento;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Rencimiento createEntity(EntityManager em) {
        Rencimiento rencimiento = new Rencimiento()
            .cedulaBeneficiario(DEFAULT_CEDULA_BENEFICIARIO)
            .telefonoEmisor(DEFAULT_TELEFONO_EMISOR)
            .fechaHora(DEFAULT_FECHA_HORA);
        return rencimiento;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Rencimiento createUpdatedEntity(EntityManager em) {
        Rencimiento rencimiento = new Rencimiento()
            .cedulaBeneficiario(UPDATED_CEDULA_BENEFICIARIO)
            .telefonoEmisor(UPDATED_TELEFONO_EMISOR)
            .fechaHora(UPDATED_FECHA_HORA);
        return rencimiento;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(Rencimiento.class).block();
        } catch (Exception e) {
            // It can fail, if other entities are still referring this - it will be removed later.
        }
    }

    @AfterEach
    public void cleanup() {
        deleteEntities(em);
    }

    @BeforeEach
    public void initTest() {
        deleteEntities(em);
        rencimiento = createEntity(em);
    }

    @Test
    void createRencimiento() throws Exception {
        int databaseSizeBeforeCreate = rencimientoRepository.findAll().collectList().block().size();
        // Create the Rencimiento
        RencimientoDTO rencimientoDTO = rencimientoMapper.toDto(rencimiento);
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rencimientoDTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the Rencimiento in the database
        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeCreate + 1);
        Rencimiento testRencimiento = rencimientoList.get(rencimientoList.size() - 1);
        assertThat(testRencimiento.getCedulaBeneficiario()).isEqualTo(DEFAULT_CEDULA_BENEFICIARIO);
        assertThat(testRencimiento.getTelefonoEmisor()).isEqualTo(DEFAULT_TELEFONO_EMISOR);
        assertThat(testRencimiento.getFechaHora()).isEqualTo(DEFAULT_FECHA_HORA);
    }

    @Test
    void createRencimientoWithExistingId() throws Exception {
        // Create the Rencimiento with an existing ID
        rencimiento.setId(1L);
        RencimientoDTO rencimientoDTO = rencimientoMapper.toDto(rencimiento);

        int databaseSizeBeforeCreate = rencimientoRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rencimientoDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Rencimiento in the database
        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkTelefonoEmisorIsRequired() throws Exception {
        int databaseSizeBeforeTest = rencimientoRepository.findAll().collectList().block().size();
        // set the field null
        rencimiento.setTelefonoEmisor(null);

        // Create the Rencimiento, which fails.
        RencimientoDTO rencimientoDTO = rencimientoMapper.toDto(rencimiento);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rencimientoDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkFechaHoraIsRequired() throws Exception {
        int databaseSizeBeforeTest = rencimientoRepository.findAll().collectList().block().size();
        // set the field null
        rencimiento.setFechaHora(null);

        // Create the Rencimiento, which fails.
        RencimientoDTO rencimientoDTO = rencimientoMapper.toDto(rencimiento);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rencimientoDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllRencimientos() {
        // Initialize the database
        rencimientoRepository.save(rencimiento).block();

        // Get all the rencimientoList
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=id,desc")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].id")
            .value(hasItem(rencimiento.getId().intValue()))
            .jsonPath("$.[*].cedulaBeneficiario")
            .value(hasItem(DEFAULT_CEDULA_BENEFICIARIO))
            .jsonPath("$.[*].telefonoEmisor")
            .value(hasItem(DEFAULT_TELEFONO_EMISOR))
            .jsonPath("$.[*].fechaHora")
            .value(hasItem(DEFAULT_FECHA_HORA));
    }

    @Test
    void getRencimiento() {
        // Initialize the database
        rencimientoRepository.save(rencimiento).block();

        // Get the rencimiento
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, rencimiento.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(rencimiento.getId().intValue()))
            .jsonPath("$.cedulaBeneficiario")
            .value(is(DEFAULT_CEDULA_BENEFICIARIO))
            .jsonPath("$.telefonoEmisor")
            .value(is(DEFAULT_TELEFONO_EMISOR))
            .jsonPath("$.fechaHora")
            .value(is(DEFAULT_FECHA_HORA));
    }

    @Test
    void getNonExistingRencimiento() {
        // Get the rencimiento
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putExistingRencimiento() throws Exception {
        // Initialize the database
        rencimientoRepository.save(rencimiento).block();

        int databaseSizeBeforeUpdate = rencimientoRepository.findAll().collectList().block().size();

        // Update the rencimiento
        Rencimiento updatedRencimiento = rencimientoRepository.findById(rencimiento.getId()).block();
        updatedRencimiento
            .cedulaBeneficiario(UPDATED_CEDULA_BENEFICIARIO)
            .telefonoEmisor(UPDATED_TELEFONO_EMISOR)
            .fechaHora(UPDATED_FECHA_HORA);
        RencimientoDTO rencimientoDTO = rencimientoMapper.toDto(updatedRencimiento);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, rencimientoDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rencimientoDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Rencimiento in the database
        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeUpdate);
        Rencimiento testRencimiento = rencimientoList.get(rencimientoList.size() - 1);
        assertThat(testRencimiento.getCedulaBeneficiario()).isEqualTo(UPDATED_CEDULA_BENEFICIARIO);
        assertThat(testRencimiento.getTelefonoEmisor()).isEqualTo(UPDATED_TELEFONO_EMISOR);
        assertThat(testRencimiento.getFechaHora()).isEqualTo(UPDATED_FECHA_HORA);
    }

    @Test
    void putNonExistingRencimiento() throws Exception {
        int databaseSizeBeforeUpdate = rencimientoRepository.findAll().collectList().block().size();
        rencimiento.setId(count.incrementAndGet());

        // Create the Rencimiento
        RencimientoDTO rencimientoDTO = rencimientoMapper.toDto(rencimiento);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, rencimientoDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rencimientoDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Rencimiento in the database
        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchRencimiento() throws Exception {
        int databaseSizeBeforeUpdate = rencimientoRepository.findAll().collectList().block().size();
        rencimiento.setId(count.incrementAndGet());

        // Create the Rencimiento
        RencimientoDTO rencimientoDTO = rencimientoMapper.toDto(rencimiento);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rencimientoDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Rencimiento in the database
        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamRencimiento() throws Exception {
        int databaseSizeBeforeUpdate = rencimientoRepository.findAll().collectList().block().size();
        rencimiento.setId(count.incrementAndGet());

        // Create the Rencimiento
        RencimientoDTO rencimientoDTO = rencimientoMapper.toDto(rencimiento);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rencimientoDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Rencimiento in the database
        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateRencimientoWithPatch() throws Exception {
        // Initialize the database
        rencimientoRepository.save(rencimiento).block();

        int databaseSizeBeforeUpdate = rencimientoRepository.findAll().collectList().block().size();

        // Update the rencimiento using partial update
        Rencimiento partialUpdatedRencimiento = new Rencimiento();
        partialUpdatedRencimiento.setId(rencimiento.getId());

        partialUpdatedRencimiento.fechaHora(UPDATED_FECHA_HORA);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedRencimiento.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedRencimiento))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Rencimiento in the database
        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeUpdate);
        Rencimiento testRencimiento = rencimientoList.get(rencimientoList.size() - 1);
        assertThat(testRencimiento.getCedulaBeneficiario()).isEqualTo(DEFAULT_CEDULA_BENEFICIARIO);
        assertThat(testRencimiento.getTelefonoEmisor()).isEqualTo(DEFAULT_TELEFONO_EMISOR);
        assertThat(testRencimiento.getFechaHora()).isEqualTo(UPDATED_FECHA_HORA);
    }

    @Test
    void fullUpdateRencimientoWithPatch() throws Exception {
        // Initialize the database
        rencimientoRepository.save(rencimiento).block();

        int databaseSizeBeforeUpdate = rencimientoRepository.findAll().collectList().block().size();

        // Update the rencimiento using partial update
        Rencimiento partialUpdatedRencimiento = new Rencimiento();
        partialUpdatedRencimiento.setId(rencimiento.getId());

        partialUpdatedRencimiento
            .cedulaBeneficiario(UPDATED_CEDULA_BENEFICIARIO)
            .telefonoEmisor(UPDATED_TELEFONO_EMISOR)
            .fechaHora(UPDATED_FECHA_HORA);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedRencimiento.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedRencimiento))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Rencimiento in the database
        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeUpdate);
        Rencimiento testRencimiento = rencimientoList.get(rencimientoList.size() - 1);
        assertThat(testRencimiento.getCedulaBeneficiario()).isEqualTo(UPDATED_CEDULA_BENEFICIARIO);
        assertThat(testRencimiento.getTelefonoEmisor()).isEqualTo(UPDATED_TELEFONO_EMISOR);
        assertThat(testRencimiento.getFechaHora()).isEqualTo(UPDATED_FECHA_HORA);
    }

    @Test
    void patchNonExistingRencimiento() throws Exception {
        int databaseSizeBeforeUpdate = rencimientoRepository.findAll().collectList().block().size();
        rencimiento.setId(count.incrementAndGet());

        // Create the Rencimiento
        RencimientoDTO rencimientoDTO = rencimientoMapper.toDto(rencimiento);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, rencimientoDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(rencimientoDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Rencimiento in the database
        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchRencimiento() throws Exception {
        int databaseSizeBeforeUpdate = rencimientoRepository.findAll().collectList().block().size();
        rencimiento.setId(count.incrementAndGet());

        // Create the Rencimiento
        RencimientoDTO rencimientoDTO = rencimientoMapper.toDto(rencimiento);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(rencimientoDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Rencimiento in the database
        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamRencimiento() throws Exception {
        int databaseSizeBeforeUpdate = rencimientoRepository.findAll().collectList().block().size();
        rencimiento.setId(count.incrementAndGet());

        // Create the Rencimiento
        RencimientoDTO rencimientoDTO = rencimientoMapper.toDto(rencimiento);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(rencimientoDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Rencimiento in the database
        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteRencimiento() {
        // Initialize the database
        rencimientoRepository.save(rencimiento).block();

        int databaseSizeBeforeDelete = rencimientoRepository.findAll().collectList().block().size();

        // Delete the rencimiento
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, rencimiento.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<Rencimiento> rencimientoList = rencimientoRepository.findAll().collectList().block();
        assertThat(rencimientoList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
