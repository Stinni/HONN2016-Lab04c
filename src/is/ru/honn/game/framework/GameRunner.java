package is.ru.honn.game.framework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by KristinnHeiðar on 23.10.2016.
 */
public class GameRunner
{
    public static void main(String[] args)
    {
        ApplicationContext context= new
                ClassPathXmlApplicationContext("/spring-config.xml");
        Game game = (Game)context.getBean("game");

        game.playOneGame();
    }
}
