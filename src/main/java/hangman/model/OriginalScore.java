package hangman.model;

import hangman.GameScoreException;

public class OriginalScore implements GameScore {

    @Override
    /**
     * @pre Se inicia con 100 puntos, puntaje minimo 0
     * @pos Se penaliza con 10 puntos por cada letra incorrecta
     * @param CorrectCount numero de letras correctas
     * @param IncorrectCount numero de letras incorrectas
     * @return score
     */
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        return 0;
    }
}
