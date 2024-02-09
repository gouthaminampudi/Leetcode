package com.goutham.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class RegexEmailsTest {

	@Test
	public void testAddCommas() {
		RegexEmails re = new RegexEmails();
		String emails = "Sabnis, Abhishek <Abhishek.Sabnis@LibertyMutual.com>; Lepine, Dale <DALE.LEPINE@LibertyMutual.com>; Stacey, Darryl (LIT) <Darryl.Stacey@Liberty-IT.co.uk>; Friedmann, Deborah <DEBORAH.FRIEDMANN@LibertyMutual.com>; Stahler, Heather <HEATHER.STAHLER@LibertyMutual.com>; Stults, Jeffrey <JEFFREY.STULTS@LibertyMutual.com>; Taylor, John P <JohnPaul.Taylor@LibertyMutual.com>; Stafford, Jonathan <JONATHAN.STAFFORD@LibertyMutual.com>; Javvaji, Kishore <Kishore.Javvaji@libertymutual.com>; Woodsmall, Michael <Michael.Woodsmall@LibertyMutual.com>; Lichti, Nolan <NOLAN.LICHTI@LibertyMutual.com>; Ramiya Desikan, Senthilkumar <Senthilkumar.RamiyaDesikan@libertymutual.com>; Piacenti, Gabriel <Gabriel.Piacenti@LibertyMutual.com>; Kondapalli, Hari <HARI.KONDAPALLI@LibertyMutual.com>; Heck, James <JAMES.HECK@LibertyMutual.com>; Kaster, Matthew <MATTHEW.KASTER@LibertyMutual.com>; Samant, Rahul <Rahul.Samant@LibertyMutual.com>; Gilles, Ryan <Ryan.Gilles@LibertyMutual.com>; Bappudi, Sanjay <Sanjay.Bappudi@LibertyMutual.com>; Tibrewal, Sanjay <SANJAY.TIBREWAL@LibertyMutual.com>; Ramiya Desikan, Senthilkumar <Senthilkumar.RamiyaDesikan@libertymutual.com>; Li, Wei <WEI.LI@LibertyMutual.com>";
		System.out.println(re.addCommas(emails));
	
	}

	
	
	
	@Test
	public void testThreads() {
		ExecutorService service = Executors.newCachedThreadPool();
		final int[] arr = new int[10000]; 
		for(int i=0;i<10000;i++) {
			final int index = i;
			final int num = i;
			Runnable r1 = new Runnable() {

				@Override
				public void run() {
					arr[index] = num+1200;
					System.out.println(arr[index]);
				}
				
			};
			service.execute(new TestTask(r1));
		}
		
		System.out.println("This is length->"+arr.length);
		
	}
	
	
	
	public static class TestTask implements Runnable{
		Runnable r1;
		public TestTask (Runnable r1) {
			this.r1 = r1;
		}
		@Override
		public void run() {

			this.r1.run();
		}
	}
	
	
	
	@Test
	public void testThreadsOne() {
	    int numThreads = 10000;
	    List<Future<Integer>> results = new ArrayList<>();
	    ExecutorService service = Executors.newCachedThreadPool();
	    
	    try {
	        for (int i = 0; i < numThreads; i++) {
	            final int num = i;
	            Callable<Integer> task = () -> num + 1200;
	            results.add(service.submit(task));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        service.shutdown();
	    }
	    
	    System.out.println("This is length -> " + results.size());
	    for (Future<Integer> result : results) {
	        try {
	            System.out.println(result.get());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
}
