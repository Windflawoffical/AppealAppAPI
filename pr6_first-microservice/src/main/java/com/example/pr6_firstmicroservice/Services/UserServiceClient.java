package com.example.pr6_firstmicroservice.Services;

import com.example.pr6_firstmicroservice.DTO.AppealDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class UserServiceClient {

    private final RestClient restClient;


    public UserServiceClient() {
        restClient = RestClient.builder()
                //.baseUrl("http://secondms:8081/appeals") // for docker
                .baseUrl("http://localhost:8081/appeals") //for local tests
                .build();
    }

    public ResponseEntity<Void> CreateAppeal(AppealDTO appealDTO) {
        return restClient.post().uri("/create").contentType(MediaType.APPLICATION_JSON).body(appealDTO).retrieve().toBodilessEntity();
    }

}
