package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class EntityValidatorServiceImplDiffblueTest {
  @Autowired
  private EntityValidatorServiceImpl entityValidatorServiceImpl;

  /**
   * Test {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}.
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateBroadleafValidatorMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.validation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1167 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.validation.EntityValidatorServiceImpl entityValidatorServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new EntityValidatorServiceImpl()).populateBroadleafValidatorMap();
  }

  /**
   * Test
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}.
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.validation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1170 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.validation.EntityValidatorServiceImpl entityValidatorServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl2 = new EntityValidatorServiceImpl();
    Entity submittedEntity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> propertiesMetadata = new HashMap<>();

    // Act
    entityValidatorServiceImpl2.validate(submittedEntity, instance, propertiesMetadata,
        new AdornedTargetListPersistenceModule(), true);
  }

  /**
   * Test
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code java.util.List}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  public void testValidate_givenArrayOfStringWithJavaUtilList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    Entity submittedEntity = mock(Entity.class);
    when(submittedEntity.getType()).thenReturn(new String[]{"java.util.List"});

    // Act
    entityValidatorServiceImpl.validate(submittedEntity, null, new HashMap<>(), mock(RecordHelper.class), true);

    // Assert
    verify(submittedEntity).getType();
  }

  /**
   * Test
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}.
   * <ul>
   *   <li>Given array of {@link String} with
   * {@code org.broadleafcommerce.openadmin.dto.Entity}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  public void testValidate_givenArrayOfStringWithOrgBroadleafcommerceOpenadminDtoEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    Entity submittedEntity = mock(Entity.class);
    when(submittedEntity.getType()).thenReturn(new String[]{"org.broadleafcommerce.openadmin.dto.Entity"});

    // Act
    entityValidatorServiceImpl.validate(submittedEntity, null, new HashMap<>(), mock(RecordHelper.class), true);

    // Assert
    verify(submittedEntity).getType();
  }

  /**
   * Test
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Type}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  public void testValidate_givenArrayOfStringWithType_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    Entity submittedEntity = mock(Entity.class);
    when(submittedEntity.getType()).thenReturn(new String[]{"Type"});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> entityValidatorServiceImpl.validate(submittedEntity, null,
        new HashMap<>(), mock(RecordHelper.class), true));
    verify(submittedEntity).getType();
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTypeHierarchy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.validation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1145 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.validation.EntityValidatorServiceImpl entityValidatorServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl2 = new EntityValidatorServiceImpl();

    // Act
    entityValidatorServiceImpl2.getTypeHierarchy(new Entity());
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Type}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  public void testGetTypeHierarchy_givenArrayOfStringWithType_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> entityValidatorServiceImpl.getTypeHierarchy(entity));
    verify(entity).getType();
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   * <ul>
   *   <li>Then return first is {@code java.util.List}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  public void testGetTypeHierarchy_thenReturnFirstIsJavaUtilList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"java.util.List"});

    // Act
    List<String> actualTypeHierarchy = entityValidatorServiceImpl.getTypeHierarchy(entity);

    // Assert
    verify(entity).getType();
    assertEquals(1, actualTypeHierarchy.size());
    assertEquals("java.util.List", actualTypeHierarchy.get(0));
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   * <ul>
   *   <li>Then return first is
   * {@code org.broadleafcommerce.openadmin.dto.Entity}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  public void testGetTypeHierarchy_thenReturnFirstIsOrgBroadleafcommerceOpenadminDtoEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"org.broadleafcommerce.openadmin.dto.Entity"});

    // Act
    List<String> actualTypeHierarchy = entityValidatorServiceImpl.getTypeHierarchy(entity);

    // Assert
    verify(entity).getType();
    assertEquals(1, actualTypeHierarchy.size());
    assertEquals("org.broadleafcommerce.openadmin.dto.Entity", actualTypeHierarchy.get(0));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityValidatorServiceImpl#setGlobalEntityValidators(List)}
   *   <li>{@link EntityValidatorServiceImpl#getGlobalEntityValidators()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    ArrayList<GlobalPropertyValidator> globalEntityValidators = new ArrayList<>();

    // Act
    entityValidatorServiceImpl.setGlobalEntityValidators(globalEntityValidators);
    List<GlobalPropertyValidator> actualGlobalEntityValidators = entityValidatorServiceImpl.getGlobalEntityValidators();

    // Assert that nothing has changed
    assertTrue(actualGlobalEntityValidators.isEmpty());
    assertSame(globalEntityValidators, actualGlobalEntityValidators);
  }
}
