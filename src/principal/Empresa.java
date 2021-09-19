package principal;

import java.util.List;

public class Empresa {

	//Atributos
	private String nomeEmpresa;
	private String CNPJ;
	private int anoFund;
	private String telEmpresa;
	private String endEmpresa;
	private List<Sapato> estoque;
	private List<Funcionario> listaFunc;

	//Construtor
	public Empresa(String nE, String c, int f, String t, String eE) { //Falta colocar estoque
		nomeEmpresa = nE;
		CNPJ = c;
		anoFund = f;
		telEmpresa = t;
		endEmpresa = eE;
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
	
	public List<Sapato> getEstoque() {
		return estoque;
	}
	public void setEstoque(List<Sapato> estoque) {
		this.estoque = estoque;
	}
	
	public List<Funcionario> getlistaFunc() {
		return listaFunc;
	}
	public void setlistaFunc(List<Funcionario> listaFunc) {
		this.listaFunc = listaFunc;
	}
	
	// Listar Empresa(s) cadastrados
	public static void listaEmpresa(List<Empresa> lista) {
		System.out.println("------------- Lista de Empresa(s) -------------\n");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("Nome:\t\t" + lista.get(i).getNomeEmpresa() + "\n" +
							   "CNPJ:\t\t" + lista.get(i).getCNPJ() + "\n" +
							   "Ano Funda��o:\t" + lista.get(i).getAnoFund() + "\n" +
							   "Telefone:\t" + lista.get(i).getTelEmpresa() + "\n" +
							   "Endere�o:\t" + lista.get(i).getEndEmpresa() + "\n" + "\n\n");
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
