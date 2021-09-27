package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Venda;

public class TelaDetalheItem implements ActionListener {
	private JFrame janela;
	private JLabel labelSapato = new JLabel("Sapato: ");
	private JTextField valorSapato;
	private JLabel labelQntd = new JLabel("Quantidade: ");
	private JTextField valorQntd;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];

	private int posicaoItem = -1;
	private Venda vendaSelecionada;
	
	public void inserirEditar(Venda venda, int item) {
		
		janela = new JFrame("Detalhe Item");
		
		posicaoItem = item;
		vendaSelecionada = venda;
		
		valorSapato = new JTextField(venda.getSapatos().get(item).getS().getNomeSapato(), 200);
		valorQntd = new JTextField(String.valueOf(venda.getSapatos().get(item).getQntdVenda()), 200);
		
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();				
		if(src == botaoExcluir) { 			
			vendaSelecionada.getSapatos().remove(posicaoItem);
			mensagemSucessoExclusao();  
		}
	}
	
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
}
