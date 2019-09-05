package com.contrader.psychprofiler.web.rest;

import com.contrader.psychprofiler.service.CandService;
import com.contrader.psychprofiler.web.rest.errors.BadRequestAlertException;
import com.contrader.psychprofiler.service.dto.CandDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.contrader.psychprofiler.domain.Cand}.
 */
@RestController
@RequestMapping("/api")
public class CandResource {

    private final Logger log = LoggerFactory.getLogger(CandResource.class);

    private static final String ENTITY_NAME = "micro1Cand";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CandService candService;

    public CandResource(CandService candService) {
        this.candService = candService;
    }

    /**
     * {@code POST  /cands} : Create a new cand.
     *
     * @param candDTO the candDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new candDTO, or with status {@code 400 (Bad Request)} if the cand has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cands")
    public ResponseEntity<CandDTO> createCand(@Valid @RequestBody CandDTO candDTO) throws URISyntaxException {
        log.debug("REST request to save Cand : {}", candDTO);
        if (candDTO.getId() != null) {
            throw new BadRequestAlertException("A new cand cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CandDTO result = candService.save(candDTO);
        return ResponseEntity.created(new URI("/api/cands/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cands} : Updates an existing cand.
     *
     * @param candDTO the candDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated candDTO,
     * or with status {@code 400 (Bad Request)} if the candDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the candDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cands")
    public ResponseEntity<CandDTO> updateCand(@Valid @RequestBody CandDTO candDTO) throws URISyntaxException {
        log.debug("REST request to update Cand : {}", candDTO);
        if (candDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CandDTO result = candService.save(candDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, candDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /cands} : get all the cands.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cands in body.
     */
    @GetMapping("/cands")
    public ResponseEntity<List<CandDTO>> getAllCands(Pageable pageable) {
        log.debug("REST request to get a page of Cands");
        Page<CandDTO> page = candService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cands/:id} : get the "id" cand.
     *
     * @param id the id of the candDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the candDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cands/{id}")
    public ResponseEntity<CandDTO> getCand(@PathVariable Long id) {
        log.debug("REST request to get Cand : {}", id);
        Optional<CandDTO> candDTO = candService.findOne(id);
        return ResponseUtil.wrapOrNotFound(candDTO);
    }

    /**
     * {@code DELETE  /cands/:id} : delete the "id" cand.
     *
     * @param id the id of the candDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cands/{id}")
    public ResponseEntity<Void> deleteCand(@PathVariable Long id) {
        log.debug("REST request to delete Cand : {}", id);
        candService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
