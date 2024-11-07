package br.senac.sp.authorization.entrypoint.api.mapper;

import br.senac.sp.authorization.core.domain.TokenDomain;
import br.senac.sp.authorization.entrypoint.api.request.TokenRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {
//        TokenDomain.class,
//        TokenRequest.class
//})
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TokenMapper {

    TokenMapper INSTANCE = Mappers.getMapper(TokenMapper.class);

    TokenDomain toTokenDomain(String token);



}
