package models;

import event.RodoviariaEvent;
import exceptions.AssentoIndisponivelException;
import exceptions.NumeroAssentoInvalidoException;
import exceptions.StatusInvalidoException;
import exceptions.TentativaLiberarAssentoDisponivelException;
import interfaces.RodoviariaListener;

import java.util.ArrayList;
import java.util.List;

public class Rodoviaria {
    private ArrayList<Assento> assentos;
    private List<RodoviariaListener> rodoviariaListeners = new ArrayList<RodoviariaListener>();

    public Rodoviaria() {
        assentos = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            assentos.add(new Assento(i, "Disponível"));
        }
    }

    public void compraPassagem (int numero) throws NumeroAssentoInvalidoException, AssentoIndisponivelException, StatusInvalidoException {
        if (numero <= 0 || numero > assentos.size()) {
            throw new NumeroAssentoInvalidoException();
        }
        Assento assento = assentos.get(numero - 1);
        if (!assento.getStatus().equals("Disponível")) {
            throw new AssentoIndisponivelException();
        }
        assento.setStatus("Indisponível");
        System.out.println("\nPassagem comprada para o assento " + numero + ".");

        disparaPassagemComprada();
    }

    public void reservaPassagem(int numero) throws NumeroAssentoInvalidoException, AssentoIndisponivelException, StatusInvalidoException {
        if (numero <= 0 || numero > assentos.size()) {
            throw new NumeroAssentoInvalidoException();
        }
        Assento assento = assentos.get(numero - 1);
        if (!assento.getStatus().equals("Disponível")) {
            throw new AssentoIndisponivelException();
        }
        assento.setStatus("Reservado");
        System.out.println("\nAssento " + numero + " reservado.");

        disparaPassagemReservada();
    }

    public void liberarAssento (int numero) throws NumeroAssentoInvalidoException, StatusInvalidoException, TentativaLiberarAssentoDisponivelException {
        if (numero <= 0 || numero > assentos.size()) {
            throw new NumeroAssentoInvalidoException();
        }
        Assento assento = assentos.get(numero - 1);
        if (assento.getStatus().equals("Disponível")){
            throw new TentativaLiberarAssentoDisponivelException();
        }
        assento.setStatus("Disponível");
        System.out.println("\nAssento " + numero + " agora está disponível.");

        disparaLiberarAsssento();
    }

    public void disparaPassagemComprada(){
        List<RodoviariaListener> listenersRodoviaria;

        synchronized (this){
            listenersRodoviaria = (List) (((ArrayList) rodoviariaListeners).clone());
        }

        RodoviariaEvent evento = new RodoviariaEvent(this);
        for (RodoviariaListener rodoviariaListener : listenersRodoviaria){
            rodoviariaListener.passagemComprada(evento);
        }
    }

    ;  public void disparaPassagemReservada(){
        List<RodoviariaListener> listenersRodoviaria;

        synchronized (this){
            listenersRodoviaria = (List) (((ArrayList) rodoviariaListeners).clone());
        }

        RodoviariaEvent evento = new RodoviariaEvent(this);
        for (RodoviariaListener rodoviariaListener : listenersRodoviaria){
            rodoviariaListener.passagemReservada(evento);
        }
    }

    public void disparaLiberarAsssento(){
        List<RodoviariaListener> listenersRodoviaria;

        synchronized (this){
            listenersRodoviaria = (List) (((ArrayList) rodoviariaListeners).clone());
        }

        RodoviariaEvent evento = new RodoviariaEvent(this);
        for (RodoviariaListener rodoviariaListener : listenersRodoviaria){
            rodoviariaListener.assentoLiberado(evento);
        }
    }

    public synchronized void addRodoviariaListener (RodoviariaListener rodoviariaListener) {
        if (!rodoviariaListeners.contains(rodoviariaListener)){
            rodoviariaListeners.add(rodoviariaListener);
        }
    }

    public synchronized void removeRodoviariaListener (RodoviariaListener rodoviariaListener){
        rodoviariaListeners.remove(rodoviariaListener);
    }

    public ArrayList<Assento> getAssentos (){
        return this.assentos;
    }

    public Assento getAssento (int numeroAssento){
        return this.assentos.get(numeroAssento - 1);
    }

    public String getCorStatus(String status) {
        switch (status) {
            case "Disponível":
                return "\u001B[32m\u2B24\u001B[0m"; // Verde
            case "Reservado":
                return "\u001B[33m\u2B24\u001B[0m"; // Amarelo
            case "Indisponível":
                return "\u001B[31m\u2B24\u001B[0m"; // Vermelho
            default:
                return "";
        }
    }
}


