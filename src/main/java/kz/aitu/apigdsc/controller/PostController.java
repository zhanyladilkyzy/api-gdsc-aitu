package kz.aitu.apigdsc.controller;


import kz.aitu.apigdsc.model.post.PostRequest;
import kz.aitu.apigdsc.model.post.PostResponse;
import kz.aitu.apigdsc.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/all")
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostResponse getPost(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostResponse addPost(@RequestBody PostRequest postRequest) {
        return postService.createPost(postRequest);
    }

    @PutMapping("/{postId}")
    public PostResponse updatePost(@PathVariable String postId, @RequestBody PostRequest postRequest) {
        postRequest.setPostId(postId);
        return postService.updatePost(postRequest);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable String postId) {
        postService.deletePost(postId);
    }

}
