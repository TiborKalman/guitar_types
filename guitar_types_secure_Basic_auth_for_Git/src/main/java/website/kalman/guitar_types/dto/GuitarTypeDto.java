package website.kalman.guitar_types.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GuitarTypeDto {

    private Long id;
    private UUID uuid;
    private String name;
    private String description;
}
