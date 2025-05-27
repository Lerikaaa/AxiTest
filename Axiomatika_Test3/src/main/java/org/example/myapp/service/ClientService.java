package org.example.myapp.service;

import org.example.myapp.dto.ApplicationDto;
import org.example.myapp.model.Client;
import org.example.myapp.repository.ClientRepositoryH;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class ClientService {

    ClientRepositoryH clientRepositoryH = new ClientRepositoryH();

    public List<Client> getAllClients() {
        return clientRepositoryH.findAll();
    }

    public Client getClientById(Long id) {
        return (Client) clientRepositoryH.findById(id).orElse(null);
    }

    public Client saveClient(Client client) {
        return (Client) clientRepositoryH.save(client);
    }

    public Client saveClientFromApplication(ApplicationDto applicationDto){
        var search = new ClientRepositoryH().findClientByPhone(applicationDto.getPhone());

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

        return clientRepositoryH.save(client);
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
            return clientRepositoryH.findClientByPhoneLikeAndFullNameLikeAndPassportLike(phone, fio, passport);
        } else if (!ObjectUtils.isEmpty(phone) && !ObjectUtils.isEmpty(fio) && ObjectUtils.isEmpty(passport)) {
            return clientRepositoryH.findClientByPhoneLikeAndFullNameLike(phone, fio);
        } else if(!ObjectUtils.isEmpty(phone) && ObjectUtils.isEmpty(fio) && !ObjectUtils.isEmpty(passport)){
            return clientRepositoryH.findClientByPhoneLikeAndPassportLike(phone, passport);
        } else if (ObjectUtils.isEmpty(phone) && !ObjectUtils.isEmpty(fio) && !ObjectUtils.isEmpty(passport)) {
            return clientRepositoryH.findClientByFullNameLikeAndPassportLike(fio, passport);
        } else if (!ObjectUtils.isEmpty(phone) && ObjectUtils.isEmpty(fio) && ObjectUtils.isEmpty(passport)) {
            return clientRepositoryH.findClientByPhoneLike(phone);
        } else if (ObjectUtils.isEmpty(phone) && !ObjectUtils.isEmpty(fio) && ObjectUtils.isEmpty(passport)) {
            return clientRepositoryH.findClientByFullNameLike(fio);
        } else if (ObjectUtils.isEmpty(phone) && ObjectUtils.isEmpty(fio) && !ObjectUtils.isEmpty(passport)) {
            return clientRepositoryH.findClientByPassportLike(passport);
        } else{
            return List.of();
        }
    }
}