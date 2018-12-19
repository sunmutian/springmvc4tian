package com.tian.config;

public class Service {
    private String className;

    private String methodName;

    private String version;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Service{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
