import junit.framework.*;

/**
 * JUnit Test en Eclipse por JPcastillo
 */

/**
 * @author Jose Pablo Castillo Rodas
 *
 */
public class TestPower extends TestCase {

	/**
	 * @param args
	 */
	public Radio radito= new Radio();
	public void testPower () {
		boolean actual= false;   //Estado Siguiente = Esta sig
		actual = !actual;
		boolean despues=true;
		despues = radito.power();
		assertEquals(despues,actual);
	}

}
