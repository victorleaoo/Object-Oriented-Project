package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controle.ControleDados;

public class MenuPrincipal implements ActionListener {
	
	private static JFrame janela = new JFrame("Loja de Sapatos");
	private static JLabel titulo = new JLabel("Tela Inicial");
	private static JButton empresa = new JButton("Empresa");
	private static JButton sapato = new JButton("Sapato");
	private static JButton cliente = new JButton("Cliente");
	private static JButton funcionario = new JButton("Funcion�rio");
	private static JButton venda = new JButton("Venda");
	public static ControleDados dados = new ControleDados();
	
	public MenuPrincipal() {
		titulo.setFont(new Font("Helvetica", Font.BOLD, 20));
		titulo.setBounds(140, 10, 150, 30); //Posi��o X, Posi��o Y, Tamanho X, Tamanho Y
		
		janela.setLayout(null);
		
		empresa.setBounds(140, 60, 100, 30);
		sapato.setBounds(140, 100, 100, 30);
		cliente.setBounds(140, 140, 100, 30);
		funcionario.setBounds(140, 180, 100, 30);
		venda.setBounds(140, 220, 100, 30);
		
		janela.add(titulo);
		janela.add(empresa);
		janela.add(sapato);
		janela.add(cliente);
		janela.add(funcionario);
		janela.add(venda);
		
		janela.setSize(400, 350);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	

	public static void main(String[] args) {
		MenuPrincipal menu = new MenuPrincipal();

		empresa.addActionListener(menu);
		sapato.addActionListener(menu);
		cliente.addActionListener(menu);
		funcionario.addActionListener(menu);
		venda.addActionListener(menu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == empresa) 
			JOptionPane.showMessageDialog(null, 
					"Ainda precisam ser implementadas as funcionalidades\n"
					+ "relacionadas a empresa", null, 
					JOptionPane.INFORMATION_MESSAGE);
		
		if(src == sapato) 
			JOptionPane.showMessageDialog(null, 
					"Ainda precisam ser implementadas as funcionalidades\n"
					+ "relacionadas a sapato", null, 
					JOptionPane.INFORMATION_MESSAGE);
		
		if(src == cliente) 
			JOptionPane.showMessageDialog(null, 
					"Ainda precisam ser implementadas as funcionalidades\n"
					+ "relacionadas a cliente", null, 
					JOptionPane.INFORMATION_MESSAGE);
		
		if(src == funcionario) 
			JOptionPane.showMessageDialog(null, 
					"Ainda precisam ser implementadas as funcionalidades\n"
					+ "relacionadas a funcionario", null, 
					JOptionPane.INFORMATION_MESSAGE);
		
		if(src == venda) 
			JOptionPane.showMessageDialog(null, 
					"Ainda precisam ser implementadas as funcionalidades\n"
					+ "relacionadas a venda", null, 
					JOptionPane.INFORMATION_MESSAGE);
	}

}
