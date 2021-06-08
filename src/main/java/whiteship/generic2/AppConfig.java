package whiteship.generic2;

//@Configuration
public class AppConfig {
//    @Bean
    public GenericDao<Apple, Integer> appleDao(){
      return new GenericDao<>();
    }
//    @Bean
    public GenericDao<Banana, Integer> bananaDao(){
        return new GenericDao<>();
    }
}
