package com.hibernate.dao;

import com.hibernate.model.PilotoMoto;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;

import java.sql.Date;
import java.util.List;

public class PilotoMotoDAO {

    public void insertar(PilotoMoto pm) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(pm);
            transaction.commit();
            JOptionPane.showMessageDialog(null, "Participación insertada");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            JOptionPane.showMessageDialog(null, "Error al insertar participación");
            e.printStackTrace();
        }
    }

    public List<PilotoMoto> seleccionarTodas() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from PilotoMoto", PilotoMoto.class).getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar participaciones");
            e.printStackTrace();
            return null;
        }
    }

    public void eliminarPorId(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            PilotoMoto pm = session.get(PilotoMoto.class, id);
            if (pm != null) {
                session.remove(pm);
                transaction.commit();
                JOptionPane.showMessageDialog(null, "Participación eliminada");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                JOptionPane.showMessageDialog(null, "Error al borrar la participación");
            }
        }
    }

    
    public List<PilotoMoto> buscarPorPiloto(int idPiloto) {
        Transaction transaction = null;
        List<PilotoMoto> resultados = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            resultados = session.createQuery(
                "FROM PilotoMoto pm WHERE pm.piloto.id = :id", PilotoMoto.class)
                .setParameter("id", idPiloto)
                .getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
        return resultados;
    }

    public List<PilotoMoto> buscarPorMoto(int idMoto) {
        Transaction transaction = null;
        List<PilotoMoto> resultados = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            resultados = session.createQuery(
                "FROM PilotoMoto pm WHERE pm.moto.id = :id", PilotoMoto.class)
                .setParameter("id", idMoto)
                .getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
        return resultados;
    }

    public void actualizarFecha(int idParticipacion, Date nuevaFecha) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            PilotoMoto pm = session.get(PilotoMoto.class, idParticipacion);
            if (pm != null) {
                pm.setFecha(nuevaFecha);
                session.merge(pm); // usar merge como en los otros DAO
                transaction.commit();
                JOptionPane.showMessageDialog(null, "Fecha actualizada correctamente");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                JOptionPane.showMessageDialog(null, "Error al actualizar la fecha");
            }
        }
    }


    
}
