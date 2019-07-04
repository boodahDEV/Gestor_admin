package paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import recursos.Firebase_admin;
import recursos.MaterialButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;

public class Panel_add_user extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField jtfnombre;
	private JTextField jtfapellido;
	private JTextField jtfemail;
	protected boolean correo_valido=false;
	private JPasswordField pass;
	private JPasswordField passvalido;

	@SuppressWarnings("unchecked")
	public Panel_add_user() {
		setBounds(0, 0, 959, 590);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel titulo = new JLabel("Agregar Usuarios");
		titulo.setForeground(new Color(92,0,122));
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
		titulo.setBounds(20, 20, 250, 64);
		add(titulo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFocusable(false);
		lblNombre.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblNombre.setBounds(86, 121, 90, 26);
		add(lblNombre);
		
		jtfnombre = new JTextField();
		jtfnombre.setForeground(new Color(142,36,170));
		jtfnombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		jtfnombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(92,0,122)));
		jtfnombre.setBounds(174, 122, 160, 30);
		add(jtfnombre);
		jtfnombre.setColumns(10);
		
		JLabel lblapellido = new JLabel("Apellido:");
		lblapellido.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblapellido.setFocusable(false);
		lblapellido.setBounds(366, 121, 90, 26);
		add(lblapellido);
		
		jtfapellido = new JTextField();
		jtfapellido.setForeground(new Color(142, 36, 170));
		jtfapellido.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		jtfapellido.setColumns(10);
		jtfapellido.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(92,0,122)));
		jtfapellido.setBounds(454, 122, 160, 30);
		add(jtfapellido);
		
		JLabel lbltipo = new JLabel("Tipo de usuario:");
		lbltipo.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lbltipo.setFocusable(false);
		lbltipo.setBounds(86, 176, 160, 26);
		add(lbltipo);
		
		JComboBox comboBox_tipo = new JComboBox();
		String []tipos = {"-", "Estudiante", "Profesor/a"};
		comboBox_tipo.setBorder(null);
		comboBox_tipo.setBackground(new Color(255, 255, 255));
		comboBox_tipo.setModel(new DefaultComboBoxModel(tipos));
		comboBox_tipo.setForeground(new Color(142, 36, 170));
		comboBox_tipo.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		comboBox_tipo.setBounds(256, 178, 120, 26);
		add(comboBox_tipo);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblEmail.setFocusable(false);
		lblEmail.setBounds(86, 231, 90, 26);
		add(lblEmail);
		
		jtfemail = new JTextField();
		jtfemail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(isEmail(jtfemail.getText())==true){
					jtfemail.setForeground(new Color(0,112,26));
					correo_valido = true;
				}else{
					jtfemail.setForeground(new Color(171,0,13));
					correo_valido = false;
				}
			}
		});
		jtfemail.setForeground(new Color(142, 36, 170));
		jtfemail.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		jtfemail.setColumns(10);
		jtfemail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(92,0,122)));
		jtfemail.setBounds(174, 232, 289, 30);
		add(jtfemail);
		
		JLabel lblpass = new JLabel("Password:");
		lblpass.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblpass.setFocusable(false);
		lblpass.setBounds(86, 294, 100, 26);
		add(lblpass);
		
		pass = new JPasswordField();
		pass.setEchoChar('*');
		pass.setForeground(new Color(142, 36, 170));
		pass.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		pass.setColumns(10);
		pass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(92,0,122)));
		pass.setBounds(185, 295,160, 30);
		add(pass);
		
		passvalido = new JPasswordField();
		passvalido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				char [] passa = pass.getPassword();
				char [] passval = passvalido.getPassword();
				
				if(String.valueOf(passval).equals(String.valueOf(passa)) == true) {
					pass.setEnabled(false);
					pass.setForeground(new Color(0,112,26));
					passvalido.setEnabled(false);
					passvalido.setForeground(new Color(0,112,26));
				}
			}
		});
		passvalido.setForeground(new Color(142, 36, 170));
		passvalido.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		passvalido.setEchoChar('*');
		passvalido.setColumns(10);
		passvalido.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(92,0,122)));
		passvalido.setBounds(255, 340, 160, 30);
		add(passvalido);
		
		JLabel lblpassvalido = new JLabel("Validar password:");
		lblpassvalido.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblpassvalido.setFocusable(false);
		lblpassvalido.setBounds(86, 339, 173, 26);
		add(lblpassvalido);

		MaterialButton cargar_usu = new MaterialButton();
		cargar_usu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(correo_valido) {
						new Firebase_admin('A',jtfemail.getText(), false, String.valueOf(passvalido.getPassword()),jtfnombre.getText()+" "+jtfapellido.getText(), false,"");
						//Firebase_admin.createUser(jtfemail.getText(), false, String.valueOf(passvalido.getPassword()),jtfnombre.getText()+" "+jtfapellido.getText(), false);

				}else System.out.println("Email incorrecto");
			}
		});
		cargar_usu.setColorNormal(new Color(142,36,170));
		cargar_usu.setColorHover(new Color(193,88,220));
		cargar_usu.setColorPressed(new Color(193,88,220));
		cargar_usu.setColorTextNormal(new Color(255,255,255));
		cargar_usu.setBounds(659, 544, 120, 35);
		cargar_usu.setFocusable(false);
		cargar_usu.setText("Cargar usuario");
		add(cargar_usu);
		
		MaterialButton cancelar = new MaterialButton();
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtfnombre.setText("");
				jtfapellido.setText("");
				comboBox_tipo.setSelectedIndex(0);
				jtfemail.setText("");
				pass.setText("");passvalido.setText("");
			}
		});
		cancelar.setColorNormal(new Color(142,36,170));
		cancelar.setColorHover(new Color(193,88,220));
		cancelar.setColorPressed(new Color(193,88,220));
		cancelar.setColorTextNormal(new Color(255,255,255));
		cancelar.setBounds(733, 361, 120, 35);
		cancelar.setFocusable(false);
		cancelar.setText("Cancelar");
		cancelar.setBounds(787, 544, 120, 35);
		add(cancelar);
	}//exit
	
	public boolean isEmail(String correo) {
		Pattern pat = null;
		Matcher mat = null;
		pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
		mat = pat.matcher(correo);
		if (mat.find()) {
			System.out.println("[" + mat.group() + "]valido.");
			return true;
		}else{
			return false;
		}
	}
	
//	public static void main(String args[]) {
//		Panel_add_user a = new Panel_add_user();
//		JFrame f = new JFrame ();
//		f.setBounds(390, 100, 959, 590);
//		f.setBackground(Color.WHITE);
//		f.getContentPane().setLayout(null);
//		f.setContentPane(a);
//		
//		f.setVisible(true);
//	}
}
