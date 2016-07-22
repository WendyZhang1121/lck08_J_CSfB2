package lck08_J_CSfB2;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class DateHandler {

	private final Date date = new Date(); 
	final Lock lock = new ReentrantLock();
	
	public void doSomething(String str) { 
		lock.lock();
		try {
			String dateString = date.toString();
			if (str != null && str.equals(dateString)) {
				// ... 
				}
			// ...
		} finally { lock.unlock();
		} 
	}
	
	public void testCase(final String testS){
		Thread test = new Thread(new Runnable() {
			public void run() {
				doSomething(testS);
				}
			});
			   test.start();
	}
	
	public void main(String[] args) throws IOException { 
		
		testCase("test1"); // starts thread 1 
		testCase("test2"); // starts thread 2
	}
}
