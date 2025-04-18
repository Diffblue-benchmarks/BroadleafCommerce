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
package org.broadleafcommerce.cms.page.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.cms.field.domain.FieldDefinition;
import org.broadleafcommerce.cms.page.dao.PageDao;
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageAttribute;
import org.broadleafcommerce.cms.page.domain.PageAttributeImpl;
import org.broadleafcommerce.cms.page.domain.PageField;
import org.broadleafcommerce.cms.page.domain.PageFieldImpl;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.broadleafcommerce.cms.page.domain.PageItemCriteria;
import org.broadleafcommerce.cms.page.domain.PageItemCriteriaImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplateImpl;
import org.broadleafcommerce.common.dao.GenericEntityDao;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.file.service.StaticAssetPathService;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PageServiceUtilityDiffblueTest {
  @Mock
  private GenericEntityDao genericEntityDao;

  @Mock
  private PageDao pageDao;

  @Mock
  private PageServiceExtensionManager pageServiceExtensionManager;

  @InjectMocks
  private PageServiceUtility pageServiceUtility;

  @Mock
  private SandBoxHelper sandBoxHelper;

  @Mock
  private StaticAssetPathService staticAssetPathService;

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("");
    PageFieldImpl pageFieldImpl = mock(PageFieldImpl.class);
    when(pageFieldImpl.getValue()).thenReturn("42");

    HashMap<String, PageField> stringPageFieldMap = new HashMap<>();
    stringPageFieldMap.put("title", pageFieldImpl);
    PageImpl page = mock(PageImpl.class);
    when(page.getPriority()).thenReturn(1);
    when(page.getId()).thenReturn(1L);
    when(page.getDescription()).thenReturn("The characteristics of someone or something");
    when(page.getFullUrl()).thenReturn("https://example.org/example");
    when(page.getMetaDescription()).thenReturn("Meta Description");
    when(page.getMetaTitle()).thenReturn("Dr");
    when(page.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(stringPageFieldMap);
    when(page.getPageMatchRules()).thenReturn(new HashMap<>());
    when(page.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(page.getPageTemplate()).thenReturn(new PageTemplateImpl());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageFieldImpl).getValue();
    verify(page).getAdditionalAttributes();
    verify(page).getDescription();
    verify(page).getFullUrl();
    verify(page).getId();
    verify(page).getMetaDescription();
    verify(page).getMetaTitle();
    verify(page, atLeast(1)).getPageFields();
    verify(page).getPageMatchRules();
    verify(page, atLeast(1)).getPageTemplate();
    verify(page).getPriority();
    verify(page, atLeast(1)).getQualifyingItemCriteria();
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields.size());
    assertEquals("42", pageFields.get("title"));
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
   *   <li>Given {@link HashMap#HashMap()} {@code title} is {@link PageAttributeImpl} (default constructor).</li>
   *   <li>Then return PageFields Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_givenHashMapTitleIsPageAttributeImpl_thenReturnPageFieldsEmpty() {
    // Arrange
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
    assertTrue(actualBuildPageDTOResult.getPageFields().isEmpty());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   * <ul>
   *   <li>Given {@link PageServiceExtensionHandler} {@link PageServiceExtensionHandler#getFieldDefinition(ExtensionResultHolder, Page, String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_givenPageServiceExtensionHandlerGetFieldDefinitionReturnNull() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(null);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");

    HashMap<String, PageField> stringPageFieldMap = new HashMap<>();
    stringPageFieldMap.put("title", new PageFieldImpl());
    PageImpl page = mock(PageImpl.class);
    when(page.getPriority()).thenReturn(1);
    when(page.getId()).thenReturn(1L);
    when(page.getDescription()).thenReturn("The characteristics of someone or something");
    when(page.getFullUrl()).thenReturn("https://example.org/example");
    when(page.getMetaDescription()).thenReturn("Meta Description");
    when(page.getMetaTitle()).thenReturn("Dr");
    when(page.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(stringPageFieldMap);
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
    verify(page, atLeast(1)).getPageFields();
    verify(page).getPageMatchRules();
    verify(page, atLeast(1)).getPageTemplate();
    verify(page).getPriority();
    verify(page, atLeast(1)).getQualifyingItemCriteria();
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, String> pageAttributes = actualBuildPageDTOResult.getPageAttributes();
    assertEquals(2, pageAttributes.size());
    assertEquals("Dr", pageAttributes.get("title"));
    assertEquals("Meta Description", pageAttributes.get("metaDescription"));
    assertEquals("The characteristics of someone or something", actualBuildPageDTOResult.getDescription());
    assertEquals("https://example.org/example", actualBuildPageDTOResult.getUrl());
    Map<String, Object> pageFields = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields.size());
    assertNull(pageFields.get("title"));
    assertNull(actualBuildPageDTOResult.getTemplatePath());
    assertNull(actualBuildPageDTOResult.getItemCriteriaDTOList());
    assertEquals(1, actualBuildPageDTOResult.getPriority().intValue());
    assertEquals(1L, actualBuildPageDTOResult.getId().longValue());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   * <ul>
   *   <li>Given {@link StaticAssetPathService} {@link StaticAssetPathService#getStaticAssetUrlPrefix()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_givenStaticAssetPathServiceGetStaticAssetUrlPrefixReturnNull() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn(null);
    PageFieldImpl pageFieldImpl = mock(PageFieldImpl.class);
    when(pageFieldImpl.getValue()).thenReturn("42");

    HashMap<String, PageField> stringPageFieldMap = new HashMap<>();
    stringPageFieldMap.put("title", pageFieldImpl);
    PageImpl page = mock(PageImpl.class);
    when(page.getPriority()).thenReturn(1);
    when(page.getId()).thenReturn(1L);
    when(page.getDescription()).thenReturn("The characteristics of someone or something");
    when(page.getFullUrl()).thenReturn("https://example.org/example");
    when(page.getMetaDescription()).thenReturn("Meta Description");
    when(page.getMetaTitle()).thenReturn("Dr");
    when(page.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(stringPageFieldMap);
    when(page.getPageMatchRules()).thenReturn(new HashMap<>());
    when(page.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(page.getPageTemplate()).thenReturn(new PageTemplateImpl());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageFieldImpl).getValue();
    verify(page).getAdditionalAttributes();
    verify(page).getDescription();
    verify(page).getFullUrl();
    verify(page).getId();
    verify(page).getMetaDescription();
    verify(page).getMetaTitle();
    verify(page, atLeast(1)).getPageFields();
    verify(page).getPageMatchRules();
    verify(page, atLeast(1)).getPageTemplate();
    verify(page).getPriority();
    verify(page, atLeast(1)).getQualifyingItemCriteria();
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields.size());
    assertEquals("42", pageFields.get("title"));
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
   *   <li>Given {@link StaticAssetPathService}.</li>
   *   <li>Then return PageFields Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_givenStaticAssetPathService_thenReturnPageFieldsEmpty() {
    // Arrange
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
    assertTrue(actualBuildPageDTOResult.getPageFields().isEmpty());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   * <ul>
   *   <li>Given {@link StaticAssetPathService}.</li>
   *   <li>When {@link PageImpl} (default constructor).</li>
   *   <li>Then return Id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_givenStaticAssetPathService_whenPageImpl_thenReturnIdIsNull() {
    // Arrange and Act
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
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   * <ul>
   *   <li>Then return ItemCriteriaDTOList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_thenReturnItemCriteriaDTOListSizeIsOne() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.convertAllAssetPathsInContent(Mockito.<String>any(), anyBoolean()))
        .thenReturn("Not all who wander are lost");
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("42");
    PageFieldImpl pageFieldImpl = mock(PageFieldImpl.class);
    when(pageFieldImpl.getValue()).thenReturn("42");

    HashMap<String, PageField> stringPageFieldMap = new HashMap<>();
    stringPageFieldMap.put("title", pageFieldImpl);

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
    when(page.getPageFields()).thenReturn(stringPageFieldMap);
    when(page.getPageMatchRules()).thenReturn(new HashMap<>());
    when(page.getQualifyingItemCriteria()).thenReturn(pageItemCriteriaSet);
    when(page.getPageTemplate()).thenReturn(new PageTemplateImpl());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageFieldImpl).getValue();
    verify(page).getAdditionalAttributes();
    verify(page).getDescription();
    verify(page).getFullUrl();
    verify(page).getId();
    verify(page).getMetaDescription();
    verify(page).getMetaTitle();
    verify(page, atLeast(1)).getPageFields();
    verify(page).getPageMatchRules();
    verify(page, atLeast(1)).getPageTemplate();
    verify(page).getPriority();
    verify(page, atLeast(1)).getQualifyingItemCriteria();
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).convertAllAssetPathsInContent(eq("42"), eq(true));
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
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
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
    assertNull(clone4.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   * <ul>
   *   <li>Then return PageFields {@code title} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_thenReturnPageFieldsTitleIs42() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");
    PageFieldImpl pageFieldImpl = mock(PageFieldImpl.class);
    when(pageFieldImpl.getValue()).thenReturn("42");

    HashMap<String, PageField> stringPageFieldMap = new HashMap<>();
    stringPageFieldMap.put("title", pageFieldImpl);
    PageImpl page = mock(PageImpl.class);
    when(page.getPriority()).thenReturn(1);
    when(page.getId()).thenReturn(1L);
    when(page.getDescription()).thenReturn("The characteristics of someone or something");
    when(page.getFullUrl()).thenReturn("https://example.org/example");
    when(page.getMetaDescription()).thenReturn("Meta Description");
    when(page.getMetaTitle()).thenReturn("Dr");
    when(page.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(stringPageFieldMap);
    when(page.getPageMatchRules()).thenReturn(new HashMap<>());
    when(page.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(page.getPageTemplate()).thenReturn(new PageTemplateImpl());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageFieldImpl).getValue();
    verify(page).getAdditionalAttributes();
    verify(page).getDescription();
    verify(page).getFullUrl();
    verify(page).getId();
    verify(page).getMetaDescription();
    verify(page).getMetaTitle();
    verify(page, atLeast(1)).getPageFields();
    verify(page).getPageMatchRules();
    verify(page, atLeast(1)).getPageTemplate();
    verify(page).getPriority();
    verify(page, atLeast(1)).getQualifyingItemCriteria();
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields.size());
    assertEquals("42", pageFields.get("title"));
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
   *   <li>Then return PageFields {@code title} is {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_thenReturnPageFieldsTitleIsNotAllWhoWanderAreLost() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.convertAllAssetPathsInContent(Mockito.<String>any(), anyBoolean()))
        .thenReturn("Not all who wander are lost");
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("42");
    PageFieldImpl pageFieldImpl = mock(PageFieldImpl.class);
    when(pageFieldImpl.getValue()).thenReturn("42");

    HashMap<String, PageField> stringPageFieldMap = new HashMap<>();
    stringPageFieldMap.put("title", pageFieldImpl);
    PageImpl page = mock(PageImpl.class);
    when(page.getPriority()).thenReturn(1);
    when(page.getId()).thenReturn(1L);
    when(page.getDescription()).thenReturn("The characteristics of someone or something");
    when(page.getFullUrl()).thenReturn("https://example.org/example");
    when(page.getMetaDescription()).thenReturn("Meta Description");
    when(page.getMetaTitle()).thenReturn("Dr");
    when(page.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(stringPageFieldMap);
    when(page.getPageMatchRules()).thenReturn(new HashMap<>());
    when(page.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(page.getPageTemplate()).thenReturn(new PageTemplateImpl());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageFieldImpl).getValue();
    verify(page).getAdditionalAttributes();
    verify(page).getDescription();
    verify(page).getFullUrl();
    verify(page).getId();
    verify(page).getMetaDescription();
    verify(page).getMetaTitle();
    verify(page, atLeast(1)).getPageFields();
    verify(page).getPageMatchRules();
    verify(page, atLeast(1)).getPageTemplate();
    verify(page).getPriority();
    verify(page, atLeast(1)).getQualifyingItemCriteria();
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).convertAllAssetPathsInContent(eq("42"), eq(true));
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, String> pageAttributes = actualBuildPageDTOResult.getPageAttributes();
    assertEquals(2, pageAttributes.size());
    assertEquals("Dr", pageAttributes.get("title"));
    assertEquals("Meta Description", pageAttributes.get("metaDescription"));
    Map<String, Object> pageFields = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields.size());
    assertEquals("Not all who wander are lost", pageFields.get("title"));
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
   *   <li>Then return PageFields {@code title} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_thenReturnPageFieldsTitleIsNull() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");

    HashMap<String, PageField> stringPageFieldMap = new HashMap<>();
    stringPageFieldMap.put("title", new PageFieldImpl());
    PageImpl page = mock(PageImpl.class);
    when(page.getPriority()).thenReturn(1);
    when(page.getId()).thenReturn(1L);
    when(page.getDescription()).thenReturn("The characteristics of someone or something");
    when(page.getFullUrl()).thenReturn("https://example.org/example");
    when(page.getMetaDescription()).thenReturn("Meta Description");
    when(page.getMetaTitle()).thenReturn("Dr");
    when(page.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(stringPageFieldMap);
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
    verify(page, atLeast(1)).getPageFields();
    verify(page).getPageMatchRules();
    verify(page, atLeast(1)).getPageTemplate();
    verify(page).getPriority();
    verify(page, atLeast(1)).getQualifyingItemCriteria();
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, String> pageAttributes = actualBuildPageDTOResult.getPageAttributes();
    assertEquals(2, pageAttributes.size());
    assertEquals("Dr", pageAttributes.get("title"));
    assertEquals("Meta Description", pageAttributes.get("metaDescription"));
    assertEquals("The characteristics of someone or something", actualBuildPageDTOResult.getDescription());
    assertEquals("https://example.org/example", actualBuildPageDTOResult.getUrl());
    Map<String, Object> pageFields = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields.size());
    assertNull(pageFields.get("title"));
    assertNull(actualBuildPageDTOResult.getTemplatePath());
    assertNull(actualBuildPageDTOResult.getItemCriteriaDTOList());
    assertEquals(1, actualBuildPageDTOResult.getPriority().intValue());
    assertEquals(1L, actualBuildPageDTOResult.getId().longValue());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_thenReturnTemplatePath() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.convertAllAssetPathsInContent(Mockito.<String>any(), anyBoolean()))
        .thenReturn("Not all who wander are lost");
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("42");
    PageFieldImpl pageFieldImpl = mock(PageFieldImpl.class);
    when(pageFieldImpl.getValue()).thenReturn("42");

    HashMap<String, PageField> stringPageFieldMap = new HashMap<>();
    stringPageFieldMap.put("title", pageFieldImpl);
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
    when(page.getPageFields()).thenReturn(stringPageFieldMap);
    when(page.getPageMatchRules()).thenReturn(new HashMap<>());
    when(page.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(page.getPageTemplate()).thenReturn(pageTemplateImpl);

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageFieldImpl).getValue();
    verify(page).getAdditionalAttributes();
    verify(page).getDescription();
    verify(page).getFullUrl();
    verify(page).getId();
    verify(page).getMetaDescription();
    verify(page).getMetaTitle();
    verify(page, atLeast(1)).getPageFields();
    verify(page).getPageMatchRules();
    verify(page, atLeast(1)).getPageTemplate();
    verify(page).getPriority();
    verify(page, atLeast(1)).getQualifyingItemCriteria();
    verify(pageTemplateImpl, atLeast(1)).getLocale();
    verify(pageTemplateImpl).getTemplatePath();
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).convertAllAssetPathsInContent(eq("42"), eq(true));
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields.size());
    assertEquals("Not all who wander are lost", pageFields.get("title"));
    assertEquals("Template Path", actualBuildPageDTOResult.getTemplatePath());
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   * <p>
   * Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"})
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");
    PageImpl page = new PageImpl();
    PageDTO pageDTO = new PageDTO();

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields = pageDTO.getPageFields();
    assertEquals(1, pageFields.size());
    assertEquals("42", pageFields.get("Field Key"));
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   * <p>
   * Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"})
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue2() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(null);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");
    PageImpl page = new PageImpl();
    PageDTO pageDTO = new PageDTO();

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields = pageDTO.getPageFields();
    assertEquals(1, pageFields.size());
    assertEquals("42", pageFields.get("Field Key"));
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   * <p>
   * Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"})
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue3() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn(null);
    PageImpl page = new PageImpl();
    PageDTO pageDTO = new PageDTO();

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields = pageDTO.getPageFields();
    assertEquals(1, pageFields.size());
    assertEquals("42", pageFields.get("Field Key"));
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   * <p>
   * Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"})
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue4() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.convertAllAssetPathsInContent(Mockito.<String>any(), anyBoolean()))
        .thenReturn("Not all who wander are lost");
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("42");
    PageImpl page = new PageImpl();
    PageDTO pageDTO = new PageDTO();

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).convertAllAssetPathsInContent(eq("42"), eq(true));
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields = pageDTO.getPageFields();
    assertEquals(1, pageFields.size());
    assertEquals("Not all who wander are lost", pageFields.get("Field Key"));
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   * <p>
   * Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"})
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue5() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("");
    PageImpl page = new PageImpl();
    PageDTO pageDTO = new PageDTO();

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields = pageDTO.getPageFields();
    assertEquals(1, pageFields.size());
    assertEquals("42", pageFields.get("Field Key"));
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   * <p>
   * Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"})
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue6() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.convertAllAssetPathsInContent(Mockito.<String>any(), anyBoolean()))
        .thenReturn("Not all who wander are lost");
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("42");
    PageImpl page = new PageImpl();
    PageDTO pageDTO = mock(PageDTO.class);
    when(pageDTO.getPageFields()).thenReturn(new HashMap<>());

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).convertAllAssetPathsInContent(eq("42"), eq(true));
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(pageDTO).getPageFields();
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   * <p>
   * Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"})
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue7() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");
    PageImpl page = new PageImpl();
    PageDTO pageDTO = mock(PageDTO.class);
    when(pageDTO.getPageFields()).thenReturn(new HashMap<>());

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(pageDTO).getPageFields();
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"})
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue_whenEmptyString() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler = mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
        Mockito.<Page>any(), Mockito.<String>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("42");
    PageImpl page = new PageImpl();
    PageDTO pageDTO = mock(PageDTO.class);
    when(pageDTO.getPageFields()).thenReturn(new HashMap<>());

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "");

    // Assert
    verify(pageServiceExtensionHandler).getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class),
        eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(pageDTO).getPageFields();
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageServiceUtility.buildItemCriteriaDTOList(Page)"})
  public void testBuildItemCriteriaDTOList_thenReturnSizeIsOne() {
    // Arrange
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
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
    assertNull(clone4.getMatchRule());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageServiceUtility.buildItemCriteriaDTOList(Page)"})
  public void testBuildItemCriteriaDTOList_whenPageImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(pageServiceUtility.buildItemCriteriaDTOList(new PageImpl()).isEmpty());
  }
}
