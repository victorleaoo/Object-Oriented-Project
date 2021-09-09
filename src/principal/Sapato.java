package principal;

public class Sapato {
	
	private String nomeSapato;
	private String marca;
	//private char modelo;
	private double preco;
	private double menorTam;
	private double maiorTam;
	private String descricao;
	//private ImageIcon fotoSapato;
	
	public Sapato(String nS, String m, double p, double men, double mai, String d) { //Falta colocar modelo e fotoSapato.
		nomeSapato = nS;
		marca = m;
		preco = p;
		menorTam = men;
		maiorTam = mai;
		descricao = d;
	}
	
	public String getNomeSapato() {
		return nomeSapato;
	}
	public void setNomeSapato(String nomeSapato) {
		this.nomeSapato = nomeSapato;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getMenorTam() {
		return menorTam;
	}
	public void setMenorTam(double menorTam) {
		this.menorTam = menorTam;
	}

	public double getMaiorTam() {
		return maiorTam;
	}
	public void setMaiorTam(double maiorTam) {
		this.maiorTam = maiorTam;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
