package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Moto;
import com.hibernate.util.HibernateUtil;

import javax.swing.*;

public class MotoDAO {

	public void insertarMoto(Moto s) {
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.persist(s);
			transaction.commit();
			JOptionPane.showMessageDialog(null, "Moto insertada");
		} catch (Exception e) {
			if (transaction!=null) {
				JOptionPane.showMessageDialog(null, "Error al insertar moto");
				transaction.rollback();
			}
		}
	}
	
	public void actualizarMoto(Moto s) {
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.merge(s);
			transaction.commit();
			JOptionPane.showMessageDialog(null, "Moto actualizada");
		} catch (Exception e) {
			if (transaction!=null) {
				JOptionPane.showMessageDialog(null, "Error al actualizar moto");
				transaction.rollback();
			}
		}
	}
	
	public void eliminarMoto(int id) {
		Transaction transaction=null;
		Moto s=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			s=session.get(Moto.class, id);
			session.remove(s);
			transaction.commit();
			JOptionPane.showMessageDialog(null, "Moto borrada");
		} catch (Exception e) {
			if (transaction!=null) {
				JOptionPane.showMessageDialog(null, "Error al borrar moto");
				transaction.rollback();
			}
		}
	}
	
	public Moto seleccionarMotoConId(int id) {
		Transaction transaction=null;
		Moto s=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			s=session.get(Moto.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				JOptionPane.showMessageDialog(null, "Error al seleccionar moto");
				transaction.rollback();
			}
		}
		return s;
	}
	
	public List<Moto> seleccionarTodasLasMotos() {
		Transaction transaction=null;
		List<Moto> moto=null;
		Moto s=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			moto=session.createQuery("from Moto",Moto.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
					JOptionPane.showMessageDialog(null, "Error al seleccionar motos");
					transaction.rollback();
			}
		}
		return moto;
	}
}
