package com.bfs.kycservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentVerificationDto {
private Long docId;
private String docType;
private String docNumber;
private String customerEmail;
private String docAddress;
}
