package AOP;

import org.junit.After;
import org.junit.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LOgTime {
    long startTime = 0;

    @Before
    public void LogBeginTime() {
        startTime = System.currentTimeMillis();
    }

    @After
    public void LogEndTime() {
        System.out.println("method done with :"+(System.currentTimeMillis()-startTime)+" milliseconds");
    }
}
