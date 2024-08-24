// Main.java
import exceptions.AssentoIndisponivelException;
import exceptions.NumeroAssentoInvalidoException;
import exceptions.StatusInvalidoException;
import exceptions.TentativaLiberarAssentoDisponivelException;
import models.Rodoviaria;
import views.Painel;
import views.Quiosque;
import controllers.RodoviariaController;

public class Main {

    public static void main(String[] args) throws NumeroAssentoInvalidoException, AssentoIndisponivelException, StatusInvalidoException, TentativaLiberarAssentoDisponivelException {
        // Criação do modelo
        Rodoviaria rodoviaria = new Rodoviaria();

        // Criação das views
        Painel painel = new Painel();
        Quiosque quiosque = new Quiosque();

        // Adiciona as views como listeners do modelo
        rodoviaria.addRodoviariaListener(painel);
        rodoviaria.addRodoviariaListener(quiosque);

        // Criação do controlador
        RodoviariaController controller = new RodoviariaController(rodoviaria);

        // Compra de passagem para o assento 1
        controller.compraPassagem(1);

        // Reserva de passagem para o assento 5
        controller.reservaPassagem(5);

        // Liberação do assento 5
        controller.liberarAssento(5);
    }
}
