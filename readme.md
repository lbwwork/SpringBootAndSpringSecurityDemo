   SpringBoot集成SpringSecurity
=====

# 引入pom.xml依赖

# 
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
#

# 入门使用
    写一个Controller，例：
        @Controller
        public class HelloController {
            @RequestMapping("hello")
            @ResponseBody
            public String hello(){
                return "Hello World";
            }
        }
    此时启动项目访问这个mapping,会自动跳转到login页面，注：此页面为SpringSecurity自带页面，无需自己写
    在没有做任何配置的情况下，用户名默认为user,密码会输出在控制台中,登陆后即会跳转出hello world

# 基础配置
    #security默认用户名
    spring.security.user.name
    #security默认密码，设置完此项后不会再自动生成密码到控制台
    spring.security.user.password
# 在内存中配置账户及权限
    具体配置查看config包下的SecurityConfig类
    
# 数据库中读取权限
    用户表
    CREATE TABLE `sys_user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    角色表
    CREATE TABLE `sys_role` (
    `id` int(11) NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    用户角色表
    CREATE TABLE `sys_user_role` (
    `user_id` int(11) NOT NULL,
    `role_id` int(11) NOT NULL,
    PRIMARY KEY (`user_id`,`role_id`),
    KEY `fk_role_id` (`role_id`),
    CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    初始化数据
    INSERT INTO `sys_role` VALUES ('1', 'ROLE_ADMIN');
    INSERT INTO `sys_role` VALUES ('2', 'ROLE_USER');
    INSERT INTO `sys_user` VALUES ('1', 'admin', '123');
    INSERT INTO `sys_user` VALUES ('2', 'jitwxs', '123');
    INSERT INTO `sys_user_role` VALUES ('1', '1');
    INSERT INTO `sys_user_role` VALUES ('2', '2');
    这里的角色权限格式为ROLE_XXX,是Spring Security规定的
    
# 代码
    @PreAuthorize 这个注解用来判断用户是否有指定权限，没有就不能访问
    SecurityContextHolder.getContext().getAuthentication()用来获取当前登录用户

# 注意
    如果使用thymeleaf需要将返回的html前加上../static/