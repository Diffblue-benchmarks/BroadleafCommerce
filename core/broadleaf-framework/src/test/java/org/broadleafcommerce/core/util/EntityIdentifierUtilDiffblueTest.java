package org.broadleafcommerce.core.util;

import static org.junit.Assert.assertNull;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext.xml",
    "/bl-framework-applicationContext-entity.xml", "/bl-framework-applicationContext-persistence.xml",
    "/bl-framework-applicationContext-workflow.xml",
    "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EntityIdentifierUtilDiffblueTest {
  @Autowired
  private EntityIdentifierUtil entityIdentifierUtil;

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Class)} with
   * {@code clazz}.
   * <p>
   * Method under test: {@link EntityIdentifierUtil#getIdentifierFieldName(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIdentifierFieldNameWithClazz() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass399 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.EntityIdentifierUtil entityIdentifierUtil;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    EntityIdentifierUtil entityIdentifierUtil2 = new EntityIdentifierUtil();
    Class<Object> clazz = Object.class;

    // Act
    entityIdentifierUtil2.getIdentifierFieldName(clazz);
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Class)} with
   * {@code clazz}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityIdentifierUtil#getIdentifierFieldName(Class)}
   */
  @Test
  public void testGetIdentifierFieldNameWithClazz_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityIdentifierUtil entityIdentifierUtil = new EntityIdentifierUtil();
    Class<EntityIdentifierUtil> clazz = EntityIdentifierUtil.class;

    // Act and Assert
    assertNull(entityIdentifierUtil.getIdentifierFieldName(clazz));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Object)} with
   * {@code entity}.
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifierFieldName(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIdentifierFieldNameWithEntity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass429 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.EntityIdentifierUtil entityIdentifierUtil;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new EntityIdentifierUtil()).getIdentifierFieldName("Entity");
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Object)} with
   * {@code entity}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifierFieldName(Object)}
   */
  @Test
  public void testGetIdentifierFieldNameWithEntity_whenEntity_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldName("Entity"));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Object)} with
   * {@code entity}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifierFieldName(Object)}
   */
  @Test
  public void testGetIdentifierFieldNameWithEntity_whenNine_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldName(9));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}.
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIdentifierFieldValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass440 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.EntityIdentifierUtil entityIdentifierUtil;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new EntityIdentifierUtil()).getIdentifierFieldValue("Entity");
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}
   */
  @Test
  public void testGetIdentifierFieldValue_whenEntity_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldValue("Entity"));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}
   */
  @Test
  public void testGetIdentifierFieldValue_whenNine_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldValue(9));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}.
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIdentifyFieldValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass451 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.EntityIdentifierUtil entityIdentifierUtil;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new EntityIdentifierUtil()).getIdentifyFieldValue("Entity", "Primary Key Field Name");
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}
   */
  @Test
  public void testGetIdentifyFieldValue_whenEntity_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifyFieldValue("Entity", "Primary Key Field Name"));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}
   */
  @Test
  public void testGetIdentifyFieldValue_whenNine_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifyFieldValue(9, "Primary Key Field Name"));
  }

  /**
   * Test {@link EntityIdentifierUtil#findIdentifierField(Class)}.
   * <p>
   * Method under test: {@link EntityIdentifierUtil#findIdentifierField(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindIdentifierField() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass369 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.EntityIdentifierUtil entityIdentifierUtil;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    EntityIdentifierUtil entityIdentifierUtil2 = new EntityIdentifierUtil();
    Class<Object> clazz = Object.class;

    // Act
    entityIdentifierUtil2.findIdentifierField(clazz);
  }

  /**
   * Test {@link EntityIdentifierUtil#findIdentifierField(Class)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityIdentifierUtil#findIdentifierField(Class)}
   */
  @Test
  public void testFindIdentifierField_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityIdentifierUtil entityIdentifierUtil = new EntityIdentifierUtil();
    Class<EntityIdentifierUtil> clazz = EntityIdentifierUtil.class;

    // Act and Assert
    assertNull(entityIdentifierUtil.findIdentifierField(clazz));
  }

  /**
   * Test new {@link EntityIdentifierUtil} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link EntityIdentifierUtil}
   */
  @Test
  public void testNewEntityIdentifierUtil() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new EntityIdentifierUtil();
  }
}
