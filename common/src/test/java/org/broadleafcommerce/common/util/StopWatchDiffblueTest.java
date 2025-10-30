/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {StopWatch.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StopWatchDiffblueTest {
  @Autowired
  private StopWatch stopWatch;

  /**
   * Test {@link StopWatch#start()}.
   * <p>
   * Method under test: {@link StopWatch#start()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StopWatch StopWatch.start()"})
  public void testStart() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new StopWatch()).start());
  }

  /**
   * Test {@link StopWatch#stop()}.
   * <p>
   * Method under test: {@link StopWatch#stop()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StopWatch StopWatch.stop()"})
  public void testStop() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act and Assert
    assertSame(stopWatch, stopWatch.stop());
  }

  /**
   * Test {@link StopWatch#reset()}.
   * <p>
   * Method under test: {@link StopWatch#reset()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StopWatch StopWatch.reset()"})
  public void testReset() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act and Assert
    assertSame(stopWatch, stopWatch.reset());
  }

  /**
   * Test {@link StopWatch#split()}.
   * <p>
   * Method under test: {@link StopWatch#split()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StopWatch StopWatch.split()"})
  public void testSplit() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act and Assert
    assertSame(stopWatch, stopWatch.split());
  }

  /**
   * Test {@link StopWatch#unsplit()}.
   * <p>
   * Method under test: {@link StopWatch#unsplit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StopWatch StopWatch.unsplit()"})
  public void testUnsplit() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act and Assert
    assertSame(stopWatch, stopWatch.unsplit());
  }

  /**
   * Test {@link StopWatch#suspend()}.
   * <p>
   * Method under test: {@link StopWatch#suspend()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StopWatch StopWatch.suspend()"})
  public void testSuspend() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act and Assert
    assertSame(stopWatch, stopWatch.suspend());
  }

  /**
   * Test {@link StopWatch#resume()}.
   * <p>
   * Method under test: {@link StopWatch#resume()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StopWatch StopWatch.resume()"})
  public void testResume() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new StopWatch()).resume());
  }

  /**
   * Test {@link StopWatch#printString(String)}.
   * <p>
   * Method under test: {@link StopWatch#printString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StopWatch StopWatch.printString(String)"})
  public void testPrintString() {
    // Arrange, Act and Assert
    assertSame(stopWatch, stopWatch.printString("Msg"));
  }

  /**
   * Test {@link StopWatch#printSplitString(String)}.
   * <p>
   * Method under test: {@link StopWatch#printSplitString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StopWatch StopWatch.printSplitString(String)"})
  public void testPrintSplitString() {
    // Arrange, Act and Assert
    assertSame(stopWatch, stopWatch.printSplitString("Msg"));
  }

  /**
   * Test {@link StopWatch#printLapString(String)}.
   * <p>
   * Method under test: {@link StopWatch#printLapString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StopWatch StopWatch.printLapString(String)"})
  public void testPrintLapString() {
    // Arrange, Act and Assert
    assertSame(stopWatch, stopWatch.printLapString("Msg"));
  }
}
