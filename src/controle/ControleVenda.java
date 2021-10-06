package controle;

import java.util.ArrayList;
import java.util.List;


import modelo.Cliente;
import modelo.Funcionario;
import modelo.ItensVenda;
import modelo.Venda;

public class ControleVenda extends ControleDados {
	
	private Venda[] vnd;
	private int qtdVendas;
	
	public ControleVenda() {
		super();
		vnd = this.getLista();
		this.setQtd(super.getQtdeLista(vnd));
	}
	
	@Override
	public Venda[] getLista() {
		return super.getDados().getdVendas();
	}
	
	public String[] getNomeVendas() {
		String[] v = new String[qtdVendas];
		for(int i = 0; i < qtdVendas; i++) {
			v[i] = vnd[i].getF().getNome() + " - Funcionário           " + vnd[i].getC().getNome() + " - Cliente           - ID: " + vnd[i].getID();
		}
		
		return v;
	}
	
	public String[] getNomeItens(List<ItensVenda> sapatos) {
		String[] s = new String[sapatos.size()];
		for(int i = 0; i < sapatos.size(); i++) {
			s[i] = sapatos.get(i).getS().getNomeSapato();
		}		
		return s;
	}
	
	public int getQtd() {
		return qtdVendas;
	}

	public void setQtd(int qtd) {
		this.qtdVendas = qtd;
	}
	
	public Cliente getCliente(int i) {
		return vnd[i].getC();
	}
	
	public Funcionario getFuncionario(int i) {
		return vnd[i].getF();
	}
	
	public char getMetPag(int i) {
		return vnd[i].getMetPag();
	}
	
	public List<ItensVenda> getItens(int i){
		return vnd[i].getSapatos();
	}
	
	public int getIDVenda(int i) {
		return vnd[i].getID();
	}

	@Override
	public boolean inserir(String[] dadosVenda) {		
		if(editar(dadosVenda)) {
			setQtd(getQtd()+1);			
		}
		return true;
	}

	@Override
	public boolean editar(String[] dadosVenda) {
		Funcionario funcVenda = null;
		for(Funcionario func : getDados().getdFuncs()) {
			if(dadosVenda[2].equals(func.getNome())) {
				funcVenda = func;
				break;
			}
		}
		Cliente clienteVenda = null;
		for(Cliente cli : getDados().getdClientes()) {
			if(dadosVenda[3].equals(cli.getNome())) {
				clienteVenda = cli;
				break;
			}
		}
		
		if(Servicos.validaMetPag(dadosVenda[1].charAt(0))){
			Venda v = new Venda(dadosVenda[1].charAt(0), funcVenda, clienteVenda, Integer.valueOf(dadosVenda[4]));
			getDados().inserirEditaVenda(v, Integer.parseInt(dadosVenda[0]));
			return true;
		}
		
		return false;

	}

	@Override
	public boolean remover(int i) {
		if(i > getQtd()) {
			return false;
		}

		vnd = getDados().getdVendas();
		int vendaRemovida = vnd[i].getID();
		
		if(i == (getQtd() -1)) { //Se o funcionário a ser removido está no final do array
			vnd[i] = null;
			setQtd(getQtd() -1);
			return true;
		} 
		
		int cont = 0;
		while(String.valueOf(vnd[cont].getID()).compareTo(String.valueOf(vendaRemovida)) != 0) {
			cont++;
		} 
		
		for (int j = cont; j < getQtd() - 1; j++) {
			vnd[j] = vnd[j+1];
		}
		vnd[getQtd()] = null;
		setQtd(getQtd() - 1);
		return true;
	}
	
}
