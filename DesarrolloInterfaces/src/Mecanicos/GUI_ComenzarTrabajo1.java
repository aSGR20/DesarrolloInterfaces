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

import Proyecto.DAO_Cliente;
import Proyecto.DAO_Usuario;
import Proyecto.DAO_Cliente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_ComenzarTrabajo1 extends javax.swing.JFrame{

	private GUI_Mecanicos menu;
	private String NumIncidencia;
	private DefaultTableModel dm;
	private JFrame frame;
	private JTable table;

	/**
	 * Create the application.
	 */
	public GUI_ComenzarTrabajo1(GUI_Mecanicos menu) {
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
		setTitle("Comenzar un trabajo");
		setBounds(100, 100, 667, 482);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		DAO_Cliente clienteDao = new DAO_Cliente();
		GUI_ComenzarTrabajo2 siguiente = new GUI_ComenzarTrabajo2();
		
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
		lbl_Ocupacion.setBounds(52, 406, 122, 14);
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
		btnVolver.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnVolver.setBounds(10, 344, 175, 62);
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
		scrollPane.setLocation(10, 38);
		scrollPane.setSize(456, 265);
		String[]columns = {"Número Incidencia", "Problema", "Tiempo Estimado", "Piezas", "Teléfono"};
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
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				siguientePaso();
			}
		});
		btnComenzar.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnComenzar.setBounds(291, 344, 175, 62);
		panel_1.add(btnComenzar);
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		menu.setVisible(true);
	}
	
	public void siguientePaso() {
		try {
			int selectedRow = table.getSelectedRow();
			NumIncidencia= dm.getValueAt(selectedRow, 0).toString();
			GUI_ComenzarTrabajo2 siguiente = new GUI_ComenzarTrabajo2(this, menu);
			this.setVisible(false);
		}catch(ArrayIndexOutOfBoundsException aiooe) {
			JOptionPane.showMessageDialog(null, "Señala la reparación ha realizar");
		}catch(NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "Señala la reparación ha realizar");
		}
	}
	
	private void tableMouseClicked(java.awt.event.MouseEvent evt) {  
		int selectedRow = table.getSelectedRow();
		NumIncidencia= dm.getValueAt(selectedRow, 0).toString();
    }  
}
