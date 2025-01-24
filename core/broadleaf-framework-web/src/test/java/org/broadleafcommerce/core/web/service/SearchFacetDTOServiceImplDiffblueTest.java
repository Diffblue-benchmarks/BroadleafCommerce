package org.broadleafcommerce.core.web.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.SearchFacet;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetResultDTO;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class SearchFacetDTOServiceImplDiffblueTest {
  @Autowired
  private SearchFacetDTOServiceImpl searchFacetDTOServiceImpl;

  /**
   * Test {@link SearchFacetDTOServiceImpl#getDefaultPageSize()}.
   * <p>
   * Method under test: {@link SearchFacetDTOServiceImpl#getDefaultPageSize()}
   */
  @Test
  @DisplayName("Test getDefaultPageSize()")
  @Disabled("TODO: Complete this test")
  void testGetDefaultPageSize() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3551 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.SearchFacetDTOServiceImpl searchFacetDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SearchFacetDTOServiceImpl()).getDefaultPageSize();
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#getMaxPageSize()}.
   * <p>
   * Method under test: {@link SearchFacetDTOServiceImpl#getMaxPageSize()}
   */
  @Test
  @DisplayName("Test getMaxPageSize()")
  @Disabled("TODO: Complete this test")
  void testGetMaxPageSize() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3552 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.SearchFacetDTOServiceImpl searchFacetDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SearchFacetDTOServiceImpl()).getMaxPageSize();
  }

  /**
   * Test
   * {@link SearchFacetDTOServiceImpl#buildSearchCriteria(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#buildSearchCriteria(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test buildSearchCriteria(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testBuildSearchCriteria() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3395 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.SearchFacetDTOServiceImpl searchFacetDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl2 = new SearchFacetDTOServiceImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    searchFacetDTOServiceImpl2.buildSearchCriteria(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#createSearchCriteria()}.
   * <p>
   * Method under test: {@link SearchFacetDTOServiceImpl#createSearchCriteria()}
   */
  @Test
  @DisplayName("Test createSearchCriteria()")
  void testCreateSearchCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SearchCriteria actualCreateSearchCriteriaResult = (new SearchFacetDTOServiceImpl()).createSearchCriteria();

    // Assert
    Collection<String> filterQueries = actualCreateSearchCriteriaResult.getFilterQueries();
    assertTrue(filterQueries instanceof List);
    assertNull(actualCreateSearchCriteriaResult.getPageSize());
    assertNull(actualCreateSearchCriteriaResult.getStartIndex());
    assertNull(actualCreateSearchCriteriaResult.getQuery());
    assertNull(actualCreateSearchCriteriaResult.getRequestHandler());
    assertNull(actualCreateSearchCriteriaResult.getSortQuery());
    assertNull(actualCreateSearchCriteriaResult.getCategory());
    assertEquals(1, actualCreateSearchCriteriaResult.getPage().intValue());
    assertFalse(actualCreateSearchCriteriaResult.getSearchExplicitCategory());
    assertTrue(filterQueries.isEmpty());
    assertTrue(actualCreateSearchCriteriaResult.getFilterCriteria().isEmpty());
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#createSearchCriteria()}.
   * <p>
   * Method under test: {@link SearchFacetDTOServiceImpl#createSearchCriteria()}
   */
  @Test
  @DisplayName("Test createSearchCriteria()")
  @Disabled("TODO: Complete this test")
  void testCreateSearchCriteria2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3550 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.SearchFacetDTOServiceImpl searchFacetDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SearchFacetDTOServiceImpl()).createSearchCriteria();
  }

  /**
   * Test
   * {@link SearchFacetDTOServiceImpl#setActiveFacetResults(List, HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#setActiveFacetResults(List, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test setActiveFacetResults(List, HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testSetActiveFacetResults() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4509 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.SearchFacetDTOServiceImpl searchFacetDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl2 = new SearchFacetDTOServiceImpl();
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    searchFacetDTOServiceImpl2.setActiveFacetResults(facets,
        new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));
  }

  /**
   * Test
   * {@link SearchFacetDTOServiceImpl#setActiveFacetResults(List, HttpServletRequest)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#setActiveFacetResults(List, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test setActiveFacetResults(List, HttpServletRequest); then ArrayList() size is one")
  void testSetActiveFacetResults_thenArrayListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();

    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setQuantity(1);
    searchFacetResultDTO.setValue("42");

    ArrayList<SearchFacetResultDTO> facetValues = new ArrayList<>();
    facetValues.add(searchFacetResultDTO);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(facetValues);
    searchFacetDTO.setShowQuantity(true);

    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    facets.add(searchFacetDTO);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    searchFacetDTOServiceImpl.setActiveFacetResults(facets,
        new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Assert
    assertEquals(1, facets.size());
    List<SearchFacetResultDTO> facetValues2 = facets.get(0).getFacetValues();
    assertEquals(1, facetValues2.size());
    assertFalse(facetValues2.get(0).isActive());
  }

  /**
   * Test
   * {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isActive(SearchFacetResultDTO, HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testIsActive() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4217 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.SearchFacetDTOServiceImpl searchFacetDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl2 = new SearchFacetDTOServiceImpl();

    SearchFacetResultDTO result = new SearchFacetResultDTO();
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    searchFacetDTOServiceImpl2.isActive(result, new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }

  /**
   * Test
   * {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} {@link SearchFacetImpl#getField()} return
   * {@link FieldImpl} (default constructor).</li>
   *   <li>Then calls {@link SearchFacetImpl#getField()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isActive(SearchFacetResultDTO, HttpServletRequest); given SearchFacetImpl getField() return FieldImpl (default constructor); then calls getField()")
  void testIsActive_givenSearchFacetImplGetFieldReturnFieldImpl_thenCallsGetField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();
    SearchFacetImpl searchFacetImpl = mock(SearchFacetImpl.class);
    when(searchFacetImpl.getField()).thenReturn(new FieldImpl());
    SearchFacetResultDTO result = mock(SearchFacetResultDTO.class);
    when(result.getFacet()).thenReturn(searchFacetImpl);
    doNothing().when(result).setActive(anyBoolean());
    doNothing().when(result).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(result).setMaxValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setMinValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setQuantity(Mockito.<Integer>any());
    doNothing().when(result).setValue(Mockito.<String>any());
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");

    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    boolean actualIsActiveResult = searchFacetDTOServiceImpl.isActive(result,
        new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Assert
    verify(searchFacetImpl).getField();
    verify(result).getFacet();
    verify(result).setActive(eq(true));
    verify(result).setFacet(isA(SearchFacet.class));
    verify(result).setMaxValue(isA(BigDecimal.class));
    verify(result).setMinValue(isA(BigDecimal.class));
    verify(result).setQuantity(eq(1));
    verify(result).setValue(eq("42"));
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test
   * {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}.
   * <ul>
   *   <li>When {@link SearchFacetResultDTO} (default constructor) Active is
   * {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isActive(SearchFacetResultDTO, HttpServletRequest); when SearchFacetResultDTO (default constructor) Active is 'true'; then return 'false'")
  void testIsActive_whenSearchFacetResultDTOActiveIsTrue_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();

    SearchFacetResultDTO result = new SearchFacetResultDTO();
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(
        searchFacetDTOServiceImpl.isActive(result, new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test
   * {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}.
   * <ul>
   *   <li>When {@link SearchFacetResultDTO}
   * {@link SearchFacetResultDTO#setActive(boolean)} does nothing.</li>
   *   <li>Then calls {@link SearchFacetResultDTO#setActive(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isActive(SearchFacetResultDTO, HttpServletRequest); when SearchFacetResultDTO setActive(boolean) does nothing; then calls setActive(boolean)")
  void testIsActive_whenSearchFacetResultDTOSetActiveDoesNothing_thenCallsSetActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();
    SearchFacetResultDTO result = mock(SearchFacetResultDTO.class);
    doNothing().when(result).setActive(anyBoolean());
    doNothing().when(result).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(result).setMaxValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setMinValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setQuantity(Mockito.<Integer>any());
    doNothing().when(result).setValue(Mockito.<String>any());
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    boolean actualIsActiveResult = searchFacetDTOServiceImpl.isActive(result,
        new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Assert
    verify(result).setActive(eq(true));
    verify(result).setFacet(isA(SearchFacet.class));
    verify(result).setMaxValue(isA(BigDecimal.class));
    verify(result).setMinValue(isA(BigDecimal.class));
    verify(result).setQuantity(eq(1));
    verify(result).setValue(eq("42"));
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetDTO)} with
   * {@code SearchFacetDTO}.
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetDTO)}
   */
  @Test
  @DisplayName("Test getUrlKey(SearchFacetDTO) with 'SearchFacetDTO'")
  @Disabled("TODO: Complete this test")
  void testGetUrlKeyWithSearchFacetDTO() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3553 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.SearchFacetDTOServiceImpl searchFacetDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl2 = new SearchFacetDTOServiceImpl();

    SearchFacetDTO result = new SearchFacetDTO();
    result.setAbbreviation("Abbreviation");
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setFacetValues(new ArrayList<>());
    result.setShowQuantity(true);

    // Act
    searchFacetDTOServiceImpl2.getUrlKey(result);
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetDTO)} with
   * {@code SearchFacetDTO}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetDTO)}
   */
  @Test
  @DisplayName("Test getUrlKey(SearchFacetDTO) with 'SearchFacetDTO'; then return 'null'")
  void testGetUrlKeyWithSearchFacetDTO_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();
    SearchFacetImpl searchFacetImpl = mock(SearchFacetImpl.class);
    when(searchFacetImpl.getField()).thenReturn(new FieldImpl());
    SearchFacetDTO result = mock(SearchFacetDTO.class);
    when(result.getFacet()).thenReturn(searchFacetImpl);
    doNothing().when(result).setAbbreviation(Mockito.<String>any());
    doNothing().when(result).setActive(anyBoolean());
    doNothing().when(result).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(result).setFacetValues(Mockito.<List<SearchFacetResultDTO>>any());
    doNothing().when(result).setShowQuantity(anyBoolean());
    result.setAbbreviation("Abbreviation");
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setFacetValues(new ArrayList<>());
    result.setShowQuantity(true);

    // Act
    String actualUrlKey = searchFacetDTOServiceImpl.getUrlKey(result);

    // Assert
    verify(result).getFacet();
    verify(result).setAbbreviation(eq("Abbreviation"));
    verify(result).setActive(eq(true));
    verify(result).setFacet(isA(SearchFacet.class));
    verify(result).setFacetValues(isA(List.class));
    verify(result).setShowQuantity(eq(true));
    verify(searchFacetImpl).getField();
    assertNull(actualUrlKey);
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetResultDTO)} with
   * {@code SearchFacetResultDTO}.
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetResultDTO)}
   */
  @Test
  @DisplayName("Test getUrlKey(SearchFacetResultDTO) with 'SearchFacetResultDTO'")
  @Disabled("TODO: Complete this test")
  void testGetUrlKeyWithSearchFacetResultDTO() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3591 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.SearchFacetDTOServiceImpl searchFacetDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl2 = new SearchFacetDTOServiceImpl();

    SearchFacetResultDTO result = new SearchFacetResultDTO();
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");

    // Act
    searchFacetDTOServiceImpl2.getUrlKey(result);
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetResultDTO)} with
   * {@code SearchFacetResultDTO}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetResultDTO)}
   */
  @Test
  @DisplayName("Test getUrlKey(SearchFacetResultDTO) with 'SearchFacetResultDTO'; then return 'null'")
  void testGetUrlKeyWithSearchFacetResultDTO_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();
    SearchFacetImpl searchFacetImpl = mock(SearchFacetImpl.class);
    when(searchFacetImpl.getField()).thenReturn(new FieldImpl());
    SearchFacetResultDTO result = mock(SearchFacetResultDTO.class);
    when(result.getFacet()).thenReturn(searchFacetImpl);
    doNothing().when(result).setActive(anyBoolean());
    doNothing().when(result).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(result).setMaxValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setMinValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setQuantity(Mockito.<Integer>any());
    doNothing().when(result).setValue(Mockito.<String>any());
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");

    // Act
    String actualUrlKey = searchFacetDTOServiceImpl.getUrlKey(result);

    // Assert
    verify(searchFacetImpl).getField();
    verify(result).getFacet();
    verify(result).setActive(eq(true));
    verify(result).setFacet(isA(SearchFacet.class));
    verify(result).setMaxValue(isA(BigDecimal.class));
    verify(result).setMinValue(isA(BigDecimal.class));
    verify(result).setQuantity(eq(1));
    verify(result).setValue(eq("42"));
    assertNull(actualUrlKey);
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#getValue(SearchFacetResultDTO)}.
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#getValue(SearchFacetResultDTO)}
   */
  @Test
  @DisplayName("Test getValue(SearchFacetResultDTO)")
  @Disabled("TODO: Complete this test")
  void testGetValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3904 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.SearchFacetDTOServiceImpl searchFacetDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl2 = new SearchFacetDTOServiceImpl();

    SearchFacetResultDTO result = new SearchFacetResultDTO();
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");

    // Act
    searchFacetDTOServiceImpl2.getValue(result);
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#getValue(SearchFacetResultDTO)}.
   * <ul>
   *   <li>Given {@code secret}.</li>
   *   <li>Then return {@code secret}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#getValue(SearchFacetResultDTO)}
   */
  @Test
  @DisplayName("Test getValue(SearchFacetResultDTO); given 'secret'; then return 'secret'")
  void testGetValue_givenSecret_thenReturnSecret() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();
    SearchFacetResultDTO result = mock(SearchFacetResultDTO.class);
    when(result.getUnencodedValueKey()).thenReturn("secret");
    doNothing().when(result).setActive(anyBoolean());
    doNothing().when(result).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(result).setMaxValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setMinValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setQuantity(Mockito.<Integer>any());
    doNothing().when(result).setValue(Mockito.<String>any());
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");

    // Act
    String actualValue = searchFacetDTOServiceImpl.getValue(result);

    // Assert
    verify(result).getUnencodedValueKey();
    verify(result).setActive(eq(true));
    verify(result).setFacet(isA(SearchFacet.class));
    verify(result).setMaxValue(isA(BigDecimal.class));
    verify(result).setMinValue(isA(BigDecimal.class));
    verify(result).setQuantity(eq(1));
    verify(result).setValue(eq("42"));
    assertEquals("secret", actualValue);
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#getValue(SearchFacetResultDTO)}.
   * <ul>
   *   <li>When {@link SearchFacetResultDTO} (default constructor) Active is
   * {@code true}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#getValue(SearchFacetResultDTO)}
   */
  @Test
  @DisplayName("Test getValue(SearchFacetResultDTO); when SearchFacetResultDTO (default constructor) Active is 'true'; then return '42'")
  void testGetValue_whenSearchFacetResultDTOActiveIsTrue_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();

    SearchFacetResultDTO result = new SearchFacetResultDTO();
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");

    // Act and Assert
    assertEquals("42", searchFacetDTOServiceImpl.getValue(result));
  }
}
