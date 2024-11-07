package br.senac.sp.archetype.hexagonal.core.usecase;

import br.senac.sp.archetype.hexagonal.core.domain.Cliente;
import br.senac.sp.archetype.hexagonal.core.domain.Clientes;

public interface ClienteUseCase {

    Cliente getClienteById(String id);

    Clientes getClientesFromWeb();

    void criarCliente(Cliente cliente);

    Clientes getTodosClientesDB();

}