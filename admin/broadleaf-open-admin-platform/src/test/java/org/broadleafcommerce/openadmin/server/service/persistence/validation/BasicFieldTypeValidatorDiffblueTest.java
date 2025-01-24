package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
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
public class BasicFieldTypeValidatorDiffblueTest {
  @Autowired
  private BasicFieldTypeValidator basicFieldTypeValidator;

  /**
   * Test
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(populateValueRequest.getDataFormatProvider()).thenReturn(new AdornedTargetListPersistenceModule());

    // Act
    basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(populateValueRequest).getDataFormatProvider();
    verify(populateValueRequest).getMetadata();
  }

  /**
   * Test
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.ID);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getRequestedValue())
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(populateValueRequest.getSetId()).thenReturn(true);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(populateValueRequest).getDataFormatProvider();
    verify(populateValueRequest, atLeast(1)).getMetadata();
    verify(populateValueRequest).getRequestedValue();
    verify(populateValueRequest).getSetId();
  }

  /**
   * Test
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getSimpleDateFormatter()).thenReturn(new SimpleDateFormat("42"));
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.DATE);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getRequestedValue()).thenReturn("42");
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    PropertyValidationResult actualValidateResult = basicFieldTypeValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(adornedTargetListPersistenceModule).getSimpleDateFormatter();
    verify(populateValueRequest, atLeast(1)).getDataFormatProvider();
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getRequestedValue();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.validation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass655 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.validation.BasicFieldTypeValidator basicFieldTypeValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator2 = new BasicFieldTypeValidator();
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
    basicFieldTypeValidator2.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then calls {@link PopulateValueRequest#getRequestedValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate_given42_thenCallsGetRequestedValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.ID);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getRequestedValue()).thenReturn("42");
    when(populateValueRequest.getSetId()).thenReturn(true);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    PropertyValidationResult actualValidateResult = basicFieldTypeValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(populateValueRequest).getDataFormatProvider();
    verify(populateValueRequest, atLeast(1)).getMetadata();
    verify(populateValueRequest).getRequestedValue();
    verify(populateValueRequest).getSetId();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) FieldType is
   * {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate_givenBasicFieldMetadataFieldTypeIsUnknown() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.UNKNOWN);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    PropertyValidationResult actualValidateResult = basicFieldTypeValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(populateValueRequest).getDataFormatProvider();
    verify(populateValueRequest).getMetadata();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) SecondaryType is
   * {@code UNKNOWN}.</li>
   *   <li>Then calls {@link PopulateValueRequest#getSetId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate_givenBasicFieldMetadataSecondaryTypeIsUnknown_thenCallsGetSetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setSecondaryType(SupportedFieldType.UNKNOWN);
    basicFieldMetadata.setFieldType(SupportedFieldType.ID);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getSetId()).thenReturn(true);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    PropertyValidationResult actualValidateResult = basicFieldTypeValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(populateValueRequest).getDataFormatProvider();
    verify(populateValueRequest, atLeast(1)).getMetadata();
    verify(populateValueRequest).getSetId();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link PopulateValueRequest} {@link PopulateValueRequest#getSetId()}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate_givenFalse_whenPopulateValueRequestGetSetIdReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.ID);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getSetId()).thenReturn(false);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    PropertyValidationResult actualValidateResult = basicFieldTypeValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(populateValueRequest).getDataFormatProvider();
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getSetId();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return ErrorMessages size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate_thenReturnErrorMessagesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getSimpleDateFormatter()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.DATE);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getRequestedValue()).thenReturn("42");
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    PropertyValidationResult actualValidateResult = basicFieldTypeValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(adornedTargetListPersistenceModule, atLeast(1)).getSimpleDateFormatter();
    verify(populateValueRequest, atLeast(1)).getDataFormatProvider();
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getRequestedValue();
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("Field must be a date of the format: yyyy/mm/dd", errorMessages.get(0));
    assertEquals("Field must be a date of the format: yyyy/mm/dd", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getSimpleDateFormatter())
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.DATE);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(adornedTargetListPersistenceModule).getSimpleDateFormatter();
    verify(populateValueRequest, atLeast(1)).getDataFormatProvider();
    verify(populateValueRequest).getMetadata();
  }

  /**
   * Test {@link BasicFieldTypeValidator#getOrder()}.
   * <p>
   * Method under test: {@link BasicFieldTypeValidator#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2147482647, (new BasicFieldTypeValidator()).getOrder());
  }
}
