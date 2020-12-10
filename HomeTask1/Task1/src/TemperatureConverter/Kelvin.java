package TemperatureConverter;

import Exceptions.CelsiusConvertationException;
import Exceptions.ConvertationException;
import Exceptions.KelvinConvertationException;

public class Kelvin extends TempratureDegree {

    public Kelvin() {
        this.initBorderValues(0.0f, Float.POSITIVE_INFINITY);
    }

    public Kelvin(float value) throws CelsiusConvertationException {
        this();
        setValue(value);
    }

    public Kelvin(TempratureDegree t)
    {
        this();
        setValue(t.getKelvin().getValue());
    }

    @Override
    public void setValue(float value) throws ConvertationException {
        checkBorderValues(value, new KelvinConvertationException("value should be in ["
                + String.valueOf(this.MinValue) + ".."
                + String.valueOf(this.MaxValue) + "] range"
        ));
        this.value = value;
    }

    @Override
    public float getValue() {
        return this.value;
    }

    @Override
    public Kelvin getKelvin() {
        return new Kelvin(this.value);
    }

    public static Kelvin convertFrom(TempratureDegree from) {
        return from.getKelvin();
    }
}
