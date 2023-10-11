package com.barclays.codefest.hopetalk.repository.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
@Entity
@Table(name = "something")
@Getter
@Setter
public class ChatSession  implements Cloneable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
private int chatId;

private int therapistId;
private int clientId;
private Timestamp startTime;
private int senderId;
private String message;
        }
