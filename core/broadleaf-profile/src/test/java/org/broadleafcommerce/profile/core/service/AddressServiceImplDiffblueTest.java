package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.service.exception.AddressVerificationException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml",
    "/bl-profile-applicationContext-persistence.xml", "/bl-profile-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-applicationContext.xml",
    "/blc-config/site/framework/bl-profile-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressServiceImplDiffblueTest {
  @Autowired
  private AddressServiceImpl addressServiceImpl;

  /**
   * Test {@link AddressServiceImpl#saveAddress(Address)}.
   * <p>
   * Method under test: {@link AddressServiceImpl#saveAddress(Address)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass431 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.AddressServiceImpl addressServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AddressServiceImpl addressServiceImpl2 = new AddressServiceImpl();

    // Act
    addressServiceImpl2.saveAddress(new AddressImpl());
  }

  /**
   * Test {@link AddressServiceImpl#readAddressById(Long)}.
   * <p>
   * Method under test: {@link AddressServiceImpl#readAddressById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAddressById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass415 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.AddressServiceImpl addressServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AddressServiceImpl()).readAddressById(1L);
  }

  /**
   * Test {@link AddressServiceImpl#create()}.
   * <p>
   * Method under test: {@link AddressServiceImpl#create()}
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
    //   public class DiffblueFakeClass335 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.AddressServiceImpl addressServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AddressServiceImpl()).create();
  }

  /**
   * Test {@link AddressServiceImpl#delete(Address)}.
   * <p>
   * Method under test: {@link AddressServiceImpl#delete(Address)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDelete() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass337 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.AddressServiceImpl addressServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AddressServiceImpl addressServiceImpl2 = new AddressServiceImpl();

    // Act
    addressServiceImpl2.delete(new AddressImpl());
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   * <p>
   * Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testVerifyAddress() throws AddressVerificationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass470 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.AddressServiceImpl addressServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AddressServiceImpl addressServiceImpl2 = new AddressServiceImpl();

    // Act
    addressServiceImpl2.verifyAddress(new AddressImpl());
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return first is {@link AddressImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  public void testVerifyAddress_givenNull_thenReturnFirstIsAddressImpl() throws AddressVerificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getStandardized()).thenReturn(null);

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(address);

    // Assert
    verify(address).getStandardized();
    assertEquals(1, actualVerifyAddressResult.size());
    assertSame(address, actualVerifyAddressResult.get(0));
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link AddressImpl} {@link AddressImpl#getStandardized()} return
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  public void testVerifyAddress_givenTrue_whenAddressImplGetStandardizedReturnTrue()
      throws AddressVerificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getStandardized()).thenReturn(true);

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(address);

    // Assert
    verify(address, atLeast(1)).getStandardized();
    assertEquals(1, actualVerifyAddressResult.size());
    assertSame(address, actualVerifyAddressResult.get(0));
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   * <ul>
   *   <li>Then throw {@link AddressVerificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  public void testVerifyAddress_thenThrowAddressVerificationException() throws AddressVerificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
    addressServiceImpl.setMustValidateAddresses(true);
    AddressImpl address = mock(AddressImpl.class);
    when(address.getStandardized()).thenReturn(null);

    // Act and Assert
    assertThrows(AddressVerificationException.class, () -> addressServiceImpl.verifyAddress(address));
    verify(address).getStandardized();
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor).</li>
   *   <li>Then return first is {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  public void testVerifyAddress_whenAddressImpl_thenReturnFirstIsAddressImpl() throws AddressVerificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
    AddressImpl address = new AddressImpl();

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(address);

    // Assert
    assertEquals(1, actualVerifyAddressResult.size());
    assertSame(address, actualVerifyAddressResult.get(0));
  }

  /**
   * Test {@link AddressServiceImpl#copyAddress(Address, Address)} with
   * {@code dest}, {@code orig}.
   * <p>
   * Method under test: {@link AddressServiceImpl#copyAddress(Address, Address)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCopyAddressWithDestOrig() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass259 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.AddressServiceImpl addressServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AddressServiceImpl addressServiceImpl2 = new AddressServiceImpl();
    AddressImpl dest = new AddressImpl();

    // Act
    addressServiceImpl2.copyAddress(dest, new AddressImpl());
  }

  /**
   * Test {@link AddressServiceImpl#copyAddress(Address, Address)} with
   * {@code dest}, {@code orig}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressServiceImpl#copyAddress(Address, Address)}
   */
  @Test
  public void testCopyAddressWithDestOrig_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();

    // Act and Assert
    assertNull(addressServiceImpl.copyAddress(new AddressImpl(), null));
  }

  /**
   * Test {@link AddressServiceImpl#copyAddress(Address)} with {@code orig}.
   * <p>
   * Method under test: {@link AddressServiceImpl#copyAddress(Address)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCopyAddressWithOrig() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass220 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.AddressServiceImpl addressServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AddressServiceImpl addressServiceImpl2 = new AddressServiceImpl();

    // Act
    addressServiceImpl2.copyAddress(new AddressImpl());
  }

  /**
   * Test {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}.
   * <p>
   * Method under test:
   * {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateAddressISOCountrySub() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass376 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.AddressServiceImpl addressServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AddressServiceImpl addressServiceImpl2 = new AddressServiceImpl();

    // Act
    addressServiceImpl2.populateAddressISOCountrySub(new AddressImpl());
  }

  /**
   * Test {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}.
   * <ul>
   *   <li>Given {@code GB}.</li>
   *   <li>Then calls {@link AddressImpl#getIsoCountrySubdivision()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}
   */
  @Test
  public void testPopulateAddressISOCountrySub_givenGb_thenCallsGetIsoCountrySubdivision() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getIsoCountrySubdivision()).thenReturn("GB");

    // Act
    addressServiceImpl.populateAddressISOCountrySub(address);

    // Assert
    verify(address).getIsoCountrySubdivision();
  }

  /**
   * Test {@link AddressServiceImpl#setMustValidateAddresses(boolean)}.
   * <p>
   * Method under test:
   * {@link AddressServiceImpl#setMustValidateAddresses(boolean)}
   */
  @Test
  public void testSetMustValidateAddresses() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     AddressServiceImpl.addressDao
    //     AddressServiceImpl.countrySubdivisionService
    //     AddressServiceImpl.moduleConfigService
    //     AddressServiceImpl.mustValidateAddresses
    //     AddressServiceImpl.phoneService
    //     AddressServiceImpl.providers

    // Arrange and Act
    (new AddressServiceImpl()).setMustValidateAddresses(true);
  }
}
