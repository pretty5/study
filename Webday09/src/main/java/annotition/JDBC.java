package annotition;
//用于配置jdbc
public @interface JDBC {
    String name();
    String password();
    String url();
    String driver();
}
