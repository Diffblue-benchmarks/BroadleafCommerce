/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.structure.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.structure.dto.StructuredContentDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {StructuredContentDefaultRuleProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StructuredContentDefaultRuleProcessorDiffblueTest {
  @Autowired
  private StructuredContentDefaultRuleProcessor structuredContentDefaultRuleProcessor;

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)} with {@code StructuredContentDTO}, {@code Map}.
   * <p>
   * Method under test: {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"})
  public void testCheckForMatchWithStructuredContentDTOMap() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("42");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)} with {@code StructuredContentDTO}, {@code Map}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"})
  public void testCheckForMatchWithStructuredContentDTOMap_givenEmptyString() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertTrue(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)} with {@code StructuredContentDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"})
  public void testCheckForMatchWithStructuredContentDTOMap_givenFoo_whenHashMapFooIs42() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("getProductAttributes()[UU]");
    sc.setValues(new HashMap<>());

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("foo", "42");

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, vars));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)} with {@code StructuredContentDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code getProductAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"})
  public void testCheckForMatchWithStructuredContentDTOMap_givenGetProductAttributesUu() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("getProductAttributes()[UU]");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)} with {@code StructuredContentDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"})
  public void testCheckForMatchWithStructuredContentDTOMap_givenNull() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setValues(new HashMap<>());
    sc.setRuleExpression(null);

    // Act and Assert
    assertTrue(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)} with {@code StructuredContentDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code Sc}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"})
  public void testCheckForMatchWithStructuredContentDTOMap_givenSc() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setValues(new HashMap<>());
    sc.setRuleExpression("Sc");

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#getContextClassNames()}.
   * <p>
   * Method under test: {@link StructuredContentDefaultRuleProcessor#getContextClassNames()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map StructuredContentDefaultRuleProcessor.getContextClassNames()"})
  public void testGetContextClassNames() {
    // Arrange and Act
    Map<String, String> actualContextClassNames = structuredContentDefaultRuleProcessor.getContextClassNames();

    // Assert
    assertEquals(4, actualContextClassNames.size());
    assertEquals("org.broadleafcommerce.common.RequestDTO", actualContextClassNames.get("request"));
    assertEquals("org.broadleafcommerce.common.TimeDTO", actualContextClassNames.get("time"));
    assertEquals("org.broadleafcommerce.core.catalog.domain.Product", actualContextClassNames.get("product"));
    assertEquals("org.broadleafcommerce.profile.core.domain.Customer", actualContextClassNames.get("customer"));
  }
}
