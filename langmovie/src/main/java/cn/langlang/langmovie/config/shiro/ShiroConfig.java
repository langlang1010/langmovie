package cn.langlang.langmovie.config.shiro;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class ShiroConfig {
    @Autowired
    private DataSource dataSource;

    @Bean("jdbcRealm")
    public JdbcRealm getJdbcRealm() {
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setAuthenticationQuery("select password from user where username = ?");
        return jdbcRealm;
    }
}
