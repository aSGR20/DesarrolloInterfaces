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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_VerTrabajos extends javax.swing.JFrame{

	private String NumIncidencia;
	private DefaultTableModel dm;
	private GUI_Mecanicos menu;
	private JFrame frame;
	private JTable table;

	/**
	 * Create the application.
	 */
	public GUI_VerTrabajos(GUI_Mecanicos menu) {
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
		setTitle("Ver lista de Trabajos");
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
		btnVolver.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnVolver.setBounds(157, 344, 189, 70);
		panel_1.add(btnVolver);
		
		dm = new DefaultTableModel();
		table = new JTable(dm);
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		table.setBackground(Color.yellow);
		table.getTableHeader().setBackground(Color.orange);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
		JScrollPane scrollPane= new  JScrollPane(table);
		scrollPane.setLocation(10, 57);
		scrollPane.setSize(456, 256);
		String[]columns = {"Número Incidencia", "Problema", "Tiempo Estimado", "Piezas", "Teléfono"};
		for ( int i=0; i<columns.length;i++){
            dm.addColumn(columns[i]);
        }
		//CARGAR LOS DATOS DE LA BASE DE DATOS DE REPARACIONES
		Object[]data = new Object[5];
		for (int i = 0; i < clienteDao.recibirDatosTrabajos().size();i++) {
			Object[] linea = clienteDao.recibirDatosTrabajos().get(i).toString().split(";");
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
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		menu.setVisible(true);
	}
}
