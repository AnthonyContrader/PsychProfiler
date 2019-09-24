package com.contrader.app.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A Quest.
 */
@Entity
@Table(name = "quest")
public class Quest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "args", nullable = false)
    private String args;

    @NotNull
    @Column(name = "quest", nullable = false)
    private String quest;

    @NotNull
    @Column(name = "ans_1", nullable = false)
    private String ans1;

    @NotNull
    @Column(name = "ans_2", nullable = false)
    private String ans2;

    @NotNull
    @Column(name = "ans_3", nullable = false)
    private String ans3;

    @NotNull
    @Column(name = "ans_4", nullable = false)
    private String ans4;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArgs() {
        return args;
    }

    public Quest args(String args) {
        this.args = args;
        return this;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getQuest() {
        return quest;
    }

    public Quest quest(String quest) {
        this.quest = quest;
        return this;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String getAns1() {
        return ans1;
    }

    public Quest ans1(String ans1) {
        this.ans1 = ans1;
        return this;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public Quest ans2(String ans2) {
        this.ans2 = ans2;
        return this;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public Quest ans3(String ans3) {
        this.ans3 = ans3;
        return this;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public Quest ans4(String ans4) {
        this.ans4 = ans4;
        return this;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Quest)) {
            return false;
        }
        return id != null && id.equals(((Quest) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Quest{" +
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
