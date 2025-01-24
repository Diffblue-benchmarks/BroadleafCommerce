package org.broadleafcommerce.core.inventory.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
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
public class InventoryServiceImplDiffblueTest {
  @Autowired
  private InventoryServiceImpl inventoryServiceImpl;

  /**
   * Test {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckBasicAvailablility() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1830 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();

    // Act
    inventoryServiceImpl2.checkBasicAvailablility(new SkuImpl());
  }

  /**
   * Test {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}.
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  public void testCheckBasicAvailablility_givenAlways_available() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    boolean actualCheckBasicAvailablilityResult = inventoryServiceImpl.checkBasicAvailablility(sku);

    // Assert
    verify(sku).getInventoryType();
    verify(sku).isActive();
    assertTrue(actualCheckBasicAvailablilityResult);
  }

  /**
   * Test {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Sku} {@link Sku#getInventoryType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  public void testCheckBasicAvailablility_givenNull_whenSkuGetInventoryTypeReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(null);
    when(sku.isActive()).thenReturn(true);

    // Act
    boolean actualCheckBasicAvailablilityResult = inventoryServiceImpl.checkBasicAvailablility(sku);

    // Assert
    verify(sku).getInventoryType();
    verify(sku).isActive();
    assertTrue(actualCheckBasicAvailablilityResult);
  }

  /**
   * Test {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}.
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  public void testCheckBasicAvailablility_givenUnavailable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    boolean actualCheckBasicAvailablilityResult = inventoryServiceImpl.checkBasicAvailablility(sku);

    // Assert
    verify(sku).getInventoryType();
    verify(sku).isActive();
    assertFalse(actualCheckBasicAvailablilityResult);
  }

  /**
   * Test {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  public void testCheckBasicAvailablility_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenThrow(new IllegalArgumentException("foo"));
    when(sku.isActive()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.checkBasicAvailablility(sku));
    verify(sku).getInventoryType();
    verify(sku).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  public void testCheckBasicAvailablility_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new InventoryServiceImpl()).checkBasicAvailablility(null));
  }

  /**
   * Test {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  public void testCheckBasicAvailablility_whenSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    // Act and Assert
    assertFalse(inventoryServiceImpl.checkBasicAvailablility(new SkuImpl()));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with
   * {@code sku}.
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRetrieveQuantityAvailableWithSku() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2290 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();

    // Act
    inventoryServiceImpl2.retrieveQuantityAvailable(new SkuImpl());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)} with
   * {@code sku}, {@code context}.
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRetrieveQuantityAvailableWithSkuContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2320 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();
    SkuImpl sku = new SkuImpl();

    // Act
    inventoryServiceImpl2.retrieveQuantityAvailable(sku, new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   * with {@code skus}.
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRetrieveQuantitiesAvailableWithSkus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2263 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();

    // Act
    inventoryServiceImpl2.retrieveQuantitiesAvailable(new ArrayList<>());
  }

  /**
   * Test
   * {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   * with {@code skus}, {@code context}.
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRetrieveQuantitiesAvailableWithSkusContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2273 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();
    ArrayList<Sku> skus = new ArrayList<>();

    // Act
    inventoryServiceImpl2.retrieveQuantitiesAvailable(skus, new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku},
   * {@code quantity}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsAvailableWithSkuQuantity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2176 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();

    // Act
    inventoryServiceImpl2.isAvailable(new SkuImpl(), 1);
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with
   * {@code sku}, {@code quantity}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsAvailableWithSkuQuantityContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2206 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();
    SkuImpl sku = new SkuImpl();

    // Act
    inventoryServiceImpl2.isAvailable(sku, 1, new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with
   * {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  public void testIsAvailableWithSkuQuantityContext_givenAlways_available() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    boolean actualIsAvailableResult = inventoryServiceImpl.isAvailable(sku, 1, new HashMap<>());

    // Assert
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    assertTrue(actualIsAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with
   * {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  public void testIsAvailableWithSkuQuantityContext_givenIllegalArgumentExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenThrow(new IllegalArgumentException("foo"));
    when(sku.isActive()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.isAvailable(sku, 1, new HashMap<>()));
    verify(sku).getInventoryType();
    verify(sku).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with
   * {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  public void testIsAvailableWithSkuQuantityContext_givenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(null);
    when(sku.isActive()).thenReturn(true);

    // Act
    boolean actualIsAvailableResult = inventoryServiceImpl.isAvailable(sku, 1, new HashMap<>());

    // Assert
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    assertTrue(actualIsAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with
   * {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  public void testIsAvailableWithSkuQuantityContext_givenUnavailable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    boolean actualIsAvailableResult = inventoryServiceImpl.isAvailable(sku, 1, new HashMap<>());

    // Assert
    verify(sku).getInventoryType();
    verify(sku).isActive();
    assertFalse(actualIsAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with
   * {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  public void testIsAvailableWithSkuQuantityContext_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    // Act and Assert
    assertFalse(inventoryServiceImpl.isAvailable(null, 1, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with
   * {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  public void testIsAvailableWithSkuQuantityContext_whenSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertFalse(inventoryServiceImpl.isAvailable(sku, 1, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with
   * {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>When {@link Sku}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  public void testIsAvailableWithSkuQuantityContext_whenSku_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    Sku sku = mock(Sku.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.isAvailable(sku, 0, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku},
   * {@code quantity}.
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  public void testIsAvailableWithSkuQuantity_givenAlways_available() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    boolean actualIsAvailableResult = inventoryServiceImpl.isAvailable(sku, 1);

    // Assert
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    assertTrue(actualIsAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku},
   * {@code quantity}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  public void testIsAvailableWithSkuQuantity_givenIllegalArgumentExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenThrow(new IllegalArgumentException("foo"));
    when(sku.isActive()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.isAvailable(sku, 1));
    verify(sku).getInventoryType();
    verify(sku).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku},
   * {@code quantity}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Sku} {@link Sku#getInventoryType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  public void testIsAvailableWithSkuQuantity_givenNull_whenSkuGetInventoryTypeReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(null);
    when(sku.isActive()).thenReturn(true);

    // Act
    boolean actualIsAvailableResult = inventoryServiceImpl.isAvailable(sku, 1);

    // Assert
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    assertTrue(actualIsAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku},
   * {@code quantity}.
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  public void testIsAvailableWithSkuQuantity_givenUnavailable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    boolean actualIsAvailableResult = inventoryServiceImpl.isAvailable(sku, 1);

    // Assert
    verify(sku).getInventoryType();
    verify(sku).isActive();
    assertFalse(actualIsAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku},
   * {@code quantity}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  public void testIsAvailableWithSkuQuantity_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new InventoryServiceImpl()).isAvailable(null, 1));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku},
   * {@code quantity}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  public void testIsAvailableWithSkuQuantity_whenSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    // Act and Assert
    assertFalse(inventoryServiceImpl.isAvailable(new SkuImpl(), 1));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku},
   * {@code quantity}.
   * <ul>
   *   <li>When {@link Sku}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  public void testIsAvailableWithSkuQuantity_whenSku_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new InventoryServiceImpl()).isAvailable(mock(Sku.class), 0));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with
   * {@code skuQuantities}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDecrementInventoryWithSkuQuantities() throws InventoryUnavailableException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1890 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();

    // Act
    inventoryServiceImpl2.decrementInventory(new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with
   * {@code skuQuantities}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDecrementInventoryWithSkuQuantitiesContext() throws InventoryUnavailableException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1903 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl2.decrementInventory(skuQuantities, new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with
   * {@code sku}, {@code quantity}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDecrementInventoryWithSkuQuantity() throws InventoryUnavailableException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1923 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();

    // Act
    inventoryServiceImpl2.decrementInventory(new SkuImpl(), 1);
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with
   * {@code sku}, {@code quantity}, {@code context}.
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDecrementInventoryWithSkuQuantityContext() throws InventoryUnavailableException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1953 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();
    SkuImpl sku = new SkuImpl();

    // Act
    inventoryServiceImpl2.decrementInventory(sku, 1, new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with
   * {@code skuQuantities}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIncrementInventoryWithSkuQuantities() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2003 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();

    // Act
    inventoryServiceImpl2.incrementInventory(new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with
   * {@code skuQuantities}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIncrementInventoryWithSkuQuantitiesContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2016 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl2.incrementInventory(skuQuantities, new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with
   * {@code sku}, {@code quantity}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIncrementInventoryWithSkuQuantity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2036 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();

    // Act
    inventoryServiceImpl2.incrementInventory(new SkuImpl(), 1);
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with
   * {@code sku}, {@code quantity}, {@code context}.
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIncrementInventoryWithSkuQuantityContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2066 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();
    SkuImpl sku = new SkuImpl();

    // Act
    inventoryServiceImpl2.incrementInventory(sku, 1, new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementSku(Map, Map)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIncrementSku() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2096 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl2.incrementSku(skuQuantities, new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementSku(Map, Map)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  public void testIncrementSku_givenZero_whenHashMapSkuImplIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementSku(skuQuantities, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementSku(Map, Map)}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#getInventoryType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  public void testIncrementSku_thenCallsGetInventoryType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 1);

    // Act
    inventoryServiceImpl.incrementSku(skuQuantities, new HashMap<>());

    // Assert
    verify(skuImpl).getInventoryType();
  }

  /**
   * Test {@link InventoryServiceImpl#incrementSku(Map, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is
   * {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  public void testIncrementSku_whenHashMapSkuImplIsNull_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementSku(skuQuantities, new HashMap<>()));
  }

  /**
   * Test
   * {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReconcileChangeOrderInventory() throws InventoryUnavailableException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2236 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();
    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl2.reconcileChangeOrderInventory(decrementSkuQuantities, incrementSkuQuantities,
        new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  public void testDecrementSku() throws InventoryUnavailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenThrow(
        new IllegalArgumentException("Not decrementing inventory as the Sku has been marked as always available"));
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.computeIfPresent(new SkuImpl(), mock(BiFunction.class));
    skuQuantities.put(skuImpl, 1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDecrementSku2() throws InventoryUnavailableException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1983 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl2.decrementSku(skuQuantities, new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return
   * {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  public void testDecrementSku_givenSkuImplGetInventoryTypeReturnAlways_available()
      throws InventoryUnavailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.computeIfPresent(new SkuImpl(), mock(BiFunction.class));
    skuQuantities.put(skuImpl, 1);

    // Act
    inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>());

    // Assert
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  public void testDecrementSku_givenSkuImplGetInventoryTypeReturnNull() throws InventoryUnavailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(null);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.computeIfPresent(new SkuImpl(), mock(BiFunction.class));
    skuQuantities.put(skuImpl, 1);

    // Act
    inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>());

    // Assert
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return
   * {@link InventoryType#UNAVAILABLE}.</li>
   *   <li>Then calls {@link SkuImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  public void testDecrementSku_givenSkuImplGetInventoryTypeReturnUnavailable_thenCallsGetId()
      throws InventoryUnavailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.computeIfPresent(new SkuImpl(), mock(BiFunction.class));
    skuQuantities.put(skuImpl, 1);

    // Act and Assert
    assertThrows(InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
    verify(skuImpl).getId();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   * <ul>
   *   <li>Given {@link SkuImpl}.</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  public void testDecrementSku_givenSkuImpl_whenHashMapSkuImplIsNull() throws InventoryUnavailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.computeIfPresent(new SkuImpl(), mock(BiFunction.class));
    skuQuantities.put(mock(SkuImpl.class), null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  public void testDecrementSku_givenZero_whenHashMapSkuImplIsZero() throws InventoryUnavailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.computeIfPresent(new SkuImpl(), mock(BiFunction.class));
    skuQuantities.put(mock(SkuImpl.class), 0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is
   * one.</li>
   *   <li>Then throw {@link InventoryUnavailableException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  public void testDecrementSku_whenHashMapSkuImplIsOne_thenThrowInventoryUnavailableException()
      throws InventoryUnavailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 1);

    // Act and Assert
    assertThrows(InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  public void testBuildSkuInventoryMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new IllegalArgumentException("foo"));
    when(bundleOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.buildSkuInventoryMap(order));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getSku();
    verify(order).getOrderItems();
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  public void testBuildSkuInventoryMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getQuantity()).thenThrow(new IllegalArgumentException("foo"));
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.buildSkuInventoryMap(order));
    verify(skuImpl).getInventoryType();
    verify(bundleOrderItemImpl).getSku();
    verify(order).getOrderItems();
    verify(bundleOrderItemImpl).getQuantity();
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  public void testBuildSkuInventoryMap3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getSku()).thenThrow(new IllegalArgumentException("foo"));

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(discreteOrderItemImpl);
    orderItemList.add(mock(BundleOrderItemImpl.class));
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.buildSkuInventoryMap(order));
    verify(discreteOrderItemImpl).getSku();
    verify(order).getOrderItems();
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildSkuInventoryMap4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1812 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();

    // Act
    inventoryServiceImpl2.buildSkuInventoryMap(new NullOrderImpl());
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  public void testBuildSkuInventoryMap_givenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    Map<Sku, Integer> actualBuildSkuInventoryMapResult = inventoryServiceImpl.buildSkuInventoryMap(order);

    // Assert
    verify(order).getOrderItems();
    assertTrue(actualBuildSkuInventoryMapResult.isEmpty());
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  public void testBuildSkuInventoryMap_givenBundleOrderItemImplGetSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act
    Map<Sku, Integer> actualBuildSkuInventoryMapResult = inventoryServiceImpl.buildSkuInventoryMap(order);

    // Assert
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getSku();
    verify(order).getOrderItems();
    assertTrue(actualBuildSkuInventoryMapResult.isEmpty());
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  public void testBuildSkuInventoryMap_givenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(inventoryServiceImpl.buildSkuInventoryMap(order).isEmpty());
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is
   * {@link Auditable} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  public void testBuildSkuInventoryMap_givenOrderItemImplAuditableIsAuditable_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(1L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new NullOrderImpl());
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(orderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act
    Map<Sku, Integer> actualBuildSkuInventoryMapResult = inventoryServiceImpl.buildSkuInventoryMap(order);

    // Assert
    verify(order).getOrderItems();
    assertTrue(actualBuildSkuInventoryMapResult.isEmpty());
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return
   * {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  public void testBuildSkuInventoryMap_givenSkuImplGetInventoryTypeReturnAlways_available() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act
    Map<Sku, Integer> actualBuildSkuInventoryMapResult = inventoryServiceImpl.buildSkuInventoryMap(order);

    // Assert
    verify(skuImpl).getInventoryType();
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getSku();
    verify(order).getOrderItems();
    assertTrue(actualBuildSkuInventoryMapResult.isEmpty());
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) InventoryType is
   * {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  public void testBuildSkuInventoryMap_givenSkuImplInventoryTypeIsAlways_available() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getQuantity()).thenReturn(1);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSku()).thenReturn(skuImpl2);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(discreteOrderItemImpl);
    orderItemList.add(bundleOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act
    Map<Sku, Integer> actualBuildSkuInventoryMapResult = inventoryServiceImpl.buildSkuInventoryMap(order);

    // Assert
    verify(skuImpl).getInventoryType();
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getSku();
    verify(discreteOrderItemImpl).getSku();
    verify(order).getOrderItems();
    verify(bundleOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getQuantity();
    assertEquals(1, actualBuildSkuInventoryMapResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  public void testBuildSkuInventoryMap_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getQuantity()).thenReturn(1);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act
    Map<Sku, Integer> actualBuildSkuInventoryMapResult = inventoryServiceImpl.buildSkuInventoryMap(order);

    // Assert
    verify(skuImpl).getInventoryType();
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getSku();
    verify(order).getOrderItems();
    verify(bundleOrderItemImpl).getQuantity();
    assertEquals(1, actualBuildSkuInventoryMapResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  public void testBuildSkuInventoryMap_thenReturnSizeIsOne2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getQuantity()).thenReturn(1);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(discreteOrderItemImpl);
    orderItemList.add(bundleOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act
    Map<Sku, Integer> actualBuildSkuInventoryMapResult = inventoryServiceImpl.buildSkuInventoryMap(order);

    // Assert
    verify(skuImpl).getInventoryType();
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getSku();
    verify(discreteOrderItemImpl).getSku();
    verify(order).getOrderItems();
    verify(bundleOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getQuantity();
    assertEquals(1, actualBuildSkuInventoryMapResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  public void testBuildSkuInventoryMap_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getQuantity()).thenReturn(1);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setInventoryType(InventoryType.CHECK_QUANTITY);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSku()).thenReturn(skuImpl2);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(discreteOrderItemImpl);
    orderItemList.add(bundleOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act
    Map<Sku, Integer> actualBuildSkuInventoryMapResult = inventoryServiceImpl.buildSkuInventoryMap(order);

    // Assert
    verify(skuImpl).getInventoryType();
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getSku();
    verify(discreteOrderItemImpl).getSku();
    verify(order).getOrderItems();
    verify(bundleOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getQuantity();
    assertEquals(2, actualBuildSkuInventoryMapResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#invalidateSkuInventory(Sku)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#invalidateSkuInventory(Sku)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInvalidateSkuInventory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2146 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();

    // Act
    inventoryServiceImpl2.invalidateSkuInventory(new SkuImpl());
  }

  /**
   * Test {@link InventoryServiceImpl#invalidateSkuInventory(Sku)}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#invalidateSkuInventory(Sku)}
   */
  @Test
  public void testInvalidateSkuInventory_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getId()).thenThrow(new IllegalArgumentException("CACHE_REGION"));

    // Act
    inventoryServiceImpl.invalidateSkuInventory(sku);

    // Assert
    verify(sku).getId();
  }

  /**
   * Test {@link InventoryServiceImpl#invalidateEntity(Class, String)}.
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#invalidateEntity(Class, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInvalidateEntity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2116 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();
    Class<Object> clazz = Object.class;

    // Act
    inventoryServiceImpl2.invalidateEntity(clazz, "42");
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckSkuAvailability() throws InventoryUnavailableException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.inventory.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1860 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.inventory.service.InventoryServiceImpl inventoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl2 = new InventoryServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    inventoryServiceImpl2.checkSkuAvailability(order, new SkuImpl(), 1);
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  public void testCheckSkuAvailability_givenAlways_available() throws InventoryUnavailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    NullOrderImpl order = new NullOrderImpl();
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(sku.isAvailable()).thenReturn(true);

    // Act
    inventoryServiceImpl.checkSkuAvailability(order, sku, 1);

    // Assert
    verify(sku).getInventoryType();
    verify(sku).isAvailable();
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then throw {@link InventoryUnavailableException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  public void testCheckSkuAvailability_givenFalse_thenThrowInventoryUnavailableException()
      throws InventoryUnavailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    NullOrderImpl order = new NullOrderImpl();
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.isAvailable()).thenReturn(false);
    when(sku.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(InventoryUnavailableException.class, () -> inventoryServiceImpl.checkSkuAvailability(order, sku, 1));
    verify(sku, atLeast(1)).getId();
    verify(sku).isAvailable();
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  public void testCheckSkuAvailability_givenIllegalArgumentExceptionWithFoo() throws InventoryUnavailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    NullOrderImpl order = new NullOrderImpl();
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenThrow(new IllegalArgumentException("foo"));
    when(sku.isAvailable()).thenReturn(true);

    // Act
    inventoryServiceImpl.checkSkuAvailability(order, sku, 1);

    // Assert
    verify(sku).getInventoryType();
    verify(sku).isAvailable();
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#isActive()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  public void testCheckSkuAvailability_thenCallsIsActive() throws InventoryUnavailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    NullOrderImpl order = new NullOrderImpl();
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.isActive()).thenThrow(new IllegalArgumentException(ContextualInventoryService.ORDER_KEY));
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isAvailable()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.checkSkuAvailability(order, sku, 1));
    verify(sku).getInventoryType();
    verify(sku).isActive();
    verify(sku).isAvailable();
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  public void testCheckSkuAvailability_whenZero_thenThrowIllegalArgumentException()
      throws InventoryUnavailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    NullOrderImpl order = new NullOrderImpl();
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isAvailable()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.checkSkuAvailability(order, sku, 0));
    verify(sku).getInventoryType();
    verify(sku).isAvailable();
  }
}
