package com.leetcode;

import org.apache.commons.lang.time.StopWatch;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
  private StopWatch stopWatch = new StopWatch();
  @Before
  public void before(){
    stopWatch.start();
  }
  @After
  public void after(){
    System.out.println(stopWatch.getTime()+"ms");
  }
}
