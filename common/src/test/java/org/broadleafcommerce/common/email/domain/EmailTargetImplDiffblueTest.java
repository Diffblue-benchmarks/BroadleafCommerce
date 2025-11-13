package org.broadleafcommerce.common.email.domain;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EmailTargetImplDiffblueTest {
  /**
   * Test {@link EmailTargetImpl#equals(Object)}, and {@link EmailTargetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailTargetImpl#equals(Object)}
   *   <li>{@link EmailTargetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmailTargetImpl.equals(Object)", "int EmailTargetImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl.setEmailAddress("42 Main St");

    EmailTargetImpl emailTargetImpl2 = new EmailTargetImpl();
    emailTargetImpl2.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl2.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl2.setEmailAddress("42 Main St");

    // Act and Assert
    assertEquals(emailTargetImpl, emailTargetImpl2);
    assertEquals(emailTargetImpl.hashCode(), emailTargetImpl2.hashCode());
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}, and {@link EmailTargetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailTargetImpl#equals(Object)}
   *   <li>{@link EmailTargetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmailTargetImpl.equals(Object)", "int EmailTargetImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl.setEmailAddress(null);

    EmailTargetImpl emailTargetImpl2 = new EmailTargetImpl();
    emailTargetImpl2.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl2.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl2.setEmailAddress(null);

    // Act and Assert
    assertEquals(emailTargetImpl, emailTargetImpl2);
    assertEquals(emailTargetImpl.hashCode(), emailTargetImpl2.hashCode());
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}, and {@link EmailTargetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailTargetImpl#equals(Object)}
   *   <li>{@link EmailTargetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmailTargetImpl.equals(Object)", "int EmailTargetImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl.setEmailAddress("42 Main St");

    // Act and Assert
    assertEquals(emailTargetImpl, emailTargetImpl);
    int expectedHashCodeResult = emailTargetImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTargetImpl.hashCode());
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTargetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmailTargetImpl.equals(Object)", "int EmailTargetImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(null);
    emailTargetImpl.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl.setEmailAddress("42 Main St");

    EmailTargetImpl emailTargetImpl2 = new EmailTargetImpl();
    emailTargetImpl2.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl2.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl2.setEmailAddress("42 Main St");

    // Act and Assert
    assertNotEquals(emailTargetImpl, emailTargetImpl2);
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTargetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmailTargetImpl.equals(Object)", "int EmailTargetImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(null);
    emailTargetImpl.setEmailAddress("42 Main St");

    EmailTargetImpl emailTargetImpl2 = new EmailTargetImpl();
    emailTargetImpl2.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl2.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl2.setEmailAddress("42 Main St");

    // Act and Assert
    assertNotEquals(emailTargetImpl, emailTargetImpl2);
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTargetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmailTargetImpl.equals(Object)", "int EmailTargetImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl.setEmailAddress("17 High St");

    EmailTargetImpl emailTargetImpl2 = new EmailTargetImpl();
    emailTargetImpl2.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl2.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl2.setEmailAddress("42 Main St");

    // Act and Assert
    assertNotEquals(emailTargetImpl, emailTargetImpl2);
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTargetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmailTargetImpl.equals(Object)", "int EmailTargetImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl.setEmailAddress(null);

    EmailTargetImpl emailTargetImpl2 = new EmailTargetImpl();
    emailTargetImpl2.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl2.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl2.setEmailAddress("42 Main St");

    // Act and Assert
    assertNotEquals(emailTargetImpl, emailTargetImpl2);
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTargetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmailTargetImpl.equals(Object)", "int EmailTargetImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl.setEmailAddress("42 Main St");

    // Act and Assert
    assertNotEquals(emailTargetImpl, null);
  }

  /**
   * Test {@link EmailTargetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTargetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmailTargetImpl.equals(Object)", "int EmailTargetImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl.setEmailAddress("42 Main St");

    // Act and Assert
    assertNotEquals(emailTargetImpl, "Different type to EmailTargetImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EmailTargetImpl}
   *   <li>{@link EmailTargetImpl#setBCCAddresses(String[])}
   *   <li>{@link EmailTargetImpl#setCCAddresses(String[])}
   *   <li>{@link EmailTargetImpl#setEmailAddress(String)}
   *   <li>{@link EmailTargetImpl#getBCCAddresses()}
   *   <li>{@link EmailTargetImpl#getCCAddresses()}
   *   <li>{@link EmailTargetImpl#getEmailAddress()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EmailTargetImpl.<init>()",
    "String[] EmailTargetImpl.getBCCAddresses()",
    "String[] EmailTargetImpl.getCCAddresses()",
    "String EmailTargetImpl.getEmailAddress()",
    "void EmailTargetImpl.setBCCAddresses(String[])",
    "void EmailTargetImpl.setCCAddresses(String[])",
    "void EmailTargetImpl.setEmailAddress(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EmailTargetImpl actualEmailTargetImpl = new EmailTargetImpl();
    String[] bccAddresses = new String[] {"mary.somerville@example.org"};
    actualEmailTargetImpl.setBCCAddresses(bccAddresses);
    String[] ccAddresses = new String[] {"42 Main St"};
    actualEmailTargetImpl.setCCAddresses(ccAddresses);
    actualEmailTargetImpl.setEmailAddress("42 Main St");
    String[] actualBCCAddresses = actualEmailTargetImpl.getBCCAddresses();
    String[] actualCCAddresses = actualEmailTargetImpl.getCCAddresses();

    // Assert
    assertEquals("42 Main St", actualEmailTargetImpl.getEmailAddress());
    assertSame(ccAddresses, actualCCAddresses);
    assertSame(bccAddresses, actualBCCAddresses);
    assertArrayEquals(new String[] {"42 Main St"}, actualCCAddresses);
    assertArrayEquals(new String[] {"mary.somerville@example.org"}, actualBCCAddresses);
  }
}
