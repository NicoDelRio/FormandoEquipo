package clase;

import java.io.File;

public abstract class Ejercicio {

	protected File entrada;
	protected File salida;

	public Ejercicio(File entrada, File salida) {
		this.entrada = entrada;
		this.salida = salida;
	}
	
	public abstract void resolver();
}
