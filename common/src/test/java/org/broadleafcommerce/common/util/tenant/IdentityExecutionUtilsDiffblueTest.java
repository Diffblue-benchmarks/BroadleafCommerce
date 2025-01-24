/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.util.tenant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.util.Currency;
import java.util.Set;
import javax.sql.DataSource;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.common.web.DeployBehavior;
import org.broadleafcommerce.common.web.DeployState;
import org.broadleafcommerce.common.web.EnforceEnterpriseCollectionBehaviorState;
import org.broadleafcommerce.common.web.ValidateProductionChangesState;
import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

public class IdentityExecutionUtilsDiffblueTest {
  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code catalog}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteCatalog() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BroadleafRequestContext.getBroadleafRequestContext(true));
    SiteImpl site = new SiteImpl();

    // Act
    Object actualRunOperationByIdentifierResult = IdentityExecutionUtils.runOperationByIdentifier(operation, site,
        new CatalogImpl());

    // Assert
    verify(operation).execute();
    assertTrue(actualRunOperationByIdentifierResult instanceof BroadleafRequestContext);
    java.util.Locale javaLocale = ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getJavaLocale();
    assertEquals("", javaLocale.getDisplayScript());
    assertEquals("", javaLocale.getDisplayVariant());
    assertEquals("", javaLocale.getScript());
    assertEquals("", javaLocale.getVariant());
    Currency javaCurrency = ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getJavaCurrency();
    assertEquals("British Pound", javaCurrency.getDisplayName());
    assertEquals("English (United Kingdom)", javaLocale.getDisplayName());
    assertEquals("English", javaLocale.getDisplayLanguage());
    assertEquals("GB", javaLocale.getCountry());
    assertEquals("GBP", javaCurrency.getCurrencyCode());
    assertEquals("GBP", javaCurrency.toString());
    assertEquals("GBR", javaLocale.getISO3Country());
    assertEquals("United Kingdom", javaLocale.getDisplayCountry());
    assertEquals("£", javaCurrency.getSymbol());
    assertEquals("en", javaLocale.getLanguage());
    assertEquals("eng", javaLocale.getISO3Language());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdminUserId());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSandBoxId());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestURIWithoutContext());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getTimeZone());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequest());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getResponse());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestDTO());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestedBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getLocale());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSandBox());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getCurrentCatalog());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getCurrentProfile());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getNonPersistentSite());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSite());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getTheme());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getMessageSource());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getWebRequest());
    assertEquals(2, javaCurrency.getDefaultFractionDigits());
    assertEquals(826, javaCurrency.getNumericCode());
    assertEquals(DeployBehavior.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getDeployBehavior());
    assertEquals(DeployState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getDeployState());
    assertEquals(EnforceEnterpriseCollectionBehaviorState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getEnforceEnterpriseCollectionBehaviorState());
    assertEquals(ValidateProductionChangesState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getValidateProductionChangesState());
    assertFalse(javaLocale.hasExtensions());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdmin());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getIgnoreSite());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getInternalIgnoreFilters());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getInternalValidateFind());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getExplicitCatalogs().isEmpty());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdditionalProperties().isEmpty());
    Set<Character> extensionKeys = javaLocale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).isProductionSandBox());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleKeys());
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code catalog}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteCatalog_givenNull_field() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);
    SiteImpl site = new SiteImpl();

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(operation, site, new CatalogImpl());

    // Assert
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code catalog}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteCatalog_givenNull_field_whenNull() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(operation, null, new CatalogImpl());

    // Assert
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code catalog}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteCatalog_thenThrowRuntimeException() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));
    SiteImpl site = new SiteImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, site, new CatalogImpl()));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code catalog}.
   * <ul>
   *   <li>Then throw {@link Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteCatalog_thenThrowThrowable() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new Throwable());
    SiteImpl site = new SiteImpl();

    // Act and Assert
    assertThrows(Throwable.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, site, new CatalogImpl()));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   * with {@code operation}, {@code site}, {@code profile}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfile() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BroadleafRequestContext.getBroadleafRequestContext(true));
    SiteImpl site = new SiteImpl();

    // Act
    Object actualRunOperationByIdentifierResult = IdentityExecutionUtils.runOperationByIdentifier(operation, site,
        new SiteImpl());

    // Assert
    verify(operation).execute();
    assertTrue(actualRunOperationByIdentifierResult instanceof BroadleafRequestContext);
    java.util.Locale javaLocale = ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getJavaLocale();
    assertEquals("", javaLocale.getDisplayScript());
    assertEquals("", javaLocale.getDisplayVariant());
    assertEquals("", javaLocale.getScript());
    assertEquals("", javaLocale.getVariant());
    Currency javaCurrency = ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getJavaCurrency();
    assertEquals("British Pound", javaCurrency.getDisplayName());
    assertEquals("English (United Kingdom)", javaLocale.getDisplayName());
    assertEquals("English", javaLocale.getDisplayLanguage());
    assertEquals("GB", javaLocale.getCountry());
    assertEquals("GBP", javaCurrency.getCurrencyCode());
    assertEquals("GBP", javaCurrency.toString());
    assertEquals("GBR", javaLocale.getISO3Country());
    assertEquals("United Kingdom", javaLocale.getDisplayCountry());
    assertEquals("£", javaCurrency.getSymbol());
    assertEquals("en", javaLocale.getLanguage());
    assertEquals("eng", javaLocale.getISO3Language());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdminUserId());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSandBoxId());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestURIWithoutContext());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getTimeZone());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequest());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getResponse());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestDTO());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestedBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getLocale());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSandBox());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getCurrentCatalog());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getCurrentProfile());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getNonPersistentSite());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSite());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getTheme());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getMessageSource());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getWebRequest());
    assertEquals(2, javaCurrency.getDefaultFractionDigits());
    assertEquals(826, javaCurrency.getNumericCode());
    assertEquals(DeployBehavior.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getDeployBehavior());
    assertEquals(DeployState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getDeployState());
    assertEquals(EnforceEnterpriseCollectionBehaviorState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getEnforceEnterpriseCollectionBehaviorState());
    assertEquals(ValidateProductionChangesState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getValidateProductionChangesState());
    assertFalse(javaLocale.hasExtensions());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdmin());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getIgnoreSite());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getInternalIgnoreFilters());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getInternalValidateFind());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getExplicitCatalogs().isEmpty());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdditionalProperties().isEmpty());
    Set<Character> extensionKeys = javaLocale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).isProductionSandBox());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleKeys());
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code profile}, {@code catalog}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalog() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BroadleafRequestContext.getBroadleafRequestContext(true));
    SiteImpl site = new SiteImpl();
    SiteImpl profile = new SiteImpl();

    // Act
    Object actualRunOperationByIdentifierResult = IdentityExecutionUtils.runOperationByIdentifier(operation, site,
        profile, new CatalogImpl());

    // Assert
    verify(operation).execute();
    assertTrue(actualRunOperationByIdentifierResult instanceof BroadleafRequestContext);
    java.util.Locale javaLocale = ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getJavaLocale();
    assertEquals("", javaLocale.getDisplayScript());
    assertEquals("", javaLocale.getDisplayVariant());
    assertEquals("", javaLocale.getScript());
    assertEquals("", javaLocale.getVariant());
    Currency javaCurrency = ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getJavaCurrency();
    assertEquals("British Pound", javaCurrency.getDisplayName());
    assertEquals("English (United Kingdom)", javaLocale.getDisplayName());
    assertEquals("English", javaLocale.getDisplayLanguage());
    assertEquals("GB", javaLocale.getCountry());
    assertEquals("GBP", javaCurrency.getCurrencyCode());
    assertEquals("GBP", javaCurrency.toString());
    assertEquals("GBR", javaLocale.getISO3Country());
    assertEquals("United Kingdom", javaLocale.getDisplayCountry());
    assertEquals("£", javaCurrency.getSymbol());
    assertEquals("en", javaLocale.getLanguage());
    assertEquals("eng", javaLocale.getISO3Language());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdminUserId());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSandBoxId());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestURIWithoutContext());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getTimeZone());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequest());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getResponse());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestDTO());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestedBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getLocale());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSandBox());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getCurrentCatalog());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getCurrentProfile());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getNonPersistentSite());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSite());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getTheme());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getMessageSource());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getWebRequest());
    assertEquals(2, javaCurrency.getDefaultFractionDigits());
    assertEquals(826, javaCurrency.getNumericCode());
    assertEquals(DeployBehavior.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getDeployBehavior());
    assertEquals(DeployState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getDeployState());
    assertEquals(EnforceEnterpriseCollectionBehaviorState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getEnforceEnterpriseCollectionBehaviorState());
    assertEquals(ValidateProductionChangesState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getValidateProductionChangesState());
    assertFalse(javaLocale.hasExtensions());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdmin());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getIgnoreSite());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getInternalIgnoreFilters());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getInternalValidateFind());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getExplicitCatalogs().isEmpty());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdditionalProperties().isEmpty());
    Set<Character> extensionKeys = javaLocale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).isProductionSandBox());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleKeys());
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code profile}, {@code catalog}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalog2() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));
    SiteImpl site = new SiteImpl();
    SiteImpl profile = new SiteImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, site, profile, new CatalogImpl()));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)}
   * with {@code operation}, {@code site}, {@code profile}, {@code catalog},
   * {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalogTransactionManager() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);
    SiteImpl profile = new SiteImpl();

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(operation, null, profile, new CatalogImpl(), null);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)}
   * with {@code operation}, {@code site}, {@code profile}, {@code catalog},
   * {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalogTransactionManager2() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BroadleafRequestContext.getBroadleafRequestContext(true));
    SiteImpl profile = new SiteImpl();

    // Act
    Object actualRunOperationByIdentifierResult = IdentityExecutionUtils.runOperationByIdentifier(operation, null,
        profile, new CatalogImpl(), null);

    // Assert
    verify(operation).execute();
    assertTrue(actualRunOperationByIdentifierResult instanceof BroadleafRequestContext);
    java.util.Locale javaLocale = ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getJavaLocale();
    assertEquals("", javaLocale.getDisplayScript());
    assertEquals("", javaLocale.getDisplayVariant());
    assertEquals("", javaLocale.getScript());
    assertEquals("", javaLocale.getVariant());
    Currency javaCurrency = ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getJavaCurrency();
    assertEquals("British Pound", javaCurrency.getDisplayName());
    assertEquals("English (United Kingdom)", javaLocale.getDisplayName());
    assertEquals("English", javaLocale.getDisplayLanguage());
    assertEquals("GB", javaLocale.getCountry());
    assertEquals("GBP", javaCurrency.getCurrencyCode());
    assertEquals("GBP", javaCurrency.toString());
    assertEquals("GBR", javaLocale.getISO3Country());
    assertEquals("United Kingdom", javaLocale.getDisplayCountry());
    assertEquals("£", javaCurrency.getSymbol());
    assertEquals("en", javaLocale.getLanguage());
    assertEquals("eng", javaLocale.getISO3Language());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdminUserId());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSandBoxId());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestURIWithoutContext());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getTimeZone());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequest());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getResponse());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestDTO());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestedBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getLocale());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSandBox());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getCurrentCatalog());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getCurrentProfile());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getNonPersistentSite());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSite());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getTheme());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getMessageSource());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getWebRequest());
    assertEquals(2, javaCurrency.getDefaultFractionDigits());
    assertEquals(826, javaCurrency.getNumericCode());
    assertEquals(DeployBehavior.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getDeployBehavior());
    assertEquals(DeployState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getDeployState());
    assertEquals(EnforceEnterpriseCollectionBehaviorState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getEnforceEnterpriseCollectionBehaviorState());
    assertEquals(ValidateProductionChangesState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getValidateProductionChangesState());
    assertFalse(javaLocale.hasExtensions());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdmin());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getIgnoreSite());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getInternalIgnoreFilters());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getInternalValidateFind());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getExplicitCatalogs().isEmpty());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdditionalProperties().isEmpty());
    Set<Character> extensionKeys = javaLocale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).isProductionSandBox());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleKeys());
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)}
   * with {@code operation}, {@code site}, {@code profile}, {@code catalog},
   * {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalogTransactionManager3() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);
    SiteImpl profile = new SiteImpl();
    CatalogImpl catalog = new CatalogImpl();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    doNothing().when(connection).commit();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(operation, null, profile, catalog,
        new DataSourceTransactionManager(dataSource));

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)}
   * with {@code operation}, {@code site}, {@code profile}, {@code catalog},
   * {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalogTransactionManager4() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));
    SiteImpl site = new SiteImpl();
    SiteImpl profile = new SiteImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, site, profile, new CatalogImpl(), null));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)}
   * with {@code operation}, {@code site}, {@code profile}, {@code catalog},
   * {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalogTransactionManager5() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));
    SiteImpl site = new SiteImpl();
    SiteImpl profile = new SiteImpl();
    CatalogImpl catalog = new CatalogImpl();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    doNothing().when(connection).rollback();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> IdentityExecutionUtils.runOperationByIdentifier(operation, site, profile,
        catalog, new DataSourceTransactionManager(dataSource)));
    verify(connection).close();
    verify(connection).getAutoCommit();
    verify(connection).rollback();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)}
   * with {@code operation}, {@code site}, {@code profile}, {@code catalog},
   * {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalogTransactionManager6() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new Throwable());
    SiteImpl site = new SiteImpl();
    SiteImpl profile = new SiteImpl();

    // Act and Assert
    assertThrows(Throwable.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, site, profile, new CatalogImpl(), null));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code profile}, {@code catalog}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalog_givenNull_field() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);
    SiteImpl site = new SiteImpl();
    SiteImpl profile = new SiteImpl();

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(operation, site, profile, new CatalogImpl());

    // Assert
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code profile}, {@code catalog}.
   * <ul>
   *   <li>Then throw {@link Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalog_thenThrowThrowable() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new Throwable());
    SiteImpl site = new SiteImpl();
    SiteImpl profile = new SiteImpl();

    // Act and Assert
    assertThrows(Throwable.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, site, profile, new CatalogImpl()));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code profile}, {@code catalog}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalog_whenNull() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);
    SiteImpl profile = new SiteImpl();

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(operation, null, profile, new CatalogImpl());

    // Assert
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   * with {@code operation}, {@code site}, {@code profile}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfile_givenNull_field() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);
    SiteImpl site = new SiteImpl();

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(operation, site, new SiteImpl());

    // Assert
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   * with {@code operation}, {@code site}, {@code profile}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfile_givenNull_field_whenNull() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(operation, null, new SiteImpl());

    // Assert
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   * with {@code operation}, {@code site}, {@code profile}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfile_thenThrowRuntimeException() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));
    SiteImpl site = new SiteImpl();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, site, new SiteImpl()));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   * with {@code operation}, {@code site}, {@code profile}.
   * <ul>
   *   <li>Then throw {@link Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSiteProfile_thenThrowThrowable() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new Throwable());
    SiteImpl site = new SiteImpl();

    // Act and Assert
    assertThrows(Throwable.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, site, new SiteImpl()));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)}
   * with {@code operation}, {@code site}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSite_givenNull_field() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(operation, new SiteImpl());

    // Assert
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)}
   * with {@code operation}, {@code site}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSite_givenNull_field_whenNull() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(operation, null);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)}
   * with {@code operation}, {@code site}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   *   <li>Then throw {@link Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSite_givenThrowable_thenThrowThrowable() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new Throwable());

    // Act and Assert
    assertThrows(Throwable.class, () -> IdentityExecutionUtils.runOperationByIdentifier(operation, new SiteImpl()));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)}
   * with {@code operation}, {@code site}.
   * <ul>
   *   <li>Then return {@link BroadleafRequestContext}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSite_thenReturnBroadleafRequestContext() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BroadleafRequestContext.getBroadleafRequestContext(true));

    // Act
    Object actualRunOperationByIdentifierResult = IdentityExecutionUtils.runOperationByIdentifier(operation,
        new SiteImpl());

    // Assert
    verify(operation).execute();
    assertTrue(actualRunOperationByIdentifierResult instanceof BroadleafRequestContext);
    java.util.Locale javaLocale = ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getJavaLocale();
    assertEquals("", javaLocale.getDisplayScript());
    assertEquals("", javaLocale.getDisplayVariant());
    assertEquals("", javaLocale.getScript());
    assertEquals("", javaLocale.getVariant());
    Currency javaCurrency = ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getJavaCurrency();
    assertEquals("British Pound", javaCurrency.getDisplayName());
    assertEquals("English (United Kingdom)", javaLocale.getDisplayName());
    assertEquals("English", javaLocale.getDisplayLanguage());
    assertEquals("GB", javaLocale.getCountry());
    assertEquals("GBP", javaCurrency.getCurrencyCode());
    assertEquals("GBP", javaCurrency.toString());
    assertEquals("GBR", javaLocale.getISO3Country());
    assertEquals("United Kingdom", javaLocale.getDisplayCountry());
    assertEquals("£", javaCurrency.getSymbol());
    assertEquals("en", javaLocale.getLanguage());
    assertEquals("eng", javaLocale.getISO3Language());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdminUserId());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSandBoxId());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestURIWithoutContext());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getTimeZone());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequest());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getResponse());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestDTO());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getRequestedBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getLocale());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSandBox());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getCurrentCatalog());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getCurrentProfile());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getNonPersistentSite());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getSite());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getTheme());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getMessageSource());
    assertNull(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getWebRequest());
    assertEquals(2, javaCurrency.getDefaultFractionDigits());
    assertEquals(826, javaCurrency.getNumericCode());
    assertEquals(DeployBehavior.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getDeployBehavior());
    assertEquals(DeployState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getDeployState());
    assertEquals(EnforceEnterpriseCollectionBehaviorState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getEnforceEnterpriseCollectionBehaviorState());
    assertEquals(ValidateProductionChangesState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationByIdentifierResult).getValidateProductionChangesState());
    assertFalse(javaLocale.hasExtensions());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdmin());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getIgnoreSite());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getInternalIgnoreFilters());
    assertFalse(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getInternalValidateFind());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getExplicitCatalogs().isEmpty());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).getAdditionalProperties().isEmpty());
    Set<Character> extensionKeys = javaLocale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(((BroadleafRequestContext) actualRunOperationByIdentifierResult).isProductionSandBox());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleKeys());
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)}
   * with {@code operation}, {@code site}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)}
   */
  @Test
  public void testRunOperationByIdentifierWithOperationSite_thenThrowRuntimeException() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, new SiteImpl()));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)}
   * with {@code operation}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)}
   */
  @Test
  public void testRunOperationAndIgnoreIdentifierWithOperation() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BroadleafRequestContext.getBroadleafRequestContext(true));

    // Act
    Object actualRunOperationAndIgnoreIdentifierResult = IdentityExecutionUtils
        .runOperationAndIgnoreIdentifier(operation);

    // Assert
    verify(operation).execute();
    assertTrue(actualRunOperationAndIgnoreIdentifierResult instanceof BroadleafRequestContext);
    java.util.Locale javaLocale = ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult)
        .getJavaLocale();
    assertEquals("", javaLocale.getDisplayScript());
    assertEquals("", javaLocale.getDisplayVariant());
    assertEquals("", javaLocale.getScript());
    assertEquals("", javaLocale.getVariant());
    Currency javaCurrency = ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getJavaCurrency();
    assertEquals("British Pound", javaCurrency.getDisplayName());
    assertEquals("English (United Kingdom)", javaLocale.getDisplayName());
    assertEquals("English", javaLocale.getDisplayLanguage());
    assertEquals("GB", javaLocale.getCountry());
    assertEquals("GBP", javaCurrency.getCurrencyCode());
    assertEquals("GBP", javaCurrency.toString());
    assertEquals("GBR", javaLocale.getISO3Country());
    assertEquals("United Kingdom", javaLocale.getDisplayCountry());
    assertEquals("£", javaCurrency.getSymbol());
    assertEquals("en", javaLocale.getLanguage());
    assertEquals("eng", javaLocale.getISO3Language());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getAdminUserId());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getSandBoxId());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getRequestURIWithoutContext());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getTimeZone());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getRequest());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getResponse());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getRequestDTO());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getRequestedBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getLocale());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getSandBox());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getCurrentCatalog());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getCurrentProfile());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getNonPersistentSite());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getSite());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getTheme());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getMessageSource());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getWebRequest());
    assertEquals(2, javaCurrency.getDefaultFractionDigits());
    assertEquals(826, javaCurrency.getNumericCode());
    assertEquals(DeployBehavior.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getDeployBehavior());
    assertEquals(DeployState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getDeployState());
    assertEquals(EnforceEnterpriseCollectionBehaviorState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult)
            .getEnforceEnterpriseCollectionBehaviorState());
    assertEquals(ValidateProductionChangesState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getValidateProductionChangesState());
    assertFalse(javaLocale.hasExtensions());
    assertFalse(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getAdmin());
    assertFalse(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getIgnoreSite());
    assertFalse(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getInternalIgnoreFilters());
    assertFalse(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getInternalValidateFind());
    assertTrue(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getExplicitCatalogs().isEmpty());
    assertTrue(
        ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getAdditionalProperties().isEmpty());
    Set<Character> extensionKeys = javaLocale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).isProductionSandBox());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleKeys());
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation, PlatformTransactionManager)}
   * with {@code operation}, {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation, PlatformTransactionManager)}
   */
  @Test
  public void testRunOperationAndIgnoreIdentifierWithOperationTransactionManager() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    IdentityExecutionUtils.runOperationAndIgnoreIdentifier(operation, null);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation, PlatformTransactionManager)}
   * with {@code operation}, {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation, PlatformTransactionManager)}
   */
  @Test
  public void testRunOperationAndIgnoreIdentifierWithOperationTransactionManager2() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BroadleafRequestContext.getBroadleafRequestContext(true));

    // Act
    Object actualRunOperationAndIgnoreIdentifierResult = IdentityExecutionUtils
        .runOperationAndIgnoreIdentifier(operation, null);

    // Assert
    verify(operation).execute();
    assertTrue(actualRunOperationAndIgnoreIdentifierResult instanceof BroadleafRequestContext);
    java.util.Locale javaLocale = ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult)
        .getJavaLocale();
    assertEquals("", javaLocale.getDisplayScript());
    assertEquals("", javaLocale.getDisplayVariant());
    assertEquals("", javaLocale.getScript());
    assertEquals("", javaLocale.getVariant());
    Currency javaCurrency = ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getJavaCurrency();
    assertEquals("British Pound", javaCurrency.getDisplayName());
    assertEquals("English (United Kingdom)", javaLocale.getDisplayName());
    assertEquals("English", javaLocale.getDisplayLanguage());
    assertEquals("GB", javaLocale.getCountry());
    assertEquals("GBP", javaCurrency.getCurrencyCode());
    assertEquals("GBP", javaCurrency.toString());
    assertEquals("GBR", javaLocale.getISO3Country());
    assertEquals("United Kingdom", javaLocale.getDisplayCountry());
    assertEquals("£", javaCurrency.getSymbol());
    assertEquals("en", javaLocale.getLanguage());
    assertEquals("eng", javaLocale.getISO3Language());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getAdminUserId());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getSandBoxId());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getRequestURIWithoutContext());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getTimeZone());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getRequest());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getResponse());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getRequestDTO());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getRequestedBroadleafCurrency());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getLocale());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getSandBox());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getCurrentCatalog());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getCurrentProfile());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getNonPersistentSite());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getSite());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getTheme());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getMessageSource());
    assertNull(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getWebRequest());
    assertEquals(2, javaCurrency.getDefaultFractionDigits());
    assertEquals(826, javaCurrency.getNumericCode());
    assertEquals(DeployBehavior.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getDeployBehavior());
    assertEquals(DeployState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getDeployState());
    assertEquals(EnforceEnterpriseCollectionBehaviorState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult)
            .getEnforceEnterpriseCollectionBehaviorState());
    assertEquals(ValidateProductionChangesState.UNDEFINED,
        ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getValidateProductionChangesState());
    assertFalse(javaLocale.hasExtensions());
    assertFalse(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getAdmin());
    assertFalse(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getIgnoreSite());
    assertFalse(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getInternalIgnoreFilters());
    assertFalse(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getInternalValidateFind());
    assertTrue(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getExplicitCatalogs().isEmpty());
    assertTrue(
        ((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).getAdditionalProperties().isEmpty());
    Set<Character> extensionKeys = javaLocale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(((BroadleafRequestContext) actualRunOperationAndIgnoreIdentifierResult).isProductionSandBox());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleKeys());
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation, PlatformTransactionManager)}
   * with {@code operation}, {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation, PlatformTransactionManager)}
   */
  @Test
  public void testRunOperationAndIgnoreIdentifierWithOperationTransactionManager3() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    doNothing().when(connection).commit();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    IdentityExecutionUtils.runOperationAndIgnoreIdentifier(operation, new DataSourceTransactionManager(dataSource));

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation, PlatformTransactionManager)}
   * with {@code operation}, {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation, PlatformTransactionManager)}
   */
  @Test
  public void testRunOperationAndIgnoreIdentifierWithOperationTransactionManager4() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> IdentityExecutionUtils.runOperationAndIgnoreIdentifier(operation, null));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation, PlatformTransactionManager)}
   * with {@code operation}, {@code transactionManager}.
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation, PlatformTransactionManager)}
   */
  @Test
  public void testRunOperationAndIgnoreIdentifierWithOperationTransactionManager5() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    doNothing().when(connection).rollback();
    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> IdentityExecutionUtils.runOperationAndIgnoreIdentifier(operation,
        new DataSourceTransactionManager(dataSource)));
    verify(connection).close();
    verify(connection).getAutoCommit();
    verify(connection).rollback();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)}
   * with {@code operation}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)}
   */
  @Test
  public void testRunOperationAndIgnoreIdentifierWithOperation_givenNull_field() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    IdentityExecutionUtils.runOperationAndIgnoreIdentifier(operation);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)}
   * with {@code operation}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)}
   */
  @Test
  public void testRunOperationAndIgnoreIdentifierWithOperation_thenThrowRuntimeException() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> IdentityExecutionUtils.runOperationAndIgnoreIdentifier(operation));
    verify(operation).execute();
  }

  /**
   * Test
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)}
   * with {@code operation}.
   * <ul>
   *   <li>Then throw {@link Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)}
   */
  @Test
  public void testRunOperationAndIgnoreIdentifierWithOperation_thenThrowThrowable() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new Throwable());

    // Act and Assert
    assertThrows(Throwable.class, () -> IdentityExecutionUtils.runOperationAndIgnoreIdentifier(operation));
    verify(operation).execute();
  }
}
