package org.broadleafcommerce.core.catalog.service;

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
@ContextConfiguration(classes = {CatalogContextDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CatalogContextDTODiffblueTest {
  @Autowired
  private CatalogContextDTO catalogContextDTO;

  /**
   * Test {@link CatalogContextDTO#get(String)}.
   * <ul>
   *   <li>Given {@link CatalogContextDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogContextDTO#get(String)}
   */
  @Test
  public void testGet_givenCatalogContextDTO() {
    // Arrange, Act and Assert
    assertNull((new CatalogContextDTO()).get("Key"));
  }

  /**
   * Test {@link CatalogContextDTO#get(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogContextDTO#get(String)}
   */
  @Test
  public void testGet_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    attributes.computeIfPresent("foo", mock(BiFunction.class));

    CatalogContextDTO catalogContextDTO2 = new CatalogContextDTO();
    catalogContextDTO2.setAttributes(attributes);

    // Act and Assert
    assertNull(catalogContextDTO2.get("Key"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CatalogContextDTO}
   *   <li>{@link CatalogContextDTO#setAttributes(Map)}
   *   <li>{@link CatalogContextDTO#getAttributes()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CatalogContextDTO actualCatalogContextDTO = new CatalogContextDTO();
    HashMap<String, Object> attributes = new HashMap<>();
    actualCatalogContextDTO.setAttributes(attributes);
    Map<String, Object> actualAttributes = actualCatalogContextDTO.getAttributes();

    // Assert that nothing has changed
    assertTrue(actualAttributes.isEmpty());
    assertSame(attributes, actualAttributes);
  }
}
