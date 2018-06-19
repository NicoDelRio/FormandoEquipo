package clase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FormandoEquipo extends Ejercicio{

	private File entrada;
	private File salida;
	
	public FormandoEquipo(File entrada, File salida) {
		super(entrada, salida);
		this.entrada = entrada;
		this.salida = salida;
	}

	public static void main(String[] args) {
		String dirIn = "Estructura de Carpetas\\Preparacion de la Prueba\\Lote de Prueba\\Entrada\\";
		String dirOut = "Estructura de Carpetas\\Ejecucion de Prueba\\Salida Obtenida\\";
		File[] v_file = new File(dirIn).listFiles();
		for (File fileIn : v_file) {
			File fileOut = new File(dirOut + fileIn.getName().replace(".in", ".out"));
			
			System.out.println("Ejecutando: " + fileIn.getName());
			long ini = System.currentTimeMillis();
			
			Ejercicio ejer = new FormandoEquipo(fileIn, fileOut);
			ejer.resolver();
			
			long fin = System.currentTimeMillis();
			System.out.println("Finalizado. Tiempo de Ejecucion: " + (fin - ini) + " milisegundos.\n");
		}
	}

	@Override
	public void resolver() {
		
		try {
			Scanner entrada = new Scanner(this.entrada);
			
//			int preguntas = entrada.nextInt();
			entrada.nextInt();
			int colaboradores = entrada.nextInt();
			entrada.nextLine();
			
			String[] v_respuestas = new String[colaboradores];
			for (int i = 0; i < v_respuestas.length; i++) {
				v_respuestas[i] = entrada.nextLine();
			}
			
			entrada.close();
			
			PrintWriter salida = new PrintWriter(this.salida);
			
			int cont, afinidad = 0; 
			String linea_correcta = null;
			do {
				Arrays.sort(v_respuestas);
				cont = 1;
				
				for (int i = 0; i < v_respuestas.length - 1; i++) {
					if(v_respuestas[i].equals(v_respuestas[i+1])) {
						cont++;
						if(afinidad < cont * v_respuestas[i].length() * v_respuestas[i].length()) {
							afinidad = cont * v_respuestas[i].length() * v_respuestas[i].length();
							linea_correcta = v_respuestas[i];
						}
					}
					else {
						cont = 1;
					}
				}
				if(v_respuestas[0].length() > 0) {
					for (int i = 0; i < v_respuestas.length; i++) {
						v_respuestas[i] = v_respuestas[i].substring(0, v_respuestas[i].length() - 1);
					}
				}
			}while(v_respuestas[0].length() > 0);
			

//			salida.println(cont * linea_correcta.length() * linea_correcta.length());
			System.out.println(afinidad);
			salida.println(afinidad);
			
			if(linea_correcta != null) {
				System.out.println(linea_correcta);
				salida.println(linea_correcta);
			}
			
			salida.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
