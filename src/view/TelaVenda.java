package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleVenda;

public class TelaVenda implements ActionListener, ListSelectionListener {
	private JFrame janela = new JFrame("Vendas");
	private JLabel titulo = new JLabel("Controle de Vendas");
	private JButton botaoCadastrar = new JButton("Cadastrar Venda");
	private JButton refresh = new JButton("Refresh");
	private JTextField busca;
	public static ControleVenda dados;
	private JList<String> listaVendasCadastradas = new JList<String>(createDefaultListModel());
	private String[] listaNomeVendas = new String[50];
	private JPanel panelListaVendas = new JPanel();
	private JPanel manterVenda;
	private TelaDetalheVenda telaDetalheVenda = new TelaDetalheVenda();
	
	public JTextField createTextField() {
		final JTextField field = new JTextField("Nome do Funcionário", 200);
        field.getDocument().addDocumentListener(new DocumentListener(){
            @Override public void insertUpdate(DocumentEvent e) { filter(); }
            @Override public void removeUpdate(DocumentEvent e) { filter(); }
            @Override public void changedUpdate(DocumentEvent e) {}
            private void filter() {
                String filter = field.getText();
                filterModel((DefaultListModel<String>)listaVendasCadastradas.getModel(), filter);
            }
        });
        return field;
	}
	
	private ListModel<String> createDefaultListModel(){ // Transformando os nomes dos clientes em uma ListModel para buscar
		dados = new ControleVenda();		
		listaNomeVendas = dados.getNomeVendas();
		DefaultListModel<String> model = new DefaultListModel<>();
		for (String s : listaNomeVendas) {
			model.addElement(s);
		}
		return model;
	}
	
    public void filterModel(DefaultListModel<String> model, String filter) { // Sistema de Busca
		dados = new ControleVenda();		
		listaNomeVendas = dados.getNomeVendas();
        for (String s : listaNomeVendas) {
            if (!s.startsWith(filter)) {
                if (model.contains(s)) {
                    model.removeElement(s);
                }
            } else {
                if (!model.contains(s)) {
                    model.addElement(s);
                }
            }
        }
    }
	
	public void mostrarVendas() {
		
		busca = createTextField();
						
		listaVendasCadastradas.setBounds(20, 50, 350, 120);
		listaVendasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaVendasCadastradas.setVisibleRowCount(10);
		titulo.setFont(new Font("Helvetica", Font.BOLD, 20));		
		titulo.setBounds(95, 0, 250, 30);
		busca.setBounds(220, 30, 150, 20);
		botaoCadastrar.setBounds(70, 177, 100, 30);
		refresh.setBounds(200, 177, 100, 30);
						
		panelListaVendas.setLayout(null);
		panelListaVendas.add(titulo);
		panelListaVendas.add(listaVendasCadastradas);
		panelListaVendas.add(botaoCadastrar);
		panelListaVendas.add(refresh);
		janela.add(busca);
		panelListaVendas.setSize(400, 400);
		
		janela.setLayout(null);
		janela.getContentPane().add(BorderLayout.CENTER, panelListaVendas);
				
		manterVenda = telaDetalheVenda.inserirEditar(dados);
		telaDetalheVenda.setParent(panelListaVendas);
		
		manterVenda.setVisible(false);
		janela.getContentPane().add(BorderLayout.CENTER, manterVenda);
		
		janela.setSize(400, 320);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
		botaoCadastrar.addActionListener(this);
		refresh.addActionListener(this);
		listaVendasCadastradas.addListSelectionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de nova Venda
		if(src == botaoCadastrar) {
			telaDetalheVenda.setVenda(-1);
			panelListaVendas.setVisible(false);
			busca.setVisible(false);
			manterVenda.setVisible(true);
		}
		
		if(src == refresh) {
			listaVendasCadastradas.setListData(dados.getNomeVendas());
			listaVendasCadastradas.updateUI();
		}		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaVendasCadastradas) {
			telaDetalheVenda.setVenda(listaVendasCadastradas.getSelectedIndex());
			panelListaVendas.setVisible(false);
			busca.setVisible(false);
			manterVenda.setVisible(true);
		}
		
	}
}
