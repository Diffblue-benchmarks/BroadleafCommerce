package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELTranslationException;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataWrapper;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
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
public class RuleFieldValidatorDiffblueTest {
  @Autowired
  private RuleFieldValidator ruleFieldValidator;

  /**
   * Test {@link RuleFieldValidator#validate(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link RuleFieldValidator#validate(PopulateValueRequest, Serializable)}
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
    //   public class DiffblueFakeClass3257 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.validation.RuleFieldValidator ruleFieldValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldValidator ruleFieldValidator2 = new RuleFieldValidator();
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
    ruleFieldValidator2.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test {@link RuleFieldValidator#validate(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return ErrorMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate_thenReturnErrorMessageIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldValidator ruleFieldValidator = new RuleFieldValidator();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    PropertyValidationResult actualValidateResult = ruleFieldValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link RuleFieldValidator#getMvelParsingErrorMesage(DataWrapper, MVELTranslationException)}.
   * <p>
   * Method under test:
   * {@link RuleFieldValidator#getMvelParsingErrorMesage(DataWrapper, MVELTranslationException)}
   */
  @Test
  public void testGetMvelParsingErrorMesage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldValidator ruleFieldValidator = new RuleFieldValidator();
    DataWrapper dw = new DataWrapper();

    // Act and Assert
    assertEquals("Problem translating rule builder, error code 1: An error occurred",
        ruleFieldValidator.getMvelParsingErrorMesage(dw, new MVELTranslationException(1, "An error occurred")));
  }

  /**
   * Test
   * {@link RuleFieldValidator#getMvelParsingErrorMesage(DataWrapper, MVELTranslationException)}.
   * <p>
   * Method under test:
   * {@link RuleFieldValidator#getMvelParsingErrorMesage(DataWrapper, MVELTranslationException)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMvelParsingErrorMesage2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.validation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3239 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.validation.RuleFieldValidator ruleFieldValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldValidator ruleFieldValidator2 = new RuleFieldValidator();
    DataWrapper dw = new DataWrapper();

    // Act
    ruleFieldValidator2.getMvelParsingErrorMesage(dw, new MVELTranslationException(1, "An error occurred"));
  }

  /**
   * Test
   * {@link RuleFieldValidator#getMvelParsingErrorMesage(DataWrapper, MVELTranslationException)}.
   * <ul>
   *   <li>When {@link DataWrapper}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldValidator#getMvelParsingErrorMesage(DataWrapper, MVELTranslationException)}
   */
  @Test
  public void testGetMvelParsingErrorMesage_whenDataWrapper() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldValidator ruleFieldValidator = new RuleFieldValidator();
    DataWrapper dw = mock(DataWrapper.class);

    // Act and Assert
    assertEquals("Problem translating rule builder, error code 1: An error occurred",
        ruleFieldValidator.getMvelParsingErrorMesage(dw, new MVELTranslationException(1, "An error occurred")));
  }

  /**
   * Test {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}.
   * <p>
   * Method under test:
   * {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleValidation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.validation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3011 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.validation.RuleFieldValidator ruleFieldValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldValidator ruleFieldValidator2 = new RuleFieldValidator();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act
    ruleFieldValidator2.canHandleValidation(new PopulateValueRequest(true, fieldManager, property, metadata, returnType,
        "42", persistenceManager, dataFormatProvider, true, new Entity()));
  }

  /**
   * Test {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}
   */
  @Test
  public void testCanHandleValidation_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldValidator ruleFieldValidator = new RuleFieldValidator();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse(ruleFieldValidator.canHandleValidation(new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity())));
  }

  /**
   * Test {@link RuleFieldValidator#getOrder()}.
   * <p>
   * Method under test: {@link RuleFieldValidator#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2147482647, (new RuleFieldValidator()).getOrder());
  }
}
