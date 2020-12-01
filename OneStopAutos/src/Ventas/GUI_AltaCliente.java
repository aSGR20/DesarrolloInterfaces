package Ventas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import Mecanicos.GUI_AnyadirTrabajos1;
import Proyecto.DAO_Cliente;
import Proyecto.DAO_Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_AltaCliente extends javax.swing.JFrame{

	private GUI_Ventas menu;
	private String profesion;
	private GUI_AnyadirTrabajos1 menuAnyadir;
	private JFrame frame;
	private JTextField text_Nombre;
	private JTextField text_Apellidos;
	private JTextField text_DNI;
	private JTextField text_Domicilio;
	private JTextField text_Telefono;
	private JTextField text_Correo;

	/**
	 * Create the application.
	 */	
	public GUI_AltaCliente(GUI_Ventas menu) {
		initialize();
		setLocationRelativeTo(null);
		this.menu = menu;
		this.profesion = "ventas";
		setVisible(true);
	}
	
	public GUI_AltaCliente(GUI_AnyadirTrabajos1 menuAnyadir, String profesion) {
		initialize();
		setLocationRelativeTo(null);
		this.menuAnyadir = menuAnyadir;
		this.profesion = profesion;
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Alta de Cliente");
		setBounds(100, 100, 667, 482);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 176, 443);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(".\\src\\images\\myLogo_Login.png"));
		lblNewLabel.setBounds(26, 48, 122, 55);
		panel.add(lblNewLabel);
		
		JLabel lbl_Nombre_Empleado = new JLabel("NOMBRE_EMPLEADO");
		DAO_Usuario usuarioDao = new DAO_Usuario();
		lbl_Nombre_Empleado.setText(usuarioDao.getName());
		lbl_Nombre_Empleado.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_Nombre_Empleado.setBounds(10, 126, 162, 14);
		panel.add(lbl_Nombre_Empleado);
		
		JLabel lbl_Ocupacion = new JLabel("OCUPACION");
		lbl_Ocupacion.setText(usuarioDao.getProfesion());
		lbl_Ocupacion.setFont(new Font("SansSerif", Font.BOLD, 18));
		lbl_Ocupacion.setBounds(10, 406, 162, 14);
		panel.add(lbl_Ocupacion);
		
		lbl_Nombre_Empleado.setHorizontalAlignment(lbl_Nombre_Empleado.CENTER);
		lbl_Ocupacion.setHorizontalAlignment(lbl_Ocupacion.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		panel_1.setBounds(175, 0, 476, 443);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_Nombre = new JLabel("*Nombre:");
		lbl_Nombre.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Nombre.setBounds(22, 39, 140, 14);
		panel_1.add(lbl_Nombre);
		
		text_Nombre = new JTextField();
		text_Nombre.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_Nombre.setBounds(22, 64, 184, 20);
		panel_1.add(text_Nombre);
		text_Nombre.setColumns(10);
		
		JLabel lbl_Apellidos = new JLabel("*Apellidos:");
		lbl_Apellidos.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Apellidos.setBounds(259, 39, 140, 14);
		panel_1.add(lbl_Apellidos);
		
		text_Apellidos = new JTextField();
		text_Apellidos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_Apellidos.setColumns(10);
		text_Apellidos.setBounds(259, 64, 184, 20);
		panel_1.add(text_Apellidos);
		
		text_DNI = new JTextField();
		text_DNI.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_DNI.setColumns(10);
		text_DNI.setBounds(22, 153, 184, 20);
		panel_1.add(text_DNI);
		
		JLabel lbl_DNI = new JLabel("*DNI:");
		lbl_DNI.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_DNI.setBounds(22, 128, 140, 14);
		panel_1.add(lbl_DNI);
		
		text_Domicilio = new JTextField();
		text_Domicilio.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_Domicilio.setColumns(10);
		text_Domicilio.setBounds(259, 153, 184, 20);
		panel_1.add(text_Domicilio);
		
		JLabel lbl_Domicilio = new JLabel("*Domicilio:");
		lbl_Domicilio.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Domicilio.setBounds(259, 128, 140, 14);
		panel_1.add(lbl_Domicilio);
		
		text_Telefono = new JTextField();
		text_Telefono.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_Telefono.setColumns(10);
		text_Telefono.setBounds(22, 251, 184, 20);
		panel_1.add(text_Telefono);
		
		JLabel lblTelefono = new JLabel("*Teléfono:");
		lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTelefono.setBounds(22, 226, 140, 14);
		panel_1.add(lblTelefono);
		
		text_Correo = new JTextField();
		text_Correo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_Correo.setColumns(10);
		text_Correo.setBounds(259, 251, 184, 20);
		panel_1.add(text_Correo);
		
		JLabel lbl_Correo = new JLabel("Correo Electr\u00F3nico:");
		lbl_Correo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Correo.setBounds(259, 226, 140, 14);
		panel_1.add(lbl_Correo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				volver();
			}
		});
		btnVolver.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnVolver.setBounds(54, 367, 107, 42);
		panel_1.add(btnVolver);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aceptar();
			}
		});
		btnAceptar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAceptar.setBounds(292, 367, 107, 42);
		panel_1.add(btnAceptar);
	}
	
	public void volver() {
		DAO_Usuario usuarioDao = new DAO_Usuario();
		this.setVisible(false);
		this.dispose();
		if(profesion.equals("Mecánico_Jefe")) {
			menuAnyadir.setVisible(true);
		}else if(profesion.equals("ventas")){
			menu.setVisible(true);
		}
	}
	
	public void aceptar() {
		DAO_Usuario usuarioDao = new DAO_Usuario();
		try {
		if((text_DNI.getText().equals(""))||(text_Nombre.getText().equals(""))||(text_Apellidos.getText().equals(""))||(text_Telefono.getText().equals(""))||(text_Domicilio.getText().equals(""))) {
			JOptionPane.showInternalMessageDialog(null, "Te faltan campos por rellenar");
		}else
		if (text_Correo.getText().equals("")){
			Object[]datos = new Object[5];
			datos[0] = text_DNI.getText();
			datos[1] = text_Nombre.getText();
			datos[2] = text_Apellidos.getText();
			datos[3] = Integer.parseInt(text_Telefono.getText());
			datos[4] = text_Domicilio.getText();
			int num = Integer.parseInt(text_Telefono.getText());
			int cantidad = 0;
			while(num!=0) {
				num = num/10;
				cantidad++;
			}
			if(cantidad<9) {
				JOptionPane.showInternalMessageDialog(null, "Número de teléfono mal escrito");
			}else {
				DAO_Cliente clienteDao = new DAO_Cliente();
			clienteDao.agregarDatos(datos);
			this.setVisible(false);
			this.dispose();
			if(profesion.equals("Mecánico_Jefe")) {
				menuAnyadir.setVisible(true);
			}else{
				menu.setVisible(true);
			}
			}
			
		}else {
			Object[]datos = new Object[6];
			datos[0] = text_DNI.getText();
			datos[1] = text_Nombre.getText();
			datos[2] = text_Apellidos.getText();
			datos[3] = text_Telefono.getText();
			datos[4] = text_Domicilio.getText();
			datos[5] = text_Correo.getText();
			int verificacion = text_Correo.getText().indexOf("@");
			int num = Integer.parseInt(text_Telefono.getText());
			int cantidad = 0;
			while(num!=0) {
				num = num/10;
				cantidad++;
			}
			if(verificacion==-1) {
				JOptionPane.showInternalMessageDialog(null, "Correo electrónico mal escrito");
			}else if(cantidad<9){
				JOptionPane.showInternalMessageDialog(null, "Número de teléfono mal escrito");
			}else {
				DAO_Cliente clienteDao = new DAO_Cliente();
				clienteDao.agregarDatos(datos);
				this.setVisible(false);
				this.dispose();
				if(profesion.equals("Mecánico_Jefe")) {
					menuAnyadir.setVisible(true);
				}else{
					menu.setVisible(true);
				}
			}
		}
		}catch(NumberFormatException nfe) {
			JOptionPane.showInternalMessageDialog(null, "Número de teléfono mal escrito");
		}
	}
}
