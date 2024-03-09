package com.griotold.banktransactionanalyzersimple;

import lombok.RequiredArgsConstructor;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public double calculateTotalAmount() {
        double result = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            result += bankTransaction.getAmount();
        }
        return result;
    }

    public double calculateTotalInMonth(final Month month) {
        double result = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            Month transactionMonth = bankTransaction.getDate().getMonth();

            if (transactionMonth == month) {
                result += bankTransaction.getAmount();
            }
        }
        return result;
    }

    public double calculateTotalForCategory(final String category) {
        double result = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            String description = bankTransaction.getDescription();

            if (description.equals(category)) {
                result += bankTransaction.getAmount();
            }
        }
        return result;
    }

    /**
     * OCP 를 적용하여 리팩토링한 코드 - 권장
     */
    public List<BankTransaction> findTransaction(BankTransactionFilter filter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if (filter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
}
