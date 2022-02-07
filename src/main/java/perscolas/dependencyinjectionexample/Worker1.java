package perscolas.dependencyinjectionexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Worker1 {
    public static final Logger LOG = LoggerFactory.getLogger(Worker1.class);
    public void doWork(){
        LOG.info("This is Worker1");
        try {
            int x = 1 / 0;
        }catch(Exception e){
            //LOG.info("");
        }
        System.out.println("Worker1 is doing work");
    }
}
