package com.example.rockpaperscissorsgame.impl;

import com.example.rockpaperscissorsgame.dto.ResponseDto;
import com.example.rockpaperscissorsgame.dto.ResultDto;
import com.example.rockpaperscissorsgame.service.GameService;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameServiceImpl implements GameService {
    @Override
    public ResponseDto checkResult(String choice) {
        return null;
    }

    public String getRandomChoice() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("https://private-anon-da72517da4-curbrockpaperscissors.apiary-mock.com/rps-stage/throw")
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get();

        ResultDto result = response.readEntity(ResultDto.class);
        return result.getBody();
    }

    public String getCustomChoice() {
        String[] arr = {"rock", "paper", "scissors"};
        Random random = new Random();
        return arr[random.nextInt(arr.length)];
    }
}
