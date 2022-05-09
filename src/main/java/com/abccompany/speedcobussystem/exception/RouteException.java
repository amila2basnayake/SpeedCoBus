package com.abccompany.speedcobussystem.exception;

import java.text.MessageFormat;

public class RouteException extends RuntimeException {
    public RouteException(Long id) {
        super(MessageFormat.format("Route does not found for {id} this id.",id));
    }
}
