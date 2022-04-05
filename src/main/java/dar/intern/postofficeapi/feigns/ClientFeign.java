package dar.intern.postofficeapi.feigns;

import dar.intern.postofficeapi.model.ClientResponse;
import dar.intern.postofficeapi.model.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("client-core-api")
public interface ClientFeign {

    @GetMapping("/client/check")
    String checkClient();

    @GetMapping("/client/all")
    List<ClientResponse> getAllClient();

    @GetMapping("/client/{clientId}")
    ClientResponse getClientById(@PathVariable String clientId);
}
