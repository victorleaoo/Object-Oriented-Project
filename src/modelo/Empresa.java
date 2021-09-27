package modelo;

import java.util.List;

public class Empresa implements Model {

	private String nomeEmpresa;
	private String CNPJ;
	private int anoFund;
	private String telEmpresa;
	private String endEmpresa;
	private List<Sapato> estoque;
	private List<Funcionario> listaFunc;

	public Empresa(String nE, String c, int f, String t, String eE) { //Falta colocar estoque
		nomeEmpresa = nE;
		CNPJ = c;
		anoFund = f;
		telEmpresa = t;
		endEmpresa = eE;
	}
	
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

	@Override
	public String getModel() {
		return CNPJ + " - " + nomeEmpresa;
	}
	
}
