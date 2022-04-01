package LogsFiltros;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class filtrosoloMultiplicar implements Filter {

	/**
	 * 
	 * Este filtro solo guardara solo los resultados que contengan el simbolo * (Multiplicar)
	 * 
	 */
	@Override
	public boolean isLoggable(LogRecord record) {

		boolean guardarlog = false;

		if (record.getMessage() != null && record.getMessage().contains("*")) {
			
			guardarlog = true;
			
		}

		return guardarlog;
	}

}
