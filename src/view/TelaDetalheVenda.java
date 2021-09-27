package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controle.ControleVenda;

public class TelaDetalheVenda implements ActionListener {
	private JFrame janela;
	private JLabel labelCliente = new JLabel("Cliente: ");
	private JTextField valorCliente;
	private JLabel labelFuncionario = new JLabel("Funcionário: ");
	private JTextField valorFuncionario;
	private JLabel labelMetPag = new JLabel("Método de Pagamento: ");
	private JTextField valorMetPag;
	private JLabel labelItens = new JLabel("Itens da Venda: ");
	private JTextField valorItens;
	private JScrollPane paneDescricao;
	private String[] NomeItensVenda = new String[50];
	private JList<String> itensVenda;
	//private JLabel labelTotal = new JLabel("O valor total da compra foi: ", precoTotal);
	//private JButton botaoAddItem = new JButton("Adicionar Item");
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleVenda dados;
	private int posicao;
	private int opcao;
	private String s;
	
	public void inserirEditar(int op, ControleVenda d, TelaVenda v, int pos) {
		
		//itensVenda = new JList<String>()
		
		opcao = op;
		posicao = pos;
		dados = d;
		
		if (op == 1) s = "Cadastro de Venda";
		if (op == 2) s = "Detalhe de Venda";
		
		janela = new JFrame(s);
		
		if (op == 2) { //Preenche dados com os dados da venda selecionada
			valorCliente = new JTextField(dados.getLista()[pos].getC().getNome(), 200);
			valorFuncionario = new JTextField(dados.getLista()[pos].getF().getNome(), 200);
			valorMetPag = new JTextField(String.valueOf(dados.getLista()[pos].getMetPag()), 100);
			
			
			
			
			
		} else { //Não preenche os dados
			valorCliente = new JTextField(200);
			valorFuncionario = new JTextField(200);
			valorMetPag = new JTextField(100);
			//valorItens
			
			botaoSalvar.setBounds(245, 175, 115, 30);
		}
		
		var y = 20;
		
		labelCliente.setBounds(30, y, 150, 25);
		valorCliente.setBounds(180, y, 180, 25);
		labelFuncionario.setBounds(30, y+=30, 150, 25);
		valorFuncionario.setBounds(180, y, 180, 25);
		labelMetPag.setBounds(30, y+=30, 150, 25);
		valorMetPag.setBounds(180, y, 180, 25);
		
		//Coloca botoes de excluir e salvar
		if (op == 2) {
			botaoSalvar.setBounds(120, y+=30, 115, 30);
			botaoExcluir.setBounds(245, y, 115, 30);
			this.janela.add(botaoExcluir);
		}
		
		this.janela.add(labelCliente);
		this.janela.add(valorCliente);
		this.janela.add(labelFuncionario);
		this.janela.add(valorFuncionario);
		this.janela.add(labelMetPag);
		this.janela.add(valorMetPag);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 250);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
