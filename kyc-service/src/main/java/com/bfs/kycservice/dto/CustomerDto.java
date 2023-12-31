package com.bfs.kycservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private int id;
private String customerName;
private String customerEmail;
private String customerMobile;
private String customerAddress;
private String status;
}
