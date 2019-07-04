import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import Animacion.*;
import recursos.*;

//import test.Hilos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import recursos.MaterialButton;
import java.awt.Font;


public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, titulo;
	public int x, y;
	
	/**/
	public static void main(String[] args) {
		Principal frame = new Principal();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	/**/
	
	
	public Principal() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(142,36,170)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			titulo = new JPanel();
			titulo.setBackground(Color.WHITE);
					titulo.addMouseMotionListener(new MouseMotionAdapter() {
						@Override
						public void mouseDragged(MouseEvent a) {
							int xx = a.getXOnScreen(), yy = a.getYOnScreen();
							setLocation(xx-x,yy-y);
						}
					});
					titulo.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent a) {
							x = a.getX();
							y = a.getY();
						}
					});
			titulo.setBounds(2, 2, 1360, 75);
			contentPane.add(titulo);
			titulo.setLayout(null);
			
			JButton exit = new JButton("");
				exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						System.exit(0);
					}
				});
			exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			exit.setIcon(new ImageIcon(Principal.class.getResource("/recursos/exit.png")));
			exit.setFocusable(false);
			exit.setContentAreaFilled(false);
			exit.setBorderPainted(false);
			exit.setBounds(1328, 5, 30, 30);
			titulo.add(exit);
			
			JLabel logo = new JLabel(""); 
			logo.setIcon(new ImageIcon(Principal.class.getResource("/recursos/logo_chemical_burette.png")));
			logo.setBounds(2, 2, 75, 66);
			titulo.add(logo);
			
			JLabel titulo_name = new JLabel("Administrador");
			titulo_name.setForeground(new Color(142,36,170));
			titulo_name.setFont(new Font("Segoe UI", Font.BOLD, 20));
			titulo_name.setBounds(73, 18, 149, 36);
			titulo.add(titulo_name);
			
			MaterialButton text_options_dash = new MaterialButton();
			text_options_dash.setColorNormal(new Color(142,36,170));
			text_options_dash.setColorHover(new Color(142,36,170));
			text_options_dash.setColorPressed(new Color(142,36,170));
			text_options_dash.setColorTextNormal(new Color(255,255,255));
			text_options_dash.setFocusable(false);
			text_options_dash.setBounds(223, 40, 150, 35); 
			text_options_dash.setVisible(false);
			titulo.add(text_options_dash);
		
		JPanel panel_contenido = new JPanel();
		panel_contenido.setBounds(390, 100, 959, 590);
		contentPane.add(panel_contenido);
		panel_contenido.setVisible(false);
		panel_contenido.setLayout(null);
		
		JPanel panel_opciones_contenido = new JPanel();
		panel_opciones_contenido.setBounds(235, 100, 145, 590);
		contentPane.add(panel_opciones_contenido);
		panel_opciones_contenido.setVisible(false);
		panel_opciones_contenido.setLayout(null);
		
			MaterialButton agregar_usu = new MaterialButton();
			agregar_usu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new Gestor_color("193,88,220","193,88,220","193,88,220","none",agregar_usu);
					panel_contenido.setVisible(true);
					new paneles.Cambia_paneles(panel_contenido, new paneles.Panel_add_user());
				}
			});
			agregar_usu.setColorNormal(new Color(142,36,170));
			agregar_usu.setColorHover(new Color(193,88,220));
			agregar_usu.setColorPressed(new Color(193,88,220));
			agregar_usu.setColorTextNormal(new Color(255,255,255));
			agregar_usu.setBounds(0, 0, 145, 35);
			agregar_usu.setFocusable(false);
			agregar_usu.setText("Agregar usuario");
			panel_opciones_contenido.add(agregar_usu);
			
			MaterialButton none = new MaterialButton();
			none.setBounds(0, 46, 145, 35);
			panel_opciones_contenido.add(none);
			
			MaterialButton none2 = new MaterialButton();
			none2.setBounds(0, 92, 145, 35);
			panel_opciones_contenido.add(none2);
			
			MaterialButton none3 = new MaterialButton();
			none3.setBounds(0, 138, 145, 35);
			panel_opciones_contenido.add(none3);
			
			MaterialButton none4 = new MaterialButton();
			none4.setBounds(0, 184, 145, 35);
			panel_opciones_contenido.add(none4);
			
		JPanel dashboard = new JPanel();
		dashboard.setBackground(Color.WHITE);
		dashboard.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(142,36,170)));
		dashboard.setBounds(2, 75, 225, 615);
		contentPane.add(dashboard);
		dashboard.setLayout(null);
		
			MaterialButton config_user = new MaterialButton();
			config_user.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new Gestor_color("142,36,170","142,36,170","142,36,170","255,255,255",config_user);
					text_options_dash.setVisible(true);
					panel_opciones_contenido.setVisible(true);
				}
			});
			config_user.setColorNormal(new Color(255,255,255));
			config_user.setColorHover(new Color(193,88,220));
			config_user.setColorPressed(new Color(193,88,220));
			config_user.setColorTextNormal(new Color(0,0,0));
			config_user.setFocusable(false);
			config_user.setText("Configuracion de usuarios");
			config_user.setBounds(10, 11, 203, 51);
			dashboard.add(config_user);
	}//end constructor
}
