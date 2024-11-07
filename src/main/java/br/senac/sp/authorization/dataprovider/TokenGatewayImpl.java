package br.senac.sp.authorization.dataprovider;

import br.senac.sp.authorization.core.domain.TokenDomain;
import br.senac.sp.authorization.core.domain.UserDomain;
import br.senac.sp.authorization.core.gateway.TokenGateway;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class TokenGatewayImpl implements TokenGateway {

    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);//.HS512);
//    private static final String SECRET_KEY = "password_seuro";

    // Chave secreta (deve ter pelo menos 512 bits)
    String secretKey = "SuaChaveSecretaMuitoSeguraComMaisDe512BitsExemplo123456789012345678901234567890";

    private static final long EXPIRATION_TIME = 1 * 60 * 1000; // 1 minuto

    @Override
    public String generate(final UserDomain userDomain) {
        return Jwts.builder()
                .setSubject(userDomain.getPhoneNumber())  // Assunto do token (pode ser o ID do usuário)
                .setIssuer("auth-service") // Quem emitiu o token
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();
    }

    @Override
    public String validate(TokenDomain tokenDomain) {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey.getBytes())
                    .parseClaimsJws(tokenDomain.getToken())
                    .getBody();
        } catch (ExpiredJwtException e) {
            System.out.println("Token expirado: " + e.getMessage());
            return false;
        } catch (SignatureException e) {
            System.out.println("Assinatura do Token inválida: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Token inválido: " + e.getMessage());
            return false;
        }
    }

}
