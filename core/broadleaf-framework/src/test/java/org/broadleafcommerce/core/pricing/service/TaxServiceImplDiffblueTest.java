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
package org.broadleafcommerce.core.pricing.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.broadleafcommerce.common.config.domain.ModuleConfiguration;
import org.broadleafcommerce.common.config.service.ModuleConfigurationService;
import org.broadleafcommerce.common.config.service.type.ModuleConfigurationType;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.pricing.service.exception.TaxException;
import org.broadleafcommerce.core.pricing.service.tax.provider.SimpleTaxProvider;
import org.broadleafcommerce.core.pricing.service.tax.provider.TaxProvider;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class TaxServiceImplDiffblueTest {
  @Mock private List<TaxProvider> list;

  @Mock private ModuleConfigurationService moduleConfigurationService;

  @InjectMocks private TaxServiceImpl taxServiceImpl;

  /**
   * Test {@link TaxServiceImpl#calculateTaxForOrder(Order)}.
   *
   * <p>Method under test: {@link TaxServiceImpl#calculateTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.calculateTaxForOrder(Order)"})
  public void testCalculateTaxForOrder() throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    SimpleTaxProvider simpleTaxProvider = mock(SimpleTaxProvider.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(simpleTaxProvider.calculateTaxForOrder(
            Mockito.<Order>any(), Mockito.<ModuleConfiguration>any()))
        .thenReturn(nullOrderImpl);
    when(simpleTaxProvider.canRespond(Mockito.<ModuleConfiguration>any())).thenReturn(true);

    ArrayList<TaxProvider> taxProviderList = new ArrayList<>();
    taxProviderList.add(simpleTaxProvider);
    Iterator<TaxProvider> iteratorResult = taxProviderList.iterator();
    when(list.isEmpty()).thenReturn(false);
    when(list.iterator()).thenReturn(iteratorResult);

    // Act
    Order actualCalculateTaxForOrderResult =
        taxServiceImpl.calculateTaxForOrder(new NullOrderImpl());

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    verify(simpleTaxProvider)
        .calculateTaxForOrder(isA(Order.class), isA(ModuleConfiguration.class));
    verify(simpleTaxProvider).canRespond(isA(ModuleConfiguration.class));
    assertSame(nullOrderImpl, actualCalculateTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#calculateTaxForOrder(Order)}.
   *
   * <p>Method under test: {@link TaxServiceImpl#calculateTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.calculateTaxForOrder(Order)"})
  public void testCalculateTaxForOrder2() throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    SimpleTaxProvider simpleTaxProvider = mock(SimpleTaxProvider.class);
    when(simpleTaxProvider.calculateTaxForOrder(
            Mockito.<Order>any(), Mockito.<ModuleConfiguration>any()))
        .thenThrow(new TaxException("An error occurred"));
    when(simpleTaxProvider.canRespond(Mockito.<ModuleConfiguration>any())).thenReturn(true);

    ArrayList<TaxProvider> taxProviderList = new ArrayList<>();
    taxProviderList.add(simpleTaxProvider);
    Iterator<TaxProvider> iteratorResult = taxProviderList.iterator();
    when(list.isEmpty()).thenReturn(false);
    when(list.iterator()).thenReturn(iteratorResult);

    // Act and Assert
    assertThrows(
        TaxException.class, () -> taxServiceImpl.calculateTaxForOrder(new NullOrderImpl()));
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    verify(simpleTaxProvider)
        .calculateTaxForOrder(isA(Order.class), isA(ModuleConfiguration.class));
    verify(simpleTaxProvider).canRespond(isA(ModuleConfiguration.class));
  }

  /**
   * Test {@link TaxServiceImpl#calculateTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SimpleTaxProvider} (default constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#calculateTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.calculateTaxForOrder(Order)"})
  public void testCalculateTaxForOrder_givenArrayListAddSimpleTaxProvider_thenCallsIterator()
      throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    ArrayList<TaxProvider> taxProviderList = new ArrayList<>();
    taxProviderList.add(new SimpleTaxProvider());
    Iterator<TaxProvider> iteratorResult = taxProviderList.iterator();
    when(list.isEmpty()).thenReturn(false);
    when(list.iterator()).thenReturn(iteratorResult);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCalculateTaxForOrderResult = taxServiceImpl.calculateTaxForOrder(order);

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(order, actualCalculateTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#calculateTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SiteMapConfigurationImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#calculateTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.calculateTaxForOrder(Order)"})
  public void testCalculateTaxForOrder_givenArrayListAddSiteMapConfigurationImpl()
      throws TaxException {
    // Arrange
    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(new SiteMapConfigurationImpl());
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);
    when(list.isEmpty()).thenReturn(true);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCalculateTaxForOrderResult = taxServiceImpl.calculateTaxForOrder(order);

    // Assert
    verify(list).isEmpty();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(order, actualCalculateTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#calculateTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#isEmpty()} return {@code false}.
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#calculateTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.calculateTaxForOrder(Order)"})
  public void testCalculateTaxForOrder_givenListIsEmptyReturnFalse_thenCallsIterator()
      throws TaxException {
    // Arrange
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());
    when(list.isEmpty()).thenReturn(false);

    ArrayList<TaxProvider> taxProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(taxProviderList.iterator());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCalculateTaxForOrderResult = taxServiceImpl.calculateTaxForOrder(order);

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(order, actualCalculateTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#calculateTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#isEmpty()} return {@code true}.
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#calculateTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.calculateTaxForOrder(Order)"})
  public void testCalculateTaxForOrder_givenListIsEmptyReturnTrue_thenReturnNullOrderImpl()
      throws TaxException {
    // Arrange
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());
    when(list.isEmpty()).thenReturn(true);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCalculateTaxForOrderResult = taxServiceImpl.calculateTaxForOrder(order);

    // Assert
    verify(list).isEmpty();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(order, actualCalculateTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#calculateTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link TaxServiceImpl} MustCalculate is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#calculateTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.calculateTaxForOrder(Order)"})
  public void testCalculateTaxForOrder_givenTaxServiceImplMustCalculateIsFalse()
      throws TaxException {
    // Arrange
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());
    taxServiceImpl.setTaxProviders(null);
    taxServiceImpl.setMustCalculate(false);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCalculateTaxForOrderResult = taxServiceImpl.calculateTaxForOrder(order);

    // Assert
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(order, actualCalculateTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#calculateTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link TaxServiceImpl} MustCalculate is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#calculateTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.calculateTaxForOrder(Order)"})
  public void testCalculateTaxForOrder_givenTaxServiceImplMustCalculateIsTrue()
      throws TaxException {
    // Arrange
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());
    taxServiceImpl.setTaxProviders(null);
    taxServiceImpl.setMustCalculate(true);

    // Act and Assert
    assertThrows(
        TaxException.class, () -> taxServiceImpl.calculateTaxForOrder(new NullOrderImpl()));
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
  }

  /**
   * Test {@link TaxServiceImpl#calculateTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Then calls {@link ModuleConfiguration#getIsDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#calculateTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.calculateTaxForOrder(Order)"})
  public void testCalculateTaxForOrder_thenCallsGetIsDefault() throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);
    when(list.isEmpty()).thenReturn(true);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCalculateTaxForOrderResult = taxServiceImpl.calculateTaxForOrder(order);

    // Assert
    verify(list).isEmpty();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(order, actualCalculateTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#commitTaxForOrder(Order)}.
   *
   * <p>Method under test: {@link TaxServiceImpl#commitTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.commitTaxForOrder(Order)"})
  public void testCommitTaxForOrder() throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    SimpleTaxProvider simpleTaxProvider = mock(SimpleTaxProvider.class);
    when(simpleTaxProvider.commitTaxForOrder(
            Mockito.<Order>any(), Mockito.<ModuleConfiguration>any()))
        .thenThrow(new TaxException("An error occurred"));
    when(simpleTaxProvider.canRespond(Mockito.<ModuleConfiguration>any())).thenReturn(true);

    ArrayList<TaxProvider> taxProviderList = new ArrayList<>();
    taxProviderList.add(simpleTaxProvider);
    Iterator<TaxProvider> iteratorResult = taxProviderList.iterator();
    when(list.isEmpty()).thenReturn(false);
    when(list.iterator()).thenReturn(iteratorResult);

    // Act and Assert
    assertThrows(TaxException.class, () -> taxServiceImpl.commitTaxForOrder(new NullOrderImpl()));
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    verify(simpleTaxProvider).canRespond(isA(ModuleConfiguration.class));
    verify(simpleTaxProvider).commitTaxForOrder(isA(Order.class), isA(ModuleConfiguration.class));
  }

  /**
   * Test {@link TaxServiceImpl#commitTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SimpleTaxProvider} (default constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#commitTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.commitTaxForOrder(Order)"})
  public void testCommitTaxForOrder_givenArrayListAddSimpleTaxProvider_thenCallsIterator()
      throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    ArrayList<TaxProvider> taxProviderList = new ArrayList<>();
    taxProviderList.add(new SimpleTaxProvider());
    Iterator<TaxProvider> iteratorResult = taxProviderList.iterator();
    when(list.isEmpty()).thenReturn(false);
    when(list.iterator()).thenReturn(iteratorResult);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCommitTaxForOrderResult = taxServiceImpl.commitTaxForOrder(order);

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(order, actualCommitTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#commitTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SiteMapConfigurationImpl} (default
   *       constructor).
   *   <li>Then calls {@link List#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#commitTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.commitTaxForOrder(Order)"})
  public void testCommitTaxForOrder_givenArrayListAddSiteMapConfigurationImpl_thenCallsIsEmpty()
      throws TaxException {
    // Arrange
    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(new SiteMapConfigurationImpl());
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);
    when(list.isEmpty()).thenReturn(true);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCommitTaxForOrderResult = taxServiceImpl.commitTaxForOrder(order);

    // Assert
    verify(list).isEmpty();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(order, actualCommitTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#commitTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#isEmpty()} return {@code false}.
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#commitTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.commitTaxForOrder(Order)"})
  public void testCommitTaxForOrder_givenListIsEmptyReturnFalse_thenCallsIterator()
      throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);
    when(list.isEmpty()).thenReturn(false);

    ArrayList<TaxProvider> taxProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(taxProviderList.iterator());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCommitTaxForOrderResult = taxServiceImpl.commitTaxForOrder(order);

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(order, actualCommitTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#commitTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#isEmpty()} return {@code true}.
   *   <li>Then calls {@link ModuleConfiguration#getIsDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#commitTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.commitTaxForOrder(Order)"})
  public void testCommitTaxForOrder_givenListIsEmptyReturnTrue_thenCallsGetIsDefault()
      throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);
    when(list.isEmpty()).thenReturn(true);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCommitTaxForOrderResult = taxServiceImpl.commitTaxForOrder(order);

    // Assert
    verify(list).isEmpty();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(order, actualCommitTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#commitTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link SimpleTaxProvider} {@link SimpleTaxProvider#commitTaxForOrder(Order,
   *       ModuleConfiguration)} return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#commitTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.commitTaxForOrder(Order)"})
  public void testCommitTaxForOrder_givenSimpleTaxProviderCommitTaxForOrderReturnNullOrderImpl()
      throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    SimpleTaxProvider simpleTaxProvider = mock(SimpleTaxProvider.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(simpleTaxProvider.commitTaxForOrder(
            Mockito.<Order>any(), Mockito.<ModuleConfiguration>any()))
        .thenReturn(nullOrderImpl);
    when(simpleTaxProvider.canRespond(Mockito.<ModuleConfiguration>any())).thenReturn(true);

    ArrayList<TaxProvider> taxProviderList = new ArrayList<>();
    taxProviderList.add(simpleTaxProvider);
    Iterator<TaxProvider> iteratorResult = taxProviderList.iterator();
    when(list.isEmpty()).thenReturn(false);
    when(list.iterator()).thenReturn(iteratorResult);

    // Act
    Order actualCommitTaxForOrderResult = taxServiceImpl.commitTaxForOrder(new NullOrderImpl());

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    verify(simpleTaxProvider).canRespond(isA(ModuleConfiguration.class));
    verify(simpleTaxProvider).commitTaxForOrder(isA(Order.class), isA(ModuleConfiguration.class));
    assertSame(nullOrderImpl, actualCommitTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#commitTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link TaxServiceImpl} MustCalculate is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#commitTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.commitTaxForOrder(Order)"})
  public void testCommitTaxForOrder_givenTaxServiceImplMustCalculateIsFalse() throws TaxException {
    // Arrange
    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(new SiteMapConfigurationImpl());
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);
    taxServiceImpl.setTaxProviders(null);
    taxServiceImpl.setMustCalculate(false);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCommitTaxForOrderResult = taxServiceImpl.commitTaxForOrder(order);

    // Assert
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(order, actualCommitTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#commitTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link TaxServiceImpl} MustCalculate is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#commitTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.commitTaxForOrder(Order)"})
  public void testCommitTaxForOrder_givenTaxServiceImplMustCalculateIsTrue() throws TaxException {
    // Arrange
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());
    taxServiceImpl.setTaxProviders(null);
    taxServiceImpl.setMustCalculate(true);

    // Act and Assert
    assertThrows(TaxException.class, () -> taxServiceImpl.commitTaxForOrder(new NullOrderImpl()));
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
  }

  /**
   * Test {@link TaxServiceImpl#commitTaxForOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link TaxServiceImpl}.
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#commitTaxForOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order TaxServiceImpl.commitTaxForOrder(Order)"})
  public void testCommitTaxForOrder_givenTaxServiceImpl_thenReturnNullOrderImpl()
      throws TaxException {
    // Arrange
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCommitTaxForOrderResult = taxServiceImpl.commitTaxForOrder(order);

    // Assert
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    assertSame(order, actualCommitTaxForOrderResult);
  }

  /**
   * Test {@link TaxServiceImpl#cancelTax(Order)}.
   *
   * <p>Method under test: {@link TaxServiceImpl#cancelTax(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxServiceImpl.cancelTax(Order)"})
  public void testCancelTax() throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    SimpleTaxProvider simpleTaxProvider = mock(SimpleTaxProvider.class);
    doThrow(new TaxException("An error occurred"))
        .when(simpleTaxProvider)
        .cancelTax(Mockito.<Order>any(), Mockito.<ModuleConfiguration>any());
    when(simpleTaxProvider.canRespond(Mockito.<ModuleConfiguration>any())).thenReturn(true);

    ArrayList<TaxProvider> taxProviderList = new ArrayList<>();
    taxProviderList.add(simpleTaxProvider);
    Iterator<TaxProvider> iteratorResult = taxProviderList.iterator();
    when(list.isEmpty()).thenReturn(false);
    when(list.iterator()).thenReturn(iteratorResult);

    // Act and Assert
    assertThrows(TaxException.class, () -> taxServiceImpl.cancelTax(new NullOrderImpl()));
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    verify(simpleTaxProvider).canRespond(isA(ModuleConfiguration.class));
    verify(simpleTaxProvider).cancelTax(isA(Order.class), isA(ModuleConfiguration.class));
  }

  /**
   * Test {@link TaxServiceImpl#cancelTax(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SimpleTaxProvider} (default constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#cancelTax(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxServiceImpl.cancelTax(Order)"})
  public void testCancelTax_givenArrayListAddSimpleTaxProvider_thenCallsIterator()
      throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    ArrayList<TaxProvider> taxProviderList = new ArrayList<>();
    taxProviderList.add(new SimpleTaxProvider());
    Iterator<TaxProvider> iteratorResult = taxProviderList.iterator();
    when(list.isEmpty()).thenReturn(false);
    when(list.iterator()).thenReturn(iteratorResult);

    // Act
    taxServiceImpl.cancelTax(new NullOrderImpl());

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
  }

  /**
   * Test {@link TaxServiceImpl#cancelTax(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SiteMapConfigurationImpl} (default
   *       constructor).
   *   <li>Then calls {@link List#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#cancelTax(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxServiceImpl.cancelTax(Order)"})
  public void testCancelTax_givenArrayListAddSiteMapConfigurationImpl_thenCallsIsEmpty()
      throws TaxException {
    // Arrange
    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(new SiteMapConfigurationImpl());
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);
    when(list.isEmpty()).thenReturn(true);

    // Act
    taxServiceImpl.cancelTax(new NullOrderImpl());

    // Assert
    verify(list).isEmpty();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
  }

  /**
   * Test {@link TaxServiceImpl#cancelTax(Order)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#isEmpty()} return {@code false}.
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#cancelTax(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxServiceImpl.cancelTax(Order)"})
  public void testCancelTax_givenListIsEmptyReturnFalse_thenCallsIterator() throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);
    when(list.isEmpty()).thenReturn(false);

    ArrayList<TaxProvider> taxProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(taxProviderList.iterator());

    // Act
    taxServiceImpl.cancelTax(new NullOrderImpl());

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
  }

  /**
   * Test {@link TaxServiceImpl#cancelTax(Order)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#isEmpty()} return {@code true}.
   *   <li>Then calls {@link ModuleConfiguration#getIsDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#cancelTax(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxServiceImpl.cancelTax(Order)"})
  public void testCancelTax_givenListIsEmptyReturnTrue_thenCallsGetIsDefault() throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);
    when(list.isEmpty()).thenReturn(true);

    // Act
    taxServiceImpl.cancelTax(new NullOrderImpl());

    // Assert
    verify(list).isEmpty();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
  }

  /**
   * Test {@link TaxServiceImpl#cancelTax(Order)}.
   *
   * <ul>
   *   <li>Given {@link SimpleTaxProvider} {@link SimpleTaxProvider#cancelTax(Order,
   *       ModuleConfiguration)} does nothing.
   *   <li>Then calls {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#cancelTax(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxServiceImpl.cancelTax(Order)"})
  public void testCancelTax_givenSimpleTaxProviderCancelTaxDoesNothing_thenCallsCanRespond()
      throws TaxException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    SimpleTaxProvider simpleTaxProvider = mock(SimpleTaxProvider.class);
    doNothing()
        .when(simpleTaxProvider)
        .cancelTax(Mockito.<Order>any(), Mockito.<ModuleConfiguration>any());
    when(simpleTaxProvider.canRespond(Mockito.<ModuleConfiguration>any())).thenReturn(true);

    ArrayList<TaxProvider> taxProviderList = new ArrayList<>();
    taxProviderList.add(simpleTaxProvider);
    Iterator<TaxProvider> iteratorResult = taxProviderList.iterator();
    when(list.isEmpty()).thenReturn(false);
    when(list.iterator()).thenReturn(iteratorResult);

    // Act
    taxServiceImpl.cancelTax(new NullOrderImpl());

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    verify(simpleTaxProvider).canRespond(isA(ModuleConfiguration.class));
    verify(simpleTaxProvider).cancelTax(isA(Order.class), isA(ModuleConfiguration.class));
  }

  /**
   * Test {@link TaxServiceImpl#cancelTax(Order)}.
   *
   * <ul>
   *   <li>Given {@link TaxServiceImpl} MustCalculate is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#cancelTax(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxServiceImpl.cancelTax(Order)"})
  public void testCancelTax_givenTaxServiceImplMustCalculateIsFalse() throws TaxException {
    // Arrange
    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(new SiteMapConfigurationImpl());
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);
    taxServiceImpl.setTaxProviders(null);
    taxServiceImpl.setMustCalculate(false);

    // Act
    taxServiceImpl.cancelTax(new NullOrderImpl());

    // Assert
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
  }

  /**
   * Test {@link TaxServiceImpl#cancelTax(Order)}.
   *
   * <ul>
   *   <li>Given {@link TaxServiceImpl} MustCalculate is {@code true}.
   *   <li>Then throw {@link TaxException}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#cancelTax(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxServiceImpl.cancelTax(Order)"})
  public void testCancelTax_givenTaxServiceImplMustCalculateIsTrue_thenThrowTaxException()
      throws TaxException {
    // Arrange
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());
    taxServiceImpl.setTaxProviders(null);
    taxServiceImpl.setMustCalculate(true);

    // Act and Assert
    assertThrows(TaxException.class, () -> taxServiceImpl.cancelTax(new NullOrderImpl()));
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
  }

  /**
   * Test {@link TaxServiceImpl#cancelTax(Order)}.
   *
   * <ul>
   *   <li>Given {@link TaxServiceImpl}.
   *   <li>Then calls {@link
   *       ModuleConfigurationService#findActiveConfigurationsByType(ModuleConfigurationType)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxServiceImpl#cancelTax(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxServiceImpl.cancelTax(Order)"})
  public void testCancelTax_givenTaxServiceImpl_thenCallsFindActiveConfigurationsByType()
      throws TaxException {
    // Arrange
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    taxServiceImpl.cancelTax(new NullOrderImpl());

    // Assert
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
  }
}
