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
package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EarlyStageMergeBeanPostProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AbstractMergeBeanPostProcessorDiffblueTest {
  @Autowired
  private AbstractMergeBeanPostProcessor abstractMergeBeanPostProcessor;

  /**
   * Test BeanPackage getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BeanPackage#setPlacement(Placement)}
   *   <li>{@link BeanPackage#setPosition(int)}
   *   <li>{@link BeanPackage#setSourceRef(String)}
   *   <li>{@link BeanPackage#setStatusProvider(MergeBeanStatusProvider)}
   *   <li>{@link BeanPackage#setTargetRef(String)}
   *   <li>{@link BeanPackage#getPlacement()}
   *   <li>{@link BeanPackage#getPosition()}
   *   <li>{@link BeanPackage#getSourceRef()}
   *   <li>{@link BeanPackage#getStatusProvider()}
   *   <li>{@link BeanPackage#getTargetRef()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Placement BeanPackage.getPlacement()", "int BeanPackage.getPosition()",
      "String BeanPackage.getSourceRef()", "MergeBeanStatusProvider BeanPackage.getStatusProvider()",
      "String BeanPackage.getTargetRef()", "void BeanPackage.setPlacement(Placement)",
      "void BeanPackage.setPosition(int)", "void BeanPackage.setSourceRef(String)",
      "void BeanPackage.setStatusProvider(MergeBeanStatusProvider)", "void BeanPackage.setTargetRef(String)"})
  public void testBeanPackageGettersAndSetters() {
    // Arrange
    BeanPackage beanPackage = new BeanPackage();

    // Act
    beanPackage.setPlacement(Placement.PREPEND);
    beanPackage.setPosition(1);
    beanPackage.setSourceRef("Source Ref");
    MergeBeanStatusProvider statusProvider = mock(MergeBeanStatusProvider.class);
    beanPackage.setStatusProvider(statusProvider);
    beanPackage.setTargetRef("Target Ref");
    Placement actualPlacement = beanPackage.getPlacement();
    int actualPosition = beanPackage.getPosition();
    String actualSourceRef = beanPackage.getSourceRef();
    MergeBeanStatusProvider actualStatusProvider = beanPackage.getStatusProvider();

    // Assert
    assertEquals("Source Ref", actualSourceRef);
    assertEquals("Target Ref", beanPackage.getTargetRef());
    assertEquals(1, actualPosition);
    assertEquals(Placement.PREPEND, actualPlacement);
    assertSame(statusProvider, actualStatusProvider);
  }

  /**
   * Test BeanPackage new {@link BeanPackage} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BeanPackage}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BeanPackage.<init>()"})
  public void testBeanPackageNewBeanPackage() {
    // Arrange and Act
    BeanPackage actualBeanPackage = new BeanPackage();

    // Assert
    assertNull(actualBeanPackage.getSourceRef());
    assertNull(actualBeanPackage.getTargetRef());
    assertNull(actualBeanPackage.getStatusProvider());
    assertEquals(0, actualBeanPackage.getPosition());
    assertEquals(Placement.APPEND, actualBeanPackage.getPlacement());
    assertFalse(actualBeanPackage.bySource);
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setApplicationContext(ApplicationContext)}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#setApplicationContext(ApplicationContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMergeBeanPostProcessor.setApplicationContext(ApplicationContext)"})
  public void testSetApplicationContext() throws BeansException {
    // Arrange and Act
    abstractMergeBeanPostProcessor.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Assert
    assertTrue(abstractMergeBeanPostProcessor instanceof EarlyStageMergeBeanPostProcessor);
    ApplicationContext applicationContext = ((EarlyStageMergeBeanPostProcessor) abstractMergeBeanPostProcessor).applicationContext;
    assertTrue(applicationContext instanceof AnnotationConfigReactiveWebApplicationContext);
    assertEquals(0L, applicationContext.getStartupDate());
    assertEquals(6, applicationContext.getBeanDefinitionCount());
    assertEquals(6, applicationContext.getBeanDefinitionNames().length);
    assertFalse(((AnnotationConfigReactiveWebApplicationContext) applicationContext).isActive());
    assertFalse(((AnnotationConfigReactiveWebApplicationContext) applicationContext).isRunning());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#postProcessAfterInitialization(Object, String)}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#postProcessAfterInitialization(Object, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractMergeBeanPostProcessor.postProcessAfterInitialization(Object, String)"})
  public void testPostProcessAfterInitialization() throws BeansException {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(object, abstractMergeBeanPostProcessor.postProcessAfterInitialization(object, "Bean Name"));
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#postProcessBeforeInitialization(Object, String)}.
   * <ul>
   *   <li>When {@code Bean Name}.</li>
   *   <li>Then return {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#postProcessBeforeInitialization(Object, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractMergeBeanPostProcessor.postProcessBeforeInitialization(Object, String)"})
  public void testPostProcessBeforeInitialization_whenBeanName_thenReturnNull_field() throws BeansException {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(object, abstractMergeBeanPostProcessor.postProcessBeforeInitialization(object, "Bean Name"));
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#processPackage(BeanPackage, Object, String)} with {@code beanPackage}, {@code bean}, {@code beanName}.
   * <ul>
   *   <li>Then return {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#processPackage(BeanPackage, Object, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractMergeBeanPostProcessor.processPackage(BeanPackage, Object, String)"})
  public void testProcessPackageWithBeanPackageBeanBeanName_thenReturnNull_field() {
    // Arrange
    BeanPackage beanPackage = mock(BeanPackage.class);
    when(beanPackage.getPosition()).thenReturn(1);
    when(beanPackage.getSourceRef()).thenReturn("Source Ref");
    when(beanPackage.getTargetRef()).thenReturn("Target Ref");
    when(beanPackage.getStatusProvider()).thenReturn(mock(MergeBeanStatusProvider.class));
    when(beanPackage.getPlacement()).thenReturn(Placement.PREPEND);
    doNothing().when(beanPackage).setPlacement(Mockito.<Placement>any());
    doNothing().when(beanPackage).setPosition(anyInt());
    doNothing().when(beanPackage).setSourceRef(Mockito.<String>any());
    doNothing().when(beanPackage).setStatusProvider(Mockito.<MergeBeanStatusProvider>any());
    doNothing().when(beanPackage).setTargetRef(Mockito.<String>any());
    beanPackage.setPlacement(Placement.PREPEND);
    beanPackage.setPosition(1);
    beanPackage.setSourceRef("Source Ref");
    beanPackage.setStatusProvider(mock(MergeBeanStatusProvider.class));
    beanPackage.setTargetRef("Target Ref");
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    Object actualProcessPackageResult = abstractMergeBeanPostProcessor.processPackage(beanPackage, object, "Bean Name");

    // Assert
    verify(beanPackage).getPlacement();
    verify(beanPackage).getPosition();
    verify(beanPackage).getSourceRef();
    verify(beanPackage).getStatusProvider();
    verify(beanPackage).getTargetRef();
    verify(beanPackage).setPlacement(eq(Placement.PREPEND));
    verify(beanPackage).setPosition(eq(1));
    verify(beanPackage).setSourceRef(eq("Source Ref"));
    verify(beanPackage).setStatusProvider(isA(MergeBeanStatusProvider.class));
    verify(beanPackage).setTargetRef(eq("Target Ref"));
    assertSame(object, actualProcessPackageResult);
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#processPackage(BeanPackage, Object, String)} with {@code beanPackage}, {@code bean}, {@code beanName}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#processPackage(BeanPackage, Object, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractMergeBeanPostProcessor.processPackage(BeanPackage, Object, String)"})
  public void testProcessPackageWithBeanPackageBeanBeanName_thenThrowIllegalArgumentException() {
    // Arrange
    BeanPackage beanPackage = mock(BeanPackage.class);
    when(beanPackage.getPosition()).thenReturn(1);
    when(beanPackage.getSourceRef()).thenReturn("");
    when(beanPackage.getTargetRef()).thenReturn("Bean Name");
    when(beanPackage.getStatusProvider()).thenReturn(mock(MergeBeanStatusProvider.class));
    when(beanPackage.getPlacement()).thenReturn(Placement.PREPEND);
    doNothing().when(beanPackage).setPlacement(Mockito.<Placement>any());
    doNothing().when(beanPackage).setPosition(anyInt());
    doNothing().when(beanPackage).setSourceRef(Mockito.<String>any());
    doNothing().when(beanPackage).setStatusProvider(Mockito.<MergeBeanStatusProvider>any());
    doNothing().when(beanPackage).setTargetRef(Mockito.<String>any());
    beanPackage.setPlacement(Placement.PREPEND);
    beanPackage.setPosition(1);
    beanPackage.setSourceRef("Source Ref");
    beanPackage.setStatusProvider(mock(MergeBeanStatusProvider.class));
    beanPackage.setTargetRef("Target Ref");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> abstractMergeBeanPostProcessor.processPackage(beanPackage, BLCFieldUtils.NULL_FIELD, "Bean Name"));
    verify(beanPackage).getPlacement();
    verify(beanPackage).getPosition();
    verify(beanPackage).getSourceRef();
    verify(beanPackage).getStatusProvider();
    verify(beanPackage).getTargetRef();
    verify(beanPackage).setPlacement(eq(Placement.PREPEND));
    verify(beanPackage).setPosition(eq(1));
    verify(beanPackage).setSourceRef(eq("Source Ref"));
    verify(beanPackage).setStatusProvider(isA(MergeBeanStatusProvider.class));
    verify(beanPackage).setTargetRef(eq("Target Ref"));
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#processPackage(BeanPackage, Object, String)} with {@code beanPackage}, {@code bean}, {@code beanName}.
   * <ul>
   *   <li>When {@link BeanPackage} (default constructor) Placement is {@code PREPEND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#processPackage(BeanPackage, Object, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractMergeBeanPostProcessor.processPackage(BeanPackage, Object, String)"})
  public void testProcessPackageWithBeanPackageBeanBeanName_whenBeanPackagePlacementIsPrepend() {
    // Arrange
    BeanPackage beanPackage = new BeanPackage();
    beanPackage.setPlacement(Placement.PREPEND);
    beanPackage.setPosition(1);
    beanPackage.setSourceRef("Source Ref");
    beanPackage.setStatusProvider(mock(MergeBeanStatusProvider.class));
    beanPackage.setTargetRef("Target Ref");
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(object, abstractMergeBeanPostProcessor.processPackage(beanPackage, object, "Bean Name"));
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#addItemToSet(Object, Object, Placement, int)}.
   * <ul>
   *   <li>When {@code APPEND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#addItemToSet(Object, Object, Placement, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMergeBeanPostProcessor.addItemToSet(Object, Object, Placement, int)"})
  public void testAddItemToSet_whenAppend() throws IllegalAccessException, NoSuchFieldException {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();

    // Act
    abstractMergeBeanPostProcessor.addItemToSet(objectSet, BLCFieldUtils.NULL_FIELD, Placement.APPEND, 1);

    // Assert
    ApplicationContext applicationContext = ((EarlyStageMergeBeanPostProcessor) abstractMergeBeanPostProcessor).applicationContext;
    Collection<ProtocolResolver> protocolResolvers = ((GenericApplicationContext) applicationContext)
        .getProtocolResolvers();
    assertTrue(protocolResolvers instanceof Set);
    assertTrue(abstractMergeBeanPostProcessor instanceof EarlyStageMergeBeanPostProcessor);
    assertTrue(applicationContext instanceof GenericApplicationContext);
    assertEquals(1, objectSet.size());
    assertTrue(protocolResolvers.isEmpty());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#addItemToSet(Object, Object, Placement, int)}.
   * <ul>
   *   <li>When {@code PREPEND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#addItemToSet(Object, Object, Placement, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMergeBeanPostProcessor.addItemToSet(Object, Object, Placement, int)"})
  public void testAddItemToSet_whenPrepend() throws IllegalAccessException, NoSuchFieldException {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();

    // Act
    abstractMergeBeanPostProcessor.addItemToSet(objectSet, BLCFieldUtils.NULL_FIELD, Placement.PREPEND, 1);

    // Assert
    ApplicationContext applicationContext = ((EarlyStageMergeBeanPostProcessor) abstractMergeBeanPostProcessor).applicationContext;
    Collection<ProtocolResolver> protocolResolvers = ((GenericApplicationContext) applicationContext)
        .getProtocolResolvers();
    assertTrue(protocolResolvers instanceof Set);
    assertTrue(abstractMergeBeanPostProcessor instanceof EarlyStageMergeBeanPostProcessor);
    assertTrue(applicationContext instanceof GenericApplicationContext);
    assertEquals(1, objectSet.size());
    assertTrue(protocolResolvers.isEmpty());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#addItemToSet(Object, Object, Placement, int)}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#addItemToSet(Object, Object, Placement, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMergeBeanPostProcessor.addItemToSet(Object, Object, Placement, int)"})
  public void testAddItemToSet_whenZero() throws IllegalAccessException, NoSuchFieldException {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();

    // Act
    abstractMergeBeanPostProcessor.addItemToSet(objectSet, BLCFieldUtils.NULL_FIELD, Placement.SPECIFIC, 0);

    // Assert
    ApplicationContext applicationContext = ((EarlyStageMergeBeanPostProcessor) abstractMergeBeanPostProcessor).applicationContext;
    Collection<ProtocolResolver> protocolResolvers = ((GenericApplicationContext) applicationContext)
        .getProtocolResolvers();
    assertTrue(protocolResolvers instanceof Set);
    assertTrue(abstractMergeBeanPostProcessor instanceof EarlyStageMergeBeanPostProcessor);
    assertTrue(applicationContext instanceof GenericApplicationContext);
    assertEquals(1, objectSet.size());
    assertTrue(protocolResolvers.isEmpty());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#addItemToList(Object, Object, Placement, int)}.
   * <ul>
   *   <li>When {@code APPEND}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#addItemToList(Object, Object, Placement, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMergeBeanPostProcessor.addItemToList(Object, Object, Placement, int)"})
  public void testAddItemToList_whenAppend_thenArrayListSizeIsOne()
      throws IllegalAccessException, NoSuchFieldException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    abstractMergeBeanPostProcessor.addItemToList(objectList, object, Placement.APPEND, 1);

    // Assert
    assertEquals(1, objectList.size());
    assertSame(object, objectList.get(0));
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#addItemToList(Object, Object, Placement, int)}.
   * <ul>
   *   <li>When {@code PREPEND}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#addItemToList(Object, Object, Placement, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMergeBeanPostProcessor.addItemToList(Object, Object, Placement, int)"})
  public void testAddItemToList_whenPrepend_thenArrayListSizeIsOne()
      throws IllegalAccessException, NoSuchFieldException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    abstractMergeBeanPostProcessor.addItemToList(objectList, object, Placement.PREPEND, 1);

    // Assert
    assertEquals(1, objectList.size());
    assertSame(object, objectList.get(0));
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#addItemToList(Object, Object, Placement, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#addItemToList(Object, Object, Placement, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMergeBeanPostProcessor.addItemToList(Object, Object, Placement, int)"})
  public void testAddItemToList_whenZero_thenArrayListSizeIsOne() throws IllegalAccessException, NoSuchFieldException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    abstractMergeBeanPostProcessor.addItemToList(objectList, object, Placement.SPECIFIC, 0);

    // Assert
    assertEquals(1, objectList.size());
    assertSame(object, objectList.get(0));
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setCollectionRef(String)}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#setCollectionRef(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMergeBeanPostProcessor.setCollectionRef(String)"})
  public void testSetCollectionRef() {
    // Arrange and Act
    abstractMergeBeanPostProcessor.setCollectionRef("Collection Ref");

    // Assert
    assertTrue(abstractMergeBeanPostProcessor instanceof EarlyStageMergeBeanPostProcessor);
    assertEquals("Collection Ref", abstractMergeBeanPostProcessor.getCollectionRef());
    assertEquals("Collection Ref", abstractMergeBeanPostProcessor.getSourceRef());
    assertEquals("Collection Ref",
        ((EarlyStageMergeBeanPostProcessor) abstractMergeBeanPostProcessor).defaultBeanPackage.getSourceRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setSourceRef(String)}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#setSourceRef(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMergeBeanPostProcessor.setSourceRef(String)"})
  public void testSetSourceRef() {
    // Arrange and Act
    abstractMergeBeanPostProcessor.setSourceRef("Source Ref");

    // Assert
    assertTrue(abstractMergeBeanPostProcessor instanceof EarlyStageMergeBeanPostProcessor);
    assertEquals("Source Ref", abstractMergeBeanPostProcessor.getCollectionRef());
    assertEquals("Source Ref", abstractMergeBeanPostProcessor.getSourceRef());
    assertEquals("Source Ref",
        ((EarlyStageMergeBeanPostProcessor) abstractMergeBeanPostProcessor).defaultBeanPackage.getSourceRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setTargetRef(String)}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#setTargetRef(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMergeBeanPostProcessor.setTargetRef(String)"})
  public void testSetTargetRef() {
    // Arrange and Act
    abstractMergeBeanPostProcessor.setTargetRef("Target Ref");

    // Assert
    assertTrue(abstractMergeBeanPostProcessor instanceof EarlyStageMergeBeanPostProcessor);
    assertEquals("Target Ref", abstractMergeBeanPostProcessor.getTargetRef());
    assertEquals("Target Ref",
        ((EarlyStageMergeBeanPostProcessor) abstractMergeBeanPostProcessor).defaultBeanPackage.getTargetRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getPlacement()}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getPlacement()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Placement AbstractMergeBeanPostProcessor.getPlacement()"})
  public void testGetPlacement() {
    // Arrange, Act and Assert
    assertEquals(Placement.APPEND, abstractMergeBeanPostProcessor.getPlacement());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setPlacement(Placement)}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#setPlacement(Placement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMergeBeanPostProcessor.setPlacement(Placement)"})
  public void testSetPlacement() {
    // Arrange and Act
    abstractMergeBeanPostProcessor.setPlacement(Placement.PREPEND);

    // Assert
    assertTrue(abstractMergeBeanPostProcessor instanceof EarlyStageMergeBeanPostProcessor);
    assertEquals(Placement.PREPEND, abstractMergeBeanPostProcessor.getPlacement());
    assertEquals(Placement.PREPEND,
        ((EarlyStageMergeBeanPostProcessor) abstractMergeBeanPostProcessor).defaultBeanPackage.getPlacement());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getPosition()}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getPosition()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AbstractMergeBeanPostProcessor.getPosition()"})
  public void testGetPosition() {
    // Arrange, Act and Assert
    assertEquals(0, abstractMergeBeanPostProcessor.getPosition());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setPosition(int)}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#setPosition(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMergeBeanPostProcessor.setPosition(int)"})
  public void testSetPosition() {
    // Arrange and Act
    abstractMergeBeanPostProcessor.setPosition(1);

    // Assert
    assertTrue(abstractMergeBeanPostProcessor instanceof EarlyStageMergeBeanPostProcessor);
    assertEquals(1, abstractMergeBeanPostProcessor.getPosition());
    assertEquals(1,
        ((EarlyStageMergeBeanPostProcessor) abstractMergeBeanPostProcessor).defaultBeanPackage.getPosition());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getStatusProvider()}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getStatusProvider()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MergeBeanStatusProvider AbstractMergeBeanPostProcessor.getStatusProvider()"})
  public void testGetStatusProvider() {
    // Arrange, Act and Assert
    assertNull(abstractMergeBeanPostProcessor.getStatusProvider());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setStatusProvider(MergeBeanStatusProvider)}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#setStatusProvider(MergeBeanStatusProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractMergeBeanPostProcessor.setStatusProvider(MergeBeanStatusProvider)"})
  public void testSetStatusProvider() {
    // Arrange
    MergeBeanStatusProvider statusProvider = mock(MergeBeanStatusProvider.class);

    // Act
    abstractMergeBeanPostProcessor.setStatusProvider(statusProvider);

    // Assert
    assertTrue(abstractMergeBeanPostProcessor instanceof EarlyStageMergeBeanPostProcessor);
    assertSame(statusProvider, abstractMergeBeanPostProcessor.getStatusProvider());
    assertSame(statusProvider,
        ((EarlyStageMergeBeanPostProcessor) abstractMergeBeanPostProcessor).defaultBeanPackage.getStatusProvider());
  }
}
