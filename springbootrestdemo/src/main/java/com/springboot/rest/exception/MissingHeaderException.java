package com.springboot.rest.exception;

/**
 * @author Murali
 *
 */
public class MissingHeaderException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public MissingHeaderException(String exception) {
        super(exception);
    }
}
