

public class Radio implements JoseCastillo {
	
	
			//emision: Estado de FM o AM, FM=TRUE AM=FALSE
			// Estado indica si esta prendido o apagado
	private boolean emision, estado=false;
			//Frecuencia establece la frecuencia actual del radio
	private int frecuenciaam,frecaminf,frecamsup;
	private float frecuenciafm,frecfminf,frecfmsup;
			//Establece 2 matrices, en las cuales 1 almacenara
			//la frecuencia como flotante, ya sea para FM y AM.
			//La otra establece la Modulacion al momento que se 
			//almaceno.
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
		emision = !emision;
		return emision;
	}
	//Metodo Implementado que Avanza la frecuencia
	//dependiendo de la Modulacion actual
	public void fw(){
		if(this.estado){
			if (this.emision){
				if(frecfmsup>=(frecuenciafm+0.2))
					this.frecuenciafm += 0.2;
			}
			else{
				if(frecamsup>=(frecuenciaam+10))
					this.frecuenciaam += 10;
			}
		}
	}
	//Metodo Implementado que Retrocede la frecuencia
	//demendiendo de la Modulacion Actual
	public void rw(){
		if(this.estado){
			if (this.emision){
				if(frecfminf<=(frecuenciafm-0.2))
					this.frecuenciafm -= 0.2;
			}
			else{ 
				if(frecaminf<=(frecuenciaam-10))
					this.frecuenciaam -= 10;
			}
		}
	}
	//Metodo que recibe el numero local de memoria
	//en donde se Almacenara la frecuencia y la mofulacion
	public void store(int localidad){
		if (emision)
			this.htz[localidad]=frecuenciafm;
		else
			this.htz[localidad]=frecuenciaam;
		this.amsfm[localidad]=emision;
	}
	//Metodo Implementado que recibe el numero de boton
	//el cual fue presionado, restaurando asi la frec y
	//Modulaicon a la situaicon actual

	
}