package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class GiftWrapOrderItemImplDiffblueTest {
  @Autowired
  private GiftWrapOrderItemImpl giftWrapOrderItemImpl;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GiftWrapOrderItemImpl#setWrappedItems(List)}
   *   <li>{@link GiftWrapOrderItemImpl#getWrappedItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    GiftWrapOrderItemImpl giftWrapOrderItemImpl = new GiftWrapOrderItemImpl();
    ArrayList<OrderItem> wrappedItems = new ArrayList<>();

    // Act
    giftWrapOrderItemImpl.setWrappedItems(wrappedItems);
    List<OrderItem> actualWrappedItems = giftWrapOrderItemImpl.getWrappedItems();

    // Assert that nothing has changed
    assertTrue(actualWrappedItems.isEmpty());
    assertSame(wrappedItems, actualWrappedItems);
  }

  /**
   * Test {@link GiftWrapOrderItemImpl#clone()}.
   * <p>
   * Method under test: {@link GiftWrapOrderItemImpl#clone()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClone() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1971 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl giftWrapOrderItemImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new GiftWrapOrderItemImpl()).clone();
  }

  /**
   * Test
   * {@link GiftWrapOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link GiftWrapOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GiftWrapOrderItemImpl giftWrapOrderItemImpl = new GiftWrapOrderItemImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<DiscreteOrderItem> actualCreateOrRetrieveCopyInstanceResult = giftWrapOrderItemImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link GiftWrapOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link GiftWrapOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2001 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl giftWrapOrderItemImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    GiftWrapOrderItemImpl giftWrapOrderItemImpl2 = new GiftWrapOrderItemImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    giftWrapOrderItemImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test {@link GiftWrapOrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftWrapOrderItemImpl#equals(Object)}
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
    //       at org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl.createOrRetrieveCopyInstance(GiftWrapOrderItemImpl.java:73)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    GiftWrapOrderItemImpl giftWrapOrderItemImpl = new GiftWrapOrderItemImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    giftWrapOrderItemImpl.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
    giftWrapOrderItemImpl.setAdditionalAttributes(new HashMap<>());
    giftWrapOrderItemImpl.setAuditable(auditable);
    giftWrapOrderItemImpl.setBaseRetailPrice(new Money());
    giftWrapOrderItemImpl.setBaseSalePrice(new Money());
    giftWrapOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl());
    giftWrapOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    giftWrapOrderItemImpl.setCartMessages(new ArrayList<>());
    giftWrapOrderItemImpl.setChildOrderItems(new ArrayList<>());
    giftWrapOrderItemImpl.setDiscountingAllowed(true);
    giftWrapOrderItemImpl.setDiscreteOrderItemFeePrices(new ArrayList<>());
    giftWrapOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    giftWrapOrderItemImpl.setHasValidationError(true);
    giftWrapOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    giftWrapOrderItemImpl.setName("Name");
    giftWrapOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    giftWrapOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    giftWrapOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    giftWrapOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    giftWrapOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    giftWrapOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    giftWrapOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    giftWrapOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    giftWrapOrderItemImpl.setProduct(new ProductBundleImpl());
    giftWrapOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    giftWrapOrderItemImpl.setQuantity(1);
    giftWrapOrderItemImpl.setRetailPrice(new Money());
    giftWrapOrderItemImpl.setRetailPriceOverride(true);
    giftWrapOrderItemImpl.setSalePrice(new Money());
    giftWrapOrderItemImpl.setSalePriceOverride(true);
    giftWrapOrderItemImpl.setSkuBundleItem(new SkuBundleItemImpl());
    giftWrapOrderItemImpl.setTaxable(true);
    giftWrapOrderItemImpl.setWrappedItems(new ArrayList<>());
    giftWrapOrderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    GiftWrapOrderItemImpl giftWrapOrderItemImpl2 = new GiftWrapOrderItemImpl();
    CatalogImpl fromCatalog2 = new CatalogImpl();
    CatalogImpl toCatalog2 = new CatalogImpl();
    SiteImpl fromSite2 = new SiteImpl();
    SiteImpl toSite2 = new SiteImpl();
    GenericEntityServiceImpl genericEntityService2 = new GenericEntityServiceImpl();
    giftWrapOrderItemImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog2, toCatalog2, fromSite2,
        toSite2, genericEntityService2, new MultiTenantCopierExtensionManager()));
    giftWrapOrderItemImpl2.setAdditionalAttributes(new HashMap<>());
    giftWrapOrderItemImpl2.setAuditable(auditable2);
    giftWrapOrderItemImpl2.setBaseRetailPrice(new Money());
    giftWrapOrderItemImpl2.setBaseSalePrice(new Money());
    giftWrapOrderItemImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    giftWrapOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    giftWrapOrderItemImpl2.setCartMessages(new ArrayList<>());
    giftWrapOrderItemImpl2.setChildOrderItems(new ArrayList<>());
    giftWrapOrderItemImpl2.setDiscountingAllowed(true);
    giftWrapOrderItemImpl2.setDiscreteOrderItemFeePrices(new ArrayList<>());
    giftWrapOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    giftWrapOrderItemImpl2.setHasValidationError(true);
    giftWrapOrderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    giftWrapOrderItemImpl2.setName("Name");
    giftWrapOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    giftWrapOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    giftWrapOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    giftWrapOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    giftWrapOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    giftWrapOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    giftWrapOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    giftWrapOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    giftWrapOrderItemImpl2.setProduct(new ProductBundleImpl());
    giftWrapOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    giftWrapOrderItemImpl2.setQuantity(1);
    giftWrapOrderItemImpl2.setRetailPrice(new Money());
    giftWrapOrderItemImpl2.setRetailPriceOverride(true);
    giftWrapOrderItemImpl2.setSalePrice(new Money());
    giftWrapOrderItemImpl2.setSalePriceOverride(true);
    giftWrapOrderItemImpl2.setSkuBundleItem(new SkuBundleItemImpl());
    giftWrapOrderItemImpl2.setTaxable(true);
    giftWrapOrderItemImpl2.setWrappedItems(new ArrayList<>());
    giftWrapOrderItemImpl2.updateSaleAndRetailPrices();

    // Act
    giftWrapOrderItemImpl.equals(giftWrapOrderItemImpl2);
  }

  /**
   * Test {@link GiftWrapOrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftWrapOrderItemImpl#equals(Object)}
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

    GiftWrapOrderItemImpl giftWrapOrderItemImpl = new GiftWrapOrderItemImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    giftWrapOrderItemImpl.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
    giftWrapOrderItemImpl.setAdditionalAttributes(new HashMap<>());
    giftWrapOrderItemImpl.setAuditable(auditable);
    giftWrapOrderItemImpl.setBaseRetailPrice(new Money());
    giftWrapOrderItemImpl.setBaseSalePrice(new Money());
    giftWrapOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl());
    giftWrapOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    giftWrapOrderItemImpl.setCartMessages(new ArrayList<>());
    giftWrapOrderItemImpl.setChildOrderItems(new ArrayList<>());
    giftWrapOrderItemImpl.setDiscountingAllowed(true);
    giftWrapOrderItemImpl.setDiscreteOrderItemFeePrices(new ArrayList<>());
    giftWrapOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    giftWrapOrderItemImpl.setHasValidationError(true);
    giftWrapOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    giftWrapOrderItemImpl.setName("Name");
    giftWrapOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    giftWrapOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    giftWrapOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    giftWrapOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    giftWrapOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    giftWrapOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    giftWrapOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    giftWrapOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    giftWrapOrderItemImpl.setProduct(new ProductBundleImpl());
    giftWrapOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    giftWrapOrderItemImpl.setQuantity(1);
    giftWrapOrderItemImpl.setRetailPrice(new Money());
    giftWrapOrderItemImpl.setRetailPriceOverride(true);
    giftWrapOrderItemImpl.setSalePrice(new Money());
    giftWrapOrderItemImpl.setSalePriceOverride(true);
    giftWrapOrderItemImpl.setSkuBundleItem(new SkuBundleItemImpl());
    giftWrapOrderItemImpl.setTaxable(true);
    giftWrapOrderItemImpl.setWrappedItems(new ArrayList<>());
    giftWrapOrderItemImpl.updateSaleAndRetailPrices();

    // Act
    giftWrapOrderItemImpl.equals(null);
  }

  /**
   * Test {@link GiftWrapOrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftWrapOrderItemImpl#equals(Object)}
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

    GiftWrapOrderItemImpl giftWrapOrderItemImpl = new GiftWrapOrderItemImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    giftWrapOrderItemImpl.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
    giftWrapOrderItemImpl.setAdditionalAttributes(new HashMap<>());
    giftWrapOrderItemImpl.setAuditable(auditable);
    giftWrapOrderItemImpl.setBaseRetailPrice(new Money());
    giftWrapOrderItemImpl.setBaseSalePrice(new Money());
    giftWrapOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl());
    giftWrapOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    giftWrapOrderItemImpl.setCartMessages(new ArrayList<>());
    giftWrapOrderItemImpl.setChildOrderItems(new ArrayList<>());
    giftWrapOrderItemImpl.setDiscountingAllowed(true);
    giftWrapOrderItemImpl.setDiscreteOrderItemFeePrices(new ArrayList<>());
    giftWrapOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    giftWrapOrderItemImpl.setHasValidationError(true);
    giftWrapOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    giftWrapOrderItemImpl.setName("Name");
    giftWrapOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    giftWrapOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    giftWrapOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    giftWrapOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    giftWrapOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    giftWrapOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    giftWrapOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    giftWrapOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    giftWrapOrderItemImpl.setProduct(new ProductBundleImpl());
    giftWrapOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    giftWrapOrderItemImpl.setQuantity(1);
    giftWrapOrderItemImpl.setRetailPrice(new Money());
    giftWrapOrderItemImpl.setRetailPriceOverride(true);
    giftWrapOrderItemImpl.setSalePrice(new Money());
    giftWrapOrderItemImpl.setSalePriceOverride(true);
    giftWrapOrderItemImpl.setSkuBundleItem(new SkuBundleItemImpl());
    giftWrapOrderItemImpl.setTaxable(true);
    giftWrapOrderItemImpl.setWrappedItems(new ArrayList<>());
    giftWrapOrderItemImpl.updateSaleAndRetailPrices();

    // Act
    giftWrapOrderItemImpl.equals(giftWrapOrderItemImpl);
  }

  /**
   * Test {@link GiftWrapOrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftWrapOrderItemImpl#equals(Object)}
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

    GiftWrapOrderItemImpl giftWrapOrderItemImpl = new GiftWrapOrderItemImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    giftWrapOrderItemImpl.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
    giftWrapOrderItemImpl.setAdditionalAttributes(new HashMap<>());
    giftWrapOrderItemImpl.setAuditable(auditable);
    giftWrapOrderItemImpl.setBaseRetailPrice(new Money());
    giftWrapOrderItemImpl.setBaseSalePrice(new Money());
    giftWrapOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl());
    giftWrapOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    giftWrapOrderItemImpl.setCartMessages(new ArrayList<>());
    giftWrapOrderItemImpl.setChildOrderItems(new ArrayList<>());
    giftWrapOrderItemImpl.setDiscountingAllowed(true);
    giftWrapOrderItemImpl.setDiscreteOrderItemFeePrices(new ArrayList<>());
    giftWrapOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    giftWrapOrderItemImpl.setHasValidationError(true);
    giftWrapOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    giftWrapOrderItemImpl.setName("Name");
    giftWrapOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    giftWrapOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    giftWrapOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    giftWrapOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    giftWrapOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    giftWrapOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    giftWrapOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    giftWrapOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    giftWrapOrderItemImpl.setProduct(new ProductBundleImpl());
    giftWrapOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    giftWrapOrderItemImpl.setQuantity(1);
    giftWrapOrderItemImpl.setRetailPrice(new Money());
    giftWrapOrderItemImpl.setRetailPriceOverride(true);
    giftWrapOrderItemImpl.setSalePrice(new Money());
    giftWrapOrderItemImpl.setSalePriceOverride(true);
    giftWrapOrderItemImpl.setSkuBundleItem(new SkuBundleItemImpl());
    giftWrapOrderItemImpl.setTaxable(true);
    giftWrapOrderItemImpl.setWrappedItems(new ArrayList<>());
    giftWrapOrderItemImpl.updateSaleAndRetailPrices();

    // Act
    giftWrapOrderItemImpl.equals("Different type to GiftWrapOrderItemImpl");
  }

  /**
   * Test new {@link GiftWrapOrderItemImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link GiftWrapOrderItemImpl}
   */
  @Test
  public void testNewGiftWrapOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GiftWrapOrderItemImpl actualGiftWrapOrderItemImpl = new GiftWrapOrderItemImpl();

    // Assert
    assertNull(actualGiftWrapOrderItemImpl.discountsAllowed);
    assertNull(actualGiftWrapOrderItemImpl.hasValidationError);
    assertNull(actualGiftWrapOrderItemImpl.itemTaxable);
    assertNull(actualGiftWrapOrderItemImpl.retailPriceOverride);
    assertNull(actualGiftWrapOrderItemImpl.salePriceOverride);
    Auditable auditable = actualGiftWrapOrderItemImpl.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(actualGiftWrapOrderItemImpl.getId());
    assertNull(actualGiftWrapOrderItemImpl.orderItemType);
    assertNull(actualGiftWrapOrderItemImpl.baseRetailPrice);
    assertNull(actualGiftWrapOrderItemImpl.baseSalePrice);
    assertNull(actualGiftWrapOrderItemImpl.price);
    assertNull(actualGiftWrapOrderItemImpl.retailPrice);
    assertNull(actualGiftWrapOrderItemImpl.salePrice);
    assertNull(actualGiftWrapOrderItemImpl.totalTax);
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(actualGiftWrapOrderItemImpl.getCartMessages());
    assertNull(actualGiftWrapOrderItemImpl.getBaseRetailPrice());
    assertNull(actualGiftWrapOrderItemImpl.getBaseSalePrice());
    assertNull(actualGiftWrapOrderItemImpl.getAdjustmentValue());
    assertNull(actualGiftWrapOrderItemImpl.getAverageAdjustmentValue());
    assertNull(actualGiftWrapOrderItemImpl.getAveragePrice());
    assertNull(actualGiftWrapOrderItemImpl.getPrice());
    assertNull(actualGiftWrapOrderItemImpl.getCategory());
    assertNull(actualGiftWrapOrderItemImpl.category);
    assertNull(actualGiftWrapOrderItemImpl.deproxiedCategory);
    assertNull(actualGiftWrapOrderItemImpl.getProduct());
    assertNull(actualGiftWrapOrderItemImpl.deproxiedProduct);
    assertNull(actualGiftWrapOrderItemImpl.product);
    assertNull(actualGiftWrapOrderItemImpl.getSku());
    assertNull(actualGiftWrapOrderItemImpl.deproxiedSku);
    assertNull(actualGiftWrapOrderItemImpl.sku);
    assertNull(actualGiftWrapOrderItemImpl.getSkuBundleItem());
    assertNull(actualGiftWrapOrderItemImpl.getBundleOrderItem());
    assertNull(actualGiftWrapOrderItemImpl.getGiftWrapOrderItem());
    assertNull(actualGiftWrapOrderItemImpl.giftWrapOrderItem);
    assertNull(actualGiftWrapOrderItemImpl.getOrder());
    assertNull(actualGiftWrapOrderItemImpl.getParentOrderItem());
    assertNull(actualGiftWrapOrderItemImpl.getPersonalMessage());
    assertNull(actualGiftWrapOrderItemImpl.getOrderItemType());
    assertEquals(0, actualGiftWrapOrderItemImpl.getQuantity());
    assertFalse(actualGiftWrapOrderItemImpl.getHasValidationError());
    assertFalse(actualGiftWrapOrderItemImpl.getIsDiscounted());
    assertFalse(actualGiftWrapOrderItemImpl.isChildOrderItem());
    assertTrue(actualGiftWrapOrderItemImpl.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getWrappedItems().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getCandidateItemOffers().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getChildOrderItems().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getOrderItemAdjustments().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getOrderItemPriceDetails().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getOrderItemQualifiers().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getProratedOrderItemAdjustments().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getAdditionalAttributes().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getOrderItemAttributes().isEmpty());
  }

  /**
   * Test new {@link GiftWrapOrderItemImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link GiftWrapOrderItemImpl}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewGiftWrapOrderItemImpl2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1970 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl giftWrapOrderItemImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new GiftWrapOrderItemImpl();
  }
}
