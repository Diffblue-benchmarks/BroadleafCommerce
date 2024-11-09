/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.cache.engine;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Method;
import java.util.Map;
import org.junit.Test;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.EmptyVisitor;

public class HydrationScannerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HydrationScanner#HydrationScanner(Class, Class)}
   *   <li>{@link HydrationScanner#visitAttribute(Attribute)}
   *   <li>{@link HydrationScanner#visitEnd()}
   *   <li>{@link HydrationScanner#visitEnum(String, String, String)}
   *   <li>{@link HydrationScanner#visitInnerClass(String, String, String, int)}
   *   <li>{@link HydrationScanner#visitOuterClass(String, String, String)}
   *   <li>{@link HydrationScanner#visitSource(String, String)}
   *   <li>{@link HydrationScanner#getCacheMutators()}
   *   <li>{@link HydrationScanner#getCacheRegion()}
   *   <li>{@link HydrationScanner#getIdMutators()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Class<Object> topEntityClass = Object.class;
    Class<Object> entityClass = Object.class;

    // Act
    HydrationScanner actualHydrationScanner = new HydrationScanner(topEntityClass, entityClass);
    actualHydrationScanner.visitAttribute(null);
    actualHydrationScanner.visitEnd();
    actualHydrationScanner.visitEnum("Arg0", "Arg1", "Arg2");
    actualHydrationScanner.visitInnerClass("Arg0", "Arg1", "Arg2", 1);
    actualHydrationScanner.visitOuterClass("Arg0", "Arg1", "Arg2");
    actualHydrationScanner.visitSource("Arg0", "Arg1");
    Map<String, HydrationItemDescriptor> actualCacheMutators = actualHydrationScanner.getCacheMutators();
    actualHydrationScanner.getCacheRegion();
    Map<String, Method[]> actualIdMutators = actualHydrationScanner.getIdMutators();

    // Assert that nothing has changed
    assertTrue(actualCacheMutators.isEmpty());
    assertTrue(actualIdMutators.isEmpty());
  }

  /**
   * Test {@link HydrationScanner#visitAnnotation(String, String)} with
   * {@code String}, {@code String}.
   * <p>
   * Method under test: {@link HydrationScanner#visitAnnotation(String, String)}
   */
  @Test
  public void testVisitAnnotationWithStringString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Class<Object> topEntityClass = Object.class;
    Class<Object> entityClass = Object.class;
    HydrationScanner hydrationScanner = new HydrationScanner(topEntityClass, entityClass);

    // Act and Assert
    assertSame(hydrationScanner, hydrationScanner.visitAnnotation("Arg0", "Arg1"));
  }

  /**
   * Test {@link HydrationScanner#visitArray(String)}.
   * <p>
   * Method under test: {@link HydrationScanner#visitArray(String)}
   */
  @Test
  public void testVisitArray() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Class<Object> topEntityClass = Object.class;
    Class<Object> entityClass = Object.class;
    HydrationScanner hydrationScanner = new HydrationScanner(topEntityClass, entityClass);

    // Act and Assert
    assertSame(hydrationScanner, hydrationScanner.visitArray("Arg0"));
  }

  /**
   * Test
   * {@link HydrationScanner#visit(int, int, String, String, String, String[])}
   * with {@code arg0}, {@code arg1}, {@code arg2}, {@code arg3}, {@code arg4},
   * {@code arg5}.
   * <ul>
   *   <li>When {@code Arg2}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HydrationScanner#visit(int, int, String, String, String, String[])}
   */
  @Test
  public void testVisitWithArg0Arg1Arg2Arg3Arg4Arg5_whenArg2_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Class<Object> topEntityClass = Object.class;
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new HydrationScanner(topEntityClass, entityClass)).visit(1, 1, "Arg2",
        "Arg3", "Arg4", new String[]{"Arg5"}));
  }

  /**
   * Test
   * {@link HydrationScanner#visit(int, int, String, String, String, String[])}
   * with {@code arg0}, {@code arg1}, {@code arg2}, {@code arg3}, {@code arg4},
   * {@code arg5}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HydrationScanner#visit(int, int, String, String, String, String[])}
   */
  @Test
  public void testVisitWithArg0Arg1Arg2Arg3Arg4Arg5_whenSlash_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Class<Object> topEntityClass = Object.class;
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new HydrationScanner(topEntityClass, entityClass)).visit(1, 1, "/",
        "Arg3", "Arg4", new String[]{"Arg5"}));
  }

  /**
   * Test
   * {@link HydrationScanner#visitMethod(int, String, String, String, String[])}.
   * <p>
   * Method under test:
   * {@link HydrationScanner#visitMethod(int, String, String, String, String[])}
   */
  @Test
  public void testVisitMethod() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Class<Object> topEntityClass = Object.class;
    Class<Object> entityClass = Object.class;

    // Act
    MethodVisitor actualVisitMethodResult = (new HydrationScanner(topEntityClass, entityClass)).visitMethod(1, "Arg1",
        "Arg2", "Arg3", new String[]{"Arg4"});

    // Assert
    assertTrue(actualVisitMethodResult instanceof EmptyVisitor);
    assertSame(actualVisitMethodResult, actualVisitMethodResult.visitAnnotationDefault());
  }
}
