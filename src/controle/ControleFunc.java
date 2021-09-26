package controle;

import modelo.Cliente;
import modelo.Funcionario;

public class ControleFunc extends ControleDados {
	
	private Funcionario[] func;
	private int qtdFuncionarios;
	
	public ControleFunc() {
		super();
		func = this.getFuncionarios();
		this.setQtd(qtdeFuncs());
	}
	
	private int qtdeFuncs() {
		int count = -1;
		for(int i = 0; i < func.length; i++) {
			if(func[i] == null) {
				break;
			}
			count = i+1;
		}
		return count;
	}
	
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
	
	public String getSalario(int i) {
		return String.valueOf(func[i].getSalario());
	}
	
	public String getAnoIng(int i) {
		String AnoIng = String.valueOf(func[i].getAnoIngresso());
		return AnoIng;
	}
	
	public boolean editarFunc(String[] dadosFunc) {		
		Funcionario f = new Funcionario(dadosFunc[1], dadosFunc[2], Integer.valueOf(dadosFunc[3]), Double.valueOf(dadosFunc[4]), Integer.valueOf(dadosFunc[5]));
		d.inserirEditaFunc(f, Integer.parseInt(dadosFunc[0]));
		return true;
	}
	
	public boolean inserirFunc(String[] dadosFunc) {
		if(editarFunc(dadosFunc)) {
			setQtd(getQtd()+1);			
		}
		return true;
	}
	
	public boolean removerFunc(int i) {
		String funcRemovido = d.getdFuncs()[i].getNome();
		
		if(i == (getQtd() -1)) { //Se o funcionário a ser removido está no final do array
			d.getdFuncs()[getQtd()] = null;
			setQtd(getQtd() -1);
			return true;
		} else {
			int cont = 0;
			while(d.getdFuncs()[cont].getNome().compareTo(funcRemovido) != 0) {
				cont++;
			} 
			
			for (int j = cont; j < getQtd() - 1; j++) {
				d.getdFuncs()[j] = null;
				d.getdFuncs()[j] = d.getdFuncs()[j+1];
			}
			d.getdFuncs()[getQtd()] = null;
			setQtd(getQtd() - 1);
			return true;
		}
	}
	
}
