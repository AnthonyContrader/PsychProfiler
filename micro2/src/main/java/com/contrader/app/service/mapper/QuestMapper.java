package com.contrader.app.service.mapper;

import com.contrader.app.domain.*;
import com.contrader.app.service.dto.QuestDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Quest} and its DTO {@link QuestDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface QuestMapper extends EntityMapper<QuestDTO, Quest> {



    default Quest fromId(Long id) {
        if (id == null) {
            return null;
        }
        Quest quest = new Quest();
        quest.setId(id);
        return quest;
    }
}
