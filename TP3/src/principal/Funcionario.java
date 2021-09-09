package principal;

public class Funcionario extends PessoaFisica{

	private int idFunc;
	private double salario;
	private int anoIngresso;
	
	public Funcionario(String nP, int t, int id, double s, int ano) { //Falta colocar modelo e fotoSapato.
		nome = nP;
		telefone = t;
		idFunc = id;
		salario = s;
		anoIngresso = ano;
	}
	
	public int getIdFunc() {
		return idFunc;
	}
	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getAnoIngresso() {
		return anoIngresso;
	}
	public void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}


	
}
