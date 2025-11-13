package org.broadleafcommerce.core.web.controller.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.web.controller.account.validator.CustomerAddressValidator;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerAddress;
import org.broadleafcommerce.profile.core.domain.CustomerAddressImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.service.AddressService;
import org.broadleafcommerce.profile.core.service.CustomerAddressService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafManageCustomerAddressesControllerDiffblueTest {
  @Mock private AddressService addressService;

  @InjectMocks
  private BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController;

  @Mock private CustomerAddressService customerAddressService;

  @Mock private CustomerAddressValidator customerAddressValidator;

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddresses(HttpServletRequest, Model)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddresses(HttpServletRequest, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.viewCustomerAddresses(HttpServletRequest, Model)"
  })
  public void testViewCustomerAddresses() {
    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController =
        new BroadleafManageCustomerAddressesController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewCustomerAddressesResult =
        broadleafManageCustomerAddressesController.viewCustomerAddresses(request, model);

    // Assert
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    assertTrue(((CustomerAddressForm) getResult).getAddress() instanceof AddressImpl);
    assertEquals("account/manageCustomerAddresses", actualViewCustomerAddressesResult);
    assertNull(((CustomerAddressForm) getResult).getCustomerAddressId());
    assertNull(((CustomerAddressForm) getResult).getAddressName());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest,
   * Model, Long)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"
  })
  public void testViewCustomerAddress() {
    // Arrange
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.viewCustomerAddress(
                request, new ConcurrentModel(), 1L));
    verify(customerAddressService).readCustomerAddressById(1L);
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest,
   * Model, Long)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"
  })
  public void testViewCustomerAddress2() {
    // Arrange
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.viewCustomerAddress(
                request, new ConcurrentModel(), 1L));
    verify(customerAddressService).readCustomerAddressById(1L);
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest,
   * Model, Long)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"
  })
  public void testViewCustomerAddress3() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getAddress()).thenThrow(new IllegalArgumentException());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(customerAddressImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.viewCustomerAddress(
                request, new ConcurrentModel(), 1L));
    verify(customerAddressImpl).getAddress();
    verify(customerAddressService).readCustomerAddressById(1L);
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest,
   * Model, Long)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"
  })
  public void testViewCustomerAddress4() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getAddressName()).thenThrow(new IllegalArgumentException());
    when(customerAddressImpl.getAddress()).thenReturn(new AddressImpl());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(customerAddressImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.viewCustomerAddress(
                request, new ConcurrentModel(), 1L));
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressService).readCustomerAddressById(1L);
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest,
   * Model, Long)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"
  })
  public void testViewCustomerAddress5() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setPrimaryPhone("6625550144");

    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(customerAddressImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafManageCustomerAddressesController.viewCustomerAddress(request, model, 1L);

    // Assert
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(1L);
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    Address address = ((CustomerAddressForm) getResult).getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    assertEquals("6625550144", address.getPrimaryPhone());
    assertEquals("6625550144", phonePrimary.getPhoneNumber());
    assertNull(phonePrimary.getId());
    assertNull(phonePrimary.getCountryCode());
    assertNull(phonePrimary.getExtension());
    assertFalse(phonePrimary.isDefault());
    assertTrue(phonePrimary.isActive());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest,
   * Model, Long)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"
  })
  public void testViewCustomerAddress6() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setSecondaryPhone("6625550144");

    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(customerAddressImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafManageCustomerAddressesController.viewCustomerAddress(request, model, 1L);

    // Assert
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(1L);
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    Address address = ((CustomerAddressForm) getResult).getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals("6625550144", address.getSecondaryPhone());
    assertEquals("6625550144", phoneSecondary.getPhoneNumber());
    assertNull(phoneSecondary.getId());
    assertNull(phoneSecondary.getCountryCode());
    assertNull(phoneSecondary.getExtension());
    assertFalse(phoneSecondary.isDefault());
    assertTrue(phoneSecondary.isActive());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest,
   * Model, Long)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"
  })
  public void testViewCustomerAddress7() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setFax("customerAddressForm");

    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(customerAddressImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafManageCustomerAddressesController.viewCustomerAddress(request, model, 1L);

    // Assert
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(1L);
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    Address address = ((CustomerAddressForm) getResult).getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals("customerAddressForm", address.getFax());
    assertEquals("customerAddressForm", phoneFax.getPhoneNumber());
    assertNull(phonePrimary.getPhoneNumber());
    assertEquals(phonePrimary, phoneSecondary);
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest,
   * Model, Long)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhoneFax()} return {@link PhoneImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"
  })
  public void testViewCustomerAddress_givenAddressImplGetPhoneFaxReturnPhoneImpl() {
    // Arrange
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getPhoneFax()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhoneSecondary()).thenReturn(new PhoneImpl());

    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(customerAddressImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewCustomerAddressResult =
        broadleafManageCustomerAddressesController.viewCustomerAddress(request, model, 1L);

    // Assert
    verify(addressImpl).getPhoneFax();
    verify(addressImpl).getPhonePrimary();
    verify(addressImpl).getPhoneSecondary();
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(1L);
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    assertEquals("42 Main St", ((CustomerAddressForm) getResult).getAddressName());
    assertEquals("account/manageCustomerAddresses", actualViewCustomerAddressResult);
    assertEquals(1L, ((CustomerAddressForm) getResult).getCustomerAddressId().longValue());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest,
   * Model, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link AddressImpl#setPhoneFax(Phone)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"
  })
  public void testViewCustomerAddress_thenCallsSetPhoneFax() {
    // Arrange
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getPhoneFax()).thenReturn(null);
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(addressImpl).setPhoneFax(Mockito.<Phone>any());

    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(customerAddressImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewCustomerAddressResult =
        broadleafManageCustomerAddressesController.viewCustomerAddress(request, model, 1L);

    // Assert
    verify(addressImpl).getPhoneFax();
    verify(addressImpl).getPhonePrimary();
    verify(addressImpl).getPhoneSecondary();
    verify(addressImpl).setPhoneFax(isA(Phone.class));
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(1L);
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    assertEquals("42 Main St", ((CustomerAddressForm) getResult).getAddressName());
    assertEquals("account/manageCustomerAddresses", actualViewCustomerAddressResult);
    assertEquals(1L, ((CustomerAddressForm) getResult).getCustomerAddressId().longValue());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest,
   * Model, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link AddressImpl#setPhonePrimary(Phone)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"
  })
  public void testViewCustomerAddress_thenCallsSetPhonePrimary() {
    // Arrange
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getPhoneFax()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhonePrimary()).thenReturn(null);
    when(addressImpl.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(addressImpl).setPhonePrimary(Mockito.<Phone>any());

    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(customerAddressImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewCustomerAddressResult =
        broadleafManageCustomerAddressesController.viewCustomerAddress(request, model, 1L);

    // Assert
    verify(addressImpl).getPhoneFax();
    verify(addressImpl).getPhonePrimary();
    verify(addressImpl).getPhoneSecondary();
    verify(addressImpl).setPhonePrimary(isA(Phone.class));
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(1L);
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    assertEquals("42 Main St", ((CustomerAddressForm) getResult).getAddressName());
    assertEquals("account/manageCustomerAddresses", actualViewCustomerAddressResult);
    assertEquals(1L, ((CustomerAddressForm) getResult).getCustomerAddressId().longValue());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest,
   * Model, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link AddressImpl#setPhoneSecondary(Phone)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"
  })
  public void testViewCustomerAddress_thenCallsSetPhoneSecondary() {
    // Arrange
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getPhoneFax()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhoneSecondary()).thenReturn(null);
    doNothing().when(addressImpl).setPhoneSecondary(Mockito.<Phone>any());

    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(customerAddressImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewCustomerAddressResult =
        broadleafManageCustomerAddressesController.viewCustomerAddress(request, model, 1L);

    // Assert
    verify(addressImpl).getPhoneFax();
    verify(addressImpl).getPhonePrimary();
    verify(addressImpl).getPhoneSecondary();
    verify(addressImpl).setPhoneSecondary(isA(Phone.class));
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(1L);
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    assertEquals("42 Main St", ((CustomerAddressForm) getResult).getAddressName());
    assertEquals("account/manageCustomerAddresses", actualViewCustomerAddressResult);
    assertEquals(1L, ((CustomerAddressForm) getResult).getCustomerAddressId().longValue());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest,
   * Model, Long)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code customerAddressForm} Address Fax is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"
  })
  public void testViewCustomerAddress_thenConcurrentModelCustomerAddressFormAddressFaxIsNull() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(new AddressImpl());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(customerAddressImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafManageCustomerAddressesController.viewCustomerAddress(request, model, 1L);

    // Assert
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(1L);
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    Address address = ((CustomerAddressForm) getResult).getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    assertNull(address.getFax());
    assertNull(address.getPrimaryPhone());
    assertNull(address.getSecondaryPhone());
    assertNull(phoneFax.getPhoneNumber());
    assertEquals(phoneFax, phonePrimary);
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest,
   * Model, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest, Model,
   * CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testAddCustomerAddress() throws ServiceException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(addressService)
        .populateAddressISOCountrySub(Mockito.<Address>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.addCustomerAddress(
                request, model, form, result, new RedirectAttributesModelMap()));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest,
   * Model, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest, Model,
   * CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testAddCustomerAddress2() throws ServiceException {
    // Arrange
    when(addressService.saveAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.create()).thenThrow(new IllegalArgumentException());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.addCustomerAddress(
                request, model, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(addressService).saveAddress(isA(Address.class));
    verify(customerAddressService).create();
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest,
   * Model, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhonePrimary()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest, Model,
   * CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testAddCustomerAddress_givenAddressImplGetPhonePrimaryReturnNull()
      throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenThrow(new IllegalArgumentException());

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(phone);
    when(address.getPhonePrimary()).thenReturn(null);
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(address).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(address).setPhoneSecondary(Mockito.<Phone>any());
    doNothing().when(address).setPrimaryPhone(Mockito.<String>any());
    address.setPrimaryPhone("");

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.addCustomerAddress(
                request, model, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(address, atLeast(1)).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address, atLeast(1)).getPhoneSecondary();
    verify(address).setPhonePrimary(isA(Phone.class));
    verify(address).setPhoneSecondary(isNull());
    verify(address).setPrimaryPhone("");
    verify(phone).getPhoneNumber();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest,
   * Model, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhonePrimary()} return {@link Phone}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest, Model,
   * CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testAddCustomerAddress_givenAddressImplGetPhonePrimaryReturnPhone()
      throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenThrow(new IllegalArgumentException());

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(mock(Phone.class));
    when(address.getPhonePrimary()).thenReturn(phone);
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(address).setPrimaryPhone(Mockito.<String>any());
    address.setPrimaryPhone("");

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.addCustomerAddress(
                request, model, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(address).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address).getPhoneSecondary();
    verify(address).setPrimaryPhone("");
    verify(phone).getPhoneNumber();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest,
   * Model, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerAddressService#saveCustomerAddress(CustomerAddress)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest, Model,
   * CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testAddCustomerAddress_thenCallsSaveCustomerAddress() throws ServiceException {
    // Arrange
    when(addressService.saveAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenThrow(new IllegalArgumentException());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.addCustomerAddress(
                request, model, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(addressService).saveAddress(isA(Address.class));
    verify(customerAddressService).create();
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest,
   * Model, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Then calls {@link AddressImpl#setPhonePrimary(Phone)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest, Model,
   * CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testAddCustomerAddress_thenCallsSetPhonePrimary() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenThrow(new IllegalArgumentException());

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(phone);
    when(address.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(address).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(address).setPhoneSecondary(Mockito.<Phone>any());
    doNothing().when(address).setPrimaryPhone(Mockito.<String>any());
    address.setPrimaryPhone("");

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.addCustomerAddress(
                request, model, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(address, atLeast(1)).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address, atLeast(1)).getPhoneSecondary();
    verify(address).setPhonePrimary(isNull());
    verify(address).setPhoneSecondary(isNull());
    verify(address).setPrimaryPhone("");
    verify(phone).getPhoneNumber();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest,
   * Model, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Then return {@code account/manageCustomerAddresses}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest, Model,
   * CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testAddCustomerAddress_thenReturnAccountManageCustomerAddresses()
      throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl address = new AddressImpl();
    address.setPrimaryPhone("");

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("blcAjax", "blcAjax"));

    // Act
    String actualAddCustomerAddressResult =
        broadleafManageCustomerAddressesController.addCustomerAddress(
            request, model, form, result, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    assertEquals("account/manageCustomerAddresses", actualAddCustomerAddressResult);
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress() throws ServiceException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.updateCustomerAddress(
                request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress2() throws ServiceException {
    // Arrange
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.updateCustomerAddress(
                request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerAddressService).readCustomerAddressById(1L);
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress3() throws ServiceException {
    // Arrange
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenThrow(new IllegalArgumentException());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.updateCustomerAddress(
                request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerAddressService).readCustomerAddressById(1L);
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhoneFax()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress_givenAddressImplGetPhoneFaxReturnNull()
      throws ServiceException {
    // Arrange
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(null);
    when(address.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(address).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(address).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(address).setPhoneSecondary(Mockito.<Phone>any());

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualUpdateCustomerAddressResult =
        broadleafManageCustomerAddressesController.updateCustomerAddress(
            request, model, 1L, form, result, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(address, atLeast(1)).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address, atLeast(1)).getPhoneSecondary();
    verify(address).setPhoneFax(isA(Phone.class));
    verify(address).setPhonePrimary(isNull());
    verify(address).setPhoneSecondary(isNull());
    verify(customerAddressService).readCustomerAddressById(1L);
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    assertEquals("redirect:/account/addresses", actualUpdateCustomerAddressResult);
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhoneFax()} return {@link PhoneImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress_givenAddressImplGetPhoneFaxReturnPhoneImpl()
      throws ServiceException {
    // Arrange
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(new PhoneImpl());
    when(address.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(address).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(address).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(address).setPhoneSecondary(Mockito.<Phone>any());

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualUpdateCustomerAddressResult =
        broadleafManageCustomerAddressesController.updateCustomerAddress(
            request, model, 1L, form, result, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(address, atLeast(1)).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address, atLeast(1)).getPhoneSecondary();
    verify(address).setPhoneFax(isNull());
    verify(address).setPhonePrimary(isNull());
    verify(address).setPhoneSecondary(isNull());
    verify(customerAddressService).readCustomerAddressById(1L);
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    assertEquals("redirect:/account/addresses", actualUpdateCustomerAddressResult);
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhonePrimary()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress_givenAddressImplGetPhonePrimaryReturnNull()
      throws ServiceException {
    // Arrange
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenReturn("");

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(phone);
    when(address.getPhonePrimary()).thenReturn(null);
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(address).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(address).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(address).setPhoneSecondary(Mockito.<Phone>any());

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualUpdateCustomerAddressResult =
        broadleafManageCustomerAddressesController.updateCustomerAddress(
            request, model, 1L, form, result, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(address, atLeast(1)).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address, atLeast(1)).getPhoneSecondary();
    verify(address).setPhoneFax(isNull());
    verify(address).setPhonePrimary(isA(Phone.class));
    verify(address).setPhoneSecondary(isNull());
    verify(phone).getPhoneNumber();
    verify(customerAddressService).readCustomerAddressById(1L);
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    assertEquals("redirect:/account/addresses", actualUpdateCustomerAddressResult);
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@link Phone} {@link Phone#getPhoneNumber()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress_givenPhoneGetPhoneNumberReturnEmptyString()
      throws ServiceException {
    // Arrange
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenReturn("");

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(phone);
    when(address.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(address).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(address).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(address).setPhoneSecondary(Mockito.<Phone>any());

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualUpdateCustomerAddressResult =
        broadleafManageCustomerAddressesController.updateCustomerAddress(
            request, model, 1L, form, result, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(address, atLeast(1)).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address, atLeast(1)).getPhoneSecondary();
    verify(address).setPhoneFax(isNull());
    verify(address).setPhonePrimary(isNull());
    verify(address).setPhoneSecondary(isNull());
    verify(phone).getPhoneNumber();
    verify(customerAddressService).readCustomerAddressById(1L);
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    assertEquals("redirect:/account/addresses", actualUpdateCustomerAddressResult);
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@link Phone} {@link Phone#getPhoneNumber()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress_givenPhoneGetPhoneNumberThrowIllegalArgumentException()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenThrow(new IllegalArgumentException());

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(phone);
    when(address.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(address).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(address).setPhoneSecondary(Mockito.<Phone>any());

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.updateCustomerAddress(
                request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(address, atLeast(1)).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address, atLeast(1)).getPhoneSecondary();
    verify(address).setPhonePrimary(isNull());
    verify(address).setPhoneSecondary(isNull());
    verify(phone).getPhoneNumber();
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@link Phone} {@link Phone#getPhoneNumber()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress_givenPhoneGetPhoneNumberThrowIllegalArgumentException2()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenThrow(new IllegalArgumentException());

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(mock(Phone.class));
    when(address.getPhonePrimary()).thenReturn(phone);
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.updateCustomerAddress(
                request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(address).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address).getPhoneSecondary();
    verify(phone).getPhoneNumber();
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Then {@link CustomerAddressForm} (default constructor) Address PhoneFax is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress_thenCustomerAddressFormAddressPhoneFaxIsNull()
      throws ServiceException {
    // Arrange
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualUpdateCustomerAddressResult =
        broadleafManageCustomerAddressesController.updateCustomerAddress(
            request, model, 1L, form, result, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerAddressService).readCustomerAddressById(1L);
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    Address address = form.getAddress();
    assertTrue(address instanceof AddressImpl);
    assertEquals("redirect:/account/addresses", actualUpdateCustomerAddressResult);
    assertNull(address.getPhoneFax());
    assertNull(address.getPhonePrimary());
    assertNull(address.getPhoneSecondary());
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Then {@link CustomerAddressForm} (default constructor) Address PhoneFax {@link
   *       PhoneImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress_thenCustomerAddressFormAddressPhoneFaxPhoneImpl()
      throws ServiceException {
    // Arrange
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl address = new AddressImpl();
    address.setFax("successMessage");

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualUpdateCustomerAddressResult =
        broadleafManageCustomerAddressesController.updateCustomerAddress(
            request, model, 1L, form, result, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerAddressService).readCustomerAddressById(1L);
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    Address address2 = form.getAddress();
    assertTrue(address2 instanceof AddressImpl);
    assertTrue(address2.getPhoneFax() instanceof PhoneImpl);
    assertEquals("redirect:/account/addresses", actualUpdateCustomerAddressResult);
    assertNull(address2.getPhonePrimary());
    assertNull(address2.getPhoneSecondary());
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Then {@link CustomerAddressForm} (default constructor) Address PhonePrimary {@link
   *       PhoneImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress_thenCustomerAddressFormAddressPhonePrimaryPhoneImpl()
      throws ServiceException {
    // Arrange
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl address = new AddressImpl();
    address.setPrimaryPhone("6625550144");

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualUpdateCustomerAddressResult =
        broadleafManageCustomerAddressesController.updateCustomerAddress(
            request, model, 1L, form, result, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerAddressService).readCustomerAddressById(1L);
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    Address address2 = form.getAddress();
    assertTrue(address2 instanceof AddressImpl);
    assertTrue(address2.getPhonePrimary() instanceof PhoneImpl);
    assertEquals("redirect:/account/addresses", actualUpdateCustomerAddressResult);
    assertNull(address2.getPhoneFax());
    assertNull(address2.getPhoneSecondary());
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Then {@link CustomerAddressForm} (default constructor) Address PhoneSecondary {@link
   *       PhoneImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress_thenCustomerAddressFormAddressPhoneSecondaryPhoneImpl()
      throws ServiceException {
    // Arrange
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl address = new AddressImpl();
    address.setSecondaryPhone("6625550144");

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualUpdateCustomerAddressResult =
        broadleafManageCustomerAddressesController.updateCustomerAddress(
            request, model, 1L, form, result, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerAddressService).readCustomerAddressById(1L);
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    Address address2 = form.getAddress();
    assertTrue(address2 instanceof AddressImpl);
    assertTrue(address2.getPhoneSecondary() instanceof PhoneImpl);
    assertEquals("redirect:/account/addresses", actualUpdateCustomerAddressResult);
    assertNull(address2.getPhoneFax());
    assertNull(address2.getPhonePrimary());
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Then return {@code account/manageCustomerAddresses}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model,
   * Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"
  })
  public void testUpdateCustomerAddress_thenReturnAccountManageCustomerAddresses()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(mock(Phone.class));
    when(address.getPhonePrimary()).thenReturn(mock(Phone.class));
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("Object Name", "Default Message"));

    // Act
    String actualUpdateCustomerAddressResult =
        broadleafManageCustomerAddressesController.updateCustomerAddress(
            request, model, 1L, form, result, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(address).getPhoneFax();
    verify(address).getPhonePrimary();
    verify(address).getPhoneSecondary();
    assertEquals("account/manageCustomerAddresses", actualUpdateCustomerAddressResult);
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model,
   * Long, RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model,
   * Long, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)"
  })
  public void testRemoveCustomerAddress() {
    // Arrange
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.removeCustomerAddress(
                request, model, 1L, new RedirectAttributesModelMap()));
    verify(customerAddressService).readCustomerAddressById(1L);
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model,
   * Long, RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model,
   * Long, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)"
  })
  public void testRemoveCustomerAddress2() {
    // Arrange
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenThrow(new DataIntegrityViolationException("successMessage"));
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualRemoveCustomerAddressResult =
        broadleafManageCustomerAddressesController.removeCustomerAddress(
            request, model, 1L, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressService).readCustomerAddressById(1L);
    assertEquals("redirect:/account/addresses", actualRemoveCustomerAddressResult);
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model,
   * Long, RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model,
   * Long, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)"
  })
  public void testRemoveCustomerAddress3() {
    // Arrange
    doNothing().when(customerAddressService).deleteCustomerAddressById(Mockito.<Long>any());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(new CustomerAddressImpl());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualRemoveCustomerAddressResult =
        broadleafManageCustomerAddressesController.removeCustomerAddress(
            request, model, 1L, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressService).deleteCustomerAddressById(1L);
    verify(customerAddressService).readCustomerAddressById(1L);
    assertEquals("redirect:/account/addresses", actualRemoveCustomerAddressResult);
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model,
   * Long, RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model,
   * Long, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)"
  })
  public void testRemoveCustomerAddress4() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(customerAddressService)
        .deleteCustomerAddressById(Mockito.<Long>any());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(new CustomerAddressImpl());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafManageCustomerAddressesController.removeCustomerAddress(
                request, model, 1L, new RedirectAttributesModelMap()));
    verify(customerAddressService).deleteCustomerAddressById(1L);
    verify(customerAddressService).readCustomerAddressById(1L);
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model,
   * Long, RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model,
   * Long, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)"
  })
  public void testRemoveCustomerAddress5() {
    // Arrange
    doThrow(new DataIntegrityViolationException("successMessage"))
        .when(customerAddressService)
        .deleteCustomerAddressById(Mockito.<Long>any());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(new CustomerAddressImpl());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualRemoveCustomerAddressResult =
        broadleafManageCustomerAddressesController.removeCustomerAddress(
            request, model, 1L, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressService).deleteCustomerAddressById(1L);
    verify(customerAddressService).readCustomerAddressById(1L);
    assertEquals("redirect:/account/addresses", actualRemoveCustomerAddressResult);
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model,
   * Long, RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model,
   * Long, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafManageCustomerAddressesController.removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)"
  })
  public void testRemoveCustomerAddress6() {
    // Arrange
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualRemoveCustomerAddressResult =
        broadleafManageCustomerAddressesController.removeCustomerAddress(
            request, model, 1L, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressService).readCustomerAddressById(1L);
    assertEquals("redirect:/account/addresses", actualRemoveCustomerAddressResult);
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"
  })
  public void testRemoveUnusedPhones_givenAddressImpl() {
    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController =
        new BroadleafManageCustomerAddressesController();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    Address address = form.getAddress();
    assertTrue(address instanceof AddressImpl);
    assertNull(address.getPhoneFax());
    assertNull(address.getPhonePrimary());
    assertNull(address.getPhoneSecondary());
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhoneFax()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"
  })
  public void testRemoveUnusedPhones_givenAddressImplGetPhoneFaxReturnNull() {
    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController =
        new BroadleafManageCustomerAddressesController();

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(null);
    when(address.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(address).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(address).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(address).setPhoneSecondary(Mockito.<Phone>any());

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    verify(address, atLeast(1)).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address, atLeast(1)).getPhoneSecondary();
    verify(address).setPhoneFax(isA(Phone.class));
    verify(address).setPhonePrimary(isNull());
    verify(address).setPhoneSecondary(isNull());
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhoneFax()} return {@link PhoneImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"
  })
  public void testRemoveUnusedPhones_givenAddressImplGetPhoneFaxReturnPhoneImpl() {
    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController =
        new BroadleafManageCustomerAddressesController();

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(new PhoneImpl());
    when(address.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(address).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(address).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(address).setPhoneSecondary(Mockito.<Phone>any());

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    verify(address, atLeast(1)).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address, atLeast(1)).getPhoneSecondary();
    verify(address).setPhoneFax(isNull());
    verify(address).setPhonePrimary(isNull());
    verify(address).setPhoneSecondary(isNull());
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhonePrimary()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"
  })
  public void testRemoveUnusedPhones_givenAddressImplGetPhonePrimaryReturnNull() {
    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController =
        new BroadleafManageCustomerAddressesController();

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenReturn("");

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(phone);
    when(address.getPhonePrimary()).thenReturn(null);
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(address).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(address).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(address).setPhoneSecondary(Mockito.<Phone>any());

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    verify(address, atLeast(1)).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address, atLeast(1)).getPhoneSecondary();
    verify(address).setPhoneFax(isNull());
    verify(address).setPhonePrimary(isA(Phone.class));
    verify(address).setPhoneSecondary(isNull());
    verify(phone).getPhoneNumber();
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhonePrimary()} return {@link Phone}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"
  })
  public void testRemoveUnusedPhones_givenAddressImplGetPhonePrimaryReturnPhone() {
    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController =
        new BroadleafManageCustomerAddressesController();

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenThrow(new IllegalArgumentException());

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(mock(Phone.class));
    when(address.getPhonePrimary()).thenReturn(phone);
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> broadleafManageCustomerAddressesController.removeUnusedPhones(form));
    verify(address).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address).getPhoneSecondary();
    verify(phone).getPhoneNumber();
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   *
   * <ul>
   *   <li>Given {@link Phone} {@link Phone#getPhoneNumber()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"
  })
  public void testRemoveUnusedPhones_givenPhoneGetPhoneNumberReturnEmptyString() {
    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController =
        new BroadleafManageCustomerAddressesController();

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenReturn("");

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(phone);
    when(address.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(address).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(address).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(address).setPhoneSecondary(Mockito.<Phone>any());

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    verify(address, atLeast(1)).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address, atLeast(1)).getPhoneSecondary();
    verify(address).setPhoneFax(isNull());
    verify(address).setPhonePrimary(isNull());
    verify(address).setPhoneSecondary(isNull());
    verify(phone).getPhoneNumber();
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   *
   * <ul>
   *   <li>Then {@link CustomerAddressForm} (default constructor) Address PhoneFax {@link
   *       PhoneImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"
  })
  public void testRemoveUnusedPhones_thenCustomerAddressFormAddressPhoneFaxPhoneImpl() {
    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController =
        new BroadleafManageCustomerAddressesController();

    AddressImpl address = new AddressImpl();
    address.setFax("Fax");

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    Address address2 = form.getAddress();
    assertTrue(address2 instanceof AddressImpl);
    assertTrue(address2.getPhoneFax() instanceof PhoneImpl);
    assertNull(address2.getPhonePrimary());
    assertNull(address2.getPhoneSecondary());
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   *
   * <ul>
   *   <li>Then {@link CustomerAddressForm} (default constructor) Address PhonePrimary {@link
   *       PhoneImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"
  })
  public void testRemoveUnusedPhones_thenCustomerAddressFormAddressPhonePrimaryPhoneImpl() {
    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController =
        new BroadleafManageCustomerAddressesController();

    AddressImpl address = new AddressImpl();
    address.setPrimaryPhone("6625550144");

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    Address address2 = form.getAddress();
    assertTrue(address2 instanceof AddressImpl);
    assertTrue(address2.getPhonePrimary() instanceof PhoneImpl);
    assertNull(address2.getPhoneFax());
    assertNull(address2.getPhoneSecondary());
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   *
   * <ul>
   *   <li>Then {@link CustomerAddressForm} (default constructor) Address PhoneSecondary {@link
   *       PhoneImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"
  })
  public void testRemoveUnusedPhones_thenCustomerAddressFormAddressPhoneSecondaryPhoneImpl() {
    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController =
        new BroadleafManageCustomerAddressesController();

    AddressImpl address = new AddressImpl();
    address.setSecondaryPhone("6625550144");

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    Address address2 = form.getAddress();
    assertTrue(address2 instanceof AddressImpl);
    assertTrue(address2.getPhoneSecondary() instanceof PhoneImpl);
    assertNull(address2.getPhoneFax());
    assertNull(address2.getPhonePrimary());
  }

  /**
   * Test {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"
  })
  public void testRemoveUnusedPhones_thenThrowIllegalArgumentException() {
    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController =
        new BroadleafManageCustomerAddressesController();

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenThrow(new IllegalArgumentException());

    AddressImpl address = mock(AddressImpl.class);
    when(address.getPhoneFax()).thenReturn(phone);
    when(address.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(address.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(address).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(address).setPhoneSecondary(Mockito.<Phone>any());

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(address);
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> broadleafManageCustomerAddressesController.removeUnusedPhones(form));
    verify(address, atLeast(1)).getPhoneFax();
    verify(address, atLeast(1)).getPhonePrimary();
    verify(address, atLeast(1)).getPhoneSecondary();
    verify(address).setPhonePrimary(isNull());
    verify(address).setPhoneSecondary(isNull());
    verify(phone).getPhoneNumber();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link
   *       BroadleafManageCustomerAddressesController}
   *   <li>{@link BroadleafManageCustomerAddressesController#getAddressAddedMessage()}
   *   <li>{@link BroadleafManageCustomerAddressesController#getAddressRemovedErrorMessage()}
   *   <li>{@link BroadleafManageCustomerAddressesController#getAddressRemovedMessage()}
   *   <li>{@link BroadleafManageCustomerAddressesController#getAddressUpdatedMessage()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafManageCustomerAddressesController.<init>()",
    "String BroadleafManageCustomerAddressesController.getAddressAddedMessage()",
    "String BroadleafManageCustomerAddressesController.getAddressRemovedErrorMessage()",
    "String BroadleafManageCustomerAddressesController.getAddressRemovedMessage()",
    "String BroadleafManageCustomerAddressesController.getAddressUpdatedMessage()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafManageCustomerAddressesController actualBroadleafManageCustomerAddressesController =
        new BroadleafManageCustomerAddressesController();
    String actualAddressAddedMessage =
        actualBroadleafManageCustomerAddressesController.getAddressAddedMessage();
    String actualAddressRemovedErrorMessage =
        actualBroadleafManageCustomerAddressesController.getAddressRemovedErrorMessage();
    String actualAddressRemovedMessage =
        actualBroadleafManageCustomerAddressesController.getAddressRemovedMessage();

    // Assert
    assertEquals("Address could not be removed as it is in use", actualAddressRemovedErrorMessage);
    assertEquals("Address successfully added", actualAddressAddedMessage);
    assertEquals("Address successfully removed", actualAddressRemovedMessage);
    assertEquals(
        "Address successfully updated",
        actualBroadleafManageCustomerAddressesController.getAddressUpdatedMessage());
  }
}
