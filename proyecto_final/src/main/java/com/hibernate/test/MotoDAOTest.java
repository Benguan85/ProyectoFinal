package com.hibernate.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hibernate.dao.MotoDAO;
import com.hibernate.model.Moto;

class MotoDAOTest {

    MotoDAO daoMoto = new MotoDAO();

    @Test
    public void testSeleccionarMotoConIdExistente() {
        int idExistente = 153;
        
        Moto moto = daoMoto.seleccionarMotoConId(idExistente);

        assertNotNull(moto, "La moto con ID " + idExistente + " no tiene que ser null");
        assertEquals(idExistente, moto.getId(), "El ID de la moto tiene que ser el mismo con el buscado");
    }

    @Test
    public void testSeleccionarMotoConIdInexistente() {
        int idInexistente = -1;

        Moto moto = daoMoto.seleccionarMotoConId(idInexistente);

        assertNull(moto, "La moto no existe y tiene que devolver null");
    }

}
