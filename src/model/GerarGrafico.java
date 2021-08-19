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

public class GerarGrafico {

	public static void geraGraficoF(double[] funcao,String titulo, double zero) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
