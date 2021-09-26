package controle;

import modelo.*;

public class ControleDados {
	protected Dados d = new Dados();
	
	public ControleDados() {
		d.preCadastro();
	}

	public Dados getDados() {
		return d;
	}

	public void setDados(Dados d) {
		this.d = d;
	}
	
	public Sapato[] getSapatos() {
		return this.d.getdSapatos();
	}
	
	public int getQtdSapato() {
		return this.d.getQtdSapatos();
	}
	
	public Empresa getEmpresa() {
		return this.d.getdEmpresa();
	}
	
	public int getQtdEmpresa() {
		return this.d.getQtdEmpresa();
	}
	
	public Cliente[] getClientes() {
		return this.d.getdClientes();
	}

	
	public Funcionario[] getFuncionarios() {
		return this.d.getdFuncs();
	}
	
	public int getQtdFuncionario() {
		return this.d.getQtdFuncionarios();
	}
	
	public Venda[] getVendas() {
		return this.d.getdVendas();
	}
	
	public int getQtdVenda() {
		return this.d.getQtdVendas();
	}
}
