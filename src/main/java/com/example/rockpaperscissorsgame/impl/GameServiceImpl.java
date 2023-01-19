package com.example.rockpaperscissorsgame.impl;

import com.example.rockpaperscissorsgame.dto.ResponseDto;
import com.example.rockpaperscissorsgame.dto.ResultDto;
import com.example.rockpaperscissorsgame.service.GameService;
import jakarta.ws.rs.BadRequestException;
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
        ResponseDto responseDto = new ResponseDto();
        String clientChoice = choice.toLowerCase();
        String serverChoice = getCustomChoice();
        responseDto.setResult(compareChoices(clientChoice, serverChoice));
        return responseDto;
    }

    private String compareChoices(String clientChoice, String serverChoice) {
        String res = "";
        switch (clientChoice) {
            case "rock":
                res = getResultAgainstRock(serverChoice);
                break;
            case "paper":
                res = getResultAgainstPaper(serverChoice);
                break;
            case "scissors":
                res = getResultAgainstScissors(serverChoice);
                break;
            default: throw new BadRequestException("invalid choice");
        }
        return res;
    }

    private String getResultAgainstRock(String serverChoice) {
        String res = "";
        switch (serverChoice) {
            case "rock": {
                res = "identical";
                break;
            }
            case "scissors": {
                res = "win";
                break;
            }
            case "paper": {
                res = "lose";
                break;
            }
        }
        return res;
    }

    private String getResultAgainstPaper(String serverChoice) {
        String res = "";
        switch (serverChoice) {
            case "rock": {
                res = "win";
                break;
            }
            case "scissors": {
                res = "lose";
                break;
            }
            case "paper": {
                res = "identical";
                break;
            }
        }
        return res;
    }

    private String getResultAgainstScissors(String serverChoice) {
        String res = "";
        switch (serverChoice) {
            case "rock": {
                res = "lose";
                break;
            }
            case "scissors": {
                res = "identical";
                break;
            }
            case "paper": {
                res = "win";
                break;
            }
        }
        return res;
    }

    // this method always returns "rock", so I created my own method that returns rock, paper and scissors randomly
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
