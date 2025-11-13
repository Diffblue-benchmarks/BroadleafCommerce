package org.broadleafcommerce.common.structure.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemCriteriaDTODiffblueTest {
  @Autowired private ItemCriteriaDTO itemCriteriaDTO;

  /**
   * Test {@link ItemCriteriaDTO#getClone()}.
   *
   * <p>Method under test: {@link ItemCriteriaDTO#getClone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemCriteriaDTO ItemCriteriaDTO.getClone()"})
  public void testGetClone() {
    // Arrange and Act
    ItemCriteriaDTO actualClone = itemCriteriaDTO.getClone();

    // Assert
    assertNull(actualClone.getQty());
    assertNull(actualClone.getMatchRule());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ItemCriteriaDTO}
   *   <li>{@link ItemCriteriaDTO#setMatchRule(String)}
   *   <li>{@link ItemCriteriaDTO#setQty(Integer)}
   *   <li>{@link ItemCriteriaDTO#getMatchRule()}
   *   <li>{@link ItemCriteriaDTO#getQty()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ItemCriteriaDTO.<init>()",
    "String ItemCriteriaDTO.getMatchRule()",
    "Integer ItemCriteriaDTO.getQty()",
    "void ItemCriteriaDTO.setMatchRule(String)",
    "void ItemCriteriaDTO.setQty(Integer)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ItemCriteriaDTO actualItemCriteriaDTO = new ItemCriteriaDTO();
    actualItemCriteriaDTO.setMatchRule("Match Rule");
    actualItemCriteriaDTO.setQty(1);
    String actualMatchRule = actualItemCriteriaDTO.getMatchRule();

    // Assert
    assertEquals("Match Rule", actualMatchRule);
    assertEquals(1, actualItemCriteriaDTO.getQty().intValue());
  }
}
