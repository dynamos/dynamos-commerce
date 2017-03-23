package br.com.dynamos.infra.exceptions;

/**
 * Created by Adelmo Alves on 09/01/2017.
 */
public class NotFoundException extends Exception {

    public NotFoundException() {
        super("Resource not found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}