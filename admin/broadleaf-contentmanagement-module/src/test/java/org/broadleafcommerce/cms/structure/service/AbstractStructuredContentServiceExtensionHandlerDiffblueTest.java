/*-
 * #%L
 * BroadleafCommerce CMS Module
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import org.broadleafcommerce.cms.structure.domain.StructuredContent;
import org.broadleafcommerce.cms.structure.domain.StructuredContentImpl;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.structure.dto.StructuredContentDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractStructuredContentServiceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractStructuredContentServiceExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractStructuredContentServiceExtensionHandler abstractStructuredContentServiceExtensionHandler;

  /**
   * Test
   * {@link AbstractStructuredContentServiceExtensionHandler#populateAdditionalStructuredContentFields(StructuredContent, StructuredContentDTO, boolean)}.
   * <p>
   * Method under test:
   * {@link AbstractStructuredContentServiceExtensionHandler#populateAdditionalStructuredContentFields(StructuredContent, StructuredContentDTO, boolean)}
   */
  @Test
  public void testPopulateAdditionalStructuredContentFields() {
    // Arrange
    AbstractStructuredContentServiceExtensionHandler abstractStructuredContentServiceExtensionHandler = new AbstractStructuredContentServiceExtensionHandler();
    StructuredContentImpl sc = new StructuredContentImpl();

    HashMap<String, Object> values = new HashMap<>();
    values.computeIfPresent("foo", mock(BiFunction.class));

    StructuredContentDTO dto = new StructuredContentDTO();
    dto.setContentName("Not all who wander are lost");
    dto.setContentType("text/plain");
    dto.setId(1L);
    dto.setItemCriteriaDTOList(new ArrayList<>());
    dto.setLocaleCode("en");
    dto.setPriority(1);
    dto.setRuleExpression("Rule Expression");
    dto.setValues(values);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractStructuredContentServiceExtensionHandler.populateAdditionalStructuredContentFields(sc, dto, true));
  }

  /**
   * Test
   * {@link AbstractStructuredContentServiceExtensionHandler#populateAdditionalStructuredContentFields(StructuredContent, StructuredContentDTO, boolean)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractStructuredContentServiceExtensionHandler#populateAdditionalStructuredContentFields(StructuredContent, StructuredContentDTO, boolean)}
   */
  @Test
  public void testPopulateAdditionalStructuredContentFields_givenHashMap() {
    // Arrange
    AbstractStructuredContentServiceExtensionHandler abstractStructuredContentServiceExtensionHandler = new AbstractStructuredContentServiceExtensionHandler();
    StructuredContentImpl sc = new StructuredContentImpl();

    StructuredContentDTO dto = new StructuredContentDTO();
    dto.setContentName("Not all who wander are lost");
    dto.setContentType("text/plain");
    dto.setId(1L);
    dto.setItemCriteriaDTOList(new ArrayList<>());
    dto.setLocaleCode("en");
    dto.setPriority(1);
    dto.setRuleExpression("Rule Expression");
    dto.setValues(new HashMap<>());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractStructuredContentServiceExtensionHandler.populateAdditionalStructuredContentFields(sc, dto, true));
  }

  /**
   * Test
   * {@link AbstractStructuredContentServiceExtensionHandler#modifyStructuredContentDtoList(List, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AbstractStructuredContentServiceExtensionHandler#modifyStructuredContentDtoList(List, ExtensionResultHolder)}
   */
  @Test
  public void testModifyStructuredContentDtoList() {
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

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    ExtensionResultHolder resultHolder = new ExtensionResultHolder();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractStructuredContentServiceExtensionHandler
        .modifyStructuredContentDtoList(structuredContentList, resultHolder));
  }

  /**
   * Test
   * {@link AbstractStructuredContentServiceExtensionHandler#modifyStructuredContentDtoList(List, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AbstractStructuredContentServiceExtensionHandler#modifyStructuredContentDtoList(List, ExtensionResultHolder)}
   */
  @Test
  public void testModifyStructuredContentDtoList2() {
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

    ExtensionResultHolder resultHolder = new ExtensionResultHolder();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractStructuredContentServiceExtensionHandler
        .modifyStructuredContentDtoList(structuredContentList, resultHolder));
  }

  /**
   * Test
   * {@link AbstractStructuredContentServiceExtensionHandler#modifyStructuredContentDtoList(List, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then calls {@link ExtensionResultHolder#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractStructuredContentServiceExtensionHandler#modifyStructuredContentDtoList(List, ExtensionResultHolder)}
   */
  @Test
  public void testModifyStructuredContentDtoList_thenCallsSetResult() {
    // Arrange
    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    ExtensionResultHolder resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<Object>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualModifyStructuredContentDtoListResult = abstractStructuredContentServiceExtensionHandler
        .modifyStructuredContentDtoList(structuredContentList, resultHolder);

    // Assert
    verify(resultHolder).setResult(isA(Object.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualModifyStructuredContentDtoListResult);
  }

  /**
   * Test
   * {@link AbstractStructuredContentServiceExtensionHandler#modifyStructuredContentDtoList(List, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractStructuredContentServiceExtensionHandler#modifyStructuredContentDtoList(List, ExtensionResultHolder)}
   */
  @Test
  public void testModifyStructuredContentDtoList_whenArrayList() {
    // Arrange
    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();

    ExtensionResultHolder resultHolder = new ExtensionResultHolder();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractStructuredContentServiceExtensionHandler
        .modifyStructuredContentDtoList(structuredContentList, resultHolder));
  }

  /**
   * Test new {@link AbstractStructuredContentServiceExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractStructuredContentServiceExtensionHandler}
   */
  @Test
  public void testNewAbstractStructuredContentServiceExtensionHandler() {
    // Arrange and Act
    AbstractStructuredContentServiceExtensionHandler actualAbstractStructuredContentServiceExtensionHandler = new AbstractStructuredContentServiceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractStructuredContentServiceExtensionHandler.getPriority());
    assertTrue(actualAbstractStructuredContentServiceExtensionHandler.isEnabled());
  }
}
