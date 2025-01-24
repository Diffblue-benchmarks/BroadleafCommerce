package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.MultiTenantCloneable;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferDuplicateModifierDiffblueTest {
  @Autowired
  private OfferDuplicateModifier offerDuplicateModifier;

  /**
   * Test {@link OfferDuplicateModifier#canHandle(MultiTenantCloneable)}.
   * <p>
   * Method under test:
   * {@link OfferDuplicateModifier#canHandle(MultiTenantCloneable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandle() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6394 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferDuplicateModifier offerDuplicateModifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferDuplicateModifier(new StandardReactiveWebEnvironment())).canHandle(mock(MultiTenantCloneable.class));
  }

  /**
   * Test {@link OfferDuplicateModifier#canHandle(MultiTenantCloneable)}.
   * <ul>
   *   <li>When {@link MultiTenantCloneable}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferDuplicateModifier#canHandle(MultiTenantCloneable)}
   */
  @Test
  public void testCanHandle_whenMultiTenantCloneable_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(
        (new OfferDuplicateModifier(new StandardReactiveWebEnvironment())).canHandle(mock(MultiTenantCloneable.class)));
  }

  /**
   * Test
   * {@link OfferDuplicateModifier#modifyInitialDuplicateState(Offer, Offer, MultiTenantCopyContext)}
   * with {@code Offer}, {@code Offer}, {@code MultiTenantCopyContext}.
   * <p>
   * Method under test:
   * {@link OfferDuplicateModifier#modifyInitialDuplicateState(Offer, Offer, MultiTenantCopyContext)}
   */
  @Test
  public void testModifyInitialDuplicateStateWithOfferOfferMultiTenantCopyContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Environment environment = mock(Environment.class);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<String>>any(), Mockito.<String>any()))
        .thenReturn("Property");
    OfferDuplicateModifier offerDuplicateModifier = new OfferDuplicateModifier(environment);
    OfferImpl original = new OfferImpl();
    OfferImpl copy = new OfferImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    offerDuplicateModifier.modifyInitialDuplicateState(original, copy, new MultiTenantCopyContext(fromCatalog,
        toCatalog, fromSite, toSite, genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(environment).getProperty(eq("admin.entity.duplication.suffix.default"), isA(Class.class), eq(" - Copy"));
  }

  /**
   * Test
   * {@link OfferDuplicateModifier#modifyInitialDuplicateState(Offer, Offer, MultiTenantCopyContext)}
   * with {@code Offer}, {@code Offer}, {@code MultiTenantCopyContext}.
   * <p>
   * Method under test:
   * {@link OfferDuplicateModifier#modifyInitialDuplicateState(Offer, Offer, MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyInitialDuplicateStateWithOfferOfferMultiTenantCopyContext2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6451 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferDuplicateModifier offerDuplicateModifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferDuplicateModifier offerDuplicateModifier2 = new OfferDuplicateModifier(new StandardReactiveWebEnvironment());
    OfferImpl original = new OfferImpl();
    OfferImpl copy = new OfferImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    offerDuplicateModifier2.modifyInitialDuplicateState(original, copy, new MultiTenantCopyContext(fromCatalog,
        toCatalog, fromSite, toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
  }
}
