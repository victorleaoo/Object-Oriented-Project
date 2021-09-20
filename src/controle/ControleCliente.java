package controle;

import modelo.Cliente;

public class ControleCliente {

	private Cliente[] cli;
	private int qtdClientes;
	
	public String[] getNomeSpts() {
		String[] s = new String[qtdClientes];
		for(int i = 0; i < qtdClientes; i++) {
			s[i] = cli[i].getNome();
		}
		
		return s;
	}
	
	public int getQtd() {
		return qtdClientes;
	}

	public void setQtd(int qtd) {
		this.qtdClientes = qtd;
	}
	
	public String getNome(int i) {		
		return cli[i].getNome();
	}
	
	public String getTelefone(int i) {
		return cli[i].getTelefone();
	}
	
	public String getEmail(int i) {
		return cli[i].getEmail();
	}
	
	public String getEndereco(int i) {
		return cli[i].getEndCliente();
	}
	
}
