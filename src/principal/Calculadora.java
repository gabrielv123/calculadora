package principal;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import LogsFiltros.filtrosoloMultiplicar;
import Logs_Formatos.FormatoHTML;
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

	// Primer Handler //
	private static final LogManager logManager = LogManager.getLogManager();
	private static final Logger LOGGER = Logger.getLogger("confLogger");

	static {

		try {

			logManager.readConfiguration(new FileInputStream("./Properties/configLognulo.properties"));

		}

		catch (IOException exception) {

			LOGGER.log(Level.SEVERE, "Error al cargar la configuracion", exception);
		}
	}

	public static void main(String[] args) {

		// Segundo Handler //
		configurarlog();

		// Variables //
		int resultado = 0;
		int[] operandos = new int[2];
		String operacion = "";

		// Objetos //
		Menu menu = new Menu();
		Operaciones operaciones = new Operaciones();

		// Bucle de Calculadora //
		do {

			operandos = menu.pedirNumeros();
			operacion = menu.menuOpciones();

			try {

				// Suma //
				if (operacion.equalsIgnoreCase("+")) {

					resultado = operaciones.sumar(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				}

				// Resta //
				else if (operacion.equalsIgnoreCase("-")) {

					resultado = operaciones.restar(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				}

				// Multiplicar //
				else if (operacion.equalsIgnoreCase("*")) {

					resultado = operaciones.multiplicar(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);

				}

				// Division //
				else if (operacion.equalsIgnoreCase("/")) {

					resultado = operaciones.dividir(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				}

				// porcentaje //
				else if (operacion.equalsIgnoreCase("%")) {

					resultado = operaciones.resto(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				}

				else {

					System.out.println("Operacion no valida");
				}

				// Logger Level Fine //
				LOGGER.log(Level.FINE, operacion + " " + operandos[0] + " " + operandos[1] + " " + resultado);

			}

			catch (ArithmeticException e) {

				// Logger Level Warning //
				LOGGER.log(Level.WARNING, "no puedes dividir entre cero ", e);

				System.out.println("no puedes divir entre cero " + e.getMessage());
			}

		} while (menu.repetir());
	}

	// Metodo de configuracion del segundo Handler //
	public static void configurarlog() {

		// Logger Creacion //
		Handler consoleHandler = null;
		Handler fileHandler = null;

		try {

			consoleHandler = new ConsoleHandler();
			fileHandler = new FileHandler("./LOGS/operacionesMultiplicar.html");

			// Formato Consola //
			fileHandler.setFormatter(new FormatoHTML());
			fileHandler.setFilter(new filtrosoloMultiplicar());

			LOGGER.addHandler(consoleHandler);
			LOGGER.addHandler(fileHandler);

			consoleHandler.setLevel(Level.ALL);
			fileHandler.setLevel(Level.ALL);
			LOGGER.setLevel(Level.ALL);

		}

		catch (IOException exception) {

			LOGGER.log(Level.SEVERE, "Ocurrio un error en FileHandler.", exception);

		}

	}
}

//elimina el handler por defecto que crea la consola
// LOGGER.Manager.getLogManager().reset();