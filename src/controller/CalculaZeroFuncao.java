package controller;

import java.util.List;
/**
 * 
 * @author Rubens
 *Classe que executa os metodos, de encontar um zero de uma funcao,
 *gerar um grafico com o zero de uma funcao e gerar uma tabela do passo a passo
 *realizado pelo metodo  
 *a partir da classe escolhida na hora de instanciar o objeto
 *@see ZeroFuncao
 */
public class CalculaZeroFuncao {

	private ZeroFuncao zerofuncao;
	/**
	 * Construtor que recebe a classe que vai ser utilizada para os calculos
	 * @param zerofuncao
	 */
	public CalculaZeroFuncao(ZeroFuncao zerofuncao) {
		this.zerofuncao = zerofuncao;
	}

	/**
	 * Metodo que realiza o calculo e encontra o 0 da funcao dentro do intervalo
	 * @param variaveis array com as constantes da funcao que se deseja calcular
	 * @param a limite inferior do intervalo
	 * @param b limite superior do intervalo
	 * @param erro erro limite para a parada 
	 * @return retorna o zero da funcao encontrado no intervalo
	 */
	public double calcular(double[] variaveis, double a, double b, double erro) {
		List<Double> zr = zerofuncao.calcular(variaveis, a, b, erro);
		return zr.get(zr.size() - 1);
	}
	/**
	 * Metodo que gera o grafico da funcao passada com destaque para o zero da funcao
	 * @param titulo que sera salvo o grafico
	 * @param variaveis array com as constantes da funcao que se deseja calcular
	 */
	public void gerarGrafico(String titulo, double[] variaveis) {
		zerofuncao.gerarGrafico(variaveis, titulo);
	}
	/**
	 * Metodo para gerar a tabela com o passo a passo feito pelo metodo
	 * para encontrar o zero da funcao
	 * @param variaveis array com as constantes da funcao que se deseja calcular
	 * @param title titulo da tabela 
	 */
	public void gerarTabela(double[] variaveis, String title) {
		zerofuncao.gerarTabela(variaveis,title);
	}
}
