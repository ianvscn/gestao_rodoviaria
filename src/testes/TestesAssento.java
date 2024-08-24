package testes;


import exceptions.StatusInvalidoException;
import models.Assento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestesAssento {
    private Assento assento;

    @BeforeEach
    public void setUp() {
        assento = new Assento(1, "Disponível");
    }

    @Test
    public void testeGetNumero() {
        assertEquals(1, assento.getNumero());
    }

    @Test
    public void testeGetStatus() {
        assertEquals("Disponível", assento.getStatus());
    }

    @Test
    public void testeSetStatus() throws StatusInvalidoException {
        assento.setStatus("Reservado");
        assertEquals("Reservado", assento.getStatus());
    }

    @Test
    public void testeSetStatusInvalido() {
        assertThrows(StatusInvalidoException.class, () -> assento.setStatus("Status inválido"));
    }
}