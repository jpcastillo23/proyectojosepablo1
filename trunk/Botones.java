
import javax.swing.*;
//import java.awt.*;
public class Botones extends JButton{
	private int identificador;
	public Botones(ImageIcon mi_imagen,int id){
		super(mi_imagen);
		this.identificador=id;
	}

}