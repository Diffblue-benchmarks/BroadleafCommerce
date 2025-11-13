package org.broadleafcommerce.core.store.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.broadleafcommerce.core.store.dao.StoreDao;
import org.broadleafcommerce.core.store.domain.Store;
import org.broadleafcommerce.core.store.domain.StoreImpl;
import org.broadleafcommerce.core.store.domain.ZipCodeImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StoreServiceImplDiffblueTest {
  @Mock private StoreDao storeDao;

  @InjectMocks private StoreServiceImpl storeServiceImpl;

  @Mock private ZipCodeService zipCodeService;

  /**
   * Test {@link StoreServiceImpl#readStoreById(Long)}.
   *
   * <p>Method under test: {@link StoreServiceImpl#readStoreById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Store StoreServiceImpl.readStoreById(Long)"})
  public void testReadStoreById() {
    // Arrange
    StoreImpl storeImpl = new StoreImpl();
    when(storeDao.readStoreById(Mockito.<Long>any())).thenReturn(storeImpl);

    // Act
    Store actualReadStoreByIdResult = storeServiceImpl.readStoreById(1L);

    // Assert
    verify(storeDao).readStoreById(1L);
    assertSame(storeImpl, actualReadStoreByIdResult);
  }

  /**
   * Test {@link StoreServiceImpl#readStoreByStoreName(String)}.
   *
   * <p>Method under test: {@link StoreServiceImpl#readStoreByStoreName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Store StoreServiceImpl.readStoreByStoreName(String)"})
  public void testReadStoreByStoreName() {
    // Arrange
    StoreImpl storeImpl = new StoreImpl();
    when(storeDao.readStoreByStoreName(Mockito.<String>any())).thenReturn(storeImpl);

    // Act
    Store actualReadStoreByStoreNameResult = storeServiceImpl.readStoreByStoreName("Store Name");

    // Assert
    verify(storeDao).readStoreByStoreName("Store Name");
    assertSame(storeImpl, actualReadStoreByStoreNameResult);
  }

  /**
   * Test {@link StoreServiceImpl#readStoreByStoreCode(String)}.
   *
   * <p>Method under test: {@link StoreServiceImpl#readStoreByStoreCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Store StoreServiceImpl.readStoreByStoreCode(String)"})
  public void testReadStoreByStoreCode() {
    // Arrange
    StoreImpl storeImpl = new StoreImpl();
    when(storeDao.readStoreByStoreCode(Mockito.<String>any())).thenReturn(storeImpl);

    // Act
    Store actualReadStoreByStoreCodeResult = storeServiceImpl.readStoreByStoreCode("Store Code");

    // Assert
    verify(storeDao).readStoreByStoreCode("Store Code");
    assertSame(storeImpl, actualReadStoreByStoreCodeResult);
  }

  /**
   * Test {@link StoreServiceImpl#readAllStores()}.
   *
   * <p>Method under test: {@link StoreServiceImpl#readAllStores()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StoreServiceImpl.readAllStores()"})
  public void testReadAllStores() {
    // Arrange
    when(storeDao.readAllStores()).thenReturn(new ArrayList<>());

    // Act
    List<Store> actualReadAllStoresResult = storeServiceImpl.readAllStores();

    // Assert
    verify(storeDao).readAllStores();
    assertTrue(actualReadAllStoresResult.isEmpty());
  }

  /**
   * Test {@link StoreServiceImpl#readAllStoresByState(String)}.
   *
   * <p>Method under test: {@link StoreServiceImpl#readAllStoresByState(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StoreServiceImpl.readAllStoresByState(String)"})
  public void testReadAllStoresByState() {
    // Arrange
    when(storeDao.readAllStoresByState(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<Store> actualReadAllStoresByStateResult = storeServiceImpl.readAllStoresByState("MD");

    // Assert
    verify(storeDao).readAllStoresByState("MD");
    assertTrue(actualReadAllStoresByStateResult.isEmpty());
  }

  /**
   * Test {@link StoreServiceImpl#saveStore(Store)}.
   *
   * <p>Method under test: {@link StoreServiceImpl#saveStore(Store)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Store StoreServiceImpl.saveStore(Store)"})
  public void testSaveStore() {
    // Arrange
    StoreImpl storeImpl = new StoreImpl();
    when(storeDao.save(Mockito.<Store>any())).thenReturn(storeImpl);

    // Act
    Store actualSaveStoreResult = storeServiceImpl.saveStore(new StoreImpl());

    // Assert
    verify(storeDao).save(isA(Store.class));
    assertSame(storeImpl, actualSaveStoreResult);
  }

  /**
   * Test {@link StoreServiceImpl#findStoresByAddress(Address, double)}.
   *
   * <ul>
   *   <li>Given {@link Store} {@link Store#getLongitude()} return ten.
   *   <li>Then calls {@link Store#getLatitude()}.
   * </ul>
   *
   * <p>Method under test: {@link StoreServiceImpl#findStoresByAddress(Address, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StoreServiceImpl.findStoresByAddress(Address, double)"})
  public void testFindStoresByAddress_givenStoreGetLongitudeReturnTen_thenCallsGetLatitude() {
    // Arrange
    Store store = mock(Store.class);
    when(store.getLatitude()).thenReturn(10.0d);
    when(store.getLongitude()).thenReturn(10.0d);

    ArrayList<Store> storeList = new ArrayList<>();
    storeList.add(store);
    when(storeDao.readAllStores()).thenReturn(storeList);
    when(zipCodeService.findZipCodeByZipCode(Mockito.<Integer>any())).thenReturn(new ZipCodeImpl());

    AddressImpl searchAddress = new AddressImpl();
    searchAddress.setActive(true);
    searchAddress.setAddressLine1("42 Main St");
    searchAddress.setAddressLine2("42 Main St");
    searchAddress.setAddressLine3("42 Main St");
    searchAddress.setBusiness(true);
    searchAddress.setCity("Oxford");
    searchAddress.setCompanyName("Company Name");
    searchAddress.setCountry(new CountryImpl());
    searchAddress.setCounty("3");
    searchAddress.setDefault(true);
    searchAddress.setEmailAddress("42 Main St");
    searchAddress.setFax("Fax");
    searchAddress.setFirstName("Jane");
    searchAddress.setFullName("Dr Jane Doe");
    searchAddress.setId(1L);
    searchAddress.setIsoCountryAlpha2(new ISOCountryImpl());
    searchAddress.setIsoCountrySubdivision("GB");
    searchAddress.setLastName("Doe");
    searchAddress.setMailing(true);
    searchAddress.setPhoneFax(new PhoneImpl());
    searchAddress.setPhonePrimary(new PhoneImpl());
    searchAddress.setPhoneSecondary(new PhoneImpl());
    searchAddress.setPrimaryPhone("6625550144");
    searchAddress.setSecondaryPhone("6625550144");
    searchAddress.setStandardized(true);
    searchAddress.setState(new StateImpl());
    searchAddress.setStateProvinceRegion("us-east-2");
    searchAddress.setStreet(true);
    searchAddress.setTokenizedAddress("42 Main St");
    searchAddress.setVerificationLevel("Verification Level");
    searchAddress.setZipFour("21654");
    searchAddress.setPostalCode("1");

    // Act
    Map<Store, Double> actualFindStoresByAddressResult =
        storeServiceImpl.findStoresByAddress(searchAddress, 10.0d);

    // Assert
    verify(storeDao).readAllStores();
    verify(store, atLeast(1)).getLatitude();
    verify(store).getLongitude();
    verify(zipCodeService).findZipCodeByZipCode(1);
    assertTrue(actualFindStoresByAddressResult.isEmpty());
  }

  /**
   * Test {@link StoreServiceImpl#findStoresByAddress(Address, double)}.
   *
   * <ul>
   *   <li>Given {@link ZipCodeService} {@link ZipCodeService#findZipCodeByZipCode(Integer)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StoreServiceImpl#findStoresByAddress(Address, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StoreServiceImpl.findStoresByAddress(Address, double)"})
  public void testFindStoresByAddress_givenZipCodeServiceFindZipCodeByZipCodeReturnNull() {
    // Arrange
    ArrayList<Store> storeList = new ArrayList<>();
    storeList.add(mock(Store.class));
    when(storeDao.readAllStores()).thenReturn(storeList);
    when(zipCodeService.findZipCodeByZipCode(Mockito.<Integer>any())).thenReturn(null);

    AddressImpl searchAddress = new AddressImpl();
    searchAddress.setActive(true);
    searchAddress.setAddressLine1("42 Main St");
    searchAddress.setAddressLine2("42 Main St");
    searchAddress.setAddressLine3("42 Main St");
    searchAddress.setBusiness(true);
    searchAddress.setCity("Oxford");
    searchAddress.setCompanyName("Company Name");
    searchAddress.setCountry(new CountryImpl());
    searchAddress.setCounty("3");
    searchAddress.setDefault(true);
    searchAddress.setEmailAddress("42 Main St");
    searchAddress.setFax("Fax");
    searchAddress.setFirstName("Jane");
    searchAddress.setFullName("Dr Jane Doe");
    searchAddress.setId(1L);
    searchAddress.setIsoCountryAlpha2(new ISOCountryImpl());
    searchAddress.setIsoCountrySubdivision("GB");
    searchAddress.setLastName("Doe");
    searchAddress.setMailing(true);
    searchAddress.setPhoneFax(new PhoneImpl());
    searchAddress.setPhonePrimary(new PhoneImpl());
    searchAddress.setPhoneSecondary(new PhoneImpl());
    searchAddress.setPrimaryPhone("6625550144");
    searchAddress.setSecondaryPhone("6625550144");
    searchAddress.setStandardized(true);
    searchAddress.setState(new StateImpl());
    searchAddress.setStateProvinceRegion("us-east-2");
    searchAddress.setStreet(true);
    searchAddress.setTokenizedAddress("42 Main St");
    searchAddress.setVerificationLevel("Verification Level");
    searchAddress.setZipFour("21654");
    searchAddress.setPostalCode("1");

    // Act
    Map<Store, Double> actualFindStoresByAddressResult =
        storeServiceImpl.findStoresByAddress(searchAddress, 10.0d);

    // Assert
    verify(storeDao).readAllStores();
    verify(zipCodeService).findZipCodeByZipCode(1);
    assertTrue(actualFindStoresByAddressResult.isEmpty());
  }

  /**
   * Test {@link StoreServiceImpl#findStoresByAddress(Address, double)}.
   *
   * <ul>
   *   <li>When {@code 3959.0}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link StoreServiceImpl#findStoresByAddress(Address, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StoreServiceImpl.findStoresByAddress(Address, double)"})
  public void testFindStoresByAddress_when39590_thenReturnSizeIsOne() {
    // Arrange
    Store store = mock(Store.class);
    when(store.getLatitude()).thenReturn(10.0d);
    when(store.getLongitude()).thenReturn(10.0d);

    ArrayList<Store> storeList = new ArrayList<>();
    storeList.add(store);
    when(storeDao.readAllStores()).thenReturn(storeList);
    when(zipCodeService.findZipCodeByZipCode(Mockito.<Integer>any())).thenReturn(new ZipCodeImpl());

    AddressImpl searchAddress = new AddressImpl();
    searchAddress.setActive(true);
    searchAddress.setAddressLine1("42 Main St");
    searchAddress.setAddressLine2("42 Main St");
    searchAddress.setAddressLine3("42 Main St");
    searchAddress.setBusiness(true);
    searchAddress.setCity("Oxford");
    searchAddress.setCompanyName("Company Name");
    searchAddress.setCountry(new CountryImpl());
    searchAddress.setCounty("3");
    searchAddress.setDefault(true);
    searchAddress.setEmailAddress("42 Main St");
    searchAddress.setFax("Fax");
    searchAddress.setFirstName("Jane");
    searchAddress.setFullName("Dr Jane Doe");
    searchAddress.setId(1L);
    searchAddress.setIsoCountryAlpha2(new ISOCountryImpl());
    searchAddress.setIsoCountrySubdivision("GB");
    searchAddress.setLastName("Doe");
    searchAddress.setMailing(true);
    searchAddress.setPhoneFax(new PhoneImpl());
    searchAddress.setPhonePrimary(new PhoneImpl());
    searchAddress.setPhoneSecondary(new PhoneImpl());
    searchAddress.setPrimaryPhone("6625550144");
    searchAddress.setSecondaryPhone("6625550144");
    searchAddress.setStandardized(true);
    searchAddress.setState(new StateImpl());
    searchAddress.setStateProvinceRegion("us-east-2");
    searchAddress.setStreet(true);
    searchAddress.setTokenizedAddress("42 Main St");
    searchAddress.setVerificationLevel("Verification Level");
    searchAddress.setZipFour("21654");
    searchAddress.setPostalCode("1");

    // Act
    Map<Store, Double> actualFindStoresByAddressResult =
        storeServiceImpl.findStoresByAddress(searchAddress, 3959.0d);

    // Assert
    verify(storeDao).readAllStores();
    verify(store, atLeast(1)).getLatitude();
    verify(store).getLongitude();
    verify(zipCodeService).findZipCodeByZipCode(1);
    assertEquals(1, actualFindStoresByAddressResult.size());
  }

  /**
   * Test {@link StoreServiceImpl#findStoresByAddress(Address, double)}.
   *
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StoreServiceImpl#findStoresByAddress(Address, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StoreServiceImpl.findStoresByAddress(Address, double)"})
  public void testFindStoresByAddress_whenAddressImpl_thenReturnEmpty() {
    // Arrange
    when(storeDao.readAllStores()).thenReturn(new ArrayList<>());

    // Act
    Map<Store, Double> actualFindStoresByAddressResult =
        storeServiceImpl.findStoresByAddress(new AddressImpl(), 10.0d);

    // Assert
    verify(storeDao).readAllStores();
    assertTrue(actualFindStoresByAddressResult.isEmpty());
  }
}
