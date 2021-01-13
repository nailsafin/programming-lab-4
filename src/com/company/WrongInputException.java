package com.company;

import java.io.IOException;

public class WrongInputException extends Exception {
    WrongInputException(String message) {
        super(message);
    }
}
