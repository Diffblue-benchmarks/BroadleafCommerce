package org.broadleafcommerce.cms.structure.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StructuredContentImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentImpl}
   *   <li>{@link StructuredContentImpl#setContentName(String)}
   *   <li>{@link StructuredContentImpl#setFieldValues(Map)}
   *   <li>{@link StructuredContentImpl#setId(Long)}
   *   <li>{@link StructuredContentImpl#setLocale(Locale)}
   *   <li>{@link StructuredContentImpl#setOfflineFlag(Boolean)}
   *   <li>{@link StructuredContentImpl#setPriority(Integer)}
   *   <li>{@link StructuredContentImpl#setQualifyingItemCriteria(Set)}
   *   <li>{@link StructuredContentImpl#setStructuredContentFieldXrefs(Map)}
   *   <li>{@link StructuredContentImpl#setStructuredContentMatchRules(Map)}
   *   <li>{@link StructuredContentImpl#setStructuredContentType(StructuredContentType)}
   *   <li>{@link StructuredContentImpl#getContentName()}
   *   <li>{@link StructuredContentImpl#getId()}
   *   <li>{@link StructuredContentImpl#getLocale()}
   *   <li>{@link StructuredContentImpl#getPriority()}
   *   <li>{@link StructuredContentImpl#getQualifyingItemCriteria()}
   *   <li>{@link StructuredContentImpl#getStructuredContentFieldXrefs()}
   *   <li>{@link StructuredContentImpl#getStructuredContentMatchRules()}
   *   <li>{@link StructuredContentImpl#getStructuredContentType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentImpl.<init>()",
    "String StructuredContentImpl.getContentName()",
    "Long StructuredContentImpl.getId()",
    "Locale StructuredContentImpl.getLocale()",
    "Integer StructuredContentImpl.getPriority()",
    "Set StructuredContentImpl.getQualifyingItemCriteria()",
    "Map StructuredContentImpl.getStructuredContentFieldXrefs()",
    "Map StructuredContentImpl.getStructuredContentMatchRules()",
    "StructuredContentType StructuredContentImpl.getStructuredContentType()",
    "void StructuredContentImpl.setContentName(String)",
    "void StructuredContentImpl.setFieldValues(Map)",
    "void StructuredContentImpl.setId(Long)",
    "void StructuredContentImpl.setLocale(Locale)",
    "void StructuredContentImpl.setOfflineFlag(Boolean)",
    "void StructuredContentImpl.setPriority(Integer)",
    "void StructuredContentImpl.setQualifyingItemCriteria(Set)",
    "void StructuredContentImpl.setStructuredContentFieldXrefs(Map)",
    "void StructuredContentImpl.setStructuredContentMatchRules(Map)",
    "void StructuredContentImpl.setStructuredContentType(StructuredContentType)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentImpl actualStructuredContentImpl = new StructuredContentImpl();
    actualStructuredContentImpl.setContentName("Not all who wander are lost");
    actualStructuredContentImpl.setFieldValues(new HashMap<>());
    actualStructuredContentImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    LocaleImpl locale = new LocaleImpl();
    actualStructuredContentImpl.setLocale(locale);
    actualStructuredContentImpl.setOfflineFlag(true);
    actualStructuredContentImpl.setPriority(1);
    HashSet<StructuredContentItemCriteria> qualifyingItemCriteria = new HashSet<>();
    actualStructuredContentImpl.setQualifyingItemCriteria(qualifyingItemCriteria);
    HashMap<String, StructuredContentFieldXref> structuredContentFields = new HashMap<>();
    actualStructuredContentImpl.setStructuredContentFieldXrefs(structuredContentFields);
    HashMap<String, StructuredContentRule> structuredContentMatchRules = new HashMap<>();
    actualStructuredContentImpl.setStructuredContentMatchRules(structuredContentMatchRules);
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    actualStructuredContentImpl.setStructuredContentType(structuredContentType);
    String actualContentName = actualStructuredContentImpl.getContentName();
    Long actualId = actualStructuredContentImpl.getId();
    Locale actualLocale = actualStructuredContentImpl.getLocale();
    Integer actualPriority = actualStructuredContentImpl.getPriority();
    Set<StructuredContentItemCriteria> actualQualifyingItemCriteria =
        actualStructuredContentImpl.getQualifyingItemCriteria();
    Map<String, StructuredContentFieldXref> actualStructuredContentFieldXrefs =
        actualStructuredContentImpl.getStructuredContentFieldXrefs();
    Map<String, StructuredContentRule> actualStructuredContentMatchRules =
        actualStructuredContentImpl.getStructuredContentMatchRules();
    StructuredContentType actualStructuredContentType =
        actualStructuredContentImpl.getStructuredContentType();

    // Assert
    assertEquals("Not all who wander are lost", actualContentName);
    assertEquals(1, actualPriority.intValue());
    assertTrue(actualStructuredContentFieldXrefs.isEmpty());
    assertTrue(actualStructuredContentMatchRules.isEmpty());
    assertTrue(actualStructuredContentImpl.fieldValuesMap.isEmpty());
    assertTrue(actualStructuredContentImpl.legacyStructuredContentFields.isEmpty());
    assertTrue(actualQualifyingItemCriteria.isEmpty());
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(structuredContentFields, actualStructuredContentFieldXrefs);
    assertSame(structuredContentMatchRules, actualStructuredContentMatchRules);
    assertSame(qualifyingItemCriteria, actualQualifyingItemCriteria);
    assertSame(structuredContentType, actualStructuredContentType);
    assertSame(locale, actualLocale);
  }
}
