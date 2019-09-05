package com.contrader.psychprofiler.service;

import com.contrader.psychprofiler.service.dto.CandDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.contrader.psychprofiler.domain.Cand}.
 */
public interface CandService {

    /**
     * Save a cand.
     *
     * @param candDTO the entity to save.
     * @return the persisted entity.
     */
    CandDTO save(CandDTO candDTO);

    /**
     * Get all the cands.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CandDTO> findAll(Pageable pageable);


    /**
     * Get the "id" cand.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CandDTO> findOne(Long id);

    /**
     * Delete the "id" cand.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
