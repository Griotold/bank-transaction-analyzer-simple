package com.griotold.banktransactionanalyzersimple;

import java.util.List;

/**
 * 결합도를 낮추는 방법 - 구현에 의존하지 않고 역할에 의존한다.
 */
public interface BankStatementParser {
    BankTransaction parseFrom(String line);

    List<BankTransaction> parseLinesFrom(List<String> lines);
}
