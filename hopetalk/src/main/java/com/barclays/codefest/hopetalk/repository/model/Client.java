package com.barclays.codefest.hopetalk.repository.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "TblClient")
@Getter
@Setter
public class Client {

    @Id
    @Column(name = "ClientID")
    private int clientID;

    @Column(name = "ClientFName")
    private String clientFName;

    @Column(name = "ClientLName")
    private String clientLName;

    @Column(name = "ClientAddress")
    private String clientAddress;

    @Column(name = "ClientPhone")
    private String clientPhone;

    @Column(name = "ClientWaiting")
    private boolean clientWaiting;
}
