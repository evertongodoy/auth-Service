package br.senac.sp.authorization.dataprovider;

import br.senac.sp.authorization.core.domain.TokenDomain;
import br.senac.sp.authorization.core.domain.UserDomain;
import br.senac.sp.authorization.core.gateway.TokenGateway;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class TokenGatewayImpl implements TokenGateway {

    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);//.HS512);
//    private static final String SECRET_KEY = "password_seuro";

    // Chave secreta (deve ter pelo menos 512 bits)
    String secretKey = "SuaChaveSecretaMuitoSeguraComMaisDe512BitsExemplo123456789012345678901234567890";

    // Chave secreta gerada automaticamente
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private Key secretKey2;


    private final String secretKey3 = "MinhaChaveSecretaSuperSegura123456!"; // Use uma chave forte
    private final Key key3 = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    // Inicializa a chave secreta
    @PostConstruct
    public void init() {
        // Você pode carregar a chave de um arquivo de propriedades ou ambiente
        // Aqui estamos gerando uma chave aleatória para exemplo
        this.secretKey2 = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }


    private static final long EXPIRATION_TIME = 1 * 60 * 1000; // 1 minuto

    @Override
    public String generate(final UserDomain userDomain) {
//        return Jwts.builder()
//                .setSubject(userDomain.getPhoneNumber())  // Assunto do token (pode ser o ID do usuário)
//                .setIssuer("auth-service") // Quem emitiu o token
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
//                .compact();

    //segunda versao
        return Jwts.builder()
                .setSubject(userDomain.getPhoneNumber()) // ID do usuário ou algo identificável
                .setIssuer("auth-service") // Identificação do emissor
                .setIssuedAt(new Date()) // Data de emissão
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))  //3600000)) // Expira em 1 hora
                .claim("role", "normal-user") // Custom claim (papel do usuário)
                .signWith(secretKey2) // Assinatura HMAC
                .compact();

    }

    @Override
    public String validate(TokenDomain tokenDomain) {
        try {
            var x = Jwts.parserBuilder().setSigningKey(secretKey2).build().parseClaimsJws(tokenDomain.getToken());
            return "true";
        } catch (ExpiredJwtException e) {
            System.out.println("Token expirado!");
        } catch (JwtException e) {
            System.out.println("Token inválido!");
        }
        return "false";
    }

}
