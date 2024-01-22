package com.goutham.leetcode.solutions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class StringManipulationTest {

	StringManipulation sm = null;
	
	@Before
	public void setUp() throws Exception {
		sm  = new StringManipulation();
	}
	
	@Test
	public void testReplaceString() {
		String str = "04-01-2022,redact,11-2222222,\"$2,000.20\", 678, test1, test2, \"$2,500.00\",yer,$500.00,\"$2,000.00\",test4,07-01-2022";
		String repStr = sm.replaceString(str);
		String expectedStr = "04-01-2022,redact,11-2222222,2000.20, 678, test1, test2, 2500.00,yer,500.00,2000.00,test4,07-01-2022";
		assertThat(repStr).isEqualTo(expectedStr);
	}

	
	@Test
	public void testReplaceString1() {
		String str = "04-01-2022,\"$5,000,000.00\",11-2222222,\"$2,000.20\", 678, test1, test2, \"$2,500.00\",$500.00,$500.00,$2,000.00,test4,07-01-2022";
		String repStr = sm.replaceString(str);
		String expectedStr = "04-01-2022,5000000.00,11-2222222,2000.20, 678, test1, test2, 2500.00,500.00,500.00,2000.00,test4,07-01-2022";
		assertThat(repStr).isEqualTo(expectedStr);
	}
	
	@Test
	public void testReplaceString2() {
		String str = "04-01-2022,\"$5,000,000.00\",11-2222222,\"$2,000,000.20\", 678, test1, test2, \"$2,500.00\",$500.00,$500.00,\"$2,000.00\",test4,07-01-2022,$0.00,$0.00,$0.00,\"$0.00\",\"$0.00\",1.00,2";
		String repStr = sm.replaceString(str);
		String expectedStr = "04-01-2022,5000000.00,11-2222222,2000000.20, 678, test1, test2, 2500.00,500.00,500.00,2000.00,test4,07-01-2022,0.00,0.00,0.00,0.00,0.00,1.00,2";
		assertThat(repStr).isEqualTo(expectedStr);
	}
	
	@Test
	public void testReplaceString3() {
		String str = "04-01-2022,\"$5,000,000.00\",11-2222222,\"$2,000,000.20\", 678, test1, test2, \"$2,500.00\",$500.00,$500.00,\"$2,000.00\",test4,07-01-2022,$0.00,$0.00,$0.00,\"$0.00\",\"$0.00\",1.00,2";
		String repStr = sm.replaceString(str);
		String expectedStr = "04-01-2022,5000000.00,11-2222222,2000000.20, 678, test1, test2, 2500.00,500.00,500.00,2000.00,test4,07-01-2022,0.00,0.00,0.00,0.00,0.00,1.00,2";
		assertThat(repStr).isEqualTo(expectedStr);
	}

}
