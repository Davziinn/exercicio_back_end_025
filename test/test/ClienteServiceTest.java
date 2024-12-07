package test;

import dao.IClienteDAO;
import dao.exceptions.TipoChaveNaoEncontradaException;
import domain.Cliente;
import mock.ClienteDAOMock;
import org.junit.*;
import services.ClienteService;
import services.IClienteService;

public class ClienteServiceTest {
    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Davi");
        cliente.setCidade("Fortaleza");
        cliente.setEnd("End");
        cliente.setEstado("CE");
        cliente.setNumero(140);
        cliente.setTel(8598258274L);
    }

    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente () {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("David");
        clienteService.alterar(cliente);
        Assert.assertEquals("David", cliente.getNome());

    }
}
