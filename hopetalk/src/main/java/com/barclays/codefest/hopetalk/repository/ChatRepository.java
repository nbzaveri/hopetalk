package com.barclays.codefest.hopetalk.repository;

import com.barclays.codefest.hopetalk.repository.model.ChatSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatSession, Integer>  {


}
