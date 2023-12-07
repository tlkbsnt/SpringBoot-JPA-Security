package bsnt.np.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApplication {
    @GetMapping("/api")
    public String hello(){
        return "Hello Tilak";
    }
}
