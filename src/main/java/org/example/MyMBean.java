package org.example;

public interface MyMBean {
    String getText();

    void setText(String newText);

    void changeLogLevelDebug();

    void changeLogLevelInfo();
}
