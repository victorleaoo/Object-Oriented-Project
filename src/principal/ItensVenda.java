package principal;

public class ItensVenda {
	
	//Atributos
	private Sapato s;
	private int qntdVenda;
	
	//Construtor
	public ItensVenda(Sapato sap, int q) {
		s = sap;
		qntdVenda = q;
	}
	
	//Gets e Sets
	public Sapato getS() {
		return s;
	}
	public void setS(Sapato s) {
		this.s = s;
	}

	public int getQntdVenda() {
		return qntdVenda;
	}
	public void setQntdVenda(int qntdVenda) {
		this.qntdVenda = qntdVenda;
	}
	
}
