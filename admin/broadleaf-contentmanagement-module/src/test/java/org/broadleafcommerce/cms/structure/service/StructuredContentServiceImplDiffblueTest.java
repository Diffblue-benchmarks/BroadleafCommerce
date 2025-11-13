package org.broadleafcommerce.cms.structure.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import javax.cache.Cache;
import javax.cache.CacheManager;
import org.broadleafcommerce.cms.structure.dao.StructuredContentDao;
import org.broadleafcommerce.cms.structure.domain.StructuredContent;
import org.broadleafcommerce.cms.structure.domain.StructuredContentField;
import org.broadleafcommerce.cms.structure.domain.StructuredContentFieldImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentFieldTemplateImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentFieldXref;
import org.broadleafcommerce.cms.structure.domain.StructuredContentFieldXrefImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentItemCriteria;
import org.broadleafcommerce.cms.structure.domain.StructuredContentItemCriteriaImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentRule;
import org.broadleafcommerce.cms.structure.domain.StructuredContentRuleImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentType;
import org.broadleafcommerce.cms.structure.domain.StructuredContentTypeImpl;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.file.service.StaticAssetPathService;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.rule.RuleProcessor;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.broadleafcommerce.common.structure.dto.StructuredContentDTO;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.RowCountProjection;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.transform.PassThroughResultTransformer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class StructuredContentServiceImplDiffblueTest {
  @Mock private CacheManager cacheManager;

  @Mock private EntityConfiguration entityConfiguration;

  @Mock private List<RuleProcessor<StructuredContentDTO>> list;

  @Mock private LocaleService localeService;

  @Mock private StaticAssetPathService staticAssetPathService;

  @Mock private StructuredContentDao structuredContentDao;

  @Mock private StructuredContentServiceExtensionManager structuredContentServiceExtensionManager;

  @InjectMocks private StructuredContentServiceImpl structuredContentServiceImpl;

  /**
   * Test {@link StructuredContentServiceImpl#findStructuredContentById(Long)}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#findStructuredContentById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StructuredContent StructuredContentServiceImpl.findStructuredContentById(Long)"
  })
  public void testFindStructuredContentById() {
    // Arrange
    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    when(structuredContentDao.findStructuredContentById(Mockito.<Long>any()))
        .thenReturn(structuredContentImpl);

    // Act
    StructuredContent actualFindStructuredContentByIdResult =
        structuredContentServiceImpl.findStructuredContentById(1L);

    // Assert
    verify(structuredContentDao).findStructuredContentById(1L);
    assertSame(structuredContentImpl, actualFindStructuredContentByIdResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#findStructuredContentTypeById(Long)}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#findStructuredContentTypeById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StructuredContentType StructuredContentServiceImpl.findStructuredContentTypeById(Long)"
  })
  public void testFindStructuredContentTypeById() {
    // Arrange
    StructuredContentTypeImpl structuredContentTypeImpl = new StructuredContentTypeImpl();
    when(structuredContentDao.findStructuredContentTypeById(Mockito.<Long>any()))
        .thenReturn(structuredContentTypeImpl);

    // Act
    StructuredContentType actualFindStructuredContentTypeByIdResult =
        structuredContentServiceImpl.findStructuredContentTypeById(1L);

    // Assert
    verify(structuredContentDao).findStructuredContentTypeById(1L);
    assertSame(structuredContentTypeImpl, actualFindStructuredContentTypeByIdResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#findStructuredContentTypeByName(String)}.
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#findStructuredContentTypeByName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StructuredContentType StructuredContentServiceImpl.findStructuredContentTypeByName(String)"
  })
  public void testFindStructuredContentTypeByName() {
    // Arrange
    StructuredContentTypeImpl structuredContentTypeImpl = new StructuredContentTypeImpl();
    when(structuredContentDao.findStructuredContentTypeByName(Mockito.<String>any()))
        .thenReturn(structuredContentTypeImpl);

    // Act
    StructuredContentType actualFindStructuredContentTypeByNameResult =
        structuredContentServiceImpl.findStructuredContentTypeByName("Name");

    // Assert
    verify(structuredContentDao).findStructuredContentTypeByName("Name");
    assertSame(structuredContentTypeImpl, actualFindStructuredContentTypeByNameResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#retrieveAllStructuredContentTypes()}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#retrieveAllStructuredContentTypes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentServiceImpl.retrieveAllStructuredContentTypes()"})
  public void testRetrieveAllStructuredContentTypes() {
    // Arrange
    when(structuredContentDao.retrieveAllStructuredContentTypes()).thenReturn(new ArrayList<>());

    // Act
    List<StructuredContentType> actualRetrieveAllStructuredContentTypesResult =
        structuredContentServiceImpl.retrieveAllStructuredContentTypes();

    // Assert
    verify(structuredContentDao).retrieveAllStructuredContentTypes();
    assertTrue(actualRetrieveAllStructuredContentTypesResult.isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#findContentItems(Criteria)}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentServiceImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#findContentItems(Criteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentServiceImpl.findContentItems(Criteria)"})
  public void testFindContentItems_givenStructuredContentServiceImpl_thenReturnEmpty() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    SessionDelegatorBaseImpl session = mock(SessionDelegatorBaseImpl.class);
    when(session.list(Mockito.<Criteria>any())).thenReturn(new ArrayList<>());
    CriteriaImpl c = new CriteriaImpl("Entity Or Class Name", session);

    // Act
    List<StructuredContent> actualFindContentItemsResult =
        structuredContentServiceImpl.findContentItems(c);

    // Assert
    verify(session).list(isA(Criteria.class));
    assertTrue(actualFindContentItemsResult.isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#findAllContentItems()}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#findAllContentItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentServiceImpl.findAllContentItems()"})
  public void testFindAllContentItems() {
    // Arrange
    when(structuredContentDao.findAllContentItems()).thenReturn(new ArrayList<>());

    // Act
    List<StructuredContent> actualFindAllContentItemsResult =
        structuredContentServiceImpl.findAllContentItems();

    // Assert
    verify(structuredContentDao).findAllContentItems();
    assertTrue(actualFindAllContentItemsResult.isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#countContentItems(Criteria)}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#countContentItems(Criteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long StructuredContentServiceImpl.countContentItems(Criteria)"})
  public void testCountContentItems() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    SessionDelegatorBaseImpl session = mock(SessionDelegatorBaseImpl.class);
    when(session.list(Mockito.<Criteria>any())).thenReturn(new ArrayList<>());
    CriteriaImpl c = new CriteriaImpl("Entity Or Class Name", session);

    // Act
    Long actualCountContentItemsResult = structuredContentServiceImpl.countContentItems(c);

    // Assert
    verify(session).list(isA(Criteria.class));
    Projection projection = c.getProjection();
    assertTrue(projection instanceof RowCountProjection);
    assertTrue(c.getResultTransformer() instanceof PassThroughResultTransformer);
    assertNull(actualCountContentItemsResult);
    assertFalse(projection.isGrouped());
    Criteria actualProjectionCriteria = c.getProjectionCriteria();
    assertSame(c, actualProjectionCriteria);
    assertArrayEquals(new String[] {null}, projection.getAliases());
  }

  /**
   * Test {@link StructuredContentServiceImpl#saveStructuredContentType(StructuredContentType)}.
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#saveStructuredContentType(StructuredContentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StructuredContentType StructuredContentServiceImpl.saveStructuredContentType(StructuredContentType)"
  })
  public void testSaveStructuredContentType() {
    // Arrange
    StructuredContentTypeImpl structuredContentTypeImpl = new StructuredContentTypeImpl();
    when(structuredContentDao.saveStructuredContentType(Mockito.<StructuredContentType>any()))
        .thenReturn(structuredContentTypeImpl);

    // Act
    StructuredContentType actualSaveStructuredContentTypeResult =
        structuredContentServiceImpl.saveStructuredContentType(new StructuredContentTypeImpl());

    // Assert
    verify(structuredContentDao).saveStructuredContentType(isA(StructuredContentType.class));
    assertSame(structuredContentTypeImpl, actualSaveStructuredContentTypeResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.buildStructuredContentDTOList(List, boolean)"
  })
  public void testBuildStructuredContentDTOList() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());
    when(entityConfiguration.createEntityInstance(
            Mockito.<String>any(), eq(StructuredContentDTO.class)))
        .thenReturn(structuredContentDTO);
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");

    HashMap<String, StructuredContentRule> structuredContentMatchRules = new HashMap<>();
    structuredContentMatchRules.put("contentName", new StructuredContentRuleImpl());

    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setContentName("Not all who wander are lost");
    structuredContentImpl.setFieldValues(new HashMap<>());
    structuredContentImpl.setId(1L);
    structuredContentImpl.setOfflineFlag(true);
    structuredContentImpl.setPriority(1);
    structuredContentImpl.setStructuredContentType(new StructuredContentTypeImpl());
    structuredContentImpl.setLocale(new LocaleImpl());
    structuredContentImpl.setQualifyingItemCriteria(new HashSet<>());
    structuredContentImpl.setStructuredContentMatchRules(structuredContentMatchRules);
    structuredContentImpl.setStructuredContentFieldXrefs(new HashMap<>());

    ArrayList<StructuredContent> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentImpl);

    // Act
    List<StructuredContentDTO> actualBuildStructuredContentDTOListResult =
        structuredContentServiceImpl.buildStructuredContentDTOList(structuredContentList, true);

    // Assert
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.structure.dto.StructuredContentDTO"),
            isA(Class.class));
    assertEquals(1, actualBuildStructuredContentDTOListResult.size());
    StructuredContentDTO getResult = actualBuildStructuredContentDTOListResult.get(0);
    Map<String, Object> values = getResult.getValues();
    assertEquals(5, values.size());
    assertNull(values.get("localeCode"));
    StructuredContentDTO clone = getResult.getClone();
    Map<String, Object> values2 = clone.getValues();
    assertEquals(5, values2.size());
    assertNull(values2.get("localeCode"));
    StructuredContentDTO clone2 = clone.getClone();
    Map<String, Object> values3 = clone2.getValues();
    assertEquals(5, values3.size());
    assertNull(values3.get("localeCode"));
    assertNull(getResult.getLocaleCode());
    assertNull(clone.getLocaleCode());
    assertNull(clone2.getLocaleCode());
    StructuredContentDTO clone3 = clone2.getClone();
    assertNull(clone3.getLocaleCode());
    Map<String, Object> values4 = clone3.getValues();
    assertEquals(5, values4.size());
    assertTrue(values.containsKey("contentType"));
    assertTrue(values.containsKey("id"));
    assertTrue(values.containsKey("priority"));
    assertTrue(values2.containsKey("id"));
    assertTrue(values2.containsKey("priority"));
    assertTrue(values3.containsKey("id"));
    assertTrue(values3.containsKey("priority"));
    assertTrue(values4.containsKey("id"));
    assertTrue(values4.containsKey("localeCode"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.buildStructuredContentDTOList(List, boolean)"
  })
  public void testBuildStructuredContentDTOList_thenReturnEmpty() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertTrue(
        structuredContentServiceImpl
            .buildStructuredContentDTOList(new ArrayList<>(), true)
            .isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}.
   *
   * <ul>
   *   <li>Then return first Values size is five.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.buildStructuredContentDTOList(List, boolean)"
  })
  public void testBuildStructuredContentDTOList_thenReturnFirstValuesSizeIsFive() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());
    when(entityConfiguration.createEntityInstance(
            Mockito.<String>any(), eq(StructuredContentDTO.class)))
        .thenReturn(structuredContentDTO);
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");

    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setContentName("Not all who wander are lost");
    structuredContentImpl.setFieldValues(new HashMap<>());
    structuredContentImpl.setId(1L);
    structuredContentImpl.setOfflineFlag(true);
    structuredContentImpl.setPriority(1);
    structuredContentImpl.setStructuredContentType(new StructuredContentTypeImpl());
    structuredContentImpl.setLocale(new LocaleImpl());
    structuredContentImpl.setQualifyingItemCriteria(new HashSet<>());
    structuredContentImpl.setStructuredContentMatchRules(new HashMap<>());
    structuredContentImpl.setStructuredContentFieldXrefs(new HashMap<>());

    ArrayList<StructuredContent> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentImpl);

    // Act
    List<StructuredContentDTO> actualBuildStructuredContentDTOListResult =
        structuredContentServiceImpl.buildStructuredContentDTOList(structuredContentList, true);

    // Assert
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.structure.dto.StructuredContentDTO"),
            isA(Class.class));
    assertEquals(1, actualBuildStructuredContentDTOListResult.size());
    StructuredContentDTO getResult = actualBuildStructuredContentDTOListResult.get(0);
    Map<String, Object> values = getResult.getValues();
    assertEquals(5, values.size());
    assertNull(values.get("localeCode"));
    StructuredContentDTO clone = getResult.getClone();
    Map<String, Object> values2 = clone.getValues();
    assertEquals(5, values2.size());
    assertNull(values2.get("localeCode"));
    StructuredContentDTO clone2 = clone.getClone();
    Map<String, Object> values3 = clone2.getValues();
    assertEquals(5, values3.size());
    assertNull(values3.get("localeCode"));
    assertNull(getResult.getLocaleCode());
    assertNull(clone.getLocaleCode());
    assertNull(clone2.getLocaleCode());
    StructuredContentDTO clone3 = clone2.getClone();
    assertNull(clone3.getLocaleCode());
    Map<String, Object> values4 = clone3.getValues();
    assertEquals(5, values4.size());
    assertTrue(values.containsKey("contentType"));
    assertTrue(values.containsKey("id"));
    assertTrue(values.containsKey("priority"));
    assertTrue(values2.containsKey("id"));
    assertTrue(values2.containsKey("priority"));
    assertTrue(values3.containsKey("id"));
    assertTrue(values3.containsKey("priority"));
    assertTrue(values4.containsKey("id"));
    assertTrue(values4.containsKey("localeCode"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}.
   *
   * <ul>
   *   <li>Then return first Values size is four.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.buildStructuredContentDTOList(List, boolean)"
  })
  public void testBuildStructuredContentDTOList_thenReturnFirstValuesSizeIsFour() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());
    when(entityConfiguration.createEntityInstance(
            Mockito.<String>any(), eq(StructuredContentDTO.class)))
        .thenReturn(structuredContentDTO);
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");

    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    structuredContentImpl.setContentName("Not all who wander are lost");
    structuredContentImpl.setFieldValues(new HashMap<>());
    structuredContentImpl.setId(1L);
    structuredContentImpl.setOfflineFlag(true);
    structuredContentImpl.setPriority(1);
    structuredContentImpl.setStructuredContentType(new StructuredContentTypeImpl());
    structuredContentImpl.setLocale(null);
    structuredContentImpl.setQualifyingItemCriteria(new HashSet<>());
    structuredContentImpl.setStructuredContentMatchRules(new HashMap<>());
    structuredContentImpl.setStructuredContentFieldXrefs(new HashMap<>());

    ArrayList<StructuredContent> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentImpl);

    // Act
    List<StructuredContentDTO> actualBuildStructuredContentDTOListResult =
        structuredContentServiceImpl.buildStructuredContentDTOList(structuredContentList, true);

    // Assert
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.structure.dto.StructuredContentDTO"),
            isA(Class.class));
    assertEquals(1, actualBuildStructuredContentDTOListResult.size());
    StructuredContentDTO getResult = actualBuildStructuredContentDTOListResult.get(0);
    Map<String, Object> values = getResult.getValues();
    assertEquals(4, values.size());
    assertEquals("Not all who wander are lost", values.get("contentName"));
    assertEquals("en", getResult.getLocaleCode());
    StructuredContentDTO clone = getResult.getClone();
    assertEquals("en", clone.getLocaleCode());
    StructuredContentDTO clone2 = clone.getClone();
    assertEquals("en", clone2.getLocaleCode());
    StructuredContentDTO clone3 = clone2.getClone();
    assertEquals("en", clone3.getLocaleCode());
    Map<String, Object> values2 = clone.getValues();
    assertEquals(4, values2.size());
    assertNull(values2.get("contentType"));
    Map<String, Object> values3 = clone2.getValues();
    assertEquals(4, values3.size());
    assertNull(values3.get("contentType"));
    Map<String, Object> values4 = clone3.getValues();
    assertEquals(4, values4.size());
    assertTrue(values.containsKey("contentType"));
    assertTrue(values.containsKey("id"));
    assertTrue(values.containsKey("priority"));
    assertTrue(values2.containsKey("id"));
    assertTrue(values2.containsKey("priority"));
    assertTrue(values3.containsKey("id"));
    assertTrue(values3.containsKey("priority"));
    assertTrue(values4.containsKey("id"));
    assertTrue(values4.containsKey("priority"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List,
   * int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.evaluateAndPriortizeContent(List, int, Map)"
  })
  public void testEvaluateAndPriortizeContent() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(new ArrayList<>());

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult =
        structuredContentServiceImpl.evaluateAndPriortizeContent(
            structuredContentList, 3, new HashMap<>());

    // Assert
    assertSame(structuredContentList, actualEvaluateAndPriortizeContentResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List,
   * int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.evaluateAndPriortizeContent(List, int, Map)"
  })
  public void testEvaluateAndPriortizeContent2() {
    // Arrange
    ArrayList<RuleProcessor<StructuredContentDTO>> ruleProcessorList = new ArrayList<>();
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    StructuredContentDTO structuredContentDTO2 = new StructuredContentDTO();
    structuredContentDTO2.setContentName("Content Name");
    structuredContentDTO2.setContentType("Not all who wander are lost");
    structuredContentDTO2.setId(2L);
    structuredContentDTO2.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO2.setLocaleCode("Locale Code");
    structuredContentDTO2.setPriority(0);
    structuredContentDTO2.setRuleExpression("42");
    structuredContentDTO2.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO2);
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult =
        structuredContentServiceImpl.evaluateAndPriortizeContent(
            structuredContentList, 3, new HashMap<>());

    // Assert
    verify(list, atLeast(1)).iterator();
    verify(structuredContentServiceExtensionManager).getProxy();
    assertEquals(structuredContentList, actualEvaluateAndPriortizeContentResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List,
   * int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.evaluateAndPriortizeContent(List, int, Map)"
  })
  public void testEvaluateAndPriortizeContent_givenStructuredContentServiceImpl() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult =
        structuredContentServiceImpl.evaluateAndPriortizeContent(
            structuredContentList, 3, new HashMap<>());

    // Assert
    assertSame(structuredContentList, actualEvaluateAndPriortizeContentResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleProcessor#checkForMatch(Object, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List,
   * int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.evaluateAndPriortizeContent(List, int, Map)"
  })
  public void testEvaluateAndPriortizeContent_thenCallsCheckForMatch() {
    // Arrange
    RuleProcessor<StructuredContentDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(
            Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();
    contentRuleProcessors.add(ruleProcessor);

    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(contentRuleProcessors);

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult =
        structuredContentServiceImpl.evaluateAndPriortizeContent(
            structuredContentList, 3, new HashMap<>());

    // Assert
    verify(ruleProcessor).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    assertSame(structuredContentList, actualEvaluateAndPriortizeContentResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List,
   * int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.evaluateAndPriortizeContent(List, int, Map)"
  })
  public void testEvaluateAndPriortizeContent_thenReturnSizeIsTwo() {
    // Arrange
    RuleProcessor<StructuredContentDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(
            Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    RuleProcessor<StructuredContentDTO> ruleProcessor2 = mock(RuleProcessor.class);
    when(ruleProcessor2.checkForMatch(
            Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<StructuredContentDTO>> ruleProcessorList = new ArrayList<>();
    ruleProcessorList.add(ruleProcessor2);
    ruleProcessorList.add(ruleProcessor);
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    StructuredContentDTO structuredContentDTO2 = new StructuredContentDTO();
    structuredContentDTO2.setContentName("Not all who wander are lost");
    structuredContentDTO2.setContentType("text/plain");
    structuredContentDTO2.setId(1L);
    structuredContentDTO2.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO2.setLocaleCode("en");
    structuredContentDTO2.setPriority(1);
    structuredContentDTO2.setRuleExpression("Rule Expression");
    structuredContentDTO2.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO2);
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult =
        structuredContentServiceImpl.evaluateAndPriortizeContent(
            structuredContentList, 3, new HashMap<>());

    // Assert
    verify(list, atLeast(1)).iterator();
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(ruleProcessor2).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    verify(ruleProcessor).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    assertEquals(2, actualEvaluateAndPriortizeContentResult.size());
  }

  /**
   * Test {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List,
   * int, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.evaluateAndPriortizeContent(List, int, Map)"
  })
  public void testEvaluateAndPriortizeContent_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult =
        structuredContentServiceImpl.evaluateAndPriortizeContent(
            structuredContentList, 3, new HashMap<>());

    // Assert
    verify(structuredContentServiceExtensionManager).getProxy();
    assertTrue(actualEvaluateAndPriortizeContentResult.isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#processUnprioritizedContent(List,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentServiceImpl.processUnprioritizedContent(List, Map)"})
  public void testProcessUnprioritizedContent() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(new ArrayList<>());

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualProcessUnprioritizedContentResult =
        structuredContentServiceImpl.processUnprioritizedContent(
            structuredContentList, new HashMap<>());

    // Assert
    assertEquals(1, actualProcessUnprioritizedContentResult.size());
    StructuredContentDTO getResult = actualProcessUnprioritizedContentResult.get(0);
    assertEquals("Not all who wander are lost", getResult.getContentName());
    StructuredContentDTO clone = getResult.getClone();
    assertEquals("Not all who wander are lost", clone.getContentName());
    assertEquals("Rule Expression", getResult.getRuleExpression());
    assertEquals("Rule Expression", clone.getRuleExpression());
    assertEquals("en", getResult.getLocaleCode());
    assertEquals("en", clone.getLocaleCode());
    assertEquals("text/plain", getResult.getContentType());
    assertEquals("text/plain", clone.getContentType());
    assertEquals(1, getResult.getPriority().intValue());
    assertEquals(1, clone.getPriority().intValue());
    assertEquals(1L, getResult.getId().longValue());
    assertEquals(1L, clone.getId().longValue());
  }

  /**
   * Test {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#processUnprioritizedContent(List,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentServiceImpl.processUnprioritizedContent(List, Map)"})
  public void testProcessUnprioritizedContent2() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(null);

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualProcessUnprioritizedContentResult =
        structuredContentServiceImpl.processUnprioritizedContent(
            structuredContentList, new HashMap<>());

    // Assert
    assertEquals(1, actualProcessUnprioritizedContentResult.size());
    StructuredContentDTO getResult = actualProcessUnprioritizedContentResult.get(0);
    assertEquals("Not all who wander are lost", getResult.getContentName());
    StructuredContentDTO clone = getResult.getClone();
    assertEquals("Not all who wander are lost", clone.getContentName());
    assertEquals("Rule Expression", getResult.getRuleExpression());
    assertEquals("Rule Expression", clone.getRuleExpression());
    assertEquals("en", getResult.getLocaleCode());
    assertEquals("en", clone.getLocaleCode());
    assertEquals("text/plain", getResult.getContentType());
    assertEquals("text/plain", clone.getContentType());
    assertEquals(1, getResult.getPriority().intValue());
    assertEquals(1, clone.getPriority().intValue());
    assertEquals(1L, getResult.getId().longValue());
    assertEquals(1L, clone.getId().longValue());
  }

  /**
   * Test {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleProcessor#checkForMatch(Object, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#processUnprioritizedContent(List,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentServiceImpl.processUnprioritizedContent(List, Map)"})
  public void testProcessUnprioritizedContent_thenCallsCheckForMatch() {
    // Arrange
    RuleProcessor<StructuredContentDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(
            Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();
    contentRuleProcessors.add(ruleProcessor);

    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(contentRuleProcessors);

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualProcessUnprioritizedContentResult =
        structuredContentServiceImpl.processUnprioritizedContent(
            structuredContentList, new HashMap<>());

    // Assert
    verify(ruleProcessor).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    assertEquals(1, actualProcessUnprioritizedContentResult.size());
    StructuredContentDTO getResult = actualProcessUnprioritizedContentResult.get(0);
    assertEquals("Not all who wander are lost", getResult.getContentName());
    StructuredContentDTO clone = getResult.getClone();
    assertEquals("Not all who wander are lost", clone.getContentName());
    assertEquals("Rule Expression", getResult.getRuleExpression());
    assertEquals("Rule Expression", clone.getRuleExpression());
    assertEquals("en", getResult.getLocaleCode());
    assertEquals("en", clone.getLocaleCode());
    assertEquals("text/plain", getResult.getContentType());
    assertEquals("text/plain", clone.getContentType());
    assertEquals(1, getResult.getPriority().intValue());
    assertEquals(1, clone.getPriority().intValue());
    assertEquals(1L, getResult.getId().longValue());
    assertEquals(1L, clone.getId().longValue());
  }

  /**
   * Test {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#processUnprioritizedContent(List,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentServiceImpl.processUnprioritizedContent(List, Map)"})
  public void testProcessUnprioritizedContent_thenReturnSizeIsTwo() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    StructuredContentDTO structuredContentDTO2 = new StructuredContentDTO();
    structuredContentDTO2.setContentName("Content Name");
    structuredContentDTO2.setContentType("Not all who wander are lost");
    structuredContentDTO2.setId(2L);
    structuredContentDTO2.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO2.setLocaleCode("Locale Code");
    structuredContentDTO2.setPriority(-1);
    structuredContentDTO2.setRuleExpression("42");
    structuredContentDTO2.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO2);
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualProcessUnprioritizedContentResult =
        structuredContentServiceImpl.processUnprioritizedContent(
            structuredContentList, new HashMap<>());

    // Assert
    assertEquals(2, actualProcessUnprioritizedContentResult.size());
    StructuredContentDTO getResult = actualProcessUnprioritizedContentResult.get(0);
    assertEquals("42", getResult.getRuleExpression());
    assertEquals("Content Name", getResult.getContentName());
    assertEquals("Locale Code", getResult.getLocaleCode());
    assertEquals("Not all who wander are lost", getResult.getContentType());
    assertEquals(-1, getResult.getPriority().intValue());
    assertEquals(2L, getResult.getId().longValue());
    assertSame(structuredContentDTO, actualProcessUnprioritizedContentResult.get(1));
  }

  /**
   * Test {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}.
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentServiceImpl.processContentRules(StructuredContentDTO, Map)"
  })
  public void testProcessContentRules() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(new ArrayList<>());

    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertTrue(structuredContentServiceImpl.processContentRules(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentServiceImpl.processContentRules(StructuredContentDTO, Map)"
  })
  public void testProcessContentRules_givenStructuredContentServiceImpl() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertTrue(structuredContentServiceImpl.processContentRules(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleProcessor#checkForMatch(Object, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentServiceImpl.processContentRules(StructuredContentDTO, Map)"
  })
  public void testProcessContentRules_thenCallsCheckForMatch() {
    // Arrange
    RuleProcessor<StructuredContentDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(
            Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();
    contentRuleProcessors.add(ruleProcessor);

    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(contentRuleProcessors);

    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act
    boolean actualProcessContentRulesResult =
        structuredContentServiceImpl.processContentRules(sc, new HashMap<>());

    // Assert
    verify(ruleProcessor).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    assertTrue(actualProcessContentRulesResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#modifyStructuredContentDtoList(List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#modifyStructuredContentDtoList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentServiceImpl.modifyStructuredContentDtoList(List)"})
  public void testModifyStructuredContentDtoList_thenReturnSizeIsOne() {
    // Arrange
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualModifyStructuredContentDtoListResult =
        structuredContentServiceImpl.modifyStructuredContentDtoList(structuredContentList);

    // Assert
    verify(structuredContentServiceExtensionManager).getProxy();
    assertEquals(1, actualModifyStructuredContentDtoListResult.size());
    StructuredContentDTO getResult = actualModifyStructuredContentDtoListResult.get(0);
    assertEquals("Not all who wander are lost", getResult.getContentName());
    StructuredContentDTO clone = getResult.getClone();
    assertEquals("Not all who wander are lost", clone.getContentName());
    assertEquals("Rule Expression", getResult.getRuleExpression());
    assertEquals("Rule Expression", clone.getRuleExpression());
    assertEquals("en", getResult.getLocaleCode());
    assertEquals("en", clone.getLocaleCode());
    assertEquals("text/plain", getResult.getContentType());
    assertEquals("text/plain", clone.getContentType());
    assertEquals(1, getResult.getPriority().intValue());
    assertEquals(1, clone.getPriority().intValue());
    assertEquals(1L, getResult.getId().longValue());
    assertEquals(1L, clone.getId().longValue());
  }

  /**
   * Test {@link StructuredContentServiceImpl#modifyStructuredContentDtoList(List)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#modifyStructuredContentDtoList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentServiceImpl.modifyStructuredContentDtoList(List)"})
  public void testModifyStructuredContentDtoList_thenReturnSizeIsTwo() {
    // Arrange
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    StructuredContentDTO structuredContentDTO2 = new StructuredContentDTO();
    structuredContentDTO2.setContentName("Content Name");
    structuredContentDTO2.setContentType("Not all who wander are lost");
    structuredContentDTO2.setId(2L);
    structuredContentDTO2.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO2.setLocaleCode("Locale Code");
    structuredContentDTO2.setPriority(0);
    structuredContentDTO2.setRuleExpression("42");
    structuredContentDTO2.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO2);
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualModifyStructuredContentDtoListResult =
        structuredContentServiceImpl.modifyStructuredContentDtoList(structuredContentList);

    // Assert
    verify(structuredContentServiceExtensionManager).getProxy();
    assertEquals(2, actualModifyStructuredContentDtoListResult.size());
    StructuredContentDTO getResult = actualModifyStructuredContentDtoListResult.get(0);
    assertEquals("42", getResult.getRuleExpression());
    assertEquals("Content Name", getResult.getContentName());
    assertEquals("Locale Code", getResult.getLocaleCode());
    assertEquals("Not all who wander are lost", getResult.getContentType());
    assertEquals(0, getResult.getPriority().intValue());
    assertEquals(2L, getResult.getId().longValue());
    assertSame(structuredContentDTO, actualModifyStructuredContentDtoListResult.get(1));
  }

  /**
   * Test {@link StructuredContentServiceImpl#modifyStructuredContentDtoList(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#modifyStructuredContentDtoList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentServiceImpl.modifyStructuredContentDtoList(List)"})
  public void testModifyStructuredContentDtoList_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());

    // Act
    List<StructuredContentDTO> actualModifyStructuredContentDtoListResult =
        structuredContentServiceImpl.modifyStructuredContentDtoList(new ArrayList<>());

    // Assert
    verify(structuredContentServiceExtensionManager).getProxy();
    assertTrue(actualModifyStructuredContentDtoListResult.isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#convertToDtos(List, boolean)}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentServiceImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#convertToDtos(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentServiceImpl.convertToDtos(List, boolean)"})
  public void testConvertToDtos_givenStructuredContentServiceImpl_thenReturnEmpty() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertTrue(structuredContentServiceImpl.convertToDtos(new ArrayList<>(), true).isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentServiceImpl#setContentRuleProcessors(List)}
   *   <li>{@link StructuredContentServiceImpl#getContentRuleProcessors()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.getContentRuleProcessors()",
    "void StructuredContentServiceImpl.setContentRuleProcessors(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();

    // Act
    structuredContentServiceImpl.setContentRuleProcessors(contentRuleProcessors);
    List<RuleProcessor<StructuredContentDTO>> actualContentRuleProcessors =
        structuredContentServiceImpl.getContentRuleProcessors();

    // Assert
    assertTrue(actualContentRuleProcessors.isEmpty());
    assertSame(contentRuleProcessors, actualContentRuleProcessors);
  }

  /**
   * Test {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.removeItemFromCacheByKey(String)"})
  public void testRemoveItemFromCacheByKey_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new StructuredContentServiceImpl().removeItemFromCacheByKey(""));
  }

  /**
   * Test {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.removeItemFromCacheByKey(String)"})
  public void testRemoveItemFromCacheByKey_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new StructuredContentServiceImpl().removeItemFromCacheByKey(null));
  }

  /**
   * Test {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale StructuredContentServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_givenBroadleafCurrencyImpl() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("en_");

    // Act
    Locale actualFindLanguageOnlyLocaleResult =
        structuredContentServiceImpl.findLanguageOnlyLocale(locale);

    // Assert
    verify(localeService).findLocaleByCode("en");
    assertSame(localeImpl, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentServiceImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale StructuredContentServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_givenStructuredContentServiceImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new StructuredContentServiceImpl().findLanguageOnlyLocale(null));
  }

  /**
   * Test {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}.
   *
   * <ul>
   *   <li>Given {@code _}.
   *   <li>Then calls {@link Locale#getLocaleCode()}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale StructuredContentServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_givenUnderscore_thenCallsGetLocaleCode() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("_");

    // Act
    Locale actualFindLanguageOnlyLocaleResult =
        structuredContentServiceImpl.findLanguageOnlyLocale(locale);

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findLocaleByCode(null);
    assertSame(localeImpl, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}.
   *
   * <ul>
   *   <li>Then return {@link Locale}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale StructuredContentServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_thenReturnLocale() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(null);

    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("_");

    // Act
    Locale actualFindLanguageOnlyLocaleResult =
        structuredContentServiceImpl.findLanguageOnlyLocale(locale);

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findLocaleByCode(null);
    assertSame(locale, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}.
   *
   * <ul>
   *   <li>When {@link LocaleImpl} (default constructor).
   *   <li>Then return {@link LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale StructuredContentServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_whenLocaleImpl_thenReturnLocaleImpl() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    // Act
    Locale actualFindLanguageOnlyLocaleResult =
        structuredContentServiceImpl.findLanguageOnlyLocale(new LocaleImpl());

    // Assert
    verify(localeService).findLocaleByCode(null);
    assertSame(localeImpl, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#getStructuredContentCache()}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#getStructuredContentCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache StructuredContentServiceImpl.getStructuredContentCache()"})
  public void testGetStructuredContentCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache actualStructuredContentCache = structuredContentServiceImpl.getStructuredContentCache();

    // Assert
    verify(cacheManager).getCache("cmsStructuredContentCache");
    assertNull(actualStructuredContentCache);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link StructuredContentRuleImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildRuleExpression(StructuredContent)"})
  public void testBuildRuleExpression_givenHashMapFooIsStructuredContentRuleImpl() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    HashMap<String, StructuredContentRule> structuredContentMatchRules = new HashMap<>();
    structuredContentMatchRules.put("foo", new StructuredContentRuleImpl());

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setStructuredContentMatchRules(structuredContentMatchRules);

    // Act and Assert
    assertNull(structuredContentServiceImpl.buildRuleExpression(sc));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   *
   * <ul>
   *   <li>Given {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildRuleExpression(StructuredContent)"})
  public void testBuildRuleExpression_givenNotAllWhoWanderAreLost() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setLocale(new LocaleImpl());
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentType(new StructuredContentTypeImpl());
    sc.setStructuredContentMatchRules(null);

    // Act and Assert
    assertNull(structuredContentServiceImpl.buildRuleExpression(sc));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   *
   * <ul>
   *   <li>Then return {@code Match Rule}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildRuleExpression(StructuredContent)"})
  public void testBuildRuleExpression_thenReturnMatchRule() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentRuleImpl structuredContentRuleImpl = mock(StructuredContentRuleImpl.class);
    when(structuredContentRuleImpl.getMatchRule()).thenReturn("Match Rule");

    HashMap<String, StructuredContentRule> structuredContentMatchRules = new HashMap<>();
    structuredContentMatchRules.put("foo", structuredContentRuleImpl);

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setStructuredContentMatchRules(structuredContentMatchRules);

    // Act
    String actualBuildRuleExpressionResult = structuredContentServiceImpl.buildRuleExpression(sc);

    // Assert
    verify(structuredContentRuleImpl, atLeast(1)).getMatchRule();
    assertEquals("Match Rule", actualBuildRuleExpressionResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   *
   * <ul>
   *   <li>Then return {@code Match Rule && Match Rule}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildRuleExpression(StructuredContent)"})
  public void testBuildRuleExpression_thenReturnMatchRuleMatchRule() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentRuleImpl structuredContentRuleImpl = mock(StructuredContentRuleImpl.class);
    when(structuredContentRuleImpl.getMatchRule()).thenReturn("Match Rule");

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    HashMap<String, StructuredContentRule> structuredContentMatchRules = new HashMap<>();
    structuredContentMatchRules.put("", structuredContentRuleImpl2);
    structuredContentMatchRules.put("foo", structuredContentRuleImpl);

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setStructuredContentMatchRules(structuredContentMatchRules);

    // Act
    String actualBuildRuleExpressionResult = structuredContentServiceImpl.buildRuleExpression(sc);

    // Assert
    verify(structuredContentRuleImpl, atLeast(1)).getMatchRule();
    assertEquals("Match Rule && Match Rule", actualBuildRuleExpressionResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   *
   * <ul>
   *   <li>When {@link StructuredContentImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildRuleExpression(StructuredContent)"})
  public void testBuildRuleExpression_whenStructuredContentImpl_thenReturnNull() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertNull(structuredContentServiceImpl.buildRuleExpression(new StructuredContentImpl()));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}.
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.buildItemCriteriaDTOList(StructuredContent)"
  })
  public void testBuildItemCriteriaDTOList() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setLocale(new LocaleImpl());
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(new StructuredContentTypeImpl());
    sc.setQualifyingItemCriteria(null);

    // Act and Assert
    assertTrue(structuredContentServiceImpl.buildItemCriteriaDTOList(sc).isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.buildItemCriteriaDTOList(StructuredContent)"
  })
  public void testBuildItemCriteriaDTOList_thenReturnSizeIsOne() {
    // Arrange
    ItemCriteriaDTO itemCriteriaDTO = new ItemCriteriaDTO();
    itemCriteriaDTO.setMatchRule("Match Rule");
    itemCriteriaDTO.setQty(1);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(ItemCriteriaDTO.class)))
        .thenReturn(itemCriteriaDTO);

    LinkedHashSet<StructuredContentItemCriteria> qualifyingItemCriteria = new LinkedHashSet<>();
    qualifyingItemCriteria.add(new StructuredContentItemCriteriaImpl());

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setLocale(new LocaleImpl());
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(new StructuredContentTypeImpl());
    sc.setQualifyingItemCriteria(qualifyingItemCriteria);

    // Act
    List<ItemCriteriaDTO> actualBuildItemCriteriaDTOListResult =
        structuredContentServiceImpl.buildItemCriteriaDTOList(sc);

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO"), isA(Class.class));
    assertEquals(1, actualBuildItemCriteriaDTOListResult.size());
    assertSame(itemCriteriaDTO, actualBuildItemCriteriaDTOListResult.get(0));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}.
   *
   * <ul>
   *   <li>When {@link StructuredContentImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructuredContentServiceImpl.buildItemCriteriaDTOList(StructuredContent)"
  })
  public void testBuildItemCriteriaDTOList_whenStructuredContentImpl_thenReturnEmpty() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertTrue(
        structuredContentServiceImpl
            .buildItemCriteriaDTOList(new StructuredContentImpl())
            .isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent,
   * StructuredContentDTO, boolean)}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent,
   * StructuredContentDTO, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentServiceImpl.buildFieldValues(StructuredContent, StructuredContentDTO, boolean)"
  })
  public void testBuildFieldValues() {
    // Arrange
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenThrow(new RuntimeException());
    StructuredContentImpl sc = new StructuredContentImpl();

    StructuredContentDTO scDTO = new StructuredContentDTO();
    scDTO.setContentName("Not all who wander are lost");
    scDTO.setContentType("text/plain");
    scDTO.setId(1L);
    scDTO.setItemCriteriaDTOList(new ArrayList<>());
    scDTO.setLocaleCode("en");
    scDTO.setPriority(1);
    scDTO.setRuleExpression("Rule Expression");
    scDTO.setValues(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> structuredContentServiceImpl.buildFieldValues(sc, scDTO, true));
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent,
   * StructuredContentDTO, boolean)}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent,
   * StructuredContentDTO, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentServiceImpl.buildFieldValues(StructuredContent, StructuredContentDTO, boolean)"
  })
  public void testBuildFieldValues2() {
    // Arrange
    when(structuredContentServiceExtensionManager.getProxy()).thenThrow(new RuntimeException());
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");
    StructuredContentImpl sc = new StructuredContentImpl();

    StructuredContentDTO scDTO = new StructuredContentDTO();
    scDTO.setContentName("Not all who wander are lost");
    scDTO.setContentType("text/plain");
    scDTO.setId(1L);
    scDTO.setItemCriteriaDTOList(new ArrayList<>());
    scDTO.setLocaleCode("en");
    scDTO.setPriority(1);
    scDTO.setRuleExpression("Rule Expression");
    scDTO.setValues(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> structuredContentServiceImpl.buildFieldValues(sc, scDTO, true));
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent,
   * StructuredContentDTO, boolean)}.
   *
   * <ul>
   *   <li>Then {@link StructuredContentDTO} (default constructor) Values {@code foo} is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent,
   * StructuredContentDTO, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentServiceImpl.buildFieldValues(StructuredContent, StructuredContentDTO, boolean)"
  })
  public void testBuildFieldValues_thenStructuredContentDTOValuesFooIs1() {
    // Arrange
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setStructuredContentFieldTemplate(
        new StructuredContentFieldTemplateImpl());

    StructuredContentField scField = mock(StructuredContentField.class);
    when(scField.getValue()).thenReturn("1");
    StructuredContentFieldXrefImpl structuredContentFieldXrefImpl =
        new StructuredContentFieldXrefImpl(new StructuredContentImpl(), scField, "id");

    HashMap<String, StructuredContentFieldXref> structuredContentFields = new HashMap<>();
    structuredContentFields.put("foo", structuredContentFieldXrefImpl);

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setLocale(new LocaleImpl());
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setStructuredContentFieldXrefs(structuredContentFields);

    HashMap<String, Object> values = new HashMap<>();
    values.put("id", "Sc DTO");

    StructuredContentDTO scDTO = new StructuredContentDTO();
    scDTO.setContentName("Not all who wander are lost");
    scDTO.setContentType("text/plain");
    scDTO.setId(1L);
    scDTO.setItemCriteriaDTOList(new ArrayList<>());
    scDTO.setLocaleCode("en");
    scDTO.setPriority(1);
    scDTO.setRuleExpression("Rule Expression");
    scDTO.setValues(values);

    // Act
    structuredContentServiceImpl.buildFieldValues(sc, scDTO, true);

    // Assert
    verify(scField, atLeast(1)).getValue();
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> values2 = scDTO.getValues();
    assertEquals(2, values2.size());
    assertEquals("1", values2.get("foo"));
    assertEquals(1L, ((Long) values2.get("id")).longValue());
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent,
   * StructuredContentDTO, boolean)}.
   *
   * <ul>
   *   <li>Then {@link StructuredContentDTO} (default constructor) Values {@code foo} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent,
   * StructuredContentDTO, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentServiceImpl.buildFieldValues(StructuredContent, StructuredContentDTO, boolean)"
  })
  public void testBuildFieldValues_thenStructuredContentDTOValuesFooIsNull() {
    // Arrange
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setStructuredContentFieldTemplate(
        new StructuredContentFieldTemplateImpl());

    HashMap<String, StructuredContentFieldXref> structuredContentFields = new HashMap<>();
    StructuredContentImpl sc = new StructuredContentImpl();
    StructuredContentFieldXrefImpl structuredContentFieldXrefImpl =
        new StructuredContentFieldXrefImpl(sc, new StructuredContentFieldImpl(), "id");
    structuredContentFields.put("foo", structuredContentFieldXrefImpl);

    StructuredContentImpl sc2 = new StructuredContentImpl();
    sc2.setContentName("Not all who wander are lost");
    sc2.setFieldValues(new HashMap<>());
    sc2.setId(1L);
    sc2.setLocale(new LocaleImpl());
    sc2.setOfflineFlag(true);
    sc2.setPriority(1);
    sc2.setQualifyingItemCriteria(new HashSet<>());
    sc2.setStructuredContentMatchRules(new HashMap<>());
    sc2.setStructuredContentType(structuredContentType);
    sc2.setStructuredContentFieldXrefs(structuredContentFields);

    HashMap<String, Object> values = new HashMap<>();
    values.put("id", "Sc DTO");

    StructuredContentDTO scDTO = new StructuredContentDTO();
    scDTO.setContentName("Not all who wander are lost");
    scDTO.setContentType("text/plain");
    scDTO.setId(1L);
    scDTO.setItemCriteriaDTOList(new ArrayList<>());
    scDTO.setLocaleCode("en");
    scDTO.setPriority(1);
    scDTO.setRuleExpression("Rule Expression");
    scDTO.setValues(values);

    // Act
    structuredContentServiceImpl.buildFieldValues(sc2, scDTO, true);

    // Assert
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> values2 = scDTO.getValues();
    assertEquals(2, values2.size());
    assertNull(values2.get("foo"));
    assertEquals(1L, ((Long) values2.get("id")).longValue());
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent,
   * StructuredContentDTO, boolean)}.
   *
   * <ul>
   *   <li>Then {@link StructuredContentDTO} (default constructor) Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent,
   * StructuredContentDTO, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentServiceImpl.buildFieldValues(StructuredContent, StructuredContentDTO, boolean)"
  })
  public void testBuildFieldValues_thenStructuredContentDTOValuesSizeIsOne() {
    // Arrange
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");
    StructuredContentImpl sc = new StructuredContentImpl();

    StructuredContentDTO scDTO = new StructuredContentDTO();
    scDTO.setContentName("Not all who wander are lost");
    scDTO.setContentType("text/plain");
    scDTO.setId(1L);
    scDTO.setItemCriteriaDTOList(new ArrayList<>());
    scDTO.setLocaleCode("en");
    scDTO.setPriority(1);
    scDTO.setRuleExpression("Rule Expression");
    HashMap<String, Object> values = new HashMap<>();
    scDTO.setValues(values);

    // Act
    structuredContentServiceImpl.buildFieldValues(sc, scDTO, true);

    // Assert
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    Map<String, Object> values2 = scDTO.getValues();
    assertEquals(1, values2.size());
    assertNull(values2.get("id"));
    assertSame(values, values2);
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.hasCmsPrefix(String, String)"})
  public void testHasCmsPrefix_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new StructuredContentServiceImpl().hasCmsPrefix("42", "Cms Prefix"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.hasCmsPrefix(String, String)"})
  public void testHasCmsPrefix_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new StructuredContentServiceImpl().hasCmsPrefix("", "Cms Prefix"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.hasCmsPrefix(String, String)"})
  public void testHasCmsPrefix_whenNotBlank_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new StructuredContentServiceImpl().hasCmsPrefix("not blank", "not blank"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.hasCmsPrefix(String, String)"})
  public void testHasCmsPrefix_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new StructuredContentServiceImpl().hasCmsPrefix("not blank", null));
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.hasCmsPrefix(String, String)"})
  public void testHasCmsPrefix_whenSpace_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new StructuredContentServiceImpl().hasCmsPrefix("not blank", " "));
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.hasCmsPrefix(String, String)"})
  public void testHasCmsPrefix_whenSpace_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(new StructuredContentServiceImpl().hasCmsPrefix(" ", "not blank"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildFieldValueWithCmsPrefix(String,
   * StructuredContentDTO, boolean, String)}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildFieldValueWithCmsPrefix(String,
   * StructuredContentDTO, boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentServiceImpl.buildFieldValueWithCmsPrefix(String, StructuredContentDTO, boolean, String)"
  })
  public void testBuildFieldValueWithCmsPrefix() {
    // Arrange
    when(staticAssetPathService.convertAllAssetPathsInContent(Mockito.<String>any(), anyBoolean()))
        .thenReturn("Not all who wander are lost");

    StructuredContentDTO scDTO = new StructuredContentDTO();
    scDTO.setContentName("Not all who wander are lost");
    scDTO.setContentType("text/plain");
    scDTO.setId(1L);
    scDTO.setItemCriteriaDTOList(new ArrayList<>());
    scDTO.setLocaleCode("en");
    scDTO.setPriority(1);
    scDTO.setRuleExpression("Rule Expression");
    HashMap<String, Object> values = new HashMap<>();
    scDTO.setValues(values);

    // Act
    structuredContentServiceImpl.buildFieldValueWithCmsPrefix("42", scDTO, true, "Field Key");

    // Assert
    verify(staticAssetPathService).convertAllAssetPathsInContent("42", true);
    Map<String, Object> values2 = scDTO.getValues();
    assertEquals(1, values2.size());
    assertEquals("Not all who wander are lost", values2.get("Field Key"));
    assertSame(values, values2);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildStructuredContentDTO(StructuredContent,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>Then return Values size is five.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#buildStructuredContentDTO(StructuredContent, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StructuredContentDTO StructuredContentServiceImpl.buildStructuredContentDTO(StructuredContent, boolean)"
  })
  public void testBuildStructuredContentDTO_givenLocaleImpl_thenReturnValuesSizeIsFive() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());
    when(entityConfiguration.createEntityInstance(
            Mockito.<String>any(), eq(StructuredContentDTO.class)))
        .thenReturn(structuredContentDTO);
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setLocale(new LocaleImpl());
    sc.setStructuredContentType(new StructuredContentTypeImpl());

    // Act
    StructuredContentDTO actualBuildStructuredContentDTOResult =
        structuredContentServiceImpl.buildStructuredContentDTO(sc, true);

    // Assert
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.structure.dto.StructuredContentDTO"),
            isA(Class.class));
    Map<String, Object> values = actualBuildStructuredContentDTOResult.getValues();
    assertEquals(5, values.size());
    assertNull(values.get("localeCode"));
    StructuredContentDTO clone = actualBuildStructuredContentDTOResult.getClone();
    Map<String, Object> values2 = clone.getValues();
    assertEquals(5, values2.size());
    assertNull(values2.get("contentType"));
    assertNull(values2.get("id"));
    assertNull(values2.get("localeCode"));
    assertNull(values2.get("priority"));
    assertNull(actualBuildStructuredContentDTOResult.getLocaleCode());
    assertNull(clone.getLocaleCode());
    StructuredContentDTO clone2 = clone.getClone();
    assertNull(clone2.getLocaleCode());
    Map<String, Object> values3 = clone2.getValues();
    assertEquals(5, values3.size());
    assertTrue(values.containsKey("contentName"));
    assertTrue(values.containsKey("contentType"));
    assertTrue(values.containsKey("id"));
    assertTrue(values.containsKey("priority"));
    assertTrue(values3.containsKey("id"));
    assertTrue(values3.containsKey("localeCode"));
    assertTrue(values3.containsKey("priority"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildStructuredContentDTO(StructuredContent,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return LocaleCode is {@code en}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentServiceImpl#buildStructuredContentDTO(StructuredContent, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StructuredContentDTO StructuredContentServiceImpl.buildStructuredContentDTO(StructuredContent, boolean)"
  })
  public void testBuildStructuredContentDTO_thenReturnLocaleCodeIsEn() {
    // Arrange
    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());
    when(entityConfiguration.createEntityInstance(
            Mockito.<String>any(), eq(StructuredContentDTO.class)))
        .thenReturn(structuredContentDTO);
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix())
        .thenReturn("https://example.org/example");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setStructuredContentType(new StructuredContentTypeImpl());

    // Act
    StructuredContentDTO actualBuildStructuredContentDTOResult =
        structuredContentServiceImpl.buildStructuredContentDTO(sc, true);

    // Assert
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.structure.dto.StructuredContentDTO"),
            isA(Class.class));
    assertEquals("en", actualBuildStructuredContentDTOResult.getLocaleCode());
    StructuredContentDTO clone = actualBuildStructuredContentDTOResult.getClone();
    assertEquals("en", clone.getLocaleCode());
    StructuredContentDTO clone2 = clone.getClone();
    assertEquals("en", clone2.getLocaleCode());
    StructuredContentDTO clone3 = clone2.getClone();
    assertEquals("en", clone3.getLocaleCode());
    StructuredContentDTO clone4 = clone3.getClone();
    assertEquals("en", clone4.getLocaleCode());
    Map<String, Object> values = clone2.getValues();
    assertEquals(4, values.size());
    assertNull(values.get("contentType"));
    Map<String, Object> values2 = clone3.getValues();
    assertEquals(4, values2.size());
    assertNull(values2.get("contentType"));
    Map<String, Object> values3 = actualBuildStructuredContentDTOResult.getValues();
    assertEquals(4, values3.size());
    Map<String, Object> values4 = clone4.getValues();
    assertEquals(4, values4.size());
    assertTrue(values3.containsKey("contentName"));
    assertTrue(values3.containsKey("contentType"));
    assertTrue(values3.containsKey("id"));
    assertTrue(values3.containsKey("priority"));
    assertTrue(values.containsKey("id"));
    assertTrue(values.containsKey("priority"));
    assertTrue(values2.containsKey("id"));
    assertTrue(values2.containsKey("priority"));
    assertTrue(values4.containsKey("id"));
    assertTrue(values4.containsKey("priority"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   * with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}, {@code
   * contentName}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, Long, Locale, String, String)"
  })
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentName() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals(
        "text/plain-Not all who wander are lost-null-null-1",
        structuredContentServiceImpl.buildNameKey(
            currentSandbox, 1L, new LocaleImpl(), "text/plain", "Not all who wander are lost"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   * with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}, {@code
   * contentName}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, Long, Locale, String, String)"
  })
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentName2() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertEquals(
        "text/plain-Not all who wander are lost-null-1",
        structuredContentServiceImpl.buildNameKey(
            new SandBoxImpl(), 1L, null, "text/plain", "Not all who wander are lost"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   * with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}, {@code
   * contentName}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, Long, Locale, String, String)"
  })
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentName3() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals(
        "text/plain-Not all who wander are lost-null-null",
        structuredContentServiceImpl.buildNameKey(
            currentSandbox, null, new LocaleImpl(), "text/plain", "Not all who wander are lost"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   * with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}, {@code
   * contentName}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, Long, Locale, String, String)"
  })
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentName4() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertEquals(
        "text/plain-Not all who wander are lost-null-1",
        structuredContentServiceImpl.buildNameKey(
            null, 1L, new LocaleImpl(), "text/plain", "Not all who wander are lost"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String,
   * Boolean)} with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType},
   * {@code contentName}, {@code secure}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale,
   * String, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, Long, Locale, String, String, Boolean)"
  })
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentNameSecure() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals(
        "text/plain-Not all who wander are lost-null-null-1-true",
        structuredContentServiceImpl.buildNameKey(
            currentSandbox,
            1L,
            new LocaleImpl(),
            "text/plain",
            "Not all who wander are lost",
            true));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String,
   * Boolean)} with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType},
   * {@code contentName}, {@code secure}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale,
   * String, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, Long, Locale, String, String, Boolean)"
  })
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentNameSecure2() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals(
        "text/plain-Not all who wander are lost-null-null-1",
        structuredContentServiceImpl.buildNameKey(
            currentSandbox,
            1L,
            new LocaleImpl(),
            "text/plain",
            "Not all who wander are lost",
            null));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String,
   * Boolean)} with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType},
   * {@code contentName}, {@code secure}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale,
   * String, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, Long, Locale, String, String, Boolean)"
  })
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentNameSecure3() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertEquals(
        "text/plain-Not all who wander are lost-null-1-true",
        structuredContentServiceImpl.buildNameKey(
            new SandBoxImpl(), 1L, null, "text/plain", "Not all who wander are lost", true));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String,
   * Boolean)} with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType},
   * {@code contentName}, {@code secure}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale,
   * String, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, Long, Locale, String, String, Boolean)"
  })
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentNameSecure4() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals(
        "text/plain-Not all who wander are lost-null-null-true",
        structuredContentServiceImpl.buildNameKey(
            currentSandbox,
            null,
            new LocaleImpl(),
            "text/plain",
            "Not all who wander are lost",
            true));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String,
   * Boolean)} with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType},
   * {@code contentName}, {@code secure}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale,
   * String, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, Long, Locale, String, String, Boolean)"
  })
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentNameSecure5() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertEquals(
        "text/plain-Not all who wander are lost-null-1-true",
        structuredContentServiceImpl.buildNameKey(
            null, 1L, new LocaleImpl(), "text/plain", "Not all who wander are lost", true));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   * with {@code sandBox}, {@code sc}, {@code secure}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox,
   * StructuredContent, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent, Boolean)"
  })
  public void testBuildNameKeyWithSandBoxScSecure() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    SandBoxImpl sandBox = new SandBoxImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("_");

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("_");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(locale);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(sandBox, sc, true);

    // Assert
    verify(localeService).findLocaleByCode(null);
    assertEquals("_-Not all who wander are lost-1-null-null-true", actualBuildNameKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   * with {@code sandBox}, {@code sc}, {@code secure}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox,
   * StructuredContent, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent, Boolean)"
  })
  public void testBuildNameKeyWithSandBoxScSecure2() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    SandBoxImpl sandBox = new SandBoxImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("-");

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode(null);

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(locale);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(sandBox, sc, true);

    // Assert
    verify(localeService).findLocaleByCode(null);
    assertEquals("--Not all who wander are lost-1-null-null-true", actualBuildNameKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   * with {@code sandBox}, {@code sc}, {@code secure}.
   *
   * <ul>
   *   <li>Then return {@code Name-Not all who wander are lost-1-null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox,
   * StructuredContent, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent, Boolean)"
  })
  public void testBuildNameKeyWithSandBoxScSecure_thenReturnNameNotAllWhoWanderAreLost1Null() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act and Assert
    assertEquals(
        "Name-Not all who wander are lost-1-null",
        structuredContentServiceImpl.buildNameKey(sandBox, sc, null));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   * with {@code sandBox}, {@code sc}, {@code secure}.
   *
   * <ul>
   *   <li>Then return {@code Name-Not all who wander are lost-1-true}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox,
   * StructuredContent, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent, Boolean)"
  })
  public void testBuildNameKeyWithSandBoxScSecure_thenReturnNameNotAllWhoWanderAreLost1True() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act and Assert
    assertEquals(
        "Name-Not all who wander are lost-1-true",
        structuredContentServiceImpl.buildNameKey(null, sc, true));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   * with {@code sandBox}, {@code sc}, {@code secure}.
   *
   * <ul>
   *   <li>Then return {@code --Not all who wander are lost-1-null-true}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox,
   * StructuredContent, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent, Boolean)"
  })
  public void testBuildNameKeyWithSandBoxScSecure_thenReturnNotAllWhoWanderAreLost1NullTrue() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("-");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act and Assert
    assertEquals(
        "--Not all who wander are lost-1-null-true",
        structuredContentServiceImpl.buildNameKey(sandBox, sc, true));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   * with {@code sandBox}, {@code sc}, {@code secure}.
   *
   * <ul>
   *   <li>Then return {@code _-Not all who wander are lost-1-_-null-true}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox,
   * StructuredContent, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent, Boolean)"
  })
  public void testBuildNameKeyWithSandBoxScSecure_thenReturnNotAllWhoWanderAreLost1NullTrue2() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(null);
    SandBoxImpl sandBox = new SandBoxImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("_");

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("_");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(locale);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(sandBox, sc, true);

    // Assert
    verify(localeService).findLocaleByCode(null);
    assertEquals("_-Not all who wander are lost-1-_-null-true", actualBuildNameKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)} with {@code
   * sandBox}, {@code sc}.
   *
   * <ul>
   *   <li>Then return {@code Name-Not all who wander are lost-1}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox,
   * StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent)"
  })
  public void testBuildNameKeyWithSandBoxSc_thenReturnNameNotAllWhoWanderAreLost1() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act and Assert
    assertEquals(
        "Name-Not all who wander are lost-1", structuredContentServiceImpl.buildNameKey(null, sc));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)} with {@code
   * sandBox}, {@code sc}.
   *
   * <ul>
   *   <li>Then return {@code --Not all who wander are lost-1-null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox,
   * StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent)"
  })
  public void testBuildNameKeyWithSandBoxSc_thenReturnNotAllWhoWanderAreLost1Null() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("-");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act and Assert
    assertEquals(
        "--Not all who wander are lost-1-null",
        structuredContentServiceImpl.buildNameKey(sandBox, sc));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)} with {@code
   * sandBox}, {@code sc}.
   *
   * <ul>
   *   <li>Then return {@code _-Not all who wander are lost-1-_-null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox,
   * StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent)"
  })
  public void testBuildNameKeyWithSandBoxSc_thenReturnNotAllWhoWanderAreLost1Null2() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(null);
    SandBoxImpl sandBox = new SandBoxImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("_");

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("_");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(locale);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(sandBox, sc);

    // Assert
    verify(localeService).findLocaleByCode(null);
    assertEquals("_-Not all who wander are lost-1-_-null", actualBuildNameKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)} with {@code
   * sandBox}, {@code sc}.
   *
   * <ul>
   *   <li>Then return {@code _-Not all who wander are lost-1-null-null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox,
   * StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent)"
  })
  public void testBuildNameKeyWithSandBoxSc_thenReturnNotAllWhoWanderAreLost1NullNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    SandBoxImpl sandBox = new SandBoxImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("_");

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("_");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(locale);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(sandBox, sc);

    // Assert
    verify(localeService).findLocaleByCode(null);
    assertEquals("_-Not all who wander are lost-1-null-null", actualBuildNameKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)} with {@code
   * sandBox}, {@code sc}.
   *
   * <ul>
   *   <li>Then return {@code --Not all who wander are lost-1-null-null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox,
   * StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent)"
  })
  public void testBuildNameKeyWithSandBoxSc_thenReturnNotAllWhoWanderAreLost1NullNull2() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    SandBoxImpl sandBox = new SandBoxImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("-");

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode(null);

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(locale);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(sandBox, sc);

    // Assert
    verify(localeService).findLocaleByCode(null);
    assertEquals("--Not all who wander are lost-1-null-null", actualBuildNameKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)} with
   * {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKey(SandBox, Long, Locale, String)"
  })
  public void testBuildTypeKeyWithCurrentSandboxSiteLocaleContentType() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals(
        "text/plain-null-null-1",
        structuredContentServiceImpl.buildTypeKey(
            currentSandbox, 1L, new LocaleImpl(), "text/plain"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)} with
   * {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}.
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKey(SandBox, Long, Locale, String)"
  })
  public void testBuildTypeKeyWithCurrentSandboxSiteLocaleContentType2() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals(
        "text/plain-null-null",
        structuredContentServiceImpl.buildTypeKey(
            currentSandbox, null, new LocaleImpl(), "text/plain"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)} with
   * {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}.
   *
   * <ul>
   *   <li>Then return {@code text/plain-null-1}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKey(SandBox, Long, Locale, String)"
  })
  public void testBuildTypeKeyWithCurrentSandboxSiteLocaleContentType_thenReturnTextPlainNull1() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertEquals(
        "text/plain-null-1",
        structuredContentServiceImpl.buildTypeKey(new SandBoxImpl(), 1L, null, "text/plain"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)} with
   * {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}.
   *
   * <ul>
   *   <li>Then return {@code text/plain-null-1}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKey(SandBox, Long, Locale, String)"
  })
  public void testBuildTypeKeyWithCurrentSandboxSiteLocaleContentType_thenReturnTextPlainNull12() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertEquals(
        "text/plain-null-1",
        structuredContentServiceImpl.buildTypeKey(null, 1L, new LocaleImpl(), "text/plain"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)} with {@code
   * sandBox}, {@code sc}.
   *
   * <ul>
   *   <li>Then return {@code Name-null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox,
   * StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKey(SandBox, StructuredContent)"
  })
  public void testBuildTypeKeyWithSandBoxSc_thenReturnNameNull() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act and Assert
    assertEquals("Name-null", structuredContentServiceImpl.buildTypeKey(sandBox, sc));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)} with {@code
   * sandBox}, {@code sc}.
   *
   * <ul>
   *   <li>Then return {@code Name-null-null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox,
   * StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKey(SandBox, StructuredContent)"
  })
  public void testBuildTypeKeyWithSandBoxSc_thenReturnNameNullNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    SandBoxImpl sandBox = new SandBoxImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("Name");

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode(null);

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(locale);

    // Act
    String actualBuildTypeKeyResult = structuredContentServiceImpl.buildTypeKey(sandBox, sc);

    // Assert
    verify(localeService).findLocaleByCode(null);
    assertEquals("Name-null-null", actualBuildTypeKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)} with {@code
   * sandBox}, {@code sc}.
   *
   * <ul>
   *   <li>Then return {@code _-_-null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox,
   * StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKey(SandBox, StructuredContent)"
  })
  public void testBuildTypeKeyWithSandBoxSc_thenReturnNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(null);
    SandBoxImpl sandBox = new SandBoxImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("_");

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("_");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(locale);

    // Act
    String actualBuildTypeKeyResult = structuredContentServiceImpl.buildTypeKey(sandBox, sc);

    // Assert
    verify(localeService).findLocaleByCode(null);
    assertEquals("_-_-null", actualBuildTypeKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)} with {@code
   * sandBox}, {@code sc}.
   *
   * <ul>
   *   <li>Then return {@code _-null-null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox,
   * StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKey(SandBox, StructuredContent)"
  })
  public void testBuildTypeKeyWithSandBoxSc_thenReturnNullNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    SandBoxImpl sandBox = new SandBoxImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("_");

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("_");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(locale);

    // Act
    String actualBuildTypeKeyResult = structuredContentServiceImpl.buildTypeKey(sandBox, sc);

    // Assert
    verify(localeService).findLocaleByCode(null);
    assertEquals("_-null-null", actualBuildTypeKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)} with {@code
   * sandBox}, {@code sc}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox,
   * StructuredContent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKey(SandBox, StructuredContent)"
  })
  public void testBuildTypeKeyWithSandBoxSc_whenNull_thenReturnName() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    structuredContentType.setName("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act and Assert
    assertEquals("Name", structuredContentServiceImpl.buildTypeKey(null, sc));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String,
   * Boolean)}.
   *
   * <ul>
   *   <li>Then return {@code text/plain-null-1-true}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long,
   * Locale, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)"
  })
  public void testBuildTypeKeyWithSecure_thenReturnTextPlainNull1True() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertEquals(
        "text/plain-null-1-true",
        structuredContentServiceImpl.buildTypeKeyWithSecure(
            new SandBoxImpl(), 1L, null, "text/plain", true));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String,
   * Boolean)}.
   *
   * <ul>
   *   <li>Then return {@code text/plain-null-1-true}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long,
   * Locale, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)"
  })
  public void testBuildTypeKeyWithSecure_thenReturnTextPlainNull1True2() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertEquals(
        "text/plain-null-1-true",
        structuredContentServiceImpl.buildTypeKeyWithSecure(
            null, 1L, new LocaleImpl(), "text/plain", true));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String,
   * Boolean)}.
   *
   * <ul>
   *   <li>Then return {@code text/plain-null-null-1}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long,
   * Locale, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)"
  })
  public void testBuildTypeKeyWithSecure_thenReturnTextPlainNullNull1() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals(
        "text/plain-null-null-1",
        structuredContentServiceImpl.buildTypeKeyWithSecure(
            currentSandbox, 1L, new LocaleImpl(), "text/plain", null));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String,
   * Boolean)}.
   *
   * <ul>
   *   <li>Then return {@code text/plain-null-null-1-true}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long,
   * Locale, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)"
  })
  public void testBuildTypeKeyWithSecure_thenReturnTextPlainNullNull1True() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals(
        "text/plain-null-null-1-true",
        structuredContentServiceImpl.buildTypeKeyWithSecure(
            currentSandbox, 1L, new LocaleImpl(), "text/plain", true));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String,
   * Boolean)}.
   *
   * <ul>
   *   <li>Then return {@code text/plain-null-null-true}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long,
   * Locale, String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StructuredContentServiceImpl.buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)"
  })
  public void testBuildTypeKeyWithSecure_thenReturnTextPlainNullNullTrue() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals(
        "text/plain-null-null-true",
        structuredContentServiceImpl.buildTypeKeyWithSecure(
            currentSandbox, null, new LocaleImpl(), "text/plain", true));
  }
}
