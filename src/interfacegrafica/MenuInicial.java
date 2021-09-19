package interfacegrafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import interfacegrafica.cliente.ClienteListar;

public class MenuInicial {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial window = new MenuInicial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {},
//			new RowSpec[] {}));
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu entidadeMenu = new JMenu("Entidades");        
        menuBar.add(entidadeMenu);
        
        JMenuItem clienteAction = new JMenuItem("Cliente");
        JMenuItem sapatoAction = new JMenuItem("Sapato");
        JMenuItem funcionarioAction = new JMenuItem("Funcionário");
        JMenuItem empresaAction = new JMenuItem("Empresa");
        JMenuItem vendaAction = new JMenuItem("Venda");
        
        entidadeMenu.add(clienteAction);
        entidadeMenu.add(sapatoAction);
        entidadeMenu.add(funcionarioAction);
        entidadeMenu.add(empresaAction);
        entidadeMenu.addSeparator();
        entidadeMenu.add(vendaAction);
        
        clienteAction.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
                ClienteListar clienteFrame = new ClienteListar();
                clienteFrame.criaJanela();
        	}
        });
        
		frame.setJMenuBar(menuBar);
	}
}
