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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PageCartRuleProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PageCartRuleProcessorDiffblueTest {
  @Autowired
  private PageCartRuleProcessor pageCartRuleProcessor;

  /**
   * Test {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageCartRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenArrayList_thenReturnTrue() {
    // Arrange
    PageDTO page = new PageDTO();
    page.setItemCriteriaDTOList(new ArrayList<>());

    HashMap<String, Object> valueMap = new HashMap<>();
    valueMap.put("customer", new CustomerImpl());

    // Act and Assert
    assertTrue(pageCartRuleProcessor.checkForMatch(page, valueMap));
  }

  /**
   * Test {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageCartRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenNull_thenReturnFalse() {
    // Arrange
    ItemCriteriaDTO itemCriteriaDTO = new ItemCriteriaDTO();
    itemCriteriaDTO.setMatchRule("Match Rule");
    itemCriteriaDTO.setQty(1);

    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    itemCriteriaDTOList.add(itemCriteriaDTO);

    PageDTO page = new PageDTO();
    page.setItemCriteriaDTOList(itemCriteriaDTOList);

    HashMap<String, Object> valueMap = new HashMap<>();
    valueMap.put("customer", null);

    // Act and Assert
    assertFalse(pageCartRuleProcessor.checkForMatch(page, valueMap));
  }

  /**
   * Test {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageCartRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_whenPageDTO_thenReturnTrue() {
    // Arrange
    PageDTO page = new PageDTO();

    // Act and Assert
    assertTrue(pageCartRuleProcessor.checkForMatch(page, new HashMap<>()));
  }

  /**
   * Test new {@link PageCartRuleProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PageCartRuleProcessor}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageCartRuleProcessor.<init>()"})
  public void testNewPageCartRuleProcessor() {
    // Arrange and Act
    PageCartRuleProcessor actualPageCartRuleProcessor = new PageCartRuleProcessor();

    // Assert
    assertNull(actualPageCartRuleProcessor.getOrderDao());
    assertTrue(actualPageCartRuleProcessor.getContextClassNames().isEmpty());
  }
}
