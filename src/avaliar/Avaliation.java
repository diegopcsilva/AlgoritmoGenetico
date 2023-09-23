package avaliar;
import campoDeTestes.Populacao;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Avaliation {
	double A = 0;
	double B = 0;
	double C = 0;
	double a;
	double b;
	double c;
	boolean Agrau = false;
	boolean Bgrau = false;
	boolean Cgrau = false;
	String expression;
	Populacao Pop;
	
	private double TamanhoPopulacao;
	
	public Avaliation(Populacao pop, String expression, double tamanhoPopulacao, boolean agrau, boolean bgrau, boolean cgrau) {
		Pop = pop;
		this.expression = expression;
		TamanhoPopulacao = tamanhoPopulacao;
		Agrau = agrau;
		Bgrau = bgrau;
		Cgrau = cgrau;
	}

	public Populacao processo(){
		int i=0;
		while(i < TamanhoPopulacao){
			A = Pop.Lista.get(i).getValorA();
			B = Pop.Lista.get(i).getValorB();	
			C = Pop.Lista.get(i).getValorC();	
			//System.out.println("a "+a);
			if(Agrau) a = A*(3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273/180);
			else a = A;
			if(Bgrau) b = B*(3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273/180);
			else b = B;
			if(Cgrau)  c = C*(3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273/180);
			else c = C;
			//net.objecthunter.exp4j.Expression e = new ExpressionBuilder("3 * sin(y) - 2 / (x - 2)")
			net.objecthunter.exp4j.Expression e = new ExpressionBuilder(expression)
			        .variables("x", "y", "z")
			        .build()
			        .setVariable("x", a)
			        .setVariable("y", b)
			        .setVariable("z", c);
			double result = e.evaluate();
			Pop.Lista.get(i).setAvalicao((Double)result);
			Pop.setAvTotal( (int)(Pop.getAvTotal()+result) );
			
			//System.out.println("Resultado avaliação"+e.evaluate());
			i++;
		}
		return Pop;
	}
}
