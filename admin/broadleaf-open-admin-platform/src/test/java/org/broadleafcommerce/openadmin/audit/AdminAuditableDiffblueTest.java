package org.broadleafcommerce.openadmin.audit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminAuditableDiffblueTest {
  /**
   * Test {@link AdminAuditable#equals(Object)}, and {@link AdminAuditable#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminAuditable#equals(Object)}
   *   <li>{@link AdminAuditable#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertEquals(adminAuditable, adminAuditable2);
    assertEquals(adminAuditable.hashCode(), adminAuditable2.hashCode());
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}, and {@link AdminAuditable#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminAuditable#equals(Object)}
   *   <li>{@link AdminAuditable#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(null);
    adminAuditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(null);
    adminAuditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertEquals(adminAuditable, adminAuditable2);
    assertEquals(adminAuditable.hashCode(), adminAuditable2.hashCode());
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}, and {@link AdminAuditable#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminAuditable#equals(Object)}
   *   <li>{@link AdminAuditable#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(null);
    adminAuditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2.setDateCreated(null);
    adminAuditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertEquals(adminAuditable, adminAuditable2);
    assertEquals(adminAuditable.hashCode(), adminAuditable2.hashCode());
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}, and {@link AdminAuditable#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminAuditable#equals(Object)}
   *   <li>{@link AdminAuditable#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(null);
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setDateUpdated(null);
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertEquals(adminAuditable, adminAuditable2);
    assertEquals(adminAuditable.hashCode(), adminAuditable2.hashCode());
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}, and {@link AdminAuditable#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminAuditable#equals(Object)}
   *   <li>{@link AdminAuditable#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(null);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(null);

    // Act and Assert
    assertEquals(adminAuditable, adminAuditable2);
    assertEquals(adminAuditable.hashCode(), adminAuditable2.hashCode());
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}, and {@link AdminAuditable#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminAuditable#equals(Object)}
   *   <li>{@link AdminAuditable#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    // Act and Assert
    assertEquals(adminAuditable, adminAuditable);
    int expectedHashCodeResult = adminAuditable.hashCode();
    assertEquals(expectedHashCodeResult, adminAuditable.hashCode());
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(0L);
    adminAuditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(null);
    adminAuditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(new Date());
    adminAuditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(null);
    adminAuditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(new Date());
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(null);
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(0L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(null);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, null);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminAuditable.equals(Object)", "int AdminAuditable.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, "Different type to AdminAuditable");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminAuditable}
   *   <li>{@link AdminAuditable#setCreatedBy(Long)}
   *   <li>{@link AdminAuditable#setDateCreated(Date)}
   *   <li>{@link AdminAuditable#setDateUpdated(Date)}
   *   <li>{@link AdminAuditable#setUpdatedBy(Long)}
   *   <li>{@link AdminAuditable#getCreatedBy()}
   *   <li>{@link AdminAuditable#getDateCreated()}
   *   <li>{@link AdminAuditable#getDateUpdated()}
   *   <li>{@link AdminAuditable#getUpdatedBy()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminAuditable.<init>()",
    "Long AdminAuditable.getCreatedBy()",
    "Date AdminAuditable.getDateCreated()",
    "Date AdminAuditable.getDateUpdated()",
    "Long AdminAuditable.getUpdatedBy()",
    "void AdminAuditable.setCreatedBy(Long)",
    "void AdminAuditable.setDateCreated(Date)",
    "void AdminAuditable.setDateUpdated(Date)",
    "void AdminAuditable.setUpdatedBy(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminAuditable actualAdminAuditable = new AdminAuditable();
    actualAdminAuditable.setCreatedBy(1L);
    Date dateCreated =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualAdminAuditable.setDateCreated(dateCreated);
    Date dateUpdated =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualAdminAuditable.setDateUpdated(dateUpdated);
    actualAdminAuditable.setUpdatedBy(1L);
    Long actualCreatedBy = actualAdminAuditable.getCreatedBy();
    Date actualDateCreated = actualAdminAuditable.getDateCreated();
    Date actualDateUpdated = actualAdminAuditable.getDateUpdated();
    Long actualUpdatedBy = actualAdminAuditable.getUpdatedBy();

    // Assert
    assertEquals(1L, actualCreatedBy.longValue());
    assertEquals(1L, actualUpdatedBy.longValue());
    assertSame(dateCreated, actualDateCreated);
    assertSame(dateUpdated, actualDateUpdated);
  }
}
