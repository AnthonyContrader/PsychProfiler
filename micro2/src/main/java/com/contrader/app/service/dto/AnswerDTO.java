package com.contrader.app.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.contrader.app.domain.Answer} entity.
 */
public class AnswerDTO implements Serializable {

    private Long id;

    @NotNull
    private String cand;

    @NotNull
    private Integer ans;


    private Long answer_questId;

    private String answer_questQuest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCand() {
        return cand;
    }

    public void setCand(String cand) {
        this.cand = cand;
    }

    public Integer getAns() {
        return ans;
    }

    public void setAns(Integer ans) {
        this.ans = ans;
    }

    public Long getAnswer_questId() {
        return answer_questId;
    }

    public void setAnswer_questId(Long questId) {
        this.answer_questId = questId;
    }

    public String getAnswer_questQuest() {
        return answer_questQuest;
    }

    public void setAnswer_questQuest(String questQuest) {
        this.answer_questQuest = questQuest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AnswerDTO answerDTO = (AnswerDTO) o;
        if (answerDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), answerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
            "id=" + getId() +
            ", cand='" + getCand() + "'" +
            ", ans=" + getAns() +
            ", answer_quest=" + getAnswer_questId() +
            ", answer_quest='" + getAnswer_questQuest() + "'" +
            "}";
    }
}
