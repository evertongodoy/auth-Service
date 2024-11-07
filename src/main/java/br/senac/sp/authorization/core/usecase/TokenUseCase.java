package br.senac.sp.authorization.core.usecase;

import br.senac.sp.authorization.core.domain.TokenDomain;
import br.senac.sp.authorization.core.domain.UserDomain;

public interface TokenUseCase {

    String generate(final UserDomain userDomain);

    String validate(final TokenDomain tokenDomain);

}
