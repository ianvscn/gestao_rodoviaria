package exceptions;

public class AssentoIndisponivelException extends Exception {
    public AssentoIndisponivelException() {
        super("Essa cadeira está indisponível, por favor escolha outra!");
    }
}
