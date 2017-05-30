package org.example;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class DummyProxyDataSource
    implements DataSource
{
    private final DataSource delegate;

    public DummyProxyDataSource(DataSource delegate)
    {
        if (null == delegate)
        {
            throw new NullPointerException("Cannot have null delegate");
        }
        this.delegate = delegate;
    }

    @Override
    public PrintWriter getLogWriter()
        throws SQLException
    {
        return delegate.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out)
        throws SQLException
    {
        delegate.setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds)
        throws SQLException
    {
        delegate.setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout()
        throws SQLException
    {
        return delegate.getLoginTimeout();
    }

    @Override
    public Logger getParentLogger()
        throws SQLFeatureNotSupportedException
    {
        return delegate.getParentLogger();
    }

    @Override
    public <T> T unwrap(Class<T> iface)
        throws SQLException
    {
        return delegate.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface)
        throws SQLException
    {
        return delegate.isWrapperFor(iface);
    }

    @Override
    public Connection getConnection()
        throws SQLException
    {
        return delegate.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password)
        throws SQLException
    {
        return delegate.getConnection(username, password);
    }
}
