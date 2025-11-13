package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PageTemplateImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PageTemplateImpl}
   *   <li>{@link PageTemplateImpl#setFieldGroupXrefs(List)}
   *   <li>{@link PageTemplateImpl#setId(Long)}
   *   <li>{@link PageTemplateImpl#setLocale(Locale)}
   *   <li>{@link PageTemplateImpl#setTemplateDescription(String)}
   *   <li>{@link PageTemplateImpl#setTemplateName(String)}
   *   <li>{@link PageTemplateImpl#setTemplatePath(String)}
   *   <li>{@link PageTemplateImpl#getFieldGroupXrefs()}
   *   <li>{@link PageTemplateImpl#getId()}
   *   <li>{@link PageTemplateImpl#getLocale()}
   *   <li>{@link PageTemplateImpl#getTemplateDescription()}
   *   <li>{@link PageTemplateImpl#getTemplateName()}
   *   <li>{@link PageTemplateImpl#getTemplatePath()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageTemplateImpl.<init>()",
    "List PageTemplateImpl.getFieldGroupXrefs()",
    "Long PageTemplateImpl.getId()",
    "Locale PageTemplateImpl.getLocale()",
    "String PageTemplateImpl.getTemplateDescription()",
    "String PageTemplateImpl.getTemplateName()",
    "String PageTemplateImpl.getTemplatePath()",
    "void PageTemplateImpl.setFieldGroupXrefs(List)",
    "void PageTemplateImpl.setId(Long)",
    "void PageTemplateImpl.setLocale(Locale)",
    "void PageTemplateImpl.setTemplateDescription(String)",
    "void PageTemplateImpl.setTemplateName(String)",
    "void PageTemplateImpl.setTemplatePath(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PageTemplateImpl actualPageTemplateImpl = new PageTemplateImpl();
    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    actualPageTemplateImpl.setFieldGroupXrefs(fieldGroups);
    actualPageTemplateImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    LocaleImpl locale = new LocaleImpl();
    actualPageTemplateImpl.setLocale(locale);
    actualPageTemplateImpl.setTemplateDescription("Template Description");
    actualPageTemplateImpl.setTemplateName("Template Name");
    actualPageTemplateImpl.setTemplatePath("Template Path");
    List<PageTemplateFieldGroupXref> actualFieldGroupXrefs =
        actualPageTemplateImpl.getFieldGroupXrefs();
    Long actualId = actualPageTemplateImpl.getId();
    Locale actualLocale = actualPageTemplateImpl.getLocale();
    String actualTemplateDescription = actualPageTemplateImpl.getTemplateDescription();
    String actualTemplateName = actualPageTemplateImpl.getTemplateName();

    // Assert
    assertEquals("Template Description", actualTemplateDescription);
    assertEquals("Template Name", actualTemplateName);
    assertEquals("Template Path", actualPageTemplateImpl.getTemplatePath());
    assertTrue(actualFieldGroupXrefs.isEmpty());
    assertTrue(actualPageTemplateImpl.legacyFieldGroups.isEmpty());
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(fieldGroups, actualFieldGroupXrefs);
    assertSame(locale, actualLocale);
  }
}
