/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Field;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FieldModifierManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldModifierManagerDiffblueTest {
  @MockBean private FieldManagerModifier fieldManagerModifier;

  @Autowired private FieldModifierManager fieldModifierManager;

  @Autowired private List<FieldManagerModifier> list;

  /**
   * Test {@link FieldModifierManager#getFieldModifierManager()}.
   *
   * <p>Method under test: {@link FieldModifierManager#getFieldModifierManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldModifierManager FieldModifierManager.getFieldModifierManager()"})
  public void testGetFieldModifierManager() {
    // Arrange, Act and Assert
    assertEquals(1, FieldModifierManager.getFieldModifierManager().fieldManagerModifiers.size());
  }

  /**
   * Test {@link FieldModifierManager#getModifiedWriteValue(Field, Object, Object, EntityManager)}.
   *
   * <p>Method under test: {@link FieldModifierManager#getModifiedWriteValue(Field, Object, Object,
   * EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldModifierManager.getModifiedWriteValue(Field, Object, Object, EntityManager)"
  })
  public void testGetModifiedWriteValue() throws IllegalAccessException {
    // Arrange
    when(fieldManagerModifier.canHandle(
            Mockito.<Field>any(), Mockito.<Object>any(), Mockito.<EntityManager>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> fieldModifierManager.getModifiedWriteValue(null, "Value", "New Value", null));
    verify(fieldManagerModifier).canHandle(isNull(), isA(Object.class), isNull());
  }

  /**
   * Test {@link FieldModifierManager#getModifiedWriteValue(Field, Object, Object, EntityManager)}.
   *
   * <p>Method under test: {@link FieldModifierManager#getModifiedWriteValue(Field, Object, Object,
   * EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldModifierManager.getModifiedWriteValue(Field, Object, Object, EntityManager)"
  })
  public void testGetModifiedWriteValue2() throws IllegalAccessException {
    // Arrange
    when(fieldManagerModifier.getModifiedWriteValue(
            Mockito.<Field>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<EntityManager>any()))
        .thenThrow(new FactoryBeanNotInitializedException("Msg"));
    when(fieldManagerModifier.canHandle(
            Mockito.<Field>any(), Mockito.<Object>any(), Mockito.<EntityManager>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> fieldModifierManager.getModifiedWriteValue(null, "Value", "New Value", null));
    verify(fieldManagerModifier).canHandle(isNull(), isA(Object.class), isNull());
    verify(fieldManagerModifier)
        .getModifiedWriteValue(isNull(), isA(Object.class), isA(Object.class), isNull());
  }

  /**
   * Test {@link FieldModifierManager#getModifiedWriteValue(Field, Object, Object, EntityManager)}.
   *
   * <ul>
   *   <li>Given {@link FieldManagerModifier} {@link FieldManagerModifier#canHandle(Field, Object,
   *       EntityManager)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldModifierManager#getModifiedWriteValue(Field, Object, Object,
   * EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldModifierManager.getModifiedWriteValue(Field, Object, Object, EntityManager)"
  })
  public void testGetModifiedWriteValue_givenFieldManagerModifierCanHandleReturnFalse()
      throws IllegalAccessException {
    // Arrange
    when(fieldManagerModifier.canHandle(
            Mockito.<Field>any(), Mockito.<Object>any(), Mockito.<EntityManager>any()))
        .thenReturn(false);

    // Act
    Object actualModifiedWriteValue =
        fieldModifierManager.getModifiedWriteValue(null, "Value", "New Value", null);

    // Assert
    verify(fieldManagerModifier).canHandle(isNull(), isA(Object.class), isNull());
    assertEquals("New Value", actualModifiedWriteValue);
  }

  /**
   * Test {@link FieldModifierManager#getModifiedWriteValue(Field, Object, Object, EntityManager)}.
   *
   * <ul>
   *   <li>Given {@link FieldModifierManager} (default constructor).
   *   <li>Then return {@code New Value}.
   * </ul>
   *
   * <p>Method under test: {@link FieldModifierManager#getModifiedWriteValue(Field, Object, Object,
   * EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldModifierManager.getModifiedWriteValue(Field, Object, Object, EntityManager)"
  })
  public void testGetModifiedWriteValue_givenFieldModifierManager_thenReturnNewValue()
      throws IllegalAccessException {
    // Arrange, Act and Assert
    assertEquals(
        "New Value",
        new FieldModifierManager().getModifiedWriteValue(null, "Value", "New Value", null));
  }

  /**
   * Test {@link FieldModifierManager#getModifiedWriteValue(Field, Object, Object, EntityManager)}.
   *
   * <ul>
   *   <li>Then return {@code Modified Write Value}.
   * </ul>
   *
   * <p>Method under test: {@link FieldModifierManager#getModifiedWriteValue(Field, Object, Object,
   * EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldModifierManager.getModifiedWriteValue(Field, Object, Object, EntityManager)"
  })
  public void testGetModifiedWriteValue_thenReturnModifiedWriteValue()
      throws IllegalAccessException {
    // Arrange
    when(fieldManagerModifier.getModifiedWriteValue(
            Mockito.<Field>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<EntityManager>any()))
        .thenReturn("Modified Write Value");
    when(fieldManagerModifier.canHandle(
            Mockito.<Field>any(), Mockito.<Object>any(), Mockito.<EntityManager>any()))
        .thenReturn(true);

    // Act
    Object actualModifiedWriteValue =
        fieldModifierManager.getModifiedWriteValue(null, "Value", "New Value", null);

    // Assert
    verify(fieldManagerModifier).canHandle(isNull(), isA(Object.class), isNull());
    verify(fieldManagerModifier)
        .getModifiedWriteValue(isNull(), isA(Object.class), isA(Object.class), isNull());
    assertEquals("Modified Write Value", actualModifiedWriteValue);
  }

  /**
   * Test {@link FieldModifierManager#getModifiedReadValue(Field, Object, EntityManager)}.
   *
   * <ul>
   *   <li>Given {@link FieldManagerModifier}.
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link FieldModifierManager#getModifiedReadValue(Field, Object,
   * EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldModifierManager.getModifiedReadValue(Field, Object, EntityManager)"
  })
  public void testGetModifiedReadValue_givenFieldManagerModifier_whenValue_thenReturnValue()
      throws IllegalAccessException {
    // Arrange, Act and Assert
    assertEquals("Value", fieldModifierManager.getModifiedReadValue(null, "Value", null));
  }

  /**
   * Test {@link FieldModifierManager#getModifiedReadValue(Field, Object, EntityManager)}.
   *
   * <ul>
   *   <li>Given {@link FieldModifierManager} (default constructor).
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link FieldModifierManager#getModifiedReadValue(Field, Object,
   * EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FieldModifierManager.getModifiedReadValue(Field, Object, EntityManager)"
  })
  public void testGetModifiedReadValue_givenFieldModifierManager_whenValue_thenReturnValue()
      throws IllegalAccessException {
    // Arrange, Act and Assert
    assertEquals("Value", new FieldModifierManager().getModifiedReadValue(null, "Value", null));
  }
}
