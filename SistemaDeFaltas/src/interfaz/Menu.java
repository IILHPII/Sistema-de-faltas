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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private static int ciU;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;

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
		tabbedPane.setBounds(0, 0, 900, 573);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Administrar Usuarios", new ImageIcon(Menu.class.getResource("/imgs/prueba2.png")), panel, null);
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		panel.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(12, 322, 857, 2);
		panel.add(separator_1_1);
		
		JLabel lblAltaDeUsuario = new JLabel("Alta de usuario");
		lblAltaDeUsuario.setBounds(148, 19, 148, 15);
		panel.add(lblAltaDeUsuario);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(12, 46, 148, 15);
		panel.add(lblCedula);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(caracter<'0' || caracter>'9' && caracter!='\b') {
					e.consume();
				}
			}
		});
		textField.setBounds(133, 39, 171, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCedula_1 = new JLabel("Nombre");
		lblCedula_1.setBounds(12, 87, 148, 15);
		panel.add(lblCedula_1);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				 boolean mayusculas = caracter >= 65 && caracter <= 90;
				 boolean minusculas = caracter >= 97 && caracter <= 122;
				 boolean espacio = caracter == 32;
				if(!(minusculas || mayusculas || espacio)) {
					e.consume();
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(133, 80, 171, 29);
		panel.add(textField_1);
		
		JLabel lblCedula_1_1 = new JLabel("Contraseña");
		lblCedula_1_1.setBounds(12, 136, 148, 15);
		panel.add(lblCedula_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 129, 171, 29);
		panel.add(textField_2);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(12, 197, 148, 15);
		panel.add(lblUsuario);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(133, 190, 171, 29);
		panel.add(comboBox);
		
		
		JButton btnCargar = new JButton("");
		btnCargar.setBounds(178, 216, 91, 94);
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
				
				try {
					carga.setCi(Integer.parseInt(textField.getText()));
					carga.setNombre(textField_1.getText());
					carga.setPassword(textField_2.getText());
					carga.setRol(comboBox.getSelectedItem().toString());
					carga.alta();
				}catch(java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Valores ingresados nulos o incorrectos","Hey!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnCargar);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1.setBounds(459, 12, 2, 298);
		panel.add(separator_1_1_1);
		
		JLabel lblEditarUsuario = new JLabel("Editar usuario");
		lblEditarUsuario.setBounds(158, 322, 148, 15);
		panel.add(lblEditarUsuario);
		
		JLabel lblCedulaDelUsuario = new JLabel("Cedula del usuario");
		lblCedulaDelUsuario.setBounds(12, 364, 148, 15);
		panel.add(lblCedulaDelUsuario);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(caracter<'0' || caracter>'9' && caracter!='\b') {
					e.consume();
				}
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(178, 357, 171, 29);
		panel.add(textField_5);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					carga.setCi(Integer.parseInt(textField_5.getText()));
					boolean existe=carga.consultaCiU();
					if(existe==true) {
						JOptionPane.showMessageDialog(null,"El usuario esta registrado! Puede proceder a modificar","Hey!",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null,"El usuario no esta registrado!","Hey!",JOptionPane.INFORMATION_MESSAGE);
					}	
				}catch(java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Valores ingresados nulos o incorrectos","Hey!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
		btnNewButton.setBounds(373, 357, 41, 28);
		panel.add(btnNewButton);
		
		JLabel lblEditarNombre = new JLabel("Editar nombre");
		lblEditarNombre.setBounds(12, 430, 148, 15);
		panel.add(lblEditarNombre);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(12, 463, 114, 29);
		panel.add(textField_6);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(148, 463, 171, 29);
		panel.add(comboBox_2);
		for(String s : carga.llenarCombo()) {
			comboBox.addItem(s);
			comboBox_2.addItem(s);
		}
		
		JLabel lblCambiarTipoUsuario = new JLabel("Cambiar Tipo Usuario");
		lblCambiarTipoUsuario.setBounds(158, 431, 173, 15);
		panel.add(lblCambiarTipoUsuario);
		
		JSeparator separator_1_1_2 = new JSeparator();
		separator_1_1_2.setBounds(9, 414, 431, 4);
		panel.add(separator_1_1_2);
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1_1.setBounds(458, 329, 3, 193);
		panel.add(separator_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					carga.setNombre(textField_6.getText());
					carga.setRol(comboBox_2.getSelectedItem().toString());
					carga.modificacion();
				}catch(java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Ingreso nulo o invalido!","Hey!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/22332.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/submit1.png")));
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/submit1.png")));
		btnNewButton_1.setBounds(330, 463, 124, 27);
		panel.add(btnNewButton_1);
		
		JLabel lblBajaDeUsuario = new JLabel("Baja de usuario");
		lblBajaDeUsuario.setBounds(569, 12, 148, 15);
		panel.add(lblBajaDeUsuario);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(611, 32, 171, 29);
		panel.add(textField_3);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(744, 74, 41, 28);
		panel.add(btnNewButton_2);
		
		JLabel lblCedulaDelUsuario_1_1 = new JLabel("Nombre del usuario");
		lblCedulaDelUsuario_1_1.setBounds(479, 169, 148, 15);
		panel.add(lblCedulaDelUsuario_1_1);
		
		JLabel lblCedulaDelUsuario_1 = new JLabel("Cedula del usuario");
		lblCedulaDelUsuario_1.setBounds(468, 39, 148, 15);
		panel.add(lblCedulaDelUsuario_1);
		
		JLabel lblCedulaDelUsuario_1_1_1 = new JLabel(".....");
		lblCedulaDelUsuario_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCedulaDelUsuario_1_1_1.setBounds(479, 230, 148, 15);
		panel.add(lblCedulaDelUsuario_1_1_1);
		
		JButton btnConfirmarBaja = new JButton("Confirmar baja");
		btnConfirmarBaja.setForeground(Color.WHITE);
		btnConfirmarBaja.setBackground(new Color(153, 193, 241));
		btnConfirmarBaja.setBounds(699, 164, 182, 25);
		panel.add(btnConfirmarBaja);
		
		JButton btnConfirmarBaja_1 = new JButton("Cancelar");
		btnConfirmarBaja_1.setForeground(Color.WHITE);
		btnConfirmarBaja_1.setBackground(new Color(153, 193, 241));
		btnConfirmarBaja_1.setBounds(721, 225, 148, 25);
		panel.add(btnConfirmarBaja_1);
		
		JLabel lblCedulaDelUsuario_1_1_2 = new JLabel("Cambio de contraseña");
		lblCedulaDelUsuario_1_1_2.setBounds(600, 322, 182, 15);
		panel.add(lblCedulaDelUsuario_1_1_2);
		
		JLabel lblCedulaDelUsuario_1_2 = new JLabel("Cedula del usuario");
		lblCedulaDelUsuario_1_2.setBounds(479, 364, 148, 15);
		panel.add(lblCedulaDelUsuario_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(629, 357, 171, 29);
		panel.add(textField_4);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_2_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_2_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
		btnNewButton_2_1.setContentAreaFilled(false);
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setBounds(825, 357, 41, 28);
		panel.add(btnNewButton_2_1);
		
		JSeparator separator_1_1_2_1 = new JSeparator();
		separator_1_1_2_1.setBounds(459, 414, 410, 2);
		panel.add(separator_1_1_2_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(477, 460, 177, 29);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(682, 461, 171, 29);
		panel.add(textField_8);
		
		JLabel lblCedulaDelUsuario_1_2_1 = new JLabel("Nueva contraseña");
		lblCedulaDelUsuario_1_2_1.setBounds(494, 424, 148, 15);
		panel.add(lblCedulaDelUsuario_1_2_1);
		
		JLabel lblCedulaDelUsuario_1_2_1_1 = new JLabel("Repita contraseña");
		lblCedulaDelUsuario_1_2_1_1.setBounds(695, 425, 148, 15);
		panel.add(lblCedulaDelUsuario_1_2_1_1);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setBackground(new Color(153, 193, 241));
		btnConfirmar.setBounds(475, 501, 177, 25);
		panel.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(153, 193, 241));
		btnCancelar.setBounds(678, 501, 176, 25);
		panel.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 893, 600);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/imgs/fondoMenu23.png")));
		lblNewLabel.setBackground(new Color(45, 173, 222));
		this.setLocationRelativeTo(null);
		
	}
}