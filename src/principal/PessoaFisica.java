package principal;

public abstract class PessoaFisica {
	
	protected String nome;
	protected int telefone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
}
