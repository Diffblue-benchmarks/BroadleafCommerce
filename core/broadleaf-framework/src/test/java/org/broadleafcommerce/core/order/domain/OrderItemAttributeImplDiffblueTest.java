package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
public class OrderItemAttributeImplDiffblueTest {
  @Autowired
  private OrderItemAttributeImpl orderItemAttributeImpl;

  /**
   * Test {@link OrderItemAttributeImpl#getValue()}.
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#getValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass50 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl orderItemAttributeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderItemAttributeImpl()).getValue();
  }

  /**
   * Test {@link OrderItemAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link OrderItemAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenOrderItemAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderItemAttributeImpl()).getValue());
  }

  /**
   * Test {@link OrderItemAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link OrderItemAttributeImpl} (default constructor) OrderItem is
   * {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenOrderItemAttributeImplOrderItemIsBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setOrderItem(mock(BundleOrderItemImpl.class));

    // Act and Assert
    assertNull(orderItemAttributeImpl.getValue());
  }

  /**
   * Test {@link OrderItemAttributeImpl#checkCloneable(OrderItemAttribute)}.
   * <p>
   * Method under test:
   * {@link OrderItemAttributeImpl#checkCloneable(OrderItemAttribute)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckCloneable() throws CloneNotSupportedException, NoSuchMethodException, SecurityException {
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
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl orderItemAttributeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl2 = new OrderItemAttributeImpl();

    // Act
    orderItemAttributeImpl2.checkCloneable(new OrderItemAttributeImpl());
  }

  /**
   * Test {@link OrderItemAttributeImpl#clone()}.
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#clone()}
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
    //   public class DiffblueFakeClass14 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl orderItemAttributeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderItemAttributeImpl()).clone();
  }

  /**
   * Test {@link OrderItemAttributeImpl#clone()}.
   * <ul>
   *   <li>Given {@link OrderItemAttributeImpl} (default constructor) OrderItem is
   * {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#clone()}
   */
  @Test
  public void testClone_givenOrderItemAttributeImplOrderItemIsBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setOrderItem(mock(BundleOrderItemImpl.class));

    // Act
    OrderItemAttribute actualCloneResult = orderItemAttributeImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof OrderItemAttributeImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.toString());
    assertNull(actualCloneResult.getName());
    assertNull(actualCloneResult.getValue());
  }

  /**
   * Test {@link OrderItemAttributeImpl#clone()}.
   * <ul>
   *   <li>Given {@link OrderItemAttributeImpl} (default constructor).</li>
   *   <li>Then return OrderItem is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#clone()}
   */
  @Test
  public void testClone_givenOrderItemAttributeImpl_thenReturnOrderItemIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    OrderItemAttribute actualCloneResult = (new OrderItemAttributeImpl()).clone();

    // Assert
    assertTrue(actualCloneResult instanceof OrderItemAttributeImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.toString());
    assertNull(actualCloneResult.getName());
    assertNull(actualCloneResult.getValue());
    assertNull(actualCloneResult.getOrderItem());
  }

  /**
   * Test {@link OrderItemAttributeImpl#equals(Object)}, and
   * {@link OrderItemAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAttributeImpl#equals(Object)}
   *   <li>{@link OrderItemAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl.setName("Name");
    orderItemAttributeImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl.setValue("42");

    OrderItemAttributeImpl orderItemAttributeImpl2 = new OrderItemAttributeImpl();
    orderItemAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl2.setName("Name");
    orderItemAttributeImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(orderItemAttributeImpl, orderItemAttributeImpl2);
    int expectedHashCodeResult = orderItemAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAttributeImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAttributeImpl#equals(Object)}, and
   * {@link OrderItemAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAttributeImpl#equals(Object)}
   *   <li>{@link OrderItemAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl.setName("Name");
    orderItemAttributeImpl.setOrderItem(mock(OrderItem.class));
    orderItemAttributeImpl.setValue("42");

    OrderItemAttributeImpl orderItemAttributeImpl2 = new OrderItemAttributeImpl();
    orderItemAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl2.setName("Name");
    orderItemAttributeImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(orderItemAttributeImpl, orderItemAttributeImpl2);
    int expectedHashCodeResult = orderItemAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAttributeImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAttributeImpl#equals(Object)}, and
   * {@link OrderItemAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAttributeImpl#equals(Object)}
   *   <li>{@link OrderItemAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl.setName("Name");
    orderItemAttributeImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(orderItemAttributeImpl, orderItemAttributeImpl);
    int expectedHashCodeResult = orderItemAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAttributeImpl.hashCode());
  }

  /**
   * Test {@link OrderItemAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl.setName("Name");
    orderItemAttributeImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl.setValue("Value");

    OrderItemAttributeImpl orderItemAttributeImpl2 = new OrderItemAttributeImpl();
    orderItemAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl2.setName("Name");
    orderItemAttributeImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(orderItemAttributeImpl, orderItemAttributeImpl2);
  }

  /**
   * Test {@link OrderItemAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl.setName("Name");
    orderItemAttributeImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl.setValue(null);

    OrderItemAttributeImpl orderItemAttributeImpl2 = new OrderItemAttributeImpl();
    orderItemAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl2.setName("Name");
    orderItemAttributeImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(orderItemAttributeImpl, orderItemAttributeImpl2);
  }

  /**
   * Test {@link OrderItemAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl.setName("Name");
    orderItemAttributeImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(orderItemAttributeImpl, null);
  }

  /**
   * Test {@link OrderItemAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl.setName("Name");
    orderItemAttributeImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(orderItemAttributeImpl, "Different type to OrderItemAttributeImpl");
  }

  /**
   * Test
   * {@link OrderItemAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link OrderItemAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
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
    //   public class DiffblueFakeClass20 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl orderItemAttributeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl2 = new OrderItemAttributeImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    orderItemAttributeImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderItemAttributeImpl}
   *   <li>{@link OrderItemAttributeImpl#setId(Long)}
   *   <li>{@link OrderItemAttributeImpl#setName(String)}
   *   <li>{@link OrderItemAttributeImpl#setOrderItem(OrderItem)}
   *   <li>{@link OrderItemAttributeImpl#setValue(String)}
   *   <li>{@link OrderItemAttributeImpl#getId()}
   *   <li>{@link OrderItemAttributeImpl#getName()}
   *   <li>{@link OrderItemAttributeImpl#getOrderItem()}
   *   <li>{@link OrderItemAttributeImpl#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemAttributeImpl actualOrderItemAttributeImpl = new OrderItemAttributeImpl();
    actualOrderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    actualOrderItemAttributeImpl.setName("Name");
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualOrderItemAttributeImpl.setOrderItem(orderItem);
    actualOrderItemAttributeImpl.setValue("42");
    Long actualId = actualOrderItemAttributeImpl.getId();
    String actualName = actualOrderItemAttributeImpl.getName();
    OrderItem actualOrderItem = actualOrderItemAttributeImpl.getOrderItem();
    String actualToStringResult = actualOrderItemAttributeImpl.toString();

    // Assert that nothing has changed
    assertEquals("42", actualOrderItemAttributeImpl.getValue());
    assertEquals("42", actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItem, actualOrderItem);
  }
}
