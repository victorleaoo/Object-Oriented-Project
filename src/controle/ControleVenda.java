package controle;

import java.util.List;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.ItensVenda;
import modelo.Venda;

public class ControleVenda {

	private Venda[] vnd;
	private int qtdVendas;
	
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
	
}
