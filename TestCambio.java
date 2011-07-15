import junit.framework.TestCase;

/**
 * 
 */

/**
 * @author jaypicastillo
 * Prueba JUnit 2
 */
public class TestCambio extends TestCase {
	/*
	 * Creo mi Objeto del cual voy a probar su
	 * valor de Retorno
	 */
	public Radio radito= new Radio();
	/*
	 * Metodo cuyo objetivo es evaluar el metodo
	 * Cambio, del objeto radio.
	 */
	public void testCambioModulacion(){
		boolean emision= false;   //Estado Siguiente = Esta sig
		emision = !emision;
		boolean cambion=true;
		cambion = radito.cambio();
		assertEquals(emision,cambion);
	}
}
