package controle;

import javax.swing.ImageIcon;

import modelo.Sapato;

public class ControleSapato {

	private Sapato[] spt;
	private int qtdSapatos;
	
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
	
	public char getModelo(int i) {		
		return spt[i].getModelo();
	}
	
	public double getPreco(int i) {		
		return spt[i].getPreco();
	}
	
	public double getMenorTam(int i) {		
		return spt[i].getMenorTam();
	}
	
	public double getMaiorTam(int i) {		
		return spt[i].getMaiorTam();
	}
	
	public String getDescricao(int i) {		
		return spt[i].getDescricao();
	}
	
	public ImageIcon getFotoSapato(int i) {		
		return spt[i].getFotoSapato();
	}
	
	public int getEstoque(int i) {		
		return spt[i].getQntdEstoque();
	}
	
}
