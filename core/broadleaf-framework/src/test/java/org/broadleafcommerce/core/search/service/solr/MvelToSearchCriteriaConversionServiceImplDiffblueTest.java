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
package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.broadleafcommerce.core.search.domain.IndexFieldType;
import org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl;
import org.junit.Test;

public class MvelToSearchCriteriaConversionServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  public void testConvert() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new MvelToSearchCriteriaConversionServiceImpl()).convert("Mvel Rule"));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}
   */
  @Test
  public void testIsProductRule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MvelToSearchCriteriaConversionServiceImpl()).isProductRule("Rule"));
    assertTrue((new MvelToSearchCriteriaConversionServiceImpl()).isProductRule("product."));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  public void testIsCustomFieldIndexed() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl = new MvelToSearchCriteriaConversionServiceImpl();

    // Act and Assert
    assertFalse(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  public void testIsCustomFieldIndexed2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MvelToSearchCriteriaConversionServiceImpl()).isCustomFieldIndexed(null));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  public void testIsCustomFieldIndexed3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl = new MvelToSearchCriteriaConversionServiceImpl();

    ArrayList<IndexFieldType> indexFieldTypes = new ArrayList<>();
    indexFieldTypes.add(new IndexFieldTypeImpl());

    // Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(indexFieldTypes));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  public void testIsCustomFieldIndexed4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl = new MvelToSearchCriteriaConversionServiceImpl();

    ArrayList<IndexFieldType> indexFieldTypes = new ArrayList<>();
    indexFieldTypes.add(new IndexFieldTypeImpl());
    indexFieldTypes.add(new IndexFieldTypeImpl());

    // Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(indexFieldTypes));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  public void testIsCustomFieldIndexed5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl = new MvelToSearchCriteriaConversionServiceImpl();

    ArrayList<IndexFieldType> indexFieldTypes = new ArrayList<>();
    indexFieldTypes.add(mock(IndexFieldTypeImpl.class));

    // Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(indexFieldTypes));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}
   */
  @Test
  public void testIsCategoryTargetingRule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MvelToSearchCriteriaConversionServiceImpl()).isCategoryTargetingRule("Mvel Rule"));
    assertTrue((new MvelToSearchCriteriaConversionServiceImpl()).isCategoryTargetingRule(
        "CollectionUtils.intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0"));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCategoryIds(String)}
   */
  @Test
  public void testGetCategoryIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertArrayEquals(new Long[]{2L}, (new MvelToSearchCriteriaConversionServiceImpl()).getCategoryIds("42\"]"));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  public void testConvertRuleToFilters() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Collection<String> actualConvertRuleToFiltersResult = (new MvelToSearchCriteriaConversionServiceImpl())
        .convertRuleToFilters("||");

    // Assert
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertEquals(1, actualConvertRuleToFiltersResult.size());
    assertEquals("", ((List<String>) actualConvertRuleToFiltersResult).get(0));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  public void testConvertRuleToFilters2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Collection<String> actualConvertRuleToFiltersResult = (new MvelToSearchCriteriaConversionServiceImpl())
        .convertRuleToFilters("&&");

    // Assert
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  public void testConvertRuleToFilters3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Collection<String> actualConvertRuleToFiltersResult = (new MvelToSearchCriteriaConversionServiceImpl())
        .convertRuleToFilters("");

    // Assert
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Field Name", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("Field Name"));
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?"));
    assertEquals("\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?"));
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("product."));
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("??"));
    assertEquals("\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?\\?"));
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?product."));
    assertEquals("Field Name", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?Field Name"));
    assertEquals("42", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?42"));
    assertEquals("!", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?!"));
    assertEquals("!=", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?!="));
    assertEquals("!=\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?!=\""));
    assertEquals("\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?\""));
    assertEquals("\")", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?\")"));
    assertEquals("\"))", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?\"))"));
    assertEquals("\",\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?\",\""));
    assertEquals("*", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?*"));
    assertEquals(".contains", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?.contains"));
    assertEquals(".endsWith", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?.endsWith"));
    assertEquals(".startsWith", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?.startsWith"));
    assertEquals(":(\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?:(\""));
    assertEquals("=", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?="));
    assertEquals("\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\??"));
    assertEquals("\\\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?\\?"));
    assertEquals("\\product.", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?product."));
    assertEquals("\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?()"));
    assertEquals("\\Field Name", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?Field Name"));
    assertEquals("\\42", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?42"));
    assertEquals("\\!", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?!"));
    assertEquals("\\!=", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?!="));
    assertEquals("\\!=\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?!=\""));
    assertEquals("\\\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?\""));
    assertEquals("\\\")", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?\")"));
    assertEquals("\\\"))", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?\"))"));
    assertEquals("\\\",\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?\",\""));
    assertEquals("\\*", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?*"));
    assertEquals("\\.contains", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?.contains"));
    assertEquals("\\.endsWith", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?.endsWith"));
    assertEquals("\\.startsWith", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?.startsWith"));
    assertEquals("\\:(\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?:(\""));
    assertEquals("\\=", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?="));
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("product.?"));
    assertEquals("\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("product.\\?"));
    assertEquals("()\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("()\\?"));
    assertEquals("Field Name", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("Field Name?"));
    assertEquals("Field Name\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("Field Name\\?"));
    assertEquals("42", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("42?"));
    assertEquals("42\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("42\\?"));
    assertEquals("!", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("!?"));
    assertEquals("!\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("!\\?"));
    assertEquals("!=", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("!=?"));
    assertEquals("!=\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("!=\\?"));
    assertEquals("!=\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("!=\"?"));
    assertEquals("!=\"\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("!=\"\\?"));
    assertEquals("\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\"?"));
    assertEquals("\"\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\"\\?"));
    assertEquals("\")", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\")?"));
    assertEquals("\")\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\")\\?"));
    assertEquals("\"))", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\"))?"));
    assertEquals("\"))\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\"))\\?"));
    assertEquals("\",\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\",\"?"));
    assertEquals("\",\"\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\",\"\\?"));
    assertEquals("*", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("*?"));
    assertEquals("*\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("*\\?"));
    assertEquals(".contains", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName(".contains?"));
    assertEquals(".contains\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName(".contains\\?"));
    assertEquals(".endsWith", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName(".endsWith?"));
    assertEquals(".endsWith\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName(".endsWith\\?"));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  public void testParseMethod() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("field Na", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("Field Name"));
    assertEquals("g", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("getget"));
    assertEquals("(^ge", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("get(^get)"));
    assertEquals("field Na", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("getField Name"));
    assertEquals("!", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("get!=\""));
    assertEquals("\"", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("get\"))"));
    assertEquals("\"", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("get\",\""));
    assertEquals(":", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("get:(\""));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}
   */
  @Test
  public void testIsWildCardSearch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MvelToSearchCriteriaConversionServiceImpl()).isWildCardSearch("42"));
    assertTrue((new MvelToSearchCriteriaConversionServiceImpl()).isWildCardSearch("*"));
    assertTrue((new MvelToSearchCriteriaConversionServiceImpl()).isWildCardSearch("42*"));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  public void testGetCustomFieldPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Mvel Rule",
        (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("Mvel Rule"));
    assertEquals("!", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("!="));
    assertEquals("(", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("("));
    assertEquals("()", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("()"));
    assertEquals("CollectionUtils",
        (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("CollectionUtils,"));
    assertEquals("[\"", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("[\"!"));
    assertEquals("\"", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("(\")"));
    assertEquals("org.apache.commons.lang3.StringUtils.contains", (new MvelToSearchCriteriaConversionServiceImpl())
        .getCustomFieldPropertyName("org.apache.commons.lang3.StringUtils.contains,"));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  public void testGetRuleOrPropertyFromFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Mvel Rule",
        (new MvelToSearchCriteriaConversionServiceImpl()).getRuleOrPropertyFromFunction("Mvel Rule"));
    assertEquals("!", (new MvelToSearchCriteriaConversionServiceImpl()).getRuleOrPropertyFromFunction("!="));
    assertEquals("\")", (new MvelToSearchCriteriaConversionServiceImpl()).getRuleOrPropertyFromFunction("\")"));
    assertEquals("()", (new MvelToSearchCriteriaConversionServiceImpl()).getRuleOrPropertyFromFunction("()"));
    assertEquals("=", (new MvelToSearchCriteriaConversionServiceImpl()).getRuleOrPropertyFromFunction("=!"));
  }

  /**
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  public void testGetCustomFieldValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue("Mvel Rule"));
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue("!=\""));
    assertEquals("=", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue("=="));
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue("!="));
    assertEquals("contains", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue(".contains\"))"));
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue("Mvel Rule=="));
    assertEquals("\"", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue("\"))CollectionUtils"));
  }
}
