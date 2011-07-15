/**
 * @author Jose Pablo Castillo Rodas 
 *100007
 *
 *Descripcion:
 *Esta es la interface utilizada en mi programa, el cual describira la
 *caracteristica comun utilizada  para todos los programas de la clase
 *de Estructura de datos en la elaboracion del Radio.
 *
*/
public interface NuestraInterfaz{
	
	/**
	 *Metodo Abstracto el cual manera el estado de 
	 *prendido y apagado del radio.
	 */
	public boolean power();
	/*
	 * Metodo que cambia la modulacion actual de la radio
	 * por otra. Asi mismo devuelve el estado actual, ya 
	 * sea TRUE para FM y FALSE para AM
	 */
	public boolean cambio();
	/*
	 * metodo abstracto cuya funcion es incrementar la frecuencia.
	 * Se esta en FM la modulacion, incrementa o disminuye 0.2, y si
	 * est‡ en AM incrementa o disminuye 10 htz. Aqui tambien se
	 * manejan las restricciones sobre los limites de aumento y decremento
	 * establecidos previamente enel constructor.
	 */
	public void fw();
	/*
	 * metodo abstracto cuya funcion es Decrementar la frecuencia.
	 * Se esta en FM la modulacion, decremento 0.2, y si
	 * est‡ en AM decrementa 10 htz. Aqui tambien se
	 * manejan las restricciones sobre los limites de aumento y decremento
	 * establecidos previamente enel constructor.
	 */
	public void bw();
	/*
	 * Metodo cuyo objetivo es recibir un numero, el cual indicara
	 * una posicion en una localidad y alacenar los estados y modulaciones
	 * actuales en una posicion de memoria a manera de retornar a ellas despues.
	 */
	public void store(int localidad);
	/*
	 * metodo que se responsabiliza por reestablecer lo que hay 
	 * en almacenado en la memoria en la localidad "estacion"
	 */
	public void select(int estacion);
	/*
	 * Metodo Abstracto cuyo objetivo es que si se cuenta con una
	 * interfaz de linea d ecomandos es salir inmediatamente
	 * de Java.
	 */
	public void salir();
	/*
	 * Metodo que cumple con @return Un String que posee
	 * los datos actuales del radio.
	 */
	public String toString();
	
}