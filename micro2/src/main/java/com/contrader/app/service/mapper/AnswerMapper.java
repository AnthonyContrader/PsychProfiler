package com.contrader.app.service.mapper;

import com.contrader.app.domain.*;
import com.contrader.app.service.dto.AnswerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Answer} and its DTO {@link AnswerDTO}.
 */
@Mapper(componentModel = "spring", uses = {QuestMapper.class})
public interface AnswerMapper extends EntityMapper<AnswerDTO, Answer> {

    @Mapping(source = "answer_quest.id", target = "answer_questId")
    @Mapping(source = "answer_quest.quest", target = "answer_questQuest")
    AnswerDTO toDto(Answer answer);

    @Mapping(source = "answer_questId", target = "answer_quest")
    Answer toEntity(AnswerDTO answerDTO);

    default Answer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Answer answer = new Answer();
        answer.setId(id);
        return answer;
    }
}
