package br.senac.sp.archetype.hexagonal.core.exceptions;

public class ClienteNaoEcontradoException extends RuntimeException {
    public ClienteNaoEcontradoException(String message) {
        super(message);
    }
}
