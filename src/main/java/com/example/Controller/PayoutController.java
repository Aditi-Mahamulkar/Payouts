package com.example.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.ItemsRequestDTO;
import com.example.DTO.createResponseDTO;
import com.example.Service.PayoutService;

@RestController
@RequestMapping("/v1")
public class PayoutController {

    private PayoutService payoutService;

    @Autowired
    public PayoutController(PayoutService payoutService) {
        this.payoutService = payoutService;
    }

    @PostMapping("/payouts") //(http://localhost:8080/v1/payments/payouts)
    public ResponseEntity<createResponseDTO> createPayout(@RequestBody ItemsRequestDTO itemsRequestDTO)
    {
                //System.out.println(itemsRequestDTO.getEmpAddress()+"\n"+itemsRequestDTO.getEmpDeptName()+"\n"+itemsRequestDTO.getEmpName()+"\n"+itemsRequestDTO.getEmpSalary());
        return new ResponseEntity<>(payoutService.createPayout(itemsRequestDTO), HttpStatus.CREATED);
    }

   

   

    
}