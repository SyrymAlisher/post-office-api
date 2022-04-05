package dar.intern.postofficeapi.feigns;

import dar.intern.postofficeapi.model.Post;
import dar.intern.postofficeapi.model.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("post-core-api")
public interface PostFeign {
    @GetMapping("/post/check")
    String checkPost();

    @GetMapping("/post/{postId}")
    Post getPostById(@PathVariable String postId);

    @GetMapping("/post/all")
    List<Post> getAllPosts();
}
