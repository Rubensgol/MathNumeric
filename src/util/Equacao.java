package util;

/**
 * Classe utilizada para realizar o calculo da funcoes e das derivadas
 * 
 * @author Rubens
 *
 */
public final class Equacao {
	/**
	 * Construtor privado para evitar que ela seja instanciada
	 */
	private Equacao() {
	};

	/**
	 * Metodo para resolver equações polinomias de graus inteiros
	 * 
	 * @param variaveis constantes da função a ser resolvida
	 * @param x         valor que se deseja encontrar o F(x)
	 * @return retorna o valor Y=F(x)
	 */
	public static double resolveEquacao(double[] variaveis, double x) {
		double resultado = 0;
		for (int i = 0; i < variaveis.length - 1; i++) {
			double eleva = Math.pow(x, variaveis.length - i - 1);
			resultado += variaveis[i] * eleva;
		}
		resultado += variaveis[variaveis.length - 1];
		return resultado;
	}

	/**
	 * Metodo para resolver equações polinomias de graus reais
	 * 
	 * @param variaveis constantes da função, e seus expoentes, a ser resolvida
	 * @param x         valor que se deseja encontrar o F(x)
	 * @return retorna o valor Y=F(x)
	 */
	public static double resolveEquacao(double[][] variaveis, double x) {
		double resultado = 0;
		for (int i = 0; i < variaveis.length - 1; i++) {
			double eleva = Math.pow(x, variaveis[i][1]);
			resultado += variaveis[i][0] * eleva;
		}
		resultado += variaveis[variaveis.length - 1][0];
		return resultado;
	}

	/**
	 * realiza a derivação de funções polinomiais com graus inteiros e calcula o
	 * valor Y do x passado
	 * 
	 * @param variaveis constantes da funcao
	 * @param x         valor x para ser usado na equacao
	 * @return o valor encontrado da derivada
	 */
	public static double derivada(double[] variaveis, double x) {
		double resultado[] = new double[variaveis.length - 1];
		double deriva;
		for (int i = 0; i < variaveis.length - 1; i++) {
			resultado[i] = variaveis[i] * (variaveis.length - i - 1);

		}
		deriva = resolveEquacao(resultado, x);
		return deriva;
	}

	/**
	 * realiza a derivação de funções polinomiais com graus reais e calcula o valor
	 * Y do x passado
	 * 
	 * @param variaveis constantes e graus da funcao
	 * @param x         valor x para ser usado na equacao
	 * @return o valor encontrado da derivada
	 */
	public static double derivada(double[][] variaveis, double x) {
		double resultado[] = new double[variaveis.length - 1];
		double deriva;
		for (int i = 0; i < variaveis.length - 1; i++) {
			resultado[i] = variaveis[i][0] * (variaveis[i][1]);

		}
		deriva = resolveEquacao(resultado, x);
		return deriva;
	}

}
