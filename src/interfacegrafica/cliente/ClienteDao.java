package interfacegrafica.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import principal.Cliente;

public class ClienteDao {
	
	private static List<Cliente> lista = new ArrayList<>();
	
	static { 		
		lista.add(new Cliente("Victor", "(61) 99184-4198", "victor@gmail.com", "Rua 1 - Casa 1"));
		lista.add(new Cliente("Felipe", "(61) 99635-7291", "felipe@gmail.com", "Rua 2 - Casa 2"));		
		lista.add(new Cliente("João Pedro", "(61) 99601-7244", "joaopedro@gmail.com", "Rua 3 - Casa 3"));
	}
	
	public void inserir(Cliente obj) {
		if (obj != null) {
			lista.add(obj);
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
		}
		else {
			JOptionPane.showMessageDialog(null, "Erro ao inserir! Cliente com dados incompletos");
		}
	}
	
	public void atualizar(Cliente obj, int index) {		
		if (obj != null) {
			lista.get(index).setEmail(obj.getEmail());
			lista.get(index).setEndCliente(obj.getEndCliente());
			lista.get(index).setNome(obj.getNome());
			lista.get(index).setTelefone(obj.getTelefone());
			JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");				
		}
		else {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar! Cliente com dados incompletos");
		}
	}
	
	public void remover(Cliente obj) {
		if(obj != null) {
			lista.remove(obj);
			JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");
		}
		else {
			JOptionPane.showMessageDialog(null, "Erro ao excluir! Cliente não localizado");
		}
	}
	
	public List<Cliente> getLista() {
		return lista;		
	}

	public Cliente getContatoByLinha(int linha) {
		return lista.get(linha);
	}
}
