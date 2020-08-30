package hangman.model;

public class PowerScore implements GameScore {

    private int score = 0;

    /**
     * @pre Inicia con 0 puntos, puntaje minimo 0
     * @pos Se bonifica con 10 puntos cada letra correcta, se penaliza con -5 puntos letra incorrecta
     * @param correctCount numero de filas
     * @param incorrectCount numero de columnas
     * @return Score
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        if(correctCount < 0 || incorrectCount < 0){
            throw new GameScoreException(GameScoreException.ERROR);
        }
        if(correctCount > 0){
            for (int i = 0; i < correctCount; i++){
                score += Math.pow(5, i+1);
            }
        }

        if(incorrectCount > 0) {
            score -= incorrectCount * 8;
        }

        if(score > 500){
            score = 500;
        }

        if(score < 0){
            score = 0;
        }

        return score;
    }
}
