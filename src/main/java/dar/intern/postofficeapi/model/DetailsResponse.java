package dar.intern.postofficeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetailsResponse {

    String postId;
    ClientResponse client;
    ClientResponse receiver;
    String postItem;
    String status;
}
