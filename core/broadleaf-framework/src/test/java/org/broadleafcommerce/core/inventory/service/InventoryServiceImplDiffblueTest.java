package org.broadleafcommerce.core.inventory.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.util.DimensionUnitOfMeasureType;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.broadleafcommerce.common.vendor.service.type.ContainerShapeType;
import org.broadleafcommerce.common.vendor.service.type.ContainerSizeType;
import org.broadleafcommerce.core.catalog.domain.Dimension;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.domain.Weight;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
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
  @Mock private ApplicationContext applicationContext;

  @Mock private CatalogService catalogService;

  @Mock private InventoryServiceExtensionManager inventoryServiceExtensionManager;

  @InjectMocks private InventoryServiceImpl inventoryServiceImpl;

  /**
   * Test {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}.
   *
   * <ul>
   *   <li>Given {@link InventoryServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryServiceImpl.checkBasicAvailablility(Sku)"})
  public void testCheckBasicAvailablility_givenInventoryServiceImpl_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new InventoryServiceImpl().checkBasicAvailablility(null));
  }

  /**
   * Test {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}.
   *
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryServiceImpl.checkBasicAvailablility(Sku)"})
  public void testCheckBasicAvailablility_givenUnavailable() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    SkuImpl sku = new SkuImpl();
    sku.setInventoryType(InventoryType.UNAVAILABLE);
    sku.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(inventoryServiceImpl.checkBasicAvailablility(sku));
  }

  /**
   * Test {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#checkBasicAvailablility(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryServiceImpl.checkBasicAvailablility(Sku)"})
  public void testCheckBasicAvailablility_whenSkuImpl_thenReturnFalse() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    // Act and Assert
    assertFalse(inventoryServiceImpl.checkBasicAvailablility(new SkuImpl()));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku() {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantityAvailable(new SkuImpl()));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.isActive()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> inventoryServiceImpl.retrieveQuantityAvailable(sku));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)} with {@code sku}, {@code
   * context}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku, Map)"})
  public void testRetrieveQuantityAvailableWithSkuContext_thenThrowIllegalArgumentException() {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantityAvailable(sku, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   *
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_givenAlways_available() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult =
        inventoryServiceImpl.retrieveQuantityAvailable(sku);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantityAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   *
   * <ul>
   *   <li>Given {@link InventoryType#InventoryType()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_givenInventoryType() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(new InventoryType());
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult =
        inventoryServiceImpl.retrieveQuantityAvailable(sku);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_givenOne_thenReturnIntValueIsOne() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getQuantityAvailable()).thenReturn(1);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult =
        inventoryServiceImpl.retrieveQuantityAvailable(sku);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku, atLeast(1)).getQuantityAvailable();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   *
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_givenUnavailable() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult =
        inventoryServiceImpl.retrieveQuantityAvailable(sku);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_whenNull_thenReturnIntValueIsZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    Integer actualRetrieveQuantityAvailableResult =
        inventoryServiceImpl.retrieveQuantityAvailable(null);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_whenSkuImplGetInventoryTypeReturnNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(null);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult =
        inventoryServiceImpl.retrieveQuantityAvailable(sku);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantityAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} {@link SkuImpl#getQuantityAvailable()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_whenSkuImplGetQuantityAvailableReturnNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getQuantityAvailable()).thenReturn(null);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act
    Integer actualRetrieveQuantityAvailableResult =
        inventoryServiceImpl.retrieveQuantityAvailable(sku);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).getQuantityAvailable();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)} with {@code sku}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantityAvailable(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer InventoryServiceImpl.retrieveQuantityAvailable(Sku)"})
  public void testRetrieveQuantityAvailableWithSku_whenSkuImpl_thenReturnIntValueIsZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    Integer actualRetrieveQuantityAvailableResult =
        inventoryServiceImpl.retrieveQuantityAvailable(new SkuImpl());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(0, actualRetrieveQuantityAvailableResult.intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus() {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(new ArrayList<>()));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(new ArrayList<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isActive()).thenThrow(new IllegalArgumentException());

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(skus));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus4() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus5() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenThrow(new IllegalArgumentException());
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(skus));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus6() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getQuantityAvailable()).thenReturn(1);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl, atLeast(1)).getQuantityAvailable();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus7() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getQuantityAvailable()).thenThrow(new IllegalArgumentException());
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(skus));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getQuantityAvailable();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus8() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus9() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(new InventoryType());
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus10() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getQuantityAvailable()).thenReturn(null);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getQuantityAvailable();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext() {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());
    ArrayList<Sku> skus = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    ArrayList<Sku> skus = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isActive()).thenThrow(new IllegalArgumentException());

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext4() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext5() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenThrow(new IllegalArgumentException());
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext6() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getQuantityAvailable()).thenReturn(1);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl, atLeast(1)).getQuantityAvailable();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext7() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getQuantityAvailable()).thenThrow(new IllegalArgumentException());
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getQuantityAvailable();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext8() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext9() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(new InventoryType());
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext10() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(null);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext11() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getQuantityAvailable()).thenReturn(null);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getQuantityAvailable();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext_givenSkuImpl() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(new SkuImpl());

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext_givenSkuImpl2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(new SkuImpl());
    skus.add(new SkuImpl());

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext_thenReturnNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    ArrayList<Sku> skus = new ArrayList<>();

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantitiesAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <ul>
   *   <li>Then return {@code null} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext_thenReturnNullIntValueIsZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(null);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
    assertEquals(0, actualRetrieveQuantitiesAvailableResult.get(null).intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)} with {@code
   * skus}, {@code context}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection, Map)"})
  public void testRetrieveQuantitiesAvailableWithSkusContext_whenArrayList_thenReturnEmpty() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    ArrayList<Sku> skus = new ArrayList<>();

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
    assertTrue(actualRetrieveQuantitiesAvailableResult.isEmpty());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@code null} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus_givenNull_thenReturnNullIntValueIsZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(null);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
    assertEquals(0, actualRetrieveQuantitiesAvailableResult.get(null).intValue());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus_givenSkuImplGetInventoryTypeReturnNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(null);
    when(skuImpl.isActive()).thenReturn(true);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(skuImpl);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus_givenSkuImpl_whenArrayListAddSkuImpl() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(new SkuImpl());

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus_givenSkuImpl_whenArrayListAddSkuImpl2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(new SkuImpl());
    skus.add(new SkuImpl());

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(skus);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertEquals(1, actualRetrieveQuantitiesAvailableResult.size());
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus_thenReturnNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(new ArrayList<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertNull(actualRetrieveQuantitiesAvailableResult);
  }

  /**
   * Test {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)} with {@code skus}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#retrieveQuantitiesAvailable(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.retrieveQuantitiesAvailable(Collection)"})
  public void testRetrieveQuantitiesAvailableWithSkus_whenArrayList_thenReturnEmpty() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    Map<Sku, Integer> actualRetrieveQuantitiesAvailableResult =
        inventoryServiceImpl.retrieveQuantitiesAvailable(new ArrayList<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    assertTrue(actualRetrieveQuantitiesAvailableResult.isEmpty());
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int, Map)"})
  public void testIsAvailableWithSkuQuantityContext_givenUnavailable() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    SkuImpl sku = new SkuImpl();
    sku.setInventoryType(InventoryType.UNAVAILABLE);
    sku.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(inventoryServiceImpl.isAvailable(sku, 1, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int, Map)"})
  public void testIsAvailableWithSkuQuantityContext_whenNull_thenReturnFalse() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    // Act and Assert
    assertFalse(inventoryServiceImpl.isAvailable(null, 1, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int, Map)"})
  public void testIsAvailableWithSkuQuantityContext_whenSkuImpl_thenReturnFalse() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertFalse(inventoryServiceImpl.isAvailable(sku, 1, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int, Map)"})
  public void testIsAvailableWithSkuQuantityContext_whenZero_thenThrowIllegalArgumentException() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.isAvailable(sku, 0, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   *
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_givenUnavailable() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    SkuImpl sku = new SkuImpl();
    sku.setInventoryType(InventoryType.UNAVAILABLE);
    sku.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(inventoryServiceImpl.isAvailable(sku, 1));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new InventoryServiceImpl().isAvailable(null, 1));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_whenSkuImpl_thenReturnFalse() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    // Act and Assert
    assertFalse(inventoryServiceImpl.isAvailable(new SkuImpl(), 1));
  }

  /**
   * Test {@link InventoryServiceImpl#isAvailable(Sku, int)} with {@code sku}, {@code quantity}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#isAvailable(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryServiceImpl.isAvailable(Sku, int)"})
  public void testIsAvailableWithSkuQuantity_whenZero_thenThrowIllegalArgumentException() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> inventoryServiceImpl.isAvailable(new SkuImpl(), 0));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities() throws InventoryUnavailableException {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities2() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.decrementInventory(new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities3() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities4() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isActive()).thenThrow(new IllegalArgumentException());

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities5() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
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
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities6() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenThrow(new IllegalArgumentException());
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext()
      throws InventoryUnavailableException {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext2()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext3()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext4()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isActive()).thenThrow(new IllegalArgumentException());

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext5()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
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
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext6()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenThrow(new IllegalArgumentException());
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext7()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext8()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
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
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext_givenSkuImpl()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 2);

    // Act and Assert
    assertThrows(
        InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext_givenZero()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(mock(SkuImpl.class), 0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <ul>
   *   <li>Then calls {@link InventoryServiceExtensionHandler#decrementInventory(Map, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext_thenCallsDecrementInventory()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <ul>
   *   <li>Then calls {@link SkuImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext_thenCallsGetId()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(
        InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getId();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map, Map)"})
  public void testDecrementInventoryWithSkuQuantitiesContext_whenHashMapSkuImplIsNull()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(mock(SkuImpl.class), null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_givenSkuImplGetInventoryTypeReturnNull()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
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
   *
   * <ul>
   *   <li>Given {@link SkuImpl}.
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_givenSkuImpl_whenHashMapSkuImplIsNull()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(mock(SkuImpl.class), null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is two.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_givenSkuImpl_whenHashMapSkuImplIsTwo()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 2);

    // Act and Assert
    assertThrows(
        InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is zero.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_givenZero_whenHashMapSkuImplIsZero()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(mock(SkuImpl.class), 0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   *
   * <ul>
   *   <li>Then calls {@link SkuImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_thenCallsGetId()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(
        InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getId();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       InventoryServiceExtensionHandler#retrieveQuantitiesAvailable(Collection, Map,
   *       ExtensionResultHolder)}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_thenCallsRetrieveQuantitiesAvailable()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Map)} with {@code skuQuantities}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then calls {@link InventoryServiceExtensionHandler#decrementInventory(Map, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Map)"})
  public void testDecrementInventoryWithSkuQuantities_whenHashMap_thenCallsDecrementInventory()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.decrementInventory(new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity() throws InventoryUnavailableException {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(new SkuImpl(), 1));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity2() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.decrementInventory(new SkuImpl(), 1);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity3() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(new SkuImpl(), 1));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity4() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.isActive()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> inventoryServiceImpl.decrementInventory(sku, 1));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext() throws InventoryUnavailableException {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext2() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act
    inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext3() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext4() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertThrows(
        InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext5() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.isActive()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext6() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext_givenAlways_available()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
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
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext_givenNull()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
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
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.
   *   <li>Then calls {@link SkuImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext_givenUnavailable_thenCallsGetId()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(sku.isActive()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku).getId();
    verify(sku).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <ul>
   *   <li>When {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int, Map)"})
  public void testDecrementInventoryWithSkuQuantityContext_whenSkuImpl()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(sku, 0, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity_givenAlways_available()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
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
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity_givenNull()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
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
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <ul>
   *   <li>Given {@link InventoryType#UNAVAILABLE}.
   *   <li>Then calls {@link SkuImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity_givenUnavailable_thenCallsGetId()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(sku.isActive()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        InventoryUnavailableException.class, () -> inventoryServiceImpl.decrementInventory(sku, 1));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku).getId();
    verify(sku).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       InventoryServiceExtensionHandler#retrieveQuantitiesAvailable(Collection, Map,
   *       ExtensionResultHolder)}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity_thenCallsRetrieveQuantitiesAvailable()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isActive()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> inventoryServiceImpl.decrementInventory(sku, 1));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <ul>
   *   <li>Then throw {@link InventoryUnavailableException}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity_thenThrowInventoryUnavailableException()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementInventory(new SkuImpl(), 1));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <ul>
   *   <li>When {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementInventory(Sku, int)"})
  public void testDecrementInventoryWithSkuQuantity_whenSkuImpl()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.decrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementInventory(mock(SkuImpl.class), 0));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).decrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities() {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.incrementInventory(new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities4() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, Integer.MIN_VALUE);
    skuQuantities.replace(new SkuImpl(), 2);

    // Act
    inventoryServiceImpl.incrementInventory(skuQuantities);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map, Map)"})
  public void testIncrementInventoryWithSkuQuantitiesContext() {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map, Map)"})
  public void testIncrementInventoryWithSkuQuantitiesContext2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.incrementInventory(skuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map, Map)"})
  public void testIncrementInventoryWithSkuQuantitiesContext3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map, Map)"})
  public void testIncrementInventoryWithSkuQuantitiesContext4() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, Integer.MIN_VALUE);
    skuQuantities.replace(new SkuImpl(), 2);

    // Act
    inventoryServiceImpl.incrementInventory(skuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map, Map)"})
  public void testIncrementInventoryWithSkuQuantitiesContext5() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setInventoryType(InventoryType.CHECK_QUANTITY);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, Integer.MIN_VALUE);
    skuQuantities.replace(new SkuImpl(), 2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map, Map)"})
  public void testIncrementInventoryWithSkuQuantitiesContext_givenTwo() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), Integer.MIN_VALUE);
    skuQuantities.replace(new SkuImpl(), 2);

    // Act
    inventoryServiceImpl.incrementInventory(skuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map, Map)"})
  public void testIncrementInventoryWithSkuQuantitiesContext_givenZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <ul>
   *   <li>Then calls {@link InventoryServiceExtensionHandler#incrementInventory(Map, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map, Map)"})
  public void testIncrementInventoryWithSkuQuantitiesContext_thenCallsIncrementInventory() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.incrementInventory(skuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map, Map)} with {@code skuQuantities},
   * {@code context}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} replace {@link SkuImpl} (default constructor) and {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map, Map)"})
  public void testIncrementInventoryWithSkuQuantitiesContext_whenHashMapReplaceSkuImplAndNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setInventoryType(InventoryType.CHECK_QUANTITY);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, Integer.MIN_VALUE);
    skuQuantities.replace(new SkuImpl(), null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link HashMap#HashMap()} replace {@link SkuImpl} (default constructor) and two.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities_givenTwo_whenHashMapReplaceSkuImplAndTwo() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), Integer.MIN_VALUE);
    skuQuantities.replace(new SkuImpl(), 2);

    // Act
    inventoryServiceImpl.incrementInventory(skuQuantities);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is zero.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities_givenZero_whenHashMapSkuImplIsZero() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       InventoryServiceExtensionHandler#retrieveQuantitiesAvailable(Collection, Map,
   *       ExtensionResultHolder)}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities_thenCallsRetrieveQuantitiesAvailable() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setInventoryType(InventoryType.CHECK_QUANTITY);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, Integer.MIN_VALUE);
    skuQuantities.replace(new SkuImpl(), 2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} replace {@link SkuImpl} (default constructor) and {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities_whenHashMapReplaceSkuImplAndNull() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setInventoryType(InventoryType.CHECK_QUANTITY);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, Integer.MIN_VALUE);
    skuQuantities.replace(new SkuImpl(), null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(skuQuantities));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Map)} with {@code skuQuantities}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then calls {@link InventoryServiceExtensionHandler#incrementInventory(Map, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Map)"})
  public void testIncrementInventoryWithSkuQuantities_whenHashMap_thenCallsIncrementInventory() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.incrementInventory(new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity() {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(new SkuImpl(), 1));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.incrementInventory(new SkuImpl(), 1);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(new SkuImpl(), 1));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity4() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> inventoryServiceImpl.incrementInventory(sku, 1));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku).getInventoryType();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity5() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.isActive()).thenThrow(new IllegalArgumentException());
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> inventoryServiceImpl.incrementInventory(sku, 1));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku).getInventoryType();
    verify(sku).isActive();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity6() {
    // Arrange
    when(catalogService.saveSku(Mockito.<Sku>any())).thenThrow(new IllegalArgumentException());

    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getQuantityAvailable()).thenReturn(1);
    when(sku.isActive()).thenReturn(true);
    doNothing().when(sku).setQuantityAvailable(Mockito.<Integer>any());
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> inventoryServiceImpl.incrementInventory(sku, 1));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku, atLeast(1)).getQuantityAvailable();
    verify(sku).isActive();
    verify(sku).setQuantityAvailable(2);
    verify(catalogService).saveSku(isA(Sku.class));
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity7() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(applicationContext)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(catalogService.saveSku(Mockito.<Sku>any())).thenReturn(new SkuImpl());

    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getQuantityAvailable()).thenReturn(1);
    when(sku.isActive()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    doNothing().when(sku).setQuantityAvailable(Mockito.<Integer>any());
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> inventoryServiceImpl.incrementInventory(sku, 1));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku).getId();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku, atLeast(1)).getQuantityAvailable();
    verify(sku).isActive();
    verify(sku).setQuantityAvailable(2);
    verify(catalogService).saveSku(isA(Sku.class));
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    verify(applicationContext).publishEvent(isA(ApplicationEvent.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int, Map)"})
  public void testIncrementInventoryWithSkuQuantityContext() {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int, Map)"})
  public void testIncrementInventoryWithSkuQuantityContext2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act
    inventoryServiceImpl.incrementInventory(sku, 1, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int, Map)"})
  public void testIncrementInventoryWithSkuQuantityContext3() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int, Map)"})
  public void testIncrementInventoryWithSkuQuantityContext4() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(sku, 1, new HashMap<>()));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku).getInventoryType();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int, Map)"})
  public void testIncrementInventoryWithSkuQuantityContext_givenAlways_available() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
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
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int, Map)"})
  public void testIncrementInventoryWithSkuQuantityContext_whenSkuImpl() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = new SkuImpl();

    // Act
    inventoryServiceImpl.incrementInventory(sku, 1, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)} with {@code sku}, {@code
   * quantity}, {@code context}.
   *
   * <ul>
   *   <li>When {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int, Map)"})
  public void testIncrementInventoryWithSkuQuantityContext_whenSkuImpl2() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    SkuImpl sku = mock(SkuImpl.class);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(sku, 0, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <ul>
   *   <li>Given {@link InventoryType#ALWAYS_AVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity_givenAlways_available() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
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
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link SkuImpl} {@link SkuImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity_givenFalse_whenSkuImplIsActiveReturnFalse() {
    // Arrange
    doNothing().when(applicationContext).publishEvent(Mockito.<ApplicationEvent>any());
    when(catalogService.saveSku(Mockito.<Sku>any())).thenReturn(new SkuImpl());

    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.isActive()).thenReturn(false);
    when(sku.getId()).thenReturn(1L);
    doNothing().when(sku).setQuantityAvailable(Mockito.<Integer>any());
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    // Act
    inventoryServiceImpl.incrementInventory(sku, 1);

    // Assert
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku).getId();
    verify(sku).getInventoryType();
    verify(sku).isActive();
    verify(sku).setQuantityAvailable(1);
    verify(catalogService).saveSku(isA(Sku.class));
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    verify(applicationContext, atLeast(1)).publishEvent(Mockito.<ApplicationEvent>any());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <ul>
   *   <li>Then calls {@link SkuImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity_thenCallsGetId() {
    // Arrange
    doNothing().when(applicationContext).publishEvent(Mockito.<ApplicationEvent>any());
    when(catalogService.saveSku(Mockito.<Sku>any())).thenReturn(new SkuImpl());

    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getQuantityAvailable()).thenReturn(1);
    when(sku.isActive()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    doNothing().when(sku).setQuantityAvailable(Mockito.<Integer>any());
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    // Act
    inventoryServiceImpl.incrementInventory(sku, 1);

    // Assert
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku).getId();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku, atLeast(1)).getQuantityAvailable();
    verify(sku).isActive();
    verify(sku).setQuantityAvailable(2);
    verify(catalogService).saveSku(isA(Sku.class));
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    verify(applicationContext, atLeast(1)).publishEvent(Mockito.<ApplicationEvent>any());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <ul>
   *   <li>When {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity_whenSkuImpl() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementInventory(mock(SkuImpl.class), 0));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} {@link SkuImpl#getQuantityAvailable()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity_whenSkuImplGetQuantityAvailableReturnNull() {
    // Arrange
    doNothing().when(applicationContext).publishEvent(Mockito.<ApplicationEvent>any());
    when(catalogService.saveSku(Mockito.<Sku>any())).thenReturn(new SkuImpl());

    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getQuantityAvailable()).thenReturn(null);
    when(sku.isActive()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    doNothing().when(sku).setQuantityAvailable(Mockito.<Integer>any());
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    // Act
    inventoryServiceImpl.incrementInventory(sku, 1);

    // Assert
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(sku).getId();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).getQuantityAvailable();
    verify(sku).isActive();
    verify(sku).setQuantityAvailable(1);
    verify(catalogService).saveSku(isA(Sku.class));
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isNull(), isA(ExtensionResultHolder.class));
    verify(applicationContext, atLeast(1)).publishEvent(Mockito.<ApplicationEvent>any());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementInventory(Sku, int)} with {@code sku}, {@code
   * quantity}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then calls {@link InventoryServiceExtensionHandler#incrementInventory(Map, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementInventory(Sku, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementInventory(Sku, int)"})
  public void testIncrementInventoryWithSkuQuantity_whenSkuImpl_thenCallsIncrementInventory() {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.incrementInventory(
            Mockito.<Map<Sku, Integer>>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    // Act
    inventoryServiceImpl.incrementInventory(new SkuImpl(), 1);

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler).incrementInventory(isA(Map.class), isNull());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementSku(Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link InventoryServiceImpl} (default constructor).
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementSku(Map, Map)"})
  public void testIncrementSku_givenInventoryServiceImpl_whenHashMap_thenDoesNotThrow() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act and Assert
    inventoryServiceImpl.incrementSku(skuQuantities, new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementSku(Map, Map)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is minus one.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementSku(Map, Map)"})
  public void testIncrementSku_givenMinusOne_whenHashMapSkuImplIsMinusOne() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), -1);
    skuQuantities.put(skuImpl, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementSku(skuQuantities, new HashMap<>()));
    verify(skuImpl).getInventoryType();
  }

  /**
   * Test {@link InventoryServiceImpl#incrementSku(Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@link
   *       InventoryType#ALWAYS_AVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementSku(Map, Map)"})
  public void testIncrementSku_givenSkuImplGetInventoryTypeReturnAlways_available() {
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
   *
   * <ul>
   *   <li>Given {@link SkuImpl}.
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementSku(Map, Map)"})
  public void testIncrementSku_givenSkuImpl_whenHashMapSkuImplIsNull() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(mock(SkuImpl.class), null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementSku(skuQuantities, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#incrementSku(Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is one.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementSku(Map, Map)"})
  public void testIncrementSku_givenSkuImpl_whenHashMapSkuImplIsOne_thenDoesNotThrow() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 1);

    // Act and Assert
    inventoryServiceImpl.incrementSku(skuQuantities, new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#incrementSku(Map, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link InventoryServiceExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#incrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.incrementSku(Map, Map)"})
  public void testIncrementSku_thenCallsGetProxy() {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.incrementSku(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getInventoryType();
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory() throws InventoryUnavailableException {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());
    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            inventoryServiceImpl.reconcileChangeOrderInventory(
                decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory2() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.reconcileChangeOrderInventory(
        decrementSkuQuantities, incrementSkuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .reconcileChangeOrderInventory(isA(Map.class), isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory3() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<String, Object>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            inventoryServiceImpl.reconcileChangeOrderInventory(
                decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .reconcileChangeOrderInventory(isA(Map.class), isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory4() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isActive()).thenThrow(new IllegalArgumentException());

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(skuImpl, 3);
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            inventoryServiceImpl.reconcileChangeOrderInventory(
                decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .reconcileChangeOrderInventory(isA(Map.class), isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   *
   * <p>Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory5() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(skuImpl, 3);
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.reconcileChangeOrderInventory(
        decrementSkuQuantities, incrementSkuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .reconcileChangeOrderInventory(isA(Map.class), isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is minus one.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_givenMinusOne_whenHashMapSkuImplIsMinusOne()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(skuImpl, 3);

    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();
    incrementSkuQuantities.put(new SkuImpl(), -1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            inventoryServiceImpl.reconcileChangeOrderInventory(
                decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .reconcileChangeOrderInventory(isA(Map.class), isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl}.
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_givenSkuImpl_whenHashMapSkuImplIsNull()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(mock(SkuImpl.class), null);
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            inventoryServiceImpl.reconcileChangeOrderInventory(
                decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .reconcileChangeOrderInventory(isA(Map.class), isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is three.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_givenSkuImpl_whenHashMapSkuImplIsThree()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();

    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();
    incrementSkuQuantities.put(new SkuImpl(), 3);

    // Act
    inventoryServiceImpl.reconcileChangeOrderInventory(
        decrementSkuQuantities, incrementSkuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .reconcileChangeOrderInventory(isA(Map.class), isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is zero.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_givenZero_whenHashMapSkuImplIsZero()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(mock(SkuImpl.class), 0);
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            inventoryServiceImpl.reconcileChangeOrderInventory(
                decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .reconcileChangeOrderInventory(isA(Map.class), isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link SkuImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_thenCallsGetId()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<String, Object>>any()))
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
    assertThrows(
        InventoryUnavailableException.class,
        () ->
            inventoryServiceImpl.reconcileChangeOrderInventory(
                decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl).getId();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .reconcileChangeOrderInventory(isA(Map.class), isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link InventoryServiceExtensionHandler#reconcileChangeOrderInventory(Map,
   *       Map, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_thenCallsReconcileChangeOrderInventory()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act
    inventoryServiceImpl.reconcileChangeOrderInventory(
        decrementSkuQuantities, incrementSkuQuantities, new HashMap<>());

    // Assert
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .reconcileChangeOrderInventory(isA(Map.class), isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       InventoryServiceExtensionHandler#retrieveQuantitiesAvailable(Collection, Map,
   *       ExtensionResultHolder)}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_thenCallsRetrieveQuantitiesAvailable()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(skuImpl, 3);
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            inventoryServiceImpl.reconcileChangeOrderInventory(
                decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager, atLeast(1)).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
    verify(inventoryServiceExtensionHandler)
        .reconcileChangeOrderInventory(isA(Map.class), isA(Map.class), isA(Map.class));
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}.
   *
   * <ul>
   *   <li>Then throw {@link InventoryUnavailableException}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#reconcileChangeOrderInventory(Map, Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.reconcileChangeOrderInventory(Map, Map, Map)"})
  public void testReconcileChangeOrderInventory_thenThrowInventoryUnavailableException()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.reconcileChangeOrderInventory(
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<Sku, Integer>>any(),
            Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);

    HashMap<Sku, Integer> decrementSkuQuantities = new HashMap<>();
    decrementSkuQuantities.put(new SkuImpl(), 3);
    HashMap<Sku, Integer> incrementSkuQuantities = new HashMap<>();

    // Act and Assert
    assertThrows(
        InventoryUnavailableException.class,
        () ->
            inventoryServiceImpl.reconcileChangeOrderInventory(
                decrementSkuQuantities, incrementSkuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(inventoryServiceExtensionHandler)
        .reconcileChangeOrderInventory(isA(Map.class), isA(Map.class), isA(Map.class));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link InventoryServiceImpl} (default constructor).
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_givenInventoryServiceImpl_whenHashMap_thenDoesNotThrow()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    HashMap<Sku, Integer> skuQuantities = new HashMap<>();

    // Act and Assert
    inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>());
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@link
   *       InventoryType#ALWAYS_AVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_givenSkuImplGetInventoryTypeReturnAlways_available()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

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
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_givenSkuImplGetInventoryTypeReturnNull()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

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
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@link
   *       InventoryType#UNAVAILABLE}.
   *   <li>Then calls {@link SkuImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_givenSkuImplGetInventoryTypeReturnUnavailable_thenCallsGetId()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 1);

    // Act and Assert
    assertThrows(
        InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
    verify(skuImpl).getId();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_givenSkuImplGetInventoryTypeThrowIllegalArgumentException()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenThrow(new IllegalArgumentException());
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
    verify(skuImpl).getInventoryType();
    verify(skuImpl).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#isActive()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_givenSkuImplIsActiveThrowIllegalArgumentException()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isActive()).thenThrow(new IllegalArgumentException());

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
    verify(skuImpl).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl}.
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_givenSkuImpl_whenHashMapSkuImplIsNull()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(mock(SkuImpl.class), null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is zero.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_givenZero_whenHashMapSkuImplIsZero()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 0);
    skuQuantities.put(skuImpl, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link InventoryServiceExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_thenCallsGetProxy() throws InventoryUnavailableException {
    // Arrange
    when(inventoryServiceExtensionManager.getProxy()).thenThrow(new IllegalArgumentException());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(skuImpl.isActive()).thenReturn(true);

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(skuImpl, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).isActive();
  }

  /**
   * Test {@link InventoryServiceImpl#decrementSku(Map, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@link SkuImpl} (default constructor) is one.
   *   <li>Then throw {@link InventoryUnavailableException}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#decrementSku(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.decrementSku(Map, Map)"})
  public void testDecrementSku_whenHashMapSkuImplIsOne_thenThrowInventoryUnavailableException()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    HashMap<Sku, Integer> skuQuantities = new HashMap<>();
    skuQuantities.put(new SkuImpl(), 1);

    // Act and Assert
    assertThrows(
        InventoryUnavailableException.class,
        () -> inventoryServiceImpl.decrementSku(skuQuantities, new HashMap<>()));
  }

  /**
   * Test {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}.
   *
   * <ul>
   *   <li>Given {@link InventoryServiceImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#buildSkuInventoryMap(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryServiceImpl.buildSkuInventoryMap(Order)"})
  public void testBuildSkuInventoryMap_givenInventoryServiceImpl_thenReturnEmpty() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(inventoryServiceImpl.buildSkuInventoryMap(order).isEmpty());
  }

  /**
   * Test {@link InventoryServiceImpl#invalidateSkuInventory(Sku)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationContext} {@link
   *       ApplicationContext#publishEvent(ApplicationEvent)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#invalidateSkuInventory(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.invalidateSkuInventory(Sku)"})
  public void testInvalidateSkuInventory_givenApplicationContextPublishEventDoesNothing() {
    // Arrange
    doNothing().when(applicationContext).publishEvent(Mockito.<ApplicationEvent>any());

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getId()).thenReturn(1L);

    // Act
    inventoryServiceImpl.invalidateSkuInventory(sku);

    // Assert
    verify(sku).getId();
    verify(applicationContext, atLeast(1)).publishEvent(Mockito.<ApplicationEvent>any());
  }

  /**
   * Test {@link InventoryServiceImpl#invalidateSkuInventory(Sku)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#invalidateSkuInventory(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.invalidateSkuInventory(Sku)"})
  public void testInvalidateSkuInventory_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(applicationContext)
        .publishEvent(Mockito.<ApplicationEvent>any());

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> inventoryServiceImpl.invalidateSkuInventory(sku));
    verify(sku).getId();
    verify(applicationContext).publishEvent(isA(ApplicationEvent.class));
  }

  /**
   * Test {@link InventoryServiceImpl#invalidateSkuInventory(Sku)}.
   *
   * <ul>
   *   <li>When {@link Sku} {@link Sku#getId()} return one.
   *   <li>Then calls {@link Sku#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#invalidateSkuInventory(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.invalidateSkuInventory(Sku)"})
  public void testInvalidateSkuInventory_whenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();

    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);

    // Act
    inventoryServiceImpl.invalidateSkuInventory(sku);

    // Assert
    verify(sku).getId();
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   *
   * <ul>
   *   <li>Given {@link Dimension} (default constructor) Container is {@link
   *       ContainerShapeType#ContainerShapeType()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.checkSkuAvailability(Order, Sku, Integer)"})
  public void testCheckSkuAvailability_givenDimensionContainerIsContainerShapeType()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    SkuImpl sku = new SkuImpl();
    sku.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sku.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sku.setAvailable(true);
    sku.setCost(new Money());
    sku.setCurrency(new BroadleafCurrencyImpl());
    sku.setDefaultProduct(new ProductBundleImpl());
    sku.setDescription("The characteristics of someone or something");
    sku.setDimension(dimension);
    sku.setDiscountable(true);
    sku.setDisplayTemplate("Display Template");
    sku.setExcludedFulfillmentOptions(new ArrayList<>());
    sku.setExternalId("42");
    sku.setFees(new ArrayList<>());
    sku.setFulfillmentFlatRates(new HashMap<>());
    sku.setFulfillmentType(FulfillmentType.DIGITAL);
    sku.setId(1L);
    sku.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    sku.setIsMachineSortable(true);
    sku.setListPrice(new Money());
    sku.setLongDescription("Long Description");
    sku.setMachineSortable(true);
    sku.setName("Name");
    sku.setProduct(new ProductBundleImpl());
    sku.setProductOptionValueXrefs(new HashSet<>());
    sku.setQuantityAvailable(1);
    sku.setRetailPrice(new Money());
    sku.setSalePrice(new Money());
    sku.setSkuAttributes(new HashMap<>());
    sku.setSkuMediaXref(new HashMap<>());
    sku.setTaxCode("Tax Code");
    sku.setTaxable(true);
    sku.setUpc("Upc");
    sku.setUrlKey("https://example.org/example");
    sku.setWeight(weight);

    // Act and Assert
    inventoryServiceImpl.checkSkuAvailability(order, sku, 1);
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   *
   * <ul>
   *   <li>Given {@link InventoryServiceImpl} (default constructor).
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.checkSkuAvailability(Order, Sku, Integer)"})
  public void testCheckSkuAvailability_givenInventoryServiceImpl_whenSkuImpl_thenDoesNotThrow()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    inventoryServiceImpl.checkSkuAvailability(order, new SkuImpl(), 1);
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   *
   * <ul>
   *   <li>Then calls {@link InventoryServiceExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.checkSkuAvailability(Order, Sku, Integer)"})
  public void testCheckSkuAvailability_thenCallsGetProxy() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.isActive()).thenReturn(true);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isAvailable()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.checkSkuAvailability(order, sku, 1));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    verify(sku).isAvailable();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   *
   * <ul>
   *   <li>Then calls {@link SkuImpl#isActive()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.checkSkuAvailability(Order, Sku, Integer)"})
  public void testCheckSkuAvailability_thenCallsIsActive() throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.isActive()).thenThrow(new IllegalArgumentException());
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isAvailable()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.checkSkuAvailability(order, sku, 1));
    verify(sku).getInventoryType();
    verify(sku).isActive();
    verify(sku).isAvailable();
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   *
   * <ul>
   *   <li>Then throw {@link InventoryUnavailableException}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.checkSkuAvailability(Order, Sku, Integer)"})
  public void testCheckSkuAvailability_thenThrowInventoryUnavailableException()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.isAvailable()).thenReturn(false);
    when(sku.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        InventoryUnavailableException.class,
        () -> inventoryServiceImpl.checkSkuAvailability(order, sku, 1));
    verify(sku, atLeast(1)).getId();
    verify(sku).isAvailable();
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@link
   *       InventoryType#ALWAYS_AVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.checkSkuAvailability(Order, Sku, Integer)"})
  public void testCheckSkuAvailability_whenSkuImplGetInventoryTypeReturnAlways_available()
      throws InventoryUnavailableException {
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
   *
   * <ul>
   *   <li>When {@link SkuImpl} {@link SkuImpl#isActive()} return {@code false}.
   *   <li>Then calls {@link InventoryServiceExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.checkSkuAvailability(Order, Sku, Integer)"})
  public void testCheckSkuAvailability_whenSkuImplIsActiveReturnFalse_thenCallsGetProxy()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceExtensionHandler inventoryServiceExtensionHandler =
        mock(InventoryServiceExtensionHandler.class);
    when(inventoryServiceExtensionHandler.retrieveQuantitiesAvailable(
            Mockito.<Collection<Sku>>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<ExtensionResultHolder<Map<Sku, Integer>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(inventoryServiceExtensionManager.getProxy()).thenReturn(inventoryServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.isActive()).thenReturn(false);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isAvailable()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.checkSkuAvailability(order, sku, 1));
    verify(inventoryServiceExtensionManager).getProxy();
    verify(sku).getId();
    verify(sku).getInventoryType();
    verify(sku).isActive();
    verify(sku).isAvailable();
    verify(inventoryServiceExtensionHandler)
        .retrieveQuantitiesAvailable(
            isA(Collection.class), isA(Map.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InventoryServiceImpl#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryServiceImpl.checkSkuAvailability(Order, Sku, Integer)"})
  public void testCheckSkuAvailability_whenZero_thenThrowIllegalArgumentException()
      throws InventoryUnavailableException {
    // Arrange
    InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getInventoryType()).thenReturn(InventoryType.CHECK_QUANTITY);
    when(sku.isAvailable()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> inventoryServiceImpl.checkSkuAvailability(order, sku, 0));
    verify(sku).getInventoryType();
    verify(sku).isAvailable();
  }
}
