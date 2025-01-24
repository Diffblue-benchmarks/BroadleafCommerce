package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection;
import org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes;
import org.broadleafcommerce.common.presentation.FieldValueConfiguration;
import org.broadleafcommerce.common.presentation.client.AddMethodType;
import org.broadleafcommerce.common.presentation.client.AdornedTargetAddMethodType;
import org.broadleafcommerce.common.presentation.client.LookupType;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.RuleBuilderDisplayType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.UnspecifiedBooleanType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverride;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.override.FieldMetadataOverride;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.FieldInfo;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddFieldMetadataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromFieldTypeRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaAnnotationRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.hibernate.mapping.Property;
import org.hibernate.type.BigDecimalType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
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
public class AdornedTargetCollectionFieldMetadataProviderDiffblueTest {
  @Autowired
  private AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleFieldForConfiguredMetadata(AddFieldMetadataRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleFieldForConfiguredMetadata(AddFieldMetadataRequest, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleFieldForConfiguredMetadata() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass17546 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider2 = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddFieldMetadataRequest addMetadataRequest = new AddFieldMetadataRequest(null, parentClass, targetClass,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act
    adornedTargetCollectionFieldMetadataProvider2.canHandleFieldForConfiguredMetadata(addMetadataRequest,
        new HashMap<>());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleFieldForTypeMetadata(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleFieldForTypeMetadata(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleFieldForTypeMetadata() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass17868 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider2 = new AdornedTargetCollectionFieldMetadataProvider();
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
    adornedTargetCollectionFieldMetadataProvider2.canHandleFieldForTypeMetadata(addMetadataFromFieldTypeRequest,
        new HashMap<>());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testCanHandleAnnotationOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertFalse(adornedTargetCollectionFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest,
        new HashMap<>()));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testCanHandleAnnotationOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertFalse(adornedTargetCollectionFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest,
        new HashMap<>()));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleAnnotationOverride3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass17222 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider2 = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act
    adornedTargetCollectionFieldMetadataProvider2.canHandleAnnotationOverride(overrideViaAnnotationRequest,
        new HashMap<>());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#addMetadata(AddFieldMetadataRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#addMetadata(AddFieldMetadataRequest, Map)}
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
    //   public class DiffblueFakeClass16414 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider2 = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddFieldMetadataRequest addMetadataRequest = new AddFieldMetadataRequest(null, parentClass, targetClass,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act
    adornedTargetCollectionFieldMetadataProvider2.addMetadata(addMetadataRequest, new HashMap<>());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, adornedTargetCollectionFieldMetadataProvider
        .overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, adornedTargetCollectionFieldMetadataProvider
        .overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOverrideViaAnnotation3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass18176 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider2 = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act
    adornedTargetCollectionFieldMetadataProvider2.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, mock(DynamicEntityDaoImpl.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        adornedTargetCollectionFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOverrideViaXml2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass18500 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider2 = new AdornedTargetCollectionFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act
    adornedTargetCollectionFieldMetadataProvider2.overrideViaXml(overrideViaXmlRequest, new HashMap<>());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <ul>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        adornedTargetCollectionFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddMetadataFromFieldType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16736 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider2 = new AdornedTargetCollectionFieldMetadataProvider();
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
    adornedTargetCollectionFieldMetadataProvider2.addMetadataFromFieldType(addMetadataFromFieldTypeRequest,
        new HashMap<>());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideAdornedTargetMergeMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("Property Type");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideAdornedTargetMergeMetadataResult = adornedTargetCollectionFieldMetadataProvider
        .overrideAdornedTargetMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeys());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getExcluded());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRequired());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSearchable());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUnique());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isProminent());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLength());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getPrecision());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getScale());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroup());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHelpText());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHint());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getManyToField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMediaField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTab());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTooltip());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValueClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLookupType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFetchType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getInspectType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getVisibility());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideAdornedTargetMergeMetadataResult.getSecondaryType());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideAdornedTargetMergeMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.stringArrayOverrideValue()).thenReturn(new String[]{"42"});
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("customCriteria");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideAdornedTargetMergeMetadataResult = adornedTargetCollectionFieldMetadataProvider
        .overrideAdornedTargetMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(adminPresentationMergeEntry).stringArrayOverrideValue();
    verify(merge).mergeEntries();
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeys());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getExcluded());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRequired());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSearchable());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUnique());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isProminent());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLength());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getPrecision());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getScale());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroup());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHelpText());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHint());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getManyToField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMediaField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTab());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTooltip());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValueClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLookupType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFetchType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getInspectType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getVisibility());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideAdornedTargetMergeMetadataResult.getSecondaryType());
    assertArrayEquals(new String[]{"42"}, actualOverrideAdornedTargetMergeMetadataResult.getCustomCriteria());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOverrideAdornedTargetMergeMetadata3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass18172 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdornedTargetCollectionFieldMetadataProvider())
        .overrideAdornedTargetMergeMetadata(mock(AdminPresentationMergeOverride.class));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return CurrencyCodeField is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#overrideAdornedTargetMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideAdornedTargetMergeMetadata_thenReturnCurrencyCodeFieldIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("currencyCodeField");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideAdornedTargetMergeMetadataResult = adornedTargetCollectionFieldMetadataProvider
        .overrideAdornedTargetMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideAdornedTargetMergeMetadataResult.getCurrencyCodeField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCustomCriteria());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridVisibleFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMaintainedAdornedTargetFields());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionFilterValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeys());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAllowNoValueEnumOption());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getCanLinkToExternalEntity());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnableTypeaheadLookup());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getExcluded());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForceFreeFormKeys());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForcePopulateChildProperties());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyCollection());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroupCollapsed());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getIsDerived());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLazyFetch());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getManualFetch());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionCanEditValues());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getReadOnly());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRequired());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRequiredOverride());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSearchable());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTranslatable());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUnique());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUseServerSideInspectionCache());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isDeleteEntityUponRemove());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isIgnoreAdornedProperties());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isLargeEntry());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isProminent());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.isSortAscending());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroupOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLength());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getPrecision());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getScale());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTabOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOrder());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAssociatedFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getDefaultValue());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getEnumerationClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldComponentRendererTemplate());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyDisplayValueProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getForeignKeyProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridFieldComponentRendererTemplate());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGroup());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHelpText());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getHint());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getJoinEntityClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeyClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getKeyPropertyFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLookupDisplayProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getManyToField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapFieldValueClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyOptionEntityValueField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMapKeyValueProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMediaField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionDisplayFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionListEntity());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getOptionValueFieldName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getParentObjectIdProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getParentObjectProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRuleIdentifier());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSelectizeVisibleField());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getShowIfProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSortProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTab());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTargetObjectIdProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTargetObjectProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneParentProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getToOneTargetProperty());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getTooltip());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValueClass());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValuePropertyFriendlyName());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getShowIfFieldEquals());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getValidationConfigurations());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddMethodType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAdornedTargetAddMethodType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getLookupType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getAddType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFetchType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getInspectType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getRemoveType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getUpdateType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getDisplayType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getExplicitFieldType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldComponentRenderer());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getFieldType());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getGridFieldComponentRenderer());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getSimpleValue());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getVisibility());
    assertNull(actualOverrideAdornedTargetMergeMetadataResult.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualOverrideAdornedTargetMergeMetadataResult.getSecondaryType());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  public void testConstructAdornedTargetCollectionMetadataOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new AdornedTargetCollectionFieldMetadataProvider())
        .constructAdornedTargetCollectionMetadataOverride(null));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  public void testConstructAdornedTargetCollectionMetadataOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.fetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.inspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.removeType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.updateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    AdminPresentationAdornedTargetCollection adornedTargetCollection = mock(
        AdminPresentationAdornedTargetCollection.class);
    when(adornedTargetCollection.lazyFetch()).thenReturn(true);
    when(adornedTargetCollection.manualFetch()).thenReturn(true);
    when(adornedTargetCollection.currencyCodeField()).thenReturn("GBP");
    when(adornedTargetCollection.showIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollection.showIfFieldEquals())
        .thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(adornedTargetCollection.addType()).thenReturn(AdornedTargetAddMethodType.LOOKUP);
    when(adornedTargetCollection.excluded()).thenReturn(true);
    when(adornedTargetCollection.ignoreAdornedProperties()).thenReturn(true);
    when(adornedTargetCollection.readOnly()).thenReturn(true);
    when(adornedTargetCollection.sortAscending()).thenReturn(true);
    when(adornedTargetCollection.useServerSideInspectionCache()).thenReturn(true);
    when(adornedTargetCollection.order()).thenReturn(1);
    when(adornedTargetCollection.tabOrder()).thenReturn(1);
    when(adornedTargetCollection.friendlyName()).thenReturn("Friendly Name");
    when(adornedTargetCollection.group()).thenReturn("Group");
    when(adornedTargetCollection.joinEntityClass()).thenReturn("Join Entity Class");
    when(adornedTargetCollection.parentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollection.parentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollection.securityLevel()).thenReturn("Security Level");
    when(adornedTargetCollection.selectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollection.sortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollection.tab()).thenReturn("Tab");
    when(adornedTargetCollection.targetObjectIdProperty()).thenReturn("Target Object Id Property");
    when(adornedTargetCollection.targetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollection.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(adornedTargetCollection.gridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollection.maintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollection.operationTypes()).thenReturn(adminPresentationOperationTypes);

    // Act
    FieldMetadataOverride actualConstructAdornedTargetCollectionMetadataOverrideResult = adornedTargetCollectionFieldMetadataProvider
        .constructAdornedTargetCollectionMetadataOverride(adornedTargetCollection);

    // Assert
    verify(adornedTargetCollection).addType();
    verify(adornedTargetCollection).currencyCodeField();
    verify(adornedTargetCollection).customCriteria();
    verify(adornedTargetCollection).excluded();
    verify(adornedTargetCollection).friendlyName();
    verify(adornedTargetCollection).gridVisibleFields();
    verify(adornedTargetCollection).group();
    verify(adornedTargetCollection).ignoreAdornedProperties();
    verify(adornedTargetCollection).joinEntityClass();
    verify(adornedTargetCollection).lazyFetch();
    verify(adornedTargetCollection).maintainedAdornedTargetFields();
    verify(adornedTargetCollection).manualFetch();
    verify(adornedTargetCollection, atLeast(1)).operationTypes();
    verify(adornedTargetCollection).order();
    verify(adornedTargetCollection).parentObjectIdProperty();
    verify(adornedTargetCollection).parentObjectProperty();
    verify(adornedTargetCollection).readOnly();
    verify(adornedTargetCollection).securityLevel();
    verify(adornedTargetCollection).selectizeVisibleField();
    verify(adornedTargetCollection, atLeast(1)).showIfFieldEquals();
    verify(adornedTargetCollection).showIfProperty();
    verify(adornedTargetCollection).sortAscending();
    verify(adornedTargetCollection).sortProperty();
    verify(adornedTargetCollection).tab();
    verify(adornedTargetCollection).tabOrder();
    verify(adornedTargetCollection).targetObjectIdProperty();
    verify(adornedTargetCollection).targetObjectProperty();
    verify(adornedTargetCollection).useServerSideInspectionCache();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    Map<String, List<String>> showIfFieldEquals = actualConstructAdornedTargetCollectionMetadataOverrideResult
        .getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals.size());
    List<String> getResult = showIfFieldEquals.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("42", getResult.get(0));
    assertEquals("Friendly Name", actualConstructAdornedTargetCollectionMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructAdornedTargetCollectionMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Group", actualConstructAdornedTargetCollectionMetadataOverrideResult.getGroup());
    assertEquals("Join Entity Class",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getJoinEntityClass());
    assertEquals("Parent Object Id Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getParentObjectIdProperty());
    assertEquals("Parent Object Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getParentObjectProperty());
    assertEquals("Security Level", actualConstructAdornedTargetCollectionMetadataOverrideResult.getSecurityLevel());
    assertEquals("Selectize Visible Field",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getSelectizeVisibleField());
    assertEquals("Show If Property", actualConstructAdornedTargetCollectionMetadataOverrideResult.getShowIfProperty());
    assertEquals("Sort Property", actualConstructAdornedTargetCollectionMetadataOverrideResult.getSortProperty());
    assertEquals("Tab", actualConstructAdornedTargetCollectionMetadataOverrideResult.getTab());
    assertEquals("Target Object Id Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getTargetObjectIdProperty());
    assertEquals("Target Object Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionFilterValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeys());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAllowNoValueEnumOption());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getCanLinkToExternalEntity());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnableTypeaheadLookup());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForceFreeFormKeys());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForcePopulateChildProperties());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGroupCollapsed());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionCanEditValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getRequired());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getRequiredOverride());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getSearchable());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getTranslatable());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getUnique());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.isDeleteEntityUponRemove());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.isLargeEntry());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.isProminent());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridOrder());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGroupOrder());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLength());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getPrecision());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getScale());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAddFriendlyName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAssociatedFieldName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getBroadleafEnumeration());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getColumnWidth());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getDefaultValue());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getHelpText());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getHint());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeyClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLookupDisplayProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getManyToField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyValueProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMediaField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionDisplayFieldName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionValueFieldName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getRuleIdentifier());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getToOneTargetProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getTooltip());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getValueClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getValuePropertyFriendlyName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getValidationConfigurations());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAddMethodType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLookupType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getDisplayType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getExplicitFieldType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getFieldComponentRenderer());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getFieldType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridFieldComponentRenderer());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getSimpleValue());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getVisibility());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructAdornedTargetCollectionMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructAdornedTargetCollectionMetadataOverrideResult.getOrder().intValue());
    assertEquals(AdornedTargetAddMethodType.LOOKUP,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getUpdateType());
    assertEquals(SupportedFieldType.INTEGER,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getSecondaryType());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLazyFetch());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getManualFetch());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.isIgnoreAdornedProperties());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.isSortAscending());
    assertArrayEquals(new String[]{"Custom Criteria"},
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getCustomCriteria());
    assertArrayEquals(new String[]{"Grid Visible Fields"},
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridVisibleFields());
    assertArrayEquals(new String[]{"Maintained Adorned Target Fields"},
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getMaintainedAdornedTargetFields());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  public void testConstructAdornedTargetCollectionMetadataOverride3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenThrow(new NoSuchBeanDefinitionException("Name"));
    AdminPresentationAdornedTargetCollection adornedTargetCollection = mock(
        AdminPresentationAdornedTargetCollection.class);
    when(adornedTargetCollection.excluded()).thenReturn(true);
    when(adornedTargetCollection.ignoreAdornedProperties()).thenReturn(true);
    when(adornedTargetCollection.readOnly()).thenReturn(true);
    when(adornedTargetCollection.sortAscending()).thenReturn(true);
    when(adornedTargetCollection.useServerSideInspectionCache()).thenReturn(true);
    when(adornedTargetCollection.order()).thenReturn(1);
    when(adornedTargetCollection.tabOrder()).thenReturn(1);
    when(adornedTargetCollection.friendlyName()).thenReturn("Friendly Name");
    when(adornedTargetCollection.group()).thenReturn("Group");
    when(adornedTargetCollection.joinEntityClass()).thenReturn("Join Entity Class");
    when(adornedTargetCollection.parentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollection.parentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollection.securityLevel()).thenReturn("Security Level");
    when(adornedTargetCollection.selectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollection.sortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollection.tab()).thenReturn("Tab");
    when(adornedTargetCollection.targetObjectIdProperty()).thenReturn("Target Object Id Property");
    when(adornedTargetCollection.targetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollection.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(adornedTargetCollection.gridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollection.maintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollection.operationTypes()).thenReturn(adminPresentationOperationTypes);

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class, () -> adornedTargetCollectionFieldMetadataProvider
        .constructAdornedTargetCollectionMetadataOverride(adornedTargetCollection));
    verify(adornedTargetCollection).customCriteria();
    verify(adornedTargetCollection).excluded();
    verify(adornedTargetCollection).friendlyName();
    verify(adornedTargetCollection).gridVisibleFields();
    verify(adornedTargetCollection).group();
    verify(adornedTargetCollection).ignoreAdornedProperties();
    verify(adornedTargetCollection).joinEntityClass();
    verify(adornedTargetCollection).maintainedAdornedTargetFields();
    verify(adornedTargetCollection).operationTypes();
    verify(adornedTargetCollection).order();
    verify(adornedTargetCollection).parentObjectIdProperty();
    verify(adornedTargetCollection).parentObjectProperty();
    verify(adornedTargetCollection).readOnly();
    verify(adornedTargetCollection).securityLevel();
    verify(adornedTargetCollection).selectizeVisibleField();
    verify(adornedTargetCollection).sortAscending();
    verify(adornedTargetCollection).sortProperty();
    verify(adornedTargetCollection).tab();
    verify(adornedTargetCollection).tabOrder();
    verify(adornedTargetCollection).targetObjectIdProperty();
    verify(adornedTargetCollection).targetObjectProperty();
    verify(adornedTargetCollection).useServerSideInspectionCache();
    verify(adminPresentationOperationTypes).addType();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  public void testConstructAdornedTargetCollectionMetadataOverride4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.fetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.inspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.removeType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.updateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    AdminPresentationAdornedTargetCollection adornedTargetCollection = mock(
        AdminPresentationAdornedTargetCollection.class);
    when(adornedTargetCollection.lazyFetch()).thenReturn(true);
    when(adornedTargetCollection.manualFetch()).thenReturn(true);
    when(adornedTargetCollection.currencyCodeField()).thenReturn("GBP");
    when(adornedTargetCollection.showIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollection.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{});
    when(adornedTargetCollection.addType()).thenReturn(AdornedTargetAddMethodType.LOOKUP);
    when(adornedTargetCollection.excluded()).thenReturn(true);
    when(adornedTargetCollection.ignoreAdornedProperties()).thenReturn(true);
    when(adornedTargetCollection.readOnly()).thenReturn(true);
    when(adornedTargetCollection.sortAscending()).thenReturn(true);
    when(adornedTargetCollection.useServerSideInspectionCache()).thenReturn(true);
    when(adornedTargetCollection.order()).thenReturn(1);
    when(adornedTargetCollection.tabOrder()).thenReturn(1);
    when(adornedTargetCollection.friendlyName()).thenReturn("Friendly Name");
    when(adornedTargetCollection.group()).thenReturn("Group");
    when(adornedTargetCollection.joinEntityClass()).thenReturn("Join Entity Class");
    when(adornedTargetCollection.parentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollection.parentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollection.securityLevel()).thenReturn("Security Level");
    when(adornedTargetCollection.selectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollection.sortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollection.tab()).thenReturn("Tab");
    when(adornedTargetCollection.targetObjectIdProperty()).thenReturn("Target Object Id Property");
    when(adornedTargetCollection.targetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollection.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(adornedTargetCollection.gridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollection.maintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollection.operationTypes()).thenReturn(adminPresentationOperationTypes);

    // Act
    FieldMetadataOverride actualConstructAdornedTargetCollectionMetadataOverrideResult = adornedTargetCollectionFieldMetadataProvider
        .constructAdornedTargetCollectionMetadataOverride(adornedTargetCollection);

    // Assert
    verify(adornedTargetCollection).addType();
    verify(adornedTargetCollection).currencyCodeField();
    verify(adornedTargetCollection).customCriteria();
    verify(adornedTargetCollection).excluded();
    verify(adornedTargetCollection).friendlyName();
    verify(adornedTargetCollection).gridVisibleFields();
    verify(adornedTargetCollection).group();
    verify(adornedTargetCollection).ignoreAdornedProperties();
    verify(adornedTargetCollection).joinEntityClass();
    verify(adornedTargetCollection).lazyFetch();
    verify(adornedTargetCollection).maintainedAdornedTargetFields();
    verify(adornedTargetCollection).manualFetch();
    verify(adornedTargetCollection, atLeast(1)).operationTypes();
    verify(adornedTargetCollection).order();
    verify(adornedTargetCollection).parentObjectIdProperty();
    verify(adornedTargetCollection).parentObjectProperty();
    verify(adornedTargetCollection).readOnly();
    verify(adornedTargetCollection).securityLevel();
    verify(adornedTargetCollection).selectizeVisibleField();
    verify(adornedTargetCollection).showIfFieldEquals();
    verify(adornedTargetCollection).showIfProperty();
    verify(adornedTargetCollection).sortAscending();
    verify(adornedTargetCollection).sortProperty();
    verify(adornedTargetCollection).tab();
    verify(adornedTargetCollection).tabOrder();
    verify(adornedTargetCollection).targetObjectIdProperty();
    verify(adornedTargetCollection).targetObjectProperty();
    verify(adornedTargetCollection).useServerSideInspectionCache();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    assertEquals("Friendly Name", actualConstructAdornedTargetCollectionMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructAdornedTargetCollectionMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Group", actualConstructAdornedTargetCollectionMetadataOverrideResult.getGroup());
    assertEquals("Join Entity Class",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getJoinEntityClass());
    assertEquals("Parent Object Id Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getParentObjectIdProperty());
    assertEquals("Parent Object Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getParentObjectProperty());
    assertEquals("Security Level", actualConstructAdornedTargetCollectionMetadataOverrideResult.getSecurityLevel());
    assertEquals("Selectize Visible Field",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getSelectizeVisibleField());
    assertEquals("Show If Property", actualConstructAdornedTargetCollectionMetadataOverrideResult.getShowIfProperty());
    assertEquals("Sort Property", actualConstructAdornedTargetCollectionMetadataOverrideResult.getSortProperty());
    assertEquals("Tab", actualConstructAdornedTargetCollectionMetadataOverrideResult.getTab());
    assertEquals("Target Object Id Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getTargetObjectIdProperty());
    assertEquals("Target Object Property",
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionFilterValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeys());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAllowNoValueEnumOption());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getCanLinkToExternalEntity());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnableTypeaheadLookup());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForceFreeFormKeys());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForcePopulateChildProperties());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGroupCollapsed());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionCanEditValues());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getRequired());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getRequiredOverride());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getSearchable());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getTranslatable());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getUnique());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.isDeleteEntityUponRemove());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.isLargeEntry());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.isProminent());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridOrder());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGroupOrder());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLength());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getPrecision());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getScale());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAddFriendlyName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAssociatedFieldName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getBroadleafEnumeration());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getColumnWidth());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getDefaultValue());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getHelpText());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getHint());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeyClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLookupDisplayProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getManyToField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMapKeyValueProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMediaField());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionDisplayFieldName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getOptionValueFieldName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getRuleIdentifier());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getToOneTargetProperty());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getTooltip());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getValueClass());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getValuePropertyFriendlyName());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getShowIfFieldEquals());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getValidationConfigurations());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getAddMethodType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLookupType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getDisplayType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getExplicitFieldType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getFieldComponentRenderer());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getFieldType());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridFieldComponentRenderer());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getSimpleValue());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getVisibility());
    assertNull(actualConstructAdornedTargetCollectionMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructAdornedTargetCollectionMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructAdornedTargetCollectionMetadataOverrideResult.getOrder().intValue());
    assertEquals(AdornedTargetAddMethodType.LOOKUP,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getUpdateType());
    assertEquals(SupportedFieldType.INTEGER,
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getSecondaryType());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getLazyFetch());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getManualFetch());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.isIgnoreAdornedProperties());
    assertTrue(actualConstructAdornedTargetCollectionMetadataOverrideResult.isSortAscending());
    assertArrayEquals(new String[]{"Custom Criteria"},
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getCustomCriteria());
    assertArrayEquals(new String[]{"Grid Visible Fields"},
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getGridVisibleFields());
    assertArrayEquals(new String[]{"Maintained Adorned Target Fields"},
        actualConstructAdornedTargetCollectionMetadataOverrideResult.getMaintainedAdornedTargetFields());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  public void testConstructAdornedTargetCollectionMetadataOverride5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    AdminPresentationOperationTypes adminPresentationOperationTypes = mock(AdminPresentationOperationTypes.class);
    when(adminPresentationOperationTypes.addType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.fetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.inspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.removeType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adminPresentationOperationTypes.updateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new NoSuchBeanDefinitionException("Name"));
    AdminPresentationAdornedTargetCollection adornedTargetCollection = mock(
        AdminPresentationAdornedTargetCollection.class);
    when(adornedTargetCollection.lazyFetch()).thenReturn(true);
    when(adornedTargetCollection.manualFetch()).thenReturn(true);
    when(adornedTargetCollection.currencyCodeField()).thenReturn("GBP");
    when(adornedTargetCollection.showIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollection.showIfFieldEquals())
        .thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)});
    when(adornedTargetCollection.addType()).thenReturn(AdornedTargetAddMethodType.LOOKUP);
    when(adornedTargetCollection.excluded()).thenReturn(true);
    when(adornedTargetCollection.ignoreAdornedProperties()).thenReturn(true);
    when(adornedTargetCollection.readOnly()).thenReturn(true);
    when(adornedTargetCollection.sortAscending()).thenReturn(true);
    when(adornedTargetCollection.useServerSideInspectionCache()).thenReturn(true);
    when(adornedTargetCollection.order()).thenReturn(1);
    when(adornedTargetCollection.tabOrder()).thenReturn(1);
    when(adornedTargetCollection.friendlyName()).thenReturn("Friendly Name");
    when(adornedTargetCollection.group()).thenReturn("Group");
    when(adornedTargetCollection.joinEntityClass()).thenReturn("Join Entity Class");
    when(adornedTargetCollection.parentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollection.parentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollection.securityLevel()).thenReturn("Security Level");
    when(adornedTargetCollection.selectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollection.sortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollection.tab()).thenReturn("Tab");
    when(adornedTargetCollection.targetObjectIdProperty()).thenReturn("Target Object Id Property");
    when(adornedTargetCollection.targetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollection.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(adornedTargetCollection.gridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollection.maintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollection.operationTypes()).thenReturn(adminPresentationOperationTypes);

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class, () -> adornedTargetCollectionFieldMetadataProvider
        .constructAdornedTargetCollectionMetadataOverride(adornedTargetCollection));
    verify(adornedTargetCollection).addType();
    verify(adornedTargetCollection).currencyCodeField();
    verify(adornedTargetCollection).customCriteria();
    verify(adornedTargetCollection).excluded();
    verify(adornedTargetCollection).friendlyName();
    verify(adornedTargetCollection).gridVisibleFields();
    verify(adornedTargetCollection).group();
    verify(adornedTargetCollection).ignoreAdornedProperties();
    verify(adornedTargetCollection).joinEntityClass();
    verify(adornedTargetCollection).lazyFetch();
    verify(adornedTargetCollection).maintainedAdornedTargetFields();
    verify(adornedTargetCollection).manualFetch();
    verify(adornedTargetCollection, atLeast(1)).operationTypes();
    verify(adornedTargetCollection).order();
    verify(adornedTargetCollection).parentObjectIdProperty();
    verify(adornedTargetCollection).parentObjectProperty();
    verify(adornedTargetCollection).readOnly();
    verify(adornedTargetCollection).securityLevel();
    verify(adornedTargetCollection).selectizeVisibleField();
    verify(adornedTargetCollection, atLeast(1)).showIfFieldEquals();
    verify(adornedTargetCollection).showIfProperty();
    verify(adornedTargetCollection).sortAscending();
    verify(adornedTargetCollection).sortProperty();
    verify(adornedTargetCollection).tab();
    verify(adornedTargetCollection).tabOrder();
    verify(adornedTargetCollection).targetObjectIdProperty();
    verify(adornedTargetCollection).targetObjectProperty();
    verify(adornedTargetCollection).useServerSideInspectionCache();
    verify(adminPresentationOperationTypes).addType();
    verify(adminPresentationOperationTypes).fetchType();
    verify(adminPresentationOperationTypes).inspectType();
    verify(adminPresentationOperationTypes).removeType();
    verify(adminPresentationOperationTypes).updateType();
    verify(fieldValueConfiguration).fieldName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#constructAdornedTargetCollectionMetadataOverride(AdminPresentationAdornedTargetCollection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConstructAdornedTargetCollectionMetadataOverride6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass18164 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdornedTargetCollectionFieldMetadataProvider())
        .constructAdornedTargetCollectionMetadataOverride(mock(AdminPresentationAdornedTargetCollection.class));
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass,
            targetClass, attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class)));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(null);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAdornedTargetCollectionMetadata14() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass17032 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider2 = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();

    FieldInfo field = new FieldInfo();
    field.setGenericType(new TypePlaceHolder(1));
    field.setManyToManyMappedBy("Many To Many Mapped By");
    field.setManyToManyTargetEntity("Many To Many Target Entity");
    field.setMapKey("Map Key");
    field.setName("Name");
    field.setOneToManyMappedBy("One To Many Mapped By");
    field.setOneToManyTargetEntity("One To Many Target Entity");

    FieldMetadataOverride adornedTargetCollectionMetadata = new FieldMetadataOverride();
    adornedTargetCollectionMetadata.setAddFriendlyName("Add Friendly Name");
    adornedTargetCollectionMetadata.setAddMethodType(AddMethodType.PERSIST);
    adornedTargetCollectionMetadata.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    adornedTargetCollectionMetadata.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    adornedTargetCollectionMetadata.setAllowNoValueEnumOption(true);
    adornedTargetCollectionMetadata.setAssociatedFieldName("Associated Field Name");
    adornedTargetCollectionMetadata.setBroadleafEnumeration("Broadleaf Enumeration");
    adornedTargetCollectionMetadata.setCanLinkToExternalEntity(true);
    adornedTargetCollectionMetadata.setColumnWidth("Column Width");
    adornedTargetCollectionMetadata.setCurrencyCodeField("GBP");
    adornedTargetCollectionMetadata.setCustomCriteria(new String[]{"Custom Criteria"});
    adornedTargetCollectionMetadata.setDeleteEntityUponRemove(true);
    adornedTargetCollectionMetadata.setDerived(true);
    adornedTargetCollectionMetadata.setDisplayType(RuleBuilderDisplayType.NORMAL);
    adornedTargetCollectionMetadata.setEnableTypeaheadLookup(true);
    adornedTargetCollectionMetadata.setEnumerationClass("Enumeration Class");
    adornedTargetCollectionMetadata.setEnumerationValues(new String[][]{new String[]{"42"}});
    adornedTargetCollectionMetadata.setExcluded(true);
    adornedTargetCollectionMetadata.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    adornedTargetCollectionMetadata.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    adornedTargetCollectionMetadata.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    adornedTargetCollectionMetadata.setFieldComponentRendererTemplate("Field Component Renderer Template");
    adornedTargetCollectionMetadata.setFieldType(SupportedFieldType.UNKNOWN);
    adornedTargetCollectionMetadata.setForceFreeFormKeys(true);
    adornedTargetCollectionMetadata.setForcePopulateChildProperties(true);
    adornedTargetCollectionMetadata.setForeignKeyClass("Foreign Key Class");
    adornedTargetCollectionMetadata.setForeignKeyCollection(true);
    adornedTargetCollectionMetadata.setForeignKeyDisplayValueProperty("42");
    adornedTargetCollectionMetadata.setForeignKeyProperty("Foreign Key Property");
    adornedTargetCollectionMetadata.setFriendlyName("Friendly Name");
    adornedTargetCollectionMetadata.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    adornedTargetCollectionMetadata.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    adornedTargetCollectionMetadata.setGridOrder(1);
    adornedTargetCollectionMetadata.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    adornedTargetCollectionMetadata.setGroup("Group");
    adornedTargetCollectionMetadata.setGroupCollapsed(true);
    adornedTargetCollectionMetadata.setGroupOrder(1);
    adornedTargetCollectionMetadata.setHelpText("Help Text");
    adornedTargetCollectionMetadata.setHideEnumerationIfEmpty(true);
    adornedTargetCollectionMetadata.setHint("Hint");
    adornedTargetCollectionMetadata.setIgnoreAdornedProperties(true);
    adornedTargetCollectionMetadata.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    adornedTargetCollectionMetadata.setJoinEntityClass("Join Entity Class");
    adornedTargetCollectionMetadata.setKeyClass("Key Class");
    adornedTargetCollectionMetadata.setKeyPropertyFriendlyName("Key Property Friendly Name");
    adornedTargetCollectionMetadata.setKeys(new String[][]{new String[]{"Keys"}});
    adornedTargetCollectionMetadata.setLargeEntry(true);
    adornedTargetCollectionMetadata.setLazyFetch(true);
    adornedTargetCollectionMetadata.setLength(3);
    adornedTargetCollectionMetadata.setLookupDisplayProperty("Lookup Display Property");
    adornedTargetCollectionMetadata.setLookupType(LookupType.STANDARD);
    adornedTargetCollectionMetadata.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    adornedTargetCollectionMetadata.setManualFetch(true);
    adornedTargetCollectionMetadata.setManyToField("Many To Field");
    adornedTargetCollectionMetadata.setMapFieldValueClass("42");
    adornedTargetCollectionMetadata.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    adornedTargetCollectionMetadata.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    adornedTargetCollectionMetadata.setMapKeyOptionEntityValueField("42");
    adornedTargetCollectionMetadata.setMapKeyValueProperty("42");
    adornedTargetCollectionMetadata.setMediaField("Media Field");
    adornedTargetCollectionMetadata.setMergedPropertyType(MergedPropertyType.PRIMARY);
    adornedTargetCollectionMetadata.setName("Name");
    adornedTargetCollectionMetadata.setOptionCanEditValues(true);
    adornedTargetCollectionMetadata.setOptionDisplayFieldName("Option Display Field Name");
    adornedTargetCollectionMetadata
        .setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    adornedTargetCollectionMetadata.setOptionListEntity("Option List Entity");
    adornedTargetCollectionMetadata.setOptionValueFieldName("42");
    adornedTargetCollectionMetadata.setOrder(1);
    adornedTargetCollectionMetadata.setParentObjectIdProperty("Parent Object Id Property");
    adornedTargetCollectionMetadata.setParentObjectProperty("Parent Object Property");
    adornedTargetCollectionMetadata.setPrecision(1);
    adornedTargetCollectionMetadata.setProminent(true);
    adornedTargetCollectionMetadata.setReadOnly(true);
    adornedTargetCollectionMetadata.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    adornedTargetCollectionMetadata.setRequired(true);
    adornedTargetCollectionMetadata.setRequiredOverride(true);
    adornedTargetCollectionMetadata.setRuleIdentifier("42");
    adornedTargetCollectionMetadata.setScale(1);
    adornedTargetCollectionMetadata.setSearchable(true);
    adornedTargetCollectionMetadata.setSecondaryType(SupportedFieldType.UNKNOWN);
    adornedTargetCollectionMetadata.setSecurityLevel("Security Level");
    adornedTargetCollectionMetadata.setSelectizeVisibleField("Selectize Visible Field");
    adornedTargetCollectionMetadata.setShowIfFieldEquals(new HashMap<>());
    adornedTargetCollectionMetadata.setShowIfProperty("Show If Property");
    adornedTargetCollectionMetadata.setSimpleValue(UnspecifiedBooleanType.TRUE);
    adornedTargetCollectionMetadata.setSortAscending(true);
    adornedTargetCollectionMetadata.setSortProperty("Sort Property");
    adornedTargetCollectionMetadata.setTab("Tab");
    adornedTargetCollectionMetadata.setTabOrder(1);
    adornedTargetCollectionMetadata.setTargetObjectIdProperty("Target Object Id Property");
    adornedTargetCollectionMetadata.setTargetObjectProperty("Target Object Property");
    adornedTargetCollectionMetadata.setToOneLookupCreatedViaAnnotation(true);
    adornedTargetCollectionMetadata.setToOneParentProperty("To One Parent Property");
    adornedTargetCollectionMetadata.setToOneTargetProperty("To One Target Property");
    adornedTargetCollectionMetadata.setTooltip("127.0.0.1");
    adornedTargetCollectionMetadata.setTranslatable(true);
    adornedTargetCollectionMetadata.setUnique(true);
    adornedTargetCollectionMetadata.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    adornedTargetCollectionMetadata.setUseServerSideInspectionCache(true);
    adornedTargetCollectionMetadata.setValidationConfigurations(new HashMap<>());
    adornedTargetCollectionMetadata.setValueClass("42");
    adornedTargetCollectionMetadata.setValuePropertyFriendlyName("42");
    adornedTargetCollectionMetadata.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act
    adornedTargetCollectionFieldMetadataProvider2.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, new DynamicEntityDaoImpl());
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass,
            targetClass, attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class)));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata_givenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(false);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadataOverride#getJoinEntityClass()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata_thenCallsGetJoinEntityClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <ul>
   *   <li>Then calls {@link FieldInfo#getOneToManyMappedBy()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata_thenCallsGetOneToManyMappedBy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    when(field.getOneToManyMappedBy()).thenReturn("One To Many Mapped By");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn(null);
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(parentClass, targetClass,
        attributes, field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
    verify(field, atLeast(1)).getOneToManyMappedBy();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link FieldMetadataOverride#getJoinEntityClass()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#buildAdornedTargetCollectionMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildAdornedTargetCollectionMetadata_whenNull_thenCallsGetJoinEntityClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride adornedTargetCollectionMetadata = mock(FieldMetadataOverride.class);
    when(adornedTargetCollectionMetadata.getJoinEntityClass()).thenThrow(new RuntimeException("foo"));
    when(adornedTargetCollectionMetadata.getReadOnly()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getParentObjectIdProperty()).thenReturn("Parent Object Id Property");
    when(adornedTargetCollectionMetadata.getParentObjectProperty()).thenReturn("Parent Object Property");
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField()).thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(adornedTargetCollectionMetadata.getSortProperty()).thenReturn("Sort Property");
    when(adornedTargetCollectionMetadata.getTargetObjectProperty()).thenReturn("Target Object Property");
    when(adornedTargetCollectionMetadata.getGridVisibleFields()).thenReturn(new String[]{"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[]{"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(adornedTargetCollectionMetadata.getAddType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getFetchType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getInspectType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getRemoveType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);
    when(adornedTargetCollectionMetadata.getUpdateType()).thenReturn(OperationType.NONDESTRUCTIVEREMOVE);

    // Act
    adornedTargetCollectionFieldMetadataProvider.buildAdornedTargetCollectionMetadata(null, targetClass, attributes,
        field, adornedTargetCollectionMetadata, mock(DynamicEntityDao.class));

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAddType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getFetchType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getInspectType();
    verify(adornedTargetCollectionMetadata).getJoinEntityClass();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectIdProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getParentObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getReadOnly();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getRemoveType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getSortProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTargetObjectProperty();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getUpdateType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#getOrder()}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.ADORNED_TARGET, (new AdornedTargetCollectionFieldMetadataProvider()).getOrder());
  }

  /**
   * Test {@link AdornedTargetCollectionFieldMetadataProvider#getOrder()}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#getOrder()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOrder2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass18168 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdornedTargetCollectionFieldMetadataProvider()).getOrder();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessShowIfFieldEqualsAnnotations() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass18530 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider2 = new AdornedTargetCollectionFieldMetadataProvider();

    FieldMetadataOverride override = new FieldMetadataOverride();
    override.setAddFriendlyName("Add Friendly Name");
    override.setAddMethodType(AddMethodType.PERSIST);
    override.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    override.setAllowNoValueEnumOption(true);
    override.setAssociatedFieldName("Associated Field Name");
    override.setBroadleafEnumeration("Broadleaf Enumeration");
    override.setCanLinkToExternalEntity(true);
    override.setColumnWidth("Column Width");
    override.setCurrencyCodeField("GBP");
    override.setCustomCriteria(new String[]{"Custom Criteria"});
    override.setDeleteEntityUponRemove(true);
    override.setDerived(true);
    override.setDisplayType(RuleBuilderDisplayType.NORMAL);
    override.setEnableTypeaheadLookup(true);
    override.setEnumerationClass("Enumeration Class");
    override.setEnumerationValues(new String[][]{new String[]{"42"}});
    override.setExcluded(true);
    override.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    override.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setFieldComponentRendererTemplate("Field Component Renderer Template");
    override.setFieldType(SupportedFieldType.UNKNOWN);
    override.setForceFreeFormKeys(true);
    override.setForcePopulateChildProperties(true);
    override.setForeignKeyClass("Foreign Key Class");
    override.setForeignKeyCollection(true);
    override.setForeignKeyDisplayValueProperty("42");
    override.setForeignKeyProperty("Foreign Key Property");
    override.setFriendlyName("Friendly Name");
    override.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    override.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    override.setGridOrder(1);
    override.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    override.setGroup("Group");
    override.setGroupCollapsed(true);
    override.setGroupOrder(1);
    override.setHelpText("Help Text");
    override.setHideEnumerationIfEmpty(true);
    override.setHint("Hint");
    override.setIgnoreAdornedProperties(true);
    override.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setJoinEntityClass("Join Entity Class");
    override.setKeyClass("Key Class");
    override.setKeyPropertyFriendlyName("Key Property Friendly Name");
    override.setKeys(new String[][]{new String[]{"Keys"}});
    override.setLargeEntry(true);
    override.setLazyFetch(true);
    override.setLength(3);
    override.setLookupDisplayProperty("Lookup Display Property");
    override.setLookupType(LookupType.STANDARD);
    override.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    override.setManualFetch(true);
    override.setManyToField("Many To Field");
    override.setMapFieldValueClass("42");
    override.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    override.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    override.setMapKeyOptionEntityValueField("42");
    override.setMapKeyValueProperty("42");
    override.setMediaField("Media Field");
    override.setMergedPropertyType(MergedPropertyType.PRIMARY);
    override.setName("Name");
    override.setOptionCanEditValues(true);
    override.setOptionDisplayFieldName("Option Display Field Name");
    override.setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    override.setOptionListEntity("Option List Entity");
    override.setOptionValueFieldName("42");
    override.setOrder(1);
    override.setParentObjectIdProperty("Parent Object Id Property");
    override.setParentObjectProperty("Parent Object Property");
    override.setPrecision(1);
    override.setProminent(true);
    override.setReadOnly(true);
    override.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setRequired(true);
    override.setRequiredOverride(true);
    override.setRuleIdentifier("42");
    override.setScale(1);
    override.setSearchable(true);
    override.setSecondaryType(SupportedFieldType.UNKNOWN);
    override.setSecurityLevel("Security Level");
    override.setSelectizeVisibleField("Selectize Visible Field");
    override.setShowIfFieldEquals(new HashMap<>());
    override.setShowIfProperty("Show If Property");
    override.setSimpleValue(UnspecifiedBooleanType.TRUE);
    override.setSortAscending(true);
    override.setSortProperty("Sort Property");
    override.setTab("Tab");
    override.setTabOrder(1);
    override.setTargetObjectIdProperty("Target Object Id Property");
    override.setTargetObjectProperty("Target Object Property");
    override.setToOneLookupCreatedViaAnnotation(true);
    override.setToOneParentProperty("To One Parent Property");
    override.setToOneTargetProperty("To One Target Property");
    override.setTooltip("127.0.0.1");
    override.setTranslatable(true);
    override.setUnique(true);
    override.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    override.setUseServerSideInspectionCache(true);
    override.setValidationConfigurations(new HashMap<>());
    override.setValueClass("42");
    override.setValuePropertyFriendlyName("42");
    override.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act
    adornedTargetCollectionFieldMetadataProvider2.processShowIfFieldEqualsAnnotations(
        new FieldValueConfiguration[]{mock(FieldValueConfiguration.class)}, override);
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations_givenRuntimeExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenThrow(new RuntimeException("foo"));

    // Act
    adornedTargetCollectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
        new FieldValueConfiguration[]{mock(FieldValueConfiguration.class)}, override);

    // Assert
    verify(override).getShowIfFieldEquals();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then calls {@link FieldValueConfiguration#fieldValues()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations_thenCallsFieldValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act
    adornedTargetCollectionFieldMetadataProvider
        .processShowIfFieldEqualsAnnotations(new FieldValueConfiguration[]{fieldValueConfiguration}, override);

    // Assert
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(override, atLeast(1)).getShowIfFieldEquals();
  }

  /**
   * Test
   * {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetCollectionFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations_thenThrowNoSuchBeanDefinitionException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new NoSuchBeanDefinitionException("Name"));
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> adornedTargetCollectionFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
            new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)}, override));
    verify(fieldValueConfiguration).fieldName();
    verify(override, atLeast(1)).getShowIfFieldEquals();
  }
}
