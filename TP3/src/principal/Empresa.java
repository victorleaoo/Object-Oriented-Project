package principal;

public class Empresa {

	private String nomeEmpresa;
	private int CNPJ;
	private int anoFund;
	//private array estoque;
	private Estoque[] sapatosCadastrados = new Estoque[40];
	private int telEmpresa;
	private String endEmpresa;
	
	public Empresa(String nE, int c, int f, int t, String eE) { //Falta colocar estoque
		nomeEmpresa = nE;
		CNPJ = c;
		anoFund = f;
		telEmpresa = t;
		endEmpresa = eE;
	}
	
}
