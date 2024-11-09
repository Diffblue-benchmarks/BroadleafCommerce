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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType;
import org.junit.Test;

public class CategorySiteMapGeneratorConfigurationImplDiffblueTest {
  /**
   * Test {@link CategorySiteMapGeneratorConfigurationImpl#equals(Object)}, and
   * {@link CategorySiteMapGeneratorConfigurationImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategorySiteMapGeneratorConfigurationImpl#equals(Object)}
   *   <li>{@link CategorySiteMapGeneratorConfigurationImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategorySiteMapGeneratorConfigurationImpl categorySiteMapGeneratorConfigurationImpl = new CategorySiteMapGeneratorConfigurationImpl();
    categorySiteMapGeneratorConfigurationImpl.setDisabled(true);
    categorySiteMapGeneratorConfigurationImpl.setEndingDepth(2);
    categorySiteMapGeneratorConfigurationImpl.setId(1L);
    categorySiteMapGeneratorConfigurationImpl.setRootCategory(new CategoryImpl());
    categorySiteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    categorySiteMapGeneratorConfigurationImpl
        .setSiteMapGeneratorType(new SiteMapGeneratorType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setStartingDepth(2);

    // Act and Assert
    assertEquals(categorySiteMapGeneratorConfigurationImpl, categorySiteMapGeneratorConfigurationImpl);
    int expectedHashCodeResult = categorySiteMapGeneratorConfigurationImpl.hashCode();
    assertEquals(expectedHashCodeResult, categorySiteMapGeneratorConfigurationImpl.hashCode());
  }

  /**
   * Test {@link CategorySiteMapGeneratorConfigurationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGeneratorConfigurationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategorySiteMapGeneratorConfigurationImpl categorySiteMapGeneratorConfigurationImpl = new CategorySiteMapGeneratorConfigurationImpl();
    categorySiteMapGeneratorConfigurationImpl.setDisabled(true);
    categorySiteMapGeneratorConfigurationImpl.setEndingDepth(2);
    categorySiteMapGeneratorConfigurationImpl.setId(1L);
    categorySiteMapGeneratorConfigurationImpl.setRootCategory(new CategoryImpl());
    categorySiteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    categorySiteMapGeneratorConfigurationImpl
        .setSiteMapGeneratorType(new SiteMapGeneratorType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setStartingDepth(2);

    CategorySiteMapGeneratorConfigurationImpl categorySiteMapGeneratorConfigurationImpl2 = new CategorySiteMapGeneratorConfigurationImpl();
    categorySiteMapGeneratorConfigurationImpl2.setDisabled(true);
    categorySiteMapGeneratorConfigurationImpl2.setEndingDepth(2);
    categorySiteMapGeneratorConfigurationImpl2.setId(1L);
    categorySiteMapGeneratorConfigurationImpl2.setRootCategory(new CategoryImpl());
    categorySiteMapGeneratorConfigurationImpl2.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl2.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    categorySiteMapGeneratorConfigurationImpl2
        .setSiteMapGeneratorType(new SiteMapGeneratorType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl2.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl2.setStartingDepth(2);

    // Act and Assert
    assertNotEquals(categorySiteMapGeneratorConfigurationImpl, categorySiteMapGeneratorConfigurationImpl2);
  }

  /**
   * Test {@link CategorySiteMapGeneratorConfigurationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGeneratorConfigurationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategorySiteMapGeneratorConfigurationImpl categorySiteMapGeneratorConfigurationImpl = new CategorySiteMapGeneratorConfigurationImpl();
    categorySiteMapGeneratorConfigurationImpl.setDisabled(true);
    categorySiteMapGeneratorConfigurationImpl.setEndingDepth(2);
    categorySiteMapGeneratorConfigurationImpl.setId(1L);
    categorySiteMapGeneratorConfigurationImpl.setRootCategory(mock(Category.class));
    categorySiteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    categorySiteMapGeneratorConfigurationImpl
        .setSiteMapGeneratorType(new SiteMapGeneratorType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setStartingDepth(2);

    CategorySiteMapGeneratorConfigurationImpl categorySiteMapGeneratorConfigurationImpl2 = new CategorySiteMapGeneratorConfigurationImpl();
    categorySiteMapGeneratorConfigurationImpl2.setDisabled(true);
    categorySiteMapGeneratorConfigurationImpl2.setEndingDepth(2);
    categorySiteMapGeneratorConfigurationImpl2.setId(1L);
    categorySiteMapGeneratorConfigurationImpl2.setRootCategory(new CategoryImpl());
    categorySiteMapGeneratorConfigurationImpl2.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl2.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    categorySiteMapGeneratorConfigurationImpl2
        .setSiteMapGeneratorType(new SiteMapGeneratorType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl2.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl2.setStartingDepth(2);

    // Act and Assert
    assertNotEquals(categorySiteMapGeneratorConfigurationImpl, categorySiteMapGeneratorConfigurationImpl2);
  }

  /**
   * Test {@link CategorySiteMapGeneratorConfigurationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGeneratorConfigurationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategorySiteMapGeneratorConfigurationImpl categorySiteMapGeneratorConfigurationImpl = new CategorySiteMapGeneratorConfigurationImpl();
    categorySiteMapGeneratorConfigurationImpl.setDisabled(true);
    categorySiteMapGeneratorConfigurationImpl.setEndingDepth(2);
    categorySiteMapGeneratorConfigurationImpl.setId(1L);
    categorySiteMapGeneratorConfigurationImpl.setRootCategory(new CategoryImpl());
    categorySiteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    categorySiteMapGeneratorConfigurationImpl
        .setSiteMapGeneratorType(new SiteMapGeneratorType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setStartingDepth(2);

    // Act and Assert
    assertNotEquals(categorySiteMapGeneratorConfigurationImpl, null);
  }

  /**
   * Test {@link CategorySiteMapGeneratorConfigurationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGeneratorConfigurationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategorySiteMapGeneratorConfigurationImpl categorySiteMapGeneratorConfigurationImpl = new CategorySiteMapGeneratorConfigurationImpl();
    categorySiteMapGeneratorConfigurationImpl.setDisabled(true);
    categorySiteMapGeneratorConfigurationImpl.setEndingDepth(2);
    categorySiteMapGeneratorConfigurationImpl.setId(1L);
    categorySiteMapGeneratorConfigurationImpl.setRootCategory(new CategoryImpl());
    categorySiteMapGeneratorConfigurationImpl.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    categorySiteMapGeneratorConfigurationImpl
        .setSiteMapGeneratorType(new SiteMapGeneratorType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));
    categorySiteMapGeneratorConfigurationImpl.setStartingDepth(2);

    // Act and Assert
    assertNotEquals(categorySiteMapGeneratorConfigurationImpl,
        "Different type to CategorySiteMapGeneratorConfigurationImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link CategorySiteMapGeneratorConfigurationImpl}
   *   <li>{@link CategorySiteMapGeneratorConfigurationImpl#setEndingDepth(int)}
   *   <li>
   * {@link CategorySiteMapGeneratorConfigurationImpl#setRootCategory(Category)}
   *   <li>{@link CategorySiteMapGeneratorConfigurationImpl#setStartingDepth(int)}
   *   <li>{@link CategorySiteMapGeneratorConfigurationImpl#getEndingDepth()}
   *   <li>{@link CategorySiteMapGeneratorConfigurationImpl#getRootCategory()}
   *   <li>{@link CategorySiteMapGeneratorConfigurationImpl#getStartingDepth()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CategorySiteMapGeneratorConfigurationImpl actualCategorySiteMapGeneratorConfigurationImpl = new CategorySiteMapGeneratorConfigurationImpl();
    actualCategorySiteMapGeneratorConfigurationImpl.setEndingDepth(2);
    CategoryImpl rootCategory = new CategoryImpl();
    actualCategorySiteMapGeneratorConfigurationImpl.setRootCategory(rootCategory);
    actualCategorySiteMapGeneratorConfigurationImpl.setStartingDepth(2);
    int actualEndingDepth = actualCategorySiteMapGeneratorConfigurationImpl.getEndingDepth();
    Category actualRootCategory = actualCategorySiteMapGeneratorConfigurationImpl.getRootCategory();

    // Assert that nothing has changed
    assertEquals(2, actualEndingDepth);
    assertEquals(2, actualCategorySiteMapGeneratorConfigurationImpl.getStartingDepth());
    assertFalse(actualCategorySiteMapGeneratorConfigurationImpl.isDisabled());
    assertSame(rootCategory, actualRootCategory);
  }
}
