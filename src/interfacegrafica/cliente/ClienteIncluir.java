package interfacegrafica.cliente;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import principal.Cliente;

public class ClienteIncluir  extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel painelFundo;
	private JButton btSalvar;
	private JButton btLimpar;
	private JLabel lbNome;
	private JLabel lbTelefone;
	private JLabel lbEmail;
	private JTextField txNome;
	private JTextField txTelefone;
	private JTextField txEmail;

	public ClienteIncluir(DefaultTableModel md) {
		super("Clientes");
		criaJanela();
		modelo = md;
	}

	public void criaJanela() {
		btSalvar = new JButton("Salvar");
		btLimpar = new JButton("Limpar");
		lbNome = new JLabel("         Nome.:   ");
		lbTelefone = new JLabel("         Telefone.:   ");
		lbEmail = new JLabel("         Email.:   ");
		txNome = new JTextField(10);
		txTelefone = new JTextField();
		txEmail = new JTextField();

		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(4, 2, 2, 4));
		painelFundo.add(lbNome);
		painelFundo.add(txNome);
		painelFundo.add(lbTelefone);
		painelFundo.add(txTelefone);
		painelFundo.add(lbEmail);
		painelFundo.add(txEmail);
		painelFundo.add(btLimpar);
		painelFundo.add(btSalvar);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 150);
		setVisible(true);
		btSalvar.addActionListener(new BtSalvarListener());
		btLimpar.addActionListener(new BtLimparListener());
	}

	private class BtSalvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Cliente c = new Cliente(txNome.getText(), txTelefone.getText(), txEmail.getText(), "-");

			ClienteDao dao = new ClienteDao();
			dao.inserir(c);
			ClienteListar.pesquisar(modelo);
			setVisible(false);
		}
	}


	private class BtLimparListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			txNome.setText("");
			txTelefone.setText("");
			txEmail.setText("");
		}
	}

}
