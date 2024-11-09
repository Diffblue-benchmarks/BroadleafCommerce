/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class FullReindexCommandDiffblueTest {
  /**
   * Test {@link FullReindexCommand#equals(Object)}, and
   * {@link FullReindexCommand#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FullReindexCommand#equals(Object)}
   *   <li>{@link FullReindexCommand#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FullReindexCommand fullReindexCommand = FullReindexCommand.DEFAULT_INSTANCE;
    FullReindexCommand fullReindexCommand2 = FullReindexCommand.DEFAULT_INSTANCE;

    // Act and Assert
    assertEquals(fullReindexCommand, fullReindexCommand2);
    int expectedHashCodeResult = fullReindexCommand.hashCode();
    assertEquals(expectedHashCodeResult, fullReindexCommand2.hashCode());
  }

  /**
   * Test {@link FullReindexCommand#equals(Object)}, and
   * {@link FullReindexCommand#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FullReindexCommand#equals(Object)}
   *   <li>{@link FullReindexCommand#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FullReindexCommand fullReindexCommand = new FullReindexCommand();
    FullReindexCommand fullReindexCommand2 = FullReindexCommand.DEFAULT_INSTANCE;

    // Act and Assert
    assertEquals(fullReindexCommand, fullReindexCommand2);
    int expectedHashCodeResult = fullReindexCommand.hashCode();
    assertEquals(expectedHashCodeResult, fullReindexCommand2.hashCode());
  }

  /**
   * Test {@link FullReindexCommand#equals(Object)}, and
   * {@link FullReindexCommand#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FullReindexCommand#equals(Object)}
   *   <li>{@link FullReindexCommand#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FullReindexCommand fullReindexCommand = FullReindexCommand.DEFAULT_INSTANCE;

    // Act and Assert
    assertEquals(fullReindexCommand, fullReindexCommand);
    int expectedHashCodeResult = fullReindexCommand.hashCode();
    assertEquals(expectedHashCodeResult, fullReindexCommand.hashCode());
  }

  /**
   * Test {@link FullReindexCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FullReindexCommand#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FullReindexCommand.DEFAULT_INSTANCE, 1);
  }

  /**
   * Test {@link FullReindexCommand#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FullReindexCommand#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FullReindexCommand.DEFAULT_INSTANCE, null);
  }

  /**
   * Test {@link FullReindexCommand#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FullReindexCommand#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FullReindexCommand.DEFAULT_INSTANCE, "Different type to FullReindexCommand");
  }
}
