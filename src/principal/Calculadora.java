package principal;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import logs.LogConsolaMasFichero;
import menu.Menu;
import operaciones.Operaciones;

/**
 * 
 * @author gabriel
 * 
 * @apiNote esta clase sera la que ejecute todos los metodos de la clase de menu
 *          y operaciones para hacer una calculadora simple
 * 
 */
public class Calculadora {

	private static final Logger LOGGER = Logger.getLogger(Calculadora.class.getName());

	public static void main(String[] args) {

		int resultado = 0;
		int[] operandos = new int[2];

		String operacion = "";

		Menu menu = new Menu();
		Operaciones operaciones = new Operaciones();

		// Logger Creacion //
		Handler consoleHandler = null;
		Handler fileHandler = null;

		try {

			consoleHandler = new ConsoleHandler();
			fileHandler = new FileHandler("./LOGS/operaciones.log");

			System.out.println(LOGGER.getHandlers().length);

			// Formato Consola //
			fileHandler.setFormatter(new SimpleFormatter());

			LOGGER.addHandler(consoleHandler);
			LOGGER.addHandler(fileHandler);

			consoleHandler.setLevel(Level.ALL);
			fileHandler.setLevel(Level.ALL);
			LOGGER.setLevel(Level.ALL);

			LOGGER.config("Configuracion hecha.");

			// Eliminamos handler de la consola
			LOGGER.removeHandler(consoleHandler);
			LOGGER.log(Level.FINE, "Nivel de log cambiado a FINE");

		}

		catch (IOException exception) {

			LOGGER.log(Level.SEVERE, "Ocurrio un error en FileHandler.", exception);

		}

		LOGGER.finer("Ejemplo con log FINE en LOGGER completado.");

		do {

			operandos = menu.pedirNumeros();
			operacion = menu.menuOpciones();

			try {

				if (operacion.equalsIgnoreCase("+")) {

					resultado = operaciones.sumar(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				}

				else if (operacion.equalsIgnoreCase("-")) {

					resultado = operaciones.restar(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				}

				else if (operacion.equalsIgnoreCase("*")) {

					resultado = operaciones.multiplicar(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				}

				else if (operacion.equalsIgnoreCase("/")) {

					resultado = operaciones.dividir(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				}

				else if (operacion.equalsIgnoreCase("%")) {

					resultado = operaciones.resto(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				}

				else {

					System.out.println("Operación no válida");
				}

				// Logger Level Fine //
				LOGGER.log(Level.FINE, " operando 1 " + operandos[0] + " operando 2 ", +operandos[1]);

			}

			catch (ArithmeticException e) {

				// Logger Level Warning //
				LOGGER.log(Level.WARNING, "no puedes dividir entre cero ", e);
				System.out.println("no puedes divir entre cero " + e.getMessage());

			}

		} while (menu.repetir());
	}
}

//elimina el handler por defecto que crea la consola
// LOGGER.Manager.getLogManager().reset();