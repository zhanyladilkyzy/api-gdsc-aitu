package kz.aitu.apigdsc.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="event_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String eventId;
    @Column(nullable = false)
    private String title;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(length = 500)
    private String description;
}
