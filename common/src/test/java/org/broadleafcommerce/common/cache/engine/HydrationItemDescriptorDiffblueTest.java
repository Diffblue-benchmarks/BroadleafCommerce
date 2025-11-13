package org.broadleafcommerce.common.cache.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Method;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HydrationItemDescriptorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link HydrationItemDescriptor}
   *   <li>{@link HydrationItemDescriptor#setFactoryMethod(String)}
   *   <li>{@link HydrationItemDescriptor#setMutators(Method[])}
   *   <li>{@link HydrationItemDescriptor#getFactoryMethod()}
   *   <li>{@link HydrationItemDescriptor#getMutators()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HydrationItemDescriptor.<init>()",
    "String HydrationItemDescriptor.getFactoryMethod()",
    "Method[] HydrationItemDescriptor.getMutators()",
    "void HydrationItemDescriptor.setFactoryMethod(String)",
    "void HydrationItemDescriptor.setMutators(Method[])"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    HydrationItemDescriptor actualHydrationItemDescriptor = new HydrationItemDescriptor();
    actualHydrationItemDescriptor.setFactoryMethod("Factory Method");
    Method[] mutators = new Method[] {null};
    actualHydrationItemDescriptor.setMutators(mutators);
    String actualFactoryMethod = actualHydrationItemDescriptor.getFactoryMethod();
    Method[] actualMutators = actualHydrationItemDescriptor.getMutators();

    // Assert
    assertEquals("Factory Method", actualFactoryMethod);
    assertNull(actualMutators[0]);
    assertEquals(1, actualMutators.length);
    assertSame(mutators, actualMutators);
  }
}
