package com.company.studentmanagement.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "COURSE", uniqueConstraints = {
        @UniqueConstraint(name = "IDX_COURSE_UNQ_CODE", columnNames = {"CODE"})
})
@Entity
public class Course {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @InstanceName
    @Column(name = "CODE", nullable = false, unique = true)
    @NotNull
    private String code;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "STATUS", nullable = false)
    @NotNull
    private String status;

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    private List<CourseClass> classes;

    public void setStatus(CourseStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public CourseStatus getStatus() {
        return status == null ? null : CourseStatus.fromId(status);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CourseClass> getClasses() {
        return classes;
    }

    public void setClasses(List<CourseClass> classes) {
        this.classes = classes;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}