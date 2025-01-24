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
import org.junit.Ignore;
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
   * Test new {@link StopWatch} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link StopWatch}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewStopWatch() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Method may be time-sensitive.
    //   Diffblue Cover was only able to write tests that are time-sensitive.
    //   The assertions don't pass when run at an alternate date, time, and
    //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
    //   that the time can be parameterized during testing.
    //   See Working with code R031 (https://diff.blue/R031) for details.

    // Arrange and Act
    new StopWatch();
  }

  /**
   * Test {@link StopWatch#start()}.
   * <p>
   * Method under test: {@link StopWatch#start()}
   */
  @Test
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
  public void testResume() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new StopWatch()).resume());
  }

  /**
   * Test {@link StopWatch#getTime()}.
   * <p>
   * Method under test: {@link StopWatch#getTime()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTime() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Method may be time-sensitive.
    //   Diffblue Cover was only able to write tests that are time-sensitive.
    //   The assertions don't pass when run at an alternate date, time, and
    //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
    //   that the time can be parameterized during testing.
    //   See Working with code R031 (https://diff.blue/R031) for details.

    // Arrange and Act
    (new StopWatch()).getTime();
  }

  /**
   * Test {@link StopWatch#getSplitTime()}.
   * <p>
   * Method under test: {@link StopWatch#getSplitTime()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSplitTime() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Method may be time-sensitive.
    //   Diffblue Cover was only able to write tests that are time-sensitive.
    //   The assertions don't pass when run at an alternate date, time, and
    //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
    //   that the time can be parameterized during testing.
    //   See Working with code R031 (https://diff.blue/R031) for details.

    // Arrange and Act
    (new StopWatch()).getSplitTime();
  }

  /**
   * Test {@link StopWatch#getLapTime()}.
   * <p>
   * Method under test: {@link StopWatch#getLapTime()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLapTime() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Method may be time-sensitive.
    //   Diffblue Cover was only able to write tests that are time-sensitive.
    //   The assertions don't pass when run at an alternate date, time, and
    //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
    //   that the time can be parameterized during testing.
    //   See Working with code R031 (https://diff.blue/R031) for details.

    // Arrange and Act
    (new StopWatch()).getLapTime();
  }

  /**
   * Test {@link StopWatch#getStartTime()}.
   * <p>
   * Method under test: {@link StopWatch#getStartTime()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetStartTime() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Method may be time-sensitive.
    //   Diffblue Cover was only able to write tests that are time-sensitive.
    //   The assertions don't pass when run at an alternate date, time, and
    //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
    //   that the time can be parameterized during testing.
    //   See Working with code R031 (https://diff.blue/R031) for details.

    // Arrange and Act
    (new StopWatch()).getStartTime();
  }

  /**
   * Test {@link StopWatch#toString()}.
   * <p>
   * Method under test: {@link StopWatch#toString()}
   */
  @Test
  public void testToString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     StopWatch.runningState
    //     StopWatch.splitState
    //     StopWatch.startTime
    //     StopWatch.stopTime

    // Arrange and Act
    (new StopWatch()).toString();
  }

  /**
   * Test {@link StopWatch#toSplitString()}.
   * <p>
   * Method under test: {@link StopWatch#toSplitString()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testToSplitString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Method may be time-sensitive.
    //   Diffblue Cover was only able to write tests that are time-sensitive.
    //   The assertions don't pass when run at an alternate date, time, and
    //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
    //   that the time can be parameterized during testing.
    //   See Working with code R031 (https://diff.blue/R031) for details.

    // Arrange and Act
    (new StopWatch()).toSplitString();
  }

  /**
   * Test {@link StopWatch#toLapString()}.
   * <p>
   * Method under test: {@link StopWatch#toLapString()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testToLapString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Method may be time-sensitive.
    //   Diffblue Cover was only able to write tests that are time-sensitive.
    //   The assertions don't pass when run at an alternate date, time, and
    //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
    //   that the time can be parameterized during testing.
    //   See Working with code R031 (https://diff.blue/R031) for details.

    // Arrange and Act
    (new StopWatch()).toLapString();
  }

  /**
   * Test {@link StopWatch#printString(String)}.
   * <p>
   * Method under test: {@link StopWatch#printString(String)}
   */
  @Test
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
  public void testPrintLapString() {
    // Arrange, Act and Assert
    assertSame(stopWatch, stopWatch.printLapString("Msg"));
  }
}
