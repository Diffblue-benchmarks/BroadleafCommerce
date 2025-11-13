package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafEnumerationUtility.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafEnumerationUtilityDiffblueTest {
  @Autowired private BroadleafEnumerationUtility broadleafEnumerationUtility;

  /**
   * Test {@link BroadleafEnumerationUtility#getEnumerationValues(String, DynamicEntityDao)}.
   *
   * <ul>
   *   <li>When {@code Broadleaf Enumeration Class}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafEnumerationUtility#getEnumerationValues(String,
   * DynamicEntityDao)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BroadleafEnumerationUtility.getEnumerationValues(String, DynamicEntityDao)"
  })
  public void testGetEnumerationValues_whenBroadleafEnumerationClass() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            broadleafEnumerationUtility.getEnumerationValues(
                "Broadleaf Enumeration Class", new DynamicEntityDaoImpl()));
  }

  /**
   * Test {@link BroadleafEnumerationUtility#getEnumerationValues(String, DynamicEntityDao)}.
   *
   * <ul>
   *   <li>When {@code java.lang.Comparable}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafEnumerationUtility#getEnumerationValues(String,
   * DynamicEntityDao)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BroadleafEnumerationUtility.getEnumerationValues(String, DynamicEntityDao)"
  })
  public void testGetEnumerationValues_whenJavaLangComparable() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            broadleafEnumerationUtility.getEnumerationValues(
                "java.lang.Comparable", new DynamicEntityDaoImpl()));
  }

  /**
   * Test {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection BroadleafEnumerationUtility.getSortedEnumValues(Map)"})
  public void testGetSortedEnumValues_given42_whenHashMap42Is42_thenReturnSizeIsOne() {
    // Arrange
    HashMap<Object, Object> typesMap = new HashMap<>();
    typesMap.put("42", "42");

    // Act
    Collection<Object> actualSortedEnumValues =
        broadleafEnumerationUtility.getSortedEnumValues(typesMap);

    // Assert
    assertTrue(actualSortedEnumValues instanceof List);
    assertEquals(1, actualSortedEnumValues.size());
    assertEquals("42", ((List<Object>) actualSortedEnumValues).get(0));
  }

  /**
   * Test {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection BroadleafEnumerationUtility.getSortedEnumValues(Map)"})
  public void testGetSortedEnumValues_whenHashMap_thenReturnEmpty() {
    // Arrange and Act
    Collection<Object> actualSortedEnumValues =
        broadleafEnumerationUtility.getSortedEnumValues(new HashMap<>());

    // Assert
    assertTrue(actualSortedEnumValues instanceof List);
    assertTrue(actualSortedEnumValues.isEmpty());
  }
}
