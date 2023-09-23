package moduloDeComunicacao;
import avaliar.Avaliation;
import campoDeTestes.Populacao;
import operadoresGeneticos.OperadoresGeneticos;
public class Main {
	public static void main(String[] args) {
		int Generation = 0;
		double TamanhoPopulacao = 200;
		double TaxaCrossover = 0.8;
		double TaxaMutacao = 0.2;
		double NumeroDeGeracoes = 100;
		double SteadyState = 1;
		double LimiteInferior = 1;
		double LimiteSuperior = 33;
		boolean Agrau = false;
		boolean Bgrau = false;
		boolean Cgrau = false;
		boolean gerando = true;
		//String expression = "1/(x+1)/(y+1)/(z+1)";
		//String expression ="x+y+z";
		String expression ="1/(exp(sinh(x)-1)+cosh(y)+tan(z^2))";
		System.out.println("Início ");
		Populacao Pop0 = new Populacao(LimiteInferior, LimiteSuperior, TamanhoPopulacao);
		Pop0.Init(TamanhoPopulacao);
		while(gerando){
			Avaliation av = new Avaliation(Pop0, expression, TamanhoPopulacao, Agrau,Bgrau,Cgrau);
			Pop0 = (Populacao) av.processo().clone();
			Pop0.ordenar((int)TamanhoPopulacao);
			Generation++;
			if(Generation==NumeroDeGeracoes){
				System.out.println("Generation "+ Generation);
				System.out.println("População Total "+ TamanhoPopulacao*Generation);
				System.out.println("Resultado encontrado "+Pop0.Lista.get(Pop0.Lista.size()-1).getAvalicao());
				break;
			}
			Pop0.remover((int)SteadyState);
			Populacao Pop1 = new Populacao(LimiteInferior, LimiteSuperior, TamanhoPopulacao);
			Pop1.recebePopulacao(SteadyState, Pop0);
			OperadoresGeneticos OpeGen = new OperadoresGeneticos(Pop0, Pop1, TamanhoPopulacao, TaxaCrossover, TaxaMutacao, LimiteSuperior, LimiteInferior);
			Pop1 = (Populacao) OpeGen.CrossoverMutation().clone();
			//POPULA��O 1 GERADA, APAGAR POP0
			Pop0.Lista.clear();
			Pop0.setAvTotal(0);
			//AVALIA��O POP1
			Avaliation av1 = new Avaliation(Pop1, expression, TamanhoPopulacao, Agrau,Bgrau,Cgrau);
			Pop1 = (Populacao) av1.processo().clone();
			Pop1.ordenar((int)TamanhoPopulacao);
			++Generation;//asdad
			if(Generation==NumeroDeGeracoes){
				System.out.println("Generation "+ Generation);
				System.out.println("População Total "+ TamanhoPopulacao*Generation);
				System.out.println("Resultado encontrado "+Pop1.Lista.get(Pop1.Lista.size()-1).getAvalicao());
				break;
			}
			Pop1.remover((int)SteadyState);
			Pop0.recebePopulacao(SteadyState, Pop1);
			OperadoresGeneticos OpeGen2 = new OperadoresGeneticos(Pop1, Pop0, TamanhoPopulacao, TaxaCrossover, TaxaMutacao, LimiteSuperior, LimiteInferior);
			Pop0 = (Populacao) OpeGen2.CrossoverMutation().clone();
			//POPULA��O 2 GERADA, APAGAR POP1
			Pop1.Lista.clear();
			Pop1.setAvTotal(0);
		}
		System.out.println("Fim");
	}
}