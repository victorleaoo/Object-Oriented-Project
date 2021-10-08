package pacoteTestes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import controle.ControleSapato;
import controle.ControleCliente;
import controle.ControleFunc;

/**
 * Pacote com os testes unit�rios. Teste de m�todos relacionados ao CRUD das classes, uma vez que s�o cruciais para o funcionamento do Software (boa parte dele � rodeado por esses):
 * (1) crUd: Teste do m�todo de edi��o. Foi usado o da classe ControleSapato, j� que possui uma grande variedade de atributos, mas a l�gica desse m�todo � a mesma para as outras classes. Al�m disso, o cadastro (C de CRUD), tamb�m tem uma din�mica parecida a desse m�todo.
 * (2) cruD: Teste do m�todo de remo��o. Foi usado o da classe ControleCliente, mas para todas as classes, a ideia do m�todo � a mesma.
 * @author Victor Le�o
 * @version 1.0 (Out. 2021)
 */
class TesteCRUD {
	
	ControleSapato s = new ControleSapato();
	ControleCliente c = new ControleCliente();
	ControleFunc f = new ControleFunc(); 
	
	@Test
	void testEditar() {
		String[] teste1 = {"1", "Sapato 1", "Marca 1", "C", "1000.00", "37.0", "40.0", "T�nis casual, marca 1", "25", "imagens/airjordan-obsidian.jpg"};
		String[] teste2 = {"2", "Sapato 2", "Marca 2", "S", "-5000.00", "10.0", "40.0", "T�nis kine, marca 2", "50", "imagens/slx-rider.jpg"};
		String[] teste3 = {"3", "Sapato 3", "Marca 3", "K", "1000.00", "37.0", "40.0", "T�nis casual, marca 1", "25", "imagens/dunk-brazil.png"};
		assertEquals(true, s.editar(teste1));
		assertEquals(false, s.editar(teste2));
		assertEquals(false, s.editar(teste3));
	}

	@Test
	void testRemover() {
		assertTrue(c.remover(0));
		assertFalse(c.remover(10));
	}

	
	@Test
	void testGetNomeFuncs() {
		String[] funcs = {"Jorge", "Yure", "Daniel"}; 
		assertEquals(funcs, f.getNomeFuncs());
	}
}
