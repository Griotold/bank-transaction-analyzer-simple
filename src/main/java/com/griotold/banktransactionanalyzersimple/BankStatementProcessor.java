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
     * 아래 코드는 동작은 하지만 문제가 있는 코드다.
     * 개방/폐쇄 원칙을 적용해서 리팩토링 해야 한다.
     * */
    public List<BankTransaction> findTransactionGreaterThanEqual(final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getAmount() >= amount) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
}
