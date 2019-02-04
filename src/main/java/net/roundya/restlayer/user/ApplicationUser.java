package net.roundya.restlayer.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Users")
public class ApplicationUser {
    @Id
    private String _id;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 6, message = "User should have 4 characters at least.")
    @Field(value = "Username")
    private String username;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 12, message = "Password should have 6 characters at least.")
    @Field(value = "Password")
    private String password;

    @NotBlank
    @NotEmpty
    @NotNull
    @Email
    @Field(value = "Email")
    private String email;

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}