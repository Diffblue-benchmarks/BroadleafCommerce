package org.broadleafcommerce.openadmin.server.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelper;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.DefaultFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.FieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.MapFieldsFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromFieldTypeRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.hibernate.mapping.Property;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.Type;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class DynamicEntityDaoImplDiffblueTest {
  @InjectMocks private DynamicEntityDaoImpl dynamicEntityDaoImpl;

  @Mock private FieldMetadataProvider fieldMetadataProvider;

  @Mock private Metadata metadata;

  /**
   * Test {@link DynamicEntityDaoImpl#addClassToTree(Class, ClassTree)}.
   *
   * <ul>
   *   <li>Given array of {@link ClassTree} with {@link ClassTree#ClassTree()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#addClassToTree(Class, ClassTree)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.addClassToTree(Class, ClassTree)"})
  public void testAddClassToTree_givenArrayOfClassTreeWithClassTree() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> clazz = Object.class;

    ClassTree tree = new ClassTree("Dr Jane Doe");
    tree.setChildren(new ClassTree[] {new ClassTree()});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicEntityDaoImpl.addClassToTree(clazz, tree));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#addClassToTree(Class, ClassTree)}.
   *
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.
   *   <li>Then calls {@link ClassTree#getFullyQualifiedClassname()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#addClassToTree(Class, ClassTree)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicEntityDaoImpl.addClassToTree(Class, ClassTree)"})
  public void testAddClassToTree_givenDrJaneDoe_thenCallsGetFullyQualifiedClassname() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    Class<Object> clazz = Object.class;

    ClassTree tree = mock(ClassTree.class);
    when(tree.getFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicEntityDaoImpl.addClassToTree(clazz, tree));
    verify(tree).getFullyQualifiedClassname();
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey,
   * ForeignKey[], Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"
  })
  public void testApplyForeignKeyPrecedence() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    ForeignKey foreignField = new ForeignKey("foo", "foo");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(
        foreignField, new ForeignKey[] {new ForeignKey()}, mergedProperties);

    // Assert
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertFalse(getResult.getExcluded());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey,
   * ForeignKey[], Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"
  })
  public void testApplyForeignKeyPrecedence2() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(
        foreignField,
        new ForeignKey[] {new ForeignKey("Many To Field", "Many To Field")},
        mergedProperties);

    // Assert that nothing has changed
    verify(foreignField).getManyToField();
    assertEquals(1, mergedProperties.size());
    assertTrue(mergedProperties.get("foo") instanceof AdornedTargetCollectionMetadata);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   *
   * <ul>
   *   <li>Then calls {@link AdornedTargetCollectionMetadata#setExcluded(Boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey,
   * ForeignKey[], Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"
  })
  public void testApplyForeignKeyPrecedence_thenCallsSetExcluded() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("foo");

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setExcluded(Mockito.<Boolean>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(
        foreignField, new ForeignKey[] {foreignKey}, mergedProperties);

    // Assert
    verify(adornedTargetCollectionMetadata).setExcluded(false);
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   *
   * <ul>
   *   <li>Then not {@link HashMap#HashMap()} {@code foo} Excluded.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey,
   * ForeignKey[], Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"
  })
  public void testApplyForeignKeyPrecedence_thenNotHashMapFooExcluded() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("foo");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(
        foreignField, new ForeignKey[] {foreignKey}, mergedProperties);

    // Assert
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertFalse(getResult.getExcluded());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   *
   * <ul>
   *   <li>When array of {@link ForeignKey} with {@link ForeignKey}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey,
   * ForeignKey[], Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"
  })
  public void testApplyForeignKeyPrecedence_whenArrayOfForeignKeyWithForeignKey() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(
        foreignField, new ForeignKey[] {foreignKey}, mergedProperties);

    // Assert that nothing has changed
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    assertEquals(1, mergedProperties.size());
    assertTrue(mergedProperties.get("foo") instanceof AdornedTargetCollectionMetadata);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyForeignKeyPrecedence(ForeignKey,
   * ForeignKey[], Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyForeignKeyPrecedence(ForeignKey, ForeignKey[], Map)"
  })
  public void testApplyForeignKeyPrecedence_whenNull_thenHashMapSizeIsOne() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyForeignKeyPrecedence(foreignField, null, mergedProperties);

    // Assert that nothing has changed
    verify(foreignField).getManyToField();
    assertEquals(1, mergedProperties.size());
    assertTrue(mergedProperties.get("foo") instanceof AdornedTargetCollectionMetadata);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean,
   * Map)}.
   *
   * <ul>
   *   <li>Then calls {@link AdornedTargetCollectionMetadata#setExcluded(Boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[],
   * String, Boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyIncludesAndExcludes(String[], String[], String, Boolean, Map)"
  })
  public void testApplyIncludesAndExcludes_thenCallsSetExcluded() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setExcluded(Mockito.<Boolean>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);

    // Act
    dynamicEntityDaoImpl.applyIncludesAndExcludes(
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Prefix",
        true,
        mergedProperties);

    // Assert
    verify(adornedTargetCollectionMetadata).setExcluded(true);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean,
   * Map)}.
   *
   * <ul>
   *   <li>Then calls {@link AdornedTargetCollectionMetadata#setExcluded(Boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[],
   * String, Boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyIncludesAndExcludes(String[], String[], String, Boolean, Map)"
  })
  public void testApplyIncludesAndExcludes_thenCallsSetExcluded2() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setExcluded(Mockito.<Boolean>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);

    // Act
    dynamicEntityDaoImpl.applyIncludesAndExcludes(
        new String[] {}, new String[] {"Prefixfoo"}, "Prefix", true, mergedProperties);

    // Assert
    verify(adornedTargetCollectionMetadata).setExcluded(true);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean,
   * Map)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code foo} Excluded.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[],
   * String, Boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyIncludesAndExcludes(String[], String[], String, Boolean, Map)"
  })
  public void testApplyIncludesAndExcludes_thenHashMapFooExcluded() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyIncludesAndExcludes(
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Prefix",
        true,
        mergedProperties);

    // Assert
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertTrue(getResult.getExcluded());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[], String, Boolean,
   * Map)}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Prefixfoo}.
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#applyIncludesAndExcludes(String[], String[],
   * String, Boolean, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.applyIncludesAndExcludes(String[], String[], String, Boolean, Map)"
  })
  public void testApplyIncludesAndExcludes_whenArrayOfStringWithPrefixfoo_thenHashMapSizeIsOne() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    dynamicEntityDaoImpl.applyIncludesAndExcludes(
        new String[] {"Prefixfoo"},
        new String[] {"Exclude Fields"},
        "Prefix",
        true,
        mergedProperties);

    // Assert that nothing has changed
    assertEquals(1, mergedProperties.size());
    assertTrue(mergedProperties.get("foo") instanceof AdornedTargetCollectionMetadata);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildPropertiesFromPolymorphicEntities(Class[], ForeignKey,
   * String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, Map,
   * List, String, Boolean, String)}.
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#buildPropertiesFromPolymorphicEntities(Class[], ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, Map, List,
   * String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildPropertiesFromPolymorphicEntities(Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, Map, List, String, Boolean, String)"
  })
  public void testBuildPropertiesFromPolymorphicEntities() {
    // Arrange
    Class<Object> type = Object.class;
    when(metadata.getFieldMetadataForTargetClass(
            Mockito.<Class<?>>any(),
            Mockito.<Class<?>>any(),
            Mockito.<DynamicEntityDao>any(),
            Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException(type));
    Class<Object> forNameResult = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            dynamicEntityDaoImpl.buildPropertiesFromPolymorphicEntities(
                new Class[] {forNameResult},
                foreignField,
                new String[] {"Additional Non Persistent Properties"},
                new ForeignKey[] {new ForeignKey()},
                MergedPropertyType.PRIMARY,
                true,
                new String[] {"Include Fields"},
                new String[] {"Exclude Fields"},
                "Configuration Key",
                "Dr Jane Doe",
                mergedProperties,
                new ArrayList<>(),
                "Prefix",
                true,
                "Parent Prefix"));
    verify(metadata)
        .getFieldMetadataForTargetClass(
            isNull(), isA(Class.class), isA(DynamicEntityDao.class), eq(""));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildPropertiesFromPolymorphicEntities(Class[], ForeignKey,
   * String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, Map,
   * List, String, Boolean, String)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicEntityDaoImpl#buildPropertiesFromPolymorphicEntities(Class[], ForeignKey, String[],
   * ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, Map, List,
   * String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildPropertiesFromPolymorphicEntities(Class[], ForeignKey, String[], ForeignKey[], MergedPropertyType, Boolean, String[], String[], String, String, Map, List, String, Boolean, String)"
  })
  public void testBuildPropertiesFromPolymorphicEntities_thenDoesNotThrow() {
    // Arrange
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act and Assert
    dynamicEntityDaoImpl.buildPropertiesFromPolymorphicEntities(
        new Class[] {},
        foreignField,
        new String[] {"Additional Non Persistent Properties"},
        new ForeignKey[] {new ForeignKey()},
        MergedPropertyType.PRIMARY,
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        mergedProperties,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[],
   * String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String,
   * String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       FieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey,
   * ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[],
   * String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)"
  })
  public void testBuildBasicProperty_thenCallsAddMetadataFromFieldType() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromFieldType(
            Mockito.<AddMetadataFromFieldTypeRequest>any(),
            Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn(MetadataProviderResponse.HANDLED);
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    ArrayList<Property> componentProperties = new ArrayList<>();
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();

    // Act
    dynamicEntityDaoImpl.buildBasicProperty(
        null,
        targetClass,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        MergedPropertyType.PRIMARY,
        presentationAttributes,
        componentProperties,
        fields,
        "Id Property",
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        parentClasses,
        "Prefix",
        true,
        "Property Name",
        new BigDecimalType(),
        true,
        1,
        true,
        "Parent Prefix");

    // Assert
    verify(fieldMetadataProvider)
        .addMetadataFromFieldType(isA(AddMetadataFromFieldTypeRequest.class), isA(Map.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey, ForeignKey[],
   * String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String,
   * String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildBasicProperty(Field, Class, ForeignKey,
   * ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[],
   * String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildBasicProperty(Field, Class, ForeignKey, ForeignKey[], String[], MergedPropertyType, Map, List, Map, String, Boolean, String[], String[], String, String, List, String, Boolean, String, Type, boolean, int, Boolean, String)"
  })
  public void testBuildBasicProperty_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    Class<Object> type = Object.class;
    when(fieldMetadataProvider.addMetadataFromFieldType(
            Mockito.<AddMetadataFromFieldTypeRequest>any(),
            Mockito.<Map<String, FieldMetadata>>any()))
        .thenThrow(new NoSuchBeanDefinitionException(type));
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    ArrayList<Property> componentProperties = new ArrayList<>();
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ArrayList<Class<?>> parentClasses = new ArrayList<>();

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            dynamicEntityDaoImpl.buildBasicProperty(
                null,
                targetClass,
                foreignField,
                new ForeignKey[] {new ForeignKey()},
                new String[] {"Additional Non Persistent Properties"},
                MergedPropertyType.PRIMARY,
                presentationAttributes,
                componentProperties,
                fields,
                "Id Property",
                true,
                new String[] {"Include Fields"},
                new String[] {"Exclude Fields"},
                "Configuration Key",
                "Dr Jane Doe",
                parentClasses,
                "Prefix",
                true,
                "Property Name",
                new BigDecimalType(),
                true,
                1,
                true,
                "Parent Prefix"));
    verify(fieldMetadataProvider)
        .addMetadataFromFieldType(isA(AddMetadataFromFieldTypeRequest.class), isA(Map.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties() {
    // Arrange
    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(new DefaultFieldMetadataProvider());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert that nothing has changed
    assertTrue(fields.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties2() {
    // Arrange
    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(new MapFieldsFieldMetadataProvider());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert that nothing has changed
    assertTrue(fields.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties3() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey("Many To Field", "Foreign Key Class")},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertSame(adornedTargetCollectionMetadata, fields.get("Property Name.foo"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties4() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        null,
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertSame(adornedTargetCollectionMetadata, fields.get("Property Name.foo"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties5() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {foreignKey},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertSame(adornedTargetCollectionMetadata, fields.get("Property Name.foo"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties6() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {foreignKey},
        new String[] {"Additional Non Persistent Properties"},
        true,
        null,
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertSame(adornedTargetCollectionMetadata, fields.get("Property Name.foo"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties7() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("Many To Field", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {mock(ForeignKey.class)},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    FieldMetadata getResult = fields.get("Property Name.Many To Field");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertSame(adornedTargetCollectionMetadata, getResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties8() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    Class<Object> type = Object.class;
    doThrow(new NoSuchBeanDefinitionException(type))
        .when(adornedTargetCollectionMetadata)
        .setInheritedFromType(Mockito.<String>any());

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            dynamicEntityDaoImpl.buildEntityProperties(
                fields,
                foreignField,
                new ForeignKey[] {foreignKey},
                new String[] {"Additional Non Persistent Properties"},
                true,
                new String[] {},
                new String[] {"Exclude Fields"},
                "Configuration Key",
                "Dr Jane Doe",
                "Property Name",
                returnedClass,
                targetClass,
                new ArrayList<>(),
                "Prefix",
                true,
                "Parent Prefix"));
    verify(adornedTargetCollectionMetadata).setInheritedFromType("java.lang.Object");
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties9() {
    // Arrange
    Class<Object> type = Object.class;
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenThrow(new NoSuchBeanDefinitionException(type));
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            dynamicEntityDaoImpl.buildEntityProperties(
                fields,
                foreignField,
                new ForeignKey[] {new ForeignKey()},
                new String[] {"Additional Non Persistent Properties"},
                true,
                new String[] {"Include Fields"},
                new String[] {"Exclude Fields"},
                "Configuration Key",
                "Dr Jane Doe",
                "Property Name",
                returnedClass,
                targetClass,
                new ArrayList<>(),
                "Prefix",
                true,
                "Parent Prefix"));
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_givenObject_whenArrayListAddObject() {
    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider =
        mock(DefaultFieldMetadataProvider.class);
    when(defaultFieldMetadataProvider.overrideViaXml(
            Mockito.<OverrideViaXmlRequest>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn(MetadataProviderResponse.HANDLED);
    doNothing()
        .when(defaultFieldMetadataProvider)
        .overrideExclusionsFromXml(
            Mockito.<OverrideViaXmlRequest>any(), Mockito.<Map<String, FieldMetadata>>any());

    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(defaultFieldMetadataProvider);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        parentClasses,
        "Prefix",
        true,
        "Parent Prefix");

    // Assert that nothing has changed
    verify(defaultFieldMetadataProvider)
        .overrideViaXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    verify(defaultFieldMetadataProvider)
        .overrideExclusionsFromXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    assertTrue(fields.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_givenObject_whenArrayListAddObject2() {
    // Arrange
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    ArrayList<Class<?>> parentClasses = new ArrayList<>();
    Class<Object> forNameResult = Object.class;
    parentClasses.add(forNameResult);
    Class<Object> forNameResult2 = Object.class;
    parentClasses.add(forNameResult2);

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        parentClasses,
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest,
   *       Map)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_thenCallsOverrideViaXml() {
    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider =
        mock(DefaultFieldMetadataProvider.class);
    when(defaultFieldMetadataProvider.overrideViaXml(
            Mockito.<OverrideViaXmlRequest>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn(MetadataProviderResponse.HANDLED);
    doNothing()
        .when(defaultFieldMetadataProvider)
        .overrideExclusionsFromXml(
            Mockito.<OverrideViaXmlRequest>any(), Mockito.<Map<String, FieldMetadata>>any());

    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(defaultFieldMetadataProvider);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert that nothing has changed
    verify(defaultFieldMetadataProvider)
        .overrideViaXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    verify(defaultFieldMetadataProvider)
        .overrideExclusionsFromXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    assertTrue(fields.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} containsKey {@code Property Name.foo}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_thenHashMapContainsKeyPropertyNameFoo() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setAvailableToTypes(Mockito.<String[]>any());
    doNothing().when(adornedTargetCollectionMetadata).setExcluded(Mockito.<Boolean>any());
    doNothing().when(adornedTargetCollectionMetadata).setInheritedFromType(Mockito.<String>any());

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {foreignKey},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(adornedTargetCollectionMetadata).setAvailableToTypes(isA(String[].class));
    verify(adornedTargetCollectionMetadata).setExcluded(true);
    verify(adornedTargetCollectionMetadata).setInheritedFromType("java.lang.Object");
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("Property Name.foo"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} containsKey {@code Property Name.Many To Field}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_thenHashMapContainsKeyPropertyNameManyToField() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setAvailableToTypes(Mockito.<String[]>any());
    doNothing().when(adornedTargetCollectionMetadata).setExcluded(Mockito.<Boolean>any());
    doNothing().when(adornedTargetCollectionMetadata).setInheritedFromType(Mockito.<String>any());

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("Many To Field", adornedTargetCollectionMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {mock(ForeignKey.class)},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(adornedTargetCollectionMetadata).setAvailableToTypes(isA(String[].class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).setExcluded(Mockito.<Boolean>any());
    verify(adornedTargetCollectionMetadata).setInheritedFromType("java.lang.Object");
    verify(foreignField).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    assertTrue(fields.containsKey("Property Name.Many To Field"));
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_thenHashMapEmpty() {
    // Arrange
    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(new HashMap<>());
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert that nothing has changed
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertTrue(fields.isEmpty());
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Property Name.foo} {@link BasicFieldMetadata}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_thenHashMapPropertyNameFooBasicFieldMetadata() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    stringFieldMetadataMap.put("foo", basicFieldMetadata);

    Metadata metadata = mock(Metadata.class);
    when(metadata.overrideMetadata(
            Mockito.<Class<Object>[]>any(),
            Mockito.<PropertyBuilder>any(),
            Mockito.<String>any(),
            Mockito.<Boolean>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DynamicEntityDao>any()))
        .thenReturn(stringFieldMetadataMap);
    doNothing()
        .when(metadata)
        .setDefaultFieldMetadataProvider(Mockito.<FieldMetadataProvider>any());
    metadata.setDefaultFieldMetadataProvider(mock(DefaultFieldMetadataProvider.class));

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();

    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getManyToField()).thenReturn("Many To Field");

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getManyToField()).thenReturn("Many To Field");
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {foreignKey},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {"Include Fields"},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert
    verify(foreignField).getManyToField();
    verify(foreignKey).getManyToField();
    verify(metadata)
        .overrideMetadata(
            isA(Class[].class),
            isA(PropertyBuilder.class),
            eq("PrefixProperty Name."),
            eq(true),
            eq("Dr Jane Doe"),
            eq("Configuration Key"),
            isA(DynamicEntityDao.class));
    verify(metadata).setDefaultFieldMetadataProvider(isA(FieldMetadataProvider.class));
    assertEquals(1, fields.size());
    FieldMetadata getResult = fields.get("Property Name.foo");
    assertTrue(getResult instanceof BasicFieldMetadata);
    assertSame(basicFieldMetadata, getResult);
  }

  /**
   * Test {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey, ForeignKey[], String[],
   * Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean,
   * String)}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then calls {@link DefaultFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest,
   *       Map)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicEntityDaoImpl#buildEntityProperties(Map, ForeignKey,
   * ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class,
   * List, String, Boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityDaoImpl.buildEntityProperties(Map, ForeignKey, ForeignKey[], String[], Boolean, String[], String[], String, String, String, Class, Class, List, String, Boolean, String)"
  })
  public void testBuildEntityProperties_whenEmptyArrayOfString_thenCallsOverrideViaXml() {
    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider =
        mock(DefaultFieldMetadataProvider.class);
    when(defaultFieldMetadataProvider.overrideViaXml(
            Mockito.<OverrideViaXmlRequest>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn(MetadataProviderResponse.HANDLED);
    doNothing()
        .when(defaultFieldMetadataProvider)
        .overrideExclusionsFromXml(
            Mockito.<OverrideViaXmlRequest>any(), Mockito.<Map<String, FieldMetadata>>any());

    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(defaultFieldMetadataProvider);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();
    dynamicEntityDaoImpl.setMetadata(metadata);
    HashMap<String, FieldMetadata> fields = new HashMap<>();
    ForeignKey foreignField = new ForeignKey();
    Class<Object> returnedClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act
    dynamicEntityDaoImpl.buildEntityProperties(
        fields,
        foreignField,
        new ForeignKey[] {new ForeignKey()},
        new String[] {"Additional Non Persistent Properties"},
        true,
        new String[] {},
        new String[] {"Exclude Fields"},
        "Configuration Key",
        "Dr Jane Doe",
        "Property Name",
        returnedClass,
        targetClass,
        new ArrayList<>(),
        "Prefix",
        true,
        "Parent Prefix");

    // Assert that nothing has changed
    verify(defaultFieldMetadataProvider)
        .overrideViaXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    verify(defaultFieldMetadataProvider)
        .overrideExclusionsFromXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    assertTrue(fields.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicEntityDaoImpl#setApplicationContext(ApplicationContext)}
   *   <li>{@link DynamicEntityDaoImpl#setDefaultFieldMetadataProvider(FieldMetadataProvider)}
   *   <li>{@link DynamicEntityDaoImpl#setDynamicDaoHelper(DynamicDaoHelper)}
   *   <li>{@link DynamicEntityDaoImpl#setEntityConfiguration(EntityConfiguration)}
   *   <li>{@link DynamicEntityDaoImpl#setFieldMetadataProviders(List)}
   *   <li>{@link DynamicEntityDaoImpl#setMetadata(Metadata)}
   *   <li>{@link DynamicEntityDaoImpl#getDefaultFieldMetadataProvider()}
   *   <li>{@link DynamicEntityDaoImpl#getDynamicDaoHelper()}
   *   <li>{@link DynamicEntityDaoImpl#getEntityConfiguration()}
   *   <li>{@link DynamicEntityDaoImpl#getFieldMetadataProviders()}
   *   <li>{@link DynamicEntityDaoImpl#getMetadata()}
   *   <li>{@link DynamicEntityDaoImpl#getStandardEntityManager()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldMetadataProvider DynamicEntityDaoImpl.getDefaultFieldMetadataProvider()",
    "DynamicDaoHelper DynamicEntityDaoImpl.getDynamicDaoHelper()",
    "EntityConfiguration DynamicEntityDaoImpl.getEntityConfiguration()",
    "List DynamicEntityDaoImpl.getFieldMetadataProviders()",
    "Metadata DynamicEntityDaoImpl.getMetadata()",
    "javax.persistence.EntityManager DynamicEntityDaoImpl.getStandardEntityManager()",
    "void DynamicEntityDaoImpl.setApplicationContext(ApplicationContext)",
    "void DynamicEntityDaoImpl.setDefaultFieldMetadataProvider(FieldMetadataProvider)",
    "void DynamicEntityDaoImpl.setDynamicDaoHelper(DynamicDaoHelper)",
    "void DynamicEntityDaoImpl.setEntityConfiguration(EntityConfiguration)",
    "void DynamicEntityDaoImpl.setFieldMetadataProviders(List)",
    "void DynamicEntityDaoImpl.setMetadata(Metadata)"
  })
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = new DynamicEntityDaoImpl();

    // Act
    dynamicEntityDaoImpl.setApplicationContext(mock(ApplicationContext.class));
    AdornedTargetCollectionFieldMetadataProvider defaultFieldMetadataProvider =
        new AdornedTargetCollectionFieldMetadataProvider();
    dynamicEntityDaoImpl.setDefaultFieldMetadataProvider(defaultFieldMetadataProvider);
    DynamicDaoHelperImpl dynamicDaoHelper = new DynamicDaoHelperImpl();
    dynamicEntityDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    dynamicEntityDaoImpl.setEntityConfiguration(entityConfiguration);
    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    dynamicEntityDaoImpl.setFieldMetadataProviders(fieldMetadataProviders);
    Metadata metadata = new Metadata();
    dynamicEntityDaoImpl.setMetadata(metadata);
    FieldMetadataProvider actualDefaultFieldMetadataProvider =
        dynamicEntityDaoImpl.getDefaultFieldMetadataProvider();
    DynamicDaoHelper actualDynamicDaoHelper = dynamicEntityDaoImpl.getDynamicDaoHelper();
    EntityConfiguration actualEntityConfiguration = dynamicEntityDaoImpl.getEntityConfiguration();
    List<FieldMetadataProvider> actualFieldMetadataProviders =
        dynamicEntityDaoImpl.getFieldMetadataProviders();
    Metadata actualMetadata = dynamicEntityDaoImpl.getMetadata();

    // Assert
    assertTrue(actualDynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertTrue(
        actualDefaultFieldMetadataProvider instanceof AdornedTargetCollectionFieldMetadataProvider);
    assertNull(dynamicEntityDaoImpl.getStandardEntityManager());
    assertNull(actualEntityConfiguration.getEntityContexts());
    assertTrue(actualFieldMetadataProviders.isEmpty());
    assertSame(fieldMetadataProviders, actualFieldMetadataProviders);
    assertSame(entityConfiguration, actualEntityConfiguration);
    assertSame(dynamicDaoHelper, actualDynamicDaoHelper);
    assertSame(metadata, actualMetadata);
    assertSame(defaultFieldMetadataProvider, actualDefaultFieldMetadataProvider);
  }
}
