package iaiglsia.tp_hr.Services;

import iaiglsia.tp_hr.Repository.ClientRepository;
import iaiglsia.tp_hr.entity.client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ClientService_Imp implements ClientService{

    private ClientRepository clientRepository;
    @Override
    public List<client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public client createClient(client client) {
        return clientRepository.save(client);
    }

    @Override
    public client updateClient(Long id, client Client) {
        return clientRepository.findById(id)
                .map(cl -> {
                    cl.setNom(Client.getNom());
                    cl.setPrenom(Client.getPrenom());
                    cl.setAdresse(Client.getAdresse());
                    cl.setCourriel(Client.getCourriel());
                    cl.setNationalite(Client.getNationalite());
                    cl.setNumeroTelephone(Client.getNumeroTelephone());

                    return clientRepository.save(cl);
                }).orElseThrow(() -> new RuntimeException("Client modifier avec succès"));

    }

    @Override
    public String deleteClient(Long id) {
        clientRepository.deleteById(id);
        return "Client supprimer avec succès";
    }
}
