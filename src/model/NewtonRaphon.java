package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import controller.Equacao;
import controller.ZeroFuncao;

public class NewtonRaphon implements ZeroFuncao {

	@Override
	public List<Double> calcular(double[] variaveis, double a, double b, double erro) {
		List<Double> passos = new ArrayList<Double>();
		double x = a;
		double erroT = erro + 1;
		double fx;
		double flx;
		while (erroT > erro) {
			fx = Equacao.resolveEquacao(variaveis, x);
			passos.add(x);
			passos.add(fx);
			flx = Equacao.derivada(variaveis, x);
			passos.add(flx);
			x = x - fx / flx;
			passos.add(x);
			erroT = Math.abs(Equacao.resolveEquacao(variaveis, x));
			passos.add(erroT);
		}
		passos.add(x);
		return passos;
	}

	@Override
	public void gerarGrafico(double[] funcao, String titulo) {
		List<Double> zero = calcular(funcao, 0, 0, 0);
		double z = zero.get(zero.size() - 1);
		GerarGrafico.geraGraficoF(funcao, titulo, z);
	}

	@Override
	public void gerarTabela(double[] variaveis, String title) {
		List<Double> vetor = calcular(variaveis, 0,0, 0.002);
		String html2 = "<html>\r\n" + "  <head>\r\n"
				+ "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n"
				+ "    <script type=\"text/javascript\">\r\n"
				+ "      google.charts.load('current', {'packages':['table']});\r\n"
				+ "      google.charts.setOnLoadCallback(drawTable);\r\n" + "\r\n" + "      function drawTable() {\r\n"
				+ "        var data = new google.visualization.DataTable();\r\n" + "var options = {\r\n"
				+ "        chart: {\r\n" + "          title: 'NewTonRaphon',\r\n"
				+ "          subtitle: 'passo a passo'\r\n" + "        },\r\n" + "        width: 300,\r\n"
				+ "        height: 300,\r\n" + "        axes: {\r\n" + "          x: {\r\n"
				+ "            0: {side: 'top'}\r\n" + "          }\r\n" + "        }\r\n" + "      };\r\n"
				+ "        data.addColumn('number', 'n');\r\n" + "        data.addColumn('number', 'xn');\r\n"
				+ "        data.addColumn('number', 'f(xn)');\r\n" + "        data.addColumn('number', 'derivada(xn)');\r\n"
				+ "        data.addColumn('number', 'xn+1');\r\n" + "        data.addColumn('number', 'erro');\r\n"
				+ "data.addRows([\r\n" + arrumaDados(vetor) + "        ]);\r\n"
				+ "        var table = new google.visualization.Table(document.getElementById('table_div'));" + "\r\n"
				+ "		table.draw(data, options);" + "\r\n" + "      }\r\n" + "    </script>\r\n" + "  </head>\r\n"
				+ "  <body>\r\n" + "    <div id=\"table_div\"></div>\r\n" + "  </body>\r\n" + "</html>";

		FileWriter arq = null;
		try {
			arq = new FileWriter("tabelas/"+title+".html");
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
		int xn = 0;
		int fxn = 1;
		int flx = 2;
		int xn1 = 3;
		int erro = 4;
		int repeticao = vetor.size() - 1;
		repeticao = repeticao / 5;
		for (int i = 0; i < repeticao; i++) {
			dados += "[" + String.valueOf(i + 1) + ", " + String.valueOf(vetor.get(xn)) + ", "
					+ String.valueOf(vetor.get(fxn)) + ", " + String.valueOf(vetor.get(flx)) + ", "
					+ String.valueOf(vetor.get(xn1)) + ", " + String.valueOf(vetor.get(erro)) + "],\r\n";
			xn += 5;
			fxn += 5;
			flx += 5;
			xn1 += 5;
			erro += 5;
		}
		return dados;
	}

}
