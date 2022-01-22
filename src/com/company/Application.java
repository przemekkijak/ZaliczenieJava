package com.company;

public class Application {
    public String appName;
    public Double version;
    public Double price;

    public String getAppName() {
        return appName;
    }

    public Application(String appName, Double version, Double price) {
        this.appName = appName;
        this.version = version;
        this.price = price;
    }
}
