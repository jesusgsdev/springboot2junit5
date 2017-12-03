package com.jesusgsdev.controllers;

import com.jesusgsdev.dtos.PurchaseRequestDTO;
import com.jesusgsdev.dtos.PurchaseResponseDTO;
import com.jesusgsdev.facades.PurchaseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    PurchaseFacade purchaseFacade;

    @PostMapping
    public PurchaseResponseDTO addBook(@RequestBody @Valid PurchaseRequestDTO purchaseRequestDTO) {
        return purchaseFacade.performPurchase(purchaseRequestDTO);
    }

    @GetMapping
    public List<PurchaseResponseDTO> findPurchasesByCustomerEmail(String email){
        return purchaseFacade.findPurchasesByCustomerEmail(email);
    }

}
