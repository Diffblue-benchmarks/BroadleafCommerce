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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.AdminPresentation;
import org.broadleafcommerce.common.presentation.AdminPresentationDataDrivenEnumeration;
import org.broadleafcommerce.common.presentation.AdminPresentationToOneLookup;
import org.broadleafcommerce.common.presentation.ConfigurationItem;
import org.broadleafcommerce.common.presentation.FieldValueConfiguration;
import org.broadleafcommerce.common.presentation.OptionFilterParam;
import org.broadleafcommerce.common.presentation.OptionFilterParamType;
import org.broadleafcommerce.common.presentation.RequiredOverride;
import org.broadleafcommerce.common.presentation.ValidationConfiguration;
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
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.override.FieldMetadataOverride;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.FieldInfo;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddFieldMetadataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaAnnotationRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
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
public class BasicFieldMetadataProviderDiffblueTest {
  @Autowired
  private BasicFieldMetadataProvider basicFieldMetadataProvider;

  /**
   * Test
   * {@link BasicFieldMetadataProvider#canHandleFieldForConfiguredMetadata(AddFieldMetadataRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#canHandleFieldForConfiguredMetadata(AddFieldMetadataRequest, Map)}
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
    //   public class DiffblueFakeClass21278 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider basicFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider2 = new BasicFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddFieldMetadataRequest addMetadataRequest = new AddFieldMetadataRequest(null, parentClass, targetClass,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act
    basicFieldMetadataProvider2.canHandleFieldForConfiguredMetadata(addMetadataRequest, new HashMap<>());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testCanHandleAnnotationOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertFalse(basicFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testCanHandleAnnotationOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertFalse(basicFieldMetadataProvider.canHandleAnnotationOverride(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#canHandleAnnotationOverride(OverrideViaAnnotationRequest, Map)}
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
    //   public class DiffblueFakeClass20954 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider basicFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider2 = new BasicFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act
    basicFieldMetadataProvider2.canHandleAnnotationOverride(overrideViaAnnotationRequest, new HashMap<>());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#addMetadata(AddFieldMetadataRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#addMetadata(AddFieldMetadataRequest, Map)}
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
    //   public class DiffblueFakeClass20348 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider basicFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider2 = new BasicFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddFieldMetadataRequest addMetadataRequest = new AddFieldMetadataRequest(null, parentClass, targetClass,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act
    basicFieldMetadataProvider2.addMetadata(addMetadataRequest, new HashMap<>());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicFieldMetadataProvider.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicFieldMetadataProvider.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
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
    //   public class DiffblueFakeClass21610 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider basicFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider2 = new BasicFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act
    basicFieldMetadataProvider2.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, mock(DynamicEntityDaoImpl.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        basicFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
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
    //   public class DiffblueFakeClass21934 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider basicFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider2 = new BasicFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act
    basicFieldMetadataProvider2.overrideViaXml(overrideViaXmlRequest, new HashMap<>());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <ul>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        basicFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("Property Type");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOverrideMergeMetadata2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass21605 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider basicFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicFieldMetadataProvider()).overrideMergeMetadata(mock(AdminPresentationMergeOverride.class));
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return AddFriendlyName is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata_thenReturnAddFriendlyNameIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("addFriendlyName");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return BroadleafEnumeration is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata_thenReturnBroadleafEnumerationIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("broadleafEnumeration");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return ColumnWidth is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata_thenReturnColumnWidthIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("columnWidth");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return FriendlyName is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata_thenReturnFriendlyNameIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("friendlyName");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return Group is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata_thenReturnGroupIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("group");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return not HideEnumerationIfEmpty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata_thenReturnNotHideEnumerationIfEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("hideEnumerationIfEmpty");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getTab());
    assertFalse(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return SecurityLevel is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata_thenReturnSecurityLevelIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("securityLevel");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getSecurityLevel());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getTab());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}.
   * <ul>
   *   <li>Then return Tab is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#overrideMergeMetadata(AdminPresentationMergeOverride)}
   */
  @Test
  public void testOverrideMergeMetadata_thenReturnTabIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.overrideValue()).thenReturn("42");
    when(adminPresentationMergeEntry.propertyType()).thenReturn("tab");
    AdminPresentationMergeOverride merge = mock(AdminPresentationMergeOverride.class);
    when(merge.mergeEntries()).thenReturn(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Act
    FieldMetadataOverride actualOverrideMergeMetadataResult = basicFieldMetadataProvider.overrideMergeMetadata(merge);

    // Assert
    verify(adminPresentationMergeEntry).overrideValue();
    verify(adminPresentationMergeEntry).propertyType();
    verify(merge).mergeEntries();
    assertEquals("42", actualOverrideMergeMetadataResult.getTab());
    assertNull(actualOverrideMergeMetadataResult.getHideEnumerationIfEmpty());
    assertNull(actualOverrideMergeMetadataResult.getAddFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getBroadleafEnumeration());
    assertNull(actualOverrideMergeMetadataResult.getColumnWidth());
    assertNull(actualOverrideMergeMetadataResult.getFriendlyName());
    assertNull(actualOverrideMergeMetadataResult.getGroup());
    assertNull(actualOverrideMergeMetadataResult.getSecurityLevel());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration));
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems())
        .thenReturn(new ConfigurationItem[]{configurationItem, mock(ConfigurationItem.class)});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot,
        mock(AdminPresentationToOneLookup.class), mock(AdminPresentationDataDrivenEnumeration.class)));
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(configurationItem).itemName();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName())
        .thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals())
        .thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot,
        mock(AdminPresentationToOneLookup.class), mock(AdminPresentationDataDrivenEnumeration.class)));
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).translatable();
    verify(annot).visibility();
    verify(fieldValueConfiguration).fieldName();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.broadleafEnumeration()).thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot, null, null));
    verify(annot).broadleafEnumeration();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConstructBasicMetadataOverride5() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass21600 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider basicFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicFieldMetadataProvider()).constructBasicMetadataOverride(mock(AdminPresentation.class),
        mock(AdminPresentationToOneLookup.class), mock(AdminPresentationDataDrivenEnumeration.class));
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <ul>
   *   <li>Given empty array of {@link FieldValueConfiguration}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride_givenEmptyArrayOfFieldValueConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems())
        .thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.validationConfigurations())
        .thenReturn(new ValidationConfiguration[]{validationConfiguration, mock(ValidationConfiguration.class)});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot,
        mock(AdminPresentationToOneLookup.class), mock(AdminPresentationDataDrivenEnumeration.class)));
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <ul>
   *   <li>Given {@code IGNORED}.</li>
   *   <li>Then return RequiredOverride is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride_givenIgnored_thenReturnRequiredOverrideIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(RequiredOverride.IGNORED);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenReturn("Param");
    when(optionFilterParam.value()).thenReturn("42");
    when(optionFilterParam.paramType()).thenReturn(OptionFilterParamType.BOOLEAN);
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionValueFieldName()).thenReturn("42");
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dataDrivenEnumeration.optionListEntity()).thenReturn(forNameResult);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act
    FieldMetadataOverride actualConstructBasicMetadataOverrideResult = basicFieldMetadataProvider
        .constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration);

    // Assert
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(dataDrivenEnumeration).optionListEntity();
    verify(dataDrivenEnumeration).optionValueFieldName();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(optionFilterParam).paramType();
    verify(optionFilterParam).value();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
    Map<String, List<Map<String, String>>> validationConfigurations = actualConstructBasicMetadataOverrideResult
        .getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("Validation Implementation");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(1, getResult2.size());
    assertEquals("42", getResult2.get("Item Name"));
    assertNull(actualConstructBasicMetadataOverrideResult.getRequiredOverride());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <ul>
   *   <li>Then return not RequiredOverride.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride_thenReturnNotRequiredOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(null);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenReturn("Param");
    when(optionFilterParam.value()).thenReturn("42");
    when(optionFilterParam.paramType()).thenReturn(OptionFilterParamType.BOOLEAN);
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionValueFieldName()).thenReturn("42");
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dataDrivenEnumeration.optionListEntity()).thenReturn(forNameResult);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act
    FieldMetadataOverride actualConstructBasicMetadataOverrideResult = basicFieldMetadataProvider
        .constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration);

    // Assert
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(dataDrivenEnumeration).optionListEntity();
    verify(dataDrivenEnumeration).optionValueFieldName();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(optionFilterParam).paramType();
    verify(optionFilterParam).value();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
    Map<String, List<Map<String, String>>> validationConfigurations = actualConstructBasicMetadataOverrideResult
        .getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("Validation Implementation");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(1, getResult2.size());
    assertEquals("42", getResult2.get("Item Name"));
    assertFalse(actualConstructBasicMetadataOverrideResult.getRequiredOverride());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <ul>
   *   <li>Then return RequiredOverride.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride_thenReturnRequiredOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{validationConfiguration});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenReturn("Param");
    when(optionFilterParam.value()).thenReturn("42");
    when(optionFilterParam.paramType()).thenReturn(OptionFilterParamType.BOOLEAN);
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionValueFieldName()).thenReturn("42");
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dataDrivenEnumeration.optionListEntity()).thenReturn(forNameResult);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act
    FieldMetadataOverride actualConstructBasicMetadataOverrideResult = basicFieldMetadataProvider
        .constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration);

    // Assert
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(dataDrivenEnumeration).optionListEntity();
    verify(dataDrivenEnumeration).optionValueFieldName();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(optionFilterParam).paramType();
    verify(optionFilterParam).value();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
    Map<String, List<Map<String, String>>> validationConfigurations = actualConstructBasicMetadataOverrideResult
        .getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("Validation Implementation");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(1, getResult2.size());
    assertEquals("42", getResult2.get("Item Name"));
    assertTrue(actualConstructBasicMetadataOverrideResult.getRequiredOverride());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <ul>
   *   <li>Then third element return {@link OptionFilterParamType}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride_thenThirdElementReturnOptionFilterParamType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.excluded()).thenReturn(true);
    when(annot.tooltip()).thenReturn("127.0.0.1");
    when(annot.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);
    when(annot.validationConfigurations()).thenReturn(new ValidationConfiguration[]{});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");
    AdminPresentationToOneLookup toOneLookup = mock(AdminPresentationToOneLookup.class);
    when(toOneLookup.enableTypeaheadLookup()).thenReturn(true);
    when(toOneLookup.forcePopulateChildProperties()).thenReturn(true);
    when(toOneLookup.useServerSideInspectionCache()).thenReturn(true);
    when(toOneLookup.lookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(toOneLookup.customCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(toOneLookup.lookupType()).thenReturn(LookupType.STANDARD);
    OptionFilterParam optionFilterParam = mock(OptionFilterParam.class);
    when(optionFilterParam.param()).thenReturn("Param");
    when(optionFilterParam.value()).thenReturn("42");
    when(optionFilterParam.paramType()).thenReturn(OptionFilterParamType.BOOLEAN);
    AdminPresentationDataDrivenEnumeration dataDrivenEnumeration = mock(AdminPresentationDataDrivenEnumeration.class);
    when(dataDrivenEnumeration.optionValueFieldName()).thenReturn("42");
    when(dataDrivenEnumeration.optionCanEditValues()).thenReturn(true);
    when(dataDrivenEnumeration.optionHideIfEmpty()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dataDrivenEnumeration.optionListEntity()).thenReturn(forNameResult);
    when(dataDrivenEnumeration.optionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(dataDrivenEnumeration.optionFilterParams()).thenReturn(new OptionFilterParam[]{optionFilterParam});

    // Act
    FieldMetadataOverride actualConstructBasicMetadataOverrideResult = basicFieldMetadataProvider
        .constructBasicMetadataOverride(annot, toOneLookup, dataDrivenEnumeration);

    // Assert
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).excluded();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).requiredOverride();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).tooltip();
    verify(annot).translatable();
    verify(annot).validationConfigurations();
    verify(annot).visibility();
    verify(dataDrivenEnumeration).optionCanEditValues();
    verify(dataDrivenEnumeration).optionDisplayFieldName();
    verify(dataDrivenEnumeration, atLeast(1)).optionFilterParams();
    verify(dataDrivenEnumeration).optionHideIfEmpty();
    verify(dataDrivenEnumeration).optionListEntity();
    verify(dataDrivenEnumeration).optionValueFieldName();
    verify(toOneLookup).customCriteria();
    verify(toOneLookup).enableTypeaheadLookup();
    verify(toOneLookup).forcePopulateChildProperties();
    verify(toOneLookup).lookupDisplayProperty();
    verify(toOneLookup).lookupType();
    verify(toOneLookup).useServerSideInspectionCache();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(optionFilterParam).param();
    verify(optionFilterParam).paramType();
    verify(optionFilterParam).value();
    Serializable[][] optionFilterValues = actualConstructBasicMetadataOverrideResult.getOptionFilterValues();
    Serializable[] serializableArray = optionFilterValues[0];
    Serializable serializable = serializableArray[2];
    assertTrue(serializable instanceof OptionFilterParamType);
    Map<String, List<String>> showIfFieldEquals = actualConstructBasicMetadataOverrideResult.getShowIfFieldEquals();
    assertEquals(1, showIfFieldEquals.size());
    List<String> getResult = showIfFieldEquals.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("42", getResult.get(0));
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getDefaultValue());
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getOptionValueFieldName());
    assertEquals("42", actualConstructBasicMetadataOverrideResult.getRuleIdentifier());
    assertEquals("42", serializableArray[1]);
    assertEquals("Add Friendly Name", actualConstructBasicMetadataOverrideResult.getAddFriendlyName());
    assertEquals("Associated Field Name", actualConstructBasicMetadataOverrideResult.getAssociatedFieldName());
    assertEquals("Broadleaf Enumeration", actualConstructBasicMetadataOverrideResult.getBroadleafEnumeration());
    assertEquals("Column Width", actualConstructBasicMetadataOverrideResult.getColumnWidth());
    assertEquals("Field Component Renderer Template",
        actualConstructBasicMetadataOverrideResult.getFieldComponentRendererTemplate());
    assertEquals("Friendly Name", actualConstructBasicMetadataOverrideResult.getFriendlyName());
    assertEquals("GBP", actualConstructBasicMetadataOverrideResult.getCurrencyCodeField());
    assertEquals("Grid Field Component Renderer Template",
        actualConstructBasicMetadataOverrideResult.getGridFieldComponentRendererTemplate());
    assertEquals("Group", actualConstructBasicMetadataOverrideResult.getGroup());
    assertEquals("Help Text", actualConstructBasicMetadataOverrideResult.getHelpText());
    assertEquals("Hint", actualConstructBasicMetadataOverrideResult.getHint());
    assertEquals("Lookup Display Property", actualConstructBasicMetadataOverrideResult.getLookupDisplayProperty());
    assertEquals("Option Display Field Name", actualConstructBasicMetadataOverrideResult.getOptionDisplayFieldName());
    assertEquals("Param", serializableArray[0]);
    assertEquals("Security Level", actualConstructBasicMetadataOverrideResult.getSecurityLevel());
    assertEquals("Show If Property", actualConstructBasicMetadataOverrideResult.getShowIfProperty());
    assertEquals("Tab", actualConstructBasicMetadataOverrideResult.getTab());
    assertEquals("java.lang.Object", actualConstructBasicMetadataOverrideResult.getOptionListEntity());
    assertNull(actualConstructBasicMetadataOverrideResult.getGridVisibleFields());
    assertNull(actualConstructBasicMetadataOverrideResult.getMaintainedAdornedTargetFields());
    assertNull(actualConstructBasicMetadataOverrideResult.getEnumerationValues());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeys());
    assertNull(actualConstructBasicMetadataOverrideResult.getForceFreeFormKeys());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyCollection());
    assertNull(actualConstructBasicMetadataOverrideResult.getIsDerived());
    assertNull(actualConstructBasicMetadataOverrideResult.getLazyFetch());
    assertNull(actualConstructBasicMetadataOverrideResult.getManualFetch());
    assertNull(actualConstructBasicMetadataOverrideResult.getRequired());
    assertNull(actualConstructBasicMetadataOverrideResult.getSearchable());
    assertNull(actualConstructBasicMetadataOverrideResult.getUnique());
    assertNull(actualConstructBasicMetadataOverrideResult.isDeleteEntityUponRemove());
    assertNull(actualConstructBasicMetadataOverrideResult.isIgnoreAdornedProperties());
    assertNull(actualConstructBasicMetadataOverrideResult.isSortAscending());
    assertNull(actualConstructBasicMetadataOverrideResult.getLength());
    assertNull(actualConstructBasicMetadataOverrideResult.getPrecision());
    assertNull(actualConstructBasicMetadataOverrideResult.getScale());
    assertNull(actualConstructBasicMetadataOverrideResult.getEnumerationClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyDisplayValueProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getForeignKeyProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getJoinEntityClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeyClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getKeyPropertyFriendlyName());
    assertNull(actualConstructBasicMetadataOverrideResult.getManyToField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapFieldValueClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityDisplayField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyOptionEntityValueField());
    assertNull(actualConstructBasicMetadataOverrideResult.getMapKeyValueProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getMediaField());
    assertNull(actualConstructBasicMetadataOverrideResult.getName());
    assertNull(actualConstructBasicMetadataOverrideResult.getParentObjectIdProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getParentObjectProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getSelectizeVisibleField());
    assertNull(actualConstructBasicMetadataOverrideResult.getSortProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getTargetObjectIdProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getTargetObjectProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getToOneParentProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getToOneTargetProperty());
    assertNull(actualConstructBasicMetadataOverrideResult.getValueClass());
    assertNull(actualConstructBasicMetadataOverrideResult.getValuePropertyFriendlyName());
    assertNull(actualConstructBasicMetadataOverrideResult.getValidationConfigurations());
    assertNull(actualConstructBasicMetadataOverrideResult.getAddMethodType());
    assertNull(actualConstructBasicMetadataOverrideResult.getAdornedTargetAddMethodType());
    assertNull(actualConstructBasicMetadataOverrideResult.getAddType());
    assertNull(actualConstructBasicMetadataOverrideResult.getFetchType());
    assertNull(actualConstructBasicMetadataOverrideResult.getInspectType());
    assertNull(actualConstructBasicMetadataOverrideResult.getRemoveType());
    assertNull(actualConstructBasicMetadataOverrideResult.getUpdateType());
    assertNull(actualConstructBasicMetadataOverrideResult.getSimpleValue());
    assertNull(actualConstructBasicMetadataOverrideResult.getMergedPropertyType());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getGridOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getGroupOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getTabOrder().intValue());
    assertEquals(1, actualConstructBasicMetadataOverrideResult.getOrder().intValue());
    assertEquals(1, optionFilterValues.length);
    assertEquals(3, serializableArray.length);
    assertEquals(OptionFilterParamType.BOOLEAN, serializable);
    assertEquals(LookupType.STANDARD, actualConstructBasicMetadataOverrideResult.getLookupType());
    assertEquals(RuleBuilderDisplayType.NORMAL, actualConstructBasicMetadataOverrideResult.getDisplayType());
    assertEquals(SupportedFieldType.DATA_DRIVEN_ENUMERATION,
        actualConstructBasicMetadataOverrideResult.getExplicitFieldType());
    assertEquals(SupportedFieldType.DATA_DRIVEN_ENUMERATION, actualConstructBasicMetadataOverrideResult.getFieldType());
    assertEquals(SupportedFieldType.INTEGER, actualConstructBasicMetadataOverrideResult.getSecondaryType());
    assertEquals(SupportedFieldType.UNKNOWN, actualConstructBasicMetadataOverrideResult.getFieldComponentRenderer());
    assertEquals(SupportedFieldType.UNKNOWN,
        actualConstructBasicMetadataOverrideResult.getGridFieldComponentRenderer());
    assertEquals(VisibilityEnum.HIDDEN_ALL, actualConstructBasicMetadataOverrideResult.getVisibility());
    assertTrue(actualConstructBasicMetadataOverrideResult.getAllowNoValueEnumOption());
    assertTrue(actualConstructBasicMetadataOverrideResult.getCanLinkToExternalEntity());
    assertTrue(actualConstructBasicMetadataOverrideResult.getEnableTypeaheadLookup());
    assertTrue(actualConstructBasicMetadataOverrideResult.getExcluded());
    assertTrue(actualConstructBasicMetadataOverrideResult.getForcePopulateChildProperties());
    assertTrue(actualConstructBasicMetadataOverrideResult.getGroupCollapsed());
    assertTrue(actualConstructBasicMetadataOverrideResult.getHideEnumerationIfEmpty());
    assertTrue(actualConstructBasicMetadataOverrideResult.getOptionCanEditValues());
    assertTrue(actualConstructBasicMetadataOverrideResult.getReadOnly());
    assertTrue(actualConstructBasicMetadataOverrideResult.getRequiredOverride());
    assertTrue(actualConstructBasicMetadataOverrideResult.getToOneLookupCreatedViaAnnotation());
    assertTrue(actualConstructBasicMetadataOverrideResult.getTranslatable());
    assertTrue(actualConstructBasicMetadataOverrideResult.getUseServerSideInspectionCache());
    assertTrue(actualConstructBasicMetadataOverrideResult.isLargeEntry());
    assertTrue(actualConstructBasicMetadataOverrideResult.isProminent());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualConstructBasicMetadataOverrideResult.getCustomCriteria());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems())
        .thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));
    AdminPresentation annot = mock(AdminPresentation.class);
    when(annot.validationConfigurations())
        .thenReturn(new ValidationConfiguration[]{validationConfiguration, mock(ValidationConfiguration.class)});
    when(annot.allowNoValueEnumOption()).thenReturn(true);
    when(annot.canLinkToExternalEntity()).thenReturn(true);
    when(annot.groupCollapsed()).thenReturn(true);
    when(annot.hideEnumerationIfEmpty()).thenReturn(true);
    when(annot.largeEntry()).thenReturn(true);
    when(annot.prominent()).thenReturn(true);
    when(annot.readOnly()).thenReturn(true);
    when(annot.translatable()).thenReturn(true);
    when(annot.gridOrder()).thenReturn(1);
    when(annot.groupOrder()).thenReturn(1);
    when(annot.order()).thenReturn(1);
    when(annot.tabOrder()).thenReturn(1);
    when(annot.addFriendlyName()).thenReturn("Add Friendly Name");
    when(annot.associatedFieldName()).thenReturn("Associated Field Name");
    when(annot.broadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(annot.columnWidth()).thenReturn("Column Width");
    when(annot.currencyCodeField()).thenReturn("GBP");
    when(annot.defaultValue()).thenReturn("42");
    when(annot.fieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(annot.friendlyName()).thenReturn("Friendly Name");
    when(annot.gridFieldComponentRendererTemplate()).thenReturn("Grid Field Component Renderer Template");
    when(annot.group()).thenReturn("Group");
    when(annot.helpText()).thenReturn("Help Text");
    when(annot.hint()).thenReturn("Hint");
    when(annot.ruleIdentifier()).thenReturn("42");
    when(annot.securityLevel()).thenReturn("Security Level");
    when(annot.showIfProperty()).thenReturn("Show If Property");
    when(annot.tab()).thenReturn("Tab");
    when(annot.showIfFieldEquals()).thenReturn(new FieldValueConfiguration[]{fieldValueConfiguration});
    when(annot.displayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(annot.fieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.fieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.gridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(annot.visibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");
    new IllegalArgumentException("ThreadLocalManager.notify.orphans");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicFieldMetadataProvider.constructBasicMetadataOverride(annot,
        mock(AdminPresentationToOneLookup.class), mock(AdminPresentationDataDrivenEnumeration.class)));
    verify(annot).addFriendlyName();
    verify(annot).allowNoValueEnumOption();
    verify(annot).associatedFieldName();
    verify(annot).broadleafEnumeration();
    verify(annot).canLinkToExternalEntity();
    verify(annot).columnWidth();
    verify(annot).currencyCodeField();
    verify(annot).defaultValue();
    verify(annot).displayType();
    verify(annot).fieldComponentRenderer();
    verify(annot).fieldComponentRendererTemplate();
    verify(annot, atLeast(1)).fieldType();
    verify(annot).friendlyName();
    verify(annot).gridFieldComponentRenderer();
    verify(annot).gridFieldComponentRendererTemplate();
    verify(annot).gridOrder();
    verify(annot).group();
    verify(annot).groupCollapsed();
    verify(annot).groupOrder();
    verify(annot).helpText();
    verify(annot).hideEnumerationIfEmpty();
    verify(annot).hint();
    verify(annot).largeEntry();
    verify(annot).order();
    verify(annot).prominent();
    verify(annot).readOnly();
    verify(annot, atLeast(1)).ruleIdentifier();
    verify(annot).securityLevel();
    verify(annot, atLeast(1)).showIfFieldEquals();
    verify(annot).showIfProperty();
    verify(annot).tab();
    verify(annot).tabOrder();
    verify(annot).translatable();
    verify(annot, atLeast(1)).validationConfigurations();
    verify(annot).visibility();
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#constructBasicMetadataOverride(AdminPresentation, AdminPresentationToOneLookup, AdminPresentationDataDrivenEnumeration)}
   */
  @Test
  public void testConstructBasicMetadataOverride_whenNull_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new BasicFieldMetadataProvider()).constructBasicMetadataOverride(null, null, null));
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessValidationAnnotations() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getValidationConfigurations()).thenThrow(new RuntimeException("foo"));

    // Act
    basicFieldMetadataProvider.processValidationAnnotations(new ValidationConfiguration[]{validationConfiguration},
        override);

    // Assert
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(validationConfiguration).configurationItems();
    verify(override).getValidationConfigurations();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessValidationAnnotations2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass22142 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider basicFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider2 = new BasicFieldMetadataProvider();

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
    basicFieldMetadataProvider2
        .processValidationAnnotations(new ValidationConfiguration[]{mock(ValidationConfiguration.class)}, override);
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then calls
   * {@link ValidationConfiguration#validationImplementation()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessValidationAnnotations_thenCallsValidationImplementation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenReturn("Item Name");
    when(configurationItem.itemValue()).thenReturn("42");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.validationImplementation()).thenReturn("Validation Implementation");
    when(validationConfiguration.configurationItems()).thenReturn(new ConfigurationItem[]{configurationItem});
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getValidationConfigurations()).thenReturn(new HashMap<>());

    // Act
    basicFieldMetadataProvider.processValidationAnnotations(new ValidationConfiguration[]{validationConfiguration},
        override);

    // Assert
    verify(configurationItem).itemName();
    verify(configurationItem).itemValue();
    verify(validationConfiguration).configurationItems();
    verify(validationConfiguration, atLeast(1)).validationImplementation();
    verify(override, atLeast(1)).getValidationConfigurations();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessValidationAnnotations_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    ConfigurationItem configurationItem = mock(ConfigurationItem.class);
    when(configurationItem.itemName()).thenThrow(new IllegalArgumentException("foo"));
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems())
        .thenReturn(new ConfigurationItem[]{configurationItem, mock(ConfigurationItem.class)});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.processValidationAnnotations(
        new ValidationConfiguration[]{validationConfiguration}, mock(FieldMetadataOverride.class)));
    verify(configurationItem).itemName();
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#processValidationAnnotations(ValidationConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessValidationAnnotations_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    new IllegalArgumentException("foo");
    new IllegalArgumentException("foo");
    ValidationConfiguration validationConfiguration = mock(ValidationConfiguration.class);
    when(validationConfiguration.configurationItems()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicFieldMetadataProvider.processValidationAnnotations(
            new ValidationConfiguration[]{validationConfiguration, mock(ValidationConfiguration.class)},
            mock(FieldMetadataOverride.class)));
    verify(validationConfiguration).configurationItems();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
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
    //   public class DiffblueFakeClass21965 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider basicFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider2 = new BasicFieldMetadataProvider();

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
    basicFieldMetadataProvider2.processShowIfFieldEqualsAnnotations(
        new FieldValueConfiguration[]{mock(FieldValueConfiguration.class)}, override);
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations_givenRuntimeExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenThrow(new RuntimeException("foo"));

    // Act
    basicFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
        new FieldValueConfiguration[]{mock(FieldValueConfiguration.class)}, override);

    // Assert
    verify(override).getShowIfFieldEquals();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then calls {@link FieldValueConfiguration#fieldValues()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations_thenCallsFieldValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenReturn("Field Name");
    when(fieldValueConfiguration.fieldValues()).thenReturn(new String[]{"42"});
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act
    basicFieldMetadataProvider
        .processShowIfFieldEqualsAnnotations(new FieldValueConfiguration[]{fieldValueConfiguration}, override);

    // Assert
    verify(fieldValueConfiguration).fieldName();
    verify(fieldValueConfiguration).fieldValues();
    verify(override, atLeast(1)).getShowIfFieldEquals();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#processShowIfFieldEqualsAnnotations(FieldValueConfiguration[], FieldMetadataOverride)}
   */
  @Test
  public void testProcessShowIfFieldEqualsAnnotations_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    FieldValueConfiguration fieldValueConfiguration = mock(FieldValueConfiguration.class);
    when(fieldValueConfiguration.fieldName()).thenThrow(new IllegalArgumentException("foo"));
    FieldMetadataOverride override = mock(FieldMetadataOverride.class);
    when(override.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.processShowIfFieldEqualsAnnotations(
        new FieldValueConfiguration[]{fieldValueConfiguration, mock(FieldValueConfiguration.class)}, override));
    verify(fieldValueConfiguration).fieldName();
    verify(override, atLeast(1)).getShowIfFieldEquals();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildBasicMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride basicFieldMetadata = mock(FieldMetadataOverride.class);
    when(basicFieldMetadata.getEnableTypeaheadLookup()).thenReturn(true);
    when(basicFieldMetadata.getExcluded()).thenReturn(true);
    when(basicFieldMetadata.getForcePopulateChildProperties()).thenReturn(true);
    when(basicFieldMetadata.getGroupCollapsed()).thenReturn(true);
    when(basicFieldMetadata.getHideEnumerationIfEmpty()).thenReturn(true);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    when(basicFieldMetadata.getToOneLookupCreatedViaAnnotation()).thenReturn(true);
    when(basicFieldMetadata.getUseServerSideInspectionCache()).thenReturn(true);
    when(basicFieldMetadata.isLargeEntry()).thenReturn(true);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getGroupOrder()).thenReturn(1);
    when(basicFieldMetadata.getTabOrder()).thenReturn(1);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getAddFriendlyName()).thenReturn("Add Friendly Name");
    when(basicFieldMetadata.getBroadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(basicFieldMetadata.getColumnWidth()).thenReturn("Column Width");
    when(basicFieldMetadata.getCurrencyCodeField()).thenReturn("GBP");
    when(basicFieldMetadata.getFieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate())
        .thenReturn("Grid Field Component Renderer Template");
    when(basicFieldMetadata.getGroup()).thenReturn("Group");
    when(basicFieldMetadata.getHelpText()).thenReturn("Help Text");
    when(basicFieldMetadata.getHint()).thenReturn("Hint");
    when(basicFieldMetadata.getLookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(basicFieldMetadata.getOptionDisplayFieldName()).thenReturn(null);
    when(basicFieldMetadata.getOptionListEntity()).thenReturn("Option List Entity");
    when(basicFieldMetadata.getOptionValueFieldName()).thenReturn("42");
    when(basicFieldMetadata.getSecurityLevel()).thenReturn("Security Level");
    when(basicFieldMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(basicFieldMetadata.getTab()).thenReturn("Tab");
    when(basicFieldMetadata.getTooltip()).thenReturn("127.0.0.1");
    when(basicFieldMetadata.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(basicFieldMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(basicFieldMetadata.getDisplayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(basicFieldMetadata.getExplicitFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getGridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.buildBasicMetadata(parentClass,
        targetClass, attributes, field, basicFieldMetadata, mock(DynamicEntityDao.class)));
    verify(basicFieldMetadata, atLeast(1)).getAddFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getBroadleafEnumeration();
    verify(basicFieldMetadata, atLeast(1)).getColumnWidth();
    verify(basicFieldMetadata, atLeast(1)).getCurrencyCodeField();
    verify(basicFieldMetadata, atLeast(1)).getCustomCriteria();
    verify(basicFieldMetadata, atLeast(1)).getDisplayType();
    verify(basicFieldMetadata, atLeast(1)).getEnableTypeaheadLookup();
    verify(basicFieldMetadata, atLeast(1)).getExcluded();
    verify(basicFieldMetadata, atLeast(1)).getExplicitFieldType();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRenderer();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForcePopulateChildProperties();
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRenderer();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getGridOrder();
    verify(basicFieldMetadata, atLeast(1)).getGroup();
    verify(basicFieldMetadata, atLeast(1)).getGroupCollapsed();
    verify(basicFieldMetadata, atLeast(1)).getGroupOrder();
    verify(basicFieldMetadata, atLeast(1)).getHelpText();
    verify(basicFieldMetadata, atLeast(1)).getHideEnumerationIfEmpty();
    verify(basicFieldMetadata, atLeast(1)).getHint();
    verify(basicFieldMetadata, atLeast(1)).getLookupDisplayProperty();
    verify(basicFieldMetadata).getOptionDisplayFieldName();
    verify(basicFieldMetadata, atLeast(1)).getOptionListEntity();
    verify(basicFieldMetadata, atLeast(1)).getOptionValueFieldName();
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(basicFieldMetadata, atLeast(1)).getSecurityLevel();
    verify(basicFieldMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(basicFieldMetadata, atLeast(1)).getShowIfProperty();
    verify(basicFieldMetadata, atLeast(1)).getTab();
    verify(basicFieldMetadata, atLeast(1)).getTabOrder();
    verify(basicFieldMetadata, atLeast(1)).getToOneLookupCreatedViaAnnotation();
    verify(basicFieldMetadata, atLeast(1)).getTooltip();
    verify(basicFieldMetadata, atLeast(1)).getUseServerSideInspectionCache();
    verify(basicFieldMetadata, atLeast(1)).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isLargeEntry();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata, atLeast(1)).getOrder();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildBasicMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride basicFieldMetadata = mock(FieldMetadataOverride.class);
    when(basicFieldMetadata.getEnableTypeaheadLookup()).thenReturn(true);
    when(basicFieldMetadata.getExcluded()).thenReturn(true);
    when(basicFieldMetadata.getForcePopulateChildProperties()).thenReturn(true);
    when(basicFieldMetadata.getGroupCollapsed()).thenReturn(true);
    when(basicFieldMetadata.getHideEnumerationIfEmpty()).thenReturn(true);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    when(basicFieldMetadata.getToOneLookupCreatedViaAnnotation()).thenReturn(true);
    when(basicFieldMetadata.getUseServerSideInspectionCache()).thenReturn(true);
    when(basicFieldMetadata.isLargeEntry()).thenReturn(true);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getGroupOrder()).thenReturn(1);
    when(basicFieldMetadata.getTabOrder()).thenReturn(1);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getAddFriendlyName()).thenReturn("Add Friendly Name");
    when(basicFieldMetadata.getBroadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    when(basicFieldMetadata.getColumnWidth()).thenReturn("Column Width");
    when(basicFieldMetadata.getCurrencyCodeField()).thenReturn("GBP");
    when(basicFieldMetadata.getFieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate())
        .thenReturn("Grid Field Component Renderer Template");
    when(basicFieldMetadata.getGroup()).thenReturn("Group");
    when(basicFieldMetadata.getHelpText()).thenReturn("Help Text");
    when(basicFieldMetadata.getHint()).thenReturn("Hint");
    when(basicFieldMetadata.getLookupDisplayProperty()).thenReturn("Lookup Display Property");
    when(basicFieldMetadata.getOptionDisplayFieldName()).thenReturn("Option Display Field Name");
    when(basicFieldMetadata.getOptionListEntity()).thenReturn("Option List Entity");
    when(basicFieldMetadata.getOptionValueFieldName()).thenReturn(null);
    when(basicFieldMetadata.getSecurityLevel()).thenReturn("Security Level");
    when(basicFieldMetadata.getShowIfProperty()).thenReturn("Show If Property");
    when(basicFieldMetadata.getTab()).thenReturn("Tab");
    when(basicFieldMetadata.getTooltip()).thenReturn("127.0.0.1");
    when(basicFieldMetadata.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(basicFieldMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    when(basicFieldMetadata.getDisplayType()).thenReturn(RuleBuilderDisplayType.NORMAL);
    when(basicFieldMetadata.getExplicitFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getGridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> basicFieldMetadataProvider.buildBasicMetadata(parentClass,
        targetClass, attributes, field, basicFieldMetadata, mock(DynamicEntityDao.class)));
    verify(basicFieldMetadata, atLeast(1)).getAddFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getBroadleafEnumeration();
    verify(basicFieldMetadata, atLeast(1)).getColumnWidth();
    verify(basicFieldMetadata, atLeast(1)).getCurrencyCodeField();
    verify(basicFieldMetadata, atLeast(1)).getCustomCriteria();
    verify(basicFieldMetadata, atLeast(1)).getDisplayType();
    verify(basicFieldMetadata, atLeast(1)).getEnableTypeaheadLookup();
    verify(basicFieldMetadata, atLeast(1)).getExcluded();
    verify(basicFieldMetadata, atLeast(1)).getExplicitFieldType();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRenderer();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForcePopulateChildProperties();
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRenderer();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getGridOrder();
    verify(basicFieldMetadata, atLeast(1)).getGroup();
    verify(basicFieldMetadata, atLeast(1)).getGroupCollapsed();
    verify(basicFieldMetadata, atLeast(1)).getGroupOrder();
    verify(basicFieldMetadata, atLeast(1)).getHelpText();
    verify(basicFieldMetadata, atLeast(1)).getHideEnumerationIfEmpty();
    verify(basicFieldMetadata, atLeast(1)).getHint();
    verify(basicFieldMetadata, atLeast(1)).getLookupDisplayProperty();
    verify(basicFieldMetadata, atLeast(1)).getOptionDisplayFieldName();
    verify(basicFieldMetadata, atLeast(1)).getOptionListEntity();
    verify(basicFieldMetadata).getOptionValueFieldName();
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(basicFieldMetadata, atLeast(1)).getSecurityLevel();
    verify(basicFieldMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(basicFieldMetadata, atLeast(1)).getShowIfProperty();
    verify(basicFieldMetadata, atLeast(1)).getTab();
    verify(basicFieldMetadata, atLeast(1)).getTabOrder();
    verify(basicFieldMetadata, atLeast(1)).getToOneLookupCreatedViaAnnotation();
    verify(basicFieldMetadata, atLeast(1)).getTooltip();
    verify(basicFieldMetadata, atLeast(1)).getUseServerSideInspectionCache();
    verify(basicFieldMetadata, atLeast(1)).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isLargeEntry();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata, atLeast(1)).getOrder();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildBasicMetadata3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20670 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider basicFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider2 = new BasicFieldMetadataProvider();
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

    FieldMetadataOverride basicFieldMetadata = new FieldMetadataOverride();
    basicFieldMetadata.setAddFriendlyName("Add Friendly Name");
    basicFieldMetadata.setAddMethodType(AddMethodType.PERSIST);
    basicFieldMetadata.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    basicFieldMetadata.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    basicFieldMetadata.setAllowNoValueEnumOption(true);
    basicFieldMetadata.setAssociatedFieldName("Associated Field Name");
    basicFieldMetadata.setBroadleafEnumeration("Broadleaf Enumeration");
    basicFieldMetadata.setCanLinkToExternalEntity(true);
    basicFieldMetadata.setColumnWidth("Column Width");
    basicFieldMetadata.setCurrencyCodeField("GBP");
    basicFieldMetadata.setCustomCriteria(new String[]{"Custom Criteria"});
    basicFieldMetadata.setDeleteEntityUponRemove(true);
    basicFieldMetadata.setDerived(true);
    basicFieldMetadata.setDisplayType(RuleBuilderDisplayType.NORMAL);
    basicFieldMetadata.setEnableTypeaheadLookup(true);
    basicFieldMetadata.setEnumerationClass("Enumeration Class");
    basicFieldMetadata.setEnumerationValues(new String[][]{new String[]{"42"}});
    basicFieldMetadata.setExcluded(true);
    basicFieldMetadata.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    basicFieldMetadata.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    basicFieldMetadata.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    basicFieldMetadata.setFieldComponentRendererTemplate("Field Component Renderer Template");
    basicFieldMetadata.setFieldType(SupportedFieldType.UNKNOWN);
    basicFieldMetadata.setForceFreeFormKeys(true);
    basicFieldMetadata.setForcePopulateChildProperties(true);
    basicFieldMetadata.setForeignKeyClass("Foreign Key Class");
    basicFieldMetadata.setForeignKeyCollection(true);
    basicFieldMetadata.setForeignKeyDisplayValueProperty("42");
    basicFieldMetadata.setForeignKeyProperty("Foreign Key Property");
    basicFieldMetadata.setFriendlyName("Friendly Name");
    basicFieldMetadata.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    basicFieldMetadata.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    basicFieldMetadata.setGridOrder(1);
    basicFieldMetadata.setGridVisibleFields(new String[]{"Grid Visible Fields"});
    basicFieldMetadata.setGroup("Group");
    basicFieldMetadata.setGroupCollapsed(true);
    basicFieldMetadata.setGroupOrder(1);
    basicFieldMetadata.setHelpText("Help Text");
    basicFieldMetadata.setHideEnumerationIfEmpty(true);
    basicFieldMetadata.setHint("Hint");
    basicFieldMetadata.setIgnoreAdornedProperties(true);
    basicFieldMetadata.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    basicFieldMetadata.setJoinEntityClass("Join Entity Class");
    basicFieldMetadata.setKeyClass("Key Class");
    basicFieldMetadata.setKeyPropertyFriendlyName("Key Property Friendly Name");
    basicFieldMetadata.setKeys(new String[][]{new String[]{"Keys"}});
    basicFieldMetadata.setLargeEntry(true);
    basicFieldMetadata.setLazyFetch(true);
    basicFieldMetadata.setLength(3);
    basicFieldMetadata.setLookupDisplayProperty("Lookup Display Property");
    basicFieldMetadata.setLookupType(LookupType.STANDARD);
    basicFieldMetadata.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});
    basicFieldMetadata.setManualFetch(true);
    basicFieldMetadata.setManyToField("Many To Field");
    basicFieldMetadata.setMapFieldValueClass("42");
    basicFieldMetadata.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    basicFieldMetadata.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    basicFieldMetadata.setMapKeyOptionEntityValueField("42");
    basicFieldMetadata.setMapKeyValueProperty("42");
    basicFieldMetadata.setMediaField("Media Field");
    basicFieldMetadata.setMergedPropertyType(MergedPropertyType.PRIMARY);
    basicFieldMetadata.setName("Name");
    basicFieldMetadata.setOptionCanEditValues(true);
    basicFieldMetadata.setOptionDisplayFieldName("Option Display Field Name");
    basicFieldMetadata
        .setOptionFilterValues(new Serializable[][]{new Serializable[]{new SimpleDateFormat("yyyy/mm/dd")}});
    basicFieldMetadata.setOptionListEntity("Option List Entity");
    basicFieldMetadata.setOptionValueFieldName("42");
    basicFieldMetadata.setOrder(1);
    basicFieldMetadata.setParentObjectIdProperty("Parent Object Id Property");
    basicFieldMetadata.setParentObjectProperty("Parent Object Property");
    basicFieldMetadata.setPrecision(1);
    basicFieldMetadata.setProminent(true);
    basicFieldMetadata.setReadOnly(true);
    basicFieldMetadata.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    basicFieldMetadata.setRequired(true);
    basicFieldMetadata.setRequiredOverride(true);
    basicFieldMetadata.setRuleIdentifier("42");
    basicFieldMetadata.setScale(1);
    basicFieldMetadata.setSearchable(true);
    basicFieldMetadata.setSecondaryType(SupportedFieldType.UNKNOWN);
    basicFieldMetadata.setSecurityLevel("Security Level");
    basicFieldMetadata.setSelectizeVisibleField("Selectize Visible Field");
    basicFieldMetadata.setShowIfFieldEquals(new HashMap<>());
    basicFieldMetadata.setShowIfProperty("Show If Property");
    basicFieldMetadata.setSimpleValue(UnspecifiedBooleanType.TRUE);
    basicFieldMetadata.setSortAscending(true);
    basicFieldMetadata.setSortProperty("Sort Property");
    basicFieldMetadata.setTab("Tab");
    basicFieldMetadata.setTabOrder(1);
    basicFieldMetadata.setTargetObjectIdProperty("Target Object Id Property");
    basicFieldMetadata.setTargetObjectProperty("Target Object Property");
    basicFieldMetadata.setToOneLookupCreatedViaAnnotation(true);
    basicFieldMetadata.setToOneParentProperty("To One Parent Property");
    basicFieldMetadata.setToOneTargetProperty("To One Target Property");
    basicFieldMetadata.setTooltip("127.0.0.1");
    basicFieldMetadata.setTranslatable(true);
    basicFieldMetadata.setUnique(true);
    basicFieldMetadata.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    basicFieldMetadata.setUseServerSideInspectionCache(true);
    basicFieldMetadata.setValidationConfigurations(new HashMap<>());
    basicFieldMetadata.setValueClass("42");
    basicFieldMetadata.setValuePropertyFriendlyName("42");
    basicFieldMetadata.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act
    basicFieldMetadataProvider2.buildBasicMetadata(parentClass, targetClass, attributes, field, basicFieldMetadata,
        new DynamicEntityDaoImpl());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#buildBasicMetadata(Class, Class, Map, FieldInfo, FieldMetadataOverride, DynamicEntityDao)}
   */
  @Test
  public void testBuildBasicMetadata_givenIllegalArgumentExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider = new BasicFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    FieldMetadataOverride basicFieldMetadata = mock(FieldMetadataOverride.class);
    when(basicFieldMetadata.getFieldType()).thenThrow(new IllegalArgumentException("foo"));

    // Act
    basicFieldMetadataProvider.buildBasicMetadata(parentClass, targetClass, attributes, field, basicFieldMetadata,
        mock(DynamicEntityDao.class));

    // Assert
    verify(basicFieldMetadata).getFieldType();
    verify(field, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#buildDataDrivenEnumList(BasicFieldMetadata)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#buildDataDrivenEnumList(BasicFieldMetadata)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildDataDrivenEnumList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20861 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider basicFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider2 = new BasicFieldMetadataProvider();

    // Act
    basicFieldMetadataProvider2.buildDataDrivenEnumList(new BasicFieldMetadata());
  }

  /**
   * Test
   * {@link BasicFieldMetadataProvider#refreshDataDrivenEnumMetadata(BasicFieldMetadata)}.
   * <p>
   * Method under test:
   * {@link BasicFieldMetadataProvider#refreshDataDrivenEnumMetadata(BasicFieldMetadata)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRefreshDataDrivenEnumMetadata() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass22319 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider basicFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicFieldMetadataProvider basicFieldMetadataProvider2 = new BasicFieldMetadataProvider();

    // Act
    basicFieldMetadataProvider2.refreshDataDrivenEnumMetadata(new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadataProvider#getOrder()}.
   * <p>
   * Method under test: {@link BasicFieldMetadataProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.BASIC, (new BasicFieldMetadataProvider()).getOrder());
  }
}
