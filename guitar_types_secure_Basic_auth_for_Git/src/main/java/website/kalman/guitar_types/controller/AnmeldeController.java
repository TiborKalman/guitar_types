package website.kalman.guitar_types.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import website.kalman.guitar_types.dto.AnmeldungDto;
import website.kalman.guitar_types.services.MyAnmeldeService;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/guitar-types/authorization")
public class AnmeldeController {


    private MyAnmeldeService myAnmeldeService;

    @PostMapping("/anmeldung")
    public ResponseEntity<String> register(@RequestBody AnmeldungDto anmeldeDto){

        String ok = myAnmeldeService.anmelden(anmeldeDto);

        ResponseEntity responseEntity = new ResponseEntity<>(ok, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AnmeldungDto anmeldeDto){
        String resp = myAnmeldeService.einloggen(anmeldeDto);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }


}
