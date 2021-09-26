package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleCliente;
import controle.ControleDados;
import controle.ControleEmpresa;
import controle.ControleFunc;

public class TelaEmpresa implements ActionListener {
	private JFrame janela = new JFrame("Empresa");
	private JLabel titulo = new JLabel("Controle da Empresa");
	private JButton refresh = new JButton("Refresh");
	private JButton cadastrarEmpresa = new JButton("Cadastrar Empresa");
	private JButton botaoAlterar = new JButton("Alterar Dados");
	private JButton botaoExcluir = new JButton("Apagar Dados");
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelCNPJ = new JLabel("CNPJ: ");
	private JTextField valorCNPJ;
	private JLabel labelAnoFund = new JLabel("Ano de Fundação: ");
	private JTextField valorAnoFund;
	private JLabel labelTelefone = new JLabel("Telefone: ");
	private JTextField valorTelefone;
	private JLabel labelEndereco = new JLabel("Endereço: ");
	private JTextField valorEndereco;
	public static ControleDados dados;
	private String e;
	
	public void mostrarEmpresa(ControleDados d) {
		dados = d;
		
		titulo.setFont(new Font("Helvetica", Font.BOLD, 20));
		titulo.setBounds(90, 10, 250, 30);
		
		valorNome = new JTextField(dados.getEmpresa().getNomeEmpresa(), 200);
		valorCNPJ = new JTextField(dados.getEmpresa().getCNPJ(), 200);
		valorAnoFund = new JTextField(String.valueOf(dados.getEmpresa().getAnoFund()), 200);
		valorTelefone = new JTextField(dados.getEmpresa().getTelEmpresa(), 200);
		valorEndereco = new JTextField(dados.getEmpresa().getEndEmpresa(), 200);
		
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(190, 20, 180, 25);
		labelCNPJ.setBounds(30, 50, 150, 25);
		valorCNPJ.setBounds(190, 50, 180, 25);	
		labelAnoFund.setBounds(30, 80, 150, 25);
		valorAnoFund.setBounds(190, 80, 180, 25);	
		labelTelefone.setBounds(30, 110, 150, 25);
		valorTelefone.setBounds(190, 110, 180, 25);	
		labelEndereco.setBounds(30, 140, 150, 25);
		valorEndereco.setBounds(190, 140, 180, 25);
		
		cadastrarEmpresa.setBounds(15, 175, 85, 30);
		botaoAlterar.setBounds(105, 175, 85, 30);
		botaoExcluir.setBounds(195, 175, 85, 30);
		refresh.setBounds(285, 175, 85, 30);
		
		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelCNPJ);
		this.janela.add(valorCNPJ);
		this.janela.add(labelAnoFund);
		this.janela.add(valorAnoFund);
		this.janela.add(labelTelefone);
		this.janela.add(valorTelefone);
		this.janela.add(labelEndereco);
		this.janela.add(valorEndereco);
		
		this.janela.add(cadastrarEmpresa);
		this.janela.add(botaoAlterar);
		this.janela.add(botaoExcluir);
		this.janela.add(refresh);

		this.janela.setLayout(null);

		this.janela.setSize(405, 250);
		this.janela.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}
	
	
}
