import com.google.common.annotations.VisibleForTesting;
import hangman.model.*;
import org.junit.Assert;
import org.junit.Test;



public class GameScoreTest {
    /**
     * Original Score
     Numero  	              Clase de equivalencia 		               Resultado
     # Letras correctas	      # Letras Incorrectas
     1	                               LC < 0		                      Incorrecto
     2		                           LI < 0	                          Incorrecto
     3	                      LC >= 0	&&    LI = 0	                     100
     4	                      LC >= 0	&&    LI > 0 && LI <= 10	       100 - (10 * LI)
     5	                      LC > 0	&&    LI > 10	                        0
     */

/**
 * Bonus Score
 Numero 	              Clase de equivalencia 		             Resultado
 # Letras correctas	    # Letras Incorrectas
 1	                             LC < 0 		                     Incorrecto
 2		                         LI < 0 	                         Incorrecto
 3	                         LC >= 0  && LI = 0	                         LC * 10
 4	                         LC > 0 && LI < LC 	                     (LC* 10) - (LI * 5)
 5	                         LC > 0 &&	LI >= LC * 2 	                  0
 */

/**
 * Power Score
 Numero 	              Clase de equivalencia 		            Resultado
 # Letras correctas	    # Letras Incorrectas
 1	                              LC< 0 		                    Incorrecto
 2		                          LI< 0	                            Incorrecto
 3	                       LC > 0 && LI = 0	                        La $i-ésima$ letra correcta se bonifica con $5^i$
 4	                       LC = 0 && LI > 0 	                         0
 5	                       LC >= 4 && LI = 0	                        500
 6	                       LC > 1 && LI > 1 	                    La $i-ésima$ letra correcta se bonifica con $5^i$ - (8*LI)
 */
    /**
     * originalScore
     * powerScore
     * bonusScore
     */
    @Test
    public void validateInvalidParameters() {
            GameScore game;
            try {
                game = new OriginalScore();
                game.calculateScore(-2, -3);
                Assert.fail();
            } catch (GameScoreException e) {
                Assert.assertTrue(true);
            }
            try {
                game = new PowerScore();
                game.calculateScore(-2, -3);
                Assert.fail();
            } catch (GameScoreException e) {
                Assert.assertTrue(true);
            }

            try {
                game = new BonusScore();
                game.calculateScore(-2, -3);
                Assert.fail();
            } catch (GameScoreException e) {
                Assert.assertTrue(true);
            }
    }

    /**
     * originalScore
     * @throws GameScoreException
     */

    @Test
    public void validOriginScoreOnlyCorrectLetters() throws GameScoreException {
        GameScore game = new OriginalScore();
        int score = game.calculateScore(10,0);
        Assert.assertEquals(100, score);
    }

    @Test
    public void validOriginScorePenalty() throws GameScoreException {
        GameScore game = new OriginalScore();
        int score = game.calculateScore(2,5);
        Assert.assertEquals(50, score);
    }

    @Test
    public void validOriginScoreMinScore() throws GameScoreException {
        GameScore game = new OriginalScore();
        int score = game.calculateScore(2,11);
        Assert.assertEquals(0, score);
    }

    /**
     * bonusScore
     */

    @Test
    public void validBonusScoreOnlyCorrectLetters() throws GameScoreException {
        GameScore game = new BonusScore();
        int score = game.calculateScore(10,0);
        Assert.assertEquals(100, score);
    }

    @Test
    public void validBonusScoreCorrectLettersAndPenalty() throws GameScoreException {
        GameScore game = new BonusScore();
        int score = game.calculateScore(10,8);
        Assert.assertEquals(60, score);
    }

    @Test
    public void validBonusScoreCorrectMinScore() throws GameScoreException {
        GameScore game = new BonusScore();
        int score = game.calculateScore(10,20);
        Assert.assertEquals(0, score);
    }

    /**
     * powerScore
     */

    @Test
    public void validPowerScoreOnlyCorrectLetters() throws GameScoreException {
        GameScore game = new PowerScore();
        int score = game.calculateScore(3,0);
        Assert.assertEquals(155, score);
    }

    @Test
    public void validPowerScoreCorrectMinScore() throws GameScoreException {
        GameScore game = new PowerScore();
        int score = game.calculateScore(0,1);
        Assert.assertEquals(0, score);
    }

    @Test
    public void validPowerScoreCorrectMaxScore() throws GameScoreException {
        GameScore game = new PowerScore();
        int score = game.calculateScore(4,0);
        Assert.assertEquals(500, score);
    }

    @Test
    public void validPowerScoreCorrectLettersAndPenalty() throws GameScoreException {
        GameScore game = new PowerScore();
        int score = game.calculateScore(3,5);
        Assert.assertEquals(115, score);
    }

}
