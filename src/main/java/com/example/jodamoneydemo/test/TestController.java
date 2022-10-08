package com.example.jodamoneydemo.test;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Random;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    /**
     *
     * @return
     */
    @GetMapping("/getCoffee")
    public Coffee readMenu() {
        return Coffee.builder().id(new Random().nextLong())
                .price(Money.of(CurrencyUnit.of("CNY"),
                        //也可以使用：org.apache.commons.lang3.math.NumberUtils#createBigDecimal
                        NumberUtils.parseNumber("100", BigDecimal.class)))
                .build();
    }
}
