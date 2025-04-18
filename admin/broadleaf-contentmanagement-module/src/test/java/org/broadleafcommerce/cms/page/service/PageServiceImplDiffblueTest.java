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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.cache.Cache;
import javax.cache.CacheManager;
import org.broadleafcommerce.cms.file.service.StaticAssetService;
import org.broadleafcommerce.cms.page.dao.PageDao;
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageField;
import org.broadleafcommerce.cms.page.domain.PageFieldImpl;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplate;
import org.broadleafcommerce.cms.page.domain.PageTemplateImpl;
import org.broadleafcommerce.common.cache.StatisticsService;
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

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PageServiceImplDiffblueTest {
  @Mock
  private CacheManager cacheManager;

  @Mock
  private List<RuleProcessor<PageDTO>> list;

  @Mock
  private LocaleService localeService;

  @Mock
  private PageDao pageDao;

  @Mock
  private PageQueryExtensionManager pageQueryExtensionManager;

  @InjectMocks
  private PageServiceImpl pageServiceImpl;

  @Mock
  private PageServiceUtility pageServiceUtility;

  @Mock
  private StaticAssetService staticAssetService;

  @Mock
  private StatisticsService statisticsService;

  /**
   * Test {@link PageServiceImpl#findPageById(Long)}.
   * <p>
   * Method under test: {@link PageServiceImpl#findPageById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Page PageServiceImpl.findPageById(Long)"})
  public void testFindPageById() {
    // Arrange
    PageImpl pageImpl = new PageImpl();
    when(pageDao.readPageById(Mockito.<Long>any())).thenReturn(pageImpl);

    // Act
    Page actualFindPageByIdResult = pageServiceImpl.findPageById(1L);

    // Assert
    verify(pageDao).readPageById(eq(1L));
    assertSame(pageImpl, actualFindPageByIdResult);
  }

  /**
   * Test {@link PageServiceImpl#findPageFieldMapByPageId(Long)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PageFieldImpl} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#findPageFieldMapByPageId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map PageServiceImpl.findPageFieldMapByPageId(Long)"})
  public void testFindPageFieldMapByPageId_givenArrayListAddPageFieldImpl_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PageField> pageFieldList = new ArrayList<>();
    PageFieldImpl pageFieldImpl = new PageFieldImpl();
    pageFieldList.add(pageFieldImpl);
    when(pageDao.readPageFieldsByPageId(Mockito.<Long>any())).thenReturn(pageFieldList);

    // Act
    Map<String, PageField> actualFindPageFieldMapByPageIdResult = pageServiceImpl.findPageFieldMapByPageId(1L);

    // Assert
    verify(pageDao).readPageFieldsByPageId(eq(1L));
    assertEquals(1, actualFindPageFieldMapByPageIdResult.size());
    assertSame(pageFieldImpl, actualFindPageFieldMapByPageIdResult.get(null));
  }

  /**
   * Test {@link PageServiceImpl#findPageFieldMapByPageId(Long)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#findPageFieldMapByPageId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map PageServiceImpl.findPageFieldMapByPageId(Long)"})
  public void testFindPageFieldMapByPageId_thenReturnEmpty() {
    // Arrange
    when(pageDao.readPageFieldsByPageId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    Map<String, PageField> actualFindPageFieldMapByPageIdResult = pageServiceImpl.findPageFieldMapByPageId(1L);

    // Assert
    verify(pageDao).readPageFieldsByPageId(eq(1L));
    assertTrue(actualFindPageFieldMapByPageIdResult.isEmpty());
  }

  /**
   * Test {@link PageServiceImpl#findPageTemplateById(Long)}.
   * <p>
   * Method under test: {@link PageServiceImpl#findPageTemplateById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageTemplate PageServiceImpl.findPageTemplateById(Long)"})
  public void testFindPageTemplateById() {
    // Arrange
    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    when(pageDao.readPageTemplateById(Mockito.<Long>any())).thenReturn(pageTemplateImpl);

    // Act
    PageTemplate actualFindPageTemplateByIdResult = pageServiceImpl.findPageTemplateById(1L);

    // Assert
    verify(pageDao).readPageTemplateById(eq(1L));
    assertSame(pageTemplateImpl, actualFindPageTemplateByIdResult);
  }

  /**
   * Test {@link PageServiceImpl#savePageTemplate(PageTemplate)}.
   * <p>
   * Method under test: {@link PageServiceImpl#savePageTemplate(PageTemplate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageTemplate PageServiceImpl.savePageTemplate(PageTemplate)"})
  public void testSavePageTemplate() {
    // Arrange
    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    when(pageDao.savePageTemplate(Mockito.<PageTemplate>any())).thenReturn(pageTemplateImpl);

    // Act
    PageTemplate actualSavePageTemplateResult = pageServiceImpl.savePageTemplate(new PageTemplateImpl());

    // Assert
    verify(pageDao).savePageTemplate(isA(PageTemplate.class));
    assertSame(pageTemplateImpl, actualSavePageTemplateResult);
  }

  /**
   * Test {@link PageServiceImpl#getPageDTOListForURI(Locale, String, boolean)}.
   * <ul>
   *   <li>Given {@link CacheManager}.</li>
   *   <li>When {@link Locale}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#getPageDTOListForURI(Locale, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageServiceImpl.getPageDTOListForURI(Locale, String, boolean)"})
  public void testGetPageDTOListForURI_givenCacheManager_whenLocale_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(pageServiceImpl.getPageDTOListForURI(mock(Locale.class), null, true));
  }

  /**
   * Test {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}.
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor).</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageServiceImpl.addPageListToPageDTOList(List, boolean, List)"})
  public void testAddPageListToPageDTOList_givenPageDTO_thenArrayListSizeIsTwo() {
    // Arrange
    PageDTO pageDTO = new PageDTO();
    when(pageServiceUtility.buildPageDTO(Mockito.<Page>any(), anyBoolean())).thenReturn(pageDTO);

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(new PageImpl());

    ArrayList<PageDTO> dtoList = new ArrayList<>();
    dtoList.add(new PageDTO());

    // Act
    pageServiceImpl.addPageListToPageDTOList(pageList, true, dtoList);

    // Assert
    verify(pageServiceUtility).buildPageDTO(isA(Page.class), eq(true));
    assertEquals(2, dtoList.size());
    assertSame(pageDTO, dtoList.get(1));
  }

  /**
   * Test {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageServiceImpl.addPageListToPageDTOList(List, boolean, List)"})
  public void testAddPageListToPageDTOList_thenArrayListSizeIsOne() {
    // Arrange
    PageDTO pageDTO = new PageDTO();
    when(pageServiceUtility.buildPageDTO(Mockito.<Page>any(), anyBoolean())).thenReturn(pageDTO);

    ArrayList<Page> pageList = new ArrayList<>();
    pageList.add(new PageImpl());
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
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageServiceImpl.addPageListToPageDTOList(List, boolean, List)"})
  public void testAddPageListToPageDTOList_thenArrayListSizeIsOne2() {
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link PageServiceImpl#getPageListFromCache(String)}.
   * <ul>
   *   <li>Given {@link CacheManager}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#getPageListFromCache(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageServiceImpl.getPageListFromCache(String)"})
  public void testGetPageListFromCache_givenCacheManager_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(pageServiceImpl.getPageListFromCache(null));
  }

  /**
   * Test {@link PageServiceImpl#getPageMapCacheKey(String, Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Uri-ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#getPageMapCacheKey(String, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.getPageMapCacheKey(String, Long)"})
  public void testGetPageMapCacheKey_whenNull_thenReturnUriAll() {
    // Arrange, Act and Assert
    assertEquals("Uri-ALL", pageServiceImpl.getPageMapCacheKey("Uri", null));
  }

  /**
   * Test {@link PageServiceImpl#getPageMapCacheKey(String, Long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code Uri-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#getPageMapCacheKey(String, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.getPageMapCacheKey(String, Long)"})
  public void testGetPageMapCacheKey_whenOne_thenReturnUri1() {
    // Arrange, Act and Assert
    assertEquals("Uri-1", pageServiceImpl.getPageMapCacheKey("Uri", 1L));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)} with {@code identifier}, {@code localeCode}, {@code secure}, {@code resultType}.
   * <ul>
   *   <li>Given {@link PageServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, String, Boolean, ResultType)"})
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_givenPageServiceImpl() {
    // Arrange, Act and Assert
    assertEquals("42-en-true", (new PageServiceImpl()).buildKey("42", "en", true, ResultType.STANDARD));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)} with {@code identifier}, {@code localeCode}, {@code secure}, {@code resultType}.
   * <ul>
   *   <li>Then return {@code 42-en-true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, String, Boolean, ResultType)"})
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_thenReturn42EnTrue() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(Mockito.<String>any(), Mockito.<ResultType>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", "en", true, ResultType.STANDARD);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKey(eq("42-en-true"), eq(ResultType.STANDARD),
        isA(ExtensionResultHolder.class));
    assertEquals("42-en-true", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)} with {@code identifier}, {@code localeCode}, {@code secure}, {@code resultType}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code 42-en}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, String, Boolean, ResultType)"})
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_whenNull_thenReturn42En() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(Mockito.<String>any(), Mockito.<ResultType>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", "en", null, ResultType.STANDARD);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKey(eq("42-en"), eq(ResultType.STANDARD),
        isA(ExtensionResultHolder.class));
    assertEquals("42-en", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)} with {@code identifier}, {@code localeCode}, {@code secure}, {@code resultType}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code 42-en-true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, String, Boolean, ResultType)"})
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_whenNull_thenReturn42EnTrue() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(Mockito.<String>any(), Mockito.<ResultType>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", "en", true, null);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKey(eq("42-en-true"), eq(ResultType.STANDARD),
        isA(ExtensionResultHolder.class));
    assertEquals("42-en-true", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)} with {@code identifier}, {@code localeCode}, {@code secure}, {@code resultType}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code 42-true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, String, Boolean, ResultType)"})
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_whenNull_thenReturn42True() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(Mockito.<String>any(), Mockito.<ResultType>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", null, true, ResultType.STANDARD);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKey(eq("42-true"), eq(ResultType.STANDARD),
        isA(ExtensionResultHolder.class));
    assertEquals("42-true", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with {@code identifier}, {@code locale}, {@code secure}.
   * <ul>
   *   <li>Given {@code en}.</li>
   *   <li>Then return {@code 42-en}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, Locale, Boolean)"})
  public void testBuildKeyWithIdentifierLocaleSecure_givenEn_thenReturn42En() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(Mockito.<String>any(), Mockito.<ResultType>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", locale, null);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKey(eq("42-en"), eq(ResultType.STANDARD),
        isA(ExtensionResultHolder.class));
    verify(locale).getLocaleCode();
    assertEquals("42-en", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with {@code identifier}, {@code locale}, {@code secure}.
   * <ul>
   *   <li>Given {@code en}.</li>
   *   <li>Then return {@code 42-en-true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, Locale, Boolean)"})
  public void testBuildKeyWithIdentifierLocaleSecure_givenEn_thenReturn42EnTrue() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(Mockito.<String>any(), Mockito.<ResultType>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", locale, true);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKey(eq("42-en-true"), eq(ResultType.STANDARD),
        isA(ExtensionResultHolder.class));
    verify(locale).getLocaleCode();
    assertEquals("42-en-true", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with {@code identifier}, {@code locale}, {@code secure}.
   * <ul>
   *   <li>Given {@link PageServiceImpl} (default constructor).</li>
   *   <li>Then return {@code 42-true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, Locale, Boolean)"})
  public void testBuildKeyWithIdentifierLocaleSecure_givenPageServiceImpl_thenReturn42True() {
    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    // Act and Assert
    assertEquals("42-true", pageServiceImpl.buildKey("42", new LocaleImpl(), true));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with {@code identifier}, {@code locale}, {@code secure}.
   * <ul>
   *   <li>Given {@link PageServiceImpl} (default constructor).</li>
   *   <li>Then return {@code 42--true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, Locale, Boolean)"})
  public void testBuildKeyWithIdentifierLocaleSecure_givenPageServiceImpl_thenReturn42True2() {
    // Arrange, Act and Assert
    assertEquals("42--true", (new PageServiceImpl()).buildKey("42", null, true));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with {@code identifier}, {@code locale}, {@code secure}.
   * <ul>
   *   <li>When {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@code 42-true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.buildKey(String, Locale, Boolean)"})
  public void testBuildKeyWithIdentifierLocaleSecure_whenLocaleImpl_thenReturn42True() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(Mockito.<String>any(), Mockito.<ResultType>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageQueryExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", new LocaleImpl(), true);

    // Assert
    verify(pageQueryExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKey(eq("42-true"), eq(ResultType.STANDARD),
        isA(ExtensionResultHolder.class));
    assertEquals("42-true", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.buildBaseKey(String, String, Boolean)"})
  public void testBuildBaseKey_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", pageServiceImpl.buildBaseKey("42", null, null));
  }

  /**
   * Test {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42-en-true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageServiceImpl.buildBaseKey(String, String, Boolean)"})
  public void testBuildBaseKey_when42_thenReturn42EnTrue() {
    // Arrange, Act and Assert
    assertEquals("42-en-true", pageServiceImpl.buildBaseKey("42", "en", true));
  }

  /**
   * Test {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}.
   * <ul>
   *   <li>Given {@code en}.</li>
   *   <li>Then calls {@link LocaleImpl#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale PageServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_givenEn_thenCallsGetLocaleCode() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);
    LocaleImpl locale = mock(LocaleImpl.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    Locale actualFindLanguageOnlyLocaleResult = pageServiceImpl.findLanguageOnlyLocale(locale);

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findLocaleByCode(isNull());
    assertSame(localeImpl, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}.
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale PageServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_givenLocaleServiceFindLocaleByCodeReturnLocaleImpl() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    // Act
    Locale actualFindLanguageOnlyLocaleResult = pageServiceImpl.findLanguageOnlyLocale(new LocaleImpl());

    // Assert
    verify(localeService).findLocaleByCode(isNull());
    assertSame(localeImpl, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}.
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale PageServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_givenLocaleServiceFindLocaleByCodeReturnNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(null);
    LocaleImpl locale = new LocaleImpl();

    // Act
    Locale actualFindLanguageOnlyLocaleResult = pageServiceImpl.findLanguageOnlyLocale(locale);

    // Assert
    verify(localeService).findLocaleByCode(isNull());
    assertSame(locale, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}.
   * <ul>
   *   <li>Given {@link LocaleService}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale PageServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_givenLocaleService_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(pageServiceImpl.findLanguageOnlyLocale(null));
  }

  /**
   * Test {@link PageServiceImpl#getPageCache()}.
   * <p>
   * Method under test: {@link PageServiceImpl#getPageCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Cache PageServiceImpl.getPageCache()"})
  public void testGetPageCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache actualPageCache = pageServiceImpl.getPageCache();

    // Assert
    verify(cacheManager).getCache(eq("cmsPageCache"));
    assertNull(actualPageCache);
  }

  /**
   * Test {@link PageServiceImpl#getPageMapCache()}.
   * <p>
   * Method under test: {@link PageServiceImpl#getPageMapCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Cache PageServiceImpl.getPageMapCache()"})
  public void testGetPageMapCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache actualPageMapCache = pageServiceImpl.getPageMapCache();

    // Assert
    verify(cacheManager).getCache(eq("cmsPageMapCache"));
    assertNull(actualPageMapCache);
  }

  /**
   * Test {@link PageServiceImpl#getUriCachedDateCache()}.
   * <p>
   * Method under test: {@link PageServiceImpl#getUriCachedDateCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Cache PageServiceImpl.getUriCachedDateCache()"})
  public void testGetUriCachedDateCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache actualUriCachedDateCache = pageServiceImpl.getUriCachedDateCache();

    // Assert
    verify(cacheManager).getCache(eq("uriCachedDateCache"));
    assertNull(actualUriCachedDateCache);
  }

  /**
   * Test {@link PageServiceImpl#copyDTOList(List)}.
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link PageDTO} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#copyDTOList(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#copyDTOList(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageServiceImpl.copyDTOList(List)"})
  public void testCopyDTOList_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(pageServiceImpl.copyDTOList(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Given {@code en}.</li>
   *   <li>Then calls {@link Locale#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_givenEn_thenCallsGetLocaleCode() {
    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    PageDTO actualEvaluatePageRulesResult = pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    assertSame(pageDTO, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Given {@link List} {@link List#iterator()} return {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link List#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_givenListIteratorReturnArrayListIterator_thenCallsIterator() {
    // Arrange
    ArrayList<RuleProcessor<PageDTO>> ruleProcessorList = new ArrayList<>();
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);
    LocaleImpl locale = new LocaleImpl();

    // Act
    PageDTO actualEvaluatePageRulesResult = pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    verify(list).iterator();
    assertSame(pageDTO, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Given {@link List}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link PageServiceImpl} {@link PageServiceImpl#NULL_PAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_givenList_whenArrayList_thenReturnPageServiceImplNull_page() {
    // Arrange
    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    LocaleImpl locale = new LocaleImpl();

    // Act and Assert
    assertSame(pageServiceImpl.NULL_PAGE, pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor) LocaleCode is {@code en}.</li>
   *   <li>Then calls {@link Locale#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_givenPageDTOLocaleCodeIsEn_thenCallsGetLocaleCode() {
    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    PageDTO pageDTO = new PageDTO();
    pageDTO.setLocaleCode("en");

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    pageDTOList.add(pageDTO);
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    PageDTO actualEvaluatePageRulesResult = pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    assertSame(pageDTO, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Given {@link PageServiceImpl} (default constructor).</li>
   *   <li>When {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@link PageDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_givenPageServiceImpl_whenLocaleImpl_thenReturnPageDTO() {
    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);
    LocaleImpl locale = new LocaleImpl();

    // Act and Assert
    assertSame(pageDTO, pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Given {@link PageServiceImpl} (default constructor).</li>
   *   <li>When {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@link PageDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_givenPageServiceImpl_whenLocaleImpl_thenReturnPageDTO2() {
    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);
    pageDTOList.add(new PageDTO());
    LocaleImpl locale = new LocaleImpl();

    // Act and Assert
    assertSame(pageDTO, pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Then calls {@link RuleProcessor#checkForMatch(Object, Map)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_thenCallsCheckForMatch() {
    // Arrange
    RuleProcessor<PageDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<PageDTO>any(), Mockito.<Map<String, Object>>any())).thenReturn(true);

    ArrayList<RuleProcessor<PageDTO>> ruleProcessorList = new ArrayList<>();
    ruleProcessorList.add(ruleProcessor);
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);
    LocaleImpl locale = new LocaleImpl();

    // Act
    PageDTO actualEvaluatePageRulesResult = pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    verify(list).iterator();
    verify(ruleProcessor).checkForMatch(isA(PageDTO.class), isA(Map.class));
    assertSame(pageDTO, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Then calls {@link PageDTO#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageDTO PageServiceImpl.evaluatePageRules(List, Locale, Map)"})
  public void testEvaluatePageRules_thenCallsGetLocaleCode() {
    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    NullPageDTO nullPageDTO = mock(NullPageDTO.class);
    when(nullPageDTO.getLocaleCode()).thenReturn("en");

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    pageDTOList.add(nullPageDTO);
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(nullPageDTO).getLocaleCode();
  }

  /**
   * Test {@link PageServiceImpl#passesPageRules(PageDTO, Map)}.
   * <ul>
   *   <li>Given {@link CacheManager}.</li>
   *   <li>Then calls {@link List#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageServiceImpl.passesPageRules(PageDTO, Map)"})
  public void testPassesPageRules_givenCacheManager_thenCallsIterator() {
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
   * <ul>
   *   <li>Given {@link PageServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageServiceImpl.passesPageRules(PageDTO, Map)"})
  public void testPassesPageRules_givenPageServiceImpl() {
    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    PageDTO page = new PageDTO();

    // Act and Assert
    assertTrue(pageServiceImpl.passesPageRules(page, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#passesPageRules(PageDTO, Map)}.
   * <ul>
   *   <li>Then calls {@link RuleProcessor#checkForMatch(Object, Map)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageServiceImpl.passesPageRules(PageDTO, Map)"})
  public void testPassesPageRules_thenCallsCheckForMatch() {
    // Arrange
    RuleProcessor<PageDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<PageDTO>any(), Mockito.<Map<String, Object>>any())).thenReturn(true);

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
   * <p>
   * Method under test: {@link PageServiceImpl#readAllPages()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link PageServiceImpl#readAllPageTemplates()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link CacheManager}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#removePageFromCache(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean PageServiceImpl.removePageFromCache(String)"})
  public void testRemovePageFromCache_givenCacheManager_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(pageServiceImpl.removePageFromCache(null));
  }
}
