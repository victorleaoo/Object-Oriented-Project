package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.ControleCliente;

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
	private static ControleCliente dados;
	private int posicao;
	private int opcao;
	private String s;
	
	public void inserirEditar(int op, ControleCliente d, TelaCliente c, String nome) {
		
		int pos = 0;
		
		for(int i = 0; i < d.getQtd(); i++) {
			if(d.getLista()[i].getNome().equals(nome)) {
				pos = i;
			}
		}
		
		opcao = op;
		posicao = pos;
		dados = d;
		
		if (op == 1) s = "Cadastro de Cliente";
		if (op == 2) s = "Detalhe de Cliente";
		
		janela = new JFrame(s);
		
		if (op == 2) { //Preenche dados com dados do cliente clicado
			
			valorNome = new JTextField(dados.getLista()[pos].getNome(), 200);
			valorTelefone = new JTextField(dados.getLista()[pos].getTelefone(),200);
			valorEmail = new JTextField(dados.getLista()[pos].getEmail(),200);
			valorEnd = new JTextField(dados.getLista()[pos].getEndCliente(),200);
			
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
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);
		janela.setLocationRelativeTo(null);

		this.janela.setSize(400, 250);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoSalvar) {
			try {
				boolean res;				
				novoDado[1] = valorNome.getText();
				novoDado[2] = valorTelefone.getText();
				novoDado[3] = valorEmail.getText();
				novoDado[4] = valorEnd.getText();
				if(opcao == 1) { //Cadastro de novo cliente
					novoDado[0] = Integer.toString(dados.getQtd());
					res = dados.inserir(novoDado);
				}
				else { //Edição de Cliente				
					novoDado[0] = Integer.toString(posicao);
					res = dados.editar(novoDado);
				}
												
				if(res) {
					mensagemSucessoCadastro();
				} else mensagemErroCadastro();
			}
			catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}
		
		
		if(src == botaoExcluir) { 
			boolean res = false;
		 
		//exclui cliente
			res = dados.remover(posicao);
			if (res) mensagemSucessoExclusao(); 
			else mensagemErroExclusao(); 
		}
		
	}
	
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n " + "Nem todos os campos foram preenchidos OU \n"
	+ "Email incorreto", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n", null, 
				JOptionPane.ERROR_MESSAGE);
	}
}
