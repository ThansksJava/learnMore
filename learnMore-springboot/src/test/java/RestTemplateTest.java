import com.cnpc.sss.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/1/29 9:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RestTemplateTest {
    @Autowired
    private RestTemplateBuilder builder;

    @Test
    public void testDQ() {
        //请求的URL地址
        String requestUrl = "https://cloud.cnpc/cmp/api/thirdpart/v1/monitor/vms/list";
        //得到RestTemplate
        RestTemplate restTemplate = builder.build();
        //设置header
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        httpHeaders.add("X-Auth-Token", "bdbc35ed9e3df3ad669d34ae2fdd81c7");
        HttpEntity requestEntity = new HttpEntity(httpHeaders);
        //发送请求
        ResponseEntity<String> resp = restTemplate.exchange(requestUrl, HttpMethod.POST, requestEntity, String.class);
//        restTemplate.
        //得到数据
        String data = resp.getBody();
        System.out.println(data);
    }

}