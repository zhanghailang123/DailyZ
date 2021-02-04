package Web;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;

@RestController
public class hello {

    @RequestMapping("/hello")
    public String hello() {
        LinkedList linkedList = new LinkedList();
        ArrayList<String> list = new ArrayList<>();
        return "Hello Spring Boot!";

    }
    
    

}