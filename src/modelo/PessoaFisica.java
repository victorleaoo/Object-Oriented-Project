package modelo;

// Caso de classe abstrata + Classe pai (herança)
public abstract class PessoaFisica {
	
	//Atributos
	protected String nome;
	protected String telefone;
	
	//Gets e Sets
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
