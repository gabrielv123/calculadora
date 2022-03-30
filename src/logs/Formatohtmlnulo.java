package logs;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Formatohtmlnulo extends Formatter {
	
	@Override
	public String format(LogRecord record) {
		
		String[] texto = record.getMessage().split(" ");
		
		return "<tr>" + "\n" 
				+"<td>" +texto[0] + "</td>" + "\n"
				+"<td>" +texto[1] + "</td>" + "\n"
				+"<td>" +texto[2] + "</td>" + "\n"
				+"<td>" +texto[3] + "</td>" + "\n"
			
				+"\n </tr> \n";
		
	}

	@Override
	public String getHead(Handler h) {
		return "<HTML> \n <HEAD> \n <link rel=\"stylesheet\" href=\"style.css\"> \n </HEAD> <BODY> \n <TABLE> \n "
				+ "<tr> <th> operacion </th> \n <th> operando1 </th> \n <th> operando2 </th> \n <th> resultado </th> \n\"";
	}

	@Override
	public String getTail(Handler h) {
		return "</body> \n </HTML> \n </TABLE> \n";
	}
}
