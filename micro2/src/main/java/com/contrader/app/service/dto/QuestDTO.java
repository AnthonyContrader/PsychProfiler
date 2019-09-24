package com.contrader.app.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.contrader.app.domain.Quest} entity.
 */
public class QuestDTO implements Serializable {

    private Long id;

    @NotNull
    private String args;

    @NotNull
    private String quest;

    @NotNull
    private String ans1;

    @NotNull
    private String ans2;

    @NotNull
    private String ans3;

    @NotNull
    private String ans4;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        QuestDTO questDTO = (QuestDTO) o;
        if (questDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), questDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "QuestDTO{" +
            "id=" + getId() +
            ", args='" + getArgs() + "'" +
            ", quest='" + getQuest() + "'" +
            ", ans1='" + getAns1() + "'" +
            ", ans2='" + getAns2() + "'" +
            ", ans3='" + getAns3() + "'" +
            ", ans4='" + getAns4() + "'" +
            "}";
    }
}
