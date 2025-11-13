package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
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
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.util.DimensionUnitOfMeasureType;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.broadleafcommerce.common.vendor.service.type.ContainerShapeType;
import org.broadleafcommerce.common.vendor.service.type.ContainerSizeType;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuImplDiffblueTest {
  @Autowired private SkuImpl skuImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuImpl#setActiveEndDate(Date)}
   *   <li>{@link SkuImpl#setActiveStartDate(Date)}
   *   <li>{@link SkuImpl#setCurrency(BroadleafCurrency)}
   *   <li>{@link SkuImpl#setDefaultProduct(Product)}
   *   <li>{@link SkuImpl#setDescription(String)}
   *   <li>{@link SkuImpl#setDimension(Dimension)}
   *   <li>{@link SkuImpl#setDisplayTemplate(String)}
   *   <li>{@link SkuImpl#setExcludedFulfillmentOptions(List)}
   *   <li>{@link SkuImpl#setExternalId(String)}
   *   <li>{@link SkuImpl#setFees(List)}
   *   <li>{@link SkuImpl#setFulfillmentFlatRates(Map)}
   *   <li>{@link SkuImpl#setId(Long)}
   *   <li>{@link SkuImpl#setIsMachineSortable(Boolean)}
   *   <li>{@link SkuImpl#setLongDescription(String)}
   *   <li>{@link SkuImpl#setMachineSortable(Boolean)}
   *   <li>{@link SkuImpl#setName(String)}
   *   <li>{@link SkuImpl#setProduct(Product)}
   *   <li>{@link SkuImpl#setProductOptionValueXrefs(Set)}
   *   <li>{@link SkuImpl#setQuantityAvailable(Integer)}
   *   <li>{@link SkuImpl#setSkuMediaXref(Map)}
   *   <li>{@link SkuImpl#setTaxCode(String)}
   *   <li>{@link SkuImpl#setUpc(String)}
   *   <li>{@link SkuImpl#setUrlKey(String)}
   *   <li>{@link SkuImpl#setWeight(Weight)}
   *   <li>{@link SkuImpl#getDefaultProduct()}
   *   <li>{@link SkuImpl#getDisplayTemplate()}
   *   <li>{@link SkuImpl#getExcludedFulfillmentOptions()}
   *   <li>{@link SkuImpl#getExternalId()}
   *   <li>{@link SkuImpl#getFees()}
   *   <li>{@link SkuImpl#getFieldEntityType()}
   *   <li>{@link SkuImpl#getFulfillmentFlatRates()}
   *   <li>{@link SkuImpl#getId()}
   *   <li>{@link SkuImpl#getProductOptionValueXrefs()}
   *   <li>{@link SkuImpl#getQuantityAvailable()}
   *   <li>{@link SkuImpl#getUpc()}
   *   <li>{@link SkuImpl#getUrlKey()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Product SkuImpl.getDefaultProduct()",
    "String SkuImpl.getDisplayTemplate()",
    "List SkuImpl.getExcludedFulfillmentOptions()",
    "String SkuImpl.getExternalId()",
    "List SkuImpl.getFees()",
    "FieldEntity SkuImpl.getFieldEntityType()",
    "Map SkuImpl.getFulfillmentFlatRates()",
    "Long SkuImpl.getId()",
    "Set SkuImpl.getProductOptionValueXrefs()",
    "Integer SkuImpl.getQuantityAvailable()",
    "String SkuImpl.getUpc()",
    "String SkuImpl.getUrlKey()",
    "void SkuImpl.setActiveEndDate(Date)",
    "void SkuImpl.setActiveStartDate(Date)",
    "void SkuImpl.setCurrency(BroadleafCurrency)",
    "void SkuImpl.setDefaultProduct(Product)",
    "void SkuImpl.setDescription(String)",
    "void SkuImpl.setDimension(Dimension)",
    "void SkuImpl.setDisplayTemplate(String)",
    "void SkuImpl.setExcludedFulfillmentOptions(List)",
    "void SkuImpl.setExternalId(String)",
    "void SkuImpl.setFees(List)",
    "void SkuImpl.setFulfillmentFlatRates(Map)",
    "void SkuImpl.setId(Long)",
    "void SkuImpl.setIsMachineSortable(Boolean)",
    "void SkuImpl.setLongDescription(String)",
    "void SkuImpl.setMachineSortable(Boolean)",
    "void SkuImpl.setName(String)",
    "void SkuImpl.setProduct(Product)",
    "void SkuImpl.setProductOptionValueXrefs(Set)",
    "void SkuImpl.setQuantityAvailable(Integer)",
    "void SkuImpl.setSkuMediaXref(Map)",
    "void SkuImpl.setTaxCode(String)",
    "void SkuImpl.setUpc(String)",
    "void SkuImpl.setUrlKey(String)",
    "void SkuImpl.setWeight(Weight)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl.setCurrency(new BroadleafCurrencyImpl());
    ProductBundleImpl defaultProduct = new ProductBundleImpl();
    skuImpl.setDefaultProduct(defaultProduct);
    skuImpl.setDescription("The characteristics of someone or something");
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    skuImpl.setDimension(dimension);
    skuImpl.setDisplayTemplate("Display Template");
    ArrayList<FulfillmentOption> excludedFulfillmentOptions = new ArrayList<>();
    skuImpl.setExcludedFulfillmentOptions(excludedFulfillmentOptions);
    skuImpl.setExternalId("42");
    ArrayList<SkuFee> fees = new ArrayList<>();
    skuImpl.setFees(fees);
    HashMap<FulfillmentOption, BigDecimal> fulfillmentFlatRates = new HashMap<>();
    skuImpl.setFulfillmentFlatRates(fulfillmentFlatRates);
    skuImpl.setId(1L);
    skuImpl.setIsMachineSortable(true);
    skuImpl.setLongDescription("Long Description");
    skuImpl.setMachineSortable(true);
    skuImpl.setName("Name");
    skuImpl.setProduct(new ProductBundleImpl());
    HashSet<SkuProductOptionValueXref> productOptionValueXrefs = new HashSet<>();
    skuImpl.setProductOptionValueXrefs(productOptionValueXrefs);
    skuImpl.setQuantityAvailable(1);
    skuImpl.setSkuMediaXref(new HashMap<>());
    skuImpl.setTaxCode("Tax Code");
    skuImpl.setUpc("Upc");
    skuImpl.setUrlKey("https://example.org/example");
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());
    skuImpl.setWeight(weight);
    Product actualDefaultProduct = skuImpl.getDefaultProduct();
    String actualDisplayTemplate = skuImpl.getDisplayTemplate();
    List<FulfillmentOption> actualExcludedFulfillmentOptions =
        skuImpl.getExcludedFulfillmentOptions();
    String actualExternalId = skuImpl.getExternalId();
    List<SkuFee> actualFees = skuImpl.getFees();
    FieldEntity actualFieldEntityType = skuImpl.getFieldEntityType();
    Map<FulfillmentOption, BigDecimal> actualFulfillmentFlatRates =
        skuImpl.getFulfillmentFlatRates();
    Long actualId = skuImpl.getId();
    Set<SkuProductOptionValueXref> actualProductOptionValueXrefs =
        skuImpl.getProductOptionValueXrefs();
    Integer actualQuantityAvailable = skuImpl.getQuantityAvailable();
    String actualUpc = skuImpl.getUpc();

    // Assert
    assertEquals("42", actualExternalId);
    assertEquals("Display Template", actualDisplayTemplate);
    assertEquals("Upc", actualUpc);
    assertEquals("https://example.org/example", skuImpl.getUrlKey());
    assertEquals(1, actualQuantityAvailable.intValue());
    assertEquals(1L, actualId.longValue());
    assertSame(excludedFulfillmentOptions, actualExcludedFulfillmentOptions);
    assertSame(fees, actualFees);
    assertSame(fulfillmentFlatRates, actualFulfillmentFlatRates);
    assertSame(productOptionValueXrefs, actualProductOptionValueXrefs);
    assertSame(defaultProduct, actualDefaultProduct);
    assertSame(FieldEntity.SKU, actualFieldEntityType);
  }

  /**
   * Test {@link SkuImpl#equals(Object)}, and {@link SkuImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuImpl#equals(Object)}
   *   <li>{@link SkuImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuImpl.equals(Object)", "int SkuImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setAvailable(true);
    skuImpl2.setCost(new Money());
    skuImpl2.setCurrency(new BroadleafCurrencyImpl());
    skuImpl2.setDefaultProduct(new ProductBundleImpl());
    skuImpl2.setDescription("The characteristics of someone or something");
    skuImpl2.setDimension(dimension2);
    skuImpl2.setDiscountable(true);
    skuImpl2.setDisplayTemplate("Display Template");
    skuImpl2.setExcludedFulfillmentOptions(new ArrayList<>());
    skuImpl2.setExternalId("42");
    skuImpl2.setFees(new ArrayList<>());
    skuImpl2.setFulfillmentFlatRates(new HashMap<>());
    skuImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    skuImpl2.setId(1L);
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl2.setIsMachineSortable(true);
    skuImpl2.setListPrice(new Money());
    skuImpl2.setLongDescription("Long Description");
    skuImpl2.setMachineSortable(true);
    skuImpl2.setName("Name");
    skuImpl2.setProduct(new ProductBundleImpl());
    skuImpl2.setProductOptionValueXrefs(new HashSet<>());
    skuImpl2.setQuantityAvailable(1);
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setSalePrice(new Money());
    skuImpl2.setSkuAttributes(new HashMap<>());
    skuImpl2.setSkuMediaXref(new HashMap<>());
    skuImpl2.setTaxCode("Tax Code");
    skuImpl2.setTaxable(true);
    skuImpl2.setUpc("Upc");
    skuImpl2.setUrlKey("https://example.org/example");
    skuImpl2.setWeight(weight2);

    // Act and Assert
    assertEquals(skuImpl, skuImpl2);
    assertEquals(skuImpl.hashCode(), skuImpl2.hashCode());
  }

  /**
   * Test {@link SkuImpl#equals(Object)}, and {@link SkuImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuImpl#equals(Object)}
   *   <li>{@link SkuImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuImpl.equals(Object)", "int SkuImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
    skuImpl.setId(null);
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

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setAvailable(true);
    skuImpl2.setCost(new Money());
    skuImpl2.setCurrency(new BroadleafCurrencyImpl());
    skuImpl2.setDefaultProduct(new ProductBundleImpl());
    skuImpl2.setDescription("The characteristics of someone or something");
    skuImpl2.setDimension(dimension2);
    skuImpl2.setDiscountable(true);
    skuImpl2.setDisplayTemplate("Display Template");
    skuImpl2.setExcludedFulfillmentOptions(new ArrayList<>());
    skuImpl2.setExternalId("42");
    skuImpl2.setFees(new ArrayList<>());
    skuImpl2.setFulfillmentFlatRates(new HashMap<>());
    skuImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    skuImpl2.setId(1L);
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl2.setIsMachineSortable(true);
    skuImpl2.setListPrice(new Money());
    skuImpl2.setLongDescription("Long Description");
    skuImpl2.setMachineSortable(true);
    skuImpl2.setName("Name");
    skuImpl2.setProduct(new ProductBundleImpl());
    skuImpl2.setProductOptionValueXrefs(new HashSet<>());
    skuImpl2.setQuantityAvailable(1);
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setSalePrice(new Money());
    skuImpl2.setSkuAttributes(new HashMap<>());
    skuImpl2.setSkuMediaXref(new HashMap<>());
    skuImpl2.setTaxCode("Tax Code");
    skuImpl2.setTaxable(true);
    skuImpl2.setUpc("Upc");
    skuImpl2.setUrlKey("https://example.org/example");
    skuImpl2.setWeight(weight2);

    // Act and Assert
    assertEquals(skuImpl, skuImpl2);
    assertEquals(skuImpl.hashCode(), skuImpl2.hashCode());
  }

  /**
   * Test {@link SkuImpl#equals(Object)}, and {@link SkuImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuImpl#equals(Object)}
   *   <li>{@link SkuImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuImpl.equals(Object)", "int SkuImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setAvailable(true);
    skuImpl2.setCost(new Money());
    skuImpl2.setCurrency(new BroadleafCurrencyImpl());
    skuImpl2.setDefaultProduct(new ProductBundleImpl());
    skuImpl2.setDescription("The characteristics of someone or something");
    skuImpl2.setDimension(dimension2);
    skuImpl2.setDiscountable(true);
    skuImpl2.setDisplayTemplate("Display Template");
    skuImpl2.setExcludedFulfillmentOptions(new ArrayList<>());
    skuImpl2.setExternalId("42");
    skuImpl2.setFees(new ArrayList<>());
    skuImpl2.setFulfillmentFlatRates(new HashMap<>());
    skuImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    skuImpl2.setId(null);
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl2.setIsMachineSortable(true);
    skuImpl2.setListPrice(new Money());
    skuImpl2.setLongDescription("Long Description");
    skuImpl2.setMachineSortable(true);
    skuImpl2.setName("Name");
    skuImpl2.setProduct(new ProductBundleImpl());
    skuImpl2.setProductOptionValueXrefs(new HashSet<>());
    skuImpl2.setQuantityAvailable(1);
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setSalePrice(new Money());
    skuImpl2.setSkuAttributes(new HashMap<>());
    skuImpl2.setSkuMediaXref(new HashMap<>());
    skuImpl2.setTaxCode("Tax Code");
    skuImpl2.setTaxable(true);
    skuImpl2.setUpc("Upc");
    skuImpl2.setUrlKey("https://example.org/example");
    skuImpl2.setWeight(weight2);

    // Act and Assert
    assertEquals(skuImpl, skuImpl2);
    assertEquals(skuImpl.hashCode(), skuImpl2.hashCode());
  }

  /**
   * Test {@link SkuImpl#equals(Object)}, and {@link SkuImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuImpl#equals(Object)}
   *   <li>{@link SkuImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuImpl.equals(Object)", "int SkuImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
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
    skuImpl.setId(null);
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl.setIsMachineSortable(true);
    skuImpl.setListPrice(new Money());
    skuImpl.setLongDescription("Long Description");
    skuImpl.setMachineSortable(true);
    skuImpl.setName(null);
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

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setAvailable(true);
    skuImpl2.setCost(new Money());
    skuImpl2.setCurrency(new BroadleafCurrencyImpl());
    skuImpl2.setDefaultProduct(new ProductBundleImpl());
    skuImpl2.setDescription("The characteristics of someone or something");
    skuImpl2.setDimension(dimension2);
    skuImpl2.setDiscountable(true);
    skuImpl2.setDisplayTemplate("Display Template");
    skuImpl2.setExcludedFulfillmentOptions(new ArrayList<>());
    skuImpl2.setExternalId("42");
    skuImpl2.setFees(new ArrayList<>());
    skuImpl2.setFulfillmentFlatRates(new HashMap<>());
    skuImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    skuImpl2.setId(1L);
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl2.setIsMachineSortable(true);
    skuImpl2.setListPrice(new Money());
    skuImpl2.setLongDescription("Long Description");
    skuImpl2.setMachineSortable(true);
    skuImpl2.setName(null);
    skuImpl2.setProduct(new ProductBundleImpl());
    skuImpl2.setProductOptionValueXrefs(new HashSet<>());
    skuImpl2.setQuantityAvailable(1);
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setSalePrice(new Money());
    skuImpl2.setSkuAttributes(new HashMap<>());
    skuImpl2.setSkuMediaXref(new HashMap<>());
    skuImpl2.setTaxCode("Tax Code");
    skuImpl2.setTaxable(true);
    skuImpl2.setUpc("Upc");
    skuImpl2.setUrlKey("https://example.org/example");
    skuImpl2.setWeight(weight2);

    // Act and Assert
    assertEquals(skuImpl, skuImpl2);
    assertEquals(skuImpl.hashCode(), skuImpl2.hashCode());
  }

  /**
   * Test {@link SkuImpl#equals(Object)}, and {@link SkuImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuImpl#equals(Object)}
   *   <li>{@link SkuImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuImpl.equals(Object)", "int SkuImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

    // Act and Assert
    assertEquals(skuImpl, skuImpl);
    int expectedHashCodeResult = skuImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuImpl.hashCode());
  }

  /**
   * Test {@link SkuImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuImpl.equals(Object)", "int SkuImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
    skuImpl.setId(2L);
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

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setAvailable(true);
    skuImpl2.setCost(new Money());
    skuImpl2.setCurrency(new BroadleafCurrencyImpl());
    skuImpl2.setDefaultProduct(new ProductBundleImpl());
    skuImpl2.setDescription("The characteristics of someone or something");
    skuImpl2.setDimension(dimension2);
    skuImpl2.setDiscountable(true);
    skuImpl2.setDisplayTemplate("Display Template");
    skuImpl2.setExcludedFulfillmentOptions(new ArrayList<>());
    skuImpl2.setExternalId("42");
    skuImpl2.setFees(new ArrayList<>());
    skuImpl2.setFulfillmentFlatRates(new HashMap<>());
    skuImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    skuImpl2.setId(1L);
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl2.setIsMachineSortable(true);
    skuImpl2.setListPrice(new Money());
    skuImpl2.setLongDescription("Long Description");
    skuImpl2.setMachineSortable(true);
    skuImpl2.setName("Name");
    skuImpl2.setProduct(new ProductBundleImpl());
    skuImpl2.setProductOptionValueXrefs(new HashSet<>());
    skuImpl2.setQuantityAvailable(1);
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setSalePrice(new Money());
    skuImpl2.setSkuAttributes(new HashMap<>());
    skuImpl2.setSkuMediaXref(new HashMap<>());
    skuImpl2.setTaxCode("Tax Code");
    skuImpl2.setTaxable(true);
    skuImpl2.setUpc("Upc");
    skuImpl2.setUrlKey("https://example.org/example");
    skuImpl2.setWeight(weight2);

    // Act and Assert
    assertNotEquals(skuImpl, skuImpl2);
  }

  /**
   * Test {@link SkuImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuImpl.equals(Object)", "int SkuImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
    skuImpl.setId(null);
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl.setIsMachineSortable(true);
    skuImpl.setListPrice(new Money());
    skuImpl.setLongDescription("Long Description");
    skuImpl.setMachineSortable(true);
    skuImpl.setName("name");
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

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setAvailable(true);
    skuImpl2.setCost(new Money());
    skuImpl2.setCurrency(new BroadleafCurrencyImpl());
    skuImpl2.setDefaultProduct(new ProductBundleImpl());
    skuImpl2.setDescription("The characteristics of someone or something");
    skuImpl2.setDimension(dimension2);
    skuImpl2.setDiscountable(true);
    skuImpl2.setDisplayTemplate("Display Template");
    skuImpl2.setExcludedFulfillmentOptions(new ArrayList<>());
    skuImpl2.setExternalId("42");
    skuImpl2.setFees(new ArrayList<>());
    skuImpl2.setFulfillmentFlatRates(new HashMap<>());
    skuImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    skuImpl2.setId(1L);
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl2.setIsMachineSortable(true);
    skuImpl2.setListPrice(new Money());
    skuImpl2.setLongDescription("Long Description");
    skuImpl2.setMachineSortable(true);
    skuImpl2.setName("Name");
    skuImpl2.setProduct(new ProductBundleImpl());
    skuImpl2.setProductOptionValueXrefs(new HashSet<>());
    skuImpl2.setQuantityAvailable(1);
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setSalePrice(new Money());
    skuImpl2.setSkuAttributes(new HashMap<>());
    skuImpl2.setSkuMediaXref(new HashMap<>());
    skuImpl2.setTaxCode("Tax Code");
    skuImpl2.setTaxable(true);
    skuImpl2.setUpc("Upc");
    skuImpl2.setUrlKey("https://example.org/example");
    skuImpl2.setWeight(weight2);

    // Act and Assert
    assertNotEquals(skuImpl, skuImpl2);
  }

  /**
   * Test {@link SkuImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuImpl.equals(Object)", "int SkuImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
    skuImpl.setId(null);
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl.setIsMachineSortable(true);
    skuImpl.setListPrice(new Money());
    skuImpl.setLongDescription("Long Description");
    skuImpl.setMachineSortable(true);
    skuImpl.setName(null);
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

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setAvailable(true);
    skuImpl2.setCost(new Money());
    skuImpl2.setCurrency(new BroadleafCurrencyImpl());
    skuImpl2.setDefaultProduct(new ProductBundleImpl());
    skuImpl2.setDescription("The characteristics of someone or something");
    skuImpl2.setDimension(dimension2);
    skuImpl2.setDiscountable(true);
    skuImpl2.setDisplayTemplate("Display Template");
    skuImpl2.setExcludedFulfillmentOptions(new ArrayList<>());
    skuImpl2.setExternalId("42");
    skuImpl2.setFees(new ArrayList<>());
    skuImpl2.setFulfillmentFlatRates(new HashMap<>());
    skuImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    skuImpl2.setId(1L);
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl2.setIsMachineSortable(true);
    skuImpl2.setListPrice(new Money());
    skuImpl2.setLongDescription("Long Description");
    skuImpl2.setMachineSortable(true);
    skuImpl2.setName("Name");
    skuImpl2.setProduct(new ProductBundleImpl());
    skuImpl2.setProductOptionValueXrefs(new HashSet<>());
    skuImpl2.setQuantityAvailable(1);
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setSalePrice(new Money());
    skuImpl2.setSkuAttributes(new HashMap<>());
    skuImpl2.setSkuMediaXref(new HashMap<>());
    skuImpl2.setTaxCode("Tax Code");
    skuImpl2.setTaxable(true);
    skuImpl2.setUpc("Upc");
    skuImpl2.setUrlKey("https://example.org/example");
    skuImpl2.setWeight(weight2);

    // Act and Assert
    assertNotEquals(skuImpl, skuImpl2);
  }

  /**
   * Test {@link SkuImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuImpl.equals(Object)", "int SkuImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
    skuImpl.setId(null);
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl.setIsMachineSortable(true);
    skuImpl.setListPrice(new Money());
    skuImpl.setLongDescription("Long Description");
    skuImpl.setMachineSortable(true);
    skuImpl.setName(null);
    skuImpl.setProduct(null);
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

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setAvailable(true);
    skuImpl2.setCost(new Money());
    skuImpl2.setCurrency(new BroadleafCurrencyImpl());
    skuImpl2.setDefaultProduct(new ProductBundleImpl());
    skuImpl2.setDescription("The characteristics of someone or something");
    skuImpl2.setDimension(dimension2);
    skuImpl2.setDiscountable(true);
    skuImpl2.setDisplayTemplate("Display Template");
    skuImpl2.setExcludedFulfillmentOptions(new ArrayList<>());
    skuImpl2.setExternalId("42");
    skuImpl2.setFees(new ArrayList<>());
    skuImpl2.setFulfillmentFlatRates(new HashMap<>());
    skuImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    skuImpl2.setId(1L);
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl2.setIsMachineSortable(true);
    skuImpl2.setListPrice(new Money());
    skuImpl2.setLongDescription("Long Description");
    skuImpl2.setMachineSortable(true);
    skuImpl2.setName("Name");
    skuImpl2.setProduct(new ProductBundleImpl());
    skuImpl2.setProductOptionValueXrefs(new HashSet<>());
    skuImpl2.setQuantityAvailable(1);
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setSalePrice(new Money());
    skuImpl2.setSkuAttributes(new HashMap<>());
    skuImpl2.setSkuMediaXref(new HashMap<>());
    skuImpl2.setTaxCode("Tax Code");
    skuImpl2.setTaxable(true);
    skuImpl2.setUpc("Upc");
    skuImpl2.setUrlKey("https://example.org/example");
    skuImpl2.setWeight(weight2);

    // Act and Assert
    assertNotEquals(skuImpl, skuImpl2);
  }

  /**
   * Test {@link SkuImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuImpl.equals(Object)", "int SkuImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());

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
    skuImpl.setId(null);
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl.setIsMachineSortable(true);
    skuImpl.setListPrice(new Money());
    skuImpl.setLongDescription("Long Description");
    skuImpl.setMachineSortable(true);
    skuImpl.setName(null);
    skuImpl.setProduct(product);
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

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setAvailable(true);
    skuImpl2.setCost(new Money());
    skuImpl2.setCurrency(new BroadleafCurrencyImpl());
    skuImpl2.setDefaultProduct(new ProductBundleImpl());
    skuImpl2.setDescription("The characteristics of someone or something");
    skuImpl2.setDimension(dimension2);
    skuImpl2.setDiscountable(true);
    skuImpl2.setDisplayTemplate("Display Template");
    skuImpl2.setExcludedFulfillmentOptions(new ArrayList<>());
    skuImpl2.setExternalId("42");
    skuImpl2.setFees(new ArrayList<>());
    skuImpl2.setFulfillmentFlatRates(new HashMap<>());
    skuImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    skuImpl2.setId(1L);
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl2.setIsMachineSortable(true);
    skuImpl2.setListPrice(new Money());
    skuImpl2.setLongDescription("Long Description");
    skuImpl2.setMachineSortable(true);
    skuImpl2.setName("Name");
    skuImpl2.setProduct(new ProductBundleImpl());
    skuImpl2.setProductOptionValueXrefs(new HashSet<>());
    skuImpl2.setQuantityAvailable(1);
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setSalePrice(new Money());
    skuImpl2.setSkuAttributes(new HashMap<>());
    skuImpl2.setSkuMediaXref(new HashMap<>());
    skuImpl2.setTaxCode("Tax Code");
    skuImpl2.setTaxable(true);
    skuImpl2.setUpc("Upc");
    skuImpl2.setUrlKey("https://example.org/example");
    skuImpl2.setWeight(weight2);

    // Act and Assert
    assertNotEquals(skuImpl, skuImpl2);
  }

  /**
   * Test {@link SkuImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link SkuImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuImpl.equals(Object)", "int SkuImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenThrowException() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenThrow(new IllegalStateException());

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
    skuImpl.setId(null);
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl.setIsMachineSortable(true);
    skuImpl.setListPrice(new Money());
    skuImpl.setLongDescription("Long Description");
    skuImpl.setMachineSortable(true);
    skuImpl.setName(null);
    skuImpl.setProduct(product);
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

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setAvailable(true);
    skuImpl2.setCost(new Money());
    skuImpl2.setCurrency(new BroadleafCurrencyImpl());
    skuImpl2.setDefaultProduct(new ProductBundleImpl());
    skuImpl2.setDescription("The characteristics of someone or something");
    skuImpl2.setDimension(dimension2);
    skuImpl2.setDiscountable(true);
    skuImpl2.setDisplayTemplate("Display Template");
    skuImpl2.setExcludedFulfillmentOptions(new ArrayList<>());
    skuImpl2.setExternalId("42");
    skuImpl2.setFees(new ArrayList<>());
    skuImpl2.setFulfillmentFlatRates(new HashMap<>());
    skuImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    skuImpl2.setId(1L);
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    skuImpl2.setIsMachineSortable(true);
    skuImpl2.setListPrice(new Money());
    skuImpl2.setLongDescription("Long Description");
    skuImpl2.setMachineSortable(true);
    skuImpl2.setName("Name");
    skuImpl2.setProduct(new ProductBundleImpl());
    skuImpl2.setProductOptionValueXrefs(new HashSet<>());
    skuImpl2.setQuantityAvailable(1);
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setSalePrice(new Money());
    skuImpl2.setSkuAttributes(new HashMap<>());
    skuImpl2.setSkuMediaXref(new HashMap<>());
    skuImpl2.setTaxCode("Tax Code");
    skuImpl2.setTaxable(true);
    skuImpl2.setUpc("Upc");
    skuImpl2.setUrlKey("https://example.org/example");
    skuImpl2.setWeight(weight2);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.equals(skuImpl2));
  }

  /**
   * Test {@link SkuImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuImpl.equals(Object)", "int SkuImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(skuImpl, null);
  }

  /**
   * Test {@link SkuImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuImpl.equals(Object)", "int SkuImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(skuImpl, "Different type to SkuImpl");
  }

  /**
   * Test new {@link SkuImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SkuImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuImpl.<init>()"})
  public void testNewSkuImpl() {
    // Arrange and Act
    SkuImpl actualSkuImpl = new SkuImpl();

    // Assert
    assertNull(actualSkuImpl.getTaxable());
    assertNull(actualSkuImpl.isMachineSortable);
    assertNull(actualSkuImpl.available);
    assertNull(actualSkuImpl.discountable);
    assertNull(actualSkuImpl.taxable);
    assertNull(actualSkuImpl.getId());
    assertNull(actualSkuImpl.getDescription());
    assertNull(actualSkuImpl.getDisplayTemplate());
    assertNull(actualSkuImpl.getExternalId());
    assertNull(actualSkuImpl.getLongDescription());
    assertNull(actualSkuImpl.getName());
    assertNull(actualSkuImpl.getTaxCode());
    assertNull(actualSkuImpl.getUpc());
    assertNull(actualSkuImpl.getUrlKey());
    assertNull(actualSkuImpl.description);
    assertNull(actualSkuImpl.fulfillmentType);
    assertNull(actualSkuImpl.inventoryType);
    assertNull(actualSkuImpl.longDescription);
    assertNull(actualSkuImpl.name);
    assertNull(actualSkuImpl.taxCode);
    assertNull(actualSkuImpl.cost);
    assertNull(actualSkuImpl.retailPrice);
    assertNull(actualSkuImpl.salePrice);
    assertNull(actualSkuImpl.getActiveEndDate());
    assertNull(actualSkuImpl.getActiveStartDate());
    assertNull(actualSkuImpl.activeEndDate);
    assertNull(actualSkuImpl.activeStartDate);
    assertNull(actualSkuImpl.getCurrency());
    assertNull(actualSkuImpl.currency);
    assertNull(actualSkuImpl.getPrimarySkuMedia());
    assertNull(actualSkuImpl.getBaseRetailPrice());
    assertNull(actualSkuImpl.getBaseSalePrice());
    assertNull(actualSkuImpl.getCost());
    assertNull(actualSkuImpl.getListPrice());
    assertNull(actualSkuImpl.getPrice());
    assertNull(actualSkuImpl.getProductOptionValueAdjustments());
    assertNull(actualSkuImpl.getRetailPrice());
    assertNull(actualSkuImpl.getRetailPriceInternal());
    assertNull(actualSkuImpl.getSalePrice());
    assertNull(actualSkuImpl.getDefaultProduct());
    assertNull(actualSkuImpl.getProduct());
    assertNull(actualSkuImpl.product);
    assertNull(actualSkuImpl.getInventoryType());
    assertNull(actualSkuImpl.getFulfillmentType());
    assertEquals(0, actualSkuImpl.getQuantityAvailable().intValue());
    assertFalse(actualSkuImpl.getDiscountable());
    assertFalse(actualSkuImpl.getIsMachineSortable());
    assertFalse(actualSkuImpl.hasDefaultSku());
    assertFalse(actualSkuImpl.hasRetailPrice());
    assertFalse(actualSkuImpl.hasSalePrice());
    assertTrue(actualSkuImpl.getExcludedFulfillmentOptions().isEmpty());
    assertTrue(actualSkuImpl.getFees().isEmpty());
    assertTrue(actualSkuImpl.getProductOptionValues().isEmpty());
    assertTrue(actualSkuImpl.skuAttributes.isEmpty());
    assertTrue(actualSkuImpl.getFulfillmentFlatRates().isEmpty());
    assertTrue(actualSkuImpl.getMultiValueSkuAttributes().isEmpty());
    assertTrue(actualSkuImpl.getSkuAttributes().isEmpty());
    assertTrue(actualSkuImpl.getSkuMedia().isEmpty());
    assertTrue(actualSkuImpl.getSkuMediaXref().isEmpty());
    assertTrue(actualSkuImpl.legacySkuMedia.isEmpty());
    assertTrue(actualSkuImpl.skuMedia.isEmpty());
    assertTrue(actualSkuImpl.getProductOptionValueXrefs().isEmpty());
    assertTrue(actualSkuImpl.getProductOptionValuesCollection().isEmpty());
    assertTrue(actualSkuImpl.legacyProductOptionValues.isEmpty());
    assertTrue(actualSkuImpl.getAvailable());
    Dimension expectedDimension = actualSkuImpl.dimension;
    assertSame(expectedDimension, actualSkuImpl.getDimension());
    Map<String, SkuMediaXref> expectedSkuMediaXrefIgnoreDefaultSku = actualSkuImpl.skuMedia;
    assertSame(
        expectedSkuMediaXrefIgnoreDefaultSku, actualSkuImpl.getSkuMediaXrefIgnoreDefaultSku());
    Weight expectedWeight = actualSkuImpl.weight;
    assertSame(expectedWeight, actualSkuImpl.getWeight());
  }
}
