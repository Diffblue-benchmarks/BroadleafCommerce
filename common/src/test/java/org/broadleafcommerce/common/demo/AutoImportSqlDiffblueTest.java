package org.broadleafcommerce.common.demo;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AutoImportSqlDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AutoImportSql#AutoImportSql()}
   *   <li>{@link AutoImportSql#setOrder(int)}
   *   <li>{@link AutoImportSql#setPersistenceUnit(String)}
   *   <li>{@link AutoImportSql#setSqlFilePath(String)}
   *   <li>{@link AutoImportSql#getOrder()}
   *   <li>{@link AutoImportSql#getPersistenceUnit()}
   *   <li>{@link AutoImportSql#getSqlFilePath()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AutoImportSql.<init>()",
    "void AutoImportSql.<init>(String, String, int)",
    "int AutoImportSql.getOrder()",
    "String AutoImportSql.getPersistenceUnit()",
    "String AutoImportSql.getSqlFilePath()",
    "void AutoImportSql.setOrder(int)",
    "void AutoImportSql.setPersistenceUnit(String)",
    "void AutoImportSql.setSqlFilePath(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AutoImportSql actualAutoImportSql = new AutoImportSql();
    actualAutoImportSql.setOrder(1);
    actualAutoImportSql.setPersistenceUnit("Persistence Unit");
    actualAutoImportSql.setSqlFilePath("/directory/foo.txt");
    int actualOrder = actualAutoImportSql.getOrder();
    String actualPersistenceUnit = actualAutoImportSql.getPersistenceUnit();

    // Assert
    assertEquals("/directory/foo.txt", actualAutoImportSql.getSqlFilePath());
    assertEquals("Persistence Unit", actualPersistenceUnit);
    assertEquals(1, actualOrder);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Persistence Unit}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AutoImportSql#AutoImportSql(String, String, int)}
   *   <li>{@link AutoImportSql#setOrder(int)}
   *   <li>{@link AutoImportSql#setPersistenceUnit(String)}
   *   <li>{@link AutoImportSql#setSqlFilePath(String)}
   *   <li>{@link AutoImportSql#getOrder()}
   *   <li>{@link AutoImportSql#getPersistenceUnit()}
   *   <li>{@link AutoImportSql#getSqlFilePath()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AutoImportSql.<init>()",
    "void AutoImportSql.<init>(String, String, int)",
    "int AutoImportSql.getOrder()",
    "String AutoImportSql.getPersistenceUnit()",
    "String AutoImportSql.getSqlFilePath()",
    "void AutoImportSql.setOrder(int)",
    "void AutoImportSql.setPersistenceUnit(String)",
    "void AutoImportSql.setSqlFilePath(String)"
  })
  public void testGettersAndSetters_whenPersistenceUnit() {
    // Arrange and Act
    AutoImportSql actualAutoImportSql =
        new AutoImportSql("Persistence Unit", "/directory/foo.txt", 1);
    actualAutoImportSql.setOrder(1);
    actualAutoImportSql.setPersistenceUnit("Persistence Unit");
    actualAutoImportSql.setSqlFilePath("/directory/foo.txt");
    int actualOrder = actualAutoImportSql.getOrder();
    String actualPersistenceUnit = actualAutoImportSql.getPersistenceUnit();

    // Assert
    assertEquals("/directory/foo.txt", actualAutoImportSql.getSqlFilePath());
    assertEquals("Persistence Unit", actualPersistenceUnit);
    assertEquals(1, actualOrder);
  }
}
