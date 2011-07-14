
//package mi_radio_josepablo;

/*
Jose Pablo Castillo Rodas 
100007

Descripcion:
Esta es la interface utilizada en mi programa, el cual describira la
caracteristica comun utilizada  para todos los programas de la clase
de Estructura de datos en la elaboracion del Radio.

*/
public interface NuestraInterfaz{
	
	public boolean power();
	public boolean cambio();
	public void fw();
	public void bw();
	public void store(int localidad);
	public void select(int estacion);
	public void salir();
	
}