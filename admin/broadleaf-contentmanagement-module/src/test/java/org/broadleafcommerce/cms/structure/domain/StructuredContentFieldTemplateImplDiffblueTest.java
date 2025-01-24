package org.broadleafcommerce.cms.structure.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
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
public class StructuredContentFieldTemplateImplDiffblueTest {
  @Autowired
  private StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl;

  /**
   * Test {@link StructuredContentFieldTemplateImpl#getFieldGroups()}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#getFieldGroups()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldGroups() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3841 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.domain.StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentFieldTemplateImpl()).getFieldGroups();
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#getFieldGroups()}.
   * <ul>
   *   <li>Given {@link StructuredContentFieldTemplateImpl} (default constructor) Id
   * is {@link StructuredContentItemCriteriaImpl#serialVersionUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#getFieldGroups()}
   */
  @Test
  public void testGetFieldGroups_givenStructuredContentFieldTemplateImplIdIsSerialVersionUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();
    structuredContentFieldTemplateImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentFieldTemplateImpl.setName("Name");
    structuredContentFieldTemplateImpl.setFieldGroupXrefs(null);

    // Act and Assert
    assertTrue(structuredContentFieldTemplateImpl.getFieldGroups().isEmpty());
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#getFieldGroups()}.
   * <ul>
   *   <li>Given {@link StructuredContentFieldTemplateImpl} (default
   * constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#getFieldGroups()}
   */
  @Test
  public void testGetFieldGroups_givenStructuredContentFieldTemplateImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new StructuredContentFieldTemplateImpl()).getFieldGroups().isEmpty());
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#getFieldGroups()}.
   * <ul>
   *   <li>Then return first is {@link FieldGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#getFieldGroups()}
   */
  @Test
  public void testGetFieldGroups_thenReturnFirstIsFieldGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldGroupXrefImpl structuredContentFieldGroupXrefImpl = mock(
        StructuredContentFieldGroupXrefImpl.class);
    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    when(structuredContentFieldGroupXrefImpl.getFieldGroup()).thenReturn(fieldGroupImpl);

    ArrayList<StructuredContentFieldGroupXref> fieldGroupXrefs = new ArrayList<>();
    fieldGroupXrefs.add(structuredContentFieldGroupXrefImpl);

    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();
    structuredContentFieldTemplateImpl.setFieldGroupXrefs(fieldGroupXrefs);

    // Act
    List<FieldGroup> actualFieldGroups = structuredContentFieldTemplateImpl.getFieldGroups();

    // Assert
    verify(structuredContentFieldGroupXrefImpl).getFieldGroup();
    assertEquals(1, actualFieldGroups.size());
    assertSame(fieldGroupImpl, actualFieldGroups.get(0));
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#getFieldGroups()}.
   * <ul>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#getFieldGroups()}
   */
  @Test
  public void testGetFieldGroups_thenReturnFirstIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<StructuredContentFieldGroupXref> fieldGroupXrefs = new ArrayList<>();
    fieldGroupXrefs.add(new StructuredContentFieldGroupXrefImpl());

    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();
    structuredContentFieldTemplateImpl.setFieldGroupXrefs(fieldGroupXrefs);

    // Act
    List<FieldGroup> actualFieldGroups = structuredContentFieldTemplateImpl.getFieldGroups();

    // Assert
    assertEquals(1, actualFieldGroups.size());
    assertNull(actualFieldGroups.get(0));
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetFieldGroups() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3846 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.domain.StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl2 = new StructuredContentFieldTemplateImpl();

    // Act
    structuredContentFieldTemplateImpl2.setFieldGroups(new ArrayList<>());
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}.
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FieldGroupImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}
   */
  @Test
  public void testSetFieldGroups_givenFieldGroupImpl_whenArrayListAddFieldGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> structuredContentFieldTemplateImpl.setFieldGroups(fieldGroups));
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}.
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FieldGroupImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}
   */
  @Test
  public void testSetFieldGroups_givenFieldGroupImpl_whenArrayListAddFieldGroupImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());
    fieldGroups.add(new FieldGroupImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> structuredContentFieldTemplateImpl.setFieldGroups(fieldGroups));
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}
   */
  @Test
  public void testSetFieldGroups_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> structuredContentFieldTemplateImpl.setFieldGroups(new ArrayList<>()));
  }

  /**
   * Test
   * {@link StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<StructuredContentFieldTemplate> actualCreateOrRetrieveCopyInstanceResult = structuredContentFieldTemplateImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.cms.structure.domain.StructuredContentFieldTemplateImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    StructuredContentFieldTemplate clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof StructuredContentFieldTemplateImpl);
    assertNull(clone.getId());
    assertNull(clone.getName());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertTrue(clone.getFieldGroupXrefs().isEmpty());
    assertTrue(clone.getFieldGroups().isEmpty());
  }

  /**
   * Test
   * {@link StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentFieldTemplate> actualCreateOrRetrieveCopyInstanceResult = structuredContentFieldTemplateImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3778 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.domain.StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl2 = new StructuredContentFieldTemplateImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    structuredContentFieldTemplateImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog,
        fromSite, toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link StructuredContentFieldTemplateImpl}
   *   <li>{@link StructuredContentFieldTemplateImpl#setFieldGroupXrefs(List)}
   *   <li>{@link StructuredContentFieldTemplateImpl#setId(Long)}
   *   <li>{@link StructuredContentFieldTemplateImpl#setName(String)}
   *   <li>{@link StructuredContentFieldTemplateImpl#getFieldGroupXrefs()}
   *   <li>{@link StructuredContentFieldTemplateImpl#getId()}
   *   <li>{@link StructuredContentFieldTemplateImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentFieldTemplateImpl actualStructuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();
    ArrayList<StructuredContentFieldGroupXref> fieldGroupXrefs = new ArrayList<>();
    actualStructuredContentFieldTemplateImpl.setFieldGroupXrefs(fieldGroupXrefs);
    actualStructuredContentFieldTemplateImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentFieldTemplateImpl.setName("Name");
    List<StructuredContentFieldGroupXref> actualFieldGroupXrefs = actualStructuredContentFieldTemplateImpl
        .getFieldGroupXrefs();
    Long actualId = actualStructuredContentFieldTemplateImpl.getId();

    // Assert that nothing has changed
    assertEquals("Name", actualStructuredContentFieldTemplateImpl.getName());
    assertTrue(actualFieldGroupXrefs.isEmpty());
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(fieldGroupXrefs, actualFieldGroupXrefs);
  }
}
