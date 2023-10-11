package com.barclays.codefest.hopetalk.repository;

import com.barclays.codefest.hopetalk.repository.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
}
