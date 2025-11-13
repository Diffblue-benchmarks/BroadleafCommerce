package org.broadleafcommerce.common.page.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PageDTO.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PageDTODiffblueTest {
  @Autowired private PageDTO pageDTO;

  /**
   * Test {@link PageDTO#getPropertyValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PageDTO#getPropertyValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PageDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_when42() {
    // Arrange, Act and Assert
    assertNull(pageDTO.getPropertyValue("42"));
  }

  /**
   * Test {@link PageDTO#getPropertyValue(String)}.
   *
   * <ul>
   *   <li>When {@code Property Name}.
   * </ul>
   *
   * <p>Method under test: {@link PageDTO#getPropertyValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PageDTO.getPropertyValue(String)"})
  public void testGetPropertyValue_whenPropertyName() {
    // Arrange, Act and Assert
    assertNull(pageDTO.getPropertyValue("Property Name"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PageDTO}
   *   <li>{@link PageDTO#setDescription(String)}
   *   <li>{@link PageDTO#setForeignPageFields(Map)}
   *   <li>{@link PageDTO#setId(Long)}
   *   <li>{@link PageDTO#setItemCriteriaDTOList(List)}
   *   <li>{@link PageDTO#setLocaleCode(String)}
   *   <li>{@link PageDTO#setPageAttributes(Map)}
   *   <li>{@link PageDTO#setPageFields(Map)}
   *   <li>{@link PageDTO#setPriority(Integer)}
   *   <li>{@link PageDTO#setRuleExpression(String)}
   *   <li>{@link PageDTO#setTemplatePath(String)}
   *   <li>{@link PageDTO#setUrl(String)}
   *   <li>{@link PageDTO#getDescription()}
   *   <li>{@link PageDTO#getForeignPageFields()}
   *   <li>{@link PageDTO#getId()}
   *   <li>{@link PageDTO#getItemCriteriaDTOList()}
   *   <li>{@link PageDTO#getLocaleCode()}
   *   <li>{@link PageDTO#getPageAttributes()}
   *   <li>{@link PageDTO#getPageFields()}
   *   <li>{@link PageDTO#getPriority()}
   *   <li>{@link PageDTO#getRuleExpression()}
   *   <li>{@link PageDTO#getTemplatePath()}
   *   <li>{@link PageDTO#getUrl()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageDTO.<init>()",
    "String PageDTO.getDescription()",
    "Map PageDTO.getForeignPageFields()",
    "Long PageDTO.getId()",
    "List PageDTO.getItemCriteriaDTOList()",
    "String PageDTO.getLocaleCode()",
    "Map PageDTO.getPageAttributes()",
    "Map PageDTO.getPageFields()",
    "Integer PageDTO.getPriority()",
    "String PageDTO.getRuleExpression()",
    "String PageDTO.getTemplatePath()",
    "String PageDTO.getUrl()",
    "void PageDTO.setDescription(String)",
    "void PageDTO.setForeignPageFields(Map)",
    "void PageDTO.setId(Long)",
    "void PageDTO.setItemCriteriaDTOList(List)",
    "void PageDTO.setLocaleCode(String)",
    "void PageDTO.setPageAttributes(Map)",
    "void PageDTO.setPageFields(Map)",
    "void PageDTO.setPriority(Integer)",
    "void PageDTO.setRuleExpression(String)",
    "void PageDTO.setTemplatePath(String)",
    "void PageDTO.setUrl(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PageDTO actualPageDTO = new PageDTO();
    actualPageDTO.setDescription("The characteristics of someone or something");
    HashMap<String, Object> foreignPageFields = new HashMap<>();
    actualPageDTO.setForeignPageFields(foreignPageFields);
    actualPageDTO.setId(1L);
    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    actualPageDTO.setItemCriteriaDTOList(itemCriteriaDTOList);
    actualPageDTO.setLocaleCode("en");
    HashMap<String, String> pageAttributes = new HashMap<>();
    actualPageDTO.setPageAttributes(pageAttributes);
    HashMap<String, Object> pageFields = new HashMap<>();
    actualPageDTO.setPageFields(pageFields);
    actualPageDTO.setPriority(1);
    actualPageDTO.setRuleExpression("Rule Expression");
    actualPageDTO.setTemplatePath("Template Path");
    actualPageDTO.setUrl("https://example.org/example");
    String actualDescription = actualPageDTO.getDescription();
    Map<String, Object> actualForeignPageFields = actualPageDTO.getForeignPageFields();
    Long actualId = actualPageDTO.getId();
    List<ItemCriteriaDTO> actualItemCriteriaDTOList = actualPageDTO.getItemCriteriaDTOList();
    String actualLocaleCode = actualPageDTO.getLocaleCode();
    Map<String, String> actualPageAttributes = actualPageDTO.getPageAttributes();
    Map<String, Object> actualPageFields = actualPageDTO.getPageFields();
    Integer actualPriority = actualPageDTO.getPriority();
    String actualRuleExpression = actualPageDTO.getRuleExpression();
    String actualTemplatePath = actualPageDTO.getTemplatePath();

    // Assert
    assertEquals("Rule Expression", actualRuleExpression);
    assertEquals("Template Path", actualTemplatePath);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("en", actualLocaleCode);
    assertEquals("https://example.org/example", actualPageDTO.getUrl());
    assertEquals(1, actualPriority.intValue());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualItemCriteriaDTOList.isEmpty());
    assertTrue(actualForeignPageFields.isEmpty());
    assertTrue(actualPageAttributes.isEmpty());
    assertTrue(actualPageFields.isEmpty());
    assertSame(itemCriteriaDTOList, actualItemCriteriaDTOList);
    assertSame(foreignPageFields, actualForeignPageFields);
    assertSame(pageAttributes, actualPageAttributes);
    assertSame(pageFields, actualPageFields);
  }
}
