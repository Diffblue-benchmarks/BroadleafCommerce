package org.broadleafcommerce.core.inventory.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.core.inventory.service.type.AvailabilityStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SkuAvailabilityImplDiffblueTest {
  /**
   * Test {@link SkuAvailabilityImpl#getAvailabilityStatus()}.
   *
   * <p>Method under test: {@link SkuAvailabilityImpl#getAvailabilityStatus()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AvailabilityStatusType SkuAvailabilityImpl.getAvailabilityStatus()"})
  public void testGetAvailabilityStatus() {
    // Arrange, Act and Assert
    assertNull(new SkuAvailabilityImpl().getAvailabilityStatus());
  }

  /**
   * Test {@link SkuAvailabilityImpl#setAvailabilityStatus(AvailabilityStatusType)}.
   *
   * <p>Method under test: {@link SkuAvailabilityImpl#setAvailabilityStatus(AvailabilityStatusType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType)"})
  public void testSetAvailabilityStatus() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    // Act
    skuAvailabilityImpl.setAvailabilityStatus(null);

    // Assert that nothing has changed
    assertEquals("AVAILABLE", skuAvailabilityImpl.availabilityStatus);
  }

  /**
   * Test {@link SkuAvailabilityImpl#setAvailabilityStatus(AvailabilityStatusType)}.
   *
   * <ul>
   *   <li>Then {@link SkuAvailabilityImpl} (default constructor) AvailabilityStatus is {@link
   *       AvailabilityStatusType#AVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link SkuAvailabilityImpl#setAvailabilityStatus(AvailabilityStatusType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType)"})
  public void testSetAvailabilityStatus_thenSkuAvailabilityImplAvailabilityStatusIsAvailable() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();

    // Act
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);

    // Assert
    assertEquals("AVAILABLE", skuAvailabilityImpl.availabilityStatus);
    assertSame(AvailabilityStatusType.AVAILABLE, skuAvailabilityImpl.getAvailabilityStatus());
  }

  /**
   * Test {@link SkuAvailabilityImpl#getAvailableQuantity()}.
   *
   * <ul>
   *   <li>Given {@link SkuAvailabilityImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuAvailabilityImpl#getAvailableQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SkuAvailabilityImpl.getAvailableQuantity()"})
  public void testGetAvailableQuantity_givenSkuAvailabilityImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SkuAvailabilityImpl().getAvailableQuantity());
  }

  /**
   * Test {@link SkuAvailabilityImpl#getAvailableQuantity()}.
   *
   * <ul>
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SkuAvailabilityImpl#getAvailableQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SkuAvailabilityImpl.getAvailableQuantity()"})
  public void testGetAvailableQuantity_thenReturnIntValueIsOne() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setSkuId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(null);

    // Act and Assert
    assertEquals(1, skuAvailabilityImpl.getAvailableQuantity().intValue());
  }

  /**
   * Test {@link SkuAvailabilityImpl#getAvailableQuantity()}.
   *
   * <ul>
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link SkuAvailabilityImpl#getAvailableQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SkuAvailabilityImpl.getAvailableQuantity()"})
  public void testGetAvailableQuantity_thenReturnIntValueIsZero() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setSkuId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);

    // Act and Assert
    assertEquals(0, skuAvailabilityImpl.getAvailableQuantity().intValue());
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}, and {@link SkuAvailabilityImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAvailabilityImpl#equals(Object)}
   *   <li>{@link SkuAvailabilityImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuAvailabilityImpl.equals(Object)",
    "int SkuAvailabilityImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
    assertEquals(skuAvailabilityImpl.hashCode(), skuAvailabilityImpl2.hashCode());
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}, and {@link SkuAvailabilityImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAvailabilityImpl#equals(Object)}
   *   <li>{@link SkuAvailabilityImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuAvailabilityImpl.equals(Object)",
    "int SkuAvailabilityImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(null);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
    assertEquals(skuAvailabilityImpl.hashCode(), skuAvailabilityImpl2.hashCode());
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}, and {@link SkuAvailabilityImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAvailabilityImpl#equals(Object)}
   *   <li>{@link SkuAvailabilityImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuAvailabilityImpl.equals(Object)",
    "int SkuAvailabilityImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(null);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
    assertEquals(skuAvailabilityImpl.hashCode(), skuAvailabilityImpl2.hashCode());
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}, and {@link SkuAvailabilityImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAvailabilityImpl#equals(Object)}
   *   <li>{@link SkuAvailabilityImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuAvailabilityImpl.equals(Object)",
    "int SkuAvailabilityImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(null);
    skuAvailabilityImpl.setLocationId(null);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(null);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
    assertEquals(skuAvailabilityImpl.hashCode(), skuAvailabilityImpl2.hashCode());
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}, and {@link SkuAvailabilityImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAvailabilityImpl#equals(Object)}
   *   <li>{@link SkuAvailabilityImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuAvailabilityImpl.equals(Object)",
    "int SkuAvailabilityImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(null);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(null);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(null);

    // Act and Assert
    assertEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
    assertEquals(skuAvailabilityImpl.hashCode(), skuAvailabilityImpl2.hashCode());
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}, and {@link SkuAvailabilityImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAvailabilityImpl#equals(Object)}
   *   <li>{@link SkuAvailabilityImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuAvailabilityImpl.equals(Object)",
    "int SkuAvailabilityImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    // Act and Assert
    assertEquals(skuAvailabilityImpl, skuAvailabilityImpl);
    int expectedHashCodeResult = skuAvailabilityImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuAvailabilityImpl.hashCode());
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuAvailabilityImpl.equals(Object)",
    "int SkuAvailabilityImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(2L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuAvailabilityImpl.equals(Object)",
    "int SkuAvailabilityImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(null);
    skuAvailabilityImpl.setLocationId(2L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuAvailabilityImpl.equals(Object)",
    "int SkuAvailabilityImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(null);
    skuAvailabilityImpl.setLocationId(null);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuAvailabilityImpl.equals(Object)",
    "int SkuAvailabilityImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(null);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(2L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuAvailabilityImpl.equals(Object)",
    "int SkuAvailabilityImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(null);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(null);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuAvailabilityImpl.equals(Object)",
    "int SkuAvailabilityImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, null);
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuAvailabilityImpl.equals(Object)",
    "int SkuAvailabilityImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, "Different type to SkuAvailabilityImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SkuAvailabilityImpl}
   *   <li>{@link SkuAvailabilityImpl#setAvailabilityDate(Date)}
   *   <li>{@link SkuAvailabilityImpl#setId(Long)}
   *   <li>{@link SkuAvailabilityImpl#setLocationId(Long)}
   *   <li>{@link SkuAvailabilityImpl#setQuantityOnHand(Integer)}
   *   <li>{@link SkuAvailabilityImpl#setReserveQuantity(Integer)}
   *   <li>{@link SkuAvailabilityImpl#setSkuId(Long)}
   *   <li>{@link SkuAvailabilityImpl#getAvailabilityDate()}
   *   <li>{@link SkuAvailabilityImpl#getId()}
   *   <li>{@link SkuAvailabilityImpl#getLocationId()}
   *   <li>{@link SkuAvailabilityImpl#getQuantityOnHand()}
   *   <li>{@link SkuAvailabilityImpl#getReserveQuantity()}
   *   <li>{@link SkuAvailabilityImpl#getSkuId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuAvailabilityImpl.<init>()",
    "Date SkuAvailabilityImpl.getAvailabilityDate()",
    "Long SkuAvailabilityImpl.getId()",
    "Long SkuAvailabilityImpl.getLocationId()",
    "Integer SkuAvailabilityImpl.getQuantityOnHand()",
    "Integer SkuAvailabilityImpl.getReserveQuantity()",
    "Long SkuAvailabilityImpl.getSkuId()",
    "void SkuAvailabilityImpl.setAvailabilityDate(Date)",
    "void SkuAvailabilityImpl.setId(Long)",
    "void SkuAvailabilityImpl.setLocationId(Long)",
    "void SkuAvailabilityImpl.setQuantityOnHand(Integer)",
    "void SkuAvailabilityImpl.setReserveQuantity(Integer)",
    "void SkuAvailabilityImpl.setSkuId(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuAvailabilityImpl actualSkuAvailabilityImpl = new SkuAvailabilityImpl();
    Date availabilityDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualSkuAvailabilityImpl.setAvailabilityDate(availabilityDate);
    actualSkuAvailabilityImpl.setId(1L);
    actualSkuAvailabilityImpl.setLocationId(1L);
    actualSkuAvailabilityImpl.setQuantityOnHand(1);
    actualSkuAvailabilityImpl.setReserveQuantity(1);
    actualSkuAvailabilityImpl.setSkuId(1L);
    Date actualAvailabilityDate = actualSkuAvailabilityImpl.getAvailabilityDate();
    Long actualId = actualSkuAvailabilityImpl.getId();
    Long actualLocationId = actualSkuAvailabilityImpl.getLocationId();
    Integer actualQuantityOnHand = actualSkuAvailabilityImpl.getQuantityOnHand();
    Integer actualReserveQuantity = actualSkuAvailabilityImpl.getReserveQuantity();
    Long actualSkuId = actualSkuAvailabilityImpl.getSkuId();

    // Assert
    assertEquals(1, actualQuantityOnHand.intValue());
    assertEquals(1, actualReserveQuantity.intValue());
    assertEquals(1L, actualId.longValue());
    assertEquals(1L, actualLocationId.longValue());
    assertEquals(1L, actualSkuId.longValue());
    assertSame(availabilityDate, actualAvailabilityDate);
  }
}
