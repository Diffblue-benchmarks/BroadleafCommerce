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
package org.broadleafcommerce.openadmin.weave;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.openadmin.audit.AdminAuditable;
import org.junit.Test;

public class WeaveAdminAuditableDiffblueTest {
  /**
   * Test {@link WeaveAdminAuditable#getCreatedBy()}.
   * <p>
   * Method under test: {@link WeaveAdminAuditable#getCreatedBy()}
   */
  @Test
  public void testGetCreatedBy() {
    // Arrange, Act and Assert
    assertNull((new WeaveAdminAuditable()).getCreatedBy());
  }

  /**
   * Test {@link WeaveAdminAuditable#getDateCreated()}.
   * <p>
   * Method under test: {@link WeaveAdminAuditable#getDateCreated()}
   */
  @Test
  public void testGetDateCreated() {
    // Arrange, Act and Assert
    assertNull((new WeaveAdminAuditable()).getDateCreated());
  }

  /**
   * Test {@link WeaveAdminAuditable#getDateUpdated()}.
   * <p>
   * Method under test: {@link WeaveAdminAuditable#getDateUpdated()}
   */
  @Test
  public void testGetDateUpdated() {
    // Arrange, Act and Assert
    assertNull((new WeaveAdminAuditable()).getDateUpdated());
  }

  /**
   * Test {@link WeaveAdminAuditable#setDateCreated(Date)}.
   * <p>
   * Method under test: {@link WeaveAdminAuditable#setDateCreated(Date)}
   */
  @Test
  public void testSetDateCreated() {
    // Arrange
    WeaveAdminAuditable weaveAdminAuditable = new WeaveAdminAuditable();
    Date dateCreated = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    weaveAdminAuditable.setDateCreated(dateCreated);

    // Assert
    assertSame(dateCreated, weaveAdminAuditable.auditable.getDateCreated());
    assertSame(dateCreated, weaveAdminAuditable.getDateCreated());
  }

  /**
   * Test {@link WeaveAdminAuditable#setDateCreated(Date)}.
   * <ul>
   *   <li>When {@link java.sql.Date}.</li>
   *   <li>Then {@link WeaveAdminAuditable} (default constructor)
   * {@link WeaveAdminAuditable#auditable} DateCreated is
   * {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveAdminAuditable#setDateCreated(java.util.Date)}
   */
  @Test
  public void testSetDateCreated_whenDate_thenWeaveAdminAuditableAuditableDateCreatedIsDate() {
    // Arrange
    WeaveAdminAuditable weaveAdminAuditable = new WeaveAdminAuditable();
    java.sql.Date dateCreated = mock(java.sql.Date.class);

    // Act
    weaveAdminAuditable.setDateCreated(dateCreated);

    // Assert
    assertSame(dateCreated, weaveAdminAuditable.auditable.getDateCreated());
    assertSame(dateCreated, weaveAdminAuditable.getDateCreated());
  }

  /**
   * Test {@link WeaveAdminAuditable#setDateUpdated(Date)}.
   * <p>
   * Method under test: {@link WeaveAdminAuditable#setDateUpdated(Date)}
   */
  @Test
  public void testSetDateUpdated() {
    // Arrange
    WeaveAdminAuditable weaveAdminAuditable = new WeaveAdminAuditable();
    Date dateUpdated = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    weaveAdminAuditable.setDateUpdated(dateUpdated);

    // Assert
    assertSame(dateUpdated, weaveAdminAuditable.auditable.getDateUpdated());
    assertSame(dateUpdated, weaveAdminAuditable.getDateUpdated());
  }

  /**
   * Test {@link WeaveAdminAuditable#setDateUpdated(Date)}.
   * <ul>
   *   <li>When {@link java.sql.Date}.</li>
   *   <li>Then {@link WeaveAdminAuditable} (default constructor)
   * {@link WeaveAdminAuditable#auditable} DateUpdated is
   * {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveAdminAuditable#setDateUpdated(java.util.Date)}
   */
  @Test
  public void testSetDateUpdated_whenDate_thenWeaveAdminAuditableAuditableDateUpdatedIsDate() {
    // Arrange
    WeaveAdminAuditable weaveAdminAuditable = new WeaveAdminAuditable();
    java.sql.Date dateUpdated = mock(java.sql.Date.class);

    // Act
    weaveAdminAuditable.setDateUpdated(dateUpdated);

    // Assert
    assertSame(dateUpdated, weaveAdminAuditable.auditable.getDateUpdated());
    assertSame(dateUpdated, weaveAdminAuditable.getDateUpdated());
  }

  /**
   * Test {@link WeaveAdminAuditable#setCreatedBy(Long)}.
   * <p>
   * Method under test: {@link WeaveAdminAuditable#setCreatedBy(Long)}
   */
  @Test
  public void testSetCreatedBy() {
    // Arrange
    WeaveAdminAuditable weaveAdminAuditable = new WeaveAdminAuditable();

    // Act
    weaveAdminAuditable.setCreatedBy(1L);

    // Assert
    assertEquals(1L, weaveAdminAuditable.auditable.getCreatedBy().longValue());
    assertEquals(1L, weaveAdminAuditable.getCreatedBy().longValue());
  }

  /**
   * Test {@link WeaveAdminAuditable#getUpdatedBy()}.
   * <p>
   * Method under test: {@link WeaveAdminAuditable#getUpdatedBy()}
   */
  @Test
  public void testGetUpdatedBy() {
    // Arrange, Act and Assert
    assertNull((new WeaveAdminAuditable()).getUpdatedBy());
  }

  /**
   * Test {@link WeaveAdminAuditable#setUpdatedBy(Long)}.
   * <p>
   * Method under test: {@link WeaveAdminAuditable#setUpdatedBy(Long)}
   */
  @Test
  public void testSetUpdatedBy() {
    // Arrange
    WeaveAdminAuditable weaveAdminAuditable = new WeaveAdminAuditable();

    // Act
    weaveAdminAuditable.setUpdatedBy(1L);

    // Assert
    assertEquals(1L, weaveAdminAuditable.auditable.getUpdatedBy().longValue());
    assertEquals(1L, weaveAdminAuditable.getUpdatedBy().longValue());
  }

  /**
   * Test {@link WeaveAdminAuditable#getEmbeddableAdminAuditable(boolean)}.
   * <p>
   * Method under test:
   * {@link WeaveAdminAuditable#getEmbeddableAdminAuditable(boolean)}
   */
  @Test
  public void testGetEmbeddableAdminAuditable() {
    // Arrange
    WeaveAdminAuditable weaveAdminAuditable = new WeaveAdminAuditable();

    // Act and Assert
    assertSame(weaveAdminAuditable.auditable, weaveAdminAuditable.getEmbeddableAdminAuditable(true));
  }

  /**
   * Test new {@link WeaveAdminAuditable} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link WeaveAdminAuditable}
   */
  @Test
  public void testNewWeaveAdminAuditable() {
    // Arrange and Act
    WeaveAdminAuditable actualWeaveAdminAuditable = new WeaveAdminAuditable();

    // Assert
    AdminAuditable adminAuditable = actualWeaveAdminAuditable.auditable;
    assertNull(adminAuditable.getCreatedBy());
    assertNull(adminAuditable.getUpdatedBy());
    assertNull(actualWeaveAdminAuditable.getCreatedBy());
    assertNull(actualWeaveAdminAuditable.getUpdatedBy());
    assertNull(adminAuditable.getDateCreated());
    assertNull(adminAuditable.getDateUpdated());
    assertNull(actualWeaveAdminAuditable.getDateCreated());
    assertNull(actualWeaveAdminAuditable.getDateUpdated());
  }
}
