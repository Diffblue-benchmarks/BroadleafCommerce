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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.TableCreator.Col;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TableCreatorDiffblueTest {
  /**
   * Test Col {@link Col#Col(String, int)}.
   * <p>
   * Method under test: {@link Col#Col(String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Col.<init>(String, int)"})
  public void testColNewCol() {
    // Arrange and Act
    Col actualCol = new Col("Dr", 1);

    // Assert
    assertEquals("Dr", actualCol.title);
    assertEquals(1, actualCol.width);
  }

  /**
   * Test Col {@link Col#Col(String)}.
   * <ul>
   *   <li>Then return {@link Col#title} is {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Col#Col(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Col.<init>(String)"})
  public void testColNewCol_thenReturnTitleIsDr() {
    // Arrange and Act
    Col actualCol = new Col("Dr");

    // Assert
    assertEquals("Dr", actualCol.title);
    assertEquals(2, actualCol.width);
  }

  /**
   * Test {@link TableCreator#TableCreator(Col[])}.
   * <p>
   * Method under test: {@link TableCreator#TableCreator(Col[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TableCreator.<init>(Col[])"})
  public void testNewTableCreator() {
    // Arrange
    Col col = new Col("", 1);

    // Act
    TableCreator actualTableCreator = new TableCreator(new Col[]{col});

    // Assert
    assertEquals("\r\n-----\r\n|   |\r\n-----\r\n", actualTableCreator.sb.toString());
    Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    assertEquals(5, actualTableCreator.rowWidth);
    assertSame(col, colArray[0]);
  }

  /**
   * Test {@link TableCreator#TableCreator(Col[])}.
   * <p>
   * Method under test: {@link TableCreator#TableCreator(Col[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TableCreator.<init>(Col[])"})
  public void testNewTableCreator2() {
    // Arrange
    Col col = new Col("Dr", -1);

    // Act
    TableCreator actualTableCreator = new TableCreator(new Col[]{col});

    // Assert
    assertEquals("\r\n---\r\n|  |\r\n---\r\n", actualTableCreator.sb.toString());
    Col[] colArray = actualTableCreator.cols;
    Col col2 = colArray[0];
    assertEquals(-1, col2.width);
    assertEquals(1, colArray.length);
    assertEquals(3, actualTableCreator.rowWidth);
    assertSame(col, col2);
  }

  /**
   * Test {@link TableCreator#TableCreator(Col[])}.
   * <ul>
   *   <li>Then return {@link TableCreator#sb} toString is {@code ----- | D | -----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#TableCreator(Col[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TableCreator.<init>(Col[])"})
  public void testNewTableCreator_thenReturnSbToStringIsD() {
    // Arrange
    Col col = new Col("Dr", 1);

    // Act
    TableCreator actualTableCreator = new TableCreator(new Col[]{col});

    // Assert
    assertEquals("\r\n-----\r\n| D |\r\n-----\r\n", actualTableCreator.sb.toString());
    Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    Col col2 = colArray[0];
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
   * Method under test: {@link TableCreator#TableCreator(Col[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TableCreator.<init>(Col[])"})
  public void testNewTableCreator_thenReturnSbToStringIsVerticalLineSpaceVerticalLine() {
    // Arrange
    Col col = new Col("Dr", Integer.MIN_VALUE);

    // Act
    TableCreator actualTableCreator = new TableCreator(new Col[]{col});

    // Assert
    assertEquals("\r\n\r\n|  |\r\n\r\n", actualTableCreator.sb.toString());
    assertEquals(-2147483644, actualTableCreator.rowWidth);
    Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    Col col2 = colArray[0];
    assertEquals(Integer.MIN_VALUE, col2.width);
    assertSame(col, col2);
  }

  /**
   * Test {@link TableCreator#TableCreator(Col[])}.
   * <ul>
   *   <li>When array of {@link Col} with {@link Col#Col(String)} with title is {@code Dr}.</li>
   *   <li>Then return {@link TableCreator#sb} toString is {@code ------ | Dr | ------}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#TableCreator(Col[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TableCreator.<init>(Col[])"})
  public void testNewTableCreator_whenArrayOfColWithColWithTitleIsDr_thenReturnSbToStringIsDr() {
    // Arrange
    Col col = new Col("Dr");

    // Act
    TableCreator actualTableCreator = new TableCreator(new Col[]{col});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n", actualTableCreator.sb.toString());
    Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    Col col2 = colArray[0];
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TableCreator.calculateRowWidth()"})
  public void testCalculateRowWidth() {
    // Arrange, Act and Assert
    assertEquals(6, (new TableCreator(new Col[]{new Col("Dr")})).calculateRowWidth());
  }

  /**
   * Test {@link TableCreator#addSeparator()}.
   * <p>
   * Method under test: {@link TableCreator#addSeparator()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addSeparator()"})
  public void testAddSeparator() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("Dr", Integer.MIN_VALUE)});

    // Act
    TableCreator actualAddSeparatorResult = tableCreator.addSeparator();

    // Assert
    assertEquals("\r\n\r\n|  |\r\n\r\n\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddSeparatorResult);
  }

  /**
   * Test {@link TableCreator#addSeparator()}.
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of {@link Col} with {@link Col#Col(String)} {@link TableCreator#sb} toString is {@code ------ | Dr | ------ ------}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addSeparator()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addSeparator()"})
  public void testAddSeparator_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDr() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("Dr")});

    // Act
    TableCreator actualAddSeparatorResult = tableCreator.addSeparator();

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n------\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddSeparatorResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   * <p>
   * Method under test: {@link TableCreator#addRow(Col[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Col[])"})
  public void testAddRowWithCols() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Col[]{new Col("Dr")});

    // Assert
    assertEquals("\r\n----\r\n|  |\r\n----\r\n|  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   * <p>
   * Method under test: {@link TableCreator#addRow(Col[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Col[])"})
  public void testAddRowWithCols2() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("Dr", -1)});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Col[]{new Col("Dr")});

    // Assert
    assertEquals("\r\n---\r\n|  |\r\n---\r\n|  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of {@link Col} with {@link Col#Col(String)} {@link TableCreator#sb} toString is {@code ------ | Dr | ------ | Dr |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(Col[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Col[])"})
  public void testAddRowWithCols_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDrDr() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("Dr")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Col[]{new Col("Dr")});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n| Dr |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of {@link Col} with {@link Col#Col(String)} {@link TableCreator#sb} toString is {@code -------- | Prof | -------- | Dr |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(Col[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Col[])"})
  public void testAddRowWithCols_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsProfDr() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("Prof")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Col[]{new Col("Dr")});

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
   * Method under test: {@link TableCreator#addRow(Col[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Col[])"})
  public void testAddRowWithCols_thenThrowIllegalArgumentException() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tableCreator.addRow(new Col[]{new Col("Dr")}));
  }

  /**
   * Test {@link TableCreator#addRow(Object[])} with {@code data}.
   * <p>
   * Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Object[])"})
  public void testAddRowWithData() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("Dr", -1)});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Object[]{BLCFieldUtils.NULL_FIELD});

    // Assert
    assertEquals("\r\n---\r\n|  |\r\n---\r\n|  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Object[])} with {@code data}.
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of {@link Col} with {@link Col#Col(String)} {@link TableCreator#sb} toString is {@code ------ | Dr | ------ | 2 |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Object[])"})
  public void testAddRowWithData_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDr2() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("Dr")});

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Object[]{2});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n| 2  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Object[])} with {@code data}.
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of {@link Col} with {@link Col#Col(String)} {@link TableCreator#sb} toString is {@code ------ | Dr | ------ | ja |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Object[])"})
  public void testAddRowWithData_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDrJa() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("Dr")});

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Object[])"})
  public void testAddRowWithData_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TableCreator(new Col[]{})).addRow(new Object[]{BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Test {@link TableCreator#addRow(String, Object)} with {@code rowHeader}, {@code rowData}.
   * <p>
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addRow(String, Object)"})
  public void testAddRowWithRowHeaderRowData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("Dr")});
    tableCreator.withGlobalRowHeaderWidth(0);

    // Act and Assert
    assertSame(tableCreator, tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link TableCreator#addRow(String, Object)} with {@code rowHeader}, {@code rowData}.
   * <p>
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addRow(String, Object)"})
  public void testAddRowWithRowHeaderRowData2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("Dr")});
    tableCreator.withGlobalRowHeaderWidth(-1);

    // Act and Assert
    assertSame(tableCreator, tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link TableCreator#addRow(String, Object)} with {@code rowHeader}, {@code rowData}.
   * <ul>
   *   <li>Given {@link TableCreator#TableCreator(Col[])} with cols is array of {@link Col} with {@link Col#Col(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addRow(String, Object)"})
  public void testAddRowWithRowHeaderRowData_givenTableCreatorWithColsIsArrayOfColWithCol() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("Dr")});

    // Act and Assert
    assertSame(tableCreator, tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link TableCreator#addRow(String, Object)} with {@code rowHeader}, {@code rowData}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableCreator TableCreator.addRow(String, Object)"})
  public void testAddRowWithRowHeaderRowData_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("Dr")});
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TableCreator.toString()", "TableCreator TableCreator.withGlobalRowHeaderWidth(int)"})
  public void testGettersAndSetters() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[]{new Col("Dr")});

    // Act
    TableCreator actualWithGlobalRowHeaderWidthResult = tableCreator.withGlobalRowHeaderWidth(1);

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n", tableCreator.toString());
    assertSame(tableCreator, actualWithGlobalRowHeaderWidthResult);
  }
}
