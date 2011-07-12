
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Driver_Sintonizando {
	public static void main(String args[]){
		Panel_fondo panel;
		
		if((System.getProperty("os.name").toLowerCase().startsWith("windows")))
			panel = new Panel_fondo(new ImageIcon(".\\imagenes\\fondo.jpg").getImage());
		else
			panel = new Panel_fondo(new ImageIcon("./imagenes/fondo.jpg").getImage());
		
		//Establezco las propiedades de mi Ventana
		JFrame ventana = new JFrame("Car Radio con Memoria");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(panel);
		ventana.setResizable(false);
		ventana.pack();
		ventana.setVisible(true);
	}
}