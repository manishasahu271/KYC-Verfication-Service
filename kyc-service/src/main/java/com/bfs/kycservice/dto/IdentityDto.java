package com.bfs.kycservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IdentityDto {
    private Long id;
    private String identityVerificationStatus;
    private String customerEmail;

}
