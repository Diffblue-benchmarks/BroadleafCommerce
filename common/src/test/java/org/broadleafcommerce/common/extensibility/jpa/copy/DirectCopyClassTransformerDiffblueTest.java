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
package org.broadleafcommerce.common.extensibility.jpa.copy;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.Test;
import org.mockito.Mockito;

public class DirectCopyClassTransformerDiffblueTest {
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
   *   <li>
   * {@link DirectCopyClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link DirectCopyClassTransformer#getIgnorePatterns()}
   *   <li>{@link DirectCopyClassTransformer#getRenameMethodOverlaps()}
   *   <li>{@link DirectCopyClassTransformer#getRenameMethodPrefix()}
   *   <li>{@link DirectCopyClassTransformer#getSkipOverlaps()}
   *   <li>{@link DirectCopyClassTransformer#getTemplateTokens()}
   *   <li>{@link DirectCopyClassTransformer#getXformTemplates()}
   * </ul>
   */
  @Test
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

    // Assert that nothing has changed
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
   * Test
   * {@link DirectCopyClassTransformer#combineXFormParams(XFormParams, XFormParams)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#combineXFormParams(DirectCopyClassTransformer.XFormParams, DirectCopyClassTransformer.XFormParams)}
   */
  @Test
  public void testCombineXFormParams_givenFalse_thenReturnNotEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
    DirectCopyClassTransformer.XFormParams defaultParams = mock(DirectCopyClassTransformer.XFormParams.class);
    when(defaultParams.getXformRenameMethodOverlaps()).thenReturn(new Boolean[]{true});
    when(defaultParams.getXformSkipOverlaps()).thenReturn(new Boolean[]{true});
    when(defaultParams.isEmpty()).thenReturn(false);
    when(defaultParams.getXformVals()).thenReturn(new String[]{"Xform Vals"});

    DirectCopyClassTransformer.XFormParams conditionalParams = (new DirectCopyClassTransformer(
        "Module Name")).new XFormParams();
    conditionalParams.setXformVals(new String[]{});

    // Act
    DirectCopyClassTransformer.XFormParams actualCombineXFormParamsResult = directCopyClassTransformer
        .combineXFormParams(defaultParams, conditionalParams);

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
   * Test
   * {@link DirectCopyClassTransformer#combineXFormParams(XFormParams, XFormParams)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#combineXFormParams(DirectCopyClassTransformer.XFormParams, DirectCopyClassTransformer.XFormParams)}
   */
  @Test
  public void testCombineXFormParams_thenReturnArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
    DirectCopyClassTransformer.XFormParams defaultParams = mock(DirectCopyClassTransformer.XFormParams.class);
    when(defaultParams.isEmpty()).thenReturn(true);

    DirectCopyClassTransformer.XFormParams conditionalParams = (new DirectCopyClassTransformer(
        "Module Name")).new XFormParams();
    conditionalParams.setXformVals(new String[]{});

    // Act
    DirectCopyClassTransformer.XFormParams actualCombineXFormParamsResult = directCopyClassTransformer
        .combineXFormParams(defaultParams, conditionalParams);

    // Assert
    verify(defaultParams).isEmpty();
    assertEquals(0, actualCombineXFormParamsResult.getXformRenameMethodOverlaps().length);
    assertEquals(0, actualCombineXFormParamsResult.getXformSkipOverlaps().length);
    assertEquals(0, actualCombineXFormParamsResult.getXformVals().length);
    assertTrue(actualCombineXFormParamsResult.isEmpty());
  }

  /**
   * Test
   * {@link DirectCopyClassTransformer#combineXFormParams(XFormParams, XFormParams)}.
   * <ul>
   *   <li>When {@link XFormParams} {@link XFormParams#setXformVals(String[])} does
   * nothing.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#combineXFormParams(DirectCopyClassTransformer.XFormParams, DirectCopyClassTransformer.XFormParams)}
   */
  @Test
  public void testCombineXFormParams_whenXFormParamsSetXformValsDoesNothing_thenReturnNotEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
    DirectCopyClassTransformer.XFormParams defaultParams = mock(DirectCopyClassTransformer.XFormParams.class);
    when(defaultParams.getXformRenameMethodOverlaps()).thenReturn(new Boolean[]{true});
    when(defaultParams.getXformSkipOverlaps()).thenReturn(new Boolean[]{true});
    when(defaultParams.isEmpty()).thenReturn(false);
    when(defaultParams.getXformVals()).thenReturn(new String[]{"Xform Vals"});
    DirectCopyClassTransformer.XFormParams conditionalParams = mock(DirectCopyClassTransformer.XFormParams.class);
    when(conditionalParams.getXformVals()).thenReturn(new String[]{"Xform Vals"});
    doNothing().when(conditionalParams).setXformVals(Mockito.<String[]>any());
    conditionalParams.setXformVals(new String[]{});

    // Act
    DirectCopyClassTransformer.XFormParams actualCombineXFormParamsResult = directCopyClassTransformer
        .combineXFormParams(defaultParams, conditionalParams);

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
   * Test
   * {@link DirectCopyClassTransformer#combineXFormParams(XFormParams, XFormParams)}.
   * <ul>
   *   <li>When {@link XFormParams} {@link XFormParams#setXformVals(String[])} does
   * nothing.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#combineXFormParams(DirectCopyClassTransformer.XFormParams, DirectCopyClassTransformer.XFormParams)}
   */
  @Test
  public void testCombineXFormParams_whenXFormParamsSetXformValsDoesNothing_thenReturnNotEmpty2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
    DirectCopyClassTransformer.XFormParams defaultParams = mock(DirectCopyClassTransformer.XFormParams.class);
    when(defaultParams.getXformRenameMethodOverlaps()).thenReturn(new Boolean[]{true});
    when(defaultParams.getXformSkipOverlaps()).thenReturn(new Boolean[]{true});
    when(defaultParams.isEmpty()).thenReturn(true);
    when(defaultParams.getXformVals()).thenReturn(new String[]{"Xform Vals"});
    DirectCopyClassTransformer.XFormParams conditionalParams = mock(DirectCopyClassTransformer.XFormParams.class);
    when(conditionalParams.getXformRenameMethodOverlaps()).thenReturn(new Boolean[]{true});
    when(conditionalParams.getXformSkipOverlaps()).thenReturn(new Boolean[]{true});
    when(conditionalParams.getXformVals()).thenReturn(new String[]{"Xform Vals"});
    doNothing().when(conditionalParams).setXformVals(Mockito.<String[]>any());
    conditionalParams.setXformVals(new String[]{});

    // Act
    DirectCopyClassTransformer.XFormParams actualCombineXFormParamsResult = directCopyClassTransformer
        .combineXFormParams(defaultParams, conditionalParams);

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
   * Test
   * {@link DirectCopyClassTransformer#reviewDirectCopyTransformAnnotations(CtClass, boolean, boolean, List)}.
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#reviewDirectCopyTransformAnnotations(CtClass, boolean, boolean, List)}
   */
  @Test
  public void testReviewDirectCopyTransformAnnotations() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
    CtClass clazz = mock(CtClass.class);
    when(clazz.getClassFile()).thenReturn(new ClassFile(true, "Classname", "Superclass"));
    DirectCopyIgnorePattern directCopyIgnorePattern = mock(DirectCopyIgnorePattern.class);
    doNothing().when(directCopyIgnorePattern).setPatterns(Mockito.<String[]>any());
    doNothing().when(directCopyIgnorePattern).setTemplateTokenPatterns(Mockito.<String[]>any());
    directCopyIgnorePattern.setPatterns(new String[]{"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[]{"ABC123"});

    ArrayList<DirectCopyIgnorePattern> matchedPatterns = new ArrayList<>();
    matchedPatterns.add(directCopyIgnorePattern);

    // Act
    DirectCopyClassTransformer.XFormParams actualReviewDirectCopyTransformAnnotationsResult = directCopyClassTransformer
        .reviewDirectCopyTransformAnnotations(clazz, true, true, matchedPatterns);

    // Assert
    verify(clazz).getClassFile();
    verify(directCopyIgnorePattern).setPatterns(isA(String[].class));
    verify(directCopyIgnorePattern).setTemplateTokenPatterns(isA(String[].class));
    assertNull(actualReviewDirectCopyTransformAnnotationsResult.getXformRenameMethodOverlaps());
    assertNull(actualReviewDirectCopyTransformAnnotationsResult.getXformSkipOverlaps());
    assertNull(actualReviewDirectCopyTransformAnnotationsResult.getXformVals());
    assertTrue(actualReviewDirectCopyTransformAnnotationsResult.isEmpty());
  }

  /**
   * Test {@link DirectCopyClassTransformer#reviewTemplateTokens(List, String)}.
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#reviewTemplateTokens(List, String)}
   */
  @Test
  public void testReviewTemplateTokens() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
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
   *   <li>Given
   * {@link DirectCopyClassTransformer#DirectCopyClassTransformer(String)} with
   * {@code Module Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#reviewTemplateTokens(List, String)}
   */
  @Test
  public void testReviewTemplateTokens_givenDirectCopyClassTransformerWithModuleName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");

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
   *   <li>Then calls {@link DirectCopyIgnorePattern#setPatterns(String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#reviewTemplateTokens(List, String)}
   */
  @Test
  public void testReviewTemplateTokens_thenCallsSetPatterns() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
    directCopyClassTransformer.setTemplateTokens(new HashMap<>());
    DirectCopyIgnorePattern directCopyIgnorePattern = mock(DirectCopyIgnorePattern.class);
    doNothing().when(directCopyIgnorePattern).setPatterns(Mockito.<String[]>any());
    doNothing().when(directCopyIgnorePattern).setTemplateTokenPatterns(Mockito.<String[]>any());
    directCopyIgnorePattern.setPatterns(new String[]{"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(new String[]{"ABC123"});

    ArrayList<DirectCopyIgnorePattern> matchedPatterns = new ArrayList<>();
    matchedPatterns.add(directCopyIgnorePattern);

    // Act
    List<String> actualReviewTemplateTokensResult = directCopyClassTransformer.reviewTemplateTokens(matchedPatterns,
        null);

    // Assert
    verify(directCopyIgnorePattern).setPatterns(isA(String[].class));
    verify(directCopyIgnorePattern).setTemplateTokenPatterns(isA(String[].class));
    assertTrue(actualReviewTemplateTokensResult.isEmpty());
  }

  /**
   * Test {@link DirectCopyClassTransformer#reviewTemplateTokens(List, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#reviewTemplateTokens(List, String)}
   */
  @Test
  public void testReviewTemplateTokens_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");

    // Act and Assert
    assertTrue(directCopyClassTransformer.reviewTemplateTokens(new ArrayList<>(), "Val").isEmpty());
  }

  /**
   * Test
   * {@link DirectCopyClassTransformer#getIndexes(ConstPool, Annotation, Annotation)}.
   * <ul>
   *   <li>Then {@link ConstPool#ConstPool(String)} with thisclass is
   * {@code indexes} Size is four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#getIndexes(ConstPool, Annotation, Annotation)}
   */
  @Test
  public void testGetIndexes_thenConstPoolWithThisclassIsIndexesSizeIsFour() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
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
   * Test
   * {@link DirectCopyClassTransformer#getIndexes(ConstPool, Annotation, Annotation)}.
   * <ul>
   *   <li>Then {@link ConstPool#ConstPool(String)} with {@code Thisclass} Size is
   * five.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#getIndexes(ConstPool, Annotation, Annotation)}
   */
  @Test
  public void testGetIndexes_thenConstPoolWithThisclassSizeIsFive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
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
   * Test
   * {@link DirectCopyClassTransformer#cloneIndexAnnotation(Annotation, ConstPool)}.
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#cloneIndexAnnotation(Annotation, ConstPool)}
   */
  @Test
  public void testCloneIndexAnnotation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
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
   * Test
   * {@link DirectCopyClassTransformer#cloneUniqueAnnotation(Annotation, ConstPool)}.
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#cloneUniqueAnnotation(Annotation, ConstPool)}
   */
  @Test
  public void testCloneUniqueAnnotation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
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
   * Test
   * {@link DirectCopyClassTransformer#getNewCacheAnnotation(ConstPool, Annotation)}.
   * <ul>
   *   <li>Then return TypeName is {@code org.hibernate.annotations.Cache}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#getNewCacheAnnotation(ConstPool, Annotation)}
   */
  @Test
  public void testGetNewCacheAnnotation_thenReturnTypeNameIsOrgHibernateAnnotationsCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");
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
   * Method under test:
   * {@link DirectCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  public void testGetImplementationType_whenClassName_thenReturnClassName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Class Name", (new DirectCopyClassTransformer("Module Name")).getImplementationType("Class Name"));
  }

  /**
   * Test {@link DirectCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code java.util.List}.</li>
   *   <li>Then return {@code java.util.ArrayList}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  public void testGetImplementationType_whenJavaUtilList_thenReturnJavaUtilArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("java.util.ArrayList",
        (new DirectCopyClassTransformer("Module Name")).getImplementationType("java.util.List"));
  }

  /**
   * Test {@link DirectCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code java.util.Map}.</li>
   *   <li>Then return {@code java.util.HashMap}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  public void testGetImplementationType_whenJavaUtilMap_thenReturnJavaUtilHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("java.util.HashMap",
        (new DirectCopyClassTransformer("Module Name")).getImplementationType("java.util.Map"));
  }

  /**
   * Test {@link DirectCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code java.util.Set}.</li>
   *   <li>Then return {@code java.util.HashSet}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  public void testGetImplementationType_whenJavaUtilSet_thenReturnJavaUtilHashSet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("java.util.HashSet",
        (new DirectCopyClassTransformer("Module Name")).getImplementationType("java.util.Set"));
  }

  /**
   * Test {@link DirectCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code [}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  public void testGetImplementationType_whenLeftSquareBracket_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DirectCopyClassTransformer("Module Name")).getImplementationType("["));
  }

  /**
   * Test {@link DirectCopyClassTransformer#addXformTemplate(String, String)}.
   * <p>
   * Method under test:
   * {@link DirectCopyClassTransformer#addXformTemplate(String, String)}
   */
  @Test
  public void testAddXformTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyClassTransformer directCopyClassTransformer = new DirectCopyClassTransformer("Module Name");

    // Act and Assert
    assertSame(directCopyClassTransformer,
        directCopyClassTransformer.addXformTemplate("Class To Transform", "Contributing Class"));
  }

  /**
   * Test XFormParams getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DirectCopyClassTransformer.XFormParams#XFormParams(DirectCopyClassTransformer)}
   *   <li>
   * {@link DirectCopyClassTransformer.XFormParams#setXformRenameMethodOverlaps(Boolean[])}
   *   <li>
   * {@link DirectCopyClassTransformer.XFormParams#setXformSkipOverlaps(Boolean[])}
   *   <li>{@link DirectCopyClassTransformer.XFormParams#setXformVals(String[])}
   *   <li>
   * {@link DirectCopyClassTransformer.XFormParams#getXformRenameMethodOverlaps()}
   *   <li>{@link DirectCopyClassTransformer.XFormParams#getXformSkipOverlaps()}
   *   <li>{@link DirectCopyClassTransformer.XFormParams#getXformVals()}
   * </ul>
   */
  @Test
  public void testXFormParamsGettersAndSetters() {
    // Arrange and Act
    DirectCopyClassTransformer.XFormParams actualXFormParams = (new DirectCopyClassTransformer(
        "Module Name")).new XFormParams();
    Boolean[] xformRenameMethodOverlaps = new Boolean[]{true};
    actualXFormParams.setXformRenameMethodOverlaps(xformRenameMethodOverlaps);
    Boolean[] xformSkipOverlaps = new Boolean[]{true};
    actualXFormParams.setXformSkipOverlaps(xformSkipOverlaps);
    String[] xformVals = new String[]{"Xform Vals"};
    actualXFormParams.setXformVals(xformVals);
    Boolean[] actualXformRenameMethodOverlaps = actualXFormParams.getXformRenameMethodOverlaps();
    Boolean[] actualXformSkipOverlaps = actualXFormParams.getXformSkipOverlaps();
    String[] actualXformVals = actualXFormParams.getXformVals();

    // Assert that nothing has changed
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
   * Method under test: {@link DirectCopyClassTransformer.XFormParams#isEmpty()}
   */
  @Test
  public void testXFormParamsIsEmpty() {
    // Arrange
    DirectCopyClassTransformer.XFormParams xFormParams = (new DirectCopyClassTransformer(
        "Module Name")).new XFormParams();
    xFormParams.setXformVals(new String[]{});

    // Act and Assert
    assertTrue(xFormParams.isEmpty());
  }

  /**
   * Test XFormParams {@link XFormParams#isEmpty()}.
   * <ul>
   *   <li>Given {@link XFormParams#XFormParams(DirectCopyClassTransformer)} with
   * this$0 is
   * {@link DirectCopyClassTransformer#DirectCopyClassTransformer(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectCopyClassTransformer.XFormParams#isEmpty()}
   */
  @Test
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
   * Method under test: {@link DirectCopyClassTransformer.XFormParams#isEmpty()}
   */
  @Test
  public void testXFormParamsIsEmpty_thenReturnFalse() {
    // Arrange
    DirectCopyClassTransformer.XFormParams xFormParams = (new DirectCopyClassTransformer(
        "Module Name")).new XFormParams();
    xFormParams.setXformVals(new String[]{"foo"});

    // Act and Assert
    assertFalse(xFormParams.isEmpty());
  }
}
