package com.abccompany.speedcobussystem.exception;

import java.text.MessageFormat;

public class LineException extends RuntimeException {
    public LineException(Long id) {
        super(MessageFormat.format("Line does not found for {id} this id.",id));
    }
}
