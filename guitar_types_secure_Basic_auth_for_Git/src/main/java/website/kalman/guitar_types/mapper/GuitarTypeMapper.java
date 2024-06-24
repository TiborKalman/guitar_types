package website.kalman.guitar_types.mapper;

import website.kalman.guitar_types.dto.GuitarTypeDto;
import website.kalman.guitar_types.entity.GuitarType;

// TODO: use MapStruct instead
public class GuitarTypeMapper {

    public static GuitarTypeDto toGuitarTypeDto(GuitarType guitarType) {
        GuitarTypeDto guitarTypeDto = new GuitarTypeDto();
        guitarTypeDto.setDescription(guitarType.getDescription());
        guitarTypeDto.setName(guitarType.getName());
        guitarTypeDto.setId(guitarType.getId());
        guitarTypeDto.setUuid(guitarType.getUuid());
        return guitarTypeDto;
    }

    public static GuitarType toGuitarType(GuitarTypeDto guitarTypeDto) {
        GuitarType guitarType = new GuitarType();
        guitarType.setDescription(guitarTypeDto.getDescription());
        guitarType.setName(guitarTypeDto.getName());
        guitarType.setId(guitarTypeDto.getId());
        guitarType.setUuid(guitarTypeDto.getUuid());
        return guitarType;
    }
}
