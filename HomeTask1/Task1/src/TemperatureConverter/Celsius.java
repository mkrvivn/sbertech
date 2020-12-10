package TemperatureConverter;

import Exceptions.CelsiusConvertationException;

public class Celsius extends TempratureDegree {

    public Celsius() {
        this.initBorderValues(-273.15f, Float.POSITIVE_INFINITY);
    }

    public Celsius(float value) throws CelsiusConvertationException {
        this();
        setValue(value);
    }

    public Celsius(TempratureDegree t)
    {
        this();
        setValue(t.getKelvin().getValue() - 273.15f);
    }

    @Override
    public void setValue(float value) throws CelsiusConvertationException {
        checkBorderValues(value, new CelsiusConvertationException("value should be in ["
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
        return new Kelvin(this.value + 273.15f);
    }

    static public Celsius convertFrom(TempratureDegree from) {
        return new Celsius(from);
    }
}
