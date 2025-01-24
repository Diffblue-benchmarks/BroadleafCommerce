package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
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
public class OrderAttributeImplDiffblueTest {
  @Autowired
  private OrderAttributeImpl orderAttributeImpl;

  /**
   * Test {@link OrderAttributeImpl#equals(Object)}, and
   * {@link OrderAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAttributeImpl#equals(Object)}
   *   <li>{@link OrderAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl.setValue("42");

    OrderAttributeImpl orderAttributeImpl2 = new OrderAttributeImpl();
    orderAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl2.setName("Name");
    orderAttributeImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(orderAttributeImpl, orderAttributeImpl2);
    int expectedHashCodeResult = orderAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderAttributeImpl2.hashCode());
  }

  /**
   * Test {@link OrderAttributeImpl#equals(Object)}, and
   * {@link OrderAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAttributeImpl#equals(Object)}
   *   <li>{@link OrderAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(mock(Order.class));
    orderAttributeImpl.setValue("42");

    OrderAttributeImpl orderAttributeImpl2 = new OrderAttributeImpl();
    orderAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl2.setName("Name");
    orderAttributeImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(orderAttributeImpl, orderAttributeImpl2);
    int expectedHashCodeResult = orderAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderAttributeImpl2.hashCode());
  }

  /**
   * Test {@link OrderAttributeImpl#equals(Object)}, and
   * {@link OrderAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAttributeImpl#equals(Object)}
   *   <li>{@link OrderAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(orderAttributeImpl, orderAttributeImpl);
    int expectedHashCodeResult = orderAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderAttributeImpl.hashCode());
  }

  /**
   * Test {@link OrderAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl.setValue("Value");

    OrderAttributeImpl orderAttributeImpl2 = new OrderAttributeImpl();
    orderAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl2.setName("Name");
    orderAttributeImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(orderAttributeImpl, orderAttributeImpl2);
  }

  /**
   * Test {@link OrderAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl.setValue(null);

    OrderAttributeImpl orderAttributeImpl2 = new OrderAttributeImpl();
    orderAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl2.setName("Name");
    orderAttributeImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(orderAttributeImpl, orderAttributeImpl2);
  }

  /**
   * Test {@link OrderAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(orderAttributeImpl, null);
  }

  /**
   * Test {@link OrderAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(orderAttributeImpl, "Different type to OrderAttributeImpl");
  }

  /**
   * Test
   * {@link OrderAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link OrderAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3336 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.OrderAttributeImpl orderAttributeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderAttributeImpl orderAttributeImpl2 = new OrderAttributeImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    orderAttributeImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderAttributeImpl}
   *   <li>{@link OrderAttributeImpl#setId(Long)}
   *   <li>{@link OrderAttributeImpl#setName(String)}
   *   <li>{@link OrderAttributeImpl#setOrder(Order)}
   *   <li>{@link OrderAttributeImpl#setValue(String)}
   *   <li>{@link OrderAttributeImpl#getId()}
   *   <li>{@link OrderAttributeImpl#getName()}
   *   <li>{@link OrderAttributeImpl#getOrder()}
   *   <li>{@link OrderAttributeImpl#getValue()}
   *   <li>{@link OrderAttributeImpl#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderAttributeImpl actualOrderAttributeImpl = new OrderAttributeImpl();
    actualOrderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    actualOrderAttributeImpl.setName("Name");
    Order order = NullOrderFactoryImpl.NULL_ORDER;
    actualOrderAttributeImpl.setOrder(order);
    actualOrderAttributeImpl.setValue("42");
    Long actualId = actualOrderAttributeImpl.getId();
    String actualName = actualOrderAttributeImpl.getName();
    Order actualOrder = actualOrderAttributeImpl.getOrder();
    String actualValue = actualOrderAttributeImpl.getValue();

    // Assert that nothing has changed
    assertEquals("42", actualValue);
    assertEquals("42", actualOrderAttributeImpl.toString());
    assertEquals("Name", actualName);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(order, actualOrder);
  }
}
