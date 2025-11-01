/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
   * Method under test: {@link WeaveAdminAuditable#getCreatedBy()}
   */
  @Test
  public void testGetCreatedBy() {
    // Arrange, Act and Assert
    assertNull((new WeaveAdminAuditable()).getCreatedBy());
  }

  /**
   * Method under test: {@link WeaveAdminAuditable#getDateCreated()}
   */
  @Test
  public void testGetDateCreated() {
    // Arrange, Act and Assert
    assertNull((new WeaveAdminAuditable()).getDateCreated());
  }

  /**
   * Method under test: {@link WeaveAdminAuditable#getDateUpdated()}
   */
  @Test
  public void testGetDateUpdated() {
    // Arrange, Act and Assert
    assertNull((new WeaveAdminAuditable()).getDateUpdated());
  }

  /**
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
   * Method under test: {@link WeaveAdminAuditable#setDateCreated(java.util.Date)}
   */
  @Test
  public void testSetDateCreated2() {
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
   * Method under test: {@link WeaveAdminAuditable#setDateUpdated(java.util.Date)}
   */
  @Test
  public void testSetDateUpdated2() {
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
   * Method under test: {@link WeaveAdminAuditable#getUpdatedBy()}
   */
  @Test
  public void testGetUpdatedBy() {
    // Arrange, Act and Assert
    assertNull((new WeaveAdminAuditable()).getUpdatedBy());
  }

  /**
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
