package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafApplicationEventDiffblueTest {
  /**
   * Test {@link BroadleafApplicationEvent#getSiteId()}.
   *
   * <p>Method under test: {@link BroadleafApplicationEvent#getSiteId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long BroadleafApplicationEvent.getSiteId()"})
  public void testGetSiteId() {
    // Arrange, Act and Assert
    assertNull(new ReindexEvent(BLCFieldUtils.NULL_FIELD).getSiteId());
  }

  /**
   * Test {@link BroadleafApplicationEvent#getCatalogId()}.
   *
   * <p>Method under test: {@link BroadleafApplicationEvent#getCatalogId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long BroadleafApplicationEvent.getCatalogId()"})
  public void testGetCatalogId() {
    // Arrange, Act and Assert
    assertNull(new ReindexEvent(BLCFieldUtils.NULL_FIELD).getCatalogId());
  }

  /**
   * Test {@link BroadleafApplicationEvent#getProfileId()}.
   *
   * <p>Method under test: {@link BroadleafApplicationEvent#getProfileId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long BroadleafApplicationEvent.getProfileId()"})
  public void testGetProfileId() {
    // Arrange, Act and Assert
    assertNull(new ReindexEvent(BLCFieldUtils.NULL_FIELD).getProfileId());
  }

  /**
   * Test {@link BroadleafApplicationEvent#getLocaleCode()}.
   *
   * <p>Method under test: {@link BroadleafApplicationEvent#getLocaleCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BroadleafApplicationEvent.getLocaleCode()"})
  public void testGetLocaleCode() {
    // Arrange, Act and Assert
    assertNull(new ReindexEvent(BLCFieldUtils.NULL_FIELD).getLocaleCode());
  }

  /**
   * Test {@link BroadleafApplicationEvent#getCurrencyCode()}.
   *
   * <p>Method under test: {@link BroadleafApplicationEvent#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BroadleafApplicationEvent.getCurrencyCode()"})
  public void testGetCurrencyCode() {
    // Arrange, Act and Assert
    assertNull(new ReindexEvent(BLCFieldUtils.NULL_FIELD).getCurrencyCode());
  }

  /**
   * Test {@link BroadleafApplicationEvent#getTimeZoneId()}.
   *
   * <p>Method under test: {@link BroadleafApplicationEvent#getTimeZoneId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BroadleafApplicationEvent.getTimeZoneId()"})
  public void testGetTimeZoneId() {
    // Arrange, Act and Assert
    assertNull(new ReindexEvent(BLCFieldUtils.NULL_FIELD).getTimeZoneId());
  }
}
