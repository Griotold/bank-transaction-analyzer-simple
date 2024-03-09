package com.griotold.banktransactionanalyzersimple;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 요약 정보를 저장하는 도메인 객체
 * */
@Getter
@RequiredArgsConstructor
public class SummaryStatistics {
    private final double sum;
    private final double max;
    private final double min;
    private final double average;
}
