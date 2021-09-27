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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleVenda;
import modelo.Venda;

public class TelaDetalheVenda implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel labelCliente = new JLabel("Cliente: ");
	private JTextField valorCliente;
	private JLabel labelFuncionario = new JLabel("Funcionário: ");
	private JTextField valorFuncionario;
	private JLabel labelMetPag = new JLabel("Método de Pagamento: ");
	private JTextField valorMetPag;
	private JLabel labelItens = new JLabel("Itens da Venda: ");
	private JTextArea valorItens;
	private JScrollPane paneItens;
	private String[] NomeItensVenda = new String[50];
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoItem = new JButton("Adicionar Item");
	private String[] novoDado = new String[9];
	private static ControleVenda dados;
	private int posicao;
	private int opcao;
	private String s;
	
	private JList<String> listaItensVenda;
	private String[] listaNomesItens = new String[50];
	private Venda venda;
	
	public void inserirEditar(int op, ControleVenda d, TelaVenda v, int pos) {
		
		opcao = op;
		posicao = pos;
		dados = d;
		
		if (op == 1) s = "Cadastro de Venda";
		if (op == 2) s = "Detalhe de Venda";
		
		janela = new JFrame(s);
		
		if (op == 2) { //Preenche dados com os dados da venda selecionada
			
			venda = dados.getLista()[pos];			
			listaNomesItens = dados.getNomeItens(venda.getSapatos());

			valorCliente = new JTextField(venda.getC().getNome(), 200);
			valorFuncionario = new JTextField(venda.getF().getNome(), 200);
			valorMetPag = new JTextField(String.valueOf(venda.getMetPag()), 100);
						
		} else { //Não preenche os dados
			valorCliente = new JTextField(200);
			valorFuncionario = new JTextField(200);
			valorMetPag = new JTextField(100);
			botaoSalvar.setBounds(245, 175, 115, 30);
			venda = null;
			listaNomesItens = new String[] {};
		}
				
		var y = 20;
		
		listaItensVenda = new JList<String>(listaNomesItens);
		listaItensVenda.setBounds(20, 50, 350, 120);
		listaItensVenda.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaItensVenda.setVisibleRowCount(10);

		paneItens = new JScrollPane(listaItensVenda);
		paneItens.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		paneItens.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
		
		labelCliente.setBounds(30, y, 150, 25);
		valorCliente.setBounds(180, y, 180, 25);
		labelFuncionario.setBounds(30, y+=30, 150, 25);
		valorFuncionario.setBounds(180, y, 180, 25);
		labelMetPag.setBounds(30, y+=30, 150, 25);
		valorMetPag.setBounds(180, y, 180, 25);
		
		paneItens.setBounds(60, y+=30, 260, 80);
		
		//Coloca botoes de excluir e salvar
		if (op == 2) {
			botaoSalvar.setBounds(135, y+=90, 115, 30);
			botaoExcluir.setBounds(260, y, 115, 30);
			botaoItem.setBounds(10, y, 115, 30);
			this.janela.add(botaoExcluir);
			this.janela.add(botaoItem);
		}
		
		this.janela.add(labelCliente);
		this.janela.add(valorCliente);
		this.janela.add(labelFuncionario);
		this.janela.add(valorFuncionario);
		this.janela.add(labelMetPag);
		this.janela.add(valorMetPag);
		this.janela.add(paneItens);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 285);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		listaItensVenda.addListSelectionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();		
		if(e.getValueIsAdjusting() && src == listaItensVenda) {
			
			new TelaDetalheItem().inserirEditar(venda,listaItensVenda.getSelectedIndex());
		}		
	}

}
