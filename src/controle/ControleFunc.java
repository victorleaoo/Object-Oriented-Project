package controle;

import modelo.Funcionario;

public class ControleFunc {
	
	private Funcionario[] func;
	private int qtdFuncionarios;
	
	public String[] getNomeFuncs() {
		String[] s = new String[qtdFuncionarios];
		for(int i = 0; i < qtdFuncionarios; i++) {
			s[i] = func[i].getNome();
		}
		
		return s;
	}
	
	public int getQtd() {
		return qtdFuncionarios;
	}

	public void setQtd(int qtd) {
		this.qtdFuncionarios = qtd;
	}
	
	public String getNome(int i) {		
		return func[i].getNome();
	}
	
	public String getTelefone(int i) {		
		return func[i].getTelefone();
	}
	
	public String getID(int i) {
		String IdFunc = String.valueOf(func[i].getIdFunc());
		return IdFunc;
	}
	
	public double getSalario(int i) {
		return func[i].getSalario();
	}
	
	public String getAnoIng(int i) {
		String AnoIng = String.valueOf(func[i].getAnoIngresso());
		return AnoIng;
	}
	
}
