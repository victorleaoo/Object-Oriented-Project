package modelo;

// Caso de classe abstrata + Classe pai (heran�a)
public abstract class PessoaFisica {
	
	protected String nome;
	protected String telefone;
	
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
