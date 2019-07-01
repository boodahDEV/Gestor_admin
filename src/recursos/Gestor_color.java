package recursos;

import java.awt.Color;

public class Gestor_color {

	public String base,hover,pressed;
	public MaterialButton boton;
	
	public Gestor_color(String color_base, String color_hover, String color_pressed, String adicional,MaterialButton boton) {
		this.boton = boton;
		base = color_base; hover = color_hover; pressed = color_pressed; 
		cambio_color(base,"normal");
		cambio_color(hover, "hover");
		cambio_color(pressed, "pressed");
		if(!adicional.equals("none"))
			cambio_color(adicional, "adicional");
	}//fin constructor
	
	public void cambio_color(String color,String Tipo) {
		//System.out.println("Dentro");
		if(color.contains(",")) {
			String[] rbg = color.split(",");
			int a,b,c;
			a = Integer.parseInt(rbg[0]);
			b = Integer.parseInt(rbg[1]);
			c = Integer.parseInt(rbg[2]);
			switch(Tipo) {
			case "normal": {
				//System.out.println("Dentro1");
				boton.setColorNormal(new Color(a,b,c));
				break;
			}
			case "hover": {
				boton.setColorHover(new Color(a,b,c));
				break;
			}
			case "pressed": {
				boton.setColorPressed(new Color(a,b,c));
				break;
			}
			default:
					boton.setColorTextNormal(new Color(a,b,c));
			}//end switch
		}else System.out.println("El caracter "+color+" es incorrecto y no coincide con el patron definido.");

	}//fin metodo color normal
}//end class
