package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Piloto;
import com.hibernate.util.HibernateUtil;

import javax.swing.*;

public class PilotoDAO {

	public void insertarPiloto(Piloto s) {
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.persist(s);
			transaction.commit();
			JOptionPane.showMessageDialog(null, "Piloto insertado");
		} catch (Exception e) {
			if (transaction!=null) {
				JOptionPane.showMessageDialog(null, "Error al insertar piloto");
				transaction.rollback();
			}
		}
	}
	
	public void actualizarPiloto(Piloto s) {
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.merge(s);
			transaction.commit();
			JOptionPane.showMessageDialog(null, "Piloto actualizado");
		} catch (Exception e) {
			if (transaction!=null) {
				JOptionPane.showMessageDialog(null, "Error al actualizar piloto");
				transaction.rollback();
			}
		}
	}
	
	public void eliminarPiloto(int id) {
		Transaction transaction=null;
		Piloto s=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			s=session.get(Piloto.class, id);
			session.remove(s);
			transaction.commit();
			JOptionPane.showMessageDialog(null, "Piloto borrado");
		} catch (Exception e) {
			if (transaction!=null) {
				JOptionPane.showMessageDialog(null, "Error al borrar piloto");
				transaction.rollback();
			}
		}
	}
	
	public Piloto seleccionarPilotoConId(int id) {
		Transaction transaction=null;
		Piloto s=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			s=session.get(Piloto.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				JOptionPane.showMessageDialog(null, "Error al seleccionar piloto");
				transaction.rollback();
			}
		}
		return s;
	}
	
	public List<Piloto> seleccionarTodosLosPilotos() {
		Transaction transaction=null;
		List<Piloto> piloto=null;
		Piloto s=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			piloto=session.createQuery("from Piloto",Piloto.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
					JOptionPane.showMessageDialog(null, "Error al seleccionar piloto");
					transaction.rollback();
			}
		}
		return piloto;
	}
}
