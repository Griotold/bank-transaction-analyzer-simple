package com.griotold.banktransactionanalyzersimple;

import java.io.IOException;

public class MainApplication {
    public static void main(final String... args) {
        BankTransactionAnalyzerSimple bankTransactionAnalyzer = new BankTransactionAnalyzerSimple();

        BankStatementParser parser = new BankStatementCSVParser();

        try {
            bankTransactionAnalyzer.analyze(args[0], parser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
