package com.contrader.psychprofiler.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.contrader.psychprofiler.domain.Cand} entity.
 */
public class CandDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private Integer age;

    @NotNull
    private String experience;

    
    private String username;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CandDTO candDTO = (CandDTO) o;
        if (candDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), candDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CandDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", age=" + getAge() +
            ", experience='" + getExperience() + "'" +
            ", username='" + getUsername() + "'" +
            "}";
    }
}
