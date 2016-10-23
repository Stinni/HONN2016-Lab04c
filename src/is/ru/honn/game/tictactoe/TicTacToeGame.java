package is.ru.honn.game.tictactoe;

import is.ru.honn.game.framework.AbstractGame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by KristinnHeiðar on 23.10.2016.
 */
public class TicTacToeGame extends AbstractGame
{
    private char[][] board;
    private final int[][] MARK = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private char currentPlayerMark;

    public void initializeGame()
    {
        board = new char[3][3];
        currentPlayerMark = 'X';
        initializeBoard();
        printBoard();
        System.out.println("To play, enter the number");
        System.out.println("123\n456\n789\non the board.");
    }

    public void makePlay(int player)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Player " + currentPlayerMark + " move: ");
        int mark = 0;
        try
        {
            String s = br.readLine();
            mark = Integer.valueOf(s);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        board[col(mark)][row(mark)] = currentPlayerMark;

        changePlayer();
        printBoard();
    }

    public boolean endOfGame()
    {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    public void printWinner()
    {
        changePlayer();
        System.out.println("Winner is " + currentPlayerMark);
    }

    private void initializeBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = '-';
            }
        }
    }

    void changePlayer()
    {
        currentPlayerMark = (currentPlayerMark == 'X' ? 'O' : 'X');
    }

    private int col(int mark)
    {
        for (int c = 0; c < 3; c++)
            for (int r = 0; r < 3; r++)
                if (mark == MARK[c][r])
                    return c;
        return 0;
    }

    private int row(int mark)
    {
        for (int c = 0; c < 3; c++)
            for (int r = 0; r < 3; r++)
                if (mark == MARK[c][r])
                    return r;
        return 0;
    }

    public void printBoard()
    {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++)
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private boolean checkRowsForWin()
    {
        for (int i = 0; i < 3; i++)
        {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true)
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin()
    {
        for (int i = 0; i < 3; i++)
        {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true)
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin()
    {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }

    private boolean checkRowCol(char c1, char c2, char c3)
    {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }
}
