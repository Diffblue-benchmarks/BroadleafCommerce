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
package org.broadleafcommerce.common.page.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PageDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PageDTODiffblueTest {
  @Autowired
  private PageDTO pageDTO;

  /**
   * Test {@link PageDTO#getPropertyValue(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDTO#getPropertyValue(String)}
   */
  @Test
  public void testGetPropertyValue_when42() {
    // Arrange, Act and Assert
    assertNull(pageDTO.getPropertyValue("42"));
  }

  /**
   * Test {@link PageDTO#getPropertyValue(String)}.
   * <ul>
   *   <li>When {@code Property Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDTO#getPropertyValue(String)}
   */
  @Test
  public void testGetPropertyValue_whenPropertyName() {
    // Arrange, Act and Assert
    assertNull(pageDTO.getPropertyValue("Property Name"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PageDTO}
   *   <li>{@link PageDTO#setDescription(String)}
   *   <li>{@link PageDTO#setForeignPageFields(Map)}
   *   <li>{@link PageDTO#setId(Long)}
   *   <li>{@link PageDTO#setItemCriteriaDTOList(List)}
   *   <li>{@link PageDTO#setLocaleCode(String)}
   *   <li>{@link PageDTO#setPageAttributes(Map)}
   *   <li>{@link PageDTO#setPageFields(Map)}
   *   <li>{@link PageDTO#setPriority(Integer)}
   *   <li>{@link PageDTO#setRuleExpression(String)}
   *   <li>{@link PageDTO#setTemplatePath(String)}
   *   <li>{@link PageDTO#setUrl(String)}
   *   <li>{@link PageDTO#getDescription()}
   *   <li>{@link PageDTO#getForeignPageFields()}
   *   <li>{@link PageDTO#getId()}
   *   <li>{@link PageDTO#getItemCriteriaDTOList()}
   *   <li>{@link PageDTO#getLocaleCode()}
   *   <li>{@link PageDTO#getPageAttributes()}
   *   <li>{@link PageDTO#getPageFields()}
   *   <li>{@link PageDTO#getPriority()}
   *   <li>{@link PageDTO#getRuleExpression()}
   *   <li>{@link PageDTO#getTemplatePath()}
   *   <li>{@link PageDTO#getUrl()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PageDTO actualPageDTO = new PageDTO();
    actualPageDTO.setDescription("The characteristics of someone or something");
    HashMap<String, Object> foreignPageFields = new HashMap<>();
    actualPageDTO.setForeignPageFields(foreignPageFields);
    actualPageDTO.setId(1L);
    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    actualPageDTO.setItemCriteriaDTOList(itemCriteriaDTOList);
    actualPageDTO.setLocaleCode("en");
    HashMap<String, String> pageAttributes = new HashMap<>();
    actualPageDTO.setPageAttributes(pageAttributes);
    HashMap<String, Object> pageFields = new HashMap<>();
    actualPageDTO.setPageFields(pageFields);
    actualPageDTO.setPriority(1);
    actualPageDTO.setRuleExpression("Rule Expression");
    actualPageDTO.setTemplatePath("Template Path");
    actualPageDTO.setUrl("https://example.org/example");
    String actualDescription = actualPageDTO.getDescription();
    Map<String, Object> actualForeignPageFields = actualPageDTO.getForeignPageFields();
    Long actualId = actualPageDTO.getId();
    List<ItemCriteriaDTO> actualItemCriteriaDTOList = actualPageDTO.getItemCriteriaDTOList();
    String actualLocaleCode = actualPageDTO.getLocaleCode();
    Map<String, String> actualPageAttributes = actualPageDTO.getPageAttributes();
    Map<String, Object> actualPageFields = actualPageDTO.getPageFields();
    Integer actualPriority = actualPageDTO.getPriority();
    String actualRuleExpression = actualPageDTO.getRuleExpression();
    String actualTemplatePath = actualPageDTO.getTemplatePath();

    // Assert that nothing has changed
    assertEquals("Rule Expression", actualRuleExpression);
    assertEquals("Template Path", actualTemplatePath);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("en", actualLocaleCode);
    assertEquals("https://example.org/example", actualPageDTO.getUrl());
    assertEquals(1, actualPriority.intValue());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualItemCriteriaDTOList.isEmpty());
    assertTrue(actualForeignPageFields.isEmpty());
    assertTrue(actualPageAttributes.isEmpty());
    assertTrue(actualPageFields.isEmpty());
    assertSame(itemCriteriaDTOList, actualItemCriteriaDTOList);
    assertSame(foreignPageFields, actualForeignPageFields);
    assertSame(pageAttributes, actualPageAttributes);
    assertSame(pageFields, actualPageFields);
  }
}
