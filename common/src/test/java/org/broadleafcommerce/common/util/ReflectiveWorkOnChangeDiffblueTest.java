package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponents.UriTemplateVariables;

public class ReflectiveWorkOnChangeDiffblueTest {
  /**
   * Test {@link ReflectiveWorkOnChange#doWork(Collection)}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveWorkOnChange#doWork(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReflectiveWorkOnChange.doWork(Collection)"})
  public void testDoWork_givenNull_field_whenArrayListAddNull_field() {
    // Arrange
    ReflectiveWorkOnChange reflectiveWorkOnChange =
        new ReflectiveWorkOnChange(BLCFieldUtils.NULL_FIELD, "Method Name");

    ArrayList<Object> changed = new ArrayList<>();
    changed.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> reflectiveWorkOnChange.doWork(changed));
  }

  /**
   * Test {@link ReflectiveWorkOnChange#doWork(Collection)}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveWorkOnChange#doWork(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReflectiveWorkOnChange.doWork(Collection)"})
  public void testDoWork_givenNull_field_whenArrayListAddNull_field2() {
    // Arrange
    ReflectiveWorkOnChange reflectiveWorkOnChange =
        new ReflectiveWorkOnChange(BLCFieldUtils.NULL_FIELD, "Method Name");

    ArrayList<Object> changed = new ArrayList<>();
    changed.add(BLCFieldUtils.NULL_FIELD);
    changed.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> reflectiveWorkOnChange.doWork(changed));
  }

  /**
   * Test {@link ReflectiveWorkOnChange#doWork(Collection)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveWorkOnChange#doWork(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReflectiveWorkOnChange.doWork(Collection)"})
  public void testDoWork_thenThrowIllegalArgumentException() {
    // Arrange
    ReflectiveWorkOnChange reflectiveWorkOnChange =
        new ReflectiveWorkOnChange(BLCFieldUtils.NULL_FIELD, "Method Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> reflectiveWorkOnChange.doWork(new ArrayList<>()));
  }

  /**
   * Test {@link ReflectiveWorkOnChange#searchForMethod(Class, Object)}.
   *
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveWorkOnChange#searchForMethod(Class, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.reflect.Method ReflectiveWorkOnChange.searchForMethod(Class, Object)"
  })
  public void testSearchForMethod_whenNull_field_thenReturnNull() {
    // Arrange
    ReflectiveWorkOnChange reflectiveWorkOnChange =
        new ReflectiveWorkOnChange(BLCFieldUtils.NULL_FIELD, "Method Name");
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertNull(reflectiveWorkOnChange.searchForMethod(targetClass, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link ReflectiveWorkOnChange#searchForMethod(Class, Object)}.
   *
   * <ul>
   *   <li>When {@link UriComponents.UriTemplateVariables#SKIP_VALUE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveWorkOnChange#searchForMethod(Class, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.reflect.Method ReflectiveWorkOnChange.searchForMethod(Class, Object)"
  })
  public void testSearchForMethod_whenSkip_value_thenReturnNull() {
    // Arrange
    ReflectiveWorkOnChange reflectiveWorkOnChange =
        new ReflectiveWorkOnChange(BLCFieldUtils.NULL_FIELD, "Method Name");
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertNull(
        reflectiveWorkOnChange.searchForMethod(targetClass, UriTemplateVariables.SKIP_VALUE));
  }
}
