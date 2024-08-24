package exceptions;

public class TentativaLiberarAssentoDisponivelException extends Exception {
    public TentativaLiberarAssentoDisponivelException () {
        super("Assento já está disponível");
    }
}
