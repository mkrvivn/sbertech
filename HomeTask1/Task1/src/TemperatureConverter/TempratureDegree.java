package TemperatureConverter;

import Exceptions.ConvertationException;

public abstract class TempratureDegree {
    public float MinValue;
    public float MaxValue;
    protected float value;

    public abstract void setValue(float value) throws ConvertationException;

    public abstract float getValue();

    protected void initBorderValues(float min, float max)
    {
        this.MinValue = min;
        this.MaxValue = max;
    }

    protected void checkBorderValues(float value, ConvertationException e) throws ConvertationException
    {
        if(value < this.MinValue || value > this.MaxValue)
            throw e;
    }

    public abstract Kelvin getKelvin();

}
