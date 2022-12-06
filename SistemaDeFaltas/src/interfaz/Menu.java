package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.border.LineBorder;

import configuration.CombosConexion;
import configuration.Conexion;
import configuration.CrudDBAlumno;
import configuration.CrudDBDocente;
import configuration.CrudDBGrupo;
import configuration.CrudDBUsuario;
import log.Log;
import model.Registros;

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
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;

public class Menu extends JFrame {

	private JPanel contentPane;
	private Conexion carga = new Conexion();
	private CrudDBUsuario crud = new CrudDBUsuario();
	private CrudDBDocente crudDocente = new CrudDBDocente();
	private CombosConexion combosConexion = new CombosConexion();
	private Consultas consulta = new Consultas();
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
	private JTextField textField_11;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private CrudDBGrupo grupo = new CrudDBGrupo();
	private JTextField textField_19;
	private JComboBox<String> comboBox_2 = new JComboBox<String>();
	private JComboBox<String> comboBox = new JComboBox<String>();
	private JComboBox<String> comboBox_1 = new JComboBox<String>();
	private JComboBox<String> comboBox_1_1 = new JComboBox<String>();
	private CrudDBAlumno cargaAlumno = new CrudDBAlumno();
	private JTextField textField_20;
	private JTextField textField_21;
	private JPanel panel_3 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel panel = new JPanel();
	private JPanel panel_4 = new JPanel();
	private String typeUser;
	private JTextField textField_22;
	private JTextField textField_23;
	private static JTable table;
	private static JScrollPane miBarra1 = new JScrollPane();
	private JComboBox<String> comboBox_3=new JComboBox<String>();
	private int ciUser;

	/**
	 * Launch the application.
	 */

	public void setTypeUser(String type) {
		this.typeUser = type;
	}

	public String getTypeUser() {
		return this.typeUser;
	}
	
	public void setCiUser(int ciUser) {
		this.ciUser=ciUser;
	}
	
	public int getCiUser() {
		return this.ciUser;
	}

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
	 * 
	 * @throws InterruptedException
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
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		tabbedPane.setFont(new Font("DialogInput", Font.PLAIN, 11));
		tabbedPane.setBounds(0, 0, 900, 600);
		contentPane.add(tabbedPane);

		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Inicio", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Bienvenido!");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(324, 12, 222, 43);
		panel.add(lblNewLabel_3);

		JSeparator separator = new JSeparator();
		separator.setBounds(365, 44, 140, 2);
		panel.add(separator);

		JButton btnNewButton_4_1 = new JButton("Consultas");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta.setVisible(true);
			}
		});
		btnNewButton_4_1.setBounds(324, 235, 227, 43);
		panel.add(btnNewButton_4_1);

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
		panel.add(btnNewButton_4_1_1);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (getTypeUser().equals("Director") || getTypeUser().equals("Administrativo")) {
						JOptionPane.showMessageDialog(null,
								"Su tipo de usuario es: " + getTypeUser() + ". Tiene todas las funciones disponibles.",
								"Hey!", JOptionPane.INFORMATION_MESSAGE);
						tabbedPane.setEnabledAt(2, true);
						tabbedPane.setEnabledAt(3, true);
						tabbedPane.setEnabledAt(4, true);
						tabbedPane.setEnabledAt(5, true);
						btnNewButton_4.setEnabled(false);
					} else {
						JOptionPane.showMessageDialog(null,
								"Su tipo de usuario es: " + getTypeUser()
										+ ". Solo puede registrar y consultar faltas.",
								"Hey!", JOptionPane.INFORMATION_MESSAGE);
						btnNewButton_4.setEnabled(false);
					}
				} catch (java.lang.NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Ningun usuario ingresado, tiene que ingresar por el login.",
							"Hey!", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, "Cerrando ventana.", "Hey!", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
		});
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_4.setIcon(new ImageIcon(Menu.class.getResource("/imgs/privilegios2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_4.setIcon(new ImageIcon(Menu.class.getResource("/imgs/privilegios1.png")));
			}
		});
		
		JLabel lblPrivilegios = new JLabel("Privilegios");
		lblPrivilegios.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrivilegios.setBounds(22, 541, 81, 15);
		panel.add(lblPrivilegios);
		btnNewButton_4.setIcon(new ImageIcon(Menu.class.getResource("/imgs/privilegios1.png")));
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBounds(22, 476, 76, 65);
		panel.add(btnNewButton_4);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/fondoMenu23.png")));
		lblNewLabel_2.setBackground(new Color(45, 173, 222));
		lblNewLabel_2.setBounds(0, 0, 893, 600);
		panel.add(lblNewLabel_2);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Faltas", null, panel_5, null);
		panel_5.setLayout(null);

		JLabel lblRegistroDeFalta = new JLabel("Registro de falta");
		lblRegistroDeFalta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeFalta.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRegistroDeFalta.setBounds(345, 12, 188, 30);
		panel_5.add(lblRegistroDeFalta);

		textField_22 = new JTextField();
		textField_22.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (caracter < '0' || caracter > '9' && caracter != '\b') {
					e.consume();
				}
			}
		});
		textField_22.setColumns(10);
		textField_22.setBounds(147, 115, 199, 30);
		panel_5.add(textField_22);

		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(147, 168, 199, 30);
		panel_5.add(textField_23);

		comboBox_3.setBounds(147, 235, 199, 30);
		panel_5.add(comboBox_3);

		JLabel lblFechasDeAusencias = new JLabel("Fechas de ausencias");
		lblFechasDeAusencias.setBounds(164, 277, 152, 15);
		panel_5.add(lblFechasDeAusencias);

		JLabel lblFechasDeInicio = new JLabel("Fecha de inicio");
		lblFechasDeInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechasDeInicio.setFont(new Font("Dialog", Font.BOLD, 10));
		lblFechasDeInicio.setBounds(81, 304, 110, 15);
		panel_5.add(lblFechasDeInicio);

		JLabel lblFechasDeFin = new JLabel("Fecha de fin");
		lblFechasDeFin.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechasDeFin.setFont(new Font("Dialog", Font.BOLD, 10));
		lblFechasDeFin.setBounds(274, 304, 110, 15);
		panel_5.add(lblFechasDeFin);

		miBarra1.setBounds(418, 134, 465, 259);
		panel_5.add(miBarra1);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(81, 331, 110, 19);
		panel_5.add(dateChooser);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-dd");
		dateChooser_1.setBounds(274, 331, 110, 19);
		panel_5.add(dateChooser_1);

		JButton btnNewButton_1_1_2 = new JButton("");
		btnNewButton_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_1_1_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/22332.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_1_1_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/submit1.png")));
			}
		});
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crudDocente.setCiD(Integer.parseInt(textField_22.getText()));
					crudDocente.setCiU(getCiUser());
					String fechaInicial = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
					crudDocente.setFechaInicial(fechaInicial);
					String fechaFinal = ((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText();
					crudDocente.setFechaFinal(fechaFinal);
					crudDocente.setGrupo(comboBox_3.getSelectedItem().toString());
					crudDocente.setMotivo(textField_23.getText());
					if (crudDocente.consulta() == true && carga.consultaCiURegistro(crudDocente.getCiU()) == true) {
						if (crudDocente.getFechaFinal().after(crudDocente.getFechaInicial())
								|| crudDocente.getFechaFinal().equals(crudDocente.getFechaInicial())) {
							try {
								Log myLog = new Log("./logFolder/log.txt");
								crudDocente.altaAusencia();
								construirTabla();
								myLog.addLine("El usuario: " + crudDocente.getCiU() + " registra la falta del docente: "
										+ crudDocente.getCiD() + " con dia de inicio: " + crudDocente.getFechaInicial()
										+ " y fecha final: " + crudDocente.getFechaFinal() + " ,afectando al grupo: "
										+ crudDocente.getGrupo() + ". Falta por: " + crudDocente.getMotivo());
								JOptionPane.showMessageDialog(null, "La ausencia se registro correctamente!", "Hey!",
										JOptionPane.INFORMATION_MESSAGE);

							} catch (IOException ex) {
								System.out.println(ex.getMessage());
							}
						} else {
							JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser mayor a la final!",
									"Hey!", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "El usuario o docente no esta registrado!", "Hey!",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "No puedes dejar las fechas vacias!", "Hey!",
							JOptionPane.ERROR_MESSAGE);
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "No puedes dejar campos vacios!", "Hey!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1_1_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/submit1.png")));
		btnNewButton_1_1_2.setContentAreaFilled(false);
		btnNewButton_1_1_2.setBorderPainted(false);
		btnNewButton_1_1_2.setBounds(164, 384, 124, 27);
		panel_5.add(btnNewButton_1_1_2);

		JLabel lblCedulaDelDocente = new JLabel("Cedula del docente");
		lblCedulaDelDocente.setBounds(0, 130, 137, 15);
		panel_5.add(lblCedulaDelDocente);

		JLabel lblMotivo = new JLabel("Motivo");
		lblMotivo.setBounds(81, 183, 54, 15);
		panel_5.add(lblMotivo);

		JLabel lblCedulaDelDocente_1 = new JLabel("Grupo");
		lblCedulaDelDocente_1.setBounds(81, 250, 54, 15);
		panel_5.add(lblCedulaDelDocente_1);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Menu.class.getResource("/imgs/fondoMenu23.png")));
		lblNewLabel_4.setBounds(0, 0, 904, 600);
		panel_5.add(lblNewLabel_4);

		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Administrar Usuarios", new ImageIcon(Menu.class.getResource("/imgs/prueba2.png")), panel_1,
				null);
		tabbedPane.setEnabledAt(2, false);
		tabbedPane.setBackgroundAt(2, Color.WHITE);
		panel_1.setLayout(null);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(12, 322, 857, 2);
		panel_1.add(separator_1_1);

		JLabel lblAltaDeUsuario = new JLabel("Alta de usuario");
		lblAltaDeUsuario.setBounds(158, 12, 148, 15);
		panel_1.add(lblAltaDeUsuario);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(12, 46, 148, 15);
		panel_1.add(lblCedula);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (caracter < '0' || caracter > '9' && caracter != '\b') {
					e.consume();
				}
			}
		});
		textField.setBounds(133, 39, 171, 29);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblCedula_1 = new JLabel("Nombre");
		lblCedula_1.setBounds(12, 87, 148, 15);
		panel_1.add(lblCedula_1);

		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				boolean mayusculas = caracter >= 65 && caracter <= 90;
				boolean minusculas = caracter >= 97 && caracter <= 122;
				boolean espacio = caracter == 32;
				if (!(minusculas || mayusculas || espacio)) {
					e.consume();
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(133, 80, 171, 29);
		panel_1.add(textField_1);

		JLabel lblCedula_1_1 = new JLabel("Contraseña");
		lblCedula_1_1.setBounds(12, 136, 148, 15);
		panel_1.add(lblCedula_1_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 129, 171, 29);
		panel_1.add(textField_2);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(12, 197, 148, 15);
		panel_1.add(lblUsuario);
		comboBox.setBounds(133, 190, 171, 29);
		panel_1.add(comboBox);

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
					if (textField_1.getText().length() == 0 || textField_2.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Nombre o password no fueron ingresados!", "Hey!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (crud.consulta() == true) {
							JOptionPane.showMessageDialog(null, "Usuario ya registrado en el sistema!", "Hey!",
									JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								Log myLog = new Log("./logFolder/log.txt");
								myLog.addLine(
										"El usuario: " + getCiUser() + " dio de alta al usuario: " + crud.getCi());
								crud.alta();
								JOptionPane.showMessageDialog(null, "Usuario registrado correctamente!", "Hey!",
										JOptionPane.INFORMATION_MESSAGE);
								textField_1.setText("");
								textField_2.setText("");
								textField.setText("");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_1.add(btnCargar);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1.setBounds(459, 12, 2, 298);
		panel_1.add(separator_1_1_1);

		JLabel lblEditarUsuario = new JLabel("Editar usuario");
		lblEditarUsuario.setBounds(158, 322, 148, 15);
		panel_1.add(lblEditarUsuario);

		JLabel lblCedulaDelUsuario = new JLabel("Cedula del usuario");
		lblCedulaDelUsuario.setBounds(12, 364, 148, 15);
		panel_1.add(lblCedulaDelUsuario);

		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (caracter < '0' || caracter > '9' && caracter != '\b') {
					e.consume();
				}
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(178, 357, 171, 29);
		panel_1.add(textField_5);

		JLabel lblEditarNombre = new JLabel("Editar nombre");
		lblEditarNombre.setBounds(12, 430, 148, 15);
		panel_1.add(lblEditarNombre);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(12, 463, 114, 29);
		panel_1.add(textField_6);

		comboBox_2.setBounds(148, 463, 171, 29);
		panel_1.add(comboBox_2);

		JLabel lblCambiarTipoUsuario = new JLabel("Cambiar Tipo Usuario");
		lblCambiarTipoUsuario.setBounds(158, 431, 173, 15);
		panel_1.add(lblCambiarTipoUsuario);

		JSeparator separator_1_1_2 = new JSeparator();
		separator_1_1_2.setBounds(9, 414, 431, 4);
		panel_1.add(separator_1_1_2);

		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1_1.setBounds(458, 329, 3, 193);
		panel_1.add(separator_1_1_1_1);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = textField_6.getText();
					if (nombre.equals("")) {
						JOptionPane.showMessageDialog(null, "El campo nombre esta vacio!", "Hey!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Log myLog;
						try {
							myLog = new Log("./logFolder/log.txt");
							myLog.addLine("El usuario: " + getCiUser() + "modifico al usuario: " + crud.getCi());
							crud.setNombre(textField_6.getText());
							crud.setRol(comboBox_2.getSelectedItem().toString());
							crud.modificacionNombreTipo();
							JOptionPane.showMessageDialog(null, "Los datos se modificaron correctamente!", "Hey!",
									JOptionPane.INFORMATION_MESSAGE);
							btnNewButton_1.setEnabled(false);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
							JOptionPane.ERROR_MESSAGE);
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
		panel_1.add(btnNewButton_1);

		JLabel lblBajaDeUsuario = new JLabel("Baja de Usuario");
		lblBajaDeUsuario.setBounds(569, 12, 148, 15);
		panel_1.add(lblBajaDeUsuario);

		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (caracter < '0' || caracter > '9' && caracter != '\b') {
					e.consume();
				}
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(611, 32, 171, 29);
		panel_1.add(textField_3);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					carga.setCi(Integer.parseInt(textField_5.getText()));
					boolean existe = carga.consultaCiU();
					if (existe == true) {
						JOptionPane.showMessageDialog(null, "El usuario esta registrado! Puede proceder a modificar",
								"Hey!", JOptionPane.INFORMATION_MESSAGE);
						crud.setCi(Integer.parseInt(textField_5.getText()));
						btnNewButton_1.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "El usuario no esta registrado!", "Hey!",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
							JOptionPane.ERROR_MESSAGE);
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
		panel_1.add(btnNewButton);

		JLabel lblCedulaDelUsuario_1_1 = new JLabel("Nombre del Usuario");
		lblCedulaDelUsuario_1_1.setBounds(479, 169, 148, 15);
		panel_1.add(lblCedulaDelUsuario_1_1);

		JLabel lblCedulaDelUsuario_1 = new JLabel("Cedula del Usuario");
		lblCedulaDelUsuario_1.setBounds(468, 39, 148, 15);
		panel_1.add(lblCedulaDelUsuario_1);

		lblCedulaDelUsuario_1_1_1 = new JLabel(".....");
		lblCedulaDelUsuario_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCedulaDelUsuario_1_1_1.setBounds(479, 230, 148, 15);
		panel_1.add(lblCedulaDelUsuario_1_1_1);
				
				JButton btnNewButton_4_1_1_1 = new JButton("");
				btnNewButton_4_1_1_1.setEnabled(false);
				btnNewButton_4_1_1_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						btnNewButton_4_1_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/eliminar2.png")));
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						btnNewButton_4_1_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/eliminar1.png")));
					}
				});
				btnNewButton_4_1_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int eleccion = JOptionPane.showConfirmDialog(null,
								"¿Esta seguro que desea eliminar el siguiente usuario? " + crud.getCi(), "Confirmacion",
								JOptionPane.YES_NO_OPTION);
						if (eleccion == 0) {
							Log myLog;
							try {
								myLog = new Log("./logFolder/log.txt");
								myLog.addLine("El usuario: " + getCiUser() + " dio de baja al usuario: " + crud.getCi());
								crud.eliminacion();
								JOptionPane.showMessageDialog(null, "Acabas de eliminar al usuario:" + crud.getCi(), "Hey!",
										JOptionPane.INFORMATION_MESSAGE);
								lblCedulaDelUsuario_1_1_1.setText(".....");
								btnNewButton_4_1_1_1.setEnabled(false);
								textField_3.setText("");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else if (eleccion == 1) {
							JOptionPane.showMessageDialog(null, "Presionaste en no eliminar al usuario:" + carga.getCi(),
									"Hey!", JOptionPane.INFORMATION_MESSAGE);
							textField_3.setText("");
							crud.setCi(0);
							lblCedulaDelUsuario_1_1_1.setText(".....");
							btnNewButton_4_1_1_1.setEnabled(false);
						}
					}
				});
				btnNewButton_4_1_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/eliminar1.png")));
				btnNewButton_4_1_1_1.setContentAreaFilled(false);
				btnNewButton_4_1_1_1.setBorderPainted(false);
				btnNewButton_4_1_1_1.setBounds(769, 197, 63, 59);
				panel_1.add(btnNewButton_4_1_1_1);
		
				JButton btnNewButton_2 = new JButton("");
				btnNewButton_2.setBorderPainted(false);
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							carga.setCi(Integer.parseInt(textField_3.getText()));
							boolean existe = carga.consultaCiU();
							if (existe == true) {
								JOptionPane.showMessageDialog(null, "El usuario esta registrado! Puede proceder a eliminar",
										"Hey!", JOptionPane.INFORMATION_MESSAGE);
								crud.setCi(Integer.parseInt(textField_3.getText()));
								lblCedulaDelUsuario_1_1_1.setText(crud.getNombreFromDB());
								btnNewButton_4_1_1_1.setEnabled(true);
							} else {
								JOptionPane.showMessageDialog(null, "El usuario no esta registrado!", "Hey!",
										JOptionPane.INFORMATION_MESSAGE);
								textField_3.setText("");
							}
						} catch (java.lang.NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
									JOptionPane.ERROR_MESSAGE);
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
				panel_1.add(btnNewButton_2);

		JLabel lblCedulaDelUsuario_1_1_2 = new JLabel("Cambio de contraseña");
		lblCedulaDelUsuario_1_1_2.setBounds(600, 322, 182, 15);
		panel_1.add(lblCedulaDelUsuario_1_1_2);

		JLabel lblCedulaDelUsuario_1_2 = new JLabel("Cedula del Usuario");
		lblCedulaDelUsuario_1_2.setBounds(479, 364, 148, 15);
		panel_1.add(lblCedulaDelUsuario_1_2);

		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (caracter < '0' || caracter > '9' && caracter != '\b') {
					e.consume();
				}
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(629, 357, 171, 29);
		panel_1.add(textField_4);

		JSeparator separator_1_1_2_1 = new JSeparator();
		separator_1_1_2_1.setBounds(473, 414, 396, 2);
		panel_1.add(separator_1_1_2_1);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(477, 460, 177, 29);
		panel_1.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(705, 460, 171, 29);
		panel_1.add(textField_8);

		JLabel lblCedulaDelUsuario_1_2_1 = new JLabel("Nueva contraseña");
		lblCedulaDelUsuario_1_2_1.setBounds(494, 424, 148, 15);
		panel_1.add(lblCedulaDelUsuario_1_2_1);

		JLabel lblCedulaDelUsuario_1_2_1_1 = new JLabel("Repita contraseña");
		lblCedulaDelUsuario_1_2_1_1.setBounds(721, 424, 148, 15);
		panel_1.add(lblCedulaDelUsuario_1_2_1_1);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField_7.getText().toString().equals("") || textField_8.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Los campos estan vacios!", "Hey!", JOptionPane.ERROR_MESSAGE);
				} else if (textField_7.getText().toString().equals(textField_8.getText().toString())) {
					int eleccion = JOptionPane.showConfirmDialog(null,
							"¿Esta seguro que desea modificar el passsword del siguiente docente? " + crud.getCi(),
							"Confirmacion", JOptionPane.YES_NO_OPTION);
					if (eleccion == 0) {
						Log myLog;
						try {
							myLog = new Log("./logFolder/log.txt");
							myLog.addLine("El usuario: " + getCiUser() + "modifico al usuario: " + crud.getCi());
							crud.setPassword(textField_7.getText().toString());
							crud.modificacionPassword();
							JOptionPane.showMessageDialog(null,
									"Acabas de modificar la contraseña del docente:" + carga.getCi(), "Hey!",
									JOptionPane.INFORMATION_MESSAGE);
							btnConfirmar.setEnabled(false);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else if (eleccion == 1) {
						JOptionPane.showMessageDialog(null,
								"Presionaste en no modificar la contraseña del docente:" + carga.getCi(), "Hey!",
								JOptionPane.INFORMATION_MESSAGE);
						btnConfirmar.setEnabled(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden!", "Hey!",
							JOptionPane.ERROR_MESSAGE);
					btnConfirmar.setEnabled(false);
				}
			}
		});
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setBackground(new Color(153, 193, 241));
		btnConfirmar.setBounds(581, 497, 177, 25);
		panel_1.add(btnConfirmar);

		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					carga.setCi(Integer.parseInt(textField_4.getText()));
					boolean confirmacion = carga.consultaCiU();
					if (confirmacion == true) {
						JOptionPane.showMessageDialog(null,
								"El usuario esta registrado! Puede proceder a modificar la contraseña", "Hey!",
								JOptionPane.INFORMATION_MESSAGE);
						crud.setCi(Integer.parseInt(textField_4.getText()));
						btnConfirmar.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "El usuario no esta registrado!", "Hey!",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
							JOptionPane.ERROR_MESSAGE);
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
		panel_1.add(btnNewButton_2_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 893, 600);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/imgs/fondoMenu23.png")));
		lblNewLabel.setBackground(new Color(45, 173, 222));

		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Administrar Docentes", new ImageIcon(Menu.class.getResource("/imgs/prueba2.png")), panel_2,
				null);
		tabbedPane.setEnabledAt(3, false);

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
				char caracter = e.getKeyChar();
				if (caracter < '0' || caracter > '9' && caracter != '\b') {
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
				char caracter = e.getKeyChar();
				boolean mayusculas = caracter >= 65 && caracter <= 90;
				boolean minusculas = caracter >= 97 && caracter <= 122;
				boolean espacio = caracter == 32;
				if (!(minusculas || mayusculas || espacio)) {
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
				char caracter = e.getKeyChar();
				if (caracter < '0' || caracter > '9' && caracter != '\b') {
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
				char caracter = e.getKeyChar();
				boolean mayusculas = caracter >= 65 && caracter <= 90;
				boolean minusculas = caracter >= 97 && caracter <= 122;
				boolean espacio = caracter == 32;
				if (!(minusculas || mayusculas || espacio)) {
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
					if (textField_10.getText().length() == 0 || textField_9.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "El campo nombre o cedula esta vacio!", "Hey!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						crudDocente.setCiD(Integer.parseInt(textField_9.getText()));
						crudDocente.setNombre(textField_10.getText());
						if (crudDocente.consulta() == true) {
							JOptionPane.showMessageDialog(null, "Docente ya registrado en el sistema!", "Hey!",
									JOptionPane.ERROR_MESSAGE);
						} else {
							Log myLog;
							try {
								myLog = new Log("./logFolder/log.txt");
								myLog.addLine("El usuario: " + getCiUser() + " dio de alta al docente: "
										+ crudDocente.getCiD());
								crudDocente.alta();
								JOptionPane.showMessageDialog(null, "Docente registrado correctamente!", "Hey!",
										JOptionPane.INFORMATION_MESSAGE);
								textField_9.setText("");
								textField_10.setText("");
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
							JOptionPane.ERROR_MESSAGE);
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
					String nombre = textField_13.getText();
					if (nombre.equals("")) {
						JOptionPane.showMessageDialog(null, "El campo nombre esta vacio!", "Hey!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Log myLog;
						try {
							myLog = new Log("./logFolder/log.txt");
							myLog.addLine(
									"El usuario: " + getCiUser() + " modifico al docente: " + crudDocente.getCiD());
							crudDocente.setNombre(textField_13.getText());
							crudDocente.modificacionNombreTipo();
							JOptionPane.showMessageDialog(null, "Los datos se modificaron correctamente!", "Hey!",
									JOptionPane.INFORMATION_MESSAGE);
							textField_12.setText("");
							btnNewButton_1_1.setEnabled(false);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
							JOptionPane.ERROR_MESSAGE);
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
				char caracter = e.getKeyChar();
				if (caracter < '0' || caracter > '9' && caracter != '\b') {
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
				try {
					crudDocente.setCiD(Integer.parseInt(textField_12.getText()));
					if (crudDocente.consulta() == true) {
						JOptionPane.showMessageDialog(null, "El docente esta registrado! Puede proceder a modificar",
								"Hey!", JOptionPane.INFORMATION_MESSAGE);
						btnNewButton_1_1.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "El docente no esta registrado!", "Hey!",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
							JOptionPane.ERROR_MESSAGE);
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

		JButton btnConfirmarBaja_1 = new JButton("");
		btnConfirmarBaja_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnConfirmarBaja_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/eliminar2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnConfirmarBaja_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/eliminar1.png")));
			}
		});
		btnConfirmarBaja_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/eliminar1.png")));
		btnConfirmarBaja_1.setBorderPainted(false);
		btnConfirmarBaja_1.setContentAreaFilled(false);
		btnConfirmarBaja_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eleccion = JOptionPane.showConfirmDialog(null,
						"¿Esta seguro que desea eliminar el siguiente docente? " + crudDocente.getCiD(), "Confirmacion",
						JOptionPane.YES_NO_OPTION);
				if (eleccion == 0) {
							Log myLog;
							try {
								myLog = new Log("./logFolder/log.txt");
								myLog.addLine("El usuario: " + getCiUser() + " dio de baja al docente: "
										+ crudDocente.getCiD());
								crudDocente.eliminacion();
								JOptionPane.showMessageDialog(null,
										"Acabas de eliminar al docente:" + crudDocente.getCiD(), "Hey!",
										JOptionPane.INFORMATION_MESSAGE);
								lblCedulaDelUsuario_1_1_1_1.setText(".....");
								btnConfirmarBaja_1.setEnabled(false);
								textField_14.setText("");
							} catch (IOException e1) {
								e1.printStackTrace();
							}	
				} else if (eleccion == 1) {
					JOptionPane.showMessageDialog(null, "Presionaste en no eliminar al docente:" + crudDocente.getCiD(),
							"Hey!", JOptionPane.INFORMATION_MESSAGE);
					textField_3.setText("");
					crudDocente.setCiD(0);
					textField_14.setText("");
					lblCedulaDelUsuario_1_1_1_1.setText(".....");
					btnConfirmarBaja_1.setEnabled(false);
				}
			}
		});
		btnConfirmarBaja_1.setForeground(Color.WHITE);
		btnConfirmarBaja_1.setEnabled(false);
		btnConfirmarBaja_1.setBackground(new Color(153, 193, 241));
		btnConfirmarBaja_1.setBounds(769, 197, 63, 59);
		panel_2.add(btnConfirmarBaja_1);

		JButton btnNewButton_2_2 = new JButton("");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					crudDocente.setCiD(Integer.parseInt(textField_14.getText()));
					if (crudDocente.consulta() == true) {
						JOptionPane.showMessageDialog(null, "El docente esta registrado! Puede proceder a eliminar",
								"Hey!", JOptionPane.INFORMATION_MESSAGE);
						lblCedulaDelUsuario_1_1_1_1.setText(crudDocente.consultaPorNombre());
						btnConfirmarBaja_1.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "El docente no esta registrado!", "Hey!",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
							JOptionPane.ERROR_MESSAGE);
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

		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Administracion Grupos", null, panel_3, null);
		tabbedPane.setEnabledAt(4, false);
		panel_3.setLayout(null);

		JLabel lblAltaDeGrupo = new JLabel("Alta de grupo");
		lblAltaDeGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeGrupo.setBounds(158, 12, 148, 15);
		panel_3.add(lblAltaDeGrupo);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(133, 80, 171, 29);
		panel_3.add(textField_11);

		textField_15 = new JTextField();
		textField_15.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (caracter < '0' || caracter > '9' && caracter != '\b') {
					e.consume();
				}
			}
		});
		textField_15.setColumns(10);
		textField_15.setBounds(133, 155, 171, 29);
		panel_3.add(textField_15);

		JLabel lblCedula_2_1 = new JLabel("Nombre");
		lblCedula_2_1.setBounds(12, 87, 148, 15);
		panel_3.add(lblCedula_2_1);

		JLabel lblCedula_2_1_1 = new JLabel("Año");
		lblCedula_2_1_1.setBounds(12, 162, 148, 15);
		panel_3.add(lblCedula_2_1_1);

		JSeparator separator_1_1_2_2_1 = new JSeparator();
		separator_1_1_2_2_1.setBounds(12, 316, 860, 4);
		panel_3.add(separator_1_1_2_2_1);

		JSeparator separator_1_1_1_2_1 = new JSeparator();
		separator_1_1_1_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1_2_1.setBounds(459, 12, 2, 298);
		panel_3.add(separator_1_1_1_2_1);

		JButton btnCargar_1_1 = new JButton("");
		btnCargar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					grupo.setNombre(textField_11.getText());
					grupo.setAnio(Integer.parseInt(textField_15.getText()));
					if (grupo.getNombre().equals("")) {
						JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio!", "Hey!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (grupo.consulta() == true) {
							JOptionPane.showMessageDialog(null, "Grupo ya registrado en el sistema!", "Hey!",
									JOptionPane.ERROR_MESSAGE);
						} else {
							Log myLog;
							try {
								myLog = new Log("./logFolder/log.txt");
								myLog.addLine(
										"El usuario: " + getCiUser() + "dio de alta al grupo: " + grupo.getNombre());
								JOptionPane.showMessageDialog(null, "Grupo registrado correctamente!", "Hey!",
										JOptionPane.INFORMATION_MESSAGE);
								grupo.alta();
								textField_11.setText("");
								textField_15.setText("");
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCargar_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCargar_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo111.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnCargar_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo222.png")));
			}
		});
		btnCargar_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo222.png")));
		btnCargar_1_1.setContentAreaFilled(false);
		btnCargar_1_1.setBorderPainted(false);
		btnCargar_1_1.setBounds(178, 216, 91, 94);
		panel_3.add(btnCargar_1_1);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(611, 32, 171, 29);
		panel_3.add(textField_16);

		JLabel lblBajaDeUsuario_1_1 = new JLabel("Baja de Grupo");
		lblBajaDeUsuario_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBajaDeUsuario_1_1.setBounds(569, 12, 148, 15);
		panel_3.add(lblBajaDeUsuario_1_1);

		JLabel lblCedulaDelUsuario_1_1_1_1_1 = new JLabel(".....");
		lblCedulaDelUsuario_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCedulaDelUsuario_1_1_1_1_1.setBounds(479, 230, 148, 15);
		panel_3.add(lblCedulaDelUsuario_1_1_1_1_1);

		JLabel lblNombreDelGrupo = new JLabel("Nombre del grupo");
		lblNombreDelGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelGrupo.setBounds(468, 39, 148, 15);
		panel_3.add(lblNombreDelGrupo);

		JButton btnConfirmarBaja_1_1 = new JButton("");
		btnConfirmarBaja_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnConfirmarBaja_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/eliminar2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnConfirmarBaja_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/eliminar1.png")));
			}
		});
		
		btnConfirmarBaja_1_1.setContentAreaFilled(false);
		btnConfirmarBaja_1_1.setBorderPainted(false);
		btnConfirmarBaja_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/eliminar1.png")));
		btnConfirmarBaja_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eleccion = JOptionPane.showConfirmDialog(null,
						"¿Esta seguro que desea eliminar el siguiente grupo? " + grupo.getNombre(), "Confirmacion",
						JOptionPane.YES_NO_OPTION);
				if (eleccion == 0) {
					Log myLog;
					try {
						myLog = new Log("./logFolder/log.txt");
						myLog.addLine("El usuario: " + getCiUser() + "dio de baja al grupo: " + grupo.getNombre());
						grupo.eliminacion();
						JOptionPane.showMessageDialog(null, "Acabas de eliminar al grupo:" + grupo.getNombre(), "Hey!",
								JOptionPane.INFORMATION_MESSAGE);
						lblCedulaDelUsuario_1_1_1_1_1.setText(".....");
						btnConfirmarBaja_1_1.setEnabled(false);
						textField_16.setText("");
						grupo.setNombre("");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else if (eleccion == 1) {
					JOptionPane.showMessageDialog(null, "Presionaste en no eliminar al grupo:" + grupo.getNombre(),
							"Hey!", JOptionPane.INFORMATION_MESSAGE);
					textField_16.setText("");
					grupo.setNombre("");
					lblCedulaDelUsuario_1_1_1_1_1.setText(".....");
					btnConfirmarBaja_1_1.setEnabled(false);
				}
			}
		});
		btnConfirmarBaja_1_1.setForeground(Color.WHITE);
		btnConfirmarBaja_1_1.setEnabled(false);
		btnConfirmarBaja_1_1.setBackground(new Color(153, 193, 241));
		btnConfirmarBaja_1_1.setBounds(769, 197, 63, 59);
		panel_3.add(btnConfirmarBaja_1_1);

		JButton btnNewButton_2_2_1 = new JButton("");
		btnNewButton_2_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_2_2_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_2_2_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
			}
		});
		btnNewButton_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grupo.setNombre(textField_16.getText());
				if (grupo.consulta() == true) {
					JOptionPane.showMessageDialog(null, "El grupo esta registrado! Puede proceder a eliminar", "Hey!",
							JOptionPane.INFORMATION_MESSAGE);
					lblCedulaDelUsuario_1_1_1_1_1.setText(grupo.getNombre());
					btnConfirmarBaja_1_1.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "El grupo no esta registrado!", "Hey!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_2_2_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
		btnNewButton_2_2_1.setContentAreaFilled(false);
		btnNewButton_2_2_1.setBorderPainted(false);
		btnNewButton_2_2_1.setBounds(744, 74, 41, 28);
		panel_3.add(btnNewButton_2_2_1);

		textField_18 = new JTextField();
		textField_18.setEnabled(false);
		textField_18.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (caracter < '0' || caracter > '9' && caracter != '\b') {
					e.consume();
				}
			}
		});
		textField_18.setColumns(10);
		textField_18.setBounds(336, 465, 257, 29);
		panel_3.add(textField_18);

		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Log myLog;
					try {
						myLog = new Log("./logFolder/log.txt");
						myLog.addLine("El usuario: " + getCiUser() + "modifico el grupo: " + grupo.getNombre());
						grupo.setAnio(Integer.parseInt(textField_18.getText()));
						grupo.modificacionNombreTipo();
						textField_17.setText("");
						btnNewButton_1_1_1.setEnabled(false);
						textField_18.setEnabled(false);
						textField_18.setText("");
						JOptionPane.showMessageDialog(null, "Año modificado correctamente!", "Hey!",JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/submit1.png")));
		btnNewButton_1_1_1.setEnabled(false);
		btnNewButton_1_1_1.setContentAreaFilled(false);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBounds(616, 467, 124, 27);
		panel_3.add(btnNewButton_1_1_1);

		JLabel lblEditarUsuario_1_1 = new JLabel("Editar año de grupo");
		lblEditarUsuario_1_1.setBounds(380, 331, 148, 15);
		panel_3.add(lblEditarUsuario_1_1);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(369, 362, 171, 29);
		panel_3.add(textField_17);

		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grupo.setNombre(textField_17.getText());
				if (grupo.consulta() == true) {
					JOptionPane.showMessageDialog(null, "El Grupo esta registrado! Puede proceder a modificar", "Hey!",
							JOptionPane.INFORMATION_MESSAGE);
					textField_18.setEnabled(true);
					btnNewButton_1_1_1.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "El Grupo no esta registrado!", "Hey!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_3_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_3_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
			}
		});
		btnNewButton_3_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
		btnNewButton_3_1.setContentAreaFilled(false);
		btnNewButton_3_1.setBorderPainted(false);
		btnNewButton_3_1.setBounds(555, 364, 41, 28);
		panel_3.add(btnNewButton_3_1);

		JLabel lblCedulaDelUsuario_2_1 = new JLabel("Nombre del grupo");
		lblCedulaDelUsuario_2_1.setBounds(203, 369, 148, 15);
		panel_3.add(lblCedulaDelUsuario_2_1);

		JSeparator separator_1_1_2_2_1_1 = new JSeparator();
		separator_1_1_2_2_1_1.setBounds(12, 428, 860, 4);
		panel_3.add(separator_1_1_2_2_1_1);

		JLabel lblCedulaDelUsuario_2_1_1 = new JLabel("Año del grupo");
		lblCedulaDelUsuario_2_1_1.setBounds(213, 472, 105, 15);
		panel_3.add(lblCedulaDelUsuario_2_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(0, 0, 900, 600);
		lblNewLabel_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/fondoMenu23.png")));
		lblNewLabel_1_1.setBackground(new Color(45, 173, 222));
		panel_3.add(lblNewLabel_1_1);

		panel_4.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Administracion alumnos", null, panel_4, null);
		tabbedPane.setEnabledAt(5, false);
		panel_4.setLayout(null);

		JLabel lblAltaDeAlumno = new JLabel("Alta de Alumno");
		lblAltaDeAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeAlumno.setBounds(158, 12, 148, 15);
		panel_4.add(lblAltaDeAlumno);

		textField_19 = new JTextField();
		textField_19.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (caracter < '0' || caracter > '9' && caracter != '\b') {
					e.consume();
				}
			}
		});
		textField_19.setColumns(10);
		textField_19.setBounds(133, 80, 171, 29);
		panel_4.add(textField_19);

		JLabel lblCedula_2_1_2 = new JLabel("Cedula");
		lblCedula_2_1_2.setBounds(12, 87, 148, 15);
		panel_4.add(lblCedula_2_1_2);

		comboBox_1.setBounds(133, 155, 171, 29);
		panel_4.add(comboBox_1);

		JButton btnCargar_1_1_1 = new JButton("");
		btnCargar_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargaAlumno.setCedula(Integer.parseInt(textField_19.getText()));
					cargaAlumno.setGrupo(comboBox_1.getSelectedItem().toString());
					if (cargaAlumno.consulta() == true) {
						JOptionPane.showMessageDialog(null, "Alumno ya registrado en el sistema!", "Hey!",
								JOptionPane.ERROR_MESSAGE);
					} else if (cargaAlumno.consulta() == false) {
						Log myLog;
						try {
							myLog = new Log("./logFolder/log.txt");
							myLog.addLine("El usuario: " + getCiUser() + "dio de alta al alumno: " +cargaAlumno.getCedula());
							cargaAlumno.alta();
							textField_19.setText("");
							JOptionPane.showMessageDialog(null, "Alumno registrado correctamente!", "Hey!",JOptionPane.INFORMATION_MESSAGE);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCargar_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCargar_1_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo111.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnCargar_1_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo222.png")));
			}
		});
		btnCargar_1_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo222.png")));
		btnCargar_1_1_1.setContentAreaFilled(false);
		btnCargar_1_1_1.setBorderPainted(false);
		btnCargar_1_1_1.setBounds(178, 216, 91, 94);
		panel_4.add(btnCargar_1_1_1);

		JSeparator separator_1_1_1_2_2 = new JSeparator();
		separator_1_1_1_2_2.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1_2_2.setBounds(459, 12, 2, 298);
		panel_4.add(separator_1_1_1_2_2);

		JLabel lblCedula_2_1_2_1 = new JLabel("Grupo");
		lblCedula_2_1_2_1.setBounds(12, 162, 148, 15);
		panel_4.add(lblCedula_2_1_2_1);

		JSeparator separator_1_1_3_1 = new JSeparator();
		separator_1_1_3_1.setBounds(12, 322, 857, 2);
		panel_4.add(separator_1_1_3_1);

		JLabel lblBajaDeUsuario_1_2 = new JLabel("Baja de Alumno");
		lblBajaDeUsuario_1_2.setBounds(569, 12, 148, 15);
		panel_4.add(lblBajaDeUsuario_1_2);

		textField_20 = new JTextField();
		textField_20.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (caracter < '0' || caracter > '9' && caracter != '\b') {
					e.consume();
				}
			}
		});
		textField_20.setColumns(10);
		textField_20.setBounds(611, 32, 171, 29);
		panel_4.add(textField_20);

		JLabel cedulaMuestra = new JLabel(".....");
		cedulaMuestra.setHorizontalAlignment(SwingConstants.CENTER);
		cedulaMuestra.setBounds(479, 230, 148, 15);
		panel_4.add(cedulaMuestra);

		JLabel lblCedulaDelUsuario_1_3_1 = new JLabel("Cedula del Alumno");
		lblCedulaDelUsuario_1_3_1.setBounds(468, 39, 148, 15);
		panel_4.add(lblCedulaDelUsuario_1_3_1);

		JButton btnConfirmarBaja_1_2 = new JButton("");
		btnConfirmarBaja_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnConfirmarBaja_1_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/eliminar2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnConfirmarBaja_1_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/eliminar1.png")));
			}
		});
		btnConfirmarBaja_1_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/eliminar1.png")));
		btnConfirmarBaja_1_2.setContentAreaFilled(false);
		btnConfirmarBaja_1_2.setBorderPainted(false);
		btnConfirmarBaja_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eleccion = JOptionPane.showConfirmDialog(null,
						"¿Esta seguro que desea eliminar el siguiente alumno? " + cargaAlumno.getCedula(),
						"Confirmacion", JOptionPane.YES_NO_OPTION);
				if (eleccion == 0) {
					Log myLog;
					try {
						myLog = new Log("./logFolder/log.txt");
						myLog.addLine("El usuario: " + getCiUser() + "dio de baja al alumno: " +cargaAlumno.getCedula());
						cargaAlumno.eliminacion();
						JOptionPane.showMessageDialog(null, "Acabas de eliminar al alumno:" + cargaAlumno.getCedula(),"Hey!", JOptionPane.INFORMATION_MESSAGE);
						cedulaMuestra.setText(".....");
						btnConfirmarBaja_1_2.setEnabled(false);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else if (eleccion == 1) {
					JOptionPane.showMessageDialog(null,
							"Presionaste en no eliminar al alumno:" + cargaAlumno.getCedula(), "Hey!",
							JOptionPane.INFORMATION_MESSAGE);
					btnConfirmarBaja_1_2.setEnabled(false);
					cedulaMuestra.setText(".....");
				}
			}
		});
		btnConfirmarBaja_1_2.setForeground(Color.WHITE);
		btnConfirmarBaja_1_2.setEnabled(false);
		btnConfirmarBaja_1_2.setBackground(new Color(153, 193, 241));
		btnConfirmarBaja_1_2.setBounds(769, 197, 63, 59);
		panel_4.add(btnConfirmarBaja_1_2);

		JButton btnNewButton_2_2_2 = new JButton("");
		btnNewButton_2_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargaAlumno.setCedula(Integer.parseInt(textField_20.getText()));
					if (cargaAlumno.consulta() == true) {
						JOptionPane.showMessageDialog(null, "El Alumno esta registrado! Puede proceder a eliminar",
								"Hey!", JOptionPane.INFORMATION_MESSAGE);
						cedulaMuestra.setText(String.valueOf(cargaAlumno.getCedula()));
						btnConfirmarBaja_1_2.setEnabled(true);
					} else if (cargaAlumno.consulta() == false) {
						JOptionPane.showMessageDialog(null, "El Alumno no esta registrado!", "Hey!",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_2_2_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_2_2_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
			}
		});
		btnNewButton_2_2_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
		btnNewButton_2_2_2.setContentAreaFilled(false);
		btnNewButton_2_2_2.setBorderPainted(false);
		btnNewButton_2_2_2.setBounds(744, 74, 41, 28);
		panel_4.add(btnNewButton_2_2_2);

		JLabel lblEditarUsuario_1_1_1 = new JLabel("Editar grupo del Alumno");
		lblEditarUsuario_1_1_1.setBounds(380, 331, 171, 15);
		panel_4.add(lblEditarUsuario_1_1_1);

		textField_21 = new JTextField();
		textField_21.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (caracter < '0' || caracter > '9' && caracter != '\b') {
					e.consume();
				}
			}
		});
		textField_21.setColumns(10);
		textField_21.setBounds(380, 362, 171, 29);
		panel_4.add(textField_21);

		JLabel lblCedulaDelUsuario_1_3_1_1 = new JLabel("Cedula del Alumno");
		lblCedulaDelUsuario_1_3_1_1.setBounds(226, 369, 136, 15);
		panel_4.add(lblCedulaDelUsuario_1_3_1_1);

		JSeparator separator_1_1_2_2_1_2 = new JSeparator();
		separator_1_1_2_2_1_2.setBounds(12, 428, 860, 4);
		panel_4.add(separator_1_1_2_2_1_2);

		comboBox_1_1.setBounds(380, 466, 171, 29);
		panel_4.add(comboBox_1_1);

		JButton btnNewButton_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Log myLog;
				try {
					myLog = new Log("./logFolder/log.txt");
					myLog.addLine("El usuario: " + getCiUser() + "modifico al alumno: " +cargaAlumno.getCedula());
					cargaAlumno.setGrupo(comboBox_1_1.getSelectedItem().toString());
					cargaAlumno.modificacionNombreTipo();
					JOptionPane.showMessageDialog(null, "El Alumno fue modificado Correctamente!", "Hey!",JOptionPane.INFORMATION_MESSAGE);
					textField_21.setText("");
					btnNewButton_1_1_1_1.setEnabled(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/submit1.png")));
		btnNewButton_1_1_1_1.setEnabled(false);
		btnNewButton_1_1_1_1.setContentAreaFilled(false);
		btnNewButton_1_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1_1.setBounds(569, 468, 124, 27);
		panel_4.add(btnNewButton_1_1_1_1);

		JButton btnNewButton_3_2 = new JButton("");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargaAlumno.setCedula(Integer.parseInt(textField_21.getText()));
					if (cargaAlumno.consulta() == true) {
						JOptionPane.showMessageDialog(null, "El Alumno registrado! Puede proceder a modificar", "Hey!",
								JOptionPane.INFORMATION_MESSAGE);
						btnNewButton_1_1_1_1.setEnabled(true);
					} else if (cargaAlumno.consulta() == false) {
						JOptionPane.showMessageDialog(null, "El Alumno no esta registrado!", "Hey!",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores ingresados nulos o incorrectos", "Hey!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_3_2.setIcon(new ImageIcon(Menu.class.getResource("/imgs/buscar1.png")));
		btnNewButton_3_2.setContentAreaFilled(false);
		btnNewButton_3_2.setBorderPainted(false);
		btnNewButton_3_2.setBounds(586, 363, 41, 28);
		panel_4.add(btnNewButton_3_2);

		JLabel lblCedula_2_1_2_1_1 = new JLabel("Grupo");
		lblCedula_2_1_2_1_1.setBounds(304, 473, 58, 15);
		panel_4.add(lblCedula_2_1_2_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setBounds(0, 0, 900, 600);
		panel_4.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imgs/fondoMenu23.png")));
		lblNewLabel_1_1_1.setBackground(new Color(45, 173, 222));
		this.setLocationRelativeTo(null);
		cargarCombo();
		cargarComboGrupo();
		construirTabla();

	}

	public static void construirTabla() {
		String titulos[] = { "Cedula Docente", "Cedula Usuario", "Fecha Inicial", "Fecha Final", "Grupo", "Motivo" };
		String informacion[][] = obtenerMatriz();
		table = new JTable(informacion, titulos);
		table.setEnabled(false);
		miBarra1.setViewportView(table);
	}

	private static String[][] obtenerMatriz() {
		ArrayList<Registros> miLista = Registros.llenarDatos();
		String matrizInfo[][] = new String[miLista.size()][6];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getCedulaDocente() + "";
			matrizInfo[i][1] = miLista.get(i).getCedulaUsuario() + "";
			matrizInfo[i][2] = miLista.get(i).getFechaInicial() + "";
			matrizInfo[i][3] = miLista.get(i).getFechaFinal() + "";
			matrizInfo[i][4] = miLista.get(i).getNombreGrupo() + "";
			matrizInfo[i][5] = miLista.get(i).getMotivo() + "";
		}
		return matrizInfo;
	}

	private void cargarCombo() {
		for (String s : combosConexion.llenarCombo()) {
			comboBox.addItem(s);
			comboBox_2.addItem(s);
		}
	}

	private void cargarComboGrupo() {
		for (String s : combosConexion.llenarComboGrupos()) {
			comboBox_1.addItem(s);
			comboBox_1_1.addItem(s);
			comboBox_3.addItem(s);

		}
	}
}
