/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.openadmin.audit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;

public class AdminAuditableDiffblueTest {
  /**
   * Test {@link AdminAuditable#equals(Object)}, and
   * {@link AdminAuditable#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminAuditable#equals(Object)}
   *   <li>{@link AdminAuditable#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertEquals(adminAuditable, adminAuditable2);
    int expectedHashCodeResult = adminAuditable.hashCode();
    assertEquals(expectedHashCodeResult, adminAuditable2.hashCode());
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}, and
   * {@link AdminAuditable#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminAuditable#equals(Object)}
   *   <li>{@link AdminAuditable#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(null);
    adminAuditable
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(null);
    adminAuditable2
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertEquals(adminAuditable, adminAuditable2);
    int expectedHashCodeResult = adminAuditable.hashCode();
    assertEquals(expectedHashCodeResult, adminAuditable2.hashCode());
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}, and
   * {@link AdminAuditable#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminAuditable#equals(Object)}
   *   <li>{@link AdminAuditable#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(null);
    adminAuditable
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2.setDateCreated(null);
    adminAuditable2
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertEquals(adminAuditable, adminAuditable2);
    int expectedHashCodeResult = adminAuditable.hashCode();
    assertEquals(expectedHashCodeResult, adminAuditable2.hashCode());
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}, and
   * {@link AdminAuditable#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminAuditable#equals(Object)}
   *   <li>{@link AdminAuditable#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(null);
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setDateUpdated(null);
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertEquals(adminAuditable, adminAuditable2);
    int expectedHashCodeResult = adminAuditable.hashCode();
    assertEquals(expectedHashCodeResult, adminAuditable2.hashCode());
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}, and
   * {@link AdminAuditable#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminAuditable#equals(Object)}
   *   <li>{@link AdminAuditable#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(null);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(null);

    // Act and Assert
    assertEquals(adminAuditable, adminAuditable2);
    int expectedHashCodeResult = adminAuditable.hashCode();
    assertEquals(expectedHashCodeResult, adminAuditable2.hashCode());
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}, and
   * {@link AdminAuditable#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminAuditable#equals(Object)}
   *   <li>{@link AdminAuditable#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    // Act and Assert
    assertEquals(adminAuditable, adminAuditable);
    int expectedHashCodeResult = adminAuditable.hashCode();
    assertEquals(expectedHashCodeResult, adminAuditable.hashCode());
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(0L);
    adminAuditable
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(null);
    adminAuditable
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable.setDateCreated(null);
    adminAuditable
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setDateUpdated(null);
    adminAuditable.setUpdatedBy(1L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(0L);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(null);

    AdminAuditable adminAuditable2 = new AdminAuditable();
    adminAuditable2.setCreatedBy(1L);
    adminAuditable2
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable2.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, adminAuditable2);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, null);
  }

  /**
   * Test {@link AdminAuditable#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAuditable#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AdminAuditable adminAuditable = new AdminAuditable();
    adminAuditable.setCreatedBy(1L);
    adminAuditable
        .setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable
        .setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    adminAuditable.setUpdatedBy(1L);

    // Act and Assert
    assertNotEquals(adminAuditable, "Different type to AdminAuditable");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminAuditable actualAdminAuditable = new AdminAuditable();
    actualAdminAuditable.setCreatedBy(1L);
    Date dateCreated = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualAdminAuditable.setDateCreated(dateCreated);
    Date dateUpdated = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualAdminAuditable.setDateUpdated(dateUpdated);
    actualAdminAuditable.setUpdatedBy(1L);
    Long actualCreatedBy = actualAdminAuditable.getCreatedBy();
    Date actualDateCreated = actualAdminAuditable.getDateCreated();
    Date actualDateUpdated = actualAdminAuditable.getDateUpdated();
    Long actualUpdatedBy = actualAdminAuditable.getUpdatedBy();

    // Assert that nothing has changed
    assertEquals(1L, actualCreatedBy.longValue());
    assertEquals(1L, actualUpdatedBy.longValue());
    assertSame(dateCreated, actualDateCreated);
    assertSame(dateUpdated, actualDateUpdated);
  }
}
