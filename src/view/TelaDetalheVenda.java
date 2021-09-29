package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleVenda;
import modelo.Venda;

public class TelaDetalheVenda implements ActionListener, ListSelectionListener {
	private JPanel janela;
	private JPanel pai;
	private JPanel editarVenda;
	private JPanel cadastrarVenda;
	private JPanel detalheItem;
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
	private TelaDetalheItem telaDetalheItem = new TelaDetalheItem();
	
	public JPanel inserirEditar(ControleVenda d) {
			
		dados = d;
		
//		if (op == 1) s = "Cadastro de Venda";
//		if (op == 2) s = "Detalhe de Venda";
		
		janela = new JPanel();
		
		venda = null;
		listaNomesItens = new String[] {};
		valorCliente = new JTextField(200);
		valorFuncionario = new JTextField(200);
		valorMetPag = new JTextField(100);								
				
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
//		if (op == 2) {
		editarVenda = new JPanel();
		editarVenda.setSize(400, 250);
		editarVenda.setBounds(140, y+=90, 120, 40);
		botaoSalvar.setBounds(135, y, 115, 30);
		botaoExcluir.setBounds(260, y, 115, 30);
		botaoItem.setBounds(10, y, 115, 30);
		editarVenda.add(botaoExcluir);
		editarVenda.add(botaoItem);
		editarVenda.setVisible(false);
		
		cadastrarVenda = new JPanel();						
		cadastrarVenda.setSize(400, 250);
		cadastrarVenda.add(botaoSalvar);		
		cadastrarVenda.setVisible(false);
//		}
		
		this.janela.add(labelCliente);
		this.janela.add(valorCliente);
		this.janela.add(labelFuncionario);
		this.janela.add(valorFuncionario);
		this.janela.add(labelMetPag);
		this.janela.add(valorMetPag);
		this.janela.add(paneItens);
		this.janela.add(editarVenda);
		this.janela.add(cadastrarVenda);

		this.janela.setLayout(null);

		this.janela.setSize(400, 285);
		this.janela.setVisible(true);
		
		detalheItem = telaDetalheItem.inserirEditar();
		telaDetalheItem.setParent(janela);
		detalheItem.setVisible(false);		
		janela.add(BorderLayout.CENTER, detalheItem);
		
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		listaItensVenda.addListSelectionListener(this);
		
		return janela;
	}

	public void setParent(JPanel pai) {
		this.pai = pai;
	}
	
	
	public void setVenda(int pos) {
		if(pos >= 0 ) {			
			venda = dados.getLista()[pos];			
			listaNomesItens = dados.getNomeItens(venda.getSapatos());
			valorCliente.setText(venda.getC().getNome());
			valorFuncionario.setText(venda.getF().getNome());
			valorMetPag.setText(String.valueOf(venda.getMetPag()));
			cadastrarVenda.setVisible(false);
			editarVenda.setVisible(true);
		}
		else {
			cadastrarVenda.setVisible(true);
			editarVenda.setVisible(false);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		janela.setVisible(false);
		this.pai.setVisible(true);		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();		
		if(e.getValueIsAdjusting() && src == listaItensVenda) {			
			telaDetalheItem.setVenda(venda, listaItensVenda.getSelectedIndex());
			janela.setVisible(false);
			detalheItem.setVisible(true);
		}		
	}

}
