package com.griotold.banktransactionanalyzersimple.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * 오류를 수집하는 도메인 클래스
 */
public class Notification {
    private final List<String> errors = new ArrayList<>();

    public void addError(final String message) {
        errors.add(message);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String errorMessage() {
        return errors.toString();
    }

    public List<String> getErrors() {
        return this.errors;
    }
}
