package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PageImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PageImpl}
   *   <li>{@link PageImpl#setActiveEndDate(Date)}
   *   <li>{@link PageImpl#setActiveStartDate(Date)}
   *   <li>{@link PageImpl#setAdditionalAttributes(Map)}
   *   <li>{@link PageImpl#setDescription(String)}
   *   <li>{@link PageImpl#setFullUrl(String)}
   *   <li>{@link PageImpl#setId(Long)}
   *   <li>{@link PageImpl#setMetaDescription(String)}
   *   <li>{@link PageImpl#setMetaTitle(String)}
   *   <li>{@link PageImpl#setPageFields(Map)}
   *   <li>{@link PageImpl#setPageMatchRules(Map)}
   *   <li>{@link PageImpl#setPageTemplate(PageTemplate)}
   *   <li>{@link PageImpl#setPriority(Integer)}
   *   <li>{@link PageImpl#setQualifyingItemCriteria(Set)}
   *   <li>{@link PageImpl#getActiveEndDate()}
   *   <li>{@link PageImpl#getActiveStartDate()}
   *   <li>{@link PageImpl#getAdditionalAttributes()}
   *   <li>{@link PageImpl#getDescription()}
   *   <li>{@link PageImpl#getFullUrl()}
   *   <li>{@link PageImpl#getId()}
   *   <li>{@link PageImpl#getMetaDescription()}
   *   <li>{@link PageImpl#getMetaTitle()}
   *   <li>{@link PageImpl#getPageFields()}
   *   <li>{@link PageImpl#getPageMatchRules()}
   *   <li>{@link PageImpl#getPageTemplate()}
   *   <li>{@link PageImpl#getQualifyingItemCriteria()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageImpl.<init>()",
    "Date PageImpl.getActiveEndDate()",
    "Date PageImpl.getActiveStartDate()",
    "Map PageImpl.getAdditionalAttributes()",
    "String PageImpl.getDescription()",
    "String PageImpl.getFullUrl()",
    "Long PageImpl.getId()",
    "String PageImpl.getMetaDescription()",
    "String PageImpl.getMetaTitle()",
    "Map PageImpl.getPageFields()",
    "Map PageImpl.getPageMatchRules()",
    "PageTemplate PageImpl.getPageTemplate()",
    "Set PageImpl.getQualifyingItemCriteria()",
    "void PageImpl.setActiveEndDate(Date)",
    "void PageImpl.setActiveStartDate(Date)",
    "void PageImpl.setAdditionalAttributes(Map)",
    "void PageImpl.setDescription(String)",
    "void PageImpl.setFullUrl(String)",
    "void PageImpl.setId(Long)",
    "void PageImpl.setMetaDescription(String)",
    "void PageImpl.setMetaTitle(String)",
    "void PageImpl.setPageFields(Map)",
    "void PageImpl.setPageMatchRules(Map)",
    "void PageImpl.setPageTemplate(PageTemplate)",
    "void PageImpl.setPriority(Integer)",
    "void PageImpl.setQualifyingItemCriteria(Set)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PageImpl actualPageImpl = new PageImpl();
    Date activeEndDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualPageImpl.setActiveEndDate(activeEndDate);
    Date activeStartDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualPageImpl.setActiveStartDate(activeStartDate);
    HashMap<String, PageAttribute> additionalAttributes = new HashMap<>();
    actualPageImpl.setAdditionalAttributes(additionalAttributes);
    actualPageImpl.setDescription("The characteristics of someone or something");
    actualPageImpl.setFullUrl("https://example.org/example");
    actualPageImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    actualPageImpl.setMetaDescription("Meta Description");
    actualPageImpl.setMetaTitle("Dr");
    HashMap<String, PageField> pageFields = new HashMap<>();
    actualPageImpl.setPageFields(pageFields);
    HashMap<String, PageRule> pageMatchRules = new HashMap<>();
    actualPageImpl.setPageMatchRules(pageMatchRules);
    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    actualPageImpl.setPageTemplate(pageTemplate);
    actualPageImpl.setPriority(1);
    HashSet<PageItemCriteria> qualifyingItemCriteria = new HashSet<>();
    actualPageImpl.setQualifyingItemCriteria(qualifyingItemCriteria);
    Date actualActiveEndDate = actualPageImpl.getActiveEndDate();
    Date actualActiveStartDate = actualPageImpl.getActiveStartDate();
    Map<String, PageAttribute> actualAdditionalAttributes =
        actualPageImpl.getAdditionalAttributes();
    String actualDescription = actualPageImpl.getDescription();
    String actualFullUrl = actualPageImpl.getFullUrl();
    Long actualId = actualPageImpl.getId();
    String actualMetaDescription = actualPageImpl.getMetaDescription();
    String actualMetaTitle = actualPageImpl.getMetaTitle();
    Map<String, PageField> actualPageFields = actualPageImpl.getPageFields();
    Map<String, PageRule> actualPageMatchRules = actualPageImpl.getPageMatchRules();
    PageTemplate actualPageTemplate = actualPageImpl.getPageTemplate();
    Set<PageItemCriteria> actualQualifyingItemCriteria = actualPageImpl.getQualifyingItemCriteria();

    // Assert
    assertEquals("Dr", actualMetaTitle);
    assertEquals("Meta Description", actualMetaDescription);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("https://example.org/example", actualFullUrl);
    assertEquals(1, actualPageImpl.priority.intValue());
    assertTrue(actualAdditionalAttributes.isEmpty());
    assertTrue(actualPageFields.isEmpty());
    assertTrue(actualPageMatchRules.isEmpty());
    assertTrue(actualQualifyingItemCriteria.isEmpty());
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(additionalAttributes, actualAdditionalAttributes);
    assertSame(pageFields, actualPageFields);
    assertSame(pageMatchRules, actualPageMatchRules);
    assertSame(qualifyingItemCriteria, actualQualifyingItemCriteria);
    assertSame(pageTemplate, actualPageTemplate);
    assertSame(activeEndDate, actualActiveEndDate);
    assertSame(activeStartDate, actualActiveStartDate);
  }
}
