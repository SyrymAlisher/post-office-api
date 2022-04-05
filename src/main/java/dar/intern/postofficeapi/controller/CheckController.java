package dar.intern.postofficeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class CheckController {

    @GetMapping("/check")
    public String checkPostOffice() {
        return "Post-Office-api is working";
    }

}
