//package br.senac.sp.archetype.hexagonal.core.usecase.impl;
//
//import br.senac.sp.archetype.hexagonal.core.domain.Cliente;
//import br.senac.sp.archetype.hexagonal.core.domain.Clientes;
//import br.senac.sp.archetype.hexagonal.core.exceptions.ClienteNaoEcontradoException;
//import br.senac.sp.archetype.hexagonal.core.usecase.ClienteUseCase;
//import br.senac.sp.archetype.hexagonal.core.gateway.database.ClienteGateway;
//import br.senac.sp.archetype.hexagonal.core.gateway.client.ClienteWebData;
//import br.senac.sp.archetype.hexagonal.dataprovider.database.gateway.ClienteGatewayImpl;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class ClienteUseCaseImpl implements ClienteUseCase {
//
//    private final ClienteGateway clienteGateway;
//    private final ClienteWebData clienteWebData;
//
//    public ClienteUseCaseImpl(final ClienteGatewayImpl clienteGateway,
//                              final ClienteWebData clienteWebData) {
//        this.clienteGateway = clienteGateway;
//        this.clienteWebData = clienteWebData;
//    }
//
//    @Override
//    public Cliente getClienteById(String id) {
//        Optional<Cliente> clienteOptional = clienteGateway.findById(id);
//        return clienteOptional.orElseThrow(() -> new ClienteNaoEcontradoException("Cliente nao encontrado"));
//    }
//
//    @Override
//    public Clientes getClientesFromWeb() {
//        return clienteWebData.getAllWeb();
//    }
//
//    @Override
//    public void criarCliente(Cliente cliente) {
//        clienteGateway.criarCliente(cliente);
//    }
//
//    @Override
//    public Clientes getTodosClientesDB() {
//        return clienteGateway.findAllDatabase();
//    }
//
//}