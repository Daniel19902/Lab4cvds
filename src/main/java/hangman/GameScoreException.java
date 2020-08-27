package hangman;

public class GameScoreException extends Exception {
    public static final String INVALID_PARAM = "los parametros son invalidos, no pudes ser negativos";

    public  GameScoreException(String message){
        super(message);
    }
}
