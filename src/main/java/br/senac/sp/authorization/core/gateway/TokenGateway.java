package br.senac.sp.authorization.core.gateway;

import br.senac.sp.authorization.core.domain.TokenDomain;
import br.senac.sp.authorization.core.domain.UserDomain;

public interface TokenGateway {

    String generate(final UserDomain userDomain);
    String validate(final TokenDomain tokenDomain);
}
