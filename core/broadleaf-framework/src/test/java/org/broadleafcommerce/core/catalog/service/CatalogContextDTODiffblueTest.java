package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CatalogContextDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CatalogContextDTODiffblueTest {
  @Autowired private CatalogContextDTO catalogContextDTO;

  /**
   * Test {@link CatalogContextDTO#get(String)}.
   *
   * <p>Method under test: {@link CatalogContextDTO#get(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CatalogContextDTO.get(String)"})
  public void testGet() {
    // Arrange, Act and Assert
    assertNull(catalogContextDTO.get("Key"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CatalogContextDTO}
   *   <li>{@link CatalogContextDTO#setAttributes(Map)}
   *   <li>{@link CatalogContextDTO#getAttributes()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogContextDTO.<init>()",
    "Map CatalogContextDTO.getAttributes()",
    "void CatalogContextDTO.setAttributes(Map)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CatalogContextDTO actualCatalogContextDTO = new CatalogContextDTO();
    HashMap<String, Object> attributes = new HashMap<>();
    actualCatalogContextDTO.setAttributes(attributes);
    Map<String, Object> actualAttributes = actualCatalogContextDTO.getAttributes();

    // Assert
    assertTrue(actualAttributes.isEmpty());
    assertSame(attributes, actualAttributes);
  }
}
