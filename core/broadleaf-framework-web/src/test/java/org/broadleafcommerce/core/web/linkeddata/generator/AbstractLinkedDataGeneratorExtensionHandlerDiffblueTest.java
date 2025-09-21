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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DefaultLinkedDataGeneratorExtensionHandler.class})
@ExtendWith(SpringExtension.class)
class AbstractLinkedDataGeneratorExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractLinkedDataGeneratorExtensionHandler abstractLinkedDataGeneratorExtensionHandler;

  @MockBean(name = "blLinkedDataGeneratorExtensionManager")
  private LinkedDataGeneratorExtensionManager linkedDataGeneratorExtensionManager;

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest,
   * JSONArray)}.
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addDefaultData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addDefaultData(HttpServletRequest, JSONArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addDefaultData(HttpServletRequest, JSONArray)"
  })
  void testAddDefaultData() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    ExtensionResultStatusType actualAddDefaultDataResult =
        abstractLinkedDataGeneratorExtensionHandler.addDefaultData(request, new JSONArray(3));

    // Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddDefaultDataResult);
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbData(HttpServletRequest,
   * JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addBreadcrumbData(HttpServletRequest, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addBreadcrumbData(HttpServletRequest, JSONObject)"
  })
  void testAddBreadcrumbData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addBreadcrumbData(request, new JSONObject()));
  }

  /**
   * Test {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbListItemData(HttpServletRequest,
   * JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbListItemData(HttpServletRequest,
   * JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addBreadcrumbListItemData(HttpServletRequest, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addBreadcrumbListItemData(HttpServletRequest, JSONObject)"
  })
  void testAddBreadcrumbListItemData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addBreadcrumbListItemData(
            request, new JSONObject()));
  }

  /**
   * Test {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbItemData(HttpServletRequest,
   * JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbItemData(HttpServletRequest,
   * JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addBreadcrumbItemData(HttpServletRequest, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addBreadcrumbItemData(HttpServletRequest, JSONObject)"
  })
  void testAddBreadcrumbItemData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addBreadcrumbItemData(
            request, new JSONObject()));
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest,
   * JSONArray)}.
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addHomepageData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addHomepageData(HttpServletRequest, JSONArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addHomepageData(HttpServletRequest, JSONArray)"
  })
  void testAddHomepageData() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    ExtensionResultStatusType actualAddHomepageDataResult =
        abstractLinkedDataGeneratorExtensionHandler.addHomepageData(request, new JSONArray(3));

    // Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddHomepageDataResult);
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addWebSiteData(HttpServletRequest,
   * JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addWebSiteData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addWebSiteData(HttpServletRequest, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addWebSiteData(HttpServletRequest, JSONObject)"
  })
  void testAddWebSiteData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addWebSiteData(request, new JSONObject()));
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addOrganizationData(HttpServletRequest,
   * JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addOrganizationData(HttpServletRequest,
   * JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addOrganizationData(HttpServletRequest, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addOrganizationData(HttpServletRequest, JSONObject)"
  })
  void testAddOrganizationData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addOrganizationData(request, new JSONObject()));
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addContactData(HttpServletRequest,
   * JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addContactData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addContactData(HttpServletRequest, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addContactData(HttpServletRequest, JSONObject)"
  })
  void testAddContactData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addContactData(request, new JSONObject()));
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest,
   * JSONArray)}.
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addSocialMediaData(HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test addSocialMediaData(HttpServletRequest, JSONArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addSocialMediaData(HttpServletRequest, JSONArray)"
  })
  void testAddSocialMediaData() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    ExtensionResultStatusType actualAddSocialMediaDataResult =
        abstractLinkedDataGeneratorExtensionHandler.addSocialMediaData(request, new JSONArray(3));

    // Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddSocialMediaDataResult);
  }

  /**
   * Test {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addPotentialActionsData(HttpServletRequest,
   * JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addPotentialActionsData(HttpServletRequest,
   * JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addPotentialActionsData(HttpServletRequest, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addPotentialActionsData(HttpServletRequest, JSONObject)"
  })
  void testAddPotentialActionsData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addPotentialActionsData(
            request, new JSONObject()));
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addCategoryData(HttpServletRequest,
   * JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addCategoryData(HttpServletRequest, JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addCategoryData(HttpServletRequest, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addCategoryData(HttpServletRequest, JSONObject)"
  })
  void testAddCategoryData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addCategoryData(request, new JSONObject()));
  }

  /**
   * Test {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addCategoryProductData(HttpServletRequest,
   * JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addCategoryProductData(HttpServletRequest,
   * JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addCategoryProductData(HttpServletRequest, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addCategoryProductData(HttpServletRequest, JSONObject)"
  })
  void testAddCategoryProductData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addCategoryProductData(
            request, new JSONObject()));
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addReviewData(HttpServletRequest,
   * Product, JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addReviewData(HttpServletRequest, Product,
   * JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addReviewData(HttpServletRequest, Product, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addReviewData(HttpServletRequest, Product, JSONObject)"
  })
  void testAddReviewData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addReviewData(
            request, product, new JSONObject()));
  }

  /**
   * Test {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addAggregateReviewData(HttpServletRequest, Product,
   * JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addAggregateReviewData(HttpServletRequest, Product,
   * JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addAggregateReviewData(HttpServletRequest, Product, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addAggregateReviewData(HttpServletRequest, Product, JSONObject)"
  })
  void testAddAggregateReviewData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addAggregateReviewData(
            request, product, new JSONObject()));
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addProductData(HttpServletRequest,
   * Product, JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addProductData(HttpServletRequest, Product,
   * JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addProductData(HttpServletRequest, Product, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addProductData(HttpServletRequest, Product, JSONObject)"
  })
  void testAddProductData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addProductData(
            request, product, new JSONObject()));
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addSkuData(HttpServletRequest, Product,
   * JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addSkuData(HttpServletRequest, Product,
   * JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addSkuData(HttpServletRequest, Product, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addSkuData(HttpServletRequest, Product, JSONObject)"
  })
  void testAddSkuData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addSkuData(request, product, new JSONObject()));
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addAggregateSkuData(HttpServletRequest,
   * Product, JSONObject)}.
   *
   * <ul>
   *   <li>When {@link JSONObject#JSONObject()}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addAggregateSkuData(HttpServletRequest, Product,
   * JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addAggregateSkuData(HttpServletRequest, Product, JSONObject); when JSONObject(); then return 'NOT_HANDLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addAggregateSkuData(HttpServletRequest, Product, JSONObject)"
  })
  void testAddAggregateSkuData_whenJSONObject_thenReturnNotHandled() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addAggregateSkuData(
            request, product, new JSONObject()));
  }
}
