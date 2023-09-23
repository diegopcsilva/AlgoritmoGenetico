package campoDeTestes;
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
import java.util.Random;

public class Populacao {
	private double LimiteInferior;
	private double LimiteSuperior;
	private Random gerador = new Random();
	private double Tam;
	public ArrayList<Individuo> Lista = new ArrayList<Individuo>();
	private double AvTotal = 0;

	public double getAvTotal() {
		return AvTotal;
	}

	public void setAvTotal(double avTotal) {
		AvTotal = avTotal;
	}

	public Populacao(double limiteInferior, double limiteSuperior, double Tam) {
		super();
		LimiteInferior = limiteInferior;
		LimiteSuperior = limiteSuperior;
		this.Tam = Tam;
	}
	public Populacao(Populacao outro) {
		this.LimiteInferior = outro.LimiteInferior;
		this.LimiteSuperior = outro.LimiteSuperior;
		this.Tam = outro.Tam;
		this.Lista = outro.Lista;
		this.AvTotal = outro.AvTotal;
	}

	public Populacao(double limiteInferior, double limiteSuperior, Random gerador, double tam,
			ArrayList<Individuo> lista, double avTotal) {
		super();
		LimiteInferior = limiteInferior;
		LimiteSuperior = limiteSuperior;
		this.gerador = gerador;
		Tam = tam;
		Lista = lista;
		AvTotal = avTotal;
	}

	public void Init(double tam){
		while(tam > 0){
		//System.out.println();
		Lista.add( new Individuo (gerador.nextInt((int)LimiteSuperior)-gerador.nextInt((int) LimiteInferior),gerador.nextInt((int)LimiteSuperior)-gerador.nextInt((int) LimiteInferior),gerador.nextInt((int)LimiteSuperior)-gerador.nextInt((int) LimiteInferior) ));
		//System.out.println(-gerador.nextInt(10));
		tam--;
		}
	//view((int)Tam);
	}
	public void view(int tam){
		   //Collections.sort(Lista);
		for(int i = 0;i<tam;i++){
			System.out.println(Lista.get(i).getValorA());
			System.out.println(Lista.get(i).getValorB());
			System.out.println(Lista.get(i).getValorC());
			System.out.println(Lista.get(i).getAvalicao());
			System.out.println();
		
		}
	}
	
	public void remover(int qnt){
		for(int i = 0; i<qnt;i++){
			Lista.remove(i);
		}
	}
	public void ordenar(int Tam){
		boolean stop = true;
		while(stop){
			stop = false;
			for(int j = 0;j<Tam-1;j++){
				if (Lista.get(j).getAvalicao() > Lista.get(j+1).getAvalicao()){
					Lista.add(Lista.get(j));
					Lista.remove(j);
					stop = true;
				}
			}
		}
	}
	public void somarAv(){
		setAvTotal(0);
		for(int i =0; i<Lista.size();i++){
			setAvTotal(getAvTotal()+Math.abs(Lista.get(i).avalicao));
		}
	}
	public Individuo selecaoRoleta(){
		somarAv();
		double acc=0;
		if(AvTotal<1){
			for(int i =0; i < Lista.size();i++) {
				acc+=Lista.get(i).getAvalicao();
				System.out.println(AvTotal);
				double comp = gerador.nextDouble()-AvTotal;
				if(comp<0) comp =0;
				if(comp<acc){
					return Lista.get(i);
				}
			}
		}
		for(int i =0; i < Lista.size();i++) {
			acc+=Lista.get(i).getAvalicao();
			System.out.println(AvTotal);

			if(gerador.nextInt((int)AvTotal)<acc){
				return Lista.get(i);
			}
		}
		return null;
	}

	public void recebePopulacao(double steadyState, Populacao pop0) {

		for(int i=(int)steadyState;i<pop0.Lista.size();i++ ){
			Lista.add(pop0.Lista.get(i));
		}
		
	}

	public Object clone() {
		
		return new Populacao(this);
	}
}