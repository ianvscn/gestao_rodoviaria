package exceptions;

public class NumeroAssentoInvalidoException extends Exception {
    public NumeroAssentoInvalidoException() {
        super("Número de assento inválido");
    }
}