package com.griotold.banktransactionanalyzersimple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(final String... args) throws IOException {

        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);

        System.out.println("The total for all transaction is " + calculateTotalAmount(bankTransactions));

        System.out.println("Transaction in January " + selectInMonth(bankTransactions, Month.JANUARY));
    }

    private static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
        double result = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            result += bankTransaction.getAmount();
        }
        return result;
    }

    private static double selectInMonth(List<BankTransaction> bankTransactions, Month month) {
        double result = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            Month transactionMonth = bankTransaction.getDate().getMonth();
            if (transactionMonth == month) {
                result += bankTransaction.getAmount();
            }
        }
        return result;
    }

}
