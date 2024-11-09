/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FieldPath.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class FieldPathDiffblueTest {
  @Autowired
  private FieldPath fieldPath;

  /**
   * Test {@link FieldPath#withAssociationPath(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldPath#withAssociationPath(List)}
   */
  @Test
  public void testWithAssociationPath_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> associationPath = new ArrayList<>();
    associationPath.add("42");
    associationPath.add("foo");

    // Act
    FieldPath actualWithAssociationPathResult = fieldPath.withAssociationPath(associationPath);

    // Assert
    assertSame(associationPath, fieldPath.getAssociationPath());
    assertSame(fieldPath, actualWithAssociationPathResult);
  }

  /**
   * Test {@link FieldPath#withAssociationPath(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldPath#withAssociationPath(List)}
   */
  @Test
  public void testWithAssociationPath_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ArrayList<String> associationPath = new ArrayList<>();
    associationPath.add("foo");

    // Act
    FieldPath actualWithAssociationPathResult = fieldPath.withAssociationPath(associationPath);

    // Assert
    assertSame(associationPath, fieldPath.getAssociationPath());
    assertSame(fieldPath, actualWithAssociationPathResult);
  }

  /**
   * Test {@link FieldPath#withAssociationPath(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldPath#withAssociationPath(List)}
   */
  @Test
  public void testWithAssociationPath_whenArrayList() {
    // Arrange
    ArrayList<String> associationPath = new ArrayList<>();

    // Act
    FieldPath actualWithAssociationPathResult = fieldPath.withAssociationPath(associationPath);

    // Assert
    assertSame(associationPath, fieldPath.getAssociationPath());
    assertSame(fieldPath, actualWithAssociationPathResult);
  }

  /**
   * Test {@link FieldPath#withTargetPropertyPieces(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldPath#withTargetPropertyPieces(List)}
   */
  @Test
  public void testWithTargetPropertyPieces_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> targetPropertyPieces = new ArrayList<>();
    targetPropertyPieces.add("42");
    targetPropertyPieces.add("foo");

    // Act
    FieldPath actualWithTargetPropertyPiecesResult = fieldPath.withTargetPropertyPieces(targetPropertyPieces);

    // Assert
    assertSame(targetPropertyPieces, fieldPath.getTargetPropertyPieces());
    assertSame(fieldPath, actualWithTargetPropertyPiecesResult);
  }

  /**
   * Test {@link FieldPath#withTargetPropertyPieces(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldPath#withTargetPropertyPieces(List)}
   */
  @Test
  public void testWithTargetPropertyPieces_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ArrayList<String> targetPropertyPieces = new ArrayList<>();
    targetPropertyPieces.add("foo");

    // Act
    FieldPath actualWithTargetPropertyPiecesResult = fieldPath.withTargetPropertyPieces(targetPropertyPieces);

    // Assert
    assertSame(targetPropertyPieces, fieldPath.getTargetPropertyPieces());
    assertSame(fieldPath, actualWithTargetPropertyPiecesResult);
  }

  /**
   * Test {@link FieldPath#withTargetPropertyPieces(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldPath#withTargetPropertyPieces(List)}
   */
  @Test
  public void testWithTargetPropertyPieces_whenArrayList() {
    // Arrange
    ArrayList<String> targetPropertyPieces = new ArrayList<>();

    // Act
    FieldPath actualWithTargetPropertyPiecesResult = fieldPath.withTargetPropertyPieces(targetPropertyPieces);

    // Assert
    assertSame(targetPropertyPieces, fieldPath.getTargetPropertyPieces());
    assertSame(fieldPath, actualWithTargetPropertyPiecesResult);
  }

  /**
   * Test {@link FieldPath#withTargetProperty(String)}.
   * <p>
   * Method under test: {@link FieldPath#withTargetProperty(String)}
   */
  @Test
  public void testWithTargetProperty() {
    // Arrange and Act
    FieldPath actualWithTargetPropertyResult = fieldPath.withTargetProperty("Target Property");

    // Assert
    assertEquals("Target Property", fieldPath.getTargetProperty());
    assertSame(fieldPath, actualWithTargetPropertyResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldPath}
   *   <li>{@link FieldPath#setAssociationPath(List)}
   *   <li>{@link FieldPath#setTargetProperty(String)}
   *   <li>{@link FieldPath#setTargetPropertyPieces(List)}
   *   <li>{@link FieldPath#getAssociationPath()}
   *   <li>{@link FieldPath#getTargetProperty()}
   *   <li>{@link FieldPath#getTargetPropertyPieces()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldPath actualFieldPath = new FieldPath();
    ArrayList<String> associationPath = new ArrayList<>();
    actualFieldPath.setAssociationPath(associationPath);
    actualFieldPath.setTargetProperty("Target Property");
    ArrayList<String> targetPropertyPieces = new ArrayList<>();
    actualFieldPath.setTargetPropertyPieces(targetPropertyPieces);
    List<String> actualAssociationPath = actualFieldPath.getAssociationPath();
    String actualTargetProperty = actualFieldPath.getTargetProperty();
    List<String> actualTargetPropertyPieces = actualFieldPath.getTargetPropertyPieces();

    // Assert that nothing has changed
    assertEquals("Target Property", actualTargetProperty);
    assertTrue(actualAssociationPath.isEmpty());
    assertTrue(actualTargetPropertyPieces.isEmpty());
    assertSame(associationPath, actualAssociationPath);
    assertSame(targetPropertyPieces, actualTargetPropertyPieces);
  }
}
