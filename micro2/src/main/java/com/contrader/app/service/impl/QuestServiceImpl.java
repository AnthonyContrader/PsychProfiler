package com.contrader.app.service.impl;

import com.contrader.app.service.QuestService;
import com.contrader.app.domain.Quest;
import com.contrader.app.repository.QuestRepository;
import com.contrader.app.service.dto.QuestDTO;
import com.contrader.app.service.mapper.QuestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Quest}.
 */
@Service
@Transactional
public class QuestServiceImpl implements QuestService {

    private final Logger log = LoggerFactory.getLogger(QuestServiceImpl.class);

    private final QuestRepository questRepository;

    private final QuestMapper questMapper;

    public QuestServiceImpl(QuestRepository questRepository, QuestMapper questMapper) {
        this.questRepository = questRepository;
        this.questMapper = questMapper;
    }

    /**
     * Save a quest.
     *
     * @param questDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public QuestDTO save(QuestDTO questDTO) {
        log.debug("Request to save Quest : {}", questDTO);
        Quest quest = questMapper.toEntity(questDTO);
        quest = questRepository.save(quest);
        return questMapper.toDto(quest);
    }

    /**
     * Get all the quests.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<QuestDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Quests");
        return questRepository.findAll(pageable)
            .map(questMapper::toDto);
    }


    /**
     * Get one quest by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<QuestDTO> findOne(Long id) {
        log.debug("Request to get Quest : {}", id);
        return questRepository.findById(id)
            .map(questMapper::toDto);
    }

    /**
     * Delete the quest by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Quest : {}", id);
        questRepository.deleteById(id);
    }
}
