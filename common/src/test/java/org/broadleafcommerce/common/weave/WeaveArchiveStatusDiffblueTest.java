/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.weave;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class WeaveArchiveStatusDiffblueTest {
  /**
   * Test {@link WeaveArchiveStatus#setArchived(Character)}.
   * <p>
   * Method under test: {@link WeaveArchiveStatus#setArchived(Character)}
   */
  @Test
  public void testSetArchived() {
    // Arrange
    WeaveArchiveStatus weaveArchiveStatus = new WeaveArchiveStatus();

    // Act
    weaveArchiveStatus.setArchived('A');

    // Assert
    assertEquals('A', weaveArchiveStatus.archiveStatus.getArchived().charValue());
    assertEquals('A', weaveArchiveStatus.getArchived().charValue());
  }

  /**
   * Test {@link WeaveArchiveStatus#getArchived()}.
   * <p>
   * Method under test: {@link WeaveArchiveStatus#getArchived()}
   */
  @Test
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', (new WeaveArchiveStatus()).getArchived().charValue());
  }

  /**
   * Test {@link WeaveArchiveStatus#isActive()}.
   * <p>
   * Method under test: {@link WeaveArchiveStatus#isActive()}
   */
  @Test
  public void testIsActive() {
    // Arrange, Act and Assert
    assertTrue((new WeaveArchiveStatus()).isActive());
  }

  /**
   * Test new {@link WeaveArchiveStatus} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link WeaveArchiveStatus}
   */
  @Test
  public void testNewWeaveArchiveStatus() {
    // Arrange and Act
    WeaveArchiveStatus actualWeaveArchiveStatus = new WeaveArchiveStatus();

    // Assert
    assertEquals('N', actualWeaveArchiveStatus.getArchived().charValue());
    assertNull(actualWeaveArchiveStatus.archiveStatus);
  }
}
