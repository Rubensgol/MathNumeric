package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import controller.ZeroFuncao;

public class Baskara implements ZeroFuncao {
	/**
	 * Metodo mais tradicional e simples manualmente o bascara usa contas
	 * matematicas para encontrar os xis de equacoes do segundo grau
	 * 
	 * @param variaveis da equacao que se deseja encontar os xis
	 * @return retorna uma lista de double com todos os passos feito para encontar o
	 *         resultado
	 * 
	 */
	@Override
	public List<Double> calcular(double[] variaveis, double a, double b, double erro) {
		List<Double> passos = new ArrayList<Double>();
		if (variaveis.length > 3)
			return null;
		else {
			double zeros[] = new double[2];
			double delta = (variaveis[1] * variaveis[1]) - (4 * variaveis[0] * variaveis[2]);
			passos.add(delta);
			zeros[0] = ((-1 * variaveis[1]) - Math.sqrt(delta));
			passos.add(zeros[0]);
			zeros[0] = zeros[0] / 2 * variaveis[0];
			passos.add(zeros[0]);
			zeros[1] = ((-1 * variaveis[1]) + Math.sqrt(delta));
			passos.add(zeros[1]);
			zeros[1] = zeros[1] / 2 * variaveis[0];
			passos.add(zeros[1]);
			return passos;
		}
	}

	@Override
	public void gerarGrafico(double[] funcao, String titulo) {
		List<Double> zero = calcular(funcao, 0, 0, 0);
		double z = zero.get(zero.size() - 1);
		GerarGrafico.geraGraficoF(funcao, titulo, z);

	}

	@Override
	public void gerarTabela(double[] variaveis, String title) {
		List<Double> vetor = calcular(variaveis, 0, 0, 0);
		String html2 = "<html>\r\n" + "  <head>\r\n"
				+ "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n"
				+ "    <script type=\"text/javascript\">\r\n"
				+ "      google.charts.load('current', {'packages':['table']});\r\n"
				+ "      google.charts.setOnLoadCallback(drawTable);\r\n" + "\r\n" + "      function drawTable() {\r\n"
				+ "        var data = new google.visualization.DataTable();\r\n" + "var options = {\r\n"
				+ "        chart: {\r\n" + "          title: 'Baskara ',\r\n"
				+ "          subtitle: 'passo a passo'\r\n" + "        },\r\n" + "        width: 300,\r\n"
				+ "        height: 300,\r\n" + "        axes: {\r\n" + "          x: {\r\n"
				+ "            0: {side: 'top'}\r\n" + "          }\r\n" + "        }\r\n" + "      };\r\n"
				+ "        data.addColumn('number', 'Delta');\r\n" 
				+ "        data.addColumn('number', 'x1');\r\n"
				+ "        data.addColumn('number', 'x2');\r\n" 
				+ "data.addRows([\r\n" + arrumaDados(vetor) + "        ]);\r\n"
				+ "        var table = new google.visualization.Table(document.getElementById('table_div'));" + "\r\n"
				+ "		table.draw(data, options);" + "\r\n" + "      }\r\n" + "    </script>\r\n" + "  </head>\r\n"
				+ "  <body>\r\n" + "    <div id=\"table_div\"></div>\r\n" + "  </body>\r\n" + "</html>";

		FileWriter arq = null;
		try {
			arq = new FileWriter("..//grafico.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter gravarArq = new PrintWriter(arq);

		gravarArq.printf(html2);
		try {
			arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String arrumaDados(List<Double> vetor) {
		String dados = "";

		dados += "[" + String.valueOf(vetor.get(0)) + ", " + String.valueOf(vetor.get(1)) + ", "
				+ String.valueOf(vetor.get(3)) + "],\r\n";
		dados += "[" + String.valueOf(vetor.get(0)) + ", " + String.valueOf(vetor.get(2))+ ", " + String.valueOf(vetor.get(4)) + "]\r\n";

		return dados;
	}
}
