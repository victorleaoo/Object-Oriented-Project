package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	private JLabel labelID = new JLabel("ID da venda: ");
	private JTextField valorID;
	private JScrollPane paneItens;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoVoltar = new JButton("Voltar");
	private JButton botaoVoltarCadastro = new JButton("Voltar");
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
		valorMetPag = new JTextField(1);	
		valorID = new JTextField(2);
				
		var y = 20;		
		listaItensVenda = new JList<String>(listaNomesItens);
		listaItensVenda.setBounds(20, 50, 350, 120);
		listaItensVenda.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaItensVenda.setVisibleRowCount(6);

		paneItens = new JScrollPane(listaItensVenda);
		paneItens.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		paneItens.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
		
		labelCliente.setBounds(30, y, 150, 25);
		valorCliente.setBounds(180, y, 150, 25);
		labelFuncionario.setBounds(30, y+=30, 150, 25);
		valorFuncionario.setBounds(180, y, 150, 25);
		labelMetPag.setBounds(30, y+=30, 150, 25);
		valorMetPag.setBounds(180, y, 180, 25);
		labelID.setBounds(30, y+=30, 150, 25);
		valorID.setBounds(180, y, 180, 25);
		
		paneItens.setBounds(60, y+=30, 260, 80);
		
		//Coloca botoes de excluir e salvar
//		if (op == 2) {
		editarVenda = new JPanel();
		editarVenda.setSize(400, 300);
		editarVenda.setBounds(140, y+=90, 120, 40);
		botaoExcluir.setBounds(300, y, 115, 30);
		botaoVoltar.setBounds(260, y, 115, 30);
		botaoItem.setBounds(10, y, 115, 30);
		editarVenda.add(botaoVoltar);
		editarVenda.add(botaoExcluir);
		//editarVenda.add(botaoItem);
		editarVenda.setVisible(true);
		
		cadastrarVenda = new JPanel();						
		cadastrarVenda.setSize(400, 400);
		botaoVoltarCadastro.setBounds(135, y, 115, 30);
		botaoSalvar.setBounds(135, y+=30, 115, 30);
		cadastrarVenda.add(botaoVoltarCadastro);
		cadastrarVenda.add(botaoSalvar);
		cadastrarVenda.setVisible(false);
//		}
		
		this.janela.add(labelCliente);
		this.janela.add(valorCliente);
		this.janela.add(labelFuncionario);
		this.janela.add(valorFuncionario);
		this.janela.add(labelMetPag);
		this.janela.add(valorMetPag);
		this.janela.add(labelID);
		this.janela.add(valorID);
		this.janela.add(paneItens);
		this.janela.add(editarVenda);
		this.janela.add(cadastrarVenda);

		this.janela.setLayout(new FlowLayout(FlowLayout.LEFT));

		this.janela.setSize(400, 400);
		this.janela.setVisible(true);
		
		detalheItem = telaDetalheItem.inserirEditar();
		telaDetalheItem.setParent(janela);
		detalheItem.setVisible(false);		
		janela.add(BorderLayout.CENTER, detalheItem);
		
		botaoExcluir.addActionListener(this);
		botaoVoltarCadastro.addActionListener(this);
		botaoVoltar.addActionListener(this);
		listaItensVenda.addListSelectionListener(this);
		botaoSalvar.addActionListener(this);
		
		return janela;
	}

	public void setParent(JPanel pai) {
		this.pai = pai;
	}
	
	
	public void setVenda(int pos) {
		posicao = pos;
		if(pos >= 0) {	
			venda = dados.getLista()[pos];			
			listaNomesItens = dados.getNomeItens(venda.getSapatos());
			valorCliente.setText(venda.getC().getNome());
			valorFuncionario.setText(venda.getF().getNome());
			valorMetPag.setText(String.valueOf(venda.getMetPag()));
			valorID.setText(String.valueOf(venda.getID()));
			cadastrarVenda.setVisible(false);
			editarVenda.setVisible(true);
		}
		else {
			valorCliente.setText(null);
			valorFuncionario.setText(null);
			valorMetPag.setText(null);
			valorID.setText(null);
			cadastrarVenda.setVisible(true);
			editarVenda.setVisible(false);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		janela.setVisible(false);
		this.pai.setVisible(true);		
		
		if(src == botaoSalvar) {
			try {
				boolean res;				
				novoDado[1] = valorMetPag.getText();
				novoDado[2] = valorFuncionario.getText();
				novoDado[3] = valorCliente.getText();
				novoDado[4] = valorID.getText();
				novoDado[0] = Integer.toString(dados.getQtd());
				res = dados.inserir(novoDado);
								
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();		
		if(e.getValueIsAdjusting() && src == listaItensVenda) {			
			telaDetalheItem.setVenda(venda, listaItensVenda.getSelectedIndex());
			janela.setVisible(false);
			detalheItem.setVisible(true);
		}
	}
	
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n " + "Nem todos os campos foram preenchidos, \n"
	+ "Dados com tipos inválidos\n" + "OU Cliente/Funcionário inexistente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n"+ 
							"Dê o refresh antes de excluir a próxima venda.", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}
