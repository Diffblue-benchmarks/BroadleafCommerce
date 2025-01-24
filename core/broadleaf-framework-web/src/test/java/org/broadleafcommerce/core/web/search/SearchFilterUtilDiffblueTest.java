package org.broadleafcommerce.core.web.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SearchFilterUtilDiffblueTest {
  /**
   * Test {@link SearchFilterUtil#filterProducts(List, Map, String[])}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFilterUtil#filterProducts(List, Map, String[])}
   */
  @Test
  @DisplayName("Test filterProducts(List, Map, String[]); when ArrayList()")
  void testFilterProducts_whenArrayList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ArrayList<Product> products = new ArrayList<>();

    // Act
    SearchFilterUtil.filterProducts(products, new HashMap<>(), new String[]{"Allowed Parameters"});
  }

  /**
   * Test {@link SearchFilterUtil#filterProducts(List, Map, String[])}.
   * <ul>
   *   <li>When array of {@link String} with empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchFilterUtil#filterProducts(List, Map, String[])}
   */
  @Test
  @DisplayName("Test filterProducts(List, Map, String[]); when array of String with empty string")
  @Disabled("TODO: Complete this test")
  void testFilterProducts_whenArrayOfStringWithEmptyString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: propertyName cannot be null or empty
    //       at org.apache.commons.beanutils.BeanToPropertyValueTransformer.<init>(BeanToPropertyValueTransformer.java:127)
    //       at org.broadleafcommerce.core.web.search.SearchFilterUtil.filterProducts(SearchFilterUtil.java:49)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    ArrayList<Product> products = new ArrayList<>();

    // Act
    SearchFilterUtil.filterProducts(products, new HashMap<>(), new String[]{""});
  }
}
