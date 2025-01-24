package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml",
    "/applicationContext-servlet-cms-contentClient.xml", "/applicationContext-servlet-cms-contentCreator.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PageRuleImplDiffblueTest {
  @Autowired
  private PageRuleImpl pageRuleImpl;

  /**
   * Test {@link PageRuleImpl#equals(Object)}, and
   * {@link PageRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageRuleImpl#equals(Object)}
   *   <li>{@link PageRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl.setMatchRule("Match Rule");

    PageRuleImpl pageRuleImpl2 = new PageRuleImpl();
    pageRuleImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(pageRuleImpl, pageRuleImpl2);
    int expectedHashCodeResult = pageRuleImpl.hashCode();
    assertEquals(expectedHashCodeResult, pageRuleImpl2.hashCode());
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}, and
   * {@link PageRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageRuleImpl#equals(Object)}
   *   <li>{@link PageRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(null);
    pageRuleImpl.setMatchRule("Match Rule");

    PageRuleImpl pageRuleImpl2 = new PageRuleImpl();
    pageRuleImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(pageRuleImpl, pageRuleImpl2);
    int notExpectedHashCodeResult = pageRuleImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, pageRuleImpl2.hashCode());
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}, and
   * {@link PageRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageRuleImpl#equals(Object)}
   *   <li>{@link PageRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl.setMatchRule("Match Rule");

    PageRuleImpl pageRuleImpl2 = new PageRuleImpl();
    pageRuleImpl2.setId(null);
    pageRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(pageRuleImpl, pageRuleImpl2);
    int notExpectedHashCodeResult = pageRuleImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, pageRuleImpl2.hashCode());
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}, and
   * {@link PageRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageRuleImpl#equals(Object)}
   *   <li>{@link PageRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(null);
    pageRuleImpl.setMatchRule(null);

    PageRuleImpl pageRuleImpl2 = new PageRuleImpl();
    pageRuleImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl2.setMatchRule(null);

    // Act and Assert
    assertEquals(pageRuleImpl, pageRuleImpl2);
    int notExpectedHashCodeResult = pageRuleImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, pageRuleImpl2.hashCode());
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}, and
   * {@link PageRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageRuleImpl#equals(Object)}
   *   <li>{@link PageRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(pageRuleImpl, pageRuleImpl);
    int expectedHashCodeResult = pageRuleImpl.hashCode();
    assertEquals(expectedHashCodeResult, pageRuleImpl.hashCode());
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(2L);
    pageRuleImpl.setMatchRule("Match Rule");

    PageRuleImpl pageRuleImpl2 = new PageRuleImpl();
    pageRuleImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(pageRuleImpl, pageRuleImpl2);
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(null);
    pageRuleImpl.setMatchRule(null);

    PageRuleImpl pageRuleImpl2 = new PageRuleImpl();
    pageRuleImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(pageRuleImpl, pageRuleImpl2);
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(null);
    pageRuleImpl.setMatchRule("42");

    PageRuleImpl pageRuleImpl2 = new PageRuleImpl();
    pageRuleImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(pageRuleImpl, pageRuleImpl2);
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(pageRuleImpl, null);
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(pageRuleImpl, "Different type to PageRuleImpl");
  }

  /**
   * Test {@link PageRuleImpl#cloneEntity()}.
   * <p>
   * Method under test: {@link PageRuleImpl#cloneEntity()}
   */
  @Test
  public void testCloneEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();

    // Act
    PageRule actualCloneEntityResult = pageRuleImpl.cloneEntity();

    // Assert
    assertTrue(actualCloneEntityResult instanceof PageRuleImpl);
    assertEquals(pageRuleImpl, actualCloneEntityResult);
  }

  /**
   * Test {@link PageRuleImpl#cloneEntity()}.
   * <p>
   * Method under test: {@link PageRuleImpl#cloneEntity()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCloneEntity2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass194 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.domain.PageRuleImpl pageRuleImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageRuleImpl()).cloneEntity();
  }

  /**
   * Test
   * {@link PageRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link PageRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PageRule> actualCreateOrRetrieveCopyInstanceResult = pageRuleImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link PageRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link PageRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass198 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.domain.PageRuleImpl pageRuleImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageRuleImpl pageRuleImpl2 = new PageRuleImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    pageRuleImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test
   * {@link PageRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then Clone return {@link PageRuleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenJavaLangObject_thenCloneReturnPageRuleImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<PageRule> actualCreateOrRetrieveCopyInstanceResult = pageRuleImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.cms.page.domain.PageRuleImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    PageRule clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof PageRuleImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(pageRuleImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PageRuleImpl}
   *   <li>{@link PageRuleImpl#setId(Long)}
   *   <li>{@link PageRuleImpl#setMatchRule(String)}
   *   <li>{@link PageRuleImpl#getId()}
   *   <li>{@link PageRuleImpl#getMatchRule()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PageRuleImpl actualPageRuleImpl = new PageRuleImpl();
    actualPageRuleImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    actualPageRuleImpl.setMatchRule("Match Rule");
    Long actualId = actualPageRuleImpl.getId();

    // Assert that nothing has changed
    assertEquals("Match Rule", actualPageRuleImpl.getMatchRule());
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
  }
}
