package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraContasTest_Ex3 {

	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor() {

		/* ========== MONTAGEM DO CENÁRIO ========== */
		
		// CRIANDO ALGUMAS CONTAS
		ContaCorrente conta01 = new ContaCorrente(1, 200, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		
		// INSERINDO AS CONTAS CRIADAS NA LISTA DE CONTAS DO BANCO
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
				
		// INSTANCIANDO A CLASSE QUE TEM O MÉTODO QUE QUEREMOS TESTAR.
		gerContas = new GerenciadoraContas(contasDoBanco);

		/* ========== EXECUÇÃO  ========== */
		gerContas.transfereValor(1, 100, 2);
		
		/* ========== VERIFICAÇÕES ========== */
		assertThat(conta02.getSaldo(), is(100.0));
		assertThat(conta01.getSaldo(), is(100.0));
	}

}
