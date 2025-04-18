/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.common.extensibility.jpa.copy;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import java.io.UnsupportedEncodingException;
import java.lang.instrument.IllegalClassFormatException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ConstPool;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RemoveAnnotationClassTransformer.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RemoveAnnotationClassTransformerDiffblueTest {
  @Autowired
  private RemoveAnnotationClassTransformer removeAnnotationClassTransformer;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RemoveAnnotationClassTransformer#RemoveAnnotationClassTransformer(String)}
   *   <li>{@link RemoveAnnotationClassTransformer#setAnnotationClass(String)}
   *   <li>{@link RemoveAnnotationClassTransformer#setBeanFactory(BeanFactory)}
   *   <li>{@link RemoveAnnotationClassTransformer#setClassNames(List)}
   *   <li>{@link RemoveAnnotationClassTransformer#setConditionalPropertyName(String)}
   *   <li>{@link RemoveAnnotationClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link RemoveAnnotationClassTransformer#getAnnotationClass()}
   *   <li>{@link RemoveAnnotationClassTransformer#getClassNames()}
   *   <li>{@link RemoveAnnotationClassTransformer#getConditionalPropertyName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoveAnnotationClassTransformer.<init>(String)",
      "void RemoveAnnotationClassTransformer.compileJPAProperties(Properties, Object)",
      "String RemoveAnnotationClassTransformer.getAnnotationClass()",
      "List RemoveAnnotationClassTransformer.getClassNames()",
      "String RemoveAnnotationClassTransformer.getConditionalPropertyName()",
      "void RemoveAnnotationClassTransformer.setAnnotationClass(String)",
      "void RemoveAnnotationClassTransformer.setBeanFactory(BeanFactory)",
      "void RemoveAnnotationClassTransformer.setClassNames(List)",
      "void RemoveAnnotationClassTransformer.setConditionalPropertyName(String)"})
  public void testGettersAndSetters() throws Exception {
    // Arrange and Act
    RemoveAnnotationClassTransformer actualRemoveAnnotationClassTransformer = new RemoveAnnotationClassTransformer(
        "Module Name");
    actualRemoveAnnotationClassTransformer.setAnnotationClass("Annotation Class");
    actualRemoveAnnotationClassTransformer.setBeanFactory(new DefaultListableBeanFactory());
    ArrayList<String> classNames = new ArrayList<>();
    actualRemoveAnnotationClassTransformer.setClassNames(classNames);
    actualRemoveAnnotationClassTransformer.setConditionalPropertyName("Conditional Property Name");
    actualRemoveAnnotationClassTransformer.compileJPAProperties(new Properties(), BLCFieldUtils.NULL_FIELD);
    String actualAnnotationClass = actualRemoveAnnotationClassTransformer.getAnnotationClass();
    List<String> actualClassNames = actualRemoveAnnotationClassTransformer.getClassNames();

    // Assert
    assertEquals("Annotation Class", actualAnnotationClass);
    assertEquals("Conditional Property Name", actualRemoveAnnotationClassTransformer.getConditionalPropertyName());
    assertTrue(actualClassNames.isEmpty());
    assertTrue(actualRemoveAnnotationClassTransformer.preLoadClassNamePatterns.isEmpty());
    assertSame(classNames, actualClassNames);
  }

  /**
   * Test {@link RemoveAnnotationClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveAnnotationClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] RemoveAnnotationClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform_whenClassName_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(removeAnnotationClassTransformer.transform(loader, "Class Name", classBeingRedefined, protectionDomain,
        "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RemoveAnnotationClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveAnnotationClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] RemoveAnnotationClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform_whenNull_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(removeAnnotationClassTransformer.transform(loader, null, classBeingRedefined, protectionDomain,
        "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RemoveAnnotationClassTransformer#stripAnnotation(ConstPool, List)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveAnnotationClassTransformer#stripAnnotation(ConstPool, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AnnotationsAttribute RemoveAnnotationClassTransformer.stripAnnotation(ConstPool, List)"})
  public void testStripAnnotation_givenNull_field_whenArrayListAddNull_field() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");

    ArrayList<Object> attributes = new ArrayList<>();
    attributes.add(BLCFieldUtils.NULL_FIELD);

    // Act
    AnnotationsAttribute actualStripAnnotationResult = removeAnnotationClassTransformer.stripAnnotation(constantPool,
        attributes);

    // Assert
    assertEquals("RuntimeVisibleAnnotations", actualStripAnnotationResult.getName());
    assertEquals(0, actualStripAnnotationResult.getAnnotations().length);
    assertEquals(4, constantPool.getSize());
    assertEquals(8, actualStripAnnotationResult.length());
    assertSame(constantPool, actualStripAnnotationResult.getConstPool());
    assertArrayEquals(new byte[]{0, 0}, actualStripAnnotationResult.get());
  }

  /**
   * Test {@link RemoveAnnotationClassTransformer#stripAnnotation(ConstPool, List)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveAnnotationClassTransformer#stripAnnotation(ConstPool, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AnnotationsAttribute RemoveAnnotationClassTransformer.stripAnnotation(ConstPool, List)"})
  public void testStripAnnotation_givenNull_field_whenArrayListAddNull_field2() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");

    ArrayList<Object> attributes = new ArrayList<>();
    attributes.add(BLCFieldUtils.NULL_FIELD);
    attributes.add(BLCFieldUtils.NULL_FIELD);

    // Act
    AnnotationsAttribute actualStripAnnotationResult = removeAnnotationClassTransformer.stripAnnotation(constantPool,
        attributes);

    // Assert
    assertEquals("RuntimeVisibleAnnotations", actualStripAnnotationResult.getName());
    assertEquals(0, actualStripAnnotationResult.getAnnotations().length);
    assertEquals(4, constantPool.getSize());
    assertEquals(8, actualStripAnnotationResult.length());
    assertSame(constantPool, actualStripAnnotationResult.getConstPool());
    assertArrayEquals(new byte[]{0, 0}, actualStripAnnotationResult.get());
  }

  /**
   * Test {@link RemoveAnnotationClassTransformer#stripAnnotation(ConstPool, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Name is {@code RuntimeVisibleAnnotations}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveAnnotationClassTransformer#stripAnnotation(ConstPool, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AnnotationsAttribute RemoveAnnotationClassTransformer.stripAnnotation(ConstPool, List)"})
  public void testStripAnnotation_whenArrayList_thenReturnNameIsRuntimeVisibleAnnotations() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");

    // Act
    AnnotationsAttribute actualStripAnnotationResult = removeAnnotationClassTransformer.stripAnnotation(constantPool,
        new ArrayList<>());

    // Assert
    assertEquals("RuntimeVisibleAnnotations", actualStripAnnotationResult.getName());
    assertEquals(0, actualStripAnnotationResult.getAnnotations().length);
    assertEquals(4, constantPool.getSize());
    assertEquals(8, actualStripAnnotationResult.length());
    assertSame(constantPool, actualStripAnnotationResult.getConstPool());
    assertArrayEquals(new byte[]{0, 0}, actualStripAnnotationResult.get());
  }

  /**
   * Test {@link RemoveAnnotationClassTransformer#isPropertyEnabled(String)}.
   * <ul>
   *   <li>Given {@link RemoveAnnotationClassTransformer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveAnnotationClassTransformer#isPropertyEnabled(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean RemoveAnnotationClassTransformer.isPropertyEnabled(String)"})
  public void testIsPropertyEnabled_givenRemoveAnnotationClassTransformer() {
    // Arrange, Act and Assert
    assertFalse(removeAnnotationClassTransformer.isPropertyEnabled("Property Name"));
  }

  /**
   * Test {@link RemoveAnnotationClassTransformer#isPropertyEnabled(String)}.
   * <ul>
   *   <li>Given {@link RemoveAnnotationClassTransformer#RemoveAnnotationClassTransformer(String)} with {@code Module Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveAnnotationClassTransformer#isPropertyEnabled(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean RemoveAnnotationClassTransformer.isPropertyEnabled(String)"})
  public void testIsPropertyEnabled_givenRemoveAnnotationClassTransformerWithModuleName() {
    // Arrange, Act and Assert
    assertFalse((new RemoveAnnotationClassTransformer("Module Name")).isPropertyEnabled("Property Name"));
  }
}
