package website.kalman.guitar_types.services;

import website.kalman.guitar_types.dto.AnmeldungDto;

public interface MyAnmeldeService {
    String einloggen(AnmeldungDto anmeldungDto);
    String anmelden(AnmeldungDto anmeldungDto);

}
