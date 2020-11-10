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
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Proyecto.Cliente;
import Proyecto.DAO_Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_VerClientes extends javax.swing.JFrame{

	private String DNI;
	private DefaultTableModel dm;
	private GUI_Ventas menu;
	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the application.
	 */
	public GUI_VerClientes(GUI_Ventas menu) {
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
		setTitle("Lista de Clientes");
		setBounds(100, 100, 667, 482);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		DAO_Cliente clienteDao = new DAO_Cliente();
		
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
		
		dm = new DefaultTableModel();
		table = new JTable(dm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		JScrollPane scrollPane= new  JScrollPane(table);
		scrollPane.setLocation(10, 104);
		scrollPane.setSize(456, 256);
		String[]columns = {"DNI", "Nombre", "Apellidos", "Telefono", "Domicilio"};
		for ( int i=0; i<columns.length;i++){
            dm.addColumn(columns[i]);
        }
		Object[]data = new Object[5];
		for (int i = 0; i < clienteDao.recibirDatos().size();i++) {
			Object[] linea = clienteDao.recibirDatos().get(i).toString().split(";");
			data[0] = linea[0];
			data[1] = linea[1];
			data[2] = linea[2];
			data[3] = linea[3];
			data[4] = linea[4];
			dm.addRow(data);
		}
		table.setModel(dm);
		
		table.setBounds(20, 70, 446, 305);
		panel_1.add(scrollPane);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				modificar();
				dm.setRowCount(0);
				for (int i = 0; i < clienteDao.recibirDatos().size();i++) {
					Object[] linea = clienteDao.recibirDatos().get(i).toString().split(";");
					data[0] = linea[0];
					data[1] = linea[1];
					data[2] = linea[2];
					data[3] = linea[3];
					data[4] = linea[4];
					dm.addRow(data);
				}
			}
		});
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnModificar.setBounds(332, 378, 134, 46);
		panel_1.add(btnModificar);
		
		JLabel lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Nombre.setBounds(10, 11, 46, 14);
		panel_1.add(lbl_Nombre);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField.setBounds(73, 9, 120, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lbl_Apellidos = new JLabel("Apellidos");
		lbl_Apellidos.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Apellidos.setBounds(10, 51, 53, 14);
		panel_1.add(lbl_Apellidos);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(73, 49, 120, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(297, 11, 120, 20);
		panel_1.add(textField_2);
		
		JLabel lbl_Telefono = new JLabel("Tel\u00E9fono");
		lbl_Telefono.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Telefono.setBounds(234, 13, 53, 14);
		panel_1.add(lbl_Telefono);
		
		JLabel lbl_Domicilio = new JLabel("Domicilio");
		lbl_Domicilio.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Domicilio.setBounds(234, 51, 53, 14);
		panel_1.add(lbl_Domicilio);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(297, 49, 120, 20);
		panel_1.add(textField_3);
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		menu.setVisible(true);
	}
	
	public void modificar() {
		try {
		Object[]datos = new Object[4];
		datos[0] = textField.getText();
		datos[1] = textField_1.getText();
		datos[2] = Integer.parseInt(textField_2.getText());
		datos[3] = textField_3.getText();
		int num = Integer.parseInt(textField_2.getText());
		int cantidad = 0;
		while(num!=0) {
			num = num/10;
			cantidad++;
		}
		if(cantidad==9) {
			DAO_Cliente clienteDao = new DAO_Cliente();
			clienteDao.modificarDatos(DNI, datos);
			dm.addRow(datos);
		}else {
			JOptionPane.showMessageDialog(null, "Numero de telefono mal escrito");
		}
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Numero de telefono mal escrito");
		}
		
	}
	
	private void tableMouseClicked(java.awt.event.MouseEvent evt) {  
		int selectedRow = table.getSelectedRow();
		DNI = dm.getValueAt(selectedRow, 0).toString();
        textField.setText(dm.getValueAt(selectedRow, 1).toString());
        textField_1.setText(dm.getValueAt(selectedRow, 2).toString());
        textField_2.setText(dm.getValueAt(selectedRow, 3).toString());
        textField_3.setText(dm.getValueAt(selectedRow, 4).toString());
    }  
}
