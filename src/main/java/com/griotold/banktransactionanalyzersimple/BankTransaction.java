package com.griotold.banktransactionanalyzersimple;

import lombok.*;

import java.time.LocalDate;

/**
 * 입출금 내역 도메인 클래스
 * */
@RequiredArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode
public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

}
