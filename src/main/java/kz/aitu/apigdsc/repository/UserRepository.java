package kz.aitu.apigdsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity getUserEntityByUserId(String userId);

    @Transactional
    void deleteUserEntityById(Long userId);
}
