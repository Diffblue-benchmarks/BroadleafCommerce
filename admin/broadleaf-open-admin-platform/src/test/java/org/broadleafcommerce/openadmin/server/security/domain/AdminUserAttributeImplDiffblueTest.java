package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-open-admin-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminUserAttributeImplDiffblueTest {
  @Autowired private AdminUserAttributeImpl adminUserAttributeImpl;

  /**
   * Test {@link AdminUserAttributeImpl#getValue()}.
   *
   * <p>Method under test: {@link AdminUserAttributeImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminUserAttributeImpl.getValue()"})
  public void testGetValue() {
    // Arrange, Act and Assert
    assertNull(adminUserAttributeImpl.getValue());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}, and {@link
   * AdminUserAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminUserAttributeImpl#equals(Object)}
   *   <li>{@link AdminUserAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
    assertNotEquals(adminUserAttributeImpl.hashCode(), adminUserAttributeImpl2.hashCode());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}, and {@link
   * AdminUserAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminUserAttributeImpl#equals(Object)}
   *   <li>{@link AdminUserAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(null);
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(null);
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
    assertEquals(adminUserAttributeImpl.hashCode(), adminUserAttributeImpl2.hashCode());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}, and {@link
   * AdminUserAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminUserAttributeImpl#equals(Object)}
   *   <li>{@link AdminUserAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(null);
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue(null);

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(null);
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue(null);

    // Act and Assert
    assertEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
    assertEquals(adminUserAttributeImpl.hashCode(), adminUserAttributeImpl2.hashCode());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}, and {@link
   * AdminUserAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminUserAttributeImpl#equals(Object)}
   *   <li>{@link AdminUserAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(adminUserAttributeImpl, adminUserAttributeImpl);
    int expectedHashCodeResult = adminUserAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, adminUserAttributeImpl.hashCode());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(2L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(null);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(null);
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName(null);
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName("java.lang.String");
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName(null);
    adminUserAttributeImpl.setValue("42");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName(null);
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(null);
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("Name");

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(null);
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(null);
    adminUserAttributeImpl.setId(null);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue(null);

    AdminUserAttributeImpl adminUserAttributeImpl2 = new AdminUserAttributeImpl();
    adminUserAttributeImpl2.setAdminUser(null);
    adminUserAttributeImpl2.setId(1L);
    adminUserAttributeImpl2.setName("Name");
    adminUserAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, adminUserAttributeImpl2);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, null);
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminUserAttributeImpl.equals(Object)",
    "int AdminUserAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(adminUserAttributeImpl, "Different type to AdminUserAttributeImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminUserAttributeImpl}
   *   <li>{@link AdminUserAttributeImpl#setAdminUser(AdminUser)}
   *   <li>{@link AdminUserAttributeImpl#setId(Long)}
   *   <li>{@link AdminUserAttributeImpl#setName(String)}
   *   <li>{@link AdminUserAttributeImpl#setValue(String)}
   *   <li>{@link AdminUserAttributeImpl#getAdminUser()}
   *   <li>{@link AdminUserAttributeImpl#getId()}
   *   <li>{@link AdminUserAttributeImpl#getName()}
   *   <li>{@link AdminUserAttributeImpl#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserAttributeImpl.<init>()",
    "AdminUser AdminUserAttributeImpl.getAdminUser()",
    "Long AdminUserAttributeImpl.getId()",
    "String AdminUserAttributeImpl.getName()",
    "void AdminUserAttributeImpl.setAdminUser(AdminUser)",
    "void AdminUserAttributeImpl.setId(Long)",
    "void AdminUserAttributeImpl.setName(String)",
    "void AdminUserAttributeImpl.setValue(String)",
    "String AdminUserAttributeImpl.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminUserAttributeImpl actualAdminUserAttributeImpl = new AdminUserAttributeImpl();
    AdminUserImpl adminUser = new AdminUserImpl();
    actualAdminUserAttributeImpl.setAdminUser(adminUser);
    actualAdminUserAttributeImpl.setId(1L);
    actualAdminUserAttributeImpl.setName("Name");
    actualAdminUserAttributeImpl.setValue("42");
    AdminUser actualAdminUser = actualAdminUserAttributeImpl.getAdminUser();
    Long actualId = actualAdminUserAttributeImpl.getId();
    String actualName = actualAdminUserAttributeImpl.getName();
    String actualToStringResult = actualAdminUserAttributeImpl.toString();

    // Assert
    assertEquals("42", actualAdminUserAttributeImpl.getValue());
    assertEquals("42", actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(1L, actualId.longValue());
    assertSame(adminUser, actualAdminUser);
  }
}
