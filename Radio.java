

public class Radio implements JoseCastillo {
	
	

	private boolean emision, estado=false;
			//Frecuencia establece la frecuencia actual del radio
	private int frecuenciaam,frecaminf,frecamsup;
	private float frecuenciafm,frecfminf,frecfmsup;

	private boolean[] amsfm = new boolean[13];
	private float[] htz = new float[13];

	
	// se establece el estado inicial AM/FM y los limites superior e inferior
	public Radio (boolean amfm,int frecaminf,int frecamsup, float frecfminf,float frecfmsup,boolean state){
		this.emision=amfm;
		//Configurar limites am
		this.frecuenciaam= frecaminf;
		this.frecaminf=frecaminf;
		this.frecamsup=frecamsup;
		//Configurar limites FM
		this.frecfminf=frecfminf;
		this.frecfmsup=frecfmsup;
		this.frecuenciafm= frecfminf;
		this.estado= state;
	}
	//Metodo que cambia de On/Off y regresa la posicion 
	public boolean power(){
		estado =  !estado;
		return estado;
	}
	//Metodo que cambia la Emision y regresa la nueva Modulacion
	public boolean cambio(){

	}
	//Metodo Implementado que Avanza la frecuencia
	//dependiendo de la Modulacion actual
	public void fw(){

	}
	//Metodo Implementado que Retrocede la frecuencia
	//demendiendo de la Modulacion Actual
	public void rw(){
	}
	//Metodo que recibe el numero local de memoria
	//en donde se Almacenara la frecuencia y la mofulacion
	public void store(int localidad){

	}
	//Metodo Implementado que recibe el numero de boton
	//el cual fue presionado, restaurando asi la frec y
	//Modulaicon a la situaicon actual

	
}