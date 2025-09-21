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
package org.broadleafcommerce.common.breadcrumbs.dto;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BreadcrumbDTODiffblueTest {
  /**
   * Test {@link BreadcrumbDTO#getType()}.
   *
   * <ul>
   *   <li>Given {@link BreadcrumbDTO} (default constructor) Link is {@code Link}.
   *   <li>Then return {@code CATEGORY}.
   * </ul>
   *
   * <p>Method under test: {@link BreadcrumbDTO#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BreadcrumbDTO.getType()"})
  public void testGetType_givenBreadcrumbDTOLinkIsLink_thenReturnCategory() {
    // Arrange
    BreadcrumbDTO breadcrumbDTO = new BreadcrumbDTO();
    breadcrumbDTO.setLink("Link");
    breadcrumbDTO.setText("Text");
    breadcrumbDTO.setType(BreadcrumbDTOType.CATEGORY);

    // Act and Assert
    assertEquals("CATEGORY", breadcrumbDTO.getType());
  }

  /**
   * Test {@link BreadcrumbDTO#getType()}.
   *
   * <ul>
   *   <li>Given {@link BreadcrumbDTO} (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BreadcrumbDTO#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BreadcrumbDTO.getType()"})
  public void testGetType_givenBreadcrumbDTO_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new BreadcrumbDTO().getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BreadcrumbDTO}
   *   <li>{@link BreadcrumbDTO#setLink(String)}
   *   <li>{@link BreadcrumbDTO#setText(String)}
   *   <li>{@link BreadcrumbDTO#setType(BreadcrumbDTOType)}
   *   <li>{@link BreadcrumbDTO#getLink()}
   *   <li>{@link BreadcrumbDTO#getText()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BreadcrumbDTO.<init>()",
    "String BreadcrumbDTO.getLink()",
    "String BreadcrumbDTO.getText()",
    "void BreadcrumbDTO.setLink(String)",
    "void BreadcrumbDTO.setText(String)",
    "void BreadcrumbDTO.setType(BreadcrumbDTOType)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BreadcrumbDTO actualBreadcrumbDTO = new BreadcrumbDTO();
    actualBreadcrumbDTO.setLink("Link");
    actualBreadcrumbDTO.setText("Text");
    actualBreadcrumbDTO.setType(BreadcrumbDTOType.CATEGORY);
    String actualLink = actualBreadcrumbDTO.getLink();

    // Assert
    assertEquals("Link", actualLink);
    assertEquals("Text", actualBreadcrumbDTO.getText());
  }
}
