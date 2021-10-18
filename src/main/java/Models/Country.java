package Models;

public class Country {
    private int countryID, goldMedals, silverMedals, bronzeMedals, totalMedals, population;
    private String countryName;

    public Country(String country, int gold, int silver, int bronze, int total, int pop) {
        setCountryName(country);
        setGoldMedals(gold);
        setSilverMedals(silver);
        setBronzeMedals(bronze);
        setTotalMedals(total);
        setPopulation(pop);
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        if (countryID > 0)
            this.countryID = countryID;
        else
            throw new IllegalArgumentException("CountryID must be greater than 0");
    }

    public int getGoldMedals() {
        return goldMedals;
    }

    public void setGoldMedals(int goldMedals) {
        if(goldMedals >= 0)
            this.goldMedals = goldMedals;
        else
            throw new IllegalArgumentException("Gold Medals cannot be negative.");
    }

    public int getSilverMedals() {
        return silverMedals;
    }

    public void setSilverMedals(int silverMedals) {
        if(silverMedals >= 0)
            this.silverMedals = silverMedals;
        else
            throw new IllegalArgumentException("Silver Medals cannot be negative.");
    }

    public int getBronzeMedals() {
        return bronzeMedals;
    }

    public void setBronzeMedals(int bronzeMedals) {
        if(bronzeMedals >= 0)
            this.bronzeMedals = bronzeMedals;
        else
            throw new IllegalArgumentException("Bronze Medals cannot be negative.");
    }

    public int getTotalMedals() {
        return totalMedals;
    }

    public void setTotalMedals(int totalMedals) {
        if(totalMedals >= 0)
            this.totalMedals = totalMedals;
        else
            throw new IllegalArgumentException("Total Medals cannot be negative.");
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        if(population >= 500)
            this.population = population;
        else
            throw new IllegalArgumentException("Population must be at least 500.");
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        if (!countryName.isBlank())
            this.countryName = countryName;
        else
            throw new IllegalArgumentException("Country can not be blank.");
    }

    public String toString()
    {
        return String.format("Country %d: %s, with a population of %d, has won %d gold medals, %d silver medals, %d bronze medals, and %d total medals.",
                countryID, countryName, population, goldMedals, silverMedals, bronzeMedals, totalMedals);
    }
}