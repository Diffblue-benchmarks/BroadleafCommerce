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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.TableCreator.Col;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TableCreatorDiffblueTest {
  /**
   * Test Col {@link Col#Col(String, int)}.
   *
   * <p>Method under test: {@link Col#Col(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@link Col#title} is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link Col#Col(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link TableCreator#TableCreator(Col[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableCreator.<init>(Col[])"})
  public void testNewTableCreator() {
    // Arrange
    Col col = new Col("", 1);
    Col[] cols = new Col[] {col};

    // Act
    TableCreator actualTableCreator = new TableCreator(cols);

    // Assert
    assertEquals("\r\n-----\r\n|   |\r\n-----\r\n", actualTableCreator.sb.toString());
    Col[] colArray = actualTableCreator.cols;
    assertEquals(1, colArray.length);
    assertEquals(5, actualTableCreator.rowWidth);
    assertSame(col, colArray[0]);
  }

  /**
   * Test {@link TableCreator#TableCreator(Col[])}.
   *
   * <p>Method under test: {@link TableCreator#TableCreator(Col[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableCreator.<init>(Col[])"})
  public void testNewTableCreator2() {
    // Arrange
    Col col = new Col("Dr", -1);
    Col[] cols = new Col[] {col};

    // Act
    TableCreator actualTableCreator = new TableCreator(cols);

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
   *
   * <ul>
   *   <li>Then return {@link TableCreator#sb} toString is {@code ----- | D | -----}.
   * </ul>
   *
   * <p>Method under test: {@link TableCreator#TableCreator(Col[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableCreator.<init>(Col[])"})
  public void testNewTableCreator_thenReturnSbToStringIsD() {
    // Arrange
    Col col = new Col("Dr", 1);
    Col[] cols = new Col[] {col};

    // Act
    TableCreator actualTableCreator = new TableCreator(cols);

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
   *
   * <ul>
   *   <li>Then return {@link TableCreator#sb} toString is {@code | |}.
   * </ul>
   *
   * <p>Method under test: {@link TableCreator#TableCreator(Col[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableCreator.<init>(Col[])"})
  public void testNewTableCreator_thenReturnSbToStringIsVerticalLineSpaceVerticalLine() {
    // Arrange
    Col col = new Col("Dr", Integer.MIN_VALUE);
    Col[] cols = new Col[] {col};

    // Act
    TableCreator actualTableCreator = new TableCreator(cols);

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
   *
   * <ul>
   *   <li>When array of {@link Col} with {@link Col#Col(String)} with title is {@code Dr}.
   *   <li>Then return {@link TableCreator#sb} toString is {@code ------ | Dr | ------}.
   * </ul>
   *
   * <p>Method under test: {@link TableCreator#TableCreator(Col[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableCreator.<init>(Col[])"})
  public void testNewTableCreator_whenArrayOfColWithColWithTitleIsDr_thenReturnSbToStringIsDr() {
    // Arrange
    Col col = new Col("Dr");
    Col[] cols = new Col[] {col};

    // Act
    TableCreator actualTableCreator = new TableCreator(cols);

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
   *
   * <p>Method under test: {@link TableCreator#calculateRowWidth()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int TableCreator.calculateRowWidth()"})
  public void testCalculateRowWidth() {
    // Arrange
    Col[] cols = new Col[] {new Col("Dr")};
    TableCreator tableCreator = new TableCreator(cols);

    // Act and Assert
    assertEquals(6, tableCreator.calculateRowWidth());
  }

  /**
   * Test {@link TableCreator#addSeparator()}.
   *
   * <p>Method under test: {@link TableCreator#addSeparator()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addSeparator()"})
  public void testAddSeparator() {
    // Arrange
    Col[] cols = new Col[] {new Col("Dr", Integer.MIN_VALUE)};
    TableCreator tableCreator = new TableCreator(cols);

    // Act
    TableCreator actualAddSeparatorResult = tableCreator.addSeparator();

    // Assert
    assertEquals("\r\n\r\n|  |\r\n\r\n\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddSeparatorResult);
  }

  /**
   * Test {@link TableCreator#addSeparator()}.
   *
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of {@link Col} with
   *       {@link Col#Col(String)} {@link TableCreator#sb} toString is {@code ------ | Dr | ------
   *       ------}.
   * </ul>
   *
   * <p>Method under test: {@link TableCreator#addSeparator()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addSeparator()"})
  public void testAddSeparator_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDr() {
    // Arrange
    Col[] cols = new Col[] {new Col("Dr")};
    TableCreator tableCreator = new TableCreator(cols);

    // Act
    TableCreator actualAddSeparatorResult = tableCreator.addSeparator();

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n------\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddSeparatorResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   *
   * <p>Method under test: {@link TableCreator#addRow(Col[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Col[])"})
  public void testAddRowWithCols() {
    // Arrange
    Col[] cols = new Col[] {new Col("Dr", -1)};
    TableCreator tableCreator = new TableCreator(cols);

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Col[] {new Col("Dr")});

    // Assert
    assertEquals("\r\n---\r\n|  |\r\n---\r\n|  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   *
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of {@link Col} with
   *       {@link Col#Col(String, int)} {@link TableCreator#sb} toString is {@code ----- | D | -----
   *       | D |}.
   * </ul>
   *
   * <p>Method under test: {@link TableCreator#addRow(Col[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Col[])"})
  public void testAddRowWithCols_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDD() {
    // Arrange
    Col[] cols = new Col[] {new Col("Dr", 1)};
    TableCreator tableCreator = new TableCreator(cols);

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Col[] {new Col("Dr")});

    // Assert
    assertEquals("\r\n-----\r\n| D |\r\n-----\r\n| D |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   *
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of {@link Col} with
   *       {@link Col#Col(String)} {@link TableCreator#sb} toString is {@code ------ | Dr | ------ |
   *       |}.
   * </ul>
   *
   * <p>Method under test: {@link TableCreator#addRow(Col[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Col[])"})
  public void testAddRowWithCols_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDr() {
    // Arrange
    Col[] cols = new Col[] {new Col("Dr")};
    TableCreator tableCreator = new TableCreator(cols);

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Col[] {new Col("")});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n|    |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   *
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of {@link Col} with
   *       {@link Col#Col(String)} {@link TableCreator#sb} toString is {@code ------ | Dr | ------ |
   *       Dr |}.
   * </ul>
   *
   * <p>Method under test: {@link TableCreator#addRow(Col[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Col[])"})
  public void testAddRowWithCols_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDrDr() {
    // Arrange
    Col[] cols = new Col[] {new Col("Dr")};
    TableCreator tableCreator = new TableCreator(cols);

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Col[] {new Col("Dr")});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n| Dr |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Col[])} with {@code cols}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TableCreator#addRow(Col[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Col[])"})
  public void testAddRowWithCols_thenThrowIllegalArgumentException() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[] {});

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> tableCreator.addRow(new Col[] {new Col("Dr")}));
  }

  /**
   * Test {@link TableCreator#addRow(Object[])} with {@code data}.
   *
   * <p>Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Object[])"})
  public void testAddRowWithData() {
    // Arrange
    Col[] cols = new Col[] {new Col("Dr", -1)};
    TableCreator tableCreator = new TableCreator(cols);

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Object[] {BLCFieldUtils.NULL_FIELD});

    // Assert
    assertEquals("\r\n---\r\n|  |\r\n---\r\n|  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Object[])} with {@code data}.
   *
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of {@link Col} with
   *       {@link Col#Col(String)} {@link TableCreator#sb} toString is {@code ------ | Dr | ------ |
   *       2 |}.
   * </ul>
   *
   * <p>Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Object[])"})
  public void testAddRowWithData_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDr2() {
    // Arrange
    Col[] cols = new Col[] {new Col("Dr")};
    TableCreator tableCreator = new TableCreator(cols);

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Object[] {2});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n| 2  |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Object[])} with {@code data}.
   *
   * <ul>
   *   <li>Then {@link TableCreator#TableCreator(Col[])} with cols is array of {@link Col} with
   *       {@link Col#Col(String)} {@link TableCreator#sb} toString is {@code ------ | Dr | ------ |
   *       ja |}.
   * </ul>
   *
   * <p>Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Object[])"})
  public void testAddRowWithData_thenTableCreatorWithColsIsArrayOfColWithColSbToStringIsDrJa() {
    // Arrange
    Col[] cols = new Col[] {new Col("Dr")};
    TableCreator tableCreator = new TableCreator(cols);

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(new Object[] {BLCFieldUtils.NULL_FIELD});

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n| ja |\r\n", tableCreator.sb.toString());
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(Object[])} with {@code data}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TableCreator#addRow(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addRow(Object[])"})
  public void testAddRowWithData_thenThrowIllegalArgumentException() {
    // Arrange
    TableCreator tableCreator = new TableCreator(new Col[] {});

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tableCreator.addRow(new Object[] {BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Test {@link TableCreator#addRow(String, Object)} with {@code rowHeader}, {@code rowData}.
   *
   * <p>Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addRow(String, Object)"})
  public void testAddRowWithRowHeaderRowData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    Col[] cols = new Col[] {new Col("Dr")};

    TableCreator tableCreator = new TableCreator(cols);
    tableCreator.withGlobalRowHeaderWidth(0);

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD);

    // Assert
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(String, Object)} with {@code rowHeader}, {@code rowData}.
   *
   * <p>Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addRow(String, Object)"})
  public void testAddRowWithRowHeaderRowData2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    Col[] cols = new Col[] {new Col("Dr")};

    TableCreator tableCreator = new TableCreator(cols);
    tableCreator.withGlobalRowHeaderWidth(-1);

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD);

    // Assert
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(String, Object)} with {@code rowHeader}, {@code rowData}.
   *
   * <ul>
   *   <li>Given {@link TableCreator#TableCreator(Col[])} with cols is array of {@link Col} with
   *       {@link Col#Col(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addRow(String, Object)"})
  public void testAddRowWithRowHeaderRowData_givenTableCreatorWithColsIsArrayOfColWithCol() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    Col[] cols = new Col[] {new Col("Dr")};
    TableCreator tableCreator = new TableCreator(cols);

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow("Row Header", BLCFieldUtils.NULL_FIELD);

    // Assert
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test {@link TableCreator#addRow(String, Object)} with {@code rowHeader}, {@code rowData}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TableCreator#addRow(String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TableCreator TableCreator.addRow(String, Object)"})
  public void testAddRowWithRowHeaderRowData_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    Col[] cols = new Col[] {new Col("Dr")};

    TableCreator tableCreator = new TableCreator(cols);
    tableCreator.withGlobalRowHeaderWidth(0);

    // Act
    TableCreator actualAddRowResult = tableCreator.addRow(null, BLCFieldUtils.NULL_FIELD);

    // Assert
    assertSame(tableCreator, actualAddRowResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TableCreator#withGlobalRowHeaderWidth(int)}
   *   <li>{@link TableCreator#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TableCreator.toString()",
    "TableCreator TableCreator.withGlobalRowHeaderWidth(int)"
  })
  public void testGettersAndSetters() {
    // Arrange
    Col[] cols = new Col[] {new Col("Dr")};
    TableCreator tableCreator = new TableCreator(cols);

    // Act
    TableCreator actualWithGlobalRowHeaderWidthResult = tableCreator.withGlobalRowHeaderWidth(1);

    // Assert
    assertEquals("\r\n------\r\n| Dr |\r\n------\r\n", tableCreator.toString());
    assertSame(tableCreator, actualWithGlobalRowHeaderWidthResult);
  }
}
