
import java.util.Objects;
import java.util.Optional;

import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;

import java.util.Comparator;

public class Exercise5 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();

        countryDao.findAllCountries().stream().map(country -> country.getCapital()).filter(id -> id != 0)
                .map(capitalID -> cityDao.findCityById(capitalID)).filter(Objects::nonNull)
                .max(Comparator.comparingInt(City::getPopulation))
                .ifPresent(capital -> System.out.println(" The Highest Populated Capital is " + capital));
    }

}