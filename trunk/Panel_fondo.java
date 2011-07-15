/**
 * @author Jose Pablo Castillo Rodas
 *{@link http://code.google.com/p/proyectojosepablo1/}  label
 *100007
 *
 *Descripcion:
 *	Este teoricamente es un panel, sin embargo es quien 
 *	controla todo el manejo del programa ya que el Driver
 *	solo utiliza un objeto de esta clase.
 *	
 *	La funcion es asignarle a cada boton una ubicacion, una imagen
 *	y su respectiva localizacion  en el panel. Posee la cualidad
 *	de asignarle un fondo a un panel asi como Tips a botones de importancia.
 *	Implemeta ActionListener, por lo queno tenemos que crear una subclase o
 *	una clase interna.
 *
 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/*
 * Panel_fondo es una clase que hereda un JPanel. Esta tambien implementa
 * aciton listeners con el objetivo de 
 */
@SuppressWarnings("serial")
public class Panel_fondo extends JPanel implements ActionListener {
	
	
	/**++++++++++++++++++++++   Atributos   +++++++++++++++++++++++++*/
	private Image fondo_panel;
		//Botones: Encendido/apagado; Am/fm; 1-12;STORE;
	private Radio car_radio;
	private JLabel pantalla = new JLabel("Radio - Pulse On/Off Para Iniciar");
	private myBotones[] mis_botoncitos = new myBotones[17];
	private Font font = new Font("Tahoma",1,28);
	@SuppressWarnings("unused")
	private boolean apachadoTemporal=false,tempboo,estadoinicial=false;
	private int counter=1;
	
	
	/**
	 *Crea el Panel con fondo del radio. Tambien se encarga de 
     *responder ante el tipo de objeto que se cree, pudiendo asi 
	 *mostrar en pantalla el formato actual del radio.
	 */
	
	public Panel_fondo(Image fondo){
		
			/** INICIALIZAR PROPIEDADES DE PANTALLA Y GUI  */
		this.fondo_panel = fondo;
		Dimension tamano = new Dimension(fondo_panel.getWidth(null),fondo_panel.getHeight(null));
		setPreferredSize(tamano);
		pantalla.setFont(font);
		setLayout(null);
		car_radio = new Radio();
		
		
		//*************************Creo mis botones con su respectiva IMAGEN y NOMBRE ***************************
		for(int a=0;a< mis_botoncitos.length ;a++){
			if(System.getProperty("os.name").toLowerCase().startsWith("windows"))
				mis_botoncitos[a] = new myBotones(new ImageIcon(".\\imagenes\\botones\\"+a+".jpg"),a);
			else
				mis_botoncitos[a] = new myBotones(new ImageIcon("./imagenes/botones/"+a+".jpg"),a);
			mis_botoncitos[a].addActionListener(this);
			add(mis_botoncitos[a]);
		}
		//*************************Coloco todos mis Botones en Forma ELEGANTE ***************************
		for(int x=0;x<4;x++){
			for(int y=0;y<4;y++){
				mis_botoncitos[counter].setBounds(286+y*54,150+x*54,55,55);
				counter +=1;
			}// Tamaño de Imagenes  83*75 , 54*119 , 79*75 , 88*62, 340*58 
		}
		//Colocar Mis Botones en Lugares Especificos, sinningun LAYOUT
		mis_botoncitos[0].setBounds(125,125,83,75);
		mis_botoncitos[13].setBounds(125,360,54,119);
		mis_botoncitos[14].setBounds(605,360,79,75);
		mis_botoncitos[15].setBounds(330,365,88,62);
		mis_botoncitos[16].setBounds(418,365,88,62);
		//Establecer ToolTips para ayuda
		mis_botoncitos[0].setToolTipText("On / Off");
		mis_botoncitos[14].setToolTipText("Presiona 'Store', y luego El numero de Memoria");
		pantalla.setBounds(270,70,340,58);
		add(pantalla);
		
		
		// ******************************************************************************************************
		
	//@verriding para pintar el fondo del panel
	//con la imagen inicialmente enviada
	
	}
	public void paintComponent(Graphics hola){
		hola.drawImage(fondo_panel,0,0,null);
	}
	

	/*	@verriding a la clase implementada de ActionListener
	Este metodo Lee la fuente de la cual es adquirido la accion
	y con ello lee su ID (identidifacor de boton). Crea diversas
	acciones para cada boton.
	*/
	public void actionPerformed(ActionEvent event){
		//aqui va o que tengo que hacer coel boton de off y on
		myBotones temp = (myBotones)event.getSource();
		switch(temp.getID()){
			case 0: // FUNCION DE APAGADO Y PRENDIDO
				car_radio.power();
				estadoinicial = !estadoinicial;
				if(estadoinicial){
					pantalla.setText("      ...    Bienvenido ....     ");
				}
				else{
					pantalla.setText("...    Buenas Noches .z.Z.z.Z.Z   ");
				}
				pantalla.repaint();
				apachadoTemporal=false;
				break;
			case 13: //funcion de cambio de AM/FM
				tempboo = car_radio.cambio();
                pantalla.setText(car_radio.toString());
                apachadoTemporal=false;
				break;
			case 14: // funcion de STORE en memoria
				apachadoTemporal=true;	
				break;
			case 15://Funcion de BACKWARD
                car_radio.bw();
                pantalla.setText(car_radio.toString());
				pantalla.repaint();
				apachadoTemporal=false;
				break;
			case 16://FUNCION DE FOWARD
                car_radio.fw(); 
                pantalla.setText(car_radio.toString());
				pantalla.repaint();
				apachadoTemporal=false;
				break;
			default:
				//Para guardar (Strore 1-12)
				if(apachadoTemporal){
			 		car_radio.store(temp.getID());
					pantalla.setText("Store:   "+temp.getID());
				}
				//para seleccionar (1-12)
				else{
					car_radio.select(temp.getID());
				}
				apachadoTemporal=false;
				pantalla.setText(car_radio.toString());
				pantalla.repaint();
				break;
		}
	}
	
	
}
