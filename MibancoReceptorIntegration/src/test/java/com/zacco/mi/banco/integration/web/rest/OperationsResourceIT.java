//package com.zacco.mi.banco.integration.web.rest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.hamcrest.Matchers.hasItem;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import com.zacco.mi.banco.integration.IntegrationTest;
//import com.zacco.mi.banco.integration.domain.Operations;
//import com.zacco.mi.banco.integration.repository.OperationsRepository;
//import com.zacco.mi.banco.integration.service.criteria.OperationsCriteria;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.atomic.AtomicLong;
//import javax.persistence.EntityManager;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * Integration tests for the {@link OperationsResource} REST controller.
// */
//@IntegrationTest
//@AutoConfigureMockMvc
//@WithMockUser
//class OperationsResourceIT {
//
//    private static final String DEFAULT_CEDULA_BENEFICIARIO = "AAAAAAAAAA";
//    private static final String UPDATED_CEDULA_BENEFICIARIO = "BBBBBBBBBB";
//
//    private static final String DEFAULT_TELEFONO_EMISOR = "AAAAAAAAAA";
//    private static final String UPDATED_TELEFONO_EMISOR = "BBBBBBBBBB";
//
//    private static final String DEFAULT_TELEFONO_BENEFICIARIO = "AAAAAAAAAA";
//    private static final String UPDATED_TELEFONO_BENEFICIARIO = "BBBBBBBBBB";
//
//    private static final String DEFAULT_MONTO = "AAAAAAAAAA";
//    private static final String UPDATED_MONTO = "BBBBBBBBBB";
//
//    private static final String DEFAULT_BANCO_EMISOR = "AAAA";
//    private static final String UPDATED_BANCO_EMISOR = "BBBB";
//
//    private static final String DEFAULT_CONCEPTO = "AAAAAAAAAA";
//    private static final String UPDATED_CONCEPTO = "BBBBBBBBBB";
//
//    private static final String DEFAULT_REFERENCIA = "AAAAAAAAAA";
//    private static final String UPDATED_REFERENCIA = "BBBBBBBBBB";
//
//    private static final String DEFAULT_FECHA_HORA = "AAAAAAAAAA";
//    private static final String UPDATED_FECHA_HORA = "BBBBBBBBBB";
//
//    private static final Boolean DEFAULT_STATUS = false;
//    private static final Boolean UPDATED_STATUS = true;
//
//    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
//    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";
//
//    private static final String ENTITY_API_URL = "/api/operations";
//    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";
//
//    private static Random random = new Random();
//    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
//
//    @Autowired
//    private OperationsRepository operationsRepository;
//
//    @Autowired
//    private EntityManager em;
//
//    @Autowired
//    private MockMvc restOperationsMockMvc;
//
//    private Operations operations;
//
//    /**
//     * Create an entity for this test.
//     *
//     * This is a static method, as tests for other entities might also need it,
//     * if they test an entity which requires the current entity.
//     */
//    public static Operations createEntity(EntityManager em) {
//        Operations operations = new Operations()
//            .cedulaBeneficiario(DEFAULT_CEDULA_BENEFICIARIO)
//            .telefonoEmisor(DEFAULT_TELEFONO_EMISOR)
//            .telefonoBeneficiario(DEFAULT_TELEFONO_BENEFICIARIO)
//            .monto(DEFAULT_MONTO)
//            .bancoEmisor(DEFAULT_BANCO_EMISOR)
//            .concepto(DEFAULT_CONCEPTO)
//            .referencia(DEFAULT_REFERENCIA)
//            .fechaHora(DEFAULT_FECHA_HORA)
//            .status(DEFAULT_STATUS)
//            .description(DEFAULT_DESCRIPTION);
//        return operations;
//    }
//
//    /**
//     * Create an updated entity for this test.
//     *
//     * This is a static method, as tests for other entities might also need it,
//     * if they test an entity which requires the current entity.
//     */
//    public static Operations createUpdatedEntity(EntityManager em) {
//        Operations operations = new Operations()
//            .cedulaBeneficiario(UPDATED_CEDULA_BENEFICIARIO)
//            .telefonoEmisor(UPDATED_TELEFONO_EMISOR)
//            .telefonoBeneficiario(UPDATED_TELEFONO_BENEFICIARIO)
//            .monto(UPDATED_MONTO)
//            .bancoEmisor(UPDATED_BANCO_EMISOR)
//            .concepto(UPDATED_CONCEPTO)
//            .referencia(UPDATED_REFERENCIA)
//            .fechaHora(UPDATED_FECHA_HORA)
//            .status(UPDATED_STATUS)
//            .description(UPDATED_DESCRIPTION);
//        return operations;
//    }
//
//    @BeforeEach
//    public void initTest() {
//        operations = createEntity(em);
//    }
//
//    @Test
//    @Transactional
//    void createOperations() throws Exception {
//        int databaseSizeBeforeCreate = operationsRepository.findAll().size();
//        // Create the Operations
//        restOperationsMockMvc
//            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(operations)))
//            .andExpect(status().isCreated());
//
//        // Validate the Operations in the database
//        List<Operations> operationsList = operationsRepository.findAll();
//        assertThat(operationsList).hasSize(databaseSizeBeforeCreate + 1);
//        Operations testOperations = operationsList.get(operationsList.size() - 1);
//        assertThat(testOperations.getCedulaBeneficiario()).isEqualTo(DEFAULT_CEDULA_BENEFICIARIO);
//        assertThat(testOperations.getTelefonoEmisor()).isEqualTo(DEFAULT_TELEFONO_EMISOR);
//        assertThat(testOperations.getTelefonoBeneficiario()).isEqualTo(DEFAULT_TELEFONO_BENEFICIARIO);
//        assertThat(testOperations.getMonto()).isEqualTo(DEFAULT_MONTO);
//        assertThat(testOperations.getBancoEmisor()).isEqualTo(DEFAULT_BANCO_EMISOR);
//        assertThat(testOperations.getConcepto()).isEqualTo(DEFAULT_CONCEPTO);
//        assertThat(testOperations.getReferencia()).isEqualTo(DEFAULT_REFERENCIA);
//        assertThat(testOperations.getFechaHora()).isEqualTo(DEFAULT_FECHA_HORA);
//        assertThat(testOperations.getStatus()).isEqualTo(DEFAULT_STATUS);
//        assertThat(testOperations.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
//    }
//
//    @Test
//    @Transactional
//    void createOperationsWithExistingId() throws Exception {
//        // Create the Operations with an existing ID
//        operations.setId(1L);
//
//        int databaseSizeBeforeCreate = operationsRepository.findAll().size();
//
//        // An entity with an existing ID cannot be created, so this API call must fail
//        restOperationsMockMvc
//            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(operations)))
//            .andExpect(status().isBadRequest());
//
//        // Validate the Operations in the database
//        List<Operations> operationsList = operationsRepository.findAll();
//        assertThat(operationsList).hasSize(databaseSizeBeforeCreate);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperations() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList
//        restOperationsMockMvc
//            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
//            .andExpect(status().isOk())
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//            .andExpect(jsonPath("$.[*].id").value(hasItem(operations.getId().intValue())))
//            .andExpect(jsonPath("$.[*].cedulaBeneficiario").value(hasItem(DEFAULT_CEDULA_BENEFICIARIO)))
//            .andExpect(jsonPath("$.[*].telefonoEmisor").value(hasItem(DEFAULT_TELEFONO_EMISOR)))
//            .andExpect(jsonPath("$.[*].telefonoBeneficiario").value(hasItem(DEFAULT_TELEFONO_BENEFICIARIO)))
//            .andExpect(jsonPath("$.[*].monto").value(hasItem(DEFAULT_MONTO)))
//            .andExpect(jsonPath("$.[*].bancoEmisor").value(hasItem(DEFAULT_BANCO_EMISOR)))
//            .andExpect(jsonPath("$.[*].concepto").value(hasItem(DEFAULT_CONCEPTO)))
//            .andExpect(jsonPath("$.[*].referencia").value(hasItem(DEFAULT_REFERENCIA)))
//            .andExpect(jsonPath("$.[*].fechaHora").value(hasItem(DEFAULT_FECHA_HORA)))
//            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.booleanValue())))
//            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)));
//    }
//
//    @Test
//    @Transactional
//    void getOperations() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get the operations
//        restOperationsMockMvc
//            .perform(get(ENTITY_API_URL_ID, operations.getId()))
//            .andExpect(status().isOk())
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//            .andExpect(jsonPath("$.id").value(operations.getId().intValue()))
//            .andExpect(jsonPath("$.cedulaBeneficiario").value(DEFAULT_CEDULA_BENEFICIARIO))
//            .andExpect(jsonPath("$.telefonoEmisor").value(DEFAULT_TELEFONO_EMISOR))
//            .andExpect(jsonPath("$.telefonoBeneficiario").value(DEFAULT_TELEFONO_BENEFICIARIO))
//            .andExpect(jsonPath("$.monto").value(DEFAULT_MONTO))
//            .andExpect(jsonPath("$.bancoEmisor").value(DEFAULT_BANCO_EMISOR))
//            .andExpect(jsonPath("$.concepto").value(DEFAULT_CONCEPTO))
//            .andExpect(jsonPath("$.referencia").value(DEFAULT_REFERENCIA))
//            .andExpect(jsonPath("$.fechaHora").value(DEFAULT_FECHA_HORA))
//            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.booleanValue()))
//            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION));
//    }
//
//    @Test
//    @Transactional
//    void getOperationsByIdFiltering() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        Long id = operations.getId();
//
//        defaultOperationsShouldBeFound("id.equals=" + id);
//        defaultOperationsShouldNotBeFound("id.notEquals=" + id);
//
//        defaultOperationsShouldBeFound("id.greaterThanOrEqual=" + id);
//        defaultOperationsShouldNotBeFound("id.greaterThan=" + id);
//
//        defaultOperationsShouldBeFound("id.lessThanOrEqual=" + id);
//        defaultOperationsShouldNotBeFound("id.lessThan=" + id);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByCedulaBeneficiarioIsEqualToSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where cedulaBeneficiario equals to DEFAULT_CEDULA_BENEFICIARIO
//        defaultOperationsShouldBeFound("cedulaBeneficiario.equals=" + DEFAULT_CEDULA_BENEFICIARIO);
//
//        // Get all the operationsList where cedulaBeneficiario equals to UPDATED_CEDULA_BENEFICIARIO
//        defaultOperationsShouldNotBeFound("cedulaBeneficiario.equals=" + UPDATED_CEDULA_BENEFICIARIO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByCedulaBeneficiarioIsInShouldWork() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where cedulaBeneficiario in DEFAULT_CEDULA_BENEFICIARIO or UPDATED_CEDULA_BENEFICIARIO
//        defaultOperationsShouldBeFound("cedulaBeneficiario.in=" + DEFAULT_CEDULA_BENEFICIARIO + "," + UPDATED_CEDULA_BENEFICIARIO);
//
//        // Get all the operationsList where cedulaBeneficiario equals to UPDATED_CEDULA_BENEFICIARIO
//        defaultOperationsShouldNotBeFound("cedulaBeneficiario.in=" + UPDATED_CEDULA_BENEFICIARIO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByCedulaBeneficiarioIsNullOrNotNull() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where cedulaBeneficiario is not null
//        defaultOperationsShouldBeFound("cedulaBeneficiario.specified=true");
//
//        // Get all the operationsList where cedulaBeneficiario is null
//        defaultOperationsShouldNotBeFound("cedulaBeneficiario.specified=false");
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByCedulaBeneficiarioContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where cedulaBeneficiario contains DEFAULT_CEDULA_BENEFICIARIO
//        defaultOperationsShouldBeFound("cedulaBeneficiario.contains=" + DEFAULT_CEDULA_BENEFICIARIO);
//
//        // Get all the operationsList where cedulaBeneficiario contains UPDATED_CEDULA_BENEFICIARIO
//        defaultOperationsShouldNotBeFound("cedulaBeneficiario.contains=" + UPDATED_CEDULA_BENEFICIARIO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByCedulaBeneficiarioNotContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where cedulaBeneficiario does not contain DEFAULT_CEDULA_BENEFICIARIO
//        defaultOperationsShouldNotBeFound("cedulaBeneficiario.doesNotContain=" + DEFAULT_CEDULA_BENEFICIARIO);
//
//        // Get all the operationsList where cedulaBeneficiario does not contain UPDATED_CEDULA_BENEFICIARIO
//        defaultOperationsShouldBeFound("cedulaBeneficiario.doesNotContain=" + UPDATED_CEDULA_BENEFICIARIO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByTelefonoEmisorIsEqualToSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where telefonoEmisor equals to DEFAULT_TELEFONO_EMISOR
//        defaultOperationsShouldBeFound("telefonoEmisor.equals=" + DEFAULT_TELEFONO_EMISOR);
//
//        // Get all the operationsList where telefonoEmisor equals to UPDATED_TELEFONO_EMISOR
//        defaultOperationsShouldNotBeFound("telefonoEmisor.equals=" + UPDATED_TELEFONO_EMISOR);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByTelefonoEmisorIsInShouldWork() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where telefonoEmisor in DEFAULT_TELEFONO_EMISOR or UPDATED_TELEFONO_EMISOR
//        defaultOperationsShouldBeFound("telefonoEmisor.in=" + DEFAULT_TELEFONO_EMISOR + "," + UPDATED_TELEFONO_EMISOR);
//
//        // Get all the operationsList where telefonoEmisor equals to UPDATED_TELEFONO_EMISOR
//        defaultOperationsShouldNotBeFound("telefonoEmisor.in=" + UPDATED_TELEFONO_EMISOR);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByTelefonoEmisorIsNullOrNotNull() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where telefonoEmisor is not null
//        defaultOperationsShouldBeFound("telefonoEmisor.specified=true");
//
//        // Get all the operationsList where telefonoEmisor is null
//        defaultOperationsShouldNotBeFound("telefonoEmisor.specified=false");
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByTelefonoEmisorContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where telefonoEmisor contains DEFAULT_TELEFONO_EMISOR
//        defaultOperationsShouldBeFound("telefonoEmisor.contains=" + DEFAULT_TELEFONO_EMISOR);
//
//        // Get all the operationsList where telefonoEmisor contains UPDATED_TELEFONO_EMISOR
//        defaultOperationsShouldNotBeFound("telefonoEmisor.contains=" + UPDATED_TELEFONO_EMISOR);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByTelefonoEmisorNotContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where telefonoEmisor does not contain DEFAULT_TELEFONO_EMISOR
//        defaultOperationsShouldNotBeFound("telefonoEmisor.doesNotContain=" + DEFAULT_TELEFONO_EMISOR);
//
//        // Get all the operationsList where telefonoEmisor does not contain UPDATED_TELEFONO_EMISOR
//        defaultOperationsShouldBeFound("telefonoEmisor.doesNotContain=" + UPDATED_TELEFONO_EMISOR);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByTelefonoBeneficiarioIsEqualToSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where telefonoBeneficiario equals to DEFAULT_TELEFONO_BENEFICIARIO
//        defaultOperationsShouldBeFound("telefonoBeneficiario.equals=" + DEFAULT_TELEFONO_BENEFICIARIO);
//
//        // Get all the operationsList where telefonoBeneficiario equals to UPDATED_TELEFONO_BENEFICIARIO
//        defaultOperationsShouldNotBeFound("telefonoBeneficiario.equals=" + UPDATED_TELEFONO_BENEFICIARIO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByTelefonoBeneficiarioIsInShouldWork() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where telefonoBeneficiario in DEFAULT_TELEFONO_BENEFICIARIO or UPDATED_TELEFONO_BENEFICIARIO
//        defaultOperationsShouldBeFound("telefonoBeneficiario.in=" + DEFAULT_TELEFONO_BENEFICIARIO + "," + UPDATED_TELEFONO_BENEFICIARIO);
//
//        // Get all the operationsList where telefonoBeneficiario equals to UPDATED_TELEFONO_BENEFICIARIO
//        defaultOperationsShouldNotBeFound("telefonoBeneficiario.in=" + UPDATED_TELEFONO_BENEFICIARIO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByTelefonoBeneficiarioIsNullOrNotNull() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where telefonoBeneficiario is not null
//        defaultOperationsShouldBeFound("telefonoBeneficiario.specified=true");
//
//        // Get all the operationsList where telefonoBeneficiario is null
//        defaultOperationsShouldNotBeFound("telefonoBeneficiario.specified=false");
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByTelefonoBeneficiarioContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where telefonoBeneficiario contains DEFAULT_TELEFONO_BENEFICIARIO
//        defaultOperationsShouldBeFound("telefonoBeneficiario.contains=" + DEFAULT_TELEFONO_BENEFICIARIO);
//
//        // Get all the operationsList where telefonoBeneficiario contains UPDATED_TELEFONO_BENEFICIARIO
//        defaultOperationsShouldNotBeFound("telefonoBeneficiario.contains=" + UPDATED_TELEFONO_BENEFICIARIO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByTelefonoBeneficiarioNotContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where telefonoBeneficiario does not contain DEFAULT_TELEFONO_BENEFICIARIO
//        defaultOperationsShouldNotBeFound("telefonoBeneficiario.doesNotContain=" + DEFAULT_TELEFONO_BENEFICIARIO);
//
//        // Get all the operationsList where telefonoBeneficiario does not contain UPDATED_TELEFONO_BENEFICIARIO
//        defaultOperationsShouldBeFound("telefonoBeneficiario.doesNotContain=" + UPDATED_TELEFONO_BENEFICIARIO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByMontoIsEqualToSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where monto equals to DEFAULT_MONTO
//        defaultOperationsShouldBeFound("monto.equals=" + DEFAULT_MONTO);
//
//        // Get all the operationsList where monto equals to UPDATED_MONTO
//        defaultOperationsShouldNotBeFound("monto.equals=" + UPDATED_MONTO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByMontoIsInShouldWork() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where monto in DEFAULT_MONTO or UPDATED_MONTO
//        defaultOperationsShouldBeFound("monto.in=" + DEFAULT_MONTO + "," + UPDATED_MONTO);
//
//        // Get all the operationsList where monto equals to UPDATED_MONTO
//        defaultOperationsShouldNotBeFound("monto.in=" + UPDATED_MONTO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByMontoIsNullOrNotNull() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where monto is not null
//        defaultOperationsShouldBeFound("monto.specified=true");
//
//        // Get all the operationsList where monto is null
//        defaultOperationsShouldNotBeFound("monto.specified=false");
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByMontoContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where monto contains DEFAULT_MONTO
//        defaultOperationsShouldBeFound("monto.contains=" + DEFAULT_MONTO);
//
//        // Get all the operationsList where monto contains UPDATED_MONTO
//        defaultOperationsShouldNotBeFound("monto.contains=" + UPDATED_MONTO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByMontoNotContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where monto does not contain DEFAULT_MONTO
//        defaultOperationsShouldNotBeFound("monto.doesNotContain=" + DEFAULT_MONTO);
//
//        // Get all the operationsList where monto does not contain UPDATED_MONTO
//        defaultOperationsShouldBeFound("monto.doesNotContain=" + UPDATED_MONTO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByBancoEmisorIsEqualToSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where bancoEmisor equals to DEFAULT_BANCO_EMISOR
//        defaultOperationsShouldBeFound("bancoEmisor.equals=" + DEFAULT_BANCO_EMISOR);
//
//        // Get all the operationsList where bancoEmisor equals to UPDATED_BANCO_EMISOR
//        defaultOperationsShouldNotBeFound("bancoEmisor.equals=" + UPDATED_BANCO_EMISOR);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByBancoEmisorIsInShouldWork() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where bancoEmisor in DEFAULT_BANCO_EMISOR or UPDATED_BANCO_EMISOR
//        defaultOperationsShouldBeFound("bancoEmisor.in=" + DEFAULT_BANCO_EMISOR + "," + UPDATED_BANCO_EMISOR);
//
//        // Get all the operationsList where bancoEmisor equals to UPDATED_BANCO_EMISOR
//        defaultOperationsShouldNotBeFound("bancoEmisor.in=" + UPDATED_BANCO_EMISOR);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByBancoEmisorIsNullOrNotNull() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where bancoEmisor is not null
//        defaultOperationsShouldBeFound("bancoEmisor.specified=true");
//
//        // Get all the operationsList where bancoEmisor is null
//        defaultOperationsShouldNotBeFound("bancoEmisor.specified=false");
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByBancoEmisorContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where bancoEmisor contains DEFAULT_BANCO_EMISOR
//        defaultOperationsShouldBeFound("bancoEmisor.contains=" + DEFAULT_BANCO_EMISOR);
//
//        // Get all the operationsList where bancoEmisor contains UPDATED_BANCO_EMISOR
//        defaultOperationsShouldNotBeFound("bancoEmisor.contains=" + UPDATED_BANCO_EMISOR);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByBancoEmisorNotContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where bancoEmisor does not contain DEFAULT_BANCO_EMISOR
//        defaultOperationsShouldNotBeFound("bancoEmisor.doesNotContain=" + DEFAULT_BANCO_EMISOR);
//
//        // Get all the operationsList where bancoEmisor does not contain UPDATED_BANCO_EMISOR
//        defaultOperationsShouldBeFound("bancoEmisor.doesNotContain=" + UPDATED_BANCO_EMISOR);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByConceptoIsEqualToSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where concepto equals to DEFAULT_CONCEPTO
//        defaultOperationsShouldBeFound("concepto.equals=" + DEFAULT_CONCEPTO);
//
//        // Get all the operationsList where concepto equals to UPDATED_CONCEPTO
//        defaultOperationsShouldNotBeFound("concepto.equals=" + UPDATED_CONCEPTO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByConceptoIsInShouldWork() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where concepto in DEFAULT_CONCEPTO or UPDATED_CONCEPTO
//        defaultOperationsShouldBeFound("concepto.in=" + DEFAULT_CONCEPTO + "," + UPDATED_CONCEPTO);
//
//        // Get all the operationsList where concepto equals to UPDATED_CONCEPTO
//        defaultOperationsShouldNotBeFound("concepto.in=" + UPDATED_CONCEPTO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByConceptoIsNullOrNotNull() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where concepto is not null
//        defaultOperationsShouldBeFound("concepto.specified=true");
//
//        // Get all the operationsList where concepto is null
//        defaultOperationsShouldNotBeFound("concepto.specified=false");
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByConceptoContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where concepto contains DEFAULT_CONCEPTO
//        defaultOperationsShouldBeFound("concepto.contains=" + DEFAULT_CONCEPTO);
//
//        // Get all the operationsList where concepto contains UPDATED_CONCEPTO
//        defaultOperationsShouldNotBeFound("concepto.contains=" + UPDATED_CONCEPTO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByConceptoNotContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where concepto does not contain DEFAULT_CONCEPTO
//        defaultOperationsShouldNotBeFound("concepto.doesNotContain=" + DEFAULT_CONCEPTO);
//
//        // Get all the operationsList where concepto does not contain UPDATED_CONCEPTO
//        defaultOperationsShouldBeFound("concepto.doesNotContain=" + UPDATED_CONCEPTO);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByReferenciaIsEqualToSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where referencia equals to DEFAULT_REFERENCIA
//        defaultOperationsShouldBeFound("referencia.equals=" + DEFAULT_REFERENCIA);
//
//        // Get all the operationsList where referencia equals to UPDATED_REFERENCIA
//        defaultOperationsShouldNotBeFound("referencia.equals=" + UPDATED_REFERENCIA);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByReferenciaIsInShouldWork() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where referencia in DEFAULT_REFERENCIA or UPDATED_REFERENCIA
//        defaultOperationsShouldBeFound("referencia.in=" + DEFAULT_REFERENCIA + "," + UPDATED_REFERENCIA);
//
//        // Get all the operationsList where referencia equals to UPDATED_REFERENCIA
//        defaultOperationsShouldNotBeFound("referencia.in=" + UPDATED_REFERENCIA);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByReferenciaIsNullOrNotNull() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where referencia is not null
//        defaultOperationsShouldBeFound("referencia.specified=true");
//
//        // Get all the operationsList where referencia is null
//        defaultOperationsShouldNotBeFound("referencia.specified=false");
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByReferenciaContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where referencia contains DEFAULT_REFERENCIA
//        defaultOperationsShouldBeFound("referencia.contains=" + DEFAULT_REFERENCIA);
//
//        // Get all the operationsList where referencia contains UPDATED_REFERENCIA
//        defaultOperationsShouldNotBeFound("referencia.contains=" + UPDATED_REFERENCIA);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByReferenciaNotContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where referencia does not contain DEFAULT_REFERENCIA
//        defaultOperationsShouldNotBeFound("referencia.doesNotContain=" + DEFAULT_REFERENCIA);
//
//        // Get all the operationsList where referencia does not contain UPDATED_REFERENCIA
//        defaultOperationsShouldBeFound("referencia.doesNotContain=" + UPDATED_REFERENCIA);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByFechaHoraIsEqualToSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where fechaHora equals to DEFAULT_FECHA_HORA
//        defaultOperationsShouldBeFound("fechaHora.equals=" + DEFAULT_FECHA_HORA);
//
//        // Get all the operationsList where fechaHora equals to UPDATED_FECHA_HORA
//        defaultOperationsShouldNotBeFound("fechaHora.equals=" + UPDATED_FECHA_HORA);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByFechaHoraIsInShouldWork() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where fechaHora in DEFAULT_FECHA_HORA or UPDATED_FECHA_HORA
//        defaultOperationsShouldBeFound("fechaHora.in=" + DEFAULT_FECHA_HORA + "," + UPDATED_FECHA_HORA);
//
//        // Get all the operationsList where fechaHora equals to UPDATED_FECHA_HORA
//        defaultOperationsShouldNotBeFound("fechaHora.in=" + UPDATED_FECHA_HORA);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByFechaHoraIsNullOrNotNull() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where fechaHora is not null
//        defaultOperationsShouldBeFound("fechaHora.specified=true");
//
//        // Get all the operationsList where fechaHora is null
//        defaultOperationsShouldNotBeFound("fechaHora.specified=false");
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByFechaHoraContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where fechaHora contains DEFAULT_FECHA_HORA
//        defaultOperationsShouldBeFound("fechaHora.contains=" + DEFAULT_FECHA_HORA);
//
//        // Get all the operationsList where fechaHora contains UPDATED_FECHA_HORA
//        defaultOperationsShouldNotBeFound("fechaHora.contains=" + UPDATED_FECHA_HORA);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByFechaHoraNotContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where fechaHora does not contain DEFAULT_FECHA_HORA
//        defaultOperationsShouldNotBeFound("fechaHora.doesNotContain=" + DEFAULT_FECHA_HORA);
//
//        // Get all the operationsList where fechaHora does not contain UPDATED_FECHA_HORA
//        defaultOperationsShouldBeFound("fechaHora.doesNotContain=" + UPDATED_FECHA_HORA);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByStatusIsEqualToSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where status equals to DEFAULT_STATUS
//        defaultOperationsShouldBeFound("status.equals=" + DEFAULT_STATUS);
//
//        // Get all the operationsList where status equals to UPDATED_STATUS
//        defaultOperationsShouldNotBeFound("status.equals=" + UPDATED_STATUS);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByStatusIsInShouldWork() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where status in DEFAULT_STATUS or UPDATED_STATUS
//        defaultOperationsShouldBeFound("status.in=" + DEFAULT_STATUS + "," + UPDATED_STATUS);
//
//        // Get all the operationsList where status equals to UPDATED_STATUS
//        defaultOperationsShouldNotBeFound("status.in=" + UPDATED_STATUS);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByStatusIsNullOrNotNull() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where status is not null
//        defaultOperationsShouldBeFound("status.specified=true");
//
//        // Get all the operationsList where status is null
//        defaultOperationsShouldNotBeFound("status.specified=false");
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByDescriptionIsEqualToSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where description equals to DEFAULT_DESCRIPTION
//        defaultOperationsShouldBeFound("description.equals=" + DEFAULT_DESCRIPTION);
//
//        // Get all the operationsList where description equals to UPDATED_DESCRIPTION
//        defaultOperationsShouldNotBeFound("description.equals=" + UPDATED_DESCRIPTION);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByDescriptionIsInShouldWork() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where description in DEFAULT_DESCRIPTION or UPDATED_DESCRIPTION
//        defaultOperationsShouldBeFound("description.in=" + DEFAULT_DESCRIPTION + "," + UPDATED_DESCRIPTION);
//
//        // Get all the operationsList where description equals to UPDATED_DESCRIPTION
//        defaultOperationsShouldNotBeFound("description.in=" + UPDATED_DESCRIPTION);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByDescriptionIsNullOrNotNull() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where description is not null
//        defaultOperationsShouldBeFound("description.specified=true");
//
//        // Get all the operationsList where description is null
//        defaultOperationsShouldNotBeFound("description.specified=false");
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByDescriptionContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where description contains DEFAULT_DESCRIPTION
//        defaultOperationsShouldBeFound("description.contains=" + DEFAULT_DESCRIPTION);
//
//        // Get all the operationsList where description contains UPDATED_DESCRIPTION
//        defaultOperationsShouldNotBeFound("description.contains=" + UPDATED_DESCRIPTION);
//    }
//
//    @Test
//    @Transactional
//    void getAllOperationsByDescriptionNotContainsSomething() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        // Get all the operationsList where description does not contain DEFAULT_DESCRIPTION
//        defaultOperationsShouldNotBeFound("description.doesNotContain=" + DEFAULT_DESCRIPTION);
//
//        // Get all the operationsList where description does not contain UPDATED_DESCRIPTION
//        defaultOperationsShouldBeFound("description.doesNotContain=" + UPDATED_DESCRIPTION);
//    }
//
//    /**
//     * Executes the search, and checks that the default entity is returned.
//     */
//    private void defaultOperationsShouldBeFound(String filter) throws Exception {
//        restOperationsMockMvc
//            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
//            .andExpect(status().isOk())
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//            .andExpect(jsonPath("$.[*].id").value(hasItem(operations.getId().intValue())))
//            .andExpect(jsonPath("$.[*].cedulaBeneficiario").value(hasItem(DEFAULT_CEDULA_BENEFICIARIO)))
//            .andExpect(jsonPath("$.[*].telefonoEmisor").value(hasItem(DEFAULT_TELEFONO_EMISOR)))
//            .andExpect(jsonPath("$.[*].telefonoBeneficiario").value(hasItem(DEFAULT_TELEFONO_BENEFICIARIO)))
//            .andExpect(jsonPath("$.[*].monto").value(hasItem(DEFAULT_MONTO)))
//            .andExpect(jsonPath("$.[*].bancoEmisor").value(hasItem(DEFAULT_BANCO_EMISOR)))
//            .andExpect(jsonPath("$.[*].concepto").value(hasItem(DEFAULT_CONCEPTO)))
//            .andExpect(jsonPath("$.[*].referencia").value(hasItem(DEFAULT_REFERENCIA)))
//            .andExpect(jsonPath("$.[*].fechaHora").value(hasItem(DEFAULT_FECHA_HORA)))
//            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.booleanValue())))
//            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)));
//
//        // Check, that the count call also returns 1
//        restOperationsMockMvc
//            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
//            .andExpect(status().isOk())
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//            .andExpect(content().string("1"));
//    }
//
//    /**
//     * Executes the search, and checks that the default entity is not returned.
//     */
//    private void defaultOperationsShouldNotBeFound(String filter) throws Exception {
//        restOperationsMockMvc
//            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
//            .andExpect(status().isOk())
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//            .andExpect(jsonPath("$").isArray())
//            .andExpect(jsonPath("$").isEmpty());
//
//        // Check, that the count call also returns 0
//        restOperationsMockMvc
//            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
//            .andExpect(status().isOk())
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//            .andExpect(content().string("0"));
//    }
//
//    @Test
//    @Transactional
//    void getNonExistingOperations() throws Exception {
//        // Get the operations
//        restOperationsMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
//    }
//
//    @Test
//    @Transactional
//    void putExistingOperations() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        int databaseSizeBeforeUpdate = operationsRepository.findAll().size();
//
//        // Update the operations
//        Operations updatedOperations = operationsRepository.findById(operations.getId()).get();
//        // Disconnect from session so that the updates on updatedOperations are not directly saved in db
//        em.detach(updatedOperations);
//        updatedOperations
//            .cedulaBeneficiario(UPDATED_CEDULA_BENEFICIARIO)
//            .telefonoEmisor(UPDATED_TELEFONO_EMISOR)
//            .telefonoBeneficiario(UPDATED_TELEFONO_BENEFICIARIO)
//            .monto(UPDATED_MONTO)
//            .bancoEmisor(UPDATED_BANCO_EMISOR)
//            .concepto(UPDATED_CONCEPTO)
//            .referencia(UPDATED_REFERENCIA)
//            .fechaHora(UPDATED_FECHA_HORA)
//            .status(UPDATED_STATUS)
//            .description(UPDATED_DESCRIPTION);
//
//        restOperationsMockMvc
//            .perform(
//                put(ENTITY_API_URL_ID, updatedOperations.getId())
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(TestUtil.convertObjectToJsonBytes(updatedOperations))
//            )
//            .andExpect(status().isOk());
//
//        // Validate the Operations in the database
//        List<Operations> operationsList = operationsRepository.findAll();
//        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
//        Operations testOperations = operationsList.get(operationsList.size() - 1);
//        assertThat(testOperations.getCedulaBeneficiario()).isEqualTo(UPDATED_CEDULA_BENEFICIARIO);
//        assertThat(testOperations.getTelefonoEmisor()).isEqualTo(UPDATED_TELEFONO_EMISOR);
//        assertThat(testOperations.getTelefonoBeneficiario()).isEqualTo(UPDATED_TELEFONO_BENEFICIARIO);
//        assertThat(testOperations.getMonto()).isEqualTo(UPDATED_MONTO);
//        assertThat(testOperations.getBancoEmisor()).isEqualTo(UPDATED_BANCO_EMISOR);
//        assertThat(testOperations.getConcepto()).isEqualTo(UPDATED_CONCEPTO);
//        assertThat(testOperations.getReferencia()).isEqualTo(UPDATED_REFERENCIA);
//        assertThat(testOperations.getFechaHora()).isEqualTo(UPDATED_FECHA_HORA);
//        assertThat(testOperations.getStatus()).isEqualTo(UPDATED_STATUS);
//        assertThat(testOperations.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
//    }
//
//    @Test
//    @Transactional
//    void putNonExistingOperations() throws Exception {
//        int databaseSizeBeforeUpdate = operationsRepository.findAll().size();
//        operations.setId(count.incrementAndGet());
//
//        // If the entity doesn't have an ID, it will throw BadRequestAlertException
//        restOperationsMockMvc
//            .perform(
//                put(ENTITY_API_URL_ID, operations.getId())
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(TestUtil.convertObjectToJsonBytes(operations))
//            )
//            .andExpect(status().isBadRequest());
//
//        // Validate the Operations in the database
//        List<Operations> operationsList = operationsRepository.findAll();
//        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    @Transactional
//    void putWithIdMismatchOperations() throws Exception {
//        int databaseSizeBeforeUpdate = operationsRepository.findAll().size();
//        operations.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        restOperationsMockMvc
//            .perform(
//                put(ENTITY_API_URL_ID, count.incrementAndGet())
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(TestUtil.convertObjectToJsonBytes(operations))
//            )
//            .andExpect(status().isBadRequest());
//
//        // Validate the Operations in the database
//        List<Operations> operationsList = operationsRepository.findAll();
//        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    @Transactional
//    void putWithMissingIdPathParamOperations() throws Exception {
//        int databaseSizeBeforeUpdate = operationsRepository.findAll().size();
//        operations.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        restOperationsMockMvc
//            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(operations)))
//            .andExpect(status().isMethodNotAllowed());
//
//        // Validate the Operations in the database
//        List<Operations> operationsList = operationsRepository.findAll();
//        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    @Transactional
//    void partialUpdateOperationsWithPatch() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        int databaseSizeBeforeUpdate = operationsRepository.findAll().size();
//
//        // Update the operations using partial update
//        Operations partialUpdatedOperations = new Operations();
//        partialUpdatedOperations.setId(operations.getId());
//
//        partialUpdatedOperations.telefonoEmisor(UPDATED_TELEFONO_EMISOR).bancoEmisor(UPDATED_BANCO_EMISOR).description(UPDATED_DESCRIPTION);
//
//        restOperationsMockMvc
//            .perform(
//                patch(ENTITY_API_URL_ID, partialUpdatedOperations.getId())
//                    .contentType("application/merge-patch+json")
//                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedOperations))
//            )
//            .andExpect(status().isOk());
//
//        // Validate the Operations in the database
//        List<Operations> operationsList = operationsRepository.findAll();
//        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
//        Operations testOperations = operationsList.get(operationsList.size() - 1);
//        assertThat(testOperations.getCedulaBeneficiario()).isEqualTo(DEFAULT_CEDULA_BENEFICIARIO);
//        assertThat(testOperations.getTelefonoEmisor()).isEqualTo(UPDATED_TELEFONO_EMISOR);
//        assertThat(testOperations.getTelefonoBeneficiario()).isEqualTo(DEFAULT_TELEFONO_BENEFICIARIO);
//        assertThat(testOperations.getMonto()).isEqualTo(DEFAULT_MONTO);
//        assertThat(testOperations.getBancoEmisor()).isEqualTo(UPDATED_BANCO_EMISOR);
//        assertThat(testOperations.getConcepto()).isEqualTo(DEFAULT_CONCEPTO);
//        assertThat(testOperations.getReferencia()).isEqualTo(DEFAULT_REFERENCIA);
//        assertThat(testOperations.getFechaHora()).isEqualTo(DEFAULT_FECHA_HORA);
//        assertThat(testOperations.getStatus()).isEqualTo(DEFAULT_STATUS);
//        assertThat(testOperations.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
//    }
//
//    @Test
//    @Transactional
//    void fullUpdateOperationsWithPatch() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        int databaseSizeBeforeUpdate = operationsRepository.findAll().size();
//
//        // Update the operations using partial update
//        Operations partialUpdatedOperations = new Operations();
//        partialUpdatedOperations.setId(operations.getId());
//
//        partialUpdatedOperations
//            .cedulaBeneficiario(UPDATED_CEDULA_BENEFICIARIO)
//            .telefonoEmisor(UPDATED_TELEFONO_EMISOR)
//            .telefonoBeneficiario(UPDATED_TELEFONO_BENEFICIARIO)
//            .monto(UPDATED_MONTO)
//            .bancoEmisor(UPDATED_BANCO_EMISOR)
//            .concepto(UPDATED_CONCEPTO)
//            .referencia(UPDATED_REFERENCIA)
//            .fechaHora(UPDATED_FECHA_HORA)
//            .status(UPDATED_STATUS)
//            .description(UPDATED_DESCRIPTION);
//
//        restOperationsMockMvc
//            .perform(
//                patch(ENTITY_API_URL_ID, partialUpdatedOperations.getId())
//                    .contentType("application/merge-patch+json")
//                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedOperations))
//            )
//            .andExpect(status().isOk());
//
//        // Validate the Operations in the database
//        List<Operations> operationsList = operationsRepository.findAll();
//        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
//        Operations testOperations = operationsList.get(operationsList.size() - 1);
//        assertThat(testOperations.getCedulaBeneficiario()).isEqualTo(UPDATED_CEDULA_BENEFICIARIO);
//        assertThat(testOperations.getTelefonoEmisor()).isEqualTo(UPDATED_TELEFONO_EMISOR);
//        assertThat(testOperations.getTelefonoBeneficiario()).isEqualTo(UPDATED_TELEFONO_BENEFICIARIO);
//        assertThat(testOperations.getMonto()).isEqualTo(UPDATED_MONTO);
//        assertThat(testOperations.getBancoEmisor()).isEqualTo(UPDATED_BANCO_EMISOR);
//        assertThat(testOperations.getConcepto()).isEqualTo(UPDATED_CONCEPTO);
//        assertThat(testOperations.getReferencia()).isEqualTo(UPDATED_REFERENCIA);
//        assertThat(testOperations.getFechaHora()).isEqualTo(UPDATED_FECHA_HORA);
//        assertThat(testOperations.getStatus()).isEqualTo(UPDATED_STATUS);
//        assertThat(testOperations.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
//    }
//
//    @Test
//    @Transactional
//    void patchNonExistingOperations() throws Exception {
//        int databaseSizeBeforeUpdate = operationsRepository.findAll().size();
//        operations.setId(count.incrementAndGet());
//
//        // If the entity doesn't have an ID, it will throw BadRequestAlertException
//        restOperationsMockMvc
//            .perform(
//                patch(ENTITY_API_URL_ID, operations.getId())
//                    .contentType("application/merge-patch+json")
//                    .content(TestUtil.convertObjectToJsonBytes(operations))
//            )
//            .andExpect(status().isBadRequest());
//
//        // Validate the Operations in the database
//        List<Operations> operationsList = operationsRepository.findAll();
//        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    @Transactional
//    void patchWithIdMismatchOperations() throws Exception {
//        int databaseSizeBeforeUpdate = operationsRepository.findAll().size();
//        operations.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        restOperationsMockMvc
//            .perform(
//                patch(ENTITY_API_URL_ID, count.incrementAndGet())
//                    .contentType("application/merge-patch+json")
//                    .content(TestUtil.convertObjectToJsonBytes(operations))
//            )
//            .andExpect(status().isBadRequest());
//
//        // Validate the Operations in the database
//        List<Operations> operationsList = operationsRepository.findAll();
//        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    @Transactional
//    void patchWithMissingIdPathParamOperations() throws Exception {
//        int databaseSizeBeforeUpdate = operationsRepository.findAll().size();
//        operations.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        restOperationsMockMvc
//            .perform(
//                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(operations))
//            )
//            .andExpect(status().isMethodNotAllowed());
//
//        // Validate the Operations in the database
//        List<Operations> operationsList = operationsRepository.findAll();
//        assertThat(operationsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    @Transactional
//    void deleteOperations() throws Exception {
//        // Initialize the database
//        operationsRepository.saveAndFlush(operations);
//
//        int databaseSizeBeforeDelete = operationsRepository.findAll().size();
//
//        // Delete the operations
//        restOperationsMockMvc
//            .perform(delete(ENTITY_API_URL_ID, operations.getId()).accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isNoContent());
//
//        // Validate the database contains one less item
//        List<Operations> operationsList = operationsRepository.findAll();
//        assertThat(operationsList).hasSize(databaseSizeBeforeDelete - 1);
//    }
//}
