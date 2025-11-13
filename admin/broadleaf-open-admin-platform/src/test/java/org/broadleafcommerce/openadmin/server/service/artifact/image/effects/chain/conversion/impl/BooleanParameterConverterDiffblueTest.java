package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.ConversionException;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.Parameter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BooleanParameterConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BooleanParameterConverterDiffblueTest {
  @Autowired private BooleanParameterConverter booleanParameterConverter;

  /**
   * Test {@link BooleanParameterConverter#convert(String, Double, boolean)}.
   *
   * <p>Method under test: {@link BooleanParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Parameter BooleanParameterConverter.convert(String, Double, boolean)"})
  public void testConvert() throws ConversionException {
    // Arrange and Act
    Parameter actualConvertResult = booleanParameterConverter.convert("42", 10.0d, true);

    // Assert
    assertEquals("boolean", actualConvertResult.getParameterClass().getName());
    assertFalse((Boolean) actualConvertResult.getParameterInstance());
  }
}
