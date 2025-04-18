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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javassist.CtClass;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformersManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class DirectCopyClassTransformerDiffblueTest {
  @Mock
  private ConditionalDirectCopyTransformersManager conditionalDirectCopyTransformersManager;

  @InjectMocks
  private DirectCopyClassTransformer directCopyClassTransformer;

  @Mock
  private List<DirectCopyIgnorePattern> list;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DirectCopyClassTransformer#DirectCopyClassTransformer(String)}
   *   <li>{@link DirectCopyClassTransformer#setIgnorePatterns(List)}
   *   <li>{@link DirectCopyClassTransformer#setRenameMethodOverlaps(Boolean)}
   *   <li>{@link DirectCopyClassTransformer#setRenameMethodPrefix(String)}
   *   <li>{@link DirectCopyClassTransformer#setSkipOverlaps(Boolean)}
   *   <li>{@link DirectCopyClassTransformer#setTemplateTokens(Map)}
   *   <li>{@link DirectCopyClassTransformer#setXformTemplates(Map)}
   *   <li>{@link DirectCopyClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link DirectCopyClassTransformer#getIgnorePatterns()}
   *   <li>{@link DirectCopyClassTransformer#getRenameMethodOverlaps()}
   *   <li>{@link DirectCopyClassTransformer#getRenameMethodPrefix()}
   *   <li>{@link DirectCopyClassTransformer#getSkipOverlaps()}
   *   <li>{@link DirectCopyClassTransformer#getTemplateTokens()}
   *   <li>{@link DirectCopyClassTransformer#getXformTemplates()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DirectCopyClassTransformer.<init>(String)",
      "void DirectCopyClassTransformer.compileJPAProperties(Properties, Object)",
      "List DirectCopyClassTransformer.getIgnorePatterns()",
      "Boolean DirectCopyClassTransformer.getRenameMethodOverlaps()",
      "String DirectCopyClassTransformer.getRenameMethodPrefix()",
      "Boolean DirectCopyClassTransformer.getSkipOverlaps()", "Map DirectCopyClassTransformer.getTemplateTokens()",
      "Map DirectCopyClassTransformer.getXformTemplates()", "void DirectCopyClassTransformer.setIgnorePatterns(List)",
      "void DirectCopyClassTransformer.setRenameMethodOverlaps(Boolean)",
      "void DirectCopyClassTransformer.setRenameMethodPrefix(String)",
      "void DirectCopyClassTransformer.setSkipOverlaps(Boolean)",
      "void DirectCopyClassTransformer.setTemplateTokens(Map)",
      "void DirectCopyClassTransformer.setXformTemplates(Map)"})
  public void testGettersAndSetters() throws Exception {
    // Arrange and Act
    DirectCopyClassTransformer actualDirectCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    actualDirectCopyClassTransformer.setIgnorePatterns(ignorePatterns);
    actualDirectCopyClassTransformer.setRenameMethodOverlaps(true);
    actualDirectCopyClassTransformer.setRenameMethodPrefix("Rename Method Prefix");
    actualDirectCopyClassTransformer.setSkipOverlaps(true);
    HashMap<String, String> templateTokens = new HashMap<>();
    actualDirectCopyClassTransformer.setTemplateTokens(templateTokens);
    HashMap<String, String> xformTemplates = new HashMap<>();
    actualDirectCopyClassTransformer.setXformTemplates(xformTemplates);
    actualDirectCopyClassTransformer.compileJPAProperties(new Properties(), BLCFieldUtils.NULL_FIELD);
    List<DirectCopyIgnorePattern> actualIgnorePatterns = actualDirectCopyClassTransformer.getIgnorePatterns();
    Boolean actualRenameMethodOverlaps = actualDirectCopyClassTransformer.getRenameMethodOverlaps();
    String actualRenameMethodPrefix = actualDirectCopyClassTransformer.getRenameMethodPrefix();
    Boolean actualSkipOverlaps = actualDirectCopyClassTransformer.getSkipOverlaps();
    Map<String, String> actualTemplateTokens = actualDirectCopyClassTransformer.getTemplateTokens();
    Map<String, String> actualXformTemplates = actualDirectCopyClassTransformer.getXformTemplates();

    // Assert
    assertEquals("Rename Method Prefix", actualRenameMethodPrefix);
    assertTrue(actualIgnorePatterns.isEmpty());
    assertTrue(actualDirectCopyClassTransformer.preLoadClassNamePatterns.isEmpty());
    assertTrue(actualTemplateTokens.isEmpty());
    assertTrue(actualXformTemplates.isEmpty());
    assertTrue(actualRenameMethodOverlaps);
    assertTrue(actualSkipOverlaps);
    assertSame(ignorePatterns, actualIgnorePatterns);
    assertSame(templateTokens, actualTemplateTokens);
    assertSame(xformTemplates, actualXformTemplates);
  }

  /**
   * Test {@link DirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] DirectCopyClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform() throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
    directCopyClassTransformer.addXformTemplate("Class To Transform", "Contributing Class");
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(directCopyClassTransformer.transform(loader, "Class Name", classBeingRedefined, protectionDomain,
        "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] DirectCopyClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform_whenA_thenThrowRuntimeException()
      throws IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> directCopyClassTransformer.transform(loader, "Class Name", classBeingRedefined,
            new ProtectionDomain(codeSource, new Permissions()),
            new byte[]{'A', 'X', 'A', 'X', 'A', Byte.MAX_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] DirectCopyClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform_whenAxaxaxaxBytesIsUtf8_thenThrowRuntimeException()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> directCopyClassTransformer.transform(loader, "Class Name",
        classBeingRedefined, protectionDomain, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] DirectCopyClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform_whenEmptyArrayOfByte_thenThrowRuntimeException()
      throws IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> directCopyClassTransformer.transform(loader, "Class Name",
        classBeingRedefined, new ProtectionDomain(codeSource, new Permissions()), new byte[]{}));
  }

  /**
   * Test {@link DirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#transform(ClassLoader, String, Class, ProtectionDomain, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "byte[] DirectCopyClassTransformer.transform(ClassLoader, String, Class, ProtectionDomain, byte[])"})
  public void testTransform_whenNull_thenReturnNull()
      throws UnsupportedEncodingException, IllegalClassFormatException, MalformedURLException {
    // Arrange
    JarClassLoader loader = new JarClassLoader();
    Class<Object> classBeingRedefined = Object.class;
    CodeSource codeSource = new CodeSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        new CodeSigner[]{null});

    ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, new Permissions());

    // Act and Assert
    assertNull(directCopyClassTransformer.transform(loader, null, classBeingRedefined, protectionDomain,
        "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DirectCopyClassTransformer#combineXFormParams(XFormParams, XFormParams)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#combineXFormParams(XFormParams, XFormParams)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"XFormParams DirectCopyClassTransformer.combineXFormParams(XFormParams, XFormParams)"})
  public void testCombineXFormParams_givenFalse_thenReturnNotEmpty() {
    // Arrange
    XFormParams defaultParams = mock(XFormParams.class);
    when(defaultParams.getXformRenameMethodOverlaps()).thenReturn(new Boolean[]{true});
    when(defaultParams.getXformSkipOverlaps()).thenReturn(new Boolean[]{true});
    when(defaultParams.isEmpty()).thenReturn(false);
    when(defaultParams.getXformVals()).thenReturn(new String[]{"Xform Vals"});

    XFormParams conditionalParams = directCopyClassTransformer.new XFormParams();
    conditionalParams.setXformVals(new String[]{});

    // Act
    XFormParams actualCombineXFormParamsResult = directCopyClassTransformer.combineXFormParams(defaultParams,
        conditionalParams);

    // Assert
    verify(defaultParams).getXformRenameMethodOverlaps();
    verify(defaultParams).getXformSkipOverlaps();
    verify(defaultParams, atLeast(1)).getXformVals();
    verify(defaultParams).isEmpty();
    assertFalse(actualCombineXFormParamsResult.isEmpty());
    assertArrayEquals(new Boolean[]{true}, actualCombineXFormParamsResult.getXformRenameMethodOverlaps());
    assertArrayEquals(new Boolean[]{true}, actualCombineXFormParamsResult.getXformSkipOverlaps());
    assertArrayEquals(new String[]{"Xform Vals"}, actualCombineXFormParamsResult.getXformVals());
  }

  /**
   * Test {@link DirectCopyClassTransformer#combineXFormParams(XFormParams, XFormParams)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#combineXFormParams(XFormParams, XFormParams)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"XFormParams DirectCopyClassTransformer.combineXFormParams(XFormParams, XFormParams)"})
  public void testCombineXFormParams_thenReturnArrayLengthIsZero() {
    // Arrange
    XFormParams defaultParams = mock(XFormParams.class);
    when(defaultParams.isEmpty()).thenReturn(true);

    XFormParams conditionalParams = directCopyClassTransformer.new XFormParams();
    conditionalParams.setXformVals(new String[]{});

    // Act
    XFormParams actualCombineXFormParamsResult = directCopyClassTransformer.combineXFormParams(defaultParams,
        conditionalParams);

    // Assert
    verify(defaultParams).isEmpty();
    assertEquals(0, actualCombineXFormParamsResult.getXformRenameMethodOverlaps().length);
    assertEquals(0, actualCombineXFormParamsResult.getXformSkipOverlaps().length);
    assertEquals(0, actualCombineXFormParamsResult.getXformVals().length);
    assertTrue(actualCombineXFormParamsResult.isEmpty());
  }

  /**
   * Test {@link DirectCopyClassTransformer#combineXFormParams(XFormParams, XFormParams)}.
   * <ul>
   *   <li>When {@link XFormParams} {@link XFormParams#setXformVals(String[])} does nothing.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#combineXFormParams(XFormParams, XFormParams)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"XFormParams DirectCopyClassTransformer.combineXFormParams(XFormParams, XFormParams)"})
  public void testCombineXFormParams_whenXFormParamsSetXformValsDoesNothing_thenReturnNotEmpty() {
    // Arrange
    XFormParams defaultParams = mock(XFormParams.class);
    when(defaultParams.getXformRenameMethodOverlaps()).thenReturn(new Boolean[]{true});
    when(defaultParams.getXformSkipOverlaps()).thenReturn(new Boolean[]{true});
    when(defaultParams.isEmpty()).thenReturn(false);
    when(defaultParams.getXformVals()).thenReturn(new String[]{"Xform Vals"});
    XFormParams conditionalParams = mock(XFormParams.class);
    when(conditionalParams.getXformVals()).thenReturn(new String[]{"Xform Vals"});
    doNothing().when(conditionalParams).setXformVals(Mockito.<String[]>any());
    conditionalParams.setXformVals(new String[]{});

    // Act
    XFormParams actualCombineXFormParamsResult = directCopyClassTransformer.combineXFormParams(defaultParams,
        conditionalParams);

    // Assert
    verify(defaultParams).getXformRenameMethodOverlaps();
    verify(defaultParams).getXformSkipOverlaps();
    verify(defaultParams, atLeast(1)).getXformVals();
    verify(conditionalParams, atLeast(1)).getXformVals();
    verify(defaultParams).isEmpty();
    verify(conditionalParams).setXformVals(isA(String[].class));
    assertFalse(actualCombineXFormParamsResult.isEmpty());
    assertArrayEquals(new Boolean[]{true}, actualCombineXFormParamsResult.getXformRenameMethodOverlaps());
    assertArrayEquals(new Boolean[]{true}, actualCombineXFormParamsResult.getXformSkipOverlaps());
    assertArrayEquals(new String[]{"Xform Vals"}, actualCombineXFormParamsResult.getXformVals());
  }

  /**
   * Test {@link DirectCopyClassTransformer#combineXFormParams(XFormParams, XFormParams)}.
   * <ul>
   *   <li>When {@link XFormParams} {@link XFormParams#setXformVals(String[])} does nothing.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#combineXFormParams(XFormParams, XFormParams)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"XFormParams DirectCopyClassTransformer.combineXFormParams(XFormParams, XFormParams)"})
  public void testCombineXFormParams_whenXFormParamsSetXformValsDoesNothing_thenReturnNotEmpty2() {
    // Arrange
    XFormParams defaultParams = mock(XFormParams.class);
    when(defaultParams.isEmpty()).thenReturn(true);
    XFormParams conditionalParams = mock(XFormParams.class);
    when(conditionalParams.getXformRenameMethodOverlaps()).thenReturn(new Boolean[]{true});
    when(conditionalParams.getXformSkipOverlaps()).thenReturn(new Boolean[]{true});
    when(conditionalParams.getXformVals()).thenReturn(new String[]{"Xform Vals"});
    doNothing().when(conditionalParams).setXformVals(Mockito.<String[]>any());
    conditionalParams.setXformVals(new String[]{});

    // Act
    XFormParams actualCombineXFormParamsResult = directCopyClassTransformer.combineXFormParams(defaultParams,
        conditionalParams);

    // Assert
    verify(conditionalParams).getXformRenameMethodOverlaps();
    verify(conditionalParams).getXformSkipOverlaps();
    verify(conditionalParams, atLeast(1)).getXformVals();
    verify(defaultParams).isEmpty();
    verify(conditionalParams).setXformVals(isA(String[].class));
    assertFalse(actualCombineXFormParamsResult.isEmpty());
    assertArrayEquals(new Boolean[]{true}, actualCombineXFormParamsResult.getXformRenameMethodOverlaps());
    assertArrayEquals(new Boolean[]{true}, actualCombineXFormParamsResult.getXformSkipOverlaps());
    assertArrayEquals(new String[]{"Xform Vals"}, actualCombineXFormParamsResult.getXformVals());
  }

  /**
   * Test {@link DirectCopyClassTransformer#reviewDirectCopyTransformAnnotations(CtClass, boolean, boolean, List)}.
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#reviewDirectCopyTransformAnnotations(CtClass, boolean, boolean, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "XFormParams DirectCopyClassTransformer.reviewDirectCopyTransformAnnotations(CtClass, boolean, boolean, List)"})
  public void testReviewDirectCopyTransformAnnotations() {
    // Arrange
    CtClass clazz = mock(CtClass.class);
    when(clazz.getClassFile()).thenReturn(new ClassFile(true, "Classname", "Superclass"));

    // Act
    XFormParams actualReviewDirectCopyTransformAnnotationsResult = directCopyClassTransformer
        .reviewDirectCopyTransformAnnotations(clazz, true, true, new ArrayList<>());

    // Assert
    verify(clazz).getClassFile();
    assertNull(actualReviewDirectCopyTransformAnnotationsResult.getXformRenameMethodOverlaps());
    assertNull(actualReviewDirectCopyTransformAnnotationsResult.getXformSkipOverlaps());
    assertNull(actualReviewDirectCopyTransformAnnotationsResult.getXformVals());
    assertTrue(actualReviewDirectCopyTransformAnnotationsResult.isEmpty());
  }

  /**
   * Test {@link DirectCopyClassTransformer#reviewTemplateTokens(List, String)}.
   * <ul>
   *   <li>Given {@link DirectCopyClassTransformer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#reviewTemplateTokens(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DirectCopyClassTransformer.reviewTemplateTokens(List, String)"})
  public void testReviewTemplateTokens_givenDirectCopyClassTransformer() {
    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[]{"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[]{"ABC123"});

    DirectCopyIgnorePattern directCopyIgnorePattern2 = new DirectCopyIgnorePattern();
    directCopyIgnorePattern2.setPatterns(new String[]{"Patterns"});
    directCopyIgnorePattern2.setTemplateTokenPatterns(new String[]{"ABC123"});

    ArrayList<DirectCopyIgnorePattern> matchedPatterns = new ArrayList<>();
    matchedPatterns.add(directCopyIgnorePattern2);
    matchedPatterns.add(directCopyIgnorePattern);

    // Act and Assert
    assertTrue(directCopyClassTransformer.reviewTemplateTokens(matchedPatterns, "Val").isEmpty());
  }

  /**
   * Test {@link DirectCopyClassTransformer#reviewTemplateTokens(List, String)}.
   * <ul>
   *   <li>Given {@link DirectCopyClassTransformer} TemplateTokens is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#reviewTemplateTokens(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DirectCopyClassTransformer.reviewTemplateTokens(List, String)"})
  public void testReviewTemplateTokens_givenDirectCopyClassTransformerTemplateTokensIsHashMap() {
    // Arrange
    directCopyClassTransformer.setTemplateTokens(new HashMap<>());

    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[]{"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[]{"ABC123"});

    ArrayList<DirectCopyIgnorePattern> matchedPatterns = new ArrayList<>();
    matchedPatterns.add(directCopyIgnorePattern);

    // Act and Assert
    assertTrue(directCopyClassTransformer.reviewTemplateTokens(matchedPatterns, null).isEmpty());
  }

  /**
   * Test {@link DirectCopyClassTransformer#reviewTemplateTokens(List, String)}.
   * <ul>
   *   <li>Given {@link DirectCopyClassTransformer}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#reviewTemplateTokens(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DirectCopyClassTransformer.reviewTemplateTokens(List, String)"})
  public void testReviewTemplateTokens_givenDirectCopyClassTransformer_whenArrayList() {
    // Arrange, Act and Assert
    assertTrue(directCopyClassTransformer.reviewTemplateTokens(new ArrayList<>(), "Val").isEmpty());
  }

  /**
   * Test {@link DirectCopyClassTransformer#getIndexes(ConstPool, Annotation, Annotation)}.
   * <ul>
   *   <li>Then {@link ConstPool#ConstPool(String)} with thisclass is {@code indexes} Size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#getIndexes(ConstPool, Annotation, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Annotation DirectCopyClassTransformer.getIndexes(ConstPool, Annotation, Annotation)"})
  public void testGetIndexes_thenConstPoolWithThisclassIsIndexesSizeIsFour() {
    // Arrange
    ConstPool constantPool = new ConstPool("indexes");
    Annotation existingTable = new Annotation(1, new ConstPool("Thisclass"));

    // Act
    Annotation actualIndexes = directCopyClassTransformer.getIndexes(constantPool, existingTable,
        new Annotation(1, new ConstPool("Thisclass")));

    // Assert
    assertEquals("javax.persistence.Table", actualIndexes.getTypeName());
    assertEquals(1, actualIndexes.getMemberNames().size());
    assertEquals(4, constantPool.getSize());
  }

  /**
   * Test {@link DirectCopyClassTransformer#getIndexes(ConstPool, Annotation, Annotation)}.
   * <ul>
   *   <li>Then {@link ConstPool#ConstPool(String)} with {@code Thisclass} Size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#getIndexes(ConstPool, Annotation, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Annotation DirectCopyClassTransformer.getIndexes(ConstPool, Annotation, Annotation)"})
  public void testGetIndexes_thenConstPoolWithThisclassSizeIsFive() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");
    Annotation existingTable = new Annotation(1, new ConstPool("Thisclass"));

    // Act
    Annotation actualIndexes = directCopyClassTransformer.getIndexes(constantPool, existingTable,
        new Annotation(1, new ConstPool("Thisclass")));

    // Assert
    assertEquals("javax.persistence.Table", actualIndexes.getTypeName());
    assertEquals(1, actualIndexes.getMemberNames().size());
    assertEquals(5, constantPool.getSize());
  }

  /**
   * Test {@link DirectCopyClassTransformer#cloneIndexAnnotation(Annotation, ConstPool)}.
   * <ul>
   *   <li>Then return TypeName is {@code javax.persistence.Index}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#cloneIndexAnnotation(Annotation, ConstPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Annotation DirectCopyClassTransformer.cloneIndexAnnotation(Annotation, ConstPool)"})
  public void testCloneIndexAnnotation_thenReturnTypeNameIsJavaxPersistenceIndex() {
    // Arrange
    Annotation annotation = new Annotation(1, new ConstPool("Thisclass"));

    ConstPool constantPool = new ConstPool("Thisclass");

    // Act
    Annotation actualCloneIndexAnnotationResult = directCopyClassTransformer.cloneIndexAnnotation(annotation,
        constantPool);

    // Assert
    assertEquals("javax.persistence.Index", actualCloneIndexAnnotationResult.getTypeName());
    assertNull(actualCloneIndexAnnotationResult.getMemberNames());
    assertEquals(4, constantPool.getSize());
  }

  /**
   * Test {@link DirectCopyClassTransformer#cloneUniqueAnnotation(Annotation, ConstPool)}.
   * <ul>
   *   <li>Then return TypeName is {@code javax.persistence.UniqueConstraint}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#cloneUniqueAnnotation(Annotation, ConstPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Annotation DirectCopyClassTransformer.cloneUniqueAnnotation(Annotation, ConstPool)"})
  public void testCloneUniqueAnnotation_thenReturnTypeNameIsJavaxPersistenceUniqueConstraint() {
    // Arrange
    Annotation annotation = new Annotation(1, new ConstPool("Thisclass"));

    ConstPool constantPool = new ConstPool("Thisclass");

    // Act
    Annotation actualCloneUniqueAnnotationResult = directCopyClassTransformer.cloneUniqueAnnotation(annotation,
        constantPool);

    // Assert
    assertEquals("javax.persistence.UniqueConstraint", actualCloneUniqueAnnotationResult.getTypeName());
    assertNull(actualCloneUniqueAnnotationResult.getMemberNames());
    assertEquals(4, constantPool.getSize());
  }

  /**
   * Test {@link DirectCopyClassTransformer#getNewCacheAnnotation(ConstPool, Annotation)}.
   * <ul>
   *   <li>Then return TypeName is {@code org.hibernate.annotations.Cache}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#getNewCacheAnnotation(ConstPool, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Annotation DirectCopyClassTransformer.getNewCacheAnnotation(ConstPool, Annotation)"})
  public void testGetNewCacheAnnotation_thenReturnTypeNameIsOrgHibernateAnnotationsCache() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");

    // Act
    Annotation actualNewCacheAnnotation = directCopyClassTransformer.getNewCacheAnnotation(constantPool,
        new Annotation(1, new ConstPool("Thisclass")));

    // Assert
    assertEquals("org.hibernate.annotations.Cache", actualNewCacheAnnotation.getTypeName());
    assertNull(actualNewCacheAnnotation.getMemberNames());
    assertEquals(4, constantPool.getSize());
  }

  /**
   * Test {@link DirectCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then return {@code Class Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DirectCopyClassTransformer.getImplementationType(String)"})
  public void testGetImplementationType_whenClassName_thenReturnClassName() {
    // Arrange, Act and Assert
    assertEquals("Class Name", directCopyClassTransformer.getImplementationType("Class Name"));
  }

  /**
   * Test {@link DirectCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code List}.</li>
   *   <li>Then return {@code ArrayList}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DirectCopyClassTransformer.getImplementationType(String)"})
  public void testGetImplementationType_whenJavaUtilList_thenReturnJavaUtilArrayList() {
    // Arrange, Act and Assert
    assertEquals("java.util.ArrayList", directCopyClassTransformer.getImplementationType("java.util.List"));
  }

  /**
   * Test {@link DirectCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code Map}.</li>
   *   <li>Then return {@code HashMap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DirectCopyClassTransformer.getImplementationType(String)"})
  public void testGetImplementationType_whenJavaUtilMap_thenReturnJavaUtilHashMap() {
    // Arrange, Act and Assert
    assertEquals("java.util.HashMap", directCopyClassTransformer.getImplementationType("java.util.Map"));
  }

  /**
   * Test {@link DirectCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code java.util.Set}.</li>
   *   <li>Then return {@code java.util.HashSet}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DirectCopyClassTransformer.getImplementationType(String)"})
  public void testGetImplementationType_whenJavaUtilSet_thenReturnJavaUtilHashSet() {
    // Arrange, Act and Assert
    assertEquals("java.util.HashSet", directCopyClassTransformer.getImplementationType("java.util.Set"));
  }

  /**
   * Test {@link DirectCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code [}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DirectCopyClassTransformer.getImplementationType(String)"})
  public void testGetImplementationType_whenLeftSquareBracket_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(directCopyClassTransformer.getImplementationType("["));
  }

  /**
   * Test {@link DirectCopyClassTransformer#addXformTemplate(String, String)}.
   * <p>
   * Method under test: {@link DirectCopyClassTransformer#addXformTemplate(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DirectCopyClassTransformer DirectCopyClassTransformer.addXformTemplate(String, String)"})
  public void testAddXformTemplate() {
    // Arrange, Act and Assert
    assertSame(directCopyClassTransformer,
        directCopyClassTransformer.addXformTemplate("Class To Transform", "Contributing Class"));
  }

  /**
   * Test XFormParams getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link XFormParams#XFormParams(DirectCopyClassTransformer)}
   *   <li>{@link XFormParams#setXformRenameMethodOverlaps(Boolean[])}
   *   <li>{@link XFormParams#setXformSkipOverlaps(Boolean[])}
   *   <li>{@link XFormParams#setXformVals(String[])}
   *   <li>{@link XFormParams#getXformRenameMethodOverlaps()}
   *   <li>{@link XFormParams#getXformSkipOverlaps()}
   *   <li>{@link XFormParams#getXformVals()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void XFormParams.<init>(DirectCopyClassTransformer)",
      "Boolean[] XFormParams.getXformRenameMethodOverlaps()", "Boolean[] XFormParams.getXformSkipOverlaps()",
      "String[] XFormParams.getXformVals()", "void XFormParams.setXformRenameMethodOverlaps(Boolean[])",
      "void XFormParams.setXformSkipOverlaps(Boolean[])", "void XFormParams.setXformVals(String[])"})
  public void testXFormParamsGettersAndSetters() {
    // Arrange and Act
    XFormParams actualXFormParams = (new DirectCopyClassTransformer("Module Name")).new XFormParams();
    Boolean[] xformRenameMethodOverlaps = new Boolean[]{true};
    actualXFormParams.setXformRenameMethodOverlaps(xformRenameMethodOverlaps);
    Boolean[] xformSkipOverlaps = new Boolean[]{true};
    actualXFormParams.setXformSkipOverlaps(xformSkipOverlaps);
    String[] xformVals = new String[]{"Xform Vals"};
    actualXFormParams.setXformVals(xformVals);
    Boolean[] actualXformRenameMethodOverlaps = actualXFormParams.getXformRenameMethodOverlaps();
    Boolean[] actualXformSkipOverlaps = actualXFormParams.getXformSkipOverlaps();
    String[] actualXformVals = actualXFormParams.getXformVals();

    // Assert
    assertSame(xformRenameMethodOverlaps, actualXformRenameMethodOverlaps);
    assertSame(xformSkipOverlaps, actualXformSkipOverlaps);
    assertSame(xformVals, actualXformVals);
    assertArrayEquals(new Boolean[]{true}, actualXformRenameMethodOverlaps);
    assertArrayEquals(new Boolean[]{true}, actualXformSkipOverlaps);
    assertArrayEquals(new String[]{"Xform Vals"}, actualXformVals);
  }

  /**
   * Test XFormParams {@link XFormParams#isEmpty()}.
   * <p>
   * Method under test: {@link XFormParams#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean XFormParams.isEmpty()"})
  public void testXFormParamsIsEmpty() {
    // Arrange
    XFormParams xFormParams = (new DirectCopyClassTransformer("Module Name")).new XFormParams();
    xFormParams.setXformVals(new String[]{});

    // Act and Assert
    assertTrue(xFormParams.isEmpty());
  }

  /**
   * Test XFormParams {@link XFormParams#isEmpty()}.
   * <ul>
   *   <li>Given {@link XFormParams#XFormParams(DirectCopyClassTransformer)} with this$0 is {@link DirectCopyClassTransformer#DirectCopyClassTransformer(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XFormParams#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean XFormParams.isEmpty()"})
  public void testXFormParamsIsEmpty_givenXFormParamsWithThis$0IsDirectCopyClassTransformer() {
    // Arrange, Act and Assert
    assertTrue(((new DirectCopyClassTransformer("Module Name")).new XFormParams()).isEmpty());
  }

  /**
   * Test XFormParams {@link XFormParams#isEmpty()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XFormParams#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean XFormParams.isEmpty()"})
  public void testXFormParamsIsEmpty_thenReturnFalse() {
    // Arrange
    XFormParams xFormParams = (new DirectCopyClassTransformer("Module Name")).new XFormParams();
    xFormParams.setXformVals(new String[]{"foo"});

    // Act and Assert
    assertFalse(xFormParams.isEmpty());
  }
}
