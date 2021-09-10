package principal;

public class Venda {

	//Atributos
	private int qntdVenda;
	private char metPag; // 'C'/'c' para Cartão - 'B'/'b' para Boleto - 'P'/'p' para Pix
	private Funcionario f;
	private Cliente c; //Analisar Array
	private Sapato s; //Analisar Array
	
	//Construtor
	public Venda(int qtdV, char mP, Funcionario fun, Cliente cli, Sapato sap) { //Analisar Array
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

	public Sapato getS() {
		return s;
	}
	public void setS(Sapato s) {
		this.s = s;
	}
	
}
