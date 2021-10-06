package modelo;

/**
 * Classe modelo de ItensVenda. Possui seus atributos, construtor e gets/sets.
 * @author Victor Leão
 * @version 1.0 (Out. 2021)
 */

public class ItensVenda implements Model{
	
	/**
	 * Atributos de ItensVenda.
	 */
	private Sapato s;
	private int qntdVenda;
	
	/**
	 * Construtor de ItensVenda
	 * @param sap -> Sapato contendo sapato que será o item da Venda.
	 * @param q   -> Int contendo quantidade vendida do sapato.
	 */
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
