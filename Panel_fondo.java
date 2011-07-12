

public class Panel_fondo extends JPanel  {
	
	
	//++++++++++++++++++++++   Atributos   +++++++++++++++++++++++++
	private Image fondo_panel;
		//Botones: Encendido/apagado; Am/fm; 1-12;STORE;
	private Radio car_radio;
	private JLabel pantalla = new JLabel("Radio - Pulse On/Off Para Iniciar");
	private Botones[] mis_botoncitos = new Botones[17];
	private Font font = new Font("Tahoma",1,28);
	private boolean apachadoTemporal=false,tempboo;
	private int counter=1;
	
	//Crea el Panel con fondo del radio
	public Panel_fondo(Image fondo){
		
			// INICIALIZAR PROPIEDADES DE PANTALLA Y GUI 
		this.fondo_panel = fondo;
		Dimension tamaño = new Dimension(fondo_panel.getWidth(null),fondo_panel.getHeight(null));
		setPreferredSize(tamaño);
		pantalla.setFont(font);
		setLayout(null);
		car_radio = new Radio(false,530,1610,(float)87.9,(float)107.9,false);
		
		
		//*************************Creo mis botones con su respectiva IMAGEN y NOMBRE ***************************
		for(int a=0;a< mis_botoncitos.length ;a++){
			if(System.getProperty("os.name").toLowerCase().startsWith("windows"))
				mis_botoncitos[a] = new Botones(new ImageIcon(".\\imagenes\\botones\\"+a+".jpg"),a);
			else
				mis_botoncitos[a] = new Botones(new ImageIcon("./imagenes/botones/"+a+".jpg"),a);
			mis_botoncitos[a].addActionListener(this);
			add(mis_botoncitos[a]);
		}
		//*************************Coloco todos mis Botones en Forma ELEGANTE ***************************

		
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
		Botones temp = (Botones)event.getSource();
		switch(temp.getID()){
			case 0: // FUNCION DE APAGADO Y PRENDIDO
				car_radio.power();
				if(car_radio.getState()){
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
				if (tempboo)
					pantalla.setText(" .        "+car_radio.getFrec(tempboo)+" FM" );
				else
					pantalla.setText(" .        "+car_radio.getFrec(tempboo)+" AM" );
				pantalla.repaint();
				apachadoTemporal=false;
				break;
			case 14: // funcion de STORE en memoria
				apachadoTemporal=true;	
				break;
			case 15://Funcion de BACKWARD
				if (tempboo){//para retroceder solo Fm
					car_radio.rw();
					pantalla.setText("  .           "+car_radio.getFrec(tempboo)+" FM" );
				}
				else{//para retroceder solo Am
					car_radio.rw();
					pantalla.setText("   .           "+car_radio.getFrec(tempboo)+" AM" );
				}
				pantalla.repaint();
				apachadoTemporal=false;
				break;
			case 16://FUNCION DE FOWARD
				if (tempboo){//para avanzar FM
					car_radio.fw();
					pantalla.setText("   .           "+car_radio.getFrec(tempboo)+"   FM" );
				}
				else{//para retroceder AM
					car_radio.fw(); 
					pantalla.setText("   .           "+car_radio.getFrec(tempboo)+" AM" );
				}
				pantalla.repaint();
				apachadoTemporal=false;
				break;
			default:
				//Para guardar (Strore 1-12)
				if(apachadoTemporal){
			 		car_radio.store(temp.getID());
					pantalla.setText("Store:   "+car_radio.getFrec(tempboo)+" AM" );
					apachadoTemporal=false;
				}
				//para seleccionar (1-12)
				else{
					car_radio.select(temp.getID());
					tempboo=car_radio.getEmision();
					if (tempboo){
						pantalla.setText(" #     "+temp.getID()+" :   "+car_radio.getFrec(tempboo)+" FM" );
					}
					else{
						pantalla.setText(" #      "+temp.getID()+" :   "+car_radio.getFrec(tempboo)+" AM" );
					}
				}
				pantalla.repaint();
				break;
		}
	}
	
}
