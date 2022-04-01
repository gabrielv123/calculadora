package Logs_Formatos;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class FormatoHTML extends Formatter {

	/**
	 * 
	 * Este Formatos contendra la estructura de los mensaje 
	 * 
	 */
	@Override
	public String format(LogRecord record) {
		return "<P>" +record.getMessage() +  "</p> \n";
	}

	/**
	 * 
	 * Este Formatos contendra la cabeza del html
	 * 
	 */
	@Override
	public String getHead(Handler h) {
		return "<HTML> \n <BODY> \n";
	}

	/**
	 * 
	 * Este Formatos contendra el final del html
	 * 
	 */
	@Override
	public String getTail(Handler h) {
		return "</body> \n </HTML> \n";
	}

}
