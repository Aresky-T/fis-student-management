package com.company.studentmanagement.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@JmixEntity
@Table(name = "TRANSCRIPT", indexes = {
        @Index(name = "IDX_TRANSCRIPT_STUDENT", columnList = "STUDENT_ID"),
        @Index(name = "IDX_TRANSCRIPT_COURSE_CLASS", columnList = "COURSE_CLASS_ID")
})
@Entity
public class Transcript {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Student student;

    @NotNull
    @Column(name = "SEMESTER", nullable = false)
    private String semester;

    @JoinColumn(name = "COURSE_CLASS_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CourseClass courseClass;

    @Column(name = "PROCESS_SCORE")
    private Float processScore;

    @Column(name = "EXAM_SCORE")
    private Float examScore;

    @Column(name = "FINAL_SCORE")
    private Float finalScore;

    @Column(name = "LETTER_GRADE")
    private Character letterGrade;

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

    public Character getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(Character letterGrade) {
        this.letterGrade = letterGrade;
    }

    public Float getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Float finalScore) {
        this.finalScore = finalScore;
    }

    public Float getExamScore() {
        return examScore;
    }

    public void setExamScore(Float examScore) {
        this.examScore = examScore;
    }

    public Float getProcessScore() {
        return processScore;
    }

    public void setProcessScore(Float processScore) {
        this.processScore = processScore;
    }

    public CourseClass getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(CourseClass courseClass) {
        this.courseClass = courseClass;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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