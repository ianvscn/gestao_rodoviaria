package views;

import event.RodoviariaEvent;
import interfaces.RodoviariaListener;
import models.Assento;
import models.Rodoviaria;

import java.util.ArrayList;

public class Quiosque implements RodoviariaListener {

    @Override
    public void passagemComprada(RodoviariaEvent rodoviariaEvent) {
        Rodoviaria rodoviaria = (Rodoviaria) rodoviariaEvent.getSource();
        ArrayList<Assento> assentos = rodoviaria.getAssentos();

        System.out.println("\nQuiosque sabe que passagem foi comprada");
        System.out.println("LISTAGEM ASSENTOS DO QUIOSQUE: ");
        for (Assento assento : assentos) {
            String status = assento.getStatus();
            System.out.println("Assento " + assento.getNumero() + ": " + status);
        }
    }

    @Override
    public void passagemReservada(RodoviariaEvent rodoviariaEvent) {
        Rodoviaria rodoviaria = (Rodoviaria) rodoviariaEvent.getSource();
        ArrayList<Assento> assentos = rodoviaria.getAssentos();

        System.out.println("\nQuiosque sabe que passagem foi reservada");
        System.out.println("LISTAGEM ASSENTOS DO QUIOSQUE: ");
        for (Assento assento : assentos) {
            String status = assento.getStatus();
            System.out.println("Assento " + assento.getNumero() + ": " + status);
        }
    }

    @Override
    public void assentoLiberado(RodoviariaEvent rodoviariaEvent) {
        Rodoviaria rodoviaria = (Rodoviaria) rodoviariaEvent.getSource();
        ArrayList<Assento> assentos = rodoviaria.getAssentos();

        System.out.println("\nQuiosque sabe que assento foi liberado");
        System.out.println("LISTAGEM ASSENTOS DO QUIOSQUE: ");
        for (Assento assento : assentos) {
            String status = assento.getStatus();
            System.out.println("Assento " + assento.getNumero() + ": " + status);
        }
    }
}
