package principal;

import java.util.List;

import javax.swing.Icon;

public class Empresa {

	//Atributos
	private String nomeEmpresa;
	private String CNPJ;
	private int anoFund;
	private Sapato[] estoque = new Sapato[100]; //Teoricamente, era para ser muitos Sapatos, logo coloquei 100, alto número.
	private String telEmpresa;
	private String endEmpresa;
	
	//Construtor
	public Empresa(String nE, String c, int f, String t, String eE) { //Falta colocar estoque
		nomeEmpresa = nE;
		CNPJ = c;
		anoFund = f;
		telEmpresa = t;
		endEmpresa = eE;
	}
	
	public void cadastroEstoque() {
		int qntd;
		Sapato[] s = this.getEstoque();
	}
	
	//Gets e Sets
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
	public int getAnoFund() {
		return anoFund;
	}
	public void setAnoFund(int anoFund) {
		this.anoFund = anoFund;
	}

	public Sapato[] getEstoque() {
		return estoque;
	}
	public void setEstoque(Sapato[] estoque) {
		this.estoque = estoque;
	}

	public String getTelEmpresa() {
		return telEmpresa;
	}
	public void setTelEmpresa(String telEmpresa) {
		this.telEmpresa = telEmpresa;
	}

	public String getEndEmpresa() {
		return endEmpresa;
	}
	public void setEndEmpresa(String endEmpresa) {
		this.endEmpresa = endEmpresa;
	}
	
	// Listar Empresa(s) cadastrados
	public static void listaEmpresa(List<Empresa> lista) {
		System.out.println("------------- Lista de Empresa(s) -------------\n");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("Nome:\t\t" + lista.get(i).getNomeEmpresa() + "\n" +
							   "CNPJ:\t\t" + lista.get(i).getCNPJ() + "\n" +
							   "Ano Fundação:\t" + lista.get(i).getAnoFund() + "\n" +
							   "Telefone:\t" + lista.get(i).getTelEmpresa() + "\n" +
							   "Endereço:\t" + lista.get(i).getEndEmpresa() + "\n" + "\n\n");
		}
	}
	
	// Alterar Empresa cadastrada
	public static void alterarEmpresa(Empresa e, String novoN, String novoCNPJ, int novoAno, String novoT, String novoEnd) {
		e.setNomeEmpresa(novoN);
		e.setCNPJ(novoCNPJ);
		e.setAnoFund(novoAno);
		e.setTelEmpresa(novoT);
		e.setEndEmpresa(novoEnd);
	}
	
}
