package com.ajeet.prod_ready_features.prod_ready_features;

import com.ajeet.prod_ready_features.prod_ready_features.clients.EmployeeClient;
import com.ajeet.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ProdReadyFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	@Order(3)
	void getAllEmployees() {
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

	@Test
	@Order(2)
	void getEmployeeById()
	{
		EmployeeDTO employeeDTO=employeeClient.getEmployeeById(100L);
	}
	@Test
	@Order(1)
	void createNewEmployee()
	{
		EmployeeDTO employeeDTO=new EmployeeDTO(null,"Ajeet","ajeet@gmail.com",2
				,"USER",5000.00
				, LocalDate.of(2024,12,12)
				,true);

		EmployeeDTO savedEmployeeDTO=employeeClient.createNewEmployee(employeeDTO);
		System.out.println(savedEmployeeDTO);
	}

}
