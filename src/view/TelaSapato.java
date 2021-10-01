package view;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controle.ControleSapato;

public class TelaSapato implements ActionListener, ListSelectionListener {
	private JFrame janela = new JFrame("Sapatos");
	private JLabel titulo = new JLabel("Controle de Sapatos");
	private JButton cadastrarSapato = new JButton("Cadastrar Sapato");
	private JButton refresh = new JButton("Refresh");
	private JTextField busca;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu filtroMenu = new JMenu("Filtros");
	private JMenuItem todosFiltro = new JMenuItem("Todos Sapatos");
	private JMenuItem casualFiltro = new JMenuItem("Casual");
	private JMenuItem sandaliaFiltro = new JMenuItem("Sandália");
	private JMenuItem esportivoFiltro = new JMenuItem("Esportivo");
	public static ControleSapato dados;
	private JList<String> listaSapatosCadastrados = new JList<String>(createDefaultListModel());
	private String[] listaNomesSapatos = new String[50];

	public JTextField createTextField() { // Caixa de texto para buscar sapato
		final JTextField field = new JTextField("Nome do Sapato", 200);
		DefaultListModel<String> model = (DefaultListModel<String>)listaSapatosCadastrados.getModel();
        field.getDocument().addDocumentListener(new DocumentListener(){
            @Override public void insertUpdate(DocumentEvent e) { filter(); }
            @Override public void removeUpdate(DocumentEvent e) { filter(); }
            @Override public void changedUpdate(DocumentEvent e) {}
            private void filter() {
                String filter = field.getText();
                filterModel(model, filter);
            }
        });
        return field;
	}
	
	private ListModel<String> createDefaultListModel(){ // Transformando os nomes dos sapatos em uma ListModel para buscar
		dados = new ControleSapato();
		listaNomesSapatos = dados.getNomeSpts();
		DefaultListModel<String> model = new DefaultListModel<>();
		for (String s : listaNomesSapatos) {
			model.addElement(s);
		}
		return model;
	}
	
    public void filterModel(DefaultListModel<String> model, String filter) { // Sistema de Busca
		dados = new ControleSapato();
		listaNomesSapatos = dados.getNomeSpts();
        for (String s : listaNomesSapatos) {
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
	
	public void mostrarSapatos() {
		
		busca = createTextField();
		
		menuBar.add(filtroMenu);
		filtroMenu.add(todosFiltro);
		filtroMenu.add(casualFiltro);
		filtroMenu.add(sandaliaFiltro);
		filtroMenu.add(esportivoFiltro);
		
		todosFiltro.addActionListener(this);
		casualFiltro.addActionListener(this);
		sandaliaFiltro.addActionListener(this);
		esportivoFiltro.addActionListener(this);
		
		titulo.setFont(new Font("Helvetica", Font.BOLD, 20));
		titulo.setBounds(95, 0, 250, 30);
		busca.setBounds(220, 30, 150, 20);
		listaSapatosCadastrados.setBounds(20, 50, 350, 120);
		listaSapatosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaSapatosCadastrados.setVisibleRowCount(10);
		
		cadastrarSapato.setBounds(70, 177, 100, 30);
		refresh.setBounds(200, 177, 100, 30);
		
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);

		janela.add(titulo);
		janela.add(listaSapatosCadastrados);
		janela.add(cadastrarSapato);
		janela.add(refresh);
		janela.add(busca);

		janela.setJMenuBar(menuBar);
		janela.setSize(400, 275);
		janela.setVisible(true);
		
		
		cadastrarSapato.addActionListener(this);
		refresh.addActionListener(this);
		listaSapatosCadastrados.addListSelectionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo sapato
		if(src == cadastrarSapato) {
			new TelaDetalheSapato().inserirEditar(1, dados, this, null);
		}
		
		// Atualiza a lista de nomes de sapatos mostrada no JList
		if(src == refresh || src == todosFiltro) {
			listaSapatosCadastrados.setListData(dados.getNomeSpts());	
			listaSapatosCadastrados.updateUI();
		}
		
		// Atualiza a lista de nomes de sapatos para sapatos casuais
		if(src == casualFiltro) {
			listaSapatosCadastrados.setListData(dados.getNomeCasual());	
			listaSapatosCadastrados.updateUI();
		}
		
		// Atualiza a lista de nomes de sapatos para sandalias
		if(src == sandaliaFiltro) {
			listaSapatosCadastrados.setListData(dados.getNomeSandalia());	
			listaSapatosCadastrados.updateUI();
		}
		
		// Atualiza a lista de nomes de sapatos para sapatos esportivos
		if(src == esportivoFiltro) {
			listaSapatosCadastrados.setListData(dados.getNomeEsportivo());	
			listaSapatosCadastrados.updateUI();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		dados = new ControleSapato();

		if(e.getValueIsAdjusting() && src == listaSapatosCadastrados) {
			new TelaDetalheSapato().inserirEditar(2, dados, this, 
					listaSapatosCadastrados.getSelectedValue());
		}
		
	}
	
}
