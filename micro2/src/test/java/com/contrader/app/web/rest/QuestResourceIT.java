package com.contrader.app.web.rest;

import com.contrader.app.Micro2App;
import com.contrader.app.domain.Quest;
import com.contrader.app.repository.QuestRepository;
import com.contrader.app.service.QuestService;
import com.contrader.app.service.dto.QuestDTO;
import com.contrader.app.service.mapper.QuestMapper;
import com.contrader.app.web.rest.errors.ExceptionTranslator;

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

import static com.contrader.app.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link QuestResource} REST controller.
 */
@SpringBootTest(classes = Micro2App.class)
public class QuestResourceIT {

    private static final String DEFAULT_ARGS = "AAAAAAAAAA";
    private static final String UPDATED_ARGS = "BBBBBBBBBB";

    private static final String DEFAULT_QUEST = "AAAAAAAAAA";
    private static final String UPDATED_QUEST = "BBBBBBBBBB";

    private static final String DEFAULT_ANS_1 = "AAAAAAAAAA";
    private static final String UPDATED_ANS_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ANS_2 = "AAAAAAAAAA";
    private static final String UPDATED_ANS_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ANS_3 = "AAAAAAAAAA";
    private static final String UPDATED_ANS_3 = "BBBBBBBBBB";

    private static final String DEFAULT_ANS_4 = "AAAAAAAAAA";
    private static final String UPDATED_ANS_4 = "BBBBBBBBBB";

    @Autowired
    private QuestRepository questRepository;

    @Autowired
    private QuestMapper questMapper;

    @Autowired
    private QuestService questService;

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

    private MockMvc restQuestMockMvc;

    private Quest quest;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final QuestResource questResource = new QuestResource(questService);
        this.restQuestMockMvc = MockMvcBuilders.standaloneSetup(questResource)
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
    public static Quest createEntity(EntityManager em) {
        Quest quest = new Quest()
            .args(DEFAULT_ARGS)
            .quest(DEFAULT_QUEST)
            .ans1(DEFAULT_ANS_1)
            .ans2(DEFAULT_ANS_2)
            .ans3(DEFAULT_ANS_3)
            .ans4(DEFAULT_ANS_4);
        return quest;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Quest createUpdatedEntity(EntityManager em) {
        Quest quest = new Quest()
            .args(UPDATED_ARGS)
            .quest(UPDATED_QUEST)
            .ans1(UPDATED_ANS_1)
            .ans2(UPDATED_ANS_2)
            .ans3(UPDATED_ANS_3)
            .ans4(UPDATED_ANS_4);
        return quest;
    }

    @BeforeEach
    public void initTest() {
        quest = createEntity(em);
    }

    @Test
    @Transactional
    public void createQuest() throws Exception {
        int databaseSizeBeforeCreate = questRepository.findAll().size();

        // Create the Quest
        QuestDTO questDTO = questMapper.toDto(quest);
        restQuestMockMvc.perform(post("/api/quests")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questDTO)))
            .andExpect(status().isCreated());

        // Validate the Quest in the database
        List<Quest> questList = questRepository.findAll();
        assertThat(questList).hasSize(databaseSizeBeforeCreate + 1);
        Quest testQuest = questList.get(questList.size() - 1);
        assertThat(testQuest.getArgs()).isEqualTo(DEFAULT_ARGS);
        assertThat(testQuest.getQuest()).isEqualTo(DEFAULT_QUEST);
        assertThat(testQuest.getAns1()).isEqualTo(DEFAULT_ANS_1);
        assertThat(testQuest.getAns2()).isEqualTo(DEFAULT_ANS_2);
        assertThat(testQuest.getAns3()).isEqualTo(DEFAULT_ANS_3);
        assertThat(testQuest.getAns4()).isEqualTo(DEFAULT_ANS_4);
    }

    @Test
    @Transactional
    public void createQuestWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = questRepository.findAll().size();

        // Create the Quest with an existing ID
        quest.setId(1L);
        QuestDTO questDTO = questMapper.toDto(quest);

        // An entity with an existing ID cannot be created, so this API call must fail
        restQuestMockMvc.perform(post("/api/quests")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Quest in the database
        List<Quest> questList = questRepository.findAll();
        assertThat(questList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkArgsIsRequired() throws Exception {
        int databaseSizeBeforeTest = questRepository.findAll().size();
        // set the field null
        quest.setArgs(null);

        // Create the Quest, which fails.
        QuestDTO questDTO = questMapper.toDto(quest);

        restQuestMockMvc.perform(post("/api/quests")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questDTO)))
            .andExpect(status().isBadRequest());

        List<Quest> questList = questRepository.findAll();
        assertThat(questList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkQuestIsRequired() throws Exception {
        int databaseSizeBeforeTest = questRepository.findAll().size();
        // set the field null
        quest.setQuest(null);

        // Create the Quest, which fails.
        QuestDTO questDTO = questMapper.toDto(quest);

        restQuestMockMvc.perform(post("/api/quests")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questDTO)))
            .andExpect(status().isBadRequest());

        List<Quest> questList = questRepository.findAll();
        assertThat(questList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAns1IsRequired() throws Exception {
        int databaseSizeBeforeTest = questRepository.findAll().size();
        // set the field null
        quest.setAns1(null);

        // Create the Quest, which fails.
        QuestDTO questDTO = questMapper.toDto(quest);

        restQuestMockMvc.perform(post("/api/quests")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questDTO)))
            .andExpect(status().isBadRequest());

        List<Quest> questList = questRepository.findAll();
        assertThat(questList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAns2IsRequired() throws Exception {
        int databaseSizeBeforeTest = questRepository.findAll().size();
        // set the field null
        quest.setAns2(null);

        // Create the Quest, which fails.
        QuestDTO questDTO = questMapper.toDto(quest);

        restQuestMockMvc.perform(post("/api/quests")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questDTO)))
            .andExpect(status().isBadRequest());

        List<Quest> questList = questRepository.findAll();
        assertThat(questList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAns3IsRequired() throws Exception {
        int databaseSizeBeforeTest = questRepository.findAll().size();
        // set the field null
        quest.setAns3(null);

        // Create the Quest, which fails.
        QuestDTO questDTO = questMapper.toDto(quest);

        restQuestMockMvc.perform(post("/api/quests")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questDTO)))
            .andExpect(status().isBadRequest());

        List<Quest> questList = questRepository.findAll();
        assertThat(questList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAns4IsRequired() throws Exception {
        int databaseSizeBeforeTest = questRepository.findAll().size();
        // set the field null
        quest.setAns4(null);

        // Create the Quest, which fails.
        QuestDTO questDTO = questMapper.toDto(quest);

        restQuestMockMvc.perform(post("/api/quests")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questDTO)))
            .andExpect(status().isBadRequest());

        List<Quest> questList = questRepository.findAll();
        assertThat(questList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllQuests() throws Exception {
        // Initialize the database
        questRepository.saveAndFlush(quest);

        // Get all the questList
        restQuestMockMvc.perform(get("/api/quests?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(quest.getId().intValue())))
            .andExpect(jsonPath("$.[*].args").value(hasItem(DEFAULT_ARGS.toString())))
            .andExpect(jsonPath("$.[*].quest").value(hasItem(DEFAULT_QUEST.toString())))
            .andExpect(jsonPath("$.[*].ans1").value(hasItem(DEFAULT_ANS_1.toString())))
            .andExpect(jsonPath("$.[*].ans2").value(hasItem(DEFAULT_ANS_2.toString())))
            .andExpect(jsonPath("$.[*].ans3").value(hasItem(DEFAULT_ANS_3.toString())))
            .andExpect(jsonPath("$.[*].ans4").value(hasItem(DEFAULT_ANS_4.toString())));
    }
    
    @Test
    @Transactional
    public void getQuest() throws Exception {
        // Initialize the database
        questRepository.saveAndFlush(quest);

        // Get the quest
        restQuestMockMvc.perform(get("/api/quests/{id}", quest.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(quest.getId().intValue()))
            .andExpect(jsonPath("$.args").value(DEFAULT_ARGS.toString()))
            .andExpect(jsonPath("$.quest").value(DEFAULT_QUEST.toString()))
            .andExpect(jsonPath("$.ans1").value(DEFAULT_ANS_1.toString()))
            .andExpect(jsonPath("$.ans2").value(DEFAULT_ANS_2.toString()))
            .andExpect(jsonPath("$.ans3").value(DEFAULT_ANS_3.toString()))
            .andExpect(jsonPath("$.ans4").value(DEFAULT_ANS_4.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingQuest() throws Exception {
        // Get the quest
        restQuestMockMvc.perform(get("/api/quests/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateQuest() throws Exception {
        // Initialize the database
        questRepository.saveAndFlush(quest);

        int databaseSizeBeforeUpdate = questRepository.findAll().size();

        // Update the quest
        Quest updatedQuest = questRepository.findById(quest.getId()).get();
        // Disconnect from session so that the updates on updatedQuest are not directly saved in db
        em.detach(updatedQuest);
        updatedQuest
            .args(UPDATED_ARGS)
            .quest(UPDATED_QUEST)
            .ans1(UPDATED_ANS_1)
            .ans2(UPDATED_ANS_2)
            .ans3(UPDATED_ANS_3)
            .ans4(UPDATED_ANS_4);
        QuestDTO questDTO = questMapper.toDto(updatedQuest);

        restQuestMockMvc.perform(put("/api/quests")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questDTO)))
            .andExpect(status().isOk());

        // Validate the Quest in the database
        List<Quest> questList = questRepository.findAll();
        assertThat(questList).hasSize(databaseSizeBeforeUpdate);
        Quest testQuest = questList.get(questList.size() - 1);
        assertThat(testQuest.getArgs()).isEqualTo(UPDATED_ARGS);
        assertThat(testQuest.getQuest()).isEqualTo(UPDATED_QUEST);
        assertThat(testQuest.getAns1()).isEqualTo(UPDATED_ANS_1);
        assertThat(testQuest.getAns2()).isEqualTo(UPDATED_ANS_2);
        assertThat(testQuest.getAns3()).isEqualTo(UPDATED_ANS_3);
        assertThat(testQuest.getAns4()).isEqualTo(UPDATED_ANS_4);
    }

    @Test
    @Transactional
    public void updateNonExistingQuest() throws Exception {
        int databaseSizeBeforeUpdate = questRepository.findAll().size();

        // Create the Quest
        QuestDTO questDTO = questMapper.toDto(quest);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restQuestMockMvc.perform(put("/api/quests")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Quest in the database
        List<Quest> questList = questRepository.findAll();
        assertThat(questList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteQuest() throws Exception {
        // Initialize the database
        questRepository.saveAndFlush(quest);

        int databaseSizeBeforeDelete = questRepository.findAll().size();

        // Delete the quest
        restQuestMockMvc.perform(delete("/api/quests/{id}", quest.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Quest> questList = questRepository.findAll();
        assertThat(questList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Quest.class);
        Quest quest1 = new Quest();
        quest1.setId(1L);
        Quest quest2 = new Quest();
        quest2.setId(quest1.getId());
        assertThat(quest1).isEqualTo(quest2);
        quest2.setId(2L);
        assertThat(quest1).isNotEqualTo(quest2);
        quest1.setId(null);
        assertThat(quest1).isNotEqualTo(quest2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(QuestDTO.class);
        QuestDTO questDTO1 = new QuestDTO();
        questDTO1.setId(1L);
        QuestDTO questDTO2 = new QuestDTO();
        assertThat(questDTO1).isNotEqualTo(questDTO2);
        questDTO2.setId(questDTO1.getId());
        assertThat(questDTO1).isEqualTo(questDTO2);
        questDTO2.setId(2L);
        assertThat(questDTO1).isNotEqualTo(questDTO2);
        questDTO1.setId(null);
        assertThat(questDTO1).isNotEqualTo(questDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(questMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(questMapper.fromId(null)).isNull();
    }
}
