package principal;

import java.util.List;

public class Venda {

	//Atributos
	private int qntdVenda;
	private char metPag; // 'C'/'c' para Cartão - 'B'/'b' para Boleto - 'P'/'p' para Pix
	private Funcionario f;
	private Cliente c; 
	private Sapato[] s = new Sapato[100];
	
	//Construtor
	public Venda(int qtdV, char mP, Funcionario fun, Cliente cli, Sapato[] sap) {
		qntdVenda = qtdV;
		metPag = mP;
		f = fun;
		c = cli;
		s = sap;
	}
	
	//Gets e Sets
	public int getQntdVenda() {
		return qntdVenda;
	}
	public void setQntdVenda(int qntdVenda) {
		this.qntdVenda = qntdVenda;
	}
	
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

	public Sapato[] getS() {
		return s;
	}
	public void setS(Sapato[] s) {
		this.s = s;
	}

	// Listar Vendas cadastradas
	public static void listaVendas(List<Venda> lista) {
		System.out.println("------------- Lista de Vendas -------------\n");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("Quantidade Vendida:\t" + lista.get(i).getQntdVenda() + "\n" +
							   "Método de Pagamento:\t" + lista.get(i).getMetPag() + "\n" +
							   "Funcionário que Vendeu:\t" + lista.get(i).getF().getNome() + "\n" +
							   "Cliente Comprador:\t" + lista.get(i).getC().getNome() + "\n\n");
		}
	}
	
	// Alterar Venda cadastrada
	public static void alterarVenda(Venda v, int novaQntd, char novoMet, Funcionario novoFunc, Cliente novoCli, Sapato[] novoSap) {
		v.setQntdVenda(novaQntd);
		v.setMetPag(novoMet);
		v.setF(novoFunc);
		v.setC(novoCli);
		v.setS(novoSap);
	}
	
}
