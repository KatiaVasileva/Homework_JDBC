package jdbc.dao;

import jdbc.model.City;

import java.util.List;

public interface CityDAO {

    public void addCity(City city);

    public void updateCity(City city);

    public void deleteCity(City city);

    public City getCityById(int id);

    public List<City> grtAllCities();
}
