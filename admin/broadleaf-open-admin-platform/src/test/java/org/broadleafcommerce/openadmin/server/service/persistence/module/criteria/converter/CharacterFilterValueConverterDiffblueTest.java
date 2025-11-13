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

@ContextConfiguration(classes = {CharacterFilterValueConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CharacterFilterValueConverterDiffblueTest {
  @Autowired private CharacterFilterValueConverter characterFilterValueConverter;

  /**
   * Test {@link CharacterFilterValueConverter#convert(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return charValue is {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link CharacterFilterValueConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Character CharacterFilterValueConverter.convert(String)"})
  public void testConvert_when42_thenReturnCharValueIs4() {
    // Arrange, Act and Assert
    assertEquals('4', characterFilterValueConverter.convert("42").charValue());
  }

  /**
   * Test {@link CharacterFilterValueConverter#convert(String)}.
   *
   * <ul>
   *   <li>When {@link Boolean#FALSE} toString.
   *   <li>Then return charValue is {@code N}.
   * </ul>
   *
   * <p>Method under test: {@link CharacterFilterValueConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Character CharacterFilterValueConverter.convert(String)"})
  public void testConvert_whenFalseToString_thenReturnCharValueIsN() {
    // Arrange, Act and Assert
    assertEquals('N', characterFilterValueConverter.convert(Boolean.FALSE.toString()).charValue());
  }

  /**
   * Test {@link CharacterFilterValueConverter#convert(String)}.
   *
   * <ul>
   *   <li>When {@link Boolean#TRUE} toString.
   *   <li>Then return charValue is {@code Y}.
   * </ul>
   *
   * <p>Method under test: {@link CharacterFilterValueConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Character CharacterFilterValueConverter.convert(String)"})
  public void testConvert_whenTrueToString_thenReturnCharValueIsY() {
    // Arrange, Act and Assert
    assertEquals('Y', characterFilterValueConverter.convert(Boolean.TRUE.toString()).charValue());
  }
}
