package controller;

import java.util.List;

public interface ZeroFuncao {
	public List<Double> calcular(double[] variaveis, double a, double b, double erro);
	public void gerarGrafico(double[] funcao,String titulo);
	public void gerarTabela(double[] variaveis, String title);
}
