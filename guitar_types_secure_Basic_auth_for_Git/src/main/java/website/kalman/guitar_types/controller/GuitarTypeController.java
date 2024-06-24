package website.kalman.guitar_types.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import website.kalman.guitar_types.dto.GuitarTypeDto;
import website.kalman.guitar_types.services.GuitarTypeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/guitar-types")
@AllArgsConstructor
@CrossOrigin("*")
public class GuitarTypeController {

    private GuitarTypeService guitarTypeService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteGuitarType(@PathVariable Long id) {
        // discuss here if a return value of String c would be better
        Boolean ok = guitarTypeService.deleteGuitarType(id);
        return ResponseEntity.ok(ok);
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("")
    public ResponseEntity<List<GuitarTypeDto>> getAllGuitarTypes() {
        List<GuitarTypeDto> guitarTypeDtos = guitarTypeService.getAllGuitarTypes();
        return new ResponseEntity<>(guitarTypeDtos, HttpStatus.OK);
        // or return ResponseEntity.ok(guitarTypeDtos);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping("/{id}")
    public ResponseEntity<GuitarTypeDto> updateGuitarType(@PathVariable("id") Long id, @RequestBody GuitarTypeDto guitarTypeDto) {
        GuitarTypeDto updatedGuitarTypeDto =guitarTypeService.updateGuitarType(id,guitarTypeDto);
        return ResponseEntity.ok(updatedGuitarTypeDto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping
    public ResponseEntity<GuitarTypeDto> creatNewGuitar(@RequestBody GuitarTypeDto guitarTypeDto) {
        GuitarTypeDto newGuitarTypeDto =guitarTypeService.creatGuitarType(guitarTypeDto);
        return new ResponseEntity<>(newGuitarTypeDto, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    public ResponseEntity<GuitarTypeDto> getGuitarTypeById(@PathVariable("id") Long id) {
        GuitarTypeDto guitarTypeDto =guitarTypeService.getGuitarTypeById(id);
        return ResponseEntity.ok(guitarTypeDto);
    }
}
