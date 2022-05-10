package paras.programming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Number guessing Game");

        //--create context
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        //---get number generator bean from context (container)
        NumberGenerator numberGenerator
                = context.getBean( NumberGenerator.class);

        //---call method next() to get a random number
        int number = numberGenerator.next();

        log.info("number = {}", number);

        //---get message generator bean from context (container)
        MessageGenerator messageGenerator =
                context.getBean(MessageGenerator.class);

        log.info("getMainMessage {}",messageGenerator.getMainMessage());
        log.info("getResultMessage {}",messageGenerator.getResultMessage());

        //--close context container
        context.close();
    }
}
