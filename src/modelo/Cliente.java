package modelo;

public class Cliente extends PessoaFisica{
	
	private String email;
	private String endCliente;
	
	public Cliente(String nP, String t, String em, String eC) {
		nome = nP;
		telefone = t;
		email = em;
		endCliente = eC;
	}

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
