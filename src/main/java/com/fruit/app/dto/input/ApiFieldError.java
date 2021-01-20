package com.fruit.app.dto.input;
public class ApiFieldError{
private String field;
private String message;
private Object rejectedValue;

public ApiFieldError() {
        }

public ApiFieldError(String field, String message, Object rejectedValue) {
        this.field = field;
        this.message = message;
        this.rejectedValue = rejectedValue;
        }

public String getField() {
        return field;
        }

public void setField(String field) {
        this.field = field;
        }

public String getMessage() {
        return message;
        }

public void setMessage(String message) {
        this.message = message;
        }

public Object getRejectedValue() {
        return rejectedValue;
        }

public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
        }
}
