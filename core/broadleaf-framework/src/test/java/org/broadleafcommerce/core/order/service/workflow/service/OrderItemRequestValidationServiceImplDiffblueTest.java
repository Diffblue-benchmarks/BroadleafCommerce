package org.broadleafcommerce.core.order.service.workflow.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.service.call.AddToCartItem;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.workflow.ActivityMessages;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderItemRequestValidationServiceImplDiffblueTest {
  @Autowired
  private OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSatisfiesMinQuantityCondition() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4508 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.service.OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl2 = new OrderItemRequestValidationServiceImpl();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act
    orderItemRequestValidationServiceImpl2.satisfiesMinQuantityCondition(orderItemRequestDTO,
        new DefaultProcessContextImpl<>());
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMinQuantity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4477 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.service.OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl2 = new OrderItemRequestValidationServiceImpl();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act
    orderItemRequestValidationServiceImpl2.getMinQuantity(orderItemRequestDTO, new DefaultProcessContextImpl<>());
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4330 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.service.OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl2 = new OrderItemRequestValidationServiceImpl();

    // Act
    orderItemRequestValidationServiceImpl2.determineProduct(new OrderItemRequestDTO());
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  public void testDetermineProduct_whenOrderItemRequestDTO_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.determineProduct(new OrderItemRequestDTO()));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)}
   * with {@code orderItemRequestDTO}, {@code messages}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineSkuWithOrderItemRequestDTOMessages() throws RequiredAttributeNotProvidedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4387 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.service.OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl2 = new OrderItemRequestValidationServiceImpl();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act
    orderItemRequestValidationServiceImpl2.determineSku(orderItemRequestDTO, new DefaultProcessContextImpl<>());
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)}
   * with {@code orderItemRequestDTO}, {@code messages}.
   * <ul>
   *   <li>Then calls {@link OrderItemRequestDTO#getProductId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)}
   */
  @Test
  public void testDetermineSkuWithOrderItemRequestDTOMessages_thenCallsGetProductId()
      throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    AddToCartItem orderItemRequestDTO = mock(AddToCartItem.class);
    when(orderItemRequestDTO.getSkuId()).thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));
    when(orderItemRequestDTO.getProductId()).thenReturn(null);

    // Act
    orderItemRequestValidationServiceImpl.determineSku(orderItemRequestDTO, new DefaultProcessContextImpl<>());

    // Assert
    verify(orderItemRequestDTO).getProductId();
    verify(orderItemRequestDTO).getSkuId();
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#determineSku(Product, Long, Map, ActivityMessages)}
   * with {@code product}, {@code skuId}, {@code attributeValues},
   * {@code messages}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#determineSku(Product, Long, Map, ActivityMessages)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineSkuWithProductSkuIdAttributeValuesMessages() throws RequiredAttributeNotProvidedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4357 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.service.OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl2 = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    orderItemRequestValidationServiceImpl2.determineSku(product, 1L, attributeValues,
        new DefaultProcessContextImpl<>());
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanSellDefaultSku() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4300 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.service.OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl2 = new OrderItemRequestValidationServiceImpl();

    // Act
    orderItemRequestValidationServiceImpl2.canSellDefaultSku(new ProductBundleImpl());
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku_givenArrayList_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAdditionalSkus()).thenReturn(new ArrayList<>());

    // Act
    boolean actualCanSellDefaultSkuResult = orderItemRequestValidationServiceImpl.canSellDefaultSku(product);

    // Assert
    verify(product).getAdditionalSkus();
    assertTrue(actualCanSellDefaultSkuResult);
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku_givenFalse_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCanSellWithoutOptions()).thenReturn(false);
    when(product.getAdditionalSkus()).thenReturn(skuList);

    // Act
    boolean actualCanSellDefaultSkuResult = orderItemRequestValidationServiceImpl.canSellDefaultSku(product);

    // Assert
    verify(product).getAdditionalSkus();
    verify(product).getCanSellWithoutOptions();
    assertFalse(actualCanSellDefaultSkuResult);
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku_givenIllegalArgumentExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCanSellWithoutOptions()).thenThrow(new IllegalArgumentException("foo"));
    when(product.getAdditionalSkus()).thenReturn(skuList);

    // Act
    orderItemRequestValidationServiceImpl.canSellDefaultSku(product);

    // Assert
    verify(product).getAdditionalSkus();
    verify(product).getCanSellWithoutOptions();
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku_givenTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCanSellWithoutOptions()).thenReturn(true);
    when(product.getAdditionalSkus()).thenReturn(skuList);

    // Act
    boolean actualCanSellDefaultSkuResult = orderItemRequestValidationServiceImpl.canSellDefaultSku(product);

    // Assert
    verify(product).getAdditionalSkus();
    verify(product).getCanSellWithoutOptions();
    assertTrue(actualCanSellDefaultSkuResult);
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku_whenProductBundleImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();

    // Act and Assert
    assertTrue(orderItemRequestValidationServiceImpl.canSellDefaultSku(new ProductBundleImpl()));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   * with {@code product}, {@code attributeValuesForSku}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindMatchingSkuWithProductAttributeValuesForSku() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4417 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.service.OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl2 = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    orderItemRequestValidationServiceImpl2.findMatchingSku(product, new HashMap<>());
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   * with {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>Then calls {@link ProductImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesForSku_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenThrow(new IllegalArgumentException("foo"));

    HashMap<String, String> attributeValuesForSku = new HashMap<>();
    attributeValuesForSku.put("", "");

    // Act
    orderItemRequestValidationServiceImpl.findMatchingSku(product, attributeValuesForSku);

    // Assert
    verify(product).getId();
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   * with {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesForSku_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   * with {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesForSku_whenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   * with {@code product}, {@code attributeValues}, {@code messages}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesMessages() throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getProductOptionXrefs()).thenThrow(new IllegalArgumentException("foo"));
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    orderItemRequestValidationServiceImpl.findMatchingSku(product, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(product).getProductOptionXrefs();
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   * with {@code product}, {@code attributeValues}, {@code messages}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindMatchingSkuWithProductAttributeValuesMessages2() throws RequiredAttributeNotProvidedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4447 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.service.OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl2 = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    orderItemRequestValidationServiceImpl2.findMatchingSku(product, attributeValues, new DefaultProcessContextImpl<>());
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   * with {@code product}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesMessages_givenArrayList()
      throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getProductOptionXrefs()).thenReturn(new ArrayList<>());
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualFindMatchingSkuResult = orderItemRequestValidationServiceImpl.findMatchingSku(product, attributeValues,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(product).getProductOptionXrefs();
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   * with {@code product}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenNull_thenReturnNull()
      throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(null, attributeValues,
        new DefaultProcessContextImpl<>()));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   * with {@code product}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenProductBundleImpl()
      throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(product, attributeValues,
        new DefaultProcessContextImpl<>()));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShouldValidateWithException() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4539 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.service.OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(true, true, "0123456789ABCDEF", true);
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_when0123456789abcdef_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(false, false,
        "0123456789ABCDEF", false));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenEmptyString_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(false, false, "", false));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(false, false, null, false));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenTrue_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(true, false,
        "0123456789ABCDEF", true));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(true, true, "0123456789ABCDEF",
        true));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#minOrderQuantityCheckIsEnabled()}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#minOrderQuantityCheckIsEnabled()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMinOrderQuantityCheckIsEnabled() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4507 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.service.OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderItemRequestValidationServiceImpl()).minOrderQuantityCheckIsEnabled();
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldUseSku()}.
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#shouldUseSku()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShouldUseSku() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4538 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.service.OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderItemRequestValidationServiceImpl()).shouldUseSku();
  }
}
