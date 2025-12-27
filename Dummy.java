package 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Dummy {
    @GetMapping("/show")
    public String display() {
        return "dummy dummy dummmmyyy";
    }
}
