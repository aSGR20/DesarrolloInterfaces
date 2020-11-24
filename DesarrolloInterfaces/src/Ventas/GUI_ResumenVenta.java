package Ventas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Proyecto.DAO_Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_ResumenVenta extends javax.swing.JFrame{

	private GUI_VenderVehiculo2 ventaVehiculo;
	private GUI_Ventas menu;
	private JFrame frame;

	/**
	 * Create the application.
	 */
	public GUI_ResumenVenta(GUI_VenderVehiculo2 ventaVehiculo, GUI_Ventas menu) {
		initialize();
		this.ventaVehiculo = ventaVehiculo;
		this.menu = menu;
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Resumen de Venta");
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
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				volver();
			}
		});
		btnVolver.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnVolver.setBounds(10, 381, 134, 46);
		panel_1.add(btnVolver);
		
		JLabel lbl_DNI = new JLabel("DNI");
		lbl_DNI.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_DNI.setBounds(10, 82, 24, 14);
		panel_1.add(lbl_DNI);
		
		JLabel lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_Nombre.setBounds(10, 149, 55, 14);
		panel_1.add(lbl_Nombre);
		
		JButton btnVender = new JButton("VENDER");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		btnVender.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnVender.setBounds(332, 381, 134, 46);
		panel_1.add(btnVender);
		
		JLabel lbldni = new JLabel("insert_text");
		lbldni.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lbldni.setBounds(35, 97, 88, 14);
		panel_1.add(lbldni);
		
		JLabel lblnombre = new JLabel("insert_text");
		lblnombre.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblnombre.setBounds(63, 165, 88, 14);
		panel_1.add(lblnombre);
		
		JLabel lbl_Apellidos = new JLabel("Apellidos");
		lbl_Apellidos.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_Apellidos.setBounds(10, 209, 78, 14);
		panel_1.add(lbl_Apellidos);
		
		JLabel lblapellidos = new JLabel("insert_text");
		lblapellidos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblapellidos.setBounds(69, 227, 88, 14);
		panel_1.add(lblapellidos);
		
		JLabel lbltelefono = new JLabel("insert_text");
		lbltelefono.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lbltelefono.setBounds(70, 289, 88, 14);
		panel_1.add(lbltelefono);
		
		JLabel lbl_Telefono = new JLabel("Tel\u00E9fono");
		lbl_Telefono.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_Telefono.setBounds(11, 271, 78, 14);
		panel_1.add(lbl_Telefono);
		
		JLabel lbl_Cliente = new JLabel("Cliente");
		lbl_Cliente.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lbl_Cliente.setBounds(35, 24, 66, 24);
		panel_1.add(lbl_Cliente);
		
		JLabel lblprecio = new JLabel("insert_text");
		lblprecio.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblprecio.setBounds(353, 289, 88, 14);
		panel_1.add(lblprecio);
		
		JLabel lbl_Telefono_1 = new JLabel("Precio");
		lbl_Telefono_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_Telefono_1.setBounds(319, 271, 78, 14);
		panel_1.add(lbl_Telefono_1);
		
		JLabel lbltipo = new JLabel("insert_text");
		lbltipo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lbltipo.setBounds(353, 227, 88, 14);
		panel_1.add(lbltipo);
		
		JLabel lbl_Apellidos_1 = new JLabel("Tipo");
		lbl_Apellidos_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_Apellidos_1.setBounds(318, 209, 78, 14);
		panel_1.add(lbl_Apellidos_1);
		
		JLabel lblmodelo = new JLabel("insert_text");
		lblmodelo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblmodelo.setBounds(371, 165, 88, 14);
		panel_1.add(lblmodelo);
		
		JLabel lbl_Nombre_1 = new JLabel("Modelo");
		lbl_Nombre_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_Nombre_1.setBounds(318, 149, 55, 14);
		panel_1.add(lbl_Nombre_1);
		
		JLabel lblmarca = new JLabel("insert_text");
		lblmarca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblmarca.setBounds(343, 97, 88, 14);
		panel_1.add(lblmarca);
		
		JLabel lbl_DNI_1 = new JLabel("Marca");
		lbl_DNI_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_DNI_1.setBounds(318, 82, 55, 14);
		panel_1.add(lbl_DNI_1);
		
		JLabel lbl_Cliente_1 = new JLabel("Cliente");
		lbl_Cliente_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lbl_Cliente_1.setBounds(353, 24, 66, 24);
		panel_1.add(lbl_Cliente_1);
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		ventaVehiculo.setVisible(true);
	}
	
	public void guardar() {
		//AGREGAR TODOS LOS DATOS SELECCIONADOS A LA BASE DE DATOS
		this.setVisible(false);
		this.dispose();
		menu.setVisible(true);
	}
}
