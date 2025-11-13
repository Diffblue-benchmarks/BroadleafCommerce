package org.broadleafcommerce.core.catalog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.persistence.NoResultException;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.util.DimensionUnitOfMeasureType;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.broadleafcommerce.common.vendor.service.type.ContainerShapeType;
import org.broadleafcommerce.common.vendor.service.type.ContainerSizeType;
import org.broadleafcommerce.core.catalog.domain.Dimension;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.domain.Weight;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SkuDaoImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @Mock private SkuDaoExtensionManager skuDaoExtensionManager;

  @InjectMocks private SkuDaoImpl skuDaoImpl;

  /**
   * Test {@link SkuDaoImpl#readSkusByIds(List)}.
   *
   * <ul>
   *   <li>Given {@link SkuDaoImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuDaoImpl#readSkusByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SkuDaoImpl.readSkusByIds(List)"})
  public void testReadSkusByIds_givenSkuDaoImpl_whenArrayList_thenReturnNull() {
    // Arrange
    SkuDaoImpl skuDaoImpl = new SkuDaoImpl();

    // Act and Assert
    assertNull(skuDaoImpl.readSkusByIds(new ArrayList<>()));
  }

  /**
   * Test {@link SkuDaoImpl#readSkusByIds(List)}.
   *
   * <ul>
   *   <li>Given {@link SkuDaoImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuDaoImpl#readSkusByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SkuDaoImpl.readSkusByIds(List)"})
  public void testReadSkusByIds_givenSkuDaoImpl_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SkuDaoImpl().readSkusByIds(null));
  }

  /**
   * Test {@link SkuDaoImpl#create()}.
   *
   * <ul>
   *   <li>Given {@link Dimension} (default constructor) Container is {@link
   *       ContainerShapeType#ContainerShapeType()}.
   *   <li>Then return {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SkuDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku SkuDaoImpl.create()"})
  public void testCreate_givenDimensionContainerIsContainerShapeType_thenReturnSkuImpl() {
    // Arrange
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

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl.setAvailable(true);
    skuImpl.setCost(new Money());
    skuImpl.setCurrency(new BroadleafCurrencyImpl());
    skuImpl.setDefaultProduct(new ProductBundleImpl());
    skuImpl.setDescription("The characteristics of someone or something");
    skuImpl.setDimension(dimension);
    skuImpl.setDiscountable(true);
    skuImpl.setDisplayTemplate("Display Template");
    skuImpl.setExcludedFulfillmentOptions(new ArrayList<>());
    skuImpl.setExternalId("42");
    skuImpl.setFees(new ArrayList<>());
    skuImpl.setFulfillmentFlatRates(new HashMap<>());
    skuImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    skuImpl.setId(1L);
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl.setIsMachineSortable(true);
    skuImpl.setListPrice(new Money());
    skuImpl.setLongDescription("Long Description");
    skuImpl.setMachineSortable(true);
    skuImpl.setName("Name");
    skuImpl.setProduct(new ProductBundleImpl());
    skuImpl.setProductOptionValueXrefs(new HashSet<>());
    skuImpl.setQuantityAvailable(1);
    skuImpl.setRetailPrice(new Money());
    skuImpl.setSalePrice(new Money());
    skuImpl.setSkuAttributes(new HashMap<>());
    skuImpl.setSkuMediaXref(new HashMap<>());
    skuImpl.setTaxCode("Tax Code");
    skuImpl.setTaxable(true);
    skuImpl.setUpc("Upc");
    skuImpl.setUrlKey("https://example.org/example");
    skuImpl.setWeight(weight);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(skuImpl);

    // Act
    Sku actualCreateResult = skuDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.catalog.domain.Sku");
    assertSame(skuImpl, actualCreateResult);
  }

  /**
   * Test {@link SkuDaoImpl#create()}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link SkuDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku SkuDaoImpl.create()"})
  public void testCreate_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(NoResultException.class, () -> skuDaoImpl.create());
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.catalog.domain.Sku");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link SkuDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SkuDaoImpl.getCurrentDateResolution()",
    "void SkuDaoImpl.setCurrentDateResolution(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SkuDaoImpl skuDaoImpl = new SkuDaoImpl();

    // Act
    skuDaoImpl.setCurrentDateResolution(1L);

    // Assert
    assertEquals(1L, skuDaoImpl.getCurrentDateResolution().longValue());
  }

  /**
   * Test {@link SkuDaoImpl#findSkuByURI(String)}.
   *
   * <p>Method under test: {@link SkuDaoImpl#findSkuByURI(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SkuDaoImpl.findSkuByURI(String)"})
  public void testFindSkuByURI() {
    // Arrange
    when(skuDaoExtensionManager.getProxy()).thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(NoResultException.class, () -> skuDaoImpl.findSkuByURI("Uri"));
    verify(skuDaoExtensionManager).getProxy();
  }

  /**
   * Test {@link SkuDaoImpl#findSkuByURI(String)}.
   *
   * <ul>
   *   <li>Given {@link SkuDaoExtensionHandler} {@link SkuDaoExtensionHandler#findSkuByURI(String,
   *       ExtensionResultHolder)} throw {@link NoResultException#NoResultException()}.
   * </ul>
   *
   * <p>Method under test: {@link SkuDaoImpl#findSkuByURI(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SkuDaoImpl.findSkuByURI(String)"})
  public void testFindSkuByURI_givenSkuDaoExtensionHandlerFindSkuByURIThrowNoResultException() {
    // Arrange
    SkuDaoExtensionHandler skuDaoExtensionHandler = mock(SkuDaoExtensionHandler.class);
    when(skuDaoExtensionHandler.findSkuByURI(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenThrow(new NoResultException());
    when(skuDaoExtensionManager.getProxy()).thenReturn(skuDaoExtensionHandler);

    // Act and Assert
    assertThrows(NoResultException.class, () -> skuDaoImpl.findSkuByURI("Uri"));
    verify(skuDaoExtensionManager).getProxy();
    verify(skuDaoExtensionHandler).findSkuByURI(eq("Uri"), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link SkuDaoImpl#findSkuByURI(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuDaoImpl#findSkuByURI(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SkuDaoImpl.findSkuByURI(String)"})
  public void testFindSkuByURI_thenReturnNull() {
    // Arrange
    SkuDaoExtensionHandler skuDaoExtensionHandler = mock(SkuDaoExtensionHandler.class);
    when(skuDaoExtensionHandler.findSkuByURI(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(skuDaoExtensionManager.getProxy()).thenReturn(skuDaoExtensionHandler);

    // Act
    List<Sku> actualFindSkuByURIResult = skuDaoImpl.findSkuByURI("Uri");

    // Assert
    verify(skuDaoExtensionManager).getProxy();
    verify(skuDaoExtensionHandler).findSkuByURI(eq("Uri"), isA(ExtensionResultHolder.class));
    assertNull(actualFindSkuByURIResult);
  }
}
