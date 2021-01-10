import com.idstaa.EmailApplication9190;
import com.idstaa.controller.EmailController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author chenjie
 * @date 2021/1/1 11:00
 */
@SpringBootTest(classes = {EmailApplication9190.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailControllerTest {
    @Autowired
    private EmailController emailController;

    @Test
    public void test(){
        String code = UUID.randomUUID().toString().substring(0,4);
        /*boolean b = emailController.sendEmail("673974833@qq.com;1121245860@qq.com", code);*/
    }
}
