package modelo;

import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon; //Importando ImageIcon
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Sapato {
	
	private String nomeSapato;
	private String marca;
	private char modelo; // 'C'/'c' para Casual - 'S'/'s' para Sand�lia - 'E'/'e' para Esportivo
	private double preco;
	private double menorTam;
	private double maiorTam;
	private String descricao;
	private ImageIcon fotoSapato;
	private int qntdEstoque;

	public Sapato(String nS, String m, char mod, double p, double men, double mai, String d, int q, ImageIcon img) { //Falta colocar fotoSapato.
		nomeSapato = nS;
		marca = m;
		modelo = mod;
		preco = p;
		menorTam = men;
		maiorTam = mai;
		descricao = d;
		qntdEstoque = q;
		fotoSapato = img;
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
	
	public char getModelo() {
		return modelo;
	}

	public void setModelo(char modelo) {
		this.modelo = modelo;
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
	
	public ImageIcon getFotoSapato() {
		return fotoSapato;
	}
	public void setFotoSapato(ImageIcon fotoSapato) {
		this.fotoSapato = fotoSapato;
	}
	
	public int getQntdEstoque() {
		return qntdEstoque;
	}

	public void setQntdEstoque(int qntdEstoque) {
		this.qntdEstoque = qntdEstoque;
	}
	
}
