package com.company.studentmanagement.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum StudentStatus implements EnumClass<String> {

    GRADUATED("Đã tốt nghiệp"),
    NOT_GRADUATED("Chưa tốt nghiệp"),
    EXPELLED("Bị đuổi học"),
    DROP_OUT("Bỏ học");

    private final String id;

    StudentStatus(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static StudentStatus fromId(String id) {
        for (StudentStatus at : StudentStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}