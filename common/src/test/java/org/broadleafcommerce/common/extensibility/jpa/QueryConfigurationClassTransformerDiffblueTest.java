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
package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.ArrayMemberValue;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class QueryConfigurationClassTransformerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link QueryConfigurationClassTransformer#QueryConfigurationClassTransformer(List, List, List)}
   *   <li>
   * {@link QueryConfigurationClassTransformer#compileJPAProperties(Properties, Object)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws Exception {
    // Arrange
    ArrayList<NamedQuery> namedQueries = new ArrayList<>();
    ArrayList<NamedNativeQuery> nativeQueries = new ArrayList<>();

    // Act
    QueryConfigurationClassTransformer actualQueryConfigurationClassTransformer = new QueryConfigurationClassTransformer(
        namedQueries, nativeQueries, new ArrayList<>());
    actualQueryConfigurationClassTransformer.compileJPAProperties(new Properties(), BLCFieldUtils.NULL_FIELD);

    // Assert that nothing has changed
    assertTrue(actualQueryConfigurationClassTransformer.managedClassNames.isEmpty());
    assertTrue(actualQueryConfigurationClassTransformer.namedQueries.isEmpty());
    assertTrue(actualQueryConfigurationClassTransformer.nativeQueries.isEmpty());
  }

  /**
   * Test
   * {@link QueryConfigurationClassTransformer#processClassLevelAnnotations(ConstPool, ClassPool, Object)}.
   * <ul>
   *   <li>Then calls {@link CtClass#getComponentType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueryConfigurationClassTransformer#processClassLevelAnnotations(ConstPool, ClassPool, Object)}
   */
  @Test
  public void testProcessClassLevelAnnotations_thenCallsGetComponentType() throws NotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<NamedQuery> namedQueries = new ArrayList<>();
    ArrayList<NamedNativeQuery> nativeQueries = new ArrayList<>();
    QueryConfigurationClassTransformer queryConfigurationClassTransformer = new QueryConfigurationClassTransformer(
        namedQueries, nativeQueries, new ArrayList<>());
    CtClass c = mock(CtClass.class);
    when(c.getComponentType()).thenThrow(new NotFoundException("Msg"));
    when(c.isArray()).thenReturn(true);
    when(c.getName()).thenReturn("Name");

    ConstPool constantPool = new ConstPool("Thisclass");
    constantPool.addClassInfo(c);

    // Act
    queryConfigurationClassTransformer.processClassLevelAnnotations(constantPool, ClassPool.getDefault(),
        BLCFieldUtils.NULL_FIELD);

    // Assert that nothing has changed
    verify(c).getComponentType();
    verify(c).getName();
    verify(c, atLeast(1)).isArray();
  }

  /**
   * Test
   * {@link QueryConfigurationClassTransformer#prepareNativeQueries(ConstPool, ClassPool, ArrayMemberValue)}.
   * <p>
   * Method under test:
   * {@link QueryConfigurationClassTransformer#prepareNativeQueries(ConstPool, ClassPool, ArrayMemberValue)}
   */
  @Test
  public void testPrepareNativeQueries() throws NotFoundException {
    // Arrange
    ArrayList<NamedQuery> namedQueries = new ArrayList<>();
    ArrayList<NamedNativeQuery> nativeQueries = new ArrayList<>();
    QueryConfigurationClassTransformer queryConfigurationClassTransformer = new QueryConfigurationClassTransformer(
        namedQueries, nativeQueries, new ArrayList<>());
    ConstPool constantPool = new ConstPool("Thisclass");
    ClassPool pool = ClassPool.getDefault();
    ArrayMemberValue queryArray = new ArrayMemberValue(new ConstPool("Thisclass"));

    // Act
    queryConfigurationClassTransformer.prepareNativeQueries(constantPool, pool, queryArray);

    // Assert
    assertEquals(0, queryArray.getValue().length);
  }

  /**
   * Test
   * {@link QueryConfigurationClassTransformer#prepareNamedQueries(ConstPool, ClassPool, ArrayMemberValue)}.
   * <p>
   * Method under test:
   * {@link QueryConfigurationClassTransformer#prepareNamedQueries(ConstPool, ClassPool, ArrayMemberValue)}
   */
  @Test
  public void testPrepareNamedQueries() throws NotFoundException {
    // Arrange
    ArrayList<NamedQuery> namedQueries = new ArrayList<>();
    ArrayList<NamedNativeQuery> nativeQueries = new ArrayList<>();
    QueryConfigurationClassTransformer queryConfigurationClassTransformer = new QueryConfigurationClassTransformer(
        namedQueries, nativeQueries, new ArrayList<>());
    ConstPool constantPool = new ConstPool("Thisclass");
    ClassPool pool = ClassPool.getDefault();
    ArrayMemberValue queryArray = new ArrayMemberValue(new ConstPool("Thisclass"));

    // Act
    queryConfigurationClassTransformer.prepareNamedQueries(constantPool, pool, queryArray);

    // Assert
    assertEquals(0, queryArray.getValue().length);
  }
}
