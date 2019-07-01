package paneles;

import javax.swing.*;
public class Cambia_paneles {
	public Cambia_paneles(JPanel contenedor, JPanel contenido) {
		contenedor.removeAll();
		contenedor.revalidate();
		contenedor.repaint();
		
		contenedor.add(contenido);
		contenedor.revalidate();
		contenedor.repaint();
	}
}