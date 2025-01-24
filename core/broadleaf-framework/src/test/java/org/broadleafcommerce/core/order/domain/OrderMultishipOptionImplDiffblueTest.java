package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
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
public class OrderMultishipOptionImplDiffblueTest {
  @Autowired
  private OrderMultishipOptionImpl orderMultishipOptionImpl;

  /**
   * Test
   * {@link OrderMultishipOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link OrderMultishipOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderMultishipOptionImpl orderMultishipOptionImpl = new OrderMultishipOptionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderMultishipOption> actualCreateOrRetrieveCopyInstanceResult = orderMultishipOptionImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link OrderMultishipOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link OrderMultishipOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
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
    //   public class DiffblueFakeClass219 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.OrderMultishipOptionImpl orderMultishipOptionImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderMultishipOptionImpl orderMultishipOptionImpl2 = new OrderMultishipOptionImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    orderMultishipOptionImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderMultishipOptionImpl}
   *   <li>{@link OrderMultishipOptionImpl#setAddress(Address)}
   *   <li>{@link OrderMultishipOptionImpl#setFulfillmentOption(FulfillmentOption)}
   *   <li>{@link OrderMultishipOptionImpl#setId(Long)}
   *   <li>{@link OrderMultishipOptionImpl#setOrder(Order)}
   *   <li>{@link OrderMultishipOptionImpl#setOrderItem(OrderItem)}
   *   <li>{@link OrderMultishipOptionImpl#getAddress()}
   *   <li>{@link OrderMultishipOptionImpl#getFulfillmentOption()}
   *   <li>{@link OrderMultishipOptionImpl#getId()}
   *   <li>{@link OrderMultishipOptionImpl#getOrder()}
   *   <li>{@link OrderMultishipOptionImpl#getOrderItem()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderMultishipOptionImpl actualOrderMultishipOptionImpl = new OrderMultishipOptionImpl();
    AddressImpl address = new AddressImpl();
    actualOrderMultishipOptionImpl.setAddress(address);
    FulfillmentOptionImpl fulfillmentOption = new FulfillmentOptionImpl();
    actualOrderMultishipOptionImpl.setFulfillmentOption(fulfillmentOption);
    actualOrderMultishipOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    Order order = NullOrderFactoryImpl.NULL_ORDER;
    actualOrderMultishipOptionImpl.setOrder(order);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualOrderMultishipOptionImpl.setOrderItem(orderItem);
    Address actualAddress = actualOrderMultishipOptionImpl.getAddress();
    FulfillmentOption actualFulfillmentOption = actualOrderMultishipOptionImpl.getFulfillmentOption();
    Long actualId = actualOrderMultishipOptionImpl.getId();
    Order actualOrder = actualOrderMultishipOptionImpl.getOrder();
    OrderItem actualOrderItem = actualOrderMultishipOptionImpl.getOrderItem();

    // Assert that nothing has changed
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItem, actualOrderItem);
    assertSame(fulfillmentOption, actualFulfillmentOption);
    assertSame(address, actualAddress);
    assertSame(order, actualOrder);
  }
}
