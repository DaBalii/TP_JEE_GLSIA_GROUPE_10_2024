package iaiglsia.tp_hr.Services;

import iaiglsia.tp_hr.entity.client;

import java.util.List;

public interface ClientService {

    public List<client> getAllClients();

    public client getClientById(Long id);

    public client createClient(client client);

    public client updateClient(Long id, client updatedClient);

    public String deleteClient(Long id);
}
