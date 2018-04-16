package com.zperkowski.exsys;

public class Main {

    private String printMessage;

    private String getPrintMessage() {
        return printMessage;
    }

    void setPrintMessage(String printMessage) {
        this.printMessage = printMessage;
    }

    public void showMessage() {
        System.out.print(printMessage);
    }
}
