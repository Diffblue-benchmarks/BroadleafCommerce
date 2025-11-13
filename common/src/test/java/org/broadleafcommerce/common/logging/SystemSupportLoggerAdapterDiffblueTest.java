package org.broadleafcommerce.common.logging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Method under test: {@link SystemSupportLoggerAdapter#getShowDateTime()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemSupportLoggerAdapter.getShowDateTime()"})
  public void testGetShowDateTime() {
    // Arrange, Act and Assert
    assertTrue(new SystemSupportLoggerAdapter().getShowDateTime());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getDateFormatter()}.
   *
   * <p>Method under test: {@link SystemSupportLoggerAdapter#getDateFormatter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DateFormat SystemSupportLoggerAdapter.getDateFormatter()"})
  public void testGetDateFormatter() {
    // Arrange and Act
    DateFormat actualDateFormatter = new SystemSupportLoggerAdapter().getDateFormatter();

    // Assert
    assertTrue(actualDateFormatter.getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualDateFormatter instanceof SimpleDateFormat);
    assertTrue(actualDateFormatter.getCalendar() instanceof GregorianCalendar);
    assertEquals("HH:mm:ss", ((SimpleDateFormat) actualDateFormatter).toPattern());
    assertTrue(actualDateFormatter.isLenient());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getShowThreadName()}.
   *
   * <p>Method under test: {@link SystemSupportLoggerAdapter#getShowThreadName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemSupportLoggerAdapter.getShowThreadName()"})
  public void testGetShowThreadName() {
    // Arrange, Act and Assert
    assertFalse(new SystemSupportLoggerAdapter().getShowThreadName());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getShowLogName()}.
   *
   * <p>Method under test: {@link SystemSupportLoggerAdapter#getShowLogName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemSupportLoggerAdapter.getShowLogName()"})
  public void testGetShowLogName() {
    // Arrange, Act and Assert
    assertTrue(new SystemSupportLoggerAdapter().getShowLogName());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getLevelInBrackets()}.
   *
   * <p>Method under test: {@link SystemSupportLoggerAdapter#getLevelInBrackets()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemSupportLoggerAdapter.getLevelInBrackets()"})
  public void testGetLevelInBrackets() {
    // Arrange, Act and Assert
    assertTrue(new SystemSupportLoggerAdapter().getLevelInBrackets());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getShowNonSupportLevels()}.
   *
   * <p>Method under test: {@link SystemSupportLoggerAdapter#getShowNonSupportLevels()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemSupportLoggerAdapter.getShowNonSupportLevels()"})
  public void testGetShowNonSupportLevels() {
    // Arrange, Act and Assert
    assertFalse(new SystemSupportLoggerAdapter().getShowNonSupportLevels());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SystemSupportLoggerAdapter}
   *   <li>{@link SystemSupportLoggerAdapter#setName(String)}
   *   <li>{@link SystemSupportLoggerAdapter#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SystemSupportLoggerAdapter.<init>()",
    "String SystemSupportLoggerAdapter.getName()",
    "void SystemSupportLoggerAdapter.setName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SystemSupportLoggerAdapter actualSystemSupportLoggerAdapter = new SystemSupportLoggerAdapter();
    actualSystemSupportLoggerAdapter.setName("Name");

    // Assert
    assertEquals("Name", actualSystemSupportLoggerAdapter.getName());
  }
}
