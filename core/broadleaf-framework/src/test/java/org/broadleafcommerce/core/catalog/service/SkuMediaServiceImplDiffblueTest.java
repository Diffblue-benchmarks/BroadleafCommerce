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
package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.dao.SkuMediaDao;
import org.broadleafcommerce.core.catalog.domain.SkuMediaXref;
import org.broadleafcommerce.core.catalog.domain.SkuMediaXrefImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

@RunWith(MockitoJUnitRunner.class)
public class SkuMediaServiceImplDiffblueTest {
  @Mock private Environment environment;

  @Mock private SkuMediaDao skuMediaDao;

  @InjectMocks private SkuMediaServiceImpl skuMediaServiceImpl;

  /**
   * Test {@link SkuMediaServiceImpl#save(SkuMediaXref)}.
   *
   * <p>Method under test: {@link SkuMediaServiceImpl#save(SkuMediaXref)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SkuMediaXref SkuMediaServiceImpl.save(SkuMediaXref)"})
  public void testSave() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    when(skuMediaDao.save(Mockito.<SkuMediaXref>any())).thenReturn(skuMediaXrefImpl);

    // Act
    SkuMediaXref actualSaveResult = skuMediaServiceImpl.save(new SkuMediaXrefImpl());

    // Assert
    verify(skuMediaDao).save(isA(SkuMediaXref.class));
    assertSame(skuMediaXrefImpl, actualSaveResult);
  }

  /**
   * Test {@link SkuMediaServiceImpl#findSkuMediaBySkuId(Long)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaServiceImpl#findSkuMediaBySkuId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SkuMediaServiceImpl.findSkuMediaBySkuId(Long)"})
  public void testFindSkuMediaBySkuId_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    when(skuMediaDao.readSkuMediaBySkuId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<SkuMediaXref> actualFindSkuMediaBySkuIdResult =
        skuMediaServiceImpl.findSkuMediaBySkuId(1L);

    // Assert
    verify(skuMediaDao).readSkuMediaBySkuId(1L);
    verify(environment)
        .getProperty(eq("sku.media.display-order.enabled"), isA(Class.class), isA(Object.class));
    assertTrue(actualFindSkuMediaBySkuIdResult.isEmpty());
  }

  /**
   * Test {@link SkuMediaServiceImpl#findSkuMediaBySkuId(Long)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaServiceImpl#findSkuMediaBySkuId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SkuMediaServiceImpl.findSkuMediaBySkuId(Long)"})
  public void testFindSkuMediaBySkuId_givenEnvironmentGetPropertyReturnTrue() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    when(skuMediaDao.readSkuMediaBySkuId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<SkuMediaXref> actualFindSkuMediaBySkuIdResult =
        skuMediaServiceImpl.findSkuMediaBySkuId(1L);

    // Assert
    verify(skuMediaDao).readSkuMediaBySkuId(1L);
    verify(environment)
        .getProperty(eq("sku.media.display-order.enabled"), isA(Class.class), isA(Object.class));
    assertTrue(actualFindSkuMediaBySkuIdResult.isEmpty());
  }

  /**
   * Test {@link SkuMediaServiceImpl#sort(List)}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaServiceImpl#sort(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SkuMediaServiceImpl.sort(List)"})
  public void testSort_givenSkuMediaXrefImpl_thenReturnArrayList() {
    // Arrange
    ArrayList<SkuMediaXref> skuMediaXrefs = new ArrayList<>();
    skuMediaXrefs.add(new SkuMediaXrefImpl());

    // Act
    List<SkuMediaXref> actualSortResult = skuMediaServiceImpl.sort(skuMediaXrefs);

    // Assert
    assertSame(skuMediaXrefs, actualSortResult);
  }

  /**
   * Test {@link SkuMediaServiceImpl#sort(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaServiceImpl#sort(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SkuMediaServiceImpl.sort(List)"})
  public void testSort_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(skuMediaServiceImpl.sort(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link SkuMediaServiceImpl#isOrderedSkuMediaEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaServiceImpl#isOrderedSkuMediaEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuMediaServiceImpl.isOrderedSkuMediaEnabled()"})
  public void testIsOrderedSkuMediaEnabled_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    boolean actualIsOrderedSkuMediaEnabledResult = skuMediaServiceImpl.isOrderedSkuMediaEnabled();

    // Assert
    verify(environment)
        .getProperty(eq("sku.media.display-order.enabled"), isA(Class.class), isA(Object.class));
    assertFalse(actualIsOrderedSkuMediaEnabledResult);
  }

  /**
   * Test {@link SkuMediaServiceImpl#isOrderedSkuMediaEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaServiceImpl#isOrderedSkuMediaEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuMediaServiceImpl.isOrderedSkuMediaEnabled()"})
  public void testIsOrderedSkuMediaEnabled_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    boolean actualIsOrderedSkuMediaEnabledResult = skuMediaServiceImpl.isOrderedSkuMediaEnabled();

    // Assert
    verify(environment)
        .getProperty(eq("sku.media.display-order.enabled"), isA(Class.class), isA(Object.class));
    assertTrue(actualIsOrderedSkuMediaEnabledResult);
  }
}
