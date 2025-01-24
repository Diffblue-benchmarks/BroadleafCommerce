package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.core.order.domain.OrderLockImpl.OrderLockPk;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class OrderLockImplDiffblueTest {
  @Autowired
  private OrderLockImpl orderLockImpl;

  /**
   * Test {@link OrderLockImpl#getOrderId()}.
   * <p>
   * Method under test: {@link OrderLockImpl#getOrderId()}
   */
  @Test
  public void testGetOrderId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderLockImpl()).getOrderId());
  }

  /**
   * Test {@link OrderLockImpl#getOrderId()}.
   * <p>
   * Method under test: {@link OrderLockImpl#getOrderId()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOrderId2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass169 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.OrderLockImpl orderLockImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderLockImpl()).getOrderId();
  }

  /**
   * Test OrderLockPk {@link OrderLockPk#equals(Object)}, and
   * {@link OrderLockPk#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderLockImpl.OrderLockPk#equals(Object)}
   *   <li>{@link OrderLockImpl.OrderLockPk#hashCode()}
   * </ul>
   */
  @Test
  public void testOrderLockPkEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderLockImpl.OrderLockPk orderLockPk = new OrderLockImpl.OrderLockPk();
    orderLockPk.setKey("Key");
    orderLockPk.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    OrderLockImpl.OrderLockPk orderLockPk2 = new OrderLockImpl.OrderLockPk();
    orderLockPk2.setKey("Key");
    orderLockPk2.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertEquals(orderLockPk, orderLockPk2);
    int expectedHashCodeResult = orderLockPk.hashCode();
    assertEquals(expectedHashCodeResult, orderLockPk2.hashCode());
  }

  /**
   * Test OrderLockPk {@link OrderLockPk#equals(Object)}, and
   * {@link OrderLockPk#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderLockImpl.OrderLockPk#equals(Object)}
   *   <li>{@link OrderLockImpl.OrderLockPk#hashCode()}
   * </ul>
   */
  @Test
  public void testOrderLockPkEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderLockImpl.OrderLockPk orderLockPk = new OrderLockImpl.OrderLockPk();
    orderLockPk.setKey("Key");
    orderLockPk.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertEquals(orderLockPk, orderLockPk);
    int expectedHashCodeResult = orderLockPk.hashCode();
    assertEquals(expectedHashCodeResult, orderLockPk.hashCode());
  }

  /**
   * Test OrderLockPk {@link OrderLockPk#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockImpl.OrderLockPk#equals(Object)}
   */
  @Test
  public void testOrderLockPkEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderLockImpl.OrderLockPk orderLockPk = new OrderLockImpl.OrderLockPk();
    orderLockPk.setKey(null);
    orderLockPk.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    OrderLockImpl.OrderLockPk orderLockPk2 = new OrderLockImpl.OrderLockPk();
    orderLockPk2.setKey("Key");
    orderLockPk2.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderLockPk, orderLockPk2);
  }

  /**
   * Test OrderLockPk {@link OrderLockPk#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockImpl.OrderLockPk#equals(Object)}
   */
  @Test
  public void testOrderLockPkEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderLockImpl.OrderLockPk orderLockPk = new OrderLockImpl.OrderLockPk();
    orderLockPk.setKey("Key");
    orderLockPk.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderLockPk, null);
  }

  /**
   * Test OrderLockPk {@link OrderLockPk#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockImpl.OrderLockPk#equals(Object)}
   */
  @Test
  public void testOrderLockPkEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderLockImpl.OrderLockPk orderLockPk = new OrderLockImpl.OrderLockPk();
    orderLockPk.setKey("Key");
    orderLockPk.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderLockPk, "Different type to OrderLockPk");
  }

  /**
   * Test OrderLockPk getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderLockImpl.OrderLockPk}
   *   <li>{@link OrderLockImpl.OrderLockPk#setKey(String)}
   *   <li>{@link OrderLockImpl.OrderLockPk#setOrderId(Long)}
   *   <li>{@link OrderLockImpl.OrderLockPk#getKey()}
   *   <li>{@link OrderLockImpl.OrderLockPk#getOrderId()}
   * </ul>
   */
  @Test
  public void testOrderLockPkGettersAndSetters() {
    // Arrange and Act
    OrderLockImpl.OrderLockPk actualOrderLockPk = new OrderLockImpl.OrderLockPk();
    actualOrderLockPk.setKey("Key");
    actualOrderLockPk.setOrderId(OrderItemQualifierImpl.serialVersionUID);
    String actualKey = actualOrderLockPk.getKey();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualOrderLockPk.getOrderId().longValue());
  }

  /**
   * Test {@link OrderLockImpl#setOrderId(Long)}.
   * <p>
   * Method under test: {@link OrderLockImpl#setOrderId(Long)}
   */
  @Test
  public void testSetOrderId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderLockImpl orderLockImpl = new OrderLockImpl();

    // Act
    orderLockImpl.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Assert
    assertEquals(OrderItemQualifierImpl.serialVersionUID, orderLockImpl.getOrderId().longValue());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, orderLockImpl.orderLockPK.getOrderId().longValue());
  }

  /**
   * Test {@link OrderLockImpl#setOrderId(Long)}.
   * <p>
   * Method under test: {@link OrderLockImpl#setOrderId(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetOrderId2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass200 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.OrderLockImpl orderLockImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderLockImpl()).setOrderId(OrderItemQualifierImpl.serialVersionUID);
  }

  /**
   * Test {@link OrderLockImpl#getLocked()}.
   * <p>
   * Method under test: {@link OrderLockImpl#getLocked()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLocked() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass163 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.OrderLockImpl orderLockImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderLockImpl()).getLocked();
  }

  /**
   * Test {@link OrderLockImpl#getLocked()}.
   * <ul>
   *   <li>Given {@link OrderLockImpl} (default constructor) Key is
   * {@code Node Key}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockImpl#getLocked()}
   */
  @Test
  public void testGetLocked_givenOrderLockImplKeyIsNodeKey_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderLockImpl orderLockImpl = new OrderLockImpl();
    orderLockImpl.setKey("Node Key");
    orderLockImpl.setLastUpdated(OrderItemQualifierImpl.serialVersionUID);
    orderLockImpl.setOrderId(OrderItemQualifierImpl.serialVersionUID);
    orderLockImpl.setLocked(true);

    // Act and Assert
    assertTrue(orderLockImpl.getLocked());
  }

  /**
   * Test {@link OrderLockImpl#getLocked()}.
   * <ul>
   *   <li>Given {@link OrderLockImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockImpl#getLocked()}
   */
  @Test
  public void testGetLocked_givenOrderLockImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OrderLockImpl()).getLocked());
  }

  /**
   * Test {@link OrderLockImpl#setLocked(Boolean)}.
   * <p>
   * Method under test: {@link OrderLockImpl#setLocked(Boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetLocked() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass194 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.OrderLockImpl orderLockImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderLockImpl()).setLocked(true);
  }

  /**
   * Test {@link OrderLockImpl#setLocked(Boolean)}.
   * <ul>
   *   <li>Given {@link OrderLockImpl} (default constructor) Key is
   * {@code Node Key}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockImpl#setLocked(Boolean)}
   */
  @Test
  public void testSetLocked_givenOrderLockImplKeyIsNodeKey_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderLockImpl orderLockImpl = new OrderLockImpl();
    orderLockImpl.setKey("Node Key");
    orderLockImpl.setLastUpdated(OrderItemQualifierImpl.serialVersionUID);
    orderLockImpl.setLocked(true);
    orderLockImpl.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Act
    orderLockImpl.setLocked(null);

    // Assert
    assertEquals('N', orderLockImpl.locked.charValue());
    assertFalse(orderLockImpl.getLocked());
  }

  /**
   * Test {@link OrderLockImpl#setLocked(Boolean)}.
   * <ul>
   *   <li>Given {@link OrderLockImpl} (default constructor).</li>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link OrderLockImpl} (default constructor)
   * {@link OrderLockImpl#locked} charValue is {@code N}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockImpl#setLocked(Boolean)}
   */
  @Test
  public void testSetLocked_givenOrderLockImpl_whenFalse_thenOrderLockImplLockedCharValueIsN() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderLockImpl orderLockImpl = new OrderLockImpl();

    // Act
    orderLockImpl.setLocked(false);

    // Assert
    assertEquals('N', orderLockImpl.locked.charValue());
    assertFalse(orderLockImpl.getLocked());
  }

  /**
   * Test {@link OrderLockImpl#setLocked(Boolean)}.
   * <ul>
   *   <li>Given {@link OrderLockImpl} (default constructor).</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link OrderLockImpl} (default constructor)
   * {@link OrderLockImpl#locked} charValue is {@code Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockImpl#setLocked(Boolean)}
   */
  @Test
  public void testSetLocked_givenOrderLockImpl_whenTrue_thenOrderLockImplLockedCharValueIsY() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderLockImpl orderLockImpl = new OrderLockImpl();

    // Act
    orderLockImpl.setLocked(true);

    // Assert
    assertEquals('Y', orderLockImpl.locked.charValue());
    assertTrue(orderLockImpl.getLocked());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderLockImpl#setLastUpdated(Long)}
   *   <li>{@link OrderLockImpl#getLastUpdated()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OrderLockImpl orderLockImpl = new OrderLockImpl();

    // Act
    orderLockImpl.setLastUpdated(OrderItemQualifierImpl.serialVersionUID);

    // Assert that nothing has changed
    assertEquals(OrderItemQualifierImpl.serialVersionUID, orderLockImpl.getLastUpdated().longValue());
  }

  /**
   * Test {@link OrderLockImpl#getKey()}.
   * <p>
   * Method under test: {@link OrderLockImpl#getKey()}
   */
  @Test
  public void testGetKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderLockImpl()).getKey());
  }

  /**
   * Test {@link OrderLockImpl#getKey()}.
   * <p>
   * Method under test: {@link OrderLockImpl#getKey()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetKey2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass157 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.OrderLockImpl orderLockImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderLockImpl()).getKey();
  }

  /**
   * Test {@link OrderLockImpl#setKey(String)}.
   * <p>
   * Method under test: {@link OrderLockImpl#setKey(String)}
   */
  @Test
  public void testSetKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderLockImpl orderLockImpl = new OrderLockImpl();

    // Act
    orderLockImpl.setKey("Node Key");

    // Assert
    assertEquals("Node Key", orderLockImpl.getKey());
    assertEquals("Node Key", orderLockImpl.orderLockPK.getKey());
  }

  /**
   * Test {@link OrderLockImpl#setKey(String)}.
   * <p>
   * Method under test: {@link OrderLockImpl#setKey(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetKey2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass175 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.OrderLockImpl orderLockImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderLockImpl()).setKey("Node Key");
  }

  /**
   * Test new {@link OrderLockImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link OrderLockImpl}
   */
  @Test
  public void testNewOrderLockImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    OrderLockImpl actualOrderLockImpl = new OrderLockImpl();

    // Assert
    assertEquals('N', actualOrderLockImpl.locked.charValue());
    assertNull(actualOrderLockImpl.getLastUpdated());
    assertNull(actualOrderLockImpl.getOrderId());
    OrderLockImpl.OrderLockPk orderLockPk = actualOrderLockImpl.orderLockPK;
    assertNull(orderLockPk.getOrderId());
    assertNull(actualOrderLockImpl.getKey());
    assertNull(orderLockPk.getKey());
    assertFalse(actualOrderLockImpl.getLocked());
  }

  /**
   * Test new {@link OrderLockImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link OrderLockImpl}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewOrderLockImpl2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass156 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.OrderLockImpl orderLockImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new OrderLockImpl();
  }
}
