package com.infrrd.regrex;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class MainController {

	@PostMapping("/matchpattern")
	public Object matchPattern(@RequestBody Expression exp) throws InterruptedException, ExecutionException
	{
		
		JsonOutput jsonOutput= new JsonOutput("",true);
		
		PatternMatcher job= new PatternMatcher(exp.getRegex(),exp.getTextBody(),jsonOutput);
		Thread thread= new Thread(job);
		
		thread.start();
		
				
		ScheduledExecutorService  scheduler= Executors.newScheduledThreadPool(1);
		
		
		scheduler.schedule(()->{
			thread.stop();
		}, 10, TimeUnit.MILLISECONDS);
		
		return jsonOutput;
		
	}

}
