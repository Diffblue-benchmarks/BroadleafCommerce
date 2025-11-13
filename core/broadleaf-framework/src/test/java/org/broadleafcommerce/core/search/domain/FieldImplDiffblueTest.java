package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FieldImplDiffblueTest {
  /**
   * Test {@link FieldImpl#equals(Object)}, and {@link FieldImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldImpl#equals(Object)}
   *   <li>{@link FieldImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldImpl.equals(Object)", "int FieldImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);

    // Act and Assert
    assertEquals(fieldImpl, fieldImpl2);
    assertEquals(fieldImpl.hashCode(), fieldImpl2.hashCode());
  }

  /**
   * Test {@link FieldImpl#equals(Object)}, and {@link FieldImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldImpl#equals(Object)}
   *   <li>{@link FieldImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldImpl.equals(Object)", "int FieldImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertEquals(fieldImpl, fieldImpl);
    int expectedHashCodeResult = fieldImpl.hashCode();
    assertEquals(expectedHashCodeResult, fieldImpl.hashCode());
  }

  /**
   * Test {@link FieldImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldImpl.equals(Object)", "int FieldImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CUSTOMER);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);

    // Act and Assert
    assertNotEquals(fieldImpl, fieldImpl2);
  }

  /**
   * Test {@link FieldImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldImpl.equals(Object)", "int FieldImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("CATEGORY");
    fieldImpl.setTranslatable(true);

    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);

    // Act and Assert
    assertNotEquals(fieldImpl, fieldImpl2);
  }

  /**
   * Test {@link FieldImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldImpl.equals(Object)", "int FieldImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertNotEquals(fieldImpl, null);
  }

  /**
   * Test {@link FieldImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldImpl.equals(Object)", "int FieldImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertNotEquals(fieldImpl, "Different type to FieldImpl");
  }
}
