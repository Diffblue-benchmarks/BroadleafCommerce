package org.broadleafcommerce.core.offer.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CustomerMaxUsesStrategyType.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerMaxUsesStrategyTypeDiffblueTest {
  @Autowired private CustomerMaxUsesStrategyType customerMaxUsesStrategyType;

  /**
   * Test {@link CustomerMaxUsesStrategyType#getInstance(String)}.
   *
   * <p>Method under test: {@link CustomerMaxUsesStrategyType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerMaxUsesStrategyType CustomerMaxUsesStrategyType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    CustomerMaxUsesStrategyType actualInstance = CustomerMaxUsesStrategyType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerMaxUsesStrategyType#CustomerMaxUsesStrategyType()}
   *   <li>{@link CustomerMaxUsesStrategyType#getFriendlyType()}
   *   <li>{@link CustomerMaxUsesStrategyType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerMaxUsesStrategyType.<init>()",
    "String CustomerMaxUsesStrategyType.getFriendlyType()",
    "String CustomerMaxUsesStrategyType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerMaxUsesStrategyType actualCustomerMaxUsesStrategyType =
        new CustomerMaxUsesStrategyType();
    String actualFriendlyType = actualCustomerMaxUsesStrategyType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualCustomerMaxUsesStrategyType.getType());
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#CustomerMaxUsesStrategyType(String, String)}.
   *
   * <p>Method under test: {@link CustomerMaxUsesStrategyType#CustomerMaxUsesStrategyType(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerMaxUsesStrategyType.<init>(String, String)"})
  public void testNewCustomerMaxUsesStrategyType() {
    // Arrange and Act
    CustomerMaxUsesStrategyType actualCustomerMaxUsesStrategyType =
        new CustomerMaxUsesStrategyType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualCustomerMaxUsesStrategyType.getFriendlyType());
    assertEquals("Type", actualCustomerMaxUsesStrategyType.getType());
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code 42ACCOUNT}.
   *   <li>Then {@link CustomerMaxUsesStrategyType} Type is {@code 42ACCOUNT}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerMaxUsesStrategyType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerMaxUsesStrategyType.setType(String)"})
  public void testSetType_when42account_thenCustomerMaxUsesStrategyTypeTypeIs42account() {
    // Arrange and Act
    customerMaxUsesStrategyType.setType("42ACCOUNT");

    // Assert
    assertEquals("42ACCOUNT", customerMaxUsesStrategyType.getType());
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then {@link CustomerMaxUsesStrategyType} Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerMaxUsesStrategyType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerMaxUsesStrategyType.setType(String)"})
  public void testSetType_whenType_thenCustomerMaxUsesStrategyTypeTypeIsType() {
    // Arrange and Act
    customerMaxUsesStrategyType.setType("Type");

    // Assert
    assertEquals("Type", customerMaxUsesStrategyType.getType());
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}, and {@link
   * CustomerMaxUsesStrategyType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerMaxUsesStrategyType#equals(Object)}
   *   <li>{@link CustomerMaxUsesStrategyType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerMaxUsesStrategyType.equals(Object)",
    "int CustomerMaxUsesStrategyType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType = CustomerMaxUsesStrategyType.ACCOUNT;
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType2 = CustomerMaxUsesStrategyType.ACCOUNT;

    // Act and Assert
    assertEquals(customerMaxUsesStrategyType, customerMaxUsesStrategyType2);
    assertEquals(customerMaxUsesStrategyType.hashCode(), customerMaxUsesStrategyType2.hashCode());
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}, and {@link
   * CustomerMaxUsesStrategyType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerMaxUsesStrategyType#equals(Object)}
   *   <li>{@link CustomerMaxUsesStrategyType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerMaxUsesStrategyType.equals(Object)",
    "int CustomerMaxUsesStrategyType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType = CustomerMaxUsesStrategyType.CUSTOMER;
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType2 =
        new CustomerMaxUsesStrategyType("CUSTOMER", "CUSTOMER");

    // Act and Assert
    assertEquals(customerMaxUsesStrategyType, customerMaxUsesStrategyType2);
    assertEquals(customerMaxUsesStrategyType.hashCode(), customerMaxUsesStrategyType2.hashCode());
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}, and {@link
   * CustomerMaxUsesStrategyType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerMaxUsesStrategyType#equals(Object)}
   *   <li>{@link CustomerMaxUsesStrategyType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerMaxUsesStrategyType.equals(Object)",
    "int CustomerMaxUsesStrategyType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType = new CustomerMaxUsesStrategyType();
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType2 = new CustomerMaxUsesStrategyType();

    // Act and Assert
    assertEquals(customerMaxUsesStrategyType, customerMaxUsesStrategyType2);
    assertEquals(customerMaxUsesStrategyType.hashCode(), customerMaxUsesStrategyType2.hashCode());
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}, and {@link
   * CustomerMaxUsesStrategyType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerMaxUsesStrategyType#equals(Object)}
   *   <li>{@link CustomerMaxUsesStrategyType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerMaxUsesStrategyType.equals(Object)",
    "int CustomerMaxUsesStrategyType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerMaxUsesStrategyType customerMaxUsesStrategyType = CustomerMaxUsesStrategyType.ACCOUNT;

    // Act and Assert
    assertEquals(customerMaxUsesStrategyType, customerMaxUsesStrategyType);
    int expectedHashCodeResult = customerMaxUsesStrategyType.hashCode();
    assertEquals(expectedHashCodeResult, customerMaxUsesStrategyType.hashCode());
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerMaxUsesStrategyType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerMaxUsesStrategyType.equals(Object)",
    "int CustomerMaxUsesStrategyType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CustomerMaxUsesStrategyType.CUSTOMER, CustomerMaxUsesStrategyType.ACCOUNT);
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerMaxUsesStrategyType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerMaxUsesStrategyType.equals(Object)",
    "int CustomerMaxUsesStrategyType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new CustomerMaxUsesStrategyType(), CustomerMaxUsesStrategyType.ACCOUNT);
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerMaxUsesStrategyType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerMaxUsesStrategyType.equals(Object)",
    "int CustomerMaxUsesStrategyType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CustomerMaxUsesStrategyType.ACCOUNT, null);
  }

  /**
   * Test {@link CustomerMaxUsesStrategyType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerMaxUsesStrategyType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerMaxUsesStrategyType.equals(Object)",
    "int CustomerMaxUsesStrategyType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        CustomerMaxUsesStrategyType.ACCOUNT, "Different type to CustomerMaxUsesStrategyType");
  }
}
