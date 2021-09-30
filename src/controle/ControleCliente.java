package controle;

import modelo.Cliente;

public class ControleCliente extends ControleDados {

	private Cliente[] cli;
	private int qtdClientes;
	
	public ControleCliente() {
		super();
		cli = this.getLista();
		this.setQtd(super.getQtdeLista(cli));		
	}

	@Override
	public Cliente[] getLista() {	
		return super.getDados().getdClientes();
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
	
    @Override
	public boolean editar(String[] dadosCliente) {
		Cliente c = new Cliente(dadosCliente[1], dadosCliente[2], dadosCliente[3], dadosCliente[4]);
		getDados().inserirEditaCliente(c, Integer.parseInt(dadosCliente[0]));
		return true;
	}

	@Override
	public boolean inserir(String[] dadosCliente) {
		if(editar(dadosCliente)) {
			setQtd(getQtd()+1);			
		}
		return true;
	}

	@Override
	public boolean remover(int i) {
		if(i > getQtd()) {
			return false;
		}
		
		cli = this.getLista();
		String clienteRemovido = cli[i].getNome();
				
		if(i == (getQtd() -1)) { //Se o cliente a ser removido está no final do array
			cli[i] = null;
			setQtd(getQtd() -1);
			return true;
		}
		
		int cont = 0;
		while(cli[cont].getNome().compareTo(clienteRemovido) != 0) {
			cont++;
		} 
		
		for (int j = cont; j < getQtd() - 1; j++) {
			cli[j] = cli[j+1];
		}
		cli[getQtd()] = null;
		setQtd(getQtd() - 1);
		
		return true;
	}
}
