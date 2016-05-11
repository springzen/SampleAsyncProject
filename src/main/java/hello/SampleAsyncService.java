package hello;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SampleAsyncService {
	@Async
	public void sampleAsyncMethod() {
		long time = System.currentTimeMillis();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// We've been interrupted
			System.out.println(String.format("Task interrupted after %d milliseconds", System.currentTimeMillis() - time));
			return;
		}

		System.out.println(String.format("Task completed after %d milliseconds", System.currentTimeMillis() - time));
	}
}
