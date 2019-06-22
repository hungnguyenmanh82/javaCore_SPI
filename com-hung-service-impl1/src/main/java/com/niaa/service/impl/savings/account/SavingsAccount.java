package com.niaa.service.impl.savings.account;

import com.niaa.service.api.account.IAccount;

/**
IAccount is API of SPI
SavingsAccount is a implementation of API of SPI.

fileName: /src/main/resources/META-INF/services/<fullName-of-api>
		/src/main/resources/META-INF/services/com.niaa.service.api.account.IAccount
 */
public class SavingsAccount implements IAccount {

	public String getAccountType() {
		return "SavingsAccount";
	}

	public String getAccountId() {
		
		return "1";
	}

}
