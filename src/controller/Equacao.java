package controller;

public final class Equacao {
	private Equacao() {
	};

	public static double resolveEquacao(double[] variaveis, double x) {
		double resultado = 0;
		for (int i = 0; i < variaveis.length - 1; i++) {
			double eleva = Math.pow(x, variaveis.length - i - 1);
			resultado += variaveis[i] * eleva;
		}
		resultado += variaveis[variaveis.length - 1];
		return resultado;
	}

	public static double resolveEquacao(double[][] variaveis, double x) {
		double resultado = 0;
		for (int i = 0; i < variaveis.length - 1; i++) {
			double eleva = Math.pow(x, variaveis[i][1]);
			resultado += variaveis[i][0] * eleva;
		}
		resultado += variaveis[variaveis.length - 1][0];
		return resultado;
	}

	public static double derivada(double[] variaveis, double x) {
		double resultado[] = new double[variaveis.length - 1];
		double deriva;
		for (int i = 0; i < variaveis.length - 1; i++) {
			resultado[i] = variaveis[i] * (variaveis.length - i - 1);

		}
		deriva = resolveEquacao(resultado, x);
		return deriva;
	}

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
