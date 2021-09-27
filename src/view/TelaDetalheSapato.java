package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controle.ControleSapato;

public class TelaDetalheSapato implements ActionListener {
	
	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelMarca = new JLabel("Marca: ");
	private JTextField valorMarca;
	private JLabel labelModelo = new JLabel("Modelo: ");
	private JTextField valorModelo;
	private JLabel labelPreco = new JLabel("Pre�o (em reais): ");
	private JTextField valorPreco;
	private JLabel labelGradeTamanhos = new JLabel("Grade de Tamanhos: ");
	private JTextField valorMenor;
	private JTextField valorMaior;
	private JLabel labelDescricao = new JLabel("Descri��o: ");
	private JTextArea valorDescricao;
	private JScrollPane paneDescricao;
	private JLabel labelFoto = new JLabel("Foto do Produto: ");
	private ImageIcon valorFoto;
	private JLabel fotoSapato;
	private JLabel labelURL = new JLabel("Diret�rio da Imagem: ");
	private JTextField valorURL;
	private JLabel labelEstoque = new JLabel("Estoque dispon�vel: ");
	private JTextField valorEstoque;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[10];
	private static ControleSapato dados;
	private int posicao;
	private int opcao;
	private String s;
	
	public void inserirEditar(int op, ControleSapato d, TelaSapato spt, int pos) {
		
		opcao = op;
		posicao = pos;
		dados = d;
		
		if (op == 1) s = "Cadastro de Sapato";
		if (op == 2) s = "Detalhe de Sapato";
		
		janela = new JFrame(s);
		
		if (op == 2) { //Preenche dados com dados do sapato clicado
			
			valorNome = new JTextField(d.getLista()[pos].getNomeSapato(), 200);
			valorMarca = new JTextField(dados.getLista()[pos].getMarca(), 200);
			valorModelo = new JTextField(String.valueOf(dados.getLista()[pos].getModel()), 1);
			valorPreco = new JTextField(String.valueOf(dados.getLista()[pos].getPreco()), 200);
			valorMenor = new JTextField(String.valueOf(dados.getLista()[pos].getMenorTam()), 4);
			valorMaior = new JTextField(String.valueOf(dados.getLista()[pos].getMaiorTam()), 4);
			valorDescricao = new JTextArea(dados.getLista()[pos].getDescricao(), 0, 200);
			valorDescricao.setLineWrap(true);
			valorDescricao.setEditable(true);
			valorEstoque = new JTextField(String.valueOf(dados.getLista()[pos].getQntdEstoque()), 200);
			
		} else { //N�o preenche com dados

			valorNome = new JTextField(200);
			valorMarca = new JTextField(200);
			valorModelo = new JTextField(1);
			valorPreco = new JTextField(200);
			valorMenor = new JTextField(4);
			valorMaior = new JTextField(4);
			valorDescricao = new JTextArea(3, 200);
			valorURL = new JTextField(200);
			valorEstoque = new JTextField(200);

			botaoSalvar.setBounds(245, 285, 115, 30);
		}
		
		paneDescricao = new JScrollPane(valorDescricao);
		paneDescricao.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		paneDescricao.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		valorFoto = new ImageIcon(new ImageIcon(getClass().getResource(dados.getLista()[pos].getFotoSapato())).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		fotoSapato = new JLabel(valorFoto);
		
		var y = 20;
		
		labelNome.setBounds(30, y, 150, 25);
		valorNome.setBounds(180, y, 180, 25);
		labelMarca.setBounds(30, y+=30, 150, 25);
		valorMarca.setBounds(180, y, 180, 25);
		labelModelo.setBounds(30, y+=30, 150, 25);
		valorModelo.setBounds(180, y, 180, 25);
		labelPreco.setBounds(30, y+=30, 150, 25);
		valorPreco.setBounds(180, y, 180, 25);
		labelGradeTamanhos.setBounds(30, y+=30, 150, 25);
		valorMenor.setBounds(180, y, 80, 25);
		valorMaior.setBounds(280, y, 80, 25);
		labelDescricao.setBounds(30, y+=30, 150, 25);
		paneDescricao.setBounds(180, y, 180, 50);
		labelFoto.setBounds(30, y+=55, 150, 25);
		fotoSapato.setBounds(180, y, 100, 100);
		
		//Seta informa��es diferentes dependendo do bot�o selecionado
		if (op == 2) {
			botaoSalvar.setBounds(120, 370, 115, 30);
			botaoExcluir.setBounds(245, 370, 115, 30);
			labelEstoque.setBounds(30, y+=110, 150, 25);
			valorEstoque.setBounds(180, y, 180, 25);
			
			this.janela.setSize(420, 450);
			
			this.janela.add(botaoExcluir);
			
			this.janela.add(labelFoto);
			this.janela.add(fotoSapato);
		}
		else {
			labelURL.setBounds(30, 225, 150, 25);
			valorURL.setBounds(180, 225, 180, 25);
			
			labelEstoque.setBounds(30, y+=30, 150, 25);
			valorEstoque.setBounds(180, y, 180, 25);
			
			this.janela.setSize(420, 360);
			
			this.janela.add(valorURL);
			this.janela.add(labelURL);
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
		this.janela.add(paneDescricao);
		this.janela.add(labelEstoque);
		this.janela.add(valorEstoque);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoSalvar) {
			try {
				boolean res;				
				novoDado[1] = valorNome.getText();
				novoDado[2] = valorMarca.getText();
				novoDado[3] = valorModelo.getText();
				novoDado[4] = valorPreco.getText();
				novoDado[5] = valorMenor.getText();
				novoDado[6] = valorMaior.getText();
				novoDado[7] = valorDescricao.getText();
				novoDado[8] = valorEstoque.getText();				
				if(opcao == 1) { //Cadastro de novo sapato
					novoDado[0] = Integer.toString(dados.getQtd());
					novoDado[9] = valorURL.getText();
					res = dados.inserir(novoDado);
				}
				else { //Edi��o de Sapato				
					novoDado[0] = Integer.toString(posicao);
					novoDado[9] = dados.getLista()[posicao].getFotoSapato();
					res = dados.editar(novoDado);
				}
												
				if(res) {
					mensagemSucessoCadastro();
				} else mensagemErroCadastro();
			}
			catch (NullPointerException exc1) {
				exc1.printStackTrace();
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				exc2.printStackTrace();
				mensagemErroCadastro();
			}
		}
		
		
		if(src == botaoExcluir) { 
			boolean res = false;
		 
		//exclui sapato
			res = dados.remover(posicao);
			if (res) mensagemSucessoExclusao(); 
			else mensagemErroExclusao(); 
		}
		
	}
	
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n " + "Nem todos os campos foram preenchidos OU \n"
	+ "Dados com tipos inv�lidos", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n"+ 
							"D� o refresh antes de excluir o pr�ximo funcion�rio.", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}