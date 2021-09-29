package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleCliente;
import controle.ControleDados;
import controle.ControleSapato;

public class TelaCliente implements ActionListener, ListSelectionListener {
	private JFrame janela = new JFrame("Clientes");
	private JLabel titulo = new JLabel("Controle de Clientes");
	private JButton cadastrarCliente = new JButton("Cadastrar Cliente");
	private JButton refresh = new JButton("Refresh");
	private JTextField busca;
	public static ControleCliente dados;
	private JList<String> listaClientesCadastrados = new JList<String>(createDefaultListModel());
	private String[] listaNomesClientes = new String[50];
	
	public JTextField createTextField() {
		final JTextField field = new JTextField("Nome do Cliente", 200);
        field.getDocument().addDocumentListener(new DocumentListener(){
            @Override public void insertUpdate(DocumentEvent e) { filter(); }
            @Override public void removeUpdate(DocumentEvent e) { filter(); }
            @Override public void changedUpdate(DocumentEvent e) {}
            private void filter() {
                String filter = field.getText();
                filterModel((DefaultListModel<String>)listaClientesCadastrados.getModel(), filter);
            }
        });
        return field;
	}
	
	private ListModel<String> createDefaultListModel(){ // Transformando os nomes dos clientes em uma ListModel para buscar
		dados = new ControleCliente();
		listaNomesClientes = dados.getNomeClientes();
		DefaultListModel<String> model = new DefaultListModel<>();
		for (String s : listaNomesClientes) {
			model.addElement(s);
		}
		return model;
	}
	
    public void filterModel(DefaultListModel<String> model, String filter) { // Sistema de Busca
		dados = new ControleCliente();
		listaNomesClientes = dados.getNomeClientes();
        for (String s : listaNomesClientes) {
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
	
	public void mostrarClientes() {
		
		busca = createTextField();
		
		titulo.setFont(new Font("Helvetica", Font.BOLD, 20));
		titulo.setBounds(95, 0, 250, 30);
		busca.setBounds(220, 30, 150, 20);
		listaClientesCadastrados.setBounds(20, 50, 350, 120);
		listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaClientesCadastrados.setVisibleRowCount(10);
		
		cadastrarCliente.setBounds(70, 177, 100, 30);
		refresh.setBounds(200, 177, 100, 30);
		
		janela.setLayout(null);

		janela.add(titulo);
		janela.add(listaClientesCadastrados);
		janela.add(cadastrarCliente);
		janela.add(refresh);
		janela.add(busca);

		janela.setSize(400, 250);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
		cadastrarCliente.addActionListener(this);
		refresh.addActionListener(this);
		listaClientesCadastrados.addListSelectionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo cliente
		if(src == cadastrarCliente)
			new TelaDetalheCliente().inserirEditar(1, dados, this, 0);
		
		// Atualiza a lista de nomes de clientes mostrada no JList
		if(src == refresh) {
			listaClientesCadastrados.setListData(dados.getNomeClientes());			
			listaClientesCadastrados.updateUI();
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaClientesCadastrados) {
			new TelaDetalheCliente().inserirEditar(2, dados, this, 
					listaClientesCadastrados.getSelectedIndex());
		}
	}
	
}
