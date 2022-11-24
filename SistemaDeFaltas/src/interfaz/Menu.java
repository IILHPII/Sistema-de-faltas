package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.border.LineBorder;

import configuration.Conexion;
import model.Persona;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;

public class Menu extends JFrame {

	private JPanel contentPane;
	private Conexion carga=new Conexion();
	private Persona registroPersona=new Persona();
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tabbedPane.setFont(new Font("DialogInput", Font.PLAIN, 11));
		tabbedPane.setBounds(0, 0, 900, 560);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Agregar nuevo usuario", new ImageIcon(Menu.class.getResource("/imgs/prueba2.png")), panel, null);
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		panel.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(12, 322, 857, 2);
		panel.add(separator_1_1);
		
		
		JButton btnCargar = new JButton("");
		btnCargar.setBounds(120, 231, 91, 94);
		btnCargar.setBorderPainted(false);
		btnCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCargar.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo111.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnCargar.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo222.png")));
			}
		});
		btnCargar.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo222.png")));
		btnCargar.setContentAreaFilled(false);
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroPersona.setCi(Integer.parseInt(textField.getText()));
				registroPersona.setNombre(textField_1.getText());
				registroPersona.setPassword(textField_2.getText());
				
			
			}
		});
		panel.add(btnCargar);
		
		JLabel lblAltaDeUsuario = new JLabel("Alta de usuario");
		lblAltaDeUsuario.setBounds(110, 12, 148, 15);
		panel.add(lblAltaDeUsuario);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(12, 46, 148, 15);
		panel.add(lblCedula);
		
		textField = new JTextField();
		textField.setBounds(89, 39, 171, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCedula_1 = new JLabel("Nombre");
		lblCedula_1.setBounds(12, 87, 148, 15);
		panel.add(lblCedula_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(87, 80, 171, 29);
		panel.add(textField_1);
		
		JLabel lblCedula_1_1 = new JLabel("Contraseña");
		lblCedula_1_1.setBounds(0, 136, 148, 15);
		panel.add(lblCedula_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(87, 129, 171, 29);
		panel.add(textField_2);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(12, 197, 148, 15);
		panel.add(lblUsuario);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(89, 190, 171, 29);
		panel.add(comboBox);
		for(String s : carga.llenarCombo()) {
			comboBox.addItem(s);
		}
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1.setBounds(310, 12, 2, 298);
		panel.add(separator_1_1_1);
		
		JLabel lblEditarUsuario = new JLabel("Editar usuario");
		lblEditarUsuario.setBounds(110, 325, 148, 15);
		panel.add(lblEditarUsuario);
		
		JLabel lblCedulaDelUsuario = new JLabel("Cedula del usuario");
		lblCedulaDelUsuario.setBounds(12, 364, 148, 15);
		panel.add(lblCedulaDelUsuario);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(178, 357, 171, 29);
		panel.add(textField_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -17, 893, 643);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/imgs/fondoMenu23.png")));
		lblNewLabel.setBackground(Color.BLUE);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Ingresar inasistencia", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblCedulaDeIdentidad_1 = new JLabel("Cedula de identidad");
		lblCedulaDeIdentidad_1.setBounds(49, 91, 159, 24);
		panel_2.add(lblCedulaDeIdentidad_1);
		
		JLabel lblCedulaDeIdentidad_1_1 = new JLabel("Asignatura");
		lblCedulaDeIdentidad_1_1.setBounds(49, 163, 159, 24);
		panel_2.add(lblCedulaDeIdentidad_1_1);
		
		JLabel lblCedulaDeIdentidad_1_1_1 = new JLabel("Grupo");
		lblCedulaDeIdentidad_1_1_1.setBounds(49, 213, 159, 24);
		panel_2.add(lblCedulaDeIdentidad_1_1_1);
		
		JLabel lblCedulaDeIdentidad_1_1_1_1 = new JLabel("Motivo");
		lblCedulaDeIdentidad_1_1_1_1.setBounds(38, 409, 159, 24);
		panel_2.add(lblCedulaDeIdentidad_1_1_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(227, 163, 276, 24);
		panel_2.add(comboBox_1);
		
		
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(227, 227, 276, 24);
		panel_2.add(comboBox_1_1);
		
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter= e.getKeyChar();
				if(caracter<'0' || caracter>'9' && caracter!='\b') {
					e.consume();
				}
			}
		});
		textField_3.setOpaque(false);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("DialogInput", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBounds(227, 87, 276, 30);
		panel_2.add(textField_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(227, 115, 276, 2);
		panel_2.add(separator_2);
		
		textField_4 = new JTextField();
		textField_4.setOpaque(false);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("DialogInput", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBounds(227, 394, 276, 30);
		panel_2.add(textField_4);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(227, 409, 276, 2);
		panel_2.add(separator_2_1);
		
		JButton btnCargarFecha = new JButton("Cargar fecha");
		btnCargarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
	
			}
		});
		btnCargarFecha.setBounds(522, 192, 150, 25);
		panel_2.add(btnCargarFecha);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setBounds(227, 282, 276, 24);
		panel_2.add(comboBox_1_1_1);
		
		JLabel lblCedulaDeIdentidad_1_1_1_2 = new JLabel("Fecha de clase");
		lblCedulaDeIdentidad_1_1_1_2.setBounds(49, 282, 159, 24);
		panel_2.add(lblCedulaDeIdentidad_1_1_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/fondoMenu23.png")));
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setBounds(0, 0, 900, 614);
		panel_2.add(lblNewLabel_1);
		this.setLocationRelativeTo(null);
		
	}
}