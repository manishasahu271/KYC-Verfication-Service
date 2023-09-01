package com.bfs.document.model;

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
@Table(name = "document_verification")
public class DocumentVerification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long docId;
    @Column
    private String docType;
    @Column
    private String docNumber;
    @Column
    private String docStatus;
    @Column
    private String customerEmail;
    @Column
    private String docAddress;
}
