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

import controle.ControleSapato;

public class TelaSapato implements ActionListener, ListSelectionListener {
	private JFrame janela = new JFrame("Sapatos");
	private JLabel titulo = new JLabel("Controle de Sapatos");
	private JButton cadastrarSapato = new JButton("Cadastrar Sapato");
	private JButton refresh = new JButton("Refresh");
	public static ControleSapato dados;
	private JList<String> listaSapatosCadastrados;
	private String[] listaNomesSapatos = new String[50];
	
	public void mostrarSapatos() {
		dados = new ControleSapato();
		
		listaNomesSapatos = dados.getNomeSpts();
		listaSapatosCadastrados = new JList<String>(listaNomesSapatos);
		
		titulo.setFont(new Font("Helvetica", Font.BOLD, 20));
		titulo.setBounds(90, 10, 250, 30);
		listaSapatosCadastrados.setBounds(20, 50, 350, 120);
		listaSapatosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaSapatosCadastrados.setVisibleRowCount(10);
		
		cadastrarSapato.setBounds(70, 177, 100, 30);
		refresh.setBounds(200, 177, 100, 30);
		
		janela.setLayout(null);

		janela.add(titulo);
		janela.add(listaSapatosCadastrados);
		janela.add(cadastrarSapato);
		janela.add(refresh);

		janela.setSize(400, 250);
		janela.setVisible(true);
		
		cadastrarSapato.addActionListener(this);
		refresh.addActionListener(this);
		listaSapatosCadastrados.addListSelectionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo sapato
		if(src == cadastrarSapato) {
			new TelaDetalheSapato().inserirEditar(1, dados, this, 0);
		}
		
		// Atualiza a lista de nomes de sapatos mostrada no JList
		if(src == refresh) {
			listaSapatosCadastrados.setListData(dados.getNomeSpts());			
			listaSapatosCadastrados.updateUI();
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaSapatosCadastrados) {
			new TelaDetalheSapato().inserirEditar(2, dados, this, 
					listaSapatosCadastrados.getSelectedIndex());
		}
		
	}
	
}
