package modelo;

import java.util.List;

public class Funcionario extends PessoaFisica implements Model {

	private int idFunc;
	private double salario;
	private int anoIngresso;
	
	public Funcionario(String nP, String t) {
		nome = nP;
		telefone = t;
	}
	
	//Sobrecarga de Método.
	public Funcionario(String nP, String t, int id, double s, int ano) {
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

	@Override
	public String getModel() {
		return nome + " - " + telefone;
	}
	
}
