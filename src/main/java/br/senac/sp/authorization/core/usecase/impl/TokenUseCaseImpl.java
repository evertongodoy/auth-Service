package br.senac.sp.authorization.core.usecase.impl;

import br.senac.sp.authorization.core.domain.TokenDomain;
import br.senac.sp.authorization.core.domain.UserDomain;
import br.senac.sp.authorization.core.gateway.TokenGateway;
import br.senac.sp.authorization.core.usecase.TokenUseCase;
import org.springframework.stereotype.Service;

@Service
public class TokenUseCaseImpl implements TokenUseCase {

    private final TokenGateway tokenGateway;

    public TokenUseCaseImpl(TokenGateway tokenGateway){
        this.tokenGateway = tokenGateway;
    }

    @Override
    public String generate(final UserDomain userDomain) {
        return this.tokenGateway.generate(userDomain);
    }

    @Override
    public String validate(TokenDomain tokenDomain) {
        return tokenGateway.validate(tokenDomain);
    }

}
