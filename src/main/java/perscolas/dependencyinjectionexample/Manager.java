package perscolas.dependencyinjectionexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Manager {
    public static final Logger LOG = LoggerFactory.getLogger(Manager.class);
    @Autowired
    private Worker1 worker1;
    @Autowired
    private Worker2 worker2;
    @Autowired
    private Worker3 worker3;

   // public Manager(Worker1 worker1, Worker2 worker2,Worker3 worker3) {
    public Manager(){

        System.out.println("I am in manager Constructor");
//        worker1.doWork();
//        worker2.doWork();
//        worker3.doWork();

    }
//    public static void main(String[] args){
//        Worker1 w1= new Worker1();
//        Worker2 w2= new Worker2();
//        Worker3 w3= new Worker3();
//        Manager m = new Manager(w1,w2,w3);
//    }
    @PostConstruct
    public void init(){
        worker1.doWork();
        worker2.doWork();
        worker3.doWork();
    }
}
