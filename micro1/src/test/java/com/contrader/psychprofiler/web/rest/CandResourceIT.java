package com.contrader.psychprofiler.web.rest;

import com.contrader.psychprofiler.Micro1App;
import com.contrader.psychprofiler.domain.Cand;
import com.contrader.psychprofiler.repository.CandRepository;
import com.contrader.psychprofiler.service.CandService;
import com.contrader.psychprofiler.service.dto.CandDTO;
import com.contrader.psychprofiler.service.mapper.CandMapper;
import com.contrader.psychprofiler.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

import static com.contrader.psychprofiler.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link CandResource} REST controller.
 */
@SpringBootTest(classes = Micro1App.class)
public class CandResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SURNAME = "AAAAAAAAAA";
    private static final String UPDATED_SURNAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_AGE = 1;
    private static final Integer UPDATED_AGE = 2;
    private static final Integer SMALLER_AGE = 1 - 1;

    private static final String DEFAULT_EXPERIENCE = "AAAAAAAAAA";
    private static final String UPDATED_EXPERIENCE = "BBBBBBBBBB";

    private static final String DEFAULT_USERNAME = "AAAAAAAAAA";
    private static final String UPDATED_USERNAME = "BBBBBBBBBB";

    @Autowired
    private CandRepository candRepository;

    @Autowired
    private CandMapper candMapper;

    @Autowired
    private CandService candService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restCandMockMvc;

    private Cand cand;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CandResource candResource = new CandResource(candService);
        this.restCandMockMvc = MockMvcBuilders.standaloneSetup(candResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Cand createEntity(EntityManager em) {
        Cand cand = new Cand()
            .name(DEFAULT_NAME)
            .surname(DEFAULT_SURNAME)
            .age(DEFAULT_AGE)
            .experience(DEFAULT_EXPERIENCE)
            .username(DEFAULT_USERNAME);
        return cand;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Cand createUpdatedEntity(EntityManager em) {
        Cand cand = new Cand()
            .name(UPDATED_NAME)
            .surname(UPDATED_SURNAME)
            .age(UPDATED_AGE)
            .experience(UPDATED_EXPERIENCE)
            .username(UPDATED_USERNAME);
        return cand;
    }

    @BeforeEach
    public void initTest() {
        cand = createEntity(em);
    }

    @Test
    @Transactional
    public void createCand() throws Exception {
        int databaseSizeBeforeCreate = candRepository.findAll().size();

        // Create the Cand
        CandDTO candDTO = candMapper.toDto(cand);
        restCandMockMvc.perform(post("/api/cands")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(candDTO)))
            .andExpect(status().isCreated());

        // Validate the Cand in the database
        List<Cand> candList = candRepository.findAll();
        assertThat(candList).hasSize(databaseSizeBeforeCreate + 1);
        Cand testCand = candList.get(candList.size() - 1);
        assertThat(testCand.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testCand.getSurname()).isEqualTo(DEFAULT_SURNAME);
        assertThat(testCand.getAge()).isEqualTo(DEFAULT_AGE);
        assertThat(testCand.getExperience()).isEqualTo(DEFAULT_EXPERIENCE);
        assertThat(testCand.getUsername()).isEqualTo(DEFAULT_USERNAME);
    }

    @Test
    @Transactional
    public void createCandWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = candRepository.findAll().size();

        // Create the Cand with an existing ID
        cand.setId(1L);
        CandDTO candDTO = candMapper.toDto(cand);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCandMockMvc.perform(post("/api/cands")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(candDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Cand in the database
        List<Cand> candList = candRepository.findAll();
        assertThat(candList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = candRepository.findAll().size();
        // set the field null
        cand.setName(null);

        // Create the Cand, which fails.
        CandDTO candDTO = candMapper.toDto(cand);

        restCandMockMvc.perform(post("/api/cands")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(candDTO)))
            .andExpect(status().isBadRequest());

        List<Cand> candList = candRepository.findAll();
        assertThat(candList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSurnameIsRequired() throws Exception {
        int databaseSizeBeforeTest = candRepository.findAll().size();
        // set the field null
        cand.setSurname(null);

        // Create the Cand, which fails.
        CandDTO candDTO = candMapper.toDto(cand);

        restCandMockMvc.perform(post("/api/cands")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(candDTO)))
            .andExpect(status().isBadRequest());

        List<Cand> candList = candRepository.findAll();
        assertThat(candList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAgeIsRequired() throws Exception {
        int databaseSizeBeforeTest = candRepository.findAll().size();
        // set the field null
        cand.setAge(null);

        // Create the Cand, which fails.
        CandDTO candDTO = candMapper.toDto(cand);

        restCandMockMvc.perform(post("/api/cands")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(candDTO)))
            .andExpect(status().isBadRequest());

        List<Cand> candList = candRepository.findAll();
        assertThat(candList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkExperienceIsRequired() throws Exception {
        int databaseSizeBeforeTest = candRepository.findAll().size();
        // set the field null
        cand.setExperience(null);

        // Create the Cand, which fails.
        CandDTO candDTO = candMapper.toDto(cand);

        restCandMockMvc.perform(post("/api/cands")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(candDTO)))
            .andExpect(status().isBadRequest());

        List<Cand> candList = candRepository.findAll();
        assertThat(candList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllCands() throws Exception {
        // Initialize the database
        candRepository.saveAndFlush(cand);

        // Get all the candList
        restCandMockMvc.perform(get("/api/cands?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cand.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].surname").value(hasItem(DEFAULT_SURNAME.toString())))
            .andExpect(jsonPath("$.[*].age").value(hasItem(DEFAULT_AGE)))
            .andExpect(jsonPath("$.[*].experience").value(hasItem(DEFAULT_EXPERIENCE.toString())))
            .andExpect(jsonPath("$.[*].username").value(hasItem(DEFAULT_USERNAME.toString())));
    }
    
    @Test
    @Transactional
    public void getCand() throws Exception {
        // Initialize the database
        candRepository.saveAndFlush(cand);

        // Get the cand
        restCandMockMvc.perform(get("/api/cands/{id}", cand.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(cand.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.surname").value(DEFAULT_SURNAME.toString()))
            .andExpect(jsonPath("$.age").value(DEFAULT_AGE))
            .andExpect(jsonPath("$.experience").value(DEFAULT_EXPERIENCE.toString()))
            .andExpect(jsonPath("$.username").value(DEFAULT_USERNAME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingCand() throws Exception {
        // Get the cand
        restCandMockMvc.perform(get("/api/cands/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCand() throws Exception {
        // Initialize the database
        candRepository.saveAndFlush(cand);

        int databaseSizeBeforeUpdate = candRepository.findAll().size();

        // Update the cand
        Cand updatedCand = candRepository.findById(cand.getId()).get();
        // Disconnect from session so that the updates on updatedCand are not directly saved in db
        em.detach(updatedCand);
        updatedCand
            .name(UPDATED_NAME)
            .surname(UPDATED_SURNAME)
            .age(UPDATED_AGE)
            .experience(UPDATED_EXPERIENCE)
            .username(UPDATED_USERNAME);
        CandDTO candDTO = candMapper.toDto(updatedCand);

        restCandMockMvc.perform(put("/api/cands")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(candDTO)))
            .andExpect(status().isOk());

        // Validate the Cand in the database
        List<Cand> candList = candRepository.findAll();
        assertThat(candList).hasSize(databaseSizeBeforeUpdate);
        Cand testCand = candList.get(candList.size() - 1);
        assertThat(testCand.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testCand.getSurname()).isEqualTo(UPDATED_SURNAME);
        assertThat(testCand.getAge()).isEqualTo(UPDATED_AGE);
        assertThat(testCand.getExperience()).isEqualTo(UPDATED_EXPERIENCE);
        assertThat(testCand.getUsername()).isEqualTo(UPDATED_USERNAME);
    }

    @Test
    @Transactional
    public void updateNonExistingCand() throws Exception {
        int databaseSizeBeforeUpdate = candRepository.findAll().size();

        // Create the Cand
        CandDTO candDTO = candMapper.toDto(cand);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCandMockMvc.perform(put("/api/cands")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(candDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Cand in the database
        List<Cand> candList = candRepository.findAll();
        assertThat(candList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCand() throws Exception {
        // Initialize the database
        candRepository.saveAndFlush(cand);

        int databaseSizeBeforeDelete = candRepository.findAll().size();

        // Delete the cand
        restCandMockMvc.perform(delete("/api/cands/{id}", cand.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Cand> candList = candRepository.findAll();
        assertThat(candList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Cand.class);
        Cand cand1 = new Cand();
        cand1.setId(1L);
        Cand cand2 = new Cand();
        cand2.setId(cand1.getId());
        assertThat(cand1).isEqualTo(cand2);
        cand2.setId(2L);
        assertThat(cand1).isNotEqualTo(cand2);
        cand1.setId(null);
        assertThat(cand1).isNotEqualTo(cand2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CandDTO.class);
        CandDTO candDTO1 = new CandDTO();
        candDTO1.setId(1L);
        CandDTO candDTO2 = new CandDTO();
        assertThat(candDTO1).isNotEqualTo(candDTO2);
        candDTO2.setId(candDTO1.getId());
        assertThat(candDTO1).isEqualTo(candDTO2);
        candDTO2.setId(2L);
        assertThat(candDTO1).isNotEqualTo(candDTO2);
        candDTO1.setId(null);
        assertThat(candDTO1).isNotEqualTo(candDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(candMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(candMapper.fromId(null)).isNull();
    }
}
