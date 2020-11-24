package Mecanicos;

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
import Proyecto.DAO_Usuario;
import Ventas.GUI_AltaCliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_AnyadirTrabajos1 extends javax.swing.JFrame{

	private String profesion;
	private String DNI;
	private DefaultTableModel dm;
	private GUI_Mecanicos menu;
	private JFrame frame;
	private JTable table;
	private JTextField textNombre;
	private JTextField textApellidos;

	/**
	 * Create the application.
	 */
	public GUI_AnyadirTrabajos1(GUI_Mecanicos menu, String profesion) {
		initialize();
		this.menu = menu;
		this.profesion = profesion;
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Añadir trabajo");
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
		scrollPane.setLocation(10, 113);
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
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				seleccionar();
			}
		});
		btnSeleccionar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSeleccionar.setBounds(332, 378, 134, 46);
		panel_1.add(btnSeleccionar);
		
		JLabel lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Nombre.setBounds(10, 53, 46, 14);
		panel_1.add(lbl_Nombre);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textNombre.setBounds(66, 50, 120, 20);
		panel_1.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lbl_Apellidos = new JLabel("Apellidos");
		lbl_Apellidos.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Apellidos.setBounds(203, 53, 53, 14);
		panel_1.add(lbl_Apellidos);
		
		textApellidos = new JTextField();
		textApellidos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textApellidos.setColumns(10);
		textApellidos.setBounds(266, 50, 120, 20);
		panel_1.add(textApellidos);
		
		JLabel lbl_Texto = new JLabel("Seleccione al cliente");
		lbl_Texto.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lbl_Texto.setBounds(10, 11, 183, 25);
		panel_1.add(lbl_Texto);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarCliente();
			}
		});
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBuscar.setBounds(387, 77, 79, 25);
		panel_1.add(btnBuscar);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaCliente();
			}
		});
		btnCrear.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCrear.setBounds(203, 399, 79, 25);
		panel_1.add(btnCrear);
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		menu.setVisible(true);
	}
	
	public void buscarCliente() {
		if((textNombre.getText().equals(""))&&(textApellidos.getText().equals(""))) {
			JOptionPane.showMessageDialog(null, "Los campos están vacíos");
		}
		if((!textNombre.getText().equals(""))&&(textApellidos.getText().equals(""))){
			//busca solo nombre en la BBDD
		}
		if((textNombre.getText().equals(""))&&(!textApellidos.getText().equals(""))) {
			//busca solo apellido en la BBDD
		}
		if((!textNombre.getText().equals(""))&&(!textApellidos.getText().equals(""))) {
			//busca nombre y apellido en la BBDD
		}
	}
	
	public void altaCliente() {
		GUI_AltaCliente alta = new GUI_AltaCliente(this, profesion);
		this.setVisible(false);
	}
	
	public void seleccionar() {
		GUI_AnyadirTrabajos2 siguiente = new GUI_AnyadirTrabajos2(this, profesion);
		this.setVisible(false);
		//GUARDAR LOS DATOS DE LA TABLA SELECCIONADO O HACERLO EN EL TABLEMOUSECLICKED
	}
	
	private void tableMouseClicked(java.awt.event.MouseEvent evt) {  
		int selectedRow = table.getSelectedRow();
		DNI = dm.getValueAt(selectedRow, 0).toString();
		textNombre.setText(dm.getValueAt(selectedRow, 1).toString());
		textApellidos.setText(dm.getValueAt(selectedRow, 2).toString());
    }
	
	public String getDni() {
		return DNI;
	}
}