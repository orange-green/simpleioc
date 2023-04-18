package com.orangegreen.ioc.test;

/**
 * <p>
 *
 * </p>
 *
 * @author wuxj
 * @since 2023/4/17 16:28:11
 */

public class Teacher {

    private String name;

    private Classroom classroom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
