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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.cache.Cache;
import javax.cache.CacheManager;
import org.broadleafcommerce.cms.page.dao.PageDao;
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageField;
import org.broadleafcommerce.cms.page.domain.PageFieldImpl;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplate;
import org.broadleafcommerce.cms.page.domain.PageTemplateImpl;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.extension.ResultType;
import org.broadleafcommerce.common.extension.SparselyPopulatedQueryExtensionHandler;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.rule.RuleProcessor;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class PageServiceImplDiffblueTest {
  @Mock private CacheManager cacheManager;

  @Mock private List<RuleProcessor<PageDTO>> list;

  @Mock private LocaleService localeService;

  @Mock private PageDao pageDao;

  @Mock private PageQueryExtensionManager pageQueryExtensionManager;

  @InjectMocks private PageServiceImpl pageServiceImpl;

  @Mock private PageServiceUtility pageServiceUtility;

  /**
   * Test {@link PageServiceImpl#findPageById(Long)}.
   *
   * <p>Method under test: {@link PageServiceImpl#findPageById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Page PageServiceImpl.findPageById(Long)"})
  public void testFindPageById() {
    // Arrange
    PageImpl pageImpl = new PageImpl();
    when(pageDao.readPageById(Mockito.<Long>any())).thenReturn(pageImpl);

    // Act
    Page actualFindPageByIdResult = pageServiceImpl.findPageById(1L);

    // Assert
    verify(pageDao).readPageById(1L);
    assertSame(pageImpl, actualFindPageByIdResult);
  }

  /**
   * Test {@link PageServiceImpl#findPageFieldMapByPageId(Long)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PageFieldImpl} (default constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#findPageFieldMapByPageId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PageServiceImpl.findPageFieldMapByPageId(Long)"})
  public void testFindPageFieldMapByPageId_givenArrayListAddPageFieldImpl_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PageField> pageFieldList = new ArrayList<>();
    PageFieldImpl pageFieldImpl = new PageFieldImpl();
    pageFieldList.add(pageFieldImpl);
    when(pageDao.readPageFieldsByPageId(Mockito.<Long>any())).thenReturn(pageFieldList);

    // Act
    Map<String, PageField> actualFindPageFieldMapByPageIdResult =
        pageServiceImpl.findPageFieldMapByPageId(1L);

    // Assert
    verify(pageDao).readPageFieldsByPageId(1L);
    assertEquals(1, actualFindPageFieldMapByPageIdResult.size());
    assertSame(pageFieldImpl, actualFindPageFieldMapByPageIdResult.get(null));
  }

  /**
   * Test {@link PageServiceImpl#findPageFieldMapByPageId(Long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#findPageFieldMapByPageId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PageServiceImpl.findPageFieldMapByPageId(Long)"})
  public void testFindPageFieldMapByPageId_thenReturnEmpty() {
    // Arrange
    when(pageDao.readPageFieldsByPageId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    Map<String, PageField> actualFindPageFieldMapByPageIdResult =
        pageServiceImpl.findPageFieldMapByPageId(1L);

    // Assert
    verify(pageDao).readPageFieldsByPageId(1L);
    assertTrue(actualFindPageFieldMapByPageIdResult.isEmpty());
  }

  /**
   * Test {@link PageServiceImpl#findPageTemplateById(Long)}.
   *
   * <p>Method under test: {@link PageServiceImpl#findPageTemplateById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageTemplate PageServiceImpl.findPageTemplateById(Long)"})
  public void testFindPageTemplateById() {
    // Arrange
    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    when(pageDao.readPageTemplateById(Mockito.<Long>any())).thenReturn(pageTemplateImpl);

    // Act
    PageTemplate actualFindPageTemplateByIdResult = pageServiceImpl.findPageTemplateById(1L);

    // Assert
    verify(pageDao).readPageTemplateById(1L);
    assertSame(pageTemplateImpl, actualFindPageTemplateByIdResult);
  }

  /**
   * Test {@link PageServiceImpl#savePageTemplate(PageTemplate)}.
   *
   * <p>Method under test: {@link PageServiceImpl#savePageTemplate(PageTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageTemplate PageServiceImpl.savePageTemplate(PageTemplate)"})
  public void testSavePageTemplate() {
    // Arrange
    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    when(pageDao.savePageTemplate(Mockito.<PageTemplate>any())).thenReturn(pageTemplateImpl);

    // Act
    PageTemplate actualSavePageTemplateResult =
        pageServiceImpl.savePageTemplate(new PageTemplateImpl());

    // Assert
    verify(pageDao).savePageTemplate(isA(PageTemplate.class));
    assertSame(pageTemplateImpl, actualSavePageTemplateResult);
  }

  /**
   * Test {@link PageServiceImpl#getPageDTOListForURI(Locale, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#getPageDTOListForURI(Locale, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageServiceImpl.getPageDTOListForURI(Locale, String, boolean)"})
  public void testGetPageDTOListForURI_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(pageServiceImpl.getPageDTOListForURI(null, null, true));
  }

  /**
   * Test {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}.
   *
   * <p>Method under test: {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageServiceImpl.addPageListToPageDTOList(List, boolean, List)"})
  public void testAddPageListToPageDTOList() {
    // Arrange
    PageDTO pageDTO = new PageDTO();
    when(pageServiceUtility.buildPageDTO(Mockito.<Page>any(), anyBoolean())).thenReturn(pageDTO);

    PageImpl pageImpl = new PageImpl();
    pageImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setAdditionalAttributes(new HashMap<>());
    pageImpl.setDescription("The characteristics of someone or something");
    pageImpl.setExcludeFromSiteMap(true);
    pageImpl.setFullUrl("https://example.org/example");
    pageImpl.setId(1L);
    pageImpl.setMetaDescription("Meta Description");
    pageImpl.setMetaTitle("Dr");
    pageImpl.setOfflineFlag(true);
    pageImpl.setPriority(1);
    pageImpl.setPageTemplate(null);
    pageImpl.setQualifyingItemCriteria(null);
    pageImpl.setPageMatchRules(null);
    pageImpl.setPageFields(new HashMap<>());

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(pageImpl);
    ArrayList<PageDTO> dtoList = new ArrayList<>();

    // Act
    pageServiceImpl.addPageListToPageDTOList(pageList, true, dtoList);

    // Assert
    verify(pageServiceUtility).buildPageDTO(isA(Page.class), eq(true));
    assertEquals(1, dtoList.size());
    assertSame(pageDTO, dtoList.get(0));
  }

  /**
   * Test {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}.
   *
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageServiceImpl.addPageListToPageDTOList(List, boolean, List)"})
  public void testAddPageListToPageDTOList_givenPageDTO_thenArrayListSizeIsTwo() {
    // Arrange
    PageDTO pageDTO = new PageDTO();
    when(pageServiceUtility.buildPageDTO(Mockito.<Page>any(), anyBoolean())).thenReturn(pageDTO);

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(new PageImpl());
    pageList.add(new PageImpl());

    ArrayList<PageDTO> dtoList = new ArrayList<>();
    dtoList.add(new PageDTO());

    // Act
    pageServiceImpl.addPageListToPageDTOList(pageList, true, dtoList);

    // Assert
    verify(pageServiceUtility, atLeast(1)).buildPageDTO(Mockito.<Page>any(), eq(true));
    assertEquals(2, dtoList.size());
    assertSame(pageDTO, dtoList.get(1));
  }

  /**
   * Test {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}.
   *
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageServiceImpl.addPageListToPageDTOList(List, boolean, List)"})
  public void testAddPageListToPageDTOList_givenPageImpl_thenArrayListSizeIsOne() {
    // Arrange
    PageDTO pageDTO = new PageDTO();
    when(pageServiceUtility.buildPageDTO(Mockito.<Page>any(), anyBoolean())).thenReturn(pageDTO);

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(new PageImpl());
    pageList.add(new PageImpl());
    ArrayList<PageDTO> dtoList = new ArrayList<>();

    // Act
    pageServiceImpl.addPageListToPageDTOList(pageList, true, dtoList);

    // Assert
    verify(pageServiceUtility, atLeast(1)).buildPageDTO(Mockito.<Page>any(), eq(true));
    assertEquals(1, dtoList.size());
    assertSame(pageDTO, dtoList.get(0));
  }

  /**
   * Test {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageServiceImpl.addPageListToPageDTOList(List, boolean, List)"})
  public void testAddPageListToPageDTOList_whenArrayList_thenArrayListEmpty() {
    // Arrange
    ArrayList<Page> pageList = new ArrayList<>();
    ArrayList<PageDTO> dtoList = new ArrayList<>();

    // Act
    pageServiceImpl.addPageListToPageDTOList(pageList, true, dtoList);

    // Assert that nothing has changed
    assertTrue(dtoList.isEmpty());
  }

  /**
   * Test {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageServiceImpl.addPageListToPageDTOList(List, boolean, List)"})
  public void testAddPageListToPageDTOList_whenNull_thenArrayListEmpty() {
    // Arrange
    ArrayList<PageDTO> dtoList = new ArrayList<>();

    // Act
    pageServiceImpl.addPageListToPageDTOList(null, true, dtoList);

    // Assert that nothing has changed
    assertTrue(dtoList.isEmpty());
  }

  /**
   * Test {@link PageServiceImpl#getPageListFromCache(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#getPageListFromCache(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageServiceImpl.getPageListFromCache(String)"})
  public void testGetPageListFromCache_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(pageServiceImpl.getPageListFromCache(null));
  }

  /**
   * Test {@link PageServiceImpl#getPageMapCacheKey(String, Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Uri-ALL}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#getPageMapCacheKey(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.getPageMapCacheKey(String, Long)"})
  public void testGetPageMapCacheKey_whenNull_thenReturnUriAll() {
    // Arrange, Act and Assert
    assertEquals("Uri-ALL", pageServiceImpl.getPageMapCacheKey("Uri", null));
  }

  /**
   * Test {@link PageServiceImpl#getPageMapCacheKey(String, Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code Uri-1}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#getPageMapCacheKey(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.getPageMapCacheKey(String, Long)"})
  public void testGetPageMapCacheKey_whenOne_thenReturnUri1() {
    // Arrange, Act and Assert
    assertEquals("Uri-1", pageServiceImpl.getPageMapCacheKey("Uri", 1L));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)} with {@code
   * identifier}, {@code localeCode}, {@code secure}, {@code resultType}.
   *
   * <ul>
   *   <li>Given {@link PageServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, String, Boolean, ResultType)"})
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_givenPageServiceImpl() {
    // Arrange, Act and Assert
    assertEquals(
        "42-en-true", new PageServiceImpl().buildKey("42", "en", true, ResultType.STANDARD));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)} with {@code
   * identifier}, {@code localeCode}, {@code secure}, {@code resultType}.
   *
   * <ul>
   *   <li>Then return {@code 42-en-true}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, String, Boolean, ResultType)"})
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_thenReturn42EnTrue() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(
            Mockito.<String>any(),
            Mockito.<ResultType>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", "en", true, ResultType.STANDARD);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKey(eq("42-en-true"), eq(ResultType.STANDARD), isA(ExtensionResultHolder.class));
    assertEquals("42-en-true", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)} with {@code
   * identifier}, {@code localeCode}, {@code secure}, {@code resultType}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code 42-en}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, String, Boolean, ResultType)"})
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_whenNull_thenReturn42En() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(
            Mockito.<String>any(),
            Mockito.<ResultType>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", "en", null, ResultType.STANDARD);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKey(eq("42-en"), eq(ResultType.STANDARD), isA(ExtensionResultHolder.class));
    assertEquals("42-en", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)} with {@code
   * identifier}, {@code localeCode}, {@code secure}, {@code resultType}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code 42-en-true}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, String, Boolean, ResultType)"})
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_whenNull_thenReturn42EnTrue() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(
            Mockito.<String>any(),
            Mockito.<ResultType>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", "en", true, null);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKey(eq("42-en-true"), eq(ResultType.STANDARD), isA(ExtensionResultHolder.class));
    assertEquals("42-en-true", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)} with {@code
   * identifier}, {@code localeCode}, {@code secure}, {@code resultType}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code 42-true}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, String, Boolean, ResultType)"})
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_whenNull_thenReturn42True() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(
            Mockito.<String>any(),
            Mockito.<ResultType>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", null, true, ResultType.STANDARD);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKey(eq("42-true"), eq(ResultType.STANDARD), isA(ExtensionResultHolder.class));
    assertEquals("42-true", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with {@code identifier}, {@code
   * locale}, {@code secure}.
   *
   * <ul>
   *   <li>Given {@code en}.
   *   <li>Then return {@code 42-en}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, Locale, Boolean)"})
  public void testBuildKeyWithIdentifierLocaleSecure_givenEn_thenReturn42En() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(
            Mockito.<String>any(),
            Mockito.<ResultType>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", locale, null);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKey(eq("42-en"), eq(ResultType.STANDARD), isA(ExtensionResultHolder.class));
    verify(locale).getLocaleCode();
    assertEquals("42-en", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with {@code identifier}, {@code
   * locale}, {@code secure}.
   *
   * <ul>
   *   <li>Given {@code en}.
   *   <li>Then return {@code 42-en-true}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, Locale, Boolean)"})
  public void testBuildKeyWithIdentifierLocaleSecure_givenEn_thenReturn42EnTrue() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(
            Mockito.<String>any(),
            Mockito.<ResultType>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", locale, true);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKey(eq("42-en-true"), eq(ResultType.STANDARD), isA(ExtensionResultHolder.class));
    verify(locale).getLocaleCode();
    assertEquals("42-en-true", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with {@code identifier}, {@code
   * locale}, {@code secure}.
   *
   * <ul>
   *   <li>Given {@link PageServiceImpl} (default constructor).
   *   <li>Then return {@code 42-true}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, Locale, Boolean)"})
  public void testBuildKeyWithIdentifierLocaleSecure_givenPageServiceImpl_thenReturn42True() {
    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    // Act and Assert
    assertEquals("42-true", pageServiceImpl.buildKey("42", new LocaleImpl(), true));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with {@code identifier}, {@code
   * locale}, {@code secure}.
   *
   * <ul>
   *   <li>When {@link LocaleImpl} (default constructor).
   *   <li>Then return {@code 42-true}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, Locale, Boolean)"})
  public void testBuildKeyWithIdentifierLocaleSecure_whenLocaleImpl_thenReturn42True() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(
            Mockito.<String>any(),
            Mockito.<ResultType>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", new LocaleImpl(), true);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKey(eq("42-true"), eq(ResultType.STANDARD), isA(ExtensionResultHolder.class));
    assertEquals("42-true", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with {@code identifier}, {@code
   * locale}, {@code secure}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code 42--true}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, Locale, Boolean)"})
  public void testBuildKeyWithIdentifierLocaleSecure_whenNull_thenReturn42True() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(
            Mockito.<String>any(),
            Mockito.<ResultType>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", null, true);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKey(eq("42--true"), eq(ResultType.STANDARD), isA(ExtensionResultHolder.class));
    assertEquals("42--true", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.buildBaseKey(String, String, Boolean)"})
  public void testBuildBaseKey_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", pageServiceImpl.buildBaseKey("42", null, null));
  }

  /**
   * Test {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42-en-true}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceImpl.buildBaseKey(String, String, Boolean)"})
  public void testBuildBaseKey_when42_thenReturn42EnTrue() {
    // Arrange, Act and Assert
    assertEquals("42-en-true", pageServiceImpl.buildBaseKey("42", "en", true));
  }

  /**
   * Test {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale PageServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_givenBroadleafCurrencyImpl() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("en_");

    // Act
    Locale actualFindLanguageOnlyLocaleResult = pageServiceImpl.findLanguageOnlyLocale(locale);

    // Assert
    verify(localeService).findLocaleByCode("en");
    assertSame(localeImpl, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}.
   *
   * <ul>
   *   <li>Given {@code _}.
   *   <li>Then calls {@link Locale#getLocaleCode()}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale PageServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_givenUnderscore_thenCallsGetLocaleCode() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("_");

    // Act
    Locale actualFindLanguageOnlyLocaleResult = pageServiceImpl.findLanguageOnlyLocale(locale);

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findLocaleByCode(null);
    assertSame(localeImpl, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}.
   *
   * <ul>
   *   <li>Then return {@link Locale}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale PageServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_thenReturnLocale() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(null);

    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("_");

    // Act
    Locale actualFindLanguageOnlyLocaleResult = pageServiceImpl.findLanguageOnlyLocale(locale);

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findLocaleByCode(null);
    assertSame(locale, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}.
   *
   * <ul>
   *   <li>When {@link LocaleImpl} (default constructor).
   *   <li>Then return {@link LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale PageServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_whenLocaleImpl_thenReturnLocaleImpl() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    // Act
    Locale actualFindLanguageOnlyLocaleResult =
        pageServiceImpl.findLanguageOnlyLocale(new LocaleImpl());

    // Assert
    verify(localeService).findLocaleByCode(null);
    assertSame(localeImpl, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale PageServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(pageServiceImpl.findLanguageOnlyLocale(null));
  }

  /**
   * Test {@link PageServiceImpl#getPageCache()}.
   *
   * <p>Method under test: {@link PageServiceImpl#getPageCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache PageServiceImpl.getPageCache()"})
  public void testGetPageCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache actualPageCache = pageServiceImpl.getPageCache();

    // Assert
    verify(cacheManager).getCache("cmsPageCache");
    assertNull(actualPageCache);
  }

  /**
   * Test {@link PageServiceImpl#getPageMapCache()}.
   *
   * <p>Method under test: {@link PageServiceImpl#getPageMapCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache PageServiceImpl.getPageMapCache()"})
  public void testGetPageMapCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache actualPageMapCache = pageServiceImpl.getPageMapCache();

    // Assert
    verify(cacheManager).getCache("cmsPageMapCache");
    assertNull(actualPageMapCache);
  }

  /**
   * Test {@link PageServiceImpl#getUriCachedDateCache()}.
   *
   * <p>Method under test: {@link PageServiceImpl#getUriCachedDateCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache PageServiceImpl.getUriCachedDateCache()"})
  public void testGetUriCachedDateCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache actualUriCachedDateCache = pageServiceImpl.getUriCachedDateCache();

    // Assert
    verify(cacheManager).getCache("uriCachedDateCache");
    assertNull(actualUriCachedDateCache);
  }

  /**
   * Test {@link PageServiceImpl#copyDTOList(List)}.
   *
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link PageDTO} (default constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#copyDTOList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageServiceImpl.copyDTOList(List)"})
  public void testCopyDTOList_givenPageDTO_whenArrayListAddPageDTO_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PageDTO> dtoList = new ArrayList<>();
    dtoList.add(new PageDTO());

    // Act
    List<PageDTO> actualCopyDTOListResult = pageServiceImpl.copyDTOList(dtoList);

    // Assert
    assertEquals(1, actualCopyDTOListResult.size());
    PageDTO getResult = actualCopyDTOListResult.get(0);
    assertNull(getResult.getPriority());
    assertNull(getResult.getId());
    assertNull(getResult.getDescription());
    assertNull(getResult.getLocaleCode());
    assertNull(getResult.getRuleExpression());
    assertNull(getResult.getTemplatePath());
    assertNull(getResult.getUrl());
    assertNull(getResult.getItemCriteriaDTOList());
    assertTrue(getResult.getForeignPageFields().isEmpty());
    assertTrue(getResult.getPageAttributes().isEmpty());
    assertTrue(getResult.getPageFields().isEmpty());
  }

  /**
   * Test {@link PageServiceImpl#copyDTOList(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#copyDTOList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageServiceImpl.copyDTOList(List)"})
  public void testCopyDTOList_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(pageServiceImpl.copyDTOList(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link ArrayList#ArrayList()} addAll {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_givenArrayList_whenArrayListAddAllArrayList() {
    // Arrange
    ArrayList<RuleProcessor<PageDTO>> ruleProcessorList = new ArrayList<>();
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);
    pageDTOList.add(new PageDTO());
    pageDTOList.addAll(new ArrayList<>());
    LocaleImpl locale = new LocaleImpl();

    // Act
    PageDTO actualEvaluatePageRulesResult =
        pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    verify(list).iterator();
    assertSame(pageDTO, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_givenBroadleafCurrencyImpl() {
    // Arrange
    ArrayList<RuleProcessor<PageDTO>> ruleProcessorList = new ArrayList<>();
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("en");

    // Act
    PageDTO actualEvaluatePageRulesResult =
        pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    verify(list).iterator();
    assertSame(pageDTO, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   *
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor) LocaleCode is {@code en}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_givenPageDTOLocaleCodeIsEn() {
    // Arrange
    ArrayList<RuleProcessor<PageDTO>> ruleProcessorList = new ArrayList<>();
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());

    PageDTO pageDTO = new PageDTO();
    pageDTO.setLocaleCode("en");

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    pageDTOList.add(pageDTO);

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("en");

    // Act
    PageDTO actualEvaluatePageRulesResult =
        pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    verify(list).iterator();
    assertSame(pageDTO, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   *
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor).
   *   <li>When {@link LocaleImpl} (default constructor).
   *   <li>Then return {@link PageDTO} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_givenPageDTO_whenLocaleImpl_thenReturnPageDTO() {
    // Arrange
    ArrayList<RuleProcessor<PageDTO>> ruleProcessorList = new ArrayList<>();
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);
    LocaleImpl locale = new LocaleImpl();

    // Act
    PageDTO actualEvaluatePageRulesResult =
        pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    verify(list).iterator();
    assertSame(pageDTO, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   *
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@link PageDTO} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_givenPageDTO_whenNull_thenReturnPageDTO() {
    // Arrange
    ArrayList<RuleProcessor<PageDTO>> ruleProcessorList = new ArrayList<>();
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);

    // Act
    PageDTO actualEvaluatePageRulesResult =
        pageServiceImpl.evaluatePageRules(pageDTOList, null, new HashMap<>());

    // Assert
    verify(list).iterator();
    assertSame(pageDTO, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   *
   * <ul>
   *   <li>Given {@link PageServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@link PageDTO} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_givenPageServiceImpl_whenNull_thenReturnPageDTO() {
    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);

    // Act and Assert
    assertSame(pageDTO, pageServiceImpl.evaluatePageRules(pageDTOList, null, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleProcessor#checkForMatch(Object, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_thenCallsCheckForMatch() {
    // Arrange
    RuleProcessor<PageDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<PageDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<PageDTO>> ruleProcessorList = new ArrayList<>();
    ruleProcessorList.add(ruleProcessor);
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);

    // Act
    PageDTO actualEvaluatePageRulesResult =
        pageServiceImpl.evaluatePageRules(pageDTOList, null, new HashMap<>());

    // Assert
    verify(list).iterator();
    verify(ruleProcessor).checkForMatch(isA(PageDTO.class), isA(Map.class));
    assertSame(pageDTO, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link NullPageDTO#getLocaleCode()}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_thenCallsGetLocaleCode() {
    // Arrange
    ArrayList<RuleProcessor<PageDTO>> ruleProcessorList = new ArrayList<>();
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());

    NullPageDTO nullPageDTO = mock(NullPageDTO.class);
    when(nullPageDTO.getLocaleCode()).thenReturn("en");
    doNothing().when(nullPageDTO).setLocaleCode(Mockito.<String>any());
    nullPageDTO.setLocaleCode("en");

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    pageDTOList.add(nullPageDTO);

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("en");

    // Act
    pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    verify(list).iterator();
    verify(nullPageDTO).getLocaleCode();
    verify(nullPageDTO).setLocaleCode("en");
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link PageServiceImpl} {@link PageServiceImpl#NULL_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_whenArrayList_thenReturnPageServiceImplNull_page() {
    // Arrange
    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    LocaleImpl locale = new LocaleImpl();

    // Act
    PageDTO actualEvaluatePageRulesResult =
        pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    assertSame(pageServiceImpl.NULL_PAGE, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link PageServiceImpl} {@link PageServiceImpl#NULL_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_whenNull_thenReturnPageServiceImplNull_page() {
    // Arrange and Act
    PageDTO actualEvaluatePageRulesResult =
        pageServiceImpl.evaluatePageRules(null, null, new HashMap<>());

    // Assert
    assertSame(pageServiceImpl.NULL_PAGE, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#passesPageRules(PageDTO, Map)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#iterator()} return {@link ArrayList#ArrayList()} iterator.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageServiceImpl.passesPageRules(PageDTO, Map)"})
  public void testPassesPageRules_givenListIteratorReturnArrayListIterator_thenReturnTrue() {
    // Arrange
    ArrayList<RuleProcessor<PageDTO>> ruleProcessorList = new ArrayList<>();
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());
    PageDTO page = new PageDTO();

    // Act
    boolean actualPassesPageRulesResult = pageServiceImpl.passesPageRules(page, new HashMap<>());

    // Assert
    verify(list).iterator();
    assertTrue(actualPassesPageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#passesPageRules(PageDTO, Map)}.
   *
   * <ul>
   *   <li>Given {@link PageServiceImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageServiceImpl.passesPageRules(PageDTO, Map)"})
  public void testPassesPageRules_givenPageServiceImpl_thenReturnTrue() {
    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    PageDTO page = new PageDTO();

    // Act and Assert
    assertTrue(pageServiceImpl.passesPageRules(page, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#passesPageRules(PageDTO, Map)}.
   *
   * <ul>
   *   <li>Given {@link RuleProcessor} {@link RuleProcessor#checkForMatch(Object, Map)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageServiceImpl.passesPageRules(PageDTO, Map)"})
  public void testPassesPageRules_givenRuleProcessorCheckForMatchReturnFalse_thenReturnFalse() {
    // Arrange
    RuleProcessor<PageDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<PageDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(false);

    ArrayList<RuleProcessor<PageDTO>> ruleProcessorList = new ArrayList<>();
    ruleProcessorList.add(ruleProcessor);
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    ruleProcessorList.add(mock(RuleProcessor.class));
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());
    PageDTO page = new PageDTO();

    // Act
    boolean actualPassesPageRulesResult = pageServiceImpl.passesPageRules(page, new HashMap<>());

    // Assert
    verify(list).iterator();
    verify(ruleProcessor).checkForMatch(isA(PageDTO.class), isA(Map.class));
    assertFalse(actualPassesPageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#passesPageRules(PageDTO, Map)}.
   *
   * <ul>
   *   <li>Given {@link RuleProcessor} {@link RuleProcessor#checkForMatch(Object, Map)} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageServiceImpl.passesPageRules(PageDTO, Map)"})
  public void testPassesPageRules_givenRuleProcessorCheckForMatchReturnTrue() {
    // Arrange
    RuleProcessor<PageDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<PageDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<PageDTO>> ruleProcessorList = new ArrayList<>();
    ruleProcessorList.add(ruleProcessor);
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());
    PageDTO page = new PageDTO();

    // Act
    boolean actualPassesPageRulesResult = pageServiceImpl.passesPageRules(page, new HashMap<>());

    // Assert
    verify(list).iterator();
    verify(ruleProcessor).checkForMatch(isA(PageDTO.class), isA(Map.class));
    assertTrue(actualPassesPageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#readAllPages()}.
   *
   * <p>Method under test: {@link PageServiceImpl#readAllPages()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageServiceImpl.readAllPages()"})
  public void testReadAllPages() {
    // Arrange
    when(pageDao.readAllPages()).thenReturn(new ArrayList<>());

    // Act
    List<Page> actualReadAllPagesResult = pageServiceImpl.readAllPages();

    // Assert
    verify(pageDao).readAllPages();
    assertTrue(actualReadAllPagesResult.isEmpty());
  }

  /**
   * Test {@link PageServiceImpl#readAllPageTemplates()}.
   *
   * <p>Method under test: {@link PageServiceImpl#readAllPageTemplates()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageServiceImpl.readAllPageTemplates()"})
  public void testReadAllPageTemplates() {
    // Arrange
    when(pageDao.readAllPageTemplates()).thenReturn(new ArrayList<>());

    // Act
    List<PageTemplate> actualReadAllPageTemplatesResult = pageServiceImpl.readAllPageTemplates();

    // Assert
    verify(pageDao).readAllPageTemplates();
    assertTrue(actualReadAllPageTemplatesResult.isEmpty());
  }

  /**
   * Test {@link PageServiceImpl#removePageFromCache(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceImpl#removePageFromCache(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean PageServiceImpl.removePageFromCache(String)"})
  public void testRemovePageFromCache_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(pageServiceImpl.removePageFromCache(null));
  }
}
