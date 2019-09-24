package com.contrader.app.repository;

import com.contrader.app.domain.Quest;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Quest entity.
 */
@SuppressWarnings("unused")
@Repository
public interface QuestRepository extends JpaRepository<Quest, Long> {

	Iterable<Quest> findByArgs(String arg);
	
}
