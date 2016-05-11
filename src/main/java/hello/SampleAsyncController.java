package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleAsyncController {
	@Autowired
	public SampleAsyncService sampleAsyncService;

	@RequestMapping(value = "/controller", method = RequestMethod.GET)
	@ResponseBody
	public String foo() {
		long time = System.currentTimeMillis();
		// Call Async service
		sampleAsyncService.sampleAsyncMethod();

		String response = String.format("Response completed in %d milliseconds.", (System.currentTimeMillis() - time));
		// you should see this message before the message in the async method
		System.out.println(response);

		return response;
	}
}
