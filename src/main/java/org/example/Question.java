package org.example;

public class Question {

    private String Questions;
    private int id;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private String Answer;

    public String getQuestions() {
        return Questions;
    }

    public void setQuestions(String questions) {
        Questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String option1) {
        Option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {
        Option3 = option3;
    }

    public String getOption4() {
        return Option4;
    }

    public void setOption4(String option4) {
        Option4 = option4;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public Question(int id,String questions, String option1, String option2, String option3, String option4, String answer) {
        Questions = questions;
        this.id = id;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        Option4 = option4;
        Answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "Questions='" + Questions + '\'' +
                ", id=" + id +
                ", Option1='" + Option1 + '\'' +
                ", Option2='" + Option2 + '\'' +
                ", Option3='" + Option3 + '\'' +
                ", Option4='" + Option4 + '\'' +
                ", Answer='" + Answer + '\'' +
                '}';
    }
}
