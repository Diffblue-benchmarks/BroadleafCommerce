package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl;
import org.broadleafcommerce.core.order.service.call.AbstractOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.BundleOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.ConfigurableOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.DiscreteOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.GiftWrapOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.NonDiscreteOrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.OrderItemRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.ProductBundleOrderItemRequest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderItemServiceImplDiffblueTest {
  @Autowired
  private OrderItemServiceImpl orderItemServiceImpl;

  /**
   * Test {@link OrderItemServiceImpl#delete(OrderItem)}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#delete(OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDelete() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2924 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    // Act
    orderItemServiceImpl2.delete(new BundleOrderItemImpl());
  }

  /**
   * Test {@link OrderItemServiceImpl#createPersonalMessage()}.
   * <p>
   * Method under test: {@link OrderItemServiceImpl#createPersonalMessage()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreatePersonalMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2923 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderItemServiceImpl()).createPersonalMessage();
  }

  /**
   * Test {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#createOrderItem(OrderItemRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrderItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2908 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    // Act
    orderItemServiceImpl2.createOrderItem(new OrderItemRequest());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)}
   * with {@code AbstractOrderItemRequest}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#createDiscreteOrderItem(AbstractOrderItemRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateDiscreteOrderItemWithAbstractOrderItemRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2822 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    // Act
    orderItemServiceImpl2.createDiscreteOrderItem((AbstractOrderItemRequest) new DiscreteOrderItemRequest());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   * with {@code DiscreteOrderItemRequest}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#createDiscreteOrderItem(DiscreteOrderItemRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateDiscreteOrderItemWithDiscreteOrderItemRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2847 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    // Act
    orderItemServiceImpl2.createDiscreteOrderItem(new DiscreteOrderItemRequest());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#createDynamicPriceDiscreteOrderItem(DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateDynamicPriceDiscreteOrderItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2866 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();
    DiscreteOrderItemRequest itemRequest = new DiscreteOrderItemRequest();

    // Act
    orderItemServiceImpl2.createDynamicPriceDiscreteOrderItem(itemRequest, new HashMap());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#createGiftWrapOrderItem(GiftWrapOrderItemRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateGiftWrapOrderItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2892 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    // Act
    orderItemServiceImpl2.createGiftWrapOrderItem(new GiftWrapOrderItemRequest());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)}
   * with {@code BundleOrderItemRequest}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#createBundleOrderItem(BundleOrderItemRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateBundleOrderItemWithBundleOrderItemRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2702 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    BundleOrderItemRequest itemRequest = new BundleOrderItemRequest();
    itemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setDiscreteOrderItems(new ArrayList<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());

    // Act
    orderItemServiceImpl2.createBundleOrderItem(itemRequest);
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)}
   * with {@code ProductBundleOrderItemRequest}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2732 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    ProductBundleOrderItemRequest itemRequest = new ProductBundleOrderItemRequest();
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setProductBundle(new ProductBundleImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());
    itemRequest.setSku(new SkuImpl());

    // Act
    orderItemServiceImpl2.createBundleOrderItem(itemRequest);
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)}
   * with {@code ProductBundleOrderItemRequest}, {@code boolean}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#createBundleOrderItem(ProductBundleOrderItemRequest, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateBundleOrderItemWithProductBundleOrderItemRequestBoolean() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2762 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    ProductBundleOrderItemRequest itemRequest = new ProductBundleOrderItemRequest();
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setProductBundle(new ProductBundleImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());
    itemRequest.setSku(new SkuImpl());

    // Act
    orderItemServiceImpl2.createBundleOrderItem(itemRequest, true);
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setOrder(new NullOrderImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult instanceof NonDiscreteOrderItemRequestDTO);
    Money overrideRetailPrice = actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice();
    Currency currency = overrideRetailPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertNull(((NonDiscreteOrderItemRequestDTO) actualBuildOrderItemRequestDTOFromOrderItemResult).getItemName());
    assertEquals(0, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, overrideRetailPrice.getAmount());
    assertEquals(overrideRetailPrice, overrideRetailPrice.abs());
    assertEquals(overrideRetailPrice, overrideRetailPrice.zero());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getQuantity()).thenReturn(1);
    when(item.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(item.getAdditionalAttributes()).thenReturn(stringStringMap);
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(new CategoryImpl());
    when(item.getProduct()).thenReturn(new ProductBundleImpl());
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item, atLeast(1)).getProduct();
    verify(item, atLeast(1)).getSku();
    verify(item, atLeast(1)).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    Map<String, String> additionalAttributes = actualBuildOrderItemRequestDTOFromOrderItemResult
        .getAdditionalAttributes();
    assertEquals(1, additionalAttributes.size());
    assertEquals("foo", additionalAttributes.get("foo"));
    assertNull(actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getQuantity()).thenReturn(1);
    when(item.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(item.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(null);
    when(item.getProduct()).thenReturn(new ProductBundleImpl());
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item, atLeast(1)).getProduct();
    verify(item, atLeast(1)).getSku();
    verify(item).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    assertNull(actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getQuantity()).thenReturn(1);
    when(item.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(item.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(new CategoryImpl());
    when(item.getProduct()).thenReturn(null);
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item).getProduct();
    verify(item, atLeast(1)).getSku();
    verify(item, atLeast(1)).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    assertNull(actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getQuantity()).thenReturn(1);
    when(item.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(item.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(new CategoryImpl());
    when(item.getProduct()).thenReturn(new ProductBundleImpl());
    when(item.getSku()).thenReturn(null);

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item, atLeast(1)).getProduct();
    verify(item).getSku();
    verify(item, atLeast(1)).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    assertNull(actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildOrderItemRequestDTOFromOrderItem6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2672 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    // Act
    orderItemServiceImpl2.buildOrderItemRequestDTOFromOrderItem(new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <ul>
   *   <li>Then return AdditionalAttributes Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem_thenReturnAdditionalAttributesEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getQuantity()).thenReturn(1);
    when(item.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(item.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(new CategoryImpl());
    when(item.getProduct()).thenReturn(new ProductBundleImpl());
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item, atLeast(1)).getProduct();
    verify(item, atLeast(1)).getSku();
    verify(item, atLeast(1)).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    assertNull(actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}.
   * <ul>
   *   <li>Then return ItemAttributes size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemRequestDTOFromOrderItem(OrderItem)}
   */
  @Test
  public void testBuildOrderItemRequestDTOFromOrderItem_thenReturnItemAttributesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

    HashMap<String, OrderItemAttribute> stringOrderItemAttributeMap = new HashMap<>();
    stringOrderItemAttributeMap.put("foo", new OrderItemAttributeImpl());
    DiscreteOrderItemImpl item = mock(DiscreteOrderItemImpl.class);
    when(item.getQuantity()).thenReturn(1);
    when(item.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(item.getAdditionalAttributes()).thenReturn(new HashMap<>());
    when(item.getOrderItemAttributes()).thenReturn(stringOrderItemAttributeMap);
    when(item.getCategory()).thenReturn(new CategoryImpl());
    when(item.getProduct()).thenReturn(new ProductBundleImpl());
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItemRequestDTO actualBuildOrderItemRequestDTOFromOrderItemResult = orderItemServiceImpl
        .buildOrderItemRequestDTOFromOrderItem(item);

    // Assert
    verify(item, atLeast(1)).getAdditionalAttributes();
    verify(item, atLeast(1)).getProduct();
    verify(item, atLeast(1)).getSku();
    verify(item, atLeast(1)).getCategory();
    verify(item).getChildOrderItems();
    verify(item, atLeast(1)).getOrderItemAttributes();
    verify(item).getQuantity();
    Map<String, String> itemAttributes = actualBuildOrderItemRequestDTOFromOrderItemResult.getItemAttributes();
    assertEquals(1, itemAttributes.size());
    assertNull(itemAttributes.get("foo"));
    assertNull(actualBuildOrderItemRequestDTOFromOrderItemResult.getOverrideRetailPrice());
    assertEquals(1, actualBuildOrderItemRequestDTOFromOrderItemResult.getQuantity().intValue());
    assertTrue(actualBuildOrderItemRequestDTOFromOrderItemResult.getAdditionalAttributes().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#buildOrderItemFromDTO(Order, OrderItemRequestDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildOrderItemFromDTO() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2642 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderItemServiceImpl2.buildOrderItemFromDTO(order, new OrderItemRequestDTO());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindAllProductsInRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2959 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    ConfigurableOrderItemRequest itemRequest = new ConfigurableOrderItemRequest();
    itemRequest.setAdditionalAttributes(new HashMap<>());
    itemRequest.setCategoryId(1L);
    itemRequest.setChildOrderItems(new ArrayList<>());
    itemRequest.setDiscountsAllowed(true);
    itemRequest.setDisplayPrice(new Money());
    itemRequest.setExpandable(true);
    itemRequest.setFirstExpandable(true);
    itemRequest.setHasConfigurationError(true);
    itemRequest.setHasOverridenPrice(true);
    itemRequest.setIsMultiSelect(true);
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setLastExpandable(true);
    itemRequest.setMaxQuantity(3);
    itemRequest.setMinQuantity(1);
    itemRequest.setOrderItemId(1L);
    itemRequest.setOrderItemIndex(1);
    itemRequest.setOverrideRetailPrice(new Money());
    itemRequest.setOverrideSalePrice(new Money());
    itemRequest.setParentOrderItemId(1L);
    itemRequest.setPricingModelType("Pricing Model Type");
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSkuId(1L);

    // Act
    orderItemServiceImpl2.findAllProductsInRequest(itemRequest);
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then calls {@link ConfigurableOrderItemRequest#getProduct()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}
   */
  @Test
  public void testFindAllProductsInRequest_givenProductBundleImpl_thenCallsGetProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    ConfigurableOrderItemRequest itemRequest = mock(ConfigurableOrderItemRequest.class);
    when(itemRequest.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(itemRequest.getProduct()).thenReturn(new ProductBundleImpl());
    when(itemRequest.setCategoryId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setItemAttributes(Mockito.<Map<String, String>>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setOrderItemId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setProductId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setQuantity(Mockito.<Integer>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setSkuId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    doNothing().when(itemRequest).setDiscountsAllowed(Mockito.<Boolean>any());
    doNothing().when(itemRequest).setDisplayPrice(Mockito.<Money>any());
    doNothing().when(itemRequest).setExpandable(anyBoolean());
    doNothing().when(itemRequest).setFirstExpandable(anyBoolean());
    doNothing().when(itemRequest).setHasConfigurationError(Mockito.<Boolean>any());
    doNothing().when(itemRequest).setHasOverridenPrice(Mockito.<Boolean>any());
    doNothing().when(itemRequest).setIsMultiSelect(Mockito.<Boolean>any());
    doNothing().when(itemRequest).setLastExpandable(anyBoolean());
    doNothing().when(itemRequest).setMaxQuantity(Mockito.<Integer>any());
    doNothing().when(itemRequest).setMinQuantity(Mockito.<Integer>any());
    doNothing().when(itemRequest).setOrderItemIndex(Mockito.<Integer>any());
    doNothing().when(itemRequest).setPricingModelType(Mockito.<String>any());
    doNothing().when(itemRequest).setProductChoices(Mockito.<List<ConfigurableOrderItemRequest>>any());
    doNothing().when(itemRequest).setAdditionalAttributes(Mockito.<Map<String, String>>any());
    doNothing().when(itemRequest).setChildOrderItems(Mockito.<List<OrderItemRequestDTO>>any());
    doNothing().when(itemRequest).setOverrideRetailPrice(Mockito.<Money>any());
    doNothing().when(itemRequest).setOverrideSalePrice(Mockito.<Money>any());
    doNothing().when(itemRequest).setParentOrderItemId(Mockito.<Long>any());
    itemRequest.setAdditionalAttributes(new HashMap<>());
    itemRequest.setCategoryId(1L);
    itemRequest.setChildOrderItems(new ArrayList<>());
    itemRequest.setDiscountsAllowed(true);
    itemRequest.setDisplayPrice(new Money());
    itemRequest.setExpandable(true);
    itemRequest.setFirstExpandable(true);
    itemRequest.setHasConfigurationError(true);
    itemRequest.setHasOverridenPrice(true);
    itemRequest.setIsMultiSelect(true);
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setLastExpandable(true);
    itemRequest.setMaxQuantity(3);
    itemRequest.setMinQuantity(1);
    itemRequest.setOrderItemId(1L);
    itemRequest.setOrderItemIndex(1);
    itemRequest.setOverrideRetailPrice(new Money());
    itemRequest.setOverrideSalePrice(new Money());
    itemRequest.setParentOrderItemId(1L);
    itemRequest.setPricingModelType("Pricing Model Type");
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSkuId(1L);

    // Act
    Set<Product> actualFindAllProductsInRequestResult = orderItemServiceImpl.findAllProductsInRequest(itemRequest);

    // Assert
    verify(itemRequest).getProduct();
    verify(itemRequest).setDiscountsAllowed(eq(true));
    verify(itemRequest).setDisplayPrice(isA(Money.class));
    verify(itemRequest).setExpandable(eq(true));
    verify(itemRequest).setFirstExpandable(eq(true));
    verify(itemRequest).setHasConfigurationError(eq(true));
    verify(itemRequest).setHasOverridenPrice(eq(true));
    verify(itemRequest).setIsMultiSelect(eq(true));
    verify(itemRequest).setLastExpandable(eq(true));
    verify(itemRequest).setMaxQuantity(eq(3));
    verify(itemRequest).setMinQuantity(eq(1));
    verify(itemRequest).setOrderItemIndex(eq(1));
    verify(itemRequest).setPricingModelType(eq("Pricing Model Type"));
    verify(itemRequest).setProductChoices(isA(List.class));
    verify(itemRequest).getChildOrderItems();
    verify(itemRequest).setAdditionalAttributes(isA(Map.class));
    verify(itemRequest).setCategoryId(eq(1L));
    verify(itemRequest).setChildOrderItems(isA(List.class));
    verify(itemRequest).setItemAttributes(isA(Map.class));
    verify(itemRequest).setOrderItemId(eq(1L));
    verify(itemRequest).setOverrideRetailPrice(isA(Money.class));
    verify(itemRequest).setOverrideSalePrice(isA(Money.class));
    verify(itemRequest).setParentOrderItemId(eq(1L));
    verify(itemRequest).setProductId(eq(1L));
    verify(itemRequest).setQuantity(eq(1));
    verify(itemRequest).setSkuId(eq(1L));
    assertEquals(1, actualFindAllProductsInRequestResult.size());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}
   */
  @Test
  public void testFindAllProductsInRequest_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

    ConfigurableOrderItemRequest itemRequest = new ConfigurableOrderItemRequest();
    itemRequest.setAdditionalAttributes(new HashMap<>());
    itemRequest.setCategoryId(1L);
    itemRequest.setChildOrderItems(new ArrayList<>());
    itemRequest.setDiscountsAllowed(true);
    itemRequest.setDisplayPrice(new Money());
    itemRequest.setExpandable(true);
    itemRequest.setFirstExpandable(true);
    itemRequest.setHasConfigurationError(true);
    itemRequest.setHasOverridenPrice(true);
    itemRequest.setIsMultiSelect(true);
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setLastExpandable(true);
    itemRequest.setMaxQuantity(3);
    itemRequest.setMinQuantity(1);
    itemRequest.setOrderItemId(1L);
    itemRequest.setOrderItemIndex(1);
    itemRequest.setOverrideRetailPrice(new Money());
    itemRequest.setOverrideSalePrice(new Money());
    itemRequest.setParentOrderItemId(1L);
    itemRequest.setPricingModelType("Pricing Model Type");
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSkuId(1L);

    // Act and Assert
    assertEquals(1, orderItemServiceImpl.findAllProductsInRequest(itemRequest).size());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#findAllProductsInRequest(ConfigurableOrderItemRequest)}
   */
  @Test
  public void testFindAllProductsInRequest_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

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
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());

    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    childOrderItems.add(configurableOrderItemRequest);

    ConfigurableOrderItemRequest itemRequest = new ConfigurableOrderItemRequest();
    itemRequest.setAdditionalAttributes(new HashMap<>());
    itemRequest.setCategoryId(1L);
    itemRequest.setDiscountsAllowed(true);
    itemRequest.setDisplayPrice(new Money());
    itemRequest.setExpandable(true);
    itemRequest.setFirstExpandable(true);
    itemRequest.setHasConfigurationError(true);
    itemRequest.setHasOverridenPrice(true);
    itemRequest.setIsMultiSelect(true);
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setLastExpandable(true);
    itemRequest.setMaxQuantity(3);
    itemRequest.setMinQuantity(1);
    itemRequest.setOrderItemId(1L);
    itemRequest.setOrderItemIndex(1);
    itemRequest.setOverrideRetailPrice(new Money());
    itemRequest.setOverrideSalePrice(new Money());
    itemRequest.setParentOrderItemId(1L);
    itemRequest.setPricingModelType("Pricing Model Type");
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSkuId(1L);
    itemRequest.setChildOrderItems(childOrderItems);

    // Act and Assert
    assertEquals(2, orderItemServiceImpl.findAllProductsInRequest(itemRequest).size());
  }

  /**
   * Test {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindAllChildProductsInRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2954 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    // Act
    orderItemServiceImpl2.findAllChildProductsInRequest(new ArrayList<>());
  }

  /**
   * Test {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}
   */
  @Test
  public void testFindAllChildProductsInRequest_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

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
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());

    ArrayList<OrderItemRequestDTO> childItems = new ArrayList<>();
    childItems.add(configurableOrderItemRequest);

    // Act and Assert
    assertEquals(1, orderItemServiceImpl.findAllChildProductsInRequest(childItems).size());
  }

  /**
   * Test {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#findAllChildProductsInRequest(List)}
   */
  @Test
  public void testFindAllChildProductsInRequest_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();

    // Act and Assert
    assertTrue(orderItemServiceImpl.findAllChildProductsInRequest(new ArrayList<>()).isEmpty());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#applyAdditionalOrderItemProperties(OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#applyAdditionalOrderItemProperties(OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyAdditionalOrderItemProperties() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2612 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    // Act
    orderItemServiceImpl2.applyAdditionalOrderItemProperties(new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#createConfigurableOrderItemRequestFromProduct(Product)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#createConfigurableOrderItemRequestFromProduct(Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateConfigurableOrderItemRequestFromProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2792 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    // Act
    orderItemServiceImpl2.createConfigurableOrderItemRequestFromProduct(new ProductBundleImpl());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#createConfigurableOrderItemRequestFromProduct(Product)}.
   * <ul>
   *   <li>Then return MaxQuantity is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#createConfigurableOrderItemRequestFromProduct(Product)}
   */
  @Test
  public void testCreateConfigurableOrderItemRequestFromProduct_thenReturnMaxQuantityIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    // Act
    ConfigurableOrderItemRequest actualCreateConfigurableOrderItemRequestFromProductResult = orderItemServiceImpl
        .createConfigurableOrderItemRequestFromProduct(product);

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(product).getId();
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getMaxQuantity());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getOrderItemIndex());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getCategoryId());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getOrderItemId());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getParentOrderItemId());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getSkuId());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getPricingModelType());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getProductChoices());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getDisplayPrice());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getOverrideRetailPrice());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getOverrideSalePrice());
    assertNull(actualCreateConfigurableOrderItemRequestFromProductResult.getSku());
    assertEquals(0, actualCreateConfigurableOrderItemRequestFromProductResult.getMinQuantity().intValue());
    assertEquals(1, actualCreateConfigurableOrderItemRequestFromProductResult.getQuantity().intValue());
    assertEquals(1L, actualCreateConfigurableOrderItemRequestFromProductResult.getProductId().longValue());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.getDiscountsAllowed());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.getHasConfigurationError());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.getHasOverridenPrice());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.getIsMultiSelect());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.isExpandable());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.isFirstExpandable());
    assertFalse(actualCreateConfigurableOrderItemRequestFromProductResult.isLastExpandable());
    assertTrue(actualCreateConfigurableOrderItemRequestFromProductResult.getChildOrderItems().isEmpty());
    assertTrue(actualCreateConfigurableOrderItemRequestFromProductResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualCreateConfigurableOrderItemRequestFromProductResult.getItemAttributes().isEmpty());
    assertSame(product, actualCreateConfigurableOrderItemRequestFromProductResult.getProduct());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#mergeOrderItemRequest(ConfigurableOrderItemRequest, OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#mergeOrderItemRequest(ConfigurableOrderItemRequest, OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMergeOrderItemRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3019 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();

    ConfigurableOrderItemRequest itemRequest = new ConfigurableOrderItemRequest();
    itemRequest.setAdditionalAttributes(new HashMap<>());
    itemRequest.setCategoryId(1L);
    itemRequest.setChildOrderItems(new ArrayList<>());
    itemRequest.setDiscountsAllowed(true);
    itemRequest.setDisplayPrice(new Money());
    itemRequest.setExpandable(true);
    itemRequest.setFirstExpandable(true);
    itemRequest.setHasConfigurationError(true);
    itemRequest.setHasOverridenPrice(true);
    itemRequest.setIsMultiSelect(true);
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setLastExpandable(true);
    itemRequest.setMaxQuantity(3);
    itemRequest.setMinQuantity(1);
    itemRequest.setOrderItemId(1L);
    itemRequest.setOrderItemIndex(1);
    itemRequest.setOverrideRetailPrice(new Money());
    itemRequest.setOverrideSalePrice(new Money());
    itemRequest.setParentOrderItemId(1L);
    itemRequest.setPricingModelType("Pricing Model Type");
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSkuId(1L);

    // Act
    orderItemServiceImpl2.mergeOrderItemRequest(itemRequest, new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List, Date, Date)}.
   * <p>
   * Method under test:
   * {@link OrderItemServiceImpl#findOrderItemsForCustomersInDateRange(List, Date, Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindOrderItemsForCustomersInDateRange() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2989 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderItemServiceImpl orderItemServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemServiceImpl orderItemServiceImpl2 = new OrderItemServiceImpl();
    ArrayList<Long> customerIds = new ArrayList<>();
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    orderItemServiceImpl2.findOrderItemsForCustomersInDateRange(customerIds, startDate,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }
}
