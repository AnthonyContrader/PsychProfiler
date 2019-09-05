package com.contrader.psychprofiler.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.contrader.psychprofiler.domain.Job} entity.
 */
public class JobDTO implements Serializable {

    private Long id;

    @NotNull
    private String role;

    @NotNull
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JobDTO jobDTO = (JobDTO) o;
        if (jobDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), jobDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "JobDTO{" +
            "id=" + getId() +
            ", role='" + getRole() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
