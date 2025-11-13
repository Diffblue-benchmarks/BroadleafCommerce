package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PageCartRuleProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PageCartRuleProcessorDiffblueTest {
  @Autowired private PageCartRuleProcessor pageCartRuleProcessor;

  /**
   * Test {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageCartRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_givenArrayList_thenReturnTrue() {
    // Arrange
    PageDTO page = new PageDTO();
    page.setItemCriteriaDTOList(new ArrayList<>());

    HashMap<String, Object> valueMap = new HashMap<>();
    valueMap.put("customer", new CustomerImpl());

    // Act and Assert
    assertTrue(pageCartRuleProcessor.checkForMatch(page, valueMap));
  }

  /**
   * Test {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageCartRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_thenReturnFalse() {
    // Arrange
    ItemCriteriaDTO itemCriteriaDTO = new ItemCriteriaDTO();
    itemCriteriaDTO.setMatchRule("Match Rule");
    itemCriteriaDTO.setQty(1);

    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    itemCriteriaDTOList.add(itemCriteriaDTO);

    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getItemCriteriaDTOList()).thenReturn(itemCriteriaDTOList);

    // Act
    boolean actualCheckForMatchResult = pageCartRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getItemCriteriaDTOList();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)} with {@code PageDTO}, {@code
   * Map}.
   *
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageCartRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageCartRuleProcessor.checkForMatch(PageDTO, Map)"})
  public void testCheckForMatchWithPageDTOMap_whenPageDTO_thenReturnTrue() {
    // Arrange
    PageDTO page = new PageDTO();

    // Act and Assert
    assertTrue(pageCartRuleProcessor.checkForMatch(page, new HashMap<>()));
  }

  /**
   * Test new {@link PageCartRuleProcessor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PageCartRuleProcessor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageCartRuleProcessor.<init>()"})
  public void testNewPageCartRuleProcessor() {
    // Arrange and Act
    PageCartRuleProcessor actualPageCartRuleProcessor = new PageCartRuleProcessor();

    // Assert
    assertNull(actualPageCartRuleProcessor.getOrderDao());
    assertTrue(actualPageCartRuleProcessor.getContextClassNames().isEmpty());
  }
}
