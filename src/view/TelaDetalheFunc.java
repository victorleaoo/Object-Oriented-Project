package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ControleDados;

public class TelaDetalheFunc implements ActionListener {
	
	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelTelefone = new JLabel("Telefone: ");
	private JTextField valorTelefone;
	private JLabel labelID = new JLabel("Id do Funcionário: ");
	private JTextField valorID;
	private JLabel labelSalario = new JLabel("Salário (em reais): ");
	private JTextField valorSalario;
	private JLabel labelAnoIng = new JLabel("Ano de Ingresso: ");
	private JTextField valorAnoIng;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;
	
	public void inserirEditar(int op, ControleDados d, TelaFuncionario f, int pos) {
		
		opcao = op;
		posicao = pos;
		dados = d;
		
		if (op == 1) s = "Cadastro de Funcionário";
		if (op == 2) s = "Detalhe de Funcionário";
		
		janela = new JFrame(s);
		
		if (op == 2) { //Preenche dados com dados do funcionário clicado
			
			valorNome = new JTextField(dados.getFuncionarios()[pos].getNome(), 200);
			valorTelefone = new JTextField(dados.getFuncionarios()[pos].getTelefone(),200);
			valorID = new JTextField(String.valueOf(dados.getFuncionarios()[pos].getIdFunc()), 200);
			valorSalario = new JTextField(String.valueOf(dados.getFuncionarios()[pos].getSalario()),200);
			valorAnoIng = new JTextField(String.valueOf(dados.getFuncionarios()[pos].getAnoIngresso()),4);
			
		} else { //Não preenche com dados

			valorNome = new JTextField(200);
			valorTelefone = new JTextField(200);
			valorID = new JTextField(200);
			valorSalario = new JTextField(200);
			valorAnoIng = new JTextField(4);

			botaoSalvar.setBounds(245, 175, 115, 30);
		}
		
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelTelefone.setBounds(30, 50, 150, 25);
		valorTelefone.setBounds(180, 50, 180, 25);	
		labelID.setBounds(30, 80, 150, 25);
		valorID.setBounds(180, 80, 180, 25);	
		labelSalario.setBounds(30, 110, 150, 25);
		valorSalario.setBounds(180, 110, 180, 25);	
		labelAnoIng.setBounds(30, 140, 150, 25);
		valorAnoIng.setBounds(180, 140, 180, 25);
		
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
		this.janela.add(labelID);
		this.janela.add(valorID);
		this.janela.add(labelSalario);
		this.janela.add(valorSalario);
		this.janela.add(labelAnoIng);
		this.janela.add(valorAnoIng);
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
