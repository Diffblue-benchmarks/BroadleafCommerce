/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class SiteReindexCommandDiffblueTest {
  /**
   * Method under test: {@link SiteReindexCommand#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SiteReindexCommand siteReindexCommand = new SiteReindexCommand(2L);

    // Act and Assert
    assertNotEquals(siteReindexCommand, new SiteReindexCommand(1L));
  }

  /**
   * Method under test: {@link SiteReindexCommand#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SiteReindexCommand(1L), null);
  }

  /**
   * Method under test: {@link SiteReindexCommand#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SiteReindexCommand(1L), "Different type to SiteReindexCommand");
  }

  /**
   * Method under test: {@link SiteReindexCommand#getSiteId()}
   */
  @Test
  public void testGetSiteId() {
    // Arrange, Act and Assert
    assertEquals(1L, (new SiteReindexCommand(1L)).getSiteId().longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SiteReindexCommand#equals(Object)}
   *   <li>{@link SiteReindexCommand#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SiteReindexCommand siteReindexCommand = new SiteReindexCommand(1L);
    SiteReindexCommand siteReindexCommand2 = new SiteReindexCommand(1L);

    // Act and Assert
    assertEquals(siteReindexCommand, siteReindexCommand2);
    int expectedHashCodeResult = siteReindexCommand.hashCode();
    assertEquals(expectedHashCodeResult, siteReindexCommand2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SiteReindexCommand#equals(Object)}
   *   <li>{@link SiteReindexCommand#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SiteReindexCommand siteReindexCommand = new SiteReindexCommand(1L);

    // Act and Assert
    assertEquals(siteReindexCommand, siteReindexCommand);
    int expectedHashCodeResult = siteReindexCommand.hashCode();
    assertEquals(expectedHashCodeResult, siteReindexCommand.hashCode());
  }

  /**
   * Method under test: {@link SiteReindexCommand#SiteReindexCommand(Long)}
   */
  @Test
  public void testNewSiteReindexCommand() {
    // Arrange, Act and Assert
    assertEquals(1L, (new SiteReindexCommand(1L)).getSiteId().longValue());
  }
}
