package website.kalman.guitar_types.services;

import website.kalman.guitar_types.dto.GuitarTypeDto;

import java.util.List;
import java.util.UUID;


public interface GuitarTypeService {

    List<GuitarTypeDto> getAllGuitarTypes();

    GuitarTypeDto getGuitarTypeById(Long id) ;

    GuitarTypeDto creatGuitarType(GuitarTypeDto gto);

    GuitarTypeDto updateGuitarType(Long id, GuitarTypeDto gto);

    boolean deleteGuitarType(Long id);
}
