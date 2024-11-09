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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.extension.ResultType;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.junit.Test;

public class PageServiceImplDiffblueTest {
  /**
   * Test {@link PageServiceImpl#getPageDTOListForURI(Locale, String, boolean)}.
   * <ul>
   *   <li>When {@link LocaleImpl}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#getPageDTOListForURI(Locale, String, boolean)}
   */
  @Test
  public void testGetPageDTOListForURI_whenLocaleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageServiceImpl()).getPageDTOListForURI(mock(LocaleImpl.class), null, true));
  }

  /**
   * Test {@link PageServiceImpl#getPageListFromCache(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#getPageListFromCache(String)}
   */
  @Test
  public void testGetPageListFromCache_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageServiceImpl()).getPageListFromCache(null));
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
  public void testGetPageMapCacheKey_whenNull_thenReturnUriAll() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Uri-ALL", (new PageServiceImpl()).getPageMapCacheKey("Uri", null));
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
  public void testGetPageMapCacheKey_whenOne_thenReturnUri1() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Uri-1", (new PageServiceImpl()).getPageMapCacheKey("Uri", 1L));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   * with {@code identifier}, {@code localeCode}, {@code secure},
   * {@code resultType}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42-en}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_when42_thenReturn42En() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42-en", (new PageServiceImpl()).buildKey("42", "en", null, ResultType.STANDARD));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   * with {@code identifier}, {@code localeCode}, {@code secure},
   * {@code resultType}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42-en-true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_when42_thenReturn42EnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42-en-true", (new PageServiceImpl()).buildKey("42", "en", true, ResultType.STANDARD));
    assertEquals("42-en-true", (new PageServiceImpl()).buildKey("42", "en", true, null));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   * with {@code identifier}, {@code localeCode}, {@code secure},
   * {@code resultType}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42-true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_when42_thenReturn42True() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42-true", (new PageServiceImpl()).buildKey("42", null, true, ResultType.STANDARD));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with
   * {@code identifier}, {@code locale}, {@code secure}.
   * <ul>
   *   <li>Given {@code en}.</li>
   *   <li>Then return {@code 42-en}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleSecure_givenEn_thenReturn42En() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    LocaleImpl locale = mock(LocaleImpl.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", locale, null);

    // Assert
    verify(locale).getLocaleCode();
    assertEquals("42-en", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with
   * {@code identifier}, {@code locale}, {@code secure}.
   * <ul>
   *   <li>Given {@code en}.</li>
   *   <li>Then return {@code 42-en-true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleSecure_givenEn_thenReturn42EnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    LocaleImpl locale = mock(LocaleImpl.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", locale, true);

    // Assert
    verify(locale).getLocaleCode();
    assertEquals("42-en-true", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with
   * {@code identifier}, {@code locale}, {@code secure}.
   * <ul>
   *   <li>When {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@code 42-true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleSecure_whenLocaleImpl_thenReturn42True() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    // Act and Assert
    assertEquals("42-true", pageServiceImpl.buildKey("42", new LocaleImpl(), true));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with
   * {@code identifier}, {@code locale}, {@code secure}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code 42--true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleSecure_whenNull_thenReturn42True() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42--true", (new PageServiceImpl()).buildKey("42", null, true));
  }

  /**
   * Test {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}
   */
  @Test
  public void testBuildBaseKey_when42_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42", (new PageServiceImpl()).buildBaseKey("42", null, null));
  }

  /**
   * Test {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42-en-true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}
   */
  @Test
  public void testBuildBaseKey_when42_thenReturn42EnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42-en-true", (new PageServiceImpl()).buildBaseKey("42", "en", true));
  }

  /**
   * Test {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  public void testFindLanguageOnlyLocale_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageServiceImpl()).findLanguageOnlyLocale(null));
  }

  /**
   * Test {@link PageServiceImpl#copyDTOList(List)}.
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link PageDTO} (default
   * constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#copyDTOList(List)}
   */
  @Test
  public void testCopyDTOList_givenPageDTO_whenArrayListAddPageDTO_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

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
  public void testCopyDTOList_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    // Act and Assert
    assertTrue(pageServiceImpl.copyDTOList(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor) LocaleCode is
   * {@code en}.</li>
   *   <li>Then calls {@link Locale#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_givenPageDTOLocaleCodeIsEn_thenCallsGetLocaleCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Given {@link PageDTO} (default constructor).</li>
   *   <li>Then calls {@link Locale#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_givenPageDTO_thenCallsGetLocaleCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Given {@link PageDTO} (default constructor).</li>
   *   <li>When {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@link PageDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_givenPageDTO_whenLocaleImpl_thenReturnPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Given {@link PageDTO} (default constructor).</li>
   *   <li>When {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@link PageDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_givenPageDTO_whenLocaleImpl_thenReturnPageDTO2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Then calls {@link PageDTO#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_thenCallsGetLocaleCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link PageServiceImpl} (default constructor)
   * {@link PageServiceImpl#NULL_PAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_whenArrayList_thenReturnPageServiceImplNull_page() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    LocaleImpl locale = new LocaleImpl();

    // Act and Assert
    assertSame(pageServiceImpl.NULL_PAGE, pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>When {@link LocaleImpl}.</li>
   *   <li>Then return {@link PageServiceImpl} (default constructor)
   * {@link PageServiceImpl#NULL_PAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_whenLocaleImpl_thenReturnPageServiceImplNull_page() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    LocaleImpl locale = mock(LocaleImpl.class);

    // Act and Assert
    assertSame(pageServiceImpl.NULL_PAGE, pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#passesPageRules(PageDTO, Map)}.
   * <ul>
   *   <li>When {@link NullPageDTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  public void testPassesPageRules_whenNullPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    NullPageDTO page = mock(NullPageDTO.class);

    // Act and Assert
    assertTrue(pageServiceImpl.passesPageRules(page, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#passesPageRules(PageDTO, Map)}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  public void testPassesPageRules_whenPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    PageDTO page = new PageDTO();

    // Act and Assert
    assertTrue(pageServiceImpl.passesPageRules(page, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#removePageFromCache(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#removePageFromCache(String)}
   */
  @Test
  public void testRemovePageFromCache_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PageServiceImpl()).removePageFromCache(null));
  }
}
