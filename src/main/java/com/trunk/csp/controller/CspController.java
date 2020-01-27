package com.trunk.csp.controller;

import com.trunk.csp.document.CarServiceProvider;
import com.trunk.csp.service.CspProduceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CspController {

    private final CspProduceService cspProduceService;

    @PostMapping("/csp/add")
    public void addCsp(@RequestBody CarServiceProvider carServiceProvider) {
        cspProduceService.produce(carServiceProvider);
    }

}
