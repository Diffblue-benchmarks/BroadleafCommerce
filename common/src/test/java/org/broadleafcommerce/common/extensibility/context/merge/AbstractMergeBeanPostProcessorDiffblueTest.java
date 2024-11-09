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
package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import org.broadleafcommerce.common.extensibility.config.PropertyConfigurer;
import org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AbstractMergeBeanPostProcessorDiffblueTest {
  /**
   * Test BeanPackage getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AbstractMergeBeanPostProcessor.BeanPackage#setPlacement(Placement)}
   *   <li>{@link AbstractMergeBeanPostProcessor.BeanPackage#setPosition(int)}
   *   <li>{@link AbstractMergeBeanPostProcessor.BeanPackage#setSourceRef(String)}
   *   <li>
   * {@link AbstractMergeBeanPostProcessor.BeanPackage#setStatusProvider(MergeBeanStatusProvider)}
   *   <li>{@link AbstractMergeBeanPostProcessor.BeanPackage#setTargetRef(String)}
   *   <li>{@link AbstractMergeBeanPostProcessor.BeanPackage#getPlacement()}
   *   <li>{@link AbstractMergeBeanPostProcessor.BeanPackage#getPosition()}
   *   <li>{@link AbstractMergeBeanPostProcessor.BeanPackage#getSourceRef()}
   *   <li>{@link AbstractMergeBeanPostProcessor.BeanPackage#getStatusProvider()}
   *   <li>{@link AbstractMergeBeanPostProcessor.BeanPackage#getTargetRef()}
   * </ul>
   */
  @Test
  public void testBeanPackageGettersAndSetters() {
    // Arrange
    AbstractMergeBeanPostProcessor.BeanPackage beanPackage = new AbstractMergeBeanPostProcessor.BeanPackage();

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

    // Assert that nothing has changed
    assertEquals("Source Ref", actualSourceRef);
    assertEquals("Target Ref", beanPackage.getTargetRef());
    assertEquals(1, actualPosition);
    assertEquals(Placement.PREPEND, actualPlacement);
    assertSame(statusProvider, actualStatusProvider);
  }

  /**
   * Test BeanPackage new {@link BeanPackage} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractMergeBeanPostProcessor.BeanPackage}
   */
  @Test
  public void testBeanPackageNewBeanPackage() {
    // Arrange and Act
    AbstractMergeBeanPostProcessor.BeanPackage actualBeanPackage = new AbstractMergeBeanPostProcessor.BeanPackage();

    // Assert
    assertNull(actualBeanPackage.getSourceRef());
    assertNull(actualBeanPackage.getTargetRef());
    assertNull(actualBeanPackage.getStatusProvider());
    assertEquals(0, actualBeanPackage.getPosition());
    assertEquals(Placement.APPEND, actualBeanPackage.getPlacement());
    assertFalse(actualBeanPackage.bySource);
  }

  /**
   * Test
   * {@link AbstractMergeBeanPostProcessor#setApplicationContext(ApplicationContext)}.
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#setApplicationContext(ApplicationContext)}
   */
  @Test
  public void testSetApplicationContext() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();

    // Act
    earlyStageMergeBeanPostProcessor.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Assert
    ApplicationContext applicationContext = earlyStageMergeBeanPostProcessor.applicationContext;
    assertTrue(applicationContext instanceof AnnotationConfigReactiveWebApplicationContext);
    assertEquals("", applicationContext.getApplicationName());
    assertNull(applicationContext.getParentBeanFactory());
    assertNull(applicationContext.getParent());
    assertEquals(0L, applicationContext.getStartupDate());
    assertEquals(6, applicationContext.getBeanDefinitionCount());
    assertFalse(((AnnotationConfigReactiveWebApplicationContext) applicationContext).isActive());
    assertFalse(((AnnotationConfigReactiveWebApplicationContext) applicationContext).isRunning());
    assertArrayEquals(
        new String[]{"org.springframework.context.annotation.internalConfigurationAnnotationProcessor",
            "org.springframework.context.annotation.internalAutowiredAnnotationProcessor",
            "org.springframework.context.annotation.internalCommonAnnotationProcessor",
            "org.springframework.context.annotation.internalPersistenceAnnotationProcessor",
            "org.springframework.context.event.internalEventListenerProcessor",
            "org.springframework.context.event.internalEventListenerFactory"},
        applicationContext.getBeanDefinitionNames());
  }

  /**
   * Test
   * {@link AbstractMergeBeanPostProcessor#postProcessAfterInitialization(Object, String)}.
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#postProcessAfterInitialization(Object, String)}
   */
  @Test
  public void testPostProcessAfterInitialization() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(mock(MergeBeanStatusProvider.class));
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(object, earlyStageMergeBeanPostProcessor.postProcessAfterInitialization(object, "Bean Name"));
  }

  /**
   * Test
   * {@link AbstractMergeBeanPostProcessor#postProcessAfterInitialization(Object, String)}.
   * <ul>
   *   <li>Given {@link EarlyStageMergeBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#postProcessAfterInitialization(Object, String)}
   */
  @Test
  public void testPostProcessAfterInitialization_givenEarlyStageMergeBeanPostProcessor() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(object, (new EarlyStageMergeBeanPostProcessor()).postProcessAfterInitialization(object, "Bean Name"));
  }

  /**
   * Test
   * {@link AbstractMergeBeanPostProcessor#postProcessBeforeInitialization(Object, String)}.
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#postProcessBeforeInitialization(Object, String)}
   */
  @Test
  public void testPostProcessBeforeInitialization() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(mock(MergeBeanStatusProvider.class));
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(object, earlyStageMergeBeanPostProcessor.postProcessBeforeInitialization(object, "Bean Name"));
  }

  /**
   * Test
   * {@link AbstractMergeBeanPostProcessor#postProcessBeforeInitialization(Object, String)}.
   * <ul>
   *   <li>Then return {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#postProcessBeforeInitialization(Object, String)}
   */
  @Test
  public void testPostProcessBeforeInitialization_thenReturnNull_field() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(object, (new EarlyStageMergeBeanPostProcessor()).postProcessBeforeInitialization(object, "Bean Name"));
  }

  /**
   * Test
   * {@link AbstractMergeBeanPostProcessor#processPackage(BeanPackage, Object, String)}
   * with {@code beanPackage}, {@code bean}, {@code beanName}.
   * <ul>
   *   <li>Then calls {@link BeanPackage#getPlacement()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#processPackage(AbstractMergeBeanPostProcessor.BeanPackage, Object, String)}
   */
  @Test
  public void testProcessPackageWithBeanPackageBeanBeanName_thenCallsGetPlacement() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    AbstractMergeBeanPostProcessor.BeanPackage beanPackage = mock(AbstractMergeBeanPostProcessor.BeanPackage.class);
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
    Object actualProcessPackageResult = earlyStageMergeBeanPostProcessor.processPackage(beanPackage, object,
        "Bean Name");

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
   * Test
   * {@link AbstractMergeBeanPostProcessor#processPackage(BeanPackage, Object, String)}
   * with {@code beanPackage}, {@code bean}, {@code beanName}.
   * <ul>
   *   <li>When {@link BeanPackage} (default constructor) Placement is
   * {@code PREPEND}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#processPackage(AbstractMergeBeanPostProcessor.BeanPackage, Object, String)}
   */
  @Test
  public void testProcessPackageWithBeanPackageBeanBeanName_whenBeanPackagePlacementIsPrepend() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();

    AbstractMergeBeanPostProcessor.BeanPackage beanPackage = new AbstractMergeBeanPostProcessor.BeanPackage();
    beanPackage.setPlacement(Placement.PREPEND);
    beanPackage.setPosition(1);
    beanPackage.setSourceRef("Source Ref");
    beanPackage.setStatusProvider(mock(MergeBeanStatusProvider.class));
    beanPackage.setTargetRef("Target Ref");
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(object, earlyStageMergeBeanPostProcessor.processPackage(beanPackage, object, "Bean Name"));
  }

  /**
   * Test
   * {@link AbstractMergeBeanPostProcessor#addItemToSet(Object, Object, Placement, int)}.
   * <ul>
   *   <li>When {@code APPEND}.</li>
   *   <li>Then {@link HashSet#HashSet()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#addItemToSet(Object, Object, Placement, int)}
   */
  @Test
  public void testAddItemToSet_whenAppend_thenHashSetSizeIsOne() throws IllegalAccessException, NoSuchFieldException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    HashSet<Object> objectSet = new HashSet<>();

    // Act
    earlyStageMergeBeanPostProcessor.addItemToSet(objectSet, BLCFieldUtils.NULL_FIELD, Placement.APPEND, 1);

    // Assert
    assertEquals(1, objectSet.size());
  }

  /**
   * Test
   * {@link AbstractMergeBeanPostProcessor#addItemToSet(Object, Object, Placement, int)}.
   * <ul>
   *   <li>When {@code PREPEND}.</li>
   *   <li>Then {@link HashSet#HashSet()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#addItemToSet(Object, Object, Placement, int)}
   */
  @Test
  public void testAddItemToSet_whenPrepend_thenHashSetSizeIsOne() throws IllegalAccessException, NoSuchFieldException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    HashSet<Object> objectSet = new HashSet<>();

    // Act
    earlyStageMergeBeanPostProcessor.addItemToSet(objectSet, BLCFieldUtils.NULL_FIELD, Placement.PREPEND, 1);

    // Assert
    assertEquals(1, objectSet.size());
  }

  /**
   * Test
   * {@link AbstractMergeBeanPostProcessor#addItemToList(Object, Object, Placement, int)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#addItemToList(Object, Object, Placement, int)}
   */
  @Test
  public void testAddItemToList_whenArrayList_thenArrayListSizeIsOne()
      throws IllegalAccessException, NoSuchFieldException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    ArrayList<Object> objectList = new ArrayList<>();
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    earlyStageMergeBeanPostProcessor.addItemToList(objectList, object, Placement.APPEND, 1);

    // Assert
    assertEquals(1, objectList.size());
    assertSame(object, objectList.get(0));
  }

  /**
   * Test
   * {@link AbstractMergeBeanPostProcessor#addItemToList(Object, Object, Placement, int)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#addItemToList(Object, Object, Placement, int)}
   */
  @Test
  public void testAddItemToList_whenArrayList_thenArrayListSizeIsOne2()
      throws IllegalAccessException, NoSuchFieldException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    ArrayList<Object> objectList = new ArrayList<>();
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    earlyStageMergeBeanPostProcessor.addItemToList(objectList, object, Placement.PREPEND, 1);

    // Assert
    assertEquals(1, objectList.size());
    assertSame(object, objectList.get(0));
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getCollectionRef()}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getCollectionRef()}
   */
  @Test
  public void testGetCollectionRef() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(mock(MergeBeanStatusProvider.class));

    // Act and Assert
    assertNull(earlyStageMergeBeanPostProcessor.getCollectionRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getCollectionRef()}.
   * <ul>
   *   <li>Given {@link EarlyStageMergeBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getCollectionRef()}
   */
  @Test
  public void testGetCollectionRef_givenEarlyStageMergeBeanPostProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EarlyStageMergeBeanPostProcessor()).getCollectionRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setCollectionRef(String)}.
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#setCollectionRef(String)}
   */
  @Test
  public void testSetCollectionRef() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(mock(MergeBeanStatusProvider.class));

    // Act
    earlyStageMergeBeanPostProcessor.setCollectionRef("Collection Ref");

    // Assert
    assertEquals("Collection Ref", earlyStageMergeBeanPostProcessor.getCollectionRef());
    assertEquals("Collection Ref", earlyStageMergeBeanPostProcessor.getSourceRef());
    assertEquals("Collection Ref", earlyStageMergeBeanPostProcessor.defaultBeanPackage.getSourceRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setCollectionRef(String)}.
   * <ul>
   *   <li>Given {@link EarlyStageMergeBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#setCollectionRef(String)}
   */
  @Test
  public void testSetCollectionRef_givenEarlyStageMergeBeanPostProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();

    // Act
    earlyStageMergeBeanPostProcessor.setCollectionRef("Collection Ref");

    // Assert
    assertEquals("Collection Ref", earlyStageMergeBeanPostProcessor.getCollectionRef());
    assertEquals("Collection Ref", earlyStageMergeBeanPostProcessor.getSourceRef());
    assertEquals("Collection Ref", earlyStageMergeBeanPostProcessor.defaultBeanPackage.getSourceRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getSourceRef()}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getSourceRef()}
   */
  @Test
  public void testGetSourceRef() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(mock(MergeBeanStatusProvider.class));

    // Act and Assert
    assertNull(earlyStageMergeBeanPostProcessor.getSourceRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getSourceRef()}.
   * <ul>
   *   <li>Given {@link EarlyStageMergeBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getSourceRef()}
   */
  @Test
  public void testGetSourceRef_givenEarlyStageMergeBeanPostProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EarlyStageMergeBeanPostProcessor()).getSourceRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setSourceRef(String)}.
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#setSourceRef(String)}
   */
  @Test
  public void testSetSourceRef() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(mock(MergeBeanStatusProvider.class));

    // Act
    earlyStageMergeBeanPostProcessor.setSourceRef("Source Ref");

    // Assert
    assertEquals("Source Ref", earlyStageMergeBeanPostProcessor.getCollectionRef());
    assertEquals("Source Ref", earlyStageMergeBeanPostProcessor.getSourceRef());
    assertEquals("Source Ref", earlyStageMergeBeanPostProcessor.defaultBeanPackage.getSourceRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setSourceRef(String)}.
   * <ul>
   *   <li>Given {@link EarlyStageMergeBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#setSourceRef(String)}
   */
  @Test
  public void testSetSourceRef_givenEarlyStageMergeBeanPostProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();

    // Act
    earlyStageMergeBeanPostProcessor.setSourceRef("Source Ref");

    // Assert
    assertEquals("Source Ref", earlyStageMergeBeanPostProcessor.getCollectionRef());
    assertEquals("Source Ref", earlyStageMergeBeanPostProcessor.getSourceRef());
    assertEquals("Source Ref", earlyStageMergeBeanPostProcessor.defaultBeanPackage.getSourceRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getTargetRef()}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getTargetRef()}
   */
  @Test
  public void testGetTargetRef() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(mock(MergeBeanStatusProvider.class));

    // Act and Assert
    assertNull(earlyStageMergeBeanPostProcessor.getTargetRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getTargetRef()}.
   * <ul>
   *   <li>Given {@link EarlyStageMergeBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getTargetRef()}
   */
  @Test
  public void testGetTargetRef_givenEarlyStageMergeBeanPostProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EarlyStageMergeBeanPostProcessor()).getTargetRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setTargetRef(String)}.
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#setTargetRef(String)}
   */
  @Test
  public void testSetTargetRef() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(mock(MergeBeanStatusProvider.class));

    // Act
    earlyStageMergeBeanPostProcessor.setTargetRef("Target Ref");

    // Assert
    assertEquals("Target Ref", earlyStageMergeBeanPostProcessor.getTargetRef());
    assertEquals("Target Ref", earlyStageMergeBeanPostProcessor.defaultBeanPackage.getTargetRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setTargetRef(String)}.
   * <ul>
   *   <li>Given {@link EarlyStageMergeBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#setTargetRef(String)}
   */
  @Test
  public void testSetTargetRef_givenEarlyStageMergeBeanPostProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();

    // Act
    earlyStageMergeBeanPostProcessor.setTargetRef("Target Ref");

    // Assert
    assertEquals("Target Ref", earlyStageMergeBeanPostProcessor.getTargetRef());
    assertEquals("Target Ref", earlyStageMergeBeanPostProcessor.defaultBeanPackage.getTargetRef());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getPlacement()}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getPlacement()}
   */
  @Test
  public void testGetPlacement() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(mock(MergeBeanStatusProvider.class));

    // Act and Assert
    assertEquals(Placement.APPEND, earlyStageMergeBeanPostProcessor.getPlacement());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getPlacement()}.
   * <ul>
   *   <li>Given {@link EarlyStageMergeBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getPlacement()}
   */
  @Test
  public void testGetPlacement_givenEarlyStageMergeBeanPostProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(Placement.APPEND, (new EarlyStageMergeBeanPostProcessor()).getPlacement());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setPlacement(Placement)}.
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#setPlacement(Placement)}
   */
  @Test
  public void testSetPlacement() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(mock(MergeBeanStatusProvider.class));

    // Act
    earlyStageMergeBeanPostProcessor.setPlacement(Placement.PREPEND);

    // Assert
    assertEquals(Placement.PREPEND, earlyStageMergeBeanPostProcessor.getPlacement());
    assertEquals(Placement.PREPEND, earlyStageMergeBeanPostProcessor.defaultBeanPackage.getPlacement());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setPlacement(Placement)}.
   * <ul>
   *   <li>Given {@link EarlyStageMergeBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#setPlacement(Placement)}
   */
  @Test
  public void testSetPlacement_givenEarlyStageMergeBeanPostProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();

    // Act
    earlyStageMergeBeanPostProcessor.setPlacement(Placement.PREPEND);

    // Assert
    assertEquals(Placement.PREPEND, earlyStageMergeBeanPostProcessor.getPlacement());
    assertEquals(Placement.PREPEND, earlyStageMergeBeanPostProcessor.defaultBeanPackage.getPlacement());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getPosition()}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getPosition()}
   */
  @Test
  public void testGetPosition() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(mock(MergeBeanStatusProvider.class));

    // Act and Assert
    assertEquals(0, earlyStageMergeBeanPostProcessor.getPosition());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getPosition()}.
   * <ul>
   *   <li>Given {@link EarlyStageMergeBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getPosition()}
   */
  @Test
  public void testGetPosition_givenEarlyStageMergeBeanPostProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new EarlyStageMergeBeanPostProcessor()).getPosition());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setPosition(int)}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#setPosition(int)}
   */
  @Test
  public void testSetPosition() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(mock(MergeBeanStatusProvider.class));

    // Act
    earlyStageMergeBeanPostProcessor.setPosition(1);

    // Assert
    assertEquals(1, earlyStageMergeBeanPostProcessor.getPosition());
    assertEquals(1, earlyStageMergeBeanPostProcessor.defaultBeanPackage.getPosition());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#setPosition(int)}.
   * <ul>
   *   <li>Given {@link EarlyStageMergeBeanPostProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#setPosition(int)}
   */
  @Test
  public void testSetPosition_givenEarlyStageMergeBeanPostProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();

    // Act
    earlyStageMergeBeanPostProcessor.setPosition(1);

    // Assert
    assertEquals(1, earlyStageMergeBeanPostProcessor.getPosition());
    assertEquals(1, earlyStageMergeBeanPostProcessor.defaultBeanPackage.getPosition());
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getStatusProvider()}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getStatusProvider()}
   */
  @Test
  public void testGetStatusProvider() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeBeanStatusProvider statusProvider = mock(MergeBeanStatusProvider.class);
    when(statusProvider.isProcessingEnabled(Mockito.<Object>any(), Mockito.<String>any(),
        Mockito.<ApplicationContext>any())).thenReturn(true);

    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(statusProvider);

    // Act
    MergeBeanStatusProvider actualStatusProvider = earlyStageMergeBeanPostProcessor.getStatusProvider();
    AnnotationConfigApplicationContext annotationConfigApplicationContext = mock(
        AnnotationConfigApplicationContext.class);
    doNothing().when(annotationConfigApplicationContext)
        .addBeanFactoryPostProcessor(Mockito.<BeanFactoryPostProcessor>any());
    annotationConfigApplicationContext.addBeanFactoryPostProcessor(new PropertyConfigurer());
    boolean actualIsProcessingEnabledResult = actualStatusProvider.isProcessingEnabled(BLCFieldUtils.NULL_FIELD, "foo",
        annotationConfigApplicationContext);

    // Assert
    verify(statusProvider).isProcessingEnabled(isA(Object.class), eq("foo"), isA(ApplicationContext.class));
    verify(annotationConfigApplicationContext).addBeanFactoryPostProcessor(isA(BeanFactoryPostProcessor.class));
    assertTrue(actualIsProcessingEnabledResult);
  }

  /**
   * Test {@link AbstractMergeBeanPostProcessor#getStatusProvider()}.
   * <p>
   * Method under test: {@link AbstractMergeBeanPostProcessor#getStatusProvider()}
   */
  @Test
  public void testGetStatusProvider2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeBeanStatusProvider statusProvider = mock(MergeBeanStatusProvider.class);
    when(statusProvider.isProcessingEnabled(Mockito.<Object>any(), Mockito.<String>any(),
        Mockito.<ApplicationContext>any())).thenReturn(false);

    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    earlyStageMergeBeanPostProcessor.setStatusProvider(statusProvider);

    // Act
    MergeBeanStatusProvider actualStatusProvider = earlyStageMergeBeanPostProcessor.getStatusProvider();
    AnnotationConfigApplicationContext annotationConfigApplicationContext = mock(
        AnnotationConfigApplicationContext.class);
    doNothing().when(annotationConfigApplicationContext)
        .addBeanFactoryPostProcessor(Mockito.<BeanFactoryPostProcessor>any());
    annotationConfigApplicationContext.addBeanFactoryPostProcessor(new PropertyConfigurer());
    boolean actualIsProcessingEnabledResult = actualStatusProvider.isProcessingEnabled(BLCFieldUtils.NULL_FIELD, "foo",
        annotationConfigApplicationContext);

    // Assert
    verify(statusProvider).isProcessingEnabled(isA(Object.class), eq("foo"), isA(ApplicationContext.class));
    verify(annotationConfigApplicationContext).addBeanFactoryPostProcessor(isA(BeanFactoryPostProcessor.class));
    assertFalse(actualIsProcessingEnabledResult);
  }

  /**
   * Test
   * {@link AbstractMergeBeanPostProcessor#setStatusProvider(MergeBeanStatusProvider)}.
   * <p>
   * Method under test:
   * {@link AbstractMergeBeanPostProcessor#setStatusProvider(MergeBeanStatusProvider)}
   */
  @Test
  public void testSetStatusProvider() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();
    MergeBeanStatusProvider statusProvider = mock(MergeBeanStatusProvider.class);

    // Act
    earlyStageMergeBeanPostProcessor.setStatusProvider(statusProvider);

    // Assert
    assertSame(statusProvider, earlyStageMergeBeanPostProcessor.getStatusProvider());
    assertSame(statusProvider, earlyStageMergeBeanPostProcessor.defaultBeanPackage.getStatusProvider());
  }
}
