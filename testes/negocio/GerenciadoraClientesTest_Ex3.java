package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest_Ex3 {

	private GerenciadoraClientes gerClientes;

	@Test
	public void testPesquisaCliente() {

		/* ========== MONTAGEM DO CENÁRIO ========== */
		
		// criando alguns clientes
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		// INSTANCIANDO A CLASSE QUE TEM O MÉTODO QUE QUEREMOS TESTAR.
		gerClientes = new GerenciadoraClientes(clientesDoBanco);

		/* ========== EXECUÇÃO ========== */
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		/* ========== VERIFICAÇÕES ========== */
		assertThat(cliente.getId(), is(1));
		
	}
	
	@Test
	public void testRemoveCliente() {

		/* ========== MONTAGEM DO CENÁRIO ========== */
		
		// criando alguns clientes
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		// INSTANCIANDO A CLASSE QUE TEM O MÉTODO QUE QUEREMOS TESTAR.
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/* ========== EXECUÇÃO ========== */
		boolean clienteRemovido = gerClientes.removeCliente(2);
		
		/* ========== VERIFICAÇÕES ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
		
	}
	
}
