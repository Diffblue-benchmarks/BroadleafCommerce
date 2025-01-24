package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.rule.QuantityBasedRule;
import org.broadleafcommerce.common.rule.SimpleRule;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddFilterPropertiesRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.broadleafcommerce.openadmin.web.rulebuilder.DataDTOToMVELTranslator;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELToDataWrapperTranslator;
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
public class RuleFieldPersistenceProviderDiffblueTest {
  @Autowired
  private RuleFieldPersistenceProvider ruleFieldPersistenceProvider;

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandlePersistence() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1702 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
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
    ruleFieldPersistenceProvider2.canHandlePersistence(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandlePersistenceResult = ruleFieldPersistenceProvider.canHandlePersistence(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(populateValueRequest, atLeast(1)).getMetadata();
    assertFalse(actualCanHandlePersistenceResult);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleExtraction() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1435 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
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
    ruleFieldPersistenceProvider2.canHandleExtraction(extractValueRequest, new Property());
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandleExtractionResult = ruleFieldPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property());

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(extractValueRequest, atLeast(1)).getMetadata();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateValue() throws PersistenceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5156 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
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
    ruleFieldPersistenceProvider2.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue_thenReturnNotHandled() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    MetadataProviderResponse actualPopulateValueResult = ruleFieldPersistenceProvider
        .populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(populateValueRequest, atLeast(1)).getMetadata();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
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
    //   public class DiffblueFakeClass3091 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
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
    ruleFieldPersistenceProvider2.extractValue(extractValueRequest, new Property());
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenReturnNotHandled() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    MetadataProviderResponse actualExtractValueResult = ruleFieldPersistenceProvider.extractValue(extractValueRequest,
        new Property());

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(extractValueRequest, atLeast(1)).getMetadata();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFilterProperties() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3358 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(new Entity());

    // Act
    ruleFieldPersistenceProvider2.filterProperties(addFilterPropertiesRequest, new HashMap<>());
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given array of {@link Property} with
   * {@link Property#Property(String, String)} with {@code Name} and value is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties_givenArrayOfPropertyWithPropertyWithNameAndValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult = ruleFieldPersistenceProvider
        .filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given array of {@link Property} with
   * {@link Property#Property(String, String)} with name is {@code Json} and value
   * is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties_givenArrayOfPropertyWithPropertyWithNameIsJsonAndValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Json", "42")});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult = ruleFieldPersistenceProvider
        .filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties_givenPropertyGetNameReturnJson() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Json");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[]{property});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    HashMap<String, FieldMetadata> properties = new HashMap<>();
    properties.put("42", new AdornedTargetCollectionMetadata());

    // Act
    MetadataProviderResponse actualFilterPropertiesResult = ruleFieldPersistenceProvider
        .filterProperties(addFilterPropertiesRequest, properties);

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    verify(property, atLeast(1)).getName();
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code Name}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties_givenPropertyGetNameReturnName_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[]{property});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult = ruleFieldPersistenceProvider
        .filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    verify(property).getName();
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExtractSimpleRule() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2790 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    Property property = new Property();
    ObjectMapper mapper = new ObjectMapper();

    // Act
    ruleFieldPersistenceProvider2.extractSimpleRule(extractValueRequest, property, mapper,
        new MVELToDataWrapperTranslator());
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  public void testExtractSimpleRule_givenOne_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getRequestedValue()).thenReturn(1);
    Property property = new Property();
    ObjectMapper mapper = new ObjectMapper();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ruleFieldPersistenceProvider
        .extractSimpleRule(extractValueRequest, property, mapper, new MVELToDataWrapperTranslator()));
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}.
   * <ul>
   *   <li>Given {@code Requested Value}.</li>
   *   <li>Then calls {@link Property#setValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  public void testExtractSimpleRule_givenRequestedValue_thenCallsSetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getDisplayVal()).thenThrow(new PersistenceException("An error occurred"));
    when(extractValueRequest.getRequestedValue()).thenReturn("Requested Value");
    Property property = mock(Property.class);
    doNothing().when(property).setValue(Mockito.<String>any());
    ObjectMapper mapper = new ObjectMapper();

    // Act
    ruleFieldPersistenceProvider.extractSimpleRule(extractValueRequest, property, mapper,
        new MVELToDataWrapperTranslator());

    // Assert
    verify(property).setValue(eq("Requested Value"));
    verify(extractValueRequest).getDisplayVal();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}.
   * <ul>
   *   <li>Given {@code Requested Value}.</li>
   *   <li>Then {@link Property#Property()} RawValue is
   * {@code Requested Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  public void testExtractSimpleRule_givenRequestedValue_thenPropertyRawValueIsRequestedValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getDisplayVal()).thenThrow(new PersistenceException("An error occurred"));
    when(extractValueRequest.getRequestedValue()).thenReturn("Requested Value");
    Property property = new Property();
    ObjectMapper mapper = new ObjectMapper();

    // Act
    ruleFieldPersistenceProvider.extractSimpleRule(extractValueRequest, property, mapper,
        new MVELToDataWrapperTranslator());

    // Assert
    verify(extractValueRequest).getDisplayVal();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    assertEquals("Requested Value", property.getRawValue());
    assertEquals("Requested Value", property.getUnHtmlEncodedValue());
    assertEquals("Requested Value", property.getValue());
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExtractQuantityRule() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2488 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    ObjectMapper mapper = new ObjectMapper();

    // Act
    ruleFieldPersistenceProvider2.extractQuantityRule(extractValueRequest, mapper, new MVELToDataWrapperTranslator());
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  public void testExtractQuantityRule_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    ObjectMapper mapper = new ObjectMapper();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ruleFieldPersistenceProvider
        .extractQuantityRule(extractValueRequest, mapper, new MVELToDataWrapperTranslator()));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateSimpleRule() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4852 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
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
    ruleFieldPersistenceProvider2.populateSimpleRule(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then throw {@link PersistenceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateSimpleRule_thenThrowPersistenceException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenThrow(new PersistenceException("An error occurred"));
    when(property.getName()).thenReturn("Name");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act and Assert
    assertThrows(PersistenceException.class, () -> ruleFieldPersistenceProvider.populateSimpleRule(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd")));
    verify(property).getName();
    verify(property).getUnHtmlEncodedValue();
    verify(populateValueRequest, atLeast(1)).getProperty();
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#getRuleId(SimpleRule, EntityManager)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getRuleId(SimpleRule, EntityManager)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRuleId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3516 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
    SimpleRule rule = mock(SimpleRule.class);
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);

    // Act
    ruleFieldPersistenceProvider2.getRuleId(rule,
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#getContainedRuleId(SimpleRule, EntityManager)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getContainedRuleId(SimpleRule, EntityManager)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetContainedRuleId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3429 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
    SimpleRule simpleRule = mock(SimpleRule.class);
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);

    // Act
    ruleFieldPersistenceProvider2.getContainedRuleId(simpleRule,
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#getContainedRuleId(SimpleRule, EntityManager)}.
   * <ul>
   *   <li>When {@link SimpleRule}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getContainedRuleId(SimpleRule, EntityManager)}
   */
  @Test
  public void testGetContainedRuleId_whenSimpleRule_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new RuleFieldPersistenceProvider()).getContainedRuleId(mock(SimpleRule.class), null));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#transformId(Long, Object)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#transformId(Long, Object)}
   */
  @Test
  public void testTransformId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1L, (new RuleFieldPersistenceProvider()).transformId(1L, "Rule").longValue());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#transformId(Long, Object)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#transformId(Long, Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTransformId2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5764 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RuleFieldPersistenceProvider()).transformId(1L, "Rule");
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#extractParent(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExtractParent() throws IllegalAccessException, FieldNotAvailableException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2184 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
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
    ruleFieldPersistenceProvider2.extractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#extractParent(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then calls {@link PopulateValueRequest#getPersistenceManager()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testExtractParent_thenCallsGetPersistenceManager()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getPersistenceManager()).thenThrow(new PersistenceException("An error occurred"));
    when(populateValueRequest.getProperty()).thenReturn(new Property());

    // Act
    ruleFieldPersistenceProvider.extractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(populateValueRequest).getPersistenceManager();
    verify(populateValueRequest).getProperty();
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualRecursivelyExtractParentResult instanceof SimpleDateFormat);
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getCalendar() instanceof GregorianCalendar);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent2() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn(".");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property).getName();
    verify(populateValueRequest).getFieldManager();
    verify(populateValueRequest).getProperty();
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualRecursivelyExtractParentResult instanceof SimpleDateFormat);
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getCalendar() instanceof GregorianCalendar);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRecursivelyExtractParent3() throws IllegalAccessException, FieldNotAvailableException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5460 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
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
    ruleFieldPersistenceProvider2.recursivelyExtractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link FieldManager}
   * {@link FieldManager#getFieldValue(Object, String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent_givenFieldManagerGetFieldValueReturnNull()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn(".");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(null);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getFieldManager()).thenReturn(fieldManager);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property).getName();
    verify(fieldManager).getFieldValue(isA(Object.class), eq(""));
    verify(populateValueRequest).getFieldManager();
    verify(populateValueRequest).getProperty();
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualRecursivelyExtractParentResult instanceof SimpleDateFormat);
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getCalendar() instanceof GregorianCalendar);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code Name}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent_givenPropertyGetNameReturnName_thenCallsGetName()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property).getName();
    verify(populateValueRequest).getProperty();
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualRecursivelyExtractParentResult instanceof SimpleDateFormat);
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getCalendar() instanceof GregorianCalendar);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent_givenPropertyWithNameAndValueIs42()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(populateValueRequest).getProperty();
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualRecursivelyExtractParentResult instanceof SimpleDateFormat);
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getCalendar() instanceof GregorianCalendar);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code Field Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent_thenReturnFieldValue()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn(".");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getFieldManager()).thenReturn(fieldManager);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property).getName();
    verify(fieldManager).getFieldValue(isA(Object.class), eq(""));
    verify(populateValueRequest).getFieldManager();
    verify(populateValueRequest).getProperty();
    assertEquals("Field Value", actualRecursivelyExtractParentResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#parseParentProperty(String)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#parseParentProperty(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testParseParentProperty() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4229 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RuleFieldPersistenceProvider()).parseParentProperty("Property Name");
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#parseParentProperty(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#parseParentProperty(String)}
   */
  @Test
  public void testParseParentProperty_whenDot_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new RuleFieldPersistenceProvider()).parseParentProperty("."));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#isEmbeddable(Class)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#isEmbeddable(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsEmbeddable() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3908 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
    Class<Object> clazz = Object.class;

    // Act
    ruleFieldPersistenceProvider2.isEmbeddable(clazz);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#isEmbeddable(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#isEmbeddable(Class)}
   */
  @Test
  public void testIsEmbeddable_whenJavaLangObject_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(ruleFieldPersistenceProvider.isEmbeddable(clazz));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#populateQuantityRule(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#populateQuantityRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateQuantityRule() throws IllegalAccessException, FieldNotAvailableException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4548 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
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
    ruleFieldPersistenceProvider2.populateQuantityRule(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, SimpleRule, String, String)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, SimpleRule, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertSimpleRuleToJson() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2097 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
    MVELToDataWrapperTranslator translator = new MVELToDataWrapperTranslator();

    // Act
    ruleFieldPersistenceProvider2.convertSimpleRuleToJson(translator, new ObjectMapper(), mock(SimpleRule.class),
        "Json Prop", "Field Service");
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertQuantityBasedRuleToJson() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2006 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
    MVELToDataWrapperTranslator translator = new MVELToDataWrapperTranslator();
    ObjectMapper mapper = new ObjectMapper();

    // Act
    ruleFieldPersistenceProvider2.convertQuantityBasedRuleToJson(translator, mapper, new ArrayList<>(), "Json Prop",
        "Field Service");
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}.
   * <ul>
   *   <li>Then throw {@link PersistenceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  public void testConvertQuantityBasedRuleToJson_thenThrowPersistenceException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    MVELToDataWrapperTranslator translator = new MVELToDataWrapperTranslator();
    ObjectMapper mapper = new ObjectMapper();
    QuantityBasedRule quantityBasedRule = mock(QuantityBasedRule.class);
    when(quantityBasedRule.getMatchRule()).thenReturn("Match Rule");
    QuantityBasedRule quantityBasedRule2 = mock(QuantityBasedRule.class);
    when(quantityBasedRule2.getMatchRule()).thenReturn("Match Rule");
    QuantityBasedRule quantityBasedRule3 = mock(QuantityBasedRule.class);
    when(quantityBasedRule3.getMatchRule()).thenThrow(new PersistenceException("An error occurred"));

    ArrayList<QuantityBasedRule> quantityBasedRules = new ArrayList<>();
    quantityBasedRules.add(quantityBasedRule3);
    quantityBasedRules.add(quantityBasedRule2);
    quantityBasedRules.add(quantityBasedRule);

    // Act and Assert
    assertThrows(PersistenceException.class, () -> ruleFieldPersistenceProvider
        .convertQuantityBasedRuleToJson(translator, mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(quantityBasedRule3).getMatchRule();
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateQuantityRule() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5804 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);
    SessionDelegatorBaseImpl em = new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null));

    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();
    ArrayList<QuantityBasedRule> criteriaList = new ArrayList<>();
    Class<Object> memberType = Object.class;

    // Act
    ruleFieldPersistenceProvider2.updateQuantityRule(em, translator, "Entity Key", "Field Service", "42", criteriaList,
        memberType, "Parent", "Mapped By", new Property());
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#updateSimpleRule(PopulateValueRequest, String, boolean, SimpleRule)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#updateSimpleRule(PopulateValueRequest, String, boolean, SimpleRule)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateSimpleRule() throws IllegalAccessException, FieldNotAvailableException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6109 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act
    ruleFieldPersistenceProvider2.updateSimpleRule(new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), "Mvel", true,
        mock(SimpleRule.class));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#updateSimpleRule(PopulateValueRequest, String, boolean, SimpleRule)}.
   * <ul>
   *   <li>Then throw {@link PersistenceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#updateSimpleRule(PopulateValueRequest, String, boolean, SimpleRule)}
   */
  @Test
  public void testUpdateSimpleRule_thenThrowPersistenceException()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    SimpleRule rule = mock(SimpleRule.class);
    doThrow(new PersistenceException("An error occurred")).when(rule).setMatchRule(Mockito.<String>any());

    // Act and Assert
    assertThrows(PersistenceException.class,
        () -> ruleFieldPersistenceProvider.updateSimpleRule(populateValueRequest, "Mvel", true, rule));
    verify(rule).setMatchRule(eq("Mvel"));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetStartingValueType() throws ClassNotFoundException, IllegalAccessException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3602 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider2 = new RuleFieldPersistenceProvider();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act
    ruleFieldPersistenceProvider2.getStartingValueType(new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType_givenBasicFieldMetadata() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(new BasicFieldMetadata());
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(forNameResult);
    when(populateValueRequest.getProperty()).thenReturn(new Property("---", "42"));

    // Act
    Class<?> actualStartingValueType = ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getProperty();
    verify(populateValueRequest).getReturnType();
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code Name}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType_givenPropertyGetNameReturnName_thenCallsGetName()
      throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(forNameResult);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act
    Class<?> actualStartingValueType = ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(property).getName();
    verify(populateValueRequest).getProperty();
    verify(populateValueRequest).getReturnType();
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType_givenPropertyWithNameAndValueIs42()
      throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(forNameResult);
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act
    Class<?> actualStartingValueType = ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(populateValueRequest).getProperty();
    verify(populateValueRequest).getReturnType();
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType_thenReturnList() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getMapFieldValueClass()).thenReturn("java.util.List");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getProperty()).thenReturn(new Property("---", "42"));

    // Act
    Class<?> actualStartingValueType = ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(basicFieldMetadata).getMapFieldValueClass();
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getProperty();
    Class<List> expectedStartingValueType = List.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalAccessException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType_thenThrowIllegalAccessException()
      throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(null);
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act and Assert
    assertThrows(IllegalAccessException.class,
        () -> ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest));
    verify(populateValueRequest, atLeast(1)).getProperty();
    verify(populateValueRequest).getReturnType();
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalAccessException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType_thenThrowIllegalAccessException2()
      throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(null);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act and Assert
    assertThrows(IllegalAccessException.class,
        () -> ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest));
    verify(property, atLeast(1)).getName();
    verify(populateValueRequest, atLeast(1)).getProperty();
    verify(populateValueRequest).getReturnType();
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.RULE, (new RuleFieldPersistenceProvider()).getOrder());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOrder2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3515 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldPersistenceProvider ruleFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RuleFieldPersistenceProvider()).getOrder();
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#findContainedRuleIfApplicable(Object)}.
   * <ul>
   *   <li>When {@code Rule}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#findContainedRuleIfApplicable(Object)}
   */
  @Test
  public void testFindContainedRuleIfApplicable_whenRule_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RuleFieldPersistenceProvider.findContainedRuleIfApplicable("Rule"));
  }
}
