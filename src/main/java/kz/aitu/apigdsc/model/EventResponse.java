package kz.aitu.apigdsc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    private String eventId;

    private String title;

    private String imageUrl;

    private String description;
}
