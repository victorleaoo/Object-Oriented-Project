package principal;

import javax.swing.ImageIcon;

public class ClassePrincipal {

	static Cliente c1;
	static Cliente c2;
	static Cliente c3;
	
	static Funcionario f1;
	static Funcionario f2;
	static Funcionario f3;
	
	static Sapato s1;
	static Sapato s2;
	static Sapato s3;
	
	static Empresa e1;
	
	public static void main(String[] args) {
		//Cadastro Prévio de Clientes - Cliente(String nP, String t, String em, String eC)
		c1 = new Cliente("Victor", "61 991844198", "victor@gmail.com", "Rua 1 - Casa 1");
		c2 = new Cliente("Felipe", "61 996357291", "felipe@gmail.com", "Rua 2 - Casa 2");
		c3 = new Cliente("João Pedro", "61 996017244", "joaopedro@gmail.com", "Rua 3 - Casa 3");
		
		//Cadastro Prévio de Funcionários - Funcionario(String nP, String t, int id, double s, int ano)
		f1 = new Funcionario("Jorge", "61 983457102", 11, 3052.0, 2018);
		f2 = new Funcionario("Yure", "61 992017202", 22, 2320.0, 2019);
		f2 = new Funcionario("Daniel", "61 933317708", 33, 750.55, 2021);
		
		//Cadastro Prévio de Sapatos - Sapato(String nS, String m, char mod, double p, double men, double mai, String d, ImageIcon img)
		ImageIcon imgObsidian = new ImageIcon("../imgs/airjordan-obsidian.jpg");
		s1 = new Sapato("Air Jordan 1 - Obsidian", "Nike", 'C', 1749.99, 34.5, 44.0, "Tênis de Couro/Borracha, com as cores em homenagem a Universidade que Jordan jogou.", imgObsidian);
		ImageIcon imgSLX = new ImageIcon("../imgs/slx-rider");
		s2 = new Sapato("Chinelo Slide - SLX", "Rider", 'S', 179.99, 35.0, 44.5, "Chinelo sandália macio, com elementos da NBA e do filme Space Jam para fãs.", imgSLX);
		ImageIcon imgGel6 = new ImageIcon("../imgs/gel6-asics");
		s3 = new Sapato("Gel-Dedicate 6 - Tênis", "Asics", 'S', 275.49, 39.0, 45.0, "Tênis ideal para jogadores de Tênis, especialmente em quadras de Saibro, com muita estabilidade torsional.", imgGel6);
	
		//Cadastro Prévio de Empresa - Empresa(String nE, int c, int f, String t, String eE) //Falta colocar estoque
		e1 = new Empresa("Luv Sneakers", );
	}

}
