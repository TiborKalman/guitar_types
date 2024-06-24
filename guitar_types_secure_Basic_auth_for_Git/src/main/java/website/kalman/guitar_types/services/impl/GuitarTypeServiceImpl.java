package website.kalman.guitar_types.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import website.kalman.guitar_types.dto.GuitarTypeDto;
import website.kalman.guitar_types.entity.GuitarType;
import website.kalman.guitar_types.exception.MyEntityNotFoundException;
import website.kalman.guitar_types.mapper.GuitarTypeMapper;
import website.kalman.guitar_types.repository.GuitarTypeRepository;
import website.kalman.guitar_types.services.GuitarTypeService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GuitarTypeServiceImpl implements GuitarTypeService {

    private GuitarTypeRepository guitarTypeRepository;

    @Override
    public boolean deleteGuitarType(Long id) {
        guitarTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public List<GuitarTypeDto> getAllGuitarTypes() {

        List<GuitarType> guitarTypeList = guitarTypeRepository.findAll();

        //TODO: remove this line for sonarlint ?
        List<GuitarTypeDto> guitarTypeDtoList = guitarTypeList.stream().map((guitarType) -> GuitarTypeMapper.toGuitarTypeDto(guitarType)).collect(Collectors.toList());
        return guitarTypeDtoList;
    }

    @Override
    public GuitarTypeDto creatGuitarType(GuitarTypeDto guitarTypeDto) {
        UUID uuid = UUID.randomUUID();
        guitarTypeDto.setUuid(uuid);
        GuitarType guitarType = GuitarTypeMapper.toGuitarType(guitarTypeDto);
        guitarTypeRepository.save(guitarType);

        // yes I know, Sonarlint does not like this-> for debugging purposes
        GuitarTypeDto responseGuitarTypeDto = GuitarTypeMapper.toGuitarTypeDto(guitarType);
        return responseGuitarTypeDto;
    }

    @Override
    public GuitarTypeDto updateGuitarType(Long id, GuitarTypeDto gto) {

        // this is just for debugging
        GuitarType oldGuitarType = guitarTypeRepository
                .findById(id)
                .orElseThrow( () -> new MyEntityNotFoundException("GuitarType not found with id: " + gto.getId()));
        // this is just for debugging
        GuitarTypeDto oldGuitarTypeDto = GuitarTypeMapper.toGuitarTypeDto(oldGuitarType);

        oldGuitarType.setDescription(gto.getDescription());
        oldGuitarType.setName(gto.getName());
        guitarTypeRepository.save(oldGuitarType);

        // yess, zip these two lines (sonarlint)
        GuitarTypeDto updatedGuitarType = GuitarTypeMapper.toGuitarTypeDto(oldGuitarType);
        return updatedGuitarType;
    }

    @Override
    public GuitarTypeDto getGuitarTypeById(Long id) {

        // TODO: this line is only for learning purposes for students
        MyEntityNotFoundException myEntityNotFoundException = new MyEntityNotFoundException("GuitarType not found with id: " + id);

        GuitarType guitarType = guitarTypeRepository
                .findById(id)
                .orElseThrow(() -> myEntityNotFoundException);
                // so prefer the line of code above!
                //.orElseThrow(() -> new MyEntityNotFoundException("GuitarType not found with id: " + id));

        //TODO for learning purposes for students:  kill this line and return it immediately!
        GuitarTypeDto guitarTypeDto = GuitarTypeMapper.toGuitarTypeDto(guitarType);
        return guitarTypeDto; // return here upper line !
    }


}
