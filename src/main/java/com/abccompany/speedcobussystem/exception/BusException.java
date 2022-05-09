package com.abccompany.speedcobussystem.exception;

import java.text.MessageFormat;

public class BusException extends RuntimeException {
    public BusException(Long busId) {
        super(MessageFormat.format("Bus dose not does not found for {id} this id.",busId));
    }
}
