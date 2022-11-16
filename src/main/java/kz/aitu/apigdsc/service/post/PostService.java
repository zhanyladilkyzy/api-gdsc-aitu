package kz.aitu.apigdsc.service.post;

import kz.aitu.apigdsc.model.post.PostRequest;
import kz.aitu.apigdsc.model.post.PostResponse;

import java.util.List;

public interface PostService {
    PostResponse createPost(PostRequest postRequest);

    PostResponse getPostById(String postId);

    PostResponse updatePostById(PostRequest postRequest);

    List<PostResponse> getAllPosts();

    void deletePostById(String postId);
}
