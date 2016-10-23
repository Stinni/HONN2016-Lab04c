package is.ru.honn.game.framework;

/**
 * Created by KristinnHeiðar on 23.10.2016.
 */
public interface Game
{
    void setPlayersCount(int playerCount);
    void initializeGame();
    void makePlay(int player);
    boolean endOfGame();
    void printWinner();
    void playOneGame();
}
