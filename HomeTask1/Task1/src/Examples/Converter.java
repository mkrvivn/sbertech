package Examples;

import Exceptions.ConvertationException;
import TemperatureConverter.Celsius;
import TemperatureConverter.Fahrenheit;

public class Converter {
    static public void run()
    {
        try
        {
            Celsius c = new Celsius(34.5f);
            System.out.println("Celsious - " + c.getValue());
            Fahrenheit f = new Fahrenheit(c);
            System.out.println("Fahrenheit - " + f.getValue());
            c = new Celsius(f);
            System.out.println("Celsious back - " + c.getValue());
            c = new Celsius(-1000f);
        }catch (ConvertationException e)
        {
            System.out.println(e.getMessage());

        }

    }
}
