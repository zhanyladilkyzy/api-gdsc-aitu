package kz.aitu.apigdsc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;

    private String surname;

    private Long barcode;

    private Long telegramId;

    private String telegramUsername;

    private String phoneNumber;

    private String password;

    private Boolean confirmed;
}
