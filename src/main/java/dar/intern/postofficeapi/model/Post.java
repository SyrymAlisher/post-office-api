package dar.intern.postofficeapi.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {
    String postId;
    String clientId;
    String receiverId;
    String postItem;
    String status;
}
