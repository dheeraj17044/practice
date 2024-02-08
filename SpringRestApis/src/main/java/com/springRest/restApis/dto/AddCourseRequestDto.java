package com.springRest.restApis.dto;

public class AddCourseRequestDto {
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

    public AddCourseRequestDto(String title, String professor) {
        this.title = title;
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "AddCourseRequestDto{" +
                "title='" + title + '\'' +
                ", professor='" + professor + '\'' +
                '}';
    }
}
