package hangman.model;

public class GameScoreException extends Exception {

    public static final String ERROR = "no puede haber numeros negativos.";

    public GameScoreException(String messaje){
        super(messaje);
    }
}
