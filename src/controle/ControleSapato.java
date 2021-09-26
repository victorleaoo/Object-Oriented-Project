package controle;

import modelo.Cliente;
import modelo.Sapato;

public class ControleSapato extends ControleDados {

	private Sapato[] spt;
	private int qtdSapatos;
	
	public ControleSapato() {
		super();
		spt = this.getSapatos();
		this.setQtd(qtde());
	}
	
	private int qtde() {
		int count = -1;
		for(int i = 0; i < spt.length; i++) {
			if(spt[i] == null) {
				break;
			}
			count = i+1;
		}
		return count;
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
	
	public boolean inserirSapato(String[] dadosSapato) {
		if(editarSapato(dadosSapato)) {
			setQtd(getQtd()+1);
		}
		return true;
	}
	
	public boolean editarSapato(String[] dadosSapato) {
		Sapato s = new Sapato(dadosSapato[1], dadosSapato[2], dadosSapato[3].toCharArray()[0], Double.valueOf(dadosSapato[4]),
				Double.valueOf(dadosSapato[5]), Double.valueOf(dadosSapato[6]), dadosSapato[7],
				Integer.valueOf(dadosSapato[8]), dadosSapato[9]);
		d.inserirEditaSapato(s, Integer.parseInt(dadosSapato[0]));
		return true;
	}
	
	public boolean removerSapato(int i) {
		if(i > getQtd()) {
			return false;
		}
		
		String sapatoRemovido = d.getdSapatos()[i].getNomeSapato();
		
		
		if(i == (getQtd() -1)) { //Se o cliente a ser removido está no final do array
			d.getdSapatos()[getQtd()] = null;
			setQtd(getQtd() -1);
			return true;
		} else {
			int cont = 0;
			while(d.getdSapatos()[cont].getNomeSapato().compareTo(sapatoRemovido) != 0) {
				cont++;
			} 
			
			for (int j = cont; j < getQtd() - 1; j++) {
				d.getdSapatos()[j] = null;
				d.getdSapatos()[j] = d.getdSapatos()[j+1];
			}
			d.getdSapatos()[getQtd()] = null;
			setQtd(getQtd() - 1);
			return true;
		}
	}
	
}
