package hangman.model;

public interface GameScore {
    /**
     * calculateScore
     * @param correctCount # palabras correctas
     * @param incorrectCount # palabras incorrectas
     * @return score
     * @throws GameScoreException
     */
    int calculateScore(int correctCount, int incorrectCount) throws GameScoreException;
}
