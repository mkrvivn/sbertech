package com.example;

public class TestClass {

    public int publicIntField;

    public String publicStringField;

    private int privateIntField;

    private String privateStringField;

    public TestClass() {
    }

    public TestClass(int publicIntField, String publicStringField, int privateIntField, String privateStringField) {
        this.publicIntField = publicIntField;
        this.publicStringField = publicStringField;
        this.privateIntField = privateIntField;
        this.privateStringField = privateStringField;
    }

    private void privateMethod()
    {

    }

    public int getPublicIntField() {
        return publicIntField;
    }

    public void setPublicIntField(int publicIntField) {
        this.publicIntField = publicIntField;
    }

    public String getPublicStringField() {
        return publicStringField;
    }

    public void setPublicStringField(String publicStringField) {
        this.publicStringField = publicStringField;
    }

    public int getPrivateIntField() {
        return privateIntField;
    }

    public void setPrivateIntField(int privateIntField) {
        this.privateIntField = privateIntField;
    }

    public String getPrivateStringField() {
        return privateStringField;
    }

    public void setPrivateStringField(String privateStringField) {
        this.privateStringField = privateStringField;
    }
}
