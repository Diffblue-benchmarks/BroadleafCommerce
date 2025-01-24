package org.broadleafcommerce.core.catalog.service.dynamic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import org.junit.Test;

public class SkuActiveDateConsiderationContextDiffblueTest {
  /**
   * Test
   * {@link SkuActiveDateConsiderationContext#getSkuActiveDateConsiderationContext()}.
   * <p>
   * Method under test:
   * {@link SkuActiveDateConsiderationContext#getSkuActiveDateConsiderationContext()}
   */
  @Test
  public void testGetSkuActiveDateConsiderationContext() {
    // Arrange, Act and Assert
    assertNull(SkuActiveDateConsiderationContext.getSkuActiveDateConsiderationContext());
  }

  /**
   * Test
   * {@link SkuActiveDateConsiderationContext#setSkuActiveDateConsiderationContext(HashMap)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuActiveDateConsiderationContext#setSkuActiveDateConsiderationContext(HashMap)}
   */
  @Test
  public void testSetSkuActiveDateConsiderationContext_whenHashMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SkuActiveDateConsiderationContext.setSkuActiveDateConsiderationContext(new HashMap());
  }

  /**
   * Test {@link SkuActiveDateConsiderationContext#getSkuActiveDatesService()}.
   * <p>
   * Method under test:
   * {@link SkuActiveDateConsiderationContext#getSkuActiveDatesService()}
   */
  @Test
  public void testGetSkuActiveDatesService() {
    // Arrange, Act and Assert
    assertNull(SkuActiveDateConsiderationContext.getSkuActiveDatesService());
  }

  /**
   * Test
   * {@link SkuActiveDateConsiderationContext#setSkuActiveDatesService(DynamicSkuActiveDatesService)}.
   * <p>
   * Method under test:
   * {@link SkuActiveDateConsiderationContext#setSkuActiveDatesService(DynamicSkuActiveDatesService)}
   */
  @Test
  public void testSetSkuActiveDatesService() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SkuActiveDateConsiderationContext.setSkuActiveDatesService(mock(DynamicSkuActiveDatesService.class));
  }

  /**
   * Test {@link SkuActiveDateConsiderationContext#hasDynamicActiveDates()}.
   * <p>
   * Method under test:
   * {@link SkuActiveDateConsiderationContext#hasDynamicActiveDates()}
   */
  @Test
  public void testHasDynamicActiveDates() {
    // Arrange, Act and Assert
    assertFalse(SkuActiveDateConsiderationContext.hasDynamicActiveDates());
  }

  /**
   * Test new {@link SkuActiveDateConsiderationContext} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SkuActiveDateConsiderationContext}
   */
  @Test
  public void testNewSkuActiveDateConsiderationContext() {
    // Arrange and Act
    SkuActiveDateConsiderationContext actualSkuActiveDateConsiderationContext = new SkuActiveDateConsiderationContext();

    // Assert
    assertNull(actualSkuActiveDateConsiderationContext.considerations);
    assertNull(actualSkuActiveDateConsiderationContext.service);
  }
}
