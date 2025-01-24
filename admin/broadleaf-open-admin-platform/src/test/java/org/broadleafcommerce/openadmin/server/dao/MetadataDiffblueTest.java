package org.broadleafcommerce.openadmin.server.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdvancedCollectionFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.DefaultFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.FieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromMappingDataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaAnnotationRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.Type;
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
public class MetadataDiffblueTest {
  @Autowired
  private Metadata metadata;

  /**
   * Test
   * {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}.
   * <p>
   * Method under test:
   * {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldMetadataForTargetClass() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass15429 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.Metadata metadata;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    Metadata metadata2 = new Metadata();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    metadata2.getFieldMetadataForTargetClass(parentClass, targetClass, new DynamicEntityDaoImpl(), "Prefix");
  }

  /**
   * Test
   * {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}.
   * <ul>
   *   <li>Then calls {@link DynamicEntityDao#getAllFields(Class)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}
   */
  @Test
  public void testGetFieldMetadataForTargetClass_thenCallsGetAllFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(new AdvancedCollectionFieldMetadataProvider());
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getAllFields(Mockito.<Class<Object>>any())).thenReturn(new Field[]{null});

    // Act
    Map<String, FieldMetadata> actualFieldMetadataForTargetClass = metadata.getFieldMetadataForTargetClass(parentClass,
        targetClass, dynamicEntityDao, "Prefix");

    // Assert
    verify(dynamicEntityDao).getAllFields(isA(Class.class));
    assertTrue(actualFieldMetadataForTargetClass.isEmpty());
  }

  /**
   * Test
   * {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}.
   * <ul>
   *   <li>When {@link DynamicEntityDaoImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}
   */
  @Test
  public void testGetFieldMetadataForTargetClass_whenDynamicEntityDaoImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Metadata metadata = new Metadata();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertTrue(metadata.getFieldMetadataForTargetClass(parentClass, targetClass, new DynamicEntityDaoImpl(), "Prefix")
        .isEmpty());
  }

  /**
   * Test {@link Metadata#getBaseTabAndGroupMetadata(Class[])}.
   * <p>
   * Method under test: {@link Metadata#getBaseTabAndGroupMetadata(Class[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetBaseTabAndGroupMetadata() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14541 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.Metadata metadata;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    Metadata metadata2 = new Metadata();
    Class<Object> forNameResult = Object.class;

    // Act
    metadata2.getBaseTabAndGroupMetadata(new Class[]{forNameResult});
  }

  /**
   * Test {@link Metadata#getBaseTabAndGroupMetadata(Class[])}.
   * <ul>
   *   <li>When empty array of {@link Class}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metadata#getBaseTabAndGroupMetadata(Class[])}
   */
  @Test
  public void testGetBaseTabAndGroupMetadata_whenEmptyArrayOfClass_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new Metadata()).getBaseTabAndGroupMetadata(new Class[]{}).isEmpty());
  }

  /**
   * Test {@link Metadata#applyTabAndGroupMetadataOverrides(Class[], Map)}.
   * <p>
   * Method under test:
   * {@link Metadata#applyTabAndGroupMetadataOverrides(Class[], Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyTabAndGroupMetadataOverrides() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass13953 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.Metadata metadata;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    Metadata metadata2 = new Metadata();
    Class<Object> forNameResult = Object.class;

    // Act
    metadata2.applyTabAndGroupMetadataOverrides(new Class[]{forNameResult}, new HashMap<>());
  }

  /**
   * Test
   * {@link Metadata#buildAdditionalTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <p>
   * Method under test:
   * {@link Metadata#buildAdditionalTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAdditionalTabAndGroupMetadataFromCmdProperties() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14226 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.Metadata metadata;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    Metadata metadata2 = new Metadata();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    metadata2.buildAdditionalTabAndGroupMetadataFromCmdProperties(cmd, new HashMap<>());
  }

  /**
   * Test
   * {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}
   */
  @Test
  public void testOverrideMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(new DefaultFieldMetadataProvider());
    Class<Object> forNameResult = Object.class;
    PropertyBuilder propertyBuilder = mock(PropertyBuilder.class);
    when(propertyBuilder.execute(Mockito.<Boolean>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, FieldMetadata> actualOverrideMetadataResult = metadata.overrideMetadata(new Class[]{forNameResult},
        propertyBuilder, "Prefix", true, "Dr Jane Doe", "Configuration Key", new DynamicEntityDaoImpl());

    // Assert
    verify(propertyBuilder).execute(isNull());
    assertTrue(actualOverrideMetadataResult.isEmpty());
  }

  /**
   * Test
   * {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOverrideMetadata2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass15755 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.Metadata metadata;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    Metadata metadata2 = new Metadata();
    Class<Object> forNameResult = Object.class;
    PropertyBuilder propertyBuilder = mock(PropertyBuilder.class);

    // Act
    metadata2.overrideMetadata(new Class[]{forNameResult}, propertyBuilder, "Prefix", true, "Dr Jane Doe",
        "Configuration Key", new DynamicEntityDaoImpl());
  }

  /**
   * Test
   * {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}.
   * <ul>
   *   <li>Then calls
   * {@link BasicFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}
   */
  @Test
  public void testOverrideMetadata_thenCallsOverrideViaAnnotation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = mock(DefaultFieldMetadataProvider.class);
    when(defaultFieldMetadataProvider.overrideViaAnnotation(Mockito.<OverrideViaAnnotationRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    when(defaultFieldMetadataProvider.overrideViaXml(Mockito.<OverrideViaXmlRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    doNothing().when(defaultFieldMetadataProvider)
        .overrideExclusionsFromXml(Mockito.<OverrideViaXmlRequest>any(), Mockito.<Map<String, FieldMetadata>>any());

    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(defaultFieldMetadataProvider);
    Class<Object> forNameResult = Object.class;
    PropertyBuilder propertyBuilder = mock(PropertyBuilder.class);
    when(propertyBuilder.execute(Mockito.<Boolean>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, FieldMetadata> actualOverrideMetadataResult = metadata.overrideMetadata(new Class[]{forNameResult},
        propertyBuilder, "Prefix", true, "Dr Jane Doe", "Configuration Key", new DynamicEntityDaoImpl());

    // Assert
    verify(propertyBuilder).execute(isNull());
    verify(defaultFieldMetadataProvider).overrideViaAnnotation(isA(OverrideViaAnnotationRequest.class), isA(Map.class));
    verify(defaultFieldMetadataProvider).overrideViaXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    verify(defaultFieldMetadataProvider).overrideExclusionsFromXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    assertTrue(actualOverrideMetadataResult.isEmpty());
  }

  /**
   * Test
   * {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   * with {@code prefix}, {@code propertyName}, {@code componentProperties},
   * {@code type}, {@code entityType}, {@code targetClass},
   * {@code presentationAttribute}, {@code mergedPropertyType},
   * {@code dynamicEntityDao}.
   * <p>
   * Method under test:
   * {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   */
  @Test
  public void testGetFieldMetadataWithPrefixPropertyNameComponentPropertiesTypeEntityTypeTargetClassPresentationAttributeMergedPropertyTypeDynamicEntityDao() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = mock(DefaultFieldMetadataProvider.class);
    when(defaultFieldMetadataProvider.addMetadataFromMappingData(Mockito.<AddMetadataFromMappingDataRequest>any(),
        Mockito.<FieldMetadata>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    fieldMetadataProviders.add(defaultFieldMetadataProvider);

    Metadata metadata = new Metadata();
    metadata.setFieldMetadataProviders(fieldMetadataProviders);
    ArrayList<org.hibernate.mapping.Property> componentProperties = new ArrayList<>();
    BigDecimalType entityType = new BigDecimalType();
    Class<Object> targetClass = Object.class;

    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    presentationAttribute.setTargetClass(null);

    // Act
    FieldMetadata actualFieldMetadata = metadata.getFieldMetadata("Prefix", "Property Name", componentProperties,
        SupportedFieldType.UNKNOWN, entityType, targetClass, presentationAttribute, MergedPropertyType.PRIMARY,
        new DynamicEntityDaoImpl());

    // Assert
    verify(defaultFieldMetadataProvider).addMetadataFromMappingData(isA(AddMetadataFromMappingDataRequest.class),
        isA(FieldMetadata.class));
    assertEquals("Property Name", presentationAttribute.getFieldName());
    assertEquals("java.lang.Object", presentationAttribute.getInheritedFromType());
    assertEquals("java.lang.Object", presentationAttribute.getTargetClass());
    assertSame(presentationAttribute, actualFieldMetadata);
  }

  /**
   * Test
   * {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   * with {@code prefix}, {@code propertyName}, {@code componentProperties},
   * {@code type}, {@code entityType}, {@code targetClass},
   * {@code presentationAttribute}, {@code mergedPropertyType},
   * {@code dynamicEntityDao}.
   * <p>
   * Method under test:
   * {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   */
  @Test
  public void testGetFieldMetadataWithPrefixPropertyNameComponentPropertiesTypeEntityTypeTargetClassPresentationAttributeMergedPropertyTypeDynamicEntityDao2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = mock(DefaultFieldMetadataProvider.class);
    when(defaultFieldMetadataProvider.addMetadataFromMappingData(Mockito.<AddMetadataFromMappingDataRequest>any(),
        Mockito.<FieldMetadata>any())).thenReturn(MetadataProviderResponse.HANDLED_BREAK);

    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    fieldMetadataProviders.add(defaultFieldMetadataProvider);

    Metadata metadata = new Metadata();
    metadata.setFieldMetadataProviders(fieldMetadataProviders);
    ArrayList<org.hibernate.mapping.Property> componentProperties = new ArrayList<>();
    BigDecimalType entityType = new BigDecimalType();
    Class<Object> targetClass = Object.class;

    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    presentationAttribute.setTargetClass(null);

    // Act
    FieldMetadata actualFieldMetadata = metadata.getFieldMetadata("Prefix", "Property Name", componentProperties,
        SupportedFieldType.UNKNOWN, entityType, targetClass, presentationAttribute, MergedPropertyType.PRIMARY,
        new DynamicEntityDaoImpl());

    // Assert
    verify(defaultFieldMetadataProvider).addMetadataFromMappingData(isA(AddMetadataFromMappingDataRequest.class),
        isA(FieldMetadata.class));
    assertEquals("Property Name", presentationAttribute.getFieldName());
    assertEquals("java.lang.Object", presentationAttribute.getInheritedFromType());
    assertEquals("java.lang.Object", presentationAttribute.getTargetClass());
    assertSame(presentationAttribute, actualFieldMetadata);
  }

  /**
   * Test
   * {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   * with {@code prefix}, {@code propertyName}, {@code componentProperties},
   * {@code type}, {@code entityType}, {@code targetClass},
   * {@code presentationAttribute}, {@code mergedPropertyType},
   * {@code dynamicEntityDao}.
   * <p>
   * Method under test:
   * {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldMetadataWithPrefixPropertyNameComponentPropertiesTypeEntityTypeTargetClassPresentationAttributeMergedPropertyTypeDynamicEntityDao3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass15117 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.Metadata metadata;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    Metadata metadata2 = new Metadata();
    ArrayList<org.hibernate.mapping.Property> componentProperties = new ArrayList<>();
    BigDecimalType entityType = new BigDecimalType();
    Class<Object> targetClass = Object.class;
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();

    // Act
    metadata2.getFieldMetadata("Prefix", "Property Name", componentProperties, SupportedFieldType.UNKNOWN, entityType,
        targetClass, presentationAttribute, MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());
  }

  /**
   * Test
   * {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   * with {@code prefix}, {@code propertyName}, {@code componentProperties},
   * {@code type}, {@code secondaryType}, {@code entityType}, {@code targetClass},
   * {@code presentationAttribute}, {@code mergedPropertyType},
   * {@code dynamicEntityDao}.
   * <p>
   * Method under test:
   * {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   */
  @Test
  public void testGetFieldMetadataWithPrefixPropertyNameComponentPropertiesTypeSecondaryTypeEntityTypeTargetClassPresentationAttributeMergedPropertyTypeDynamicEntityDao() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = mock(DefaultFieldMetadataProvider.class);
    when(defaultFieldMetadataProvider.addMetadataFromMappingData(Mockito.<AddMetadataFromMappingDataRequest>any(),
        Mockito.<FieldMetadata>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    fieldMetadataProviders.add(defaultFieldMetadataProvider);

    Metadata metadata = new Metadata();
    metadata.setFieldMetadataProviders(fieldMetadataProviders);
    ArrayList<org.hibernate.mapping.Property> componentProperties = new ArrayList<>();
    BigDecimalType entityType = new BigDecimalType();
    Class<Object> targetClass = Object.class;

    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    presentationAttribute.setTargetClass(null);

    // Act
    FieldMetadata actualFieldMetadata = metadata.getFieldMetadata("Prefix", "Property Name", componentProperties,
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, entityType, targetClass, presentationAttribute,
        MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    // Assert
    verify(defaultFieldMetadataProvider).addMetadataFromMappingData(isA(AddMetadataFromMappingDataRequest.class),
        isA(FieldMetadata.class));
    assertEquals("Property Name", presentationAttribute.getFieldName());
    assertEquals("java.lang.Object", presentationAttribute.getInheritedFromType());
    assertEquals("java.lang.Object", presentationAttribute.getTargetClass());
    assertSame(presentationAttribute, actualFieldMetadata);
  }

  /**
   * Test
   * {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   * with {@code prefix}, {@code propertyName}, {@code componentProperties},
   * {@code type}, {@code secondaryType}, {@code entityType}, {@code targetClass},
   * {@code presentationAttribute}, {@code mergedPropertyType},
   * {@code dynamicEntityDao}.
   * <p>
   * Method under test:
   * {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   */
  @Test
  public void testGetFieldMetadataWithPrefixPropertyNameComponentPropertiesTypeSecondaryTypeEntityTypeTargetClassPresentationAttributeMergedPropertyTypeDynamicEntityDao2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = mock(DefaultFieldMetadataProvider.class);
    when(defaultFieldMetadataProvider.addMetadataFromMappingData(Mockito.<AddMetadataFromMappingDataRequest>any(),
        Mockito.<FieldMetadata>any())).thenReturn(MetadataProviderResponse.HANDLED_BREAK);

    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    fieldMetadataProviders.add(defaultFieldMetadataProvider);

    Metadata metadata = new Metadata();
    metadata.setFieldMetadataProviders(fieldMetadataProviders);
    ArrayList<org.hibernate.mapping.Property> componentProperties = new ArrayList<>();
    BigDecimalType entityType = new BigDecimalType();
    Class<Object> targetClass = Object.class;

    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    presentationAttribute.setTargetClass(null);

    // Act
    FieldMetadata actualFieldMetadata = metadata.getFieldMetadata("Prefix", "Property Name", componentProperties,
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, entityType, targetClass, presentationAttribute,
        MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    // Assert
    verify(defaultFieldMetadataProvider).addMetadataFromMappingData(isA(AddMetadataFromMappingDataRequest.class),
        isA(FieldMetadata.class));
    assertEquals("Property Name", presentationAttribute.getFieldName());
    assertEquals("java.lang.Object", presentationAttribute.getInheritedFromType());
    assertEquals("java.lang.Object", presentationAttribute.getTargetClass());
    assertSame(presentationAttribute, actualFieldMetadata);
  }

  /**
   * Test
   * {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   * with {@code prefix}, {@code propertyName}, {@code componentProperties},
   * {@code type}, {@code secondaryType}, {@code entityType}, {@code targetClass},
   * {@code presentationAttribute}, {@code mergedPropertyType},
   * {@code dynamicEntityDao}.
   * <p>
   * Method under test:
   * {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldMetadataWithPrefixPropertyNameComponentPropertiesTypeSecondaryTypeEntityTypeTargetClassPresentationAttributeMergedPropertyTypeDynamicEntityDao3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14807 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.Metadata metadata;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    Metadata metadata2 = new Metadata();
    ArrayList<org.hibernate.mapping.Property> componentProperties = new ArrayList<>();
    BigDecimalType entityType = new BigDecimalType();
    Class<Object> targetClass = Object.class;
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();

    // Act
    metadata2.getFieldMetadata("Prefix", "Property Name", componentProperties, SupportedFieldType.UNKNOWN,
        SupportedFieldType.UNKNOWN, entityType, targetClass, presentationAttribute, MergedPropertyType.PRIMARY,
        new DynamicEntityDaoImpl());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Metadata#setDefaultFieldMetadataProvider(FieldMetadataProvider)}
   *   <li>{@link Metadata#setFieldMetadataProviders(List)}
   *   <li>{@link Metadata#getDefaultFieldMetadataProvider()}
   *   <li>{@link Metadata#getFieldMetadataProviders()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Metadata metadata = new Metadata();
    AdornedTargetCollectionFieldMetadataProvider defaultFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act
    metadata.setDefaultFieldMetadataProvider(defaultFieldMetadataProvider);
    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    metadata.setFieldMetadataProviders(fieldMetadataProviders);
    FieldMetadataProvider actualDefaultFieldMetadataProvider = metadata.getDefaultFieldMetadataProvider();
    List<FieldMetadataProvider> actualFieldMetadataProviders = metadata.getFieldMetadataProviders();

    // Assert that nothing has changed
    assertTrue(actualDefaultFieldMetadataProvider instanceof AdornedTargetCollectionFieldMetadataProvider);
    assertTrue(actualFieldMetadataProviders.isEmpty());
    assertSame(fieldMetadataProviders, actualFieldMetadataProviders);
    assertSame(defaultFieldMetadataProvider, actualDefaultFieldMetadataProvider);
  }
}
