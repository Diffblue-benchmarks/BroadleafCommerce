package org.broadleafcommerce.admin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuFieldsPersistenceProviderDiffblueTest {
  @Autowired
  private SkuFieldsPersistenceProvider skuFieldsPersistenceProvider;

  /**
   * Test {@link SkuFieldsPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link SkuFieldsPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(49001, (new SkuFieldsPersistenceProvider()).getOrder());
  }

  /**
   * Test {@link SkuFieldsPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link SkuFieldsPersistenceProvider#getOrder()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOrder2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11833 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.SkuFieldsPersistenceProvider skuFieldsPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SkuFieldsPersistenceProvider()).getOrder();
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getRequestedValue()).thenReturn(new BreadcrumbDTOType(
        "org.broadleafcommerce.core.catalog.domain.SkuImpl", "org.broadleafcommerce.core.catalog.domain.SkuImpl"));
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = new Property("Name", "42");

    // Act
    skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getDisplayValue());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getRawValue());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getUnHtmlEncodedValue());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", property.getValue());
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExtractValue2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11566 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.SkuFieldsPersistenceProvider skuFieldsPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider2 = new SkuFieldsPersistenceProvider();
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
    skuFieldsPersistenceProvider2.extractValue(extractValueRequest, new Property());
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_givenAdornedTargetCollectionMetadata_thenReturnHandled()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(
        adornedTargetListPersistenceModule.getStringValueFromGetter(Mockito.<Serializable>any(), Mockito.<String>any()))
            .thenReturn("42");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getRequestedValue()).thenReturn(new BreadcrumbDTOType());
    when(extractValueRequest.getRecordHelper()).thenReturn(adornedTargetListPersistenceModule);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    doNothing().when(property).setDisplayValue(Mockito.<String>any());
    doNothing().when(property).setValue(Mockito.<String>any());
    when(property.getName()).thenReturn("Name");

    // Act
    MetadataProviderResponse actualExtractValueResult = skuFieldsPersistenceProvider.extractValue(extractValueRequest,
        property);

    // Assert
    verify(property).getMetadata();
    verify(property, atLeast(1)).getName();
    verify(property).setDisplayValue(eq("42"));
    verify(property).setValue(isNull());
    verify(adornedTargetListPersistenceModule).getStringValueFromGetter(isA(Serializable.class), eq("Name"));
    verify(extractValueRequest).getEntity();
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest).getRecordHelper();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    assertEquals(MetadataProviderResponse.HANDLED, actualExtractValueResult);
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property()} RawValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenPropertyRawValueIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("Target Class");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = new Property();

    // Act
    MetadataProviderResponse actualExtractValueResult = skuFieldsPersistenceProvider.extractValue(extractValueRequest,
        property);

    // Assert
    verify(extractValueRequest, atLeast(1)).getMetadata();
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42} DisplayValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenPropertyWithNameAndValueIs42DisplayValueIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getRequestedValue()).thenReturn(new BreadcrumbDTOType());
    when(extractValueRequest.getRecordHelper()).thenReturn(new AdornedTargetListPersistenceModule());
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = new Property("Name", "42");

    // Act
    skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(extractValueRequest).getEntity();
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest).getRecordHelper();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    assertNull(property.getDisplayValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42} DisplayValue is {@code Requested Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenPropertyWithNameAndValueIs42DisplayValueIsRequestedValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getRequestedValue()).thenReturn("Requested Value");
    when(extractValueRequest.getRecordHelper()).thenReturn(new AdornedTargetListPersistenceModule());
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = new Property("Name", "42");

    // Act
    skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest).getRecordHelper();
    verify(extractValueRequest).getRequestedValue();
    assertEquals("Requested Value", property.getDisplayValue());
    assertEquals("Requested Value", property.getRawValue());
    assertEquals("Requested Value", property.getUnHtmlEncodedValue());
    assertEquals("Requested Value", property.getValue());
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42} Metadata {@link BasicFieldMetadata}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenPropertyWithNameAndValueIs42MetadataBasicFieldMetadata()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(
        adornedTargetListPersistenceModule.getStringValueFromGetter(Mockito.<Serializable>any(), Mockito.<String>any()))
            .thenReturn("42");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getRequestedValue()).thenReturn(new BreadcrumbDTOType());
    when(extractValueRequest.getRecordHelper()).thenReturn(adornedTargetListPersistenceModule);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = new Property("Name", "42");

    // Act
    skuFieldsPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(adornedTargetListPersistenceModule).getStringValueFromGetter(isA(Serializable.class), eq("Name"));
    verify(extractValueRequest).getEntity();
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest).getRecordHelper();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    FieldMetadata metadata = property.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("42", property.getDisplayValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertTrue(((BasicFieldMetadata) metadata).getIsDerived());
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property(String, String)} with name is {@code ---}
   * and value is {@code 42} RawValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenPropertyWithNameIsDashDashDashAndValueIs42RawValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    Property property = new Property("---", "42");

    // Act
    MetadataProviderResponse actualExtractValueResult = skuFieldsPersistenceProvider.extractValue(extractValueRequest,
        property);

    // Assert
    verify(extractValueRequest).getMetadata();
    assertEquals("42", property.getRawValue());
    assertEquals("42", property.getUnHtmlEncodedValue());
    assertEquals("42", property.getValue());
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleExtraction() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11299 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.persistence.module.provider.SkuFieldsPersistenceProvider skuFieldsPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider2 = new SkuFieldsPersistenceProvider();
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
    skuFieldsPersistenceProvider2.canHandleExtraction(extractValueRequest, new Property());
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) TargetClass is
   * {@code Target Class}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_givenBasicFieldMetadataTargetClassIsTargetClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("Target Class");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandleExtractionResult = skuFieldsPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property());

    // Assert
    verify(extractValueRequest, atLeast(1)).getMetadata();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_whenPropertyWithNameAndValueIs42_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandleExtractionResult = skuFieldsPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property("Name", "42"));

    // Assert
    verify(extractValueRequest).getMetadata();
    assertTrue(actualCanHandleExtractionResult);
  }

  /**
   * Test
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with name is {@code ---}
   * and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuFieldsPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_whenPropertyWithNameIsDashDashDashAndValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldsPersistenceProvider skuFieldsPersistenceProvider = new SkuFieldsPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTargetClass("org.broadleafcommerce.core.catalog.domain.SkuImpl");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandleExtractionResult = skuFieldsPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property("---", "42"));

    // Assert
    verify(extractValueRequest).getMetadata();
    assertFalse(actualCanHandleExtractionResult);
  }
}
