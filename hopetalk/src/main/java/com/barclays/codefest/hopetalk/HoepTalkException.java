package com.barclays.codefest.hopetalk;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class HoepTalkException extends RuntimeException{

    public HoepTalkException(String message) {
        super(message);
    }

    public HoepTalkException(String message, Throwable cause) {
        super(message, cause);
    }

}
