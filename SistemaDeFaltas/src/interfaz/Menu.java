package interfaz;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.border.LineBorder;

import configuration.CombosConexion;
import configuration.Conexion;
import configuration.CrudDBDocente;
import configuration.CrudDBPersona;


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


public class Menu extends JFrame {

	private JPanel contentPane;
	private Conexion carga=new Conexion();
	private CrudDBPersona  crud=new CrudDBPersona();
	private CrudDBDocente crudDocente=new CrudDBDocente();
	private CombosConexion combosConexion=new CombosConexion();
	private RegistroDeFaltas registro=new RegistroDeFaltas();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblCedulaDelUsuario_1_1_1;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;

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
		setUndecorated(true);
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
		tabbedPane.setBounds(0, 0, 900, 600);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Inicio", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Bienvenido!");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(324, 12, 222, 43);
		panel_1.add(lblNewLabel_3);

		
		JSeparator separator = new JSeparator();
		separator.setBounds(365, 44, 140, 2);
		panel_1.add(separator);
		
		JButton btnNewButton_4 = new JButton("Registrar falta de docente");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(319, 155, 227, 43);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Consultas");
		btnNewButton_4_1.setBounds(319, 255, 227, 43);
		panel_1.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_1_1 = new JButton("");
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_4_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_4_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/exit22.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_4_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/exit.png")));
			}
		});
		btnNewButton_4_1_1.setContentAreaFilled(false);
		btnNewButton_4_1_1.setBorderPainted(false);
		btnNewButton_4_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/exit.png")));
		btnNewButton_4_1_1.setBounds(818, 497, 63, 59);
		panel_1.add(btnNewButton_4_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/fondoMenu23.png")));
		lblNewLabel_2.setBackground(new Color(45, 173, 222));
		lblNewLabel_2.setBounds(0, 0, 893, 600);
		panel_1.add(lblNewLabel_2);
		
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
		lblAltaDeUsuario.setBounds(158, 12, 148, 15);
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
		
		JComboBox<String> comboBox = new JComboBox<String>();
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
					crud.setCi(Integer.parseInt(textField.getText()));
					crud.setNombre(textField_1.getText());
					crud.setPassword(textField_2.getText());
					crud.setRol(comboBox.getSelectedItem().toString());
					
					if(textField_1.getText().length()==0 || textField_2.getText().length()==0) {
						JOptionPane.showMessageDialog(null,"Nombre o password no fueron ingresados!","Hey!",JOptionPane.ERROR_MESSAGE);
					}else {
						if(crud.consulta()==true) {
							JOptionPane.showMessageDialog(null,"Usuario ya registrado en el sistema!","Hey!",JOptionPane.ERROR_MESSAGE);
						}else {
							crud.alta();
							JOptionPane.showMessageDialog(null,"Usuario registrado correctamente!","Hey!",JOptionPane.INFORMATION_MESSAGE);
						}	
					}
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
		
		JLabel lblEditarNombre = new JLabel("Editar nombre");
		lblEditarNombre.setBounds(12, 430, 148, 15);
		panel.add(lblEditarNombre);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(12, 463, 114, 29);
		panel.add(textField_6);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(148, 463, 171, 29);
		panel.add(comboBox_2);
		for(String s : combosConexion.llenarCombo()) {
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
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre=textField_6.getText();
					if(nombre.equals("")) {
						JOptionPane.showMessageDialog(null,"El campo nombre esta vacio!","Hey!",JOptionPane.ERROR_MESSAGE);
					}else {
					crud.setNombre(textField_6.getText());
					crud.setRol(comboBox_2.getSelectedItem().toString());
					crud.modificacionNombreTipo();
					JOptionPane.showMessageDialog(null,"Los datos se modificaron correctamente!","Hey!",JOptionPane.INFORMATION_MESSAGE);
					btnNewButton_1.setEnabled(false);
					}
				}catch(java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Valores ingresados nulos o incorrectos","Hey!",JOptionPane.ERROR_MESSAGE);
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
		
		JLabel lblBajaDeUsuario = new JLabel("Baja de Usuario");
		lblBajaDeUsuario.setBounds(569, 12, 148, 15);
		panel.add(lblBajaDeUsuario);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(caracter<'0' || caracter>'9' && caracter!='\b') {
					e.consume();
				}
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(611, 32, 171, 29);
		panel.add(textField_3);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					carga.setCi(Integer.parseInt(textField_5.getText()));
					boolean existe=carga.consultaCiU();
					if(existe==true) {
						JOptionPane.showMessageDialog(null,"El usuario esta registrado! Puede proceder a modificar","Hey!",JOptionPane.INFORMATION_MESSAGE);
						crud.setCi(Integer.parseInt(textField_5.getText()));
						btnNewButton_1.setEnabled(true);
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
		
		JLabel lblCedulaDelUsuario_1_1 = new JLabel("Nombre del Usuario");
		lblCedulaDelUsuario_1_1.setBounds(479, 169, 148, 15);
		panel.add(lblCedulaDelUsuario_1_1);
		
		JLabel lblCedulaDelUsuario_1 = new JLabel("Cedula del Usuario");
		lblCedulaDelUsuario_1.setBounds(468, 39, 148, 15);
		panel.add(lblCedulaDelUsuario_1);
		
		lblCedulaDelUsuario_1_1_1 = new JLabel(".....");
		lblCedulaDelUsuario_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCedulaDelUsuario_1_1_1.setBounds(479, 230, 148, 15);
		panel.add(lblCedulaDelUsuario_1_1_1);
		
		JButton btnConfirmarBaja = new JButton("Confirmar baja");
		btnConfirmarBaja.setEnabled(false);
		btnConfirmarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eleccion=JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea eliminar el siguiente usuario? "+crud.getCi(),"Confirmacion",JOptionPane.YES_NO_OPTION);
				if(eleccion==0) {
					crud.eliminacion();
					JOptionPane.showMessageDialog(null,"Acabas de eliminar al usuario:"+crud.getCi(),"Hey!",JOptionPane.INFORMATION_MESSAGE);
					lblCedulaDelUsuario_1_1_1.setText(".....");
					btnConfirmarBaja.setEnabled(false);
				}else if(eleccion==1) {
					JOptionPane.showMessageDialog(null,"Presionaste en no eliminar al usuario:"+carga.getCi(),"Hey!",JOptionPane.INFORMATION_MESSAGE);
					textField_3.setText("");
					crud.setCi(0);
					lblCedulaDelUsuario_1_1_1.setText(".....");
					btnConfirmarBaja.setEnabled(false);
				}
			}
		});
		btnConfirmarBaja.setForeground(Color.WHITE);
		btnConfirmarBaja.setBackground(new Color(153, 193, 241));
		btnConfirmarBaja.setBounds(687, 225, 182, 25);
		panel.add(btnConfirmarBaja);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					carga.setCi(Integer.parseInt(textField_3.getText()));
					boolean existe=carga.consultaCiU();
					if(existe==true) {
						JOptionPane.showMessageDialog(null,"El usuario esta registrado! Puede proceder a eliminar","Hey!",JOptionPane.INFORMATION_MESSAGE);
						crud.setCi(Integer.parseInt(textField_3.getText()));
						lblCedulaDelUsuario_1_1_1.setText(crud.getNombreFromDB());
						btnConfirmarBaja.setEnabled(true);
					}else {
						JOptionPane.showMessageDialog(null,"El usuario no esta registrado!","Hey!",JOptionPane.INFORMATION_MESSAGE);
						textField_3.setText("");
					}	
				}catch(java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Valores ingresados nulos o incorrectos","Hey!",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
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
		btnNewButton_2.setBounds(744, 74, 41, 28);
		panel.add(btnNewButton_2);
		
		JLabel lblCedulaDelUsuario_1_1_2 = new JLabel("Cambio de contraseña");
		lblCedulaDelUsuario_1_1_2.setBounds(600, 322, 182, 15);
		panel.add(lblCedulaDelUsuario_1_1_2);
		
		JLabel lblCedulaDelUsuario_1_2 = new JLabel("Cedula del Usuario");
		lblCedulaDelUsuario_1_2.setBounds(479, 364, 148, 15);
		panel.add(lblCedulaDelUsuario_1_2);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(caracter<'0' || caracter>'9' && caracter!='\b') {
					e.consume();
				}
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(629, 357, 171, 29);
		panel.add(textField_4);
		
		JSeparator separator_1_1_2_1 = new JSeparator();
		separator_1_1_2_1.setBounds(473, 414, 396, 2);
		panel.add(separator_1_1_2_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(477, 460, 177, 29);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(705, 460, 171, 29);
		panel.add(textField_8);
		
		JLabel lblCedulaDelUsuario_1_2_1 = new JLabel("Nueva contraseña");
		lblCedulaDelUsuario_1_2_1.setBounds(494, 424, 148, 15);
		panel.add(lblCedulaDelUsuario_1_2_1);
		
		JLabel lblCedulaDelUsuario_1_2_1_1 = new JLabel("Repita contraseña");
		lblCedulaDelUsuario_1_2_1_1.setBounds(721, 424, 148, 15);
		panel.add(lblCedulaDelUsuario_1_2_1_1);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(textField_7.getText().toString().equals("") || textField_8.getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null,"Los campos estan vacios!","Hey!",JOptionPane.ERROR_MESSAGE);	
			}else if(textField_7.getText().toString().equals(textField_8.getText().toString())) {
				int eleccion=JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea modificar el passsword del siguiente docente? "+crud.getCi(),"Confirmacion",JOptionPane.YES_NO_OPTION);
					if(eleccion==0) {
						crud.setPassword(textField_7.getText().toString());
						crud.modificacionPassword();
						JOptionPane.showMessageDialog(null,"Acabas de modificar la contraseña del docente:"+carga.getCi(),"Hey!",JOptionPane.INFORMATION_MESSAGE);
						btnConfirmar.setEnabled(false);
					}else if(eleccion==1) {
						JOptionPane.showMessageDialog(null,"Presionaste en no modificar la contraseña del docente:"+carga.getCi(),"Hey!",JOptionPane.INFORMATION_MESSAGE);	
						btnConfirmar.setEnabled(false);
					}
			}else {
				JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden!","Hey!",JOptionPane.ERROR_MESSAGE);	
				btnConfirmar.setEnabled(false);
				}
			}
		});
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setBackground(new Color(153, 193, 241));
		btnConfirmar.setBounds(581, 497, 177, 25);
		panel.add(btnConfirmar);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					carga.setCi(Integer.parseInt(textField_4.getText()));
					boolean confirmacion=carga.consultaCiU();
					if(confirmacion==true) {
						JOptionPane.showMessageDialog(null,"El usuario esta registrado! Puede proceder a modificar la contraseña","Hey!",JOptionPane.INFORMATION_MESSAGE);
						crud.setCi(Integer.parseInt(textField_4.getText()));
						btnConfirmar.setEnabled(true);
					}else {
						JOptionPane.showMessageDialog(null,"El usuario no esta registrado!","Hey!",JOptionPane.INFORMATION_MESSAGE);
					}
				}catch(java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Valores ingresados nulos o incorrectos","Hey!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 893, 600);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/imgs/fondoMenu23.png")));
		lblNewLabel.setBackground(new Color(45, 173, 222));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Administrar Docentes", new ImageIcon(Menu.class.getResource("/imgs/prueba2.png")), panel_2, null);
		
		JSeparator separator_1_1_3 = new JSeparator();
		separator_1_1_3.setBounds(12, 322, 857, 2);
		panel_2.add(separator_1_1_3);
		
		JLabel lblAltaDeDocente = new JLabel("Alta de docente");
		lblAltaDeDocente.setBounds(158, 12, 148, 15);
		panel_2.add(lblAltaDeDocente);
		
		JLabel lblCedula_2 = new JLabel("Cedula");
		lblCedula_2.setBounds(12, 87, 148, 15);
		panel_2.add(lblCedula_2);
		
		textField_9 = new JTextField();
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(caracter<'0' || caracter>'9' && caracter!='\b') {
					e.consume();
				}
			}
		});
		textField_9.setColumns(10);
		textField_9.setBounds(133, 80, 171, 29);
		panel_2.add(textField_9);
		
		JLabel lblCedula_1_2 = new JLabel("Nombre");
		lblCedula_1_2.setBounds(12, 162, 148, 15);
		panel_2.add(lblCedula_1_2);
		
		textField_10 = new JTextField();
		textField_10.addKeyListener(new KeyAdapter() {
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
		textField_10.setColumns(10);
		textField_10.setBounds(133, 155, 171, 29);
		panel_2.add(textField_10);
		
		JSeparator separator_1_1_1_2 = new JSeparator();
		separator_1_1_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1_2.setBounds(459, 12, 2, 298);
		panel_2.add(separator_1_1_1_2);
		
		JLabel lblEditarUsuario_1 = new JLabel("Editar Docente");
		lblEditarUsuario_1.setBounds(404, 330, 148, 15);
		panel_2.add(lblEditarUsuario_1);
		
		JLabel lblCedulaDelUsuario_2 = new JLabel("Cedula del  Docente");
		lblCedulaDelUsuario_2.setBounds(198, 364, 148, 15);
		panel_2.add(lblCedulaDelUsuario_2);
		
		textField_12 = new JTextField();
		textField_12.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(caracter<'0' || caracter>'9' && caracter!='\b') {
					e.consume();
				}
			}
		});
		textField_12.setColumns(10);
		textField_12.setBounds(381, 357, 171, 29);
		panel_2.add(textField_12);
		
		JLabel lblEditarNombre_1 = new JLabel("Editar nombre");
		lblEditarNombre_1.setBounds(404, 434, 148, 15);
		panel_2.add(lblEditarNombre_1);
		
		textField_13 = new JTextField();
		textField_13.addKeyListener(new KeyAdapter() {
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
		textField_13.setColumns(10);
		textField_13.setBounds(333, 461, 257, 29);
		panel_2.add(textField_13);
		
		JButton btnCargar_1 = new JButton("");
		btnCargar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField_10.getText().length()==0 || textField_9.getText().length()==0 ) {
						JOptionPane.showMessageDialog(null,"El campo nombre o cedula esta vacio!","Hey!",JOptionPane.ERROR_MESSAGE);
					}else {
						crudDocente.setCiD(Integer.parseInt(textField_9.getText()));
						crudDocente.setNombre(textField_10.getText());
						if(crudDocente.consulta()==true) {
							JOptionPane.showMessageDialog(null,"Docente ya registrado en el sistema!","Hey!",JOptionPane.ERROR_MESSAGE);
						}else {
							crudDocente.alta();
							JOptionPane.showMessageDialog(null,"Docente registrado correctamente!","Hey!",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}catch(java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Valores ingresados nulos o incorrectos","Hey!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCargar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCargar_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo111.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnCargar_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo222.png")));
			}
		});
		btnCargar_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo222.png")));
		btnCargar_1.setContentAreaFilled(false);
		btnCargar_1.setBorderPainted(false);
		btnCargar_1.setBounds(178, 216, 91, 94);
		panel_2.add(btnCargar_1);
		
		JSeparator separator_1_1_2_2 = new JSeparator();
		separator_1_1_2_2.setBounds(9, 414, 860, 4);
		panel_2.add(separator_1_1_2_2);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/22332.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/submit1.png")));
			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre=textField_13.getText();
					if(nombre.equals("")) {
						JOptionPane.showMessageDialog(null,"El campo nombre esta vacio!","Hey!",JOptionPane.ERROR_MESSAGE);
					}else {
					crudDocente.setNombre(textField_13.getText());
					crudDocente.modificacionNombreTipo();
					JOptionPane.showMessageDialog(null,"Los datos se modificaron correctamente!","Hey!",JOptionPane.INFORMATION_MESSAGE);
					btnNewButton_1_1.setEnabled(false);
					}
				}catch(java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Valores ingresados nulos o incorrectos","Hey!",JOptionPane.ERROR_MESSAGE);
				}	
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/submit1.png")));
		btnNewButton_1_1.setEnabled(false);
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBounds(611, 463, 124, 27);
		panel_2.add(btnNewButton_1_1);
		
		JLabel lblBajaDeUsuario_1 = new JLabel("Baja de Docente");
		lblBajaDeUsuario_1.setBounds(569, 12, 148, 15);
		panel_2.add(lblBajaDeUsuario_1);
		
		textField_14 = new JTextField();
		textField_14.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(caracter<'0' || caracter>'9' && caracter!='\b') {
					e.consume();
				}
			}
		});
		textField_14.setColumns(10);
		textField_14.setBounds(611, 32, 171, 29);
		panel_2.add(textField_14);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudDocente.setCiD(Integer.parseInt(textField_12.getText()));
				if(crudDocente.consulta()==true) {
					JOptionPane.showMessageDialog(null,"El docente esta registrado! Puede proceder a modificar","Hey!",JOptionPane.INFORMATION_MESSAGE);
					btnNewButton_1_1.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null,"El docente no esta registrado!","Hey!",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_3.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_3.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBounds(585, 358, 41, 28);
		panel_2.add(btnNewButton_3);
		
		JLabel lblCedulaDelUsuario_1_1_3 = new JLabel("Nombre del Docente");
		lblCedulaDelUsuario_1_1_3.setBounds(479, 169, 148, 15);
		panel_2.add(lblCedulaDelUsuario_1_1_3);
		
		JLabel lblCedulaDelUsuario_1_3 = new JLabel("Cedula del Docente");
		lblCedulaDelUsuario_1_3.setBounds(468, 39, 148, 15);
		panel_2.add(lblCedulaDelUsuario_1_3);
		
		JLabel lblCedulaDelUsuario_1_1_1_1 = new JLabel(".....");
		lblCedulaDelUsuario_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCedulaDelUsuario_1_1_1_1.setBounds(479, 230, 148, 15);
		panel_2.add(lblCedulaDelUsuario_1_1_1_1);
		
		JButton btnConfirmarBaja_1 = new JButton("Confirmar baja");
		btnConfirmarBaja_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eleccion=JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea eliminar el siguiente docente? "+crudDocente.getCiD(),"Confirmacion",JOptionPane.YES_NO_OPTION);
				if(eleccion==0) {
					crudDocente.eliminacion();
					JOptionPane.showMessageDialog(null,"Acabas de eliminar al docente:"+crudDocente.getCiD(),"Hey!",JOptionPane.INFORMATION_MESSAGE);
					lblCedulaDelUsuario_1_1_1_1.setText(".....");
					btnConfirmarBaja_1.setEnabled(false);
				}else if(eleccion==1) {
					JOptionPane.showMessageDialog(null,"Presionaste en no eliminar al docente:"+crudDocente.getCiD(),"Hey!",JOptionPane.INFORMATION_MESSAGE);
					textField_3.setText("");
					crudDocente.setCiD(0);
					lblCedulaDelUsuario_1_1_1_1.setText(".....");
					btnConfirmarBaja_1.setEnabled(false);
				}
			}
		});
		btnConfirmarBaja_1.setForeground(Color.WHITE);
		btnConfirmarBaja_1.setEnabled(false);
		btnConfirmarBaja_1.setBackground(new Color(153, 193, 241));
		btnConfirmarBaja_1.setBounds(687, 225, 182, 25);
		panel_2.add(btnConfirmarBaja_1);
		
		JButton btnNewButton_2_2 = new JButton("");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					crudDocente.setCiD(Integer.parseInt(textField_14.getText()));
					if(crudDocente.consulta()==true) {
						JOptionPane.showMessageDialog(null,"El docente esta registrado! Puede proceder a eliminar","Hey!",JOptionPane.INFORMATION_MESSAGE);
						lblCedulaDelUsuario_1_1_1_1.setText(crudDocente.consultaPorNombre());
						btnConfirmarBaja_1.setEnabled(true);
					}else {
						JOptionPane.showMessageDialog(null,"El docente no esta registrado!","Hey!",JOptionPane.INFORMATION_MESSAGE);
					}
				}catch(java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Valores ingresados nulos o incorrectos","Hey!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_2_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_2_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
			}
		});
		btnNewButton_2_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
		btnNewButton_2_2.setContentAreaFilled(false);
		btnNewButton_2_2.setBorderPainted(false);
		btnNewButton_2_2.setBounds(744, 74, 41, 28);
		panel_2.add(btnNewButton_2_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/fondoMenu23.png")));
		lblNewLabel_1.setBackground(new Color(45, 173, 222));
		lblNewLabel_1.setBounds(0, 0, 893, 600);
		panel_2.add(lblNewLabel_1);
		this.setLocationRelativeTo(null);
		
	}
}