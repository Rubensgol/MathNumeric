package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import controller.Equacao;
import controller.ZeroFuncao;

public class Bissecao implements ZeroFuncao {

	@Override
	public List<Double> calcular(double[] variaveis, double a, double b, double erro) {
		List<Double> passos = new ArrayList<Double>();
		double x = 0.0;
		double erroT = erro + 1;
		double fxa;
		double fxb;
		double fxx;
		while (erroT > erro) {
			x = (a + b) / 2;
			passos.add(a);
			passos.add(x);
			passos.add(b);
			fxa = Equacao.resolveEquacao(variaveis, a);
			passos.add(fxa);
			fxb = Equacao.resolveEquacao(variaveis, b);
			fxx = Equacao.resolveEquacao(variaveis, x);
			passos.add(fxx);
			passos.add(fxb);
			if (fxa * fxx < 0)
				b = x;
			else
				a = x;
			erroT = Math.abs(fxx);
			passos.add(erroT);
		}
		passos.add(x);
		return passos;
	}

	@Override
	public void gerarGrafico(double[] funcao, String titulo) {
		List<Double> zero = calcular(funcao, 1, 2, 0.02);
		double z = zero.get(zero.size() - 1);
		GerarGrafico.geraGraficoF(funcao, titulo, z);

	}

	@Override
	public void gerarTabela(double[] variaveis,String title) {
		List<Double> vetor = calcular(variaveis, 1, 2, 0.02);
		String html2 = "<html>\r\n" + "  <head>\r\n"
				+ "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n"
				+ "    <script type=\"text/javascript\">\r\n"
				+ "      google.charts.load('current', {'packages':['table']});\r\n"
				+ "      google.charts.setOnLoadCallback(drawTable);\r\n" + "\r\n" + "      function drawTable() {\r\n"
				+ "        var data = new google.visualization.DataTable();\r\n" + "var options = {\r\n"
				+ "        chart: {\r\n" + "          title: 'Bisssecao',\r\n"
				+ "          subtitle: 'passo a passo'\r\n" + "        },\r\n" + "        width: 300,\r\n"
				+ "        height: 300,\r\n" + "        axes: {\r\n" + "          x: {\r\n"
				+ "            0: {side: 'top'}\r\n" + "          }\r\n" + "        }\r\n" + "      };\r\n"
				+ "        data.addColumn('number', 'n');\r\n" + "        data.addColumn('number', 'a');\r\n"
				+ "        data.addColumn('number', 'xn');\r\n" + "        data.addColumn('number', 'b');\r\n"
				+ "        data.addColumn('number', 'f(a)');\r\n" + "        data.addColumn('number', 'f(xn)');\r\n"
				+ "        data.addColumn('number', 'f(b)');\r\n" + "        data.addColumn('number', 'erro');\r\n"
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
		int a = 0;
		int xn = 1;
		int b = 2;
		int fa = 3;
		int fxn = 4;
		int fb = 5;
		int erro = 6;
		int repeticao = vetor.size() - 1;
		repeticao = repeticao / 7;
		for (int i = 0; i < repeticao; i++) {
			dados += "[" + String.valueOf(i + 1) + ", " + String.valueOf(vetor.get(a)) + ", "
					+ String.valueOf(vetor.get(xn)) + ", " + String.valueOf(vetor.get(b)) + ", "
					+ String.valueOf(vetor.get(fa)) + ", " + String.valueOf(vetor.get(fxn)) + ", "
					+ String.valueOf(vetor.get(fb)) + ", " + String.valueOf(vetor.get(erro)) + "],\r\n";
			xn += 7;
			fa += 7;
			fb += 7;
			fxn += 7;
			a += 7;
			b += 7;
			erro += 7;
		}
		return dados;
	}

}
