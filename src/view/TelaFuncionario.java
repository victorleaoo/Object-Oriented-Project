package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import controle.ControleCliente;
import controle.ControleDados;
import controle.ControleFunc;

public class TelaFuncionario {
	private JFrame janela = new JFrame("Funcionários");
	private JLabel titulo = new JLabel("Controle de Funcionários");
	private JButton cadastrarFunc = new JButton("Cadastrar Funcionário");
	private JButton refresh = new JButton("Refresh");
	public static ControleDados dados;
	private JList<String> listaFuncCadastrados;
	private String[] listaNomesFuncs = new String[50];
	
	public void mostrarFuncionarios(ControleDados d) {
		dados = d;
		
		listaNomesFuncs = new ControleFunc(dados).getNomeFuncs();
		listaFuncCadastrados = new JList<String>(listaNomesFuncs);
		
		titulo.setFont(new Font("Helvetica", Font.BOLD, 20));
		titulo.setBounds(90, 10, 250, 30);
		listaFuncCadastrados.setBounds(20, 50, 350, 120);
		listaFuncCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaFuncCadastrados.setVisibleRowCount(10);
		
		cadastrarFunc.setBounds(70, 177, 100, 30);
		refresh.setBounds(200, 177, 100, 30);
		
		janela.setLayout(null);

		janela.add(titulo);
		janela.add(listaFuncCadastrados);
		janela.add(cadastrarFunc);
		janela.add(refresh);

		janela.setSize(400, 250);
		janela.setVisible(true);
	}
}
