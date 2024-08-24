package testes;

import exceptions.AssentoIndisponivelException;
import exceptions.NumeroAssentoInvalidoException;
import models.Assento;
import models.Rodoviaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestesRodoviaria {

    private Rodoviaria rodoviaria;

    @BeforeEach
    public void setUp() {
        rodoviaria = new Rodoviaria();
    }

    @Test
    public void testeComprarPassagemAssentoInvalido() {
        assertThrows(NumeroAssentoInvalidoException.class, () -> rodoviaria.compraPassagem(0));
    }

    @Test
    public void testeComprarPassagemAssentoIndisponivel() {
        assertThrows(AssentoIndisponivelException.class, () -> {
            rodoviaria.getAssento(1).setStatus("Indisponível");
            rodoviaria.compraPassagem(1);
        });
    }

    @Test
    public void testeReservaPassagemAssentoInvalido() {
        assertThrows(NumeroAssentoInvalidoException.class, () -> rodoviaria.reservaPassagem(0));
    }

    @Test
    public void testeReservaPassagemAssentoIndisponivel() {
        assertThrows(AssentoIndisponivelException.class, () -> {
            rodoviaria.getAssento(1).setStatus("Indisponível");
            rodoviaria.reservaPassagem(1);
        });
    }

    @Test
    public void testeLiberarAssentoAssentoInvalido() {
        assertThrows(NumeroAssentoInvalidoException.class, () -> rodoviaria.liberarAssento(0));
    }

    @Test
    public void testeLiberarAssentoStatusDisponivel() throws Exception {
        rodoviaria.getAssento(1).setStatus("Disponível");
        assertThrows(NumeroAssentoInvalidoException.class, () -> rodoviaria.liberarAssento(0));
    }

    @Test
    public void testeGetAssentos() {
        ArrayList<Assento> assentos = rodoviaria.getAssentos();
        assertEquals(10, assentos.size());
    }

    @Test
    public void testeGetAssento() {
        Assento assento = rodoviaria.getAssento(1);
        assertEquals(1, assento.getNumero());
    }
}