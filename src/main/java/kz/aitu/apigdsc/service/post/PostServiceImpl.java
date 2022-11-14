package kz.aitu.apigdsc.service.post;

import kz.aitu.apigdsc.model.post.PostRequest;
import kz.aitu.apigdsc.model.post.PostResponse;
import kz.aitu.apigdsc.repository.PostEntity;
import kz.aitu.apigdsc.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements  PostService{
    @Autowired
    PostRepository postRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public PostResponse createPost(PostRequest postRequest) {
        postRequest.setPostId(UUID.randomUUID().toString());
        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);
        postRepository.save(postEntity);
        return modelMapper.map(postEntity, PostResponse.class);
    }

    @Override
    public PostResponse getPostById(String postId) {
        return null;
    }

    @Override
    public PostResponse updatePostById(String postId) {
        return null;
    }

    @Override
    public List<PostResponse> getAllPosts() {
        return null;
    }

    @Override
    public void deletePostById(String postId) {

    }
}
