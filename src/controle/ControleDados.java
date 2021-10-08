package controle;

import modelo.Dados;
import modelo.Model;

/**
 * Classe de controle da classe Dados, sendo pai das outras classes de Controle. Possui os métodos abstratos responsáveis pelo CRUD das classes. 
 * @author Victor Leão
 * @version 1.0 (Out. 2021)
 */
public abstract class ControleDados {
	private Dados d = new Dados();
	
	/**
	 * Método que retorna os dados.
	 * @return Dados
	 */
	public Dados getDados() {
		return d;
	}

	/**
	 * Métodos que serão destrinchados em cada uma das outras classes de Controle:
	 * (1) getLista -> Relacionado ao R de CRUD;
	 * (2) inserir  -> Relacionado ao C de CRUD;
	 * (3) editar   -> Relacionado ao U de CRUD; 
	 * (4) remover  -> Relacionado ao D de CRUD;
	 */
	public abstract Model[] getLista();
	public abstract boolean inserir(String[] dados);
	public abstract boolean editar(String[] dados);
	public abstract boolean remover(int i);
	
	/**
	 * Método que conta a quantidade de elementos de uma classe estão cadastrados.
	 * @param lista -> Array contendo os objetos instanciados de uma classe.
	 * @return int -> Quantidade.
	 */
	protected int getQtdeLista(Model[] lista) {
		int count = -1;
		for(int i = 0; i < lista.length; i++) {
			if(lista[i] == null) {
				break;
			}
			count = i+1;
		}
		return count;
	}
}
