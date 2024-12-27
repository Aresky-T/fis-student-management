package com.company.studentmanagement.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum CourseClassStatus implements EnumClass<String> {

    REGISTRATION_OPEN("REGISTRATION_OPEN"),
    REGISTRATION_CLOSED("REGISTRATION_CLOSED"),
    SCHEDULED("SCHEDULED"),
    CANCELLED("CANCELLED"),
    POSTPONED("POSTPONED");

    private final String id;

    CourseClassStatus(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CourseClassStatus fromId(String id) {
        for (CourseClassStatus at : CourseClassStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}