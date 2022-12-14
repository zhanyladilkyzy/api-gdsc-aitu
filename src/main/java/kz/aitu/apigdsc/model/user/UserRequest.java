package kz.aitu.apigdsc.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String userId;
    @NotNull
    private String name;

    private String surname;

    private String bio;

    private Long barcode;
    @NotNull
    private Long telegramId;

    private String telegramUsername;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String password;

    private Boolean confirmed;

    private UserRole role;

    private String imageUrl;

}
