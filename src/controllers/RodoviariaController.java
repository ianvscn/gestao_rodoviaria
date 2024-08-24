package controllers;

import exceptions.AssentoIndisponivelException;
import exceptions.NumeroAssentoInvalidoException;
import exceptions.StatusInvalidoException;
import exceptions.TentativaLiberarAssentoDisponivelException;
import models.Rodoviaria;
import models.Assento;

public class RodoviariaController {
    private Rodoviaria rodoviaria;

    public RodoviariaController(Rodoviaria rodoviaria) {
        this.rodoviaria = rodoviaria;
    }

    public void compraPassagem(int numero) throws NumeroAssentoInvalidoException, AssentoIndisponivelException, StatusInvalidoException {
        if (numero <= 0 || numero > rodoviaria.getAssentos().size()) {
            throw new NumeroAssentoInvalidoException();
        }
        Assento assento = rodoviaria.getAssento(numero);
        if (!assento.getStatus().equals("Disponível")) {
            throw new AssentoIndisponivelException();
        }
        assento.setStatus("Indisponível");
        rodoviaria.disparaPassagemComprada();
    }

    public void reservaPassagem(int numero) throws NumeroAssentoInvalidoException, AssentoIndisponivelException, StatusInvalidoException {
        if (numero <= 0 || numero > rodoviaria.getAssentos().size()) {
            throw new NumeroAssentoInvalidoException();
        }
        Assento assento = rodoviaria.getAssento(numero);
        if (!assento.getStatus().equals("Disponível")) {
            throw new AssentoIndisponivelException();
        }
        assento.setStatus("Reservado");
        rodoviaria.disparaPassagemReservada();
    }

    public void liberarAssento(int numero) throws NumeroAssentoInvalidoException, StatusInvalidoException, TentativaLiberarAssentoDisponivelException {
        if (numero <= 0 || numero > rodoviaria.getAssentos().size()) {
            throw new NumeroAssentoInvalidoException();
        }
        Assento assento = rodoviaria.getAssento(numero);
        if (assento.getStatus().equals("Disponível")) {
            throw new TentativaLiberarAssentoDisponivelException();
        }
        assento.setStatus("Disponível");
        rodoviaria.disparaLiberarAsssento();
    }
}
