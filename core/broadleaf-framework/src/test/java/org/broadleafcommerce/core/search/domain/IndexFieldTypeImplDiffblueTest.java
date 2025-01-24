package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
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
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class IndexFieldTypeImplDiffblueTest {
  @Autowired
  private IndexFieldTypeImpl indexFieldTypeImpl;

  /**
   * Test {@link IndexFieldTypeImpl#getFieldType()}.
   * <p>
   * Method under test: {@link IndexFieldTypeImpl#getFieldType()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass968 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl indexFieldTypeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new IndexFieldTypeImpl()).getFieldType();
  }

  /**
   * Test {@link IndexFieldTypeImpl#getFieldType()}.
   * <ul>
   *   <li>Given {@link FieldType} {@link FieldType#getType()} return
   * {@code Type}.</li>
   *   <li>Then return {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldTypeImpl#getFieldType()}
   */
  @Test
  public void testGetFieldType_givenFieldTypeGetTypeReturnType_thenReturnFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldType fieldType = mock(FieldType.class);
    when(fieldType.getType()).thenReturn("Type");

    IndexFieldTypeImpl indexFieldTypeImpl = new IndexFieldTypeImpl();
    indexFieldTypeImpl.setFieldType(fieldType);

    // Act
    FieldType actualFieldType = indexFieldTypeImpl.getFieldType();

    // Assert
    verify(fieldType).getType();
    assertEquals("Friendly Type", actualFieldType.getFriendlyType());
    assertEquals("Type", actualFieldType.getType());
  }

  /**
   * Test {@link IndexFieldTypeImpl#getFieldType()}.
   * <ul>
   *   <li>Given {@link IndexFieldTypeImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldTypeImpl#getFieldType()}
   */
  @Test
  public void testGetFieldType_givenIndexFieldTypeImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new IndexFieldTypeImpl()).getFieldType());
  }

  /**
   * Test {@link IndexFieldTypeImpl#setFieldType(FieldType)}.
   * <p>
   * Method under test: {@link IndexFieldTypeImpl#setFieldType(FieldType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetFieldType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass973 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl indexFieldTypeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new IndexFieldTypeImpl()).setFieldType(FieldType.BOOLEAN);
  }

  /**
   * Test {@link IndexFieldTypeImpl#setFieldType(FieldType)}.
   * <ul>
   *   <li>Then {@link IndexFieldTypeImpl} (default constructor) FieldType
   * FriendlyType is {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldTypeImpl#setFieldType(FieldType)}
   */
  @Test
  public void testSetFieldType_thenIndexFieldTypeImplFieldTypeFriendlyTypeIsFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldTypeImpl indexFieldTypeImpl = new IndexFieldTypeImpl();
    FieldType fieldType = mock(FieldType.class);
    when(fieldType.getType()).thenReturn("Type");

    // Act
    indexFieldTypeImpl.setFieldType(fieldType);

    // Assert
    verify(fieldType).getType();
    FieldType fieldType2 = indexFieldTypeImpl.getFieldType();
    assertEquals("Friendly Type", fieldType2.getFriendlyType());
    assertEquals("Type", fieldType2.getType());
    assertEquals("Type", indexFieldTypeImpl.fieldType);
  }

  /**
   * Test {@link IndexFieldTypeImpl#setFieldType(FieldType)}.
   * <ul>
   *   <li>When {@link FieldType#BOOLEAN}.</li>
   *   <li>Then {@link IndexFieldTypeImpl} (default constructor)
   * {@link IndexFieldTypeImpl#fieldType} is {@code b}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldTypeImpl#setFieldType(FieldType)}
   */
  @Test
  public void testSetFieldType_whenBoolean_thenIndexFieldTypeImplFieldTypeIsB() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldTypeImpl indexFieldTypeImpl = new IndexFieldTypeImpl();
    FieldType fieldType = FieldType.BOOLEAN;

    // Act
    indexFieldTypeImpl.setFieldType(fieldType);

    // Assert
    assertEquals("b", indexFieldTypeImpl.fieldType);
    FieldType expectedFieldType = fieldType.BOOLEAN;
    assertSame(expectedFieldType, indexFieldTypeImpl.getFieldType());
  }

  /**
   * Test
   * {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldTypeImpl indexFieldTypeImpl = new IndexFieldTypeImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<IndexFieldType> actualCreateOrRetrieveCopyInstanceResult = indexFieldTypeImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldType fieldType = mock(FieldType.class);
    when(fieldType.getType()).thenReturn("Type");

    IndexFieldTypeImpl indexFieldTypeImpl = new IndexFieldTypeImpl();
    indexFieldTypeImpl.setFieldType(fieldType);

    IndexFieldTypeImpl indexFieldTypeImpl2 = new IndexFieldTypeImpl();
    indexFieldTypeImpl2.setFieldType(FieldType.BOOLEAN);
    indexFieldTypeImpl2.setId(1L);
    indexFieldTypeImpl2.setIndexField(new IndexFieldImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(indexFieldTypeImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<IndexFieldType> actualCreateOrRetrieveCopyInstanceResult = indexFieldTypeImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(fieldType).getType();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass938 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl indexFieldTypeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    IndexFieldTypeImpl indexFieldTypeImpl2 = new IndexFieldTypeImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    indexFieldTypeImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test
   * {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link IndexFieldTypeImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldTypeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnIndexFieldTypeImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldTypeImpl indexFieldTypeImpl = new IndexFieldTypeImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<IndexFieldType> actualCreateOrRetrieveCopyInstanceResult = indexFieldTypeImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    IndexFieldType clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof IndexFieldTypeImpl);
    assertNull(clone.getId());
    assertNull(((IndexFieldTypeImpl) clone).fieldType);
    assertNull(clone.getIndexField());
    assertNull(clone.getFieldType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IndexFieldTypeImpl}
   *   <li>{@link IndexFieldTypeImpl#setId(Long)}
   *   <li>{@link IndexFieldTypeImpl#setIndexField(IndexField)}
   *   <li>{@link IndexFieldTypeImpl#getId()}
   *   <li>{@link IndexFieldTypeImpl#getIndexField()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IndexFieldTypeImpl actualIndexFieldTypeImpl = new IndexFieldTypeImpl();
    actualIndexFieldTypeImpl.setId(1L);
    IndexFieldImpl indexField = new IndexFieldImpl();
    actualIndexFieldTypeImpl.setIndexField(indexField);
    Long actualId = actualIndexFieldTypeImpl.getId();
    IndexField actualIndexField = actualIndexFieldTypeImpl.getIndexField();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertSame(indexField, actualIndexField);
  }
}
