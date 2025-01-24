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
import org.junit.Ignore;
import org.junit.Test;

public class BLCPromotionMessageUtilsDiffblueTest {
  /**
   * Test {@link BLCPromotionMessageUtils#gatherMessages(List)}.
   * <ul>
   *   <li>Given {@link PromotionMessageImpl} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCPromotionMessageUtils#gatherMessages(List)}
   */
  @Test
  public void testGatherMessages_givenPromotionMessageImpl_thenReturnSizeIsOne() {
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
   * Test {@link BLCPromotionMessageUtils#gatherMessages(List)}.
   * <ul>
   *   <li>Given {@link PromotionMessageImpl} (default constructor).</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCPromotionMessageUtils#gatherMessages(List)}
   */
  @Test
  public void testGatherMessages_givenPromotionMessageImpl_thenReturnSizeIsTwo() {
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
   * Test {@link BLCPromotionMessageUtils#gatherMessages(List)}.
   * <ul>
   *   <li>Then return first is {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCPromotionMessageUtils#gatherMessages(List)}
   */
  @Test
  public void testGatherMessages_thenReturnFirstIsNotAllWhoWanderAreLost() {
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
   * Test {@link BLCPromotionMessageUtils#gatherMessages(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCPromotionMessageUtils#gatherMessages(List)}
   */
  @Test
  public void testGatherMessages_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualGatherMessagesResult = BLCPromotionMessageUtils.gatherMessages(new ArrayList<>());

    // Assert
    assertTrue(actualGatherMessagesResult.isEmpty());
  }

  /**
   * Test {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}.
   * <ul>
   *   <li>Then return first is {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}
   */
  @Test
  public void testGatherMessagesFromDTOs_thenReturnFirstIsNotAllWhoWanderAreLost() {
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
   * Test {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}
   */
  @Test
  public void testGatherMessagesFromDTOs_thenReturnSizeIsOne() {
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
   * Test {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}
   */
  @Test
  public void testGatherMessagesFromDTOs_thenReturnSizeIsTwo() {
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
   * Test {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#gatherMessagesFromDTOs(List)}
   */
  @Test
  public void testGatherMessagesFromDTOs_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualGatherMessagesFromDTOsResult = BLCPromotionMessageUtils
        .gatherMessagesFromDTOs(new ArrayList<>());

    // Assert
    assertTrue(actualGatherMessagesFromDTOsResult.isEmpty());
  }

  /**
   * Test {@link BLCPromotionMessageUtils#sortMessagesByPriority(List)} with
   * {@code List}.
   * <ul>
   *   <li>Then calls {@link PromotionMessageImpl#getEndDate()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#sortMessagesByPriority(List)}
   */
  @Test
  public void testSortMessagesByPriorityWithList_thenCallsGetEndDate() {
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
   * Test {@link BLCPromotionMessageUtils#sortMessagesByPriority(Map)} with
   * {@code Map}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#sortMessagesByPriority(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSortMessagesByPriorityWithMap_givenArrayListAddNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.promotionMessage.util.BLCPromotionMessageUtils$3.compare(BLCPromotionMessageUtils.java:93)
    //       at org.broadleafcommerce.core.promotionMessage.util.BLCPromotionMessageUtils$3.compare(BLCPromotionMessageUtils.java:90)
    //       at java.base/java.util.TimSort.countRunAndMakeAscending(TimSort.java:355)
    //       at java.base/java.util.TimSort.sort(TimSort.java:220)
    //       at java.base/java.util.Arrays.sort(Arrays.java:1515)
    //       at java.base/java.util.ArrayList.sort(ArrayList.java:1750)
    //       at java.base/java.util.Collections.sort(Collections.java:179)
    //       at org.broadleafcommerce.core.promotionMessage.util.BLCPromotionMessageUtils.sortMessagesByPriority(BLCPromotionMessageUtils.java:90)
    //       at org.broadleafcommerce.core.promotionMessage.util.BLCPromotionMessageUtils.sortMessagesByPriority(BLCPromotionMessageUtils.java:80)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    ArrayList<PromotionMessageDTO> promotionMessageDTOList = new ArrayList<>();
    promotionMessageDTOList.add(null);
    promotionMessageDTOList.add(new PromotionMessageDTO(new PromotionMessageImpl()));

    HashMap<String, List<PromotionMessageDTO>> promotionMessages = new HashMap<>();
    promotionMessages.put("foo", promotionMessageDTOList);

    // Act
    BLCPromotionMessageUtils.sortMessagesByPriority(promotionMessages);
  }

  /**
   * Test {@link BLCPromotionMessageUtils#sortMessagesByPriority(Map)} with
   * {@code Map}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#sortMessagesByPriority(Map)}
   */
  @Test
  public void testSortMessagesByPriorityWithMap_whenHashMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    BLCPromotionMessageUtils.sortMessagesByPriority(new HashMap<>());
  }

  /**
   * Test
   * {@link BLCPromotionMessageUtils#gatherMessagesByPlacementType(Map, PromotionMessagePlacementType)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#gatherMessagesByPlacementType(Map, PromotionMessagePlacementType)}
   */
  @Test
  public void testGatherMessagesByPlacementType_givenFoo() {
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
   * Test
   * {@link BLCPromotionMessageUtils#gatherMessagesByPlacementType(Map, PromotionMessagePlacementType)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#gatherMessagesByPlacementType(Map, PromotionMessagePlacementType)}
   */
  @Test
  public void testGatherMessagesByPlacementType_whenHashMap_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualGatherMessagesByPlacementTypeResult = BLCPromotionMessageUtils
        .gatherMessagesByPlacementType(new HashMap<>(), PromotionMessagePlacementType.BROWSE);

    // Assert
    assertTrue(actualGatherMessagesByPlacementTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}
   */
  @Test
  public void testFilterPromotionMessageDTOsByTypes_given42_whenArrayListAdd42() {
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
   * Test
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}
   */
  @Test
  public void testFilterPromotionMessageDTOsByTypes_givenArrayList_whenHashMapFooIsArrayList() {
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
   * Test
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}
   */
  @Test
  public void testFilterPromotionMessageDTOsByTypes_givenArrayList_whenHashMapFooIsArrayList2() {
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

  /**
   * Test
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}
   */
  @Test
  public void testFilterPromotionMessageDTOsByTypes_givenBiFunction() {
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
   * Test
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}
   */
  @Test
  public void testFilterPromotionMessageDTOsByTypes_givenFoo_whenHashMap() {
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
   * Test
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCPromotionMessageUtils#filterPromotionMessageDTOsByTypes(Map, List)}
   */
  @Test
  public void testFilterPromotionMessageDTOsByTypes_whenHashMap() {
    // Arrange
    HashMap<String, List<PromotionMessageDTO>> promotionMessages = new HashMap<>();

    // Act
    List<PromotionMessageDTO> actualFilterPromotionMessageDTOsByTypesResult = BLCPromotionMessageUtils
        .filterPromotionMessageDTOsByTypes(promotionMessages, new ArrayList<>());

    // Assert
    assertTrue(actualFilterPromotionMessageDTOsByTypesResult.isEmpty());
  }
}
