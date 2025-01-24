package org.broadleafcommerce.cms.structure.domain;

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
public class StructuredContentFieldImplDiffblueTest {
  @Autowired
  private StructuredContentFieldImpl structuredContentFieldImpl;

  /**
   * Test {@link StructuredContentFieldImpl#getValue()}.
   * <p>
   * Method under test: {@link StructuredContentFieldImpl#getValue()}
   */
  @Test
  public void testGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StructuredContentFieldImpl()).getValue());
  }

  /**
   * Test {@link StructuredContentFieldImpl#getValue()}.
   * <p>
   * Method under test: {@link StructuredContentFieldImpl#getValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetValue2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3756 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.domain.StructuredContentFieldImpl structuredContentFieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentFieldImpl()).getValue();
  }

  /**
   * Test {@link StructuredContentFieldImpl#setValue(String)}.
   * <p>
   * Method under test: {@link StructuredContentFieldImpl#setValue(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3760 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.domain.StructuredContentFieldImpl structuredContentFieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentFieldImpl()).setValue("42");
  }

  /**
   * Test {@link StructuredContentFieldImpl#setValue(String)}.
   * <ul>
   *   <li>Then {@link StructuredContentFieldImpl} (default constructor) Value is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentFieldImpl#setValue(String)}
   */
  @Test
  public void testSetValue_thenStructuredContentFieldImplValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldImpl structuredContentFieldImpl = new StructuredContentFieldImpl();

    // Act
    structuredContentFieldImpl.setValue("42");

    // Assert
    assertEquals("42", structuredContentFieldImpl.getValue());
    assertEquals("42", structuredContentFieldImpl.stringValue);
  }

  /**
   * Test {@link StructuredContentFieldImpl#setValue(String)}.
   * <ul>
   *   <li>Then {@link StructuredContentFieldImpl} (default constructor) Value is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentFieldImpl#setValue(String)}
   */
  @Test
  public void testSetValue_thenStructuredContentFieldImplValueIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldImpl structuredContentFieldImpl = new StructuredContentFieldImpl();
    structuredContentFieldImpl.setFieldKey("Field Key");
    structuredContentFieldImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);

    // Act
    structuredContentFieldImpl.setValue(null);

    // Assert
    assertNull(structuredContentFieldImpl.getValue());
    assertNull(structuredContentFieldImpl.stringValue);
  }

  /**
   * Test {@link StructuredContentFieldImpl#clone()}.
   * <p>
   * Method under test: {@link StructuredContentFieldImpl#clone()}
   */
  @Test
  public void testClone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    StructuredContentField actualCloneResult = (new StructuredContentFieldImpl()).clone();

    // Assert
    assertTrue(actualCloneResult instanceof StructuredContentFieldImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getFieldKey());
    assertNull(actualCloneResult.getValue());
    assertNull(((StructuredContentFieldImpl) actualCloneResult).lobValue);
    assertNull(((StructuredContentFieldImpl) actualCloneResult).stringValue);
  }

  /**
   * Test {@link StructuredContentFieldImpl#clone()}.
   * <p>
   * Method under test: {@link StructuredContentFieldImpl#clone()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClone2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3690 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.domain.StructuredContentFieldImpl structuredContentFieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentFieldImpl()).clone();
  }

  /**
   * Test
   * {@link StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldImpl structuredContentFieldImpl = new StructuredContentFieldImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentField> actualCreateOrRetrieveCopyInstanceResult = structuredContentFieldImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3694 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.domain.StructuredContentFieldImpl structuredContentFieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentFieldImpl structuredContentFieldImpl2 = new StructuredContentFieldImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    structuredContentFieldImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog,
        fromSite, toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test
   * {@link StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link StructuredContentFieldImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnStructuredContentFieldImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldImpl structuredContentFieldImpl = new StructuredContentFieldImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<StructuredContentField> actualCreateOrRetrieveCopyInstanceResult = structuredContentFieldImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.cms.structure.domain.StructuredContentFieldImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    StructuredContentField clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof StructuredContentFieldImpl);
    assertNull(clone.getId());
    assertNull(clone.getFieldKey());
    assertNull(clone.getValue());
    assertNull(((StructuredContentFieldImpl) clone).lobValue);
    assertNull(((StructuredContentFieldImpl) clone).stringValue);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link StructuredContentFieldImpl}
   *   <li>{@link StructuredContentFieldImpl#setFieldKey(String)}
   *   <li>{@link StructuredContentFieldImpl#setId(Long)}
   *   <li>{@link StructuredContentFieldImpl#getFieldKey()}
   *   <li>{@link StructuredContentFieldImpl#getId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentFieldImpl actualStructuredContentFieldImpl = new StructuredContentFieldImpl();
    actualStructuredContentFieldImpl.setFieldKey("Field Key");
    actualStructuredContentFieldImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    String actualFieldKey = actualStructuredContentFieldImpl.getFieldKey();

    // Assert that nothing has changed
    assertEquals("Field Key", actualFieldKey);
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID,
        actualStructuredContentFieldImpl.getId().longValue());
  }
}
