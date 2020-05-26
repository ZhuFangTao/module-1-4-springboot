### 1.添加博客文章类，并使用jpa注解实现orm

```java
@Entity(name = "t_article")
public class BlogArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @Column(name="created")
    private Date createdDate;

    @Column(name="modified")
    private Date modifiedDate;

    private String categories;

    private String tags;

    @Column(name="allow_comment")
    private int allowComment;

    private String thumbnail;
}
```



### 2.配置Thymeleaf 解析路径

```properties
#不开启页面缓存
spring.thymeleaf.cache=false
spring.jpa.show-sql=true

#数据库配置
spring.datasource.url=jdbc:mysql://localhost:3306/blog_system?serverTimezone=UTC
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root


#thymeleaf
spring.thymeleaf.prefix=classpath:/templates
spring.thymeleaf.encoding=UTF-8
spring.thymeleaf.suffix=.html
```



### 3.新建博客contrller

```java
@Controller
public class BlogController {

    @Autowired
    private ArticleMapper articleMapper;

    @RequestMapping("/index")
    public String toLoginPage(Model model, HttpServletRequest request){
        int pageNum;
        int pageSize;
        try{
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        }catch (Exception e){
            pageNum = 0;
            pageSize = 3;
        }
        List<BlogArticle> articleList = articleMapper
          .findAll(PageRequest.of(pageNum,pageSize, Sort.by("id"))).getContent();
        model.addAttribute("articleList",articleList);
        return "/client/index";
    }

}
```



### 4.使用jpa分页查询数据，并将结果保存到model中，供Thymeleaf解析

```java
List<BlogArticle> articleList = articleMapper
          .findAll(PageRequest.of(pageNum,pageSize, Sort.by("id")))
  				.getContent();
model.addAttribute("articleList",articleList);
```





### 5.修改html模版中解析逻辑。并添加分页查询逻辑

```html
div class="am-g am-g-fixed blog-fixed index-page">
    <div class="am-u-md-8 am-u-sm-12">
        <!-- 文章遍历并分页展示 : 需要同学们手动完成，基本样式已经给出，请使用th标签及表达式完成页面展示 -->
        <div th:each="article:${articleList}">
            <article class="am-g blog-entry-article">

                <div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
                    <!-- 文章分类 -->
                    <span class="blog-color"style="font-size: 15px;"><a>默认分类</a></span>
                    <span>&nbsp;&nbsp;&nbsp;</span>
                    <!-- 发布时间 -->
                    <span style="font-size: 15px;" th:text="'发布于 '+ ${article.createdDate}" />
                    <h2>
                        <!-- 文章标题 -->
                        <div><a style="color: #0f9ae0;font-size: 20px;" th:text="${article.title}" />
                        </div>
                    </h2>
                    <!-- 文章内容-->
                    <div style="font-size: 16px;" th:text="${article.content}" />
                </div>
            </article>
        </div>
        <a th:href="@{?pageNum=0&pageSize=3}">首页</a>
        <a th:href="@{?pageNum=0&pageSize=3}">上一页</a>
        <a th:href="@{?pageNum=1&pageSize=3}">下一页</a>
    </div>
```

