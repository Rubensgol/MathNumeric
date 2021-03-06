package model;

import java.awt.Rectangle;
import java.io.FileOutputStream;

import de.progra.charting.ChartEncoder;
import de.progra.charting.ChartUtilities;
import de.progra.charting.CoordSystem;
import de.progra.charting.DefaultChart;
import de.progra.charting.model.DefaultChartDataModel;
import de.progra.charting.model.DefaultDataSet;
import de.progra.charting.render.LineChartRenderer;
import util.Equacao;

/**
 * Classe responsavel por gerar os grafico no plano cartesiano
 * utilizando o frameWork charting 
 * @author Rubens
 */
public class GerarGrafico {
	
	/**
	 * Metodo principal que gera o grafico a partir das constantes passadas
	 * @param funcao constantes da funcao para se montada no plano cartesiano
	 * @param titulo do grafico
	 * @param zero o zero encontrado nos metodos usados
	 * @return retorna verdadeiro caso o grafico for gerado corretamente e false se nao
	 */
	public static boolean geraGraficoF(double[] funcao,String titulo, double zero) {
		double[] xis = new double[10];
		double[] y = new double[10];
		String legenda="O zero da funcao:"+zero;
		int pos = 0;
		for (int i = -5; i < 5; i++) {
			xis[pos] = Equacao.resolveEquacao(funcao, i);
			y[pos] = i;
			pos++;
		}
		// Creating a data set array
		DefaultDataSet[] ds = new DefaultDataSet[1];

		// Filling all DataSets

		ds[0] = new DefaultDataSet(ChartUtilities.transformArray(xis), ChartUtilities.transformArray(y),
				CoordSystem.FIRST_YAXIS, legenda);

		String title = titulo;

		int width = 640;
		int height = 480;

		DefaultChartDataModel data = new DefaultChartDataModel(ds);
		data.setAutoScale(true);

		DefaultChart c = new DefaultChart(data, title, DefaultChart.LINEAR_X_LINEAR_Y);
		c.addChartRenderer(new LineChartRenderer(c.getCoordSystem(), data), 1);
		c.setBounds(new Rectangle(0, 0, width, height));

		try {
			ChartEncoder.createPNG(new FileOutputStream("graficos/"+title+".png"), c);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
