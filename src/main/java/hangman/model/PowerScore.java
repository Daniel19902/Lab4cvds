package hangman.model;

import hangman.GameScoreException;

public class PowerScore implements GameScore {

    @Override
    /**
     * @pre Inicia con 0 puntos, puntaje minimo 0
     * @pos Se bonifica con 10 puntos cada letra correcta, se penaliza con -5 puntos letra incorrecta
     * @param CorrectCount numero de filas
     * @param IncorrectCount numero de columnas
     * @return Score
     */
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        return 0;
    }
}
