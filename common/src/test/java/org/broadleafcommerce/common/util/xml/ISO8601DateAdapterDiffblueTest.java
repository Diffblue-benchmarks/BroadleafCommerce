package org.broadleafcommerce.common.util.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ISO8601DateAdapterDiffblueTest {
  /**
   * Test new {@link ISO8601DateAdapter} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ISO8601DateAdapter}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ISO8601DateAdapter.<init>()"})
  public void testNewISO8601DateAdapter() {
    // Arrange, Act and Assert
    SimpleDateFormat simpleDateFormat = new ISO8601DateAdapter().isoFormat;
    assertTrue(simpleDateFormat.getNumberFormat() instanceof DecimalFormat);
    assertTrue(simpleDateFormat.getCalendar() instanceof GregorianCalendar);
    assertEquals("yyyy-MM-dd'T'HH:mm:ss.SSSZ", simpleDateFormat.toPattern());
    assertTrue(simpleDateFormat.isLenient());
  }
}
