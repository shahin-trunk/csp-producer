package com.trunk.csp.document;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CarServiceProvider {
    private String message;
    private Integer identifier;
}
