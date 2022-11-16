package kz.aitu.apigdsc.service.post;

import kz.aitu.apigdsc.model.post.PostRequest;
import kz.aitu.apigdsc.model.post.PostResponse;
import kz.aitu.apigdsc.repository.PostEntity;
import kz.aitu.apigdsc.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        PostEntity postEntity = postRepository.getPostEntityByPostId(postId);
        return modelMapper.map(postEntity, PostResponse.class);
    }

    @Override
    public PostResponse updatePostById(PostRequest postRequest) {
        PostEntity dbEntity = postRepository.getPostEntityByPostId(postRequest.getPostId());
        PostEntity updatedEntity = modelMapper.map(postRequest, PostEntity.class);
        updatedEntity.setId(dbEntity.getId());
        postRepository.save(updatedEntity);
        return modelMapper.map(updatedEntity, PostResponse.class);
    }

    @Override
    public List<PostResponse> getAllPosts() {
        List<PostEntity> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        return posts.stream().map(post -> modelMapper.map(post, PostResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void deletePostById(String postId) {
        postRepository.deleteByPostId(postId);
    }
}
