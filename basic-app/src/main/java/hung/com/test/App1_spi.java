package hung.com.test;

import java.util.Iterator;
import java.util.ServiceLoader;


import com.niaa.service.api.account.IAccount;

public class App1_spi {

	public static void main(String[] args) throws Exception {

			// use Java Reflection to load all implementations of API
		    // factory pattern to create object (new implementationClass )
		    ServiceLoader<IAccount> loader = ServiceLoader.load(IAccount.class);
			
			// iterator la kieu list of new ImplementationClass
			Iterator<IAccount> iterator = loader.iterator();
			
			int i = 1;
			while(iterator.hasNext()) {
				System.out.println("======== implementation class: "+ i);
				IAccount next = iterator.next();
				System.out.println("AccountType: "+ next.getAccountType());
				System.out.println("AccountId: "+ next.getAccountId());
				
			}

	}

}
