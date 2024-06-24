package website.kalman.guitar_types.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnmeldungDto {

    private String username;
    private String password;

    private String emailAccount;
    private String name;

}

