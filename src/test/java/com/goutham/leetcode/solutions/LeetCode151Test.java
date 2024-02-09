package com.goutham.leetcode.solutions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class LeetCode151Test {

    LeetCode151 leetCode151;
    @Before
    public void setup(){
        leetCode151 = new LeetCode151(); 
    }


    @Test
    @Parameters({
        "the sky is blue|blue is sky the|true",
        "  hello world  |world hello|false",
        "a good   example|example good a|false"
		
	})
    public void testReverseWords(String val,String expectedVal,boolean result) {
        String reversed = leetCode151.reverseWords(val);
        assertThat(reversed).isEqualTo(expectedVal);

    }
}
