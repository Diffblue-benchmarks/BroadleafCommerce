package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.presentation.OptionFilterParamType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.FieldInfo;
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
public class AbstractFieldMetadataProviderDiffblueTest {
  @Autowired
  private AbstractFieldMetadataProvider abstractFieldMetadataProvider;

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#setClassOwnership(Class, Class, Map, FieldInfo)}.
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#setClassOwnership(Class, Class, Map, FieldInfo)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetClassOwnership() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16111 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AbstractFieldMetadataProvider abstractFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
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

    // Act
    adornedTargetCollectionFieldMetadataProvider.setClassOwnership(parentClass, targetClass, attributes, field);
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#setClassOwnership(Class, Class, Map, FieldInfo)}.
   * <ul>
   *   <li>Then {@link FieldInfo} (default constructor) GenericType
   * {@link TypePlaceHolder}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#setClassOwnership(Class, Class, Map, FieldInfo)}
   */
  @Test
  public void testSetClassOwnership_thenFieldInfoGenericTypeTypePlaceHolder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
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

    // Act
    adornedTargetCollectionFieldMetadataProvider.setClassOwnership(parentClass, targetClass, attributes, field);

    // Assert that nothing has changed
    Type genericType = field.getGenericType();
    assertTrue(genericType instanceof TypePlaceHolder);
    Class<Object> expectedErasedType = Object.class;
    assertEquals(expectedErasedType, ((TypePlaceHolder) genericType).getErasedType());
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#setClassOwnership(Class, Class, Map, FieldInfo)}.
   * <ul>
   *   <li>When {@link FieldInfo} {@link FieldInfo#getName()} return
   * {@code Name}.</li>
   *   <li>Then calls {@link FieldInfo#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#setClassOwnership(Class, Class, Map, FieldInfo)}
   */
  @Test
  public void testSetClassOwnership_whenFieldInfoGetNameReturnName_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setGenericType(Mockito.<Type>any());
    doNothing().when(field).setManyToManyMappedBy(Mockito.<String>any());
    doNothing().when(field).setManyToManyTargetEntity(Mockito.<String>any());
    doNothing().when(field).setMapKey(Mockito.<String>any());
    doNothing().when(field).setName(Mockito.<String>any());
    doNothing().when(field).setOneToManyMappedBy(Mockito.<String>any());
    doNothing().when(field).setOneToManyTargetEntity(Mockito.<String>any());
    field.setGenericType(new TypePlaceHolder(1));
    field.setManyToManyMappedBy("Many To Many Mapped By");
    field.setManyToManyTargetEntity("Many To Many Target Entity");
    field.setMapKey("Map Key");
    field.setName("Name");
    field.setOneToManyMappedBy("One To Many Mapped By");
    field.setOneToManyTargetEntity("One To Many Target Entity");

    // Act
    adornedTargetCollectionFieldMetadataProvider.setClassOwnership(parentClass, targetClass, attributes, field);

    // Assert
    verify(field).getName();
    verify(field).setGenericType(isA(Type.class));
    verify(field).setManyToManyMappedBy(eq("Many To Many Mapped By"));
    verify(field).setManyToManyTargetEntity(eq("Many To Many Target Entity"));
    verify(field).setMapKey(eq("Map Key"));
    verify(field).setName(eq("Name"));
    verify(field).setOneToManyMappedBy(eq("One To Many Mapped By"));
    verify(field).setOneToManyTargetEntity(eq("One To Many Target Entity"));
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#buildFieldInfo(Field)}.
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#buildFieldInfo(Field)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildFieldInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16054 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AbstractFieldMetadataProvider abstractFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdornedTargetCollectionFieldMetadataProvider()).buildFieldInfo(null);
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   * with {@code configurationKey}, {@code ceilingEntityFullyQualifiedClassname}.
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  public void testGetTargetedOverrideWithConfigurationKeyCeilingEntityFullyQualifiedClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull(
        (new AdornedTargetCollectionFieldMetadataProvider()).getTargetedOverride("Configuration Key", "Dr Jane Doe"));
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   * with {@code configurationKey}, {@code ceilingEntityFullyQualifiedClassname}.
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  public void testGetTargetedOverrideWithConfigurationKeyCeilingEntityFullyQualifiedClassname2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(null, null));
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   * with {@code configurationKey}, {@code ceilingEntityFullyQualifiedClassname}.
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  public void testGetTargetedOverrideWithConfigurationKeyCeilingEntityFullyQualifiedClassname3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(null, "Dr Jane Doe"));
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   * with {@code configurationKey}, {@code ceilingEntityFullyQualifiedClassname}.
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  public void testGetTargetedOverrideWithConfigurationKeyCeilingEntityFullyQualifiedClassname4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride("Configuration Key", null));
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   * with {@code configurationKey}, {@code ceilingEntityFullyQualifiedClassname}.
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  public void testGetTargetedOverrideWithConfigurationKeyCeilingEntityFullyQualifiedClassname5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<Object, Object> metadataOverrides = new HashMap<>();
    metadataOverrides.computeIfPresent("42", mock(BiFunction.class));

    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(metadataOverrides);

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(null, null));
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   * with {@code configurationKey}, {@code ceilingEntityFullyQualifiedClassname}.
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTargetedOverrideWithConfigurationKeyCeilingEntityFullyQualifiedClassname6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16100 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AbstractFieldMetadataProvider abstractFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdornedTargetCollectionFieldMetadataProvider()).getTargetedOverride("Configuration Key", "Dr Jane Doe");
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetBasicJavaType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16077 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AbstractFieldMetadataProvider abstractFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdornedTargetCollectionFieldMetadataProvider()).getBasicJavaType(SupportedFieldType.UNKNOWN);
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code BOOLEAN}.</li>
   *   <li>Then return Name is {@code boolean}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicJavaType_whenBoolean_thenReturnNameIsBoolean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("boolean",
        (new AdornedTargetCollectionFieldMetadataProvider()).getBasicJavaType(SupportedFieldType.BOOLEAN).getName());
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code DATE}.</li>
   *   <li>Then return {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicJavaType_whenDate_thenReturnDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicJavaType = (new AdornedTargetCollectionFieldMetadataProvider())
        .getBasicJavaType(SupportedFieldType.DATE);

    // Assert
    Class<Date> expectedBasicJavaType = Date.class;
    assertEquals(expectedBasicJavaType, actualBasicJavaType);
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code DECIMAL}.</li>
   *   <li>Then return {@link BigDecimal}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicJavaType_whenDecimal_thenReturnBigDecimal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicJavaType = (new AdornedTargetCollectionFieldMetadataProvider())
        .getBasicJavaType(SupportedFieldType.DECIMAL);

    // Assert
    Class<BigDecimal> expectedBasicJavaType = BigDecimal.class;
    assertEquals(expectedBasicJavaType, actualBasicJavaType);
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code ID}.</li>
   *   <li>Then return {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicJavaType_whenId_thenReturnString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicJavaType = (new AdornedTargetCollectionFieldMetadataProvider())
        .getBasicJavaType(SupportedFieldType.ID);

    // Assert
    Class<String> expectedBasicJavaType = String.class;
    assertEquals(expectedBasicJavaType, actualBasicJavaType);
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code INTEGER}.</li>
   *   <li>Then return Name is {@code int}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicJavaType_whenInteger_thenReturnNameIsInt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("int",
        (new AdornedTargetCollectionFieldMetadataProvider()).getBasicJavaType(SupportedFieldType.INTEGER).getName());
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code MONEY}.</li>
   *   <li>Then return {@link BigDecimal}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicJavaType_whenMoney_thenReturnBigDecimal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicJavaType = (new AdornedTargetCollectionFieldMetadataProvider())
        .getBasicJavaType(SupportedFieldType.MONEY);

    // Assert
    Class<BigDecimal> expectedBasicJavaType = BigDecimal.class;
    assertEquals(expectedBasicJavaType, actualBasicJavaType);
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code UNKNOWN}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicJavaType_whenUnknown_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionFieldMetadataProvider()).getBasicJavaType(SupportedFieldType.UNKNOWN));
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}.
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16058 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AbstractFieldMetadataProvider abstractFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdornedTargetCollectionFieldMetadataProvider()).convertType("42", OptionFilterParamType.BOOLEAN);
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}.
   * <ul>
   *   <li>When {@code DOUBLE}.</li>
   *   <li>Then return doubleValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}
   */
  @Test
  public void testConvertType_whenDouble_thenReturnDoubleValueIsFortyTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(42.0d,
        ((Double) (new AdornedTargetCollectionFieldMetadataProvider()).convertType("42", OptionFilterParamType.DOUBLE))
            .doubleValue(),
        0.0);
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}.
   * <ul>
   *   <li>When {@code FLOAT}.</li>
   *   <li>Then return floatValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}
   */
  @Test
  public void testConvertType_whenFloat_thenReturnFloatValueIsFortyTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(42.0f,
        ((Float) (new AdornedTargetCollectionFieldMetadataProvider()).convertType("42", OptionFilterParamType.FLOAT))
            .floatValue(),
        0.0f);
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}.
   * <ul>
   *   <li>When {@code STRING}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}
   */
  @Test
  public void testConvertType_whenString_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42",
        (new AdornedTargetCollectionFieldMetadataProvider()).convertType("42", OptionFilterParamType.STRING));
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#setupBroadleafEnumeration(String, BasicFieldMetadata, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#setupBroadleafEnumeration(String, BasicFieldMetadata, DynamicEntityDao)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetupBroadleafEnumeration() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16277 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AbstractFieldMetadataProvider abstractFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    BasicFieldMetadata fieldMetadata = new BasicFieldMetadata();

    // Act
    adornedTargetCollectionFieldMetadataProvider.setupBroadleafEnumeration("Broadleaf Enumeration Class", fieldMetadata,
        new DynamicEntityDaoImpl());
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getAdminPresentationEntries(AdminPresentationMergeEntry[])}.
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getAdminPresentationEntries(AdminPresentationMergeEntry[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAdminPresentationEntries() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16070 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.AbstractFieldMetadataProvider abstractFieldMetadataProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdornedTargetCollectionFieldMetadataProvider())
        .getAdminPresentationEntries(new AdminPresentationMergeEntry[]{mock(AdminPresentationMergeEntry.class)});
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getAdminPresentationEntries(AdminPresentationMergeEntry[])}.
   * <ul>
   *   <li>Given {@code Property Type}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getAdminPresentationEntries(AdminPresentationMergeEntry[])}
   */
  @Test
  public void testGetAdminPresentationEntries_givenPropertyType_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.propertyType()).thenReturn("Property Type");

    // Act
    Map<String, AdminPresentationMergeEntry> actualAdminPresentationEntries = adornedTargetCollectionFieldMetadataProvider
        .getAdminPresentationEntries(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Assert
    verify(adminPresentationMergeEntry).propertyType();
    assertEquals(1, actualAdminPresentationEntries.size());
    assertTrue(actualAdminPresentationEntries.containsKey("Property Type"));
  }

  /**
   * Test
   * {@link AbstractFieldMetadataProvider#getAdminPresentationEntries(AdminPresentationMergeEntry[])}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getAdminPresentationEntries(AdminPresentationMergeEntry[])}
   */
  @Test
  public void testGetAdminPresentationEntries_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.propertyType()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adornedTargetCollectionFieldMetadataProvider.getAdminPresentationEntries(
        new AdminPresentationMergeEntry[]{adminPresentationMergeEntry, mock(AdminPresentationMergeEntry.class)}));
    verify(adminPresentationMergeEntry).propertyType();
  }
}
