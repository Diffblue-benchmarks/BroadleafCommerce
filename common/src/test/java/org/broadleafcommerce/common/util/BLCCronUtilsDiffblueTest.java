package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BLCCronUtilsDiffblueTest {
  /**
   * Test {@link BLCCronUtils#getNextValidTime(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_when42() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("42"));
  }

  /**
   * Test {@link BLCCronUtils#getNextValidTime(String)}.
   *
   * <ul>
   *   <li>When {@code 42Unable to parse the given cron expression:}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_when42UnableToParseTheGivenCronExpression() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("42Unable to parse the given cron expression: "));
  }

  /**
   * Test {@link BLCCronUtils#getNextValidTime(String)}.
   *
   * <ul>
   *   <li>When {@code 42L-44}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_when42l44() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("42L-44"));
  }

  /**
   * Test {@link BLCCronUtils#getNextValidTime(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_when4242() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("4242"));
  }

  /**
   * Test {@link BLCCronUtils#getNextValidTime(String)}.
   *
   * <ul>
   *   <li>When {@code 4242Unable to parse the given cron expression:}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_when4242UnableToParseTheGivenCronExpression() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("4242Unable to parse the given cron expression: "));
  }

  /**
   * Test {@link BLCCronUtils#getNextValidTime(String)}.
   *
   * <ul>
   *   <li>When {@code Cron}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_whenCron() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("Cron"));
  }

  /**
   * Test {@link BLCCronUtils#getNextValidTime(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime(""));
  }

  /**
   * Test {@link BLCCronUtils#getNextValidTime(String)}.
   *
   * <ul>
   *   <li>When {@code L-44}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_whenL44() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("L-44"));
  }

  /**
   * Test {@link BLCCronUtils#getNextValidTime(String)}.
   *
   * <ul>
   *   <li>When {@code L-4442}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_whenL4442() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("L-4442"));
  }

  /**
   * Test {@link BLCCronUtils#getNextValidTime(String)}.
   *
   * <ul>
   *   <li>When {@code L-444242}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_whenL444242() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("L-444242"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_when42() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("42"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code 42Cron}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_when42Cron() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("42Cron"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code 42L-44}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_when42l44() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("42L-44"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_when4242() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("4242"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code 4242Cron}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_when4242Cron() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("4242Cron"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code Cron}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_whenCron() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("Cron"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code L-44}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_whenL44() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("L-44"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code L-4442}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_whenL4442() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("L-4442"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code L-44 42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_whenL44422() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("L-44 42"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code L-444242}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_whenL444242() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("L-444242"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_whenNull() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression(null));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When space.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_whenSpace() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression(" "));
  }
}
