package com.bfs.kycservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
    @Column
    private String customerName;
    @Column
    private String customerEmail;
    @Column
    private String customerMobile;
    @Column
    private String customerAddress;
    @Column
    private String customerDocNumber;
    @Column
    private String status;
}
