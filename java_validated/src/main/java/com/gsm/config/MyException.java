package com.gsm.config;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyException extends RuntimeException {
    private String msg;
}
