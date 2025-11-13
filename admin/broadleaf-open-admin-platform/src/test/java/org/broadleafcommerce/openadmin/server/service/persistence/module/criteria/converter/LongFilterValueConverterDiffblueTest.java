package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {LongFilterValueConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LongFilterValueConverterDiffblueTest {
  @Autowired private LongFilterValueConverter longFilterValueConverter;

  /**
   * Test {@link LongFilterValueConverter#convert(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link LongFilterValueConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long LongFilterValueConverter.convert(String)"})
  public void testConvert_when42_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, longFilterValueConverter.convert("42").longValue());
  }
}
