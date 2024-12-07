package test;

import dao.IClienteDAO;
import dao.exceptions.TipoChaveNaoEncontradaException;
import domain.Cliente;
import mock.ClienteDAOMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {
    private IClienteDAO clienteDAO;

    private Cliente cliente;

    public ClienteDAOTest () {
        clienteDAO = new ClienteDAOMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Davi");
        cliente.setCidade("Fortaleza");
        cliente.setEnd("End");
        cliente.setEstado("CE");
        cliente.setNumero(140);
        cliente.setTel(8598258274L);

        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteDAO.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteDAO.excluir(cliente.getCpf());
    }


    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("David");
        clienteDAO.alterar(cliente);

        Assert.assertEquals("David", cliente.getNome());
    }
}
