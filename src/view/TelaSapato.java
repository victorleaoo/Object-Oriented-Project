package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import controle.ControleDados;
import controle.ControleSapato;

public class TelaSapato {
	private JFrame janela = new JFrame("Sapatos");
	private JLabel titulo = new JLabel("Controle de Sapatos");
	private JButton cadastrarSapato = new JButton("Cadastrar Sapato");
	private JButton refresh = new JButton("Refresh");
	public static ControleDados dados;
	private JList<String> listaSapatosCadastrados;
	private String[] listaNomesSapatos = new String[50];
	
	public void mostrarSapatos(ControleDados d) {
		dados = d;
		
		listaNomesSapatos = new ControleSapato(dados).getNomeSpts();
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
	}
	
}
