package org.broadleafcommerce.common.site.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteCatalogXref;
import org.broadleafcommerce.common.site.domain.SiteCatalogXrefImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.site.service.type.SiteResolutionType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SiteDaoImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @InjectMocks private SiteDaoImpl siteDaoImpl;

  /**
   * Test {@link SiteDaoImpl#create()}.
   *
   * <p>Method under test: {@link SiteDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteDaoImpl.create()"})
  public void testCreate() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    siteImpl.setCatalogs(new ArrayList<>());
    siteImpl.setDeactivated(true);
    siteImpl.setDefaultLocale(new LocaleImpl());
    siteImpl.setId(1L);
    siteImpl.setName("Name");
    siteImpl.setSiteIdentifierType("Site Identifier Type");
    siteImpl.setSiteIdentifierValue("42");
    siteImpl.setSiteResolutionType(SiteResolutionType.DOMAIN);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(siteImpl);

    // Act
    Site actualCreateResult = siteDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.common.site.domain.Site");
    assertSame(siteImpl, actualCreateResult);
  }

  /**
   * Test {@link SiteDaoImpl#createCatalog()}.
   *
   * <p>Method under test: {@link SiteDaoImpl#createCatalog()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Catalog SiteDaoImpl.createCatalog()"})
  public void testCreateCatalog() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setId(1L);
    catalogImpl.setName("Name");
    catalogImpl.setSiteXrefs(new ArrayList<>());
    catalogImpl.setSites(new ArrayList<>());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(catalogImpl);

    // Act
    Catalog actualCreateCatalogResult = siteDaoImpl.createCatalog();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.common.site.domain.Catalog");
    assertSame(catalogImpl, actualCreateCatalogResult);
  }

  /**
   * Test {@link SiteDaoImpl#createSiteCatalog()}.
   *
   * <p>Method under test: {@link SiteDaoImpl#createSiteCatalog()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteCatalogXref SiteDaoImpl.createSiteCatalog()"})
  public void testCreateSiteCatalog() {
    // Arrange
    SiteCatalogXrefImpl siteCatalogXrefImpl = new SiteCatalogXrefImpl();
    siteCatalogXrefImpl.setCatalog(new CatalogImpl());
    siteCatalogXrefImpl.setId(1L);
    siteCatalogXrefImpl.setSite(new SiteImpl());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(siteCatalogXrefImpl);

    // Act
    SiteCatalogXref actualCreateSiteCatalogResult = siteDaoImpl.createSiteCatalog();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.common.site.domain.SiteCatalogXref");
    assertSame(siteCatalogXrefImpl, actualCreateSiteCatalogResult);
  }

  /**
   * Test {@link SiteDaoImpl#retrieveSiteByDomainOrDomainPrefix(String, String)}.
   *
   * <ul>
   *   <li>Given {@link SiteDaoImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SiteDaoImpl#retrieveSiteByDomainOrDomainPrefix(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteDaoImpl.retrieveSiteByDomainOrDomainPrefix(String, String)"})
  public void testRetrieveSiteByDomainOrDomainPrefix_givenSiteDaoImpl_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SiteDaoImpl().retrieveSiteByDomainOrDomainPrefix(null, "Domain Prefix"));
  }

  /**
   * Test {@link SiteDaoImpl#retrieveDefaultSite()}.
   *
   * <p>Method under test: {@link SiteDaoImpl#retrieveDefaultSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site SiteDaoImpl.retrieveDefaultSite()"})
  public void testRetrieveDefaultSite() {
    // Arrange, Act and Assert
    assertNull(new SiteDaoImpl().retrieveDefaultSite());
  }
}
