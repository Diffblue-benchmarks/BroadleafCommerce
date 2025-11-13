package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Autowired private StopWatch stopWatch;

  /**
   * Test {@link StopWatch#start()}.
   *
   * <p>Method under test: {@link StopWatch#start()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StopWatch StopWatch.start()"})
  public void testStart() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new StopWatch().start());
  }

  /**
   * Test {@link StopWatch#stop()}.
   *
   * <p>Method under test: {@link StopWatch#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StopWatch StopWatch.stop()"})
  public void testStop() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act
    StopWatch actualStopResult = stopWatch.stop();

    // Assert
    assertSame(stopWatch, actualStopResult);
  }

  /**
   * Test {@link StopWatch#reset()}.
   *
   * <p>Method under test: {@link StopWatch#reset()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StopWatch StopWatch.reset()"})
  public void testReset() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act
    StopWatch actualResetResult = stopWatch.reset();

    // Assert
    assertSame(stopWatch, actualResetResult);
  }

  /**
   * Test {@link StopWatch#split()}.
   *
   * <p>Method under test: {@link StopWatch#split()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StopWatch StopWatch.split()"})
  public void testSplit() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act
    StopWatch actualSplitResult = stopWatch.split();

    // Assert
    assertSame(stopWatch, actualSplitResult);
  }

  /**
   * Test {@link StopWatch#unsplit()}.
   *
   * <p>Method under test: {@link StopWatch#unsplit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StopWatch StopWatch.unsplit()"})
  public void testUnsplit() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act
    StopWatch actualUnsplitResult = stopWatch.unsplit();

    // Assert
    assertSame(stopWatch, actualUnsplitResult);
  }

  /**
   * Test {@link StopWatch#suspend()}.
   *
   * <p>Method under test: {@link StopWatch#suspend()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StopWatch StopWatch.suspend()"})
  public void testSuspend() {
    // Arrange
    StopWatch stopWatch = new StopWatch();

    // Act
    StopWatch actualSuspendResult = stopWatch.suspend();

    // Assert
    assertSame(stopWatch, actualSuspendResult);
  }

  /**
   * Test {@link StopWatch#resume()}.
   *
   * <p>Method under test: {@link StopWatch#resume()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StopWatch StopWatch.resume()"})
  public void testResume() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new StopWatch().resume());
  }

  /**
   * Test {@link StopWatch#printString(String)}.
   *
   * <p>Method under test: {@link StopWatch#printString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StopWatch StopWatch.printString(String)"})
  public void testPrintString() {
    // Arrange and Act
    StopWatch actualPrintStringResult = stopWatch.printString("Msg");

    // Assert
    assertSame(stopWatch, actualPrintStringResult);
  }

  /**
   * Test {@link StopWatch#printSplitString(String)}.
   *
   * <p>Method under test: {@link StopWatch#printSplitString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StopWatch StopWatch.printSplitString(String)"})
  public void testPrintSplitString() {
    // Arrange and Act
    StopWatch actualPrintSplitStringResult = stopWatch.printSplitString("Msg");

    // Assert
    assertSame(stopWatch, actualPrintSplitStringResult);
  }

  /**
   * Test {@link StopWatch#printLapString(String)}.
   *
   * <p>Method under test: {@link StopWatch#printLapString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StopWatch StopWatch.printLapString(String)"})
  public void testPrintLapString() {
    // Arrange and Act
    StopWatch actualPrintLapStringResult = stopWatch.printLapString("Msg");

    // Assert
    assertSame(stopWatch, actualPrintLapStringResult);
  }
}
