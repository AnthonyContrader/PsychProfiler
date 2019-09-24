package com.contrader.app.web.rest;

import com.contrader.app.service.QuestService;
import com.contrader.app.web.rest.errors.BadRequestAlertException;
import com.contrader.app.service.dto.QuestDTO;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.contrader.app.domain.Quest}.
 */
@RestController
@RequestMapping("/api")
public class QuestResource {

    private final Logger log = LoggerFactory.getLogger(QuestResource.class);

    private static final String ENTITY_NAME = "micro2Quest";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final QuestService questService;

    public QuestResource(QuestService questService) {
        this.questService = questService;
    }

    /**
     * {@code POST  /quests} : Create a new quest.
     *
     * @param questDTO the questDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new questDTO, or with status {@code 400 (Bad Request)} if the quest has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/quests")
    public ResponseEntity<QuestDTO> createQuest(@Valid @RequestBody QuestDTO questDTO) throws URISyntaxException {
        log.debug("REST request to save Quest : {}", questDTO);
        if (questDTO.getId() != null) {
            throw new BadRequestAlertException("A new quest cannot already have an ID", ENTITY_NAME, "idexists");
        }
        QuestDTO result = questService.save(questDTO);
        return ResponseEntity.created(new URI("/api/quests/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /quests} : Updates an existing quest.
     *
     * @param questDTO the questDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated questDTO,
     * or with status {@code 400 (Bad Request)} if the questDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the questDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/quests")
    public ResponseEntity<QuestDTO> updateQuest(@Valid @RequestBody QuestDTO questDTO) throws URISyntaxException {
        log.debug("REST request to update Quest : {}", questDTO);
        if (questDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        QuestDTO result = questService.save(questDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, questDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /quests} : get all the quests.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of quests in body.
     */
    @GetMapping("/quests")
    public ResponseEntity<List<QuestDTO>> getAllQuests(Pageable pageable) {
        log.debug("REST request to get a page of Quests");
        Page<QuestDTO> page = questService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /quests/:id} : get the "id" quest.
     *
     * @param id the id of the questDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the questDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/quests/{id}")
    public ResponseEntity<QuestDTO> getQuest(@PathVariable Long id) {
        log.debug("REST request to get Quest : {}", id);
        Optional<QuestDTO> questDTO = questService.findOne(id);
        return ResponseUtil.wrapOrNotFound(questDTO);
    }

    /**
     * {@code DELETE  /quests/:id} : delete the "id" quest.
     *
     * @param id the id of the questDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/quests/{id}")
    public ResponseEntity<Void> deleteQuest(@PathVariable Long id) {
        log.debug("REST request to delete Quest : {}", id);
        questService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
  
}
