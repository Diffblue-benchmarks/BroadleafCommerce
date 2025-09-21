/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.payment.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GiftCardDTO.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class GiftCardDTODiffblueTest {
  @Autowired private GiftCardDTO<Object> giftCardDTO;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GiftCardDTO#GiftCardDTO()}
   *   <li>{@link GiftCardDTO#giftCardMasked(String)}
   *   <li>{@link GiftCardDTO#giftCardNum(String)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GiftCardDTO.<init>()",
    "void GiftCardDTO.<init>(Object)",
    "GiftCardDTO GiftCardDTO.giftCardMasked(String)",
    "GiftCardDTO GiftCardDTO.giftCardNum(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    GiftCardDTO<Object> actualGiftCardDTO = new GiftCardDTO<>();
    GiftCardDTO<Object> actualGiftCardMaskedResult =
        actualGiftCardDTO.giftCardMasked("Gift Card Masked");
    GiftCardDTO<Object> actualGiftCardNumResult = actualGiftCardDTO.giftCardNum("Gift Card Num");

    // Assert
    assertTrue(actualGiftCardDTO.additionalFields.isEmpty());
    assertSame(actualGiftCardDTO, actualGiftCardMaskedResult);
    assertSame(actualGiftCardDTO, actualGiftCardNumResult);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GiftCardDTO#GiftCardDTO(Object)}
   *   <li>{@link GiftCardDTO#giftCardMasked(String)}
   *   <li>{@link GiftCardDTO#giftCardNum(String)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GiftCardDTO.<init>()",
    "void GiftCardDTO.<init>(Object)",
    "GiftCardDTO GiftCardDTO.giftCardMasked(String)",
    "GiftCardDTO GiftCardDTO.giftCardNum(String)"
  })
  public void testGettersAndSetters_whenNull_field() {
    // Arrange and Act
    GiftCardDTO<Object> actualGiftCardDTO = new GiftCardDTO<>(BLCFieldUtils.NULL_FIELD);
    GiftCardDTO<Object> actualGiftCardMaskedResult =
        actualGiftCardDTO.giftCardMasked("Gift Card Masked");
    GiftCardDTO<Object> actualGiftCardNumResult = actualGiftCardDTO.giftCardNum("Gift Card Num");

    // Assert
    assertTrue(actualGiftCardDTO.additionalFields.isEmpty());
    assertSame(actualGiftCardDTO, actualGiftCardMaskedResult);
    assertSame(actualGiftCardDTO, actualGiftCardNumResult);
  }

  /**
   * Test {@link GiftCardDTO#done()}.
   *
   * <p>Method under test: {@link GiftCardDTO#done()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GiftCardDTO.done()"})
  public void testDone() {
    // Arrange
    GiftCardDTO<Object> giftCardDTO = new GiftCardDTO<>();

    // Act and Assert
    assertNull(giftCardDTO.done());
  }

  /**
   * Test {@link GiftCardDTO#additionalFields(String, Object)}.
   *
   * <p>Method under test: {@link GiftCardDTO#additionalFields(String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GiftCardDTO GiftCardDTO.additionalFields(String, Object)"})
  public void testAdditionalFields() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    GiftCardDTO<Object> actualAdditionalFieldsResult = giftCardDTO.additionalFields("Key", object);

    // Assert
    Map<String, Object> stringObjectMap = giftCardDTO.additionalFields;
    assertEquals(1, stringObjectMap.size());
    assertSame(giftCardDTO, actualAdditionalFieldsResult);
    assertSame(object, stringObjectMap.get("Key"));
  }
}
