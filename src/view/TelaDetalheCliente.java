package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ControleDados;

public class TelaDetalheCliente implements ActionListener {
	
	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelTelefone = new JLabel("Telefone: ");
	private JTextField valorTelefone;
	private JLabel labelEmail = new JLabel("E-mail: ");
	private JTextField valorEmail;
	private JLabel labelEnd = new JLabel("Endereco: ");
	private JTextField valorEnd;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;
	
	public void inserirEditar(int op, ControleDados d, TelaCliente c, int pos) {
		
		opcao = op;
		posicao = pos;
		dados = d;
		
		if (op == 1) s = "Cadastro de Cliente";
		if (op == 2) s = "Detalhe de Cliente";
		
		janela = new JFrame(s);
		
		if (op == 2) { //Preenche dados com dados do cliente clicado
			
			valorNome = new JTextField(dados.getClientes()[pos].getNome(), 200);
			valorTelefone = new JTextField(dados.getClientes()[pos].getTelefone(),200);
			valorEmail = new JTextField(dados.getClientes()[pos].getEmail(),200);
			valorEnd = new JTextField(dados.getClientes()[pos].getEndCliente(),200);
			
		} else { //Não preenche com dados

			valorNome = new JTextField(200);
			valorTelefone = new JTextField(200);
			valorEmail = new JTextField(200);
			valorEnd = new JTextField(200);

			botaoSalvar.setBounds(245, 175, 115, 30);
		}
		
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelTelefone.setBounds(30, 50, 150, 25);
		valorTelefone.setBounds(180, 50, 180, 25);
		labelEmail.setBounds(30, 80, 150, 25);
		valorEmail.setBounds(180, 80, 180, 25);
		labelEnd.setBounds(30, 110, 150, 25);
		valorEnd.setBounds(180, 110, 180, 25);
		
		//Coloca botoes de excluir e salvar
		if (op == 2) {
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoExcluir.setBounds(245, 175, 115, 30);
			this.janela.add(botaoExcluir);
		}
		
		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelTelefone);
		this.janela.add(valorTelefone);
		this.janela.add(labelEmail);
		this.janela.add(valorEmail);
		this.janela.add(labelEnd);
		this.janela.add(valorEnd);
		this.janela.add(valorTelefone);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 250);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
