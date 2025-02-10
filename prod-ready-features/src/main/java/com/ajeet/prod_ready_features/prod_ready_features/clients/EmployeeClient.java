package com.ajeet.prod_ready_features.prod_ready_features.clients;

import com.ajeet.prod_ready_features.prod_ready_features.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();
}
