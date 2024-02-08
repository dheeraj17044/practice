package org.example.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class Answer {

    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answerText;

    @JoinColumn(name = "q_id")
    @OneToOne(mappedBy = "answer") // this foreign key will be shown in the Question table,
    private Question question;     // but bidirectional mapping is still there.

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer() {
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answerText='" + answerText + '\'' +
                ", question=" + question +
                '}';
    }
}
