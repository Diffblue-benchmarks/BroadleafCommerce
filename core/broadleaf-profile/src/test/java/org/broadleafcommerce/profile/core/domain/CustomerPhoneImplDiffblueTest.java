package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
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
public class CustomerPhoneImplDiffblueTest {
  @Autowired
  private CustomerPhoneImpl customerPhoneImpl;

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}, and
   * {@link CustomerPhoneImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerPhoneImpl#equals(Object)}
   *   <li>{@link CustomerPhoneImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    customerPhoneImpl.setId(1L);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName("6625550144");

    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    customerPhoneImpl2.setCustomer(new CustomerImpl());
    customerPhoneImpl2.setId(1L);
    customerPhoneImpl2.setPhone(new PhoneImpl());
    customerPhoneImpl2.setPhoneName("6625550144");

    // Act and Assert
    assertEquals(customerPhoneImpl, customerPhoneImpl2);
    int expectedHashCodeResult = customerPhoneImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerPhoneImpl2.hashCode());
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}, and
   * {@link CustomerPhoneImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerPhoneImpl#equals(Object)}
   *   <li>{@link CustomerPhoneImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(mock(Customer.class));
    customerPhoneImpl.setId(1L);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName("6625550144");

    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    customerPhoneImpl2.setCustomer(new CustomerImpl());
    customerPhoneImpl2.setId(1L);
    customerPhoneImpl2.setPhone(new PhoneImpl());
    customerPhoneImpl2.setPhoneName("6625550144");

    // Act and Assert
    assertEquals(customerPhoneImpl, customerPhoneImpl2);
    int notExpectedHashCodeResult = customerPhoneImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, customerPhoneImpl2.hashCode());
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}, and
   * {@link CustomerPhoneImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerPhoneImpl#equals(Object)}
   *   <li>{@link CustomerPhoneImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    customerPhoneImpl.setId(null);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName("6625550144");

    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    customerPhoneImpl2.setCustomer(new CustomerImpl());
    customerPhoneImpl2.setId(1L);
    customerPhoneImpl2.setPhone(new PhoneImpl());
    customerPhoneImpl2.setPhoneName("6625550144");

    // Act and Assert
    assertEquals(customerPhoneImpl, customerPhoneImpl2);
    int expectedHashCodeResult = customerPhoneImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerPhoneImpl2.hashCode());
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}, and
   * {@link CustomerPhoneImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerPhoneImpl#equals(Object)}
   *   <li>{@link CustomerPhoneImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    customerPhoneImpl.setId(1L);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName("6625550144");

    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    customerPhoneImpl2.setCustomer(new CustomerImpl());
    customerPhoneImpl2.setId(null);
    customerPhoneImpl2.setPhone(new PhoneImpl());
    customerPhoneImpl2.setPhoneName("6625550144");

    // Act and Assert
    assertEquals(customerPhoneImpl, customerPhoneImpl2);
    int expectedHashCodeResult = customerPhoneImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerPhoneImpl2.hashCode());
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}, and
   * {@link CustomerPhoneImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerPhoneImpl#equals(Object)}
   *   <li>{@link CustomerPhoneImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(null);
    customerPhoneImpl.setId(null);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName("6625550144");

    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    customerPhoneImpl2.setCustomer(null);
    customerPhoneImpl2.setId(1L);
    customerPhoneImpl2.setPhone(new PhoneImpl());
    customerPhoneImpl2.setPhoneName("6625550144");

    // Act and Assert
    assertEquals(customerPhoneImpl, customerPhoneImpl2);
    int expectedHashCodeResult = customerPhoneImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerPhoneImpl2.hashCode());
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}, and
   * {@link CustomerPhoneImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerPhoneImpl#equals(Object)}
   *   <li>{@link CustomerPhoneImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    customerPhoneImpl.setId(null);
    customerPhoneImpl.setPhone(null);
    customerPhoneImpl.setPhoneName("6625550144");

    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    customerPhoneImpl2.setCustomer(new CustomerImpl());
    customerPhoneImpl2.setId(1L);
    customerPhoneImpl2.setPhone(null);
    customerPhoneImpl2.setPhoneName("6625550144");

    // Act and Assert
    assertEquals(customerPhoneImpl, customerPhoneImpl2);
    int expectedHashCodeResult = customerPhoneImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerPhoneImpl2.hashCode());
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}, and
   * {@link CustomerPhoneImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerPhoneImpl#equals(Object)}
   *   <li>{@link CustomerPhoneImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    customerPhoneImpl.setId(1L);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName("6625550144");

    // Act and Assert
    assertEquals(customerPhoneImpl, customerPhoneImpl);
    int expectedHashCodeResult = customerPhoneImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerPhoneImpl.hashCode());
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPhoneImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    customerPhoneImpl.setId(2L);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName("6625550144");

    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    customerPhoneImpl2.setCustomer(new CustomerImpl());
    customerPhoneImpl2.setId(1L);
    customerPhoneImpl2.setPhone(new PhoneImpl());
    customerPhoneImpl2.setPhoneName("6625550144");

    // Act and Assert
    assertNotEquals(customerPhoneImpl, customerPhoneImpl2);
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPhoneImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(mock(Customer.class));
    customerPhoneImpl.setId(null);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName("6625550144");

    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    customerPhoneImpl2.setCustomer(new CustomerImpl());
    customerPhoneImpl2.setId(1L);
    customerPhoneImpl2.setPhone(new PhoneImpl());
    customerPhoneImpl2.setPhoneName("6625550144");

    // Act and Assert
    assertNotEquals(customerPhoneImpl, customerPhoneImpl2);
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPhoneImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(null);
    customerPhoneImpl.setId(null);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName("6625550144");

    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    customerPhoneImpl2.setCustomer(new CustomerImpl());
    customerPhoneImpl2.setId(1L);
    customerPhoneImpl2.setPhone(new PhoneImpl());
    customerPhoneImpl2.setPhoneName("6625550144");

    // Act and Assert
    assertNotEquals(customerPhoneImpl, customerPhoneImpl2);
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPhoneImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    customerPhoneImpl.setId(null);
    customerPhoneImpl.setPhone(null);
    customerPhoneImpl.setPhoneName("6625550144");

    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    customerPhoneImpl2.setCustomer(new CustomerImpl());
    customerPhoneImpl2.setId(1L);
    customerPhoneImpl2.setPhone(new PhoneImpl());
    customerPhoneImpl2.setPhoneName("6625550144");

    // Act and Assert
    assertNotEquals(customerPhoneImpl, customerPhoneImpl2);
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPhoneImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    customerPhoneImpl.setId(null);
    customerPhoneImpl.setPhone(mock(PhoneImpl.class));
    customerPhoneImpl.setPhoneName("6625550144");

    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    customerPhoneImpl2.setCustomer(new CustomerImpl());
    customerPhoneImpl2.setId(1L);
    customerPhoneImpl2.setPhone(new PhoneImpl());
    customerPhoneImpl2.setPhoneName("6625550144");

    // Act and Assert
    assertNotEquals(customerPhoneImpl, customerPhoneImpl2);
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPhoneImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    customerPhoneImpl.setId(null);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName("8605550118");

    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    customerPhoneImpl2.setCustomer(new CustomerImpl());
    customerPhoneImpl2.setId(1L);
    customerPhoneImpl2.setPhone(new PhoneImpl());
    customerPhoneImpl2.setPhoneName("6625550144");

    // Act and Assert
    assertNotEquals(customerPhoneImpl, customerPhoneImpl2);
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPhoneImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    customerPhoneImpl.setId(null);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName(null);

    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    customerPhoneImpl2.setCustomer(new CustomerImpl());
    customerPhoneImpl2.setId(1L);
    customerPhoneImpl2.setPhone(new PhoneImpl());
    customerPhoneImpl2.setPhoneName("6625550144");

    // Act and Assert
    assertNotEquals(customerPhoneImpl, customerPhoneImpl2);
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPhoneImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    customerPhoneImpl.setId(1L);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName("6625550144");

    // Act and Assert
    assertNotEquals(customerPhoneImpl, null);
  }

  /**
   * Test {@link CustomerPhoneImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPhoneImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    customerPhoneImpl.setId(1L);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName("6625550144");

    // Act and Assert
    assertNotEquals(customerPhoneImpl, "Different type to CustomerPhoneImpl");
  }

  /**
   * Test
   * {@link CustomerPhoneImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CustomerPhone> actualCreateOrRetrieveCopyInstanceResult = customerPhoneImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link CustomerPhoneImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4126 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.domain.CustomerPhoneImpl customerPhoneImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    customerPhoneImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test
   * {@link CustomerPhoneImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link CustomerPhoneImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPhoneImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnCustomerPhoneImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<CustomerPhone> actualCreateOrRetrieveCopyInstanceResult = customerPhoneImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.profile.core.domain.CustomerPhoneImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    CustomerPhone clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof CustomerPhoneImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(customerPhoneImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerPhoneImpl}
   *   <li>{@link CustomerPhoneImpl#setCustomer(Customer)}
   *   <li>{@link CustomerPhoneImpl#setId(Long)}
   *   <li>{@link CustomerPhoneImpl#setPhone(Phone)}
   *   <li>{@link CustomerPhoneImpl#setPhoneName(String)}
   *   <li>{@link CustomerPhoneImpl#getCustomer()}
   *   <li>{@link CustomerPhoneImpl#getId()}
   *   <li>{@link CustomerPhoneImpl#getPhone()}
   *   <li>{@link CustomerPhoneImpl#getPhoneName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerPhoneImpl actualCustomerPhoneImpl = new CustomerPhoneImpl();
    CustomerImpl customer = new CustomerImpl();
    actualCustomerPhoneImpl.setCustomer(customer);
    actualCustomerPhoneImpl.setId(1L);
    PhoneImpl phone = new PhoneImpl();
    actualCustomerPhoneImpl.setPhone(phone);
    actualCustomerPhoneImpl.setPhoneName("6625550144");
    Customer actualCustomer = actualCustomerPhoneImpl.getCustomer();
    Long actualId = actualCustomerPhoneImpl.getId();
    Phone actualPhone = actualCustomerPhoneImpl.getPhone();

    // Assert that nothing has changed
    assertEquals("6625550144", actualCustomerPhoneImpl.getPhoneName());
    assertEquals(1L, actualId.longValue());
    assertSame(customer, actualCustomer);
    assertSame(phone, actualPhone);
  }
}
