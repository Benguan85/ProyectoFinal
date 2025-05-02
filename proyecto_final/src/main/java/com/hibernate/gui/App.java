package com.hibernate.gui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
import javax.swing.table.DefaultTableCellRenderer;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.time.format.DateTimeFormatter;
import java.awt.Font;


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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		MotoDAO daoMoto=new MotoDAO();
		List<Moto> listMoto=null;
		
		PilotoDAO daoPiloto=new PilotoDAO();
		List<Piloto> listPiloto=null;
		
		PilotoMotoDAO daoPilotoMoto = new PilotoMotoDAO();
		List<PilotoMoto> listPilotoMoto = null;
		
		frmCircuito = new JFrame();
		frmCircuito.getContentPane().setBackground(new Color(192, 192, 192));
		frmCircuito.setTitle("Circuito");
		frmCircuito.setBounds(100, 100, 1600, 900);
		frmCircuito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCircuito.getContentPane().setLayout(null);
		
		
		textField_IdMoto = new JTextField();
		textField_IdMoto.setEditable(false);
		textField_IdMoto.setBounds(52, 366, 59, 19);
		frmCircuito.getContentPane().add(textField_IdMoto);
		textField_IdMoto.setColumns(10);
		
		textField_Marca = new JTextField();
		textField_Marca.setBounds(137, 366, 114, 19);
		frmCircuito.getContentPane().add(textField_Marca);
		textField_Marca.setColumns(10);
		
		textField_Modelo = new JTextField();
		textField_Modelo.setBounds(277, 366, 114, 19);
		frmCircuito.getContentPane().add(textField_Modelo);
		textField_Modelo.setColumns(10);
		
		textField_Cilindrada = new JTextField();
		textField_Cilindrada.setBounds(418, 366, 114, 19);
		frmCircuito.getContentPane().add(textField_Cilindrada);
		textField_Cilindrada.setColumns(10);
		
		textField_Caballos = new JTextField();
		textField_Caballos.setBounds(556, 366, 114, 19);
		frmCircuito.getContentPane().add(textField_Caballos);
		textField_Caballos.setColumns(10);
		
		textField_IdPiloto = new JTextField();
		textField_IdPiloto.setEditable(false);
		textField_IdPiloto.setBounds(10, 758, 59, 19);
		frmCircuito.getContentPane().add(textField_IdPiloto);
		textField_IdPiloto.setColumns(10);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(79, 758, 114, 19);
		frmCircuito.getContentPane().add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		textField_Edad = new JTextField();
		textField_Edad.setBounds(203, 758, 59, 19);
		frmCircuito.getContentPane().add(textField_Edad);
		textField_Edad.setColumns(10);
		
		textField_Nacionalidad = new JTextField();
		textField_Nacionalidad.setBounds(272, 758, 150, 19);
		frmCircuito.getContentPane().add(textField_Nacionalidad);
		textField_Nacionalidad.setColumns(10);
		
		textField_Escuderia = new JTextField();
		textField_Escuderia.setBounds(432, 758, 114, 19);
		frmCircuito.getContentPane().add(textField_Escuderia);
		textField_Escuderia.setColumns(10);
		
		textField_TiempoVuelta = new JTextField();
		textField_TiempoVuelta.setBounds(556, 758, 150, 19);
		frmCircuito.getContentPane().add(textField_TiempoVuelta);
		textField_TiempoVuelta.setColumns(10);

		textField_PilotoPM = new JTextField();
		textField_PilotoPM.setBounds(946, 366, 59, 20);
		frmCircuito.getContentPane().add(textField_PilotoPM);
		textField_PilotoPM.setColumns(10);
		
		textField_MotoPM = new JTextField();
		textField_MotoPM.setBounds(1028, 366, 86, 20);
		frmCircuito.getContentPane().add(textField_MotoPM);
		textField_MotoPM.setColumns(10);
		
		DatePickerSettings settings = new DatePickerSettings();
		settings.setFormatForDatesCommonEra("dd/MM/yyyy"); // formato europeo

		DatePicker datePickerPM = new DatePicker(settings);
		datePickerPM.setBounds(1000, 400, 150, 25);
		frmCircuito.getContentPane().add(datePickerPM);


		
		DefaultTableModel modelMoto = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		modelMoto.addColumn("ID");
		modelMoto.addColumn("Marca");
		modelMoto.addColumn("Modelo");
		modelMoto.addColumn("Cilindrada");
		modelMoto.addColumn("Caballos");
		
		listMoto=daoMoto.seleccionarTodasLasMotos();
		
		for (int i=0;i<listMoto.size();i++) {
			Object[] row=new Object[5];
			row[0]=listMoto.get(i).getId();
			row[1]=listMoto.get(i).getMarca();
			row[2]=listMoto.get(i).getModelo();
			row[3]=listMoto.get(i).getCilindrada();
			row[4]=listMoto.get(i).getCaballos();

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

		JScrollPane scrollPaneMoto = new JScrollPane();
		scrollPaneMoto.setBounds(10, 44, 696, 285);
		frmCircuito.getContentPane().add(scrollPaneMoto);
		
		scrollPaneMoto.setViewportView(tableMoto);
		
		DefaultTableModel modelPiloto = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		modelPiloto.addColumn("ID");
		modelPiloto.addColumn("Nombre");
		modelPiloto.addColumn("Edad");
		modelPiloto.addColumn("Nacionalidad");
		modelPiloto.addColumn("Escuderia");
		modelPiloto.addColumn("Tiempo vuelta");
		
		listPiloto=daoPiloto.seleccionarTodosLosPilotos();
		
		for (int i=0;i<listPiloto.size();i++) {
			Object[] row=new Object[6];
			row[0]=listPiloto.get(i).getId();
			row[1]=listPiloto.get(i).getNombre();
			row[2]=listPiloto.get(i).getEdad();
			row[3]=listPiloto.get(i).getNacionalidad();
			row[4]=listPiloto.get(i).getEscuderia();
			row[5]=listPiloto.get(i).getTiempo_vuelta();

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

		JScrollPane scrollPanePiloto = new JScrollPane();
		scrollPanePiloto.setBounds(10, 442, 696, 285);
		frmCircuito.getContentPane().add(scrollPanePiloto);
		
		scrollPanePiloto.setViewportView(tablePiloto);
		
		DefaultTableModel modelPilotoMoto = new DefaultTableModel() {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};

		modelPilotoMoto.addColumn("ID");
		modelPilotoMoto.addColumn("Piloto");
		modelPilotoMoto.addColumn("Moto");
		modelPilotoMoto.addColumn("Fecha");

		PilotoMotoDAO daoPM = new PilotoMotoDAO();

		List<PilotoMoto> participaciones = daoPM.seleccionarTodas();
		DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		for (int i = 0; i < participaciones.size(); i++) {
		    Object[] row = new Object[4];
		    row[0] = participaciones.get(i).getId();
		    row[1] = participaciones.get(i).getPiloto().getId();
		    row[2] = participaciones.get(i).getMoto().getId();
		    row[3] = participaciones.get(i).getFecha().toLocalDate().format(formatoEuropeo);

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
		JScrollPane scrollPanePilotoMoto = new JScrollPane(tablePilotoMoto);
		scrollPanePilotoMoto.setBounds(869, 44, 614, 285);
		frmCircuito.getContentPane().add(scrollPanePilotoMoto);


		
		DefaultTableCellRenderer tiempoRenderer = new DefaultTableCellRenderer() {
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value,
		            boolean isSelected, boolean hasFocus, int row, int column) {

		        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		        try {
		            double tiempo = Double.parseDouble(value.toString());
		            if (tiempo < 1.35) {
		                c.setBackground(Color.RED);
		            } else {
		                c.setBackground(Color.GREEN);
		            }
		        } catch (NumberFormatException ex) {
		            c.setBackground(Color.WHITE);
		        }

		        return c;
		    }
		};


		tablePiloto.getColumnModel().getColumn(5).setCellRenderer(tiempoRenderer);

		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		for (int i = 0; i < tableMoto.getColumnCount(); i++) {
		    tableMoto.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		for (int i = 0; i < tablePiloto.getColumnCount(); i++) {
		    if (i == 5) {
		        tablePiloto.getColumnModel().getColumn(i).setCellRenderer(tiempoRenderer); // ✔ color en columna "tiempo vuelta"
		    } else {
		        tablePiloto.getColumnModel().getColumn(i).setCellRenderer(centerRenderer); // ✔ centrado
		    }
		}

		
		JButton btnGuardarMoto = new JButton("Guardar");
		btnGuardarMoto.setBackground(new Color(69, 153, 60));
		btnGuardarMoto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGuardarMoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String marca;
				String modelo;
				int cilindrada;
				int caballos;
				
				marca=textField_Marca.getText();
				modelo=textField_Modelo.getText();
				cilindrada=Integer.parseInt(textField_Cilindrada.getText());
				caballos=Integer.parseInt(textField_Caballos.getText());
				
				Moto s=new Moto(marca,modelo,cilindrada,caballos);
				daoMoto.insertarMoto(s);
				
				modelMoto.setRowCount(0);
				for(Moto m:daoMoto.seleccionarTodasLasMotos()) {
					Object[] row=new Object[5];
					row[0]=m.getId();
					row[1]=m.getMarca();
					row[2]=m.getModelo();
					row[3]=m.getCilindrada();
					row[4]=m.getCaballos();

					modelMoto.addRow(row);
				}
			}
		});
		btnGuardarMoto.setBounds(716, 129, 145, 40);
		frmCircuito.getContentPane().add(btnGuardarMoto);		
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(52, 340, 59, 15);
		frmCircuito.getContentPane().add(lblId);
		
		JLabel lblMarca = new JLabel("MARCA");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setBounds(138, 340, 113, 15);
		frmCircuito.getContentPane().add(lblMarca);
		
		JLabel lblModelo = new JLabel("MODELO");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setBounds(277, 340, 114, 15);
		frmCircuito.getContentPane().add(lblModelo);
		
		JLabel lblCilindrada = new JLabel("CILINDRADA");
		lblCilindrada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCilindrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblCilindrada.setBounds(418, 340, 114, 15);
		frmCircuito.getContentPane().add(lblCilindrada);
		
		JLabel lblCaballos = new JLabel("CABALLOS");
		lblCaballos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCaballos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaballos.setBounds(556, 340, 114, 15);
		frmCircuito.getContentPane().add(lblCaballos);
		

		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblId_1.setBounds(10, 738, 59, 15);
		frmCircuito.getContentPane().add(lblId_1);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(79, 738, 114, 15);
		frmCircuito.getContentPane().add(lblNombre);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setBounds(203, 738, 59, 15);
		frmCircuito.getContentPane().add(lblEdad);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		lblNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNacionalidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblNacionalidad.setBounds(272, 738, 150, 15);
		frmCircuito.getContentPane().add(lblNacionalidad);
		
		JLabel lblEscuderia = new JLabel("ESCUDERIA");
		lblEscuderia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEscuderia.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscuderia.setBounds(432, 738, 114, 15);
		frmCircuito.getContentPane().add(lblEscuderia);
		
		JLabel lblTiempoVuelta = new JLabel("TIEMPO VUELTA");
		lblTiempoVuelta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTiempoVuelta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoVuelta.setBounds(556, 738, 150, 15);
		frmCircuito.getContentPane().add(lblTiempoVuelta);
		
		JButton btnGuardarPiloto = new JButton("Guardar");
		btnGuardarPiloto.setBackground(new Color(69, 153, 60));
		btnGuardarPiloto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGuardarPiloto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre;
				int edad;
				String nacionalidad;				
				String escuderia;
				double tiempo_vuelta;
				
				nombre=textField_Nombre.getText();
				edad=Integer.parseInt(textField_Edad.getText());
				nacionalidad=textField_Nacionalidad.getText();
				escuderia=textField_Escuderia.getText();
				tiempo_vuelta=Double.parseDouble(textField_TiempoVuelta.getText());
				
				Piloto s=new Piloto(nombre,edad,nacionalidad,escuderia,tiempo_vuelta);
				daoPiloto.insertarPiloto(s);
				
				modelPiloto.setRowCount(0);
				for(Piloto p:daoPiloto.seleccionarTodosLosPilotos()) {
					Object[] row=new Object[6];
					row[0]=p.getId();
					row[1]=p.getNombre();
					row[2]=p.getEdad();
					row[3]=p.getNacionalidad();
					row[4]=p.getEscuderia();
					row[5]=p.getTiempo_vuelta();

					modelPiloto.addRow(row);
				}
			}
		});
		btnGuardarPiloto.setBounds(716, 512, 145, 40);
		frmCircuito.getContentPane().add(btnGuardarPiloto);
		
		JButton btnActualizarMoto = new JButton("Actualizar");
		btnActualizarMoto.setBackground(new Color(221, 183, 68));
		btnActualizarMoto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnActualizarMoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    try {
			        int id = Integer.parseInt(textField_IdMoto.getText());
			        String marca = textField_Marca.getText();
			        String modelo = textField_Modelo.getText();
			        int cilindrada = Integer.parseInt(textField_Cilindrada.getText());
			        int caballos = Integer.parseInt(textField_Caballos.getText());

			        Moto m = new Moto(marca, modelo, cilindrada, caballos);
			        m.setId(id);

			        daoMoto.actualizarMoto(m);

			        modelMoto.setRowCount(0);
			        for (Moto moto : daoMoto.seleccionarTodasLasMotos()) {
			            Object[] row = { moto.getId(), moto.getMarca(), moto.getModelo(), moto.getCilindrada(), moto.getCaballos() };
			            modelMoto.addRow(row);
			        }
			    } catch (Exception ex) {
			        JOptionPane.showMessageDialog(null, "Error al actualizar la moto");
			    }
			}
		});
		btnActualizarMoto.setBounds(716, 180, 145, 40);
		frmCircuito.getContentPane().add(btnActualizarMoto);
		
		JButton btnActualizarPiloto = new JButton("Actualizar");
		btnActualizarPiloto.setBackground(new Color(221, 183, 68));
		btnActualizarPiloto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnActualizarPiloto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    try {
			        int id = Integer.parseInt(textField_IdPiloto.getText());
			        String nombre = textField_Nombre.getText();
			        int edad = Integer.parseInt(textField_Edad.getText());
			        String nacionalidad = textField_Nacionalidad.getText();
			        String escuderia = textField_Escuderia.getText();
			        double tiempo = Double.parseDouble(textField_TiempoVuelta.getText());

			        Piloto p = new Piloto(nombre, edad, nacionalidad, escuderia, tiempo);
			        p.setId(id);

			        daoPiloto.actualizarPiloto(p);

			        modelPiloto.setRowCount(0);
			        for (Piloto piloto : daoPiloto.seleccionarTodosLosPilotos()) {
			            Object[] row = {
			                piloto.getId(), piloto.getNombre(), piloto.getEdad(),
			                piloto.getNacionalidad(), piloto.getEscuderia(), piloto.getTiempo_vuelta()
			            };
			            modelPiloto.addRow(row);
			        }
			    } catch (Exception ex) {
			        JOptionPane.showMessageDialog(null, "Error al actualizar el piloto");
			    }
			}
		});
		btnActualizarPiloto.setBounds(716, 563, 145, 40);
		frmCircuito.getContentPane().add(btnActualizarPiloto);
		
		JButton btnBorrarMoto = new JButton("Borrar");
		btnBorrarMoto.setBackground(new Color(160, 33, 33));
		btnBorrarMoto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBorrarMoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    try {
			        int id = Integer.parseInt(textField_IdMoto.getText());
			        daoMoto.eliminarMoto(id);

			        modelMoto.setRowCount(0);
			        for (Moto moto : daoMoto.seleccionarTodasLasMotos()) {
			            Object[] row = { moto.getId(), moto.getMarca(), moto.getModelo(), moto.getCilindrada(), moto.getCaballos() };
			            modelMoto.addRow(row);
			        }

			        textField_IdMoto.setText("");
			        textField_Marca.setText("");
			        textField_Modelo.setText("");
			        textField_Cilindrada.setText("");
			        textField_Caballos.setText("");
			    } catch (Exception ex) {
			        JOptionPane.showMessageDialog(null, "Error al borrar la moto");
			    }
			}
		});
		btnBorrarMoto.setBounds(716, 231, 145, 40);
		frmCircuito.getContentPane().add(btnBorrarMoto);
		
		JButton btnBorrarPiloto = new JButton("Borrar");
		btnBorrarPiloto.setBackground(new Color(160, 33, 33));
		btnBorrarPiloto.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBorrarPiloto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    try {
			        int id = Integer.parseInt(textField_IdPiloto.getText());
			        daoPiloto.eliminarPiloto(id);

			        modelPiloto.setRowCount(0);
			        for (Piloto piloto : daoPiloto.seleccionarTodosLosPilotos()) {
			            Object[] row = {
			                piloto.getId(), piloto.getNombre(), piloto.getEdad(),
			                piloto.getNacionalidad(), piloto.getEscuderia(), piloto.getTiempo_vuelta()
			            };
			            modelPiloto.addRow(row);
			        }

			        textField_IdPiloto.setText("");
			        textField_Nombre.setText("");
			        textField_Edad.setText("");
			        textField_Nacionalidad.setText("");
			        textField_Escuderia.setText("");
			        textField_TiempoVuelta.setText("");
			    } catch (Exception ex) {
			        JOptionPane.showMessageDialog(null, "Error al borrar el piloto");
			    }
			}
		});
		btnBorrarPiloto.setBounds(716, 614, 145, 40);
		frmCircuito.getContentPane().add(btnBorrarPiloto);
		
		
		
		//yeeeeeeeeeeeeeeee
		
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.setBounds(1287, 501, 100, 25);
		frmCircuito.getContentPane().add(btnAsignar);

		btnAsignar.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            int idPiloto = Integer.parseInt(textField_PilotoPM.getText());
		            int idMoto = Integer.parseInt(textField_MotoPM.getText());
		            LocalDate selectedDate = datePickerPM.getDate();

		            if (selectedDate == null) {
		                JOptionPane.showMessageDialog(null, "Selecciona una fecha válida.");
		                return;
		            }

		            Date fecha = Date.valueOf(selectedDate);

		            Piloto piloto = daoPiloto.seleccionarPilotoConId(idPiloto);
		            Moto moto = daoMoto.seleccionarMotoConId(idMoto);

		            if (piloto == null || moto == null) {
		                JOptionPane.showMessageDialog(null, "Piloto o Moto no encontrados");
		                return;
		            }

		            PilotoMoto pm = new PilotoMoto(piloto, moto, fecha);
		            daoPM.insertar(pm);

		            // Actualizar tabla
		            modelPilotoMoto.setRowCount(0);
		            List<PilotoMoto> participaciones = daoPM.seleccionarTodas();
		            DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		            for (int i = 0; i < participaciones.size(); i++) {
		                Object[] row = new Object[4];
		                row[0] = participaciones.get(i).getId();
		                row[1] = participaciones.get(i).getPiloto().getId();
		                row[2] = participaciones.get(i).getMoto().getId();
		                row[3] = participaciones.get(i).getFecha().toLocalDate().format(formatoEuropeo);
		                modelPilotoMoto.addRow(row);
		            }

		            // ✅ Limpiar campos
		            textField_IdPM.setText("");
		            textField_PilotoPM.setText("");
		            textField_MotoPM.setText("");
		            datePickerPM.clear();

		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al asignar piloto a moto");
		            ex.printStackTrace();
		        }
		    }
		});


		
		JButton btnFiltrarPorPiloto = new JButton("Filtrar por piloto");
		btnFiltrarPorPiloto.setBounds(855, 473, 150, 25);
		frmCircuito.getContentPane().add(btnFiltrarPorPiloto);

		btnFiltrarPorPiloto.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            int idPiloto = Integer.parseInt(textField_PilotoPM.getText());

		            modelPilotoMoto.setRowCount(0);
		            List<PilotoMoto> participaciones = daoPM.buscarPorPiloto(idPiloto);
		            DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		            for (int i = 0; i < participaciones.size(); i++) {
		                Object[] row = new Object[4];
		                row[0] = participaciones.get(i).getId();
		                row[1] = participaciones.get(i).getPiloto().getId();
		                row[2] = participaciones.get(i).getMoto().getId();
		                row[3] = participaciones.get(i).getFecha().toLocalDate().format(formatoEuropeo);
		                modelPilotoMoto.addRow(row);
		            }

		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Introduce un ID de piloto válido.");
		        }
		    }
		});



		
		JButton btnFiltrarPorMoto = new JButton("Filtrar por moto");
		btnFiltrarPorMoto.setBounds(1017, 473, 150, 25);
		frmCircuito.getContentPane().add(btnFiltrarPorMoto);

		btnFiltrarPorMoto.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            int idMoto = Integer.parseInt(textField_MotoPM.getText());

		            modelPilotoMoto.setRowCount(0);
		            List<PilotoMoto> participaciones = daoPM.buscarPorMoto(idMoto);
		            DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		            for (int i = 0; i < participaciones.size(); i++) {
		                Object[] row = new Object[4];
		                row[0] = participaciones.get(i).getId();
		                row[1] = participaciones.get(i).getPiloto().getId();
		                row[2] = participaciones.get(i).getMoto().getId();
		                row[3] = participaciones.get(i).getFecha().toLocalDate().format(formatoEuropeo);
		                modelPilotoMoto.addRow(row);
		            }

		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Introduce un ID de moto válido.");
		        }
		    }
		});




		
		JButton btnBorrarPM = new JButton("Borrar");
		btnBorrarPM.setBounds(1237, 438, 170, 25);
		frmCircuito.getContentPane().add(btnBorrarPM);

		btnBorrarPM.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            int idParticipacion = Integer.parseInt(textField_IdPM.getText());

		            daoPM.eliminarPorId(idParticipacion);

		            // Refrescar tabla
		            modelPilotoMoto.setRowCount(0);
		            List<PilotoMoto> participaciones = daoPM.seleccionarTodas();
		            DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		            for (PilotoMoto pm : participaciones) {
		                Object[] row = new Object[4];
		                row[0] = pm.getId();
		                row[1] = pm.getPiloto().getId();
		                row[2] = pm.getMoto().getId();
		                row[3] = pm.getFecha().toLocalDate().format(formatoEuropeo);
		                modelPilotoMoto.addRow(row);
		            }

		            // Limpiar campos
		            textField_IdPM.setText("");
		            textField_PilotoPM.setText("");
		            textField_MotoPM.setText("");
		            datePickerPM.clear();

		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Introduce un ID válido.");
		        }
		    }
		});




		
		JLabel lblPilotoPM = new JLabel("PILOTO");
		lblPilotoPM.setBounds(946, 340, 46, 14);
		frmCircuito.getContentPane().add(lblPilotoPM);
		
		JLabel lblMotoPM = new JLabel("MOTO");
		lblMotoPM.setBounds(1043, 341, 46, 14);
		frmCircuito.getContentPane().add(lblMotoPM);
		
		JLabel lblNewLabel_2 = new JLabel("TABLA MOTO");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(10, 11, 696, 35);
		frmCircuito.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TABLA PILOTO");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3.setBounds(10, 407, 696, 32);
		frmCircuito.getContentPane().add(lblNewLabel_3);
		
		JLabel lblId_2 = new JLabel("ID");
		lblId_2.setBounds(869, 341, 59, 14);
		frmCircuito.getContentPane().add(lblId_2);
		
		textField_IdPM = new JTextField();
		textField_IdPM.setEditable(false);
		textField_IdPM.setBounds(869, 366, 59, 20);
		frmCircuito.getContentPane().add(textField_IdPM);
		textField_IdPM.setColumns(10);
		
		JButton btnMostrarTodas = new JButton("Mostrar todas");
		btnMostrarTodas.setBounds(1237, 407, 150, 25);
		frmCircuito.getContentPane().add(btnMostrarTodas);
		btnMostrarTodas.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        modelPilotoMoto.setRowCount(0); // Limpiar tabla
		        List<PilotoMoto> participaciones = daoPM.seleccionarTodas();
		        DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		        for (int i = 0; i < participaciones.size(); i++) {
		            Object[] row = new Object[4];
		            row[0] = participaciones.get(i).getId();
		            row[1] = participaciones.get(i).getPiloto().getId();
		            row[2] = participaciones.get(i).getMoto().getId();
		            row[3] = participaciones.get(i).getFecha().toLocalDate().format(formatoEuropeo);
		            modelPilotoMoto.addRow(row);
		        }

		        // ✅ Limpiar campos
	            textField_IdPM.setText("");
		        textField_PilotoPM.setText("");
		        textField_MotoPM.setText("");
		        datePickerPM.clear();
		    }
		});

		JButton btnActualizarFecha = new JButton("Actualizar fecha");
		btnActualizarFecha.setBounds(1424, 473, 150, 25);
		frmCircuito.getContentPane().add(btnActualizarFecha);

		btnActualizarFecha.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            int idParticipacion = Integer.parseInt(textField_IdPM.getText());

		            LocalDate nuevaFechaLocal = datePickerPM.getDate();
		            if (nuevaFechaLocal == null) {
		                JOptionPane.showMessageDialog(null, "Selecciona una nueva fecha.");
		                return;
		            }

		            Date nuevaFecha = Date.valueOf(nuevaFechaLocal);

		            daoPM.actualizarFecha(idParticipacion, nuevaFecha);

		            // Refrescar tabla
		            modelPilotoMoto.setRowCount(0);
		            List<PilotoMoto> participaciones = daoPM.seleccionarTodas();
		            DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		            for (PilotoMoto pm : participaciones) {
		                Object[] row = new Object[4];
		                row[0] = pm.getId();
		                row[1] = pm.getPiloto().getId();
		                row[2] = pm.getMoto().getId();
		                row[3] = pm.getFecha().toLocalDate().format(formatoEuropeo);
		                modelPilotoMoto.addRow(row);
		            }

		            // Limpiar campos
		            textField_IdPM.setText("");
		            textField_PilotoPM.setText("");
		            textField_MotoPM.setText("");
		            datePickerPM.clear();

		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Introduce un ID válido.");
		        }
		    }
		});


		
		
	}
}
