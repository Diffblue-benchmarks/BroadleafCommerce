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

@ContextConfiguration(classes = {StringFilterValueConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StringFilterValueConverterDiffblueTest {
  @Autowired private StringFilterValueConverter stringFilterValueConverter;

  /**
   * Test {@link StringFilterValueConverter#convert(String)}.
   *
   * <p>Method under test: {@link StringFilterValueConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringFilterValueConverter.convert(String)"})
  public void testConvert() {
    // Arrange, Act and Assert
    assertEquals("42", stringFilterValueConverter.convert("42"));
  }
}
