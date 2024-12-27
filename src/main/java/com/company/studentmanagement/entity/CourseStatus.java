package com.company.studentmanagement.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum CourseStatus implements EnumClass<String> {

    SCHEDULED("SCHEDULED"),
    CANCELLED("CANCELLED"),
    DEFERRED("DEFERRED"),
    REGISTRATION_OPEN("REGISTRATION_OPEN"),
    NEW("NEW");

    private final String id;

    CourseStatus(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CourseStatus fromId(String id) {
        for (CourseStatus at : CourseStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}