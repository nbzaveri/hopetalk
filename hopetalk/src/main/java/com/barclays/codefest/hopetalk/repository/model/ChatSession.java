package com.barclays.codefest.hopetalk.repository.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "TblChatSession")
@Getter
@Setter
public class ChatSession implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "ChatID")
    private int chatId;
    @Column(name = "TherapistID")
    private int therapistId;
    @Column(name = "ClientID")
    private int clientId;
    @Column(name = "ChatTime")
    private Timestamp startTime;
    @Column(name = "SenderID")
    private int senderId;
    @Column(name = "ChatInteraction")
    private String message;
}
