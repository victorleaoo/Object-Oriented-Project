package principal;

import java.util.List;

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
	
	// Listar Clientes cadastrados
	public static void listaClientes(List<Cliente> lista) {
		System.out.println("------------- Lista de Clientes -------------\n");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("Nome:\t\t" + lista.get(i).getNome() + "\n" +
							   "Telefone:\t" + lista.get(i).getTelefone() + "\n" +
							   "E-mail:\t\t" + lista.get(i).getEmail() + "\n" +
							   "Endereço:\t" + lista.get(i).getEndCliente() + "\n\n");
		}
	}
	
	// Alterar Cliente cadastrado
	public static void alterarCliente(Cliente c, String novoN, String novoT, String novoE, String novoEd) {
		c.setNome(novoN);
		c.setTelefone(novoT);
		c.setEmail(novoE);
		c.setEndCliente(novoEd);
	}
}
