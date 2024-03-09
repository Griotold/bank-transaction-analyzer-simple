package com.griotold.banktransactionanalyzersimple.exception;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * 검증 로직을 수행하는 Validator 클래스
 */
@AllArgsConstructor
public class BankStatementValidator {

    private String description;
    private String date;
    private String amount;

    // 과도하게 세밀한 검증
    public boolean validateOverlySpecific() throws DescriptionTooLongException,
            InvalidDateFormat,
            DateInTheFutureException,
            InvalidAmountException {
        if (this.description.length() > 100) {
            throw new DescriptionTooLongException();
        }

        final LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(this.date);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormat();
        }

        if (parsedDate.isAfter(LocalDate.now())) throw new DateInTheFutureException();

        try {
            Double.parseDouble(this.amount);
        } catch (NumberFormatException e) {
            throw new InvalidAmountException();
        }

        return true;
    }

    // 과도하게 덤덤한 검증 - 모든 예외를 IllegalArgumentException(런타임 예외)
    public boolean validateRoughly() {
        if (this.description.length() > 100) {
            throw new IllegalArgumentException("The description is too long");
        }

        final LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(this.date);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format for date", e);
        }

        if (parsedDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("date cannot be in the future");
        }

        try {
            Double.parseDouble(this.amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid format for amount", e);
        }

        return true;
    }
}
