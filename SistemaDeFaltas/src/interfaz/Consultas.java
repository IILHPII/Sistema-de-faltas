package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import model.Docente;
import model.Registros;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Consultas extends JFrame {
	

	private JPanel contentPane;
	private Docente docente=new Docente();
	private Registros registro=new Registros();
	private static JTable miTabla1;
	private static JScrollPane miBarra1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultas frame = new Consultas();
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
	public Consultas() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 899, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeFalta = new JLabel("Consultas Generales");
		lblRegistroDeFalta.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRegistroDeFalta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeFalta.setBounds(319, 12, 227, 30);
		contentPane.add(lblRegistroDeFalta);
		
		
		miBarra1=new JScrollPane();
		miBarra1.setBounds(137,39,600,320);
		getContentPane().add(miBarra1);
		construirTabla();
		
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
		
		textField.setEnabled(false);
		textField.setBounds(492, 422, 162, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setHorizontalAlignment(SwingConstants.CENTER);
		lblCedula.setBounds(539, 401, 70, 15);
		contentPane.add(lblCedula);
		
		JCheckBox chckbxFiltrarPorCedula = new JCheckBox("Filtrar por Cedula de Docente");
		chckbxFiltrarPorCedula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
			}
		});
		buttonGroup.add(chckbxFiltrarPorCedula);
		chckbxFiltrarPorCedula.setBounds(137, 397, 262, 23);
		contentPane.add(chckbxFiltrarPorCedula);
		
		JCheckBox chckbxFiltrarPorCedula_2 = new JCheckBox("Filtrar por Cedula de Usuario");
		chckbxFiltrarPorCedula_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
			}
		});
		buttonGroup.add(chckbxFiltrarPorCedula_2);
		chckbxFiltrarPorCedula_2.setBounds(137, 454, 262, 23);
		contentPane.add(chckbxFiltrarPorCedula_2);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxFiltrarPorCedula.isSelected()) {
					registro.setCedulaDocente(textField.getText());
					construirTablaDocente();
				}else if(chckbxFiltrarPorCedula_2.isSelected()) {
					registro.setCedulaUsuario(textField.getText());
					construirTablaUsuario();
				}else {
					JOptionPane.showMessageDialog(null,"No tiene ningun filtro seleccionado!","Hey!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(717, 424, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_4_1_1 = new JButton("");
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_4_1_1.setIcon(new ImageIcon(Consultas.class.getResource("/imgs/exit22.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_4_1_1.setIcon(new ImageIcon(Consultas.class.getResource("/imgs/exit.png")));
			}
		});
		
		btnNewButton_4_1_1.setIcon(new ImageIcon(Consultas.class.getResource("/imgs/exit.png")));
		btnNewButton_4_1_1.setContentAreaFilled(false);
		btnNewButton_4_1_1.setBorderPainted(false);
		btnNewButton_4_1_1.setBounds(824, 516, 63, 59);
		contentPane.add(btnNewButton_4_1_1);
		
		JButton btnNewButton_1 = new JButton("Refrescar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				construirTabla();
			}
		});
		btnNewButton_1.setBounds(620, 361, 117, 15);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RegistroDeFaltas.class.getResource("/imgs/fondoMenu23.png")));
		lblNewLabel.setBounds(0, 0, 904, 600);
		contentPane.add(lblNewLabel);
		
		
	}
	
	
	public void construirTabla() {
		String titulos[]= {"Cedula Docente","Cedula Usuario","Fecha Inicial","Fecha Final","Grupo","Motivo"};
		String informacion[][]=obtenerMatriz();
		miTabla1=new JTable(informacion,titulos);
		miTabla1.setEnabled(false);
		miBarra1.setViewportView(miTabla1);
	}
	
	private String[][] obtenerMatriz(){
		ArrayList<Registros>miLista=registro.llenarDatos();
		String matrizInfo[][]=new String[miLista.size()][6];
		for(int i =0;i<miLista.size();i++) {
			matrizInfo[i][0]=miLista.get(i).getCedulaDocente()+"";
			matrizInfo[i][1]=miLista.get(i).getCedulaUsuario()+"";
			matrizInfo[i][2]=miLista.get(i).getFechaInicial()+"";
			matrizInfo[i][3]=miLista.get(i).getFechaFinal()+"";
			matrizInfo[i][4]=miLista.get(i).getNombreGrupo()+"";
			matrizInfo[i][5]=miLista.get(i).getMotivo()+"";
		}
		return matrizInfo;
	}
	
	public void construirTablaDocente() {
		String titulos[]= {"Cedula Docente","Cedula Usuario","Fecha Inicial","Fecha Final","Grupo","Motivo"};
		String informacion[][]=obtenerMatrizDocente();
		miTabla1=new JTable(informacion,titulos);
		miTabla1.setEnabled(false);
		miBarra1.setViewportView(miTabla1);
	}
	
	private String[][] obtenerMatrizDocente(){
		ArrayList<Registros>miLista=registro.llenarDatosDocente();
		String matrizInfo[][]=new String[miLista.size()][6];
		for(int i =0;i<miLista.size();i++) {
			matrizInfo[i][0]=miLista.get(i).getCedulaDocente()+"";
			matrizInfo[i][1]=miLista.get(i).getCedulaUsuario()+"";
			matrizInfo[i][2]=miLista.get(i).getFechaInicial()+"";
			matrizInfo[i][3]=miLista.get(i).getFechaFinal()+"";
			matrizInfo[i][4]=miLista.get(i).getNombreGrupo()+"";
			matrizInfo[i][5]=miLista.get(i).getMotivo()+"";
		}
		return matrizInfo;
	}
	
	
	public void construirTablaUsuario() {
		String titulos[]= {"Cedula Docente","Cedula Usuario","Fecha Inicial","Fecha Final","Grupo","Motivo"};
		String informacion[][]=obtenerMatrizUsuario();
		miTabla1=new JTable(informacion,titulos);
		miTabla1.setEnabled(false);
		miBarra1.setViewportView(miTabla1);
	}
	
	private String[][] obtenerMatrizUsuario(){
		ArrayList<Registros>miLista=registro.llenarDatosUsuario();
		String matrizInfo[][]=new String[miLista.size()][6];
		for(int i =0;i<miLista.size();i++) {
			matrizInfo[i][0]=miLista.get(i).getCedulaDocente()+"";
			matrizInfo[i][1]=miLista.get(i).getCedulaUsuario()+"";
			matrizInfo[i][2]=miLista.get(i).getFechaInicial()+"";
			matrizInfo[i][3]=miLista.get(i).getFechaFinal()+"";
			matrizInfo[i][4]=miLista.get(i).getNombreGrupo()+"";
			matrizInfo[i][5]=miLista.get(i).getMotivo()+"";
		}
		return matrizInfo;
	}
}





