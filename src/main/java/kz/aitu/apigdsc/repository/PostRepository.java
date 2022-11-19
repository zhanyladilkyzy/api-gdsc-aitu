package kz.aitu.apigdsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    PostEntity getPostEntityByPostId(String postId);

    @Transactional
    void deletePostEntityById(Long postId);
}
