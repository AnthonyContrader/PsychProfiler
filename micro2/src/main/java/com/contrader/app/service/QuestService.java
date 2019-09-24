package com.contrader.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.contrader.app.service.dto.QuestDTO;

/**
 * Service Interface for managing {@link com.contrader.app.domain.Quest}.
 */
public interface QuestService {

    /**
     * Save a quest.
     *
     * @param questDTO the entity to save.
     * @return the persisted entity.
     */
    QuestDTO save(QuestDTO questDTO);

    /**
     * Get all the quests.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<QuestDTO> findAll(Pageable pageable);


    /**
     * Get the "id" quest.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<QuestDTO> findOne(Long id);

    /**
     * Delete the "id" quest.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

}
