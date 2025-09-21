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
package org.broadleafcommerce.common.extensibility.jpa.cache;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import java.io.UnsupportedEncodingException;
import java.lang.instrument.IllegalClassFormatException;
import java.net.MalformedURLException;
import java.net.URL;
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
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.AnnotationMemberValue;
import javassist.bytecode.annotation.StringMemberValue;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RemoveCacheClassTransformer.class, String.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class RemoveCacheClassTransformerDiffblueTest {
  @Autowired private RemoveCacheClassTransformer removeCacheClassTransformer;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RemoveCacheClassTransformer#RemoveCacheClassTransformer(String)}
   *   <li>{@link RemoveCacheClassTransformer#setAnnotationClass(String)}
   *   <li>{@link RemoveCacheClassTransformer#setBeanFactory(BeanFactory)}
   *   <li>{@link RemoveCacheClassTransformer#setCacheRegions(List)}
   *   <li>{@link RemoveCacheClassTransformer#setClassNames(List)}
   *   <li>{@link RemoveCacheClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link RemoveCacheClassTransformer#getAnnotationClass()}
   *   <li>{@link RemoveCacheClassTransformer#getCacheRegions()}
   *   <li>{@link RemoveCacheClassTransformer#getClassNames()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RemoveCacheClassTransformer.<init>(String)",
    "void RemoveCacheClassTransformer.compileJPAProperties(Properties, Object)",
    "String RemoveCacheClassTransformer.getAnnotationClass()",
    "List RemoveCacheClassTransformer.getCacheRegions()",
    "List RemoveCacheClassTransformer.getClassNames()",
    "void RemoveCacheClassTransformer.setAnnotationClass(String)",
    "void RemoveCacheClassTransformer.setBeanFactory(BeanFactory)",
    "void RemoveCacheClassTransformer.setCacheRegions(List)",
    "void RemoveCacheClassTransformer.setClassNames(List)"
  })
  public void testGettersAndSetters() throws Exception {
    // Arrange and Act
    RemoveCacheClassTransformer actualRemoveCacheClassTransformer =
        new RemoveCacheClassTransformer("Module Name");
    actualRemoveCacheClassTransformer.setAnnotationClass("Annotation Class");
    actualRemoveCacheClassTransformer.setBeanFactory(new DefaultListableBeanFactory());
    ArrayList<String> cacheRegions = new ArrayList<>();
    actualRemoveCacheClassTransformer.setCacheRegions(cacheRegions);
    ArrayList<String> classNames = new ArrayList<>();
    actualRemoveCacheClassTransformer.setClassNames(classNames);
    actualRemoveCacheClassTransformer.compileJPAProperties(
        new Properties(), BLCFieldUtils.NULL_FIELD);
    String actualAnnotationClass = actualRemoveCacheClassTransformer.getAnnotationClass();
    List<String> actualCacheRegions = actualRemoveCacheClassTransformer.getCacheRegions();
    List<String> actualClassNames = actualRemoveCacheClassTransformer.getClassNames();

    // Assert
    assertEquals("Annotation Class", actualAnnotationClass);
    assertTrue(actualCacheRegions.isEmpty());
    assertTrue(actualClassNames.isEmpty());
    assertSame(cacheRegions, actualCacheRegions);
    assertSame(classNames, actualClassNames);
  }

  /**
   * Test {@link RemoveCacheClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain,
   * byte[])}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] RemoveCacheClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_whenClassName_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(
        removeCacheClassTransformer.transform(
            loader,
            "Class Name",
            classBeingRedefined,
            protectionDomain,
            "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RemoveCacheClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain,
   * byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#transform(ClassLoader, String, Class,
   * ProtectionDomain, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] RemoveCacheClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"
  })
  public void testTransform_whenNull_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    URL toURLResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    CodeSigner[] codeSignerArray = new CodeSigner[] {null};

    CodeSource codeSource = new CodeSource(toURLResult, codeSignerArray);
    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(
        removeCacheClassTransformer.transform(
            loader, null, classBeingRedefined, protectionDomain, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RemoveCacheClassTransformer#classQualifies(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#classQualifies(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RemoveCacheClassTransformer.classQualifies(String)"})
  public void testClassQualifies_givenArrayListAddEmptyString_whenEmptyString_thenReturnTrue() {
    // Arrange
    ArrayList<String> classNames = new ArrayList<>();
    classNames.add("");
    classNames.add("foo");
    removeCacheClassTransformer.setClassNames(classNames);

    // Act and Assert
    assertTrue(removeCacheClassTransformer.classQualifies(""));
  }

  /**
   * Test {@link RemoveCacheClassTransformer#classQualifies(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>When {@code Class Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#classQualifies(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RemoveCacheClassTransformer.classQualifies(String)"})
  public void testClassQualifies_givenArrayListAddFoo_whenClassName_thenReturnFalse() {
    // Arrange
    ArrayList<String> classNames = new ArrayList<>();
    classNames.add("foo");
    removeCacheClassTransformer.setClassNames(classNames);

    // Act and Assert
    assertFalse(removeCacheClassTransformer.classQualifies("Class Name"));
  }

  /**
   * Test {@link RemoveCacheClassTransformer#classQualifies(String)}.
   *
   * <ul>
   *   <li>Given {@link RemoveCacheClassTransformer}.
   *   <li>When {@code Class Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#classQualifies(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RemoveCacheClassTransformer.classQualifies(String)"})
  public void testClassQualifies_givenRemoveCacheClassTransformer_whenClassName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(removeCacheClassTransformer.classQualifies("Class Name"));
  }

  /**
   * Test {@link RemoveCacheClassTransformer#annotationQualifies(ConstPool, List)}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#annotationQualifies(ConstPool, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RemoveCacheClassTransformer.annotationQualifies(ConstPool, List)"})
  public void testAnnotationQualifies_givenNull_field_whenArrayListAddNull_field() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");

    ArrayList<Object> attributes = new ArrayList<>();
    attributes.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertFalse(removeCacheClassTransformer.annotationQualifies(constantPool, attributes));
  }

  /**
   * Test {@link RemoveCacheClassTransformer#annotationQualifies(ConstPool, List)}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#annotationQualifies(ConstPool, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RemoveCacheClassTransformer.annotationQualifies(ConstPool, List)"})
  public void testAnnotationQualifies_givenNull_field_whenArrayListAddNull_field2() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");

    ArrayList<Object> attributes = new ArrayList<>();
    attributes.add(BLCFieldUtils.NULL_FIELD);
    attributes.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertFalse(removeCacheClassTransformer.annotationQualifies(constantPool, attributes));
  }

  /**
   * Test {@link RemoveCacheClassTransformer#annotationQualifies(ConstPool, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#annotationQualifies(ConstPool, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RemoveCacheClassTransformer.annotationQualifies(ConstPool, List)"})
  public void testAnnotationQualifies_whenArrayList_thenReturnFalse() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");

    // Act and Assert
    assertFalse(removeCacheClassTransformer.annotationQualifies(constantPool, new ArrayList<>()));
  }

  /**
   * Test {@link RemoveCacheClassTransformer#cacheRegionQualifies(Annotation)}.
   *
   * <ul>
   *   <li>Given {@link AnnotationMemberValue#AnnotationMemberValue(ConstPool)} with cp is {@link
   *       ConstPool#ConstPool(String)}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#cacheRegionQualifies(Annotation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RemoveCacheClassTransformer.cacheRegionQualifies(Annotation)"})
  public void testCacheRegionQualifies_givenAnnotationMemberValueWithCpIsConstPool() {
    // Arrange
    Annotation annotation = mock(Annotation.class);
    when(annotation.getMemberValue(Mockito.<String>any()))
        .thenReturn(new AnnotationMemberValue(new ConstPool("Thisclass")));

    // Act
    Boolean actualCacheRegionQualifiesResult =
        removeCacheClassTransformer.cacheRegionQualifies(annotation);

    // Assert
    verify(annotation).getMemberValue("region");
    assertFalse(actualCacheRegionQualifiesResult);
  }

  /**
   * Test {@link RemoveCacheClassTransformer#cacheRegionQualifies(Annotation)}.
   *
   * <ul>
   *   <li>Given {@link StringMemberValue#StringMemberValue(ConstPool)} with cp is {@link
   *       ConstPool#ConstPool(String)}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#cacheRegionQualifies(Annotation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RemoveCacheClassTransformer.cacheRegionQualifies(Annotation)"})
  public void testCacheRegionQualifies_givenStringMemberValueWithCpIsConstPool() {
    // Arrange
    Annotation annotation = mock(Annotation.class);
    when(annotation.getMemberValue(Mockito.<String>any()))
        .thenReturn(new StringMemberValue(new ConstPool("Thisclass")));

    // Act
    Boolean actualCacheRegionQualifiesResult =
        removeCacheClassTransformer.cacheRegionQualifies(annotation);

    // Assert
    verify(annotation).getMemberValue("region");
    assertFalse(actualCacheRegionQualifiesResult);
  }

  /**
   * Test {@link RemoveCacheClassTransformer#stripAnnotation(ConstPool, List)}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#stripAnnotation(ConstPool, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AnnotationsAttribute RemoveCacheClassTransformer.stripAnnotation(ConstPool, List)"
  })
  public void testStripAnnotation_givenNull_field_thenArrayListSizeIsOne() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");

    ArrayList<Object> attributes = new ArrayList<>();
    attributes.add(BLCFieldUtils.NULL_FIELD);

    // Act
    AnnotationsAttribute actualStripAnnotationResult =
        removeCacheClassTransformer.stripAnnotation(constantPool, attributes);

    // Assert
    assertEquals(1, attributes.size());
    assertEquals(4, constantPool.getSize());
    assertArrayEquals(new byte[] {0, 0}, actualStripAnnotationResult.get());
  }

  /**
   * Test {@link RemoveCacheClassTransformer#stripAnnotation(ConstPool, List)}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#stripAnnotation(ConstPool, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AnnotationsAttribute RemoveCacheClassTransformer.stripAnnotation(ConstPool, List)"
  })
  public void testStripAnnotation_givenNull_field_thenArrayListSizeIsTwo() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");

    ArrayList<Object> attributes = new ArrayList<>();
    attributes.add(BLCFieldUtils.NULL_FIELD);
    attributes.add(BLCFieldUtils.NULL_FIELD);

    // Act
    AnnotationsAttribute actualStripAnnotationResult =
        removeCacheClassTransformer.stripAnnotation(constantPool, attributes);

    // Assert
    assertEquals(2, attributes.size());
    assertEquals(4, constantPool.getSize());
    assertArrayEquals(new byte[] {0, 0}, actualStripAnnotationResult.get());
  }

  /**
   * Test {@link RemoveCacheClassTransformer#stripAnnotation(ConstPool, List)}.
   *
   * <ul>
   *   <li>Given {@code RuntimeVisibleAnnotations}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#stripAnnotation(ConstPool, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AnnotationsAttribute RemoveCacheClassTransformer.stripAnnotation(ConstPool, List)"
  })
  public void testStripAnnotation_givenRuntimeVisibleAnnotations() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");
    constantPool.addClassInfo("RuntimeVisibleAnnotations");
    ArrayList<Object> attributes = new ArrayList<>();

    // Act
    AnnotationsAttribute actualStripAnnotationResult =
        removeCacheClassTransformer.stripAnnotation(constantPool, attributes);

    // Assert
    assertEquals(5, constantPool.getSize());
    assertTrue(attributes.isEmpty());
    assertArrayEquals(new byte[] {0, 0}, actualStripAnnotationResult.get());
  }

  /**
   * Test {@link RemoveCacheClassTransformer#stripAnnotation(ConstPool, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ConstPool#ConstPool(String)} with {@code Thisclass} Size is four.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#stripAnnotation(ConstPool, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AnnotationsAttribute RemoveCacheClassTransformer.stripAnnotation(ConstPool, List)"
  })
  public void testStripAnnotation_whenArrayList_thenConstPoolWithThisclassSizeIsFour() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");
    ArrayList<Object> attributes = new ArrayList<>();

    // Act
    AnnotationsAttribute actualStripAnnotationResult =
        removeCacheClassTransformer.stripAnnotation(constantPool, attributes);

    // Assert
    assertEquals(4, constantPool.getSize());
    assertTrue(attributes.isEmpty());
    assertArrayEquals(new byte[] {0, 0}, actualStripAnnotationResult.get());
  }

  /**
   * Test {@link RemoveCacheClassTransformer#isPropertyEnabled(String)}.
   *
   * <ul>
   *   <li>Given {@link RemoveCacheClassTransformer}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#isPropertyEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RemoveCacheClassTransformer.isPropertyEnabled(String)"})
  public void testIsPropertyEnabled_givenRemoveCacheClassTransformer() {
    // Arrange, Act and Assert
    assertFalse(removeCacheClassTransformer.isPropertyEnabled("Property Name"));
  }

  /**
   * Test {@link RemoveCacheClassTransformer#isPropertyEnabled(String)}.
   *
   * <ul>
   *   <li>Given {@link RemoveCacheClassTransformer#RemoveCacheClassTransformer(String)} with {@code
   *       Module Name}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveCacheClassTransformer#isPropertyEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RemoveCacheClassTransformer.isPropertyEnabled(String)"})
  public void testIsPropertyEnabled_givenRemoveCacheClassTransformerWithModuleName() {
    // Arrange, Act and Assert
    assertFalse(new RemoveCacheClassTransformer("Module Name").isPropertyEnabled("Property Name"));
  }
}
