package base;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.jaywu.InitApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=InitApplication.class)
public class BaseJunit4Test {

    protected MockMvc mockMvc;

}
