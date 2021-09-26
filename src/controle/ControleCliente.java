package controle;

import modelo.Cliente;

public class ControleCliente extends ControleDados {

	private Cliente[] cli;
	private int qtdClientes;
	
	public ControleCliente() {
		super();
		cli = this.getClientes();
		this.setQtd(qtdeClientes());		
	}
	
	private int qtdeClientes() {
		int count = -1;
		for(int i = 0; i < cli.length; i++) {
			if(cli[i] == null) {
				break;
			}
			count = i+1;
		}
		return count;
	}
	public String[] getNomeClientes() {
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
	
	public boolean editarCliente(String[] dadosCliente) {
		Cliente c = new Cliente(dadosCliente[1], dadosCliente[2], dadosCliente[3], dadosCliente[4]);
		d.inserirEditaCliente(c, Integer.parseInt(dadosCliente[0]));
		return true;
	}

	public boolean inserirCliente(String[] dadosCliente) {
		if(editarCliente(dadosCliente)) {
			setQtd(getQtd()+1);			
		}
		return true;
	}

	public boolean removerCliente(int i) {
		if(i > getQtd()) {
			return false;
		}
		
		String clienteRemovido = d.getdClientes()[i].getNome();
		
		
		if(i == (getQtd() -1)) { //Se o cliente a ser removido está no final do array
			d.getdClientes()[getQtd()] = null;
			setQtd(getQtd() -1);
			return true;
		} else {
			int cont = 0;
			while(d.getdClientes()[cont].getNome().compareTo(clienteRemovido) != 0) {
				cont++;
			} 
			
			for (int j = cont; j < getQtd() - 1; j++) {
				d.getdClientes()[j] = null;
				d.getdClientes()[j] = d.getdClientes()[j+1];
			}
			d.getdClientes()[getQtd()] = null;
			setQtd(getQtd() - 1);
			return true;
		}
	}
	
}
