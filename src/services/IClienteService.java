package services;

import dao.exceptions.TipoChaveNaoEncontradaException;
import domain.Cliente;

public interface IClienteService {
    Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCpf(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
