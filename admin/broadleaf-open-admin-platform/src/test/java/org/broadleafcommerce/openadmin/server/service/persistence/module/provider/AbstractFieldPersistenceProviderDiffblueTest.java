package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddSearchMappingRequest;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractFieldPersistenceProviderDiffblueTest {
  @Autowired
  private AbstractFieldPersistenceProvider abstractFieldPersistenceProvider;

  /**
   * Test
   * {@link AbstractFieldPersistenceProvider#getListFieldType(Serializable, FieldManager, Property, PersistenceManager)}.
   * <p>
   * Method under test:
   * {@link AbstractFieldPersistenceProvider#getListFieldType(Serializable, FieldManager, Property, PersistenceManager)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetListFieldType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11250 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.AbstractFieldPersistenceProvider abstractFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);
    FieldManager fieldManager = new FieldManager(entityConfiguration,
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)));

    Property property = new Property();

    // Act
    basicFieldPersistenceProvider.getListFieldType(instance, fieldManager, property, new PersistenceManagerImpl());
  }

  /**
   * Test
   * {@link AbstractFieldPersistenceProvider#getMapFieldType(Serializable, FieldManager, Property, PersistenceManager)}.
   * <p>
   * Method under test:
   * {@link AbstractFieldPersistenceProvider#getMapFieldType(Serializable, FieldManager, Property, PersistenceManager)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMapFieldType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11432 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.AbstractFieldPersistenceProvider abstractFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);
    FieldManager fieldManager = new FieldManager(entityConfiguration,
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)));

    Property property = new Property();

    // Act
    basicFieldPersistenceProvider.getMapFieldType(instance, fieldManager, property, new PersistenceManagerImpl());
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#buildFieldInfo(Field)}.
   * <p>
   * Method under test:
   * {@link AbstractFieldPersistenceProvider#buildFieldInfo(Field)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildFieldInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11244 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.AbstractFieldPersistenceProvider abstractFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicFieldPersistenceProvider()).buildFieldInfo(null);
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#alwaysRun()}.
   * <p>
   * Method under test: {@link AbstractFieldPersistenceProvider#alwaysRun()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAlwaysRun() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11241 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.AbstractFieldPersistenceProvider abstractFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicFieldPersistenceProvider()).alwaysRun();
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#alwaysRun()}.
   * <ul>
   *   <li>Given {@link BasicFieldPersistenceProvider} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldPersistenceProvider#alwaysRun()}
   */
  @Test
  public void testAlwaysRun_givenBasicFieldPersistenceProvider() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BasicFieldPersistenceProvider()).alwaysRun());
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#alwaysRun()}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePerspective#addPersistencePerspectiveItem(PersistencePerspectiveItemType, PersistencePerspectiveItem)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldPersistenceProvider#alwaysRun()}
   */
  @Test
  public void testAlwaysRun_thenCallsAddPersistencePerspectiveItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    doNothing().when(persistencePerspective)
        .addPersistencePerspectiveItem(Mockito.<PersistencePerspectiveItemType>any(),
            Mockito.<PersistencePerspectiveItem>any());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>());

    // Act
    boolean actualAlwaysRunResult = basicFieldPersistenceProvider.alwaysRun();

    // Assert
    verify(persistencePerspective).addPersistencePerspectiveItem(eq(PersistencePerspectiveItemType.FOREIGNKEY),
        isA(PersistencePerspectiveItem.class));
    assertFalse(actualAlwaysRunResult);
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}.
   * <p>
   * Method under test:
   * {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandlePopulateNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11247 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.AbstractFieldPersistenceProvider abstractFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicFieldPersistenceProvider()).canHandlePopulateNull();
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}.
   * <ul>
   *   <li>Given {@link BasicFieldPersistenceProvider} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}
   */
  @Test
  public void testCanHandlePopulateNull_givenBasicFieldPersistenceProvider_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BasicFieldPersistenceProvider()).canHandlePopulateNull());
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}.
   * <ul>
   *   <li>Given {@link MapFieldPersistenceProvider} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}
   */
  @Test
  public void testCanHandlePopulateNull_givenMapFieldPersistenceProvider_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MapFieldPersistenceProvider()).canHandlePopulateNull());
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePerspective#addPersistencePerspectiveItem(PersistencePerspectiveItemType, PersistencePerspectiveItem)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}
   */
  @Test
  public void testCanHandlePopulateNull_thenCallsAddPersistencePerspectiveItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    doNothing().when(persistencePerspective)
        .addPersistencePerspectiveItem(Mockito.<PersistencePerspectiveItemType>any(),
            Mockito.<PersistencePerspectiveItem>any());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>());

    // Act
    boolean actualCanHandlePopulateNullResult = basicFieldPersistenceProvider.canHandlePopulateNull();

    // Assert
    verify(persistencePerspective).addPersistencePerspectiveItem(eq(PersistencePerspectiveItemType.FOREIGNKEY),
        isA(PersistencePerspectiveItem.class));
    assertFalse(actualCanHandlePopulateNullResult);
  }
}
