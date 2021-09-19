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

public class ClienteAlterar extends JFrame {
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelo =
			new DefaultTableModel();
			private JPanel painelFundo;
			private JButton btSalvar;
			private JButton btLimpar;
			private JLabel lbNome;
			private JLabel lbTelefone;
			private JLabel lbEmail;
			private JLabel lbEndereco;
			private JTextField txNome;
			private JTextField txEndereco;
			private JTextField txTelefone;
			private JTextField txEmail;
			Cliente cliente;
			private int linhaSelecionada;

			public ClienteAlterar(DefaultTableModel md, int linha) {
				super("Clientes");
				criaJanela();
				modelo = md;
				ClienteDao dao = new ClienteDao();
				cliente = dao.getContatoByLinha(linha);
				txNome.setText(cliente.getNome());
				txTelefone.setText(cliente.getTelefone());
				txEmail.setText(cliente.getEmail());
				txEndereco.setText(cliente.getEndCliente());
				linhaSelecionada = linha;
			}

			public void criaJanela() {
				btSalvar = new JButton("Salvar");
				btLimpar = new JButton("Limpar");
				lbNome = new JLabel("         Nome.:   ");
				lbTelefone = new JLabel("         Telefone.:   ");
				lbEmail = new JLabel("         Email.:   ");
				lbEndereco = new JLabel("         Endereço.:   ");
				txNome = new JTextField();
				txTelefone = new JTextField();
				txEmail = new JTextField();
				txEndereco = new JTextField();				

				painelFundo = new JPanel();
				painelFundo.setLayout(new GridLayout(5, 2, 2, 4));
				painelFundo.add(lbNome);
				painelFundo.add(txNome);
				painelFundo.add(lbTelefone);
				painelFundo.add(txTelefone);
				painelFundo.add(lbEmail);
				painelFundo.add(txEmail);
				painelFundo.add(lbEndereco);
				painelFundo.add(txEndereco);				
				painelFundo.add(btLimpar);
				painelFundo.add(btSalvar);

				getContentPane().add(painelFundo);
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setSize(300, 150);
				setVisible(true);

				btSalvar.addActionListener(new	ClienteAlterar.BtSalvarListener());
				btLimpar.addActionListener(new	ClienteAlterar.BtLimparListener());
			}

			private class BtSalvarListener implements ActionListener {

				public void actionPerformed(ActionEvent e) {
					Cliente c = new Cliente(txNome.getText(), txTelefone.getText(), txEmail.getText(), txEndereco.getText());					
					ClienteDao dao = new ClienteDao();
					dao.atualizar(c, linhaSelecionada);
					modelo.removeRow(linhaSelecionada);
					modelo.addRow(new Object[]{c.getNome(), c.getTelefone(), c.getEmail(), c.getEndCliente()});
					setVisible(false);
				}
			}

			private class BtLimparListener implements ActionListener {

				public void actionPerformed(ActionEvent e) {
					txNome.setText("");
					txTelefone.setText("");
					txEmail.setText("");
					txEndereco.setText("");
				}
			}
}
