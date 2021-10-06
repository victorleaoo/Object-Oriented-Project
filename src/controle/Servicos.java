package controle;

public class Servicos {
	
	public static ControleEmpresa dadosEmpresa;
	
	// Cliente
	public static boolean validaEmail(String email) {
		if(email.contains("@") && !(email.startsWith("@"))) {
			return true;
		}
		return false;
	}
	
	//Funcionário
	public static boolean validaIDFunc(int id) {
		if(id >= 0) {
			return true;
		}
		return false;
	}
	
	public static boolean validaAnoIng(int ano) {
		dadosEmpresa = new ControleEmpresa();
		if(ano >= dadosEmpresa.getEmpresa().getAnoFund() && ano <= 2021) {
			return true;
		}
		return false;
	}
	
	//Empresa
	public static boolean validaAnoFund(int ano) {
		if(ano >= 1000) { //Ter pelo menos 4 dígitos.
			return true;
		}
		return false;
	}
	
	//Sapato
	public static boolean validaModelo(char modelo) {
		if(modelo == 'C' || modelo == 'c' || modelo == 'S' || modelo == 's' || modelo == 'E' || modelo == 'e'){
			return true;
		}
		return false;
	}
	
	public static boolean validaTamanho(double tamanho) {
		if(tamanho >= 15 && tamanho <= 46) { //Tamanhos comuns
			return true;
		}
		return false;
	}
	
	//Venda
	public static boolean validaMetPag(char metpag) {
		if(metpag == 'C' || metpag == 'c' || metpag == 'B' || metpag == 'b' || metpag == 'P' || metpag == 'p'){
			return true;
		}
		return false;
	}
	
	//Gerais
	public static boolean validaDouble(double valor) { 
		if(valor >= 0) {
			return true;
		}
		return false;
	}

}
