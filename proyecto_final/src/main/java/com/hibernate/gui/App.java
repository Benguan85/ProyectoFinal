package com.hibernate.gui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.hibernate.dao.MotoDAO;
import com.hibernate.dao.PilotoDAO;
import com.hibernate.dao.PilotoMotoDAO;
import com.hibernate.model.Moto;
import com.hibernate.model.Piloto;
import com.hibernate.model.PilotoMoto;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.awt.Color;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.time.format.DateTimeFormatter;
import java.awt.Font;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

	private JFrame frmCircuito;
	private JTable tableMoto;
	private JTable tablePiloto;
	private JTextField textField_IdMoto;
	private JTextField textField_Marca;
	private JTextField textField_Modelo;
	private JTextField textField_Cilindrada;
	private JTextField textField_Caballos;
	private JTextField textField_IdPiloto;
	private JTextField textField_Nombre;
	private JTextField textField_Edad;
	private JTextField textField_Nacionalidad;
	private JTextField textField_Escuderia;
	private JTextField textField_TiempoVuelta;
	private JTextField textField_PilotoPM;
	private JTextField textField_MotoPM;
	private JTextField textField_IdPM;
	private ResourceBundle msgs;

	// Constante para determinar que tiempo es el destacado en el circuito
	final double TIEMPO_DESTACADO = 1.35;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmCircuito.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		// Puedes forzar el idioma así:
		Locale locale = Locale.forLanguageTag("es");
		msgs = ResourceBundle.getBundle("MessagesBundle", locale);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		MotoDAO daoMoto = new MotoDAO();
		List<Moto> listMoto = null;

		PilotoDAO daoPiloto = new PilotoDAO();
		List<Piloto> listPiloto = null;

		PilotoMotoDAO daoPilotoMoto = new PilotoMotoDAO();
		List<PilotoMoto> listPilotoMoto = null;

		frmCircuito = new JFrame();
		frmCircuito.setTitle(msgs.getString("title"));
		frmCircuito.getContentPane().setBackground(new Color(192, 192, 192));
		frmCircuito.setBounds(100, 100, 1600, 900);
		frmCircuito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCircuito.getContentPane().setLayout(null);

		// TODOS LOS JLABEL
		JLabel lblId = new JLabel(msgs.getString("label.id"));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(52, 340, 59, 25);
		frmCircuito.getContentPane().add(lblId);

		JLabel lblMarca = new JLabel(msgs.getString("label.marca"));
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setBounds(138, 340, 113, 25);
		frmCircuito.getContentPane().add(lblMarca);

		JLabel lblModelo = new JLabel(msgs.getString("label.modelo"));
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setBounds(277, 340, 114, 25);
		frmCircuito.getContentPane().add(lblModelo);

		JLabel lblCilindrada = new JLabel(msgs.getString("label.cilindrada"));
		lblCilindrada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCilindrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblCilindrada.setBounds(409, 340, 132, 25);
		frmCircuito.getContentPane().add(lblCilindrada);

		JLabel lblCaballos = new JLabel(msgs.getString("label.caballos"));
		lblCaballos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCaballos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaballos.setBounds(556, 340, 114, 25);
		frmCircuito.getContentPane().add(lblCaballos);

		JLabel lblId_1 = new JLabel(msgs.getString("label.id"));
		lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblId_1.setBounds(10, 738, 59, 25);
		frmCircuito.getContentPane().add(lblId_1);

		JLabel lblNombre = new JLabel(msgs.getString("label.nombre"));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(79, 738, 114, 25);
		frmCircuito.getContentPane().add(lblNombre);

		JLabel lblEdad = new JLabel(msgs.getString("label.edad"));
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setBounds(203, 738, 59, 25);
		frmCircuito.getContentPane().add(lblEdad);

		JLabel lblNacionalidad = new JLabel(msgs.getString("label.nacionalidad"));
		lblNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNacionalidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblNacionalidad.setBounds(272, 738, 150, 25);
		frmCircuito.getContentPane().add(lblNacionalidad);

		JLabel lblEscuderia = new JLabel(msgs.getString("label.escuderia"));
		lblEscuderia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEscuderia.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscuderia.setBounds(432, 738, 114, 25);
		frmCircuito.getContentPane().add(lblEscuderia);

		JLabel lblTiempoVuelta = new JLabel(msgs.getString("label.tiempoVuelta"));
		lblTiempoVuelta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTiempoVuelta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoVuelta.setBounds(545, 738, 170, 25);
		frmCircuito.getContentPane().add(lblTiempoVuelta);

		JLabel lblPilotoPM = new JLabel(msgs.getString("label.piloto"));
		lblPilotoPM.setHorizontalAlignment(SwingConstants.CENTER);
		lblPilotoPM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPilotoPM.setBounds(1079, 340, 74, 25);
		frmCircuito.getContentPane().add(lblPilotoPM);

		JLabel lblMotoPM = new JLabel(msgs.getString("label.moto"));
		lblMotoPM.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotoPM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMotoPM.setBounds(1189, 340, 100, 24);
		frmCircuito.getContentPane().add(lblMotoPM);

		JLabel lblTablaMoto = new JLabel(msgs.getString("label.tablaMoto"));
		lblTablaMoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablaMoto.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTablaMoto.setBounds(10, 0, 696, 46);
		frmCircuito.getContentPane().add(lblTablaMoto);

		JLabel lblTablaPiloto = new JLabel(msgs.getString("label.tablaPiloto"));
		lblTablaPiloto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablaPiloto.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTablaPiloto.setBounds(10, 407, 696, 32);
		frmCircuito.getContentPane().add(lblTablaPiloto);

		JLabel lblId_2 = new JLabel(msgs.getString("label.id"));
		lblId_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblId_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId_2.setBounds(973, 340, 59, 24);
		frmCircuito.getContentPane().add(lblId_2);

		JLabel lblTablaAsignar = new JLabel(msgs.getString("label.tablaAsignar"));
		lblTablaAsignar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablaAsignar.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTablaAsignar.setBounds(923, 0, 614, 46);
		frmCircuito.getContentPane().add(lblTablaAsignar);

		JLabel lblFecha = new JLabel(msgs.getString("label.fecha"));
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFecha.setBounds(1320, 340, 150, 25);
		frmCircuito.getContentPane().add(lblFecha);

		JLabel lblIdioma = new JLabel(msgs.getString("label.idioma"));
		lblIdioma.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdioma.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIdioma.setBounds(716, 0, 197, 37);
		frmCircuito.getContentPane().add(lblIdioma);

		// TODOS LOS TEXT FIELD
		textField_IdMoto = new JTextField();
		textField_IdMoto.setEditable(false);
		textField_IdMoto.setBounds(52, 366, 59, 25);
		frmCircuito.getContentPane().add(textField_IdMoto);
		textField_IdMoto.setColumns(10);

		textField_Marca = new JTextField();
		textField_Marca.setBounds(137, 366, 114, 25);
		frmCircuito.getContentPane().add(textField_Marca);
		textField_Marca.setColumns(10);

		textField_Modelo = new JTextField();
		textField_Modelo.setBounds(277, 366, 114, 25);
		frmCircuito.getContentPane().add(textField_Modelo);
		textField_Modelo.setColumns(10);

		textField_Cilindrada = new JTextField();
		textField_Cilindrada.setBounds(418, 366, 114, 25);
		frmCircuito.getContentPane().add(textField_Cilindrada);
		textField_Cilindrada.setColumns(10);

		textField_Caballos = new JTextField();
		textField_Caballos.setBounds(556, 366, 114, 25);
		frmCircuito.getContentPane().add(textField_Caballos);
		textField_Caballos.setColumns(10);

		textField_IdPiloto = new JTextField();
		textField_IdPiloto.setEditable(false);
		textField_IdPiloto.setBounds(10, 764, 59, 25);
		frmCircuito.getContentPane().add(textField_IdPiloto);
		textField_IdPiloto.setColumns(10);

		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(79, 764, 114, 25);
		frmCircuito.getContentPane().add(textField_Nombre);
		textField_Nombre.setColumns(10);

		textField_Edad = new JTextField();
		textField_Edad.setBounds(203, 764, 59, 25);
		frmCircuito.getContentPane().add(textField_Edad);
		textField_Edad.setColumns(10);

		textField_Nacionalidad = new JTextField();
		textField_Nacionalidad.setBounds(272, 764, 150, 25);
		frmCircuito.getContentPane().add(textField_Nacionalidad);
		textField_Nacionalidad.setColumns(10);

		textField_Escuderia = new JTextField();
		textField_Escuderia.setBounds(432, 764, 114, 25);
		frmCircuito.getContentPane().add(textField_Escuderia);
		textField_Escuderia.setColumns(10);

		textField_TiempoVuelta = new JTextField();
		textField_TiempoVuelta.setBounds(556, 764, 150, 25);
		frmCircuito.getContentPane().add(textField_TiempoVuelta);
		textField_TiempoVuelta.setColumns(10);

		textField_PilotoPM = new JTextField();
		textField_PilotoPM.setBounds(1084, 366, 59, 25);
		frmCircuito.getContentPane().add(textField_PilotoPM);
		textField_PilotoPM.setColumns(10);

		textField_MotoPM = new JTextField();
		textField_MotoPM.setBounds(1211, 366, 59, 25);
		frmCircuito.getContentPane().add(textField_MotoPM);
		textField_MotoPM.setColumns(10);

		textField_IdPM = new JTextField();
		textField_IdPM.setEditable(false);
		textField_IdPM.setBounds(973, 366, 59, 25);
		frmCircuito.getContentPane().add(textField_IdPM);
		textField_IdPM.setColumns(10);

		// CONFIGURACION GESTION DE FECHAS
		DatePickerSettings settings = new DatePickerSettings();
		settings.setFormatForDatesCommonEra("dd/MM/yyyy");

		DatePicker datePickerPM = new DatePicker(settings);
		datePickerPM.setBounds(1320, 366, 150, 25);
		frmCircuito.getContentPane().add(datePickerPM);

		// TODAS LAS 3 TABLAS

		// Tabla Moto
		DefaultTableModel modelMoto = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		modelMoto.addColumn(msgs.getString("label.id"));
		modelMoto.addColumn(msgs.getString("label.marca"));
		modelMoto.addColumn(msgs.getString("label.modelo"));
		modelMoto.addColumn(msgs.getString("label.cilindrada"));
		modelMoto.addColumn(msgs.getString("label.caballos"));

		listMoto = daoMoto.seleccionarTodasLasMotos();

		for (int i = 0; i < listMoto.size(); i++) {
			Object[] row = new Object[5];
			row[0] = listMoto.get(i).getId();
			row[1] = listMoto.get(i).getMarca();
			row[2] = listMoto.get(i).getModelo();
			row[3] = listMoto.get(i).getCilindrada();
			row[4] = listMoto.get(i).getCaballos();

			modelMoto.addRow(row);
		}
		tableMoto = new JTable(modelMoto);
		tableMoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableMoto.getSelectedRow();
				TableModel modelMoto = tableMoto.getModel();

				textField_IdMoto.setText(modelMoto.getValueAt(index, 0).toString());
				textField_Marca.setText(modelMoto.getValueAt(index, 1).toString());
				textField_Modelo.setText(modelMoto.getValueAt(index, 2).toString());
				textField_Cilindrada.setText(modelMoto.getValueAt(index, 3).toString());
				textField_Caballos.setText(modelMoto.getValueAt(index, 4).toString());
			}
		});
		tableMoto.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableMoto.getTableHeader().setBackground(Color.DARK_GRAY);
		tableMoto.getTableHeader().setForeground(Color.WHITE);
		tableMoto.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));

		JScrollPane scrollPaneMoto = new JScrollPane();
		scrollPaneMoto.setBounds(10, 44, 696, 285);
		frmCircuito.getContentPane().add(scrollPaneMoto);
		scrollPaneMoto.setViewportView(tableMoto);

		// Tabla Piloto
		DefaultTableModel modelPiloto = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		modelPiloto.addColumn(msgs.getString("label.id"));
		modelPiloto.addColumn(msgs.getString("label.nombre"));
		modelPiloto.addColumn(msgs.getString("label.edad"));
		modelPiloto.addColumn(msgs.getString("label.nacionalidad"));
		modelPiloto.addColumn(msgs.getString("label.escuderia"));
		modelPiloto.addColumn(msgs.getString("label.tiempoVuelta"));

		listPiloto = daoPiloto.seleccionarTodosLosPilotos();

		for (int i = 0; i < listPiloto.size(); i++) {
			Object[] row = new Object[6];
			row[0] = listPiloto.get(i).getId();
			row[1] = listPiloto.get(i).getNombre();
			row[2] = listPiloto.get(i).getEdad();
			row[3] = listPiloto.get(i).getNacionalidad();
			row[4] = listPiloto.get(i).getEscuderia();
			row[5] = listPiloto.get(i).getTiempo_vuelta();

			modelPiloto.addRow(row);
		}
		tablePiloto = new JTable(modelPiloto);
		tablePiloto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tablePiloto.getSelectedRow();
				TableModel modelPiloto = tablePiloto.getModel();

				textField_IdPiloto.setText(modelPiloto.getValueAt(index, 0).toString());
				textField_Nombre.setText(modelPiloto.getValueAt(index, 1).toString());
				textField_Edad.setText(modelPiloto.getValueAt(index, 2).toString());
				textField_Nacionalidad.setText(modelPiloto.getValueAt(index, 3).toString());
				textField_Escuderia.setText(modelPiloto.getValueAt(index, 4).toString());
				textField_TiempoVuelta.setText(modelPiloto.getValueAt(index, 5).toString());

			}
		});
		tablePiloto.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablePiloto.getTableHeader().setBackground(Color.DARK_GRAY);
		tablePiloto.getTableHeader().setForeground(Color.WHITE);
		tablePiloto.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));

		JScrollPane scrollPanePiloto = new JScrollPane();
		scrollPanePiloto.setBounds(10, 442, 696, 285);
		frmCircuito.getContentPane().add(scrollPanePiloto);
		scrollPanePiloto.setViewportView(tablePiloto);

		// Tabla PilotoMoto
		DefaultTableModel modelPilotoMoto = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		modelPilotoMoto.addColumn(msgs.getString("label.id"));
		modelPilotoMoto.addColumn(msgs.getString("label.piloto"));
		modelPilotoMoto.addColumn(msgs.getString("label.moto"));
		modelPilotoMoto.addColumn(msgs.getString("label.fecha"));

		DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		listPilotoMoto = daoPilotoMoto.seleccionarTodas();

		for (int i = 0; i < listPilotoMoto.size(); i++) {
			Object[] row = new Object[4];
			row[0] = listPilotoMoto.get(i).getId();
			row[1] = listPilotoMoto.get(i).getPiloto().getId();
			row[2] = listPilotoMoto.get(i).getMoto().getId();
			row[3] = listPilotoMoto.get(i).getFecha().toLocalDate().format(formatoEuropeo);

			modelPilotoMoto.addRow(row);
		}

		JTable tablePilotoMoto = new JTable(modelPilotoMoto);
		tablePilotoMoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tablePilotoMoto.getSelectedRow();
				TableModel modelPilotoMoto = tablePilotoMoto.getModel();
				textField_IdPM.setText(modelPilotoMoto.getValueAt(index, 0).toString());
				textField_PilotoPM.setText(modelPilotoMoto.getValueAt(index, 1).toString());
				textField_MotoPM.setText(modelPilotoMoto.getValueAt(index, 2).toString());
				datePickerPM.setText(modelPilotoMoto.getValueAt(index, 3).toString());
			}
		});
		tablePilotoMoto.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablePilotoMoto.getTableHeader().setBackground(Color.DARK_GRAY);
		tablePilotoMoto.getTableHeader().setForeground(Color.WHITE);
		tablePilotoMoto.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));

		JScrollPane scrollPanePilotoMoto = new JScrollPane(tablePilotoMoto);
		scrollPanePilotoMoto.setBounds(923, 44, 614, 285);
		frmCircuito.getContentPane().add(scrollPanePilotoMoto);
		scrollPanePilotoMoto.setViewportView(tablePilotoMoto);

		// CENTRADO Y COLOREADO DE TABLAS
		// Renderizador para la columna de "tiempo de vuelta" que es la que cambia de
		// colores
		DefaultTableCellRenderer tiempoRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

				// Centrar el contenido de la celda
				setHorizontalAlignment(SwingConstants.CENTER);

				// Colorear el contenido de la celda
				try {
					double tiempo = Double.parseDouble(value.toString());

					if (tiempo < TIEMPO_DESTACADO) {
						c.setBackground(Color.GREEN);
					} else {
						c.setBackground(Color.CYAN);
					}
				} catch (NumberFormatException ex) {
					c.setBackground(Color.WHITE);
				}

				return c;
			}
		};

		// Esto aplica el renderizador a la columna "tiempo de vuelta"
		tablePiloto.getColumnModel().getColumn(5).setCellRenderer(tiempoRenderer);

		// Renderizador generico que solo centra el texto
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// Centrar todas las columnas de la tabla de motos
		for (int i = 0; i < tableMoto.getColumnCount(); i++) {
			tableMoto.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		// Centrar todas las columnas de la tabla de pilotos sin pasar por la columna 5
		// que usa el renderizador de arriba del color
		for (int i = 0; i < tablePiloto.getColumnCount(); i++) {
			if (i == 5) {
				tablePiloto.getColumnModel().getColumn(i).setCellRenderer(tiempoRenderer);
			} else {
				tablePiloto.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			}
		}

		// Centrar todas las columnas de la tabla PilotoMoto
		for (int i = 0; i < tablePilotoMoto.getColumnCount(); i++) {
			tablePilotoMoto.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		// TODOS LOS BOTONES

		// Botones de la tabla MOTO

		// Boton Guardar
		JButton btnGuardarMoto = new JButton(msgs.getString("button.guardar"));
		btnGuardarMoto.setBackground(new Color(69, 153, 60));
		btnGuardarMoto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGuardarMoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String marca = textField_Marca.getText();
				String modelo = textField_Modelo.getText();
				String cilindradaStr = textField_Cilindrada.getText();
				String caballosStr = textField_Caballos.getText();

				// Validar marca (solo letras)
				if (marca.length() == 0 || !marca.matches("\\D+")) {
					JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Moto1"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validar modelo (solo letras)
				if (modelo.length() == 0 || !modelo.matches("\\D+")) {
					JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Moto2"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validar cilindrada (solo números)
				if (cilindradaStr.length() == 0 || !cilindradaStr.matches("\\d+")) {
					JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Moto3"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validar caballos (solo números)
				if (caballosStr.length() == 0 || !caballosStr.matches("\\d+")) {
					JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Moto4"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					int cilindrada = Integer.parseInt(cilindradaStr);
					int caballos = Integer.parseInt(caballosStr);

					Moto moto = new Moto(marca, modelo, cilindrada, caballos);
					daoMoto.insertarMoto(moto);

					// Actualizar tabla
					modelMoto.setRowCount(0);
					for (Moto m : daoMoto.seleccionarTodasLasMotos()) {
						Object[] row = new Object[5];
						row[0] = m.getId();
						row[1] = m.getMarca();
						row[2] = m.getModelo();
						row[3] = m.getCilindrada();
						row[4] = m.getCaballos();
						modelMoto.addRow(row);
					}

					// Limpiar campos
					textField_IdMoto.setText("");
					textField_Marca.setText("");
					textField_Modelo.setText("");
					textField_Cilindrada.setText("");
					textField_Caballos.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.MotoCatchGuardar"), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnGuardarMoto.setBounds(716, 129, 145, 40);
		frmCircuito.getContentPane().add(btnGuardarMoto);

		// Boton Actualizar
		JButton btnActualizarMoto = new JButton(msgs.getString("button.actualizar"));
		btnActualizarMoto.setBackground(new Color(221, 183, 68));
		btnActualizarMoto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnActualizarMoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String idStr = textField_IdMoto.getText();
					String marca = textField_Marca.getText();
					String modelo = textField_Modelo.getText();
					String cilindradaStr = textField_Cilindrada.getText();
					String caballosStr = textField_Caballos.getText();

					// Validar ID vacío o incorrecto
					if (idStr.length() == 0) {
						JOptionPane.showMessageDialog(null, msgs.getString("error.Moto0"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Validar marca (solo letras)
					if (marca.length() == 0 || !marca.matches("\\D+")) {
						JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Moto1"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Validar modelo (solo letras)
					if (modelo.length() == 0 || !modelo.matches("\\D+")) {
						JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Moto2"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Validar cilindrada (solo números)
					if (cilindradaStr.length() == 0 || !cilindradaStr.matches("\\d+")) {
						JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Moto3"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Validar caballos (solo números)
					if (caballosStr.length() == 0 || !caballosStr.matches("\\d+")) {
						JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Moto4"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					int id = Integer.parseInt(idStr);
					int cilindrada = Integer.parseInt(cilindradaStr);
					int caballos = Integer.parseInt(caballosStr);

					Moto moto = new Moto(marca, modelo, cilindrada, caballos);
					moto.setId(id);

					daoMoto.actualizarMoto(moto);

					// Actualizar tabla
					modelMoto.setRowCount(0);
					for (Moto m : daoMoto.seleccionarTodasLasMotos()) {
						Object[] row = new Object[5];
						row[0] = m.getId();
						row[1] = m.getMarca();
						row[2] = m.getModelo();
						row[3] = m.getCilindrada();
						row[4] = m.getCaballos();
						modelMoto.addRow(row);
					}

					textField_IdMoto.setText("");
					textField_Marca.setText("");
					textField_Modelo.setText("");
					textField_Cilindrada.setText("");
					textField_Caballos.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.MotoCatchActualizar"), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnActualizarMoto.setBounds(716, 180, 145, 40);
		frmCircuito.getContentPane().add(btnActualizarMoto);

		// Boton borrar
		JButton btnBorrarMoto = new JButton(msgs.getString("button.borrar"));
		btnBorrarMoto.setBackground(new Color(160, 33, 33));
		btnBorrarMoto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBorrarMoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int id = Integer.parseInt(textField_IdMoto.getText());
					String idStr = textField_IdMoto.getText();

					// Validar ID vacío o incorrecto
					if (idStr.length() == 0) {
						JOptionPane.showMessageDialog(null, msgs.getString("error.Moto0"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					daoMoto.eliminarMoto(id);

					// Actualizar tabla
					modelMoto.setRowCount(0);
					for (Moto m : daoMoto.seleccionarTodasLasMotos()) {
						Object[] row = new Object[5];
						row[0] = m.getId();
						row[1] = m.getMarca();
						row[2] = m.getModelo();
						row[3] = m.getCilindrada();
						row[4] = m.getCaballos();
						modelMoto.addRow(row);
					}

					textField_IdMoto.setText("");
					textField_Marca.setText("");
					textField_Modelo.setText("");
					textField_Cilindrada.setText("");
					textField_Caballos.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.MotoCatchBorrar"));
				}
			}
		});
		btnBorrarMoto.setBounds(716, 231, 145, 40);
		frmCircuito.getContentPane().add(btnBorrarMoto);

		// Botones de la tabla PILOTO

		// Boton Guardar
		JButton btnGuardarPiloto = new JButton(msgs.getString("button.guardar"));
		btnGuardarPiloto.setBackground(new Color(69, 153, 60));
		btnGuardarPiloto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGuardarPiloto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = textField_Nombre.getText();
				String edadStr = textField_Edad.getText();
				String nacionalidad = textField_Nacionalidad.getText();
				String escuderia = textField_Escuderia.getText();
				String tiempoVueltaStr = textField_TiempoVuelta.getText();

				// Validar nombre (solo letras)
				if (nombre.length() == 0 || !nombre.matches("\\D+")) {
					JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Piloto1"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validar edad (solo números)
				if (edadStr.length() == 0 || !edadStr.matches("\\d+")) {
					JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Piloto2"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validar nacionalidad (solo letras)
				if (nacionalidad.length() == 0 || !nacionalidad.matches("\\D+")) {
					JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Piloto3"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validar escudería (solo letras)
				if (escuderia.length() == 0 || !escuderia.matches("\\D+")) {
					JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Piloto4"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validar tiempo de vuelta (solo números y decimales)
				if (tiempoVueltaStr.length() == 0 || !tiempoVueltaStr.matches("\\d+(\\.\\d+)?")) {
					JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Piloto5"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					int edad = Integer.parseInt(edadStr);
					double tiempo_vuelta = Double.parseDouble(tiempoVueltaStr);

					// Crear el piloto y guardarlo
					Piloto s = new Piloto(nombre, edad, nacionalidad, escuderia, tiempo_vuelta);
					daoPiloto.insertarPiloto(s);

					// Actualizar tabla
					modelPiloto.setRowCount(0);
					for (Piloto p : daoPiloto.seleccionarTodosLosPilotos()) {
						Object[] row = new Object[6];
						row[0] = p.getId();
						row[1] = p.getNombre();
						row[2] = p.getEdad();
						row[3] = p.getNacionalidad();
						row[4] = p.getEscuderia();
						row[5] = p.getTiempo_vuelta();

						modelPiloto.addRow(row);
					}

					// Limpiar campos
					textField_IdPiloto.setText("");
					textField_Nombre.setText("");
					textField_Edad.setText("");
					textField_Nacionalidad.setText("");
					textField_Escuderia.setText("");
					textField_TiempoVuelta.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.PilotoCatchGuardar"), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnGuardarPiloto.setBounds(716, 512, 145, 40);
		frmCircuito.getContentPane().add(btnGuardarPiloto);

		// Boton Actualizar
		JButton btnActualizarPiloto = new JButton(msgs.getString("button.actualizar"));
		btnActualizarPiloto.setBackground(new Color(221, 183, 68));
		btnActualizarPiloto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnActualizarPiloto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String idStr = textField_IdPiloto.getText();
					String nombre = textField_Nombre.getText();
					String edadStr = textField_Edad.getText();
					String nacionalidad = textField_Nacionalidad.getText();
					String escuderia = textField_Escuderia.getText();
					String tiempoVueltaStr = textField_TiempoVuelta.getText();

					// Validar ID vacío o incorrecto
					if (idStr.length() == 0) {
						JOptionPane.showMessageDialog(null, msgs.getString("error.Piloto0"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Validar nombre (solo letras)
					if (nombre.length() == 0 || !nombre.matches("\\D+")) {
						JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Piloto1"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Validar edad (solo números)
					if (edadStr.length() == 0 || !edadStr.matches("\\d+")) {
						JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Piloto2"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Validar nacionalidad (solo letras)
					if (nacionalidad.length() == 0 || !nacionalidad.matches("\\D+")) {
						JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Piloto3"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Validar escudería (solo letras)
					if (escuderia.length() == 0 || !escuderia.matches("\\D+")) {
						JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Piloto4"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Validar tiempo de vuelta (solo números y decimales)
					if (tiempoVueltaStr.length() == 0 || !tiempoVueltaStr.matches("\\d+(\\.\\d+)?")) {
						JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.Piloto5"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					int id = Integer.parseInt(idStr);
					int edad = Integer.parseInt(edadStr);
					double tiempo_vuelta = Double.parseDouble(tiempoVueltaStr);

					// Crear el piloto con los datos
					Piloto p = new Piloto(nombre, edad, nacionalidad, escuderia, tiempo_vuelta);
					p.setId(id);

					// Actualizar el piloto en la base de datos
					daoPiloto.actualizarPiloto(p);

					// Actualizar tabla
					modelPiloto.setRowCount(0);
					for (Piloto p1 : daoPiloto.seleccionarTodosLosPilotos()) {
						Object[] row = new Object[6];
						row[0] = p1.getId();
						row[1] = p1.getNombre();
						row[2] = p1.getEdad();
						row[3] = p1.getNacionalidad();
						row[4] = p1.getEscuderia();
						row[5] = p1.getTiempo_vuelta();

						modelPiloto.addRow(row);
					}

					// Limpiar campos
					textField_IdPiloto.setText("");
					textField_Nombre.setText("");
					textField_Edad.setText("");
					textField_Nacionalidad.setText("");
					textField_Escuderia.setText("");
					textField_TiempoVuelta.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frmCircuito, msgs.getString("error.PilotoCatchActualizar"), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnActualizarPiloto.setBounds(716, 563, 145, 40);
		frmCircuito.getContentPane().add(btnActualizarPiloto);

		// Boton Borrar
		JButton btnBorrarPiloto = new JButton(msgs.getString("button.borrar"));
		btnBorrarPiloto.setBackground(new Color(160, 33, 33));
		btnBorrarPiloto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBorrarPiloto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int id = Integer.parseInt(textField_IdPiloto.getText());
					String idStr = textField_IdPiloto.getText();

					// Validar ID vacío o incorrecto
					if (idStr.length() == 0) {
						JOptionPane.showMessageDialog(null, msgs.getString("error.Piloto0"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					daoPiloto.eliminarPiloto(id);

					// Actualizar tabla
					modelPiloto.setRowCount(0);
					for (Piloto p : daoPiloto.seleccionarTodosLosPilotos()) {
						Object[] row = new Object[6];
						row[0] = p.getId();
						row[1] = p.getNombre();
						row[2] = p.getEdad();
						row[3] = p.getNacionalidad();
						row[4] = p.getEscuderia();
						row[5] = p.getTiempo_vuelta();

						modelPiloto.addRow(row);
					}

					textField_IdPiloto.setText("");
					textField_Nombre.setText("");
					textField_Edad.setText("");
					textField_Nacionalidad.setText("");
					textField_Escuderia.setText("");
					textField_TiempoVuelta.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoCatchBorrar"));
				}
			}
		});
		btnBorrarPiloto.setBounds(716, 614, 145, 40);
		frmCircuito.getContentPane().add(btnBorrarPiloto);

		// Botones de la tabla PILOTO MOTO

		// Boton Asignar (Hace funcion de guardar)
		JButton btnAsignar = new JButton(msgs.getString("button.asignar"));
		btnAsignar.setBackground(new Color(69, 153, 60));
		btnAsignar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAsignar.setBounds(1277, 407, 200, 40);
		frmCircuito.getContentPane().add(btnAsignar);

		btnAsignar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idPilotoStr = textField_PilotoPM.getText();
				String idMotoStr = textField_MotoPM.getText();
				LocalDate selectedDate = datePickerPM.getDate();

				// Validar campos vacíos
				if (idPilotoStr.length() == 0 || !idPilotoStr.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoAsignar1"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (idMotoStr.length() == 0 || !idMotoStr.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoAsignar2"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (selectedDate == null) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoAsignar3"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				int idPiloto = Integer.parseInt(idPilotoStr);
				int idMoto = Integer.parseInt(idMotoStr);
				Date fecha = Date.valueOf(selectedDate);

				// Validar existencia de piloto y moto
				Piloto piloto = daoPiloto.seleccionarPilotoConId(idPiloto);
				if (piloto == null) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoAsignar4"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				Moto moto = daoMoto.seleccionarMotoConId(idMoto);
				if (moto == null) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoAsignar5"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					PilotoMoto pm = new PilotoMoto(piloto, moto, fecha);
					daoPilotoMoto.insertar(pm);

					// Actualizar tabla
					modelPilotoMoto.setRowCount(0);
					DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

					for (PilotoMoto participacion : daoPilotoMoto.seleccionarTodas()) {
						Object[] row = new Object[4];
						row[0] = participacion.getId();
						row[1] = participacion.getPiloto().getId();
						row[2] = participacion.getMoto().getId();
						row[3] = participacion.getFecha().toLocalDate().format(formatoEuropeo);
						modelPilotoMoto.addRow(row);
					}

					// Limpia textField y la fecha
					textField_IdPM.setText("");
					textField_PilotoPM.setText("");
					textField_MotoPM.setText("");
					datePickerPM.clear();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoCatchAsignar"), "Error",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});

		// Boton Actualizar fecha (hace funcion de actualizar pero solo para la fecha
		// porque no tiene logica hacerlo para "piloto" o "moto")
		JButton btnActualizarFecha = new JButton(msgs.getString("button.actualizarFecha"));
		btnActualizarFecha.setBackground(new Color(221, 183, 68));
		btnActualizarFecha.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnActualizarFecha.setBounds(1277, 461, 200, 40);
		frmCircuito.getContentPane().add(btnActualizarFecha);

		btnActualizarFecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idParticipacionStr = textField_IdPM.getText();

				// Validar ID vacío o incorrecto
				if (idParticipacionStr.length() == 0) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoActualizar1"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				int idParticipacion = Integer.parseInt(idParticipacionStr);

				// Validar fecha
				LocalDate nuevaFechaLocal = datePickerPM.getDate();
				if (nuevaFechaLocal == null) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoActualizar2"), "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					Date nuevaFecha = Date.valueOf(nuevaFechaLocal);
					daoPilotoMoto.actualizarFecha(idParticipacion, nuevaFecha);

					// Actualizar tabla
					modelPilotoMoto.setRowCount(0);
					DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

					for (PilotoMoto participacion : daoPilotoMoto.seleccionarTodas()) {
						Object[] row = new Object[4];
						row[0] = participacion.getId();
						row[1] = participacion.getPiloto().getId();
						row[2] = participacion.getMoto().getId();
						row[3] = participacion.getFecha().toLocalDate().format(formatoEuropeo);
						modelPilotoMoto.addRow(row);
					}

					// Limpia textField y la fecha
					textField_IdPM.setText("");
					textField_PilotoPM.setText("");
					textField_MotoPM.setText("");
					datePickerPM.clear();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoCatchActualizar"), "Error",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});

		JButton btnBorrarPM = new JButton(msgs.getString("button.borrar"));
		btnBorrarPM.setBackground(new Color(160, 33, 33));
		btnBorrarPM.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBorrarPM.setBounds(1277, 512, 200, 40);
		frmCircuito.getContentPane().add(btnBorrarPM);

		// Boton borrar
		btnBorrarPM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int idParticipacion = Integer.parseInt(textField_IdPM.getText());
					String idStr = textField_IdPiloto.getText();

					// Validar ID vacío o incorrecto
					if (idStr.length() == 0) {
						JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoBorrar1"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					daoPilotoMoto.eliminarPorId(idParticipacion);

					// Actualiza la tabla
					modelPilotoMoto.setRowCount(0);
					DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

					for (PilotoMoto participacion : daoPilotoMoto.seleccionarTodas()) {
						Object[] row = new Object[4];
						row[0] = participacion.getId();
						row[1] = participacion.getPiloto().getId();
						row[2] = participacion.getMoto().getId();
						row[3] = participacion.getFecha().toLocalDate().format(formatoEuropeo);
						modelPilotoMoto.addRow(row);
					}

					// Limpia textField y la fecha
					textField_IdPM.setText("");
					textField_PilotoPM.setText("");
					textField_MotoPM.setText("");
					datePickerPM.clear();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoCatchBorrar"));
				}
			}
		});

		// Boton filtrar por piloto, es una operacion especifica
		JButton btnFiltrarPorPiloto = new JButton(msgs.getString("button.filtrarPiloto"));
		btnFiltrarPorPiloto.setBackground(new Color(0, 128, 192));
		btnFiltrarPorPiloto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnFiltrarPorPiloto.setBounds(983, 407, 200, 40);
		frmCircuito.getContentPane().add(btnFiltrarPorPiloto);

		btnFiltrarPorPiloto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String idPilotoStr = textField_PilotoPM.getText();

					// Coomprueba si esta vacio o si el texto no es un numero
					if (idPilotoStr.length() == 0 || !idPilotoStr.matches("\\d+")) {
						JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoFiltrarPiloto1"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					int idPiloto = Integer.parseInt(idPilotoStr);

					// Verifica si el piloto con ese ID existe
					Piloto piloto = daoPiloto.seleccionarPilotoConId(idPiloto);
					if (piloto == null) {
						JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoFiltrarPiloto2"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Actualiza la tabla
					modelPilotoMoto.setRowCount(0); // Limpia la tabla
					DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

					// Verifica si no hay participaciones para el piloto
					if (daoPilotoMoto.buscarPorPiloto(idPiloto).isEmpty()) {
						JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoFiltrarPiloto3"));
					}

					for (PilotoMoto participacion : daoPilotoMoto.buscarPorPiloto(idPiloto)) {
						Object[] row = new Object[4];
						row[0] = participacion.getId();
						row[1] = participacion.getPiloto().getId();
						row[2] = participacion.getMoto().getId();
						row[3] = participacion.getFecha().toLocalDate().format(formatoEuropeo);

						modelPilotoMoto.addRow(row);
					}

					// Limpia textField y la fecha
					textField_IdPM.setText("");
					textField_PilotoPM.setText("");
					textField_MotoPM.setText("");
					datePickerPM.clear();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoCatchFiltrarPiloto"), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// Boton filtrar por moto, es una operacion especifica
		JButton btnFiltrarPorMoto = new JButton(msgs.getString("button.filtrarMoto"));
		btnFiltrarPorMoto.setBackground(new Color(0, 128, 192));
		btnFiltrarPorMoto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnFiltrarPorMoto.setBounds(983, 461, 200, 40);
		frmCircuito.getContentPane().add(btnFiltrarPorMoto);

		btnFiltrarPorMoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String idMotoStr = textField_MotoPM.getText();

					// Coomprueba si esta vacio o si el texto no es un numero
					if (idMotoStr.length() == 0 || !idMotoStr.matches("\\d+")) {
						JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoFiltrarMoto1"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					int idMoto = Integer.parseInt(idMotoStr);

					// Verifica si la moto con ese ID existe
					Moto moto = daoMoto.seleccionarMotoConId(idMoto);
					if (moto == null) {
						JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoFiltrarMoto2"), "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Actualiza la tabla
					modelPilotoMoto.setRowCount(0); // Limpiar la tabla
					DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

					// Verifica si no hay participaciones para la moto
					if (daoPilotoMoto.buscarPorMoto(idMoto).isEmpty()) {
						JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoFiltrarMoto3"));
					}

					for (PilotoMoto participacion : daoPilotoMoto.buscarPorMoto(idMoto)) {
						Object[] row = new Object[4];
						row[0] = participacion.getId();
						row[1] = participacion.getPiloto().getId();
						row[2] = participacion.getMoto().getId();
						row[3] = participacion.getFecha().toLocalDate().format(formatoEuropeo);

						modelPilotoMoto.addRow(row);
					}

					// Limpia textField y la fecha
					textField_IdPM.setText("");
					textField_PilotoPM.setText("");
					textField_MotoPM.setText("");
					datePickerPM.clear();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoCatchFiltrarMoto"), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// Boton Mostrar todas, sirve para cuando has filtrado por moto o por piloto y
		// en la tabla solo muestre esa operacion especifica pues pulsando a este boton
		// te vuelve a mostrar todos los datos de la tabla
		JButton btnMostrarTodas = new JButton(msgs.getString("button.mostrarTodas"));
		btnMostrarTodas.setBackground(new Color(166, 0, 166));
		btnMostrarTodas.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMostrarTodas.setBounds(983, 512, 200, 40);
		frmCircuito.getContentPane().add(btnMostrarTodas);
		btnMostrarTodas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// Actualizar tabla
					modelPilotoMoto.setRowCount(0);
					DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

					for (PilotoMoto participacion : daoPilotoMoto.seleccionarTodas()) {
						Object[] row = new Object[4];
						row[0] = participacion.getId();
						row[1] = participacion.getPiloto().getId();
						row[2] = participacion.getMoto().getId();
						row[3] = participacion.getFecha().toLocalDate().format(formatoEuropeo);
						modelPilotoMoto.addRow(row);
					}

					// Limpia textField y la fecha
					textField_IdPM.setText("");
					textField_PilotoPM.setText("");
					textField_MotoPM.setText("");
					datePickerPM.clear();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, msgs.getString("error.PilotoMotoCatchMostrarTodas"), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		frmCircuito.getContentPane().setLayout(null);

		JButton btnEspañol = new JButton("Español");
		btnEspañol.setBounds(716, 37, 100, 30);
		frmCircuito.getContentPane().add(btnEspañol);

		JButton btnIngles = new JButton("English");
		btnIngles.setBounds(813, 37, 100, 30);
		frmCircuito.getContentPane().add(btnIngles);

		// BOTÓN ESPAÑOL
		btnEspañol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cambiar texto de etiquetas, botones, etc.

				msgs = ResourceBundle.getBundle("MessagesBundle", Locale.forLanguageTag("es-ES"));

				frmCircuito.setTitle(msgs.getString("title"));
				lblIdioma.setText(msgs.getString("label.idioma"));
				btnGuardarMoto.setText(msgs.getString("button.guardar"));
				lblId.setText(msgs.getString("label.id"));
				lblMarca.setText(msgs.getString("label.marca"));
				lblModelo.setText(msgs.getString("label.modelo"));
				lblCilindrada.setText(msgs.getString("label.cilindrada"));
				lblCaballos.setText(msgs.getString("label.caballos"));

				lblNombre.setText(msgs.getString("label.nombre"));
				lblEdad.setText(msgs.getString("label.edad"));
				lblNacionalidad.setText(msgs.getString("label.nacionalidad"));
				lblEscuderia.setText(msgs.getString("label.escuderia"));
				lblTiempoVuelta.setText(msgs.getString("label.tiempoVuelta"));

				lblPilotoPM.setText(msgs.getString("label.piloto"));
				lblMotoPM.setText(msgs.getString("label.moto"));
				lblFecha.setText(msgs.getString("label.fecha"));

				// Botones
				btnGuardarMoto.setText(msgs.getString("button.guardar"));
				btnActualizarMoto.setText(msgs.getString("button.actualizar"));
				btnBorrarMoto.setText(msgs.getString("button.borrar"));

				btnGuardarPiloto.setText(msgs.getString("button.guardar"));
				btnActualizarPiloto.setText(msgs.getString("button.actualizar"));
				btnBorrarPiloto.setText(msgs.getString("button.borrar"));

				btnAsignar.setText(msgs.getString("button.asignar"));
				btnFiltrarPorPiloto.setText(msgs.getString("button.filtrarPiloto"));
				btnFiltrarPorMoto.setText(msgs.getString("button.filtrarMoto"));
				btnMostrarTodas.setText(msgs.getString("button.mostrarTodas"));
				btnActualizarFecha.setText(msgs.getString("button.actualizarFecha"));
				btnBorrarPM.setText(msgs.getString("button.borrar"));

				// Etiquetas de las tablas
				lblTablaMoto.setText(msgs.getString("label.tablaMoto"));
				lblTablaPiloto.setText(msgs.getString("label.tablaPiloto"));
				lblTablaAsignar.setText(msgs.getString("label.tablaAsignar"));

				// Cambiar encabezados de tableMoto
				String[] columnasESMoto = { "ID", "Marca", "Modelo", "Cilindrada", "Caballos" };
				TableColumnModel cmMoto = tableMoto.getColumnModel();
				for (int i = 0; i < columnasESMoto.length; i++) {
					cmMoto.getColumn(i).setHeaderValue(columnasESMoto[i]);
				}
				tableMoto.getTableHeader().repaint();

				// Cambiar encabezados de tablePiloto
				String[] columnasESPiloto = { "ID", "Nombre", "Edad", "Nacionalidad", "Escudería", "Tiempo vuelta" };
				TableColumnModel cmPiloto = tablePiloto.getColumnModel();
				for (int i = 0; i < columnasESPiloto.length; i++) {
					cmPiloto.getColumn(i).setHeaderValue(columnasESPiloto[i]);
				}
				tablePiloto.getTableHeader().repaint();

				// Cambiar encabezados de tablePilotoMoto
				String[] columnasESPM = { "ID", "Piloto", "Moto", "Fecha" };
				TableColumnModel cmPM = tablePilotoMoto.getColumnModel();
				for (int i = 0; i < columnasESPM.length; i++) {
					cmPM.getColumn(i).setHeaderValue(columnasESPM[i]);
				}
				tablePilotoMoto.getTableHeader().repaint();
			}
		});

		// BOTÓN INGLÉS
		btnIngles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				msgs = ResourceBundle.getBundle("MessagesBundle", Locale.forLanguageTag("en-US"));

				frmCircuito.setTitle(msgs.getString("title"));
				lblIdioma.setText(msgs.getString("label.idioma"));
				btnGuardarMoto.setText(msgs.getString("button.guardar"));
				lblId.setText(msgs.getString("label.id"));
				lblMarca.setText(msgs.getString("label.marca"));
				lblModelo.setText(msgs.getString("label.modelo"));
				lblCilindrada.setText(msgs.getString("label.cilindrada"));
				lblCaballos.setText(msgs.getString("label.caballos"));

				lblNombre.setText(msgs.getString("label.nombre"));
				lblEdad.setText(msgs.getString("label.edad"));
				lblNacionalidad.setText(msgs.getString("label.nacionalidad"));
				lblEscuderia.setText(msgs.getString("label.escuderia"));
				lblTiempoVuelta.setText(msgs.getString("label.tiempoVuelta"));

				lblPilotoPM.setText(msgs.getString("label.piloto"));
				lblMotoPM.setText(msgs.getString("label.moto"));
				lblFecha.setText(msgs.getString("label.fecha"));

				// Botones
				btnGuardarMoto.setText(msgs.getString("button.guardar"));
				btnActualizarMoto.setText(msgs.getString("button.actualizar"));
				btnBorrarMoto.setText(msgs.getString("button.borrar"));

				btnGuardarPiloto.setText(msgs.getString("button.guardar"));
				btnActualizarPiloto.setText(msgs.getString("button.actualizar"));
				btnBorrarPiloto.setText(msgs.getString("button.borrar"));

				btnAsignar.setText(msgs.getString("button.asignar"));
				btnFiltrarPorPiloto.setText(msgs.getString("button.filtrarPiloto"));
				btnFiltrarPorMoto.setText(msgs.getString("button.filtrarMoto"));
				btnMostrarTodas.setText(msgs.getString("button.mostrarTodas"));
				btnActualizarFecha.setText(msgs.getString("button.actualizarFecha"));
				btnBorrarPM.setText(msgs.getString("button.borrar"));

				// Etiquetas de las tablas
				lblTablaMoto.setText(msgs.getString("label.tablaMoto"));
				lblTablaPiloto.setText(msgs.getString("label.tablaPiloto"));
				lblTablaAsignar.setText(msgs.getString("label.tablaAsignar"));

				String[] columnasENMoto = { "ID", "Brand", "Model", "Displacement", "Horsepower" };
				TableColumnModel cmMoto = tableMoto.getColumnModel();
				for (int i = 0; i < columnasENMoto.length; i++) {
					cmMoto.getColumn(i).setHeaderValue(columnasENMoto[i]);
				}
				tableMoto.getTableHeader().repaint();

				String[] columnasENPiloto = { "ID", "Name", "Age", "Nationality", "Team", "Lap time" };
				TableColumnModel cmPiloto = tablePiloto.getColumnModel();
				for (int i = 0; i < columnasENPiloto.length; i++) {
					cmPiloto.getColumn(i).setHeaderValue(columnasENPiloto[i]);
				}
				tablePiloto.getTableHeader().repaint();

				String[] columnasENPM = { "ID", "Rider", "Bike", "Date" };
				TableColumnModel cmPM = tablePilotoMoto.getColumnModel();
				for (int i = 0; i < columnasENPM.length; i++) {
					cmPM.getColumn(i).setHeaderValue(columnasENPM[i]);
				}
				tablePilotoMoto.getTableHeader().repaint();
			}
		});
	}
}