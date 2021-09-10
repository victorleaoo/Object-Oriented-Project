package principal;

//Classe filha de PessoaFisica
public class Funcionario extends PessoaFisica{

	//Atributos
	private int idFunc;
	private double salario;
	private int anoIngresso;
	
	//Construtor 1
	public Funcionario(String nP, String t) {
		nome = nP;
		telefone = t;
	}
	
	//Construtor 2 - Sobrecarga de M�todo.
	public Funcionario(String nP, String t, int id, double s, int ano) {
		nome = nP;
		telefone = t;
		idFunc = id;
		salario = s;
		anoIngresso = ano;
	}
	
	//Gets e Sets
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