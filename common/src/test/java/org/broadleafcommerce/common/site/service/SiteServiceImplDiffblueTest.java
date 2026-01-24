package org.broadleafcommerce.common.site.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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
import java.util.List;
import org.broadleafcommerce.common.site.dao.SiteDao;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteCatalogXref;
import org.broadleafcommerce.common.site.domain.SiteCatalogXrefImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.StreamingTransactionCapableUtil;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.orm.jpa.JpaTransactionManager;

@RunWith(MockitoJUnitRunner.class)
public class SiteServiceImplDiffblueTest {
  @Mock private SiteDao siteDao;

  @InjectMocks private SiteServiceImpl siteServiceImpl;

  @Mock private StreamingTransactionCapableUtil streamingTransactionCapableUtil;

  /**
   * Test {@link SiteServiceImpl#createSite()}.
   *
   * <ul>
   *   <li>Given {@link SiteDao} {@link SiteDao#create()} return {@link SiteImpl} (default
   *       constructor).
   *   <li>Then return {@link SiteImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#createSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.createSite()"})
  public void testCreateSite_givenSiteDaoCreateReturnSiteImpl_thenReturnSiteImpl() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    when(siteDao.create()).thenReturn(siteImpl);

    // Act
    Site actualCreateSiteResult = siteServiceImpl.createSite();

    // Assert
    verify(siteDao).create();
    assertSame(siteImpl, actualCreateSiteResult);
  }

  /**
   * Test {@link SiteServiceImpl#createSite()}.
   *
   * <ul>
   *   <li>Given {@link SiteDao} {@link SiteDao#create()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#createSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.createSite()"})
  public void testCreateSite_givenSiteDaoCreateThrowRuntimeException_thenThrowRuntimeException() {
    // Arrange
    when(siteDao.create()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.createSite());
    verify(siteDao).create();
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteById(Long)} with {@code id}.
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveSiteById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveSiteById(Long)"})
  public void testRetrieveSiteByIdWithId() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    Site actualRetrieveSiteByIdResult = siteServiceImpl.retrieveSiteById(1L);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertNull(actualRetrieveSiteByIdResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteById(Long, boolean)} with {@code id}, {@code
   * persistentResult}.
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveSiteById(Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveSiteById(Long, boolean)"})
  public void testRetrieveSiteByIdWithIdPersistentResult() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    Site actualRetrieveSiteByIdResult = siteServiceImpl.retrieveSiteById(1L, true);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertNull(actualRetrieveSiteByIdResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteById(Long, boolean)} with {@code id}, {@code
   * persistentResult}.
   *
   * <ul>
   *   <li>Given {@link SiteServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveSiteById(Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveSiteById(Long, boolean)"})
  public void testRetrieveSiteByIdWithIdPersistentResult_givenSiteServiceImpl_whenNull() {
    // Arrange, Act and Assert
    assertNull(new SiteServiceImpl().retrieveSiteById(null, true));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteById(Long, boolean)} with {@code id}, {@code
   * persistentResult}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveSiteById(Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveSiteById(Long, boolean)"})
  public void testRetrieveSiteByIdWithIdPersistentResult_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.retrieveSiteById(1L, true));
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteById(Long)} with {@code id}.
   *
   * <ul>
   *   <li>Given {@link SiteServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveSiteById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveSiteById(Long)"})
  public void testRetrieveSiteByIdWithId_givenSiteServiceImpl_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SiteServiceImpl().retrieveSiteById(null));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteById(Long)} with {@code id}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveSiteById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveSiteById(Long)"})
  public void testRetrieveSiteByIdWithId_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.retrieveSiteById(1L));
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveNonPersistentSiteById(Long)}.
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveNonPersistentSiteById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveNonPersistentSiteById(Long)"})
  public void testRetrieveNonPersistentSiteById() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    Site actualRetrieveNonPersistentSiteByIdResult =
        siteServiceImpl.retrieveNonPersistentSiteById(1L);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertNull(actualRetrieveNonPersistentSiteByIdResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrieveNonPersistentSiteById(Long)}.
   *
   * <ul>
   *   <li>Given {@link SiteServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveNonPersistentSiteById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveNonPersistentSiteById(Long)"})
  public void testRetrieveNonPersistentSiteById_givenSiteServiceImpl_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SiteServiceImpl().retrieveNonPersistentSiteById(null));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveNonPersistentSiteById(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveNonPersistentSiteById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveNonPersistentSiteById(Long)"})
  public void testRetrieveNonPersistentSiteById_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.retrieveNonPersistentSiteById(1L));
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#retrievePersistentSiteById(Long)}.
   *
   * <p>Method under test: {@link SiteServiceImpl#retrievePersistentSiteById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrievePersistentSiteById(Long)"})
  public void testRetrievePersistentSiteById() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    Site actualRetrievePersistentSiteByIdResult = siteServiceImpl.retrievePersistentSiteById(1L);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertNull(actualRetrievePersistentSiteByIdResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrievePersistentSiteById(Long)}.
   *
   * <ul>
   *   <li>Given {@link SiteServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrievePersistentSiteById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrievePersistentSiteById(Long)"})
  public void testRetrievePersistentSiteById_givenSiteServiceImpl_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SiteServiceImpl().retrievePersistentSiteById(null));
  }

  /**
   * Test {@link SiteServiceImpl#retrievePersistentSiteById(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrievePersistentSiteById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrievePersistentSiteById(Long)"})
  public void testRetrievePersistentSiteById_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.retrievePersistentSiteById(1L));
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveNonPersistentSiteByIdentifer(String)}.
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveNonPersistentSiteByIdentifer(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveNonPersistentSiteByIdentifer(String)"})
  public void testRetrieveNonPersistentSiteByIdentifer() {
    // Arrange
    when(streamingTransactionCapableUtil.getTransactionManager())
        .thenReturn(new JpaTransactionManager(new SessionFactoryDelegatingImpl(null)));

    // Act
    Site actualRetrieveNonPersistentSiteByIdentiferResult =
        siteServiceImpl.retrieveNonPersistentSiteByIdentifer("42");

    // Assert
    verify(streamingTransactionCapableUtil).getTransactionManager();
    assertNull(actualRetrieveNonPersistentSiteByIdentiferResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrieveNonPersistentSiteByIdentifer(String)}.
   *
   * <ul>
   *   <li>Given {@link SiteServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveNonPersistentSiteByIdentifer(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveNonPersistentSiteByIdentifer(String)"})
  public void testRetrieveNonPersistentSiteByIdentifer_givenSiteServiceImpl_whenNull() {
    // Arrange, Act and Assert
    assertNull(new SiteServiceImpl().retrieveNonPersistentSiteByIdentifer(null));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveNonPersistentSiteByIdentifer(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveNonPersistentSiteByIdentifer(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveNonPersistentSiteByIdentifer(String)"})
  public void testRetrieveNonPersistentSiteByIdentifer_thenThrowRuntimeException() {
    // Arrange
    when(streamingTransactionCapableUtil.getTransactionManager()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> siteServiceImpl.retrieveNonPersistentSiteByIdentifer("42"));
    verify(streamingTransactionCapableUtil).getTransactionManager();
  }

  /**
   * Test {@link SiteServiceImpl#retrievePersistentSiteByIdentifier(String)}.
   *
   * <p>Method under test: {@link SiteServiceImpl#retrievePersistentSiteByIdentifier(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrievePersistentSiteByIdentifier(String)"})
  public void testRetrievePersistentSiteByIdentifier() {
    // Arrange
    when(streamingTransactionCapableUtil.getTransactionManager())
        .thenReturn(new JpaTransactionManager(new SessionFactoryDelegatingImpl(null)));

    // Act
    Site actualRetrievePersistentSiteByIdentifierResult =
        siteServiceImpl.retrievePersistentSiteByIdentifier("42");

    // Assert
    verify(streamingTransactionCapableUtil).getTransactionManager();
    assertNull(actualRetrievePersistentSiteByIdentifierResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrievePersistentSiteByIdentifier(String)}.
   *
   * <ul>
   *   <li>Given {@link SiteServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrievePersistentSiteByIdentifier(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrievePersistentSiteByIdentifier(String)"})
  public void testRetrievePersistentSiteByIdentifier_givenSiteServiceImpl_whenNull() {
    // Arrange, Act and Assert
    assertNull(new SiteServiceImpl().retrievePersistentSiteByIdentifier(null));
  }

  /**
   * Test {@link SiteServiceImpl#retrievePersistentSiteByIdentifier(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrievePersistentSiteByIdentifier(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrievePersistentSiteByIdentifier(String)"})
  public void testRetrievePersistentSiteByIdentifier_thenThrowRuntimeException() {
    // Arrange
    when(streamingTransactionCapableUtil.getTransactionManager()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> siteServiceImpl.retrievePersistentSiteByIdentifier("42"));
    verify(streamingTransactionCapableUtil).getTransactionManager();
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteByIdentifier(String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link
   *       SessionFactoryDelegatingImpl#SessionFactoryDelegatingImpl(SessionFactoryImplementor)}
   *       with delegate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveSiteByIdentifier(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveSiteByIdentifier(String, boolean)"})
  public void testRetrieveSiteByIdentifier_givenSessionFactoryDelegatingImplWithDelegateIsNull() {
    // Arrange
    when(streamingTransactionCapableUtil.getTransactionManager())
        .thenReturn(new JpaTransactionManager(new SessionFactoryDelegatingImpl(null)));

    // Act
    Site actualRetrieveSiteByIdentifierResult =
        siteServiceImpl.retrieveSiteByIdentifier("42", true);

    // Assert
    verify(streamingTransactionCapableUtil).getTransactionManager();
    assertNull(actualRetrieveSiteByIdentifierResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteByIdentifier(String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link SiteServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveSiteByIdentifier(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveSiteByIdentifier(String, boolean)"})
  public void testRetrieveSiteByIdentifier_givenSiteServiceImpl_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SiteServiceImpl().retrieveSiteByIdentifier(null, true));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteByIdentifier(String, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveSiteByIdentifier(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveSiteByIdentifier(String, boolean)"})
  public void testRetrieveSiteByIdentifier_thenThrowRuntimeException() {
    // Arrange
    when(streamingTransactionCapableUtil.getTransactionManager()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> siteServiceImpl.retrieveSiteByIdentifier("42", true));
    verify(streamingTransactionCapableUtil).getTransactionManager();
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteByDomainName(String, boolean)} with {@code domainName},
   * {@code persistentResult}.
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveSiteByDomainName(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveSiteByDomainName(String, boolean)"})
  public void testRetrieveSiteByDomainNameWithDomainNamePersistentResult() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> siteServiceImpl.retrieveSiteByDomainName("Domain Name", true));
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteByDomainName(String, boolean)} with {@code domainName},
   * {@code persistentResult}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveSiteByDomainName(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveSiteByDomainName(String, boolean)"})
  public void testRetrieveSiteByDomainNameWithDomainNamePersistentResult_thenReturnNull() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    Site actualRetrieveSiteByDomainNameResult =
        siteServiceImpl.retrieveSiteByDomainName("Domain Name", true);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertNull(actualRetrieveSiteByDomainNameResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteByDomainName(String)} with {@code domainName}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveSiteByDomainName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveSiteByDomainName(String)"})
  public void testRetrieveSiteByDomainNameWithDomainName_thenReturnNull() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    Site actualRetrieveSiteByDomainNameResult =
        siteServiceImpl.retrieveSiteByDomainName("Domain Name");

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertNull(actualRetrieveSiteByDomainNameResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrieveSiteByDomainName(String)} with {@code domainName}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveSiteByDomainName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveSiteByDomainName(String)"})
  public void testRetrieveSiteByDomainNameWithDomainName_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> siteServiceImpl.retrieveSiteByDomainName("Domain Name"));
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#stripSubdomain(String)}.
   *
   * <ul>
   *   <li>Given {@link SiteServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#stripSubdomain(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SiteServiceImpl.stripSubdomain(String)"})
  public void testStripSubdomain_givenSiteServiceImpl_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new SiteServiceImpl().stripSubdomain(null));
  }

  /**
   * Test {@link SiteServiceImpl#save(Catalog)} with {@code catalog}.
   *
   * <ul>
   *   <li>Given {@link SiteDao} {@link SiteDao#save(Catalog)} return {@link CatalogImpl} (default
   *       constructor).
   *   <li>Then return {@link CatalogImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#save(Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Catalog SiteServiceImpl.save(Catalog)"})
  public void testSaveWithCatalog_givenSiteDaoSaveReturnCatalogImpl_thenReturnCatalogImpl() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    when(siteDao.save(Mockito.<Catalog>any())).thenReturn(catalogImpl);

    // Act
    Catalog actualSaveResult = siteServiceImpl.save(new CatalogImpl());

    // Assert
    verify(siteDao).save(isA(Catalog.class));
    assertSame(catalogImpl, actualSaveResult);
  }

  /**
   * Test {@link SiteServiceImpl#save(Catalog)} with {@code catalog}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#save(Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Catalog SiteServiceImpl.save(Catalog)"})
  public void testSaveWithCatalog_thenThrowRuntimeException() {
    // Arrange
    when(siteDao.save(Mockito.<Catalog>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.save(new CatalogImpl()));
    verify(siteDao).save(isA(Catalog.class));
  }

  /**
   * Test {@link SiteServiceImpl#save(Site)} with {@code site}.
   *
   * <ul>
   *   <li>Given {@link SiteDao} {@link SiteDao#save(Site)} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#save(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.save(Site)"})
  public void testSaveWithSite_givenSiteDaoSaveReturnNull_thenReturnNull() {
    // Arrange
    when(siteDao.save(Mockito.<Site>any())).thenReturn(null);

    // Act
    Site actualSaveResult = siteServiceImpl.save(new SiteImpl());

    // Assert
    verify(siteDao).save(isA(Site.class));
    assertNull(actualSaveResult);
  }

  /**
   * Test {@link SiteServiceImpl#save(Site)} with {@code site}.
   *
   * <ul>
   *   <li>Given {@link SiteDao} {@link SiteDao#save(Site)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#save(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.save(Site)"})
  public void testSaveWithSite_givenSiteDaoSaveThrowRuntimeException_thenThrowRuntimeException() {
    // Arrange
    when(siteDao.save(Mockito.<Site>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.save(new SiteImpl()));
    verify(siteDao).save(isA(Site.class));
  }

  /**
   * Test {@link SiteServiceImpl#save(Site)} with {@code site}.
   *
   * <ul>
   *   <li>Given {@link SiteImpl} {@link SiteImpl#getId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link SiteImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#save(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.save(Site)"})
  public void testSaveWithSite_givenSiteImplGetIdThrowRuntimeException_thenCallsGetId() {
    // Arrange
    SiteImpl siteImpl = mock(SiteImpl.class);
    when(siteImpl.getId()).thenThrow(new RuntimeException());
    when(siteDao.save(Mockito.<Site>any())).thenReturn(siteImpl);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.save(new SiteImpl()));
    verify(siteDao).save(isA(Site.class));
    verify(siteImpl).getId();
  }

  /**
   * Test {@link SiteServiceImpl#saveAndReturnNonPersisted(Site)}.
   *
   * <ul>
   *   <li>Given {@link SiteDao} {@link SiteDao#save(Site)} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#saveAndReturnNonPersisted(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.saveAndReturnNonPersisted(Site)"})
  public void testSaveAndReturnNonPersisted_givenSiteDaoSaveReturnNull_thenReturnNull() {
    // Arrange
    when(siteDao.save(Mockito.<Site>any())).thenReturn(null);

    // Act
    Site actualSaveAndReturnNonPersistedResult =
        siteServiceImpl.saveAndReturnNonPersisted(new SiteImpl());

    // Assert
    verify(siteDao).save(isA(Site.class));
    assertNull(actualSaveAndReturnNonPersistedResult);
  }

  /**
   * Test {@link SiteServiceImpl#saveAndReturnNonPersisted(Site)}.
   *
   * <ul>
   *   <li>Given {@link SiteDao} {@link SiteDao#save(Site)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#saveAndReturnNonPersisted(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.saveAndReturnNonPersisted(Site)"})
  public void testSaveAndReturnNonPersisted_givenSiteDaoSaveThrowRuntimeException() {
    // Arrange
    when(siteDao.save(Mockito.<Site>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> siteServiceImpl.saveAndReturnNonPersisted(new SiteImpl()));
    verify(siteDao).save(isA(Site.class));
  }

  /**
   * Test {@link SiteServiceImpl#saveAndReturnNonPersisted(Site)}.
   *
   * <ul>
   *   <li>Then calls {@link SiteImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#saveAndReturnNonPersisted(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.saveAndReturnNonPersisted(Site)"})
  public void testSaveAndReturnNonPersisted_thenCallsGetId() {
    // Arrange
    SiteImpl siteImpl = mock(SiteImpl.class);
    when(siteImpl.getId()).thenThrow(new RuntimeException());
    when(siteDao.save(Mockito.<Site>any())).thenReturn(siteImpl);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> siteServiceImpl.saveAndReturnNonPersisted(new SiteImpl()));
    verify(siteDao).save(isA(Site.class));
    verify(siteImpl).getId();
  }

  /**
   * Test {@link SiteServiceImpl#saveAndReturnPersisted(Site)}.
   *
   * <ul>
   *   <li>Given {@link SiteDao} {@link SiteDao#save(Site)} return {@link SiteImpl} (default
   *       constructor).
   *   <li>Then return {@link SiteImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#saveAndReturnPersisted(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.saveAndReturnPersisted(Site)"})
  public void testSaveAndReturnPersisted_givenSiteDaoSaveReturnSiteImpl_thenReturnSiteImpl() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    when(siteDao.save(Mockito.<Site>any())).thenReturn(siteImpl);

    // Act
    Site actualSaveAndReturnPersistedResult =
        siteServiceImpl.saveAndReturnPersisted(new SiteImpl());

    // Assert
    verify(siteDao).save(isA(Site.class));
    assertSame(siteImpl, actualSaveAndReturnPersistedResult);
  }

  /**
   * Test {@link SiteServiceImpl#saveAndReturnPersisted(Site)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#saveAndReturnPersisted(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.saveAndReturnPersisted(Site)"})
  public void testSaveAndReturnPersisted_thenThrowRuntimeException() {
    // Arrange
    when(siteDao.save(Mockito.<Site>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> siteServiceImpl.saveAndReturnPersisted(new SiteImpl()));
    verify(siteDao).save(isA(Site.class));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveNonPersistentSiteByDomainName(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveNonPersistentSiteByDomainName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveNonPersistentSiteByDomainName(String)"})
  public void testRetrieveNonPersistentSiteByDomainName_thenReturnNull() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    Site actualRetrieveNonPersistentSiteByDomainNameResult =
        siteServiceImpl.retrieveNonPersistentSiteByDomainName("Domain Name");

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertNull(actualRetrieveNonPersistentSiteByDomainNameResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrieveNonPersistentSiteByDomainName(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveNonPersistentSiteByDomainName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveNonPersistentSiteByDomainName(String)"})
  public void testRetrieveNonPersistentSiteByDomainName_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> siteServiceImpl.retrieveNonPersistentSiteByDomainName("Domain Name"));
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#retrievePersistentSiteByDomainName(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrievePersistentSiteByDomainName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrievePersistentSiteByDomainName(String)"})
  public void testRetrievePersistentSiteByDomainName_thenReturnNull() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    Site actualRetrievePersistentSiteByDomainNameResult =
        siteServiceImpl.retrievePersistentSiteByDomainName("Domain Name");

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertNull(actualRetrievePersistentSiteByDomainNameResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrievePersistentSiteByDomainName(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrievePersistentSiteByDomainName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrievePersistentSiteByDomainName(String)"})
  public void testRetrievePersistentSiteByDomainName_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> siteServiceImpl.retrievePersistentSiteByDomainName("Domain Name"));
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#findCatalogById(Long)}.
   *
   * <ul>
   *   <li>Then return {@link CatalogImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findCatalogById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Catalog SiteServiceImpl.findCatalogById(Long)"})
  public void testFindCatalogById_thenReturnCatalogImpl() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    when(siteDao.retrieveCatalog(Mockito.<Long>any())).thenReturn(catalogImpl);

    // Act
    Catalog actualFindCatalogByIdResult = siteServiceImpl.findCatalogById(1L);

    // Assert
    verify(siteDao).retrieveCatalog(1L);
    assertSame(catalogImpl, actualFindCatalogByIdResult);
  }

  /**
   * Test {@link SiteServiceImpl#findCatalogById(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findCatalogById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Catalog SiteServiceImpl.findCatalogById(Long)"})
  public void testFindCatalogById_thenThrowRuntimeException() {
    // Arrange
    when(siteDao.retrieveCatalog(Mockito.<Long>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.findCatalogById(1L));
    verify(siteDao).retrieveCatalog(1L);
  }

  /**
   * Test {@link SiteServiceImpl#findCatalogByName(String)}.
   *
   * <ul>
   *   <li>Then return {@link CatalogImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findCatalogByName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Catalog SiteServiceImpl.findCatalogByName(String)"})
  public void testFindCatalogByName_thenReturnCatalogImpl() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    when(siteDao.retrieveCatalogByName(Mockito.<String>any())).thenReturn(catalogImpl);

    // Act
    Catalog actualFindCatalogByNameResult = siteServiceImpl.findCatalogByName("Name");

    // Assert
    verify(siteDao).retrieveCatalogByName("Name");
    assertSame(catalogImpl, actualFindCatalogByNameResult);
  }

  /**
   * Test {@link SiteServiceImpl#findCatalogByName(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findCatalogByName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Catalog SiteServiceImpl.findCatalogByName(String)"})
  public void testFindCatalogByName_thenThrowRuntimeException() {
    // Arrange
    when(siteDao.retrieveCatalogByName(Mockito.<String>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.findCatalogByName("Name"));
    verify(siteDao).retrieveCatalogByName("Name");
  }

  /**
   * Test {@link SiteServiceImpl#retrieveDefaultSite(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveDefaultSite(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveDefaultSite(boolean)"})
  public void testRetrieveDefaultSiteWithBoolean_thenReturnNull() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    Site actualRetrieveDefaultSiteResult = siteServiceImpl.retrieveDefaultSite(true);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertNull(actualRetrieveDefaultSiteResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrieveDefaultSite(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveDefaultSite(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveDefaultSite(boolean)"})
  public void testRetrieveDefaultSiteWithBoolean_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.retrieveDefaultSite(true));
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveDefaultSite()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveDefaultSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveDefaultSite()"})
  public void testRetrieveDefaultSite_thenReturnNull() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    Site actualRetrieveDefaultSiteResult = siteServiceImpl.retrieveDefaultSite();

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertNull(actualRetrieveDefaultSiteResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrieveDefaultSite()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveDefaultSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveDefaultSite()"})
  public void testRetrieveDefaultSite_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.retrieveDefaultSite());
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#retrieveNonPersistentDefaultSite()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveNonPersistentDefaultSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveNonPersistentDefaultSite()"})
  public void testRetrieveNonPersistentDefaultSite_thenReturnNull() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    Site actualRetrieveNonPersistentDefaultSiteResult =
        siteServiceImpl.retrieveNonPersistentDefaultSite();

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertNull(actualRetrieveNonPersistentDefaultSiteResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrieveNonPersistentDefaultSite()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrieveNonPersistentDefaultSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrieveNonPersistentDefaultSite()"})
  public void testRetrieveNonPersistentDefaultSite_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.retrieveNonPersistentDefaultSite());
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#retrievePersistentDefaultSite()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrievePersistentDefaultSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrievePersistentDefaultSite()"})
  public void testRetrievePersistentDefaultSite_thenReturnNull() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    Site actualRetrievePersistentDefaultSiteResult =
        siteServiceImpl.retrievePersistentDefaultSite();

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertNull(actualRetrievePersistentDefaultSiteResult);
  }

  /**
   * Test {@link SiteServiceImpl#retrievePersistentDefaultSite()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#retrievePersistentDefaultSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.retrievePersistentDefaultSite()"})
  public void testRetrievePersistentDefaultSite_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.retrievePersistentDefaultSite());
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#findAllActiveSites()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findAllActiveSites()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SiteServiceImpl.findAllActiveSites()"})
  public void testFindAllActiveSites_thenReturnEmpty() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    List<Site> actualFindAllActiveSitesResult = siteServiceImpl.findAllActiveSites();

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertTrue(actualFindAllActiveSitesResult.isEmpty());
  }

  /**
   * Test {@link SiteServiceImpl#findAllActiveSites()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findAllActiveSites()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SiteServiceImpl.findAllActiveSites()"})
  public void testFindAllActiveSites_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.findAllActiveSites());
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#findAllNonPersistentActiveSites()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findAllNonPersistentActiveSites()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SiteServiceImpl.findAllNonPersistentActiveSites()"})
  public void testFindAllNonPersistentActiveSites_thenReturnEmpty() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    List<Site> actualFindAllNonPersistentActiveSitesResult =
        siteServiceImpl.findAllNonPersistentActiveSites();

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertTrue(actualFindAllNonPersistentActiveSitesResult.isEmpty());
  }

  /**
   * Test {@link SiteServiceImpl#findAllNonPersistentActiveSites()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findAllNonPersistentActiveSites()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SiteServiceImpl.findAllNonPersistentActiveSites()"})
  public void testFindAllNonPersistentActiveSites_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.findAllNonPersistentActiveSites());
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#findAllPersistentActiveSites()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findAllPersistentActiveSites()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SiteServiceImpl.findAllPersistentActiveSites()"})
  public void testFindAllPersistentActiveSites_thenReturnEmpty() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    List<Site> actualFindAllPersistentActiveSitesResult =
        siteServiceImpl.findAllPersistentActiveSites();

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertTrue(actualFindAllPersistentActiveSitesResult.isEmpty());
  }

  /**
   * Test {@link SiteServiceImpl#findAllPersistentActiveSites()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findAllPersistentActiveSites()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SiteServiceImpl.findAllPersistentActiveSites()"})
  public void testFindAllPersistentActiveSites_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.findAllPersistentActiveSites());
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#findAllSites(boolean)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findAllSites(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SiteServiceImpl.findAllSites(boolean)"})
  public void testFindAllSites_thenReturnEmpty() {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act
    List<Site> actualFindAllSitesResult = siteServiceImpl.findAllSites(true);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
    assertTrue(actualFindAllSitesResult.isEmpty());
  }

  /**
   * Test {@link SiteServiceImpl#findAllSites(boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findAllSites(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SiteServiceImpl.findAllSites(boolean)"})
  public void testFindAllSites_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.findAllSites(true));
    verify(streamingTransactionCapableUtil)
        .runOptionalEntityManagerInViewOperation(isA(Runnable.class));
  }

  /**
   * Test {@link SiteServiceImpl#getNonPersistentSite(Site)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#getNonPersistentSite(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteServiceImpl.getNonPersistentSite(Site)"})
  public void testGetNonPersistentSite_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SiteServiceImpl().getNonPersistentSite(null));
  }

  /**
   * Test {@link SiteServiceImpl#createCatalog()}.
   *
   * <ul>
   *   <li>Then return {@link CatalogImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#createCatalog()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Catalog SiteServiceImpl.createCatalog()"})
  public void testCreateCatalog_thenReturnCatalogImpl() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    when(siteDao.createCatalog()).thenReturn(catalogImpl);

    // Act
    Catalog actualCreateCatalogResult = siteServiceImpl.createCatalog();

    // Assert
    verify(siteDao).createCatalog();
    assertSame(catalogImpl, actualCreateCatalogResult);
  }

  /**
   * Test {@link SiteServiceImpl#createCatalog()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#createCatalog()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Catalog SiteServiceImpl.createCatalog()"})
  public void testCreateCatalog_thenThrowRuntimeException() {
    // Arrange
    when(siteDao.createCatalog()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.createCatalog());
    verify(siteDao).createCatalog();
  }

  /**
   * Test {@link SiteServiceImpl#createSiteCatalog()}.
   *
   * <ul>
   *   <li>Then return {@link SiteCatalogXrefImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#createSiteCatalog()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteCatalogXref SiteServiceImpl.createSiteCatalog()"})
  public void testCreateSiteCatalog_thenReturnSiteCatalogXrefImpl() {
    // Arrange
    SiteCatalogXrefImpl siteCatalogXrefImpl = new SiteCatalogXrefImpl();
    when(siteDao.createSiteCatalog()).thenReturn(siteCatalogXrefImpl);

    // Act
    SiteCatalogXref actualCreateSiteCatalogResult = siteServiceImpl.createSiteCatalog();

    // Assert
    verify(siteDao).createSiteCatalog();
    assertSame(siteCatalogXrefImpl, actualCreateSiteCatalogResult);
  }

  /**
   * Test {@link SiteServiceImpl#createSiteCatalog()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#createSiteCatalog()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteCatalogXref SiteServiceImpl.createSiteCatalog()"})
  public void testCreateSiteCatalog_thenThrowRuntimeException() {
    // Arrange
    when(siteDao.createSiteCatalog()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.createSiteCatalog());
    verify(siteDao).createSiteCatalog();
  }

  /**
   * Test {@link SiteServiceImpl#findAllCatalogs()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findAllCatalogs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SiteServiceImpl.findAllCatalogs()"})
  public void testFindAllCatalogs_thenReturnEmpty() {
    // Arrange
    when(siteDao.retrieveAllCatalogs()).thenReturn(new ArrayList<>());

    // Act
    List<Catalog> actualFindAllCatalogsResult = siteServiceImpl.findAllCatalogs();

    // Assert
    verify(siteDao).retrieveAllCatalogs();
    assertTrue(actualFindAllCatalogsResult.isEmpty());
  }

  /**
   * Test {@link SiteServiceImpl#findAllCatalogs()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SiteServiceImpl#findAllCatalogs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SiteServiceImpl.findAllCatalogs()"})
  public void testFindAllCatalogs_thenThrowRuntimeException() {
    // Arrange
    when(siteDao.retrieveAllCatalogs()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> siteServiceImpl.findAllCatalogs());
    verify(siteDao).retrieveAllCatalogs();
  }
}
