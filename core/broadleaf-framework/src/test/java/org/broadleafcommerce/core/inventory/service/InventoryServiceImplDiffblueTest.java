/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.inventory.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

@RunWith(MockitoJUnitRunner.class)
public class InventoryServiceImplDiffblueTest {
  @Mock
  private ApplicationContext applicationContext;

  @Mock
  private CatalogService catalogService;

  @Mock
  private InventoryServiceExtensionManager inventoryServiceExtensionManager;

  @InjectMocks
  private InventoryServiceImpl inventoryServiceImpl;

  /**
   * Test {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.checkBasicAvailablility(Sku)"})
  public void testCheckBasicAvailablility() {
    // Arrange
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
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.checkBasicAvailablility(Sku)"})
  public void testCheckBasicAvailablility_givenAlways_available() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.checkBasicAvailablility(Sku)"})
  public void testCheckBasicAvailablility_givenNull_whenSkuGetInventoryTypeReturnNull() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.checkBasicAvailablility(Sku)"})
  public void testCheckBasicAvailablility_givenUnavailable() {
    // Arrange
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
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.checkBasicAvailablility(Sku)"})
  public void testCheckBasicAvailablility_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(inventoryServiceImpl.checkBasicAvailablility(null));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.checkBasicAvailablility(Sku)"})
  public void testCheckBasicAvailablility_whenSkuImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(inventoryServiceImpl.checkBasicAvailablility(new SkuImpl()));
  }

  /**
   * Test {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}.
   * <ul>
   *   <li>When {@link Sku} {@link Sku#isActive()} throw {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.checkBasicAvailablility(Sku)"})
  public void testCheckBasicAvailablility_whenSkuIsActiveThrowIllegalArgumentExceptionWithFoo() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.isActive()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.checkBasicAvailablility(sku));
    verify(sku).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)} with {@code sku}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku, Map)"})
  public void testRetrieveQuantityAvailableWithSkuContext() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getQuantityAvailable()).thenReturn(null);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(sku,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).getQuantityAvailable();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)} with {@code sku}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku, Map)"})
  public void testRetrieveQuantityAvailableWithSkuContext2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(null);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(sku,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantityAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)} with {@code sku}, {@code context}.
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku, Map)"})
  public void testRetrieveQuantityAvailableWithSkuContext_givenAlways_available() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(sku,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantityAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)} with {@code sku}, {@code context}.
   * <ul>
   *   <li>Given {@link InventoryType#InventoryType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku, Map)"})
  public void testRetrieveQuantityAvailableWithSkuContext_givenInventoryType() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(new InventoryType());
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(sku,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)} with {@code sku}, {@code context}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku, Map)"})
  public void testRetrieveQuantityAvailableWithSkuContext_givenOne_thenReturnIntValueIsOne() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getQuantityAvailable()).thenReturn(1);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(sku,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku, atLeast(1)).getQuantityAvailable();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)} with {@code sku}, {@code context}.
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku, Map)"})
  public void testRetrieveQuantityAvailableWithSkuContext_givenUnavailable() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(sku,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)} with {@code sku}, {@code context}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku, Map)"})
  public void testRetrieveQuantityAvailableWithSkuContext_thenThrowIllegalArgumentException() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantityAvailable(sku, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)} with {@code sku}, {@code context}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku, Map)"})
  public void testRetrieveQuantityAvailableWithSkuContext_whenNull_thenReturnIntValueIsZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(null,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)} with {@code sku}, {@code context}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku, Map)"})
  public void testRetrieveQuantityAvailableWithSkuContext_whenSkuImpl_thenReturnIntValueIsZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(sku,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_givenAlways_available() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(sku);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantityAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   * <ul>
   *   <li>Given {@link InventoryType#InventoryType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_givenInventoryType() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(new InventoryType());
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(sku);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_givenOne_thenReturnIntValueIsOne() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getQuantityAvailable()).thenReturn(1);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(sku);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku, atLeast(1)).getQuantityAvailable();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_givenUnavailable() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(sku);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_thenThrowIllegalArgumentException() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.retrieveQuantityAvailable(new SkuImpl()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_whenNull_thenReturnIntValueIsZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(null);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   * <ul>
   *   <li>When {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_whenSkuImplGetInventoryTypeReturnNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(null);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(sku);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantityAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   * <ul>
   *   <li>When {@link SkuImpl} {@link SkuImpl#getQuantityAvailable()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_whenSkuImplGetQuantityAvailableReturnNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getQuantityAvailable()).thenReturn(null);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(sku);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).getQuantityAvailable();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_whenSkuImpl_thenReturnIntValueIsZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    Integer actualRetrieveQuantityAvailableResult = inventoryServiceImpl.retrieveQuantityAvailable(new SkuImpl());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(new ArrayList<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenThrow(new IllegalArgumentException("foo"));
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.retrieveQuantitiesAvailable(skus));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus4() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getQuantityAvailable()).thenReturn(1);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl, atLeast(1)).getQuantityAvailable();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus5() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getQuantityAvailable()).thenReturn(null);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getQuantityAvailable();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus6() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus7() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(new InventoryType());
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus8() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getQuantityAvailable()).thenThrow(new IllegalArgumentException("UNAVAILABLE"));
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.retrieveQuantitiesAvailable(skus));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getQuantityAvailable();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    ArrayList<Sku> skus = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenThrow(new IllegalArgumentException("foo"));
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext4() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getQuantityAvailable()).thenReturn(1);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl, atLeast(1)).getQuantityAvailable();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext5() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getQuantityAvailable()).thenReturn(null);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getQuantityAvailable();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext6() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext7() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(new InventoryType());
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext8() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(null);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext9() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getQuantityAvailable()).thenThrow(new IllegalArgumentException("UNAVAILABLE"));
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getQuantityAvailable();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext_givenSkuImpl() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(new SkuImpl());

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext_thenReturnNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    ArrayList<Sku> skus = new ArrayList<>();

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantitiesAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext_thenReturnNull2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(new SkuImpl());

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantitiesAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext_thenReturnNull3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(new SkuImpl());
    skus.add(new SkuImpl());

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantitiesAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <ul>
   *   <li>Then return {@code null} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext_thenReturnNullIntValueIsZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(null);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
    assertEquals(0, actualRetrieveQuantitiesAvailableResult.get(null).intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code skus}, {@code context}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext_whenArrayList_thenReturnEmpty() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    ArrayList<Sku> skus = new ArrayList<>();

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus,
        new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertTrue(actualRetrieveQuantitiesAvailableResult.isEmpty());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@code null} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus_givenNull_thenReturnNullIntValueIsZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(null);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
    assertEquals(0, actualRetrieveQuantitiesAvailableResult.get(null).intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus_givenSkuImplGetInventoryTypeReturnNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(null);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus_givenSkuImpl_whenArrayListAddSkuImpl() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(new SkuImpl());

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus_thenReturnNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl
        .retrieveQuantitiesAvailable(new ArrayList<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantitiesAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus_thenReturnNull2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(new SkuImpl());

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantitiesAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus_thenReturnNull3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(new SkuImpl());
    skus.add(new SkuImpl());

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantitiesAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus_whenArrayList_thenReturnEmpty() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult = inventoryServiceImpl
        .retrieveQuantitiesAvailable(new ArrayList<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertTrue(actualRetrieveQuantitiesAvailableResult.isEmpty());
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("UNAVAILABLE"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.isAvailable(sku, 1));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int, Map)"})
  public void testIsAvailableWithSkuQuantityContext() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("UNAVAILABLE"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.isAvailable(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int, Map)"})
  public void testIsAvailableWithSkuQuantityContext_givenAlways_available() {
    // Arrange
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
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int, Map)"})
  public void testIsAvailableWithSkuQuantityContext_givenIllegalArgumentExceptionWithFoo() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenThrow(new IllegalArgumentException("foo"));
    when(sku.isActive()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.isAvailable(sku, 1, new HashMap<>()));
    verify(sku).getInventoryType();
    verify(sku).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int, Map)"})
  public void testIsAvailableWithSkuQuantityContext_givenNull() {
    // Arrange
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
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int, Map)"})
  public void testIsAvailableWithSkuQuantityContext_givenUnavailable() {
    // Arrange
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
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>Then calls {@link Sku#getQuantityAvailable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int, Map)"})
  public void testIsAvailableWithSkuQuantityContext_thenCallsGetQuantityAvailable() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    Sku sku = mock(Sku.class);
    when(sku.getQuantityAvailable()).thenReturn(1);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act
    boolean actualIsAvailableResult = inventoryServiceImpl.isAvailable(sku, 1, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku, atLeast(1)).getQuantityAvailable();
    verify(sku, atLeast(1)).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
    assertTrue(actualIsAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int, Map)"})
  public void testIsAvailableWithSkuQuantityContext_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(inventoryServiceImpl.isAvailable(null, 1, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int, Map)"})
  public void testIsAvailableWithSkuQuantityContext_whenSkuImpl_thenReturnFalse() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertFalse(inventoryServiceImpl.isAvailable(sku, 1, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>When {@link Sku}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int, Map)"})
  public void testIsAvailableWithSkuQuantityContext_whenSku_thenThrowIllegalArgumentException() {
    // Arrange
    Sku sku = mock(Sku.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.isAvailable(sku, 0, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_givenAlways_available() {
    // Arrange
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
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_givenIllegalArgumentExceptionWithFoo() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenThrow(new IllegalArgumentException("foo"));
    when(sku.isActive()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.isAvailable(sku, 1));
    verify(sku).getInventoryType();
    verify(sku).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_givenIllegalArgumentExceptionWithUnavailable() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    Sku sku = mock(Sku.class);
    when(sku.getQuantityAvailable()).thenThrow(new IllegalArgumentException("UNAVAILABLE"));
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.isAvailable(sku, 1));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).getQuantityAvailable();
    verify(sku, atLeast(1)).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Sku} {@link Sku#getInventoryType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_givenNull_whenSkuGetInventoryTypeReturnNull() {
    // Arrange
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
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Sku} {@link Sku#getQuantityAvailable()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_givenNull_whenSkuGetQuantityAvailableReturnNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    Sku sku = mock(Sku.class);
    when(sku.getQuantityAvailable()).thenReturn(null);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act
    boolean actualIsAvailableResult = inventoryServiceImpl.isAvailable(sku, 1);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).getQuantityAvailable();
    verify(sku, atLeast(1)).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertFalse(actualIsAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link Sku} {@link Sku#getQuantityAvailable()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_givenOne_whenSkuGetQuantityAvailableReturnOne() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    Sku sku = mock(Sku.class);
    when(sku.getQuantityAvailable()).thenReturn(1);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act
    boolean actualIsAvailableResult = inventoryServiceImpl.isAvailable(sku, 1);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku, atLeast(1)).getQuantityAvailable();
    verify(sku, atLeast(1)).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertTrue(actualIsAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_givenUnavailable() {
    // Arrange
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
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link Sku} {@link Sku#getQuantityAvailable()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_givenZero_whenSkuGetQuantityAvailableReturnZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    Sku sku = mock(Sku.class);
    when(sku.getQuantityAvailable()).thenReturn(0);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act
    boolean actualIsAvailableResult = inventoryServiceImpl.isAvailable(sku, 1);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku, atLeast(1)).getQuantityAvailable();
    verify(sku, atLeast(1)).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
    assertFalse(actualIsAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(inventoryServiceImpl.isAvailable(null, 1));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_whenSkuImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(inventoryServiceImpl.isAvailable(new SkuImpl(), 1));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>When {@link Sku}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_whenSku_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.isAvailable(mock(Sku.class), 0));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.decrementInventory(new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities2() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.decrementInventory(new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities3() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act
    inventoryServiceImpl.decrementInventory(skuQuantities);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities4() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenThrow(
        new IllegalArgumentException("Not decrementing inventory as the Sku has been marked as always available"));
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.decrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext2() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext3() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act
    inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext4() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenThrow(
        new IllegalArgumentException("Not decrementing inventory as the Sku has been marked as always available"));
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext5() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(null);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act
    inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext6() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("UNAVAILABLE"));
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext_givenSkuImpl() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 2);

    // Act and Assert
    assertThrows(InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext_givenZero() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(mock(SkuImpl.class), 0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext_thenCallsGetId() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getId();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext_thenCallsGetProxy() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext_whenHashMapSkuImplIsNull()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(mock(SkuImpl.class), null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_givenSkuImplGetInventoryTypeReturnNull()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(null);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act
    inventoryServiceImpl.decrementInventory(skuQuantities);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   * <ul>
   *   <li>Given {@link SkuImpl}.</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_givenSkuImpl_whenHashMapSkuImplIsNull()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(mock(SkuImpl.class), null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.decrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_givenSkuImpl_whenHashMapSkuImplIsTwo()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 2);

    // Act and Assert
    assertThrows(InventoryUnavailableException.class, () -> inventoryServiceImpl.decrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_givenZero_whenHashMapSkuImplIsZero()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(mock(SkuImpl.class), 0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.decrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_thenCallsGetId() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(InventoryUnavailableException.class, () -> inventoryServiceImpl.decrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getId();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   * <ul>
   *   <li>Then calls {@link InventoryServiceExtensionHandler#retrieveQuantitiesAvailable(Collection, Map, ExtensionResultHolder)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_thenCallsRetrieveQuantitiesAvailable()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("UNAVAILABLE"));
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.decrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_whenHashMap_thenCallsGetProxy()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.decrementInventory(new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.decrementInventory(new SkuImpl(), 1);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity2() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.decrementInventory(new SkuImpl(), 1));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act
    inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext2() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext3() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertThrows(InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext4() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("UNAVAILABLE"));
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext_givenAlways_available()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext_givenNull() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(null);
    when(sku.isActive()).thenReturn(true);

    // Act
    inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.</li>
   *   <li>Then calls {@link SkuImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext_givenUnavailable_thenCallsGetId()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(sku.isActive()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku).getId();
    verify(sku).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>When {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext_whenSkuImpl() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(sku, 0, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity_givenAlways_available() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    inventoryServiceImpl.decrementInventory(sku, 1);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity_givenNull() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(null);
    when(sku.isActive()).thenReturn(true);

    // Act
    inventoryServiceImpl.decrementInventory(sku, 1);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.</li>
   *   <li>Then calls {@link SkuImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity_givenUnavailable_thenCallsGetId()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(sku.isActive()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(InventoryUnavailableException.class, () -> inventoryServiceImpl.decrementInventory(sku, 1));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku).getId();
    verify(sku).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Then calls {@link InventoryServiceExtensionHandler#retrieveQuantitiesAvailable(Collection, Map, ExtensionResultHolder)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity_thenCallsRetrieveQuantitiesAvailable()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("UNAVAILABLE"));
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.decrementInventory(sku, 1));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Then throw {@link InventoryUnavailableException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity_thenThrowInventoryUnavailableException()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(InventoryUnavailableException.class, () -> inventoryServiceImpl.decrementInventory(new SkuImpl(), 1));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>When {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity_whenSkuImpl() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.decrementInventory(mock(SkuImpl.class), 0));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.incrementInventory(new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.incrementInventory(new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act
    inventoryServiceImpl.incrementInventory(skuQuantities);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map, Map)"})
  public void testIncrementInventoryWithSkuQuantitiesContext() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.incrementInventory(skuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map, Map)"})
  public void testIncrementInventoryWithSkuQuantitiesContext2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map, Map)"})
  public void testIncrementInventoryWithSkuQuantitiesContext3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.incrementInventory(skuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with {@code skuQuantities}, {@code context}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map, Map)"})
  public void testIncrementInventoryWithSkuQuantitiesContext_givenSkuImpl() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   * <ul>
   *   <li>Given {@link SkuImpl}.</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities_givenSkuImpl_whenHashMapSkuImplIsNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(mock(SkuImpl.class), null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.incrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities_givenSkuImpl_whenHashMapSkuImplIsTwo() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 2);

    // Act
    inventoryServiceImpl.incrementInventory(skuQuantities);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities_givenZero_whenHashMapSkuImplIsZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.incrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   * <ul>
   *   <li>Then calls {@link InventoryServiceExtensionHandler#retrieveQuantitiesAvailable(Collection, Map, ExtensionResultHolder)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities_thenCallsRetrieveQuantitiesAvailable() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.incrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(skuImpl).getInventoryType();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities_whenHashMap_thenCallsGetProxy() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.incrementInventory(new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.incrementInventory(new SkuImpl(), 1);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.incrementInventory(new SkuImpl(), 1));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.incrementInventory(sku, 1));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku).getInventoryType();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isNull(),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int, Map)"})
  public void testIncrementInventoryWithSkuQuantityContext() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act
    inventoryServiceImpl.incrementInventory(sku, 1, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int, Map)"})
  public void testIncrementInventoryWithSkuQuantityContext2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int, Map)"})
  public void testIncrementInventoryWithSkuQuantityContext3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku).getInventoryType();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int, Map)"})
  public void testIncrementInventoryWithSkuQuantityContext_givenAlways_available() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);

    // Act
    inventoryServiceImpl.incrementInventory(sku, 1, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku).getInventoryType();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>When {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int, Map)"})
  public void testIncrementInventoryWithSkuQuantityContext_whenSkuImpl() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(sku, 0, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with {@code sku}, {@code quantity}, {@code context}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int, Map)"})
  public void testIncrementInventoryWithSkuQuantityContext_whenSkuImpl_thenCallsGetProxy() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act
    inventoryServiceImpl.incrementInventory(sku, 1, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity_givenAlways_available() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);

    // Act
    inventoryServiceImpl.incrementInventory(sku, 1);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku).getInventoryType();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>Given {@link ApplicationContext}.</li>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity_givenApplicationContext_whenSkuImpl() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.incrementInventory(new SkuImpl(), 1);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code quantity}.
   * <ul>
   *   <li>When {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity_whenSkuImpl() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<String, Object>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.incrementInventory(mock(SkuImpl.class), 0));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementSku(Map, Map)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementSku(Map, Map)"})
  public void testIncrementSku() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementSku(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementSku(Map, Map)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementSku(Map, Map)"})
  public void testIncrementSku2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getQuantityAvailable()).thenThrow(new IllegalArgumentException("UNAVAILABLE"));
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementSku(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getQuantityAvailable();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementSku(Map, Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementSku(Map, Map)"})
  public void testIncrementSku_givenNull_whenHashMapSkuImplIsNull() {
    // Arrange
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementSku(skuQuantities, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementSku(Map, Map)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementSku(Map, Map)"})
  public void testIncrementSku_givenSkuImplGetInventoryTypeReturnAlways_available() {
    // Arrange
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
   *   <li>Given zero.</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.incrementSku(Map, Map)"})
  public void testIncrementSku_givenZero_whenHashMapSkuImplIsZero() {
    // Arrange
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementSku(skuQuantities, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.reconcileChangeOrderInventory(decrementSkuQuantities, incrementSkuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).reconcileChangeOrderInventory(isA(Map.class), isA(Map.class),
        isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory2() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl
        .reconcileChangeOrderInventory(decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).reconcileChangeOrderInventory(isA(Map.class), isA(Map.class),
        isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory3() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(skuImpl, 3);
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.reconcileChangeOrderInventory(decrementSkuQuantities, incrementSkuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).reconcileChangeOrderInventory(isA(Map.class), isA(Map.class),
        isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory4() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenThrow(
        new IllegalArgumentException("Not decrementing inventory as the Sku has been marked as always available"));
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(skuImpl, 3);
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl
        .reconcileChangeOrderInventory(decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).reconcileChangeOrderInventory(isA(Map.class), isA(Map.class),
        isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   * <ul>
   *   <li>Given {@link SkuImpl}.</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_givenSkuImpl_whenHashMapSkuImplIsNull()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(mock(SkuImpl.class), null);
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl
        .reconcileChangeOrderInventory(decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).reconcileChangeOrderInventory(isA(Map.class), isA(Map.class),
        isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_givenSkuImpl_whenHashMapSkuImplIsThree()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();

    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();
    incrementSkuQuantities.put(new SkuImpl(), 3);

    // Act
    inventoryServiceImpl.reconcileChangeOrderInventory(decrementSkuQuantities, incrementSkuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).reconcileChangeOrderInventory(isA(Map.class), isA(Map.class),
        isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_givenZero_whenHashMapSkuImplIsZero()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(mock(SkuImpl.class), 0);
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl
        .reconcileChangeOrderInventory(decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).reconcileChangeOrderInventory(isA(Map.class), isA(Map.class),
        isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_thenCallsGetId() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(skuImpl, 3);
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(InventoryUnavailableException.class, () -> inventoryServiceImpl
        .reconcileChangeOrderInventory(decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getId();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).reconcileChangeOrderInventory(isA(Map.class), isA(Map.class),
        isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_thenCallsGetProxy() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.reconcileChangeOrderInventory(decrementSkuQuantities, incrementSkuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).reconcileChangeOrderInventory(isA(Map.class), isA(Map.class),
        isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   * <ul>
   *   <li>Then calls {@link InventoryServiceExtensionHandler#retrieveQuantitiesAvailable(Collection, Map, ExtensionResultHolder)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_thenCallsRetrieveQuantitiesAvailable()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("UNAVAILABLE"));
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(skuImpl, 3);
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl
        .reconcileChangeOrderInventory(decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).reconcileChangeOrderInventory(isA(Map.class), isA(Map.class),
        isA(Map.class));
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   * <ul>
   *   <li>Then throw {@link InventoryUnavailableException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_thenThrowInventoryUnavailableException()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(Mockito.<Map<Sku, Integer>>any(),
        Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(new SkuImpl(), 3);
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(InventoryUnavailableException.class, () -> inventoryServiceImpl
        .reconcileChangeOrderInventory(decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).reconcileChangeOrderInventory(isA(Map.class), isA(Map.class),
        isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku() throws InventoryUnavailableException {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenThrow(
        new IllegalArgumentException("Not decrementing inventory as the Sku has been marked as always available"));
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
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
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_givenNull_whenHashMapSkuImplIsNull() throws InventoryUnavailableException {
    // Arrange
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_givenSkuImplGetInventoryTypeReturnAlways_available()
      throws InventoryUnavailableException {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
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
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_givenSkuImplGetInventoryTypeReturnNull() throws InventoryUnavailableException {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(null);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
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
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@link InventoryType#UNAVAILABLE}.</li>
   *   <li>Then calls {@link SkuImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_givenSkuImplGetInventoryTypeReturnUnavailable_thenCallsGetId()
      throws InventoryUnavailableException {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
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
   *   <li>Given zero.</li>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_givenZero_whenHashMapSkuImplIsZero() throws InventoryUnavailableException {
    // Arrange
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_thenCallsGetProxy() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler = mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(Mockito.<Collection<Sku>>any(),
        Mockito.<Map<String, Object>>any(), Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException("UNAVAILABLE"));
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).retrieveQuantitiesAvailable(isA(Collection.class), isA(Map.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is one.</li>
   *   <li>Then throw {@link InventoryUnavailableException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_whenHashMapSkuImplIsOne_thenThrowInventoryUnavailableException()
      throws InventoryUnavailableException {
    // Arrange
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 1);

    // Act and Assert
    assertThrows(InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map InventoryServiceImpl.buildSkuInventoryMap(Order)"})
  public void testBuildSkuInventoryMap_givenAuditableCreatedByIsOne_thenReturnEmpty() {
    // Arrange
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
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(inventoryServiceImpl.buildSkuInventoryMap(order).isEmpty());
  }

  /**
   * Test {@link InventoryServiceImpl#invalidateSkuInventory(Sku)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#invalidateSkuInventory(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.invalidateSkuInventory(Sku)"})
  public void testInvalidateSkuInventory_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("CACHE_REGION")).when(applicationContext)
        .publishEvent(Mockito.<ApplicationEvent>any());
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> inventoryServiceImpl.invalidateSkuInventory(sku));
    verify(sku).getId();
    verify(applicationContext).publishEvent(isA(ApplicationEvent.class));
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.checkSkuAvailability(Order, Sku, Integer)"})
  public void testCheckSkuAvailability_givenAlways_available() throws InventoryUnavailableException {
    // Arrange
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
   * Method under test: {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.checkSkuAvailability(Order, Sku, Integer)"})
  public void testCheckSkuAvailability_givenFalse_thenThrowInventoryUnavailableException()
      throws InventoryUnavailableException {
    // Arrange
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
   * Method under test: {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.checkSkuAvailability(Order, Sku, Integer)"})
  public void testCheckSkuAvailability_thenCallsIsActive() throws InventoryUnavailableException {
    // Arrange
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
   * Method under test: {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryServiceImpl.checkSkuAvailability(Order, Sku, Integer)"})
  public void testCheckSkuAvailability_whenZero_thenThrowIllegalArgumentException()
      throws InventoryUnavailableException {
    // Arrange
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
