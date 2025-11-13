package org.broadleafcommerce.common.presentation.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DynamicSupportedFieldType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DynamicSupportedFieldTypeDiffblueTest {
  @Autowired private DynamicSupportedFieldType dynamicSupportedFieldType;

  /**
   * Test {@link DynamicSupportedFieldType#getInstance(String)}.
   *
   * <p>Method under test: {@link DynamicSupportedFieldType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DynamicSupportedFieldType DynamicSupportedFieldType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange, Act and Assert
    assertNull(DynamicSupportedFieldType.getInstance("Type"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicSupportedFieldType#DynamicSupportedFieldType()}
   *   <li>{@link DynamicSupportedFieldType#getFriendlyType()}
   *   <li>{@link DynamicSupportedFieldType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicSupportedFieldType.<init>()",
    "String DynamicSupportedFieldType.getFriendlyType()",
    "String DynamicSupportedFieldType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DynamicSupportedFieldType actualDynamicSupportedFieldType = new DynamicSupportedFieldType();
    String actualFriendlyType = actualDynamicSupportedFieldType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualDynamicSupportedFieldType.getType());
  }

  /**
   * Test {@link DynamicSupportedFieldType#DynamicSupportedFieldType(String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicSupportedFieldType#DynamicSupportedFieldType(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicSupportedFieldType.<init>(String, String)"})
  public void testNewDynamicSupportedFieldType_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new DynamicSupportedFieldType(
                "ADDITIONAL_FOREIGN_KEY|org.broadleafcommerce.core.catalog.domain.Category",
                "Friendly Type"));
  }

  /**
   * Test {@link DynamicSupportedFieldType#getTypes()}.
   *
   * <p>Method under test: {@link DynamicSupportedFieldType#getTypes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DynamicSupportedFieldType.getTypes()"})
  public void testGetTypes() {
    // Arrange and Act
    List<DynamicSupportedFieldType> actualTypes = DynamicSupportedFieldType.getTypes();

    // Assert
    assertEquals(8, actualTypes.size());
    DynamicSupportedFieldType getResult = actualTypes.get(6);
    assertEquals(
        "ADDITIONAL_FOREIGN_KEY|org.broadleafcommerce.core.catalog.domain.Category",
        getResult.getType());
    DynamicSupportedFieldType getResult2 = actualTypes.get(5);
    assertEquals(
        "ADDITIONAL_FOREIGN_KEY|org.broadleafcommerce.core.catalog.domain.Product",
        getResult2.getType());
    DynamicSupportedFieldType getResult3 = actualTypes.get(4);
    assertEquals("ASSET_LOOKUP", getResult3.getType());
    DynamicSupportedFieldType getResult4 = actualTypes.get(3);
    assertEquals("COLOR", getResult4.getType());
    assertEquals("Category Lookup", getResult.getFriendlyType());
    assertEquals("Color", getResult4.getFriendlyType());
    DynamicSupportedFieldType getResult5 = actualTypes.get(7);
    assertEquals("DATE", getResult5.getType());
    assertEquals("Date", getResult5.getFriendlyType());
    DynamicSupportedFieldType getResult6 = actualTypes.get(1);
    assertEquals("HTML", getResult6.getType());
    assertEquals("Image", getResult3.getFriendlyType());
    DynamicSupportedFieldType getResult7 = actualTypes.get(2);
    assertEquals("MONEY", getResult7.getType());
    assertEquals("Money", getResult7.getFriendlyType());
    assertEquals("Product Lookup", getResult2.getFriendlyType());
    assertEquals("Rich Text", getResult6.getFriendlyType());
    DynamicSupportedFieldType getResult8 = actualTypes.get(0);
    assertEquals("STRING", getResult8.getType());
    assertEquals("String", getResult8.getFriendlyType());
  }

  /**
   * Test {@link DynamicSupportedFieldType#equals(Object)}, and {@link
   * DynamicSupportedFieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicSupportedFieldType#equals(Object)}
   *   <li>{@link DynamicSupportedFieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DynamicSupportedFieldType.equals(Object)",
    "int DynamicSupportedFieldType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DynamicSupportedFieldType dynamicSupportedFieldType = DynamicSupportedFieldType.ASSET_LOOKUP;
    DynamicSupportedFieldType dynamicSupportedFieldType2 = DynamicSupportedFieldType.ASSET_LOOKUP;

    // Act and Assert
    assertEquals(dynamicSupportedFieldType, dynamicSupportedFieldType2);
    assertEquals(dynamicSupportedFieldType.hashCode(), dynamicSupportedFieldType2.hashCode());
  }

  /**
   * Test {@link DynamicSupportedFieldType#equals(Object)}, and {@link
   * DynamicSupportedFieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicSupportedFieldType#equals(Object)}
   *   <li>{@link DynamicSupportedFieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DynamicSupportedFieldType.equals(Object)",
    "int DynamicSupportedFieldType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DynamicSupportedFieldType dynamicSupportedFieldType = new DynamicSupportedFieldType();
    DynamicSupportedFieldType dynamicSupportedFieldType2 = new DynamicSupportedFieldType();

    // Act and Assert
    assertEquals(dynamicSupportedFieldType, dynamicSupportedFieldType2);
    assertEquals(dynamicSupportedFieldType.hashCode(), dynamicSupportedFieldType2.hashCode());
  }

  /**
   * Test {@link DynamicSupportedFieldType#equals(Object)}, and {@link
   * DynamicSupportedFieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicSupportedFieldType#equals(Object)}
   *   <li>{@link DynamicSupportedFieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DynamicSupportedFieldType.equals(Object)",
    "int DynamicSupportedFieldType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DynamicSupportedFieldType dynamicSupportedFieldType = DynamicSupportedFieldType.ASSET_LOOKUP;

    // Act and Assert
    assertEquals(dynamicSupportedFieldType, dynamicSupportedFieldType);
    int expectedHashCodeResult = dynamicSupportedFieldType.hashCode();
    assertEquals(expectedHashCodeResult, dynamicSupportedFieldType.hashCode());
  }

  /**
   * Test {@link DynamicSupportedFieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DynamicSupportedFieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DynamicSupportedFieldType.equals(Object)",
    "int DynamicSupportedFieldType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        DynamicSupportedFieldType.CATEGORY_LOOKUP, DynamicSupportedFieldType.ASSET_LOOKUP);
  }

  /**
   * Test {@link DynamicSupportedFieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DynamicSupportedFieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DynamicSupportedFieldType.equals(Object)",
    "int DynamicSupportedFieldType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DynamicSupportedFieldType(), DynamicSupportedFieldType.ASSET_LOOKUP);
  }

  /**
   * Test {@link DynamicSupportedFieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DynamicSupportedFieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DynamicSupportedFieldType.equals(Object)",
    "int DynamicSupportedFieldType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DynamicSupportedFieldType.ASSET_LOOKUP, null);
  }

  /**
   * Test {@link DynamicSupportedFieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DynamicSupportedFieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DynamicSupportedFieldType.equals(Object)",
    "int DynamicSupportedFieldType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        DynamicSupportedFieldType.ASSET_LOOKUP, "Different type to DynamicSupportedFieldType");
  }
}
