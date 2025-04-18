/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.store.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.core.store.dao.StoreDao;
import org.broadleafcommerce.core.store.domain.Store;
import org.broadleafcommerce.core.store.domain.StoreImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StoreServiceImplDiffblueTest {
  @Mock
  private StoreDao storeDao;

  @InjectMocks
  private StoreServiceImpl storeServiceImpl;

  @Mock
  private ZipCodeService zipCodeService;

  /**
   * Test {@link StoreServiceImpl#readStoreById(Long)}.
   * <p>
   * Method under test: {@link StoreServiceImpl#readStoreById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Store StoreServiceImpl.readStoreById(Long)"})
  public void testReadStoreById() {
    // Arrange
    StoreImpl storeImpl = new StoreImpl();
    when(storeDao.readStoreById(Mockito.<Long>any())).thenReturn(storeImpl);

    // Act
    Store actualReadStoreByIdResult = storeServiceImpl.readStoreById(1L);

    // Assert
    verify(storeDao).readStoreById(eq(1L));
    assertSame(storeImpl, actualReadStoreByIdResult);
  }

  /**
   * Test {@link StoreServiceImpl#readStoreByStoreName(String)}.
   * <p>
   * Method under test: {@link StoreServiceImpl#readStoreByStoreName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Store StoreServiceImpl.readStoreByStoreName(String)"})
  public void testReadStoreByStoreName() {
    // Arrange
    StoreImpl storeImpl = new StoreImpl();
    when(storeDao.readStoreByStoreName(Mockito.<String>any())).thenReturn(storeImpl);

    // Act
    Store actualReadStoreByStoreNameResult = storeServiceImpl.readStoreByStoreName("Store Name");

    // Assert
    verify(storeDao).readStoreByStoreName(eq("Store Name"));
    assertSame(storeImpl, actualReadStoreByStoreNameResult);
  }

  /**
   * Test {@link StoreServiceImpl#readStoreByStoreCode(String)}.
   * <p>
   * Method under test: {@link StoreServiceImpl#readStoreByStoreCode(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Store StoreServiceImpl.readStoreByStoreCode(String)"})
  public void testReadStoreByStoreCode() {
    // Arrange
    StoreImpl storeImpl = new StoreImpl();
    when(storeDao.readStoreByStoreCode(Mockito.<String>any())).thenReturn(storeImpl);

    // Act
    Store actualReadStoreByStoreCodeResult = storeServiceImpl.readStoreByStoreCode("Store Code");

    // Assert
    verify(storeDao).readStoreByStoreCode(eq("Store Code"));
    assertSame(storeImpl, actualReadStoreByStoreCodeResult);
  }

  /**
   * Test {@link StoreServiceImpl#readAllStores()}.
   * <p>
   * Method under test: {@link StoreServiceImpl#readAllStores()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link StoreServiceImpl#readAllStoresByState(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StoreServiceImpl.readAllStoresByState(String)"})
  public void testReadAllStoresByState() {
    // Arrange
    when(storeDao.readAllStoresByState(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<Store> actualReadAllStoresByStateResult = storeServiceImpl.readAllStoresByState("MD");

    // Assert
    verify(storeDao).readAllStoresByState(eq("MD"));
    assertTrue(actualReadAllStoresByStateResult.isEmpty());
  }

  /**
   * Test {@link StoreServiceImpl#saveStore(Store)}.
   * <p>
   * Method under test: {@link StoreServiceImpl#saveStore(Store)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StoreServiceImpl#findStoresByAddress(Address, double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map StoreServiceImpl.findStoresByAddress(Address, double)"})
  public void testFindStoresByAddress_whenAddressImpl_thenReturnEmpty() {
    // Arrange
    when(storeDao.readAllStores()).thenReturn(new ArrayList<>());

    // Act
    Map<Store, Double> actualFindStoresByAddressResult = storeServiceImpl.findStoresByAddress(new AddressImpl(), 10.0d);

    // Assert
    verify(storeDao).readAllStores();
    assertTrue(actualFindStoresByAddressResult.isEmpty());
  }
}
