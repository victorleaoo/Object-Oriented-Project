package principal;

public class Cliente extends PessoaFisica{
	
	private String email;
	private String endCliente;
	//private char metPag;
	
	public Cliente(String nP, int t, String em, String eC) { //Falta colocar metodo de pagamento.
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
