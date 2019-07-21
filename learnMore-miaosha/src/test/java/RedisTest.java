import com.learn.miaosha.MiaoShaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author fengjie
 * @version 1.0
 * @date 2019/7/6
 */
@SpringBootTest(classes = MiaoShaApplication.class)
@RunWith(SpringRunner.class)
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void redisAdd(){
        redisTemplate.opsForValue().set("name","fengjie");
    }

}
