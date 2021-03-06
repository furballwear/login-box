package com.loginbox.app;

import com.loginbox.app.version.VersionBundle;
import com.loginbox.app.views.ViewBundle;
import com.loginbox.dropwizard.mybatis.MybatisBundle;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import org.junit.Test;

import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginBoxTest {
    private final Bootstrap<LoginBoxConfiguration> bootstrap = mock(Bootstrap.class);
    private final LoginBox application = new LoginBox();

    @Test
    public void configuresExpectedBundles() {
        /* This is a dumb test: it more or less reiterates the body of the methods under test. However, it's better than nothing, I hope... */
        application.initialize(bootstrap);

        verify(bootstrap).addBundle(isA(VersionBundle.class));
        verify(bootstrap).addBundle(isA(AssetsBundle.class));
        verify(bootstrap).addBundle(isA(ViewBundle.class));
        verify(bootstrap).addBundle(isA(MigrationsBundle.class));
        verify(bootstrap).addBundle(isA(MybatisBundle.class));
    }
}
