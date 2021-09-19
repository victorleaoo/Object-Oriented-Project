package interfacegrafica.cliente;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import principal.Cliente;

public class ClienteListar extends JFrame {
    
	private static final long serialVersionUID = 1L;
		
	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JButton btInserir = new JButton("Inserir");
	private JButton btExcluir = new JButton("Excluir");
	private JButton btEditar = new JButton("Editar");
	private DefaultTableModel modelo = new DefaultTableModel();

    public ClienteListar() {
        super ("Clientes");
        criaJTable();
		criaJanela();
    }

    public void criaJanela(){
				
    	setSize(720, 320);
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(2, 1));
		painelFundo.add(barraRolagem);
		
		painelBotoes = new JPanel();
		painelBotoes.add(btInserir);
		painelBotoes.add(btEditar);
		painelBotoes.add(btExcluir);
		painelFundo.add(painelBotoes);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setVisible(true);
		btInserir.addActionListener(new BtInserirListener());
		btEditar.addActionListener(new BtEditarListener());
		btExcluir.addActionListener(new BtExcluirListener());
    }    
    
    private void criaJTable() {
		modelo.addColumn("Nome");
		modelo.addColumn("Telefone");
		modelo.addColumn("Email");
		modelo.addColumn("Endereço");
		tabela = new JTable(modelo);				
		tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(20);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
		pesquisar(modelo);
	}
    
	public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		ClienteDao dao = new ClienteDao();
		for (Cliente c : dao.getLista()) {
			modelo.addRow(new Object[]{c.getNome(),	c.getTelefone(), c.getEmail(), c.getEndCliente()});
		}
	}
	
	private class BtInserirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			ClienteIncluir ic = new ClienteIncluir(modelo);
			ic.setVisible(true);
		}
	}

	private class BtEditarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada >= 0) {				
				ClienteAlterar ic = new ClienteAlterar(modelo, linhaSelecionada);
				ic.setVisible(true);				
			} else {
				JOptionPane.showMessageDialog(null,	"Selecione uma linha.");
			}
		}
	}

	private class BtExcluirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada >= 0) {
				//int idContato = (int)
				tabela.getValueAt(linhaSelecionada, 0);
				//ContatoDao dao = new ContatoDao();
				//dao.remover(idContato);
				modelo.removeRow(linhaSelecionada);
			} else {
				JOptionPane.showMessageDialog(null,	"Selecione uma linha.");
			}
		}
	}
}