/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class AbstractLinkedDataGeneratorExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addDefaultData(HttpServletRequest, JSONArray)")
  void testAddDefaultData() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultLinkedDataGeneratorExtensionHandler.addDefaultData(request, new JSONArray(3)));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addDefaultData(HttpServletRequest, JSONArray)")
  void testAddDefaultData2() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultLinkedDataGeneratorExtensionHandler.addDefaultData(request, new JSONArray(3)));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addBreadcrumbData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddBreadcrumbData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddBreadcrumbDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addBreadcrumbData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddBreadcrumbDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbListItemData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbListItemData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addBreadcrumbListItemData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddBreadcrumbListItemData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddBreadcrumbListItemDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addBreadcrumbListItemData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddBreadcrumbListItemDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbItemData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbItemData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addBreadcrumbItemData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddBreadcrumbItemData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddBreadcrumbItemDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addBreadcrumbItemData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddBreadcrumbItemDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addHomepageData(HttpServletRequest, JSONArray)")
  void testAddHomepageData() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultLinkedDataGeneratorExtensionHandler.addHomepageData(request, new JSONArray(3)));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addHomepageData(HttpServletRequest, JSONArray)")
  void testAddHomepageData2() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultLinkedDataGeneratorExtensionHandler.addHomepageData(request, new JSONArray(3)));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addWebSiteData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addWebSiteData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addWebSiteData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddWebSiteData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddWebSiteDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addWebSiteData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddWebSiteDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addOrganizationData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addOrganizationData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addOrganizationData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddOrganizationData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddOrganizationDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addOrganizationData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddOrganizationDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addContactData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addContactData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addContactData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddContactData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddContactDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addContactData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddContactDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addSocialMediaData(HttpServletRequest, JSONArray)")
  void testAddSocialMediaData() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultLinkedDataGeneratorExtensionHandler.addSocialMediaData(request, new JSONArray(3)));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest, JSONArray)}.
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addSocialMediaData(HttpServletRequest, JSONArray)")
  void testAddSocialMediaData2() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultLinkedDataGeneratorExtensionHandler.addSocialMediaData(request, new JSONArray(3)));
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addPotentialActionsData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addPotentialActionsData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addPotentialActionsData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddPotentialActionsData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddPotentialActionsDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addPotentialActionsData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddPotentialActionsDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addCategoryData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddCategoryData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddCategoryDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addCategoryData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddCategoryDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryProductData(HttpServletRequest, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryProductData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName("Test addCategoryProductData(HttpServletRequest, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddCategoryProductData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));

    // Act
    ExtensionResultStatusType actualAddCategoryProductDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addCategoryProductData(request, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddCategoryProductDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addReviewData(HttpServletRequest, Product, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addReviewData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addReviewData(HttpServletRequest, Product, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddReviewData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    ExtensionResultStatusType actualAddReviewDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addReviewData(request, product, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddReviewDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateReviewData(HttpServletRequest, Product, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateReviewData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addAggregateReviewData(HttpServletRequest, Product, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddAggregateReviewData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    ExtensionResultStatusType actualAddAggregateReviewDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addAggregateReviewData(request, product, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddAggregateReviewDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addProductData(HttpServletRequest, Product, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addProductData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addProductData(HttpServletRequest, Product, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddProductData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    ExtensionResultStatusType actualAddProductDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addProductData(request, product, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddProductDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSkuData(HttpServletRequest, Product, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSkuData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addSkuData(HttpServletRequest, Product, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddSkuData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    ExtensionResultStatusType actualAddSkuDataResult = defaultLinkedDataGeneratorExtensionHandler.addSkuData(request,
        product, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddSkuDataResult);
  }

  /**
   * Test
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateSkuData(HttpServletRequest, Product, JSONObject)}.
   * <ul>
   *   <li>Given {@code Profile}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateSkuData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addAggregateSkuData(HttpServletRequest, Product, JSONObject); given 'Profile'; then return 'NOT_HANDLED'")
  void testAddAggregateSkuData_givenProfile_thenReturnNotHandled() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler = new DefaultLinkedDataGeneratorExtensionHandler();
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("Profile");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class), environment, new String[]{"White List Param Names"}));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    ExtensionResultStatusType actualAddAggregateSkuDataResult = defaultLinkedDataGeneratorExtensionHandler
        .addAggregateSkuData(request, product, new JSONObject());

    // Assert
    verify(environment).addActiveProfile(eq("Profile"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddAggregateSkuDataResult);
  }
}
