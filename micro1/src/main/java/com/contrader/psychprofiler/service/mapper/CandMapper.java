package com.contrader.psychprofiler.service.mapper;

import com.contrader.psychprofiler.domain.*;
import com.contrader.psychprofiler.service.dto.CandDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cand} and its DTO {@link CandDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CandMapper extends EntityMapper<CandDTO, Cand> {



    default Cand fromId(Long id) {
        if (id == null) {
            return null;
        }
        Cand cand = new Cand();
        cand.setId(id);
        return cand;
    }
}
