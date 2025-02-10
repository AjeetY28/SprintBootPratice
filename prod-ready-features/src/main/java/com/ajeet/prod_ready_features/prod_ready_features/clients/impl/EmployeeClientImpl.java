package com.ajeet.prod_ready_features.prod_ready_features.clients.impl;

import com.ajeet.prod_ready_features.prod_ready_features.advice.ApiResponse;
import com.ajeet.prod_ready_features.prod_ready_features.clients.EmployeeClient;
import com.ajeet.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try {
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });

            return employeeDTOList.getData();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
