/*-
 * #%L
 * BroadleafCommerce Framework
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
import org.junit.Test;

public class InventoryServiceImplDiffblueTest {
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
