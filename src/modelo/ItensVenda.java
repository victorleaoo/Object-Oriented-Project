package modelo;

public class ItensVenda implements Model{
	
	private Sapato s;
	private int qntdVenda;
	
	public ItensVenda(Sapato sap, int q) {
		s = sap;
		qntdVenda = q;
	}
	
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

	@Override
	public String getModel() {
		return "Sapato";
	}
	
}
