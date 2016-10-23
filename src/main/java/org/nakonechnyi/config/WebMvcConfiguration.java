package org.nakonechnyi.config;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

//@Configuration
//@EnableWebMvc
//@ComponentScan
    @Deprecated
public class WebMvcConfiguration /*extends WebMvcConfigurerAdapter*/ {

  /*  @Value(value = "${view.catalog-path}")
    private static String CATALOG_PATH;*/
  private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
          "classpath:/META-INF/resources/", "classpath:/resources/",
          "classpath:/static/", "classpath:/public/" };

    public WebMvcConfiguration() {
        super();
    }


//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
//
//        registry.addViewController("/").setViewName("index.html");
//        //registry.addViewController("/landing").setViewName("landing");
//        registry.addViewController("/login").setViewName("index");
//        registry.addViewController("/registration").setViewName("index");
//
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }
//
//    @Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
//
////        registry.addResourceHandler("/files/**")
////                .addResourceLocations("file:" + CATALOG_IMAGE_PATH)
////                .setCachePeriod(31556926);
//    }

}
