package hung.com.test;

import java.util.Iterator;
import java.util.ServiceLoader;


import com.niaa.service.api.account.IAccount;

/**
 * nếu dùng SPI (Service Provider Interface): thì chỉ lấy được singleton Object của class
 * Trong trường hợp muốn lấy nhiều Object của 1 class thì ko đc.
 */
public class App1_spi {

	public static void main(String[] args) throws Exception {

			/**
			 *  Case1: Implement SPI *.jar phải có trong ClassPath ở runtime ( or add vào pom.xml luôn)
			 *  
			 *  Case2: nếu implement SPI *.jar ko có trong ClassPath thì phải dùng ClassLoad để load *.jar trc khi gọi ServiceLoader.load(IAccount.class); 
			 */
		    ServiceLoader<IAccount> serviceLoader = ServiceLoader.load(IAccount.class); 
			
			/**
			 *  Nhược điểm của SPI là nó chỉ load instant là singleton
			 *  vd: common logging log4j2, slf4j, tracer, metric
			 *  
			 *  JDBC có thể dùng multi instance: vì 1 app có thể kết nối tới nhiều Database khác loại cùng lúc, nhiều địa chỉ cùng loại cùng lúc
			 */
			Iterator<IAccount> iterator = serviceLoader.iterator();
			
			int i = 1;
			// cách 1:
			System.out.println("================================================= cách 1:");
			while(iterator.hasNext()) {
				System.out.println("======== implementation class: "+ i);
				IAccount next = iterator.next();
				System.out.println("AccountType: "+ next.getAccountType());  //đã khởi tạo Object, ko còn là class nữa
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
