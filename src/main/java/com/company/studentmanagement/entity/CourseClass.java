package com.company.studentmanagement.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@JmixEntity
@Table(name = "COURSE_CLASS", indexes = {
        @Index(name = "IDX_COURSE_CLASS_TEACHER", columnList = "TEACHER_ID"),
        @Index(name = "IDX_COURSE_CLASS_COURSE", columnList = "COURSE_ID"),
        @Index(name = "IDX_COURSE_CLASS_NAME", columnList = "CLASS_NAME")
}, uniqueConstraints = {
        @UniqueConstraint(name = "IDX_COURSE_CLASS_UNQ_CLASS_CODE", columnNames = {"CLASS_CODE"})
})
@Entity
public class CourseClass {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @Column(name = "CLASS_CODE", nullable = false)
    @NotNull
    private String classCode;

    @Column(name = "CLASS_NAME", nullable = false)
    @NotNull
    private String className;

    @NotNull
    @Column(name = "SEMESTER", nullable = false)
    private String semester;

    @JoinColumn(name = "COURSE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    private Course course;

    @Column(name = "TYPE_", nullable = false)
    @NotNull
    private String type;

    @JoinColumn(name = "TEACHER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @NotNull
    @Column(name = "CREDIT", nullable = false)
    private Integer credit;

    @Column(name = "STATUS", nullable = false)
    @NotNull
    private String status;

    @Column(name = "NUMBER_OF_STUDENTS", nullable = false)
    @NotNull
    private Integer numberOfStudents;

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

    public void setType(CourseClassType type) {
        this.type = type == null ? null : type.getId();
    }

    public CourseClassType getType() {
        return type == null ? null : CourseClassType.fromId(type);
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setStatus(CourseClassStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public CourseClassStatus getStatus() {
        return status == null ? null : CourseClassStatus.fromId(status);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
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

    @InstanceName
    @DependsOnProperties({"className" , "classCode"})
    public String getDisplayName(){
        return this.classCode;
    }
}