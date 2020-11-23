package Ventas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import Proyecto.DAO_Usuario;
import Proyecto.GUI_Login;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Ventas extends javax.swing.JFrame{

	private String nombre;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Ventas window = new GUI_Ventas();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public GUI_Ventas(GUI_Login login) {
		initialize();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public GUI_Ventas(String nombre, String usuario) {
		this.nombre = nombre;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setTitle("Menú Principal");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
		lbl_Nombre_Empleado.setBounds(26, 126, 122, 14);
		panel.add(lbl_Nombre_Empleado);
		
		JLabel lbl_Ocupacion = new JLabel("OCUPACION");
		lbl_Ocupacion.setText(usuarioDao.getProfesion());
		lbl_Ocupacion.setFont(new Font("SansSerif", Font.BOLD, 18));
		lbl_Ocupacion.setBounds(52, 406, 69, 14);
		panel.add(lbl_Ocupacion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		panel_1.setBounds(175, 0, 476, 443);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_Bienvenida = new JLabel("Bienvenid@ ^^ \u00BFQu\u00E9 deseas realizar?");
		lbl_Bienvenida.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_Bienvenida.setBounds(10, 11, 289, 29);
		panel_1.add(lbl_Bienvenida);
		
		JLabel lbl_AltaCliente = new JLabel("REGISTRAR alg\u00FAn CLIENTE");
		lbl_AltaCliente.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_AltaCliente.setBounds(17, 110, 169, 14);
		panel_1.add(lbl_AltaCliente);
		
		JButton btnAltaCliente = new JButton("Registrar");
		btnAltaCliente.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnAltaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				altaClientes();
			}
		});
		btnAltaCliente.setBounds(40, 135, 89, 23);
		panel_1.add(btnAltaCliente);
		
		JButton btnVerVehiculo = new JButton("Ver");
		btnVerVehiculo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnVerVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verVehiculos();
			}
		});
		btnVerVehiculo.setBounds(328, 217, 89, 23);
		panel_1.add(btnVerVehiculo);
		
		JLabel lbl_VerVehiculos = new JLabel("Ver TODOS los VEH\u00CDCULOS");
		lbl_VerVehiculos.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_VerVehiculos.setBounds(292, 192, 160, 14);
		panel_1.add(lbl_VerVehiculos);
		
		JLabel lbl_VenderVehículo = new JLabel("VENDER alg\u00FAn VEH\u00CDCULO");
		lbl_VenderVehículo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_VenderVehículo.setBounds(10, 297, 154, 14);
		panel_1.add(lbl_VenderVehículo);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				venderVehiculo();
			}
		});
		btnVender.setBounds(40, 322, 89, 23);
		panel_1.add(btnVender);
		
		JLabel lbl_ProponerVehiculo = new JLabel("PROPONER alg\u00FAn VEH\u00CDCULO");
		lbl_ProponerVehiculo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_ProponerVehiculo.setBounds(283, 297, 169, 14);
		panel_1.add(lbl_ProponerVehiculo);
		
		JButton btnProponer = new JButton("Proponer");
		btnProponer.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnProponer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				proponerVehiculo();
			}
		});
		btnProponer.setBounds(328, 322, 89, 23);
		panel_1.add(btnProponer);
		
		JLabel lbl_ComprobarPropuestas = new JLabel("COMPROBAR las PROPUESTAS");
		lbl_ComprobarPropuestas.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_ComprobarPropuestas.setBounds(141, 384, 187, 14);
		panel_1.add(lbl_ComprobarPropuestas);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verPropuestas();
			}
		});
		btnComprobar.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnComprobar.setBounds(184, 409, 107, 23);
		panel_1.add(btnComprobar);
		
		JLabel lbl_VerClientes = new JLabel("Ver TODOS los CLIENTES");
		lbl_VerClientes.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_VerClientes.setBounds(298, 110, 154, 14);
		panel_1.add(lbl_VerClientes);
		
		JButton btnVerCliente = new JButton("Ver");
		btnVerCliente.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnVerCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verClientes();
			}
		});
		btnVerCliente.setBounds(328, 135, 89, 23);
		panel_1.add(btnVerCliente);
		
		JLabel lbl_AltaVehiculo = new JLabel("REGISTRAR alg\u00FAn VEH\u00CDCULO");
		lbl_AltaVehiculo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_AltaVehiculo.setBounds(10, 192, 181, 14);
		panel_1.add(lbl_AltaVehiculo);
		
		JButton btnAltaCliente_1 = new JButton("Registrar");
		btnAltaCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaVehiculos();
			}
		});
		btnAltaCliente_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnAltaCliente_1.setBounds(40, 217, 89, 23);
		panel_1.add(btnAltaCliente_1);
	}
	
	public void altaClientes() {
		GUI_AltaCliente alta = new GUI_AltaCliente(this);
		this.setVisible(false);
	}
	
	public void altaVehiculos() {
		GUI_AltaVehiculo alta = new GUI_AltaVehiculo(this);
		this.setVisible(false);
	}
	
	public void verVehiculos() {
		GUI_VerVehiculos verVehiculos = new GUI_VerVehiculos(this);
		this.setVisible(false);
	}
	
	public void verClientes() {
		GUI_VerClientes verClientes = new GUI_VerClientes(this);
		this.setVisible(false);
	}
	
	public void proponerVehiculo() {
		GUI_PropuestaVehiculo1 proponer = new GUI_PropuestaVehiculo1(this);
		this.setVisible(false);
	}
	
	public void verPropuestas() {
		GUI_VerPropuestas verPropuestas = new GUI_VerPropuestas(this);
		this.setVisible(false);
	}
	
	public void venderVehiculo() {
		GUI_VenderVehiculo1 vender = new GUI_VenderVehiculo1(this);
		this.setVisible(false);
	}
}

