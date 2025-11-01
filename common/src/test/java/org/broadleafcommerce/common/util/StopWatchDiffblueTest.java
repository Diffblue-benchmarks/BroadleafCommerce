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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
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
   * Method under test: {@link StopWatch#start()}
   */
  @Test
  public void testStart() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new StopWatch()).start());
  }

  /**
   * Method under test: {@link StopWatch#stop()}
   */
  @Test
  public void testStop() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act and Assert
    assertSame(stopWatch, stopWatch.stop());
  }

  /**
   * Method under test: {@link StopWatch#reset()}
   */
  @Test
  public void testReset() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act
    StopWatch actualResetResult = stopWatch.reset();

    // Assert
    assertEquals(0L, actualResetResult.getTime());
    assertSame(stopWatch, actualResetResult);
  }

  /**
   * Method under test: {@link StopWatch#split()}
   */
  @Test
  public void testSplit() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act and Assert
    assertSame(stopWatch, stopWatch.split());
  }

  /**
   * Method under test: {@link StopWatch#unsplit()}
   */
  @Test
  public void testUnsplit() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act and Assert
    assertSame(stopWatch, stopWatch.unsplit());
  }

  /**
   * Method under test: {@link StopWatch#suspend()}
   */
  @Test
  public void testSuspend() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act and Assert
    assertSame(stopWatch, stopWatch.suspend());
  }

  /**
   * Method under test: {@link StopWatch#resume()}
   */
  @Test
  public void testResume() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new StopWatch()).resume());
  }

  /**
   * Method under test: {@link StopWatch#printString(String)}
   */
  @Test
  public void testPrintString() {
    // Arrange, Act and Assert
    assertSame(stopWatch, stopWatch.printString("Msg"));
  }

  /**
   * Method under test: {@link StopWatch#printSplitString(String)}
   */
  @Test
  public void testPrintSplitString() {
    // Arrange, Act and Assert
    assertSame(stopWatch, stopWatch.printSplitString("Msg"));
  }

  /**
   * Method under test: {@link StopWatch#printLapString(String)}
   */
  @Test
  public void testPrintLapString() {
    // Arrange, Act and Assert
    assertSame(stopWatch, stopWatch.printLapString("Msg"));
  }
}
