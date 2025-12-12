
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Exercise2 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        countryDao.findAllCountries().stream().map(country -> country.getContinent()).distinct().forEach(continent -> {

            countryDao.findCountriesByContinent(continent).stream()
                    .flatMap(country -> country.getCities().stream())
                    .max(Comparator.comparingInt(City::getPopulation))
                    .ifPresent(city -> System.out.println("In " + continent + " The largest Populated City is "
                            + city.getName() + " with population " + city.getPopulation()));

        });
    }

}
