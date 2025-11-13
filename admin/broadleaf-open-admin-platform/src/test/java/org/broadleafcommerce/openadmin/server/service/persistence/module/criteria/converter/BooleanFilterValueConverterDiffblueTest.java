package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BooleanFilterValueConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BooleanFilterValueConverterDiffblueTest {
  @Autowired private BooleanFilterValueConverter booleanFilterValueConverter;

  /**
   * Test {@link BooleanFilterValueConverter#convert(String)}.
   *
   * <p>Method under test: {@link BooleanFilterValueConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean BooleanFilterValueConverter.convert(String)"})
  public void testConvert() {
    // Arrange, Act and Assert
    assertFalse(booleanFilterValueConverter.convert("42"));
  }
}
