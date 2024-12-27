package com.company.studentmanagement.entity;

import io.jmix.core.FileRef;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "STUDENT", indexes = {
        @Index(name = "IDX_STUDENT_MANAGEMENT_CLASS", columnList = "MANAGEMENT_CLASS_ID")
})
@Entity
public class Student {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @Column(name = "CODE", nullable = false)
    @NotNull
    private String code;

    @Column(name = "SURNAME", nullable = false)
    @NotNull
    private String surname;

    @InstanceName
    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "FIRST_NAME", nullable = false)
    @NotNull
    private String firstName;

    @Email
    @Column(name = "EMAIL", nullable = false)
    @NotNull
    private String email;

    @Column(name = "PICTURE", length = 1024)
    private FileRef picture;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Column(name = "CITIZEN_ID")
    private String citizenId;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ACADEMIC_PROGRAM", nullable = false)
    @NotNull
    private String academicProgram;

    @JoinColumn(name = "MANAGEMENT_CLASS_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ManagementClass managementClass;

    @Min(message = "{msg://com.company.studentmanagement.entity/Student.yearOfStudy.validation.Min}", value = 1)
    @Column(name = "YEAR_OF_STUDY", nullable = false)
    @NotNull
    private Integer yearOfStudy;

    @Column(name = "STATUS", nullable = false)
    @NotNull
    private String status;

    @OneToMany(mappedBy = "student")
    private List<Transcript> transcripts;

    public List<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(List<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StudentStatus getStatus() {
        return status == null ? null : StudentStatus.fromId(status);
    }

    public void setStatus(StudentStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public ManagementClass getManagementClass() {
        return managementClass;
    }

    public void setManagementClass(ManagementClass managementClass) {
        this.managementClass = managementClass;
    }

    public String getAcademicProgram() {
        return academicProgram;
    }

    public void setAcademicProgram(String academicProgram) {
        this.academicProgram = academicProgram;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public FileRef getPicture() {
        return picture;
    }

    public void setPicture(FileRef picture) {
        this.picture = picture;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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