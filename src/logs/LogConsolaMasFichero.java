package logs;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogConsolaMasFichero {
	 private static final Logger LOGGER = Logger.getLogger(LogConsolaMasFichero.class.getName());
	    public static void main(String[] args) {
	 
	        Handler consoleHandler = null;
	        Handler fileHandler  = null;
	        try{
	            //Crear consoleHandler y fileHandler
	            consoleHandler = new ConsoleHandler();
	            fileHandler  = new FileHandler("./ficheroLog.log");
	             
	            //Asignar handlers al objeto LOGGER
	            LOGGER.addHandler(consoleHandler);
	            LOGGER.addHandler(fileHandler);
	             
	            //Establecer niveles a handlers y LOGGER
	            consoleHandler.setLevel(Level.ALL);
	            fileHandler.setLevel(Level.ALL);
	            LOGGER.setLevel(Level.ALL);
	             
	            LOGGER.config("Configuración hecha.");
	             
	            //Eliminamos handler de la consola
	            LOGGER.removeHandler(consoleHandler);
	             
	            LOGGER.log(Level.FINE, "Nivel de log cambiado a FINE");
				
	        }catch(IOException exception){
	            LOGGER.log(Level.SEVERE, "Ocurrió un error en FileHandler.", exception);
	        }
	         
	        LOGGER.finer("Ejemplo con log FINE en LOGGER completado.");
	         
	    }
}
