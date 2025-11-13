package org.broadleafcommerce.core.inventory.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InventoryUnavailableExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Arg0}.
   *   <li>Then return Message is {@code Arg0}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InventoryUnavailableException#InventoryUnavailableException(String, Long, Integer,
   *       Integer)}
   *   <li>{@link InventoryUnavailableException#setSkuId(Long)}
   *   <li>{@link InventoryUnavailableException#getSkuId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InventoryUnavailableException.<init>(Long, Integer, Integer)",
    "void InventoryUnavailableException.<init>(String)",
    "void InventoryUnavailableException.<init>(String, Long, Integer, Integer)",
    "void InventoryUnavailableException.<init>(String, Throwable)",
    "Long InventoryUnavailableException.getSkuId()",
    "void InventoryUnavailableException.setSkuId(Long)"
  })
  public void testGettersAndSetters_whenArg0_thenReturnMessageIsArg0() {
    // Arrange and Act
    InventoryUnavailableException actualInventoryUnavailableException =
        new InventoryUnavailableException("Arg0", 1L, 1, 1);
    actualInventoryUnavailableException.setSkuId(1L);
    Long actualSkuId = actualInventoryUnavailableException.getSkuId();

    // Assert
    assertEquals("Arg0", actualInventoryUnavailableException.getMessage());
    assertNull(actualInventoryUnavailableException.getCause());
    assertEquals(0, actualInventoryUnavailableException.getSuppressed().length);
    assertEquals(1, actualInventoryUnavailableException.quantityAvailable.intValue());
    assertEquals(1, actualInventoryUnavailableException.quantityRequested.intValue());
    assertEquals(1L, actualSkuId.longValue());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then return Message is {@code Msg}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InventoryUnavailableException#InventoryUnavailableException(String)}
   *   <li>{@link InventoryUnavailableException#setSkuId(Long)}
   *   <li>{@link InventoryUnavailableException#getSkuId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InventoryUnavailableException.<init>(Long, Integer, Integer)",
    "void InventoryUnavailableException.<init>(String)",
    "void InventoryUnavailableException.<init>(String, Long, Integer, Integer)",
    "void InventoryUnavailableException.<init>(String, Throwable)",
    "Long InventoryUnavailableException.getSkuId()",
    "void InventoryUnavailableException.setSkuId(Long)"
  })
  public void testGettersAndSetters_whenMsg_thenReturnMessageIsMsg() {
    // Arrange and Act
    InventoryUnavailableException actualInventoryUnavailableException =
        new InventoryUnavailableException("Msg");
    actualInventoryUnavailableException.setSkuId(1L);
    Long actualSkuId = actualInventoryUnavailableException.getSkuId();

    // Assert
    assertEquals("Msg", actualInventoryUnavailableException.getMessage());
    assertNull(actualInventoryUnavailableException.getCause());
    assertEquals(0, actualInventoryUnavailableException.getSuppressed().length);
    assertEquals(1L, actualSkuId.longValue());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InventoryUnavailableException#InventoryUnavailableException(Long, Integer,
   *       Integer)}
   *   <li>{@link InventoryUnavailableException#setSkuId(Long)}
   *   <li>{@link InventoryUnavailableException#getSkuId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InventoryUnavailableException.<init>(Long, Integer, Integer)",
    "void InventoryUnavailableException.<init>(String)",
    "void InventoryUnavailableException.<init>(String, Long, Integer, Integer)",
    "void InventoryUnavailableException.<init>(String, Throwable)",
    "Long InventoryUnavailableException.getSkuId()",
    "void InventoryUnavailableException.setSkuId(Long)"
  })
  public void testGettersAndSetters_whenOne_thenReturnMessageIsNull() {
    // Arrange and Act
    InventoryUnavailableException actualInventoryUnavailableException =
        new InventoryUnavailableException(1L, 1, 1);
    actualInventoryUnavailableException.setSkuId(1L);
    Long actualSkuId = actualInventoryUnavailableException.getSkuId();

    // Assert
    assertNull(actualInventoryUnavailableException.getMessage());
    assertNull(actualInventoryUnavailableException.getCause());
    assertEquals(0, actualInventoryUnavailableException.getSuppressed().length);
    assertEquals(1, actualInventoryUnavailableException.quantityAvailable.intValue());
    assertEquals(1, actualInventoryUnavailableException.quantityRequested.intValue());
    assertEquals(1L, actualSkuId.longValue());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InventoryUnavailableException#InventoryUnavailableException(String, Throwable)}
   *   <li>{@link InventoryUnavailableException#setSkuId(Long)}
   *   <li>{@link InventoryUnavailableException#getSkuId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InventoryUnavailableException.<init>(Long, Integer, Integer)",
    "void InventoryUnavailableException.<init>(String)",
    "void InventoryUnavailableException.<init>(String, Long, Integer, Integer)",
    "void InventoryUnavailableException.<init>(String, Throwable)",
    "Long InventoryUnavailableException.getSkuId()",
    "void InventoryUnavailableException.setSkuId(Long)"
  })
  public void testGettersAndSetters_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InventoryUnavailableException actualInventoryUnavailableException =
        new InventoryUnavailableException("Msg", cause);
    actualInventoryUnavailableException.setSkuId(1L);
    Long actualSkuId = actualInventoryUnavailableException.getSkuId();

    // Assert
    assertEquals("Msg", actualInventoryUnavailableException.getMessage());
    assertEquals(0, actualInventoryUnavailableException.getSuppressed().length);
    assertEquals(1L, actualSkuId.longValue());
    assertSame(cause, actualInventoryUnavailableException.getCause());
  }

  /**
   * Test {@link InventoryUnavailableException#getQuantityRequested()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InventoryUnavailableException#getQuantityRequested()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int InventoryUnavailableException.getQuantityRequested()"})
  public void testGetQuantityRequested_thenReturnOne() {
    // Arrange
    InventoryUnavailableException inventoryUnavailableException =
        new InventoryUnavailableException("Msg");
    inventoryUnavailableException.setQuantityRequested(1);

    // Act and Assert
    assertEquals(1, inventoryUnavailableException.getQuantityRequested());
  }

  /**
   * Test {@link InventoryUnavailableException#setQuantityRequested(int)}.
   *
   * <p>Method under test: {@link InventoryUnavailableException#setQuantityRequested(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryUnavailableException.setQuantityRequested(int)"})
  public void testSetQuantityRequested() {
    // Arrange
    InventoryUnavailableException inventoryUnavailableException =
        new InventoryUnavailableException("Msg");

    // Act
    inventoryUnavailableException.setQuantityRequested(1);

    // Assert
    assertEquals(1, inventoryUnavailableException.quantityRequested.intValue());
    assertEquals(1, inventoryUnavailableException.getQuantityRequested());
  }

  /**
   * Test {@link InventoryUnavailableException#getQuantityAvailable()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InventoryUnavailableException#getQuantityAvailable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int InventoryUnavailableException.getQuantityAvailable()"})
  public void testGetQuantityAvailable_thenReturnOne() {
    // Arrange
    InventoryUnavailableException inventoryUnavailableException =
        new InventoryUnavailableException("Msg");
    inventoryUnavailableException.setQuantityAvailable(1);

    // Act and Assert
    assertEquals(1, inventoryUnavailableException.getQuantityAvailable());
  }

  /**
   * Test {@link InventoryUnavailableException#setQuantityAvailable(int)}.
   *
   * <p>Method under test: {@link InventoryUnavailableException#setQuantityAvailable(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InventoryUnavailableException.setQuantityAvailable(int)"})
  public void testSetQuantityAvailable() {
    // Arrange
    InventoryUnavailableException inventoryUnavailableException =
        new InventoryUnavailableException("Msg");

    // Act
    inventoryUnavailableException.setQuantityAvailable(1);

    // Assert
    assertEquals(1, inventoryUnavailableException.quantityAvailable.intValue());
    assertEquals(1, inventoryUnavailableException.getQuantityAvailable());
  }
}
