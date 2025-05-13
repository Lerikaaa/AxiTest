package org.example.myapp.repository;

import org.example.myapp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findClientByPhoneLikeAndFullNameLikeAndPassportLike(String phone, String fullName, String passport);
    List<Client> findClientByPhoneLikeAndFullNameLike(String phone, String fullName);
    List<Client> findClientByPhoneLikeAndPassportLike(String phone, String passport);
    List<Client> findClientByFullNameLikeAndPassportLike(String fullName, String passport);

    List<Client> findClientByPhoneLike(String phone);
    List<Client> findClientByFullNameLike(String fullName);
    List<Client> findClientByPassportLike(String passport);

    Optional<Client> findClientByPhone(String phone);
}