package com.lc.cloud.alibaba.consumer.controllers;

import com.lc.cloud.alibaba.consumer.domain.service.SeataTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class MoneyAccountController {

    @Autowired
    SeataTestService seataTestService;

    /**
     * http://localhost:8081/account/query_available/1
     * http://localhost:8081/account/query_out/1
     * http://localhost:8081/account/add/1?addAmount=100.00
     * http://localhost:8081/account/use/1?useAmount=10.00
     */
    @GetMapping("query_available/{id}")
    public BigDecimal queryAvailableAmount(@PathVariable Long id) {
        return seataTestService.queryAvailableAmount(id);
    }

    @GetMapping("query_out/{id}")
    public BigDecimal queryOutAmount(@PathVariable Long id) {
        return seataTestService.queryOutAmount(id);
    }

    @GetMapping("add/{id}")
    public BigDecimal add(@PathVariable Long id,
                          @RequestParam BigDecimal addAmount) {
        return seataTestService.add(addAmount, id);
    }

    @GetMapping("use/{id}")
    public BigDecimal use(@PathVariable Long id,
                          @RequestParam BigDecimal useAmount) {
        return seataTestService.use(useAmount, id);
    }
}