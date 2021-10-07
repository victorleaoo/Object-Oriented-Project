package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controle.ControleVenda;
import modelo.ItensVenda;
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
	private JButton botaoAlterar = new JButton("Salvar");
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoVoltar = new JButton("Voltar");
	private JButton botaoVoltarCadastro = new JButton("Voltar");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoItem = new JButton("Adicionar Item");
	private String[] novoDado = new String[9];
	private static ControleVenda dados;
	private int posicao;
	
	private JList<String> listaItensVenda;
	private Venda venda;
	private TelaDetalheItem telaDetalheItem = new TelaDetalheItem();
	private JTable table = new JTable();
	
	public JPanel inserirEditar(ControleVenda d) {
			
		dados = d;
			
		janela = new JPanel(new GridLayout(2, 2));
		
		//this.janela.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.janela.setSize(650, 400);
		
		venda = null;		
		valorCliente = new JTextField(200);
		valorFuncionario = new JTextField(200);
		valorMetPag = new JTextField(1);	
		valorID = new JTextField(2);				
												
		table.setModel(createTableModel());
		
		JPanel panel = new JPanel();
		panel.setSize(400, 200);
		panel.setBorder(BorderFactory.createTitledBorder(
		         BorderFactory.createEtchedBorder(), "Itens", TitledBorder.CENTER, TitledBorder.TOP));
		var scrollPane = new JScrollPane(table);
		scrollPane.setSize(350, 150);
		panel.add(scrollPane);						
		
		JPanel panelDados = new JPanel(new GridLayout(5, 2));
				
		editarVenda = new JPanel();
		editarVenda.setSize(400, 300);
		//editarVenda.add(listaItensVenda);
		editarVenda.add(botaoAlterar);
		editarVenda.add(botaoVoltar);
		editarVenda.add(botaoExcluir);
		//editarVenda.add(botaoItem);
		editarVenda.setVisible(true);
		cadastrarVenda = new JPanel();						
		cadastrarVenda.setSize(400, 400);
		cadastrarVenda.add(botaoVoltarCadastro);
		cadastrarVenda.add(botaoSalvar);
		cadastrarVenda.setVisible(false);
								
		panelDados.add(labelCliente);
		panelDados.add(valorCliente);
		panelDados.add(labelFuncionario);
		panelDados.add(valorFuncionario);
		panelDados.add(labelMetPag);
		panelDados.add(valorMetPag);
		panelDados.add(labelID);
		panelDados.add(valorID);
		panelDados.add(editarVenda);
		panelDados.add(cadastrarVenda);
		
		janela.add(panelDados);
		janela.add(panel);
		
		detalheItem = telaDetalheItem.inserirEditar();
		telaDetalheItem.setParent(janela);
		detalheItem.setVisible(false);		
//		janela.add(BorderLayout.CENTER, detalheItem);
		
		this.janela.setVisible(true);
		
		botaoAlterar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		botaoVoltarCadastro.addActionListener(this);
		botaoVoltar.addActionListener(this);
		//listaItensVenda.addListSelectionListener(this);
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
			valorCliente.setText(venda.getC().getNome());
			valorFuncionario.setText(venda.getF().getNome());
			valorMetPag.setText(String.valueOf(venda.getMetPag()));
			valorID.setText(String.valueOf(venda.getID()));
			var mTable = createTableModel();
			var itens = venda.getSapatos();			
			for (ItensVenda item : itens) {				
				mTable.addRow(new Object[]{
						item.getS().getNomeSapato(), item.getQntdVenda(), false});
			}			
			table.setModel(mTable);
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
			table.setModel(createTableModel());
		}
	}

	private DefaultTableModel createTableModel() {		
		return new DefaultTableModel(null, new String[] { "Nome", "Quantidade" });
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
		
		if(src == botaoAlterar) {
			try {
				boolean res;
				novoDado[1] = valorMetPag.getText();
				novoDado[2] = valorFuncionario.getText();
				novoDado[3] = valorCliente.getText();
				novoDado[4] = valorID.getText();
				novoDado[0] = Integer.toString(posicao);
				res = dados.editar(novoDado);
												
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
