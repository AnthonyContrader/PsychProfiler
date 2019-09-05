package com.contrader.psychprofiler.repository;

import com.contrader.psychprofiler.domain.Cand;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Cand entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CandRepository extends JpaRepository<Cand, Long> {

}
