package dar.intern.postofficeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientResponse {
    String clientId;
    String name;
    String surname;
    String email;

}
