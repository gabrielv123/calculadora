package logs;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class filtrosolonulo implements Filter {

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
