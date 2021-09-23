package controle;

import modelo.Sapato;

public class ControleSapato {

	private Sapato[] spt;
	private int qtdSapatos;
	
	public ControleSapato(ControleDados d) {
		spt = d.getSapatos();
		qtdSapatos = d.getQtdSapato();
	}
	
	public String[] getNomeSpts() {
		String[] s = new String[qtdSapatos];
		for(int i = 0; i < qtdSapatos; i++) {
			s[i] = spt[i].getNomeSapato();
		}
		
		return s;
	}
	
	public int getQtd() {
		return qtdSapatos;
	}

	public void setQtd(int qtd) {
		this.qtdSapatos = qtd;
	}
	
	public String getNome(int i) {		
		return spt[i].getNomeSapato();
	}
	
	public String getMarca(int i) {		
		return spt[i].getMarca();
	}
	
	public String getModelo(int i) {	
		String modelo = String.valueOf(spt[i].getModelo());
		return modelo;
	}
	
	public String getPreco(int i) {		
		String preco = String.valueOf(spt[i].getPreco());
		return preco;
	}
	
	public String getMenorTam(int i) {
		String menorTam = String.valueOf(spt[i].getMenorTam());
		return menorTam;
	}
	
	public String getMaiorTam(int i) {	
		String maiorTam = String.valueOf(spt[i].getMaiorTam());
		return maiorTam;
	}
	
	public String getDescricao(int i) {		
		return spt[i].getDescricao();
	}
	
	public String getFotoSapato(int i) {		
		return spt[i].getFotoSapato();
	}
	
	public String getEstoque(int i) {
		String estoque = String.valueOf(spt[i].getQntdEstoque());
		return estoque;
	}
	
}
