package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleCliente;
import controle.ControleDados;

public class TelaCliente implements ActionListener, ListSelectionListener {
	private JFrame janela = new JFrame("Clientes");
	private JLabel titulo = new JLabel("Controle de Clientes");
	private JButton cadastrarCliente = new JButton("Cadastrar Cliente");
	private JButton refresh = new JButton("Refresh");
	public static ControleCliente dados;
	private JList<String> listaClientesCadastrados;
	private String[] listaNomesClientes = new String[50];
	
	public void mostrarClientes() {
		dados = new ControleCliente();
		
		listaNomesClientes = dados.getNomeClientes();
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
		
		cadastrarCliente.addActionListener(this);
		refresh.addActionListener(this);
		listaClientesCadastrados.addListSelectionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo cliente
		if(src == cadastrarCliente)
			new TelaDetalheCliente().inserirEditar(1, dados, this, 0);
		
		// Atualiza a lista de nomes de clientes mostrada no JList
		if(src == refresh) {
			listaClientesCadastrados.setListData(dados.getNomeClientes());			
			listaClientesCadastrados.updateUI();
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaClientesCadastrados) {
			new TelaDetalheCliente().inserirEditar(2, dados, this, 
					listaClientesCadastrados.getSelectedIndex());
		}
	}
	
}
