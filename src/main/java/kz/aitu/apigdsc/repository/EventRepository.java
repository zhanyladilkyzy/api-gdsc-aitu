package kz.aitu.apigdsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    EventEntity getEventEntityByEventId(String eventId);

    @Transactional
    void deleteEventEntityById(Long Id);

}
