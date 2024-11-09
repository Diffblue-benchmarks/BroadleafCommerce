/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.junit.Test;

public class BroadleafSystemEventDetailDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafSystemEventDetail#BroadleafSystemEventDetail(String)}
   *   <li>{@link BroadleafSystemEventDetail#setBlob(Serializable)}
   *   <li>{@link BroadleafSystemEventDetail#setFriendlyName(String)}
   *   <li>{@link BroadleafSystemEventDetail#setValue(String)}
   *   <li>{@link BroadleafSystemEventDetail#getBlob()}
   *   <li>{@link BroadleafSystemEventDetail#getFriendlyName()}
   *   <li>{@link BroadleafSystemEventDetail#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_when42() {
    // Arrange and Act
    BroadleafSystemEventDetail actualBroadleafSystemEventDetail = new BroadleafSystemEventDetail("42");
    SimpleDateFormat blob = new SimpleDateFormat("yyyy/mm/dd");
    actualBroadleafSystemEventDetail.setBlob(blob);
    actualBroadleafSystemEventDetail.setFriendlyName("Friendly Name");
    actualBroadleafSystemEventDetail.setValue("42");
    Serializable actualBlob = actualBroadleafSystemEventDetail.getBlob();
    String actualFriendlyName = actualBroadleafSystemEventDetail.getFriendlyName();

    // Assert that nothing has changed
    assertEquals("42", actualBroadleafSystemEventDetail.getValue());
    assertEquals("Friendly Name", actualFriendlyName);
    assertSame(blob, actualBlob);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Friendly Name}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BroadleafSystemEventDetail#BroadleafSystemEventDetail(String, Serializable)}
   *   <li>{@link BroadleafSystemEventDetail#setBlob(Serializable)}
   *   <li>{@link BroadleafSystemEventDetail#setFriendlyName(String)}
   *   <li>{@link BroadleafSystemEventDetail#setValue(String)}
   *   <li>{@link BroadleafSystemEventDetail#getBlob()}
   *   <li>{@link BroadleafSystemEventDetail#getFriendlyName()}
   *   <li>{@link BroadleafSystemEventDetail#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenFriendlyName() {
    // Arrange and Act
    BroadleafSystemEventDetail actualBroadleafSystemEventDetail = new BroadleafSystemEventDetail("Friendly Name",
        new SimpleDateFormat("yyyy/mm/dd"));
    SimpleDateFormat blob = new SimpleDateFormat("yyyy/mm/dd");
    actualBroadleafSystemEventDetail.setBlob(blob);
    actualBroadleafSystemEventDetail.setFriendlyName("Friendly Name");
    actualBroadleafSystemEventDetail.setValue("42");
    Serializable actualBlob = actualBroadleafSystemEventDetail.getBlob();
    String actualFriendlyName = actualBroadleafSystemEventDetail.getFriendlyName();

    // Assert that nothing has changed
    assertEquals("42", actualBroadleafSystemEventDetail.getValue());
    assertEquals("Friendly Name", actualFriendlyName);
    assertSame(blob, actualBlob);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Friendly Name}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BroadleafSystemEventDetail#BroadleafSystemEventDetail(String, String)}
   *   <li>{@link BroadleafSystemEventDetail#setBlob(Serializable)}
   *   <li>{@link BroadleafSystemEventDetail#setFriendlyName(String)}
   *   <li>{@link BroadleafSystemEventDetail#setValue(String)}
   *   <li>{@link BroadleafSystemEventDetail#getBlob()}
   *   <li>{@link BroadleafSystemEventDetail#getFriendlyName()}
   *   <li>{@link BroadleafSystemEventDetail#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenFriendlyName2() {
    // Arrange and Act
    BroadleafSystemEventDetail actualBroadleafSystemEventDetail = new BroadleafSystemEventDetail("Friendly Name", "42");
    SimpleDateFormat blob = new SimpleDateFormat("yyyy/mm/dd");
    actualBroadleafSystemEventDetail.setBlob(blob);
    actualBroadleafSystemEventDetail.setFriendlyName("Friendly Name");
    actualBroadleafSystemEventDetail.setValue("42");
    Serializable actualBlob = actualBroadleafSystemEventDetail.getBlob();
    String actualFriendlyName = actualBroadleafSystemEventDetail.getFriendlyName();

    // Assert that nothing has changed
    assertEquals("42", actualBroadleafSystemEventDetail.getValue());
    assertEquals("Friendly Name", actualFriendlyName);
    assertSame(blob, actualBlob);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link SimpleDateFormat#SimpleDateFormat(String)} with
   * {@code yyyy/mm/dd}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BroadleafSystemEventDetail#BroadleafSystemEventDetail(Serializable)}
   *   <li>{@link BroadleafSystemEventDetail#setBlob(Serializable)}
   *   <li>{@link BroadleafSystemEventDetail#setFriendlyName(String)}
   *   <li>{@link BroadleafSystemEventDetail#setValue(String)}
   *   <li>{@link BroadleafSystemEventDetail#getBlob()}
   *   <li>{@link BroadleafSystemEventDetail#getFriendlyName()}
   *   <li>{@link BroadleafSystemEventDetail#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenSimpleDateFormatWithYyyyMmDd() {
    // Arrange and Act
    BroadleafSystemEventDetail actualBroadleafSystemEventDetail = new BroadleafSystemEventDetail(
        new SimpleDateFormat("yyyy/mm/dd"));
    SimpleDateFormat blob = new SimpleDateFormat("yyyy/mm/dd");
    actualBroadleafSystemEventDetail.setBlob(blob);
    actualBroadleafSystemEventDetail.setFriendlyName("Friendly Name");
    actualBroadleafSystemEventDetail.setValue("42");
    Serializable actualBlob = actualBroadleafSystemEventDetail.getBlob();
    String actualFriendlyName = actualBroadleafSystemEventDetail.getFriendlyName();

    // Assert that nothing has changed
    assertEquals("42", actualBroadleafSystemEventDetail.getValue());
    assertEquals("Friendly Name", actualFriendlyName);
    assertSame(blob, actualBlob);
  }
}
