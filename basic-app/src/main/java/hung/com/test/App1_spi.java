package hung.com.test;

import java.util.Iterator;
import java.util.ServiceLoader;


import com.niaa.service.api.account.IAccount;


public class App1_spi {

	public static void main(String[] args) throws Exception {

			/**
			 *  use Java Reflection to load all implementations of API
			 *  factory pattern to create object (new implementationClass )
			 */
		    ServiceLoader<IAccount> serviceLoader = ServiceLoader.load(IAccount.class); 
			
			// iterator la kieu list of new ImplementationClass
			Iterator<IAccount> iterator = serviceLoader.iterator();
			
			int i = 1;
			// cách 1:
			System.out.println("================================================= cách 1:");
			while(iterator.hasNext()) {
				System.out.println("======== implementation class: "+ i);
				IAccount next = iterator.next();
				System.out.println("AccountType: "+ next.getAccountType());
				System.out.println("AccountId: "+ next.getAccountId());
				
			}
			
			// cách 2:
			i = 1;
			System.out.println("================================================= cách 2:");
			for (IAccount account : serviceLoader) {
		    	System.out.println("======== implementation class: "+ i++);
		    	System.out.println("AccountType: "+ account.getAccountType());
				System.out.println("AccountId: "+ account.getAccountId());
		    }
			
			// cách 3 (nên dùng): lambda java 8
			System.out.println("================================================= cách 3:");
			serviceLoader.forEach(account->{
				System.out.println("======== implementation class: ");
		    	System.out.println("AccountType: "+ account.getAccountType());
				System.out.println("AccountId: "+ account.getAccountId());
			});

	}

}
