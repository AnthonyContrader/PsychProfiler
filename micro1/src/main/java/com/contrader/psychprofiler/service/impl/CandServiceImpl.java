package com.contrader.psychprofiler.service.impl;

import com.contrader.psychprofiler.service.CandService;
import com.contrader.psychprofiler.domain.Cand;
import com.contrader.psychprofiler.repository.CandRepository;
import com.contrader.psychprofiler.service.dto.CandDTO;
import com.contrader.psychprofiler.service.mapper.CandMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Cand}.
 */
@Service
@Transactional
public class CandServiceImpl implements CandService {

    private final Logger log = LoggerFactory.getLogger(CandServiceImpl.class);

    private final CandRepository candRepository;

    private final CandMapper candMapper;

    public CandServiceImpl(CandRepository candRepository, CandMapper candMapper) {
        this.candRepository = candRepository;
        this.candMapper = candMapper;
    }

    /**
     * Save a cand.
     *
     * @param candDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CandDTO save(CandDTO candDTO) {
        log.debug("Request to save Cand : {}", candDTO);
        Cand cand = candMapper.toEntity(candDTO);
        cand = candRepository.save(cand);
        return candMapper.toDto(cand);
    }

    /**
     * Get all the cands.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CandDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Cands");
        return candRepository.findAll(pageable)
            .map(candMapper::toDto);
    }


    /**
     * Get one cand by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CandDTO> findOne(Long id) {
        log.debug("Request to get Cand : {}", id);
        return candRepository.findById(id)
            .map(candMapper::toDto);
    }

    /**
     * Delete the cand by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Cand : {}", id);
        candRepository.deleteById(id);
    }
}
