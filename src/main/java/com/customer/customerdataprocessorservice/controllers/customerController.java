package com.customer.customerdataprocessorservice.controllers;

import com.customer.customerdataprocessorservice.model.Customer;
import com.customer.customerdataprocessorservice.model.CustomerDetail;
import com.customer.customerdataprocessorservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9090")
public class customerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST,value= "/customers")
    public ResponseEntity<String> createCandidate(@RequestBody Customer customer){

        return new ResponseEntity(customerService.create(customer), HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET,value= "/v1/customers")
    public ResponseEntity<List<CustomerDetail>> getCandidates(@RequestParam("limit") int limit){

        return new ResponseEntity(customerService.findAll(), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET,value= "/v1/customers/{customerId}")
    public ResponseEntity<CustomerDetail> getCandidateById(@PathVariable int customerId){

        return new ResponseEntity(customerService.findById(customerId), HttpStatus.OK);
    }

}
