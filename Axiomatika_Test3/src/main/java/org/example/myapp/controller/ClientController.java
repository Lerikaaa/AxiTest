package org.example.myapp.controller;

import org.example.myapp.dto.ApplicationDto;
import org.example.myapp.dto.SearchClientDto;
import org.example.myapp.model.Client;
import org.example.myapp.model.LoanApplication;
import org.example.myapp.service.ClientService;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients.html")
    public String getAllClients(Model model) {
        model.addAttribute("listClients", clientService.getAllClients());
        return "clients";
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/search")
    public List<Client> searchClient(@RequestParam(required = false) String phone, @RequestParam(required = false) String fio, @RequestParam(required = false) String passport) {
        return clientService.searchClient(phone, fio, passport);
    }

    @PostMapping(value = "/searchClient.html", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String showClientSearchForm(SearchClientDto searchClient, Model model) {
        List<Client> clients = clientService.searchClient(searchClient.getPhone(), searchClient.getFio(), searchClient.getPassport());
        model.addAttribute("clients", clients);
        return getSearchClients(model);
    }

    @GetMapping("/searchClient.html")
    public String getSearchClients(Model model) {
        return "searchClient";
    }
}
