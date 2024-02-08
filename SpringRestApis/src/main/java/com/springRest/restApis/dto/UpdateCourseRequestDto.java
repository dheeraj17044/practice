package com.springRest.restApis.dto;

public class UpdateCourseRequestDto {

    private int id;
    private String title;
    private String professor;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UpdateCourseRequestDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", professor='" + professor + '\'' +
                '}';
    }
}
