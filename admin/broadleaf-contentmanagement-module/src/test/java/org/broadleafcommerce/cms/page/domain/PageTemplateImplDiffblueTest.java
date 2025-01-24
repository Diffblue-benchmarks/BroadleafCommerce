package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
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
public class PageTemplateImplDiffblueTest {
  @Autowired
  private PageTemplateImpl pageTemplateImpl;

  /**
   * Test {@link PageTemplateImpl#getFieldGroups()}.
   * <p>
   * Method under test: {@link PageTemplateImpl#getFieldGroups()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldGroups() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass326 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.domain.PageTemplateImpl pageTemplateImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageTemplateImpl()).getFieldGroups();
  }

  /**
   * Test {@link PageTemplateImpl#getFieldGroups()}.
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor) Locale is
   * {@link Locale}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#getFieldGroups()}
   */
  @Test
  public void testGetFieldGroups_givenPageTemplateImplLocaleIsLocale_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(new PageTemplateFieldGroupXrefImpl());

    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    pageTemplateImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageTemplateImpl.setLocale(mock(Locale.class));
    pageTemplateImpl.setTemplateDescription("Template Description");
    pageTemplateImpl.setTemplateName("Template Name");
    pageTemplateImpl.setTemplatePath("Template Path");
    pageTemplateImpl.setFieldGroupXrefs(fieldGroups);

    // Act
    List<FieldGroup> actualFieldGroups = pageTemplateImpl.getFieldGroups();

    // Assert
    assertEquals(1, actualFieldGroups.size());
    assertNull(actualFieldGroups.get(0));
  }

  /**
   * Test {@link PageTemplateImpl#getFieldGroups()}.
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#getFieldGroups()}
   */
  @Test
  public void testGetFieldGroups_givenPageTemplateImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PageTemplateImpl()).getFieldGroups().isEmpty());
  }

  /**
   * Test {@link PageTemplateImpl#getFieldGroups()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#getFieldGroups()}
   */
  @Test
  public void testGetFieldGroups_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(new PageTemplateFieldGroupXrefImpl());

    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    pageTemplateImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageTemplateImpl.setLocale(new LocaleImpl());
    pageTemplateImpl.setTemplateDescription("Template Description");
    pageTemplateImpl.setTemplateName("Template Name");
    pageTemplateImpl.setTemplatePath("Template Path");
    pageTemplateImpl.setFieldGroupXrefs(fieldGroups);

    // Act
    List<FieldGroup> actualFieldGroups = pageTemplateImpl.getFieldGroups();

    // Assert
    assertEquals(1, actualFieldGroups.size());
    assertNull(actualFieldGroups.get(0));
  }

  /**
   * Test {@link PageTemplateImpl#setFieldGroups(List)}.
   * <p>
   * Method under test: {@link PageTemplateImpl#setFieldGroups(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetFieldGroups() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass342 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.domain.PageTemplateImpl pageTemplateImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateImpl pageTemplateImpl2 = new PageTemplateImpl();

    // Act
    pageTemplateImpl2.setFieldGroups(new ArrayList<>());
  }

  /**
   * Test {@link PageTemplateImpl#setFieldGroups(List)}.
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor) Locale is
   * {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#setFieldGroups(List)}
   */
  @Test
  public void testSetFieldGroups_givenPageTemplateImplLocaleIsLocaleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    pageTemplateImpl.setFieldGroupXrefs(fieldGroups);
    pageTemplateImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageTemplateImpl.setLocale(new LocaleImpl());
    pageTemplateImpl.setTemplateDescription("Template Description");
    pageTemplateImpl.setTemplateName("Template Name");
    pageTemplateImpl.setTemplatePath("Template Path");

    ArrayList<FieldGroup> fieldGroups2 = new ArrayList<>();
    fieldGroups2.add(new FieldGroupImpl());

    // Act
    pageTemplateImpl.setFieldGroups(fieldGroups2);

    // Assert
    assertEquals(1, fieldGroups2.size());
    List<PageTemplateFieldGroupXref> fieldGroupXrefs = pageTemplateImpl.getFieldGroupXrefs();
    assertEquals(1, fieldGroupXrefs.size());
    assertEquals(1, pageTemplateImpl.getFieldGroups().size());
    assertEquals(1, pageTemplateImpl.legacyFieldGroups.size());
    assertSame(fieldGroups, fieldGroupXrefs);
  }

  /**
   * Test {@link PageTemplateImpl#setFieldGroups(List)}.
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor) Locale is
   * {@link Locale}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#setFieldGroups(List)}
   */
  @Test
  public void testSetFieldGroups_givenPageTemplateImplLocaleIsLocale_thenArrayListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    pageTemplateImpl.setFieldGroupXrefs(fieldGroups);
    pageTemplateImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageTemplateImpl.setLocale(mock(Locale.class));
    pageTemplateImpl.setTemplateDescription("Template Description");
    pageTemplateImpl.setTemplateName("Template Name");
    pageTemplateImpl.setTemplatePath("Template Path");

    ArrayList<FieldGroup> fieldGroups2 = new ArrayList<>();
    fieldGroups2.add(new FieldGroupImpl());

    // Act
    pageTemplateImpl.setFieldGroups(fieldGroups2);

    // Assert
    assertEquals(1, fieldGroups2.size());
    List<PageTemplateFieldGroupXref> fieldGroupXrefs = pageTemplateImpl.getFieldGroupXrefs();
    assertEquals(1, fieldGroupXrefs.size());
    assertEquals(1, pageTemplateImpl.getFieldGroups().size());
    assertEquals(1, pageTemplateImpl.legacyFieldGroups.size());
    assertSame(fieldGroups, fieldGroupXrefs);
  }

  /**
   * Test {@link PageTemplateImpl#setFieldGroups(List)}.
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#setFieldGroups(List)}
   */
  @Test
  public void testSetFieldGroups_givenPageTemplateImpl_whenArrayList_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();

    // Act
    pageTemplateImpl.setFieldGroups(fieldGroups);

    // Assert
    assertTrue(fieldGroups.isEmpty());
    assertTrue(pageTemplateImpl.getFieldGroupXrefs().isEmpty());
    assertTrue(pageTemplateImpl.getFieldGroups().isEmpty());
    assertTrue(pageTemplateImpl.legacyFieldGroups.isEmpty());
  }

  /**
   * Test {@link PageTemplateImpl#setFieldGroups(List)}.
   * <ul>
   *   <li>Then {@link PageTemplateImpl} (default constructor) FieldGroupXrefs size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#setFieldGroups(List)}
   */
  @Test
  public void testSetFieldGroups_thenPageTemplateImplFieldGroupXrefsSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());
    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateImpl.setFieldGroups(fieldGroups);

    // Assert
    List<PageTemplateFieldGroupXref> fieldGroupXrefs = pageTemplateImpl.getFieldGroupXrefs();
    assertEquals(2, fieldGroupXrefs.size());
    PageTemplateFieldGroupXref getResult = fieldGroupXrefs.get(1);
    assertTrue(getResult instanceof PageTemplateFieldGroupXrefImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getGroupOrder());
    assertEquals(2, fieldGroups.size());
    List<FieldGroup> fieldGroups2 = pageTemplateImpl.getFieldGroups();
    assertEquals(2, fieldGroups2.size());
    List<FieldGroup> fieldGroupList = pageTemplateImpl.legacyFieldGroups;
    assertEquals(2, fieldGroupList.size());
    assertSame(fieldGroupImpl, fieldGroups2.get(1));
    assertSame(fieldGroupImpl, fieldGroupList.get(1));
    assertSame(fieldGroupImpl, getResult.getFieldGroup());
    assertSame(pageTemplateImpl, getResult.getPageTemplate());
  }

  /**
   * Test {@link PageTemplateImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link PageTemplateImpl#getMainEntityName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMainEntityName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass334 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.domain.PageTemplateImpl pageTemplateImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageTemplateImpl()).getMainEntityName();
  }

  /**
   * Test {@link PageTemplateImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenPageTemplateImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageTemplateImpl()).getMainEntityName());
  }

  /**
   * Test {@link PageTemplateImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor) Locale is
   * {@link LocaleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenPageTemplateImplLocaleIsLocaleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    pageTemplateImpl.setLocale(mock(LocaleImpl.class));

    // Act and Assert
    assertNull(pageTemplateImpl.getMainEntityName());
  }

  /**
   * Test
   * {@link PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PageTemplate> actualCreateOrRetrieveCopyInstanceResult = pageTemplateImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
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
    //   public class DiffblueFakeClass260 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.domain.PageTemplateImpl pageTemplateImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateImpl pageTemplateImpl2 = new PageTemplateImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    pageTemplateImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test
   * {@link PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link PageTemplateImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnPageTemplateImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<PageTemplate> actualCreateOrRetrieveCopyInstanceResult = pageTemplateImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.cms.page.domain.PageTemplateImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    PageTemplate clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof PageTemplateImpl);
    assertNull(clone.getId());
    assertNull(clone.getTemplateDescription());
    assertNull(clone.getTemplateName());
    assertNull(clone.getTemplatePath());
    assertNull(((PageTemplateImpl) clone).getMainEntityName());
    assertNull(clone.getLocale());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertTrue(clone.getFieldGroupXrefs().isEmpty());
    assertTrue(clone.getFieldGroups().isEmpty());
    assertTrue(((PageTemplateImpl) clone).legacyFieldGroups.isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PageTemplateImpl}
   *   <li>{@link PageTemplateImpl#setFieldGroupXrefs(List)}
   *   <li>{@link PageTemplateImpl#setId(Long)}
   *   <li>{@link PageTemplateImpl#setLocale(Locale)}
   *   <li>{@link PageTemplateImpl#setTemplateDescription(String)}
   *   <li>{@link PageTemplateImpl#setTemplateName(String)}
   *   <li>{@link PageTemplateImpl#setTemplatePath(String)}
   *   <li>{@link PageTemplateImpl#getFieldGroupXrefs()}
   *   <li>{@link PageTemplateImpl#getId()}
   *   <li>{@link PageTemplateImpl#getLocale()}
   *   <li>{@link PageTemplateImpl#getTemplateDescription()}
   *   <li>{@link PageTemplateImpl#getTemplateName()}
   *   <li>{@link PageTemplateImpl#getTemplatePath()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PageTemplateImpl actualPageTemplateImpl = new PageTemplateImpl();
    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    actualPageTemplateImpl.setFieldGroupXrefs(fieldGroups);
    actualPageTemplateImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    LocaleImpl locale = new LocaleImpl();
    actualPageTemplateImpl.setLocale(locale);
    actualPageTemplateImpl.setTemplateDescription("Template Description");
    actualPageTemplateImpl.setTemplateName("Template Name");
    actualPageTemplateImpl.setTemplatePath("Template Path");
    List<PageTemplateFieldGroupXref> actualFieldGroupXrefs = actualPageTemplateImpl.getFieldGroupXrefs();
    Long actualId = actualPageTemplateImpl.getId();
    Locale actualLocale = actualPageTemplateImpl.getLocale();
    String actualTemplateDescription = actualPageTemplateImpl.getTemplateDescription();
    String actualTemplateName = actualPageTemplateImpl.getTemplateName();

    // Assert that nothing has changed
    assertEquals("Template Description", actualTemplateDescription);
    assertEquals("Template Name", actualTemplateName);
    assertEquals("Template Path", actualPageTemplateImpl.getTemplatePath());
    assertTrue(actualFieldGroupXrefs.isEmpty());
    assertTrue(actualPageTemplateImpl.legacyFieldGroups.isEmpty());
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(fieldGroups, actualFieldGroupXrefs);
    assertSame(locale, actualLocale);
  }
}
