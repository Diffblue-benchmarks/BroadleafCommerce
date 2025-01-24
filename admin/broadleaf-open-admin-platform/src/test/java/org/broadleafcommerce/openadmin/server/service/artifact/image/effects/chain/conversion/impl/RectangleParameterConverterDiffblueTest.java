package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.impl;

import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.ConversionException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RectangleParameterConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RectangleParameterConverterDiffblueTest {
  @Autowired
  private RectangleParameterConverter rectangleParameterConverter;

  /**
   * Test {@link RectangleParameterConverter#convert(String, Double, boolean)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RectangleParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvert_when42() throws ConversionException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.util.NoSuchElementException
    //       at java.base/java.util.StringTokenizer.nextToken(StringTokenizer.java:349)
    //       at org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.impl.RectangleParameterConverter.convert(RectangleParameterConverter.java:36)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    rectangleParameterConverter.convert("42", 10.0d, true);
  }

  /**
   * Test new {@link RectangleParameterConverter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link RectangleParameterConverter}
   */
  @Test
  public void testNewRectangleParameterConverter() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new RectangleParameterConverter();
  }
}
