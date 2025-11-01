/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.promotionMessage.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl;
import org.broadleafcommerce.core.promotionMessage.domain.PromotionMessage;
import org.broadleafcommerce.core.promotionMessage.domain.PromotionMessageImpl;
import org.broadleafcommerce.core.promotionMessage.domain.type.PromotionMessagePlacementType;
import org.broadleafcommerce.core.promotionMessage.dto.PromotionMessageDTO;
import org.junit.Test;

public class BLCPromotionMessageUtilsDiffblueTest {
  /**
   * Method under test: {@link BLCPromotionMessageUtils#gatherMessages(List)}
   */
  @Test
  public void testGatherMessages() {
    // Arrange and Act
    List<String> actualGatherMessagesResult = BLCPromotionMessageUtils.gatherMessages(new ArrayList<>());

    // Assert
    assertTrue(actualGatherMessagesResult.isEmpty());
  }

  /**
   * Method under test: {@link BLCPromotionMessageUtils#gatherMessages(List)}
   */
  @Test
  public void testGatherMessages2() {
    // Arrange
    ArrayList<PromotionMessage> promotionMessages = new ArrayList<>();
    promotionMessages.add(new PromotionMessageImpl());

    // Act
    List<String> actualGatherMessagesResult = BLCPromotionMessageUtils.gatherMessages(promotionMessages);

    // Assert
    assertEquals(1, actualGatherMessagesResult.size());
    assertNull(actualGatherMessagesResult.get(0));
  }

  /**
   * Method under test: {@link BLCPromotionMessageUtils#gatherMessages(List)}
   */
  @Test
  public void testGatherMessages3() {
    // Arrange
    ArrayList<PromotionMessage> promotionMessages = new ArrayList<>();
    promotionMessages.add(new PromotionMessageImpl());
    promotionMessages.add(new PromotionMessageImpl());

    // Act
    List<String> actualGatherMessagesResult = BLCPromotionMessageUtils.gatherMessages(promotionMessages);

    // Assert
    assertEquals(2, actualGatherMessagesResult.size());
    assertNull(actualGatherMessagesResult.get(0));
    assertNull(actualGatherMessagesResult.get(1));
  }

  /**
   * Method under test: {@link BLCPromotionMessageUtils#gatherMessages(List)}
   */
  @Test
  public void testGatherMessages4() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = mock(PromotionMessageImpl.class);
    when(promotionMessageImpl.getMessage()).thenReturn("Not all who wander are lost");

    ArrayList<PromotionMessage> promotionMessages = new ArrayList<>();
    promotionMessages.add(promotionMessageImpl);

    // Act
    List<String> actualGatherMessagesResult = BLCPromotionMessageUtils.gatherMessages(promotionMessages);

    // Assert
    verify(promotionMessageImpl).getMessage();
    assertEquals(1, actualGatherMessagesResult.size());
    assertEquals("Not all who wander are lost", actualGatherMessagesResult.get(0));
  }

  /**
   * Method under test:
   * {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}
   */
  @Test
  public void testGatherMessagesFromDTOs() {
    // Arrange and Act
    List<String> actualGatherMessagesFromDTOsResult = BLCPromotionMessageUtils
        .gatherMessagesFromDTOs(new ArrayList<>());

    // Assert
    assertTrue(actualGatherMessagesFromDTOsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}
   */
  @Test
  public void testGatherMessagesFromDTOs2() {
    // Arrange
    ArrayList<PromotionMessageDTO> promotionMessages = new ArrayList<>();
    promotionMessages.add(new PromotionMessageDTO(new PromotionMessageImpl()));

    // Act
    List<String> actualGatherMessagesFromDTOsResult = BLCPromotionMessageUtils
        .gatherMessagesFromDTOs(promotionMessages);

    // Assert
    assertEquals(1, actualGatherMessagesFromDTOsResult.size());
    assertNull(actualGatherMessagesFromDTOsResult.get(0));
  }

  /**
   * Method under test:
   * {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}
   */
  @Test
  public void testGatherMessagesFromDTOs3() {
    // Arrange
    ArrayList<PromotionMessageDTO> promotionMessages = new ArrayList<>();
    promotionMessages.add(new PromotionMessageDTO(new PromotionMessageImpl()));
    promotionMessages.add(new PromotionMessageDTO(new PromotionMessageImpl()));

    // Act
    List<String> actualGatherMessagesFromDTOsResult = BLCPromotionMessageUtils
        .gatherMessagesFromDTOs(promotionMessages);

    // Assert
    assertEquals(2, actualGatherMessagesFromDTOsResult.size());
    assertNull(actualGatherMessagesFromDTOsResult.get(0));
    assertNull(actualGatherMessagesFromDTOsResult.get(1));
  }

  /**
   * Method under test:
   * {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}
   */
  @Test
  public void testGatherMessagesFromDTOs4() {
    // Arrange
    PromotionMessage promotionMessage = mock(PromotionMessage.class);
    when(promotionMessage.getPriority()).thenReturn(1);
    when(promotionMessage.getMessage()).thenReturn("Not all who wander are lost");
    when(promotionMessage.getMessagePlacement()).thenReturn("Message Placement");
    when(promotionMessage.getEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(promotionMessage.getLocale()).thenReturn(new LocaleImpl());
    when(promotionMessage.getMedia()).thenReturn(new CategoryMediaXrefImpl());
    PromotionMessageDTO promotionMessageDTO = new PromotionMessageDTO(promotionMessage);

    ArrayList<PromotionMessageDTO> promotionMessages = new ArrayList<>();
    promotionMessages.add(promotionMessageDTO);

    // Act
    List<String> actualGatherMessagesFromDTOsResult = BLCPromotionMessageUtils
        .gatherMessagesFromDTOs(promotionMessages);

    // Assert
    verify(promotionMessage).getEndDate();
    verify(promotionMessage, atLeast(1)).getLocale();
    verify(promotionMessage).getMedia();
    verify(promotionMessage).getMessage();
    verify(promotionMessage).getMessagePlacement();
    verify(promotionMessage).getPriority();
    assertEquals(1, actualGatherMessagesFromDTOsResult.size());
    assertEquals("Not all who wander are lost", actualGatherMessagesFromDTOsResult.get(0));
  }

  /**
   * Method under test:
   * {@link BLCPromotionMessageUtils#sortMessagesByPriority(List)}
   */
  @Test
  public void testSortMessagesByPriority() {
    // Arrange
    PromotionMessageImpl promotionMessage = mock(PromotionMessageImpl.class);
    when(promotionMessage.getPriority()).thenReturn(1);
    when(promotionMessage.getMessage()).thenReturn("Not all who wander are lost");
    when(promotionMessage.getMessagePlacement()).thenReturn("Message Placement");
    when(promotionMessage.getEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(promotionMessage.getLocale()).thenReturn(new LocaleImpl());
    when(promotionMessage.getMedia()).thenReturn(new CategoryMediaXrefImpl());
    PromotionMessageDTO promotionMessageDTO = new PromotionMessageDTO(promotionMessage);

    ArrayList<PromotionMessageDTO> promotionMessages = new ArrayList<>();
    promotionMessages.add(promotionMessageDTO);

    // Act
    BLCPromotionMessageUtils.sortMessagesByPriority(promotionMessages);

    // Assert
    verify(promotionMessage).getEndDate();
    verify(promotionMessage, atLeast(1)).getLocale();
    verify(promotionMessage).getMedia();
    verify(promotionMessage).getMessage();
    verify(promotionMessage).getMessagePlacement();
    verify(promotionMessage).getPriority();
  }

  /**
   * Method under test:
   * {@link BLCPromotionMessageUtils#gatherMessagesByPlacementType(Map, PromotionMessagePlacementType)}
   */
  @Test
  public void testGatherMessagesByPlacementType() {
    // Arrange and Act
    List<String> actualGatherMessagesByPlacementTypeResult = BLCPromotionMessageUtils
        .gatherMessagesByPlacementType(new HashMap<>(), PromotionMessagePlacementType.BROWSE);

    // Assert
    assertTrue(actualGatherMessagesByPlacementTypeResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCPromotionMessageUtils#gatherMessagesByPlacementType(Map, PromotionMessagePlacementType)}
   */
  @Test
  public void testGatherMessagesByPlacementType2() {
    // Arrange
    HashMap<String, List<PromotionMessageDTO>> promotionMessageMap = new HashMap<>();
    promotionMessageMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    List<String> actualGatherMessagesByPlacementTypeResult = BLCPromotionMessageUtils
        .gatherMessagesByPlacementType(promotionMessageMap, PromotionMessagePlacementType.BROWSE);

    // Assert
    assertTrue(actualGatherMessagesByPlacementTypeResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}
   */
  @Test
  public void testFilterPromotionMessageDTOsByTypes() {
    // Arrange
    HashMap<String, List<PromotionMessageDTO>> promotionMessages = new HashMap<>();

    // Act
    List<PromotionMessageDTO> actualFilterPromotionMessageDTOsByTypesResult = BLCPromotionMessageUtils
        .filterPromotionMessageDTOsByTypes(promotionMessages, new ArrayList<>());

    // Assert
    assertTrue(actualFilterPromotionMessageDTOsByTypesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}
   */
  @Test
  public void testFilterPromotionMessageDTOsByTypes2() {
    // Arrange
    HashMap<String, List<PromotionMessageDTO>> promotionMessages = new HashMap<>();
    promotionMessages.put("foo", new ArrayList<>());

    // Act
    List<PromotionMessageDTO> actualFilterPromotionMessageDTOsByTypesResult = BLCPromotionMessageUtils
        .filterPromotionMessageDTOsByTypes(promotionMessages, new ArrayList<>());

    // Assert
    assertTrue(actualFilterPromotionMessageDTOsByTypesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}
   */
  @Test
  public void testFilterPromotionMessageDTOsByTypes3() {
    // Arrange
    HashMap<String, List<PromotionMessageDTO>> promotionMessages = new HashMap<>();
    promotionMessages.computeIfPresent("foo", mock(BiFunction.class));
    promotionMessages.put("foo", new ArrayList<>());

    // Act
    List<PromotionMessageDTO> actualFilterPromotionMessageDTOsByTypesResult = BLCPromotionMessageUtils
        .filterPromotionMessageDTOsByTypes(promotionMessages, new ArrayList<>());

    // Assert
    assertTrue(actualFilterPromotionMessageDTOsByTypesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}
   */
  @Test
  public void testFilterPromotionMessageDTOsByTypes4() {
    // Arrange
    HashMap<String, List<PromotionMessageDTO>> promotionMessages = new HashMap<>();

    ArrayList<String> placementTypes = new ArrayList<>();
    placementTypes.add("foo");

    // Act
    List<PromotionMessageDTO> actualFilterPromotionMessageDTOsByTypesResult = BLCPromotionMessageUtils
        .filterPromotionMessageDTOsByTypes(promotionMessages, placementTypes);

    // Assert
    assertTrue(actualFilterPromotionMessageDTOsByTypesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}
   */
  @Test
  public void testFilterPromotionMessageDTOsByTypes5() {
    // Arrange
    HashMap<String, List<PromotionMessageDTO>> promotionMessages = new HashMap<>();

    ArrayList<String> placementTypes = new ArrayList<>();
    placementTypes.add("42");
    placementTypes.add("foo");

    // Act
    List<PromotionMessageDTO> actualFilterPromotionMessageDTOsByTypesResult = BLCPromotionMessageUtils
        .filterPromotionMessageDTOsByTypes(promotionMessages, placementTypes);

    // Assert
    assertTrue(actualFilterPromotionMessageDTOsByTypesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}
   */
  @Test
  public void testFilterPromotionMessageDTOsByTypes6() {
    // Arrange
    HashMap<String, List<PromotionMessageDTO>> promotionMessages = new HashMap<>();
    promotionMessages.put("foo", new ArrayList<>());

    ArrayList<String> placementTypes = new ArrayList<>();
    placementTypes.add("foo");

    // Act
    List<PromotionMessageDTO> actualFilterPromotionMessageDTOsByTypesResult = BLCPromotionMessageUtils
        .filterPromotionMessageDTOsByTypes(promotionMessages, placementTypes);

    // Assert
    assertTrue(actualFilterPromotionMessageDTOsByTypesResult.isEmpty());
  }
}
