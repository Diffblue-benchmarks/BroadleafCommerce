package org.broadleafcommerce.admin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryXref;
import org.broadleafcommerce.core.catalog.domain.CategoryXrefImpl;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryParentCategoryFieldPersistenceProviderDiffblueTest {
  @Autowired
  private CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider;

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8944 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider2 = new CategoryParentCategoryFieldPersistenceProvider();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    categoryParentCategoryFieldPersistenceProvider2.populateValue(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, categoryParentCategoryFieldPersistenceProvider
        .populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExtractValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8643 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider2 = new CategoryParentCategoryFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    categoryParentCategoryFieldPersistenceProvider2.extractValue(extractValueRequest, new Property());
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        categoryParentCategoryFieldPersistenceProvider.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckDirtyStateWithInstanceCheckValue4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8604 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider2 = new CategoryParentCategoryFieldPersistenceProvider();

    // Act
    categoryParentCategoryFieldPersistenceProvider2.checkDirtyState(new CategoryImpl(), 42L);
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue_givenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue_givenArrayListAddCategoryXrefImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getId()).thenReturn(1L);
    when(categoryImpl.isActive()).thenReturn(true);
    doNothing().when(categoryImpl).setActiveStartDate(Mockito.<Date>any());
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 42L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(categoryImpl).getId();
    verify(categoryImpl).isActive();
    verify(categoryImpl).setActiveStartDate(isA(Date.class));
    verify(categoryXrefImpl, atLeast(1)).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue_whenCategoryImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    // Act and Assert
    assertTrue(categoryParentCategoryFieldPersistenceProvider.checkDirtyState(new CategoryImpl(), 42L));
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>When {@link CategoryImpl}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue_whenCategoryImpl_thenReturnTrue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryParentCategoryFieldPersistenceProvider()).checkDirtyState(mock(CategoryImpl.class), null));
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryParentCategoryFieldPersistenceProvider()).checkDirtyState(null, 42L));
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   * with {@code instance}, {@code checkValue}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#checkDirtyState(Category, Long)}
   */
  @Test
  public void testCheckDirtyStateWithInstanceCheckValue_whenOne_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getId()).thenReturn(1L);
    when(categoryImpl.isActive()).thenReturn(true);
    doNothing().when(categoryImpl).setActiveStartDate(Mockito.<Date>any());
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl instance = mock(CategoryImpl.class);
    when(instance.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    boolean actualCheckDirtyStateResult = categoryParentCategoryFieldPersistenceProvider.checkDirtyState(instance, 1L);

    // Assert
    verify(instance).getAllParentCategoryXrefs();
    verify(categoryImpl).getId();
    verify(categoryImpl).isActive();
    verify(categoryImpl).setActiveStartDate(isA(Date.class));
    verify(categoryXrefImpl, atLeast(1)).getCategory();
    verify(categoryXrefImpl, atLeast(1)).getDefaultReference();
    assertFalse(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}.
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8910 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider2 = new CategoryParentCategoryFieldPersistenceProvider();

    // Act
    categoryParentCategoryFieldPersistenceProvider2.getDefaultCategory(new CategoryImpl());
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryXrefImpl} (default
   * constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  public void testGetDefaultCategory_givenArrayListAddCategoryXrefImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(new CategoryXrefImpl());
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    Category actualDefaultCategory = categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  public void testGetDefaultCategory_givenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    Category actualDefaultCategory = categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}.
   * <ul>
   *   <li>Then calls {@link CategoryXrefImpl#getCategory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  public void testGetDefaultCategory_thenCallsGetCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}.
   * <ul>
   *   <li>Then calls {@link CategoryXrefImpl#getCategory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  public void testGetDefaultCategory_thenCallsGetCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    Category actualDefaultCategory = categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}.
   * <ul>
   *   <li>Then calls {@link CategoryXrefImpl#getCategory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  public void testGetDefaultCategory_thenCallsGetCategory3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryXrefImpl categoryXrefImpl = mock(CategoryXrefImpl.class);
    when(categoryXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryXref> categoryXrefList = new ArrayList<>();
    categoryXrefList.add(categoryXrefImpl);
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getAllParentCategoryXrefs()).thenReturn(categoryXrefList);

    // Act
    Category actualDefaultCategory = categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(category);

    // Assert
    verify(category).getAllParentCategoryXrefs();
    verify(categoryXrefImpl).getCategory();
    assertNull(actualDefaultCategory);
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getDefaultCategory(Category)}
   */
  @Test
  public void testGetDefaultCategory_whenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();

    // Act and Assert
    assertNull(categoryParentCategoryFieldPersistenceProvider.getDefaultCategory(new CategoryImpl()));
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandlePersistence() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8300 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider2 = new CategoryParentCategoryFieldPersistenceProvider();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    categoryParentCategoryFieldPersistenceProvider2.canHandlePersistence(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertFalse(categoryParentCategoryFieldPersistenceProvider.canHandlePersistence(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleExtraction() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8033 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider2 = new CategoryParentCategoryFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    categoryParentCategoryFieldPersistenceProvider2.canHandleExtraction(extractValueRequest, new Property());
  }

  /**
   * Test
   * {@link CategoryParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryParentCategoryFieldPersistenceProvider categoryParentCategoryFieldPersistenceProvider = new CategoryParentCategoryFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertFalse(
        categoryParentCategoryFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property()));
  }

  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test:
   * {@link CategoryParentCategoryFieldPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-2147483548, (new CategoryParentCategoryFieldPersistenceProvider()).getOrder());
  }
}
