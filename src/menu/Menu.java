package menu;
import java.util.Scanner;


/**
 * 
 * @author gabriel
 * 
 * @apiNote esta clase implementa los metodos de pedir, opciones y si quieres continuar o no
 * 
 */
public class Menu {
	
    private static Scanner teclado = new Scanner(System.in);
    
    
    /**
     * 
     *@author gabrielon
     * 
     *@apiNote pides dos numeros al usuario y lo almacena en un array de enteros
     * 
     * @return los dos numeros
     */
    public int[] pedirNumeros(){
    	
        int[] ret = new int[2];
        System.out.print ("Operando 1: ");
        ret [0] = teclado.nextInt();
        
        System.out.print ("Operando 2: ");
        ret [1] = teclado.nextInt();
        
        return ret;
    }
    
    /**
     * @author gabriel
     * 
     *@apiNote pides el tipo de operando al usuario
     * 
     * @return retorna el operando
     */
    public String menuOpciones() {
    	
        String ret = "";
        
        do {
        	
            System.out.print ("Operaciones [+, -, *, /, %]: ");
            ret = teclado.next();
            
        } while (!((ret.equalsIgnoreCase("+")) || (ret.equalsIgnoreCase("-")) ||(ret.equalsIgnoreCase("*")) || (ret.equalsIgnoreCase("/")) ||(ret.equalsIgnoreCase("%")) ));
                return ret;
    }
    
    /**
     * @author gabriel
     * 
     *@apiNote le pides al usuario una vez terminado la operacion si quiere continuar o no
     * 
     * @return retorna true si dices que si y retorna false si dices que no
     */
    public boolean repetir() {
    	
        boolean ret = false;
        String respuesta;
        
        do {
        	
            System.out.print ("¿Desea continuar trabajando con la calculadora? [s / n]");
            respuesta = teclado.next();
            
        } while (!((respuesta.equalsIgnoreCase("s")) || (respuesta.equalsIgnoreCase("n"))));
                    
        if (respuesta.equalsIgnoreCase("s")) {
        	
            ret = true;
            
        }
        
        return ret;
    }
}