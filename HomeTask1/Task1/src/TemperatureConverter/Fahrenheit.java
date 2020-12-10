package TemperatureConverter;

import Exceptions.CelsiusConvertationException;
import Exceptions.FahrenheitConvertationException;

public class Fahrenheit extends TempratureDegree {
    public Fahrenheit() {
        this.initBorderValues(-459.67f, Float.POSITIVE_INFINITY);
    }

    public Fahrenheit(float value) throws CelsiusConvertationException {
        this();
        setValue(value);
    }

    public Fahrenheit(TempratureDegree t)
    {
        this();
        setValue((t.getKelvin().getValue() - 273.15f) * (9.0f / 5.0f) + 32.0f);
    }

    @Override
    public void setValue(float value) throws FahrenheitConvertationException {
        checkBorderValues(value, new FahrenheitConvertationException("value should be in ["
                + String.valueOf(this.MinValue) + ".."
                + String.valueOf(this.MaxValue) + "] range"
        ));
        this.value = value;
    }

    @Override
    public float getValue() {
        return value;
    }

    @Override
    public Kelvin getKelvin() {
        return new Kelvin((this.value - 32) * (5 / 9.0f) + 273.15f);
    }

    static public Fahrenheit convertFrom(TempratureDegree from) {
        return new Fahrenheit(from);
    }
}
