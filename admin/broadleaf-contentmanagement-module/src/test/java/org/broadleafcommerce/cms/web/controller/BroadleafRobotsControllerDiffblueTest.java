package org.broadleafcommerce.cms.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.cms.page.service.PageService;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.web.BaseUrlResolver;
import org.broadleafcommerce.common.web.resource.BroadleafContextUtil;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafRobotsControllerDiffblueTest {
  @Mock private BaseUrlResolver baseUrlResolver;

  @Mock private BroadleafContextUtil broadleafContextUtil;

  @InjectMocks private BroadleafRobotsController broadleafRobotsController;

  @Mock private PageService pageService;

  /**
   * Test {@link BroadleafRobotsController#getRobotsFile(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link BroadleafRobotsController#getRobotsFile(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafRobotsController.getRobotsFile(HttpServletRequest, HttpServletResponse)"
  })
  public void testGetRobotsFile() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("/");
    doNothing().when(broadleafContextUtil).establishThinRequestContext();
    when(pageService.findPageByURI(
            Mockito.<Locale>any(),
            Mockito.<String>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenReturn(new PageDTO());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRobotsFile = broadleafRobotsController.getRobotsFile(request, response);

    // Assert
    verify(pageService).findPageByURI(isNull(), eq("/robots.txt"), isA(Map.class), eq(false));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(broadleafContextUtil).establishThinRequestContext();
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals(
        "# Using default Broadleaf Commerce robots.txt file\nUser-agent: *\nDisallow:\nSitemap:/sitemap.xml.gz",
        actualRobotsFile);
    assertEquals("UTF-8", response.getCharacterEncoding());
    assertEquals("text/plain;charset=UTF-8", response.getContentType());
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCharset());
  }

  /**
   * Test {@link BroadleafRobotsController#getRobotsFile(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code body} is {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRobotsController#getRobotsFile(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafRobotsController.getRobotsFile(HttpServletRequest, HttpServletResponse)"
  })
  public void testGetRobotsFile_givenHashMapBodyIs42_thenReturn42() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    doNothing().when(broadleafContextUtil).establishThinRequestContext();

    HashMap<String, Object> pageFields = new HashMap<>();
    pageFields.put("body", "42");

    NullPageDTO nullPageDTO = new NullPageDTO();
    nullPageDTO.setPageFields(pageFields);
    when(pageService.findPageByURI(
            Mockito.<Locale>any(),
            Mockito.<String>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenReturn(nullPageDTO);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("text/plain", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRobotsFile = broadleafRobotsController.getRobotsFile(request, response);

    // Assert
    verify(pageService).findPageByURI(isNull(), eq("/robots.txt"), isA(Map.class), eq(false));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(broadleafContextUtil).establishThinRequestContext();
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("42", actualRobotsFile);
    assertEquals("UTF-8", response.getCharacterEncoding());
    assertEquals("text/plain;charset=UTF-8", response.getContentType());
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCharset());
  }

  /**
   * Test {@link BroadleafRobotsController#getRobotsFile(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link PageService} {@link PageService#findPageByURI(Locale, String, Map, boolean)}
   *       return {@code null}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRobotsController#getRobotsFile(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafRobotsController.getRobotsFile(HttpServletRequest, HttpServletResponse)"
  })
  public void testGetRobotsFile_givenPageServiceFindPageByURIReturnNull_thenReturnAString() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    doNothing().when(broadleafContextUtil).establishThinRequestContext();
    when(pageService.findPageByURI(
            Mockito.<Locale>any(),
            Mockito.<String>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRobotsFile = broadleafRobotsController.getRobotsFile(request, response);

    // Assert
    verify(pageService).findPageByURI(isNull(), eq("/robots.txt"), isA(Map.class), eq(false));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(broadleafContextUtil).establishThinRequestContext();
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals(
        "# Using default Broadleaf Commerce robots.txt file\n"
            + "User-agent: *\n"
            + "Disallow:\n"
            + "Sitemap:https://example.org/example/sitemap.xml.gz",
        actualRobotsFile);
    assertEquals("UTF-8", response.getCharacterEncoding());
    assertEquals("text/plain;charset=UTF-8", response.getContentType());
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCharset());
  }

  /**
   * Test {@link BroadleafRobotsController#getRobotsFile(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRobotsController#getRobotsFile(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafRobotsController.getRobotsFile(HttpServletRequest, HttpServletResponse)"
  })
  public void testGetRobotsFile_thenReturnAString() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    doNothing().when(broadleafContextUtil).establishThinRequestContext();
    when(pageService.findPageByURI(
            Mockito.<Locale>any(),
            Mockito.<String>any(),
            Mockito.<Map<String, Object>>any(),
            anyBoolean()))
        .thenReturn(new PageDTO());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRobotsFile = broadleafRobotsController.getRobotsFile(request, response);

    // Assert
    verify(pageService).findPageByURI(isNull(), eq("/robots.txt"), isA(Map.class), eq(false));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(broadleafContextUtil).establishThinRequestContext();
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals(
        "# Using default Broadleaf Commerce robots.txt file\n"
            + "User-agent: *\n"
            + "Disallow:\n"
            + "Sitemap:https://example.org/example/sitemap.xml.gz",
        actualRobotsFile);
    assertEquals("UTF-8", response.getCharacterEncoding());
    assertEquals("text/plain;charset=UTF-8", response.getContentType());
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCharset());
  }

  /**
   * Test {@link BroadleafRobotsController#isSecure(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code HTTPS}.
   *   <li>When {@link MockMultipartHttpServletRequest#MockMultipartHttpServletRequest()} Scheme is
   *       {@code HTTPS}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRobotsController#isSecure(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRobotsController.isSecure(HttpServletRequest)"})
  public void testIsSecure_givenHttps_whenMockMultipartHttpServletRequestSchemeIsHttps() {
    // Arrange
    BroadleafRobotsController broadleafRobotsController = new BroadleafRobotsController();

    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
    request.setScheme("HTTPS");
    request.setSecure(true);

    // Act and Assert
    assertTrue(broadleafRobotsController.isSecure(request));
  }

  /**
   * Test {@link BroadleafRobotsController#isSecure(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRobotsController#isSecure(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRobotsController.isSecure(HttpServletRequest)"})
  public void testIsSecure_givenTrue_thenReturnTrue() {
    // Arrange
    BroadleafRobotsController broadleafRobotsController = new BroadleafRobotsController();

    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
    request.setSecure(true);

    // Act and Assert
    assertTrue(broadleafRobotsController.isSecure(request));
  }

  /**
   * Test {@link BroadleafRobotsController#isSecure(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRobotsController#isSecure(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRobotsController.isSecure(HttpServletRequest)"})
  public void testIsSecure_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange
    BroadleafRobotsController broadleafRobotsController = new BroadleafRobotsController();

    // Act and Assert
    assertFalse(broadleafRobotsController.isSecure(new MockHttpServletRequest()));
  }

  /**
   * Test {@link BroadleafRobotsController#isSecure(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRobotsController#isSecure(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRobotsController.isSecure(HttpServletRequest)"})
  public void testIsSecure_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BroadleafRobotsController().isSecure(null));
  }

  /**
   * Test {@link BroadleafRobotsController#getDefaultRobotsTxt()}.
   *
   * <p>Method under test: {@link BroadleafRobotsController#getDefaultRobotsTxt()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafRobotsController.getDefaultRobotsTxt()"})
  public void testGetDefaultRobotsTxt() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("/");

    // Act
    String actualDefaultRobotsTxt = broadleafRobotsController.getDefaultRobotsTxt();

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    assertEquals(
        "# Using default Broadleaf Commerce robots.txt file\nUser-agent: *\nDisallow:\nSitemap:/sitemap.xml.gz",
        actualDefaultRobotsTxt);
  }

  /**
   * Test {@link BroadleafRobotsController#getDefaultRobotsTxt()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRobotsController#getDefaultRobotsTxt()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafRobotsController.getDefaultRobotsTxt()"})
  public void testGetDefaultRobotsTxt_thenReturnAString() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act
    String actualDefaultRobotsTxt = broadleafRobotsController.getDefaultRobotsTxt();

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    assertEquals(
        "# Using default Broadleaf Commerce robots.txt file\n"
            + "User-agent: *\n"
            + "Disallow:\n"
            + "Sitemap:https://example.org/example/sitemap.xml.gz",
        actualDefaultRobotsTxt);
  }

  /**
   * Test new {@link BroadleafRobotsController} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BroadleafRobotsController}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafRobotsController.<init>()"})
  public void testNewBroadleafRobotsController() {
    // Arrange, Act and Assert
    assertNull(new BroadleafRobotsController().blcContextUtil);
  }
}
