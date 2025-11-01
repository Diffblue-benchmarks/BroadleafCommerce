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
   * Method under test:
   * {@link PageServiceImpl#getPageDTOListForURI(Locale, String, boolean)}
   */
  @Test
  public void testGetPageDTOListForURI() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageServiceImpl()).getPageDTOListForURI(mock(LocaleImpl.class), null, true));
  }

  /**
   * Method under test: {@link PageServiceImpl#getPageListFromCache(String)}
   */
  @Test
  public void testGetPageListFromCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageServiceImpl()).getPageListFromCache(null));
  }

  /**
   * Method under test: {@link PageServiceImpl#getPageMapCacheKey(String, Long)}
   */
  @Test
  public void testGetPageMapCacheKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Uri-1", (new PageServiceImpl()).getPageMapCacheKey("Uri", 1L));
    assertEquals("Uri-ALL", (new PageServiceImpl()).getPageMapCacheKey("Uri", null));
  }

  /**
   * Method under test:
   * {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  public void testBuildKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42-en-true", (new PageServiceImpl()).buildKey("42", "en", true, ResultType.STANDARD));
    assertEquals("42-true", (new PageServiceImpl()).buildKey("42", null, true, ResultType.STANDARD));
    assertEquals("42-en", (new PageServiceImpl()).buildKey("42", "en", null, ResultType.STANDARD));
    assertEquals("42-en-true", (new PageServiceImpl()).buildKey("42", "en", true, null));
    assertEquals("42--true", (new PageServiceImpl()).buildKey("42", null, true));
  }

  /**
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  public void testBuildKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    // Act and Assert
    assertEquals("42-true", pageServiceImpl.buildKey("42", new LocaleImpl(), true));
  }

  /**
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  public void testBuildKey3() {
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
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  public void testBuildKey4() {
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
   * Method under test:
   * {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}
   */
  @Test
  public void testBuildBaseKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42-en-true", (new PageServiceImpl()).buildBaseKey("42", "en", true));
    assertEquals("42", (new PageServiceImpl()).buildBaseKey("42", null, null));
  }

  /**
   * Method under test: {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  public void testFindLanguageOnlyLocale() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageServiceImpl()).findLanguageOnlyLocale(null));
  }

  /**
   * Method under test: {@link PageServiceImpl#copyDTOList(List)}
   */
  @Test
  public void testCopyDTOList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    // Act and Assert
    assertTrue(pageServiceImpl.copyDTOList(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test: {@link PageServiceImpl#copyDTOList(List)}
   */
  @Test
  public void testCopyDTOList2() {
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
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    LocaleImpl locale = new LocaleImpl();

    // Act and Assert
    assertSame(pageServiceImpl.NULL_PAGE, pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules2() {
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
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules3() {
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
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    LocaleImpl locale = mock(LocaleImpl.class);

    // Act and Assert
    assertSame(pageServiceImpl.NULL_PAGE, pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules5() {
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
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules6() {
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
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules7() {
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
   * Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  public void testPassesPageRules() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    PageDTO page = new PageDTO();

    // Act and Assert
    assertTrue(pageServiceImpl.passesPageRules(page, new HashMap<>()));
  }

  /**
   * Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  public void testPassesPageRules2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    NullPageDTO page = mock(NullPageDTO.class);

    // Act and Assert
    assertTrue(pageServiceImpl.passesPageRules(page, new HashMap<>()));
  }

  /**
   * Method under test: {@link PageServiceImpl#removePageFromCache(String)}
   */
  @Test
  public void testRemovePageFromCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PageServiceImpl()).removePageFromCache(null));
  }
}
