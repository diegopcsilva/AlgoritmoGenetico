package campoDeTestes;

public class Individuo {
	double valorA = -1;
	double valorB = -1;
	double valorC = -1;
	Double avalicao = 2.0;
	
	
	public Individuo(int valor1,int valor2,int valor3) {
		super();
		this.valorA = valor1;
		this.valorB = valor2;
		this.valorC = valor3;
	}
	
	public double getValorB() {
		return valorB;
	}

	public void setValorB(double valorB) {
		this.valorB = valorB;
	}

	public double getValorC() {
		return valorC;
	}

	public void setValorC(double valorC) {
		this.valorC = valorC;
	}

	public double getValorA() {
		return valorA;
	}
	public void setValorA(double valor) {
		this.valorA = valor;
	}
	public Double getAvalicao() {
		return avalicao;
	}
	public void setAvalicao(Double avalicao) {
		this.avalicao = avalicao;
	}
	
}
