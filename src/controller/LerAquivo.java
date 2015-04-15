package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LerAquivo {
	Scanner scanner;

	String cidades;
	ArrayList<String> cidadesA = new ArrayList<String>();

	public void ler() {
		try {
			scanner = new Scanner(
					new FileReader(
							"/Users/Usuário/workspace/ExServlets/WebContent/resources/arquivotexto/frutas.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void cidadesA() {
		while (scanner.hasNextLine()) {
			cidades = scanner.nextLine();
			if (cidades.startsWith("A")) {
				this.cidadesA.add(cidades);
			}
		}
	}

}

