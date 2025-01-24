package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddFieldMetadataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromFieldTypeRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromMappingDataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.hibernate.mapping.Property;
import org.hibernate.type.BigDecimalType;
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
public class DefaultFieldMetadataProviderDiffblueTest {
  @Autowired
  private DefaultFieldMetadataProvider defaultFieldMetadataProvider;

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadata(AddFieldMetadataRequest, Map)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadata(AddFieldMetadataRequest, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddMetadata() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass24295 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.DefaultFieldMetadataProvider defaultFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider2 = new DefaultFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddFieldMetadataRequest addMetadataRequest = new AddFieldMetadataRequest(null, parentClass, targetClass,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act
    defaultFieldMetadataProvider2.addMetadata(addMetadataRequest, new HashMap<>());
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#overrideExclusionsFromXml(OverrideViaXmlRequest, Map)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#overrideExclusionsFromXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOverrideExclusionsFromXml() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass25065 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.DefaultFieldMetadataProvider defaultFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider2 = new DefaultFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act
    defaultFieldMetadataProvider2.overrideExclusionsFromXml(overrideViaXmlRequest, new HashMap<>());
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddMetadataFromMappingData() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass24913 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.DefaultFieldMetadataProvider defaultFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider2 = new DefaultFieldMetadataProvider();
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType requestedEntityType = new BigDecimalType();
    AddMetadataFromMappingDataRequest addMetadataFromMappingDataRequest = new AddMetadataFromMappingDataRequest(
        componentProperties, SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, requestedEntityType,
        "Property Name", MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    // Act
    defaultFieldMetadataProvider2.addMetadataFromMappingData(addMetadataFromMappingDataRequest,
        new AdornedTargetCollectionMetadata());
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = mock(AddMetadataFromFieldTypeRequest.class);
    when(addMetadataFromFieldTypeRequest.getPrefix()).thenThrow(new IllegalArgumentException("foo"));
    when(addMetadataFromFieldTypeRequest.getRequestedPropertyName()).thenReturn("Requested Property Name");
    when(addMetadataFromFieldTypeRequest.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());
    Class<Boolean> forNameResult = Boolean.class;
    Mockito.<Class<?>>when(addMetadataFromFieldTypeRequest.getReturnedClass()).thenReturn(forNameResult);
    when(addMetadataFromFieldTypeRequest.getExplicitType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(addMetadataFromFieldTypeRequest.getPresentationAttribute()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(addMetadataFromFieldTypeRequest).getDynamicEntityDao();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getExplicitType();
    verify(addMetadataFromFieldTypeRequest).getPrefix();
    verify(addMetadataFromFieldTypeRequest).getPresentationAttribute();
    verify(addMetadataFromFieldTypeRequest).getRequestedPropertyName();
    verify(addMetadataFromFieldTypeRequest).getReturnedClass();
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = mock(AddMetadataFromFieldTypeRequest.class);
    when(addMetadataFromFieldTypeRequest.getPrefix()).thenReturn("Prefix");
    when(addMetadataFromFieldTypeRequest.getComponentProperties()).thenReturn(new ArrayList<>());
    when(addMetadataFromFieldTypeRequest.getRequestedPropertyName()).thenReturn("Requested Property Name");
    when(addMetadataFromFieldTypeRequest.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());
    when(addMetadataFromFieldTypeRequest.getType()).thenThrow(new IllegalArgumentException("foo"));
    Class<Boolean> forNameResult = Boolean.class;
    Mockito.<Class<?>>when(addMetadataFromFieldTypeRequest.getReturnedClass()).thenReturn(forNameResult);
    when(addMetadataFromFieldTypeRequest.getExplicitType()).thenReturn(null);
    when(addMetadataFromFieldTypeRequest.getPresentationAttribute()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(addMetadataFromFieldTypeRequest).getComponentProperties();
    verify(addMetadataFromFieldTypeRequest).getDynamicEntityDao();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getExplicitType();
    verify(addMetadataFromFieldTypeRequest).getPrefix();
    verify(addMetadataFromFieldTypeRequest).getPresentationAttribute();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getRequestedPropertyName();
    verify(addMetadataFromFieldTypeRequest).getReturnedClass();
    verify(addMetadataFromFieldTypeRequest).getType();
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = mock(AddMetadataFromFieldTypeRequest.class);
    when(addMetadataFromFieldTypeRequest.getIdProperty()).thenReturn("Requested Property Name");
    when(addMetadataFromFieldTypeRequest.getPrefix()).thenReturn("Prefix");
    when(addMetadataFromFieldTypeRequest.getComponentProperties()).thenReturn(new ArrayList<>());
    when(addMetadataFromFieldTypeRequest.getRequestedPropertyName()).thenReturn("Requested Property Name");
    when(addMetadataFromFieldTypeRequest.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());
    when(addMetadataFromFieldTypeRequest.getType()).thenThrow(new IllegalArgumentException("foo"));
    Class<Byte> forNameResult = Byte.class;
    Mockito.<Class<?>>when(addMetadataFromFieldTypeRequest.getReturnedClass()).thenReturn(forNameResult);
    when(addMetadataFromFieldTypeRequest.getExplicitType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(addMetadataFromFieldTypeRequest.getPresentationAttribute()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(addMetadataFromFieldTypeRequest).getComponentProperties();
    verify(addMetadataFromFieldTypeRequest).getDynamicEntityDao();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getExplicitType();
    verify(addMetadataFromFieldTypeRequest).getIdProperty();
    verify(addMetadataFromFieldTypeRequest).getPrefix();
    verify(addMetadataFromFieldTypeRequest).getPresentationAttribute();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getRequestedPropertyName();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getReturnedClass();
    verify(addMetadataFromFieldTypeRequest).getType();
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = mock(AddMetadataFromFieldTypeRequest.class);
    when(addMetadataFromFieldTypeRequest.getIdProperty()).thenReturn("Id Property");
    when(addMetadataFromFieldTypeRequest.getPrefix()).thenReturn("Prefix");
    when(addMetadataFromFieldTypeRequest.getComponentProperties()).thenReturn(new ArrayList<>());
    when(addMetadataFromFieldTypeRequest.getRequestedPropertyName()).thenReturn("Requested Property Name");
    when(addMetadataFromFieldTypeRequest.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());
    when(addMetadataFromFieldTypeRequest.getType()).thenThrow(new IllegalArgumentException("foo"));
    Class<Byte> forNameResult = Byte.class;
    Mockito.<Class<?>>when(addMetadataFromFieldTypeRequest.getReturnedClass()).thenReturn(forNameResult);
    when(addMetadataFromFieldTypeRequest.getExplicitType()).thenReturn(null);
    when(addMetadataFromFieldTypeRequest.getPresentationAttribute()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(addMetadataFromFieldTypeRequest).getComponentProperties();
    verify(addMetadataFromFieldTypeRequest).getDynamicEntityDao();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getExplicitType();
    verify(addMetadataFromFieldTypeRequest).getIdProperty();
    verify(addMetadataFromFieldTypeRequest).getPrefix();
    verify(addMetadataFromFieldTypeRequest).getPresentationAttribute();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getRequestedPropertyName();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getReturnedClass();
    verify(addMetadataFromFieldTypeRequest).getType();
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = mock(AddMetadataFromFieldTypeRequest.class);
    when(addMetadataFromFieldTypeRequest.getIdProperty()).thenThrow(new RuntimeException("foo"));
    when(addMetadataFromFieldTypeRequest.getRequestedPropertyName()).thenReturn("Requested Property Name");
    Class<Byte> forNameResult = Byte.class;
    Mockito.<Class<?>>when(addMetadataFromFieldTypeRequest.getReturnedClass()).thenReturn(forNameResult);
    when(addMetadataFromFieldTypeRequest.getExplicitType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(addMetadataFromFieldTypeRequest.getPresentationAttribute()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getExplicitType();
    verify(addMetadataFromFieldTypeRequest).getIdProperty();
    verify(addMetadataFromFieldTypeRequest).getPresentationAttribute();
    verify(addMetadataFromFieldTypeRequest).getRequestedPropertyName();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getReturnedClass();
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddMetadataFromFieldType6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass24617 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.DefaultFieldMetadataProvider defaultFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider2 = new DefaultFieldMetadataProvider();
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    Class<Object> returnedClass = Object.class;
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = new AddMetadataFromFieldTypeRequest(null,
        targetClass, foreignField, new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, componentProperties,
        "Id Property", "Prefix", "Requested Property Name", type, true, 1, presentationAttributes,
        presentationAttribute, SupportedFieldType.UNKNOWN, returnedClass, new DynamicEntityDaoImpl());

    // Act
    defaultFieldMetadataProvider2.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Given {@code BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType_givenBoolean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = mock(AddMetadataFromFieldTypeRequest.class);
    when(addMetadataFromFieldTypeRequest.getPrefix()).thenReturn("Prefix");
    when(addMetadataFromFieldTypeRequest.getComponentProperties()).thenReturn(new ArrayList<>());
    when(addMetadataFromFieldTypeRequest.getRequestedPropertyName()).thenReturn("Requested Property Name");
    when(addMetadataFromFieldTypeRequest.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());
    when(addMetadataFromFieldTypeRequest.getType()).thenThrow(new IllegalArgumentException("foo"));
    when(addMetadataFromFieldTypeRequest.getExplicitType()).thenReturn(SupportedFieldType.BOOLEAN);
    when(addMetadataFromFieldTypeRequest.getPresentationAttribute()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(addMetadataFromFieldTypeRequest).getComponentProperties();
    verify(addMetadataFromFieldTypeRequest).getDynamicEntityDao();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getExplicitType();
    verify(addMetadataFromFieldTypeRequest).getPrefix();
    verify(addMetadataFromFieldTypeRequest).getPresentationAttribute();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getRequestedPropertyName();
    verify(addMetadataFromFieldTypeRequest).getType();
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Given {@code DATE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType_givenDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = mock(AddMetadataFromFieldTypeRequest.class);
    when(addMetadataFromFieldTypeRequest.getIdProperty()).thenReturn("Id Property");
    when(addMetadataFromFieldTypeRequest.getPrefix()).thenReturn("Prefix");
    when(addMetadataFromFieldTypeRequest.getComponentProperties()).thenReturn(new ArrayList<>());
    when(addMetadataFromFieldTypeRequest.getRequestedPropertyName()).thenReturn("Requested Property Name");
    when(addMetadataFromFieldTypeRequest.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());
    when(addMetadataFromFieldTypeRequest.getType()).thenThrow(new IllegalArgumentException("foo"));
    Class<Byte> forNameResult = Byte.class;
    Mockito.<Class<?>>when(addMetadataFromFieldTypeRequest.getReturnedClass()).thenReturn(forNameResult);
    when(addMetadataFromFieldTypeRequest.getExplicitType()).thenReturn(SupportedFieldType.DATE);
    when(addMetadataFromFieldTypeRequest.getPresentationAttribute()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(addMetadataFromFieldTypeRequest).getComponentProperties();
    verify(addMetadataFromFieldTypeRequest).getDynamicEntityDao();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getExplicitType();
    verify(addMetadataFromFieldTypeRequest).getIdProperty();
    verify(addMetadataFromFieldTypeRequest).getPrefix();
    verify(addMetadataFromFieldTypeRequest).getPresentationAttribute();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getRequestedPropertyName();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getReturnedClass();
    verify(addMetadataFromFieldTypeRequest).getType();
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Given {@code ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType_givenId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = mock(AddMetadataFromFieldTypeRequest.class);
    when(addMetadataFromFieldTypeRequest.getPrefix()).thenReturn("Prefix");
    when(addMetadataFromFieldTypeRequest.getComponentProperties()).thenReturn(new ArrayList<>());
    when(addMetadataFromFieldTypeRequest.getRequestedPropertyName()).thenReturn("Requested Property Name");
    when(addMetadataFromFieldTypeRequest.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());
    when(addMetadataFromFieldTypeRequest.getType()).thenThrow(new IllegalArgumentException("foo"));
    when(addMetadataFromFieldTypeRequest.getExplicitType()).thenReturn(SupportedFieldType.ID);
    when(addMetadataFromFieldTypeRequest.getPresentationAttribute()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(addMetadataFromFieldTypeRequest).getComponentProperties();
    verify(addMetadataFromFieldTypeRequest).getDynamicEntityDao();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getExplicitType();
    verify(addMetadataFromFieldTypeRequest).getPrefix();
    verify(addMetadataFromFieldTypeRequest).getPresentationAttribute();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getRequestedPropertyName();
    verify(addMetadataFromFieldTypeRequest).getType();
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Given {@code ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType_givenId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = mock(AddMetadataFromFieldTypeRequest.class);
    when(addMetadataFromFieldTypeRequest.getPrefix()).thenThrow(new IllegalArgumentException("foo"));
    when(addMetadataFromFieldTypeRequest.getRequestedPropertyName()).thenReturn("Requested Property Name");
    when(addMetadataFromFieldTypeRequest.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());
    when(addMetadataFromFieldTypeRequest.getExplicitType()).thenReturn(SupportedFieldType.ID);
    when(addMetadataFromFieldTypeRequest.getPresentationAttribute()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(addMetadataFromFieldTypeRequest).getDynamicEntityDao();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getExplicitType();
    verify(addMetadataFromFieldTypeRequest).getPrefix();
    verify(addMetadataFromFieldTypeRequest).getPresentationAttribute();
    verify(addMetadataFromFieldTypeRequest).getRequestedPropertyName();
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Given {@code Id Property}.</li>
   *   <li>Then calls {@link AddMetadataFromFieldTypeRequest#getIdProperty()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType_givenIdProperty_thenCallsGetIdProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = mock(AddMetadataFromFieldTypeRequest.class);
    when(addMetadataFromFieldTypeRequest.getIdProperty()).thenReturn("Id Property");
    when(addMetadataFromFieldTypeRequest.getPrefix()).thenReturn("Prefix");
    when(addMetadataFromFieldTypeRequest.getComponentProperties()).thenReturn(new ArrayList<>());
    when(addMetadataFromFieldTypeRequest.getRequestedPropertyName()).thenReturn("Requested Property Name");
    when(addMetadataFromFieldTypeRequest.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());
    when(addMetadataFromFieldTypeRequest.getType()).thenThrow(new IllegalArgumentException("foo"));
    Class<Byte> forNameResult = Byte.class;
    Mockito.<Class<?>>when(addMetadataFromFieldTypeRequest.getReturnedClass()).thenReturn(forNameResult);
    when(addMetadataFromFieldTypeRequest.getExplicitType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(addMetadataFromFieldTypeRequest.getPresentationAttribute()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(addMetadataFromFieldTypeRequest).getComponentProperties();
    verify(addMetadataFromFieldTypeRequest).getDynamicEntityDao();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getExplicitType();
    verify(addMetadataFromFieldTypeRequest).getIdProperty();
    verify(addMetadataFromFieldTypeRequest).getPrefix();
    verify(addMetadataFromFieldTypeRequest).getPresentationAttribute();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getRequestedPropertyName();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getReturnedClass();
    verify(addMetadataFromFieldTypeRequest).getType();
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Given {@code java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType_givenJavaLangBoolean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = mock(AddMetadataFromFieldTypeRequest.class);
    when(addMetadataFromFieldTypeRequest.getPrefix()).thenReturn("Prefix");
    when(addMetadataFromFieldTypeRequest.getComponentProperties()).thenReturn(new ArrayList<>());
    when(addMetadataFromFieldTypeRequest.getRequestedPropertyName()).thenReturn("Requested Property Name");
    when(addMetadataFromFieldTypeRequest.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());
    when(addMetadataFromFieldTypeRequest.getType()).thenThrow(new IllegalArgumentException("foo"));
    Class<Boolean> forNameResult = Boolean.class;
    Mockito.<Class<?>>when(addMetadataFromFieldTypeRequest.getReturnedClass()).thenReturn(forNameResult);
    when(addMetadataFromFieldTypeRequest.getExplicitType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(addMetadataFromFieldTypeRequest.getPresentationAttribute()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(addMetadataFromFieldTypeRequest).getComponentProperties();
    verify(addMetadataFromFieldTypeRequest).getDynamicEntityDao();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getExplicitType();
    verify(addMetadataFromFieldTypeRequest).getPrefix();
    verify(addMetadataFromFieldTypeRequest).getPresentationAttribute();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getRequestedPropertyName();
    verify(addMetadataFromFieldTypeRequest).getReturnedClass();
    verify(addMetadataFromFieldTypeRequest).getType();
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then calls
   * {@link AddMetadataFromFieldTypeRequest#isPropertyForeignKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType_givenJavaLangObject_thenCallsIsPropertyForeignKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = mock(AddMetadataFromFieldTypeRequest.class);
    when(addMetadataFromFieldTypeRequest.isPropertyForeignKey()).thenThrow(new IllegalArgumentException("foo"));
    when(addMetadataFromFieldTypeRequest.getForeignField()).thenReturn(new ForeignKey());
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(addMetadataFromFieldTypeRequest.getReturnedClass()).thenReturn(forNameResult);
    when(addMetadataFromFieldTypeRequest.getExplicitType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(addMetadataFromFieldTypeRequest.getPresentationAttribute()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getExplicitType();
    verify(addMetadataFromFieldTypeRequest).getForeignField();
    verify(addMetadataFromFieldTypeRequest).getPresentationAttribute();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getReturnedClass();
    verify(addMetadataFromFieldTypeRequest).isPropertyForeignKey();
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Then calls
   * {@link AddMetadataFromFieldTypeRequest#getAdditionalForeignFields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType_thenCallsGetAdditionalForeignFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = mock(AddMetadataFromFieldTypeRequest.class);
    when(addMetadataFromFieldTypeRequest.getAdditionalForeignKeyIndexPosition())
        .thenThrow(new IllegalArgumentException("foo"));
    when(addMetadataFromFieldTypeRequest.getForeignField()).thenReturn(null);
    when(addMetadataFromFieldTypeRequest.getAdditionalForeignFields()).thenReturn(new ForeignKey[]{new ForeignKey()});
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(addMetadataFromFieldTypeRequest.getReturnedClass()).thenReturn(forNameResult);
    when(addMetadataFromFieldTypeRequest.getExplicitType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(addMetadataFromFieldTypeRequest.getPresentationAttribute()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(addMetadataFromFieldTypeRequest).getAdditionalForeignFields();
    verify(addMetadataFromFieldTypeRequest).getAdditionalForeignKeyIndexPosition();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getExplicitType();
    verify(addMetadataFromFieldTypeRequest).getForeignField();
    verify(addMetadataFromFieldTypeRequest).getPresentationAttribute();
    verify(addMetadataFromFieldTypeRequest, atLeast(1)).getReturnedClass();
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = mock(ForeignKey.class);
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    Class<Object> returnedClass = Object.class;
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = new AddMetadataFromFieldTypeRequest(null,
        targetClass, foreignField, new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, componentProperties,
        "Id Property", "Prefix", "Requested Property Name", type, true, 1, presentationAttributes, null,
        SupportedFieldType.UNKNOWN, returnedClass, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    Class<Object> targetClass = Object.class;
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    Class<Object> returnedClass = Object.class;
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = new AddMetadataFromFieldTypeRequest(null,
        targetClass, null, new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, componentProperties,
        "Id Property", "Prefix", "Requested Property Name", type, true, 1, presentationAttributes,
        presentationAttribute, SupportedFieldType.UNKNOWN, returnedClass, new DynamicEntityDaoImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = new DefaultFieldMetadataProvider();
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getDisplayValueProperty()).thenThrow(new RuntimeException("foo"));
    when(foreignField.getForeignKeyClass()).thenReturn("Foreign Key Class");
    Class<Object> targetClass = Object.class;
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    Class<Object> returnedClass = Object.class;
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = new AddMetadataFromFieldTypeRequest(null,
        targetClass, foreignField, new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, componentProperties,
        "Id Property", "Prefix", "Requested Property Name", type, true, 1, presentationAttributes,
        presentationAttribute, SupportedFieldType.UNKNOWN, returnedClass, new DynamicEntityDaoImpl());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>()));
    verify(foreignField).getDisplayValueProperty();
    verify(foreignField, atLeast(1)).getForeignKeyClass();
  }
}
