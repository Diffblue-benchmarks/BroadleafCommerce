/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {SearchContextDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchContextDTODiffblueTest {
  @Autowired
  private SearchContextDTO searchContextDTO;

  /**
   * Test {@link SearchContextDTO#get(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchContextDTO#get(String)}
   */
  @Test
  public void testGet_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    attributes.computeIfPresent("foo", mock(BiFunction.class));

    SearchContextDTO searchContextDTO2 = new SearchContextDTO();
    searchContextDTO2.setAttributes(attributes);

    // Act and Assert
    assertNull(searchContextDTO2.get("Key"));
  }

  /**
   * Test {@link SearchContextDTO#get(String)}.
   * <ul>
   *   <li>Given {@link SearchContextDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchContextDTO#get(String)}
   */
  @Test
  public void testGet_givenSearchContextDTO() {
    // Arrange, Act and Assert
    assertNull((new SearchContextDTO()).get("Key"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchContextDTO}
   *   <li>{@link SearchContextDTO#setAttributes(Map)}
   *   <li>{@link SearchContextDTO#getAttributes()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchContextDTO actualSearchContextDTO = new SearchContextDTO();
    HashMap<String, Object> attributes = new HashMap<>();
    actualSearchContextDTO.setAttributes(attributes);
    Map<String, Object> actualAttributes = actualSearchContextDTO.getAttributes();

    // Assert that nothing has changed
    assertTrue(actualAttributes.isEmpty());
    assertSame(attributes, actualAttributes);
  }
}
