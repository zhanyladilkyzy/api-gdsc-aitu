package kz.aitu.apigdsc.repository;

import kz.aitu.apigdsc.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="user_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false, length = 80)
    private String name;
    @Column(nullable = false, length = 80)
    private String surname;
    private String bio;
    @Column(nullable = false, length = 10)
    private Long barcode;
    @Column(nullable = false, name = "telegram_id")
    private Long telegramId;
    @Column(nullable = false, name = "telegram_username")
    private String telegramUsername;
    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean confirmed;
    @Column(nullable = false)
    private UserRole role;
    @Column(nullable = false, name = "image_url")
    private String imageUrl;
}
