import com.cnpc.sss.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/15
 * @Time 9:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
//@SpringBootTest
public class RabbitMQTest {
    @Autowired
    private AmqpTemplate template;
    @Test
    public void testSend(){
        template.convertAndSend("queue","hello world");
    }

}
