package com.ajeet.prod_ready_features.prod_ready_features.clients.impl;

import com.ajeet.prod_ready_features.prod_ready_features.advice.ApiResponse;
import com.ajeet.prod_ready_features.prod_ready_features.clients.EmployeeClient;
import com.ajeet.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import com.ajeet.prod_ready_features.prod_ready_features.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log= LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        log.trace("Trying to retrieve the employees in getAllEmployees method");
        try {
            log.info("Trying to retrieve the employees in getAllEmployees method");
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get()
                    .uri("employee")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });

//            assert employeeDTOList != null;
            log.debug("Successfully retrieved the employees in getAllEmployees method");
            log.trace("Retrieved employees list in getAllEmployees : {},{},{}",employeeDTOList.getData(),"Hello",5);
            return employeeDTOList.getData();

        } catch (Exception e) {
            log.error("Exception occurred in a getAllEmployees method",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        log.trace("Trying to get employees by Id in getEmployeeById : {}",employeeId);
        try {
            ApiResponse<EmployeeDTO> employeeResponse = restClient.get()
                    .uri("employee/{employeeId}", employeeId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });

            return employeeResponse.getData();
        } catch (Exception e) {
            log.error("Exception occurred in a getEmployeeById method",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        log.trace("Trying to create employees with information : {}",employeeDTO);
        try {
            ResponseEntity<ApiResponse<EmployeeDTO> > employeeDTOApiResponse=restClient.post()
                    .uri("employee")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .toEntity(new ParameterizedTypeReference<>() {
                    });
            log.trace("successfully created the employee : {}",employeeDTOApiResponse.getBody());
            return employeeDTOApiResponse.getBody().getData();

        }catch (Exception e)
        {
            log.error("Exception occurred in createNewEmployee method",e);
            throw new RuntimeException(e);
        }
    }
}