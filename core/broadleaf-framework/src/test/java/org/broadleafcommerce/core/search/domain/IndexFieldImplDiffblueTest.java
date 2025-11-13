package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IndexFieldImplDiffblueTest {
  /**
   * Test {@link IndexFieldImpl#equals(Object)}, and {@link IndexFieldImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IndexFieldImpl#equals(Object)}
   *   <li>{@link IndexFieldImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexFieldImpl.equals(Object)", "int IndexFieldImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(null);
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    IndexFieldImpl indexFieldImpl2 = new IndexFieldImpl();
    indexFieldImpl2.setField(null);
    indexFieldImpl2.setFieldTypes(new ArrayList<>());
    indexFieldImpl2.setId(1L);
    indexFieldImpl2.setSearchable(true);

    // Act and Assert
    assertEquals(indexFieldImpl, indexFieldImpl2);
    assertEquals(indexFieldImpl.hashCode(), indexFieldImpl2.hashCode());
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}, and {@link IndexFieldImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IndexFieldImpl#equals(Object)}
   *   <li>{@link IndexFieldImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexFieldImpl.equals(Object)", "int IndexFieldImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    // Act and Assert
    assertEquals(indexFieldImpl, indexFieldImpl);
    int expectedHashCodeResult = indexFieldImpl.hashCode();
    assertEquals(expectedHashCodeResult, indexFieldImpl.hashCode());
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexFieldImpl.equals(Object)", "int IndexFieldImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(null);
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    IndexFieldImpl indexFieldImpl2 = new IndexFieldImpl();
    indexFieldImpl2.setField(new FieldImpl());
    indexFieldImpl2.setFieldTypes(new ArrayList<>());
    indexFieldImpl2.setId(1L);
    indexFieldImpl2.setSearchable(true);

    // Act and Assert
    assertNotEquals(indexFieldImpl, indexFieldImpl2);
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexFieldImpl.equals(Object)", "int IndexFieldImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    // Act and Assert
    assertNotEquals(indexFieldImpl, null);
  }

  /**
   * Test {@link IndexFieldImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexFieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexFieldImpl.equals(Object)", "int IndexFieldImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setFieldTypes(new ArrayList<>());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);

    // Act and Assert
    assertNotEquals(indexFieldImpl, "Different type to IndexFieldImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link IndexFieldImpl}
   *   <li>{@link IndexFieldImpl#setField(Field)}
   *   <li>{@link IndexFieldImpl#setFieldTypes(List)}
   *   <li>{@link IndexFieldImpl#setId(Long)}
   *   <li>{@link IndexFieldImpl#setSearchable(Boolean)}
   *   <li>{@link IndexFieldImpl#getField()}
   *   <li>{@link IndexFieldImpl#getFieldTypes()}
   *   <li>{@link IndexFieldImpl#getId()}
   *   <li>{@link IndexFieldImpl#getSearchable()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IndexFieldImpl.<init>()",
    "Field IndexFieldImpl.getField()",
    "List IndexFieldImpl.getFieldTypes()",
    "Long IndexFieldImpl.getId()",
    "Boolean IndexFieldImpl.getSearchable()",
    "void IndexFieldImpl.setField(Field)",
    "void IndexFieldImpl.setFieldTypes(List)",
    "void IndexFieldImpl.setId(Long)",
    "void IndexFieldImpl.setSearchable(Boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    IndexFieldImpl actualIndexFieldImpl = new IndexFieldImpl();
    FieldImpl field = new FieldImpl();
    actualIndexFieldImpl.setField(field);
    ArrayList<IndexFieldType> fieldTypes = new ArrayList<>();
    actualIndexFieldImpl.setFieldTypes(fieldTypes);
    actualIndexFieldImpl.setId(1L);
    actualIndexFieldImpl.setSearchable(true);
    Field actualField = actualIndexFieldImpl.getField();
    List<IndexFieldType> actualFieldTypes = actualIndexFieldImpl.getFieldTypes();
    Long actualId = actualIndexFieldImpl.getId();
    Boolean actualSearchable = actualIndexFieldImpl.getSearchable();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertTrue(actualFieldTypes.isEmpty());
    assertTrue(actualSearchable);
    assertSame(fieldTypes, actualFieldTypes);
    assertSame(field, actualField);
  }
}
