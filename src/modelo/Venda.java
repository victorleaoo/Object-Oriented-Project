package modelo;

import java.util.ArrayList;
import java.util.List;

public class Venda {

	//Atributos
	private char metPag; // 'C'/'c' para Cartão - 'B'/'b' para Boleto - 'P'/'p' para Pix
	private Funcionario f;
	private Cliente c; 
	private List<ItensVenda> sapatos;
	
	//Construtor
	public Venda(char mP, Funcionario fun, Cliente cli) {
		metPag = mP;
		f = fun;
		c = cli;
		sapatos = new ArrayList<>();
	}
	
	//Gets e Sets
	public char getMetPag() {
		return metPag;
	}
	public void setMetPag(char metPag) {
		this.metPag = metPag;
	}

	public Funcionario getF() {
		return f;
	}
	public void setF(Funcionario f) {
		this.f = f;
	}

	public Cliente getC() {
		return c;
	}
	public void setC(Cliente c) {
		this.c = c;
	}

	public List<ItensVenda> getSapatos() {
		return sapatos;
	}
	public void setSapatos(List<ItensVenda> sapatos) {
		this.sapatos = sapatos;
	}
	
	//Colocar um sapato a uma única venda.
	public void addItem(ItensVenda s) {
		sapatos.add(s);
	}
	
	//Alterar uma venda
	public static void alterarVenda(Venda v, char mP, Funcionario func, Cliente cli) {
		v.setMetPag(mP);
		v.setF(func);
		v.setC(cli);
	}
	
	//Alterar quantidade vendida de uma venda
	public void alterarItem(ItensVenda s, int nQ) {
		for (ItensVenda itensVenda : sapatos) {
			if(itensVenda.equals(s)) {
				itensVenda.setQntdVenda(nQ);
			}
		}
	}
	
	//Apagar um sapato de uma lista
	public void deletarItem(ItensVenda s) {
		sapatos.remove(s);
	}
	
	public void listaItens() {
		System.out.println("---"+c.getNome()+"---");
		for (ItensVenda itensVenda : sapatos) {
			System.out.println(itensVenda.getS().getNomeSapato() + " - " + itensVenda.getQntdVenda());
		}
		System.out.println("-------------------------------------------------------");
	}
}
