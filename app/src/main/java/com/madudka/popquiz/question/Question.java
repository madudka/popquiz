package com.madudka.popquiz.question;


import android.content.Context;

import java.util.ArrayList;

public class Question {
    private String question;
    private String answerTrue;
    private String answerFalse;
    private String info;

    Question(String question, String answerTrue, String answerFalse, String info){
        this.question = question;
        this.answerTrue = answerTrue;
        this.answerFalse = answerFalse;
        this.info = info;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(String answerTrue) {
        this.answerTrue = answerTrue;
    }

    public String getAnswerFalse() {
        return answerFalse;
    }

    public void setAnswerFalse(String answerFalse) {
        this.answerFalse = answerFalse;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static ArrayList<Question> getQuestionList(Context context, int level){
        String fileName = JsonHelper.FILE_QUESTION_ONE;
        switch (level){
            case 2: fileName = JsonHelper.FILE_QUESTION_TWO; break;
            case 3: fileName = JsonHelper.FILE_QUESTION_THREE; break;
        }

        String jsonQuestions = JsonHelper.getJsonFromAssets(context, fileName);
        return JsonHelper.importFromJSON(jsonQuestions);
    }
}