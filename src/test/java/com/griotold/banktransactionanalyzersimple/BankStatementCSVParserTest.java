package com.griotold.banktransactionanalyzersimple;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class BankStatementCSVParserTest {
    private final BankStatementParser parser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        final String line = "30-01-2017,-50,Tesco";

        final BankTransaction result = parser.parseFrom(line);

        BankTransaction expected
                = new BankTransaction(
                LocalDate.of(2017, Month.JANUARY, 30),
                -50,
                "Tesco");

        final double tolerance = 0.0d;

        assertThat(result.getDate()).isEqualTo(expected.getDate());
        assertThat(result.getAmount()).isCloseTo(expected.getAmount(), within(tolerance));
        assertThat(result.getDescription()).isEqualTo(expected.getDescription());
    }
}