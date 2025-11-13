package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PageTemplateFieldGroupXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageTemplateFieldGroupXrefImpl#PageTemplateFieldGroupXrefImpl()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setFieldGroup(FieldGroup)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setGroupOrder(BigDecimal)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setId(Long)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setPageTemplate(PageTemplate)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getFieldGroup()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getGroupOrder()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getId()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getPageTemplate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageTemplateFieldGroupXrefImpl.<init>()",
    "void PageTemplateFieldGroupXrefImpl.<init>(PageTemplate, FieldGroup)",
    "FieldGroup PageTemplateFieldGroupXrefImpl.getFieldGroup()",
    "BigDecimal PageTemplateFieldGroupXrefImpl.getGroupOrder()",
    "Long PageTemplateFieldGroupXrefImpl.getId()",
    "PageTemplate PageTemplateFieldGroupXrefImpl.getPageTemplate()",
    "void PageTemplateFieldGroupXrefImpl.setFieldGroup(FieldGroup)",
    "void PageTemplateFieldGroupXrefImpl.setGroupOrder(BigDecimal)",
    "void PageTemplateFieldGroupXrefImpl.setId(Long)",
    "void PageTemplateFieldGroupXrefImpl.setPageTemplate(PageTemplate)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PageTemplateFieldGroupXrefImpl actualPageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    actualPageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);
    BigDecimal groupOrder = new BigDecimal("2.3");
    actualPageTemplateFieldGroupXrefImpl.setGroupOrder(groupOrder);
    actualPageTemplateFieldGroupXrefImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    actualPageTemplateFieldGroupXrefImpl.setPageTemplate(pageTemplate);
    FieldGroup actualFieldGroup = actualPageTemplateFieldGroupXrefImpl.getFieldGroup();
    BigDecimal actualGroupOrder = actualPageTemplateFieldGroupXrefImpl.getGroupOrder();
    Long actualId = actualPageTemplateFieldGroupXrefImpl.getId();
    PageTemplate actualPageTemplate = actualPageTemplateFieldGroupXrefImpl.getPageTemplate();

    // Assert
    assertEquals(new BigDecimal("2.3"), actualGroupOrder);
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(groupOrder, actualGroupOrder);
    assertSame(fieldGroup, actualFieldGroup);
    assertSame(pageTemplate, actualPageTemplate);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link PageTemplateImpl} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageTemplateFieldGroupXrefImpl#PageTemplateFieldGroupXrefImpl(PageTemplate,
   *       FieldGroup)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setFieldGroup(FieldGroup)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setGroupOrder(BigDecimal)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setId(Long)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#setPageTemplate(PageTemplate)}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getFieldGroup()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getGroupOrder()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getId()}
   *   <li>{@link PageTemplateFieldGroupXrefImpl#getPageTemplate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageTemplateFieldGroupXrefImpl.<init>()",
    "void PageTemplateFieldGroupXrefImpl.<init>(PageTemplate, FieldGroup)",
    "FieldGroup PageTemplateFieldGroupXrefImpl.getFieldGroup()",
    "BigDecimal PageTemplateFieldGroupXrefImpl.getGroupOrder()",
    "Long PageTemplateFieldGroupXrefImpl.getId()",
    "PageTemplate PageTemplateFieldGroupXrefImpl.getPageTemplate()",
    "void PageTemplateFieldGroupXrefImpl.setFieldGroup(FieldGroup)",
    "void PageTemplateFieldGroupXrefImpl.setGroupOrder(BigDecimal)",
    "void PageTemplateFieldGroupXrefImpl.setId(Long)",
    "void PageTemplateFieldGroupXrefImpl.setPageTemplate(PageTemplate)"
  })
  public void testGettersAndSetters_whenPageTemplateImpl() {
    // Arrange
    PageTemplateImpl pageTemplate = new PageTemplateImpl();

    // Act
    PageTemplateFieldGroupXrefImpl actualPageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl(pageTemplate, new FieldGroupImpl());
    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    actualPageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);
    BigDecimal groupOrder = new BigDecimal("2.3");
    actualPageTemplateFieldGroupXrefImpl.setGroupOrder(groupOrder);
    actualPageTemplateFieldGroupXrefImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    PageTemplateImpl pageTemplate2 = new PageTemplateImpl();
    actualPageTemplateFieldGroupXrefImpl.setPageTemplate(pageTemplate2);
    FieldGroup actualFieldGroup = actualPageTemplateFieldGroupXrefImpl.getFieldGroup();
    BigDecimal actualGroupOrder = actualPageTemplateFieldGroupXrefImpl.getGroupOrder();
    Long actualId = actualPageTemplateFieldGroupXrefImpl.getId();
    PageTemplate actualPageTemplate = actualPageTemplateFieldGroupXrefImpl.getPageTemplate();

    // Assert
    assertEquals(new BigDecimal("2.3"), actualGroupOrder);
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(groupOrder, actualGroupOrder);
    assertSame(fieldGroup, actualFieldGroup);
    assertSame(pageTemplate2, actualPageTemplate);
  }
}
