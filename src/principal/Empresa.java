package principal;

public class Empresa {

	//Atributos
	private String nomeEmpresa;
	private String CNPJ;
	private int anoFund;
	private Sapato[] estoque = new Sapato[40];
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
	
}
