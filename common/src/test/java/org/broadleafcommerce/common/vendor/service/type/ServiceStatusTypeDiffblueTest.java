package org.broadleafcommerce.common.vendor.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ServiceStatusTypeDiffblueTest {
  /**
   * Test {@link ServiceStatusType#equals(Object)}, and {@link ServiceStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ServiceStatusType#equals(Object)}
   *   <li>{@link ServiceStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ServiceStatusType.equals(Object)",
    "int ServiceStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ServiceStatusType serviceStatusType = ServiceStatusType.DOWN;
    ServiceStatusType serviceStatusType2 = ServiceStatusType.DOWN;

    // Act and Assert
    assertEquals(serviceStatusType, serviceStatusType2);
    assertEquals(serviceStatusType.hashCode(), serviceStatusType2.hashCode());
  }

  /**
   * Test {@link ServiceStatusType#equals(Object)}, and {@link ServiceStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ServiceStatusType#equals(Object)}
   *   <li>{@link ServiceStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ServiceStatusType.equals(Object)",
    "int ServiceStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ServiceStatusType serviceStatusType = new ServiceStatusType();
    ServiceStatusType serviceStatusType2 = new ServiceStatusType();

    // Act and Assert
    assertEquals(serviceStatusType, serviceStatusType2);
    assertEquals(serviceStatusType.hashCode(), serviceStatusType2.hashCode());
  }

  /**
   * Test {@link ServiceStatusType#equals(Object)}, and {@link ServiceStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ServiceStatusType#equals(Object)}
   *   <li>{@link ServiceStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ServiceStatusType.equals(Object)",
    "int ServiceStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ServiceStatusType serviceStatusType = ServiceStatusType.DOWN;

    // Act and Assert
    assertEquals(serviceStatusType, serviceStatusType);
    int expectedHashCodeResult = serviceStatusType.hashCode();
    assertEquals(expectedHashCodeResult, serviceStatusType.hashCode());
  }

  /**
   * Test {@link ServiceStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ServiceStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ServiceStatusType.equals(Object)",
    "int ServiceStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ServiceStatusType.PAUSED, ServiceStatusType.DOWN);
  }

  /**
   * Test {@link ServiceStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ServiceStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ServiceStatusType.equals(Object)",
    "int ServiceStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ServiceStatusType(), ServiceStatusType.DOWN);
  }

  /**
   * Test {@link ServiceStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ServiceStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ServiceStatusType.equals(Object)",
    "int ServiceStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ServiceStatusType.DOWN, null);
  }

  /**
   * Test {@link ServiceStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ServiceStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ServiceStatusType.equals(Object)",
    "int ServiceStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ServiceStatusType.DOWN, "Different type to ServiceStatusType");
  }
}
