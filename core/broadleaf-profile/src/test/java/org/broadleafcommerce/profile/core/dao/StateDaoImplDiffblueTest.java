package org.broadleafcommerce.profile.core.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.State;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StateDaoImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @InjectMocks private StateDaoImpl stateDaoImpl;

  /**
   * Test {@link StateDaoImpl#create()}.
   *
   * <p>Method under test: {@link StateDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"State StateDaoImpl.create()"})
  public void testCreate() {
    // Arrange
    StateImpl stateImpl = new StateImpl();
    stateImpl.setAbbreviation("Abbreviation");
    stateImpl.setCountry(new CountryImpl());
    stateImpl.setName("Name");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(stateImpl);

    // Act
    State actualCreateResult = stateDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.profile.core.domain.State");
    assertSame(stateImpl, actualCreateResult);
  }
}
