package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItem;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
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
public class DiscreteOrderItemImplDiffblueTest {
  @Autowired
  private DiscreteOrderItemImpl discreteOrderItemImpl;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DiscreteOrderItemImpl#setAdditionalAttributes(Map)}
   *   <li>{@link DiscreteOrderItemImpl#setDiscreteOrderItemFeePrices(List)}
   *   <li>{@link DiscreteOrderItemImpl#setProduct(Product)}
   *   <li>{@link DiscreteOrderItemImpl#setSkuBundleItem(SkuBundleItem)}
   *   <li>{@link DiscreteOrderItemImpl#getAdditionalAttributes()}
   *   <li>{@link DiscreteOrderItemImpl#getBundleOrderItem()}
   *   <li>{@link DiscreteOrderItemImpl#getDiscreteOrderItemFeePrices()}
   *   <li>{@link DiscreteOrderItemImpl#getSkuBundleItem()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    HashMap<String, String> additionalAttributes = new HashMap<>();

    // Act
    discreteOrderItemImpl.setAdditionalAttributes(additionalAttributes);
    ArrayList<DiscreteOrderItemFeePrice> discreteOrderItemFeePrices = new ArrayList<>();
    discreteOrderItemImpl.setDiscreteOrderItemFeePrices(discreteOrderItemFeePrices);
    discreteOrderItemImpl.setProduct(new ProductBundleImpl());
    SkuBundleItemImpl SkuBundleItem = new SkuBundleItemImpl();
    discreteOrderItemImpl.setSkuBundleItem(SkuBundleItem);
    Map<String, String> actualAdditionalAttributes = discreteOrderItemImpl.getAdditionalAttributes();
    discreteOrderItemImpl.getBundleOrderItem();
    List<DiscreteOrderItemFeePrice> actualDiscreteOrderItemFeePrices = discreteOrderItemImpl
        .getDiscreteOrderItemFeePrices();
    SkuBundleItem actualSkuBundleItem = discreteOrderItemImpl.getSkuBundleItem();

    // Assert that nothing has changed
    assertTrue(actualDiscreteOrderItemFeePrices.isEmpty());
    assertTrue(actualAdditionalAttributes.isEmpty());
    assertSame(discreteOrderItemFeePrices, actualDiscreteOrderItemFeePrices);
    assertSame(additionalAttributes, actualAdditionalAttributes);
    assertSame(SkuBundleItem, actualSkuBundleItem);
  }

  /**
   * Test {@link DiscreteOrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.service.GenericEntityServiceImpl.getIdentifier(GenericEntityServiceImpl.java:77)
    //       at org.broadleafcommerce.common.copy.MultiTenantCopyContext.getIdentifier(MultiTenantCopyContext.java:114)
    //       at org.broadleafcommerce.common.copy.MultiTenantCopyContext.handleStandardEntity(MultiTenantCopyContext.java:280)
    //       at org.broadleafcommerce.common.copy.MultiTenantCopyContext.createOrRetrieveCopyInstance(MultiTenantCopyContext.java:148)
    //       at org.broadleafcommerce.core.order.domain.OrderItemImpl.createOrRetrieveCopyInstance(OrderItemImpl.java:1048)
    //       at org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl.createOrRetrieveCopyInstance(DiscreteOrderItemImpl.java:492)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    discreteOrderItemImpl.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
    discreteOrderItemImpl.setAdditionalAttributes(new HashMap<>());
    discreteOrderItemImpl.setAuditable(auditable);
    discreteOrderItemImpl.setBaseRetailPrice(new Money());
    discreteOrderItemImpl.setBaseSalePrice(new Money());
    discreteOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl());
    discreteOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    discreteOrderItemImpl.setCartMessages(new ArrayList<>());
    discreteOrderItemImpl.setChildOrderItems(new ArrayList<>());
    discreteOrderItemImpl.setDiscountingAllowed(true);
    discreteOrderItemImpl.setDiscreteOrderItemFeePrices(new ArrayList<>());
    discreteOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    discreteOrderItemImpl.setHasValidationError(true);
    discreteOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemImpl.setName("Name");
    discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    discreteOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    discreteOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    discreteOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    discreteOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    discreteOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    discreteOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    discreteOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    discreteOrderItemImpl.setProduct(new ProductBundleImpl());
    discreteOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    discreteOrderItemImpl.setQuantity(1);
    discreteOrderItemImpl.setRetailPrice(new Money());
    discreteOrderItemImpl.setRetailPriceOverride(true);
    discreteOrderItemImpl.setSalePrice(new Money());
    discreteOrderItemImpl.setSalePriceOverride(true);
    discreteOrderItemImpl.setSkuBundleItem(new SkuBundleItemImpl());
    discreteOrderItemImpl.setTaxable(true);
    discreteOrderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    DiscreteOrderItemImpl discreteOrderItemImpl2 = new DiscreteOrderItemImpl();
    CatalogImpl fromCatalog2 = new CatalogImpl();
    CatalogImpl toCatalog2 = new CatalogImpl();
    SiteImpl fromSite2 = new SiteImpl();
    SiteImpl toSite2 = new SiteImpl();
    GenericEntityServiceImpl genericEntityService2 = new GenericEntityServiceImpl();
    discreteOrderItemImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog2, toCatalog2, fromSite2,
        toSite2, genericEntityService2, new MultiTenantCopierExtensionManager()));
    discreteOrderItemImpl2.setAdditionalAttributes(new HashMap<>());
    discreteOrderItemImpl2.setAuditable(auditable2);
    discreteOrderItemImpl2.setBaseRetailPrice(new Money());
    discreteOrderItemImpl2.setBaseSalePrice(new Money());
    discreteOrderItemImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    discreteOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    discreteOrderItemImpl2.setCartMessages(new ArrayList<>());
    discreteOrderItemImpl2.setChildOrderItems(new ArrayList<>());
    discreteOrderItemImpl2.setDiscountingAllowed(true);
    discreteOrderItemImpl2.setDiscreteOrderItemFeePrices(new ArrayList<>());
    discreteOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    discreteOrderItemImpl2.setHasValidationError(true);
    discreteOrderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemImpl2.setName("Name");
    discreteOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    discreteOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    discreteOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    discreteOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    discreteOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    discreteOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    discreteOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    discreteOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    discreteOrderItemImpl2.setProduct(new ProductBundleImpl());
    discreteOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    discreteOrderItemImpl2.setQuantity(1);
    discreteOrderItemImpl2.setRetailPrice(new Money());
    discreteOrderItemImpl2.setRetailPriceOverride(true);
    discreteOrderItemImpl2.setSalePrice(new Money());
    discreteOrderItemImpl2.setSalePriceOverride(true);
    discreteOrderItemImpl2.setSkuBundleItem(new SkuBundleItemImpl());
    discreteOrderItemImpl2.setTaxable(true);
    discreteOrderItemImpl2.updateSaleAndRetailPrices();

    // Act
    discreteOrderItemImpl.equals(discreteOrderItemImpl2);
  }

  /**
   * Test {@link DiscreteOrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsNull() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    discreteOrderItemImpl.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
    discreteOrderItemImpl.setAdditionalAttributes(new HashMap<>());
    discreteOrderItemImpl.setAuditable(auditable);
    discreteOrderItemImpl.setBaseRetailPrice(new Money());
    discreteOrderItemImpl.setBaseSalePrice(new Money());
    discreteOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl());
    discreteOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    discreteOrderItemImpl.setCartMessages(new ArrayList<>());
    discreteOrderItemImpl.setChildOrderItems(new ArrayList<>());
    discreteOrderItemImpl.setDiscountingAllowed(true);
    discreteOrderItemImpl.setDiscreteOrderItemFeePrices(new ArrayList<>());
    discreteOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    discreteOrderItemImpl.setHasValidationError(true);
    discreteOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemImpl.setName("Name");
    discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    discreteOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    discreteOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    discreteOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    discreteOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    discreteOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    discreteOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    discreteOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    discreteOrderItemImpl.setProduct(new ProductBundleImpl());
    discreteOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    discreteOrderItemImpl.setQuantity(1);
    discreteOrderItemImpl.setRetailPrice(new Money());
    discreteOrderItemImpl.setRetailPriceOverride(true);
    discreteOrderItemImpl.setSalePrice(new Money());
    discreteOrderItemImpl.setSalePriceOverride(true);
    discreteOrderItemImpl.setSkuBundleItem(new SkuBundleItemImpl());
    discreteOrderItemImpl.setTaxable(true);
    discreteOrderItemImpl.updateSaleAndRetailPrices();

    // Act
    discreteOrderItemImpl.equals(null);
  }

  /**
   * Test {@link DiscreteOrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsSame() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    discreteOrderItemImpl.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
    discreteOrderItemImpl.setAdditionalAttributes(new HashMap<>());
    discreteOrderItemImpl.setAuditable(auditable);
    discreteOrderItemImpl.setBaseRetailPrice(new Money());
    discreteOrderItemImpl.setBaseSalePrice(new Money());
    discreteOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl());
    discreteOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    discreteOrderItemImpl.setCartMessages(new ArrayList<>());
    discreteOrderItemImpl.setChildOrderItems(new ArrayList<>());
    discreteOrderItemImpl.setDiscountingAllowed(true);
    discreteOrderItemImpl.setDiscreteOrderItemFeePrices(new ArrayList<>());
    discreteOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    discreteOrderItemImpl.setHasValidationError(true);
    discreteOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemImpl.setName("Name");
    discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    discreteOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    discreteOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    discreteOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    discreteOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    discreteOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    discreteOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    discreteOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    discreteOrderItemImpl.setProduct(new ProductBundleImpl());
    discreteOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    discreteOrderItemImpl.setQuantity(1);
    discreteOrderItemImpl.setRetailPrice(new Money());
    discreteOrderItemImpl.setRetailPriceOverride(true);
    discreteOrderItemImpl.setSalePrice(new Money());
    discreteOrderItemImpl.setSalePriceOverride(true);
    discreteOrderItemImpl.setSkuBundleItem(new SkuBundleItemImpl());
    discreteOrderItemImpl.setTaxable(true);
    discreteOrderItemImpl.updateSaleAndRetailPrices();

    // Act
    discreteOrderItemImpl.equals(discreteOrderItemImpl);
  }

  /**
   * Test {@link DiscreteOrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsWrongType() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    discreteOrderItemImpl.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
    discreteOrderItemImpl.setAdditionalAttributes(new HashMap<>());
    discreteOrderItemImpl.setAuditable(auditable);
    discreteOrderItemImpl.setBaseRetailPrice(new Money());
    discreteOrderItemImpl.setBaseSalePrice(new Money());
    discreteOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl());
    discreteOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    discreteOrderItemImpl.setCartMessages(new ArrayList<>());
    discreteOrderItemImpl.setChildOrderItems(new ArrayList<>());
    discreteOrderItemImpl.setDiscountingAllowed(true);
    discreteOrderItemImpl.setDiscreteOrderItemFeePrices(new ArrayList<>());
    discreteOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    discreteOrderItemImpl.setHasValidationError(true);
    discreteOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    discreteOrderItemImpl.setName("Name");
    discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    discreteOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    discreteOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    discreteOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    discreteOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    discreteOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    discreteOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    discreteOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    discreteOrderItemImpl.setProduct(new ProductBundleImpl());
    discreteOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    discreteOrderItemImpl.setQuantity(1);
    discreteOrderItemImpl.setRetailPrice(new Money());
    discreteOrderItemImpl.setRetailPriceOverride(true);
    discreteOrderItemImpl.setSalePrice(new Money());
    discreteOrderItemImpl.setSalePriceOverride(true);
    discreteOrderItemImpl.setSkuBundleItem(new SkuBundleItemImpl());
    discreteOrderItemImpl.setTaxable(true);
    discreteOrderItemImpl.updateSaleAndRetailPrices();

    // Act
    discreteOrderItemImpl.equals("Different type to DiscreteOrderItemImpl");
  }

  /**
   * Test new {@link DiscreteOrderItemImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link DiscreteOrderItemImpl}
   */
  @Test
  public void testNewDiscreteOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    DiscreteOrderItemImpl actualDiscreteOrderItemImpl = new DiscreteOrderItemImpl();

    // Assert
    assertNull(actualDiscreteOrderItemImpl.discountsAllowed);
    assertNull(actualDiscreteOrderItemImpl.hasValidationError);
    assertNull(actualDiscreteOrderItemImpl.itemTaxable);
    assertNull(actualDiscreteOrderItemImpl.retailPriceOverride);
    assertNull(actualDiscreteOrderItemImpl.salePriceOverride);
    Auditable auditable = actualDiscreteOrderItemImpl.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(actualDiscreteOrderItemImpl.getId());
    assertNull(actualDiscreteOrderItemImpl.orderItemType);
    assertNull(actualDiscreteOrderItemImpl.baseRetailPrice);
    assertNull(actualDiscreteOrderItemImpl.baseSalePrice);
    assertNull(actualDiscreteOrderItemImpl.price);
    assertNull(actualDiscreteOrderItemImpl.retailPrice);
    assertNull(actualDiscreteOrderItemImpl.salePrice);
    assertNull(actualDiscreteOrderItemImpl.totalTax);
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(actualDiscreteOrderItemImpl.getCartMessages());
    assertNull(actualDiscreteOrderItemImpl.getBaseRetailPrice());
    assertNull(actualDiscreteOrderItemImpl.getBaseSalePrice());
    assertNull(actualDiscreteOrderItemImpl.getAdjustmentValue());
    assertNull(actualDiscreteOrderItemImpl.getAverageAdjustmentValue());
    assertNull(actualDiscreteOrderItemImpl.getAveragePrice());
    assertNull(actualDiscreteOrderItemImpl.getPrice());
    assertNull(actualDiscreteOrderItemImpl.getCategory());
    assertNull(actualDiscreteOrderItemImpl.category);
    assertNull(actualDiscreteOrderItemImpl.deproxiedCategory);
    assertNull(actualDiscreteOrderItemImpl.getProduct());
    assertNull(actualDiscreteOrderItemImpl.deproxiedProduct);
    assertNull(actualDiscreteOrderItemImpl.product);
    assertNull(actualDiscreteOrderItemImpl.getSku());
    assertNull(actualDiscreteOrderItemImpl.deproxiedSku);
    assertNull(actualDiscreteOrderItemImpl.sku);
    assertNull(actualDiscreteOrderItemImpl.getSkuBundleItem());
    assertNull(actualDiscreteOrderItemImpl.getBundleOrderItem());
    assertNull(actualDiscreteOrderItemImpl.getGiftWrapOrderItem());
    assertNull(actualDiscreteOrderItemImpl.giftWrapOrderItem);
    assertNull(actualDiscreteOrderItemImpl.getOrder());
    assertNull(actualDiscreteOrderItemImpl.getParentOrderItem());
    assertNull(actualDiscreteOrderItemImpl.getPersonalMessage());
    assertNull(actualDiscreteOrderItemImpl.getOrderItemType());
    assertEquals(0, actualDiscreteOrderItemImpl.getQuantity());
    assertFalse(actualDiscreteOrderItemImpl.getHasValidationError());
    assertFalse(actualDiscreteOrderItemImpl.getIsDiscounted());
    assertFalse(actualDiscreteOrderItemImpl.isChildOrderItem());
    assertTrue(actualDiscreteOrderItemImpl.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getCandidateItemOffers().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getChildOrderItems().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getOrderItemAdjustments().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getOrderItemPriceDetails().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getOrderItemQualifiers().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getProratedOrderItemAdjustments().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getAdditionalAttributes().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getOrderItemAttributes().isEmpty());
  }

  /**
   * Test new {@link DiscreteOrderItemImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link DiscreteOrderItemImpl}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewDiscreteOrderItemImpl2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl discreteOrderItemImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new DiscreteOrderItemImpl();
  }
}
