package com.bfs.riskassesmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiskServiceImpl implements RiskService {
	
	@Autowired
	private DocumentApiClient documentApiClient;
	
	@Autowired
	private AddressApiClient addressApiClient;
	
	@Autowired
	private IdentityApiClient identityApiClient;

	@Override
	public float calculateRisk(String customerEmail) {
		boolean documentStatus = documentApiClient.getDocumentStatus(customerEmail);
		boolean addressStatus = addressApiClient.getAddressStatus(customerEmail);
		boolean identityStatus = identityApiClient.getIdentityStatus(customerEmail);
		
		
		float riskScore = 0;
		if(!documentStatus)
			riskScore+=33.33;
		if(!addressStatus)
			riskScore+=33.33;
		if(!identityStatus)
			riskScore+=33.33;
		
		
		return riskScore;
	}

}
