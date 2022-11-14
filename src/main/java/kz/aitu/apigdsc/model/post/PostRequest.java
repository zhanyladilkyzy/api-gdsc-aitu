package kz.aitu.apigdsc.model.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private String postId;

    private String title;

    private String description;

    private String link;

}
