package br.senac.sp.authorization.entrypoint.api.controller;

import br.senac.sp.archetype.hexagonal.core.domain.Cliente;
import br.senac.sp.archetype.hexagonal.core.domain.Clientes;
import br.senac.sp.archetype.hexagonal.core.usecase.ClienteUseCase;
import br.senac.sp.authorization.entrypoint.api.dto.ClienteDTO;
import br.senac.sp.authorization.entrypoint.api.dto.ClientesDTO;
import br.senac.sp.authorization.core.usecase.TokenUseCase;
import br.senac.sp.authorization.entrypoint.api.mapper.TokenMapper;
import br.senac.sp.authorization.entrypoint.api.mapper.UserMapper;
import br.senac.sp.authorization.entrypoint.api.request.TokenRequest;
import br.senac.sp.authorization.entrypoint.api.request.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth-token")
public class TokenController {

//    private final ClienteUseCase clienteUseCase;
    private final TokenUseCase tokenUseCase;

    public TokenController(final TokenUseCase tokenUseCase){
        this.tokenUseCase = tokenUseCase;
    }


    @PostMapping("/generate")
    public ResponseEntity<String> generateToken(@Valid @RequestBody UserRequest request) {
        String token = tokenUseCase.generate(UserMapper.INSTANCE.toUserDomain(request));
        return ResponseEntity.ok(token);
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestHeader(name = "token") String token) {
        tokenUseCase.validate(TokenMapper.INSTANCE.toTokenDomain(token));
        return ResponseEntity.ok("ok");
    }

//
//    @GetMapping("/{id}")
//    public ResponseEntity<ClienteDTO> getCliente(@PathVariable String id) {
//        var cliente = clienteUseCase.getClienteById(id);
//        return ResponseEntity.ok(br.senac.sp.archetype.hexagonal.entrypoint.api.mapper.TokenMapper.INSTANCE.toClienteDTO(cliente));
//    }
//
//    @GetMapping("/web")
//    public ResponseEntity<ClientesDTO> getClientesWeb() {
//        Clientes clientes = clienteUseCase.getClientesFromWeb();
//
//        List<ClienteDTO> clientesDto = clientes.getClientes().stream()
//                .map(br.senac.sp.archetype.hexagonal.entrypoint.api.mapper.TokenMapper.INSTANCE::toClienteDTO)
//                .toList();
//
//        var clientesDTO = new ClientesDTO();
//        clientesDTO.setClientesDTO(clientesDto);
//        return ResponseEntity.ok(clientesDTO);
//    }
//
//
//    @PostMapping("/criar")
//    public ResponseEntity<Void> criarCliente(@RequestBody ClienteDTO clienteDTO) {
//        Cliente cliente = br.senac.sp.archetype.hexagonal.entrypoint.api.mapper.TokenMapper.INSTANCE.toCliente(clienteDTO);
//        clienteUseCase.criarCliente(cliente);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    @GetMapping("/todos-db")
//    public ResponseEntity<ClientesDTO> getClientesDb() {
//        Clientes clientes = clienteUseCase.getTodosClientesDB();
//
//        List<ClienteDTO> clientesDto = clientes.getClientes().stream()
//                .map(br.senac.sp.archetype.hexagonal.entrypoint.api.mapper.TokenMapper.INSTANCE::toClienteDTO)
//                .toList();
//
//        var clientesDTO = new ClientesDTO();
//        clientesDTO.setClientesDTO(clientesDto);
//        return ResponseEntity.ok(clientesDTO);
//    }

}