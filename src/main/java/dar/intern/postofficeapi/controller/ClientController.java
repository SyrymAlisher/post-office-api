package dar.intern.postofficeapi.controller;

import dar.intern.postofficeapi.feigns.ClientFeign;
import dar.intern.postofficeapi.model.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientFeign clientFeign;


    @GetMapping("/check")
    public String checkClient() {
        return clientFeign.checkClient();
    }


    @GetMapping("/all")
    public List<ClientResponse> getAllClients() {
        return clientFeign.getAllClient();
    }


    @GetMapping("/{clientId}")
    public ClientResponse getClientById(@PathVariable String clientId) {
        return clientFeign.getClientById(clientId);
    }

}
