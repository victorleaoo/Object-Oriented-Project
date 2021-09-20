package modelo;

import java.util.ArrayList;
import java.util.List;

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
	
	static Venda v1;
	static Venda v2;
	static Venda v3;
	
	public static void main(String[] args) {
		List<Cliente> listC = new ArrayList<Cliente>();
		//Cadastro Prévio de Clientes - Cliente(String nP, String t, String em, String eC) -> Testando funcionamento do construtor dessa classe
		c1 = new Cliente("Victor", "(61) 99184-4198", "victor@gmail.com", "Rua 1 - Casa 1");
		listC.add(c1);
		c2 = new Cliente("Felipe", "(61) 99635-7291", "felipe@gmail.com", "Rua 2 - Casa 2");
		listC.add(c2);
		c3 = new Cliente("João Pedro", "(61) 99601-7244", "joaopedro@gmail.com", "Rua 3 - Casa 3");
		listC.add(c3);
		
		List<Funcionario> listF = new ArrayList<Funcionario>();
		//Cadastro Prévio de Funcionários - Funcionario(String nP, String t, int id, double s, int ano) -> Testando funcionamento do construtor dessa classe
		f1 = new Funcionario("Jorge", "(61) 98345-7102", 11, 3052.0, 2018);
		listF.add(f1);
		f2 = new Funcionario("Yure", "(61) 99201-7202", 22, 2320.0, 2019);
		listF.add(f2);
		f3 = new Funcionario("Daniel", "(61) 93331-7708", 33, 750.55, 2021);
		listF.add(f3);
		
		List<Sapato> listS = new ArrayList<Sapato>();
		//Cadastro Prévio de Sapatos - Sapato(String nS, String m, char mod, double p, double men, double mai, String d, int q, ImageIcon img) -> Testando funcionamento do construtor dessa classe
		ImageIcon imgObsidian = new ImageIcon("../imgs/airjordan-obsidian.jpg");
		s1 = new Sapato("Air Jordan 1 - Obsidian", "Nike", 'C', 1749.99, 34.5, 44.0, "Tênis de Couro/Borracha, com as cores em homenagem a Universidade que Jordan jogou.", 10, imgObsidian);
		listS.add(s1);
		ImageIcon imgSLX = new ImageIcon("../imgs/slx-rider.jpg");
		s2 = new Sapato("Chinelo Slide - SLX", "Rider", 'S', 179.99, 35.0, 44.5, "Chinelo sandália macio, com elementos da NBA e do filme Space Jam para fãs.", 20, imgSLX);
		listS.add(s2);
		ImageIcon imgGel6 = new ImageIcon("../imgs/gel6-asics.jpg");
		s3 = new Sapato("Gel-Dedicate 6 - Tênis", "Asics", 'E', 275.49, 39.0, 45.0, "Tênis ideal para jogadores de Tênis, especialmente em quadras de Saibro, com muita estabilidade torsional.", 30, imgGel6);
		listS.add(s3);
		
		ImageIcon imgBoost = new ImageIcon("../imgs/ultraboost-adidas.jpg");
		
		List<Empresa> listE = new ArrayList<Empresa>();
		//Cadastro Prévio da Empresa - Empresa(String nE, String c, int f, String t, String eE) -> Testando funcionamento do construtor dessa classe
		e1 = new Empresa("Luv Sneakers", "59.546.515/0001-34", 2015, "(11) 4935-2323", "QG Luv Sneakers - DF");
		listE.add(e1);
		
		List<Venda> listV = new ArrayList<Venda>();
		//Cadastro Prévio de Vendas - Venda(char mP, Funcionario fun, Cliente cli) -> Testando funcionamento do construtor dessa classe
		v1 = new Venda('C', f1, c1);
		v1.addItem(new ItensVenda(s1, 1));
		listV.add(v1);
		v1.listaItens();
		v1.listaItens();
		v2 = new Venda('B', f2, c2);
		v2.addItem(new ItensVenda(s1, 2));
		v2.addItem(new ItensVenda(s2, 3));
		listV.add(v2);
		v2.listaItens();
		v3 = new Venda('P', f3, c3);
		var itv = new ItensVenda(s2, 3);
		v3.addItem(new ItensVenda(s1, 1));
		v3.addItem(itv);
		v3.addItem(new ItensVenda(s3, 5));
		v3.listaItens();
		v3.alterarItem(itv, 10);
		v3.listaItens();
		listV.add(v3);
		
		
		//Testando funcionamento dos sets da classe Cliente - alterarCliente(Cliente c, String novoN, String novoT, String novoE, String novoEd)
		Cliente.alterarCliente(c3, "Enzo", "(61) 999123-4134", "enzo@gmail.com", "Rua 10 - Casa 10");
		//Testando funcionamento dos gets da classe Cliente
		Cliente.listaClientes(listC); 
		
		//Testando funcionamento dos sets da classe Funcionário - alterarFunc(Funcionario f, String novoN, String novoT, int novoId, double novoSal, int novoAno)
		Funcionario.alterarFunc(f3, "Guilherme", "(61) 988423-7734", 11, 10000.00, 2011);
		//Testando funcionamento dos gets da classe Funcionario 
		Funcionario.listaFuncionarios(listF);
		
		//Testando funcionamento dos sets da classe Sapato - alterarSapato(Sapato s, String novoN, String novoMarca, char novoMod, double novoP, double novoMenor, double novoMaior, String novaD, ImageIcon novoImg)
		Sapato.alterarSapato(s3, "Ultraboost - Corrida", "Adidas", 'E', 999.99, 37.0, 44.0, "Tênis com tecnologia boost, extremamente confortável e ideal para corridas.", imgBoost);
		//Testando funcionamento dos gets da classe Sapato 
		Sapato.listaSapatos(listS);
		
		//Testando funcionamento dos sets da classe Empresa - alterarEmpresa(Empresa e, String novoN, String novoCNPJ, int novoAno, String novoT, String novoEnd)
		Empresa.alterarEmpresa(e1, "Luv Sneakers <3", "61.546.515/0001-34", 2011, "(61) 4935-2323", "QG Luv Sneakers - Brasília/DF");
		//Testando funcionamento dos gets da classe Empresa
		Empresa.listaEmpresa(listE);
		
		//Testando funcionamento dos sets da classe Venda - alterarVenda(Venda v, int novaQntd, char novoMet, Funcionario novoFunc, Cliente novoCli, Sapato novoSap)
		Venda.alterarVenda(v3, 'C', f2, c2);
	}

}