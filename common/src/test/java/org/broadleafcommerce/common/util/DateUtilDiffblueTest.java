package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DateUtilDiffblueTest {
  /**
   * Test {@link DateUtil#isActive(Date, Date, boolean)}.
   *
   * <ul>
   *   <li>When {@link Date#Date()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DateUtil#isActive(Date, Date, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DateUtil.isActive(Date, Date, boolean)"})
  public void testIsActive_whenDate_thenReturnFalse() {
    // Arrange
    Date startDate = new Date();

    // Act
    boolean actualIsActiveResult =
        DateUtil.isActive(
            startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            true);

    // Assert
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link DateUtil#isActive(Date, Date, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DateUtil#isActive(Date, Date, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DateUtil.isActive(Date, Date, boolean)"})
  public void testIsActive_whenFalse_thenReturnFalse() {
    // Arrange
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boolean actualIsActiveResult =
        DateUtil.isActive(
            startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            false);

    // Assert
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link DateUtil#isActive(Date, Date, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DateUtil#isActive(Date, Date, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DateUtil.isActive(Date, Date, boolean)"})
  public void testIsActive_whenNull_thenReturnFalse() {
    // Arrange and Act
    boolean actualIsActiveResult =
        DateUtil.isActive(
            null,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            false);

    // Assert
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link DateUtil#isActive(Date, Date, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DateUtil#isActive(Date, Date, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DateUtil.isActive(Date, Date, boolean)"})
  public void testIsActive_whenTrue_thenReturnFalse() {
    // Arrange
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boolean actualIsActiveResult =
        DateUtil.isActive(
            startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            true);

    // Assert
    assertFalse(actualIsActiveResult);
  }
}
