package principal;

import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon; //Importando ImageIcon
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Sapato {
	
	//Atributos
	private String nomeSapato;
	private String marca;
	private char modelo; // 'C'/'c' para Casual - 'S'/'s' para Sandália - 'E'/'e' para Esportivo
	private double preco;
	private double menorTam;
	private double maiorTam;
	private String descricao;
	private ImageIcon fotoSapato;
	private int qntdEstoque;

	//Construtor
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

	//Gets e Sets
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
	
	// Alterar Sapato cadastrado
	public static void alterarSapato(Sapato s, String novoN, String novoMarca, char novoMod, double novoP, double novoMenor, double novoMaior, String novaD, ImageIcon novoImg) {
		s.setNomeSapato(novoN);
		s.setMarca(novoMarca);
		s.setModelo(novoMod);
		s.setPreco(novoP);
		s.setMenorTam(novoMenor);
		s.setMaiorTam(novoMaior);
		s.setDescricao(novaD);
		s.setFotoSapato(novoImg);
	}
	
	// Listar Sapatos cadastrados
	public static void listaSapatos(List<Sapato> lista) {
		System.out.println("------------- Lista de Sapatos -------------\n");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("Nome:\t\t" + lista.get(i).getNomeSapato() + "\n" +
							   "Marca:\t\t" + lista.get(i).getMarca() + "\n" +
							   "Modelo:\t\t" + lista.get(i).getModelo() + "\n" +
							   "getPreco:\tR$" + lista.get(i).getPreco() + "\n" +
							   "Tamanhos:\t" + lista.get(i).getMenorTam() + " até " + lista.get(i).getMaiorTam()+ "\n" +
							   "Descricao:\t" + lista.get(i).getDescricao() + "\n" +
							   "Estoque:\t" + lista.get(i).getQntdEstoque() + "\n" +
							   "Foto:\t");
			JFrame frame = new JFrame("Foto Sapato");
			Icon imagem = lista.get(i).getFotoSapato();
			JLabel label = new JLabel(imagem);
			frame.add(label);
			frame.setDefaultCloseOperation
			         (JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
			System.out.println("\n\n");
		}
	}
}
