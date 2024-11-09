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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.util.TableCreator.Col;
import org.junit.Test;

public class TableCreatorDiffblueTest {
  /**
   * Test Col {@link Col#Col(String, int)}.
   * <p>
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
   * Test Col {@link Col#Col(String)}.
   * <p>
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
   * Test {@link TableCreator#TableCreator(Col[])}.
   * <p>
   * Method under test: {@link TableCreator#TableCreator(TableCreator.Col[])}
   */
  @Test
  public void testNewTableCreator() {
    // Arrange
    TableCreator.Col col = new TableCreator.Col("", 1);

    // Act
    TableCreator actualTableCreator = new TableCreator(new TableCreator.Col[]{col});

    // Assert
    assertEquals("\r\n-----\r\n|   |\r\n-----\r\n", actualTableCreator.sb.toString());
    TableCreator.Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    assertEquals(5, actualTableCreator.rowWidth);
    assertSame(col, colArray[0]);
  }

  /**
   * Test {@link TableCreator#TableCreator(Col[])}.
   * <p>
   * Method under test: {@link TableCreator#TableCreator(TableCreator.Col[])}
   */
  @Test
  public void testNewTableCreator2() {
    // Arrange
    TableCreator.Col col = new TableCreator.Col("Dr", -1);

    // Act
    TableCreator actualTableCreator = new TableCreator(new TableCreator.Col[]{col});

    // Assert
    assertEquals("\r\n---\r\n|  |\r\n---\r\n", actualTableCreator.sb.toString());
    TableCreator.Col[] colArray = actualTableCreator.cols;
    TableCreator.Col col2 = colArray[0];
    assertEquals(-1, col2.width);
    assertEquals(1, colArray.length);
    assertEquals(3, actualTableCreator.rowWidth);
    assertSame(col, col2);
  }

  /**
   * Test {@link TableCreator#TableCreator(Col[])}.
   * <ul>
   *   <li>Then return {@link TableCreator#sb} toString is
   * {@code ----- | D | -----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#TableCreator(TableCreator.Col[])}
   */
  @Test
  public void testNewTableCreator_thenReturnSbToStringIsD() {
    // Arrange
    TableCreator.Col col = new TableCreator.Col("Dr", 1);

    // Act
    TableCreator actualTableCreator = new TableCreator(new TableCreator.Col[]{col});

    // Assert
    assertEquals("\r\n-----\r\n| D |\r\n-----\r\n", actualTableCreator.sb.toString());
    TableCreator.Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    TableCreator.Col col2 = colArray[0];
    assertEquals(1, col2.width);
    assertEquals(5, actualTableCreator.rowWidth);
    assertSame(col, col2);
  }

  /**
   * Test {@link TableCreator#TableCreator(Col[])}.
   * <ul>
   *   <li>Then return {@link TableCreator#sb} toString is {@code | |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#TableCreator(TableCreator.Col[])}
   */
  @Test
  public void testNewTableCreator_thenReturnSbToStringIsVerticalLineSpaceVerticalLine() {
    // Arrange
    TableCreator.Col col = new TableCreator.Col("Dr", Integer.MIN_VALUE);

    // Act
    TableCreator actualTableCreator = new TableCreator(new TableCreator.Col[]{col});

    // Assert
    assertEquals("\r\n\r\n|  |\r\n\r\n", actualTableCreator.sb.toString());
    assertEquals(-2147483644, actualTableCreator.rowWidth);
    TableCreator.Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    TableCreator.Col col2 = colArray[0];
    assertEquals(Integer.MIN_VALUE, col2.width);
    assertSame(col, col2);
  }

  /**
   * Test {@link TableCreator#TableCreator(Col[])}.
   * <ul>
   *   <li>When array of {@link Col} with {@link Col#Col(String)} with title is
   * {@code Dr}.</li>
   *   <li>Then return {@link TableCreator#sb} toString is
   * {@code ------ | Dr | ------}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#TableCreator(TableCreator.Col[])}
   */
  @Test
  public void testNewTableCreator_whenArrayOfColWithColWithTitleIsDr_thenReturnSbToStringIsDr() {
    // Arrange
    TableCreator.Col col = new TableCreator.Col("Dr");

    // Act
    TableCreator actualTableCreator = new TableCreator(new TableCreator.Col[]{col});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n", actualTableCreator.sb.toString());
    TableCreator.Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    TableCreator.Col col2 = colArray[0];
    assertEquals(2, col2.width);
    assertEquals(6, actualTableCreator.rowWidth);
    assertSame(col, col2);
  }

  /**
   * Test {@link TableCreator#calculateRowWidth()}.
   * <p>
   * Method under test: {@link TableCreator#calculateRowWidth()}
   */
  @Test
  public void testCalculateRowWidth() {
    // Arrange, Act and Assert
    assertEquals(6, (new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")})).calculateRowWidth());
  }

  /**
   * Test {@link TableCreator#addSeparator()}.
   * <p>
   * Method under test: {@link TableCreator#addSeparator()}
   */
  @Test
  public void testAddSeparator() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr", Integer.MIN_VALUE)});

    // Act
    TableCreator actualAddSeparatorResult = tableCreator.addSeparator();

    // Assert
    assertEquals("\r\n\r\n|  |\r\n\r\n\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddSeparatorResult);
  }

  /**
   * Test {@link TableCreator#addSeparator()}.
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of
   * {@link Col} with {@link Col#Col(String)} {@link TableCreator#sb} toString is
   * {@code ------ | Dr | ------ ------}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addSeparator()}
   */
  @Test
  public void testAddSeparator_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDr() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Act
    TableCreator actualAddSeparatorResult = tableCreator.addSeparator();

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n------\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddSeparatorResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   * <p>
   * Method under test: {@link TableCreator#addRow(TableCreator.Col[])}
   */
  @Test
  public void testAddRowWithCols() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Assert
    assertEquals("\r\n----\r\n|  |\r\n----\r\n|  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   * <p>
   * Method under test: {@link TableCreator#addRow(TableCreator.Col[])}
   */
  @Test
  public void testAddRowWithCols2() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr", -1)});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Assert
    assertEquals("\r\n---\r\n|  |\r\n---\r\n|  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of
   * {@link Col} with {@link Col#Col(String)} {@link TableCreator#sb} toString is
   * {@code ------ | Dr | ------ | Dr |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(TableCreator.Col[])}
   */
  @Test
  public void testAddRowWithCols_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDrDr() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n| Dr |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of
   * {@link Col} with {@link Col#Col(String)} {@link TableCreator#sb} toString is
   * {@code -------- | Prof | -------- | Dr |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(TableCreator.Col[])}
   */
  @Test
  public void testAddRowWithCols_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsProfDr() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Prof")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Assert
    assertEquals("\r\n--------\r\n| Prof |\r\n--------\r\n| Dr   |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(TableCreator.Col[])}
   */
  @Test
  public void testAddRowWithCols_thenThrowIllegalArgumentException() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{});

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> tableCreator.addRow(new TableCreator.Col[]{new TableCreator.Col("Dr")}));
  }

  /**
   * Test {@link TableCreator#addRow(Object[])} with {@code data}.
   * <p>
   * Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  public void testAddRowWithData() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr", -1)});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Object[]{BLCFieldUtils.NULL_FIELD});

    // Assert
    assertEquals("\r\n---\r\n|  |\r\n---\r\n|  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Object[])} with {@code data}.
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of
   * {@link Col} with {@link Col#Col(String)} {@link TableCreator#sb} toString is
   * {@code ------ | Dr | ------ | 2 |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  public void testAddRowWithData_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDr2() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Object[]{2});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n| 2  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Object[])} with {@code data}.
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of
   * {@link Col} with {@link Col#Col(String)} {@link TableCreator#sb} toString is
   * {@code ------ | Dr | ------ | ja |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  public void testAddRowWithData_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDrJa() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Object[]{BLCFieldUtils.NULL_FIELD});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n| ja |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Object[])} with {@code data}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  public void testAddRowWithData_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TableCreator(new TableCreator.Col[]{})).addRow(new Object[]{BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Test {@link TableCreator#addRow(String, Object)} with {@code rowHeader},
   * {@code rowData}.
   * <p>
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  public void testAddRowWithRowHeaderRowData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});
    tableCreator.withGlobalRowHeaderWidth(0);

    // Act and Assert
    assertSame(tableCreator, tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link TableCreator#addRow(String, Object)} with {@code rowHeader},
   * {@code rowData}.
   * <p>
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  public void testAddRowWithRowHeaderRowData2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});
    tableCreator.withGlobalRowHeaderWidth(-1);

    // Act and Assert
    assertSame(tableCreator, tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link TableCreator#addRow(String, Object)} with {@code rowHeader},
   * {@code rowData}.
   * <ul>
   *   <li>Given {@link TableCreator#TableCreator(Col[])} with cols is array of
   * {@link Col} with {@link Col#Col(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  public void testAddRowWithRowHeaderRowData_givenTableCreatorWithColsIsArrayOfColWithCol() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});

    // Act and Assert
    assertSame(tableCreator, tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link TableCreator#addRow(String, Object)} with {@code rowHeader},
   * {@code rowData}.
   * <ul>
   *   <li>Then return {@link TableCreator#TableCreator(Col[])} with cols is array
   * of {@link Col} with {@link Col}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  public void testAddRowWithRowHeaderRowData_thenReturnTableCreatorWithColsIsArrayOfColWithCol() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{mock(TableCreator.Col.class)});

    // Act and Assert
    assertSame(tableCreator, tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link TableCreator#addRow(String, Object)} with {@code rowHeader},
   * {@code rowData}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  public void testAddRowWithRowHeaderRowData_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TableCreator tableCreator = new TableCreator(new TableCreator.Col[]{new TableCreator.Col("Dr")});
    tableCreator.withGlobalRowHeaderWidth(0);

    // Act and Assert
    assertSame(tableCreator, tableCreator.addRow(null, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test getters and setters.
   * <p>
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
}
