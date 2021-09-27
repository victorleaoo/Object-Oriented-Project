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

import controle.ControleFunc;
import controle.ControleVenda;

public class TelaVenda implements ActionListener, ListSelectionListener {
	private JFrame janela = new JFrame("Vendas");
	private JLabel titulo = new JLabel("Controle de Vendas");
	private JButton botaoCadastrar = new JButton("Cadastrar Venda");
	private JButton refresh = new JButton("Refresh");
	public static ControleVenda dados;
	private JList<String> listaVendasCadastradas;
	private String[] listaNomeVendas = new String[50];
	
	public void mostrarVendas() {
		dados = new ControleVenda();
		
		listaNomeVendas = dados.getNomeVendas();
		listaVendasCadastradas = new JList<String>(listaNomeVendas);
		
		titulo.setFont(new Font("Helvetica", Font.BOLD, 20));
		titulo.setBounds(90, 10, 250, 30);
		listaVendasCadastradas.setBounds(20, 50, 350, 120);
		listaVendasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaVendasCadastradas.setVisibleRowCount(10);
		
		botaoCadastrar.setBounds(70, 177, 100, 30);
		refresh.setBounds(200, 177, 100, 30);
		
		janela.setLayout(null);

		janela.add(titulo);
		janela.add(listaVendasCadastradas);
		janela.add(botaoCadastrar);
		janela.add(refresh);
		
		janela.setSize(400, 250);
		janela.setVisible(true);
		
		botaoCadastrar.addActionListener(this);
		refresh.addActionListener(this);
		listaVendasCadastradas.addListSelectionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de nova Venda
		if(src == botaoCadastrar) {
			new TelaDetalheVenda().inserirEditar(1, dados, this, 0);
		}
		
		if(src == refresh) {
			listaVendasCadastradas.setListData(dados.getNomeVendas());
			listaVendasCadastradas.updateUI();
		}
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaVendasCadastradas) {
			new TelaDetalheVenda().inserirEditar(2, dados, this, listaVendasCadastradas.getSelectedIndex());
		}
		
	}
}
