package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.annotation.Annotation;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BLCAnnotationUtilsDiffblueTest {
  /**
   * Test {@link BLCAnnotationUtils#getAnnotationFromClassOrInterface(Class, Class)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCAnnotationUtils#getAnnotationFromClassOrInterface(Class,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Annotation BLCAnnotationUtils.getAnnotationFromClassOrInterface(Class, Class)"
  })
  public void testGetAnnotationFromClassOrInterface_thenReturnNull() {
    // Arrange
    Class<Annotation> annotationClass = Annotation.class;
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(BLCAnnotationUtils.getAnnotationFromClassOrInterface(annotationClass, clazz));
  }
}
