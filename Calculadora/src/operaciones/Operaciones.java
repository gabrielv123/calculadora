package operaciones;


/**
 * 
 * @author gabriel
 * 
 * @apiNote esta clase implementa los metodos sumar, restar, multplicar,dividir y el resto de los numeros enteros
 * 
 */
public class Operaciones {
	
	/**
	 * suma los numero entero que que recibe como parametros
	 * 
	 * @author gabriel
	 * 
	 * @param valor1 = primer numero
	 * @param valor2 = segundo numero
	 * 
	 * @return devuelve la suma de los dos numeros entero
	 */
	public int sumar(int valor1, int valor2) {
		
		int numero;
		numero = valor1 + valor2;
		return numero;
	}

	/**
	 * 
	 *resta los numero entero que que recibe como parametros
	 * 
	 * @author gabriel
	 * 
	 * @param valor1 = primer numero
	 * @param valor2 = segundo numero
	 * 
	 * @return devuelve la resta de los dos numeros entero
 	 */
	public int restar(int valor1, int valor2) {
		
		int numero;
		numero = valor1 - valor2;
		return numero;
	}

	/**
	 * 
	 * multiplica los numero entero que que recibe como parametros
	 * 
	 * @author gabriel
	 * 
	 * @param valor1 = primer numero
	 * @param valor2 = segundo numero
	 * 
	 * @return devuelve la mulplicacion de los dos numeros entero
	 */
	public int multiplicar(int valor1, int valor2) {
		
		int numero;
		numero = valor1 * valor2;
		return numero;
	}
	/**
	 *divide los numero entero que que recibe como parametros
	 * 
	 * @author gabriel
	 * 
	 * @param valor1 = primer numero
	 * @param valor2 = segundo numero
	 * 
	 * @return devuelve la division de los numeros
	 * 
	 * @throws ArithmeticException sucede cuando intentas dividir entre 0 
	 */
	public int dividir(int valor1, int valor2) throws ArithmeticException {
		
		int numero;
		numero = valor1 / valor2;
		return numero;
	}

	/**
	 * 
	 * saca el resto de los dos numeros enteros que recibe como parametro
	 * 
	 * @author gabriel
	 * 
	 * @param valor1 =  primer numero
	 * @param valor2 = segundo numero
	 * 
	 * @return devuelve el resto de los dos numeros
	 * 
	 */
	public int resto(int valor1, int valor2) {
		
		int numero;
		numero = valor1 % valor2;
		return numero;
	}
}