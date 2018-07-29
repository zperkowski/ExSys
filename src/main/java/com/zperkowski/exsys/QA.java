package com.zperkowski.exsys;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class QA extends Observable {

    private String question;
    private List<String> answers;
    private String answerd;
    private Object observer;

    public QA() {
        question = "";
        (answers = new ArrayList<>()).add("");
        answerd = "";
        notifyObservers();
        System.out.println("Created empty object\t" + this.toString() + " observers:\t" + this.countObservers());
    }

    public QA(QA old_qa, String answerd){
        this.question = old_qa.question;
        this.answers = old_qa.getAnswers();
        this.answerd = answerd;
        this.addObserver((ExSysController) old_qa.getObserver());
    }

    public QA(String question, List<String> answers) {
        this.question = question;
        this.answers = answers;
        this.answerd = "";
        System.out.println("Created object\t\t\t" + this.toString() + " observers:\t" + this.countObservers());
        notifyObservers();
    }

    public QA(String question, List<String> answers, Object o) {
        this.question = question;
        this.answers = answers;
        this.answerd = "";
        this.addObserver((ExSysController) o);
        System.out.println("Created object\t\t\t" + this.toString() + " observers:\t" + this.countObservers());
        setChanged();
        notifyObservers();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        this.observer = o;
        super.addObserver(o);
    }

    public Object getObserver() {
        return this.observer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getAnswerd() {
        return answerd;
    }

    public void setAnswerd(String answerd) {
        this.answerd = answerd;
    }

    public void change(String question, List<String> answers) {
        this.question = question;
        this.answers = answers;
        setAnswerd("");
        setChanged();
        notifyObservers();
    }

    public void sendInfo(String info) {
        setChanged();
        notifyObservers(info);
    }
}
