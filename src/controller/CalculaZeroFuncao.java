package controller;

import java.util.List;

public class CalculaZeroFuncao {
	private ZeroFuncao zerofuncao;

	public CalculaZeroFuncao(ZeroFuncao zerofuncao) {
		this.zerofuncao = zerofuncao;
	}

	public double calcular(double[] variaveis, double a, double b, double erro) {
		List<Double> zr = zerofuncao.calcular(variaveis, a, b, erro);
		return zr.get(zr.size() - 1);
	}

	public void gerarGrafico(String titulo, double[] variaveis) {
		zerofuncao.gerarGrafico(variaveis, titulo);
	}

	public void gerarTabela(double[] variaveis, String title) {
		zerofuncao.gerarTabela(variaveis);
	}
}
