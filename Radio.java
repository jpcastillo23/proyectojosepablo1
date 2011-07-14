
//package mi_radio_josepablo;

/*
Jose Pablo Castillo Rodas
10007

Descripcion:
	Clase constructora de Radios. Esta clase Posee
	-Atributos para las estaciones guardadas
										*am
										*fm
	-La posicion actual de la sintonizacion en AM/Fm por individuales
	Por lo que almacena tanto donde se quedo el usuario en AM y en FM
	- posee una memoria de 12  espacios, con frecuencia y estacion
	- 
*/

public class Radio implements NuestraInterfaz {
	
	
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
	public Radio (){
		//530,1610,(float)87.9,(float)107.9,false
		this.emision=false;
		//Configurar limites am
		this.frecuenciaam= 530;
		this.frecaminf=540;
		this.frecamsup=1610;
		//Configurar limites FM
		this.frecfminf=(float)87.9;
		this.frecfmsup=(float)107.9;
		this.frecuenciafm= frecfminf;
		this.estado= false;
	}
	//Metodo que cambia de On/Off y regresa la posicion 
	public boolean power(){
		estado =  !estado;
		if (estado)
			System.out.println("El Radio Ahora esta : Encendido");
		else 
			System.out.println("El Radio Ahora esta : Apagado");
		return estado;
	}
	//Metodo que cambia la Emision y regresa la nueva Modulacion
	public boolean cambio(){
		emision = !emision;
		if(emision)
			System.out.println("Ahora su Emisora esta en FM");
		else
			System.out.println("Ahora su Emisora esta en AM");
		return emision;
	}
	//Metodo Implementado que Avanza la frecuencia
	//dependiendo de la Modulacion actual
	public void fw(){
		if(this.estado){
			if (this.emision){
				if(frecfmsup>=(frecuenciafm+0.2))
					this.frecuenciafm += 0.2;
					System.out.println("Estacion: "+frecuenciafm+ "  FM ");
					
			}
			else{
				if(frecamsup>=(frecuenciaam+10))
					this.frecuenciaam += 10;
						System.out.println("Estacion: "+frecuenciaam+ "  AM ");
			}
		}
	}
	//Metodo Implementado que Retrocede la frecuencia
	//demendiendo de la Modulacion Actual
	public void bw(){
		if(this.estado){
			if (this.emision){
				if(frecfminf<=(frecuenciafm-0.2))
					this.frecuenciafm -= 0.2;
					System.out.println("Estacion: "+frecuenciafm+ "  FM ");
			}
			else{ 
				if(frecaminf<=(frecuenciaam-10))
					this.frecuenciaam -= 10;
					System.out.println("Estacion: "+frecuenciaam+ "  AM ");
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
		System.out.println("Se ha Almacenado la frecuencia"+this.htz[localidad]+" En Localidad: "+ localidad);
		
		
	}
	//Metodo Implementado que recibe el numero de boton
	//el cual fue presionado, restaurando asi la frec y
	//Modulaicon a la situaicon actual
	public void select(int cualboton){
		System.out.println("Ah seleccionado el boton: "+ cualboton);
		if (htz[cualboton]== (float)0){
			if(amsfm[cualboton])
				this.htz[cualboton]=frecfminf;
			else
				this.htz[cualboton]= frecaminf;
		}
		if(amsfm[cualboton])
			this.frecuenciafm=htz[cualboton];
		else
			this.frecuenciaam= (int)(htz[cualboton]);
		
		this.emision=amsfm[cualboton];
		
		
		
		
		System.out.println(toString());
		
		
	}
	// metodo Implementado que establece el radio como
	//Apagado
	public void salir(){
		this.estado = false ;
	}
	//Metodo que regresa la frecuencia actual segun la
	//modulacion actual
	public float getFrec(boolean which){
		if (which)
			return this.frecuenciafm;
		else
			return this.frecuenciaam;
	}
	//Regresa el estado del radio, ON/off
	public boolean getState(){
		return estado;
	} 
	//Retorna la modulacion en la cual se encuentra 
	//la radio
	public boolean getEmision(){
		return emision;
	}
	//Metodo que efectivamente regresa a su origen
	//a cada frecuencia debido a si un usuario
	//desea crecer la frecuencia, habiendo este 
	//apachado un numero antes, este lo situaba en 0Htz, ahora
	//lo situa en el menor
	public void setFrec(boolean which){
		if (which)
			this.frecuenciafm= frecfminf;
		else
			this.frecuenciaam= frecaminf;
	}
	/*
	Clase que muestra el estado actual de la radio, tanto como emisoras
	frecuencias, estado actual.
	*/
	public String toString(){
		String muestra = "";
		if (emision)
			muestra += "Frecuencia:"+frecuenciafm+" FM\n";
		else
			muestra += "Frecuencia:"+frecuenciaam+" AM\n";
		muestra += "+++++++++++++++++++++++++++++++++++++++++++++++++\n";
		muestra += "+++++++++++++++++++++++++Ver DOS+++++++++++++++++\n";
		if (estado)
			muestra += "Tu Radio esta: Encendido \n";
		else
			muestra += "Tu Radio esta: Apagado\n";
		return muestra;
	}
	/*
	    Funcion que resstablece al menor de la respectiva emisoda si
	en tal caso al seleccinar un boton este está vacio. 

	*/
	public void reestablecer(){
		
	}
	
	
}