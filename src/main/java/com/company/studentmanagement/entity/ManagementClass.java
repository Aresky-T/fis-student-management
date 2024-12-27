package com.company.studentmanagement.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "MANAGEMENT_CLASS", indexes = {
        @Index(name = "IDX_MANAGEMENT_CLASS_MANAGER", columnList = "MANAGER_ID")
}, uniqueConstraints = {
        @UniqueConstraint(name = "IDX_MANAGEMENT_CLASS_UNQ_NAME", columnNames = {"NAME"})
})
@Entity
public class ManagementClass {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @JoinColumn(name = "MANAGER_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Teacher manager;

    @NotNull
    @Column(name = "TOTAL_STUDENTS", nullable = false, columnDefinition = "INT NOT NULL DEFAULT 0")
    private Integer totalStudents;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @OneToMany(mappedBy = "managementClass")
    private List<Student> students;

    public void setTotalStudents(Integer totalStudents) {
        this.totalStudents = totalStudents;
    }

    public Integer getTotalStudents() {
        return totalStudents;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getManager() {
        return manager;
    }

    public void setManager(Teacher manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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