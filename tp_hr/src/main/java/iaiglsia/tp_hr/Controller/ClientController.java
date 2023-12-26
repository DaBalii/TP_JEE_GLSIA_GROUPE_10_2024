package iaiglsia.tp_hr.Controller;

import iaiglsia.tp_hr.Services.ClientService;
import iaiglsia.tp_hr.entity.client;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<client> getAllClients() {
        return clientService.getAllClients();
    }


    @GetMapping("/{id}")
    public client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }


    @PostMapping("/create")
    public client createClient(@RequestBody client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/update/{id}")
    public client updateClient(@PathVariable Long id, @RequestBody client updatedClient) {
        return clientService.updateClient(id, updatedClient);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "Client supprimer avec succès";
    }

}
