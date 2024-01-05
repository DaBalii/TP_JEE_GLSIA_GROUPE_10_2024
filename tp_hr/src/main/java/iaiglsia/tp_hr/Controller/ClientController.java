package iaiglsia.tp_hr.Controller;




import iaiglsia.tp_hr.Services.ClientService;

import iaiglsia.tp_hr.Services.TransactionService;
import iaiglsia.tp_hr.Validator.ClientValidator;
import iaiglsia.tp_hr.entity.Transaction;
import iaiglsia.tp_hr.entity.client;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {
    @Autowired
    private ClientService clientService;

    private ClientValidator clientValidator;
    private TransactionService transactionService;


    @GetMapping
    public List<client> getAllClients() {
        return clientService.getAllClients();
    }


    @GetMapping("/{id}")
    public client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }


    @PostMapping("/create")
    public client createClient(@RequestBody client client, Errors errors) {

        clientValidator.validate(client, errors);
        if (errors.hasErrors()) {
            return null;
        }
        return clientService.createClient(client);
    }

    @PutMapping("/update/{id}")
    public client updateClient(@PathVariable Long id, @RequestBody client updatedClient,Errors errors) {

        clientValidator.validate(updatedClient, errors);
        if (errors.hasErrors()) {
            return null;
        }
        return clientService.updateClient(id, updatedClient);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "Client supprimer avec succès";
    }



}
