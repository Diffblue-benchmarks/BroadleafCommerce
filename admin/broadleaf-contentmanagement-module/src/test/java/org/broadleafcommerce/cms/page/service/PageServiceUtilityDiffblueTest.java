/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.page.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageAttribute;
import org.broadleafcommerce.cms.page.domain.PageAttributeImpl;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.broadleafcommerce.cms.page.domain.PageItemCriteria;
import org.broadleafcommerce.cms.page.domain.PageItemCriteriaImpl;
import org.broadleafcommerce.cms.page.domain.PageRule;
import org.broadleafcommerce.cms.page.domain.PageRuleImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplateImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.junit.Test;

public class PageServiceUtilityDiffblueTest {
  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code title} is
   * {@link PageAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  public void testBuildPageDTO_givenHashMapTitleIsPageAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    HashMap<String, PageAttribute> stringPageAttributeMap = new HashMap<>();
    stringPageAttributeMap.put("title", new PageAttributeImpl());
    PageImpl page = mock(PageImpl.class);
    when(page.getPriority()).thenReturn(1);
    when(page.getId()).thenReturn(1L);
    when(page.getDescription()).thenReturn("The characteristics of someone or something");
    when(page.getFullUrl()).thenReturn("https://example.org/example");
    when(page.getMetaDescription()).thenReturn("Meta Description");
    when(page.getMetaTitle()).thenReturn("Dr");
    when(page.getAdditionalAttributes()).thenReturn(stringPageAttributeMap);
    when(page.getPageFields()).thenReturn(new HashMap<>());
    when(page.getPageMatchRules()).thenReturn(new HashMap<>());
    when(page.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(page.getPageTemplate()).thenReturn(new PageTemplateImpl());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(page).getAdditionalAttributes();
    verify(page).getDescription();
    verify(page).getFullUrl();
    verify(page).getId();
    verify(page).getMetaDescription();
    verify(page).getMetaTitle();
    verify(page).getPageFields();
    verify(page).getPageMatchRules();
    verify(page, atLeast(1)).getPageTemplate();
    verify(page).getPriority();
    verify(page, atLeast(1)).getQualifyingItemCriteria();
    Map<String, String> pageAttributes = actualBuildPageDTOResult.getPageAttributes();
    assertEquals(2, pageAttributes.size());
    assertEquals("Dr", pageAttributes.get("title"));
    assertEquals("Meta Description", pageAttributes.get("metaDescription"));
    assertEquals("The characteristics of someone or something", actualBuildPageDTOResult.getDescription());
    assertEquals("https://example.org/example", actualBuildPageDTOResult.getUrl());
    assertNull(actualBuildPageDTOResult.getTemplatePath());
    assertNull(actualBuildPageDTOResult.getItemCriteriaDTOList());
    assertEquals(1, actualBuildPageDTOResult.getPriority().intValue());
    assertEquals(1L, actualBuildPageDTOResult.getId().longValue());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return TemplatePath is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  public void testBuildPageDTO_givenHashSet_thenReturnTemplatePathIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();
    PageImpl page = mock(PageImpl.class);
    when(page.getPriority()).thenReturn(1);
    when(page.getId()).thenReturn(1L);
    when(page.getDescription()).thenReturn("The characteristics of someone or something");
    when(page.getFullUrl()).thenReturn("https://example.org/example");
    when(page.getMetaDescription()).thenReturn("Meta Description");
    when(page.getMetaTitle()).thenReturn("Dr");
    when(page.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(new HashMap<>());
    when(page.getPageMatchRules()).thenReturn(new HashMap<>());
    when(page.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(page.getPageTemplate()).thenReturn(new PageTemplateImpl());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(page).getAdditionalAttributes();
    verify(page).getDescription();
    verify(page).getFullUrl();
    verify(page).getId();
    verify(page).getMetaDescription();
    verify(page).getMetaTitle();
    verify(page).getPageFields();
    verify(page).getPageMatchRules();
    verify(page, atLeast(1)).getPageTemplate();
    verify(page).getPriority();
    verify(page, atLeast(1)).getQualifyingItemCriteria();
    Map<String, String> pageAttributes = actualBuildPageDTOResult.getPageAttributes();
    assertEquals(2, pageAttributes.size());
    assertEquals("Dr", pageAttributes.get("title"));
    assertEquals("Meta Description", pageAttributes.get("metaDescription"));
    assertEquals("The characteristics of someone or something", actualBuildPageDTOResult.getDescription());
    assertEquals("https://example.org/example", actualBuildPageDTOResult.getUrl());
    assertNull(actualBuildPageDTOResult.getTemplatePath());
    assertNull(actualBuildPageDTOResult.getItemCriteriaDTOList());
    assertEquals(1, actualBuildPageDTOResult.getPriority().intValue());
    assertEquals(1L, actualBuildPageDTOResult.getId().longValue());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   * <ul>
   *   <li>Then return ItemCriteriaDTOList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  public void testBuildPageDTO_thenReturnItemCriteriaDTOListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    HashSet<PageItemCriteria> pageItemCriteriaSet = new HashSet<>();
    pageItemCriteriaSet.add(new PageItemCriteriaImpl());
    PageImpl page = mock(PageImpl.class);
    when(page.getPriority()).thenReturn(1);
    when(page.getId()).thenReturn(1L);
    when(page.getDescription()).thenReturn("The characteristics of someone or something");
    when(page.getFullUrl()).thenReturn("https://example.org/example");
    when(page.getMetaDescription()).thenReturn("Meta Description");
    when(page.getMetaTitle()).thenReturn("Dr");
    when(page.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(new HashMap<>());
    when(page.getPageMatchRules()).thenReturn(new HashMap<>());
    when(page.getQualifyingItemCriteria()).thenReturn(pageItemCriteriaSet);
    when(page.getPageTemplate()).thenReturn(new PageTemplateImpl());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(page).getAdditionalAttributes();
    verify(page).getDescription();
    verify(page).getFullUrl();
    verify(page).getId();
    verify(page).getMetaDescription();
    verify(page).getMetaTitle();
    verify(page).getPageFields();
    verify(page).getPageMatchRules();
    verify(page, atLeast(1)).getPageTemplate();
    verify(page).getPriority();
    verify(page, atLeast(1)).getQualifyingItemCriteria();
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    ItemCriteriaDTO clone4 = clone3.getClone();
    assertNull(clone4.getQty());
    ItemCriteriaDTO clone5 = clone4.getClone();
    assertNull(clone5.getQty());
    ItemCriteriaDTO clone6 = clone5.getClone();
    assertNull(clone6.getQty());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
    assertNull(clone4.getMatchRule());
    assertNull(clone5.getMatchRule());
    assertNull(clone6.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   * <ul>
   *   <li>Then return {@code Template Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  public void testBuildPageDTO_thenReturnTemplatePath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();
    PageTemplateImpl pageTemplateImpl = mock(PageTemplateImpl.class);
    when(pageTemplateImpl.getTemplatePath()).thenReturn("Template Path");
    when(pageTemplateImpl.getLocale()).thenReturn(new LocaleImpl());
    PageImpl page = mock(PageImpl.class);
    when(page.getPriority()).thenReturn(1);
    when(page.getId()).thenReturn(1L);
    when(page.getDescription()).thenReturn("The characteristics of someone or something");
    when(page.getFullUrl()).thenReturn("https://example.org/example");
    when(page.getMetaDescription()).thenReturn("Meta Description");
    when(page.getMetaTitle()).thenReturn("Dr");
    when(page.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(new HashMap<>());
    when(page.getPageMatchRules()).thenReturn(new HashMap<>());
    when(page.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(page.getPageTemplate()).thenReturn(pageTemplateImpl);

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(page).getAdditionalAttributes();
    verify(page).getDescription();
    verify(page).getFullUrl();
    verify(page).getId();
    verify(page).getMetaDescription();
    verify(page).getMetaTitle();
    verify(page).getPageFields();
    verify(page).getPageMatchRules();
    verify(page, atLeast(1)).getPageTemplate();
    verify(page).getPriority();
    verify(page, atLeast(1)).getQualifyingItemCriteria();
    verify(pageTemplateImpl, atLeast(1)).getLocale();
    verify(pageTemplateImpl).getTemplatePath();
    Map<String, String> pageAttributes = actualBuildPageDTOResult.getPageAttributes();
    assertEquals(2, pageAttributes.size());
    assertEquals("Dr", pageAttributes.get("title"));
    assertEquals("Meta Description", pageAttributes.get("metaDescription"));
    assertEquals("Template Path", actualBuildPageDTOResult.getTemplatePath());
    assertEquals("The characteristics of someone or something", actualBuildPageDTOResult.getDescription());
    assertEquals("https://example.org/example", actualBuildPageDTOResult.getUrl());
    assertNull(actualBuildPageDTOResult.getItemCriteriaDTOList());
    assertEquals(1, actualBuildPageDTOResult.getPriority().intValue());
    assertEquals(1L, actualBuildPageDTOResult.getId().longValue());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   * <ul>
   *   <li>When {@link PageImpl} (default constructor).</li>
   *   <li>Then return Id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  public void testBuildPageDTO_whenPageImpl_thenReturnIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(new PageImpl(), true);

    // Assert
    assertNull(actualBuildPageDTOResult.getId());
    Map<String, String> pageAttributes = actualBuildPageDTOResult.getPageAttributes();
    assertEquals(2, pageAttributes.size());
    assertNull(pageAttributes.get("metaDescription"));
    assertNull(pageAttributes.get("title"));
    assertNull(actualBuildPageDTOResult.getDescription());
    assertNull(actualBuildPageDTOResult.getUrl());
    assertEquals(0, actualBuildPageDTOResult.getPriority().intValue());
  }

  /**
   * Test {@link PageServiceUtility#buildRuleExpression(Page)}.
   * <p>
   * Method under test: {@link PageServiceUtility#buildRuleExpression(Page)}
   */
  @Test
  public void testBuildRuleExpression() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    PageImpl page = new PageImpl();
    page.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageFields(new HashMap<>());
    page.setPageTemplate(new PageTemplateImpl());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setPageMatchRules(null);

    // Act and Assert
    assertNull(pageServiceUtility.buildRuleExpression(page));
  }

  /**
   * Test {@link PageServiceUtility#buildRuleExpression(Page)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@link PageRuleImpl}
   * (default constructor).</li>
   *   <li>Then return {@code Match Rule && null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildRuleExpression(Page)}
   */
  @Test
  public void testBuildRuleExpression_givenHashMap42IsPageRuleImpl_thenReturnMatchRuleNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();
    PageRuleImpl pageRuleImpl = mock(PageRuleImpl.class);
    when(pageRuleImpl.getMatchRule()).thenReturn("Match Rule");

    HashMap<String, PageRule> stringPageRuleMap = new HashMap<>();
    stringPageRuleMap.put("42", new PageRuleImpl());
    stringPageRuleMap.putAll(new HashMap<>());
    stringPageRuleMap.put("foo", pageRuleImpl);
    PageImpl page = mock(PageImpl.class);
    when(page.getPageMatchRules()).thenReturn(stringPageRuleMap);

    // Act
    String actualBuildRuleExpressionResult = pageServiceUtility.buildRuleExpression(page);

    // Assert
    verify(page).getPageMatchRules();
    verify(pageRuleImpl).getMatchRule();
    assertEquals("Match Rule && null", actualBuildRuleExpressionResult);
  }

  /**
   * Test {@link PageServiceUtility#buildRuleExpression(Page)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildRuleExpression(Page)}
   */
  @Test
  public void testBuildRuleExpression_givenHashMap_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();
    PageImpl page = mock(PageImpl.class);
    when(page.getPageMatchRules()).thenReturn(new HashMap<>());

    // Act
    String actualBuildRuleExpressionResult = pageServiceUtility.buildRuleExpression(page);

    // Assert
    verify(page).getPageMatchRules();
    assertNull(actualBuildRuleExpressionResult);
  }

  /**
   * Test {@link PageServiceUtility#buildRuleExpression(Page)}.
   * <ul>
   *   <li>Then return {@code Match Rule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildRuleExpression(Page)}
   */
  @Test
  public void testBuildRuleExpression_thenReturnMatchRule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();
    PageRuleImpl pageRuleImpl = mock(PageRuleImpl.class);
    when(pageRuleImpl.getMatchRule()).thenReturn("Match Rule");

    HashMap<String, PageRule> stringPageRuleMap = new HashMap<>();
    stringPageRuleMap.put("foo", pageRuleImpl);
    PageImpl page = mock(PageImpl.class);
    when(page.getPageMatchRules()).thenReturn(stringPageRuleMap);

    // Act
    String actualBuildRuleExpressionResult = pageServiceUtility.buildRuleExpression(page);

    // Assert
    verify(page).getPageMatchRules();
    verify(pageRuleImpl).getMatchRule();
    assertEquals("Match Rule", actualBuildRuleExpressionResult);
  }

  /**
   * Test {@link PageServiceUtility#buildRuleExpression(Page)}.
   * <ul>
   *   <li>When {@link PageImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildRuleExpression(Page)}
   */
  @Test
  public void testBuildRuleExpression_whenPageImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    // Act and Assert
    assertNull(pageServiceUtility.buildRuleExpression(new PageImpl()));
  }

  /**
   * Test {@link PageServiceUtility#buildItemCriteriaDTOList(Page)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link PageImpl#getQualifyingItemCriteria()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildItemCriteriaDTOList(Page)}
   */
  @Test
  public void testBuildItemCriteriaDTOList_givenHashSet_thenCallsGetQualifyingItemCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();
    PageImpl page = mock(PageImpl.class);
    when(page.getQualifyingItemCriteria()).thenReturn(new HashSet<>());

    // Act
    List<ItemCriteriaDTO> actualBuildItemCriteriaDTOListResult = pageServiceUtility.buildItemCriteriaDTOList(page);

    // Assert
    verify(page).getQualifyingItemCriteria();
    assertTrue(actualBuildItemCriteriaDTOListResult.isEmpty());
  }

  /**
   * Test {@link PageServiceUtility#buildItemCriteriaDTOList(Page)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildItemCriteriaDTOList(Page)}
   */
  @Test
  public void testBuildItemCriteriaDTOList_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageImpl page = new PageImpl();
    page.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageFields(new HashMap<>());
    page.setPageMatchRules(new HashMap<>());
    page.setPageTemplate(new PageTemplateImpl());
    page.setPriority(1);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);

    // Act
    List<ItemCriteriaDTO> actualBuildItemCriteriaDTOListResult = pageServiceUtility.buildItemCriteriaDTOList(page);

    // Assert
    assertEquals(1, actualBuildItemCriteriaDTOListResult.size());
    ItemCriteriaDTO getResult = actualBuildItemCriteriaDTOListResult.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    ItemCriteriaDTO clone4 = clone3.getClone();
    assertNull(clone4.getQty());
    ItemCriteriaDTO clone5 = clone4.getClone();
    assertNull(clone5.getQty());
    ItemCriteriaDTO clone6 = clone5.getClone();
    assertNull(clone6.getQty());
    ItemCriteriaDTO clone7 = clone6.getClone();
    assertNull(clone7.getQty());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
    assertNull(clone4.getMatchRule());
    assertNull(clone5.getMatchRule());
    assertNull(clone6.getMatchRule());
    assertNull(clone7.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildItemCriteriaDTOList(Page)}.
   * <ul>
   *   <li>When {@link PageImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildItemCriteriaDTOList(Page)}
   */
  @Test
  public void testBuildItemCriteriaDTOList_whenPageImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    // Act and Assert
    assertTrue(pageServiceUtility.buildItemCriteriaDTOList(new PageImpl()).isEmpty());
  }

  /**
   * Test {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code 42}.</li>
   *   <li>Then return {@link NullPageDTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}
   */
  @Test
  public void testHydrateForeignLookups_givenHashMapFooIs42_thenReturnNullPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("foo", "42");
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getForeignPageFields()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(stringObjectMap);

    // Act
    PageDTO actualHydrateForeignLookupsResult = pageServiceUtility.hydrateForeignLookups(page);

    // Assert
    verify(page).getForeignPageFields();
    verify(page).getPageFields();
    assertSame(page, actualHydrateForeignLookupsResult);
  }

  /**
   * Test {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link NullPageDTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}
   */
  @Test
  public void testHydrateForeignLookups_givenHashMap_thenReturnNullPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getForeignPageFields()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(new HashMap<>());

    // Act
    PageDTO actualHydrateForeignLookupsResult = pageServiceUtility.hydrateForeignLookups(page);

    // Assert
    verify(page).getForeignPageFields();
    verify(page).getPageFields();
    assertSame(page, actualHydrateForeignLookupsResult);
  }

  /**
   * Test {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   *   <li>Then return {@link PageDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}
   */
  @Test
  public void testHydrateForeignLookups_whenPageDTO_thenReturnPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();
    PageDTO page = new PageDTO();

    // Act and Assert
    assertSame(page, pageServiceUtility.hydrateForeignLookups(page));
  }
}
