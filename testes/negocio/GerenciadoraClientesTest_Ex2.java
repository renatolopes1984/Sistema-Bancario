package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GerenciadoraClientesTest_Ex2 {

	private GerenciadoraClientes gerClientes;

	@Test
	public void testPesquisaCliente() {
		//CRIANDO ALGUNS CLIENTES
		Cliente cliente01 = new Cliente(1, "Renato Lopes", 40, "renato.lopes1984@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Vinicius Castro", 36, "vini@gmail.com", 1, true);
		
		//INSERINDO CLIENTES CRIADOS NA LISTA DE CLIENTES DO BANCO:
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		//INVOCANDO O MÉTODO DE PESQUISA DE CLIENTES
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		//assertThat == AFIRMANDO QUE O CLIENTE PESQUISADO É DE id 1 COM O E-MAIL ABAIXO
		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getEmail(), is("renato.lopes1984@gmail.com"));
		
		//assertEquals == TAMBÉM AFIRMA QUE OS ATRIBUTOS SÃO ESSES
		Assert.assertEquals(1, cliente.getId());
		Assert.assertEquals("renato.lopes1984@gmail.com", cliente.getEmail());
		
	}
	
	@Test
	public void testRemoveCliente() {
		//CRIANDO ALGUNS CLIENTES
		Cliente cliente01 = new Cliente(1, "Renato Lopes", 40, "renato.lopes1984@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Vinicius Castro", 36, "vini@gmail.com", 1, true);
		
		//INSERINDO CLIENTES CRIADOS NA LISTA DE CLIENTES DO BANCO:
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		//CHAMANDO MÉTODO A SER TESTADO removeCLiente()
		boolean clienteRemovido = gerClientes.removeCliente(2);
		
		// VERIFIQUE (AFIRME) QUE O CLIENTE FOI REMOVITO (O RETORNO DO MÉTODO DE REMOÇÃO É TRUE PARA SIM, OU FALSE PARA NÃO)
		assertThat(clienteRemovido, is(true));
		// VERIFIQUE (AFIRME) QUE A QUANTIDADE DE CLIENTES NO BANCO É 1
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		// VERIFIQUE SE O MÉTODO DE PESQUISA CLIENTE COM ID 2, RETORNARÁ NULL
		assertNull(gerClientes.pesquisaCliente(2));
		
	}
	

}
