
//package mi_radio_josepablo;

/*
Jose Pablo Castillo Rodas
Descripcion:
 	A causa de que el progrma utilizaria al menos 5 botones, me vi
	en la obligacion de crear una clase que manipulara mis botoncitos :D
	Este le da a cada boton su respectiva imagen y un debido Identificador
*/

import javax.swing.*;
//import java.awt.*;
public class Botones extends JButton{
	private int identificador;
	public Botones(ImageIcon mi_imagen,int id){
		super(mi_imagen);
		this.identificador=id;
	}
	public int getID(){
		return this.identificador;
	}
}