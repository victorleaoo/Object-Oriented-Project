package principal;

//Classe filha de PessoaFisica
public class Cliente extends PessoaFisica{
	
	//Atributos
	private String email;
	private String endCliente;
	
	//Construtor
	public Cliente(String nP, String t, String em, String eC) { 
		nome = nP;
		telefone = t;
		email = em;
		endCliente = eC;
	}

	//Gets e Sets
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndCliente() {
		return endCliente;
	}
	public void setEndCliente(String endCliente) {
		this.endCliente = endCliente;
	}

}
