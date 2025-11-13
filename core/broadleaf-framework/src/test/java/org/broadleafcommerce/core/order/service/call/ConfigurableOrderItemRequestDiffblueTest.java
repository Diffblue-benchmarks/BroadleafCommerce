package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConfigurableOrderItemRequestDiffblueTest {
  /**
   * Test {@link ConfigurableOrderItemRequest#getIsMultiSelect()}.
   *
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurableOrderItemRequest#getIsMultiSelect()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ConfigurableOrderItemRequest.getIsMultiSelect()"})
  public void testGetIsMultiSelect_givenConfigurableOrderItemRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ConfigurableOrderItemRequest().getIsMultiSelect());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getIsMultiSelect()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurableOrderItemRequest#getIsMultiSelect()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ConfigurableOrderItemRequest.getIsMultiSelect()"})
  public void testGetIsMultiSelect_thenReturnTrue() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setIsMultiSelect(true);

    // Act and Assert
    assertTrue(configurableOrderItemRequest.getIsMultiSelect());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getQuantity()}.
   *
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor) Quantity is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurableOrderItemRequest#getQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ConfigurableOrderItemRequest.getQuantity()"})
  public void testGetQuantity_givenConfigurableOrderItemRequestQuantityIsNull() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setQuantity(null);

    // Act and Assert
    assertEquals(1, configurableOrderItemRequest.getQuantity().intValue());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getQuantity()}.
   *
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor) Quantity is one.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurableOrderItemRequest#getQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ConfigurableOrderItemRequest.getQuantity()"})
  public void testGetQuantity_givenConfigurableOrderItemRequestQuantityIsOne() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setMinQuantity(1);

    // Act and Assert
    assertEquals(1, configurableOrderItemRequest.getQuantity().intValue());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getQuantity()}.
   *
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor).
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurableOrderItemRequest#getQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ConfigurableOrderItemRequest.getQuantity()"})
  public void testGetQuantity_givenConfigurableOrderItemRequest_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new ConfigurableOrderItemRequest().getQuantity().intValue());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getMinQuantity()}.
   *
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor).
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurableOrderItemRequest#getMinQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ConfigurableOrderItemRequest.getMinQuantity()"})
  public void testGetMinQuantity_givenConfigurableOrderItemRequest_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new ConfigurableOrderItemRequest().getMinQuantity().intValue());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getMinQuantity()}.
   *
   * <ul>
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurableOrderItemRequest#getMinQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ConfigurableOrderItemRequest.getMinQuantity()"})
  public void testGetMinQuantity_thenReturnIntValueIsOne() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setMinQuantity(1);

    // Act and Assert
    assertEquals(1, configurableOrderItemRequest.getMinQuantity().intValue());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getHasOverridenPrice()}.
   *
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurableOrderItemRequest#getHasOverridenPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ConfigurableOrderItemRequest.getHasOverridenPrice()"})
  public void testGetHasOverridenPrice_givenConfigurableOrderItemRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ConfigurableOrderItemRequest().getHasOverridenPrice());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getHasOverridenPrice()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurableOrderItemRequest#getHasOverridenPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ConfigurableOrderItemRequest.getHasOverridenPrice()"})
  public void testGetHasOverridenPrice_thenReturnTrue() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setHasOverridenPrice(true);

    // Act and Assert
    assertTrue(configurableOrderItemRequest.getHasOverridenPrice());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getHasConfigurationError()}.
   *
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurableOrderItemRequest#getHasConfigurationError()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ConfigurableOrderItemRequest.getHasConfigurationError()"})
  public void testGetHasConfigurationError_givenConfigurableOrderItemRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ConfigurableOrderItemRequest().getHasConfigurationError());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getHasConfigurationError()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurableOrderItemRequest#getHasConfigurationError()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ConfigurableOrderItemRequest.getHasConfigurationError()"})
  public void testGetHasConfigurationError_thenReturnTrue() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setHasConfigurationError(true);

    // Act and Assert
    assertTrue(configurableOrderItemRequest.getHasConfigurationError());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getDiscountsAllowed()}.
   *
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurableOrderItemRequest#getDiscountsAllowed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ConfigurableOrderItemRequest.getDiscountsAllowed()"})
  public void testGetDiscountsAllowed_givenConfigurableOrderItemRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ConfigurableOrderItemRequest().getDiscountsAllowed());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getDiscountsAllowed()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurableOrderItemRequest#getDiscountsAllowed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ConfigurableOrderItemRequest.getDiscountsAllowed()"})
  public void testGetDiscountsAllowed_thenReturnTrue() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setDiscountsAllowed(true);

    // Act and Assert
    assertTrue(configurableOrderItemRequest.getDiscountsAllowed());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ConfigurableOrderItemRequest}
   *   <li>{@link ConfigurableOrderItemRequest#setDiscountsAllowed(Boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setDisplayPrice(Money)}
   *   <li>{@link ConfigurableOrderItemRequest#setExpandable(boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setFirstExpandable(boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setHasConfigurationError(Boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setHasOverridenPrice(Boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setIsMultiSelect(Boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setLastExpandable(boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setMaxQuantity(Integer)}
   *   <li>{@link ConfigurableOrderItemRequest#setMinQuantity(Integer)}
   *   <li>{@link ConfigurableOrderItemRequest#setOrderItemIndex(Integer)}
   *   <li>{@link ConfigurableOrderItemRequest#setPricingModelType(String)}
   *   <li>{@link ConfigurableOrderItemRequest#setProductChoices(List)}
   *   <li>{@link ConfigurableOrderItemRequest#getDisplayPrice()}
   *   <li>{@link ConfigurableOrderItemRequest#getMaxQuantity()}
   *   <li>{@link ConfigurableOrderItemRequest#getOrderItemIndex()}
   *   <li>{@link ConfigurableOrderItemRequest#getPricingModelType()}
   *   <li>{@link ConfigurableOrderItemRequest#getProduct()}
   *   <li>{@link ConfigurableOrderItemRequest#getProductChoices()}
   *   <li>{@link ConfigurableOrderItemRequest#getSku()}
   *   <li>{@link ConfigurableOrderItemRequest#isExpandable()}
   *   <li>{@link ConfigurableOrderItemRequest#isFirstExpandable()}
   *   <li>{@link ConfigurableOrderItemRequest#isLastExpandable()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConfigurableOrderItemRequest.<init>()",
    "Money ConfigurableOrderItemRequest.getDisplayPrice()",
    "Integer ConfigurableOrderItemRequest.getMaxQuantity()",
    "Integer ConfigurableOrderItemRequest.getOrderItemIndex()",
    "String ConfigurableOrderItemRequest.getPricingModelType()",
    "Product ConfigurableOrderItemRequest.getProduct()",
    "List ConfigurableOrderItemRequest.getProductChoices()",
    "Sku ConfigurableOrderItemRequest.getSku()",
    "boolean ConfigurableOrderItemRequest.isExpandable()",
    "boolean ConfigurableOrderItemRequest.isFirstExpandable()",
    "boolean ConfigurableOrderItemRequest.isLastExpandable()",
    "void ConfigurableOrderItemRequest.setDiscountsAllowed(Boolean)",
    "void ConfigurableOrderItemRequest.setDisplayPrice(Money)",
    "void ConfigurableOrderItemRequest.setExpandable(boolean)",
    "void ConfigurableOrderItemRequest.setFirstExpandable(boolean)",
    "void ConfigurableOrderItemRequest.setHasConfigurationError(Boolean)",
    "void ConfigurableOrderItemRequest.setHasOverridenPrice(Boolean)",
    "void ConfigurableOrderItemRequest.setIsMultiSelect(Boolean)",
    "void ConfigurableOrderItemRequest.setLastExpandable(boolean)",
    "void ConfigurableOrderItemRequest.setMaxQuantity(Integer)",
    "void ConfigurableOrderItemRequest.setMinQuantity(Integer)",
    "void ConfigurableOrderItemRequest.setOrderItemIndex(Integer)",
    "void ConfigurableOrderItemRequest.setPricingModelType(String)",
    "void ConfigurableOrderItemRequest.setProductChoices(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ConfigurableOrderItemRequest actualConfigurableOrderItemRequest =
        new ConfigurableOrderItemRequest();
    actualConfigurableOrderItemRequest.setDiscountsAllowed(true);
    Money displayPrice = new Money();
    actualConfigurableOrderItemRequest.setDisplayPrice(displayPrice);
    actualConfigurableOrderItemRequest.setExpandable(true);
    actualConfigurableOrderItemRequest.setFirstExpandable(true);
    actualConfigurableOrderItemRequest.setHasConfigurationError(true);
    actualConfigurableOrderItemRequest.setHasOverridenPrice(true);
    actualConfigurableOrderItemRequest.setIsMultiSelect(true);
    actualConfigurableOrderItemRequest.setLastExpandable(true);
    actualConfigurableOrderItemRequest.setMaxQuantity(3);
    actualConfigurableOrderItemRequest.setMinQuantity(1);
    actualConfigurableOrderItemRequest.setOrderItemIndex(1);
    actualConfigurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    ArrayList<ConfigurableOrderItemRequest> productChoices = new ArrayList<>();
    actualConfigurableOrderItemRequest.setProductChoices(productChoices);
    Money actualDisplayPrice = actualConfigurableOrderItemRequest.getDisplayPrice();
    Integer actualMaxQuantity = actualConfigurableOrderItemRequest.getMaxQuantity();
    Integer actualOrderItemIndex = actualConfigurableOrderItemRequest.getOrderItemIndex();
    String actualPricingModelType = actualConfigurableOrderItemRequest.getPricingModelType();
    Product actualProduct = actualConfigurableOrderItemRequest.getProduct();
    List<ConfigurableOrderItemRequest> actualProductChoices =
        actualConfigurableOrderItemRequest.getProductChoices();
    Sku actualSku = actualConfigurableOrderItemRequest.getSku();
    boolean actualIsExpandableResult = actualConfigurableOrderItemRequest.isExpandable();
    boolean actualIsFirstExpandableResult = actualConfigurableOrderItemRequest.isFirstExpandable();
    boolean actualIsLastExpandableResult = actualConfigurableOrderItemRequest.isLastExpandable();

    // Assert
    assertEquals("Pricing Model Type", actualPricingModelType);
    assertNull(actualConfigurableOrderItemRequest.getCategoryId());
    assertNull(actualConfigurableOrderItemRequest.getOrderItemId());
    assertNull(actualConfigurableOrderItemRequest.getParentOrderItemId());
    assertNull(actualConfigurableOrderItemRequest.getProductId());
    assertNull(actualConfigurableOrderItemRequest.getSkuId());
    assertNull(actualConfigurableOrderItemRequest.getOverrideRetailPrice());
    assertNull(actualConfigurableOrderItemRequest.getOverrideSalePrice());
    assertNull(actualProduct);
    assertNull(actualSku);
    assertEquals(1, actualOrderItemIndex.intValue());
    assertEquals(1, actualConfigurableOrderItemRequest.minQuantity.intValue());
    assertEquals(3, actualMaxQuantity.intValue());
    assertTrue(actualConfigurableOrderItemRequest.getChildOrderItems().isEmpty());
    assertTrue(actualConfigurableOrderItemRequest.getAdditionalAttributes().isEmpty());
    assertTrue(actualConfigurableOrderItemRequest.getItemAttributes().isEmpty());
    assertTrue(actualIsExpandableResult);
    assertTrue(actualIsFirstExpandableResult);
    assertTrue(actualIsLastExpandableResult);
    assertSame(productChoices, actualProductChoices);
    assertSame(displayPrice, actualDisplayPrice);
  }
}
