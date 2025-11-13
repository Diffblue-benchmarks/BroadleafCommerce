package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultLinkedDataGeneratorExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractLinkedDataGeneratorExtensionHandlerDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addDefaultData(HttpServletRequest, JSONArray)"
  })
  public void testAddDefaultData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addDefaultData(request, new JSONArray()));
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbData(HttpServletRequest,
   * JSONObject)}.
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbData(HttpServletRequest, JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addBreadcrumbData(HttpServletRequest, JSONObject)"
  })
  public void testAddBreadcrumbData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

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
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbListItemData(HttpServletRequest,
   * JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addBreadcrumbListItemData(HttpServletRequest, JSONObject)"
  })
  public void testAddBreadcrumbListItemData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

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
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addBreadcrumbItemData(HttpServletRequest,
   * JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addBreadcrumbItemData(HttpServletRequest, JSONObject)"
  })
  public void testAddBreadcrumbItemData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addHomepageData(HttpServletRequest, JSONArray)"
  })
  public void testAddHomepageData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addHomepageData(request, new JSONArray()));
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addWebSiteData(HttpServletRequest,
   * JSONObject)}.
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addWebSiteData(HttpServletRequest, JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addWebSiteData(HttpServletRequest, JSONObject)"
  })
  public void testAddWebSiteData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addWebSiteData(request, new JSONObject()));
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addOrganizationData(HttpServletRequest,
   * JSONObject)}.
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addOrganizationData(HttpServletRequest,
   * JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addOrganizationData(HttpServletRequest, JSONObject)"
  })
  public void testAddOrganizationData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addOrganizationData(request, new JSONObject()));
  }

  /**
   * Test {@link AbstractLinkedDataGeneratorExtensionHandler#addContactData(HttpServletRequest,
   * JSONObject)}.
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addContactData(HttpServletRequest, JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addContactData(HttpServletRequest, JSONObject)"
  })
  public void testAddContactData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addSocialMediaData(HttpServletRequest, JSONArray)"
  })
  public void testAddSocialMediaData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addSocialMediaData(request, new JSONArray()));
  }

  /**
   * Test {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addPotentialActionsData(HttpServletRequest,
   * JSONObject)}.
   *
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addPotentialActionsData(HttpServletRequest,
   * JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addPotentialActionsData(HttpServletRequest, JSONObject)"
  })
  public void testAddPotentialActionsData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

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
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addCategoryData(HttpServletRequest, JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addCategoryData(HttpServletRequest, JSONObject)"
  })
  public void testAddCategoryData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

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
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addCategoryProductData(HttpServletRequest,
   * JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addCategoryProductData(HttpServletRequest, JSONObject)"
  })
  public void testAddCategoryProductData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

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
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addReviewData(HttpServletRequest, Product,
   * JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addReviewData(HttpServletRequest, Product, JSONObject)"
  })
  public void testAddReviewData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
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
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addAggregateReviewData(HttpServletRequest, Product,
   * JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addAggregateReviewData(HttpServletRequest, Product, JSONObject)"
  })
  public void testAddAggregateReviewData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
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
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addProductData(HttpServletRequest, Product,
   * JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addProductData(HttpServletRequest, Product, JSONObject)"
  })
  public void testAddProductData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
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
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addSkuData(HttpServletRequest, Product,
   * JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addSkuData(HttpServletRequest, Product, JSONObject)"
  })
  public void testAddSkuData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
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
   * <p>Method under test: {@link
   * AbstractLinkedDataGeneratorExtensionHandler#addAggregateSkuData(HttpServletRequest, Product,
   * JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractLinkedDataGeneratorExtensionHandler.addAggregateSkuData(HttpServletRequest, Product, JSONObject)"
  })
  public void testAddAggregateSkuData() throws JSONException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractLinkedDataGeneratorExtensionHandler.addAggregateSkuData(
            request, product, new JSONObject()));
  }
}
