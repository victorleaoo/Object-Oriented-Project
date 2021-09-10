package principal;

import java.util.List;

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
	
	//Construtor 2 - Sobrecarga de Método.
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
	
	// Listar Funcionários cadastrados
	public static void listaFuncionarios(List<Funcionario> lista) {
		System.out.println("------------- Lista de Funcionários -------------\n");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("Nome:\t\t" + lista.get(i).getNome() + "\n" +
							   "Telefone:\t" + lista.get(i).getTelefone() + "\n" +
							   "Id Func.:\t" + lista.get(i).getIdFunc() + "\n" +
							   "Salário:\tR$" + lista.get(i).getSalario() + "\n" +
							   "Ingresso:\t" + lista.get(i).getAnoIngresso() + "\n\n");
		}
	}

	// Alterar Funcionário cadastrado
	public static void alterarFunc(Funcionario f, String novoN, String novoT, int novoId, double novoSal, int novoAno) {
		f.setNome(novoN);
		f.setTelefone(novoT);
		f.setIdFunc(novoId);
		f.setSalario(novoSal);
		f.setAnoIngresso(novoAno);
	}
}
