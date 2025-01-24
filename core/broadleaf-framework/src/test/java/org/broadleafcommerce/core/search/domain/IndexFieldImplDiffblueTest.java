package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class IndexFieldImplDiffblueTest {
  @Autowired
  private IndexFieldImpl indexFieldImpl;

  /**
   * Test
   * {@link IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<IndexField> actualCreateOrRetrieveCopyInstanceResult = indexFieldImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass902 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.IndexFieldImpl indexFieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    IndexFieldImpl indexFieldImpl2 = new IndexFieldImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    indexFieldImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test
   * {@link IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link IndexFieldImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndexFieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnIndexFieldImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<IndexField> actualCreateOrRetrieveCopyInstanceResult = indexFieldImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.search.domain.IndexFieldImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    IndexField clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof IndexFieldImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(indexFieldImpl, clone);
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}, and
   * {@link IndexFieldImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IndexFieldImpl#equals(Object)}
   *   <li>{@link IndexFieldImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(null);
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    IndexFieldImpl indexFieldImpl2 = new IndexFieldImpl();
    indexFieldImpl2.setField(null);
    indexFieldImpl2.setFieldTypes(new ArrayList<>());
    indexFieldImpl2.setId(1L);
    indexFieldImpl2.setSearchable(true);

    // Act and Assert
    assertEquals(indexFieldImpl, indexFieldImpl2);
    int expectedHashCodeResult = indexFieldImpl.hashCode();
    assertEquals(expectedHashCodeResult, indexFieldImpl2.hashCode());
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}, and
   * {@link IndexFieldImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IndexFieldImpl#equals(Object)}
   *   <li>{@link IndexFieldImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    // Act and Assert
    assertEquals(indexFieldImpl, indexFieldImpl);
    int expectedHashCodeResult = indexFieldImpl.hashCode();
    assertEquals(expectedHashCodeResult, indexFieldImpl.hashCode());
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(null);
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    IndexFieldImpl indexFieldImpl2 = new IndexFieldImpl();
    indexFieldImpl2.setField(new FieldImpl());
    indexFieldImpl2.setFieldTypes(new ArrayList<>());
    indexFieldImpl2.setId(1L);
    indexFieldImpl2.setSearchable(true);

    // Act and Assert
    assertNotEquals(indexFieldImpl, indexFieldImpl2);
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(mock(FieldImpl.class));
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    IndexFieldImpl indexFieldImpl2 = new IndexFieldImpl();
    indexFieldImpl2.setField(new FieldImpl());
    indexFieldImpl2.setFieldTypes(new ArrayList<>());
    indexFieldImpl2.setId(1L);
    indexFieldImpl2.setSearchable(true);

    // Act and Assert
    assertNotEquals(indexFieldImpl, indexFieldImpl2);
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent_thenThrowException() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.search.domain.FieldImpl.equals(FieldImpl.java:243)
    //       at org.apache.commons.lang3.builder.EqualsBuilder.append(EqualsBuilder.java:624)
    //       at org.broadleafcommerce.core.search.domain.IndexFieldImpl.equals(IndexFieldImpl.java:171)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    IndexFieldImpl indexFieldImpl2 = new IndexFieldImpl();
    indexFieldImpl2.setField(new FieldImpl());
    indexFieldImpl2.setFieldTypes(new ArrayList<>());
    indexFieldImpl2.setId(1L);
    indexFieldImpl2.setSearchable(true);

    // Act and Assert
    assertThrows(NullPointerException.class, () -> indexFieldImpl.equals(indexFieldImpl2));
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    // Act and Assert
    assertNotEquals(indexFieldImpl, null);
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    // Act and Assert
    assertNotEquals(indexFieldImpl, "Different type to IndexFieldImpl");
  }

  /**
   * Test {@link IndexFieldImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link IndexFieldImpl#getMainEntityName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMainEntityName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass932 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.IndexFieldImpl indexFieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new IndexFieldImpl()).getMainEntityName();
  }

  /**
   * Test {@link IndexFieldImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor) Field is
   * {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenIndexFieldImplFieldIsFieldImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    // Act and Assert
    assertNull(indexFieldImpl.getMainEntityName());
  }

  /**
   * Test {@link IndexFieldImpl#getMainEntityName()}.
   * <ul>
   *   <li>Then return {@code Friendly Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexFieldImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_thenReturnFriendlyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Field field = mock(Field.class);
    when(field.getFriendlyName()).thenReturn("Friendly Name");

    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(field);
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    // Act
    String actualMainEntityName = indexFieldImpl.getMainEntityName();

    // Assert
    verify(field).getFriendlyName();
    assertEquals("Friendly Name", actualMainEntityName);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IndexFieldImpl}
   *   <li>{@link IndexFieldImpl#setField(Field)}
   *   <li>{@link IndexFieldImpl#setFieldTypes(List)}
   *   <li>{@link IndexFieldImpl#setId(Long)}
   *   <li>{@link IndexFieldImpl#setSearchable(Boolean)}
   *   <li>{@link IndexFieldImpl#getField()}
   *   <li>{@link IndexFieldImpl#getFieldTypes()}
   *   <li>{@link IndexFieldImpl#getId()}
   *   <li>{@link IndexFieldImpl#getSearchable()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IndexFieldImpl actualIndexFieldImpl = new IndexFieldImpl();
    FieldImpl field = new FieldImpl();
    actualIndexFieldImpl.setField(field);
    ArrayList<IndexFieldType> fieldTypes = new ArrayList<>();
    actualIndexFieldImpl.setFieldTypes(fieldTypes);
    actualIndexFieldImpl.setId(1L);
    actualIndexFieldImpl.setSearchable(true);
    Field actualField = actualIndexFieldImpl.getField();
    List<IndexFieldType> actualFieldTypes = actualIndexFieldImpl.getFieldTypes();
    Long actualId = actualIndexFieldImpl.getId();
    Boolean actualSearchable = actualIndexFieldImpl.getSearchable();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertTrue(actualFieldTypes.isEmpty());
    assertTrue(actualSearchable);
    assertSame(fieldTypes, actualFieldTypes);
    assertSame(field, actualField);
  }
}
