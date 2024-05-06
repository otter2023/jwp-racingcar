package racingcar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import racingcar.dto.GameInitializationRequest;
import racingcar.dto.GameResultResponse;
import racingcar.service.RacingCarService;


@RestController
public class WebRacingCarController {

    private final RacingCarService racingCarService;

    @Autowired
    public WebRacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    @PostMapping("/plays")
    public ResponseEntity<GameResultResponse> playRacingCar(@RequestBody GameInitializationRequest gameInitializationRequest) {
        final GameResultResponse gameResultResponse = racingCarService.startRace(gameInitializationRequest);

        return ResponseEntity.ok().body(gameResultResponse);
    }

}
