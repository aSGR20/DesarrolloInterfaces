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
import Proyecto.DAO_Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_VerPropuestas extends javax.swing.JFrame{

	private String DNI;
	private DefaultTableModel dm;
	private GUI_Ventas menu;
	private JFrame frame;
	private JTable table;
	private JTextField text_DNI;
	private JTextField text_Nombre;
	private JTextField text_Marca;
	private JTextField text_Modelo;

	/**
	 * Create the application.
	 */
	public GUI_VerPropuestas(GUI_Ventas menu) {
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
		String[]columns = {"DNI", "Nombre", "Marca", "Modelo", "Tipo", "Fecha_Entrada"};
		for ( int i=0; i<columns.length;i++){
            dm.addColumn(columns[i]);
        }
		Object[]data = new Object[6];
		for (int i = 0; i < clienteDao.recibirPropuestas().size();i++) {
			Object[] linea = clienteDao.recibirPropuestas().get(i).toString().split(";");
			data[0] = linea[0];
			data[1] = linea[1];
			data[2] = linea[2];
			data[3] = linea[3];
			data[4] = linea[4];
			data[5] = linea[5];
			dm.addRow(data);
		}
		table.setModel(dm);
		
		table.setBounds(20, 70, 446, 305);
		panel_1.add(scrollPane);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dm.setRowCount(0);
				String dni = text_DNI.getText();
				String nombre = text_Nombre.getText();
				String marca = text_Marca.getText();
				String modelo = text_Modelo.getText();
				DAO_Cliente clienteDao = new DAO_Cliente();
				Object[]data = new Object[6];
				if((text_DNI.getText().equals(""))&&(text_Nombre.getText().equals(""))&&(text_Marca.getText().equals(""))&&(text_Modelo.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "No puedes buscar  \"nada\"");
				}
				if((!text_DNI.getText().equals(""))&&(!text_Nombre.getText().equals(""))&&(!text_Marca.getText().equals(""))&&(!text_Modelo.getText().equals(""))) {
					for(int i = 0; i < clienteDao.recibirPropuestasTodo(dni, nombre, marca, modelo).size(); i++) {
						Object[] linea = clienteDao.recibirPropuestasTodo(dni, nombre, marca, modelo).get(i).toString().split(";");
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						dm.addRow(data);
					}
				}else if(!text_DNI.getText().equals("")) {
					for(int i = 0; i < clienteDao.recibirPropuestasDni(dni).size(); i++) {
						Object[] linea = clienteDao.recibirPropuestasDni(dni).get(i).toString().split(";");
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						dm.addRow(data);
					}
				}else if(!text_Nombre.getText().equals("")) {
					for(int i = 0; i < clienteDao.recibirPropuestasNombre(nombre).size(); i++) {
						Object[] linea = clienteDao.recibirPropuestasNombre(nombre).get(i).toString().split(";");
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						dm.addRow(data);
					}
				}else if(!text_Marca.getText().equals("")) {
					for(int i = 0; i < clienteDao.recibirPropuestasMarca(marca).size(); i++) {
						Object[] linea = clienteDao.recibirPropuestasMarca(marca).get(i).toString().split(";");
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						dm.addRow(data);
					}
				}else if(!text_Modelo.getText().equals("")) {
					for(int i = 0; i < clienteDao.recibirPropuestasModelo(modelo).size(); i++) {
						Object[] linea = clienteDao.recibirPropuestasModelo(modelo).get(i).toString().split(";");
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						dm.addRow(data);
					}
				}
			}
		});
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBuscar.setBounds(332, 371, 134, 25);
		panel_1.add(btnBuscar);
		
		JLabel lbl_DNI = new JLabel("DNI");
		lbl_DNI.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_DNI.setBounds(41, 13, 46, 14);
		panel_1.add(lbl_DNI);
		
		text_DNI = new JTextField();
		text_DNI.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_DNI.setBounds(73, 9, 120, 20);
		panel_1.add(text_DNI);
		text_DNI.setColumns(10);
		
		JLabel lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Nombre.setBounds(10, 51, 53, 14);
		panel_1.add(lbl_Nombre);
		
		text_Nombre = new JTextField();
		text_Nombre.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_Nombre.setColumns(10);
		text_Nombre.setBounds(73, 49, 120, 20);
		panel_1.add(text_Nombre);
		
		text_Marca = new JTextField();
		text_Marca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_Marca.setColumns(10);
		text_Marca.setBounds(297, 11, 120, 20);
		panel_1.add(text_Marca);
		
		JLabel lbl_Marca = new JLabel("Marca");
		lbl_Marca.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Marca.setBounds(256, 13, 53, 14);
		panel_1.add(lbl_Marca);
		
		JLabel lbl_Modelo = new JLabel("Modelo");
		lbl_Modelo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Modelo.setBounds(251, 51, 53, 14);
		panel_1.add(lbl_Modelo);
		
		text_Modelo = new JTextField();
		text_Modelo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_Modelo.setColumns(10);
		text_Modelo.setBounds(297, 49, 120, 20);
		panel_1.add(text_Modelo);
		
		JButton btnResetear = new JButton("Resetear");
		btnResetear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetear();
			}
		});
		btnResetear.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnResetear.setBounds(332, 407, 134, 25);
		panel_1.add(btnResetear);
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		menu.setVisible(true);
	}
	
	public void buscarPropuestas() {
		dm.setRowCount(0);
		DAO_Cliente clienteDao = new DAO_Cliente();
		Object[]data = new Object[6];
		if((text_DNI.getText().equals(""))&&(text_Nombre.getText().equals(""))&&(text_Marca.getText().equals(""))&&(text_Modelo.getText().equals(""))) {
			JOptionPane.showMessageDialog(null, "No puedes buscar \"nada\"");
		}else if(!text_DNI.getText().equals("")) {
			//Busca DNI
			String dni = text_DNI.getText();
			for(int i = 0; i < clienteDao.buscarDatosDni(dni).size(); i++) {
				Object[] linea = clienteDao.buscarDatosDni(dni).get(i).toString().split(";");
				data[0] = linea[0];
				data[1] = linea[1];
				data[2] = linea[2];
				data[3] = linea[3];
				data[4] = linea[4];
				data[5] = linea[5];
				dm.addRow(data);
			}
		}
		
		
	}
	
	public void resetear() {
		dm.setRowCount(0);
		DAO_Cliente clienteDao = new DAO_Cliente();
		text_DNI.setText("");
		text_Nombre.setText("");
		text_Marca.setText("");
		text_Modelo.setText("");
		Object[]data = new Object[6];
		for (int i = 0; i < clienteDao.recibirPropuestas().size();i++) {
			Object[] linea = clienteDao.recibirPropuestas().get(i).toString().split(";");
			data[0] = linea[0];
			data[1] = linea[1];
			data[2] = linea[2];
			data[3] = linea[3];
			data[4] = linea[4];
			data[5] = linea[5];
			dm.addRow(data);
		}
	}
	
	private void tableMouseClicked(java.awt.event.MouseEvent evt) {  
		int selectedRow = table.getSelectedRow();
		DNI = dm.getValueAt(selectedRow, 0).toString();
        text_DNI.setText(dm.getValueAt(selectedRow, 0).toString());
        text_Nombre.setText(dm.getValueAt(selectedRow, 1).toString());
        text_Marca.setText(dm.getValueAt(selectedRow, 2).toString());
        text_Modelo.setText(dm.getValueAt(selectedRow, 3).toString());
    }  
}
