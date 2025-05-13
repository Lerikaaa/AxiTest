package org.example.myapp.service;

import org.example.myapp.dto.ApplicationDto;
import org.example.myapp.model.Client;
import org.example.myapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return (Client) clientRepository.findById(id).orElse(null);
    }

    public Client saveClient(Client client) {
        return (Client) clientRepository.save(client);
    }

    public Client saveClientFromApplication(ApplicationDto applicationDto){
        var search = clientRepository.findClientByPhone(applicationDto.getPhone());

        if (search.isPresent()){
            return search.get();
        }

        Client client = new Client();
        client.setFullName(applicationDto.getFio());
        client.setPassport(applicationDto.getPassport());
        client.setGender(applicationDto.getGender());
        client.setMaritalStatus(applicationDto.getMaritalStatus());
        client.setResidenceAddress(applicationDto.getResidence());
        client.setRegistrationAddress(applicationDto.getRegistration());
        client.setPhone(applicationDto.getPhone());

        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public List<Client> searchClient(String phone, String fio, String passport) {
        if (!ObjectUtils.isEmpty(phone)){
            phone = "%" + phone + "%";
        }
        if (!ObjectUtils.isEmpty(fio)){
            fio = "%" + fio + "%";
        }
        if (!ObjectUtils.isEmpty(passport)){
            passport = "%" + passport + "%";
        }
        
        if (!ObjectUtils.isEmpty(phone) && !ObjectUtils.isEmpty(fio) && !ObjectUtils.isEmpty(passport)){
            return clientRepository.findClientByPhoneLikeAndFullNameLikeAndPassportLike(phone, fio, passport);
        } else if (!ObjectUtils.isEmpty(phone) && !ObjectUtils.isEmpty(fio) && ObjectUtils.isEmpty(passport)) {
            return clientRepository.findClientByPhoneLikeAndFullNameLike(phone, fio);
        } else if(!ObjectUtils.isEmpty(phone) && ObjectUtils.isEmpty(fio) && !ObjectUtils.isEmpty(passport)){
            return clientRepository.findClientByPhoneLikeAndPassportLike(phone, passport);
        } else if (ObjectUtils.isEmpty(phone) && !ObjectUtils.isEmpty(fio) && !ObjectUtils.isEmpty(passport)) {
            return clientRepository.findClientByFullNameLikeAndPassportLike(fio, passport);
        } else if (!ObjectUtils.isEmpty(phone) && ObjectUtils.isEmpty(fio) && ObjectUtils.isEmpty(passport)) {
            return clientRepository.findClientByPhoneLike(phone);
        } else if (ObjectUtils.isEmpty(phone) && !ObjectUtils.isEmpty(fio) && ObjectUtils.isEmpty(passport)) {
            return clientRepository.findClientByFullNameLike(fio);
        } else if (ObjectUtils.isEmpty(phone) && ObjectUtils.isEmpty(fio) && !ObjectUtils.isEmpty(passport)) {
            return clientRepository.findClientByPassportLike(passport);
        } else{
            return List.of();
        }
    }
}