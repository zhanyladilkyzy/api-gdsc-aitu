package kz.aitu.apigdsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    PostEntity getPostEntityByPostId(String postId);

    void deleteByPostId(String postId);
}
