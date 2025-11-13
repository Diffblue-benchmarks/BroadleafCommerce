package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ParentRecordStructureDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParentRecordStructure#ParentRecordStructure()}
   *   <li>{@link ParentRecordStructure#setParentMetadata(ClassMetadata)}
   *   <li>{@link ParentRecordStructure#setParentRecord(Entity)}
   *   <li>{@link ParentRecordStructure#getParentMetadata()}
   *   <li>{@link ParentRecordStructure#getParentRecord()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ParentRecordStructure.<init>()",
    "void ParentRecordStructure.<init>(Entity, ClassMetadata)",
    "ClassMetadata ParentRecordStructure.getParentMetadata()",
    "Entity ParentRecordStructure.getParentRecord()",
    "void ParentRecordStructure.setParentMetadata(ClassMetadata)",
    "void ParentRecordStructure.setParentRecord(Entity)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ParentRecordStructure actualParentRecordStructure = new ParentRecordStructure();
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[] {new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());
    actualParentRecordStructure.setParentMetadata(parentMetadata);
    Entity parentRecord = new Entity();
    actualParentRecordStructure.setParentRecord(parentRecord);
    ClassMetadata actualParentMetadata = actualParentRecordStructure.getParentMetadata();

    // Assert
    assertSame(parentMetadata, actualParentMetadata);
    assertSame(parentRecord, actualParentRecordStructure.getParentRecord());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParentRecordStructure#ParentRecordStructure(Entity, ClassMetadata)}
   *   <li>{@link ParentRecordStructure#setParentMetadata(ClassMetadata)}
   *   <li>{@link ParentRecordStructure#setParentRecord(Entity)}
   *   <li>{@link ParentRecordStructure#getParentMetadata()}
   *   <li>{@link ParentRecordStructure#getParentRecord()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ParentRecordStructure.<init>()",
    "void ParentRecordStructure.<init>(Entity, ClassMetadata)",
    "ClassMetadata ParentRecordStructure.getParentMetadata()",
    "Entity ParentRecordStructure.getParentRecord()",
    "void ParentRecordStructure.setParentMetadata(ClassMetadata)",
    "void ParentRecordStructure.setParentRecord(Entity)"
  })
  public void testGettersAndSetters_givenType_whenEntity() {
    // Arrange
    Entity parentRecord = new Entity();

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[] {new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    // Act
    ParentRecordStructure actualParentRecordStructure =
        new ParentRecordStructure(parentRecord, parentMetadata);
    ClassMetadata parentMetadata2 = new ClassMetadata();
    parentMetadata2.setCeilingType("Type");
    parentMetadata2.setCurrencyCode("GBP");
    parentMetadata2.setPolymorphicEntities(new ClassTree());
    parentMetadata2.setProperties(new Property[] {new Property()});
    parentMetadata2.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata2.setTabAndGroupMetadata(new HashMap<>());
    actualParentRecordStructure.setParentMetadata(parentMetadata2);
    Entity parentRecord2 = new Entity();
    actualParentRecordStructure.setParentRecord(parentRecord2);
    ClassMetadata actualParentMetadata = actualParentRecordStructure.getParentMetadata();

    // Assert
    assertSame(parentMetadata2, actualParentMetadata);
    assertSame(parentRecord2, actualParentRecordStructure.getParentRecord());
  }

  /**
   * Test {@link ParentRecordStructure#clonePersistencePerspectiveItem()}.
   *
   * <p>Method under test: {@link ParentRecordStructure#clonePersistencePerspectiveItem()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePerspectiveItem ParentRecordStructure.clonePersistencePerspectiveItem()"
  })
  public void testClonePersistencePerspectiveItem() {
    // Arrange
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();

    // Act
    PersistencePerspectiveItem actualClonePersistencePerspectiveItemResult =
        parentRecordStructure.clonePersistencePerspectiveItem();

    // Assert
    assertTrue(actualClonePersistencePerspectiveItemResult instanceof ParentRecordStructure);
    assertEquals(parentRecordStructure, actualClonePersistencePerspectiveItemResult);
  }

  /**
   * Test {@link ParentRecordStructure#toString()}.
   *
   * <p>Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ParentRecordStructure.toString()"})
  public void testToString() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());
    parentMetadata.setProperties(null);
    ParentRecordStructure parentRecordStructure =
        new ParentRecordStructure(new Entity(), parentMetadata);

    // Act and Assert
    assertEquals(
        "ParentRecordStructure{Entity{isValidationFailure=false, isDirty=false, properties=null, type=null}'}",
        parentRecordStructure.toString());
  }

  /**
   * Test {@link ParentRecordStructure#toString()}.
   *
   * <p>Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ParentRecordStructure.toString()"})
  public void testToString2() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());
    parentMetadata.setProperties(new Property[] {new Property("ParentRecordStructure{", "42")});
    ParentRecordStructure parentRecordStructure =
        new ParentRecordStructure(new Entity(), parentMetadata);

    // Act and Assert
    assertEquals(
        "ParentRecordStructure{Entity{isValidationFailure=false, isDirty=false, properties=null, type=null}',"
            + " parentMetadata=[Property{name='ParentRecordStructure{', value='42', isDirty=false, enabled=true}]}",
        parentRecordStructure.toString());
  }

  /**
   * Test {@link ParentRecordStructure#toString()}.
   *
   * <p>Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ParentRecordStructure.toString()"})
  public void testToString3() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property property = new Property();
    parentMetadata.setProperties(new Property[] {property, new Property()});
    ParentRecordStructure parentRecordStructure =
        new ParentRecordStructure(new Entity(), parentMetadata);

    // Act and Assert
    assertEquals(
        "ParentRecordStructure{Entity{isValidationFailure=false, isDirty=false, properties=null, type=null}',"
            + " parentMetadata=[Property{name='null', value='null', isDirty=false, enabled=true}, Property{name='null',"
            + " value='null', isDirty=false, enabled=true}]}",
        parentRecordStructure.toString());
  }

  /**
   * Test {@link ParentRecordStructure#toString()}.
   *
   * <ul>
   *   <li>Given {@link ClassMetadata} (default constructor) Properties is array of {@link Property}
   *       with {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ParentRecordStructure.toString()"})
  public void testToString_givenClassMetadataPropertiesIsArrayOfPropertyWithNull() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());
    parentMetadata.setProperties(new Property[] {null});
    ParentRecordStructure parentRecordStructure =
        new ParentRecordStructure(new Entity(), parentMetadata);

    // Act and Assert
    assertEquals(
        "ParentRecordStructure{Entity{isValidationFailure=false, isDirty=false, properties=null, type=null}',"
            + " parentMetadata=[null]}",
        parentRecordStructure.toString());
  }

  /**
   * Test {@link ParentRecordStructure#toString()}.
   *
   * <ul>
   *   <li>Given {@link ClassMetadata} (default constructor) Properties is array of {@link Property}
   *       with {@link Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ParentRecordStructure.toString()"})
  public void testToString_givenClassMetadataPropertiesIsArrayOfPropertyWithProperty() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());
    parentMetadata.setProperties(new Property[] {new Property()});
    ParentRecordStructure parentRecordStructure =
        new ParentRecordStructure(new Entity(), parentMetadata);

    // Act and Assert
    assertEquals(
        "ParentRecordStructure{Entity{isValidationFailure=false, isDirty=false, properties=null, type=null}',"
            + " parentMetadata=[Property{name='null', value='null', isDirty=false, enabled=true}]}",
        parentRecordStructure.toString());
  }

  /**
   * Test {@link ParentRecordStructure#toString()}.
   *
   * <ul>
   *   <li>Given {@link ParentRecordStructure#ParentRecordStructure()}.
   *   <li>Then return {@code ParentRecordStructure{}}.
   * </ul>
   *
   * <p>Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ParentRecordStructure.toString()"})
  public void testToString_givenParentRecordStructure_thenReturnParentRecordStructure() {
    // Arrange, Act and Assert
    assertEquals("ParentRecordStructure{}", new ParentRecordStructure().toString());
  }

  /**
   * Test {@link ParentRecordStructure#equals(Object)}, and {@link
   * ParentRecordStructure#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParentRecordStructure#equals(Object)}
   *   <li>{@link ParentRecordStructure#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParentRecordStructure.equals(Object)",
    "int ParentRecordStructure.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    ParentRecordStructure parentRecordStructure2 = new ParentRecordStructure();

    // Act and Assert
    assertEquals(parentRecordStructure, parentRecordStructure2);
    assertEquals(parentRecordStructure.hashCode(), parentRecordStructure2.hashCode());
  }

  /**
   * Test {@link ParentRecordStructure#equals(Object)}, and {@link
   * ParentRecordStructure#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParentRecordStructure#equals(Object)}
   *   <li>{@link ParentRecordStructure#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParentRecordStructure.equals(Object)",
    "int ParentRecordStructure.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();

    // Act and Assert
    assertEquals(parentRecordStructure, parentRecordStructure);
    int expectedHashCodeResult = parentRecordStructure.hashCode();
    assertEquals(expectedHashCodeResult, parentRecordStructure.hashCode());
  }

  /**
   * Test {@link ParentRecordStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParentRecordStructure.equals(Object)",
    "int ParentRecordStructure.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[] {new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());
    ParentRecordStructure parentRecordStructure =
        new ParentRecordStructure(new Entity(), parentMetadata);

    // Act and Assert
    assertNotEquals(parentRecordStructure, new ParentRecordStructure());
  }

  /**
   * Test {@link ParentRecordStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParentRecordStructure.equals(Object)",
    "int ParentRecordStructure.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[] {new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());
    ParentRecordStructure parentRecordStructure2 =
        new ParentRecordStructure(new Entity(), parentMetadata);

    // Act and Assert
    assertNotEquals(parentRecordStructure, parentRecordStructure2);
  }

  /**
   * Test {@link ParentRecordStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParentRecordStructure.equals(Object)",
    "int ParentRecordStructure.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[] {new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    parentRecordStructure.setParentMetadata(parentMetadata);

    // Act and Assert
    assertNotEquals(parentRecordStructure, new ParentRecordStructure());
  }

  /**
   * Test {@link ParentRecordStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParentRecordStructure.equals(Object)",
    "int ParentRecordStructure.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[] {new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());
    ParentRecordStructure parentRecordStructure =
        new ParentRecordStructure(new Entity(), parentMetadata);

    ParentRecordStructure parentRecordStructure2 = new ParentRecordStructure();
    parentRecordStructure2.setParentRecord(new Entity());

    // Act and Assert
    assertNotEquals(parentRecordStructure, parentRecordStructure2);
  }

  /**
   * Test {@link ParentRecordStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParentRecordStructure.equals(Object)",
    "int ParentRecordStructure.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[] {new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    ParentRecordStructure parentRecordStructure2 = new ParentRecordStructure();
    parentRecordStructure2.setParentMetadata(parentMetadata);

    // Act and Assert
    assertNotEquals(parentRecordStructure, parentRecordStructure2);
  }

  /**
   * Test {@link ParentRecordStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParentRecordStructure.equals(Object)",
    "int ParentRecordStructure.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParentRecordStructure(), null);
  }

  /**
   * Test {@link ParentRecordStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParentRecordStructure.equals(Object)",
    "int ParentRecordStructure.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParentRecordStructure(), "Different type to ParentRecordStructure");
  }
}
