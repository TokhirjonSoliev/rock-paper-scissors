package com.example.rockpaperscissorsgame.impl;

import com.example.rockpaperscissorsgame.dto.ResponseDto;
import com.example.rockpaperscissorsgame.service.GameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    @Override
    public ResponseDto checkResult(String choice) {
        return null;
    }
}
