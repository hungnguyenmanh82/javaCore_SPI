package com.niaa.service.impl.current.account;

import com.niaa.service.api.account.IAccount;

/**
IAccount is API of SPI
CurrentAccount is a implementation of API of SPI.

fileName: /src/main/resources/META-INF/services/<fullName-of-api>
		/src/main/resources/META-INF/services/com.niaa.service.api.account.IAccount
 */
public class CurrentAccount implements IAccount {

	public String getAccountType() {
		return "CurrentAccount";
	}

	public String getAccountId() {
		return "2";
	}

}
