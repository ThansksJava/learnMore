import com.cnpc.ioc.BeanDefinition;
import com.cnpc.ioc.factory.AutowireCapableBeanFactory;
import com.cnpc.ioc.factory.BeanFactory;
import org.junit.Test;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/9
 * @Time 14:46
 */
public class IocTest {
    @Test
    public void test(){
        // 1.初始化beanfactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
