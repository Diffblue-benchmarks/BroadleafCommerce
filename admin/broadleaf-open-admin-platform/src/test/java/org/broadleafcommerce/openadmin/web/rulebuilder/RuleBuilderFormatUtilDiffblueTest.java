package org.broadleafcommerce.openadmin.web.rulebuilder;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;

public class RuleBuilderFormatUtilDiffblueTest {
  /**
   * Test {@link RuleBuilderFormatUtil#formatDate(Date)}.
   * <p>
   * Method under test: {@link RuleBuilderFormatUtil#formatDate(Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFormatDate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at java.base/java.util.GregorianCalendar.computeFields(GregorianCalendar.java:2339)
    //       at java.base/java.util.GregorianCalendar.computeFields(GregorianCalendar.java:2309)
    //       at java.base/java.util.Calendar.setTimeInMillis(Calendar.java:1834)
    //       at java.base/java.util.Calendar.setTime(Calendar.java:1800)
    //       at java.base/java.text.SimpleDateFormat.format(SimpleDateFormat.java:974)
    //       at java.base/java.text.SimpleDateFormat.format(SimpleDateFormat.java:967)
    //       at java.base/java.text.DateFormat.format(DateFormat.java:374)
    //       at org.broadleafcommerce.openadmin.web.rulebuilder.RuleBuilderFormatUtil.formatDate(RuleBuilderFormatUtil.java:46)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    RuleBuilderFormatUtil
        .formatDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link RuleBuilderFormatUtil#parseDate(String)}.
   * <p>
   * Method under test: {@link RuleBuilderFormatUtil#parseDate(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testParseDate() throws ParseException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.text.ParseException: Unparseable date: "2020-03-01"
    //       at java.base/java.text.DateFormat.parse(DateFormat.java:395)
    //       at org.broadleafcommerce.openadmin.web.rulebuilder.RuleBuilderFormatUtil.parseDate(RuleBuilderFormatUtil.java:58)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    RuleBuilderFormatUtil.parseDate("2020-03-01");
  }
}
