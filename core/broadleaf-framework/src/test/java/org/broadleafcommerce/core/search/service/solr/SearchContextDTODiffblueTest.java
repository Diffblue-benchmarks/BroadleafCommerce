package org.broadleafcommerce.core.search.service.solr;

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

@ContextConfiguration(classes = {SearchContextDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchContextDTODiffblueTest {
  @Autowired private SearchContextDTO searchContextDTO;

  /**
   * Test {@link SearchContextDTO#get(String)}.
   *
   * <p>Method under test: {@link SearchContextDTO#get(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SearchContextDTO.get(String)"})
  public void testGet() {
    // Arrange, Act and Assert
    assertNull(searchContextDTO.get("Key"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchContextDTO}
   *   <li>{@link SearchContextDTO#setAttributes(Map)}
   *   <li>{@link SearchContextDTO#getAttributes()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchContextDTO.<init>()",
    "Map SearchContextDTO.getAttributes()",
    "void SearchContextDTO.setAttributes(Map)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchContextDTO actualSearchContextDTO = new SearchContextDTO();
    HashMap<String, Object> attributes = new HashMap<>();
    actualSearchContextDTO.setAttributes(attributes);
    Map<String, Object> actualAttributes = actualSearchContextDTO.getAttributes();

    // Assert
    assertTrue(actualAttributes.isEmpty());
    assertSame(attributes, actualAttributes);
  }
}
