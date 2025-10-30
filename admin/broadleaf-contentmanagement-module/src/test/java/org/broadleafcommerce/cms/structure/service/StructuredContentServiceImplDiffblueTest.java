/*-
 * #%L
 * BroadleafCommerce CMS Module
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.cms.structure.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.broadleafcommerce.cms.structure.domain.StructuredContentImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentItemCriteria;
import org.broadleafcommerce.cms.structure.domain.StructuredContentItemCriteriaImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentRule;
import org.broadleafcommerce.cms.structure.domain.StructuredContentRuleImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentType;
import org.broadleafcommerce.cms.structure.domain.StructuredContentTypeImpl;
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

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class StructuredContentServiceImplDiffblueTest {
  @Mock
  private StaticAssetPathService staticAssetPathService;

  @InjectMocks
  private StructuredContentServiceImpl structuredContentServiceImpl;

  @Mock
  private StructuredContentServiceExtensionManager structuredContentServiceExtensionManager;

  @Mock
  private EntityConfiguration entityConfiguration;

  @Mock
  private LocaleService localeService;

  @Mock
  private List<RuleProcessor<StructuredContentDTO>> list;

  @Mock
  private StructuredContentDao structuredContentDao;

  @Mock
  private CacheManager cacheManager;

  /**
   * Test {@link StructuredContentServiceImpl#findStructuredContentById(Long)}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#findStructuredContentById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StructuredContent StructuredContentServiceImpl.findStructuredContentById(Long)"})
  public void testFindStructuredContentById() {
    // Arrange
    StructuredContentImpl structuredContentImpl = new StructuredContentImpl();
    when(structuredContentDao.findStructuredContentById(Mockito.<Long>any())).thenReturn(structuredContentImpl);

    // Act
    StructuredContent actualFindStructuredContentByIdResult = structuredContentServiceImpl
        .findStructuredContentById(1L);

    // Assert
    verify(structuredContentDao).findStructuredContentById(eq(1L));
    assertSame(structuredContentImpl, actualFindStructuredContentByIdResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#findStructuredContentTypeById(Long)}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#findStructuredContentTypeById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StructuredContentType StructuredContentServiceImpl.findStructuredContentTypeById(Long)"})
  public void testFindStructuredContentTypeById() {
    // Arrange
    StructuredContentTypeImpl structuredContentTypeImpl = new StructuredContentTypeImpl();
    when(structuredContentDao.findStructuredContentTypeById(Mockito.<Long>any())).thenReturn(structuredContentTypeImpl);

    // Act
    StructuredContentType actualFindStructuredContentTypeByIdResult = structuredContentServiceImpl
        .findStructuredContentTypeById(1L);

    // Assert
    verify(structuredContentDao).findStructuredContentTypeById(eq(1L));
    assertSame(structuredContentTypeImpl, actualFindStructuredContentTypeByIdResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#findStructuredContentTypeByName(String)}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#findStructuredContentTypeByName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StructuredContentType StructuredContentServiceImpl.findStructuredContentTypeByName(String)"})
  public void testFindStructuredContentTypeByName() {
    // Arrange
    StructuredContentTypeImpl structuredContentTypeImpl = new StructuredContentTypeImpl();
    when(structuredContentDao.findStructuredContentTypeByName(Mockito.<String>any()))
        .thenReturn(structuredContentTypeImpl);

    // Act
    StructuredContentType actualFindStructuredContentTypeByNameResult = structuredContentServiceImpl
        .findStructuredContentTypeByName("Name");

    // Assert
    verify(structuredContentDao).findStructuredContentTypeByName(eq("Name"));
    assertSame(structuredContentTypeImpl, actualFindStructuredContentTypeByNameResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#retrieveAllStructuredContentTypes()}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#retrieveAllStructuredContentTypes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.retrieveAllStructuredContentTypes()"})
  public void testRetrieveAllStructuredContentTypes() {
    // Arrange
    when(structuredContentDao.retrieveAllStructuredContentTypes()).thenReturn(new ArrayList<>());

    // Act
    List<StructuredContentType> actualRetrieveAllStructuredContentTypesResult = structuredContentServiceImpl
        .retrieveAllStructuredContentTypes();

    // Assert
    verify(structuredContentDao).retrieveAllStructuredContentTypes();
    assertTrue(actualRetrieveAllStructuredContentTypesResult.isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#findContentItems(Criteria)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#findContentItems(Criteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.findContentItems(Criteria)"})
  public void testFindContentItems_givenArrayList_thenReturnEmpty() {
    // Arrange
    SessionDelegatorBaseImpl session = mock(SessionDelegatorBaseImpl.class);
    when(session.list(Mockito.<Criteria>any())).thenReturn(new ArrayList<>());

    // Act
    List<StructuredContent> actualFindContentItemsResult = structuredContentServiceImpl
        .findContentItems(new CriteriaImpl("Entity Or Class Name", session));

    // Assert
    verify(session).list(isA(Criteria.class));
    assertTrue(actualFindContentItemsResult.isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#findAllContentItems()}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#findAllContentItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.findAllContentItems()"})
  public void testFindAllContentItems() {
    // Arrange
    when(structuredContentDao.findAllContentItems()).thenReturn(new ArrayList<>());

    // Act
    List<StructuredContent> actualFindAllContentItemsResult = structuredContentServiceImpl.findAllContentItems();

    // Assert
    verify(structuredContentDao).findAllContentItems();
    assertTrue(actualFindAllContentItemsResult.isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#countContentItems(Criteria)}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#countContentItems(Criteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long StructuredContentServiceImpl.countContentItems(Criteria)"})
  public void testCountContentItems() {
    // Arrange
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
    assertSame(c, c.getProjectionCriteria());
    assertArrayEquals(new String[]{null}, projection.getAliases());
  }

  /**
   * Test {@link StructuredContentServiceImpl#saveStructuredContentType(StructuredContentType)}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#saveStructuredContentType(StructuredContentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "StructuredContentType StructuredContentServiceImpl.saveStructuredContentType(StructuredContentType)"})
  public void testSaveStructuredContentType() {
    // Arrange
    StructuredContentTypeImpl structuredContentTypeImpl = new StructuredContentTypeImpl();
    when(structuredContentDao.saveStructuredContentType(Mockito.<StructuredContentType>any()))
        .thenReturn(structuredContentTypeImpl);

    // Act
    StructuredContentType actualSaveStructuredContentTypeResult = structuredContentServiceImpl
        .saveStructuredContentType(new StructuredContentTypeImpl());

    // Assert
    verify(structuredContentDao).saveStructuredContentType(isA(StructuredContentType.class));
    assertSame(structuredContentTypeImpl, actualSaveStructuredContentTypeResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.buildStructuredContentDTOList(List, boolean)"})
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
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<StructuredContentDTO>>any()))
        .thenReturn(structuredContentDTO);
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");

    HashMap<String, StructuredContentRule> stringStructuredContentRuleMap = new HashMap<>();
    stringStructuredContentRuleMap.put("contentName", new StructuredContentRuleImpl());
    StructuredContentImpl structuredContentImpl = mock(StructuredContentImpl.class);
    when(structuredContentImpl.getPriority()).thenReturn(1);
    when(structuredContentImpl.getId()).thenReturn(1L);
    when(structuredContentImpl.getStructuredContentFieldXrefs()).thenReturn(new HashMap<>());
    when(structuredContentImpl.getStructuredContentMatchRules()).thenReturn(stringStructuredContentRuleMap);
    when(structuredContentImpl.getLocale()).thenReturn(new LocaleImpl());
    when(structuredContentImpl.getContentName()).thenReturn("Not all who wander are lost");
    when(structuredContentImpl.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(structuredContentImpl.getStructuredContentType()).thenReturn(new StructuredContentTypeImpl());

    ArrayList<StructuredContent> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentImpl);

    // Act
    List<StructuredContentDTO> actualBuildStructuredContentDTOListResult = structuredContentServiceImpl
        .buildStructuredContentDTOList(structuredContentList, true);

    // Assert
    verify(structuredContentImpl).getContentName();
    verify(structuredContentImpl, atLeast(1)).getId();
    verify(structuredContentImpl, atLeast(1)).getLocale();
    verify(structuredContentImpl).getPriority();
    verify(structuredContentImpl).getQualifyingItemCriteria();
    verify(structuredContentImpl).getStructuredContentFieldXrefs();
    verify(structuredContentImpl).getStructuredContentMatchRules();
    verify(structuredContentImpl).getStructuredContentType();
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(entityConfiguration)
        .createEntityInstance(eq("org.broadleafcommerce.common.structure.dto.StructuredContentDTO"), isA(Class.class));
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
   * <ul>
   *   <li>Then return first Values size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.buildStructuredContentDTOList(List, boolean)"})
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
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<StructuredContentDTO>>any()))
        .thenReturn(structuredContentDTO);
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");
    StructuredContentImpl structuredContentImpl = mock(StructuredContentImpl.class);
    when(structuredContentImpl.getPriority()).thenReturn(1);
    when(structuredContentImpl.getId()).thenReturn(1L);
    when(structuredContentImpl.getStructuredContentFieldXrefs()).thenReturn(new HashMap<>());
    when(structuredContentImpl.getStructuredContentMatchRules()).thenReturn(new HashMap<>());
    when(structuredContentImpl.getLocale()).thenReturn(new LocaleImpl());
    when(structuredContentImpl.getContentName()).thenReturn("Not all who wander are lost");
    when(structuredContentImpl.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(structuredContentImpl.getStructuredContentType()).thenReturn(new StructuredContentTypeImpl());

    ArrayList<StructuredContent> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentImpl);

    // Act
    List<StructuredContentDTO> actualBuildStructuredContentDTOListResult = structuredContentServiceImpl
        .buildStructuredContentDTOList(structuredContentList, true);

    // Assert
    verify(structuredContentImpl).getContentName();
    verify(structuredContentImpl, atLeast(1)).getId();
    verify(structuredContentImpl, atLeast(1)).getLocale();
    verify(structuredContentImpl).getPriority();
    verify(structuredContentImpl).getQualifyingItemCriteria();
    verify(structuredContentImpl).getStructuredContentFieldXrefs();
    verify(structuredContentImpl).getStructuredContentMatchRules();
    verify(structuredContentImpl).getStructuredContentType();
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(entityConfiguration)
        .createEntityInstance(eq("org.broadleafcommerce.common.structure.dto.StructuredContentDTO"), isA(Class.class));
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
   * <ul>
   *   <li>Then return first Values size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.buildStructuredContentDTOList(List, boolean)"})
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
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<StructuredContentDTO>>any()))
        .thenReturn(structuredContentDTO);
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");
    StructuredContentImpl structuredContentImpl = mock(StructuredContentImpl.class);
    when(structuredContentImpl.getPriority()).thenReturn(1);
    when(structuredContentImpl.getId()).thenReturn(1L);
    when(structuredContentImpl.getStructuredContentFieldXrefs()).thenReturn(new HashMap<>());
    when(structuredContentImpl.getStructuredContentMatchRules()).thenReturn(new HashMap<>());
    when(structuredContentImpl.getLocale()).thenReturn(null);
    when(structuredContentImpl.getContentName()).thenReturn("Not all who wander are lost");
    when(structuredContentImpl.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(structuredContentImpl.getStructuredContentType()).thenReturn(new StructuredContentTypeImpl());

    ArrayList<StructuredContent> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentImpl);

    // Act
    List<StructuredContentDTO> actualBuildStructuredContentDTOListResult = structuredContentServiceImpl
        .buildStructuredContentDTOList(structuredContentList, true);

    // Assert
    verify(structuredContentImpl).getContentName();
    verify(structuredContentImpl, atLeast(1)).getId();
    verify(structuredContentImpl).getLocale();
    verify(structuredContentImpl).getPriority();
    verify(structuredContentImpl).getQualifyingItemCriteria();
    verify(structuredContentImpl).getStructuredContentFieldXrefs();
    verify(structuredContentImpl).getStructuredContentMatchRules();
    verify(structuredContentImpl).getStructuredContentType();
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(entityConfiguration)
        .createEntityInstance(eq("org.broadleafcommerce.common.structure.dto.StructuredContentDTO"), isA(Class.class));
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
   * Test {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.buildStructuredContentDTOList(List, boolean)"})
  public void testBuildStructuredContentDTOList_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(structuredContentServiceImpl.buildStructuredContentDTOList(new ArrayList<>(), true).isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   * <ul>
   *   <li>Then calls {@link RuleProcessor#checkForMatch(Object, Map)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.evaluateAndPriortizeContent(List, int, Map)"})
  public void testEvaluateAndPriortizeContent_thenCallsCheckForMatch() {
    // Arrange
    RuleProcessor<StructuredContentDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<StructuredContentDTO>> ruleProcessorList = new ArrayList<>();
    ruleProcessorList.add(ruleProcessor);
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());

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
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult = structuredContentServiceImpl
        .evaluateAndPriortizeContent(structuredContentList, 3, new HashMap<>());

    // Assert
    verify(list).iterator();
    verify(ruleProcessor).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    assertSame(structuredContentList, actualEvaluateAndPriortizeContentResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.evaluateAndPriortizeContent(List, int, Map)"})
  public void testEvaluateAndPriortizeContent_thenReturnArrayList() {
    // Arrange
    ArrayList<RuleProcessor<StructuredContentDTO>> ruleProcessorList = new ArrayList<>();
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());

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
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult = structuredContentServiceImpl
        .evaluateAndPriortizeContent(structuredContentList, 3, new HashMap<>());

    // Assert
    verify(list).iterator();
    assertSame(structuredContentList, actualEvaluateAndPriortizeContentResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.evaluateAndPriortizeContent(List, int, Map)"})
  public void testEvaluateAndPriortizeContent_thenReturnEmpty() {
    // Arrange
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult = structuredContentServiceImpl
        .evaluateAndPriortizeContent(structuredContentList, 3, new HashMap<>());

    // Assert
    verify(structuredContentServiceExtensionManager).getProxy();
    assertTrue(actualEvaluateAndPriortizeContentResult.isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.processUnprioritizedContent(List, Map)"})
  public void testProcessUnprioritizedContent() {
    // Arrange
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

    // Act and Assert
    assertSame(structuredContentList,
        structuredContentServiceImpl.processUnprioritizedContent(structuredContentList, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.processUnprioritizedContent(List, Map)"})
  public void testProcessUnprioritizedContent2() {
    // Arrange
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

    // Act and Assert
    assertSame(structuredContentList,
        structuredContentServiceImpl.processUnprioritizedContent(structuredContentList, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}.
   * <ul>
   *   <li>Then calls {@link RuleProcessor#checkForMatch(Object, Map)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.processUnprioritizedContent(List, Map)"})
  public void testProcessUnprioritizedContent_thenCallsCheckForMatch() {
    // Arrange
    RuleProcessor<StructuredContentDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();
    contentRuleProcessors.add(ruleProcessor);
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
    List<StructuredContentDTO> actualProcessUnprioritizedContentResult = structuredContentServiceImpl
        .processUnprioritizedContent(structuredContentList, new HashMap<>());

    // Assert
    verify(ruleProcessor).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    assertSame(structuredContentList, actualProcessUnprioritizedContentResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.processContentRules(StructuredContentDTO, Map)"})
  public void testProcessContentRules() {
    // Arrange
    structuredContentServiceImpl.setContentRuleProcessors(null);

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
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.processContentRules(StructuredContentDTO, Map)"})
  public void testProcessContentRules2() {
    // Arrange
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
   * <ul>
   *   <li>Then calls {@link List#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.processContentRules(StructuredContentDTO, Map)"})
  public void testProcessContentRules_thenCallsIterator() {
    // Arrange
    RuleProcessor<StructuredContentDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<StructuredContentDTO>> ruleProcessorList = new ArrayList<>();
    ruleProcessorList.add(ruleProcessor);
    when(list.iterator()).thenReturn(ruleProcessorList.iterator());

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
    boolean actualProcessContentRulesResult = structuredContentServiceImpl.processContentRules(sc, new HashMap<>());

    // Assert
    verify(list).iterator();
    verify(ruleProcessor).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    assertTrue(actualProcessContentRulesResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#modifyStructuredContentDtoList(List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#modifyStructuredContentDtoList(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    List<StructuredContentDTO> actualModifyStructuredContentDtoListResult = structuredContentServiceImpl
        .modifyStructuredContentDtoList(structuredContentList);

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
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#modifyStructuredContentDtoList(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    List<StructuredContentDTO> actualModifyStructuredContentDtoListResult = structuredContentServiceImpl
        .modifyStructuredContentDtoList(structuredContentList);

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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#modifyStructuredContentDtoList(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.modifyStructuredContentDtoList(List)"})
  public void testModifyStructuredContentDtoList_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());

    // Act
    List<StructuredContentDTO> actualModifyStructuredContentDtoListResult = structuredContentServiceImpl
        .modifyStructuredContentDtoList(new ArrayList<>());

    // Assert
    verify(structuredContentServiceExtensionManager).getProxy();
    assertTrue(actualModifyStructuredContentDtoListResult.isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#convertToDtos(List, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#convertToDtos(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.convertToDtos(List, boolean)"})
  public void testConvertToDtos_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(structuredContentServiceImpl.convertToDtos(new ArrayList<>(), true).isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentServiceImpl#setContentRuleProcessors(List)}
   *   <li>{@link StructuredContentServiceImpl#getContentRuleProcessors()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.getContentRuleProcessors()",
      "void StructuredContentServiceImpl.setContentRuleProcessors(List)"})
  public void testGettersAndSetters() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();

    // Act
    structuredContentServiceImpl.setContentRuleProcessors(contentRuleProcessors);
    List<RuleProcessor<StructuredContentDTO>> actualContentRuleProcessors = structuredContentServiceImpl
        .getContentRuleProcessors();

    // Assert
    assertTrue(actualContentRuleProcessors.isEmpty());
    assertSame(contentRuleProcessors, actualContentRuleProcessors);
  }

  /**
   * Test {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.removeItemFromCacheByKey(String)"})
  public void testRemoveItemFromCacheByKey_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(structuredContentServiceImpl.removeItemFromCacheByKey(""));
  }

  /**
   * Test {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.removeItemFromCacheByKey(String)"})
  public void testRemoveItemFromCacheByKey_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(structuredContentServiceImpl.removeItemFromCacheByKey(null));
  }

  /**
   * Test {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}.
   * <ul>
   *   <li>Given {@code en}.</li>
   *   <li>Then calls {@link LocaleImpl#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale StructuredContentServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_givenEn_thenCallsGetLocaleCode() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);
    LocaleImpl locale = mock(LocaleImpl.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    Locale actualFindLanguageOnlyLocaleResult = structuredContentServiceImpl.findLanguageOnlyLocale(locale);

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findLocaleByCode(isNull());
    assertSame(localeImpl, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}.
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale StructuredContentServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_givenLocaleServiceFindLocaleByCodeReturnLocaleImpl() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    // Act
    Locale actualFindLanguageOnlyLocaleResult = structuredContentServiceImpl.findLanguageOnlyLocale(new LocaleImpl());

    // Assert
    verify(localeService).findLocaleByCode(isNull());
    assertSame(localeImpl, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}.
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale StructuredContentServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_givenLocaleServiceFindLocaleByCodeReturnNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(null);
    LocaleImpl locale = new LocaleImpl();

    // Act
    Locale actualFindLanguageOnlyLocaleResult = structuredContentServiceImpl.findLanguageOnlyLocale(locale);

    // Assert
    verify(localeService).findLocaleByCode(isNull());
    assertSame(locale, actualFindLanguageOnlyLocaleResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale StructuredContentServiceImpl.findLanguageOnlyLocale(Locale)"})
  public void testFindLanguageOnlyLocale_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(structuredContentServiceImpl.findLanguageOnlyLocale(null));
  }

  /**
   * Test {@link StructuredContentServiceImpl#getStructuredContentCache()}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#getStructuredContentCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Cache StructuredContentServiceImpl.getStructuredContentCache()"})
  public void testGetStructuredContentCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache actualStructuredContentCache = structuredContentServiceImpl.getStructuredContentCache();

    // Assert
    verify(cacheManager).getCache(eq("cmsStructuredContentCache"));
    assertNull(actualStructuredContentCache);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link StructuredContentRuleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildRuleExpression(StructuredContent)"})
  public void testBuildRuleExpression_givenHashMapFooIsStructuredContentRuleImpl() {
    // Arrange
    HashMap<String, StructuredContentRule> structuredContentMatchRules = new HashMap<>();
    structuredContentMatchRules.put("foo", new StructuredContentRuleImpl());

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setStructuredContentMatchRules(structuredContentMatchRules);

    // Act and Assert
    assertNull(structuredContentServiceImpl.buildRuleExpression(sc));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   * <ul>
   *   <li>Given {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildRuleExpression(StructuredContent)"})
  public void testBuildRuleExpression_givenNotAllWhoWanderAreLost() {
    // Arrange
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
   * <ul>
   *   <li>Then return {@code Match Rule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildRuleExpression(StructuredContent)"})
  public void testBuildRuleExpression_thenReturnMatchRule() {
    // Arrange
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
   * <ul>
   *   <li>When {@link StructuredContentImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildRuleExpression(StructuredContent)"})
  public void testBuildRuleExpression_whenStructuredContentImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(structuredContentServiceImpl.buildRuleExpression(new StructuredContentImpl()));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.buildItemCriteriaDTOList(StructuredContent)"})
  public void testBuildItemCriteriaDTOList_givenNull() {
    // Arrange
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
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.buildItemCriteriaDTOList(StructuredContent)"})
  public void testBuildItemCriteriaDTOList_thenReturnSizeIsOne() {
    // Arrange
    ItemCriteriaDTO itemCriteriaDTO = new ItemCriteriaDTO();
    itemCriteriaDTO.setMatchRule("Match Rule");
    itemCriteriaDTO.setQty(1);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<ItemCriteriaDTO>>any()))
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
    List<ItemCriteriaDTO> actualBuildItemCriteriaDTOListResult = structuredContentServiceImpl
        .buildItemCriteriaDTOList(sc);

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO"),
        isA(Class.class));
    assertEquals(1, actualBuildItemCriteriaDTOListResult.size());
    assertSame(itemCriteriaDTO, actualBuildItemCriteriaDTOListResult.get(0));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}.
   * <ul>
   *   <li>When {@link StructuredContentImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StructuredContentServiceImpl.buildItemCriteriaDTOList(StructuredContent)"})
  public void testBuildItemCriteriaDTOList_whenStructuredContentImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(structuredContentServiceImpl.buildItemCriteriaDTOList(new StructuredContentImpl()).isEmpty());
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent, StructuredContentDTO, boolean)}.
   * <ul>
   *   <li>Then {@link StructuredContentDTO} (default constructor) Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent, StructuredContentDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StructuredContentServiceImpl.buildFieldValues(StructuredContent, StructuredContentDTO, boolean)"})
  public void testBuildFieldValues_thenStructuredContentDTOValuesSizeIsOne() {
    // Arrange
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");
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
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.hasCmsPrefix(String, String)"})
  public void testHasCmsPrefix_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(structuredContentServiceImpl.hasCmsPrefix("42", "42"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   * <ul>
   *   <li>When {@code Cms Prefix}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.hasCmsPrefix(String, String)"})
  public void testHasCmsPrefix_whenCmsPrefix_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(structuredContentServiceImpl.hasCmsPrefix("42", "Cms Prefix"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.hasCmsPrefix(String, String)"})
  public void testHasCmsPrefix_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(structuredContentServiceImpl.hasCmsPrefix("", "Cms Prefix"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.hasCmsPrefix(String, String)"})
  public void testHasCmsPrefix_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(structuredContentServiceImpl.hasCmsPrefix(null, null));
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StructuredContentServiceImpl.hasCmsPrefix(String, String)"})
  public void testHasCmsPrefix_whenNull_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(structuredContentServiceImpl.hasCmsPrefix("42", null));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildFieldValueWithCmsPrefix(String, StructuredContentDTO, boolean, String)}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildFieldValueWithCmsPrefix(String, StructuredContentDTO, boolean, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void StructuredContentServiceImpl.buildFieldValueWithCmsPrefix(String, StructuredContentDTO, boolean, String)"})
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
    verify(staticAssetPathService).convertAllAssetPathsInContent(eq("42"), eq(true));
    Map<String, Object> values2 = scDTO.getValues();
    assertEquals(1, values2.size());
    assertEquals("Not all who wander are lost", values2.get("Field Key"));
    assertSame(values, values2);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildStructuredContentDTO(StructuredContent, boolean)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code contentName} is {@link StructuredContentRuleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildStructuredContentDTO(StructuredContent, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "StructuredContentDTO StructuredContentServiceImpl.buildStructuredContentDTO(StructuredContent, boolean)"})
  public void testBuildStructuredContentDTO_givenHashMapContentNameIsStructuredContentRuleImpl() {
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
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<StructuredContentDTO>>any()))
        .thenReturn(structuredContentDTO);
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");

    HashMap<String, StructuredContentRule> stringStructuredContentRuleMap = new HashMap<>();
    stringStructuredContentRuleMap.put("contentName", new StructuredContentRuleImpl());
    StructuredContent sc = mock(StructuredContent.class);
    when(sc.getPriority()).thenReturn(1);
    when(sc.getId()).thenReturn(1L);
    when(sc.getStructuredContentFieldXrefs()).thenReturn(new HashMap<>());
    when(sc.getStructuredContentMatchRules()).thenReturn(stringStructuredContentRuleMap);
    when(sc.getLocale()).thenReturn(new LocaleImpl());
    when(sc.getContentName()).thenReturn("Not all who wander are lost");
    when(sc.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(sc.getStructuredContentType()).thenReturn(new StructuredContentTypeImpl());

    // Act
    StructuredContentDTO actualBuildStructuredContentDTOResult = structuredContentServiceImpl
        .buildStructuredContentDTO(sc, true);

    // Assert
    verify(sc).getContentName();
    verify(sc, atLeast(1)).getId();
    verify(sc, atLeast(1)).getLocale();
    verify(sc).getPriority();
    verify(sc).getQualifyingItemCriteria();
    verify(sc).getStructuredContentFieldXrefs();
    verify(sc).getStructuredContentMatchRules();
    verify(sc).getStructuredContentType();
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(entityConfiguration)
        .createEntityInstance(eq("org.broadleafcommerce.common.structure.dto.StructuredContentDTO"), isA(Class.class));
    Map<String, Object> values = actualBuildStructuredContentDTOResult.getValues();
    assertEquals(5, values.size());
    assertNull(values.get("localeCode"));
    StructuredContentDTO clone = actualBuildStructuredContentDTOResult.getClone();
    Map<String, Object> values2 = clone.getValues();
    assertEquals(5, values2.size());
    assertNull(values2.get("contentType"));
    assertNull(values2.get("localeCode"));
    assertNull(actualBuildStructuredContentDTOResult.getLocaleCode());
    assertNull(clone.getLocaleCode());
    StructuredContentDTO clone2 = clone.getClone();
    assertNull(clone2.getLocaleCode());
    assertEquals(1, ((Integer) values2.get("priority")).intValue());
    assertEquals(1L, ((Long) values2.get("id")).longValue());
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
   * Test {@link StructuredContentServiceImpl#buildStructuredContentDTO(StructuredContent, boolean)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return LocaleCode is {@code en}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildStructuredContentDTO(StructuredContent, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "StructuredContentDTO StructuredContentServiceImpl.buildStructuredContentDTO(StructuredContent, boolean)"})
  public void testBuildStructuredContentDTO_givenNull_thenReturnLocaleCodeIsEn() {
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
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<StructuredContentDTO>>any()))
        .thenReturn(structuredContentDTO);
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");
    StructuredContent sc = mock(StructuredContent.class);
    when(sc.getPriority()).thenReturn(1);
    when(sc.getId()).thenReturn(1L);
    when(sc.getStructuredContentFieldXrefs()).thenReturn(new HashMap<>());
    when(sc.getStructuredContentMatchRules()).thenReturn(new HashMap<>());
    when(sc.getLocale()).thenReturn(null);
    when(sc.getContentName()).thenReturn("Not all who wander are lost");
    when(sc.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(sc.getStructuredContentType()).thenReturn(new StructuredContentTypeImpl());

    // Act
    StructuredContentDTO actualBuildStructuredContentDTOResult = structuredContentServiceImpl
        .buildStructuredContentDTO(sc, true);

    // Assert
    verify(sc).getContentName();
    verify(sc, atLeast(1)).getId();
    verify(sc).getLocale();
    verify(sc).getPriority();
    verify(sc).getQualifyingItemCriteria();
    verify(sc).getStructuredContentFieldXrefs();
    verify(sc).getStructuredContentMatchRules();
    verify(sc).getStructuredContentType();
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(entityConfiguration)
        .createEntityInstance(eq("org.broadleafcommerce.common.structure.dto.StructuredContentDTO"), isA(Class.class));
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
   * Test {@link StructuredContentServiceImpl#buildStructuredContentDTO(StructuredContent, boolean)}.
   * <ul>
   *   <li>Then return Values size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildStructuredContentDTO(StructuredContent, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "StructuredContentDTO StructuredContentServiceImpl.buildStructuredContentDTO(StructuredContent, boolean)"})
  public void testBuildStructuredContentDTO_thenReturnValuesSizeIsFive() {
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
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<StructuredContentDTO>>any()))
        .thenReturn(structuredContentDTO);
    when(structuredContentServiceExtensionManager.getProxy())
        .thenReturn(new AbstractStructuredContentServiceExtensionHandler());
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");
    StructuredContent sc = mock(StructuredContent.class);
    when(sc.getPriority()).thenReturn(1);
    when(sc.getId()).thenReturn(1L);
    when(sc.getStructuredContentFieldXrefs()).thenReturn(new HashMap<>());
    when(sc.getStructuredContentMatchRules()).thenReturn(new HashMap<>());
    when(sc.getLocale()).thenReturn(new LocaleImpl());
    when(sc.getContentName()).thenReturn("Not all who wander are lost");
    when(sc.getQualifyingItemCriteria()).thenReturn(new HashSet<>());
    when(sc.getStructuredContentType()).thenReturn(new StructuredContentTypeImpl());

    // Act
    StructuredContentDTO actualBuildStructuredContentDTOResult = structuredContentServiceImpl
        .buildStructuredContentDTO(sc, true);

    // Assert
    verify(sc).getContentName();
    verify(sc, atLeast(1)).getId();
    verify(sc, atLeast(1)).getLocale();
    verify(sc).getPriority();
    verify(sc).getQualifyingItemCriteria();
    verify(sc).getStructuredContentFieldXrefs();
    verify(sc).getStructuredContentMatchRules();
    verify(sc).getStructuredContentType();
    verify(structuredContentServiceExtensionManager).getProxy();
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    verify(entityConfiguration)
        .createEntityInstance(eq("org.broadleafcommerce.common.structure.dto.StructuredContentDTO"), isA(Class.class));
    Map<String, Object> values = actualBuildStructuredContentDTOResult.getValues();
    assertEquals(5, values.size());
    assertNull(values.get("localeCode"));
    StructuredContentDTO clone = actualBuildStructuredContentDTOResult.getClone();
    Map<String, Object> values2 = clone.getValues();
    assertEquals(5, values2.size());
    assertNull(values2.get("contentType"));
    assertNull(values2.get("localeCode"));
    assertNull(actualBuildStructuredContentDTOResult.getLocaleCode());
    assertNull(clone.getLocaleCode());
    StructuredContentDTO clone2 = clone.getClone();
    assertNull(clone2.getLocaleCode());
    assertEquals(1, ((Integer) values2.get("priority")).intValue());
    assertEquals(1L, ((Long) values2.get("id")).longValue());
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
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)} with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}, {@code contentName}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildNameKey(SandBox, Long, Locale, String, String)"})
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentName() {
    // Arrange
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals("text/plain-Not all who wander are lost-null-null-1", structuredContentServiceImpl
        .buildNameKey(currentSandbox, 1L, new LocaleImpl(), "text/plain", "Not all who wander are lost"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)} with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}, {@code contentName}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildNameKey(SandBox, Long, Locale, String, String)"})
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentName2() {
    // Arrange, Act and Assert
    assertEquals("text/plain-Not all who wander are lost",
        structuredContentServiceImpl.buildNameKey(null, null, null, "text/plain", "Not all who wander are lost"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)} with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}, {@code contentName}, {@code secure}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String StructuredContentServiceImpl.buildNameKey(SandBox, Long, Locale, String, String, Boolean)"})
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentNameSecure() {
    // Arrange
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals("text/plain-Not all who wander are lost-null-null-1-true", structuredContentServiceImpl
        .buildNameKey(currentSandbox, 1L, new LocaleImpl(), "text/plain", "Not all who wander are lost", true));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)} with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}, {@code contentName}, {@code secure}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String StructuredContentServiceImpl.buildNameKey(SandBox, Long, Locale, String, String, Boolean)"})
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentNameSecure2() {
    // Arrange, Act and Assert
    assertEquals("text/plain-Not all who wander are lost",
        structuredContentServiceImpl.buildNameKey(null, null, null, "text/plain", "Not all who wander are lost", null));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)} with {@code sandBox}, {@code sc}, {@code secure}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent, Boolean)"})
  public void testBuildNameKeyWithSandBoxScSecure() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    SandBoxImpl sandBox = new SandBoxImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

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
    sc.setLocale(new LocaleImpl());

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(sandBox, sc, null);

    // Assert
    verify(structuredContentType).getName();
    verify(localeService).findLocaleByCode(isNull());
    assertEquals("Name-Not all who wander are lost-1-null-null", actualBuildNameKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)} with {@code sandBox}, {@code sc}, {@code secure}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent, Boolean)"})
  public void testBuildNameKeyWithSandBoxScSecure2() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

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
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(null, sc, true);

    // Assert
    verify(structuredContentType).getName();
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findLocaleByCode(isNull());
    assertEquals("Name-Not all who wander are lost-1-null-true", actualBuildNameKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)} with {@code sandBox}, {@code sc}, {@code secure}.
   * <ul>
   *   <li>Then return {@code Name-Not all who wander are lost-1-null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent, Boolean)"})
  public void testBuildNameKeyWithSandBoxScSecure_thenReturnNameNotAllWhoWanderAreLost1Null() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

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
    sc.setLocale(new LocaleImpl());

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(null, sc, null);

    // Assert
    verify(structuredContentType).getName();
    verify(localeService).findLocaleByCode(isNull());
    assertEquals("Name-Not all who wander are lost-1-null", actualBuildNameKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)} with {@code sandBox}, {@code sc}, {@code secure}.
   * <ul>
   *   <li>Then return {@code Name-Not all who wander are lost-1-null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent, Boolean)"})
  public void testBuildNameKeyWithSandBoxScSecure_thenReturnNameNotAllWhoWanderAreLost1Null2() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

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
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(null, sc, null);

    // Assert
    verify(structuredContentType).getName();
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findLocaleByCode(isNull());
    assertEquals("Name-Not all who wander are lost-1-null", actualBuildNameKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)} with {@code sandBox}, {@code sc}.
   * <ul>
   *   <li>Then calls {@link Locale#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent)"})
  public void testBuildNameKeyWithSandBoxSc_thenCallsGetLocaleCode() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

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
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(null, sc);

    // Assert
    verify(structuredContentType).getName();
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findLocaleByCode(isNull());
    assertEquals("Name-Not all who wander are lost-1-null", actualBuildNameKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)} with {@code sandBox}, {@code sc}.
   * <ul>
   *   <li>Then return {@code Name-Not all who wander are lost-1-null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent)"})
  public void testBuildNameKeyWithSandBoxSc_thenReturnNameNotAllWhoWanderAreLost1Null() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

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
    sc.setLocale(new LocaleImpl());

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(null, sc);

    // Assert
    verify(structuredContentType).getName();
    verify(localeService).findLocaleByCode(isNull());
    assertEquals("Name-Not all who wander are lost-1-null", actualBuildNameKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)} with {@code sandBox}, {@code sc}.
   * <ul>
   *   <li>Then return {@code Name-Not all who wander are lost-1-null-null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildNameKey(SandBox, StructuredContent)"})
  public void testBuildNameKeyWithSandBoxSc_thenReturnNameNotAllWhoWanderAreLost1NullNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    SandBoxImpl sandBox = new SandBoxImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

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
    sc.setLocale(new LocaleImpl());

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(sandBox, sc);

    // Assert
    verify(structuredContentType).getName();
    verify(localeService).findLocaleByCode(isNull());
    assertEquals("Name-Not all who wander are lost-1-null-null", actualBuildNameKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)} with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildTypeKey(SandBox, Long, Locale, String)"})
  public void testBuildTypeKeyWithCurrentSandboxSiteLocaleContentType() {
    // Arrange
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals("text/plain-null-null-1",
        structuredContentServiceImpl.buildTypeKey(currentSandbox, 1L, new LocaleImpl(), "text/plain"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)} with {@code currentSandbox}, {@code site}, {@code locale}, {@code contentType}.
   * <ul>
   *   <li>Then return {@code text/plain}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildTypeKey(SandBox, Long, Locale, String)"})
  public void testBuildTypeKeyWithCurrentSandboxSiteLocaleContentType_thenReturnTextPlain() {
    // Arrange, Act and Assert
    assertEquals("text/plain", structuredContentServiceImpl.buildTypeKey(null, null, null, "text/plain"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)} with {@code sandBox}, {@code sc}.
   * <ul>
   *   <li>Then calls {@link Locale#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildTypeKey(SandBox, StructuredContent)"})
  public void testBuildTypeKeyWithSandBoxSc_thenCallsGetLocaleCode() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

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
    String actualBuildTypeKeyResult = structuredContentServiceImpl.buildTypeKey(null, sc);

    // Assert
    verify(structuredContentType).getName();
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findLocaleByCode(isNull());
    assertEquals("Name-null", actualBuildTypeKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)} with {@code sandBox}, {@code sc}.
   * <ul>
   *   <li>Then return {@code Name-null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildTypeKey(SandBox, StructuredContent)"})
  public void testBuildTypeKeyWithSandBoxSc_thenReturnNameNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

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
    sc.setLocale(new LocaleImpl());

    // Act
    String actualBuildTypeKeyResult = structuredContentServiceImpl.buildTypeKey(null, sc);

    // Assert
    verify(structuredContentType).getName();
    verify(localeService).findLocaleByCode(isNull());
    assertEquals("Name-null", actualBuildTypeKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)} with {@code sandBox}, {@code sc}.
   * <ul>
   *   <li>When {@link SandBoxImpl} (default constructor).</li>
   *   <li>Then return {@code Name-null-null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StructuredContentServiceImpl.buildTypeKey(SandBox, StructuredContent)"})
  public void testBuildTypeKeyWithSandBoxSc_whenSandBoxImpl_thenReturnNameNullNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());
    SandBoxImpl sandBox = new SandBoxImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

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
    sc.setLocale(new LocaleImpl());

    // Act
    String actualBuildTypeKeyResult = structuredContentServiceImpl.buildTypeKey(sandBox, sc);

    // Assert
    verify(structuredContentType).getName();
    verify(localeService).findLocaleByCode(isNull());
    assertEquals("Name-null-null", actualBuildTypeKeyResult);
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code text/plain}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String StructuredContentServiceImpl.buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)"})
  public void testBuildTypeKeyWithSecure_whenNull_thenReturnTextPlain() {
    // Arrange, Act and Assert
    assertEquals("text/plain",
        structuredContentServiceImpl.buildTypeKeyWithSecure(null, null, null, "text/plain", null));
  }

  /**
   * Test {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}.
   * <ul>
   *   <li>When {@link SandBoxImpl} (default constructor).</li>
   *   <li>Then return {@code text/plain-null-null-1-true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String StructuredContentServiceImpl.buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)"})
  public void testBuildTypeKeyWithSecure_whenSandBoxImpl_thenReturnTextPlainNullNull1True() {
    // Arrange
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals("text/plain-null-null-1-true",
        structuredContentServiceImpl.buildTypeKeyWithSecure(currentSandbox, 1L, new LocaleImpl(), "text/plain", true));
  }
}
