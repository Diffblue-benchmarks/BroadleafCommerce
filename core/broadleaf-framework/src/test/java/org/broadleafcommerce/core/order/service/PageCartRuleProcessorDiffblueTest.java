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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class PageCartRuleProcessorDiffblueTest {
  /**
   * Method under test: {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    PageDTO page = new PageDTO();

    // Act and Assert
    assertTrue(pageCartRuleProcessor.checkForMatch(page, new HashMap<>()));
  }

  /**
   * Method under test: {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();

    PageDTO page = new PageDTO();
    page.setItemCriteriaDTOList(new ArrayList<>());

    HashMap<String, Object> valueMap = new HashMap<>();
    valueMap.put("customer", new CustomerImpl());

    // Act and Assert
    assertTrue(pageCartRuleProcessor.checkForMatch(page, valueMap));
  }

  /**
   * Method under test: {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getItemCriteriaDTOList()).thenReturn(new ArrayList<>());

    // Act
    boolean actualCheckForMatchResult = pageCartRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getItemCriteriaDTOList();
    assertTrue(actualCheckForMatchResult);
  }

  /**
   * Method under test: {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatch4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();

    ItemCriteriaDTO itemCriteriaDTO = new ItemCriteriaDTO();
    itemCriteriaDTO.setMatchRule("Match Rule");
    itemCriteriaDTO.setQty(1);

    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    itemCriteriaDTOList.add(itemCriteriaDTO);
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getItemCriteriaDTOList()).thenReturn(itemCriteriaDTOList);

    // Act
    boolean actualCheckForMatchResult = pageCartRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getItemCriteriaDTOList();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PageCartRuleProcessor}
   */
  @Test
  public void testNewPageCartRuleProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    PageCartRuleProcessor actualPageCartRuleProcessor = new PageCartRuleProcessor();

    // Assert
    assertNull(actualPageCartRuleProcessor.getOrderDao());
    assertTrue(actualPageCartRuleProcessor.getContextClassNames().isEmpty());
  }
}
