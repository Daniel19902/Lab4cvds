package hangman.model;

public class OriginalScore implements GameScore {

    private int score = 100;

    /**
     * @pre Se inicia con 100 puntos, putaje minimo 0.
     * @pos se penaliza con 10 puntos por cada letra incorrecta
     * @param correctCount numero de letras correctas
     * @param incorrectCount numero de letras incorrectas
     * @return score.
     */

    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException{
        if(correctCount < 0 || incorrectCount < 0){
            throw new GameScoreException(GameScoreException.ERROR);
        }
        if(incorrectCount > 0) {
            score -= incorrectCount * 10;
        }
        if(score < 0){ score = 0;}

        return score;
    }
}
