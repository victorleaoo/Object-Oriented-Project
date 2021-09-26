package controle;

import modelo.Empresa;

public class ControleEmpresa {

	private Empresa empresa; //Só pode ter uma empresa cadastrada por vez
	private int qtdEmpresa;
	
	public ControleEmpresa(ControleDados d) {
		empresa = d.getEmpresa();
		qtdEmpresa = d.getQtdEmpresa();
		
	}
	
	public String getNomeEmpresa() {
		return empresa.getNomeEmpresa();
	}
	
	public int getQtd() {
		return qtdEmpresa;
	}
	
	public void setQtd(int qtd) {
		this.qtdEmpresa = qtd;
	}

	public String getCNPJ() {
		return empresa.getCNPJ();
	}
	
	public String getAnoFund() {
		String AnoFund = String.valueOf(empresa.getAnoFund());
		return AnoFund;
	}

	public String getTelEmpresa() {
		return empresa.getTelEmpresa();
	}

	public String getEndEmpresa() {
		return empresa.getEndEmpresa();
	}
	
}
