package dar.intern.postofficeapi.model;

import dar.intern.postofficeapi.model.ClientResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostResponse {

    String postId;
    ClientResponse client;
    ClientResponse receiver;
    String postItem;
    String status;
}
