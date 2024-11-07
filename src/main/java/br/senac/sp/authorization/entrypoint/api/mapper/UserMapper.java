package br.senac.sp.authorization.entrypoint.api.mapper;


import br.senac.sp.authorization.core.domain.UserDomain;
import br.senac.sp.authorization.entrypoint.api.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {
//        UserDomain.class,
//        UserRequest.class
//})
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDomain toUserDomain(UserRequest request);

    UserRequest toUserRequest(UserDomain tokenDomain);


}
