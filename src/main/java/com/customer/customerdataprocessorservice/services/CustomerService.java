package com.customer.customerdataprocessorservice.services;

import com.customer.customerdataprocessorservice.model.Customer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {


    private RestTemplate restTemplate;

    public ResponseEntity<String> create(Customer customer)
    {
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");

        String query1 = "query : mutation { createCustomer(firstName: "+ customer.getFirstName() + ", lastName: " + customer.getLastName()+ ", email: "+ customer.getEmail()+ ", phoneNumber: "+ customer.getPhoneNumber()+ ") { customerId }}";

        String URL = "/graphiql";

        ResponseEntity<String> response = restTemplate.postForEntity(URL, new HttpEntity<>(query1, headers), String.class);
        System.out.println("The response================="+response);
        return response;
    }

    public ResponseEntity<String> findAll()
    {
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");

        String query1 = "query : query { customerDetails(count: 1) { customerId  firstName  lastName   emailId   phoneNumber  }  }";

        String URL = "/graphiql";

        ResponseEntity<String> response = restTemplate.postForEntity(URL, new HttpEntity<>(query1, headers), String.class);
        System.out.println("The response================="+response);
        return response;
    }

    public ResponseEntity<String> findById(Integer id)
    {
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");

        String query1 = "query : query { customerDetailsById(id : " + id+ " ) { customerId  firstName  lastName   emailId   phoneNumber  }  }";

        String URL = "/graphiql";

        ResponseEntity<String> response = restTemplate.postForEntity(URL, new HttpEntity<>(query1, headers), String.class);
        System.out.println("The response================="+response);
        return response;
    }
}
