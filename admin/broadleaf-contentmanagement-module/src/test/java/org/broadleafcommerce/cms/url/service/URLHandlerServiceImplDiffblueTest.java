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
package org.broadleafcommerce.cms.url.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.cache.Cache;
import javax.cache.CacheManager;
import org.broadleafcommerce.cms.url.dao.URLHandlerDao;
import org.broadleafcommerce.cms.url.domain.NullURLHandler;
import org.broadleafcommerce.cms.url.domain.URLHandler;
import org.broadleafcommerce.cms.url.domain.URLHandlerDTO;
import org.broadleafcommerce.cms.url.domain.URLHandlerImpl;
import org.broadleafcommerce.cms.url.type.URLRedirectType;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
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
public class URLHandlerServiceImplDiffblueTest {
  @InjectMocks
  private URLHandlerServiceImpl uRLHandlerServiceImpl;

  @Mock
  private URLHandlerDao uRLHandlerDao;

  @Mock
  private CacheManager cacheManager;

  /**
   * Test {@link URLHandlerServiceImpl#findURLHandlerByURI(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#findURLHandlerByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.findURLHandlerByURI(String)"})
  public void testFindURLHandlerByURI_thenThrowRuntimeException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> uRLHandlerServiceImpl.findURLHandlerByURI("https://example.org/example"));
    verify(cacheManager).getCache(eq("cmsUrlHandlerCache"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#findURLHandlerByURI(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#findURLHandlerByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.findURLHandlerByURI(String)"})
  public void testFindURLHandlerByURI_whenNull_thenThrowRuntimeException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> uRLHandlerServiceImpl.findURLHandlerByURI(null));
    verify(cacheManager).getCache(eq("cmsUrlHandlerCache"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#findURLHandlerById(Long)}.
   * <ul>
   *   <li>Then return {@link URLHandlerServiceImpl} {@link URLHandlerServiceImpl#NULL_URL_HANDLER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#findURLHandlerById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.findURLHandlerById(Long)"})
  public void testFindURLHandlerById_thenReturnURLHandlerServiceImplNull_url_handler() {
    // Arrange
    when(uRLHandlerDao.findURLHandlerById(Mockito.<Long>any())).thenReturn(URLHandlerServiceImpl.NULL_URL_HANDLER);

    // Act
    URLHandler actualFindURLHandlerByIdResult = uRLHandlerServiceImpl.findURLHandlerById(1L);

    // Assert
    verify(uRLHandlerDao).findURLHandlerById(eq(1L));
    assertSame(uRLHandlerServiceImpl.NULL_URL_HANDLER, actualFindURLHandlerByIdResult);
  }

  /**
   * Test {@link URLHandlerServiceImpl#findURLHandlerById(Long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#findURLHandlerById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.findURLHandlerById(Long)"})
  public void testFindURLHandlerById_thenThrowRuntimeException() {
    // Arrange
    when(uRLHandlerDao.findURLHandlerById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> uRLHandlerServiceImpl.findURLHandlerById(1L));
    verify(uRLHandlerDao).findURLHandlerById(eq(1L));
  }

  /**
   * Test {@link URLHandlerServiceImpl#findAllURLHandlers()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#findAllURLHandlers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List URLHandlerServiceImpl.findAllURLHandlers()"})
  public void testFindAllURLHandlers_thenReturnEmpty() {
    // Arrange
    when(uRLHandlerDao.findAllURLHandlers()).thenReturn(new ArrayList<>());

    // Act
    List<URLHandler> actualFindAllURLHandlersResult = uRLHandlerServiceImpl.findAllURLHandlers();

    // Assert
    verify(uRLHandlerDao).findAllURLHandlers();
    assertTrue(actualFindAllURLHandlersResult.isEmpty());
  }

  /**
   * Test {@link URLHandlerServiceImpl#findAllURLHandlers()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#findAllURLHandlers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List URLHandlerServiceImpl.findAllURLHandlers()"})
  public void testFindAllURLHandlers_thenThrowRuntimeException() {
    // Arrange
    when(uRLHandlerDao.findAllURLHandlers()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> uRLHandlerServiceImpl.findAllURLHandlers());
    verify(uRLHandlerDao).findAllURLHandlers();
  }

  /**
   * Test {@link URLHandlerServiceImpl#findAllRegexURLHandlers()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#findAllRegexURLHandlers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List URLHandlerServiceImpl.findAllRegexURLHandlers()"})
  public void testFindAllRegexURLHandlers_thenReturnEmpty() {
    // Arrange
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(new ArrayList<>());

    // Act
    List<URLHandler> actualFindAllRegexURLHandlersResult = uRLHandlerServiceImpl.findAllRegexURLHandlers();

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    assertTrue(actualFindAllRegexURLHandlersResult.isEmpty());
  }

  /**
   * Test {@link URLHandlerServiceImpl#findAllRegexURLHandlers()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#findAllRegexURLHandlers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List URLHandlerServiceImpl.findAllRegexURLHandlers()"})
  public void testFindAllRegexURLHandlers_thenThrowRuntimeException() {
    // Arrange
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> uRLHandlerServiceImpl.findAllRegexURLHandlers());
    verify(uRLHandlerDao).findAllRegexURLHandlers();
  }

  /**
   * Test {@link URLHandlerServiceImpl#saveURLHandler(URLHandler)}.
   * <ul>
   *   <li>Then return {@link URLHandlerServiceImpl#NULL_URL_HANDLER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#saveURLHandler(URLHandler)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.saveURLHandler(URLHandler)"})
  public void testSaveURLHandler_thenReturnNull_url_handler() {
    // Arrange
    when(uRLHandlerDao.saveURLHandler(Mockito.<URLHandler>any())).thenReturn(URLHandlerServiceImpl.NULL_URL_HANDLER);
    NullURLHandler handler = URLHandlerServiceImpl.NULL_URL_HANDLER;

    // Act
    URLHandler actualSaveURLHandlerResult = uRLHandlerServiceImpl.saveURLHandler(handler);

    // Assert
    verify(uRLHandlerDao).saveURLHandler(isA(URLHandler.class));
    assertSame(handler, actualSaveURLHandlerResult);
  }

  /**
   * Test {@link URLHandlerServiceImpl#saveURLHandler(URLHandler)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#saveURLHandler(URLHandler)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.saveURLHandler(URLHandler)"})
  public void testSaveURLHandler_thenThrowRuntimeException() {
    // Arrange
    when(uRLHandlerDao.saveURLHandler(Mockito.<URLHandler>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> uRLHandlerServiceImpl.saveURLHandler(URLHandlerServiceImpl.NULL_URL_HANDLER));
    verify(uRLHandlerDao).saveURLHandler(isA(URLHandler.class));
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches() {
    // Arrange
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenThrow(new RuntimeException("foo"));

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("https://example.org/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    assertNull(actualCheckForMatchesResult);
    assertTrue(uRLHandlerServiceImpl.urlPatternMap.isEmpty());
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches2() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    ArrayList<URLHandler> urlHandlerList = new ArrayList<>();
    urlHandlerList.add(urlHandlerImpl);
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(urlHandlerList);

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("https://example.org/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    Map<String, Pattern> stringPatternMap = uRLHandlerServiceImpl.urlPatternMap;
    assertEquals(1, stringPatternMap.size());
    assertEquals("^/https://example.org/example$", stringPatternMap.get("^/https://example.org/example$").pattern());
    assertNull(actualCheckForMatchesResult);
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches3() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL(" ");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    ArrayList<URLHandler> urlHandlerList = new ArrayList<>();
    urlHandlerList.add(urlHandlerImpl);
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(urlHandlerList);

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("https://example.org/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    Map<String, Pattern> stringPatternMap = uRLHandlerServiceImpl.urlPatternMap;
    assertEquals(1, stringPatternMap.size());
    assertEquals("^ $", stringPatternMap.get("^ $").pattern());
    assertNull(actualCheckForMatchesResult);
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches4() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("/https://exampleUorg/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    ArrayList<URLHandler> urlHandlerList = new ArrayList<>();
    urlHandlerList.add(urlHandlerImpl);
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(urlHandlerList);

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("https://example.org/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    Map<String, Pattern> stringPatternMap = uRLHandlerServiceImpl.urlPatternMap;
    assertEquals(1, stringPatternMap.size());
    assertEquals("^/https://exampleUorg/example$", stringPatternMap.get("^/https://exampleUorg/example$").pattern());
    assertNull(actualCheckForMatchesResult);
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches5() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("^");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    ArrayList<URLHandler> urlHandlerList = new ArrayList<>();
    urlHandlerList.add(urlHandlerImpl);
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(urlHandlerList);

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("https://example.org/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    Map<String, Pattern> stringPatternMap = uRLHandlerServiceImpl.urlPatternMap;
    assertEquals(1, stringPatternMap.size());
    assertEquals("^$", stringPatternMap.get("^$").pattern());
    assertNull(actualCheckForMatchesResult);
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches6() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("([\\[\\]\\.\\|\\?\\*\\+\\(\\)\\\\~`\\!@#%&\\-_+={}'\"\"<>:;, \\/])");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    ArrayList<URLHandler> urlHandlerList = new ArrayList<>();
    urlHandlerList.add(urlHandlerImpl);
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(urlHandlerList);

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("https://example.org/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    Map<String, Pattern> stringPatternMap = uRLHandlerServiceImpl.urlPatternMap;
    assertEquals(1, stringPatternMap.size());
    assertEquals("^([\\[\\]\\.\\|\\?\\*\\+\\(\\)\\\\~`\\!@#%&\\-_+={}'\"\"<>:;, \\/])$",
        stringPatternMap.get("^([\\[\\]\\.\\|\\?\\*\\+\\(\\)\\\\~`\\!@#%&\\-_+={}'\"\"<>:;, \\/])$").pattern());
    assertNull(actualCheckForMatchesResult);
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches7() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("$");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    ArrayList<URLHandler> urlHandlerList = new ArrayList<>();
    urlHandlerList.add(urlHandlerImpl);
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(urlHandlerList);

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("https://example.org/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    Map<String, Pattern> stringPatternMap = uRLHandlerServiceImpl.urlPatternMap;
    assertEquals(1, stringPatternMap.size());
    assertEquals("^/$", stringPatternMap.get("^/$").pattern());
    assertNull(actualCheckForMatchesResult);
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches_givenArrayListAddNull() {
    // Arrange
    ArrayList<URLHandler> urlHandlerList = new ArrayList<>();
    urlHandlerList.add(null);
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(urlHandlerList);

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("https://example.org/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    assertNull(actualCheckForMatchesResult);
    assertTrue(uRLHandlerServiceImpl.urlPatternMap.isEmpty());
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link URLHandlerServiceImpl#NULL_URL_HANDLER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches_givenArrayListAddNull_url_handler() {
    // Arrange
    ArrayList<URLHandler> urlHandlerList = new ArrayList<>();
    urlHandlerList.add(URLHandlerServiceImpl.NULL_URL_HANDLER);
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(urlHandlerList);

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("https://example.org/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    assertNull(actualCheckForMatchesResult);
    assertTrue(uRLHandlerServiceImpl.urlPatternMap.isEmpty());
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) IncomingURL is {@code (}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches_givenURLHandlerImplIncomingURLIsLeftParenthesis() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("(");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    ArrayList<URLHandler> urlHandlerList = new ArrayList<>();
    urlHandlerList.add(urlHandlerImpl);
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(urlHandlerList);

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("https://example.org/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    assertNull(actualCheckForMatchesResult);
    assertTrue(uRLHandlerServiceImpl.urlPatternMap.isEmpty());
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) IncomingURL is {@code )}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches_givenURLHandlerImplIncomingURLIsRightParenthesis() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL(")");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    ArrayList<URLHandler> urlHandlerList = new ArrayList<>();
    urlHandlerList.add(urlHandlerImpl);
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(urlHandlerList);

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("https://example.org/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    assertNull(actualCheckForMatchesResult);
    assertTrue(uRLHandlerServiceImpl.urlPatternMap.isEmpty());
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <ul>
   *   <li>Then return {@link URLHandlerDTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches_thenReturnURLHandlerDTO() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("*");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    ArrayList<URLHandler> urlHandlerList = new ArrayList<>();
    urlHandlerList.add(urlHandlerImpl);
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(urlHandlerList);

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("https://example.org/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    assertTrue(actualCheckForMatchesResult instanceof URLHandlerDTO);
    assertEquals("", actualCheckForMatchesResult.getIncomingURL());
    URLRedirectType urlRedirectType = actualCheckForMatchesResult.getUrlRedirectType();
    assertEquals("FORWARD", urlRedirectType.getType());
    assertEquals("Forward URI", urlRedirectType.getFriendlyType());
    Map<String, Pattern> stringPatternMap = uRLHandlerServiceImpl.urlPatternMap;
    assertEquals(1, stringPatternMap.size());
    assertEquals("^*$", stringPatternMap.get("^*$").pattern());
    assertEquals("https://example.org/examplehttps://example.org/example", actualCheckForMatchesResult.getNewURL());
    assertNull(actualCheckForMatchesResult.getId());
    assertFalse(actualCheckForMatchesResult.isRegexHandler());
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <ul>
   *   <li>Then {@link URLHandlerServiceImpl} {@link URLHandlerServiceImpl#urlPatternMap} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches_thenURLHandlerServiceImplUrlPatternMapEmpty() {
    // Arrange
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(new ArrayList<>());

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("https://example.org/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    assertNull(actualCheckForMatchesResult);
    assertTrue(uRLHandlerServiceImpl.urlPatternMap.isEmpty());
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <ul>
   *   <li>When {@code /https://exampleUorg/example}.</li>
   *   <li>Then return {@link URLHandlerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches_whenHttpsExampleUorgExample_thenReturnURLHandlerImpl() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    ArrayList<URLHandler> urlHandlerList = new ArrayList<>();
    urlHandlerList.add(urlHandlerImpl);
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(urlHandlerList);

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches("/https://exampleUorg/example");

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    assertSame(urlHandlerImpl, actualCheckForMatchesResult);
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.checkForMatches(String)"})
  public void testCheckForMatches_whenNull() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    ArrayList<URLHandler> urlHandlerList = new ArrayList<>();
    urlHandlerList.add(urlHandlerImpl);
    when(uRLHandlerDao.findAllRegexURLHandlers()).thenReturn(urlHandlerList);

    // Act
    URLHandler actualCheckForMatchesResult = uRLHandlerServiceImpl.checkForMatches(null);

    // Assert
    verify(uRLHandlerDao).findAllRegexURLHandlers();
    Map<String, Pattern> stringPatternMap = uRLHandlerServiceImpl.urlPatternMap;
    assertEquals(1, stringPatternMap.size());
    assertEquals("^/https://example.org/example$", stringPatternMap.get("^/https://example.org/example$").pattern());
    assertNull(actualCheckForMatchesResult);
  }

  /**
   * Test {@link URLHandlerServiceImpl#removeURLHandlerFromCache(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#removeURLHandlerFromCache(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean URLHandlerServiceImpl.removeURLHandlerFromCache(String)"})
  public void testRemoveURLHandlerFromCache_thenThrowRuntimeException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new RuntimeException("cmsUrlHandlerCache"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> uRLHandlerServiceImpl.removeURLHandlerFromCache("https://example.org/example"));
    verify(cacheManager).getCache(eq("cmsUrlHandlerCache"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#removeURLHandlerFromCache(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#removeURLHandlerFromCache(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean URLHandlerServiceImpl.removeURLHandlerFromCache(String)"})
  public void testRemoveURLHandlerFromCache_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(uRLHandlerServiceImpl.removeURLHandlerFromCache(null));
  }

  /**
   * Test {@link URLHandlerServiceImpl#manipulateUri(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#manipulateUri(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String URLHandlerServiceImpl.manipulateUri(String)"})
  public void testManipulateUri() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", uRLHandlerServiceImpl.manipulateUri("https://example.org/example"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#getUrlHandlerFromCache(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#getUrlHandlerFromCache(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URLHandler URLHandlerServiceImpl.getUrlHandlerFromCache(String)"})
  public void testGetUrlHandlerFromCache_thenThrowRuntimeException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new RuntimeException("cmsUrlHandlerCache"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> uRLHandlerServiceImpl.getUrlHandlerFromCache("https://example.org/example"));
    verify(cacheManager).getCache(eq("cmsUrlHandlerCache"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#getUrlHandlerCache()}.
   * <ul>
   *   <li>Given {@link CacheManager} {@link CacheManager#getCache(String)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#getUrlHandlerCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Cache URLHandlerServiceImpl.getUrlHandlerCache()"})
  public void testGetUrlHandlerCache_givenCacheManagerGetCacheReturnNull_thenReturnNull() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache<String, URLHandler> actualUrlHandlerCache = uRLHandlerServiceImpl.getUrlHandlerCache();

    // Assert
    verify(cacheManager).getCache(eq("cmsUrlHandlerCache"));
    assertNull(actualUrlHandlerCache);
  }

  /**
   * Test {@link URLHandlerServiceImpl#getUrlHandlerCache()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#getUrlHandlerCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Cache URLHandlerServiceImpl.getUrlHandlerCache()"})
  public void testGetUrlHandlerCache_thenThrowRuntimeException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new RuntimeException("cmsUrlHandlerCache"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> uRLHandlerServiceImpl.getUrlHandlerCache());
    verify(cacheManager).getCache(eq("cmsUrlHandlerCache"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}.
   * <ul>
   *   <li>Then return {@code site:null_https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String URLHandlerServiceImpl.buildURLHandlerCacheKey(Site, String)"})
  public void testBuildURLHandlerCacheKey_thenReturnSiteNullHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("site:null_https://example.org/example",
        uRLHandlerServiceImpl.buildURLHandlerCacheKey(new SiteImpl(), "https://example.org/example"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String URLHandlerServiceImpl.buildURLHandlerCacheKey(Site, String)"})
  public void testBuildURLHandlerCacheKey_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", uRLHandlerServiceImpl.buildURLHandlerCacheKey(null, null));
  }

  /**
   * Test {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String URLHandlerServiceImpl.wrapStringsWithAnchors(String)"})
  public void testWrapStringsWithAnchors() {
    // Arrange, Act and Assert
    assertEquals("^([\\[\\]\\.\\|\\?\\*\\+\\(\\)\\\\~`\\!@#%&\\-_+={}'\"\"<>:;, \\/])$", uRLHandlerServiceImpl
        .wrapStringsWithAnchors("([\\[\\]\\.\\|\\?\\*\\+\\(\\)\\\\~`\\!@#%&\\-_+={}'\"\"<>:;, \\/])"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}.
   * <ul>
   *   <li>Then return {@code ^$}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String URLHandlerServiceImpl.wrapStringsWithAnchors(String)"})
  public void testWrapStringsWithAnchors_thenReturnCircumflexAccentDollarSign() {
    // Arrange, Act and Assert
    assertEquals("^$", uRLHandlerServiceImpl.wrapStringsWithAnchors("^"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}.
   * <ul>
   *   <li>Then return {@code ^/$}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String URLHandlerServiceImpl.wrapStringsWithAnchors(String)"})
  public void testWrapStringsWithAnchors_thenReturnCircumflexAccentSlashDollarSign() {
    // Arrange, Act and Assert
    assertEquals("^/$", uRLHandlerServiceImpl.wrapStringsWithAnchors("$"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}.
   * <ul>
   *   <li>Then return {@code ^/https://example.org/example$}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String URLHandlerServiceImpl.wrapStringsWithAnchors(String)"})
  public void testWrapStringsWithAnchors_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("^/https://example.org/example$",
        uRLHandlerServiceImpl.wrapStringsWithAnchors("https://example.org/example"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return {@code ^ $}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String URLHandlerServiceImpl.wrapStringsWithAnchors(String)"})
  public void testWrapStringsWithAnchors_whenSpace_thenReturnCircumflexAccentSpaceDollarSign() {
    // Arrange, Act and Assert
    assertEquals("^ $", uRLHandlerServiceImpl.wrapStringsWithAnchors(" "));
  }
}
