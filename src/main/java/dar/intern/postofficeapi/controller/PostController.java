package dar.intern.postofficeapi.controller;

import dar.intern.postofficeapi.feigns.ClientFeign;
import dar.intern.postofficeapi.feigns.PostFeign;
import dar.intern.postofficeapi.model.DetailsResponse;
import dar.intern.postofficeapi.model.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostFeign postFeign;

    @Autowired
    ClientFeign clientFeign;

    @GetMapping("/check")
    public String checkPost() {
        return postFeign.checkPost();
    }

    @GetMapping("/all")
    public List<PostResponse> getAllPosts() {
        return postFeign.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostResponse getPostById(@PathVariable String postId) {
        return postFeign.getPostById(postId);
    }

    @GetMapping("/all/details")
    public List<DetailsResponse> getAllPostDetails(){
        List<PostResponse> posts = getAllPosts();
        List<DetailsResponse> detailsRespons = new ArrayList<>();
        for (PostResponse post : posts){
            DetailsResponse detailsResponse = getPostDetailsById(post.getPostId());
            detailsRespons.add(detailsResponse);
        }
        return detailsRespons;
    }

    @GetMapping("/{postId}/details")
    public DetailsResponse getPostDetailsById(@PathVariable String postId) {

        PostResponse post = postFeign.getPostById(postId);
        DetailsResponse detailsResponse = new DetailsResponse();
        detailsResponse.setPostId(post.getPostId());
        detailsResponse.setClient(clientFeign.getClientById(post.getClientId()));
        detailsResponse.setReceiver(clientFeign.getClientById(post.getReceiverId()));
        detailsResponse.setPostItem(post.getPostItem());
        detailsResponse.setStatus(post.getStatus());
        return detailsResponse;
    }


}
