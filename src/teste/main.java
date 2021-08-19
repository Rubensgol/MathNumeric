package teste;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import controller.CalculaZeroFuncao;
import model.Bissecao;

public class main {

	public static void main(String[] args) {

		double[] variavels = { 1, 0, -3 };
		CalculaZeroFuncao czf = new CalculaZeroFuncao(new Bissecao());
		System.out.println(czf.calcular(variavels, 1.5, 1.7, 0.5));
		czf.gerarGrafico("nr", variavels);
		czf.gerarTabela(variavels);
	}


	

}
