/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.weave;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WeaveArchiveStatusDiffblueTest {
  /**
   * Test {@link WeaveArchiveStatus#setArchived(Character)}.
   *
   * <ul>
   *   <li>Given {@link WeaveArchiveStatus} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link WeaveArchiveStatus#setArchived(Character)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WeaveArchiveStatus.setArchived(Character)"})
  public void testSetArchived_givenWeaveArchiveStatus() {
    // Arrange
    WeaveArchiveStatus weaveArchiveStatus = new WeaveArchiveStatus();

    // Act
    weaveArchiveStatus.setArchived('A');

    // Assert
    assertEquals('A', weaveArchiveStatus.archiveStatus.getArchived().charValue());
    assertEquals('A', weaveArchiveStatus.getArchived().charValue());
  }

  /**
   * Test {@link WeaveArchiveStatus#setArchived(Character)}.
   *
   * <ul>
   *   <li>Given {@link WeaveArchiveStatus} (default constructor) Archived is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link WeaveArchiveStatus#setArchived(Character)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WeaveArchiveStatus.setArchived(Character)"})
  public void testSetArchived_givenWeaveArchiveStatusArchivedIsA() {
    // Arrange
    WeaveArchiveStatus weaveArchiveStatus = new WeaveArchiveStatus();
    weaveArchiveStatus.setArchived('A');

    // Act
    weaveArchiveStatus.setArchived('A');

    // Assert that nothing has changed
    assertEquals('A', weaveArchiveStatus.archiveStatus.getArchived().charValue());
    assertEquals('A', weaveArchiveStatus.getArchived().charValue());
  }

  /**
   * Test {@link WeaveArchiveStatus#getArchived()}.
   *
   * <ul>
   *   <li>Given {@link WeaveArchiveStatus} (default constructor) Archived is {@code A}.
   *   <li>Then return charValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link WeaveArchiveStatus#getArchived()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Character WeaveArchiveStatus.getArchived()"})
  public void testGetArchived_givenWeaveArchiveStatusArchivedIsA_thenReturnCharValueIsA() {
    // Arrange
    WeaveArchiveStatus weaveArchiveStatus = new WeaveArchiveStatus();
    weaveArchiveStatus.setArchived('A');

    // Act and Assert
    assertEquals('A', weaveArchiveStatus.getArchived().charValue());
  }

  /**
   * Test {@link WeaveArchiveStatus#getArchived()}.
   *
   * <ul>
   *   <li>Given {@link WeaveArchiveStatus} (default constructor).
   *   <li>Then return charValue is {@code N}.
   * </ul>
   *
   * <p>Method under test: {@link WeaveArchiveStatus#getArchived()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Character WeaveArchiveStatus.getArchived()"})
  public void testGetArchived_givenWeaveArchiveStatus_thenReturnCharValueIsN() {
    // Arrange, Act and Assert
    assertEquals('N', new WeaveArchiveStatus().getArchived().charValue());
  }

  /**
   * Test {@link WeaveArchiveStatus#isActive()}.
   *
   * <ul>
   *   <li>Given {@link WeaveArchiveStatus} (default constructor) Archived is {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WeaveArchiveStatus#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WeaveArchiveStatus.isActive()"})
  public void testIsActive_givenWeaveArchiveStatusArchivedIsA_thenReturnTrue() {
    // Arrange
    WeaveArchiveStatus weaveArchiveStatus = new WeaveArchiveStatus();
    weaveArchiveStatus.setArchived('A');

    // Act and Assert
    assertTrue(weaveArchiveStatus.isActive());
  }

  /**
   * Test {@link WeaveArchiveStatus#isActive()}.
   *
   * <ul>
   *   <li>Given {@link WeaveArchiveStatus} (default constructor) Archived is {@code Y}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WeaveArchiveStatus#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WeaveArchiveStatus.isActive()"})
  public void testIsActive_givenWeaveArchiveStatusArchivedIsY_thenReturnFalse() {
    // Arrange
    WeaveArchiveStatus weaveArchiveStatus = new WeaveArchiveStatus();
    weaveArchiveStatus.setArchived('Y');

    // Act and Assert
    assertFalse(weaveArchiveStatus.isActive());
  }

  /**
   * Test {@link WeaveArchiveStatus#isActive()}.
   *
   * <ul>
   *   <li>Given {@link WeaveArchiveStatus} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WeaveArchiveStatus#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WeaveArchiveStatus.isActive()"})
  public void testIsActive_givenWeaveArchiveStatus_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new WeaveArchiveStatus().isActive());
  }

  /**
   * Test new {@link WeaveArchiveStatus} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link WeaveArchiveStatus}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WeaveArchiveStatus.<init>()"})
  public void testNewWeaveArchiveStatus() {
    // Arrange and Act
    WeaveArchiveStatus actualWeaveArchiveStatus = new WeaveArchiveStatus();

    // Assert
    assertEquals('N', actualWeaveArchiveStatus.getArchived().charValue());
    assertNull(actualWeaveArchiveStatus.archiveStatus);
  }
}
