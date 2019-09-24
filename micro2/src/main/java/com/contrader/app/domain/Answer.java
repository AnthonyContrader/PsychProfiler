package com.contrader.app.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A Answer.
 */
@Entity
@Table(name = "answer")
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "cand", nullable = false)
    private String cand;

    @NotNull
    @Column(name = "ans", nullable = false)
    private Integer ans;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("answers")
    private Quest answer_quest;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCand() {
        return cand;
    }

    public Answer cand(String cand) {
        this.cand = cand;
        return this;
    }

    public void setCand(String cand) {
        this.cand = cand;
    }

    public Integer getAns() {
        return ans;
    }

    public Answer ans(Integer ans) {
        this.ans = ans;
        return this;
    }

    public void setAns(Integer ans) {
        this.ans = ans;
    }

    public Quest getAnswer_quest() {
        return answer_quest;
    }

    public Answer answer_quest(Quest quest) {
        this.answer_quest = quest;
        return this;
    }

    public void setAnswer_quest(Quest quest) {
        this.answer_quest = quest;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Answer)) {
            return false;
        }
        return id != null && id.equals(((Answer) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Answer{" +
            "id=" + getId() +
            ", cand='" + getCand() + "'" +
            ", ans=" + getAns() +
            "}";
    }
}
