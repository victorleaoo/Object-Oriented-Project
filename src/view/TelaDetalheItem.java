package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Venda;

public class TelaDetalheItem implements ActionListener {
	private JPanel janela;
	private JPanel pai;
	private JLabel labelSapato = new JLabel("Sapato: ");
	private JTextField valorSapato;
	private JLabel labelQntd = new JLabel("Quantidade: ");
	private JTextField valorQntd;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	//private String[] novoDado = new String[9];

	private int posicaoItem = -1;
	private Venda vendaSelecionada;
	
	public JPanel inserirEditar() {
		
		janela = new JPanel();
				
		valorSapato = new JTextField("", 200);
		valorQntd = new JTextField("", 200);
		
		labelSapato.setBounds(30, 20, 150, 25);
		valorSapato.setBounds(180, 20, 180, 25);
		labelQntd.setBounds(30, 50, 150, 25);
		valorQntd.setBounds(180, 50, 180, 25);	
		
		botaoSalvar.setBounds(120, 80, 115, 30);
		botaoExcluir.setBounds(245, 80, 115, 30);
		
		this.janela.add(labelSapato);
		this.janela.add(valorSapato);
		this.janela.add(labelQntd);
		this.janela.add(valorQntd);
		this.janela.add(botaoSalvar);
		this.janela.add(botaoExcluir);
		
		this.janela.setLayout(null);

		this.janela.setSize(400, 160);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		
		return janela;
	}
	
	public void setVenda(Venda venda, int item) {
		posicaoItem = item;
		vendaSelecionada = venda;		
		valorSapato.setText(venda.getSapatos().get(item).getS().getNomeSapato());
		valorQntd.setText(String.valueOf(venda.getSapatos().get(item).getQntdVenda()));		
	}
	
	public void setParent(JPanel pai) {
		this.pai = pai;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();				
		if(src == botaoExcluir) { 			
			vendaSelecionada.getSapatos().remove(posicaoItem);
			mensagemSucessoExclusao();  
		}
		janela.setVisible(false);
		this.pai.setVisible(true);		
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
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n " + "Nem todos os campos foram preenchidos OU \n"
	+ "Dados com tipos inválidos", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n"+ 
							"Dê o refresh antes de excluir o próximo funcionário.", null, 
				JOptionPane.ERROR_MESSAGE);
	}
}
