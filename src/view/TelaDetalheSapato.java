package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ControleDados;

public class TelaDetalheSapato implements ActionListener {
	
	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelMarca = new JLabel("Marca: ");
	private JTextField valorMarca;
	private JLabel labelModelo = new JLabel("Modelo: ");
	private JTextField valorModelo;
	private JLabel labelPreco = new JLabel("Preço (em reais): ");
	private JTextField valorPreco;
	private JLabel labelGradeTamanhos = new JLabel("Grade de Tamanhos: ");
	private JTextField valorMenor;
	private JTextField valorMaior;
	private JLabel labelDescricao = new JLabel("Descrição: ");
	private JTextField valorDescricao;
	private JLabel labelFoto = new JLabel("Foto do Produto: ");
	private JTextField valorFoto;
	private JLabel labelEstoque = new JLabel("Estoque disponível: ");
	private JTextField valorEstoque;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;
	
	public void inserirEditar(int op, ControleDados d, TelaSapato spt, int pos) {
		
		opcao = op;
		posicao = pos;
		dados = d;
		
		if (op == 1) s = "Cadastro de Sapato";
		if (op == 2) s = "Detalhe de Sapato";
		
		janela = new JFrame(s);
		
		if (op == 2) { //Preenche dados com dados do sapato clicado
			
			valorNome = new JTextField(dados.getSapatos()[pos].getNomeSapato(), 200);
			valorMarca = new JTextField(dados.getSapatos()[pos].getMarca(), 200);
			valorModelo = new JTextField(String.valueOf(dados.getSapatos()[pos].getModelo()), 1);
			valorPreco = new JTextField(String.valueOf(dados.getSapatos()[pos].getPreco()), 200);
			valorMenor = new JTextField(String.valueOf(dados.getSapatos()[pos].getMenorTam()), 4);
			valorMaior = new JTextField(String.valueOf(dados.getSapatos()[pos].getMaiorTam()), 4);
			valorDescricao = new JTextField(dados.getSapatos()[pos].getDescricao(), 200);
			valorFoto = new JTextField(dados.getSapatos()[pos].getFotoSapato(), 200);
			valorEstoque = new JTextField(String.valueOf(dados.getSapatos()[pos].getQntdEstoque()), 200);
			
		} else { //Não preenche com dados

			valorNome = new JTextField(200);
			valorMarca = new JTextField(200);
			valorModelo = new JTextField(1);
			valorPreco = new JTextField(200);
			valorMenor = new JTextField(4);
			valorMaior = new JTextField(4);
			valorDescricao = new JTextField(200);
			valorFoto = new JTextField(200);
			valorEstoque = new JTextField(200);

			botaoSalvar.setBounds(245, 175, 115, 30);
		}
		
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelMarca.setBounds(30, 50, 150, 25);
		valorMarca.setBounds(180, 50, 180, 25);
		labelModelo.setBounds(30, 80, 150, 25);
		valorModelo.setBounds(180, 80, 180, 25);
		labelPreco.setBounds(30, 110, 150, 25);
		valorPreco.setBounds(180, 110, 180, 25);
		labelGradeTamanhos.setBounds(30, 140, 150, 25);
		valorMenor.setBounds(180, 140, 80, 25);
		valorMaior.setBounds(280, 140, 80, 25);
		labelDescricao.setBounds(30, 170, 150, 25);
		valorDescricao.setBounds(180, 170, 180, 25);
		labelFoto.setBounds(30, 200, 150, 25);
		valorFoto.setBounds(180, 200, 180, 25);
		labelEstoque.setBounds(30, 230, 150, 25);
		valorEstoque.setBounds(180, 230, 180, 25);
		
		//Coloca botoes de excluir e salvar
		if (op == 2) {
			botaoSalvar.setBounds(120, 280, 115, 30);
			botaoExcluir.setBounds(245, 280, 115, 30);
			this.janela.add(botaoExcluir);
		}
		
		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelMarca);
		this.janela.add(valorMarca);
		this.janela.add(labelModelo);
		this.janela.add(valorModelo);
		this.janela.add(labelPreco);
		this.janela.add(valorPreco);
		this.janela.add(labelGradeTamanhos);
		this.janela.add(valorMenor);
		this.janela.add(valorMaior);
		this.janela.add(labelDescricao);
		this.janela.add(valorDescricao);
		this.janela.add(labelFoto);
		this.janela.add(valorFoto);
		this.janela.add(labelEstoque);
		this.janela.add(valorEstoque);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(420, 360);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
