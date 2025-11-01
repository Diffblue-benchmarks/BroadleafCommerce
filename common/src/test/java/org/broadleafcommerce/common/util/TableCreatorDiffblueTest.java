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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class TableCreatorDiffblueTest {
  /**
   * Method under test: {@link TableCreator#calculateRowWidth()}
   */
  @Test
  public void testCalculateRowWidth() {
    // Arrange, Act and Assert
    assertEquals(6, (new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")})).calculateRowWidth());
  }

  /**
   * Method under test: {@link TableCreator#addSeparator()}
   */
  @Test
  public void testAddSeparator() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Act
    TableCreator actualAddSeparatorResult = tableCreator.addSeparator();

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n------\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddSeparatorResult);
  }

  /**
   * Method under test: {@link TableCreator#addSeparator()}
   */
  @Test
  public void testAddSeparator2() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr", Integer.MIN_VALUE)});

    // Act
    TableCreator actualAddSeparatorResult = tableCreator.addSeparator();

    // Assert
    assertEquals("\r\n\r\n|  |\r\n\r\n\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddSeparatorResult);
  }

  /**
   * Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  public void testAddRow() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Object[]{BLCFieldUtils.NULL_FIELD});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n| ja |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  public void testAddRow2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TableCreator(new TableCreator.Col[]{})).addRow(new Object[]{BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  public void testAddRow3() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Object[]{2});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n| 2  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  public void testAddRow4() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr", -1)});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Object[]{BLCFieldUtils.NULL_FIELD});

    // Assert
    assertEquals("\r\n---\r\n|  |\r\n---\r\n|  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Method under test: {@link TableCreator#addRow(TableCreator.Col[])}
   */
  @Test
  public void testAddRow5() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n| Dr |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Method under test: {@link TableCreator#addRow(TableCreator.Col[])}
   */
  @Test
  public void testAddRow6() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Prof")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Assert
    assertEquals("\r\n--------\r\n| Prof |\r\n--------\r\n| Dr   |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Method under test: {@link TableCreator#addRow(TableCreator.Col[])}
   */
  @Test
  public void testAddRow7() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Assert
    assertEquals("\r\n----\r\n|  |\r\n----\r\n|  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Method under test: {@link TableCreator#addRow(TableCreator.Col[])}
   */
  @Test
  public void testAddRow8() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{});

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> tableCreator.addRow(new TableCreator.Col[]{new TableCreator.Col("Dr")}));
  }

  /**
   * Method under test: {@link TableCreator#addRow(TableCreator.Col[])}
   */
  @Test
  public void testAddRow9() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr", -1)});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Assert
    assertEquals("\r\n---\r\n|  |\r\n---\r\n|  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  public void testAddRow10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Act and Assert
    assertSame(tableCreator, tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  public void testAddRow11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});
    tableCreator.withGlobalRowHeaderWidth(0);

    // Act and Assert
    assertSame(tableCreator, tableCreator.addRow(null, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  public void testAddRow12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});
    tableCreator.withGlobalRowHeaderWidth(0);

    // Act and Assert
    assertSame(tableCreator, tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  public void testAddRow13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});
    tableCreator.withGlobalRowHeaderWidth(-1);

    // Act and Assert
    assertSame(tableCreator, tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  public void testAddRow14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{mock(TableCreator.Col.class)});

    // Act and Assert
    assertSame(tableCreator, tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test: {@link TableCreator.Col#Col(String, int)}
   */
  @Test
  public void testColNewCol() {
    // Arrange and Act
    TableCreator.Col actualCol = new TableCreator.Col("Dr", 1);

    // Assert
    assertEquals("Dr", actualCol.title);
    assertEquals(1, actualCol.width);
  }

  /**
   * Method under test: {@link TableCreator.Col#Col(String)}
   */
  @Test
  public void testColNewCol2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TableCreator.Col actualCol = new TableCreator.Col("Dr");

    // Assert
    assertEquals("Dr", actualCol.title);
    assertEquals(2, actualCol.width);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TableCreator#withGlobalRowHeaderWidth(int)}
   *   <li>{@link TableCreator#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Act
    TableCreator actualWithGlobalRowHeaderWidthResult = tableCreator.withGlobalRowHeaderWidth(1);

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n", tableCreator.toString());
    assertSame(tableCreator, actualWithGlobalRowHeaderWidthResult);
  }

  /**
   * Method under test: {@link TableCreator#TableCreator(TableCreator.Col[])}
   */
  @Test
  public void testNewTableCreator() {
    // Arrange
    TableCreator.Col col = new TableCreator.Col("Dr");

    // Act
    TableCreator actualTableCreator = new TableCreator(new TableCreator.Col[]{col});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n", actualTableCreator.sb.toString());
    TableCreator.Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    assertEquals(20, actualTableCreator.globalRowHeaderWidth);
    assertEquals(6, actualTableCreator.rowWidth);
    assertSame(col, colArray[0]);
  }

  /**
   * Method under test: {@link TableCreator#TableCreator(TableCreator.Col[])}
   */
  @Test
  public void testNewTableCreator2() {
    // Arrange
    TableCreator.Col col = new TableCreator.Col("Dr", 1);

    // Act
    TableCreator actualTableCreator = new TableCreator(new TableCreator.Col[]{col});

    // Assert
    assertEquals("\r\n-----\r\n| D |\r\n-----\r\n", actualTableCreator.sb.toString());
    TableCreator.Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    assertEquals(20, actualTableCreator.globalRowHeaderWidth);
    assertEquals(5, actualTableCreator.rowWidth);
    assertSame(col, colArray[0]);
  }

  /**
   * Method under test: {@link TableCreator#TableCreator(TableCreator.Col[])}
   */
  @Test
  public void testNewTableCreator3() {
    // Arrange
    TableCreator.Col col = new TableCreator.Col("", 1);

    // Act
    TableCreator actualTableCreator = new TableCreator(new TableCreator.Col[]{col});

    // Assert
    assertEquals("\r\n-----\r\n|   |\r\n-----\r\n", actualTableCreator.sb.toString());
    TableCreator.Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    assertEquals(20, actualTableCreator.globalRowHeaderWidth);
    assertEquals(5, actualTableCreator.rowWidth);
    assertSame(col, colArray[0]);
  }

  /**
   * Method under test: {@link TableCreator#TableCreator(TableCreator.Col[])}
   */
  @Test
  public void testNewTableCreator4() {
    // Arrange
    TableCreator.Col col = new TableCreator.Col("Dr", -1);

    // Act
    TableCreator actualTableCreator = new TableCreator(new TableCreator.Col[]{col});

    // Assert
    assertEquals("\r\n---\r\n|  |\r\n---\r\n", actualTableCreator.sb.toString());
    TableCreator.Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    assertEquals(20, actualTableCreator.globalRowHeaderWidth);
    assertEquals(3, actualTableCreator.rowWidth);
    assertSame(col, colArray[0]);
  }

  /**
   * Method under test: {@link TableCreator#TableCreator(TableCreator.Col[])}
   */
  @Test
  public void testNewTableCreator5() {
    // Arrange
    TableCreator.Col col = new TableCreator.Col("Dr", Integer.MIN_VALUE);

    // Act
    TableCreator actualTableCreator = new TableCreator(new TableCreator.Col[]{col});

    // Assert
    assertEquals("\r\n\r\n|  |\r\n\r\n", actualTableCreator.sb.toString());
    assertEquals(-2147483644, actualTableCreator.rowWidth);
    TableCreator.Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    assertEquals(20, actualTableCreator.globalRowHeaderWidth);
    assertSame(col, colArray[0]);
  }
}
