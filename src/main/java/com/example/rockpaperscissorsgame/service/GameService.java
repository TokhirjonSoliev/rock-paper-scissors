package com.example.rockpaperscissorsgame.service;

import com.example.rockpaperscissorsgame.dto.ResponseDto;

public interface GameService {
    ResponseDto checkResult(String choice);
}
