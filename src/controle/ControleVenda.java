package controle;

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
			v[i] = vnd[i].getC().getNome() + " - Venda feita por: " + vnd[i].getF().getNome();
		}
		
		return v;
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


	@Override
	public boolean inserir(String[] dados) {
		
		return false;
	}

	@Override
	public boolean editar(String[] dados) {
		
		return false;
	}

	@Override
	public boolean remover(int i) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
