package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml",
    "/bl-profile-applicationContext-persistence.xml", "/bl-profile-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-applicationContext.xml",
    "/blc-config/site/framework/bl-profile-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PhoneServiceImplDiffblueTest {
  @Autowired
  private PhoneServiceImpl phoneServiceImpl;

  /**
   * Test {@link PhoneServiceImpl#savePhone(Phone)}.
   * <p>
   * Method under test: {@link PhoneServiceImpl#savePhone(Phone)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSavePhone() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4163 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.PhoneServiceImpl phoneServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PhoneServiceImpl phoneServiceImpl2 = new PhoneServiceImpl();

    // Act
    phoneServiceImpl2.savePhone(new PhoneImpl());
  }

  /**
   * Test {@link PhoneServiceImpl#readPhoneById(Long)}.
   * <p>
   * Method under test: {@link PhoneServiceImpl#readPhoneById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadPhoneById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4148 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.PhoneServiceImpl phoneServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PhoneServiceImpl()).readPhoneById(1L);
  }

  /**
   * Test {@link PhoneServiceImpl#create()}.
   * <p>
   * Method under test: {@link PhoneServiceImpl#create()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4147 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.PhoneServiceImpl phoneServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PhoneServiceImpl()).create();
  }

  /**
   * Test {@link PhoneServiceImpl#copyPhone(Phone, Phone)} with {@code dest},
   * {@code orig}.
   * <p>
   * Method under test: {@link PhoneServiceImpl#copyPhone(Phone, Phone)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCopyPhoneWithDestOrig() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4126 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.PhoneServiceImpl phoneServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PhoneServiceImpl phoneServiceImpl2 = new PhoneServiceImpl();
    PhoneImpl dest = new PhoneImpl();

    // Act
    phoneServiceImpl2.copyPhone(dest, new PhoneImpl());
  }

  /**
   * Test {@link PhoneServiceImpl#copyPhone(Phone, Phone)} with {@code dest},
   * {@code orig}.
   * <ul>
   *   <li>Then return {@link PhoneImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneServiceImpl#copyPhone(Phone, Phone)}
   */
  @Test
  public void testCopyPhoneWithDestOrig_thenReturnPhoneImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();
    PhoneImpl dest = mock(PhoneImpl.class);
    doNothing().when(dest).setCountryCode(Mockito.<String>any());
    doNothing().when(dest).setExtension(Mockito.<String>any());
    doNothing().when(dest).setPhoneNumber(Mockito.<String>any());

    // Act
    Phone actualCopyPhoneResult = phoneServiceImpl.copyPhone(dest, new PhoneImpl());

    // Assert
    verify(dest).setCountryCode(isNull());
    verify(dest).setExtension(isNull());
    verify(dest).setPhoneNumber(isNull());
    assertSame(dest, actualCopyPhoneResult);
  }

  /**
   * Test {@link PhoneServiceImpl#copyPhone(Phone, Phone)} with {@code dest},
   * {@code orig}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneServiceImpl#copyPhone(Phone, Phone)}
   */
  @Test
  public void testCopyPhoneWithDestOrig_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();

    // Act and Assert
    assertNull(phoneServiceImpl.copyPhone(new PhoneImpl(), null));
  }

  /**
   * Test {@link PhoneServiceImpl#copyPhone(Phone, Phone)} with {@code dest},
   * {@code orig}.
   * <ul>
   *   <li>When {@link PhoneImpl} (default constructor).</li>
   *   <li>Then return {@link PhoneImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneServiceImpl#copyPhone(Phone, Phone)}
   */
  @Test
  public void testCopyPhoneWithDestOrig_whenPhoneImpl_thenReturnPhoneImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();
    PhoneImpl dest = new PhoneImpl();

    // Act and Assert
    assertSame(dest, phoneServiceImpl.copyPhone(dest, new PhoneImpl()));
  }

  /**
   * Test {@link PhoneServiceImpl#copyPhone(Phone)} with {@code orig}.
   * <p>
   * Method under test: {@link PhoneServiceImpl#copyPhone(Phone)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCopyPhoneWithOrig() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4115 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.PhoneServiceImpl phoneServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PhoneServiceImpl phoneServiceImpl2 = new PhoneServiceImpl();

    // Act
    phoneServiceImpl2.copyPhone(new PhoneImpl());
  }
}
