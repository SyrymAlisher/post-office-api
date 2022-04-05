package dar.intern.postofficeapi.controller;


import dar.intern.postofficeapi.feigns.ClientFeign;
import dar.intern.postofficeapi.feigns.PostFeign;
import dar.intern.postofficeapi.model.Post;
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
    public List<Post> getAllPosts() {
        return postFeign.getAllPosts();
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable String postId) {
        return postFeign.getPostById(postId);
    }

    @GetMapping("/all/details")
    public List<PostResponse> getAllPostDetails(){
        List<Post> posts = getAllPosts();
        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts){
            PostResponse postResponse = getPostDetailsById(post.getPostId());
            postResponses.add(postResponse);
        }
        return postResponses;
    }

    @GetMapping("/{postId}/details")
    public PostResponse getPostDetailsById(@PathVariable String postId) {
        Post post = postFeign.getPostById(postId);
        PostResponse postResponse = new PostResponse();
        postResponse.setPostId(post.getPostId());
        postResponse.setClient(clientFeign.getClientById(post.getClientId()));
        postResponse.setReceiver(clientFeign.getClientById(post.getReceiverId()));
        postResponse.setPostItem(post.getPostItem());
        postResponse.setStatus(post.getStatus());
        return postResponse;
    }


}
