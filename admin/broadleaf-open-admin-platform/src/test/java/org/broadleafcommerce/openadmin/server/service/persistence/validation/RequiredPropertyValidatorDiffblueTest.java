package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
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
public class RequiredPropertyValidatorDiffblueTest {
  @Autowired
  private RequiredPropertyValidator requiredPropertyValidator;

  /**
   * Test
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <p>
   * Method under test:
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
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
    //   public class DiffblueFakeClass2830 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.validation.RequiredPropertyValidator requiredPropertyValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RequiredPropertyValidator requiredPropertyValidator2 = new RequiredPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    // Act
    requiredPropertyValidator2.validate(entity, instance, entityFieldMetadata, new BasicFieldMetadata(),
        "Property Name", "42");
  }

  /**
   * Test
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return not Valid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenNull_whenEmptyString_thenReturnNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredPropertyValidator requiredPropertyValidator = new RequiredPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    BasicFieldMetadata propertyMetadata = new BasicFieldMetadata();
    propertyMetadata.setRequiredOverride(null);
    propertyMetadata.setRequired(true);

    // Act
    PropertyValidationResult actualValidateResult = requiredPropertyValidator.validate(entity, instance,
        entityFieldMetadata, propertyMetadata, "Property Name", "");

    // Assert
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor) RequiredOverride is
   * {@code null}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenBasicFieldMetadataRequiredOverrideIsNull_thenReturnNotNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredPropertyValidator requiredPropertyValidator = new RequiredPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    BasicFieldMetadata propertyMetadata = new BasicFieldMetadata();
    propertyMetadata.setRequiredOverride(null);
    propertyMetadata.setRequired(true);

    // Act
    PropertyValidationResult actualValidateResult = requiredPropertyValidator.validate(entity, instance,
        entityFieldMetadata, propertyMetadata, "Property Name", "42");

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor) RequiredOverride is
   * {@code null}.</li>
   *   <li>Then return not Valid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenBasicFieldMetadataRequiredOverrideIsNull_thenReturnNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredPropertyValidator requiredPropertyValidator = new RequiredPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    BasicFieldMetadata propertyMetadata = new BasicFieldMetadata();
    propertyMetadata.setRequiredOverride(null);
    propertyMetadata.setRequired(true);

    // Act
    PropertyValidationResult actualValidateResult = requiredPropertyValidator.validate(entity, instance,
        entityFieldMetadata, propertyMetadata, "Property Name", null);

    // Assert
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor) RequiredOverride is
   * {@code true}.</li>
   *   <li>Then return not Valid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenBasicFieldMetadataRequiredOverrideIsTrue_thenReturnNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredPropertyValidator requiredPropertyValidator = new RequiredPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    BasicFieldMetadata propertyMetadata = new BasicFieldMetadata();
    propertyMetadata.setRequiredOverride(true);
    propertyMetadata.setRequired(null);

    // Act
    PropertyValidationResult actualValidateResult = requiredPropertyValidator.validate(entity, instance,
        entityFieldMetadata, propertyMetadata, "Property Name", null);

    // Assert
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenBasicFieldMetadata_thenReturnNotNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredPropertyValidator requiredPropertyValidator = new RequiredPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = requiredPropertyValidator.validate(entity, instance,
        entityFieldMetadata, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link Entity}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenEntity_thenReturnNotNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredPropertyValidator requiredPropertyValidator = new RequiredPropertyValidator();
    Entity entity = mock(Entity.class);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = requiredPropertyValidator.validate(entity, instance,
        entityFieldMetadata, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }
}
