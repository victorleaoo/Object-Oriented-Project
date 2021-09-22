package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import controle.ControleCliente;
import controle.ControleDados;
import controle.ControleSapato;

public class TelaCliente {
	private JFrame janela = new JFrame("Clientes");
	private JLabel titulo = new JLabel("Controle de Clientes");
	private JButton cadastrarCliente = new JButton("Cadastrar Cliente");
	private JButton refresh = new JButton("Refresh");
	public static ControleDados dados;
	private JList<String> listaClientesCadastrados;
	private String[] listaNomesClientes = new String[50];
	
	public void mostrarClientes(ControleDados d) {
		dados = d;
		
		listaNomesClientes = new ControleCliente(dados).getNomeClientes();
		listaClientesCadastrados = new JList<String>(listaNomesClientes);
		
		titulo.setFont(new Font("Helvetica", Font.BOLD, 20));
		titulo.setBounds(90, 10, 250, 30);
		listaClientesCadastrados.setBounds(20, 50, 350, 120);
		listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaClientesCadastrados.setVisibleRowCount(10);
		
		cadastrarCliente.setBounds(70, 177, 100, 30);
		refresh.setBounds(200, 177, 100, 30);
		
		janela.setLayout(null);

		janela.add(titulo);
		janela.add(listaClientesCadastrados);
		janela.add(cadastrarCliente);
		janela.add(refresh);

		janela.setSize(400, 250);
		janela.setVisible(true);
	}
	
}
