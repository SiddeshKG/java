package org.example;
import java.util.Scanner;

public class QuestionService {

    Question [] questions = new Question[5];
    String selection [] = new String[5];
    public QuestionService(){
        questions[0]= new Question(1,"who are u","don","king","minister","siddu","siddu");
        questions[1]= new Question(2,"bgmi game","bot","pro","legend","noob","pro");
        questions[2]= new Question(3,"who are u","don","king","minister","siddu","siddu");
        questions[3]= new Question(4,"who are u","don","king","minister","siddu","siddu");
        questions[4]= new Question(5,"who are u","don","king","minister","siddu","siddu");

    }

    public void playQuiz(){
        int i =0;
        for(Question q : questions) {
            System.out.println(q.getQuestions());
            System.out.println(q.getId());
            System.out.println(q.getOption1());
            System.out.println(q.getOption2());
            System.out.println(q.getOption3());
            System.out.println(q.getOption4());
            Scanner sc = new Scanner(System.in);
            selection [i] =sc.nextLine();
            i++;

        }

//        for(String s:selection ){
//            System.out.println(s);
//        }
 }

    public void calculateScore(){
        int score=0;
        for(int i=0; i< questions.length; i++){

            Question que = questions[i];
            String actAnswer = que.getAnswer();
            String selectedAnswer = selection[i];

            if(actAnswer.equals(selectedAnswer)){
                score++;
            }

            System.out.println("your score is :" +score);


        }
    }
}
