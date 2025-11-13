package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.rating.domain.RatingDetailImpl;
import org.broadleafcommerce.core.rating.domain.RatingSummary;
import org.broadleafcommerce.core.rating.domain.RatingSummaryImpl;
import org.broadleafcommerce.core.rating.domain.ReviewDetail;
import org.broadleafcommerce.core.rating.domain.ReviewDetailImpl;
import org.broadleafcommerce.core.rating.service.RatingService;
import org.broadleafcommerce.core.rating.service.type.RatingType;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class ProductLinkedDataGeneratorImplDiffblueTest {
  @Mock private LinkedDataGeneratorExtensionManager linkedDataGeneratorExtensionManager;

  @InjectMocks private ProductLinkedDataGeneratorImpl productLinkedDataGeneratorImpl;

  @Mock private RatingService ratingService;

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  public void testCanHandle() {
    // Arrange
    ProductLinkedDataGeneratorImpl productLinkedDataGeneratorImpl =
        new ProductLinkedDataGeneratorImpl();

    // Act and Assert
    assertFalse(productLinkedDataGeneratorImpl.canHandle(new MockHttpServletRequest()));
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addImageUrl(Product, JSONObject)}.
   *
   * <ul>
   *   <li>Given {@link ProductLinkedDataGeneratorImpl} (default constructor).
   *   <li>Then calls {@link ProductBundleImpl#getMedia()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addImageUrl(Product, JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductLinkedDataGeneratorImpl.addImageUrl(Product, JSONObject)"})
  public void testAddImageUrl_givenProductLinkedDataGeneratorImpl_thenCallsGetMedia()
      throws JSONException {
    // Arrange
    ProductLinkedDataGeneratorImpl productLinkedDataGeneratorImpl =
        new ProductLinkedDataGeneratorImpl();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(new HashMap<>());

    // Act
    productLinkedDataGeneratorImpl.addImageUrl(product, new JSONObject());

    // Assert
    verify(product).getMedia();
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then {@link JSONObject#JSONObject()} length is one.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest,
   * Product, JSONObject, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addSkus(HttpServletRequest, Product, JSONObject, String)"
  })
  public void testAddSkus_givenArrayList_thenJSONObjectLengthIsOne() throws JSONException {
    // Arrange
    ProductLinkedDataGeneratorImpl productLinkedDataGeneratorImpl =
        new ProductLinkedDataGeneratorImpl();
    MockHttpServletRequest request = new MockHttpServletRequest();

    Product product = mock(Product.class);
    when(product.getAllSellableSkus()).thenReturn(new ArrayList<>());
    when(product.getRetailPrice()).thenReturn(new Money());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addSkus(
        request, product, productData, "https://example.org/example");

    // Assert
    verify(product).getAllSellableSkus();
    verify(product).getRetailPrice();
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#determineAvailability(Sku)}.
   *
   * <ul>
   *   <li>Then return {@code OutOfStock}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#determineAvailability(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.determineAvailability(Sku)"})
  public void testDetermineAvailability_thenReturnOutOfStock() {
    // Arrange
    ProductLinkedDataGeneratorImpl productLinkedDataGeneratorImpl =
        new ProductLinkedDataGeneratorImpl();

    // Act and Assert
    assertEquals("OutOfStock", productLinkedDataGeneratorImpl.determineAvailability(new SkuImpl()));
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest, Product,
   * JSONObject)}.
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest,
   * Product, JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addReviewData(HttpServletRequest, Product, JSONObject)"
  })
  public void testAddReviewData() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    ArrayList<ReviewDetail> reviewDetailList = new ArrayList<>();
    CustomerImpl customer = new CustomerImpl();
    Date reivewSubmittedDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();

    ReviewDetailImpl reviewDetailImpl =
        new ReviewDetailImpl(
            customer, reivewSubmittedDate, ratingDetail, "ratingCount", new RatingSummaryImpl());
    reviewDetailList.add(reviewDetailImpl);

    RatingSummary ratingSummary = mock(RatingSummary.class);
    when(ratingSummary.getAverageRating()).thenReturn(10.0d);
    when(ratingSummary.getReviews()).thenReturn(reviewDetailList);
    when(ratingSummary.getNumberOfRatings()).thenReturn(10);
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummary);
    MockHttpServletRequest request = new MockHttpServletRequest();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addReviewData(request, product, productData);

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(product).getId();
    verify(ratingSummary).getAverageRating();
    verify(ratingSummary, atLeast(1)).getNumberOfRatings();
    verify(ratingSummary).getReviews();
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    assertEquals(2, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest, Product,
   * JSONObject)}.
   *
   * <ul>
   *   <li>Given {@link RatingService} {@link RatingService#readRatingSummary(String, RatingType)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest,
   * Product, JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addReviewData(HttpServletRequest, Product, JSONObject)"
  })
  public void testAddReviewData_givenRatingServiceReadRatingSummaryReturnNull()
      throws JSONException {
    // Arrange
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addReviewData(request, product, productData);

    // Assert that nothing has changed
    verify(product).getId();
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    assertEquals(0, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest, Product,
   * JSONObject)}.
   *
   * <ul>
   *   <li>Given {@link RatingService} {@link RatingService#readRatingSummary(String, RatingType)}
   *       return {@link RatingSummaryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest,
   * Product, JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addReviewData(HttpServletRequest, Product, JSONObject)"
  })
  public void testAddReviewData_givenRatingServiceReadRatingSummaryReturnRatingSummaryImpl()
      throws JSONException {
    // Arrange
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());
    MockHttpServletRequest request = new MockHttpServletRequest();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addReviewData(request, product, productData);

    // Assert that nothing has changed
    verify(product).getId();
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    assertEquals(0, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest, Product,
   * JSONObject)}.
   *
   * <ul>
   *   <li>Then {@link JSONObject#JSONObject()} length is two.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest,
   * Product, JSONObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addReviewData(HttpServletRequest, Product, JSONObject)"
  })
  public void testAddReviewData_thenJSONObjectLengthIsTwo() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    RatingSummary ratingSummary = mock(RatingSummary.class);
    when(ratingSummary.getAverageRating()).thenReturn(10.0d);
    when(ratingSummary.getReviews()).thenReturn(new ArrayList<>());
    when(ratingSummary.getNumberOfRatings()).thenReturn(10);
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummary);
    MockHttpServletRequest request = new MockHttpServletRequest();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addReviewData(request, product, productData);

    // Assert
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(product).getId();
    verify(ratingSummary).getAverageRating();
    verify(ratingSummary, atLeast(1)).getNumberOfRatings();
    verify(ratingSummary).getReviews();
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    assertEquals(2, productData.length());
  }
}
