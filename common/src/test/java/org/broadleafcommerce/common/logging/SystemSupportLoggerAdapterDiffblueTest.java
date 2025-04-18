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
package org.broadleafcommerce.common.logging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SystemSupportLoggerAdapterDiffblueTest {
  /**
   * Test {@link SystemSupportLoggerAdapter#getShowDateTime()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getShowDateTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SystemSupportLoggerAdapter.getShowDateTime()"})
  public void testGetShowDateTime() {
    // Arrange, Act and Assert
    assertTrue((new SystemSupportLoggerAdapter()).getShowDateTime());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getDateFormatter()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getDateFormatter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DateFormat SystemSupportLoggerAdapter.getDateFormatter()"})
  public void testGetDateFormatter() {
    // Arrange and Act
    DateFormat actualDateFormatter = (new SystemSupportLoggerAdapter()).getDateFormatter();

    // Assert
    assertTrue(actualDateFormatter.getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualDateFormatter instanceof SimpleDateFormat);
    assertTrue(actualDateFormatter.getCalendar() instanceof GregorianCalendar);
    assertEquals("HH:mm:ss", ((SimpleDateFormat) actualDateFormatter).toPattern());
    assertTrue(actualDateFormatter.isLenient());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getShowThreadName()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getShowThreadName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SystemSupportLoggerAdapter.getShowThreadName()"})
  public void testGetShowThreadName() {
    // Arrange, Act and Assert
    assertFalse((new SystemSupportLoggerAdapter()).getShowThreadName());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getShowLogName()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getShowLogName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SystemSupportLoggerAdapter.getShowLogName()"})
  public void testGetShowLogName() {
    // Arrange, Act and Assert
    assertTrue((new SystemSupportLoggerAdapter()).getShowLogName());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getLevelInBrackets()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getLevelInBrackets()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SystemSupportLoggerAdapter.getLevelInBrackets()"})
  public void testGetLevelInBrackets() {
    // Arrange, Act and Assert
    assertTrue((new SystemSupportLoggerAdapter()).getLevelInBrackets());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getShowNonSupportLevels()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getShowNonSupportLevels()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SystemSupportLoggerAdapter.getShowNonSupportLevels()"})
  public void testGetShowNonSupportLevels() {
    // Arrange, Act and Assert
    assertFalse((new SystemSupportLoggerAdapter()).getShowNonSupportLevels());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SystemSupportLoggerAdapter}
   *   <li>{@link SystemSupportLoggerAdapter#setName(String)}
   *   <li>{@link SystemSupportLoggerAdapter#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SystemSupportLoggerAdapter.<init>()", "String SystemSupportLoggerAdapter.getName()",
      "void SystemSupportLoggerAdapter.setName(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SystemSupportLoggerAdapter actualSystemSupportLoggerAdapter = new SystemSupportLoggerAdapter();
    actualSystemSupportLoggerAdapter.setName("Name");

    // Assert
    assertEquals("Name", actualSystemSupportLoggerAdapter.getName());
  }
}
