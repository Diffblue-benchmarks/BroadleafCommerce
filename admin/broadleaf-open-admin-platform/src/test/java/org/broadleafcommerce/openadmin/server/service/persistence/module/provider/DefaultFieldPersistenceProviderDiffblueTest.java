package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
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

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultFieldPersistenceProviderDiffblueTest {
  @Autowired
  private DefaultFieldPersistenceProvider defaultFieldPersistenceProvider;

  /**
   * Test
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    when(fieldManager.setFieldValue(Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    defaultFieldPersistenceProvider.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), isNull());
    verify(fieldManager).setFieldValue(isA(Object.class), isNull(), isA(Object.class));
  }

  /**
   * Test
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue2()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(" /");
    when(fieldManager.setFieldValue(Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    defaultFieldPersistenceProvider.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), isNull());
    verify(fieldManager).setFieldValue(isA(Object.class), isNull(), isA(Object.class));
    Property property2 = populateValueRequest.getProperty();
    assertEquals(" /", property2.getOriginalDisplayValue());
    assertEquals(" /", property2.getOriginalValue());
  }

  /**
   * Test
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue3()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(null);
    when(fieldManager.setFieldValue(Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    defaultFieldPersistenceProvider.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), isNull());
    verify(fieldManager).setFieldValue(isA(Object.class), isNull(), isA(Object.class));
    Property property2 = populateValueRequest.getProperty();
    assertNull(property2.getOriginalDisplayValue());
    assertNull(property2.getOriginalValue());
  }

  /**
   * Test
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue4()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    when(fieldManager.setFieldValue(Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getDefaultValue()).thenReturn("42");
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    defaultFieldPersistenceProvider.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(metadata).getDefaultValue();
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), isNull());
    verify(fieldManager).setFieldValue(isA(Object.class), isNull(), isA(Object.class));
    assertTrue(populateValueRequest.getProperty().getIsDirty());
  }

  /**
   * Test
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateValue5() throws PersistenceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2389 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.DefaultFieldPersistenceProvider defaultFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider2 = new DefaultFieldPersistenceProvider();
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
    defaultFieldPersistenceProvider2.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue_givenEmptyString()
      throws IllegalAccessException, InstantiationException, PersistenceException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    when(fieldManager.setFieldValue(Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getDefaultValue()).thenReturn("");
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    defaultFieldPersistenceProvider.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(metadata).getDefaultValue();
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), isNull());
    verify(fieldManager).setFieldValue(isA(Object.class), isNull(), isA(Object.class));
  }

  /**
   * Test
   * {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExtractValue() throws PersistenceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2122 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.DefaultFieldPersistenceProvider defaultFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider2 = new DefaultFieldPersistenceProvider();
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
    defaultFieldPersistenceProvider2.extractValue(extractValueRequest, new Property());
  }

  /**
   * Test
   * {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_givenNull_thenReturnHandled() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getRequestedValue()).thenReturn(null);
    Property property = new Property();

    // Act
    MetadataProviderResponse actualExtractValueResult = defaultFieldPersistenceProvider
        .extractValue(extractValueRequest, property);

    // Assert
    verify(extractValueRequest).getRequestedValue();
    assertNull(property.getDisplayValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertEquals(MetadataProviderResponse.HANDLED, actualExtractValueResult);
  }

  /**
   * Test
   * {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then calls {@link ExtractValueRequest#getDisplayVal()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenCallsGetDisplayVal() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getDisplayVal()).thenThrow(new PersistenceException("An error occurred"));
    when(extractValueRequest.getRequestedValue()).thenReturn("Requested Value");
    Property property = new Property();

    // Act
    defaultFieldPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(extractValueRequest).getDisplayVal();
    verify(extractValueRequest).getRequestedValue();
    assertNull(property.getDisplayValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
  }

  /**
   * Test
   * {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property()} DisplayValue is
   * {@code Display Val}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenPropertyDisplayValueIsDisplayVal() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider = new DefaultFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    Property property = new Property();

    // Act
    defaultFieldPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    assertEquals("Display Val", property.getDisplayValue());
    assertEquals("Requested Value", property.getRawValue());
    assertEquals("Requested Value", property.getUnHtmlEncodedValue());
    assertEquals("Requested Value", property.getValue());
  }
}
