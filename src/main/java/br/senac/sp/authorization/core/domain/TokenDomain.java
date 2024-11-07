package br.senac.sp.authorization.core.domain;

public class TokenDomain {

    private String token;

    public String getToken() {
        return token;
    }

    public TokenDomain setToken(String token) {
        this.token = token;
        return this;
    }
}
