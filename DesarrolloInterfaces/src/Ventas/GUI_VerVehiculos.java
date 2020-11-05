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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_VerVehiculos extends javax.swing.JFrame{

	private GUI_Ventas menu;
	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the application.
	 */
	public GUI_VerVehiculos(GUI_Ventas menu) {
		initialize();
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
		setTitle("Lista de Vehículos");
		setBounds(100, 100, 667, 482);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 176, 443);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sebas\\eclipse-workspace\\DesarrolloInterfaces\\src\\images\\myLogo_Login.png"));
		lblNewLabel.setBounds(26, 48, 122, 55);
		panel.add(lblNewLabel);
		
		JLabel lbl_Nombre_Empleado = new JLabel("NOMBRE_EMPLEADO");
		lbl_Nombre_Empleado.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Nombre_Empleado.setBounds(26, 126, 122, 14);
		panel.add(lbl_Nombre_Empleado);
		
		JLabel lbl_Ocupacion = new JLabel("OCUPACION");
		lbl_Ocupacion.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Ocupacion.setBounds(52, 406, 69, 14);
		panel.add(lbl_Ocupacion);
		
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
		btnVolver.setBounds(10, 378, 134, 46);
		panel_1.add(btnVolver);
		
		table = new JTable();
		JScrollPane scrollPane= new  JScrollPane(table);
		scrollPane.setLocation(10, 104);
		scrollPane.setSize(456, 256);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero Serie", "Marca", "Modelo", "Precio", "Fecha de Entrada"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.setBounds(20, 70, 446, 305);
		panel_1.add(scrollPane);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
			}
		});
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnModificar.setBounds(332, 378, 134, 46);
		panel_1.add(btnModificar);
		
		JLabel lbl_Marca = new JLabel("Marca");
		lbl_Marca.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Marca.setBounds(10, 11, 43, 14);
		panel_1.add(lbl_Marca);
		
		textField = new JTextField();
		textField.setBounds(63, 9, 120, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lbl_Marca_1 = new JLabel("Modelo");
		lbl_Marca_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Marca_1.setBounds(10, 51, 43, 14);
		panel_1.add(lbl_Marca_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(63, 49, 120, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(287, 11, 120, 20);
		panel_1.add(textField_2);
		
		JLabel lbl_Precio = new JLabel("Precio");
		lbl_Precio.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Precio.setBounds(234, 13, 43, 14);
		panel_1.add(lbl_Precio);
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		menu.setVisible(true);
	}
	
	public void modificar() {
		//COGE EL APARTADO SELECCIONADO DE LA TABLA Y LO RELLENA EN LOS TEXTFIELDS, ACTUALIZAR EL APARTADO SELECCIONADO AL CAMPO
	}
}
