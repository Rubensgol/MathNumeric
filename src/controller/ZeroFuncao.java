package controller;

import java.util.List;

/**
 * Interface que cria os metodos de calcular, gerarGrafico e gerar tabela
 * 
 * @author Rubens
 * 
 */
public interface ZeroFuncao {
	/**
	 * metodo que calcula o zero da funcao
	 * 
	 * @param variaveis as constantes da funcao que se deseja encontrar o zero da
	 *                  funcao
	 * @param a         limite inferior do intervalo
	 * @param b         limite superior do intervalo
	 * @param erro      variavel do criterio de parada
	 * @return retorna uma lista de double com todos os passos feito
	 */
	public List<Double> calcular(double[] variaveis, double a, double b, double erro);

	/**
	 * Metodo que gera o grafico da funcao passada com destaque para o zero da
	 * funcao
	 * 
	 * @param titulo    que sera salvo o grafico
	 * @param funcao array com as constantes da funcao que se deseja calcular
	 */
	public void gerarGrafico(double[] funcao, String titulo);

	/**
	 * Metodo para gerar a tabela com o passo a passo feito pelo metodo para
	 * encontrar o zero da funcao
	 * 
	 * @param variaveis array com as constantes da funcao que se deseja calcular
	 * @param title     titulo da tabela
	 */
	public void gerarTabela(double[] variaveis, String title);
}
