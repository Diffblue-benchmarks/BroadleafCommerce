/*-
 * #%L
 * BroadleafCommerce Framework Web
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class AbstractLinkedDataGeneratorExtensionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest, JSONArray)}
   */
  @Test
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest, JSONArray)}
   */
  @Test
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbData(HttpServletRequest, JSONObject)}
   */
  @Test
  void testAddBreadcrumbData() throws JSONException {
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbListItemData(HttpServletRequest, JSONObject)}
   */
  @Test
  void testAddBreadcrumbListItemData() throws JSONException {
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbItemData(HttpServletRequest, JSONObject)}
   */
  @Test
  void testAddBreadcrumbItemData() throws JSONException {
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest, JSONArray)}
   */
  @Test
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest, JSONArray)}
   */
  @Test
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addWebSiteData(HttpServletRequest, JSONObject)}
   */
  @Test
  void testAddWebSiteData() throws JSONException {
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addOrganizationData(HttpServletRequest, JSONObject)}
   */
  @Test
  void testAddOrganizationData() throws JSONException {
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addContactData(HttpServletRequest, JSONObject)}
   */
  @Test
  void testAddContactData() throws JSONException {
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest, JSONArray)}
   */
  @Test
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest, JSONArray)}
   */
  @Test
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addPotentialActionsData(HttpServletRequest, JSONObject)}
   */
  @Test
  void testAddPotentialActionsData() throws JSONException {
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryData(HttpServletRequest, JSONObject)}
   */
  @Test
  void testAddCategoryData() throws JSONException {
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryProductData(HttpServletRequest, JSONObject)}
   */
  @Test
  void testAddCategoryProductData() throws JSONException {
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addReviewData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  void testAddReviewData() throws JSONException {
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateReviewData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  void testAddAggregateReviewData() throws JSONException {
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addProductData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  void testAddProductData() throws JSONException {
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addSkuData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  void testAddSkuData() throws JSONException {
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
   * Method under test:
   * {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateSkuData(HttpServletRequest, Product, JSONObject)}
   */
  @Test
  void testAddAggregateSkuData() throws JSONException {
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
