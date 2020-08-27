package hangman.model;

import hangman.GameScoreException;

public interface GameScore {

    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException;

}
