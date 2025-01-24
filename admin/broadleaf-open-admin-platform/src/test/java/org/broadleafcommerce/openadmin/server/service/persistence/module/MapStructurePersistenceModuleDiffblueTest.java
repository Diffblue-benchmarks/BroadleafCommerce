package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MapStructure;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
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
public class MapStructurePersistenceModuleDiffblueTest {
  @Autowired
  private MapStructurePersistenceModule mapStructurePersistenceModule;

  /**
   * Test {@link MapStructurePersistenceModule#isCompatible(OperationType)}.
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    mapStructurePersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act and Assert
    assertFalse(mapStructurePersistenceModule.isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link MapStructurePersistenceModule#isCompatible(OperationType)}.
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#isCompatible(OperationType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsCompatible2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2423 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.MapStructurePersistenceModule mapStructurePersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MapStructurePersistenceModule()).isCompatible(OperationType.NONDESTRUCTIVEREMOVE);
  }

  /**
   * Test {@link MapStructurePersistenceModule#isCompatible(OperationType)}.
   * <ul>
   *   <li>Given {@link MapStructurePersistenceModule} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible_givenMapStructurePersistenceModule_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MapStructurePersistenceModule()).isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link MapStructurePersistenceModule#isCompatible(OperationType)}.
   * <ul>
   *   <li>Given {@link MapStructurePersistenceModule} (default constructor).</li>
   *   <li>When {@code MAP}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible_givenMapStructurePersistenceModule_whenMap_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MapStructurePersistenceModule()).isCompatible(OperationType.MAP));
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    mapStructurePersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExtractProperties2() throws NumberFormatException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1704 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.MapStructurePersistenceModule mapStructurePersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule2 = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    // Act
    mapStructurePersistenceModule2.extractProperties(new Class[]{forNameResult}, mergedProperties, new ArrayList<>());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_givenHashMap_thenArrayListEmpty() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, null);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, new HashMap<>());
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@link MergedPropertyType#MAPSTRUCTUREKEY}
   * is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_givenHashMap_whenHashMapMapstructurekeyIsHashMap() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, new HashMap<>());
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, null);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@code MAPSTRUCTUREKEY}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_givenMapstructurekey_thenArrayListFirstNameIsFoo() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", new AdornedTargetCollectionMetadata());

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, null);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(1, properties.size());
    assertEquals("foo", properties.get(0).getName());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} first Metadata
   * {@link BasicFieldMetadata}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_givenProperty_thenArrayListFirstMetadataBasicFieldMetadata()
      throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(new Property());

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    Property getResult = properties.get(0);
    assertTrue(getResult.getMetadata() instanceof BasicFieldMetadata);
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_givenProperty_thenArrayListSizeIsTwo() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(new Property());
    properties.add(new Property());

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertEquals(2, properties.size());
    Property getResult = properties.get(0);
    assertTrue(getResult.getMetadata() instanceof BasicFieldMetadata);
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_thenArrayListFirstNameIs42() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("42", new AdornedTargetCollectionMetadata());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, null);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(2, properties.size());
    assertEquals("42", properties.get(0).getName());
    Property getResult = properties.get(1);
    assertEquals("foo", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_thenArrayListFirstNameIsFoo() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", new AdornedTargetCollectionMetadata());

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, null);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(1, properties.size());
    assertEquals("foo", properties.get(0).getName());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_whenHashMap_thenArrayListEmpty() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#updateMergedProperties(PersistencePackage, Map)}.
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#updateMergedProperties(PersistencePackage, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateMergedProperties() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2545 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.MapStructurePersistenceModule mapStructurePersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule2 = new MapStructurePersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    mapStructurePersistenceModule2.updateMergedProperties(persistencePackage, new HashMap<>());
  }

  /**
   * Test {@link MapStructurePersistenceModule#add(PersistencePackage)} with
   * {@code persistencePackage}.
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#add(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithPersistencePackage() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1617 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.MapStructurePersistenceModule mapStructurePersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule2 = new MapStructurePersistenceModule();

    // Act
    mapStructurePersistenceModule2.add(new PersistencePackage());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#convertPrimitiveBasedOnType(String, String, Map)}.
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#convertPrimitiveBasedOnType(String, String, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertPrimitiveBasedOnType() throws ParseException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1649 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.MapStructurePersistenceModule mapStructurePersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule2 = new MapStructurePersistenceModule();

    // Act
    mapStructurePersistenceModule2.convertPrimitiveBasedOnType("42", "42", new HashMap<>());
  }

  /**
   * Test {@link MapStructurePersistenceModule#update(PersistencePackage)} with
   * {@code persistencePackage}.
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#update(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateWithPersistencePackage() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2513 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.MapStructurePersistenceModule mapStructurePersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule2 = new MapStructurePersistenceModule();

    // Act
    mapStructurePersistenceModule2.update(new PersistencePackage());
  }

  /**
   * Test {@link MapStructurePersistenceModule#remove(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#remove(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemove() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2481 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.MapStructurePersistenceModule mapStructurePersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule2 = new MapStructurePersistenceModule();

    // Act
    mapStructurePersistenceModule2.remove(new PersistencePackage());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#fetch(PersistencePackage, CriteriaTransferObject)}.
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#fetch(PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFetch() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2032 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.MapStructurePersistenceModule mapStructurePersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule2 = new MapStructurePersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    mapStructurePersistenceModule2.fetch(persistencePackage, new CriteriaTransferObject());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}.
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcureSandBoxMapValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2436 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.MapStructurePersistenceModule mapStructurePersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule2 = new MapStructurePersistenceModule();
    MapStructure mapStructure = new MapStructure();

    // Act
    mapStructurePersistenceModule2.procureSandBoxMapValue(mapStructure, new Entity());
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}
   */
  @Test
  public void testProcureSandBoxMapValue_given42_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    MapStructure mapStructure = mock(MapStructure.class);
    when(mapStructure.getValueClassName()).thenReturn("42");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> mapStructurePersistenceModule.procureSandBoxMapValue(mapStructure, new Entity()));
    verify(mapStructure).getValueClassName();
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}
   */
  @Test
  public void testProcureSandBoxMapValue_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    mapStructurePersistenceModule.setPersistenceManager(persistenceManager);
    MapStructure mapStructure = mock(MapStructure.class);
    when(mapStructure.getValueClassName()).thenReturn("java.lang.String");

    // Act
    Serializable actualProcureSandBoxMapValueResult = mapStructurePersistenceModule.procureSandBoxMapValue(mapStructure,
        new Entity());

    // Assert
    verify(mapStructure).getValueClassName();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    assertNull(actualProcureSandBoxMapValueResult);
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}
   */
  @Test
  public void testProcureSandBoxMapValue_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    mapStructurePersistenceModule.setPersistenceManager(persistenceManager);
    MapStructure mapStructure = mock(MapStructure.class);
    when(mapStructure.getValueClassName()).thenReturn("java.lang.String");
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new IllegalStateException("name"));
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> mapStructurePersistenceModule.procureSandBoxMapValue(mapStructure, entity));
    verify(entity).findProperty(isNull());
    verify(mapStructure).getValueClassName();
    verify(property).getValue();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#getMapRecords(Serializable, MapStructure, Map, Map, Property, String[])}.
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#getMapRecords(Serializable, MapStructure, Map, Map, Property, String[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMapRecords() throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException,
      NoSuchFieldException, NoSuchMethodException, SecurityException, InvocationTargetException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2270 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.MapStructurePersistenceModule mapStructurePersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule2 = new MapStructurePersistenceModule();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");
    MapStructure mapStructure = new MapStructure();
    HashMap<String, FieldMetadata> ceilingMergedProperties = new HashMap<>();
    HashMap<String, FieldMetadata> valueMergedProperties = new HashMap<>();

    // Act
    mapStructurePersistenceModule2.getMapRecords(resultRecord, mapStructure, ceilingMergedProperties,
        valueMergedProperties, new Property(), new String[]{"Custom Criteria"});
  }

  /**
   * Test
   * {@link MapStructurePersistenceModule#getMapRecord(String, Serializable, MapStructure, Map, Property, Object, String[])}.
   * <p>
   * Method under test:
   * {@link MapStructurePersistenceModule#getMapRecord(String, Serializable, MapStructure, Map, Property, Object, String[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMapRecord() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2080 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.MapStructurePersistenceModule mapStructurePersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule2 = new MapStructurePersistenceModule();
    SimpleDateFormat valueInstance = new SimpleDateFormat("yyyy/mm/dd");
    MapStructure mapStructure = new MapStructure();
    HashMap<String, FieldMetadata> valueMergedProperties = new HashMap<>();

    // Act
    mapStructurePersistenceModule2.getMapRecord("Ceiling Class", valueInstance, mapStructure, valueMergedProperties,
        new Property(), "Key", new String[]{"Custom Criteria"});
  }
}
