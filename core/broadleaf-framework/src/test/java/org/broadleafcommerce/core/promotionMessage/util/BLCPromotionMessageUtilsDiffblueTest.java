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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.core.promotionMessage.domain.PromotionMessage;
import org.broadleafcommerce.core.promotionMessage.domain.PromotionMessageImpl;
import org.broadleafcommerce.core.promotionMessage.domain.type.PromotionMessagePlacementType;
import org.broadleafcommerce.core.promotionMessage.dto.PromotionMessageDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BLCPromotionMessageUtilsDiffblueTest {
  /**
   * Test {@link BLCPromotionMessageUtils#gatherMessages(List)}.
   *
   * <ul>
   *   <li>Given {@link PromotionMessageImpl} (default constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BLCPromotionMessageUtils#gatherMessages(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BLCPromotionMessageUtils.gatherMessages(List)"})
  public void testGatherMessages_givenPromotionMessageImpl_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PromotionMessage> promotionMessages = new ArrayList<>();
    promotionMessages.add(new PromotionMessageImpl());

    // Act
    List<String> actualGatherMessagesResult =
        BLCPromotionMessageUtils.gatherMessages(promotionMessages);

    // Assert
    assertEquals(1, actualGatherMessagesResult.size());
    assertNull(actualGatherMessagesResult.get(0));
  }

  /**
   * Test {@link BLCPromotionMessageUtils#gatherMessages(List)}.
   *
   * <ul>
   *   <li>Given {@link PromotionMessageImpl} (default constructor).
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link BLCPromotionMessageUtils#gatherMessages(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BLCPromotionMessageUtils.gatherMessages(List)"})
  public void testGatherMessages_givenPromotionMessageImpl_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<PromotionMessage> promotionMessages = new ArrayList<>();
    promotionMessages.add(new PromotionMessageImpl());
    promotionMessages.add(new PromotionMessageImpl());

    // Act
    List<String> actualGatherMessagesResult =
        BLCPromotionMessageUtils.gatherMessages(promotionMessages);

    // Assert
    assertEquals(2, actualGatherMessagesResult.size());
    assertNull(actualGatherMessagesResult.get(0));
    assertNull(actualGatherMessagesResult.get(1));
  }

  /**
   * Test {@link BLCPromotionMessageUtils#gatherMessages(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BLCPromotionMessageUtils#gatherMessages(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BLCPromotionMessageUtils.gatherMessages(List)"})
  public void testGatherMessages_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualGatherMessagesResult =
        BLCPromotionMessageUtils.gatherMessages(new ArrayList<>());

    // Assert
    assertTrue(actualGatherMessagesResult.isEmpty());
  }

  /**
   * Test {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BLCPromotionMessageUtils.gatherMessagesFromDTOs(List)"})
  public void testGatherMessagesFromDTOs_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PromotionMessageDTO> promotionMessages = new ArrayList<>();
    promotionMessages.add(new PromotionMessageDTO(new PromotionMessageImpl()));

    // Act
    List<String> actualGatherMessagesFromDTOsResult =
        BLCPromotionMessageUtils.gatherMessagesFromDTOs(promotionMessages);

    // Assert
    assertEquals(1, actualGatherMessagesFromDTOsResult.size());
    assertNull(actualGatherMessagesFromDTOsResult.get(0));
  }

  /**
   * Test {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BLCPromotionMessageUtils.gatherMessagesFromDTOs(List)"})
  public void testGatherMessagesFromDTOs_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<PromotionMessageDTO> promotionMessages = new ArrayList<>();
    promotionMessages.add(new PromotionMessageDTO(new PromotionMessageImpl()));
    promotionMessages.add(new PromotionMessageDTO(new PromotionMessageImpl()));

    // Act
    List<String> actualGatherMessagesFromDTOsResult =
        BLCPromotionMessageUtils.gatherMessagesFromDTOs(promotionMessages);

    // Assert
    assertEquals(2, actualGatherMessagesFromDTOsResult.size());
    assertNull(actualGatherMessagesFromDTOsResult.get(0));
    assertNull(actualGatherMessagesFromDTOsResult.get(1));
  }

  /**
   * Test {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BLCPromotionMessageUtils.gatherMessagesFromDTOs(List)"})
  public void testGatherMessagesFromDTOs_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualGatherMessagesFromDTOsResult =
        BLCPromotionMessageUtils.gatherMessagesFromDTOs(new ArrayList<>());

    // Assert
    assertTrue(actualGatherMessagesFromDTOsResult.isEmpty());
  }

  /**
   * Test {@link BLCPromotionMessageUtils#gatherMessagesByPlacementType(Map,
   * PromotionMessagePlacementType)}.
   *
   * <ul>
   *   <li>When {@link PromotionMessagePlacementType#BROWSE}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BLCPromotionMessageUtils#gatherMessagesByPlacementType(Map,
   * PromotionMessagePlacementType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BLCPromotionMessageUtils.gatherMessagesByPlacementType(Map, PromotionMessagePlacementType)"
  })
  public void testGatherMessagesByPlacementType_whenBrowse_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualGatherMessagesByPlacementTypeResult =
        BLCPromotionMessageUtils.gatherMessagesByPlacementType(
            new HashMap<>(), PromotionMessagePlacementType.BROWSE);

    // Assert
    assertTrue(actualGatherMessagesByPlacementTypeResult.isEmpty());
  }

  /**
   * Test {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BLCPromotionMessageUtils.filterPromotionMessageDTOsByTypes(Map, List)"})
  public void testFilterPromotionMessageDTOsByTypes_given42_whenArrayListAdd42() {
    // Arrange
    HashMap<String, List<PromotionMessageDTO>> promotionMessages = new HashMap<>();
    promotionMessages.put("foo", new ArrayList<>());

    ArrayList<String> placementTypes = new ArrayList<>();
    placementTypes.add("42");
    placementTypes.add("foo");

    // Act
    List<PromotionMessageDTO> actualFilterPromotionMessageDTOsByTypesResult =
        BLCPromotionMessageUtils.filterPromotionMessageDTOsByTypes(
            promotionMessages, placementTypes);

    // Assert
    assertTrue(actualFilterPromotionMessageDTOsByTypesResult.isEmpty());
  }

  /**
   * Test {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BLCPromotionMessageUtils.filterPromotionMessageDTOsByTypes(Map, List)"})
  public void testFilterPromotionMessageDTOsByTypes_givenFoo_whenArrayList() {
    // Arrange
    HashMap<String, List<PromotionMessageDTO>> promotionMessages = new HashMap<>();
    promotionMessages.put("foo", new ArrayList<>());

    // Act
    List<PromotionMessageDTO> actualFilterPromotionMessageDTOsByTypesResult =
        BLCPromotionMessageUtils.filterPromotionMessageDTOsByTypes(
            promotionMessages, new ArrayList<>());

    // Assert
    assertTrue(actualFilterPromotionMessageDTOsByTypesResult.isEmpty());
  }

  /**
   * Test {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BLCPromotionMessageUtils.filterPromotionMessageDTOsByTypes(Map, List)"})
  public void testFilterPromotionMessageDTOsByTypes_givenFoo_whenArrayListAddFoo() {
    // Arrange
    HashMap<String, List<PromotionMessageDTO>> promotionMessages = new HashMap<>();
    promotionMessages.put("foo", new ArrayList<>());

    ArrayList<String> placementTypes = new ArrayList<>();
    placementTypes.add("foo");

    // Act
    List<PromotionMessageDTO> actualFilterPromotionMessageDTOsByTypesResult =
        BLCPromotionMessageUtils.filterPromotionMessageDTOsByTypes(
            promotionMessages, placementTypes);

    // Assert
    assertTrue(actualFilterPromotionMessageDTOsByTypesResult.isEmpty());
  }

  /**
   * Test {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BLCPromotionMessageUtils.filterPromotionMessageDTOsByTypes(Map, List)"})
  public void testFilterPromotionMessageDTOsByTypes_whenHashMap() {
    // Arrange
    HashMap<String, List<PromotionMessageDTO>> promotionMessages = new HashMap<>();

    // Act
    List<PromotionMessageDTO> actualFilterPromotionMessageDTOsByTypesResult =
        BLCPromotionMessageUtils.filterPromotionMessageDTOsByTypes(
            promotionMessages, new ArrayList<>());

    // Assert
    assertTrue(actualFilterPromotionMessageDTOsByTypesResult.isEmpty());
  }
}
