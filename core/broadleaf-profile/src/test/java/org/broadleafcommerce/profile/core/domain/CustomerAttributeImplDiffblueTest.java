package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CustomerAttributeImplDiffblueTest {
  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and {@link
   * CustomerAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(1L);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl2);
    assertEquals(customerAttributeImpl.hashCode(), customerAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and {@link
   * CustomerAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl2);
    assertEquals(customerAttributeImpl.hashCode(), customerAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and {@link
   * CustomerAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(1L);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(null);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl2);
    assertEquals(customerAttributeImpl.hashCode(), customerAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and {@link
   * CustomerAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(null);
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(null);
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl2);
    assertEquals(customerAttributeImpl.hashCode(), customerAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and {@link
   * CustomerAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName(null);
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName(null);
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl2);
    assertEquals(customerAttributeImpl.hashCode(), customerAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and {@link
   * CustomerAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue(null);

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue(null);

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl2);
    assertEquals(customerAttributeImpl.hashCode(), customerAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and {@link
   * CustomerAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(1L);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl);
    int expectedHashCodeResult = customerAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerAttributeImpl.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(2L);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(null);
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(mock(CustomerImpl.class));
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("42");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName(null);
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("Name");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue(null);

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(1L);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, null);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAttributeImpl.equals(Object)",
    "int CustomerAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(1L);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, "Different type to CustomerAttributeImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerAttributeImpl}
   *   <li>{@link CustomerAttributeImpl#setCustomer(Customer)}
   *   <li>{@link CustomerAttributeImpl#setId(Long)}
   *   <li>{@link CustomerAttributeImpl#setName(String)}
   *   <li>{@link CustomerAttributeImpl#setValue(String)}
   *   <li>{@link CustomerAttributeImpl#getCustomer()}
   *   <li>{@link CustomerAttributeImpl#getId()}
   *   <li>{@link CustomerAttributeImpl#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerAttributeImpl.<init>()",
    "Customer CustomerAttributeImpl.getCustomer()",
    "Long CustomerAttributeImpl.getId()",
    "void CustomerAttributeImpl.setCustomer(Customer)",
    "void CustomerAttributeImpl.setId(Long)",
    "void CustomerAttributeImpl.setName(String)",
    "void CustomerAttributeImpl.setValue(String)",
    "String CustomerAttributeImpl.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerAttributeImpl actualCustomerAttributeImpl = new CustomerAttributeImpl();
    CustomerImpl customer = new CustomerImpl();
    actualCustomerAttributeImpl.setCustomer(customer);
    actualCustomerAttributeImpl.setId(1L);
    actualCustomerAttributeImpl.setName("Name");
    actualCustomerAttributeImpl.setValue("42");
    Customer actualCustomer = actualCustomerAttributeImpl.getCustomer();
    Long actualId = actualCustomerAttributeImpl.getId();

    // Assert
    assertEquals("42", actualCustomerAttributeImpl.toString());
    assertEquals(1L, actualId.longValue());
    assertSame(customer, actualCustomer);
  }
}
