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
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public static void main(final String... args) throws IOException {

        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in Feburary is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
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
