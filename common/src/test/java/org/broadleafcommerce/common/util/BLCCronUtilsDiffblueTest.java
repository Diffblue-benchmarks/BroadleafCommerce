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
   *   <li>When {@code 42L-9}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_when42l9() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("42L-9"));
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
   *   <li>When {@code L-9}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_whenL9() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("L-9"));
  }

  /**
   * Test {@link BLCCronUtils#getNextValidTime(String)}.
   *
   * <ul>
   *   <li>When {@code L-942}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_whenL942() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("L-942"));
  }

  /**
   * Test {@link BLCCronUtils#getNextValidTime(String)}.
   *
   * <ul>
   *   <li>When {@code L-94242}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Date BLCCronUtils.getNextValidTime(String)"})
  public void testGetNextValidTime_whenL94242() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("L-94242"));
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
   *   <li>When {@code 42L-9}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_when42l9() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("42L-9"));
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
   *   <li>When {@code L-9}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_whenL9() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("L-9"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code L-942}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_whenL942() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("L-942"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code L-9 42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_whenL9422() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("L-9 42"));
  }

  /**
   * Test {@link BLCCronUtils#isValidExpression(String)}.
   *
   * <ul>
   *   <li>When {@code L-94242}.
   * </ul>
   *
   * <p>Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BLCCronUtils.isValidExpression(String)"})
  public void testIsValidExpression_whenL94242() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("L-94242"));
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
