package controle;

import modelo.Funcionario;

public class ControleFunc extends ControleDados {
	
	private Funcionario[] funcs;
	private int qtdFuncionarios;
	
	public ControleFunc() {
		super();
		funcs = this.getLista();
		this.setQtd(super.getQtdeLista(funcs));
	}
	
	@Override
	public Funcionario[] getLista() {
		return super.getDados().getdFuncs();
	}
	
	public String[] getNomeFuncs() {
		String[] s = new String[qtdFuncionarios];
		for(int i = 0; i < qtdFuncionarios; i++) {
			s[i] = funcs[i].getNome();
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
		return funcs[i].getNome();
	}
	
	public String getTelefone(int i) {		
		return funcs[i].getTelefone();
	}
	
	public String getID(int i) {
		String IdFunc = String.valueOf(funcs[i].getIdFunc());
		return IdFunc;
	}
	
	public String getSalario(int i) {
		return String.valueOf(funcs[i].getSalario());
	}
	
	public String getAnoIng(int i) {
		String AnoIng = String.valueOf(funcs[i].getAnoIngresso());
		return AnoIng;
	}
	
	@Override
	public boolean editar(String[] dadosFunc) {		
		Funcionario f = new Funcionario(dadosFunc[1], dadosFunc[2], Integer.valueOf(dadosFunc[3]), Double.valueOf(dadosFunc[4]), Integer.valueOf(dadosFunc[5]));
		getDados().inserirEditaFunc(f, Integer.parseInt(dadosFunc[0]));
		return true;
	}
	
	@Override
	public boolean inserir(String[] dadosFunc) {
		if(editar(dadosFunc)) {
			setQtd(getQtd()+1);			
		}
		return true;
	}
	
	@Override
	public boolean remover(int i) {
		if(i > getQtd()) {
			return false;
		}

		funcs = getDados().getdFuncs();
		String funcRemovido = funcs[i].getNome();
		
		if(i == (getQtd() -1)) { //Se o funcionário a ser removido está no final do array
			funcs[i] = null;
			setQtd(getQtd() -1);
			return true;
		} 
		int cont = 0;
		while(funcs[cont].getNome().compareTo(funcRemovido) != 0) {
			cont++;
		} 
		
		for (int j = cont; j < getQtd() - 1; j++) {
			funcs[j] = funcs[j+1];
		}
		funcs[getQtd()] = null;
		setQtd(getQtd() - 1);
		return true;
	}
	
}
