package org.broadleafcommerce.cms.page.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.cms.field.domain.FieldDefinition;
import org.broadleafcommerce.cms.field.domain.FieldDefinitionImpl;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageAttribute;
import org.broadleafcommerce.cms.page.domain.PageAttributeImpl;
import org.broadleafcommerce.cms.page.domain.PageField;
import org.broadleafcommerce.cms.page.domain.PageFieldImpl;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.broadleafcommerce.cms.page.domain.PageItemCriteria;
import org.broadleafcommerce.cms.page.domain.PageItemCriteriaImpl;
import org.broadleafcommerce.cms.page.domain.PageRule;
import org.broadleafcommerce.cms.page.domain.PageRuleImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplateFieldGroupXref;
import org.broadleafcommerce.cms.page.domain.PageTemplateFieldGroupXrefImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplateImpl;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.file.service.StaticAssetPathService;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PageServiceUtilityDiffblueTest {
  @Mock private PageServiceExtensionManager pageServiceExtensionManager;

  @InjectMocks private PageServiceUtility pageServiceUtility;

  @Mock private StaticAssetPathService staticAssetPathService;

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageFieldImpl pageFieldImpl = mock(PageFieldImpl.class);
    when(pageFieldImpl.getValue()).thenReturn("42");

    HashMap<String, PageField> pageFields = new HashMap<>();
    pageFields.put("title", pageFieldImpl);

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);
    page.setPageMatchRules(new HashMap<>());
    page.setPageFields(pageFields);

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageFieldImpl).getValue();
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields2 = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields2.size());
    assertEquals("42", pageFields2.get("title"));
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO2() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("");

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageFieldImpl pageFieldImpl = mock(PageFieldImpl.class);
    when(pageFieldImpl.getValue()).thenReturn("42");

    HashMap<String, PageField> pageFields = new HashMap<>();
    pageFields.put("title", pageFieldImpl);

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);
    page.setPageMatchRules(new HashMap<>());
    page.setPageFields(pageFields);

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageFieldImpl).getValue();
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields2 = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields2.size());
    assertEquals("42", pageFields2.get("title"));
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code title} is {@link PageAttributeImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_givenHashMapTitleIsPageAttributeImpl() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    HashMap<String, PageAttribute> additionalAttributes = new HashMap<>();
    additionalAttributes.put("title", new PageAttributeImpl());

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(additionalAttributes);
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);
    page.setPageMatchRules(new HashMap<>());
    page.setPageFields(new HashMap<>());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    ItemCriteriaDTO clone4 = clone3.getClone();
    assertNull(clone4.getQty());
    assertNull(actualBuildPageDTOResult.getRuleExpression());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
    assertNull(clone4.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PageImpl} (default constructor) PageMatchRules is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_givenNull_whenPageImplPageMatchRulesIsNull() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);
    page.setPageMatchRules(null);
    page.setPageFields(new HashMap<>());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    ItemCriteriaDTO clone4 = clone3.getClone();
    assertNull(clone4.getQty());
    assertNull(actualBuildPageDTOResult.getRuleExpression());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
    assertNull(clone4.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PageServiceExtensionHandler} {@link
   *       PageServiceExtensionHandler#getFieldDefinition(ExtensionResultHolder, Page, String)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_givenPageServiceExtensionHandlerGetFieldDefinitionReturnNull() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(null);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageFieldImpl pageFieldImpl = mock(PageFieldImpl.class);
    when(pageFieldImpl.getValue()).thenReturn("42");

    HashMap<String, PageField> pageFields = new HashMap<>();
    pageFields.put("title", pageFieldImpl);

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);
    page.setPageMatchRules(new HashMap<>());
    page.setPageFields(pageFields);

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageFieldImpl).getValue();
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields2 = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields2.size());
    assertEquals("42", pageFields2.get("title"));
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PageServiceUtility} (default constructor).
   *   <li>Then return RuleExpression is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_givenPageServiceUtility_thenReturnRuleExpressionIsNull() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);
    page.setPageMatchRules(new HashMap<>());
    page.setPageFields(new HashMap<>());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    ItemCriteriaDTO clone4 = clone3.getClone();
    assertNull(clone4.getQty());
    assertNull(actualBuildPageDTOResult.getRuleExpression());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
    assertNull(clone4.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PageServiceUtility} (default constructor).
   *   <li>When {@link PageImpl} (default constructor).
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_givenPageServiceUtility_whenPageImpl_thenReturnIdIsNull() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(new PageImpl(), true);

    // Assert
    assertNull(actualBuildPageDTOResult.getId());
    Map<String, String> pageAttributes = actualBuildPageDTOResult.getPageAttributes();
    assertEquals(2, pageAttributes.size());
    assertNull(pageAttributes.get("metaDescription"));
    assertNull(pageAttributes.get("title"));
    assertNull(actualBuildPageDTOResult.getDescription());
    assertNull(actualBuildPageDTOResult.getTemplatePath());
    assertNull(actualBuildPageDTOResult.getUrl());
    assertEquals(0, actualBuildPageDTOResult.getPriority().intValue());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor) Locale is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_givenPageTemplateImplLocaleIsNull() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(null);
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);
    page.setPageMatchRules(new HashMap<>());
    page.setPageFields(new HashMap<>());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    ItemCriteriaDTO clone4 = clone3.getClone();
    assertNull(clone4.getQty());
    assertNull(actualBuildPageDTOResult.getRuleExpression());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
    assertNull(clone4.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <ul>
   *   <li>Given {@link StaticAssetPathService} {@link
   *       StaticAssetPathService#getStaticAssetUrlPrefix()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_givenStaticAssetPathServiceGetStaticAssetUrlPrefixReturnNull() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn(null);

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageFieldImpl pageFieldImpl = mock(PageFieldImpl.class);
    when(pageFieldImpl.getValue()).thenReturn("42");

    HashMap<String, PageField> pageFields = new HashMap<>();
    pageFields.put("title", pageFieldImpl);

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);
    page.setPageMatchRules(new HashMap<>());
    page.setPageFields(pageFields);

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageFieldImpl).getValue();
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields2 = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields2.size());
    assertEquals("42", pageFields2.get("title"));
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <ul>
   *   <li>Given {@link StaticAssetPathService} {@link
   *       StaticAssetPathService#getStaticAssetUrlPrefix()} return space.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_givenStaticAssetPathServiceGetStaticAssetUrlPrefixReturnSpace() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn(" ");

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageFieldImpl pageFieldImpl = mock(PageFieldImpl.class);
    when(pageFieldImpl.getValue()).thenReturn("42");

    HashMap<String, PageField> pageFields = new HashMap<>();
    pageFields.put("title", pageFieldImpl);

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);
    page.setPageMatchRules(new HashMap<>());
    page.setPageFields(pageFields);

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageFieldImpl).getValue();
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields2 = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields2.size());
    assertEquals("42", pageFields2.get("title"));
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <ul>
   *   <li>Then return PageAttributes {@code title} is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_thenReturnPageAttributesTitleIsDr() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(null);
    page.setPageMatchRules(new HashMap<>());
    page.setPageFields(new HashMap<>());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    Map<String, String> pageAttributes = actualBuildPageDTOResult.getPageAttributes();
    assertEquals(2, pageAttributes.size());
    assertEquals("Dr", pageAttributes.get("title"));
    assertEquals("Meta Description", pageAttributes.get("metaDescription"));
    assertEquals("Template Path", actualBuildPageDTOResult.getTemplatePath());
    assertEquals(
        "The characteristics of someone or something", actualBuildPageDTOResult.getDescription());
    assertEquals("https://example.org/example", actualBuildPageDTOResult.getUrl());
    assertNull(actualBuildPageDTOResult.getItemCriteriaDTOList());
    assertEquals(1, actualBuildPageDTOResult.getPriority().intValue());
    assertEquals(1L, actualBuildPageDTOResult.getId().longValue());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <ul>
   *   <li>Then return PageFields {@code title} is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_thenReturnPageFieldsTitleIsNotAllWhoWanderAreLost() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.convertAllAssetPathsInContent(Mockito.<String>any(), anyBoolean()))
        .thenReturn("Not all who wander are lost");
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("42");

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageFieldImpl pageFieldImpl = mock(PageFieldImpl.class);
    when(pageFieldImpl.getValue()).thenReturn("42");

    HashMap<String, PageField> pageFields = new HashMap<>();
    pageFields.put("title", pageFieldImpl);

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);
    page.setPageMatchRules(new HashMap<>());
    page.setPageFields(pageFields);

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageFieldImpl).getValue();
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).convertAllAssetPathsInContent("42", true);
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields2 = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields2.size());
    assertEquals("Not all who wander are lost", pageFields2.get("title"));
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <ul>
   *   <li>Then return PageFields {@code title} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_thenReturnPageFieldsTitleIsNull() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    HashMap<String, PageField> pageFields = new HashMap<>();
    pageFields.put("title", new PageFieldImpl());

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);
    page.setPageMatchRules(new HashMap<>());
    page.setPageFields(pageFields);

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("title"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    Map<String, Object> pageFields2 = actualBuildPageDTOResult.getPageFields();
    assertEquals(1, pageFields2.size());
    assertNull(pageFields2.get("title"));
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <ul>
   *   <li>Then return RuleExpression is {@code Match Rule}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_thenReturnRuleExpressionIsMatchRule() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageRuleImpl pageRuleImpl = mock(PageRuleImpl.class);
    when(pageRuleImpl.getMatchRule()).thenReturn("Match Rule");

    HashMap<String, PageRule> pageMatchRules = new HashMap<>();
    pageMatchRules.put("title", pageRuleImpl);

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);
    page.setPageMatchRules(pageMatchRules);
    page.setPageFields(new HashMap<>());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageRuleImpl).getMatchRule();
    assertEquals("Match Rule", actualBuildPageDTOResult.getRuleExpression());
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    ItemCriteriaDTO clone4 = clone3.getClone();
    assertNull(clone4.getQty());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
    assertNull(clone4.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildPageDTO(Page, boolean)}.
   *
   * <ul>
   *   <li>Then return RuleExpression is {@code Match Rule && null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildPageDTO(Page, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.buildPageDTO(Page, boolean)"})
  public void testBuildPageDTO_thenReturnRuleExpressionIsMatchRuleNull() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageRuleImpl pageRuleImpl = mock(PageRuleImpl.class);
    when(pageRuleImpl.getMatchRule()).thenReturn("Match Rule");

    HashMap<String, PageRule> pageMatchRules = new HashMap<>();
    pageMatchRules.put("metaDescription", new PageRuleImpl());
    pageMatchRules.put("title", pageRuleImpl);

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPriority(1);
    page.setPageTemplate(pageTemplate);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);
    page.setPageMatchRules(pageMatchRules);
    page.setPageFields(new HashMap<>());

    // Act
    PageDTO actualBuildPageDTOResult = pageServiceUtility.buildPageDTO(page, true);

    // Assert
    verify(pageRuleImpl).getMatchRule();
    assertEquals("Match Rule && null", actualBuildPageDTOResult.getRuleExpression());
    List<ItemCriteriaDTO> itemCriteriaDTOList = actualBuildPageDTOResult.getItemCriteriaDTOList();
    assertEquals(1, itemCriteriaDTOList.size());
    ItemCriteriaDTO getResult = itemCriteriaDTOList.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    ItemCriteriaDTO clone4 = clone3.getClone();
    assertNull(clone4.getQty());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
    assertNull(clone4.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with
   * {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   *
   * <p>Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"
  })
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");
    PageImpl page = new PageImpl();
    PageDTO pageDTO = new PageDTO();

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields = pageDTO.getPageFields();
    assertEquals(1, pageFields.size());
    assertEquals("42", pageFields.get("Field Key"));
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with
   * {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   *
   * <p>Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"
  })
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue2() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");
    PageImpl page = new PageImpl();

    PageDTO pageDTO = mock(PageDTO.class);
    when(pageDTO.getPageFields()).thenReturn(new HashMap<>());

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(pageDTO).getPageFields();
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with
   * {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   *
   * <p>Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"
  })
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue3() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(null);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");
    PageImpl page = new PageImpl();

    PageDTO pageDTO = mock(PageDTO.class);
    when(pageDTO.getPageFields()).thenReturn(new HashMap<>());

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(pageDTO).getPageFields();
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with
   * {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   *
   * <p>Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"
  })
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue4() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn(null);
    PageImpl page = new PageImpl();

    PageDTO pageDTO = mock(PageDTO.class);
    when(pageDTO.getPageFields()).thenReturn(new HashMap<>());

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(pageDTO).getPageFields();
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with
   * {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   *
   * <p>Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"
  })
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue5() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.convertAllAssetPathsInContent(Mockito.<String>any(), anyBoolean()))
        .thenReturn("Not all who wander are lost");
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("42");
    PageImpl page = new PageImpl();

    PageDTO pageDTO = mock(PageDTO.class);
    when(pageDTO.getPageFields()).thenReturn(new HashMap<>());

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).convertAllAssetPathsInContent("42", true);
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(pageDTO).getPageFields();
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with
   * {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   *
   * <p>Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"
  })
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue6() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn(" ");
    PageImpl page = new PageImpl();

    PageDTO pageDTO = mock(PageDTO.class);
    when(pageDTO.getPageFields()).thenReturn(new HashMap<>());

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(pageDTO).getPageFields();
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with
   * {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   *
   * <p>Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"
  })
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue7() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("");
    PageImpl page = new PageImpl();

    PageDTO pageDTO = mock(PageDTO.class);
    when(pageDTO.getPageFields()).thenReturn(new HashMap<>());

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "42");

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(pageDTO).getPageFields();
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with
   * {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   *
   * <p>Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"
  })
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue8() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("42");
    PageImpl page = new PageImpl();

    PageDTO pageDTO = mock(PageDTO.class);
    when(pageDTO.getPageFields()).thenReturn(new HashMap<>());

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", " ");

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(pageDTO).getPageFields();
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with
   * {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   *
   * <p>Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"
  })
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue9() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");

    HashMap<String, PageField> pageFields = new HashMap<>();
    pageFields.put("foo", new PageFieldImpl());

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageMatchRules(new HashMap<>());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setPageFields(pageFields);
    page.setPageTemplate(pageTemplate);

    PageDTO pageDTO = new PageDTO();
    HashMap<String, Object> pageFields2 = new HashMap<>();
    pageDTO.setPageFields(pageFields2);

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "not blank");

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields3 = pageDTO.getPageFields();
    assertEquals(1, pageFields3.size());
    assertEquals("not blank", pageFields3.get("Field Key"));
    assertSame(pageFields2, pageFields3);
  }

  /**
   * Test {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO, String, String)} with
   * {@code page}, {@code secure}, {@code pageDTO}, {@code fieldKey}, {@code originalValue}.
   *
   * <p>Method under test: {@link PageServiceUtility#addPageFieldToDTO(Page, boolean, PageDTO,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageServiceUtility.addPageFieldToDTO(Page, boolean, PageDTO, String, String)"
  })
  public void testAddPageFieldToDTOWithPageSecurePageDTOFieldKeyOriginalValue10() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);
    when(staticAssetPathService.convertAllAssetPathsInContent(Mockito.<String>any(), anyBoolean()))
        .thenReturn("Not all who wander are lost");
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("not blank");

    HashMap<String, PageField> pageFields = new HashMap<>();
    pageFields.put("foo", new PageFieldImpl());

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    pageTemplate.setId(1L);
    pageTemplate.setLocale(new LocaleImpl());
    pageTemplate.setTemplateDescription("Template Description");
    pageTemplate.setTemplateName("Template Name");
    pageTemplate.setTemplatePath("Template Path");
    pageTemplate.setFieldGroupXrefs(fieldGroups);

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageMatchRules(new HashMap<>());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setPageFields(pageFields);
    page.setPageTemplate(pageTemplate);

    PageDTO pageDTO = new PageDTO();
    HashMap<String, Object> pageFields2 = new HashMap<>();
    pageDTO.setPageFields(pageFields2);

    // Act
    pageServiceUtility.addPageFieldToDTO(page, true, pageDTO, "Field Key", "not blank");

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    verify(staticAssetPathService).convertAllAssetPathsInContent("not blank", true);
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> pageFields3 = pageDTO.getPageFields();
    assertEquals(1, pageFields3.size());
    assertEquals("Not all who wander are lost", pageFields3.get("Field Key"));
    assertSame(pageFields2, pageFields3);
  }

  /**
   * Test {@link PageServiceUtility#getFieldDefinition(Page, String)}.
   *
   * <p>Method under test: {@link PageServiceUtility#getFieldDefinition(Page, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldDefinition PageServiceUtility.getFieldDefinition(Page, String)"})
  public void testGetFieldDefinition() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);

    // Act
    FieldDefinition actualFieldDefinition =
        pageServiceUtility.getFieldDefinition(new PageImpl(), "Field Key");

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    assertNull(actualFieldDefinition);
  }

  /**
   * Test {@link PageServiceUtility#getFieldDefinition(Page, String)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#getFieldDefinition(Page, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldDefinition PageServiceUtility.getFieldDefinition(Page, String)"})
  public void testGetFieldDefinition_givenPageTemplateImpl() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);

    PageImpl page = new PageImpl();
    page.setPageTemplate(new PageTemplateImpl());

    // Act
    FieldDefinition actualFieldDefinition =
        pageServiceUtility.getFieldDefinition(page, "Field Key");

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    assertNull(actualFieldDefinition);
  }

  /**
   * Test {@link PageServiceUtility#getFieldDefinition(Page, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Page#getPageTemplate()}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#getFieldDefinition(Page, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldDefinition PageServiceUtility.getFieldDefinition(Page, String)"})
  public void testGetFieldDefinition_thenCallsGetPageTemplate() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    pageTemplateImpl.setId(1L);
    pageTemplateImpl.setLocale(new LocaleImpl());
    pageTemplateImpl.setTemplateDescription("Template Description");
    pageTemplateImpl.setTemplateName("Template Name");
    pageTemplateImpl.setTemplatePath("Template Path");
    pageTemplateImpl.setFieldGroupXrefs(fieldGroups);

    Page page = mock(Page.class);
    when(page.getPageTemplate()).thenReturn(pageTemplateImpl);

    // Act
    FieldDefinition actualFieldDefinition =
        pageServiceUtility.getFieldDefinition(page, "Field Key");

    // Assert
    verify(page, atLeast(1)).getPageTemplate();
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    assertNull(actualFieldDefinition);
  }

  /**
   * Test {@link PageServiceUtility#getFieldDefinition(Page, String)}.
   *
   * <ul>
   *   <li>Then return {@link FieldDefinitionImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#getFieldDefinition(Page, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldDefinition PageServiceUtility.getFieldDefinition(Page, String)"})
  public void testGetFieldDefinition_thenReturnFieldDefinitionImpl() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);

    FieldDefinitionImpl fieldDefinitionImpl = new FieldDefinitionImpl();
    fieldDefinitionImpl.setName("Field Key");

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(fieldDefinitionImpl);

    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    fieldGroup.setFieldGroupXrefs(new ArrayList<>());
    fieldGroup.setId(1L);
    fieldGroup.setInitCollapsedFlag(true);
    fieldGroup.setIsMasterFieldGroup(true);
    fieldGroup.setName("Name");
    fieldGroup.setFieldDefinitions(fieldDefinitions);

    PageTemplateFieldGroupXrefImpl pageTemplateFieldGroupXrefImpl =
        new PageTemplateFieldGroupXrefImpl();
    pageTemplateFieldGroupXrefImpl.setGroupOrder(new BigDecimal("2.3"));
    pageTemplateFieldGroupXrefImpl.setId(1L);
    pageTemplateFieldGroupXrefImpl.setPageTemplate(new PageTemplateImpl());
    pageTemplateFieldGroupXrefImpl.setFieldGroup(fieldGroup);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(pageTemplateFieldGroupXrefImpl);

    PageTemplateImpl pageTemplateImpl = new PageTemplateImpl();
    pageTemplateImpl.setId(1L);
    pageTemplateImpl.setLocale(new LocaleImpl());
    pageTemplateImpl.setTemplateDescription("Template Description");
    pageTemplateImpl.setTemplateName("Template Name");
    pageTemplateImpl.setTemplatePath("Template Path");
    pageTemplateImpl.setFieldGroupXrefs(fieldGroups);

    Page page = mock(Page.class);
    when(page.getPageTemplate()).thenReturn(pageTemplateImpl);

    // Act
    FieldDefinition actualFieldDefinition =
        pageServiceUtility.getFieldDefinition(page, "Field Key");

    // Assert
    verify(page, atLeast(1)).getPageTemplate();
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    assertSame(fieldDefinitionImpl, actualFieldDefinition);
  }

  /**
   * Test {@link PageServiceUtility#getFieldDefinition(Page, String)}.
   *
   * <ul>
   *   <li>When {@link PageImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#getFieldDefinition(Page, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldDefinition PageServiceUtility.getFieldDefinition(Page, String)"})
  public void testGetFieldDefinition_whenPageImpl_thenReturnNull() {
    // Arrange
    PageServiceExtensionHandler pageServiceExtensionHandler =
        mock(PageServiceExtensionHandler.class);
    when(pageServiceExtensionHandler.getFieldDefinition(
            Mockito.<ExtensionResultHolder<FieldDefinition>>any(),
            Mockito.<Page>any(),
            Mockito.<String>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);
    when(pageServiceExtensionManager.getProxy()).thenReturn(pageServiceExtensionHandler);

    // Act
    FieldDefinition actualFieldDefinition =
        pageServiceUtility.getFieldDefinition(new PageImpl(), "Field Key");

    // Assert
    verify(pageServiceExtensionHandler)
        .getFieldDefinition(isA(ExtensionResultHolder.class), isA(Page.class), eq("Field Key"));
    verify(pageServiceExtensionManager).getProxy();
    assertNull(actualFieldDefinition);
  }

  /**
   * Test {@link PageServiceUtility#buildRuleExpression(Page)}.
   *
   * <p>Method under test: {@link PageServiceUtility#buildRuleExpression(Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceUtility.buildRuleExpression(Page)"})
  public void testBuildRuleExpression() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageFields(new HashMap<>());
    page.setPageTemplate(new PageTemplateImpl());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setPageMatchRules(null);

    // Act and Assert
    assertNull(pageServiceUtility.buildRuleExpression(page));
  }

  /**
   * Test {@link PageServiceUtility#buildRuleExpression(Page)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@link PageRuleImpl} (default constructor).
   *   <li>Then return {@code Match Rule && null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildRuleExpression(Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceUtility.buildRuleExpression(Page)"})
  public void testBuildRuleExpression_givenHashMap42IsPageRuleImpl_thenReturnMatchRuleNull() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    PageRuleImpl pageRuleImpl = mock(PageRuleImpl.class);
    when(pageRuleImpl.getMatchRule()).thenReturn("Match Rule");

    HashMap<String, PageRule> pageMatchRules = new HashMap<>();
    pageMatchRules.put("42", new PageRuleImpl());
    pageMatchRules.putAll(new HashMap<>());
    pageMatchRules.put("foo", pageRuleImpl);

    PageImpl page = new PageImpl();
    page.setPageMatchRules(pageMatchRules);

    // Act
    String actualBuildRuleExpressionResult = pageServiceUtility.buildRuleExpression(page);

    // Assert
    verify(pageRuleImpl).getMatchRule();
    assertEquals("Match Rule && null", actualBuildRuleExpressionResult);
  }

  /**
   * Test {@link PageServiceUtility#buildRuleExpression(Page)}.
   *
   * <ul>
   *   <li>Given {@link PageServiceUtility} (default constructor).
   *   <li>When {@link PageImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildRuleExpression(Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceUtility.buildRuleExpression(Page)"})
  public void testBuildRuleExpression_givenPageServiceUtility_whenPageImpl_thenReturnNull() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    // Act and Assert
    assertNull(pageServiceUtility.buildRuleExpression(new PageImpl()));
  }

  /**
   * Test {@link PageServiceUtility#buildRuleExpression(Page)}.
   *
   * <ul>
   *   <li>Then return {@code Match Rule}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildRuleExpression(Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageServiceUtility.buildRuleExpression(Page)"})
  public void testBuildRuleExpression_thenReturnMatchRule() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    PageRuleImpl pageRuleImpl = mock(PageRuleImpl.class);
    when(pageRuleImpl.getMatchRule()).thenReturn("Match Rule");

    HashMap<String, PageRule> pageMatchRules = new HashMap<>();
    pageMatchRules.put("foo", pageRuleImpl);

    PageImpl page = new PageImpl();
    page.setPageMatchRules(pageMatchRules);

    // Act
    String actualBuildRuleExpressionResult = pageServiceUtility.buildRuleExpression(page);

    // Assert
    verify(pageRuleImpl).getMatchRule();
    assertEquals("Match Rule", actualBuildRuleExpressionResult);
  }

  /**
   * Test {@link PageServiceUtility#buildItemCriteriaDTOList(Page)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildItemCriteriaDTOList(Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageServiceUtility.buildItemCriteriaDTOList(Page)"})
  public void testBuildItemCriteriaDTOList_thenReturnSizeIsOne() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    LinkedHashSet<PageItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new PageItemCriteriaImpl());

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageFields(new HashMap<>());
    page.setPageMatchRules(new HashMap<>());
    page.setPageTemplate(new PageTemplateImpl());
    page.setPriority(1);
    page.setQualifyingItemCriteria(qualifyingItemCriteria);

    // Act
    List<ItemCriteriaDTO> actualBuildItemCriteriaDTOListResult =
        pageServiceUtility.buildItemCriteriaDTOList(page);

    // Assert
    assertEquals(1, actualBuildItemCriteriaDTOListResult.size());
    ItemCriteriaDTO getResult = actualBuildItemCriteriaDTOListResult.get(0);
    assertNull(getResult.getQty());
    ItemCriteriaDTO clone = getResult.getClone();
    assertNull(clone.getQty());
    ItemCriteriaDTO clone2 = clone.getClone();
    assertNull(clone2.getQty());
    ItemCriteriaDTO clone3 = clone2.getClone();
    assertNull(clone3.getQty());
    ItemCriteriaDTO clone4 = clone3.getClone();
    assertNull(clone4.getQty());
    assertNull(getResult.getMatchRule());
    assertNull(clone.getMatchRule());
    assertNull(clone2.getMatchRule());
    assertNull(clone3.getMatchRule());
    assertNull(clone4.getMatchRule());
  }

  /**
   * Test {@link PageServiceUtility#buildItemCriteriaDTOList(Page)}.
   *
   * <ul>
   *   <li>When {@link PageImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#buildItemCriteriaDTOList(Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageServiceUtility.buildItemCriteriaDTOList(Page)"})
  public void testBuildItemCriteriaDTOList_whenPageImpl_thenReturnEmpty() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    // Act and Assert
    assertTrue(pageServiceUtility.buildItemCriteriaDTOList(new PageImpl()).isEmpty());
  }

  /**
   * Test {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}.
   *
   * <ul>
   *   <li>Given {@link BiFunction} {@link BiFunction#apply(Object, Object)} return forty-two.
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.hydrateForeignLookups(PageDTO)"})
  public void testHydrateForeignLookups_givenBiFunctionApplyReturnFortyTwo_thenCallsApply() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    BiFunction<String, Object, Object> biFunction = mock(BiFunction.class);
    when(biFunction.apply(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(42);

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("", "42");
    stringObjectMap.replaceAll(biFunction);
    stringObjectMap.put("foo", "42");

    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getForeignPageFields()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(stringObjectMap);

    // Act
    PageDTO actualHydrateForeignLookupsResult = pageServiceUtility.hydrateForeignLookups(page);

    // Assert
    verify(biFunction).apply(eq(""), isA(Object.class));
    verify(page).getForeignPageFields();
    verify(page).getPageFields();
    assertSame(page, actualHydrateForeignLookupsResult);
  }

  /**
   * Test {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}.
   *
   * <ul>
   *   <li>Given {@link PageServiceUtility} (default constructor).
   *   <li>Then return {@link NullPageDTO}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.hydrateForeignLookups(PageDTO)"})
  public void testHydrateForeignLookups_givenPageServiceUtility_thenReturnNullPageDTO() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getForeignPageFields()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(new HashMap<>());

    // Act
    PageDTO actualHydrateForeignLookupsResult = pageServiceUtility.hydrateForeignLookups(page);

    // Assert
    verify(page).getForeignPageFields();
    verify(page).getPageFields();
    assertSame(page, actualHydrateForeignLookupsResult);
  }

  /**
   * Test {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}.
   *
   * <ul>
   *   <li>Given {@link PageServiceUtility} (default constructor).
   *   <li>Then return {@link NullPageDTO}.
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.hydrateForeignLookups(PageDTO)"})
  public void testHydrateForeignLookups_givenPageServiceUtility_thenReturnNullPageDTO2() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("foo", "42");

    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getForeignPageFields()).thenReturn(new HashMap<>());
    when(page.getPageFields()).thenReturn(stringObjectMap);

    // Act
    PageDTO actualHydrateForeignLookupsResult = pageServiceUtility.hydrateForeignLookups(page);

    // Assert
    verify(page).getForeignPageFields();
    verify(page).getPageFields();
    assertSame(page, actualHydrateForeignLookupsResult);
  }

  /**
   * Test {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}.
   *
   * <ul>
   *   <li>Given {@link PageServiceUtility} (default constructor).
   *   <li>When {@link PageDTO} (default constructor).
   *   <li>Then return {@link PageDTO} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageServiceUtility#hydrateForeignLookups(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageDTO PageServiceUtility.hydrateForeignLookups(PageDTO)"})
  public void testHydrateForeignLookups_givenPageServiceUtility_whenPageDTO_thenReturnPageDTO() {
    // Arrange
    PageServiceUtility pageServiceUtility = new PageServiceUtility();
    PageDTO page = new PageDTO();

    // Act
    PageDTO actualHydrateForeignLookupsResult = pageServiceUtility.hydrateForeignLookups(page);

    // Assert
    assertSame(page, actualHydrateForeignLookupsResult);
  }
}
