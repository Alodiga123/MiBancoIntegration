package com.alodiga.promotion.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import com.alodiga.promotion.IntegrationTest;
import com.alodiga.promotion.domain.Operations;
import com.alodiga.promotion.repository.EntityManager;
import com.alodiga.promotion.repository.OperationsRepository;
import com.alodiga.promotion.service.dto.OperationsDTO;
import com.alodiga.promotion.service.mapper.OperationsMapper;
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
 * Integration tests for the {@link OperationsResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class OperationsResourceIT {

    private static final String DEFAULT_CEDULA_BENEFICIARIO = "AAAAAAAAAA";
    private static final String UPDATED_CEDULA_BENEFICIARIO = "BBBBBBBBBB";

    private static final String DEFAULT_TELEFONO_EMISOR = "AAAAAAAAAA";
    private static final String UPDATED_TELEFONO_EMISOR = "BBBBBBBBBB";

    private static final String DEFAULT_TELEFONO_BENEFICIARIO = "AAAAAAAAAA";
    private static final String UPDATED_TELEFONO_BENEFICIARIO = "BBBBBBBBBB";

    private static final String DEFAULT_MONTO = "AAAAAAAAAA";
    private static final String UPDATED_MONTO = "BBBBBBBBBB";

    private static final String DEFAULT_BANCO_EMISOR = "AAAA";
    private static final String UPDATED_BANCO_EMISOR = "BBBB";

    private static final String DEFAULT_CONCEPTO = "AAAAAAAAAA";
    private static final String UPDATED_CONCEPTO = "BBBBBBBBBB";

    private static final String DEFAULT_REFERENCIA = "AAAAAAAAAA";
    private static final String UPDATED_REFERENCIA = "BBBBBBBBBB";

    private static final String DEFAULT_FECHA_HORA = "AAAAAAAAAA";
    private static final String UPDATED_FECHA_HORA = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/operations";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private OperationsRepository operationsRepository;

    @Autowired
    private OperationsMapper operationsMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private Operations operations;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Operations createEntity(EntityManager em) {
        Operations operations = new Operations()
            .cedulaBeneficiario(DEFAULT_CEDULA_BENEFICIARIO)
            .telefonoEmisor(DEFAULT_TELEFONO_EMISOR)
            .telefonoBeneficiario(DEFAULT_TELEFONO_BENEFICIARIO)
            .monto(DEFAULT_MONTO)
            .bancoEmisor(DEFAULT_BANCO_EMISOR)
            .concepto(DEFAULT_CONCEPTO)
            .referencia(DEFAULT_REFERENCIA)
            .fechaHora(DEFAULT_FECHA_HORA);
        return operations;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Operations createUpdatedEntity(EntityManager em) {
        Operations operations = new Operations()
            .cedulaBeneficiario(UPDATED_CEDULA_BENEFICIARIO)
            .telefonoEmisor(UPDATED_TELEFONO_EMISOR)
            .telefonoBeneficiario(UPDATED_TELEFONO_BENEFICIARIO)
            .monto(UPDATED_MONTO)
            .bancoEmisor(UPDATED_BANCO_EMISOR)
            .concepto(UPDATED_CONCEPTO)
            .referencia(UPDATED_REFERENCIA)
            .fechaHora(UPDATED_FECHA_HORA);
        return operations;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(Operations.class).block();
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
        operations = createEntity(em);
    }

    @Test
    void createOperations() throws Exception {
        int databaseSizeBeforeCreate = operationsRepository.findAll().collectList().block().size();
        // Create the Operations
        OperationsDTO operationsDTO = operationsMapper.toDto(operations);
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(operationsDTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the Operations in the database
        List<Operations> operationsList = operationsRepository.findAll().collectList().block();
        assertThat(operationsList).hasSize(databaseSizeBeforeCreate + 1);
        Operations testOperations = operationsList.get(operationsList.size() - 1);
        assertThat(testOperations.getCedulaBeneficiario()).isEqualTo(DEFAULT_CEDULA_BENEFICIARIO);
        assertThat(testOperations.getTelefonoEmisor()).isEqualTo(DEFAULT_TELEFONO_EMISOR);
        assertThat(testOperations.getTelefonoBeneficiario()).isEqualTo(DEFAULT_TELEFONO_BENEFICIARIO);
        assertThat(testOperations.getMonto()).isEqualTo(DEFAULT_MONTO);
        assertThat(testOperations.getBancoEmisor()).isEqualTo(DEFAULT_BANCO_EMISOR);
        assertThat(testOperations.getConcepto()).isEqualTo(DEFAULT_CONCEPTO);
        assertThat(testOperations.getReferencia()).isEqualTo(DEFAULT_REFERENCIA);
        assertThat(testOperations.getFechaHora()).isEqualTo(DEFAULT_FECHA_HORA);
    }

    @Test
    void createOperationsWithExistingId() throws Exception {
        // Create the Operations with an existing ID
        operations.setId(1L);
        OperationsDTO operationsDTO = operationsMapper.toDto(operations);

        int databaseSizeBeforeCreate = operationsRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(operationsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Operations in the database
        List<Operations> operationsList = operationsRepository.findAll().collectList().block();
        assertThat(operationsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllOperations() {
        // Initialize the database
        operationsRepository.save(operations).block();

        // Get all the operationsList
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
            .value(hasItem(operations.getId().intValue()))
            .jsonPath("$.[*].cedulaBeneficiario")
            .value(hasItem(DEFAULT_CEDULA_BENEFICIARIO))
            .jsonPath("$.[*].telefonoEmisor")
            .value(hasItem(DEFAULT_TELEFONO_EMISOR))
            .jsonPath("$.[*].telefonoBeneficiario")
            .value(hasItem(DEFAULT_TELEFONO_BENEFICIARIO))
            .jsonPath("$.[*].monto")
            .value(hasItem(DEFAULT_MONTO))
            .jsonPath("$.[*].bancoEmisor")
            .value(hasItem(DEFAULT_BANCO_EMISOR))
            .jsonPath("$.[*].concepto")
            .value(hasItem(DEFAULT_CONCEPTO))
            .jsonPath("$.[*].referencia")
            .value(hasItem(DEFAULT_REFERENCIA))
            .jsonPath("$.[*].fechaHora")
            .value(hasItem(DEFAULT_FECHA_HORA));
    }

    @Test
    void getOperations() {
        // Initialize the database
        operationsRepository.save(operations).block();

        // Get the operations
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, operations.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(operations.getId().intValue()))
            .jsonPath("$.cedulaBeneficiario")
            .value(is(DEFAULT_CEDULA_BENEFICIARIO))
            .jsonPath("$.telefonoEmisor")
            .value(is(DEFAULT_TELEFONO_EMISOR))
            .jsonPath("$.telefonoBeneficiario")
            .value(is(DEFAULT_TELEFONO_BENEFICIARIO))
            .jsonPath("$.monto")
            .value(is(DEFAULT_MONTO))
            .jsonPath("$.bancoEmisor")
            .value(is(DEFAULT_BANCO_EMISOR))
            .jsonPath("$.concepto")
            .value(is(DEFAULT_CONCEPTO))
            .jsonPath("$.referencia")
            .value(is(DEFAULT_REFERENCIA))
            .jsonPath("$.fechaHora")
            .value(is(DEFAULT_FECHA_HORA));
    }

    @Test
    void getNonExistingOperations() {
        // Get the operations
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putExistingOperations() throws Exception {
        // Initialize the database
        operationsRepository.save(operations).block();

        int databaseSizeBeforeUpdate = operationsRepository.findAll().collectList().block().size();

        // Update the operations
        Operations updatedOperations = operationsRepository.findById(operations.getId()).block();
        updatedOperations
            .cedulaBeneficiario(UPDATED_CEDULA_BENEFICIARIO)
            .telefonoEmisor(UPDATED_TELEFONO_EMISOR)
            .telefonoBeneficiario(UPDATED_TELEFONO_BENEFICIARIO)
            .monto(UPDATED_MONTO)
            .bancoEmisor(UPDATED_BANCO_EMISOR)
            .concepto(UPDATED_CONCEPTO)
            .referencia(UPDATED_REFERENCIA)
            .fechaHora(UPDATED_FECHA_HORA);
        OperationsDTO operationsDTO = operationsMapper.toDto(updatedOperations);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, operationsDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(operationsDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Operations in the database
        List<Operations> operationsList = operationsRepository.findAll().collectList().block();
        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
        Operations testOperations = operationsList.get(operationsList.size() - 1);
        assertThat(testOperations.getCedulaBeneficiario()).isEqualTo(UPDATED_CEDULA_BENEFICIARIO);
        assertThat(testOperations.getTelefonoEmisor()).isEqualTo(UPDATED_TELEFONO_EMISOR);
        assertThat(testOperations.getTelefonoBeneficiario()).isEqualTo(UPDATED_TELEFONO_BENEFICIARIO);
        assertThat(testOperations.getMonto()).isEqualTo(UPDATED_MONTO);
        assertThat(testOperations.getBancoEmisor()).isEqualTo(UPDATED_BANCO_EMISOR);
        assertThat(testOperations.getConcepto()).isEqualTo(UPDATED_CONCEPTO);
        assertThat(testOperations.getReferencia()).isEqualTo(UPDATED_REFERENCIA);
        assertThat(testOperations.getFechaHora()).isEqualTo(UPDATED_FECHA_HORA);
    }

    @Test
    void putNonExistingOperations() throws Exception {
        int databaseSizeBeforeUpdate = operationsRepository.findAll().collectList().block().size();
        operations.setId(count.incrementAndGet());

        // Create the Operations
        OperationsDTO operationsDTO = operationsMapper.toDto(operations);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, operationsDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(operationsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Operations in the database
        List<Operations> operationsList = operationsRepository.findAll().collectList().block();
        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchOperations() throws Exception {
        int databaseSizeBeforeUpdate = operationsRepository.findAll().collectList().block().size();
        operations.setId(count.incrementAndGet());

        // Create the Operations
        OperationsDTO operationsDTO = operationsMapper.toDto(operations);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(operationsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Operations in the database
        List<Operations> operationsList = operationsRepository.findAll().collectList().block();
        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamOperations() throws Exception {
        int databaseSizeBeforeUpdate = operationsRepository.findAll().collectList().block().size();
        operations.setId(count.incrementAndGet());

        // Create the Operations
        OperationsDTO operationsDTO = operationsMapper.toDto(operations);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(operationsDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Operations in the database
        List<Operations> operationsList = operationsRepository.findAll().collectList().block();
        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateOperationsWithPatch() throws Exception {
        // Initialize the database
        operationsRepository.save(operations).block();

        int databaseSizeBeforeUpdate = operationsRepository.findAll().collectList().block().size();

        // Update the operations using partial update
        Operations partialUpdatedOperations = new Operations();
        partialUpdatedOperations.setId(operations.getId());

        partialUpdatedOperations.telefonoEmisor(UPDATED_TELEFONO_EMISOR).bancoEmisor(UPDATED_BANCO_EMISOR);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedOperations.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedOperations))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Operations in the database
        List<Operations> operationsList = operationsRepository.findAll().collectList().block();
        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
        Operations testOperations = operationsList.get(operationsList.size() - 1);
        assertThat(testOperations.getCedulaBeneficiario()).isEqualTo(DEFAULT_CEDULA_BENEFICIARIO);
        assertThat(testOperations.getTelefonoEmisor()).isEqualTo(UPDATED_TELEFONO_EMISOR);
        assertThat(testOperations.getTelefonoBeneficiario()).isEqualTo(DEFAULT_TELEFONO_BENEFICIARIO);
        assertThat(testOperations.getMonto()).isEqualTo(DEFAULT_MONTO);
        assertThat(testOperations.getBancoEmisor()).isEqualTo(UPDATED_BANCO_EMISOR);
        assertThat(testOperations.getConcepto()).isEqualTo(DEFAULT_CONCEPTO);
        assertThat(testOperations.getReferencia()).isEqualTo(DEFAULT_REFERENCIA);
        assertThat(testOperations.getFechaHora()).isEqualTo(DEFAULT_FECHA_HORA);
    }

    @Test
    void fullUpdateOperationsWithPatch() throws Exception {
        // Initialize the database
        operationsRepository.save(operations).block();

        int databaseSizeBeforeUpdate = operationsRepository.findAll().collectList().block().size();

        // Update the operations using partial update
        Operations partialUpdatedOperations = new Operations();
        partialUpdatedOperations.setId(operations.getId());

        partialUpdatedOperations
            .cedulaBeneficiario(UPDATED_CEDULA_BENEFICIARIO)
            .telefonoEmisor(UPDATED_TELEFONO_EMISOR)
            .telefonoBeneficiario(UPDATED_TELEFONO_BENEFICIARIO)
            .monto(UPDATED_MONTO)
            .bancoEmisor(UPDATED_BANCO_EMISOR)
            .concepto(UPDATED_CONCEPTO)
            .referencia(UPDATED_REFERENCIA)
            .fechaHora(UPDATED_FECHA_HORA);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedOperations.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedOperations))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Operations in the database
        List<Operations> operationsList = operationsRepository.findAll().collectList().block();
        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
        Operations testOperations = operationsList.get(operationsList.size() - 1);
        assertThat(testOperations.getCedulaBeneficiario()).isEqualTo(UPDATED_CEDULA_BENEFICIARIO);
        assertThat(testOperations.getTelefonoEmisor()).isEqualTo(UPDATED_TELEFONO_EMISOR);
        assertThat(testOperations.getTelefonoBeneficiario()).isEqualTo(UPDATED_TELEFONO_BENEFICIARIO);
        assertThat(testOperations.getMonto()).isEqualTo(UPDATED_MONTO);
        assertThat(testOperations.getBancoEmisor()).isEqualTo(UPDATED_BANCO_EMISOR);
        assertThat(testOperations.getConcepto()).isEqualTo(UPDATED_CONCEPTO);
        assertThat(testOperations.getReferencia()).isEqualTo(UPDATED_REFERENCIA);
        assertThat(testOperations.getFechaHora()).isEqualTo(UPDATED_FECHA_HORA);
    }

    @Test
    void patchNonExistingOperations() throws Exception {
        int databaseSizeBeforeUpdate = operationsRepository.findAll().collectList().block().size();
        operations.setId(count.incrementAndGet());

        // Create the Operations
        OperationsDTO operationsDTO = operationsMapper.toDto(operations);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, operationsDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(operationsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Operations in the database
        List<Operations> operationsList = operationsRepository.findAll().collectList().block();
        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchOperations() throws Exception {
        int databaseSizeBeforeUpdate = operationsRepository.findAll().collectList().block().size();
        operations.setId(count.incrementAndGet());

        // Create the Operations
        OperationsDTO operationsDTO = operationsMapper.toDto(operations);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(operationsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Operations in the database
        List<Operations> operationsList = operationsRepository.findAll().collectList().block();
        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamOperations() throws Exception {
        int databaseSizeBeforeUpdate = operationsRepository.findAll().collectList().block().size();
        operations.setId(count.incrementAndGet());

        // Create the Operations
        OperationsDTO operationsDTO = operationsMapper.toDto(operations);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(operationsDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Operations in the database
        List<Operations> operationsList = operationsRepository.findAll().collectList().block();
        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteOperations() {
        // Initialize the database
        operationsRepository.save(operations).block();

        int databaseSizeBeforeDelete = operationsRepository.findAll().collectList().block().size();

        // Delete the operations
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, operations.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<Operations> operationsList = operationsRepository.findAll().collectList().block();
        assertThat(operationsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
