package com.griotold.banktransactionanalyzersimple;

/**
 * 해당 인터페이스를 준수하는 다양한 내보내기 기능을 구현할 수 있다.
 */
public interface Exporter {
    // void 말고 String을 반환하면 여러 이점이 있다. p.63
    String export(SummaryStatistics summaryStatistics);
}
