package logs;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class filtrosoloMultiplicar implements Filter {

	@Override
	public boolean isLoggable(LogRecord record) {

		boolean guardarlog = false;

		if (record.getMessage() != null && record.getMessage().contains("*")) {
			
			guardarlog = true;
			
		}

		return guardarlog;
	}

}
