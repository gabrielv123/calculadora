package LogsFiltros;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class filtrosolonulo implements Filter {

	/**
	 * 
	 * Este filtro solo guardara solo los resultados que contengan el resultado a 0 agarrando la ultima posicion del array del logger 
	 * 
	 */
	@Override
	public boolean isLoggable(LogRecord record) {

		boolean guardarlog = false;
		
		String[] texto = record.getMessage().split(" ");
	
		if (texto[texto.length-1].equals("0")) {
			
			guardarlog = true;
			
		}

		return guardarlog;
	}
}
