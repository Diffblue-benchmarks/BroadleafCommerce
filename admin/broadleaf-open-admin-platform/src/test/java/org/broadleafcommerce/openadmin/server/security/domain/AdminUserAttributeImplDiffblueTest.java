package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-open-admin-applicationContext-entity.xml",
    "/applicationContext-servlet-open-admin.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminUserAttributeImplDiffblueTest {
  @Autowired
  private AdminUserAttributeImpl adminUserAttributeImpl;

  /**
   * Test {@link AdminUserAttributeImpl#getValue()}.
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#getValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-open-admin-applicationContext-entity.xml","/applicationContext-servlet-open-admin.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass26 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.domain.AdminUserAttributeImpl adminUserAttributeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminUserAttributeImpl()).getValue();
  }

  /**
   * Test {@link AdminUserAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link AdminUserAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenAdminUserAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminUserAttributeImpl()).getValue());
  }

  /**
   * Test {@link AdminUserAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link AdminUserAttributeImpl} (default constructor) AdminUser is
   * {@link AdminUserImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenAdminUserAttributeImplAdminUserIsAdminUserImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(mock(AdminUserImpl.class));

    // Act and Assert
    assertNull(adminUserAttributeImpl.getValue());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}, and
   * {@link AdminUserAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminUserAttributeImpl#equals(Object)}
   *   <li>{@link AdminUserAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int notExpectedHashCodeResult = adminUserAttributeImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, adminUserAttributeImpl2.hashCode());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}, and
   * {@link AdminUserAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminUserAttributeImpl#equals(Object)}
   *   <li>{@link AdminUserAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(mock(AdminUser.class));
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
    int notExpectedHashCodeResult = adminUserAttributeImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, adminUserAttributeImpl2.hashCode());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}, and
   * {@link AdminUserAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminUserAttributeImpl#equals(Object)}
   *   <li>{@link AdminUserAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
    int expectedHashCodeResult = adminUserAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, adminUserAttributeImpl2.hashCode());
  }

  /**
   * Test {@link AdminUserAttributeImpl#equals(Object)}, and
   * {@link AdminUserAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminUserAttributeImpl#equals(Object)}
   *   <li>{@link AdminUserAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserAttributeImpl#equals(Object)}
   */
  @Test
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
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("42", actualAdminUserAttributeImpl.getValue());
    assertEquals("42", actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(1L, actualId.longValue());
    assertSame(adminUser, actualAdminUser);
  }
}
