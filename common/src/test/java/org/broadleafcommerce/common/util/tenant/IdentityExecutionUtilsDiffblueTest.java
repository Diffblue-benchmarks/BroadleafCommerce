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

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.transaction.PlatformTransactionManager;

public class IdentityExecutionUtilsDiffblueTest {
  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code catalog}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Catalog)"
  })
  public void testRunOperationByIdentifierWithOperationSiteCatalog_givenNull_field()
      throws Throwable {
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
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code catalog}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Catalog)"
  })
  public void testRunOperationByIdentifierWithOperationSiteCatalog_givenNull_field_whenNull()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(operation, null, new CatalogImpl());

    // Assert
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code catalog}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Catalog)"
  })
  public void testRunOperationByIdentifierWithOperationSiteCatalog_thenThrowRuntimeException()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException());
    SiteImpl site = new SiteImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, site, new CatalogImpl()));
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Catalog)}
   * with {@code operation}, {@code site}, {@code catalog}.
   *
   * <ul>
   *   <li>Then throw {@link Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Catalog)"
  })
  public void testRunOperationByIdentifierWithOperationSiteCatalog_thenThrowThrowable()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new Throwable());
    SiteImpl site = new SiteImpl();

    // Act and Assert
    assertThrows(
        Throwable.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, site, new CatalogImpl()));
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site,
   * Catalog)} with {@code operation}, {@code site}, {@code profile}, {@code catalog}.
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Site, Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)"
  })
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalog() throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException());
    SiteImpl site = new SiteImpl();
    SiteImpl profile = new SiteImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            IdentityExecutionUtils.runOperationByIdentifier(
                operation, site, profile, new CatalogImpl()));
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site,
   * Catalog, PlatformTransactionManager)} with {@code operation}, {@code site}, {@code profile},
   * {@code catalog}, {@code transactionManager}.
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Site, Catalog, PlatformTransactionManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)"
  })
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalogTransactionManager()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);
    SiteImpl profile = new SiteImpl();

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(
        operation, null, profile, new CatalogImpl(), null);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site,
   * Catalog, PlatformTransactionManager)} with {@code operation}, {@code site}, {@code profile},
   * {@code catalog}, {@code transactionManager}.
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Site, Catalog, PlatformTransactionManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)"
  })
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalogTransactionManager2()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException());
    SiteImpl profile = new SiteImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            IdentityExecutionUtils.runOperationByIdentifier(
                operation, null, profile, new CatalogImpl(), null));
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site,
   * Catalog, PlatformTransactionManager)} with {@code operation}, {@code site}, {@code profile},
   * {@code catalog}, {@code transactionManager}.
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Site, Catalog, PlatformTransactionManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)"
  })
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalogTransactionManager3()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new Throwable());
    SiteImpl profile = new SiteImpl();

    // Act and Assert
    assertThrows(
        Throwable.class,
        () ->
            IdentityExecutionUtils.runOperationByIdentifier(
                operation, null, profile, new CatalogImpl(), null));
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site,
   * Catalog, PlatformTransactionManager)} with {@code operation}, {@code site}, {@code profile},
   * {@code catalog}, {@code transactionManager}.
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Site, Catalog, PlatformTransactionManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Site, Catalog, PlatformTransactionManager)"
  })
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalogTransactionManager4()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);
    SiteImpl site = new SiteImpl();
    SiteImpl profile = new SiteImpl();

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(
        operation, site, profile, new CatalogImpl(), null);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site,
   * Catalog)} with {@code operation}, {@code site}, {@code profile}, {@code catalog}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Site, Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)"
  })
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalog_givenNull_field()
      throws Throwable {
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
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site,
   * Catalog)} with {@code operation}, {@code site}, {@code profile}, {@code catalog}.
   *
   * <ul>
   *   <li>Then throw {@link Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Site, Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)"
  })
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalog_thenThrowThrowable()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new Throwable());
    SiteImpl site = new SiteImpl();
    SiteImpl profile = new SiteImpl();

    // Act and Assert
    assertThrows(
        Throwable.class,
        () ->
            IdentityExecutionUtils.runOperationByIdentifier(
                operation, site, profile, new CatalogImpl()));
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site,
   * Catalog)} with {@code operation}, {@code site}, {@code profile}, {@code catalog}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Site, Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Site, Catalog)"
  })
  public void testRunOperationByIdentifierWithOperationSiteProfileCatalog_whenNull()
      throws Throwable {
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
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   * with {@code operation}, {@code site}, {@code profile}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Site)"
  })
  public void testRunOperationByIdentifierWithOperationSiteProfile_givenNull_field()
      throws Throwable {
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
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   * with {@code operation}, {@code site}, {@code profile}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Site)"
  })
  public void testRunOperationByIdentifierWithOperationSiteProfile_givenNull_field_whenNull()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(operation, null, new SiteImpl());

    // Assert
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   * with {@code operation}, {@code site}, {@code profile}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Site)"
  })
  public void testRunOperationByIdentifierWithOperationSiteProfile_thenThrowRuntimeException()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException());
    SiteImpl site = new SiteImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, site, new SiteImpl()));
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site, Site)}
   * with {@code operation}, {@code site}, {@code profile}.
   *
   * <ul>
   *   <li>Then throw {@link Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site, Site)"
  })
  public void testRunOperationByIdentifierWithOperationSiteProfile_thenThrowThrowable()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new Throwable());
    SiteImpl site = new SiteImpl();

    // Act and Assert
    assertThrows(
        Throwable.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, site, new SiteImpl()));
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)} with
   * {@code operation}, {@code site}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site)"
  })
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
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)} with
   * {@code operation}, {@code site}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site)"
  })
  public void testRunOperationByIdentifierWithOperationSite_givenNull_field_whenNull()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    IdentityExecutionUtils.runOperationByIdentifier(operation, null);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)} with
   * {@code operation}, {@code site}.
   *
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.
   *   <li>Then throw {@link Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site)"
  })
  public void testRunOperationByIdentifierWithOperationSite_givenThrowable_thenThrowThrowable()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new Throwable());

    // Act and Assert
    assertThrows(
        Throwable.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, new SiteImpl()));
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation, Site)} with
   * {@code operation}, {@code site}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link IdentityExecutionUtils#runOperationByIdentifier(IdentityOperation,
   * Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationByIdentifier(IdentityOperation, Site)"
  })
  public void testRunOperationByIdentifierWithOperationSite_thenThrowRuntimeException()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> IdentityExecutionUtils.runOperationByIdentifier(operation, new SiteImpl()));
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation,
   * PlatformTransactionManager)} with {@code operation}, {@code transactionManager}.
   *
   * <p>Method under test: {@link
   * IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation,
   * PlatformTransactionManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationAndIgnoreIdentifier(IdentityOperation, PlatformTransactionManager)"
  })
  public void testRunOperationAndIgnoreIdentifierWithOperationTransactionManager()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    IdentityExecutionUtils.runOperationAndIgnoreIdentifier(operation, null);

    // Assert
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation,
   * PlatformTransactionManager)} with {@code operation}, {@code transactionManager}.
   *
   * <p>Method under test: {@link
   * IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation,
   * PlatformTransactionManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationAndIgnoreIdentifier(IdentityOperation, PlatformTransactionManager)"
  })
  public void testRunOperationAndIgnoreIdentifierWithOperationTransactionManager2()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> IdentityExecutionUtils.runOperationAndIgnoreIdentifier(operation, null));
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation,
   * PlatformTransactionManager)} with {@code operation}, {@code transactionManager}.
   *
   * <p>Method under test: {@link
   * IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation,
   * PlatformTransactionManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationAndIgnoreIdentifier(IdentityOperation, PlatformTransactionManager)"
  })
  public void testRunOperationAndIgnoreIdentifierWithOperationTransactionManager3()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new Throwable());

    // Act and Assert
    assertThrows(
        Throwable.class,
        () -> IdentityExecutionUtils.runOperationAndIgnoreIdentifier(operation, null));
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)} with
   * {@code operation}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationAndIgnoreIdentifier(IdentityOperation)"
  })
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
   * Test {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)} with
   * {@code operation}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationAndIgnoreIdentifier(IdentityOperation)"
  })
  public void testRunOperationAndIgnoreIdentifierWithOperation_thenThrowRuntimeException()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> IdentityExecutionUtils.runOperationAndIgnoreIdentifier(operation));
    verify(operation).execute();
  }

  /**
   * Test {@link IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)} with
   * {@code operation}.
   *
   * <ul>
   *   <li>Then throw {@link Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IdentityExecutionUtils#runOperationAndIgnoreIdentifier(IdentityOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IdentityExecutionUtils.runOperationAndIgnoreIdentifier(IdentityOperation)"
  })
  public void testRunOperationAndIgnoreIdentifierWithOperation_thenThrowThrowable()
      throws Throwable {
    // Arrange
    IdentityOperation<Object, Throwable> operation = mock(IdentityOperation.class);
    when(operation.execute()).thenThrow(new Throwable());

    // Act and Assert
    assertThrows(
        Throwable.class, () -> IdentityExecutionUtils.runOperationAndIgnoreIdentifier(operation));
    verify(operation).execute();
  }
}
