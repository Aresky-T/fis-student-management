package com.company.studentmanagement.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum CourseClassType implements EnumClass<String> {

    LECTURE_CLASS("LECTURE_CLASS"),
    LAB_CLASS("LAB_CLASS"),
    PROJECT_CLASS("PROJECT_CLASS"),
    INTERNSHIP_CLASS("INTERNSHIP_CLASS"),
    SOFT_SKILLS_CLASS("SOFT_SKILLS_CLASS"),
    ELECTIVE_CLASS("ELECTIVE_CLASS");

    private final String id;

    CourseClassType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CourseClassType fromId(String id) {
        for (CourseClassType at : CourseClassType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}