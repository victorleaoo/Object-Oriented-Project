package controle;

import modelo.*;

public abstract class ControleDados {
	private Dados d = new Dados();
	
	public Dados getDados() {
		return d;
	}

	// CRUD 
	public abstract Model[] getLista();  // cRud - Read
	public abstract boolean inserir(String[] dados);  // Crud - create
	public abstract boolean editar(String[] dados);  // crUd - Update
	public abstract boolean remover(int i); // cruD - Delete
	
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
