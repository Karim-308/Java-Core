
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Exercise1 {

   public static void main(String[] args) {
      CountryDao countryDao = InMemoryWorldDao.getInstance();
      countryDao.findAllCountries().stream().forEach(country -> {
         Optional<City> MaxCityForCountry = country.getCities().stream()
               .max(Comparator.comparingInt(City::getPopulation));

         MaxCityForCountry.ifPresent(city -> System.out.println("In " + country.getName()
               + " The largest Populated City is : " + city.getName() + " with population " + city.getPopulation()));

      });

   }
}