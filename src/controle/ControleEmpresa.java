package controle;

import modelo.Empresa;

public class ControleEmpresa extends ControleDados {

	private Empresa empresa; //Só pode ter uma empresa cadastrada por vez
	private int qtdEmpresa;
	
	public ControleEmpresa() {
		super();
		empresa = this.getEmpresa();
		this.setQtd(empresa != null ?  1 : 0);
	}
	
	@Override
	public Empresa[] getLista()  {
		return null;
	}
	
	public Empresa getEmpresa() {
		return this.getDados().getdEmpresa();
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
	
	@Override
	public boolean editar(String[] dadosEmpresa) {
		Empresa e = new Empresa(dadosEmpresa[1], dadosEmpresa[2], Integer.valueOf(dadosEmpresa[3]), dadosEmpresa[4], dadosEmpresa[5]);
		getDados().inserirEditaEmpresa(e);
		return true;
	}

	@Override
	public boolean inserir(String[] dados) {
		return editar(dados);
	}

	@Override
	public boolean remover(int i) {
		getDados().inserirEditaEmpresa(null);
		return true;
	}
}
