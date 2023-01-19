package com.example.rockpaperscissorsgame.controller;

import com.example.rockpaperscissorsgame.dto.ResponseDto;
import com.example.rockpaperscissorsgame.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/game")
public class GameController {
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<ResponseDto> getResult(@RequestParam String choice){
        return ResponseEntity.ok(gameService.checkResult(choice));
    }
}
