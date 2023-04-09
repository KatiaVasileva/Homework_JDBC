package hibernate.dao;

import hibernate.model.City;

import java.util.List;

public interface CityDAO {

    void addCity(City city);

    void updateCity(City city);

    void deleteCity(City city);

    City getCityById(int id);

    List<City> getAllCities();

    void getEmployees(int id);
}
